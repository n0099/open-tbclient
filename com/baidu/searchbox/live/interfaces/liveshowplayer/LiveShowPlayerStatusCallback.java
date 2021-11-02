package com.baidu.searchbox.live.interfaces.liveshowplayer;

import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerStatusCallback;", "Lkotlin/Any;", "", "onBufferEnd", "()V", "onBufferStart", "onEnded", "", "var1", "var2", "onError", "(II)V", "onInfo", "", "onInfoExtent", "(ILjava/lang/Object;)V", MissionEvent.MESSAGE_PAUSE, "onPrepared", "onResume", "onStart", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface LiveShowPlayerStatusCallback {
    void onBufferEnd();

    void onBufferStart();

    void onEnded();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onInfoExtent(int i2, Object obj);

    void onPause();

    void onPrepared();

    void onResume();

    void onStart();
}
