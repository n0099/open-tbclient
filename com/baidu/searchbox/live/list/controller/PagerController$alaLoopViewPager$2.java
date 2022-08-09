package com.baidu.searchbox.live.list.controller;

import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.data.constant.MixConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.livepager.AlaLoopViewPager;
import com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/livepager/AlaLoopViewPager;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PagerController$alaLoopViewPager$2 extends Lambda implements Function0<AlaLoopViewPager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ PagerController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerController$alaLoopViewPager$2(PagerController pagerController) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pagerController};
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
        this.this$0 = pagerController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AlaLoopViewPager invoke() {
        InterceptResult invokeV;
        ViewPager.OnPageChangeListener onPageChangeListener;
        AlaVerticalViewPagerNew.Callback callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlaLoopViewPager alaLoopViewPager = new AlaLoopViewPager(this.this$0.getContext());
            onPageChangeListener = this.this$0.onPageChangedListener;
            alaLoopViewPager.setOnPageChangeListener(onPageChangeListener);
            callback = this.this$0.mCallBack;
            alaLoopViewPager.setCallback(callback);
            alaLoopViewPager.setBoundaryCaching(true);
            alaLoopViewPager.setDetermineYRatio(1.0f);
            alaLoopViewPager.setScrollControl(new AlaLoopViewPager.IScrollControl(this) { // from class: com.baidu.searchbox.live.list.controller.PagerController$alaLoopViewPager$2$$special$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PagerController$alaLoopViewPager$2 this$0;

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

                @Override // com.baidu.searchbox.live.livepager.AlaLoopViewPager.IScrollControl
                public boolean isEnableScrollDown(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    boolean isFirstLive;
                    IMixActivityInterface iMixActivityInterface;
                    JSONObject mixEventDispatcher;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                        isFirstLive = this.this$0.this$0.isFirstLive();
                        boolean z = !isFirstLive;
                        if (z) {
                            iMixActivityInterface = this.this$0.this$0.mixActivity;
                            Boolean valueOf = (iMixActivityInterface == null || (mixEventDispatcher = iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_GET_AUDIO_ROOM_SCROLLABLE, motionEvent)) == null) ? null : Boolean.valueOf(mixEventDispatcher.optBoolean(MixConstants.RES_GET_AUDIO_ROOM_SCROLLABLE, true));
                            z = valueOf != null ? valueOf.booleanValue() : true;
                        }
                        ListLogKt.log(MixTagConstants.MIX_PAGER, "isEnableScrollDown " + z);
                        return z;
                    }
                    return invokeL.booleanValue;
                }

                @Override // com.baidu.searchbox.live.livepager.AlaLoopViewPager.IScrollControl
                public boolean isEnableScrollUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    boolean isLastLive;
                    IMixActivityInterface iMixActivityInterface;
                    JSONObject mixEventDispatcher;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                        isLastLive = this.this$0.this$0.isLastLive();
                        boolean z = !isLastLive;
                        if (z) {
                            iMixActivityInterface = this.this$0.this$0.mixActivity;
                            Boolean valueOf = (iMixActivityInterface == null || (mixEventDispatcher = iMixActivityInterface.setMixEventDispatcher(MixConstants.KEY_GET_AUDIO_ROOM_SCROLLABLE, motionEvent)) == null) ? null : Boolean.valueOf(mixEventDispatcher.optBoolean(MixConstants.RES_GET_AUDIO_ROOM_SCROLLABLE, true));
                            z = valueOf != null ? valueOf.booleanValue() : true;
                        }
                        ListLogKt.log(MixTagConstants.MIX_PAGER, "isEnableScrollUp " + z);
                        return z;
                    }
                    return invokeL.booleanValue;
                }
            });
            return alaLoopViewPager;
        }
        return (AlaLoopViewPager) invokeV.objValue;
    }
}
