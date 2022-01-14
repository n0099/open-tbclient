package com.baidu.searchbox.live.interfaces.service;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AudioFloatCallback;", "Lkotlin/Any;", "", "closeFloatView", "()V", "hideFloatView", "", "isFloatShowing", "()Z", "isMute", "muteMic", "(Z)V", "showFloatView", "switchToFrontRoom", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public interface AudioFloatCallback {
    void closeFloatView();

    void hideFloatView();

    boolean isFloatShowing();

    void muteMic(boolean z);

    void showFloatView();

    void switchToFrontRoom();
}
