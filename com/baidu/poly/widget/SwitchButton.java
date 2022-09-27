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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ra1;
import com.baidu.tieba.zc1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwitchButton extends CompoundButton {
    public static /* synthetic */ Interceptable $ic;
    public static int[] f0;
    public static int[] g0;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF A;
    public Paint B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ObjectAnimator F;
    public float G;
    public RectF H;
    public float I;
    public float J;
    public float K;
    public int L;
    public int M;
    public Paint N;
    public CharSequence O;
    public CharSequence P;
    public TextPaint Q;
    public Layout R;
    public Layout S;
    public float T;
    public float U;
    public int V;
    public int W;
    public Drawable a;
    public int a0;
    public Drawable b;
    public boolean b0;
    public ColorStateList c;
    public boolean c0;
    public ColorStateList d;
    public boolean d0;
    public float e;
    public CompoundButton.OnCheckedChangeListener e0;
    public float f;
    public RectF g;
    public float h;
    public long i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public Drawable u;
    public Drawable v;
    public RectF w;
    public RectF x;
    public RectF y;
    public RectF z;

    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence offText;
        public CharSequence onText;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
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
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                TextUtils.writeToParcel(this.onText, parcel, i);
                TextUtils.writeToParcel(this.offText, parcel, i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
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
        f0 = new int[]{16842912, 16842910, 16842919};
        g0 = new int[]{-16842912, 16842910, 16842919};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(attributeSet);
    }

    private float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.G : invokeV.floatValue;
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

    private void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65543, this, f) == null) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            this.G = f;
            invalidate();
        }
    }

    public void a(boolean z) {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (objectAnimator = this.F) == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.F.cancel();
        }
        this.F.setDuration(this.i);
        if (z) {
            this.F.setFloatValues(this.G, 1.0f);
        } else {
            this.F.setFloatValues(this.G, 0.0f);
        }
        this.F.start();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.d0 = true;
        }
    }

    public final int c(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)})) == null) ? (int) Math.ceil(d) : invokeCommon.intValue;
    }

    public final void d(AttributeSet attributeSet) {
        String str;
        float f;
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        ColorStateList colorStateList;
        float f2;
        ColorStateList colorStateList2;
        Drawable drawable;
        float f3;
        Drawable drawable2;
        float f4;
        boolean z;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int i5;
        float f10;
        float f11;
        TypedArray obtainStyledAttributes;
        ColorStateList colorStateList3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
            this.L = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.M = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
            this.B = new Paint(1);
            Paint paint = new Paint(1);
            this.N = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.N.setStrokeWidth(getResources().getDisplayMetrics().density);
            this.Q = getPaint();
            this.w = new RectF();
            this.x = new RectF();
            this.y = new RectF();
            this.g = new RectF();
            this.z = new RectF();
            this.A = new RectF();
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
            this.F = duration;
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.H = new RectF();
            float f12 = getResources().getDisplayMetrics().density * 2.0f;
            TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, ra1.SwitchButton);
            if (obtainStyledAttributes2 != null) {
                drawable = obtainStyledAttributes2.getDrawable(11);
                ColorStateList colorStateList4 = obtainStyledAttributes2.getColorStateList(10);
                float dimension = obtainStyledAttributes2.getDimension(13, f12);
                float dimension2 = obtainStyledAttributes2.getDimension(15, dimension);
                float dimension3 = obtainStyledAttributes2.getDimension(16, dimension);
                float dimension4 = obtainStyledAttributes2.getDimension(17, dimension);
                float dimension5 = obtainStyledAttributes2.getDimension(14, dimension);
                float dimension6 = obtainStyledAttributes2.getDimension(20, 0.0f);
                float dimension7 = obtainStyledAttributes2.getDimension(12, 0.0f);
                float dimension8 = obtainStyledAttributes2.getDimension(18, -1.0f);
                float dimension9 = obtainStyledAttributes2.getDimension(3, -1.0f);
                Drawable drawable3 = obtainStyledAttributes2.getDrawable(2);
                ColorStateList colorStateList5 = obtainStyledAttributes2.getColorStateList(1);
                float f13 = obtainStyledAttributes2.getFloat(19, 1.8f);
                int integer = obtainStyledAttributes2.getInteger(0, 250);
                boolean z2 = obtainStyledAttributes2.getBoolean(4, true);
                int color = obtainStyledAttributes2.getColor(21, 0);
                String string = obtainStyledAttributes2.getString(8);
                String string2 = obtainStyledAttributes2.getString(7);
                int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(9, 0);
                int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(6, 0);
                int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(5, 0);
                obtainStyledAttributes2.recycle();
                f = dimension7;
                colorStateList2 = colorStateList4;
                i5 = integer;
                i3 = dimensionPixelSize;
                f5 = dimension9;
                f3 = dimension6;
                colorStateList = colorStateList5;
                str2 = string;
                f6 = dimension8;
                i4 = color;
                f8 = dimension5;
                i = dimensionPixelSize3;
                str = string2;
                f9 = dimension3;
                f4 = dimension2;
                drawable2 = drawable3;
                f2 = dimension4;
                i2 = dimensionPixelSize2;
                f7 = f13;
                z = z2;
            } else {
                str = null;
                f = 0.0f;
                i = 0;
                i2 = 0;
                i3 = 0;
                str2 = null;
                i4 = 0;
                colorStateList = null;
                f2 = 0.0f;
                colorStateList2 = null;
                drawable = null;
                f3 = 0.0f;
                drawable2 = null;
                f4 = 0.0f;
                z = true;
                f5 = -1.0f;
                f6 = -1.0f;
                f7 = 1.8f;
                f8 = 0.0f;
                f9 = 0.0f;
                i5 = 250;
            }
            if (attributeSet == null) {
                f10 = f2;
                f11 = f4;
                obtainStyledAttributes = null;
            } else {
                f10 = f2;
                f11 = f4;
                obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
            }
            if (obtainStyledAttributes != null) {
                colorStateList3 = colorStateList;
                boolean z3 = obtainStyledAttributes.getBoolean(0, true);
                boolean z4 = obtainStyledAttributes.getBoolean(1, z3);
                setFocusable(z3);
                setClickable(z4);
                obtainStyledAttributes.recycle();
            } else {
                colorStateList3 = colorStateList;
                setFocusable(true);
                setClickable(true);
            }
            this.O = str2;
            this.P = str;
            this.V = i3;
            this.W = i2;
            this.a0 = i;
            this.a = drawable;
            this.d = colorStateList2;
            this.C = drawable != null;
            this.k = i4;
            if (i4 == 0) {
                new TypedValue();
                this.k = 3309506;
            }
            if (!this.C && this.d == null) {
                ColorStateList b = zc1.b(this.k);
                this.d = b;
                this.p = b.getDefaultColor();
            }
            this.l = c(f3);
            this.m = c(f);
            this.b = drawable2;
            this.c = colorStateList3;
            boolean z5 = drawable2 != null;
            this.D = z5;
            if (!z5 && this.c == null) {
                ColorStateList a2 = zc1.a(this.k);
                this.c = a2;
                int defaultColor = a2.getDefaultColor();
                this.q = defaultColor;
                this.r = this.c.getColorForState(f0, defaultColor);
            }
            this.g.set(f11, f10, f9, f8);
            float f14 = f7;
            this.h = this.g.width() >= 0.0f ? Math.max(f14, 1.0f) : f14;
            this.e = f6;
            this.f = f5;
            long j = i5;
            this.i = j;
            this.j = z;
            this.F.setDuration(j);
            if (isChecked()) {
                setProgress(1.0f);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            if (!this.C && (colorStateList2 = this.d) != null) {
                this.p = colorStateList2.getColorForState(getDrawableState(), this.p);
            } else {
                setDrawableState(this.a);
            }
            int[] iArr = isChecked() ? g0 : f0;
            ColorStateList textColors = getTextColors();
            if (textColors != null) {
                int defaultColor = textColors.getDefaultColor();
                this.s = textColors.getColorForState(f0, defaultColor);
                this.t = textColors.getColorForState(g0, defaultColor);
            }
            if (!this.D && (colorStateList = this.c) != null) {
                int colorForState = colorStateList.getColorForState(getDrawableState(), this.q);
                this.q = colorForState;
                this.r = this.c.getColorForState(iArr, colorForState);
                return;
            }
            Drawable drawable = this.b;
            if ((drawable instanceof StateListDrawable) && this.j) {
                drawable.setState(iArr);
                this.v = this.b.getCurrent().mutate();
            } else {
                this.v = null;
            }
            setDrawableState(this.b);
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                this.u = drawable2.getCurrent().mutate();
            }
        }
    }

    public final Layout e(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequence)) == null) {
            TextPaint textPaint = this.Q;
            return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        return (Layout) invokeL.objValue;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        int i2;
        int c;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            if (this.m == 0 && this.C) {
                this.m = this.a.getIntrinsicHeight();
            }
            if (mode == 1073741824) {
                if (this.m != 0) {
                    RectF rectF = this.g;
                    this.o = c(i2 + rectF.top + rectF.bottom);
                    this.o = c(Math.max(c, this.U));
                    if ((((c2 + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.g.top)) - Math.min(0.0f, this.g.bottom) > size) {
                        this.m = 0;
                    }
                }
                if (this.m == 0) {
                    int c3 = c(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.g.top) + Math.min(0.0f, this.g.bottom));
                    this.o = c3;
                    if (c3 < 0) {
                        this.o = 0;
                        this.m = 0;
                        return size;
                    }
                    RectF rectF2 = this.g;
                    this.m = c((c3 - rectF2.top) - rectF2.bottom);
                }
                if (this.m < 0) {
                    this.o = 0;
                    this.m = 0;
                    return size;
                }
                return size;
            }
            if (this.m == 0) {
                this.m = c(getResources().getDisplayMetrics().density * 20.0f);
            }
            RectF rectF3 = this.g;
            int c4 = c(this.m + rectF3.top + rectF3.bottom);
            this.o = c4;
            if (c4 < 0) {
                this.o = 0;
                this.m = 0;
                return size;
            }
            int c5 = c(this.U - c4);
            if (c5 > 0) {
                this.o += c5;
                this.m += c5;
            }
            int max = Math.max(this.m, this.o);
            return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
        }
        return invokeI.intValue;
    }

    public final int g(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            if (this.l == 0 && this.C) {
                this.l = this.a.getIntrinsicWidth();
            }
            int c = c(this.T);
            if (this.h == 0.0f) {
                this.h = 1.8f;
            }
            if (mode == 1073741824) {
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                if (this.l != 0) {
                    int c2 = c(i2 * this.h);
                    RectF rectF = this.g;
                    int c3 = (this.W + c) - ((c2 - this.l) + c(Math.max(rectF.left, rectF.right)));
                    float f = c2;
                    RectF rectF2 = this.g;
                    int c4 = c(rectF2.left + f + rectF2.right + Math.max(c3, 0));
                    this.n = c4;
                    if (c4 < 0) {
                        this.l = 0;
                    }
                    if (f + Math.max(this.g.left, 0.0f) + Math.max(this.g.right, 0.0f) + Math.max(c3, 0) > paddingLeft) {
                        this.l = 0;
                    }
                }
                if (this.l == 0) {
                    int c5 = c((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.g.left, 0.0f)) - Math.max(this.g.right, 0.0f));
                    if (c5 < 0) {
                        this.l = 0;
                        this.n = 0;
                        return size;
                    }
                    float f2 = c5;
                    this.l = c(f2 / this.h);
                    RectF rectF3 = this.g;
                    int c6 = c(f2 + rectF3.left + rectF3.right);
                    this.n = c6;
                    if (c6 < 0) {
                        this.l = 0;
                        this.n = 0;
                        return size;
                    }
                    int i3 = c + this.W;
                    int i4 = c5 - this.l;
                    RectF rectF4 = this.g;
                    int c7 = i3 - (i4 + c(Math.max(rectF4.left, rectF4.right)));
                    if (c7 > 0) {
                        this.l -= c7;
                    }
                    if (this.l < 0) {
                        this.l = 0;
                        this.n = 0;
                        return size;
                    }
                    return size;
                }
                return size;
            }
            if (this.l == 0) {
                this.l = c(getResources().getDisplayMetrics().density * 20.0f);
            }
            if (this.h == 0.0f) {
                this.h = 1.8f;
            }
            int c8 = c(this.l * this.h);
            RectF rectF5 = this.g;
            int c9 = c((c + this.W) - (((c8 - this.l) + Math.max(rectF5.left, rectF5.right)) + this.V));
            float f3 = c8;
            RectF rectF6 = this.g;
            int c10 = c(rectF6.left + f3 + rectF6.right + Math.max(0, c9));
            this.n = c10;
            if (c10 < 0) {
                this.l = 0;
                this.n = 0;
                return size;
            }
            int c11 = c(f3 + Math.max(0.0f, this.g.left) + Math.max(0.0f, this.g.right) + Math.max(0, c9));
            return Math.max(c11, getPaddingLeft() + c11 + getPaddingRight());
        }
        return invokeI.intValue;
    }

    public long getAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.longValue;
    }

    public ColorStateList getBackColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (ColorStateList) invokeV.objValue;
    }

    public Drawable getBackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (Drawable) invokeV.objValue;
    }

    public float getBackRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f : invokeV.floatValue;
    }

    public PointF getBackSizeF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new PointF(this.x.width(), this.x.height()) : (PointF) invokeV.objValue;
    }

    public CharSequence getTextOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.P : (CharSequence) invokeV.objValue;
    }

    public CharSequence getTextOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.O : (CharSequence) invokeV.objValue;
    }

    public ColorStateList getThumbColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : (ColorStateList) invokeV.objValue;
    }

    public Drawable getThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : (Drawable) invokeV.objValue;
    }

    public float getThumbHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m : invokeV.floatValue;
    }

    public RectF getThumbMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.g : (RectF) invokeV.objValue;
    }

    public float getThumbRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.e : invokeV.floatValue;
    }

    public float getThumbRangeRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.h : invokeV.floatValue;
    }

    public float getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : invokeV.floatValue;
    }

    public int getTintColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void h() {
        int i;
        int i2;
        float paddingTop;
        float paddingLeft;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (i = this.l) == 0 || (i2 = this.m) == 0 || this.n == 0 || this.o == 0) {
            return;
        }
        if (this.e == -1.0f) {
            this.e = Math.min(i, i2) / 2;
        }
        if (this.f == -1.0f) {
            this.f = Math.min(this.n, this.o) / 2;
        }
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int c = c((this.n - Math.min(0.0f, this.g.left)) - Math.min(0.0f, this.g.right));
        int c2 = c((this.o - Math.min(0.0f, this.g.top)) - Math.min(0.0f, this.g.bottom));
        if (measuredHeight <= c2) {
            paddingTop = getPaddingTop() + Math.max(0.0f, this.g.top);
        } else {
            paddingTop = (((measuredHeight - c2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.g.top);
        }
        if (measuredWidth <= this.n) {
            paddingLeft = getPaddingLeft() + Math.max(0.0f, this.g.left);
        } else {
            paddingLeft = (((measuredWidth - c) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.g.left);
        }
        this.w.set(paddingLeft, paddingTop, this.l + paddingLeft, this.m + paddingTop);
        RectF rectF = this.w;
        float f = rectF.left;
        RectF rectF2 = this.g;
        float f2 = f - rectF2.left;
        RectF rectF3 = this.x;
        float f3 = rectF.top - rectF2.top;
        rectF3.set(f2, f3, this.n + f2, this.o + f3);
        RectF rectF4 = this.y;
        RectF rectF5 = this.w;
        rectF4.set(rectF5.left, 0.0f, (this.x.right - this.g.right) - rectF5.width(), 0.0f);
        this.f = Math.min(Math.min(this.x.width(), this.x.height()) / 2.0f, this.f);
        Drawable drawable = this.b;
        if (drawable != null) {
            RectF rectF6 = this.x;
            drawable.setBounds((int) rectF6.left, (int) rectF6.top, c(rectF6.right), c(this.x.bottom));
        }
        if (this.R != null) {
            RectF rectF7 = this.x;
            float width = (rectF7.left + (((((rectF7.width() + this.V) - this.l) - this.g.right) - this.R.getWidth()) / 2.0f)) - this.a0;
            RectF rectF8 = this.x;
            float height = rectF8.top + ((rectF8.height() - this.R.getHeight()) / 2.0f);
            this.z.set(width, height, this.R.getWidth() + width, this.R.getHeight() + height);
        }
        if (this.S != null) {
            RectF rectF9 = this.x;
            float width2 = ((rectF9.right - (((((rectF9.width() + this.V) - this.l) - this.g.left) - this.S.getWidth()) / 2.0f)) - this.S.getWidth()) + this.a0;
            RectF rectF10 = this.x;
            float height2 = rectF10.top + ((rectF10.height() - this.S.getHeight()) / 2.0f);
            this.A.set(width2, height2, this.S.getWidth() + width2, this.S.getHeight() + height2);
        }
        this.c0 = true;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.e0 == null) {
                toggle();
                return;
            }
            super.setOnCheckedChangeListener(null);
            toggle();
            super.setOnCheckedChangeListener(this.e0);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float progress;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) {
            super.onDraw(canvas);
            if (!this.c0) {
                h();
            }
            if (this.c0) {
                if (this.D) {
                    if (this.j && this.u != null && this.v != null) {
                        Drawable drawable = isChecked() ? this.u : this.v;
                        Drawable drawable2 = isChecked() ? this.v : this.u;
                        int progress2 = (int) (getProgress() * 255.0f);
                        drawable.setAlpha(progress2);
                        drawable.draw(canvas);
                        drawable2.setAlpha(255 - progress2);
                        drawable2.draw(canvas);
                    } else {
                        this.b.setAlpha(255);
                        this.b.draw(canvas);
                    }
                } else if (this.j) {
                    int i = isChecked() ? this.q : this.r;
                    int i2 = isChecked() ? this.r : this.q;
                    int progress3 = (int) (getProgress() * 255.0f);
                    this.B.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                    RectF rectF = this.x;
                    float f = this.f;
                    canvas.drawRoundRect(rectF, f, f, this.B);
                    this.B.setARGB((Color.alpha(i2) * (255 - progress3)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                    RectF rectF2 = this.x;
                    float f2 = this.f;
                    canvas.drawRoundRect(rectF2, f2, f2, this.B);
                    this.B.setAlpha(255);
                } else {
                    this.B.setColor(this.q);
                    RectF rectF3 = this.x;
                    float f3 = this.f;
                    canvas.drawRoundRect(rectF3, f3, f3, this.B);
                }
                Layout layout = ((double) getProgress()) > 0.5d ? this.R : this.S;
                RectF rectF4 = ((double) getProgress()) > 0.5d ? this.z : this.A;
                if (layout != null && rectF4 != null) {
                    if (getProgress() >= 0.75d) {
                        progress = (getProgress() * 4.0f) - 3.0f;
                    } else {
                        progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                    }
                    int i3 = (int) (progress * 255.0f);
                    int i4 = ((double) getProgress()) > 0.5d ? this.s : this.t;
                    layout.getPaint().setARGB((Color.alpha(i4) * i3) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                    canvas.save();
                    canvas.translate(rectF4.left, rectF4.top);
                    layout.draw(canvas);
                    canvas.restore();
                }
                this.H.set(this.w);
                this.H.offset(this.G * this.y.width(), 0.0f);
                if (this.C) {
                    Drawable drawable3 = this.a;
                    RectF rectF5 = this.H;
                    drawable3.setBounds((int) rectF5.left, (int) rectF5.top, c(rectF5.right), c(this.H.bottom));
                    this.a.draw(canvas);
                } else {
                    this.B.setColor(this.p);
                    RectF rectF6 = this.H;
                    float f4 = this.e;
                    canvas.drawRoundRect(rectF6, f4, f4, this.B);
                }
                if (this.E) {
                    this.N.setColor(Color.parseColor("#AA0000"));
                    canvas.drawRect(this.x, this.N);
                    this.N.setColor(Color.parseColor("#0000FF"));
                    canvas.drawRect(this.H, this.N);
                    this.N.setColor(Color.parseColor("#000000"));
                    RectF rectF7 = this.y;
                    float f5 = rectF7.left;
                    float f6 = this.w.top;
                    canvas.drawLine(f5, f6, rectF7.right, f6, this.N);
                    this.N.setColor(Color.parseColor("#00CC00"));
                    canvas.drawRect(((double) getProgress()) > 0.5d ? this.z : this.A, this.N);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            if (this.R == null && !TextUtils.isEmpty(this.O)) {
                this.R = e(this.O);
            }
            if (this.S == null && !TextUtils.isEmpty(this.P)) {
                this.S = e(this.P);
            }
            Layout layout = this.R;
            float width = layout != null ? layout.getWidth() : 0.0f;
            Layout layout2 = this.S;
            float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
            if (width == 0.0f && width2 == 0.0f) {
                this.T = 0.0f;
            } else {
                this.T = Math.max(width, width2);
            }
            Layout layout3 = this.R;
            float height = layout3 != null ? layout3.getHeight() : 0.0f;
            Layout layout4 = this.S;
            float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
            if (height == 0.0f && height2 == 0.0f) {
                this.U = 0.0f;
            } else {
                this.U = Math.max(height, height2);
            }
            setMeasuredDimension(g(i), f(i2));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            setText(savedState.onText, savedState.offText);
            this.b0 = true;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.b0 = false;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.onText = this.O;
            savedState.offText = this.P;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i == i3 && i2 == i4) {
                return;
            }
            h();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            if (isEnabled() && isClickable() && isFocusable() && this.c0) {
                int action = motionEvent.getAction();
                float x = motionEvent.getX() - this.I;
                float y = motionEvent.getY() - this.J;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x2 = motionEvent.getX();
                            setProgress(getProgress() + ((x2 - this.K) / this.y.width()));
                            if (!this.d0 && (Math.abs(x) > this.L / 2 || Math.abs(y) > this.L / 2)) {
                                if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                                    if (Math.abs(y) > Math.abs(x)) {
                                        return false;
                                    }
                                } else {
                                    b();
                                }
                            }
                            this.K = x2;
                        }
                    }
                    this.d0 = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.L && Math.abs(y) < this.L && eventTime < this.M) {
                        performClick();
                    } else {
                        boolean statusBasedOnPos = getStatusBasedOnPos();
                        if (statusBasedOnPos != isChecked()) {
                            playSoundEffect(0);
                            setChecked(statusBasedOnPos);
                        } else {
                            a(statusBasedOnPos);
                        }
                    }
                } else {
                    this.I = motionEvent.getX();
                    this.J = motionEvent.getY();
                    this.K = this.I;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? super.performClick() : invokeV.booleanValue;
    }

    public void setAnimationDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.i = j;
        }
    }

    public void setBackColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, colorStateList) == null) {
            this.c = colorStateList;
            if (colorStateList != null) {
                setBackDrawable(null);
            }
            invalidate();
        }
    }

    public void setBackColorRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            setBackColor(getResources().getColorStateList(i));
        }
    }

    public void setBackDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, drawable) == null) {
            this.b = drawable;
            this.D = drawable != null;
            refreshDrawableState();
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setBackDrawableRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            setBackDrawable(getResources().getDrawable(i));
        }
    }

    public void setBackRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f) == null) {
            this.f = f;
            if (this.D) {
                return;
            }
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            if (isChecked() != z) {
                a(z);
            }
            if (this.b0) {
                setCheckedImmediatelyNoEvent(z);
            } else {
                super.setChecked(z);
            }
        }
    }

    public void setCheckedImmediately(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.setChecked(z);
            ObjectAnimator objectAnimator = this.F;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.F.cancel();
            }
            setProgress(z ? 1.0f : 0.0f);
            invalidate();
        }
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (this.e0 == null) {
                setCheckedImmediately(z);
                return;
            }
            super.setOnCheckedChangeListener(null);
            setCheckedImmediately(z);
            super.setOnCheckedChangeListener(this.e0);
        }
    }

    public void setCheckedNoEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (this.e0 == null) {
                setChecked(z);
                return;
            }
            super.setOnCheckedChangeListener(null);
            setChecked(z);
            super.setOnCheckedChangeListener(this.e0);
        }
    }

    public void setDrawDebugRect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.E = z;
            invalidate();
        }
    }

    public void setFadeBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.j = z;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onCheckedChangeListener) == null) {
            super.setOnCheckedChangeListener(onCheckedChangeListener);
            this.e0 = onCheckedChangeListener;
        }
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, charSequence, charSequence2) == null) {
            this.O = charSequence;
            this.P = charSequence2;
            this.R = null;
            this.S = null;
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextAdjust(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.a0 = i;
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextExtra(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.W = i;
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setTextThumbInset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.V = i;
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setThumbColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, colorStateList) == null) {
            this.d = colorStateList;
            if (colorStateList != null) {
                setThumbDrawable(null);
            }
            invalidate();
        }
    }

    public void setThumbColorRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            setThumbColor(getResources().getColorStateList(i));
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, drawable) == null) {
            this.a = drawable;
            this.C = drawable != null;
            refreshDrawableState();
            this.c0 = false;
            requestLayout();
            invalidate();
        }
    }

    public void setThumbDrawableRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            setThumbDrawable(getResources().getDrawable(i));
        }
    }

    public void setThumbMargin(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, rectF) == null) {
            if (rectF == null) {
                setThumbMargin(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                setThumbMargin(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
        }
    }

    public void setThumbRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f) == null) {
            this.e = f;
            if (this.C) {
                return;
            }
            invalidate();
        }
    }

    public void setThumbRangeRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f) == null) {
            this.h = f;
            this.c0 = false;
            requestLayout();
        }
    }

    public void setThumbSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i, i2) == null) {
            this.l = i;
            this.m = i2;
            this.c0 = false;
            requestLayout();
        }
    }

    public void setTintColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.k = i;
            this.d = zc1.b(i);
            this.c = zc1.a(this.k);
            this.D = false;
            this.C = false;
            refreshDrawableState();
            invalidate();
        }
    }

    public void setThumbMargin(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.g.set(f, f2, f3, f4);
            this.c0 = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(attributeSet);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(null);
    }
}
