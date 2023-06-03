package com.baidu.searchbox.live.recommendmore;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/recommendmore/LiveRecMoreActionListener;", "Lkotlin/Any;", "", "cmd", "", "onGotoPersonCenter", "(Ljava/lang/String;)V", "", "type", "onJumpLiveRoom", "(Ljava/lang/String;I)V", "onUserClose", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface LiveRecMoreActionListener {
    void onGotoPersonCenter(String str);

    void onJumpLiveRoom(String str, @RoomType int i);

    void onUserClose();
}
