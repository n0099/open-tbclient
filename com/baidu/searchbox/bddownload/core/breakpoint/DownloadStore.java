package com.baidu.searchbox.bddownload.core.breakpoint;

import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface DownloadStore extends BreakpointStore {
    BreakpointInfo getAfterCompleted(int i);

    boolean markFileClear(int i);

    boolean markFileDirty(int i);

    void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i, long j) throws IOException;

    void onTaskEnd(int i, EndCause endCause, Exception exc);

    void onTaskStart(int i);
}
