package com.baidu.searchbox.bddownload.core.file;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class ProcessFileStrategy {
    public final FileLock fileLock = new FileLock();

    public void completeProcessStream(@NonNull MultiPointOutputStream multiPointOutputStream, @NonNull DownloadTask downloadTask) {
    }

    @NonNull
    public FileLock getFileLock() {
        return this.fileLock;
    }

    @NonNull
    public MultiPointOutputStream createProcessStream(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull DownloadStore downloadStore) {
        return new MultiPointOutputStream(downloadTask, breakpointInfo, downloadStore);
    }

    public void discardProcess(@NonNull DownloadTask downloadTask) throws IOException {
        File file = downloadTask.getFile();
        if (file != null && file.exists() && !file.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public boolean isPreAllocateLength(@NonNull DownloadTask downloadTask) {
        if (!BdDownload.with().outputStreamFactory().supportSeek()) {
            return false;
        }
        if (downloadTask.getSetPreAllocateLength() != null) {
            return downloadTask.getSetPreAllocateLength().booleanValue();
        }
        return true;
    }
}
