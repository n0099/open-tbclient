package com.baidu.searchbox.live.interfaces.liveshowplayer;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\bJ!\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerCallback;", "Lkotlin/Any;", "", "status", "", "ext", "", "cyberInitCallBack", "(ILjava/lang/Object;)V", "playerCallBack", "showFloating", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface LiveShowPlayerCallback {
    void cyberInitCallBack(int i2, Object obj);

    void playerCallBack(int i2, Object obj);

    void showFloating(int i2, Object obj);
}
