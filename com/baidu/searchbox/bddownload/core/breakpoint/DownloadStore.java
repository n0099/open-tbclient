package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
/* loaded from: classes3.dex */
public interface DownloadStore extends BreakpointStore {
    @Nullable
    BreakpointInfo getAfterCompleted(int i);

    boolean markFileClear(int i);

    boolean markFileDirty(int i);

    void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i, long j) throws IOException;

    void onTaskEnd(int i, @NonNull EndCause endCause, @Nullable Exception exc);

    void onTaskStart(int i);
}
