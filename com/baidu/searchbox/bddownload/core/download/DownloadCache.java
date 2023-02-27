package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.exception.FileBusyAfterRunException;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.PreAllocateException;
import com.baidu.searchbox.bddownload.core.exception.ResumeFailedException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes2.dex */
public class DownloadCache {
    public volatile boolean fileBusyAfterRun;
    public final MultiPointOutputStream outputStream;
    public volatile boolean preAllocateFailed;
    public volatile boolean preconditionFailed;
    public volatile IOException realCause;
    public String redirectLocation;
    public volatile boolean serverCanceled;
    public volatile boolean unknownError;
    public volatile boolean userCanceled;

    /* loaded from: classes2.dex */
    public static class PreError extends DownloadCache {
        public PreError(IOException iOException) {
            super(null);
            setUnknownError(iOException);
        }
    }

    public DownloadCache() {
        this.outputStream = null;
    }

    @NonNull
    public MultiPointOutputStream getOutputStream() {
        MultiPointOutputStream multiPointOutputStream = this.outputStream;
        if (multiPointOutputStream != null) {
            return multiPointOutputStream;
        }
        throw new IllegalArgumentException();
    }

    public IOException getRealCause() {
        return this.realCause;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public ResumeFailedCause getResumeFailedCause() {
        return ((ResumeFailedException) this.realCause).getResumeFailedCause();
    }

    public boolean isFileBusyAfterRun() {
        return this.fileBusyAfterRun;
    }

    public boolean isInterrupt() {
        if (!this.preconditionFailed && !this.userCanceled && !this.serverCanceled && !this.unknownError && !this.fileBusyAfterRun && !this.preAllocateFailed) {
            return false;
        }
        return true;
    }

    public boolean isPreAllocateFailed() {
        return this.preAllocateFailed;
    }

    public boolean isPreconditionFailed() {
        return this.preconditionFailed;
    }

    public boolean isServerCanceled() {
        return this.serverCanceled;
    }

    public boolean isUnknownError() {
        return this.unknownError;
    }

    public boolean isUserCanceled() {
        return this.userCanceled;
    }

    public void setFileBusyAfterRun() {
        this.fileBusyAfterRun = true;
    }

    public void setUserCanceled() {
        this.userCanceled = true;
    }

    public DownloadCache(@NonNull MultiPointOutputStream multiPointOutputStream) {
        this.outputStream = multiPointOutputStream;
    }

    public void setPreAllocateFailed(IOException iOException) {
        this.preAllocateFailed = true;
        this.realCause = iOException;
    }

    public void setPreconditionFailed(IOException iOException) {
        this.preconditionFailed = true;
        this.realCause = iOException;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setServerCanceled(IOException iOException) {
        this.serverCanceled = true;
        this.realCause = iOException;
    }

    public void setUnknownError(IOException iOException) {
        this.unknownError = true;
        this.realCause = iOException;
    }

    public void catchException(IOException iOException) {
        if (isUserCanceled()) {
            return;
        }
        if (iOException instanceof ResumeFailedException) {
            setPreconditionFailed(iOException);
        } else if (iOException instanceof ServerCanceledException) {
            setServerCanceled(iOException);
        } else if (iOException == FileBusyAfterRunException.SIGNAL) {
            setFileBusyAfterRun();
        } else if (iOException instanceof PreAllocateException) {
            setPreAllocateFailed(iOException);
        } else if (iOException != InterruptException.SIGNAL) {
            setUnknownError(iOException);
            if (!(iOException instanceof SocketException)) {
                Util.d("DownloadCache", "catch unknown error " + iOException);
            }
        }
    }
}
