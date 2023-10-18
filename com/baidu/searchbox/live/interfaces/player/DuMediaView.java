package com.baidu.searchbox.live.interfaces.player;

import android.net.Uri;
import android.view.View;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002&'J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH&¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\u000eH&¢\u0006\u0004\b%\u0010\u0010¨\u0006("}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaView;", "Lkotlin/Any;", "", "getCurrentPosition", "()I", "getDuration", "getVideoHeight", "getVideoWidth", "Landroid/view/View;", "getView", "()Landroid/view/View;", "", "isPlaying", "()Z", "", DownloadStatisticConstants.UBC_TYPE_PAUSE, "()V", "time", "seekTo", "(I)V", "width", "height", "setLayoutParamsSize", "(II)V", "Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnCompletionListener;", "onCompletionListener", "setOnCompletionListener", "(Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnCompletionListener;)V", "Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnPreparedListener;", "onPreparedListener", "setOnPreparedListener", "(Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnPreparedListener;)V", "Landroid/net/Uri;", "uri", "setVideoURI", "(Landroid/net/Uri;)V", "start", "stopPlayback", "OnCompletionListener", "OnPreparedListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface DuMediaView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnCompletionListener;", "Lkotlin/Any;", "", "onCompletion", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaView$OnPreparedListener;", "Lkotlin/Any;", "", "onPrepared", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    boolean isPlaying();

    void pause();

    void seekTo(int i);

    void setLayoutParamsSize(int i, int i2);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setVideoURI(Uri uri);

    void start();

    void stopPlayback();
}
