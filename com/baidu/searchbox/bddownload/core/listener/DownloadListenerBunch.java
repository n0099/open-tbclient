package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DownloadListenerBunch implements DownloadListener {
    @NonNull
    public final DownloadListener[] listenerList;

    /* loaded from: classes2.dex */
    public static class Builder {
        public List<DownloadListener> listenerList = new ArrayList();

        public Builder append(@Nullable DownloadListener downloadListener) {
            if (downloadListener != null && !this.listenerList.contains(downloadListener)) {
                this.listenerList.add(downloadListener);
            }
            return this;
        }

        public DownloadListenerBunch build() {
            List<DownloadListener> list = this.listenerList;
            return new DownloadListenerBunch((DownloadListener[]) list.toArray(new DownloadListener[list.size()]));
        }

        public boolean remove(DownloadListener downloadListener) {
            return this.listenerList.remove(downloadListener);
        }
    }

    public DownloadListenerBunch(@NonNull DownloadListener[] downloadListenerArr) {
        this.listenerList = downloadListenerArr;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectEnd(@NonNull DownloadTask downloadTask, int i2, int i3, @NonNull Map<String, List<String>> map) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.connectEnd(downloadTask, i2, i3, map);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectStart(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.connectStart(downloadTask, i2, map);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialEnd(@NonNull DownloadTask downloadTask, int i2, @NonNull Map<String, List<String>> map) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.connectTrialEnd(downloadTask, i2, map);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void connectTrialStart(@NonNull DownloadTask downloadTask, @NonNull Map<String, List<String>> map) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.connectTrialStart(downloadTask, map);
        }
    }

    public boolean contain(DownloadListener downloadListener) {
        for (DownloadListener downloadListener2 : this.listenerList) {
            if (downloadListener2 == downloadListener) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBeginning(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, @NonNull ResumeFailedCause resumeFailedCause) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.downloadFromBeginning(downloadTask, breakpointInfo, resumeFailedCause);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void downloadFromBreakpoint(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.downloadFromBreakpoint(downloadTask, breakpointInfo);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchEnd(@NonNull DownloadTask downloadTask, int i2, long j) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.fetchEnd(downloadTask, i2, j);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchProgress(@NonNull DownloadTask downloadTask, int i2, long j) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.fetchProgress(downloadTask, i2, j);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void fetchStart(@NonNull DownloadTask downloadTask, int i2, long j) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.fetchStart(downloadTask, i2, j);
        }
    }

    public int indexOf(DownloadListener downloadListener) {
        int i2 = 0;
        while (true) {
            DownloadListener[] downloadListenerArr = this.listenerList;
            if (i2 >= downloadListenerArr.length) {
                return -1;
            }
            if (downloadListenerArr[i2] == downloadListener) {
                return i2;
            }
            i2++;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.taskEnd(downloadTask, endCause, exc);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
    public void taskStart(@NonNull DownloadTask downloadTask) {
        for (DownloadListener downloadListener : this.listenerList) {
            downloadListener.taskStart(downloadTask);
        }
    }
}
