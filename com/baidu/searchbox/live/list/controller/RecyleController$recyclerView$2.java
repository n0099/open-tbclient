package com.baidu.searchbox.live.list.controller;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.baidu.searchbox.live.widget.PagerRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/widget/PagerRecyclerView;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyleController$recyclerView$2 extends Lambda implements Function0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ RecyleController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyleController$recyclerView$2(RecyleController recyleController) {
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
    @Override // kotlin.jvm.functions.Function0
    public final PagerRecyclerView invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PagerRecyclerView pagerRecyclerView = new PagerRecyclerView(this.this$0.getContext());
            pagerRecyclerView.setHasFixedSize(true);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(4, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(5, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(3, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(8, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 2);
            pagerRecyclerView.getRecycledViewPool().setMaxRecycledViews(6, 2);
            pagerRecyclerView.setItemViewCacheSize(0);
            pagerRecyclerView.setCanScrollListener(new PagerRecyclerView.CanScrollListener(this) { // from class: com.baidu.searchbox.live.list.controller.RecyleController$recyclerView$2$$special$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecyleController$recyclerView$2 this$0;

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
                }

                @Override // com.baidu.searchbox.live.widget.PagerRecyclerView.CanScrollListener
                public boolean isCanScrollable(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    String str;
                    IMixActivityInterface iMixActivityInterface;
                    JSONObject mixEventDispatcher;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                        LiveContainer.LiveItemModel curRoomModel = this.this$0.this$0.getListController().getCurRoomModel();
                        String str2 = null;
                        if (curRoomModel != null) {
                            str = curRoomModel.getLiveType();
                        } else {
                            str = null;
                        }
                        if (!TextUtils.equals(str, "4")) {
                            LiveContainer.LiveItemModel curRoomModel2 = this.this$0.this$0.getListController().getCurRoomModel();
                            if (curRoomModel2 != null) {
                                str2 = curRoomModel2.getTemplateId();
                            }
                            TextUtils.equals(str2, "5");
                        }
                        iMixActivityInterface = this.this$0.this$0.mixActivity;
                        if (iMixActivityInterface == null || (mixEventDispatcher = iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_GET_AUDIO_ROOM_SCROLLABLE, motionEvent)) == null) {
                            return true;
                        }
                        return mixEventDispatcher.optBoolean(MixConstants.RES_GET_AUDIO_ROOM_SCROLLABLE, true);
                    }
                    return invokeL.booleanValue;
                }
            });
            return pagerRecyclerView;
        }
        return (PagerRecyclerView) invokeV.objValue;
    }
}
