package com.baidu.searchbox.bddownload.core.breakpoint.sqllite;

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
    public BreakpointInfo get(int i) {
        return this.onCache.get(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i) {
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        return this.onCache.getResponseFilename(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        return this.onCache.isFileDirty(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        if (this.onCache.markFileClear(i)) {
            this.helper.markFileClear(i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        if (this.onCache.markFileDirty(i)) {
            this.helper.markFileDirty(i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        this.onCache.onSyncToFilesystemSuccess(breakpointInfo, i, j);
        this.helper.updateBlockIncrease(breakpointInfo, i, breakpointInfo.getBlock(i).getCurrentOffset());
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, @NonNull EndCause endCause, @Nullable Exception exc) {
        this.onCache.onTaskEnd(i, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.helper.removeInfo(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        this.onCache.onTaskStart(i);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i) {
        this.onCache.remove(i);
        this.helper.removeInfo(i);
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
