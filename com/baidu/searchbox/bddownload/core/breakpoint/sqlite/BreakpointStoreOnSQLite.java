package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStoreOnCache;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BreakpointStoreOnSQLite implements DownloadStore {
    public static final String TAG = "BreakpointStoreOnSQLite";
    public final BreakpointSQLiteHelper helper;
    public final BreakpointStoreOnCache onCache;

    public BreakpointStoreOnSQLite(BreakpointSQLiteHelper breakpointSQLiteHelper, BreakpointStoreOnCache breakpointStoreOnCache) {
        this.helper = breakpointSQLiteHelper;
        this.onCache = breakpointStoreOnCache;
    }

    public void close() {
        this.helper.close();
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) throws IOException {
        BreakpointInfo createAndInsert = this.onCache.createAndInsert(downloadTask);
        this.helper.insert(createAndInsert);
        return createAndInsert;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        return this.onCache.findAnotherInfoFromCompare(downloadTask, breakpointInfo);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(@NonNull DownloadTask downloadTask) {
        return this.onCache.findOrCreateId(downloadTask);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo get(int i2) {
        return this.onCache.get(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i2) {
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        return this.onCache.getResponseFilename(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i2) {
        return this.onCache.isFileDirty(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i2) {
        if (this.onCache.markFileClear(i2)) {
            this.helper.markFileClear(i2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i2) {
        if (this.onCache.markFileDirty(i2)) {
            this.helper.markFileDirty(i2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i2, long j) throws IOException {
        this.onCache.onSyncToFilesystemSuccess(breakpointInfo, i2, j);
        this.helper.updateBlockIncrease(breakpointInfo, i2, breakpointInfo.getBlock(i2).getCurrentOffset());
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i2, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.onCache.onTaskEnd(i2, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.helper.removeInfo(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i2) {
        this.onCache.onTaskStart(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i2) {
        this.onCache.remove(i2);
        this.helper.removeInfo(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        boolean update = this.onCache.update(breakpointInfo);
        this.helper.updateInfo(breakpointInfo);
        String filename = breakpointInfo.getFilename();
        Util.d(TAG, "update " + breakpointInfo);
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.helper.updateFilename(breakpointInfo.getUrl(), filename);
        }
        return update;
    }

    public BreakpointStoreOnSQLite(Context context) {
        BreakpointSQLiteHelper breakpointSQLiteHelper = new BreakpointSQLiteHelper(context.getApplicationContext());
        this.helper = breakpointSQLiteHelper;
        this.onCache = new BreakpointStoreOnCache(breakpointSQLiteHelper.loadToCache(), this.helper.loadDirtyFileList(), this.helper.loadResponseFilenameToMap());
    }
}
