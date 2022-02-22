package com.baidu.poly.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.i0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SwitchButton extends CompoundButton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ANIMATION_DURATION = 250;
    public static final int DEFAULT_THUMB_MARGIN_DP = 2;
    public static final float DEFAULT_THUMB_RANGE_RATIO = 1.8f;
    public static final int DEFAULT_THUMB_SIZE_DP = 20;
    public static final int DEFAULT_TINT_COLOR = 3309506;
    public static int[] k0;
    public static int[] q0;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF A;
    public RectF B;
    public RectF C;
    public RectF D;
    public RectF E;
    public Paint F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ObjectAnimator J;
    public float K;
    public RectF L;
    public float M;
    public float N;
    public float O;
    public int P;
    public int Q;
    public Paint R;
    public CharSequence S;
    public CharSequence T;
    public TextPaint U;
    public Layout V;
    public Layout W;
    public float a0;
    public float b0;
    public int c0;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f38076e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f38077f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f38078g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f38079h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public float f38080i;
    public CompoundButton.OnCheckedChangeListener i0;

    /* renamed from: j  reason: collision with root package name */
    public float f38081j;
    public RectF k;
    public float l;
    public long m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public Drawable y;
    public Drawable z;

    /* loaded from: classes11.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence offText;
        public CharSequence onText;

        /* loaded from: classes11.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(994689609, "Lcom/baidu/poly/widget/SwitchButton$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(994689609, "Lcom/baidu/poly/widget/SwitchButton$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                TextUtils.writeToParcel(this.onText, parcel, i2);
                TextUtils.writeToParcel(this.offText, parcel, i2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.onText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.offText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1831624737, "Lcom/baidu/poly/widget/SwitchButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1831624737, "Lcom/baidu/poly/widget/SwitchButton;");
                return;
            }
        }
        k0 = new int[]{16842912, 16842910, 16842919};
        q0 = new int[]{-16842912, 16842910, 16842919};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.I = false;
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        c(attributeSet);
    }

    private float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.K : invokeV.floatValue;
    }

    private boolean getStatusBasedOnPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? getProgress() > 0.5f : invokeV.booleanValue;
    }

    private void setDrawableState(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setState(getDrawableState());
        invalidate();
    }

    private void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65543, this, f2) == null) {
            if (f2 > 1.0f) {
                f2 = 1.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            this.K = f2;
            invalidate();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.h0 = true;
        }
    }

    public void animateToState(boolean z) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (objectAnimator = this.J) == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.J.cancel();
        }
        this.J.setDuration(this.m);
        if (z) {
            this.J.setFloatValues(this.K, 1.0f);
        } else {
            this.J.setFloatValues(this.K, 0.0f);
        }
        this.J.start();
    }

    public final int b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) Math.ceil(d2) : invokeCommon.intValue;
    }

    public final void c(AttributeSet attributeSet) {
        String str;
        ColorStateList colorStateList;
        float f2;
        int i2;
        int i3;
        int i4;
        String str2;
        int i5;
        Drawable drawable;
        float f3;
        float f4;
        Drawable drawable2;
        ColorStateList colorStateList2;
        float f5;
        boolean z;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        int i6;
        float f11;
        float f12;
        TypedArray obtainStyledAttributes;
        ColorStateList colorStateList3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
            this.P = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.Q = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
            this.F = new Paint(1);
            Paint paint = new Paint(1);
            this.R = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.R.setStrokeWidth(getResources().getDisplayMetrics().density);
            this.U = getPaint();
            this.A = new RectF();
            this.B = new RectF();
            this.C = new RectF();
            this.k = new RectF();
            this.D = new RectF();
            this.E = new RectF();
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
            this.J = duration;
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.L = new RectF();
            float f13 = getResources().getDisplayMetrics().density * 2.0f;
            TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, k.SwitchButton);
            if (obtainStyledAttributes2 != null) {
                Drawable drawable3 = obtainStyledAttributes2.getDrawable(k.SwitchButton_kswThumbDrawable);
                ColorStateList colorStateList4 = obtainStyledAttributes2.getColorStateList(k.SwitchButton_kswThumbColor);
                float dimension = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbMargin, f13);
                float dimension2 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbMarginLeft, dimension);
                float dimension3 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbMarginRight, dimension);
                float dimension4 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbMarginTop, dimension);
                float dimension5 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbMarginBottom, dimension);
                float dimension6 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbWidth, 0.0f);
                float dimension7 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbHeight, 0.0f);
                float dimension8 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswThumbRadius, -1.0f);
                float dimension9 = obtainStyledAttributes2.getDimension(k.SwitchButton_kswBackRadius, -1.0f);
                Drawable drawable4 = obtainStyledAttributes2.getDrawable(k.SwitchButton_kswBackDrawable);
                ColorStateList colorStateList5 = obtainStyledAttributes2.getColorStateList(k.SwitchButton_kswBackColor);
                float f14 = obtainStyledAttributes2.getFloat(k.SwitchButton_kswThumbRangeRatio, 1.8f);
                int integer = obtainStyledAttributes2.getInteger(k.SwitchButton_kswAnimationDuration, 250);
                boolean z2 = obtainStyledAttributes2.getBoolean(k.SwitchButton_kswFadeBack, true);
                int color = obtainStyledAttributes2.getColor(k.SwitchButton_kswTintColor, 0);
                String string = obtainStyledAttributes2.getString(k.SwitchButton_kswTextOn);
                String string2 = obtainStyledAttributes2.getString(k.SwitchButton_kswTextOff);
                int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(k.SwitchButton_kswTextThumbInset, 0);
                int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(k.SwitchButton_kswTextExtra, 0);
                int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(k.SwitchButton_kswTextAdjust, 0);
                obtainStyledAttributes2.recycle();
                colorStateList = colorStateList4;
                i6 = integer;
                z = z2;
                i3 = dimensionPixelSize2;
                f8 = f14;
                drawable2 = drawable3;
                drawable = drawable4;
                f4 = dimension4;
                f7 = dimension8;
                str2 = string;
                i2 = dimensionPixelSize3;
                str = string2;
                f10 = dimension2;
                colorStateList2 = colorStateList5;
                f3 = dimension6;
                f2 = dimension3;
                f5 = dimension7;
                i5 = color;
                f9 = dimension5;
                f6 = dimension9;
                i4 = dimensionPixelSize;
            } else {
                str = null;
                colorStateList = null;
                f2 = 0.0f;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                str2 = null;
                i5 = 0;
                drawable = null;
                f3 = 0.0f;
                f4 = 0.0f;
                drawable2 = null;
                colorStateList2 = null;
                f5 = 0.0f;
                z = true;
                f6 = -1.0f;
                f7 = -1.0f;
                f8 = 1.8f;
                f9 = 0.0f;
                f10 = 0.0f;
                i6 = 250;
            }
            if (attributeSet == null) {
                f11 = f2;
                f12 = f4;
                obtainStyledAttributes = null;
            } else {
                f11 = f2;
                f12 = f4;
                obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
            }
            if (obtainStyledAttributes != null) {
                colorStateList3 = colorStateList2;
                boolean z3 = obtainStyledAttributes.getBoolean(0, true);
                boolean z4 = obtainStyledAttributes.getBoolean(1, z3);
                setFocusable(z3);
                setClickable(z4);
                obtainStyledAttributes.recycle();
            } else {
                colorStateList3 = colorStateList2;
                setFocusable(true);
                setClickable(true);
            }
            this.S = str2;
            this.T = str;
            this.c0 = i4;
            this.d0 = i3;
            this.e0 = i2;
            this.f38076e = drawable2;
            this.f38079h = colorStateList;
            this.G = drawable2 != null;
            this.o = i5;
            if (i5 == 0) {
                new TypedValue();
                this.o = DEFAULT_TINT_COLOR;
            }
            if (!this.G && this.f38079h == null) {
                ColorStateList b2 = c.a.i0.t.a.b(this.o);
                this.f38079h = b2;
                this.t = b2.getDefaultColor();
            }
            this.p = b(f3);
            this.q = b(f5);
            this.f38077f = drawable;
            this.f38078g = colorStateList3;
            boolean z5 = drawable != null;
            this.H = z5;
            if (!z5 && this.f38078g == null) {
                ColorStateList a2 = c.a.i0.t.a.a(this.o);
                this.f38078g = a2;
                int defaultColor = a2.getDefaultColor();
                this.u = defaultColor;
                this.v = this.f38078g.getColorForState(k0, defaultColor);
            }
            this.k.set(f10, f12, f11, f9);
            float f15 = f8;
            this.l = this.k.width() >= 0.0f ? Math.max(f15, 1.0f) : f15;
            this.f38080i = f7;
            this.f38081j = f6;
            long j2 = i6;
            this.m = j2;
            this.n = z;
            this.J.setDuration(j2);
            if (isChecked()) {
                setProgress(1.0f);
            }
        }
    }

    public final Layout d(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) {
            TextPaint textPaint = this.U;
            return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        return (Layout) invokeL.objValue;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.drawableStateChanged();
            if (!this.G && (colorStateList2 = this.f38079h) != null) {
                this.t = colorStateList2.getColorForState(getDrawableState(), this.t);
            } else {
                setDrawableState(this.f38076e);
            }
            int[] iArr = isChecked() ? q0 : k0;
            ColorStateList textColors = getTextColors();
            if (textColors != null) {
                int defaultColor = textColors.getDefaultColor();
                this.w = textColors.getColorForState(k0, defaultColor);
                this.x = textColors.getColorForState(q0, defaultColor);
            }
            if (!this.H && (colorStateList = this.f38078g) != null) {
                int colorForState = colorStateList.getColorForState(getDrawableState(), this.u);
                this.u = colorForState;
                this.v = this.f38078g.getColorForState(iArr, colorForState);
                return;
            }
            Drawable drawable = this.f38077f;
            if ((drawable instanceof StateListDrawable) && this.n) {
                drawable.setState(iArr);
                this.z = this.f38077f.getCurrent().mutate();
            } else {
                this.z = null;
            }
            setDrawableState(this.f38077f);
            Drawable drawable2 = this.f38077f;
            if (drawable2 != null) {
                this.y = drawable2.getCurrent().mutate();
            }
        }
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        int i3;
        int b2;
        int b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (this.q == 0 && this.G) {
                this.q = this.f38076e.getIntrinsicHeight();
            }
            if (mode == 1073741824) {
                if (this.q != 0) {
                    RectF rectF = this.k;
                    this.s = b(i3 + rectF.top + rectF.bottom);
                    this.s = b(Math.max(b2, this.b0));
                    if ((((b3 + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.k.top)) - Math.min(0.0f, this.k.bottom) > size) {
                        this.q = 0;
                    }
                }
                if (this.q == 0) {
                    int b4 = b(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.k.top) + Math.min(0.0f, this.k.bottom));
                    this.s = b4;
                    if (b4 < 0) {
                        this.s = 0;
                        this.q = 0;
                        return size;
                    }
                    RectF rectF2 = this.k;
                    this.q = b((b4 - rectF2.top) - rectF2.bottom);
                }
                if (this.q < 0) {
                    this.s = 0;
                    this.q = 0;
                    return size;
                }
                return size;
            }
            if (this.q == 0) {
                this.q = b(getResources().getDisplayMetrics().density * 20.0f);
            }
            RectF rectF3 = this.k;
            int b5 = b(this.q + rectF3.top + rectF3.bottom);
            this.s = b5;
            if (b5 < 0) {
                this.s = 0;
                this.q = 0;
                return size;
            }
            int b6 = b(this.b0 - b5);
            if (b6 > 0) {
                this.s += b6;
                this.q += b6;
            }
            int max = Math.max(this.q, this.s);
            return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
        }
        return invokeI.intValue;
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (this.p == 0 && this.G) {
                this.p = this.f38076e.getIntrinsicWidth();
            }
            int b2 = b(this.a0);
            if (this.l == 0.0f) {
                this.l = 1.8f;
            }
            if (mode == 1073741824) {
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                if (this.p != 0) {
                    int b3 = b(i3 * this.l);
                    RectF rectF = this.k;
                    int b4 = (this.d0 + b2) - ((b3 - this.p) + b(Math.max(rectF.left, rectF.right)));
                    float f2 = b3;
                    RectF rectF2 = this.k;
                    int b5 = b(rectF2.left + f2 + rectF2.right + Math.max(b4, 0));
                    this.r = b5;
                    if (b5 < 0) {
                        this.p = 0;
                    }
                    if (f2 + Math.max(this.k.left, 0.0f) + Math.max(this.k.right, 0.0f) + Math.max(b4, 0) > paddingLeft) {
                        this.p = 0;
                    }
                }
                if (this.p == 0) {
                    int b6 = b((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.k.left, 0.0f)) - Math.max(this.k.right, 0.0f));
                    if (b6 < 0) {
                        this.p = 0;
                        this.r = 0;
                        return size;
                    }
                    float f3 = b6;
                    this.p = b(f3 / this.l);
                    RectF rectF3 = this.k;
                    int b7 = b(f3 + rectF3.left + rectF3.right);
                    this.r = b7;
                    if (b7 < 0) {
                        this.p = 0;
                        this.r = 0;
                        return size;
                    }
                    int i4 = b2 + this.d0;
                    int i5 = b6 - this.p;
                    RectF rectF4 = this.k;
                    int b8 = i4 - (i5 + b(Math.max(rectF4.left, rectF4.right)));
                    if (b8 > 0) {
                        this.p -= b8;
                    }
                    if (this.p < 0) {
                        this.p = 0;
                        this.r = 0;
                        return size;
                    }
                    return size;
                }
                return size;
            }
            if (this.p == 0) {
                this.p = b(getResources().getDisplayMetrics().density * 20.0f);
            }
            if (this.l == 0.0f) {
                this.l = 1.8f;
            }
            int b9 = b(this.p * this.l);
            RectF rectF5 = this.k;
            int b10 = b((b2 + this.d0) - (((b9 - this.p) + Math.max(rectF5.left, rectF5.right)) + this.c0));
            float f4 = b9;
            RectF rectF6 = this.k;
            int b11 = b(rectF6.left + f4 + rectF6.right + Math.max(0, b10));
            this.r = b11;
            if (b11 < 0) {
                this.p = 0;
                this.r = 0;
                return size;
            }
            int b12 = b(f4 + Math.max(0.0f, this.k.left) + Math.max(0.0f, this.k.right) + Math.max(0, b10));
            return Math.max(b12, getPaddingLeft() + b12 + getPaddingRight());
        }
        return invokeI.intValue;
    }

    public final void g() {
        int i2;
        int i3;
        float paddingTop;
        float paddingLeft;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (i2 = this.p) == 0 || (i3 = this.q) == 0 || this.r == 0 || this.s == 0) {
            return;
        }
        if (this.f38080i == -1.0f) {
            this.f38080i = Math.min(i2, i3) / 2;
        }
        if (this.f38081j == -1.0f) {
            this.f38081j = Math.min(this.r, this.s) / 2;
        }
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int b2 = b((this.r - Math.min(0.0f, this.k.left)) - Math.min(0.0f, this.k.right));
        int b3 = b((this.s - Math.min(0.0f, this.k.top)) - Math.min(0.0f, this.k.bottom));
        if (measuredHeight <= b3) {
            paddingTop = getPaddingTop() + Math.max(0.0f, this.k.top);
        } else {
            paddingTop = (((measuredHeight - b3) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.k.top);
        }
        if (measuredWidth <= this.r) {
            paddingLeft = getPaddingLeft() + Math.max(0.0f, this.k.left);
        } else {
            paddingLeft = (((measuredWidth - b2) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.k.left);
        }
        this.A.set(paddingLeft, paddingTop, this.p + paddingLeft, this.q + paddingTop);
        RectF rectF = this.A;
        float f2 = rectF.left;
        RectF rectF2 = this.k;
        float f3 = f2 - rectF2.left;
        RectF rectF3 = this.B;
        float f4 = rectF.top - rectF2.top;
        rectF3.set(f3, f4, this.r + f3, this.s + f4);
        RectF rectF4 = this.C;
        RectF rectF5 = this.A;
        rectF4.set(rectF5.left, 0.0f, (this.B.right - this.k.right) - rectF5.width(), 0.0f);
        this.f38081j = Math.min(Math.min(this.B.width(), this.B.height()) / 2.0f, this.f38081j);
        Drawable drawable = this.f38077f;
        if (drawable != null) {
            RectF rectF6 = this.B;
            drawable.setBounds((int) rectF6.left, (int) rectF6.top, b(rectF6.right), b(this.B.bottom));
        }
        if (this.V != null) {
            RectF rectF7 = this.B;
            float width = (rectF7.left + (((((rectF7.width() + this.c0) - this.p) - this.k.right) - this.V.getWidth()) / 2.0f)) - this.e0;
            RectF rectF8 = this.B;
            float height = rectF8.top + ((rectF8.height() - this.V.getHeight()) / 2.0f);
            this.D.set(width, height, this.V.getWidth() + width, this.V.getHeight() + height);
        }
        if (this.W != null) {
            RectF rectF9 = this.B;
            float width2 = ((rectF9.right - (((((rectF9.width() + this.c0) - this.p) - this.k.left) - this.W.getWidth()) / 2.0f)) - this.W.getWidth()) + this.e0;
            RectF rectF10 = this.B;
            float height2 = rectF10.top + ((rectF10.height() - this.W.getHeight()) / 2.0f);
            this.E.set(width2, height2, this.W.getWidth() + width2, this.W.getHeight() + height2);
        }
        this.g0 = true;
    }

    public long getAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.longValue;
    }

    public ColorStateList getBackColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38078g : (ColorStateList) invokeV.objValue;
    }

    public Drawable getBackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f38077f : (Drawable) invokeV.objValue;
    }

    public float getBackRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f38081j : invokeV.floatValue;
    }

    public PointF getBackSizeF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new PointF(this.B.width(), this.B.height()) : (PointF) invokeV.objValue;
    }

    public CharSequence getTextOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.T : (CharSequence) invokeV.objValue;
    }

    public CharSequence getTextOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.S : (CharSequence) invokeV.objValue;
    }

    public ColorStateList getThumbColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f38079h : (ColorStateList) invokeV.objValue;
    }

    public Drawable getThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f38076e : (Drawable) invokeV.objValue;
    }

    public float getThumbHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q : invokeV.floatValue;
    }

    public RectF getThumbMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k : (RectF) invokeV.objValue;
    }

    public float getThumbRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f38080i : invokeV.floatValue;
    }

    public float getThumbRangeRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p : invokeV.floatValue;
    }

    public int getTintColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : invokeV.intValue;
    }

    public boolean isDrawDebugRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean isFadeBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float progress;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, canvas) == null) {
            super.onDraw(canvas);
            if (!this.g0) {
                g();
            }
            if (this.g0) {
                if (this.H) {
                    if (this.n && this.y != null && this.z != null) {
                        Drawable drawable = isChecked() ? this.y : this.z;
                        Drawable drawable2 = isChecked() ? this.z : this.y;
                        int progress2 = (int) (getProgress() * 255.0f);
                        drawable.setAlpha(progress2);
                        drawable.draw(canvas);
                        drawable2.setAlpha(255 - progress2);
                        drawable2.draw(canvas);
                    } else {
                        this.f38077f.setAlpha(255);
                        this.f38077f.draw(canvas);
                    }
                } else if (this.n) {
                    int i2 = isChecked() ? this.u : this.v;
                    int i3 = isChecked() ? this.v : this.u;
                    int progress3 = (int) (getProgress() * 255.0f);
                    this.F.setARGB((Color.alpha(i2) * progress3) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                    RectF rectF = this.B;
                    float f2 = this.f38081j;
                    canvas.drawRoundRect(rectF, f2, f2, this.F);
                    this.F.setARGB((Color.alpha(i3) * (255 - progress3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                    RectF rectF2 = this.B;
                    float f3 = this.f38081j;
                    canvas.drawRoundRect(rectF2, f3, f3, this.F);
                    this.F.setAlpha(255);
                } else {
                    this.F.setColor(this.u);
                    RectF rectF3 = this.B;
                    float f4 = this.f38081j;
                    canvas.drawRoundRect(rectF3, f4, f4, this.F);
                }
                Layout layout = ((double) getProgress()) > 0.5d ? this.V : this.W;
                RectF rectF4 = ((double) getProgress()) > 0.5d ? this.D : this.E;
                if (layout != null && rectF4 != null) {
                    if (getProgress() >= 0.75d) {
                        progress = (getProgress() * 4.0f) - 3.0f;
                    } else {
                        progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                    }
                    int i4 = (int) (progress * 255.0f);
                    int i5 = ((double) getProgress()) > 0.5d ? this.w : this.x;
                    layout.getPaint().setARGB((Color.alpha(i5) * i4) / 255, Color.red(i5), Color.green(i5), Color.blue(i5));
                    canvas.save();
                    canvas.translate(rectF4.left, rectF4.top);
                    layout.draw(canvas);
                    canvas.restore();
                }
                this.L.set(this.A);
                this.L.offset(this.K * this.C.width(), 0.0f);
                if (this.G) {
                    Drawable drawable3 = this.f38076e;
                    RectF rectF5 = this.L;
                    drawable3.setBounds((int) rectF5.left, (int) rectF5.top, b(rectF5.right), b(this.L.bottom));
                    this.f38076e.draw(canvas);
                } else {
                    this.F.setColor(this.t);
                    RectF rectF6 = this.L;
                    float f5 = this.f38080i;
                    canvas.drawRoundRect(rectF6, f5, f5, this.F);
                }
                if (this.I) {
                    this.R.setColor(Color.parseColor("#AA0000"));
                    canvas.drawRect(this.B, this.R);
                    this.R.setColor(Color.parseColor("#0000FF"));
                    canvas.drawRect(this.L, this.R);
                    this.R.setColor(Color.parseColor("#000000"));
                    RectF rectF7 = this.C;
                    float f6 = rectF7.left;
                    float f7 = this.A.top;
                    canvas.drawLine(f6, f7, rectF7.right, f7, this.R);
                    this.R.setColor(Color.parseColor("#00CC00"));
                    canvas.drawRect(((double) getProgress()) > 0.5d ? this.D : this.E, this.R);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            if (this.V == null && !TextUtils.isEmpty(this.S)) {
                this.V = d(this.S);
            }
            if (this.W == null && !TextUtils.isEmpty(this.T)) {
                this.W = d(this.T);
            }
            Layout layout = this.V;
            float width = layout != null ? layout.getWidth() : 0.0f;
            Layout layout2 = this.W;
            float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
            if (width == 0.0f && width2 == 0.0f) {
                this.a0 = 0.0f;
            } else {
                this.a0 = Math.max(width, width2);
            }
            Layout layout3 = this.V;
            float height = layout3 != null ? layout3.getHeight() : 0.0f;
            Layout layout4 = this.W;
            float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
            if (height == 0.0f && height2 == 0.0f) {
                this.b0 = 0.0f;
            } else {
                this.b0 = Math.max(height, height2);
            }
            setMeasuredDimension(f(i2), e(i3));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            setText(savedState.onText, savedState.offText);
            this.f0 = true;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f0 = false;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.onText = this.S;
            savedState.offText = this.T;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048606, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 == i4 && i3 == i5) {
                return;
            }
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            if (isEnabled() && isClickable() && isFocusable() && this.g0) {
                int action = motionEvent.getAction();
                float x = motionEvent.getX() - this.M;
                float y = motionEvent.getY() - this.N;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x2 = motionEvent.getX();
                            setProgress(getProgress() + ((x2 - this.O) / this.C.width()));
                            if (!this.h0 && (Math.abs(x) > this.P / 2 || Math.abs(y) > this.P / 2)) {
                                if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                                    if (Math.abs(y) > Math.abs(x)) {
                                        return false;
                                    }
                                } else {
                                    a();
                                }
                            }
                            this.O = x2;
                        }
                    }
                    this.h0 = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.P && Math.abs(y) < this.P && eventTime < this.Q) {
                        performClick();
                    } else {
                        boolean statusBasedOnPos = getStatusBasedOnPos();
                        if (statusBasedOnPos != isChecked()) {
                            playSoundEffect(0);
                            setChecked(statusBasedOnPos);
                        } else {
                            animateToState(statusBasedOnPos);
                        }
                    }
                } else {
                    this.M = motionEvent.getX();
                    this.N = motionEvent.getY();
                    this.O = this.M;
                    setPressed(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? super.performClick() : invokeV.booleanValue;
    }

    public void setAnimationDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.m = j2;
        }
    }

    public void setBackColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, colorStateList) == null) {
            this.f38078g = colorStateList;
            if (colorStateList != null) {
                setBackDrawable(null);
            }
            invalidate();
        }
    }

    public void setBackColorRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            setBackColor(getResources().getColorStateList(i2));
        }
    }

    public void setBackDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, drawable) == null) {
            this.f38077f = drawable;
            this.H = drawable != null;
            refreshDrawableState();
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setBackDrawableRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            setBackDrawable(getResources().getDrawable(i2));
        }
    }

    public void setBackRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            this.f38081j = f2;
            if (this.H) {
                return;
            }
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (isChecked() != z) {
                animateToState(z);
            }
            if (this.f0) {
                setCheckedImmediatelyNoEvent(z);
            } else {
                super.setChecked(z);
            }
        }
    }

    public void setCheckedImmediately(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.setChecked(z);
            ObjectAnimator objectAnimator = this.J;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.J.cancel();
            }
            setProgress(z ? 1.0f : 0.0f);
            invalidate();
        }
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (this.i0 == null) {
                setCheckedImmediately(z);
                return;
            }
            super.setOnCheckedChangeListener(null);
            setCheckedImmediately(z);
            super.setOnCheckedChangeListener(this.i0);
        }
    }

    public void setCheckedNoEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            if (this.i0 == null) {
                setChecked(z);
                return;
            }
            super.setOnCheckedChangeListener(null);
            setChecked(z);
            super.setOnCheckedChangeListener(this.i0);
        }
    }

    public void setDrawDebugRect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.I = z;
            invalidate();
        }
    }

    public void setFadeBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.n = z;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onCheckedChangeListener) == null) {
            super.setOnCheckedChangeListener(onCheckedChangeListener);
            this.i0 = onCheckedChangeListener;
        }
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, charSequence, charSequence2) == null) {
            this.S = charSequence;
            this.T = charSequence2;
            this.V = null;
            this.W = null;
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextAdjust(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.e0 = i2;
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextExtra(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.d0 = i2;
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextThumbInset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.c0 = i2;
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setThumbColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, colorStateList) == null) {
            this.f38079h = colorStateList;
            if (colorStateList != null) {
                setThumbDrawable(null);
            }
            invalidate();
        }
    }

    public void setThumbColorRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            setThumbColor(getResources().getColorStateList(i2));
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, drawable) == null) {
            this.f38076e = drawable;
            this.G = drawable != null;
            refreshDrawableState();
            this.g0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setThumbDrawableRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            setThumbDrawable(getResources().getDrawable(i2));
        }
    }

    public void setThumbMargin(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, rectF) == null) {
            if (rectF == null) {
                setThumbMargin(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                setThumbMargin(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
        }
    }

    public void setThumbRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            this.f38080i = f2;
            if (this.G) {
                return;
            }
            invalidate();
        }
    }

    public void setThumbRangeRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            this.l = f2;
            this.g0 = false;
            requestLayout();
        }
    }

    public void setThumbSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048634, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
            this.g0 = false;
            requestLayout();
        }
    }

    public void setTintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.o = i2;
            this.f38079h = c.a.i0.t.a.b(i2);
            this.f38078g = c.a.i0.t.a.a(this.o);
            this.H = false;
            this.G = false;
            refreshDrawableState();
            invalidate();
        }
    }

    public void toggleImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            setCheckedImmediately(!isChecked());
        }
    }

    public void toggleImmediatelyNoEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.i0 == null) {
                toggleImmediately();
                return;
            }
            super.setOnCheckedChangeListener(null);
            toggleImmediately();
            super.setOnCheckedChangeListener(this.i0);
        }
    }

    public void toggleNoEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.i0 == null) {
                toggle();
                return;
            }
            super.setOnCheckedChangeListener(null);
            toggle();
            super.setOnCheckedChangeListener(this.i0);
        }
    }

    public void setThumbMargin(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.k.set(f2, f3, f4, f5);
            this.g0 = false;
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.I = false;
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        c(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.I = false;
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        c(null);
    }
}
