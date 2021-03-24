package com.baidu.searchbox.bddownload.core.breakpoint.sqllite;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.RemitSyncExecutor;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    @NonNull
    public final BreakpointStoreOnSQLite onSQLiteWrapper;
    @NonNull
    public final RemitSyncToDBHelper remitHelper;
    @NonNull
    public final BreakpointSQLiteHelper sqLiteHelper;
    @NonNull
    public final DownloadStore sqliteCache;

    public RemitStoreOnSQLite(@NonNull BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = breakpointStoreOnSQLite.onCache;
        this.sqLiteHelper = breakpointStoreOnSQLite.helper;
    }

    public static void setRemitToDBDelayMillis(int i) {
        BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
        if (breakpointStore instanceof RemitStoreOnSQLite) {
            ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i);
            return;
        }
        throw new IllegalStateException("The current store is " + breakpointStore + " not RemitStoreOnSQLite!");
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(downloadTask.getId())) {
            return this.sqliteCache.createAndInsert(downloadTask);
        }
        return this.onSQLiteWrapper.createAndInsert(downloadTask);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        return this.onSQLiteWrapper.findAnotherInfoFromCompare(downloadTask, breakpointInfo);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(@NonNull DownloadTask downloadTask) {
        return this.onSQLiteWrapper.findOrCreateId(downloadTask);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo get(int i) {
        return this.onSQLiteWrapper.get(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i) {
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        return this.onSQLiteWrapper.getResponseFilename(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        return this.onSQLiteWrapper.isFileDirty(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        return this.onSQLiteWrapper.markFileClear(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        return this.onSQLiteWrapper.markFileDirty(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i, j);
        } else {
            this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i, j);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.sqliteCache.onTaskEnd(i, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.remitHelper.discard(i);
        } else {
            this.remitHelper.endAndEnsureToDB(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        this.onSQLiteWrapper.onTaskStart(i);
        this.remitHelper.onTaskStart(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i) {
        this.sqliteCache.remove(i);
        this.remitHelper.discard(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqllite.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i) {
        this.sqLiteHelper.removeInfo(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqllite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List<Integer> list) throws IOException {
        SQLiteDatabase writableDatabase = this.sqLiteHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (Integer num : list) {
                syncCacheToDB(num.intValue());
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            return this.sqliteCache.update(breakpointInfo);
        }
        return this.onSQLiteWrapper.update(breakpointInfo);
    }

    public RemitStoreOnSQLite(@NonNull RemitSyncToDBHelper remitSyncToDBHelper, @NonNull BreakpointStoreOnSQLite breakpointStoreOnSQLite, @NonNull DownloadStore downloadStore, @NonNull BreakpointSQLiteHelper breakpointSQLiteHelper) {
        this.remitHelper = remitSyncToDBHelper;
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = downloadStore;
        this.sqLiteHelper = breakpointSQLiteHelper;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqllite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i) throws IOException {
        this.sqLiteHelper.removeInfo(i);
        BreakpointInfo breakpointInfo = this.sqliteCache.get(i);
        if (breakpointInfo == null || breakpointInfo.getFilename() == null || breakpointInfo.getTotalOffset() <= 0) {
            return;
        }
        this.sqLiteHelper.insert(breakpointInfo);
    }
}
