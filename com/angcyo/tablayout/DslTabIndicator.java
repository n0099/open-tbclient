package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.angcyo.tablayout.DslTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.j0;
import com.baidu.tieba.q0;
import com.baidu.tieba.r0;
import com.baidu.tieba.ve7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016J\u000e\u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ>\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJF\u0010c\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJF\u0010e\u001a\u00020X2\u0006\u0010]\u001a\u00020#2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010b\u001a\u00020MJ\u000e\u0010g\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\u0010\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010m\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010n\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010o\u001a\u00020\u00062\u0006\u0010i\u001a\u00020jH\u0016J\u001a\u0010p\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00062\b\b\u0002\u0010q\u001a\u00020\u0006H\u0016J\u001a\u0010r\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00062\b\b\u0002\u0010q\u001a\u00020\u0006H\u0016J\u0010\u0010s\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0012\u0010u\u001a\u0004\u0018\u00010j2\u0006\u0010i\u001a\u00020jH\u0016J\u001a\u0010v\u001a\u00020X2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016JK\u0010{\u001a\u00020X2\u0006\u0010V\u001a\u00020\u000629\u0010|\u001a5\u0012\u0013\u0012\u00110j¢\u0006\f\b~\u0012\b\b\u007f\u0012\u0004\b\b(i\u0012\u0016\u0012\u0014\u0018\u00010j¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u00020X0}H\u0016J\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0083\u0001\u001a\u00020\u0006H\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\fR(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\fR\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\fR\u001a\u00108\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\fR\u001a\u0010;\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\b\"\u0004\b=\u0010\fR\u001a\u0010>\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\fR\u001a\u0010A\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010\fR\u001a\u0010D\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010\fR\u001a\u0010G\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010\fR\u001a\u0010J\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\fR$\u0010N\u001a\u00020M2\u0006\u0010\u0019\u001a\u00020M@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0087\u0001"}, d2 = {"Lcom/angcyo/tablayout/DslTabIndicator;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "tabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "(Lcom/angcyo/tablayout/DslTabLayout;)V", "_indicatorDrawStyle", "", "get_indicatorDrawStyle", "()I", "_targetIndex", "get_targetIndex", "set_targetIndex", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "ignoreChildPadding", "", "getIgnoreChildPadding", "()Z", "setIgnoreChildPadding", "(Z)V", "indicatorAnim", "getIndicatorAnim", "setIndicatorAnim", "value", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "Landroid/graphics/drawable/Drawable;", "indicatorDrawable", "getIndicatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setIndicatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "indicatorEnableFlash", "getIndicatorEnableFlash", "setIndicatorEnableFlash", "indicatorEnableFlashClip", "getIndicatorEnableFlashClip", "setIndicatorEnableFlashClip", "indicatorEnableFlow", "getIndicatorEnableFlow", "setIndicatorEnableFlow", "indicatorFlowStep", "getIndicatorFlowStep", "setIndicatorFlowStep", "indicatorGravity", "getIndicatorGravity", "setIndicatorGravity", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorHeightOffset", "getIndicatorHeightOffset", "setIndicatorHeightOffset", "indicatorStyle", "getIndicatorStyle", "setIndicatorStyle", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "indicatorWidthOffset", "getIndicatorWidthOffset", "setIndicatorWidthOffset", "indicatorXOffset", "getIndicatorXOffset", "setIndicatorXOffset", "indicatorYOffset", "getIndicatorYOffset", "setIndicatorYOffset", "", "positionOffset", "getPositionOffset", "()F", "setPositionOffset", "(F)V", "getTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "_childConvexHeight", "index", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawHorizontal", "drawIndicator", NativeConstants.TYPE_INDICATOR, "l", "t", "r", "b", "offset", "drawIndicatorClipHorizontal", "endWidth", "drawIndicatorClipVertical", "endHeight", "drawVertical", "getChildTargetHeight", "childView", "Landroid/view/View;", "getChildTargetPaddingBottom", "getChildTargetPaddingLeft", "getChildTargetPaddingRight", "getChildTargetPaddingTop", "getChildTargetWidth", "getChildTargetX", NotificationCompat.WearableExtender.KEY_GRAVITY, "getChildTargetY", "getIndicatorDrawHeight", "getIndicatorDrawWidth", "indicatorContentView", "initAttribute", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "targetChildView", "onChildView", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "contentChildView", "tintDrawableColor", ResourceManager.DRAWABLE, "color", "updateOriginDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslTabIndicator extends j0 {
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
    public boolean J;
    public boolean K;
    public float L;
    public int M;
    public int N;
    public final DslTabLayout s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public Drawable z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1085465482, "Lcom/angcyo/tablayout/DslTabIndicator;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1085465482, "Lcom/angcyo/tablayout/DslTabIndicator;");
        }
    }

    public DslTabIndicator(DslTabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.s = tabLayout;
        this.u = 4;
        this.x = true;
        this.y = 1;
        this.A = -2;
        this.H = -1;
        this.I = -1;
        this.J = true;
        this.K = true;
        setCallback(tabLayout);
        this.M = -1;
        this.N = -1;
    }

    public int g0(int i) {
        InterceptResult invokeI;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            int i2 = this.D;
            if (i2 != -2) {
                if (i2 == -1 && (view2 = (View) CollectionsKt___CollectionsKt.getOrNull(this.s.getDslSelector().g(), i)) != null) {
                    i2 = view2.getMeasuredHeight();
                }
            } else {
                View view3 = (View) CollectionsKt___CollectionsKt.getOrNull(this.s.getDslSelector().g(), i);
                if (view3 != null) {
                    View n0 = n0(view3);
                    if (n0 != null) {
                        view3 = n0;
                    }
                    i2 = T(view3);
                }
            }
            return i2 + this.E;
        }
        return invokeI.intValue;
    }

    public int h0(int i) {
        InterceptResult invokeI;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            int i2 = this.B;
            if (i2 != -2) {
                if (i2 == -1 && (view2 = (View) CollectionsKt___CollectionsKt.getOrNull(this.s.getDslSelector().g(), i)) != null) {
                    i2 = view2.getMeasuredWidth();
                }
            } else {
                View view3 = (View) CollectionsKt___CollectionsKt.getOrNull(this.s.getDslSelector().g(), i);
                if (view3 != null) {
                    View n0 = n0(view3);
                    if (n0 != null) {
                        view3 = n0;
                    }
                    i2 = W(view3);
                }
            }
            return i2 + this.C;
        }
        return invokeI.intValue;
    }

    public static /* synthetic */ int Y(DslTabIndicator dslTabIndicator, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = dslTabIndicator.u;
            }
            return dslTabIndicator.X(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChildTargetX");
    }

    public static /* synthetic */ int a0(DslTabIndicator dslTabIndicator, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = dslTabIndicator.u;
            }
            return dslTabIndicator.Z(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChildTargetY");
    }

    @Override // com.baidu.tieba.j0
    public GradientDrawable M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GradientDrawable M = super.M();
            q0(z());
            return M;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.M;
        }
        return invokeV.intValue;
    }

    public final boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    public final int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public final int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public final int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public final int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public final int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public final float k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.L;
        }
        return invokeV.floatValue;
    }

    public final int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return r0.y(this.t, 4096);
        }
        return invokeV.intValue;
    }

    public final int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.N;
        }
        return invokeV.intValue;
    }

    public final int N(int i) {
        InterceptResult invokeI;
        DslTabLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (a() instanceof ViewGroup) {
                View a = a();
                if (a != null) {
                    ViewGroup.LayoutParams layoutParams2 = ((ViewGroup) a).getChildAt(i).getLayoutParams();
                    if (layoutParams2 instanceof DslTabLayout.LayoutParams) {
                        layoutParams = (DslTabLayout.LayoutParams) layoutParams2;
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams != null) {
                        return layoutParams.h();
                    }
                    return 0;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.j0, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (isVisible() && l0() != 0 && this.z != null) {
                if (this.s.k()) {
                    O(canvas);
                } else {
                    S(canvas);
                }
            }
        }
    }

    public final void O(Canvas canvas) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        Drawable drawable;
        int i7;
        int i8;
        float f;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int size = this.s.getDslSelector().g().size();
            int i14 = this.M;
            int i15 = this.N;
            if (i15 >= 0 && i15 < size) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i14 = Math.max(0, i14);
            }
            if (i14 >= 0 && i14 < size) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
            int Y = Y(this, i14, 0, 2, null);
            int h0 = h0(i14);
            int g0 = g0(i14);
            int i16 = (Y - (h0 / 2)) + this.F;
            int Y2 = Y(this, this.N, 0, 2, null);
            int h02 = h0(this.N);
            int i17 = (Y2 - (h02 / 2)) + this.F;
            int i18 = this.N;
            if (i18 >= 0 && i18 < size) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && (i7 = this.N) != i14) {
                int g02 = g0(i7);
                if (this.w) {
                    float f2 = this.L;
                    i9 = (int) (h0 * (1 - f2));
                    i10 = (int) (h02 * f2);
                    i3 = (Y - (i9 / 2)) + this.F;
                    i8 = g02;
                    i = size;
                } else {
                    if (this.v && Math.abs(this.N - i14) <= this.y) {
                        if (this.N > i14) {
                            int i19 = i17 - i16;
                            i11 = i19 + h02;
                            float f3 = this.L;
                            i8 = g02;
                            if (f3 >= 0.5d) {
                                i = size;
                                i12 = (int) (i16 + ((i19 * (f3 - 0.5d)) / 0.5f));
                            } else {
                                i = size;
                                i12 = i16;
                            }
                        } else {
                            i8 = g02;
                            i = size;
                            int i20 = i16 - i17;
                            i11 = i20 + h0;
                            float f4 = this.L;
                            if (f4 >= 0.5d) {
                                i12 = i17;
                            } else {
                                i12 = (int) (i16 - ((i20 * f4) / 0.5f));
                            }
                        }
                        i3 = i12;
                        int i21 = i11;
                        float f5 = this.L;
                        if (f5 >= 0.5d) {
                            i13 = (int) (i21 - (((i21 - h02) * (f5 - 0.5d)) / 0.5f));
                        } else {
                            i13 = (int) (h0 + (((i21 - h0) * f5) / 0.5f));
                        }
                        i9 = i13;
                    } else {
                        i8 = g02;
                        i = size;
                        if (this.N > i14) {
                            f = i16 + ((i17 - i16) * this.L);
                        } else {
                            f = i16 - ((i16 - i17) * this.L);
                        }
                        i3 = (int) f;
                        i9 = (int) (h0 + ((h02 - h0) * this.L));
                    }
                    i10 = h02;
                }
                i5 = (int) ((i8 - g0) * this.L);
                i4 = i10;
                i2 = i9;
            } else {
                i = size;
                i2 = h0;
                i3 = i16;
                i4 = h02;
                i5 = 0;
            }
            int l0 = l0();
            if (l0 != 1) {
                if (l0 != 2) {
                    i6 = ((((e() + (g() / 2)) - (g0 / 2)) + this.G) - i5) + ((this.s.get_maxConvexHeight() - N(i14)) / 2);
                } else {
                    i6 = (i() - g0) - this.G;
                }
                z4 = false;
            } else {
                z4 = false;
                i6 = this.G + 0;
            }
            Drawable drawable2 = this.z;
            if (drawable2 != null) {
                if (this.w) {
                    if (this.x) {
                        drawable = drawable2;
                        Q(drawable2, canvas, i16, i6, i16 + h0, i6 + g0 + i5, i2, 1 - this.L);
                    } else {
                        drawable = drawable2;
                        P(drawable, canvas, i3, i6, i3 + i2, i6 + g0 + i5, 1 - this.L);
                    }
                    int i22 = this.N;
                    if (i22 >= 0 && i22 < i) {
                        z4 = true;
                    }
                    if (z4) {
                        if (this.x) {
                            Q(drawable, canvas, i17, i6, i17 + h02, g0 + i6 + i5, i4, this.L);
                            return;
                        } else {
                            P(drawable, canvas, i17, i6, i17 + i4, g0 + i6 + i5, this.L);
                            return;
                        }
                    }
                    return;
                }
                P(drawable2, canvas, i3, i6, i3 + i2, g0 + i6 + i5, 1 - this.L);
            }
        }
    }

    public final void S(Canvas canvas) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        Drawable drawable;
        int i7;
        float f;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int size = this.s.getDslSelector().g().size();
            int i15 = this.M;
            int i16 = this.N;
            if (i16 >= 0 && i16 < size) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i15 = Math.max(0, i15);
            }
            if (i15 >= 0 && i15 < size) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
            int a0 = a0(this, i15, 0, 2, null);
            int h0 = h0(i15);
            int g0 = g0(i15);
            int i17 = (a0 - (g0 / 2)) + this.G;
            int a02 = a0(this, this.N, 0, 2, null);
            int g02 = g0(this.N);
            int i18 = (a02 - (g02 / 2)) + this.G;
            int i19 = this.N;
            if (i19 >= 0 && i19 < size) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && (i7 = this.N) != i15) {
                int h02 = h0(i7);
                if (this.w) {
                    float f2 = this.L;
                    i = (int) (g0 * (1 - f2));
                    i9 = (int) (g02 * f2);
                    int i20 = this.F;
                    i8 = (a0 - (i / 2)) + i20;
                    i10 = (a02 - (i9 / 2)) + i20;
                } else {
                    if (this.v && Math.abs(this.N - i15) <= this.y) {
                        if (this.N > i15) {
                            int i21 = i18 - i17;
                            int i22 = i21 + g02;
                            float f3 = this.L;
                            if (f3 >= 0.5d) {
                                i11 = g0;
                                i14 = (int) (i17 + ((i21 * (f3 - 0.5d)) / 0.5f));
                            } else {
                                i11 = g0;
                                i14 = i17;
                            }
                            i8 = i14;
                            i12 = i22;
                        } else {
                            i11 = g0;
                            int i23 = i17 - i18;
                            i12 = i23 + i11;
                            float f4 = this.L;
                            if (f4 >= 0.5d) {
                                i13 = i18;
                            } else {
                                i13 = (int) (i17 - ((i23 * f4) / 0.5f));
                            }
                            i8 = i13;
                        }
                        float f5 = this.L;
                        if (f5 >= 0.5d) {
                            i = (int) (i12 - (((i12 - g02) * (f5 - 0.5d)) / 0.5f));
                            g0 = i11;
                        } else {
                            g0 = i11;
                            i = (int) (g0 + (((i12 - g0) * f5) / 0.5f));
                        }
                    } else {
                        if (this.N > i15) {
                            f = i17 + ((i18 - i17) * this.L);
                        } else {
                            f = i17 - ((i17 - i18) * this.L);
                        }
                        i8 = (int) f;
                        i = (int) (g0 + ((g02 - g0) * this.L));
                    }
                    i9 = g02;
                    i10 = i18;
                }
                i5 = (int) ((h02 - h0) * this.L);
                i4 = i10;
                i2 = i8;
                i3 = i9;
            } else {
                i = g0;
                i2 = i17;
                i3 = g02;
                i4 = i18;
                i5 = 0;
            }
            int l0 = l0();
            if (l0 != 1) {
                if (l0 != 2) {
                    i6 = ((c() + this.F) + ((h() / 2) - (h0 / 2))) - ((this.s.get_maxConvexHeight() - N(i15)) / 2);
                } else {
                    i6 = (j() - h0) - this.F;
                }
                z4 = false;
            } else {
                z4 = false;
                i6 = this.F + 0;
            }
            Drawable drawable2 = this.z;
            if (drawable2 != null) {
                if (this.w) {
                    if (this.x) {
                        drawable = drawable2;
                        R(drawable2, canvas, i6, i17, i6 + h0 + i5, i17 + g0, i, 1 - this.L);
                    } else {
                        drawable = drawable2;
                        P(drawable, canvas, i6, i2, i6 + h0 + i5, i + i2, 1 - this.L);
                    }
                    int i24 = this.N;
                    if (i24 >= 0 && i24 < size) {
                        z4 = true;
                    }
                    if (z4) {
                        if (this.x) {
                            R(drawable, canvas, i6, i18, i6 + h0 + i5, i18 + g02, i3, this.L);
                            return;
                        } else {
                            P(drawable, canvas, i6, i4, i6 + h0 + i5, i4 + i3, this.L);
                            return;
                        }
                    }
                    return;
                }
                P(drawable2, canvas, i6, i2, i6 + h0 + i5, i + i2, 1 - this.L);
            }
        }
    }

    public final void P(Drawable indicator, Canvas canvas, int i, int i2, int i3, int i4, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{indicator, canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (indicator instanceof q0) {
                indicator.setBounds(i, i2, i3, i4);
                ((q0) indicator).a(this, canvas, f);
                return;
            }
            indicator.setBounds(0, 0, i3 - i, i4 - i2);
            int save = canvas.save();
            try {
                canvas.translate(i, i2);
                indicator.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    public final void Q(Drawable indicator, Canvas canvas, int i, int i2, int i3, int i4, int i5, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{indicator, canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.save();
            int i6 = ((i3 - i) - i5) / 2;
            canvas.clipRect(i + i6, i2, i3 - i6, i4);
            indicator.setBounds(i, i2, i3, i4);
            if (indicator instanceof q0) {
                ((q0) indicator).a(this, canvas, f);
            } else {
                indicator.draw(canvas);
            }
            canvas.restore();
        }
    }

    public final void R(Drawable indicator, Canvas canvas, int i, int i2, int i3, int i4, int i5, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{indicator, canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(indicator, "indicator");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.save();
            int i6 = ((i4 - i2) - i5) / 2;
            canvas.clipRect(i, i2 + i6, i3, i4 - i6);
            indicator.setBounds(i, i2, i3, i4);
            if (indicator instanceof q0) {
                ((q0) indicator).a(this, canvas, f);
            } else {
                indicator.draw(canvas);
            }
            canvas.restore();
        }
    }

    public int T(View childView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, childView)) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            if (this.K) {
                return r0.o(childView);
            }
            return childView.getMeasuredHeight();
        }
        return invokeL.intValue;
    }

    public int U(View childView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, childView)) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            if (this.K) {
                return childView.getPaddingLeft();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int V(View childView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, childView)) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            if (this.K) {
                return childView.getPaddingTop();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int W(View childView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, childView)) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            if (this.K) {
                return r0.p(childView);
            }
            return childView.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.M = i;
        }
    }

    public final void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.A = i;
            q0(this.z);
        }
    }

    public final void q0(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, drawable) == null) {
            this.z = u0(drawable, this.A);
        }
    }

    public final void r0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f) == null) {
            this.L = f;
            invalidateSelf();
        }
    }

    public final void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.N = i;
        }
    }

    public int X(int i, final int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            if (i > 0) {
                i3 = this.s.getMaxWidth();
            } else {
                i3 = 0;
            }
            intRef.element = i3;
            t0(i, new Function2<View, View, Unit>(intRef, i2, this) { // from class: com.angcyo.tablayout.DslTabIndicator$getChildTargetX$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $gravity;
                public final /* synthetic */ Ref.IntRef $result;
                public final /* synthetic */ DslTabIndicator this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intRef, Integer.valueOf(i2), this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$result = intRef;
                    this.$gravity = i2;
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view2, View view3) {
                    invoke2(view2, view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View childView, View view2) {
                    int left;
                    int left2;
                    int i4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, childView, view2) == null) {
                        Intrinsics.checkNotNullParameter(childView, "childView");
                        Ref.IntRef intRef2 = this.$result;
                        if (view2 == null) {
                            int i5 = this.$gravity;
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    i4 = childView.getLeft() + this.this$0.U(childView) + (this.this$0.W(childView) / 2);
                                } else {
                                    i4 = childView.getRight();
                                }
                            } else {
                                i4 = childView.getLeft();
                            }
                        } else {
                            int i6 = this.$gravity;
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    left = childView.getLeft() + view2.getLeft() + this.this$0.U(view2);
                                    left2 = this.this$0.W(view2) / 2;
                                } else {
                                    left = childView.getLeft();
                                    left2 = view2.getRight();
                                }
                            } else {
                                left = childView.getLeft();
                                left2 = view2.getLeft();
                            }
                            i4 = left2 + left;
                        }
                        intRef2.element = i4;
                    }
                }
            });
            return intRef.element;
        }
        return invokeII.intValue;
    }

    public int Z(int i, final int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            if (i > 0) {
                i3 = this.s.getMaxHeight();
            } else {
                i3 = 0;
            }
            intRef.element = i3;
            t0(i, new Function2<View, View, Unit>(intRef, i2, this) { // from class: com.angcyo.tablayout.DslTabIndicator$getChildTargetY$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $gravity;
                public final /* synthetic */ Ref.IntRef $result;
                public final /* synthetic */ DslTabIndicator this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intRef, Integer.valueOf(i2), this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$result = intRef;
                    this.$gravity = i2;
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view2, View view3) {
                    invoke2(view2, view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View childView, View view2) {
                    int top;
                    int top2;
                    int i4;
                    int top3;
                    int bottom;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, childView, view2) == null) {
                        Intrinsics.checkNotNullParameter(childView, "childView");
                        Ref.IntRef intRef2 = this.$result;
                        if (view2 == null) {
                            int i5 = this.$gravity;
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    top3 = childView.getTop() + this.this$0.V(childView);
                                    bottom = this.this$0.T(childView) / 2;
                                    i4 = top3 + bottom;
                                } else {
                                    i4 = childView.getBottom();
                                }
                            } else {
                                i4 = childView.getTop();
                            }
                            intRef2.element = i4;
                        }
                        int i6 = this.$gravity;
                        if (i6 != 1) {
                            if (i6 != 2) {
                                top = childView.getTop() + view2.getTop() + this.this$0.V(view2);
                                top2 = this.this$0.T(view2) / 2;
                            } else {
                                top3 = childView.getTop();
                                bottom = childView.getBottom();
                                i4 = top3 + bottom;
                                intRef2.element = i4;
                            }
                        } else {
                            top = childView.getTop();
                            top2 = view2.getTop();
                        }
                        i4 = top2 + top;
                        intRef2.element = i4;
                    }
                }
            });
            return intRef.element;
        }
        return invokeII.intValue;
    }

    public void t0(int i, Function2<? super View, ? super View, Unit> onChildView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i, onChildView) == null) {
            Intrinsics.checkNotNullParameter(onChildView, "onChildView");
            View view2 = (View) CollectionsKt___CollectionsKt.getOrNull(this.s.getDslSelector().g(), i);
            if (view2 != null) {
                onChildView.invoke(view2, n0(view2));
            }
        }
    }

    public Drawable u0(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, drawable, i)) == null) {
            if (drawable != null && i != -2) {
                return r0.C(drawable, i);
            }
            return drawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        int i;
        boolean z;
        int[] n;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ve7.DslTabLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.DslTabLayout)");
            q0(obtainStyledAttributes.getDrawable(77));
            p0(obtainStyledAttributes.getColor(72, this.A));
            if (this.s.k()) {
                i = 2;
            } else {
                i = 1;
            }
            this.t = obtainStyledAttributes.getInt(95, i);
            this.u = obtainStyledAttributes.getInt(85, this.u);
            int i5 = -1;
            if (r0.s(this.t, 4096)) {
                if (this.s.k()) {
                    i2 = -1;
                } else {
                    i2 = r0.i() * 3;
                }
                this.B = obtainStyledAttributes.getLayoutDimension(96, i2);
                if (this.s.k()) {
                    i5 = r0.i() * 3;
                }
                this.D = obtainStyledAttributes.getLayoutDimension(86, i5);
                if (this.s.k()) {
                    i3 = 0;
                } else {
                    i3 = r0.i() * 2;
                }
                this.F = obtainStyledAttributes.getDimensionPixelOffset(98, i3);
                if (this.s.k()) {
                    i4 = r0.i() * 2;
                } else {
                    i4 = 0;
                }
                this.G = obtainStyledAttributes.getDimensionPixelOffset(99, i4);
            } else {
                if (this.s.k()) {
                    this.B = -1;
                    this.D = -1;
                } else {
                    this.D = -1;
                    this.B = -1;
                }
                this.B = obtainStyledAttributes.getLayoutDimension(96, this.B);
                this.D = obtainStyledAttributes.getLayoutDimension(86, this.D);
                this.F = obtainStyledAttributes.getDimensionPixelOffset(98, this.F);
                this.G = obtainStyledAttributes.getDimensionPixelOffset(99, this.G);
            }
            this.K = obtainStyledAttributes.getBoolean(88, !r0.s(this.t, 4));
            this.y = obtainStyledAttributes.getInt(81, this.y);
            this.v = obtainStyledAttributes.getBoolean(80, this.v);
            this.w = obtainStyledAttributes.getBoolean(78, this.w);
            this.x = obtainStyledAttributes.getBoolean(79, this.x);
            this.C = obtainStyledAttributes.getDimensionPixelOffset(97, this.C);
            this.E = obtainStyledAttributes.getDimensionPixelOffset(87, this.E);
            this.H = obtainStyledAttributes.getInt(74, this.H);
            this.I = obtainStyledAttributes.getResourceId(73, this.I);
            this.J = obtainStyledAttributes.getBoolean(71, this.J);
            G(obtainStyledAttributes.getInt(91, v()));
            H(obtainStyledAttributes.getColor(92, w()));
            I(obtainStyledAttributes.getColor(93, x()));
            J(obtainStyledAttributes.getDimensionPixelOffset(94, y()));
            D(obtainStyledAttributes.getDimensionPixelOffset(76, (int) t()));
            C(obtainStyledAttributes.getDimensionPixelOffset(75, (int) s()));
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(90, 0);
            if (dimensionPixelOffset > 0) {
                Arrays.fill(u(), dimensionPixelOffset);
            } else {
                String string = obtainStyledAttributes.getString(89);
                if (string != null) {
                    o(u(), string);
                }
            }
            String string2 = obtainStyledAttributes.getString(82);
            if (string2 != null && string2.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                int color = obtainStyledAttributes.getColor(84, 0);
                int color2 = obtainStyledAttributes.getColor(83, 0);
                n = color != color2 ? new int[]{color, color2} : r();
            } else {
                n = n(string2);
                if (n == null) {
                    n = r();
                }
            }
            B(n);
            obtainStyledAttributes.recycle();
            if (this.z == null && A()) {
                M();
            }
        }
    }

    public View n0(View childView) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, childView)) == null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            ViewGroup.LayoutParams layoutParams = childView.getLayoutParams();
            if (layoutParams != null) {
                DslTabLayout.LayoutParams layoutParams2 = (DslTabLayout.LayoutParams) layoutParams;
                if (layoutParams2.f() != -1) {
                    i = layoutParams2.f();
                } else {
                    i = this.I;
                }
                if (i != -1) {
                    return childView.findViewById(i);
                }
                if (layoutParams2.g() >= 0) {
                    i2 = layoutParams2.g();
                } else {
                    i2 = this.H;
                }
                if (i2 >= 0 && (childView instanceof ViewGroup)) {
                    boolean z = false;
                    if (i2 >= 0 && i2 < ((ViewGroup) childView).getChildCount()) {
                        z = true;
                    }
                    if (z) {
                        return ((ViewGroup) childView).getChildAt(i2);
                    }
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        }
        return (View) invokeL.objValue;
    }
}
