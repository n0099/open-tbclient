package com.angcyo.tablayout;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011Rz\u0010\u0012\u001ab\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRt\u0010 \u001a\\\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR|\u0010'\u001ad\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b((\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020!0\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR_\u0010,\u001aG\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001b0-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/angcyo/tablayout/DslSelectorConfig;", "", "()V", "dslMaxSelectLimit", "", "getDslMaxSelectLimit", "()I", "setDslMaxSelectLimit", "(I)V", "dslMinSelectLimit", "getDslMinSelectLimit", "setDslMinSelectLimit", "dslMultiMode", "", "getDslMultiMode", "()Z", "setDslMultiMode", "(Z)V", "onSelectIndexChange", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "fromIndex", "", "selectIndexList", "reselect", "fromUser", "", "getOnSelectIndexChange", "()Lkotlin/jvm/functions/Function4;", "setOnSelectIndexChange", "(Lkotlin/jvm/functions/Function4;)V", "onSelectItemView", "Landroid/view/View;", "itemView", "index", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "getOnSelectItemView", "setOnSelectItemView", "onSelectViewChange", "fromView", "selectViewList", "getOnSelectViewChange", "setOnSelectViewChange", "onStyleItemView", "Lkotlin/Function3;", "getOnStyleItemView", "()Lkotlin/jvm/functions/Function3;", "setOnStyleItemView", "(Lkotlin/jvm/functions/Function3;)V", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslSelectorConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public Function3<? super View, ? super Integer, ? super Boolean, Unit> d;
    public Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> e;
    public Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> f;
    public Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> g;

    public DslSelectorConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = Integer.MAX_VALUE;
        this.d = DslSelectorConfig$onStyleItemView$1.INSTANCE;
        this.e = DslSelectorConfig$onSelectViewChange$1.INSTANCE;
        this.f = DslSelectorConfig$onSelectIndexChange$1.INSTANCE;
        this.g = DslSelectorConfig$onSelectItemView$1.INSTANCE;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super java.util.List<java.lang.Integer>, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function4<java.lang.Integer, java.util.List<java.lang.Integer>, java.lang.Boolean, java.lang.Boolean, kotlin.Unit> */
    public final Function4<Integer, List<Integer>, Boolean, Boolean, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (Function4) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super android.view.View, ? super java.lang.Integer, ? super java.lang.Boolean, ? super java.lang.Boolean, java.lang.Boolean>, kotlin.jvm.functions.Function4<android.view.View, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean> */
    public final Function4<View, Integer, Boolean, Boolean, Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Function4) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super android.view.View, ? super java.util.List<? extends android.view.View>, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function4<android.view.View, java.util.List<? extends android.view.View>, java.lang.Boolean, java.lang.Boolean, kotlin.Unit> */
    public final Function4<View, List<? extends View>, Boolean, Boolean, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (Function4) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function3<? super android.view.View, ? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function3<android.view.View, java.lang.Integer, java.lang.Boolean, kotlin.Unit> */
    public final Function3<View, Integer, Boolean, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (Function3) invokeV.objValue;
    }

    public final void h(Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> function4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, function4) == null) {
            Intrinsics.checkNotNullParameter(function4, "<set-?>");
            this.f = function4;
        }
    }

    public final void i(Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> function4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, function4) == null) {
            Intrinsics.checkNotNullParameter(function4, "<set-?>");
            this.g = function4;
        }
    }

    public final void j(Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> function4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, function4) == null) {
            Intrinsics.checkNotNullParameter(function4, "<set-?>");
            this.e = function4;
        }
    }

    public final void k(Function3<? super View, ? super Integer, ? super Boolean, Unit> function3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, function3) == null) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.d = function3;
        }
    }
}
