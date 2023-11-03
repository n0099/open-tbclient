package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.tieba.de7;
import com.baidu.tieba.j0;
import com.baidu.tieba.r0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\u0002012\u0006\u00102\u001a\u000203J\u001a\u00105\u001a\u0002012\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J(\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0013H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u0006A"}, d2 = {"Lcom/angcyo/tablayout/DslTabBorder;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "()V", "borderBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBorderBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBorderBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "borderBackgroundHeightOffset", "", "getBorderBackgroundHeightOffset", "()I", "setBorderBackgroundHeightOffset", "(I)V", "borderBackgroundWidthOffset", "getBorderBackgroundWidthOffset", "setBorderBackgroundWidthOffset", "borderDrawItemBackground", "", "getBorderDrawItemBackground", "()Z", "setBorderDrawItemBackground", "(Z)V", "borderItemBackgroundGradientColors", "", "getBorderItemBackgroundGradientColors", "()[I", "setBorderItemBackgroundGradientColors", "([I)V", "borderItemBackgroundSolidColor", "getBorderItemBackgroundSolidColor", "()Ljava/lang/Integer;", "setBorderItemBackgroundSolidColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "borderItemBackgroundSolidDisableColor", "getBorderItemBackgroundSolidDisableColor", "setBorderItemBackgroundSolidDisableColor", "borderKeepItemRadius", "getBorderKeepItemRadius", "setBorderKeepItemRadius", "itemDeselectBgDrawable", "getItemDeselectBgDrawable", "setItemDeselectBgDrawable", "itemSelectBgDrawable", "getItemSelectBgDrawable", "setItemSelectBgDrawable", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawBorderBackground", "initAttribute", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "updateItemBackground", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "itemView", "Landroid/view/View;", "index", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslTabBorder extends j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable A;
    public Drawable B;
    public boolean s;
    public boolean t;
    public Drawable u;
    public int v;
    public int w;
    public Integer x;
    public Integer y;
    public int[] z;

    public DslTabBorder() {
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
        this.s = true;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public final int[] Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.z;
        }
        return (int[]) invokeV.objValue;
    }

    public final Integer R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.x;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.y;
        }
        return (Integer) invokeV.objValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void N(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            Drawable drawable = this.u;
            if (drawable != null) {
                drawable.setBounds(c(), b(), j() - d(), i() - b());
                drawable.draw(canvas);
            }
        }
    }

    @Override // com.baidu.tieba.j0, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            Drawable z = z();
            if (z != null) {
                z.setBounds(c(), b(), j() - d(), i() - b());
                z.draw(canvas);
            }
        }
    }

    public void U(final DslTabLayout tabLayout, View itemView, int i, boolean z) {
        final boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{tabLayout, itemView, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (!this.s) {
                return;
            }
            if (z) {
                final boolean z3 = false;
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (i == tabLayout.getDslSelector().g().size() - 1) {
                    z3 = true;
                }
                j0 j0Var = new j0();
                j0Var.p(new Function1<j0, Unit>(this, tabLayout, z2, z3) { // from class: com.angcyo.tablayout.DslTabBorder$updateItemBackground$drawable$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean $isFirst;
                    public final /* synthetic */ boolean $isLast;
                    public final /* synthetic */ DslTabLayout $tabLayout;
                    public final /* synthetic */ DslTabBorder this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tabLayout, Boolean.valueOf(z2), Boolean.valueOf(z3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$tabLayout = tabLayout;
                        this.$isFirst = z2;
                        this.$isLast = z3;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(j0 j0Var2) {
                        invoke2(j0Var2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(j0 configDrawable) {
                        int x;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configDrawable) == null) {
                            Intrinsics.checkNotNullParameter(configDrawable, "$this$configDrawable");
                            configDrawable.K(this.this$0.P());
                            configDrawable.E(this.this$0.O());
                            Integer R = this.this$0.R();
                            if (R != null) {
                                x = R.intValue();
                            } else {
                                x = this.this$0.x();
                            }
                            configDrawable.H(x);
                            if (!this.$tabLayout.getItemEnableSelector() && this.this$0.S() != null) {
                                Integer S = this.this$0.S();
                                Intrinsics.checkNotNull(S);
                                configDrawable.H(S.intValue());
                            }
                            configDrawable.B(this.this$0.Q());
                            if ((this.$isFirst && this.$isLast) || this.this$0.T()) {
                                configDrawable.F(this.this$0.u());
                            } else if (this.$isFirst) {
                                if (this.$tabLayout.k()) {
                                    if (this.$tabLayout.l()) {
                                        configDrawable.F(new float[]{0.0f, 0.0f, this.this$0.u()[2], this.this$0.u()[3], this.this$0.u()[4], this.this$0.u()[5], 0.0f, 0.0f});
                                        return;
                                    } else {
                                        configDrawable.F(new float[]{this.this$0.u()[0], this.this$0.u()[1], 0.0f, 0.0f, 0.0f, 0.0f, this.this$0.u()[6], this.this$0.u()[7]});
                                        return;
                                    }
                                }
                                configDrawable.F(new float[]{this.this$0.u()[0], this.this$0.u()[1], this.this$0.u()[2], this.this$0.u()[3], 0.0f, 0.0f, 0.0f, 0.0f});
                            } else if (this.$isLast) {
                                if (this.$tabLayout.k()) {
                                    if (this.$tabLayout.l()) {
                                        configDrawable.F(new float[]{this.this$0.u()[0], this.this$0.u()[1], 0.0f, 0.0f, 0.0f, 0.0f, this.this$0.u()[6], this.this$0.u()[7]});
                                        return;
                                    } else {
                                        configDrawable.F(new float[]{0.0f, 0.0f, this.this$0.u()[2], this.this$0.u()[3], this.this$0.u()[4], this.this$0.u()[5], 0.0f, 0.0f});
                                        return;
                                    }
                                }
                                configDrawable.F(new float[]{0.0f, 0.0f, 0.0f, 0.0f, this.this$0.u()[4], this.this$0.u()[5], this.this$0.u()[6], this.this$0.u()[7]});
                            }
                        }
                    }
                });
                this.A = j0Var;
                ViewCompat.setBackground(itemView, j0Var);
                return;
            }
            ViewCompat.setBackground(itemView, this.B);
        }
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        int x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, de7.DslTabLayout);
            final int color = obtainStyledAttributes.getColor(31, w());
            I(obtainStyledAttributes.getColor(32, x()));
            J(obtainStyledAttributes.getDimensionPixelOffset(33, r0.i() * 2));
            q(obtainStyledAttributes.getDimensionPixelOffset(30, 0));
            L(obtainStyledAttributes.getDrawable(22));
            this.s = obtainStyledAttributes.getBoolean(21, this.s);
            this.t = obtainStyledAttributes.getBoolean(29, this.t);
            this.v = obtainStyledAttributes.getDimensionPixelOffset(28, this.v);
            this.w = obtainStyledAttributes.getDimensionPixelOffset(25, this.w);
            if (obtainStyledAttributes.hasValue(26)) {
                this.x = Integer.valueOf(obtainStyledAttributes.getColor(26, x()));
            }
            if (obtainStyledAttributes.hasValue(27)) {
                Integer num = this.x;
                if (num != null) {
                    x = num.intValue();
                } else {
                    x = x();
                }
                this.y = Integer.valueOf(obtainStyledAttributes.getColor(27, x));
            }
            if (obtainStyledAttributes.hasValue(24) || obtainStyledAttributes.hasValue(23)) {
                this.z = new int[]{obtainStyledAttributes.getColor(24, x()), obtainStyledAttributes.getColor(23, x())};
            }
            obtainStyledAttributes.recycle();
            if (z() == null) {
                j0 j0Var = new j0();
                j0Var.p(new Function1<j0, Unit>(color, this) { // from class: com.angcyo.tablayout.DslTabBorder$initAttribute$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ int $borderBackgroundColor;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DslTabBorder this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Integer.valueOf(color), this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$borderBackgroundColor = color;
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(j0 j0Var2) {
                        invoke2(j0Var2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(j0 configDrawable) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configDrawable) == null) {
                            Intrinsics.checkNotNullParameter(configDrawable, "$this$configDrawable");
                            configDrawable.H(this.$borderBackgroundColor);
                            configDrawable.F(this.this$0.u());
                        }
                    }
                });
                this.u = j0Var.z();
                M();
            }
        }
    }
}
