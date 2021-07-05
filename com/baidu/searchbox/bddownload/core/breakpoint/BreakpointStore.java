package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface BreakpointStore {
    @NonNull
    BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) throws IOException;

    @Nullable
    BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo);

    int findOrCreateId(@NonNull DownloadTask downloadTask);

    @Nullable
    BreakpointInfo get(int i2);

    @Nullable
    String getResponseFilename(String str);

    boolean isFileDirty(int i2);

    boolean isOnlyMemoryCache();

    void remove(int i2);

    boolean update(@NonNull BreakpointInfo breakpointInfo) throws IOException;
}
