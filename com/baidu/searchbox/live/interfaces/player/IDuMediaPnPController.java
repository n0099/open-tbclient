package com.baidu.searchbox.live.interfaces.player;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0018H&¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u000bH&¢\u0006\u0004\b\u001e\u0010\r¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController;", "Lkotlin/Any;", "", "getCurrentTime", "()J", "getDuration", "", "url", "", "getUrlPlayStatus", "(Ljava/lang/String;)I", "", DownloadStatisticConstants.UBC_TYPE_PAUSE, "()V", "play", "pos", "seek", "(J)V", "setAVTransportUrl", "(Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController$CtrlPointListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController$CtrlPointListener;)V", "", "mute", "setMute", "(Z)V", "continuePlay", "shutdown", "stop", "CtrlPointListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IDuMediaPnPController {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/IDuMediaPnPController$CtrlPointListener;", "Lkotlin/Any;", "", GameAssistConstKt.TYPE_CALLBACK_COMPLETE, "()V", "", "error", "subError", GameAssistConstKt.TYPE_CALLBACK_ERROR, "(II)V", "status", "subStatus", "", "obj", "onInfo", "(IILjava/lang/Object;)V", "onPrepared", "onSeekCompleted", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface CtrlPointListener {
        void onComplete();

        void onError(int i, int i2);

        void onInfo(int i, int i2, Object obj);

        void onPrepared();

        void onSeekCompleted(int i, int i2);
    }

    long getCurrentTime();

    long getDuration();

    int getUrlPlayStatus(String str);

    void pause();

    void play();

    void seek(long j);

    void setAVTransportUrl(String str);

    void setListener(CtrlPointListener ctrlPointListener);

    void setMute(boolean z);

    void shutdown(boolean z);

    void stop();
}
