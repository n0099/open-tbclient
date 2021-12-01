package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
/* loaded from: classes9.dex */
public interface DownloadStore extends BreakpointStore {
    @Nullable
    BreakpointInfo getAfterCompleted(int i2);

    boolean markFileClear(int i2);

    boolean markFileDirty(int i2);

    void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i2, long j2) throws IOException;

    void onTaskEnd(int i2, @NonNull EndCause endCause, @Nullable Exception exc);

    void onTaskStart(int i2);
}
