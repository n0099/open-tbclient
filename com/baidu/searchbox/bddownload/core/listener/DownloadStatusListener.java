package com.baidu.searchbox.bddownload.core.listener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
/* loaded from: classes2.dex */
public abstract class DownloadStatusListener extends DownloadTaskProgressListener {

    /* renamed from: com.baidu.searchbox.bddownload.core.listener.DownloadStatusListener$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause;

        static {
            int[] iArr = new int[EndCause.values().length];
            $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause = iArr;
            try {
                iArr[EndCause.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.PRE_ALLOCATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.FILE_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[EndCause.SAME_TASK_BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public abstract void canceled(@NonNull DownloadTask downloadTask);

    public abstract void completed(@NonNull DownloadTask downloadTask);

    public abstract void error(@NonNull DownloadTask downloadTask, @NonNull Exception exc);

    public abstract void started(@NonNull DownloadTask downloadTask);

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
    public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$bddownload$core$cause$EndCause[endCause.ordinal()]) {
            case 1:
                completed(downloadTask);
                return;
            case 2:
                canceled(downloadTask);
                return;
            case 3:
            case 4:
                error(downloadTask, exc);
                return;
            case 5:
            case 6:
                warn(downloadTask);
                return;
            default:
                Util.w("DownloadStatusListener", "Don't support " + endCause);
                return;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
    public final void taskStart(@NonNull DownloadTask downloadTask, @NonNull TaskProgressListenerAssist.Listener1Model listener1Model) {
        started(downloadTask);
    }

    public abstract void warn(@NonNull DownloadTask downloadTask);
}
