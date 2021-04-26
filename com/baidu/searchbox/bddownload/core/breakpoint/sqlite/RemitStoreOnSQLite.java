package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor;
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

    public static void setRemitToDBDelayMillis(int i2) {
        BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
        if (breakpointStore instanceof RemitStoreOnSQLite) {
            ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i2);
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
    public BreakpointInfo get(int i2) {
        return this.onSQLiteWrapper.get(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i2) {
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        return this.onSQLiteWrapper.getResponseFilename(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i2) {
        return this.onSQLiteWrapper.isFileDirty(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i2) {
        return this.onSQLiteWrapper.markFileClear(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i2) {
        return this.onSQLiteWrapper.markFileDirty(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i2, long j) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i2, j);
        } else {
            this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i2, j);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i2, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.sqliteCache.onTaskEnd(i2, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.remitHelper.discard(i2);
        } else {
            this.remitHelper.endAndEnsureToDB(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i2) {
        this.onSQLiteWrapper.onTaskStart(i2);
        this.remitHelper.onTaskStart(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i2) {
        this.sqliteCache.remove(i2);
        this.remitHelper.discard(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i2) {
        this.sqLiteHelper.removeInfo(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
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

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i2) throws IOException {
        this.sqLiteHelper.removeInfo(i2);
        BreakpointInfo breakpointInfo = this.sqliteCache.get(i2);
        if (breakpointInfo == null || breakpointInfo.getFilename() == null || breakpointInfo.getTotalOffset() <= 0) {
            return;
        }
        this.sqLiteHelper.insert(breakpointInfo);
    }
}
