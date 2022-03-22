package com.baidu.pass.biometrics.face.liveness.view.face;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class CircleImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 255;
    public static final boolean B = false;
    public static final ImageView.ScaleType u;
    public static final Bitmap.Config v;
    public static final int w = 2;
    public static final int x = 0;
    public static final int y = -16777216;
    public static final int z = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f28026b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f28027c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f28028d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f28029e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f28030f;

    /* renamed from: g  reason: collision with root package name */
    public int f28031g;

    /* renamed from: h  reason: collision with root package name */
    public int f28032h;
    public int i;
    public int j;
    public Bitmap k;
    public Canvas l;
    public float m;
    public float n;
    public ColorFilter o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CircleImageView a;

        public a(CircleImageView circleImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {circleImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = circleImageView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setBackgroundColor(0);
                this.a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes4.dex */
    public class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CircleImageView a;

        public b(CircleImageView circleImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {circleImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = circleImageView;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) {
                if (this.a.t) {
                    ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                    return;
                }
                Rect rect = new Rect();
                this.a.f28026b.roundOut(rect);
                outline.setRoundRect(rect, rect.width() / 2.0f);
            }
        }

        public /* synthetic */ b(CircleImageView circleImageView, a aVar) {
            this(circleImageView);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-450117455, "Lcom/baidu/pass/biometrics/face/liveness/view/face/CircleImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-450117455, "Lcom/baidu/pass/biometrics/face/liveness/view/face/CircleImageView;");
                return;
            }
        }
        u = ImageView.ScaleType.CENTER_CROP;
        v = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context) {
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
        this.a = new RectF();
        this.f28026b = new RectF();
        this.f28027c = new Matrix();
        this.f28028d = new Paint();
        this.f28029e = new Paint();
        this.f28030f = new Paint();
        this.f28031g = -16777216;
        this.f28032h = 0;
        this.i = 0;
        this.j = 255;
        e();
    }

    private RectF d() {
        InterceptResult invokeV;
        int width;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
            float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
            float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
            float f2 = min;
            return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
        }
        return (RectF) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.p = true;
            super.setScaleType(u);
            this.f28028d.setAntiAlias(true);
            this.f28028d.setDither(true);
            this.f28028d.setFilterBitmap(true);
            this.f28028d.setAlpha(this.j);
            this.f28028d.setColorFilter(this.o);
            this.f28029e.setStyle(Paint.Style.STROKE);
            this.f28029e.setAntiAlias(true);
            this.f28029e.setColor(this.f28031g);
            this.f28029e.setStrokeWidth(this.f28032h);
            this.f28030f.setStyle(Paint.Style.FILL);
            this.f28030f.setAntiAlias(true);
            this.f28030f.setColor(this.i);
            if (Build.VERSION.SDK_INT >= 21) {
                setOutlineProvider(new b(this, null));
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Bitmap a2 = a(getDrawable());
            this.k = a2;
            if (a2 != null && a2.isMutable()) {
                this.l = new Canvas(this.k);
            } else {
                this.l = null;
            }
            if (this.p) {
                if (this.k != null) {
                    h();
                } else {
                    this.f28028d.setShader(null);
                }
            }
        }
    }

    private void g() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f28026b.set(d());
            this.n = Math.min((this.f28026b.height() - this.f28032h) / 2.0f, (this.f28026b.width() - this.f28032h) / 2.0f);
            this.a.set(this.f28026b);
            if (!this.s && (i = this.f28032h) > 0) {
                float f2 = i - 1.0f;
                this.a.inset(f2, f2);
            }
            this.m = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
            h();
        }
    }

    private void h() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.k == null) {
            return;
        }
        this.f28027c.set(null);
        int height2 = this.k.getHeight();
        float width2 = this.k.getWidth();
        float f2 = height2;
        float f3 = 0.0f;
        if (this.a.height() * width2 > this.a.width() * f2) {
            width = this.a.height() / f2;
            f3 = (this.a.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.a.width() / width2;
            height = (this.a.height() - (f2 * width)) * 0.5f;
        }
        this.f28027c.setScale(width, width);
        Matrix matrix = this.f28027c;
        RectF rectF = this.a;
        matrix.postTranslate(((int) (f3 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.q = true;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setBackgroundColor(-1);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new a(this));
            startAnimation(alphaAnimation);
        }
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28031g : invokeV.intValue;
    }

    public int getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28032h : invokeV.intValue;
    }

    public int getCircleBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : (ColorFilter) invokeV.objValue;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.r = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            if (this.t) {
                super.onDraw(canvas);
                return;
            }
            if (this.i != 0) {
                canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.m, this.f28030f);
            }
            if (this.k != null) {
                if (this.r && this.l != null) {
                    this.r = false;
                    Drawable drawable = getDrawable();
                    drawable.setBounds(0, 0, this.l.getWidth(), this.l.getHeight());
                    drawable.draw(this.l);
                }
                if (this.q) {
                    this.q = false;
                    Bitmap bitmap = this.k;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                    bitmapShader.setLocalMatrix(this.f28027c);
                    this.f28028d.setShader(bitmapShader);
                }
                canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.m, this.f28028d);
            }
            if (this.f28032h > 0) {
                canvas.drawCircle(this.f28026b.centerX(), this.f28026b.centerY(), this.n, this.f28029e);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            g();
            invalidate();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (this.t) {
                return super.onTouchEvent(motionEvent);
            }
            return a(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) && z2) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || i == this.f28031g) {
            return;
        }
        this.f28031g = i;
        this.f28029e.setColor(i);
        invalidate();
    }

    public void setBorderOverlay(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) || z2 == this.s) {
            return;
        }
        this.s = z2;
        g();
        invalidate();
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || i == this.f28032h) {
            return;
        }
        this.f28032h = i;
        this.f28029e.setStrokeWidth(i);
        g();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || i == this.i) {
            return;
        }
        this.i = i;
        this.f28030f.setColor(i);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            setCircleBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, colorFilter) == null) || colorFilter == this.o) {
            return;
        }
        this.o = colorFilter;
        if (this.p) {
            this.f28028d.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) || z2 == this.t) {
            return;
        }
        this.t = z2;
        if (z2) {
            this.k = null;
            this.l = null;
            this.f28028d.setShader(null);
        } else {
            f();
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (i2 = i & 255) == this.j) {
            return;
        }
        this.j = i2;
        if (this.p) {
            this.f28028d.setAlpha(i2);
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            f();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            super.setImageDrawable(drawable);
            f();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            super.setImageResource(i);
            f();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, uri) == null) {
            super.setImageURI(uri);
            f();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048601, this, i, i2, i3, i4) == null) {
            super.setPadding(i, i2, i3, i4);
            g();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i, i2, i3, i4) == null) {
            super.setPaddingRelative(i, i2, i3, i4);
            g();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, scaleType) == null) && scaleType != u) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : invokeV.booleanValue;
    }

    private Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                if (drawable instanceof ColorDrawable) {
                    createBitmap = Bitmap.createBitmap(2, 2, v);
                } else {
                    createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), v);
                }
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    private boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f28026b.isEmpty() || Math.pow((double) (f2 - this.f28026b.centerX()), 2.0d) + Math.pow((double) (f3 - this.f28026b.centerY()), 2.0d) <= Math.pow((double) this.n, 2.0d) : invokeCommon.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new RectF();
        this.f28026b = new RectF();
        this.f28027c = new Matrix();
        this.f28028d = new Paint();
        this.f28029e = new Paint();
        this.f28030f = new Paint();
        this.f28031g = -16777216;
        this.f28032h = 0;
        this.i = 0;
        this.j = 255;
        e();
    }
}
