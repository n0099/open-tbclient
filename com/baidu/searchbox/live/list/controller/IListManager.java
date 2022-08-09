package com.baidu.searchbox.live.list.controller;

import android.view.View;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/IListManager;", "Lkotlin/Any;", "", "sizeBefore", "", "clear", "(I)V", "Landroid/view/View;", "createView", "()Landroid/view/View;", "", "", "closeRoomIdList", "onCloseRoom", "(Ljava/util/List;)V", MissionEvent.MESSAGE_DESTROY, "()V", "size", "onListChange", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "itemModel", "resetCurRoom", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "scrollToNextLiveRoom", "scrollToPreLiveRoom", "", "isCanScroll", "setIsScrollable", "(Z)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IListManager {
    void clear(int i);

    View createView();

    void onCloseRoom(List<String> list);

    void onDestroy();

    void onListChange(int i);

    void resetCurRoom(LiveContainer.LiveItemModel liveItemModel);

    void scrollToNextLiveRoom();

    void scrollToPreLiveRoom();

    void setIsScrollable(boolean z);
}
