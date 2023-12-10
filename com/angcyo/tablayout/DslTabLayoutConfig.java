package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.view.InputDeviceCompat;
import com.angcyo.tablayout.DslTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.tieba.r0;
import com.baidu.tieba.t0;
import com.baidu.tieba.u0;
import com.baidu.tieba.we7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u00142\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\fH\u0016J*\u0010n\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u00142\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\fH\u0016J*\u0010o\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u00142\u0006\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020\f2\u0006\u0010m\u001a\u00020\fH\u0016J*\u0010r\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u001c2\u0006\u0010s\u001a\u00020\f2\u0006\u0010t\u001a\u00020\f2\u0006\u0010m\u001a\u00020\fH\u0016J\u001a\u0010u\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u00142\u0006\u0010v\u001a\u00020\u0007H\u0016J\u001c\u0010w\u001a\u00020i2\u0006\u0010x\u001a\u00020y2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{H\u0016J \u0010|\u001a\u00020i2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010}\u001a\u00020i2\b\u0010~\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u007f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0080\u0001\u001a\u00020i2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020%H\u0016R_\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u001a\u00107\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u001a\u0010:\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R$\u0010=\u001a\u00020%2\u0006\u0010$\u001a\u00020%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010!\"\u0004\bH\u0010#R\u001c\u0010I\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010!\"\u0004\bK\u0010#R\u001e\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\u001a\u0010Y\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010!\"\u0004\b[\u0010#R\u001a\u0010\\\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010S\"\u0004\b^\u0010UR\u001a\u0010_\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010S\"\u0004\ba\u0010UR\u001e\u0010b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010!\"\u0004\bd\u0010#R\u001a\u0010e\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010(\"\u0004\bg\u0010*¨\u0006\u0082\u0001"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayoutConfig;", "Lcom/angcyo/tablayout/DslSelectorConfig;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "(Lcom/angcyo/tablayout/DslTabLayout;)V", "onGetGradientIndicatorColor", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "fromIndex", "toIndex", "", "positionOffset", "getOnGetGradientIndicatorColor", "()Lkotlin/jvm/functions/Function3;", "setOnGetGradientIndicatorColor", "(Lkotlin/jvm/functions/Function3;)V", "onGetIcoStyleView", "Lkotlin/Function2;", "Landroid/view/View;", "itemView", "index", "getOnGetIcoStyleView", "()Lkotlin/jvm/functions/Function2;", "setOnGetIcoStyleView", "(Lkotlin/jvm/functions/Function2;)V", "onGetTextStyleView", "Landroid/widget/TextView;", "getOnGetTextStyleView", "setOnGetTextStyleView", "tabDeselectColor", "getTabDeselectColor", "()I", "setTabDeselectColor", "(I)V", "value", "", "tabEnableGradientColor", "getTabEnableGradientColor", "()Z", "setTabEnableGradientColor", "(Z)V", "tabEnableGradientScale", "getTabEnableGradientScale", "setTabEnableGradientScale", "tabEnableGradientTextSize", "getTabEnableGradientTextSize", "setTabEnableGradientTextSize", "tabEnableIcoColor", "getTabEnableIcoColor", "setTabEnableIcoColor", "tabEnableIcoGradientColor", "getTabEnableIcoGradientColor", "setTabEnableIcoGradientColor", "tabEnableIndicatorGradientColor", "getTabEnableIndicatorGradientColor", "setTabEnableIndicatorGradientColor", "tabEnableTextBold", "getTabEnableTextBold", "setTabEnableTextBold", "tabEnableTextColor", "getTabEnableTextColor", "setTabEnableTextColor", "tabGradientCallback", "Lcom/angcyo/tablayout/TabGradientCallback;", "getTabGradientCallback", "()Lcom/angcyo/tablayout/TabGradientCallback;", "setTabGradientCallback", "(Lcom/angcyo/tablayout/TabGradientCallback;)V", "tabIcoDeselectColor", "getTabIcoDeselectColor", "setTabIcoDeselectColor", "tabIcoSelectColor", "getTabIcoSelectColor", "setTabIcoSelectColor", "tabIconViewId", "getTabIconViewId", "setTabIconViewId", "getTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "tabMaxScale", "getTabMaxScale", "()F", "setTabMaxScale", "(F)V", "tabMinScale", "getTabMinScale", "setTabMinScale", "tabSelectColor", "getTabSelectColor", "setTabSelectColor", "tabTextMaxSize", "getTabTextMaxSize", "setTabTextMaxSize", "tabTextMinSize", "getTabTextMinSize", "setTabTextMinSize", "tabTextViewId", "getTabTextViewId", "setTabTextViewId", "tabUseTypefaceBold", "getTabUseTypefaceBold", "setTabUseTypefaceBold", "_gradientColor", "", "view", "startColor", "endColor", "percent", "_gradientIcoColor", "_gradientScale", "startScale", "endScale", "_gradientTextSize", "startTextSize", "endTextSize", "_updateIcoColor", "color", "initAttribute", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "onPageIndexScrolled", "onPageViewScrolled", "fromView", "toView", "onUpdateItemStyle", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslTabLayoutConfig extends DslSelectorConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @IdRes
    public int A;
    @IdRes
    public int B;
    public Function2<? super View, ? super Integer, ? extends TextView> C;
    public Function2<? super View, ? super Integer, ? extends View> D;
    public Function3<? super Integer, ? super Integer, ? super Float, Integer> E;
    public final DslTabLayout h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;
    public float u;
    public float v;
    public boolean w;
    public float x;
    public float y;
    public t0 z;

    public void w(int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
        }
    }

    public DslTabLayoutConfig(DslTabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.h = tabLayout;
        this.i = true;
        this.l = -1;
        this.m = Color.parseColor("#999999");
        this.p = true;
        this.r = -2;
        this.s = -2;
        this.u = 0.8f;
        this.v = 1.2f;
        this.w = true;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = new t0();
        this.A = -1;
        this.B = -1;
        this.C = new Function2<View, Integer, TextView>(this) { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetTextStyleView$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayoutConfig this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            public final TextView invoke(View itemView, int i3) {
                InterceptResult invokeLI;
                KeyEvent.Callback callback;
                KeyEvent.Callback findViewById;
                KeyEvent.Callback g;
                KeyEvent.Callback findViewById2;
                KeyEvent.Callback g2;
                KeyEvent.Callback findViewById3;
                KeyEvent.Callback g3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, itemView, i3)) == null) {
                    Intrinsics.checkNotNullParameter(itemView, "itemView");
                    if (this.this$0.u() == -1) {
                        if (itemView instanceof TextView) {
                            callback = (TextView) itemView;
                        } else {
                            callback = null;
                        }
                        if (this.this$0.t().getTabIndicator().f0() != -1 && (g3 = r0.g(itemView, this.this$0.t().getTabIndicator().f0())) != null && (g3 instanceof TextView)) {
                            callback = g3;
                        }
                        if (this.this$0.t().getTabIndicator().e0() != -1 && (findViewById3 = itemView.findViewById(this.this$0.t().getTabIndicator().e0())) != null && (findViewById3 instanceof TextView)) {
                            callback = findViewById3;
                        }
                        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
                        if (layoutParams instanceof DslTabLayout.LayoutParams) {
                            DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
                            if (layoutParams2.g() != -1 && (itemView instanceof ViewGroup) && (g2 = r0.g(itemView, layoutParams2.g())) != null && (g2 instanceof TextView)) {
                                callback = g2;
                            }
                            if (layoutParams2.f() != -1 && (findViewById2 = itemView.findViewById(layoutParams2.f())) != null && (findViewById2 instanceof TextView)) {
                                callback = findViewById2;
                            }
                            if (layoutParams2.d() != -1 && (itemView instanceof ViewGroup) && (g = r0.g(itemView, layoutParams2.d())) != null && (g instanceof TextView)) {
                                callback = g;
                            }
                            if (layoutParams2.c() != -1 && (findViewById = itemView.findViewById(layoutParams2.c())) != null && (findViewById instanceof TextView)) {
                                callback = findViewById;
                            }
                        }
                        return (TextView) callback;
                    }
                    return (TextView) itemView.findViewById(this.this$0.u());
                }
                return (TextView) invokeLI.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ TextView invoke(View view2, Integer num) {
                return invoke(view2, num.intValue());
            }
        };
        this.D = new Function2<View, Integer, View>(this) { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetIcoStyleView$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayoutConfig this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            public final View invoke(View itemView, int i3) {
                InterceptResult invokeLI;
                View view2;
                View findViewById;
                View findViewById2;
                View findViewById3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, itemView, i3)) == null) {
                    Intrinsics.checkNotNullParameter(itemView, "itemView");
                    if (this.this$0.s() == -1) {
                        if (this.this$0.t().getTabIndicator().f0() == -1 || (view2 = r0.g(itemView, this.this$0.t().getTabIndicator().f0())) == null) {
                            view2 = itemView;
                        }
                        if (this.this$0.t().getTabIndicator().e0() != -1 && (findViewById3 = itemView.findViewById(this.this$0.t().getTabIndicator().e0())) != null) {
                            view2 = findViewById3;
                        }
                        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
                        if (layoutParams instanceof DslTabLayout.LayoutParams) {
                            DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
                            if (layoutParams2.g() != -1 && (itemView instanceof ViewGroup)) {
                                view2 = r0.g(itemView, layoutParams2.g());
                            }
                            if (layoutParams2.f() != -1 && (findViewById2 = itemView.findViewById(layoutParams2.f())) != null) {
                                view2 = findViewById2;
                            }
                            if (layoutParams2.b() != -1 && (itemView instanceof ViewGroup)) {
                                view2 = r0.g(itemView, layoutParams2.b());
                            }
                            if (layoutParams2.a() != -1 && (findViewById = itemView.findViewById(layoutParams2.a())) != null) {
                                return findViewById;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return itemView.findViewById(this.this$0.s());
                }
                return (View) invokeLI.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ View invoke(View view2, Integer num) {
                return invoke(view2, num.intValue());
            }
        };
        this.E = new Function3<Integer, Integer, Float, Integer>(this) { // from class: com.angcyo.tablayout.DslTabLayoutConfig$onGetGradientIndicatorColor$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayoutConfig this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            public final Integer invoke(int i3, int i4, float f) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f)})) == null) {
                    return Integer.valueOf(this.this$0.t().getTabIndicator().d0());
                }
                return (Integer) invokeCommon.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2, Float f) {
                return invoke(num.intValue(), num2.intValue(), f.floatValue());
            }
        };
        k(new Function3<View, Integer, Boolean, Unit>(this) { // from class: com.angcyo.tablayout.DslTabLayoutConfig.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayoutConfig this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view2, Integer num, Boolean bool) {
                invoke(view2, num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View itemView, int i3, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{itemView, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                    Intrinsics.checkNotNullParameter(itemView, "itemView");
                    this.this$0.y(itemView, i3, z);
                }
            }
        });
        h(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>(this) { // from class: com.angcyo.tablayout.DslTabLayoutConfig.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayoutConfig this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, List<Integer> selectIndexList, boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), selectIndexList, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    Intrinsics.checkNotNullParameter(selectIndexList, "selectIndexList");
                    int intValue = ((Number) CollectionsKt___CollectionsKt.last((List<? extends Object>) selectIndexList)).intValue();
                    u0 u0Var = this.this$0.t().get_viewPagerDelegate();
                    if (u0Var != null) {
                        u0Var.a(i3, intValue, z, z2);
                    }
                }
            }
        });
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.i = z;
            if (z) {
                this.p = true;
            }
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.j = z;
            if (z) {
                this.q = true;
            }
        }
    }

    public void l(View view2, int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            this.z.a(view2, i, i2, f);
        }
    }

    public void m(View view2, int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            this.z.b(view2, i, i2, f);
        }
    }

    public void n(View view2, float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.z.c(view2, f, f2, f3);
        }
    }

    public void o(TextView textView, float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{textView, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.z.d(textView, f, f2, f3);
        }
    }

    public void p(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view2, i) == null) {
            this.z.e(view2, i);
        }
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.s;
            if (i == -2) {
                return this.m;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.r;
            if (i == -2) {
                return this.l;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public final DslTabLayout t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (DslTabLayout) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public void v(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, we7.DslTabLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.DslTabLayout)");
            this.l = obtainStyledAttributes.getColor(113, this.l);
            this.m = obtainStyledAttributes.getColor(36, this.m);
            this.r = obtainStyledAttributes.getColor(69, -2);
            this.s = obtainStyledAttributes.getColor(68, -2);
            A(obtainStyledAttributes.getBoolean(62, this.i));
            this.k = obtainStyledAttributes.getBoolean(59, this.k);
            z(obtainStyledAttributes.getBoolean(54, this.j));
            this.p = obtainStyledAttributes.getBoolean(57, this.p);
            this.q = obtainStyledAttributes.getBoolean(58, this.q);
            this.n = obtainStyledAttributes.getBoolean(61, this.n);
            this.o = obtainStyledAttributes.getBoolean(117, this.o);
            this.t = obtainStyledAttributes.getBoolean(55, this.t);
            this.u = obtainStyledAttributes.getFloat(108, this.u);
            this.v = obtainStyledAttributes.getFloat(107, this.v);
            this.w = obtainStyledAttributes.getBoolean(56, this.w);
            if (obtainStyledAttributes.hasValue(115)) {
                this.x = obtainStyledAttributes.getDimensionPixelOffset(115, (int) this.x);
            }
            if (obtainStyledAttributes.hasValue(114)) {
                this.y = obtainStyledAttributes.getDimensionPixelOffset(114, (int) this.y);
            }
            this.A = obtainStyledAttributes.getResourceId(116, this.A);
            this.B = obtainStyledAttributes.getResourceId(70, this.B);
            obtainStyledAttributes.recycle();
        }
    }

    public void x(View view2, View toView, float f) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view2, toView, Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(toView, "toView");
            if (!Intrinsics.areEqual(view2, toView)) {
                int b0 = this.h.getTabIndicator().b0();
                int m0 = this.h.getTabIndicator().m0();
                if (this.k) {
                    this.h.getTabIndicator().p0(r0.d(f, this.E.invoke(Integer.valueOf(b0), Integer.valueOf(b0), Float.valueOf(0.0f)).intValue(), this.E.invoke(Integer.valueOf(b0), Integer.valueOf(m0), Float.valueOf(f)).intValue()));
                }
                if (this.j) {
                    if (view2 != null) {
                        l(this.C.invoke(view2, Integer.valueOf(b0)), this.l, this.m, f);
                    }
                    l(this.C.invoke(toView, Integer.valueOf(m0)), this.m, this.l, f);
                }
                if (this.q) {
                    if (view2 != null) {
                        m(this.D.invoke(view2, Integer.valueOf(b0)), r(), q(), f);
                    }
                    m(this.D.invoke(toView, Integer.valueOf(m0)), q(), r(), f);
                }
                if (this.t) {
                    n(view2, this.v, this.u, f);
                    n(toView, this.u, this.v, f);
                }
                if (this.w) {
                    float f2 = this.y;
                    if (f2 > 0.0f) {
                        float f3 = this.x;
                        if (f3 > 0.0f) {
                            if (f3 == f2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                if (view2 != null) {
                                    textView = this.C.invoke(view2, Integer.valueOf(b0));
                                } else {
                                    textView = null;
                                }
                                o(textView, this.y, this.x, f);
                                o(this.C.invoke(toView, Integer.valueOf(m0)), this.x, this.y, f);
                                if (m0 == CollectionsKt__CollectionsKt.getLastIndex(this.h.getDslSelector().g()) || m0 == 0) {
                                    this.h.f(m0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void y(View itemView, int i, boolean z) {
        DslTabBorder tabBorder;
        float f;
        float f2;
        View invoke;
        int q;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{itemView, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            TextView invoke2 = this.C.invoke(itemView, Integer.valueOf(i));
            if (invoke2 != null) {
                TextPaint paint = invoke2.getPaint();
                if (paint != null) {
                    Intrinsics.checkNotNullExpressionValue(paint, "paint");
                    if (this.n && z) {
                        if (this.o) {
                            paint.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            paint.setFlags(paint.getFlags() | 32);
                            paint.setFakeBoldText(true);
                        }
                    } else if (this.o) {
                        paint.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        paint.setFlags(paint.getFlags() & (-33));
                        paint.setFakeBoldText(false);
                    }
                }
                if (this.i) {
                    if (z) {
                        i2 = this.l;
                    } else {
                        i2 = this.m;
                    }
                    invoke2.setTextColor(i2);
                }
                if (this.y > 0.0f || this.x > 0.0f) {
                    float min = Math.min(this.x, this.y);
                    float max = Math.max(this.x, this.y);
                    if (z) {
                        min = max;
                    }
                    invoke2.setTextSize(0, min);
                }
            }
            if (this.p && (invoke = this.D.invoke(itemView, Integer.valueOf(i))) != null) {
                if (z) {
                    q = r();
                } else {
                    q = q();
                }
                p(invoke, q);
            }
            if (this.t) {
                if (z) {
                    f = this.v;
                } else {
                    f = this.u;
                }
                itemView.setScaleX(f);
                if (z) {
                    f2 = this.v;
                } else {
                    f2 = this.u;
                }
                itemView.setScaleY(f2);
            }
            if (this.h.getDrawBorder() && (tabBorder = this.h.getTabBorder()) != null) {
                tabBorder.U(this.h, itemView, i, z);
            }
        }
    }
}
