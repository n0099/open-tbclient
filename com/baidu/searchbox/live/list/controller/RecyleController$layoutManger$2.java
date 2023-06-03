package com.baidu.searchbox.live.list.controller;

import android.view.View;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUiThreadUtil;
import com.baidu.searchbox.live.list.controller.RecyleController;
import com.baidu.searchbox.live.service.MixShellScrollInterface;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.live.widget.PagerLayoutManager;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/widget/PagerLayoutManager;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class RecyleController$layoutManger$2 extends Lambda implements Function0<PagerLayoutManager> {
    public final /* synthetic */ RecyleController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyleController$layoutManger$2(RecyleController recyleController) {
        super(0);
        this.this$0 = recyleController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PagerLayoutManager invoke() {
        PagerLayoutManager pagerLayoutManager = new PagerLayoutManager(this.this$0.getContext());
        pagerLayoutManager.setOnPagerListener(new PagerLayoutManager.SimplePagerListener() { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1
            public View lastSelectView;
            public int lastSelectedPos = -1;

            public final void setLastSelectView(View view2) {
                this.lastSelectView = view2;
            }

            public final void setLastSelectedPos(int i) {
                this.lastSelectedPos = i;
            }

            public final View getLastSelectView() {
                return this.lastSelectView;
            }

            public final int getLastSelectedPos() {
                return this.lastSelectedPos;
            }

            @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
            public void onPageScrolled(boolean z, int i, boolean z2, boolean z3) {
                super.onPageScrolled(z, i, z2, z3);
                MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                if (mixShellScrollInterface != null) {
                    mixShellScrollInterface.pageScrolledAction(i, z, z2);
                }
            }

            @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
            public void onPageSelected(PagerLayoutManager.PagerListener.PageAction pageAction, int i, View view2) {
                LiveContainer.LiveItemModel liveItemModel;
                if (pageAction == PagerLayoutManager.PagerListener.PageAction.NONE && i == 0 && RecyleController$layoutManger$2.this.this$0.getListController().getCurrentPosition() != 0 && RecyleController$layoutManger$2.this.this$0.getListController().getCurrentPosition() < RecyleController$layoutManger$2.this.this$0.getListController().getItemData().size()) {
                    i = RecyleController$layoutManger$2.this.this$0.getListController().getCurrentPosition();
                }
                int i2 = this.lastSelectedPos;
                if (i2 >= 0 && this.lastSelectView != null && i2 != i) {
                    if (i2 < RecyleController$layoutManger$2.this.this$0.getListController().getItemData().size()) {
                        liveItemModel = RecyleController$layoutManger$2.this.this$0.getListController().getItemData().get(this.lastSelectedPos);
                    } else {
                        liveItemModel = null;
                    }
                    View view3 = this.lastSelectView;
                    if (!(view3 instanceof LiveContainer)) {
                        view3 = null;
                    }
                    LiveContainer liveContainer = (LiveContainer) view3;
                    if (liveContainer != null) {
                        liveContainer.onDeselected(this.lastSelectedPos, liveItemModel);
                    }
                }
                final Set<Integer> handleClosedLiveRoom = RecyleController$layoutManger$2.this.this$0.handleClosedLiveRoom();
                if (!handleClosedLiveRoom.isEmpty()) {
                    if (handleClosedLiveRoom.size() == 1) {
                        MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyleController.ListAdapter adapter;
                                try {
                                    adapter = RecyleController$layoutManger$2.this.this$0.getAdapter();
                                    adapter.notifyItemRemoved(((Number) CollectionsKt___CollectionsKt.first(handleClosedLiveRoom)).intValue());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else {
                        MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyleController.ListAdapter adapter;
                                try {
                                    adapter = RecyleController$layoutManger$2.this.this$0.getAdapter();
                                    adapter.notifyDataSetChanged();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    ListLogKt.log("MixLiveCell_fake_list", "ListComponent onPageSelected but return " + handleClosedLiveRoom.size() + " context:" + RecyleController$layoutManger$2.this.this$0.getContext().hashCode());
                }
                if (i < RecyleController$layoutManger$2.this.this$0.getListController().getItemData().size()) {
                    RecyleController$layoutManger$2.this.this$0.getListController().setCurrentPosition(i);
                    this.lastSelectedPos = i;
                    this.lastSelectView = view2;
                    RecyleController$layoutManger$2.this.this$0.getListController().setCurRoomModel(RecyleController$layoutManger$2.this.this$0.getListController().getItemData().get(i));
                    RecyleController$layoutManger$2.this.this$0.getListController().onBeforeSelect(i);
                    if (!(view2 instanceof LiveContainer)) {
                        view2 = null;
                    }
                    LiveContainer liveContainer2 = (LiveContainer) view2;
                    if (liveContainer2 != null) {
                        liveContainer2.onSelected(i, RecyleController$layoutManger$2.this.this$0.getListController().getItemData().get(i), !RecyleController$layoutManger$2.this.this$0.getListController().isFromForward());
                    }
                    RecyleController$layoutManger$2.this.this$0.getListController().onAfterSelect(i);
                }
            }

            @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
            public void onScrollStateChanged(int i, int i2) {
                super.onScrollStateChanged(i, i2);
                MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                if (mixShellScrollInterface != null) {
                    mixShellScrollInterface.pageScrolledStateChangedAction(i, i2);
                }
            }

            @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
            public void onStartPageScrolledOffset(boolean z, int i) {
                super.onStartPageScrolledOffset(z, i);
                MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                if (mixShellScrollInterface != null) {
                    mixShellScrollInterface.pageStartScrolledOffsetAction(z, i);
                }
            }
        });
        return pagerLayoutManager;
    }
}
