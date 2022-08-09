package com.baidu.live.mix.interfaces;

import android.view.KeyEvent;
import com.baidu.live.mix.interfaces.MixLiveLifeCycleInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixLiveInterface;", "Lcom/baidu/live/mix/interfaces/MixLiveLifeCycleInterface;", "Lcom/baidu/live/mix/interfaces/MixLiveListInterface;", "Lcom/baidu/live/mix/interfaces/MixLivePlayInterface;", "Lcom/baidu/live/mix/interfaces/MixLiveOtherInterface;", "Lkotlin/Any;", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixLiveInterface extends MixLiveLifeCycleInterface, MixLiveListInterface, MixLivePlayInterface, MixLiveOtherInterface {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean onKeyDown(MixLiveInterface mixLiveInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, mixLiveInterface, i, keyEvent)) == null) ? MixLiveLifeCycleInterface.DefaultImpls.onKeyDown(mixLiveInterface, i, keyEvent) : invokeLIL.booleanValue;
        }
    }
}
