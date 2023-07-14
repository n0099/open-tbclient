package com.baidu.searchbox.live.model.net;

import android.os.Handler;
import com.baidu.searchbox.live.interfaces.net.DownLoadCallback;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MixNetwork$download$1 implements Runnable {
    public final /* synthetic */ MixNetDownloadCallback $callback;
    public final /* synthetic */ Object $key;
    public final /* synthetic */ String $localPath;
    public final /* synthetic */ MixNetwork this$0;

    public MixNetwork$download$1(MixNetwork mixNetwork, Object obj, String str, MixNetDownloadCallback mixNetDownloadCallback) {
        this.this$0 = mixNetwork;
        this.$key = obj;
        this.$localPath = str;
        this.$callback = mixNetDownloadCallback;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/baidu/searchbox/live/model/net/MixNetwork$download$1$1", "Lcom/baidu/searchbox/live/interfaces/net/DownLoadCallback;", "", "key", "", "statusCode", StatConstants.KEY_EXT_ERR_CODE, "", "exception", "", "onFileDownloaded", "(Ljava/lang/Object;IILjava/lang/String;)V", "", "downloadLength", "totalLength", "onFileUpdateProgress", "(Ljava/lang/Object;JJ)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.searchbox.live.model.net.MixNetwork$download$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 implements DownLoadCallback {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public AnonymousClass1() {
        }

        @Override // com.baidu.searchbox.live.interfaces.net.DownLoadCallback
        public void onFileDownloaded(final Object obj, final int i, final int i2, final String str) {
            Handler handler;
            handler = MixNetwork$download$1.this.this$0.getHandler();
            handler.post(new Runnable() { // from class: com.baidu.searchbox.live.model.net.MixNetwork$download$1$1$onFileDownloaded$1
                @Override // java.lang.Runnable
                public final void run() {
                    MixNetDownloadCallback mixNetDownloadCallback = MixNetwork$download$1.this.$callback;
                    if (mixNetDownloadCallback != null) {
                        mixNetDownloadCallback.onFileDownloaded(obj, i, i2, str);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.live.interfaces.net.DownLoadCallback
        public void onFileUpdateProgress(final Object obj, final long j, final long j2) {
            Handler handler;
            handler = MixNetwork$download$1.this.this$0.getHandler();
            handler.post(new Runnable() { // from class: com.baidu.searchbox.live.model.net.MixNetwork$download$1$1$onFileUpdateProgress$1
                @Override // java.lang.Runnable
                public final void run() {
                    MixNetDownloadCallback mixNetDownloadCallback = MixNetwork$download$1.this.$callback;
                    if (mixNetDownloadCallback != null) {
                        mixNetDownloadCallback.onFileUpdateProgress(obj, j, j2);
                    }
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        INetWork iNetWork;
        iNetWork = this.this$0.netImpl;
        if (iNetWork == null) {
            Intrinsics.throwNpe();
        }
        iNetWork.download(this.$key, this.$localPath, new AnonymousClass1());
    }
}
