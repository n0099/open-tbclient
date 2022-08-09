package com.baidu.searchbox.live.list.controller;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.utils.MiniUiThreadUtil;
import com.baidu.searchbox.live.list.controller.RecyleController;
import com.baidu.searchbox.live.service.MixShellScrollInterface;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.live.widget.PagerLayoutManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/widget/PagerLayoutManager;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyleController$layoutManger$2 extends Lambda implements Function0<PagerLayoutManager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ RecyleController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyleController$layoutManger$2(RecyleController recyleController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyleController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = recyleController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PagerLayoutManager invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PagerLayoutManager pagerLayoutManager = new PagerLayoutManager(this.this$0.getContext());
            pagerLayoutManager.setOnPagerListener(new PagerLayoutManager.SimplePagerListener(this) { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public View lastSelectView;
                public int lastSelectedPos;
                public final /* synthetic */ RecyleController$layoutManger$2 this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.lastSelectedPos = -1;
                }

                public final View getLastSelectView() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.lastSelectView : (View) invokeV2.objValue;
                }

                public final int getLastSelectedPos() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lastSelectedPos : invokeV2.intValue;
                }

                @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
                public void onPageScrolled(boolean z, int i, boolean z2, boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                        super.onPageScrolled(z, i, z2, z3);
                        MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                        if (mixShellScrollInterface != null) {
                            mixShellScrollInterface.pageScrolledAction(i, z, z2);
                        }
                    }
                }

                @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
                public void onPageSelected(PagerLayoutManager.PagerListener.PageAction pageAction, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, pageAction, i, view2) == null) {
                        if (pageAction == PagerLayoutManager.PagerListener.PageAction.NONE && i == 0 && this.this$0.this$0.getListController().getCurrentPosition() != 0 && this.this$0.this$0.getListController().getCurrentPosition() < this.this$0.this$0.getListController().getItemData().size()) {
                            i = this.this$0.this$0.getListController().getCurrentPosition();
                        }
                        int i2 = this.lastSelectedPos;
                        if (i2 >= 0 && this.lastSelectView != null && i2 != i) {
                            LiveContainer.LiveItemModel liveItemModel = i2 < this.this$0.this$0.getListController().getItemData().size() ? this.this$0.this$0.getListController().getItemData().get(this.lastSelectedPos) : null;
                            View view3 = this.lastSelectView;
                            if (!(view3 instanceof LiveContainer)) {
                                view3 = null;
                            }
                            LiveContainer liveContainer = (LiveContainer) view3;
                            if (liveContainer != null) {
                                liveContainer.onDeselected(this.lastSelectedPos, liveItemModel);
                            }
                        }
                        Set<Integer> handleClosedLiveRoom = this.this$0.this$0.handleClosedLiveRoom();
                        if (!handleClosedLiveRoom.isEmpty()) {
                            if (handleClosedLiveRoom.size() == 1) {
                                MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable(this, handleClosedLiveRoom) { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ Set $needRefresh;
                                    public final /* synthetic */ RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, handleClosedLiveRoom};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.$needRefresh = handleClosedLiveRoom;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        RecyleController.ListAdapter adapter;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                adapter = this.this$0.this$0.this$0.getAdapter();
                                                adapter.notifyItemRemoved(((Number) CollectionsKt___CollectionsKt.first(this.$needRefresh)).intValue());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            } else {
                                MiniUiThreadUtil.INSTANCE.runOnUiThread(new Runnable(this) { // from class: com.baidu.searchbox.live.list.controller.RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ RecyleController$layoutManger$2$$special$$inlined$apply$lambda$1 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        RecyleController.ListAdapter adapter;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            try {
                                                adapter = this.this$0.this$0.this$0.getAdapter();
                                                adapter.notifyDataSetChanged();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                            ListLogKt.log("MixLiveCell_fake_list", "ListComponent onPageSelected but return " + handleClosedLiveRoom.size() + " context:" + this.this$0.this$0.getContext().hashCode());
                        }
                        if (i < this.this$0.this$0.getListController().getItemData().size()) {
                            this.this$0.this$0.getListController().setCurrentPosition(i);
                            this.lastSelectedPos = i;
                            this.lastSelectView = view2;
                            this.this$0.this$0.getListController().setCurRoomModel(this.this$0.this$0.getListController().getItemData().get(i));
                            this.this$0.this$0.getListController().onBeforeSelect(i);
                            if (!(view2 instanceof LiveContainer)) {
                                view2 = null;
                            }
                            LiveContainer liveContainer2 = (LiveContainer) view2;
                            if (liveContainer2 != null) {
                                liveContainer2.onSelected(i, this.this$0.this$0.getListController().getItemData().get(i), !this.this$0.this$0.getListController().isFromForward());
                            }
                            this.this$0.this$0.getListController().onAfterSelect(i);
                        }
                    }
                }

                @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
                public void onScrollStateChanged(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048580, this, i, i2) == null) {
                        super.onScrollStateChanged(i, i2);
                        MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                        if (mixShellScrollInterface != null) {
                            mixShellScrollInterface.pageScrolledStateChangedAction(i, i2);
                        }
                    }
                }

                @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.SimplePagerListener, com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
                public void onStartPageScrolledOffset(boolean z, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                        super.onStartPageScrolledOffset(z, i);
                        MixShellScrollInterface mixShellScrollInterface = (MixShellScrollInterface) ServiceLocator.Companion.getGlobalService(MixShellScrollInterface.class);
                        if (mixShellScrollInterface != null) {
                            mixShellScrollInterface.pageStartScrolledOffsetAction(z, i);
                        }
                    }
                }

                public final void setLastSelectView(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, view2) == null) {
                        this.lastSelectView = view2;
                    }
                }

                public final void setLastSelectedPos(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048583, this, i) == null) {
                        this.lastSelectedPos = i;
                    }
                }
            });
            return pagerLayoutManager;
        }
        return (PagerLayoutManager) invokeV.objValue;
    }
}
