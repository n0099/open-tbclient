package com.baidu.searchbox.live.goback;

import android.content.Context;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/goback/IYYGobackController;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/goback/LiveGoBackBean;", "info", "", "addRoomToStack", "(Lcom/baidu/searchbox/live/goback/LiveGoBackBean;)V", "clearRoomStack", "()V", "", "getCountdownTime", "()J", "getLastRoomInfo", "()Lcom/baidu/searchbox/live/goback/LiveGoBackBean;", "", "roomId", "popTopSameItem", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "returnLastRoom", "(Landroid/content/Context;)V", "time", "setCountdownTime", "(J)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IYYGobackController {
    void addRoomToStack(LiveGoBackBean liveGoBackBean);

    void clearRoomStack();

    long getCountdownTime();

    LiveGoBackBean getLastRoomInfo();

    void popTopSameItem(String str);

    void returnLastRoom(Context context);

    void setCountdownTime(long j);
}
