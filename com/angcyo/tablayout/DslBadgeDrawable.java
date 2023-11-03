package com.angcyo.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j0;
import com.baidu.tieba.k0;
import com.baidu.tieba.l0;
import com.baidu.tieba.r0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\nH\u0016J\b\u0010X\u001a\u00020\nH\u0016J\u001a\u0010Y\u001a\u00020T2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR$\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020@@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010J\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0006R\u0011\u0010K\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bL\u0010\fR\u0011\u0010M\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bN\u0010\fR\u0011\u0010O\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bP\u0010CR\u0011\u0010Q\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bR\u0010C¨\u0006^"}, d2 = {"Lcom/angcyo/tablayout/DslBadgeDrawable;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "()V", "badgeAutoCircle", "", "getBadgeAutoCircle", "()Z", "setBadgeAutoCircle", "(Z)V", "badgeCircleOffsetX", "", "getBadgeCircleOffsetX", "()I", "setBadgeCircleOffsetX", "(I)V", "badgeCircleOffsetY", "getBadgeCircleOffsetY", "setBadgeCircleOffsetY", "badgeCircleRadius", "getBadgeCircleRadius", "setBadgeCircleRadius", "badgeGravity", "getBadgeGravity", "setBadgeGravity", "badgeMinHeight", "getBadgeMinHeight", "setBadgeMinHeight", "badgeMinWidth", "getBadgeMinWidth", "setBadgeMinWidth", "badgeOffsetX", "getBadgeOffsetX", "setBadgeOffsetX", "badgeOffsetY", "getBadgeOffsetY", "setBadgeOffsetY", "badgePaddingBottom", "getBadgePaddingBottom", "setBadgePaddingBottom", "badgePaddingLeft", "getBadgePaddingLeft", "setBadgePaddingLeft", "badgePaddingRight", "getBadgePaddingRight", "setBadgePaddingRight", "badgePaddingTop", "getBadgePaddingTop", "setBadgePaddingTop", "badgeText", "", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "badgeTextColor", "getBadgeTextColor", "setBadgeTextColor", "badgeTextOffsetX", "getBadgeTextOffsetX", "setBadgeTextOffsetX", "badgeTextOffsetY", "getBadgeTextOffsetY", "setBadgeTextOffsetY", "value", "", "badgeTextSize", "getBadgeTextSize", "()F", "setBadgeTextSize", "(F)V", "dslGravity", "Lcom/angcyo/tablayout/DslGravity;", "getDslGravity", "()Lcom/angcyo/tablayout/DslGravity;", "isCircle", "maxHeight", "getMaxHeight", "maxWidth", "getMaxWidth", "textHeight", "getTextHeight", "textWidth", "getTextWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "initAttribute", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslBadgeDrawable extends j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public final k0 s;
    public int t;
    public int u;
    public String v;
    public float w;
    public boolean x;
    public int y;
    public int z;

    public DslBadgeDrawable() {
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
        this.s = new k0();
        this.t = 17;
        this.u = -1;
        this.w = 12 * r0.h();
        this.x = true;
        this.y = r0.i() * 4;
        this.J = -2;
        this.K = -2;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        int d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (h0()) {
                d0 = this.y * 2;
            } else {
                if (this.x) {
                    String str = this.v;
                    boolean z = true;
                    if ((str == null || str.length() != 1) ? false : false) {
                        d0 = Math.max(e0(), d0());
                    }
                }
                d0 = d0();
            }
            return Math.max(this.J, d0);
        }
        return invokeV.intValue;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        int e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (h0()) {
                e0 = this.y * 2;
            } else {
                if (this.x) {
                    String str = this.v;
                    boolean z = true;
                    if ((str == null || str.length() != 1) ? false : false) {
                        e0 = Math.max(e0(), d0());
                    }
                }
                e0 = e0();
            }
            return Math.max(this.K, e0);
        }
        return invokeV.intValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public final int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.C;
        }
        return invokeV.intValue;
    }

    public final int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public final int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public final int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public final int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public final String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public final int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public final int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
    }

    public final float c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.w;
        }
        return invokeV.floatValue;
    }

    public final int d0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int f0 = (int) f0();
            Drawable z = z();
            if (z != null) {
                i = z.getMinimumHeight();
            } else {
                i = 0;
            }
            return Math.max(f0, i) + this.H + this.I;
        }
        return invokeV.intValue;
    }

    public final int e0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int g0 = (int) g0();
            Drawable z = z();
            if (z != null) {
                i = z.getMinimumWidth();
            } else {
                i = 0;
            }
            return Math.max(g0, i) + this.F + this.G;
        }
        return invokeV.intValue;
    }

    public final float f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return r0.A(f());
        }
        return invokeV.floatValue;
    }

    public final float g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return r0.B(f(), this.v);
        }
        return invokeV.floatValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return TextUtils.isEmpty(this.v);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j0, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(final Canvas canvas) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.v == null) {
                return;
            }
            final k0 k0Var = this.s;
            int i = 5;
            if (m()) {
                int i2 = this.t;
                if (i2 != 3) {
                    if (i2 != 5) {
                        i = i2;
                    } else {
                        i = 3;
                    }
                }
            } else {
                i = this.t;
            }
            k0Var.g(i);
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
            k0Var.h(bounds);
            if (h0()) {
                k0Var.i(this.z);
                k0Var.j(this.A);
            } else {
                k0Var.i(this.B);
                k0Var.j(this.C);
            }
            final float B = r0.B(f(), this.v);
            final float A = r0.A(f());
            if (h0()) {
                f = this.y;
            } else {
                f = this.H + A + this.I;
                int i3 = this.J;
                if (i3 > 0) {
                    f = Math.max(f, i3);
                }
            }
            final float f3 = f;
            if (h0()) {
                f2 = this.y;
            } else {
                f2 = this.F + B + this.G;
                int i4 = this.K;
                if (i4 == -1) {
                    f2 = Math.max(f2, f3);
                } else if (i4 > 0) {
                    f2 = Math.max(f2, i4);
                }
            }
            final float f4 = f2;
            k0Var.a(f4, f3, new Function2<Integer, Integer, Unit>(this, k0Var, canvas, B, A, f4, f3) { // from class: com.angcyo.tablayout.DslBadgeDrawable$draw$1$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Canvas $canvas;
                public final /* synthetic */ float $drawHeight;
                public final /* synthetic */ float $drawWidth;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float $textHeight;
                public final /* synthetic */ float $textWidth;
                public final /* synthetic */ k0 $this_with;
                public final /* synthetic */ DslBadgeDrawable this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, k0Var, canvas, Float.valueOf(B), Float.valueOf(A), Float.valueOf(f4), Float.valueOf(f3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$this_with = k0Var;
                    this.$canvas = canvas;
                    this.$textWidth = B;
                    this.$textHeight = A;
                    this.$drawWidth = f4;
                    this.$drawHeight = f3;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i5, int i6) {
                    float d;
                    float e;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i5, i6) == null) {
                        if (this.this$0.h0()) {
                            this.this$0.f().setColor(this.this$0.w());
                            if (l0.a(this.$this_with.b())) {
                                d = i5;
                                e = i6;
                            } else {
                                d = i5 + this.$this_with.d();
                                e = i6 + this.$this_with.e();
                            }
                            this.this$0.f().setColor(this.this$0.w());
                            this.$canvas.drawCircle(d, e, this.this$0.Q(), this.this$0.f());
                            if (this.this$0.y() > 0 && this.this$0.x() != 0) {
                                float strokeWidth = this.this$0.f().getStrokeWidth();
                                Paint.Style style = this.this$0.f().getStyle();
                                this.this$0.f().setColor(this.this$0.x());
                                this.this$0.f().setStrokeWidth(this.this$0.y());
                                this.this$0.f().setStyle(Paint.Style.STROKE);
                                this.$canvas.drawCircle(d, e, this.this$0.Q(), this.this$0.f());
                                this.this$0.f().setStrokeWidth(strokeWidth);
                                this.this$0.f().setStyle(style);
                                return;
                            }
                            return;
                        }
                        this.this$0.f().setColor(this.this$0.Z());
                        float f5 = i5;
                        float f6 = 2;
                        float f7 = f5 - (this.$textWidth / f6);
                        float f8 = i6;
                        float f9 = (this.$textHeight / f6) + f8;
                        int c = this.$this_with.c();
                        int f10 = this.$this_with.f();
                        if (this.this$0.N()) {
                            String Y = this.this$0.Y();
                            boolean z = true;
                            if ((Y == null || Y.length() != 1) ? false : false) {
                                if (this.this$0.w() != 0) {
                                    this.this$0.f().setColor(this.this$0.w());
                                    this.$canvas.drawCircle(f5, f8, Math.max(this.this$0.e0(), this.this$0.d0()) / f6, this.this$0.f());
                                }
                                this.this$0.f().setColor(this.this$0.Z());
                                Canvas canvas2 = this.$canvas;
                                String Y2 = this.this$0.Y();
                                Intrinsics.checkNotNull(Y2);
                                canvas2.drawText(Y2, f7 + this.this$0.a0(), (f9 - this.this$0.f().descent()) + this.this$0.b0(), this.this$0.f());
                            }
                        }
                        Drawable z2 = this.this$0.z();
                        if (z2 != null) {
                            float f11 = this.$drawWidth;
                            float f12 = this.$drawHeight;
                            Canvas canvas3 = this.$canvas;
                            z2.setBounds(c, f10, (int) (c + f11), (int) (f10 + f12));
                            z2.draw(canvas3);
                        }
                        this.this$0.f().setColor(this.this$0.Z());
                        Canvas canvas22 = this.$canvas;
                        String Y22 = this.this$0.Y();
                        Intrinsics.checkNotNull(Y22);
                        canvas22.drawText(Y22, f7 + this.this$0.a0(), (f9 - this.this$0.f().descent()) + this.this$0.b0(), this.this$0.f());
                    }
                }
            });
        }
    }

    public final void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.z = i;
        }
    }

    public final void j0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.A = i;
        }
    }

    public final void k0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.y = i;
        }
    }

    public final void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.t = i;
        }
    }

    public final void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.J = i;
        }
    }

    public final void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.K = i;
        }
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.B = i;
        }
    }

    public final void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.C = i;
        }
    }

    public final void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.I = i;
        }
    }

    public final void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.F = i;
        }
    }

    public final void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.G = i;
        }
    }

    public final void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.H = i;
        }
    }

    public final void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.v = str;
        }
    }

    public final void v0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.u = i;
        }
    }

    public final void w0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f) == null) {
            this.w = f;
            f().setTextSize(this.w);
        }
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.k(context, attributeSet);
            M();
        }
    }
}
