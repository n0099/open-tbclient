package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.d;
import d.a.o0.a.f;
import d.a.o0.a.k;
import d.a.o0.a.v2.n0;
/* loaded from: classes3.dex */
public class FullScreenFloatView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f11354e;

    /* renamed from: f  reason: collision with root package name */
    public int f11355f;

    /* renamed from: g  reason: collision with root package name */
    public int f11356g;

    /* renamed from: h  reason: collision with root package name */
    public int f11357h;

    /* renamed from: i  reason: collision with root package name */
    public int f11358i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public b p;
    public c q;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FullScreenFloatView f11359e;

        public b(FullScreenFloatView fullScreenFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11359e = fullScreenFloatView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11359e.k = false;
                if (FullScreenFloatView.r) {
                    Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
                }
            }
        }

        public /* synthetic */ b(FullScreenFloatView fullScreenFloatView, a aVar) {
            this(fullScreenFloatView);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void onClick();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(201030676, "Lcom/baidu/swan/apps/res/ui/FullScreenFloatView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(201030676, "Lcom/baidu/swan/apps/res/ui/FullScreenFloatView;");
                return;
            }
        }
        r = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = 66;
        this.k = false;
        this.l = false;
        this.m = true;
        this.p = new b(this, null);
        setStatusBarHeight();
    }

    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (this.f11357h == 0) {
                this.f11357h = getWidth();
            }
            if (this.f11358i == 0) {
                this.f11358i = getHeight();
            }
            this.f11355f = view.getWidth();
            this.f11356g = view.getHeight();
            if (r) {
                Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.f11357h + ", mScreenHeight = " + this.f11358i + ",mFloatViewWidth = " + this.f11355f + ", mFloatViewHeight = " + this.f11356g);
            }
        }
    }

    public int c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (r) {
                Log.e("FullScreenFloatView", "minDIstance---> x = " + f2 + ", y = " + f3);
            }
            boolean z = f2 <= ((float) this.f11357h) - f2;
            boolean z2 = f3 <= ((float) this.f11358i) - f3;
            if (z && z2) {
                return f2 <= f3 ? 1 : 3;
            } else if (z && !z2) {
                return f2 <= ((float) this.f11358i) - f3 ? 1 : 4;
            } else if (!z && z2) {
                return ((float) this.f11357h) - f2 <= f3 ? 2 : 3;
            } else if (z || z2) {
                return 0;
            } else {
                return ((float) this.f11357h) - f2 <= ((float) this.f11358i) - f3 ? 2 : 4;
            }
        }
        return invokeCommon.intValue;
    }

    public final void d(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f11354e == null) {
            return;
        }
        if (r) {
            Log.e("FullScreenFloatView", "move--> x = " + f2 + ", y = " + f3);
        }
        int i2 = (int) (f2 - (this.f11355f / 2));
        int i3 = (int) (f3 - (this.f11356g / 2));
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i3 <= 0) {
            i3 = 0;
        }
        int i4 = this.f11357h;
        int i5 = this.f11355f;
        if (i2 > i4 - i5) {
            i2 = i4 - i5;
        }
        int i6 = this.f11358i;
        int i7 = this.f11356g;
        if (i3 > i6 - i7) {
            i3 = i6 - i7;
        }
        int i8 = (this.f11357h - i2) - this.f11355f;
        int i9 = (this.f11358i - i3) - this.f11356g;
        if (r) {
            Log.e("FullScreenFloatView", "move--> left = " + i2 + ", top = " + i3 + ", right = " + i8 + ",bottom = " + i9 + ", mStatusBarHeight = " + this.j);
        }
        this.f11354e.setX(i2);
        this.f11354e.setY(i3);
        requestLayout();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f11354e == null) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.swan_app_dimens_21dp);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(d.swan_app_dimens_51dp);
        this.f11354e.animate().x((n0.o(getContext()) - dimensionPixelOffset) - this.f11355f).y((n0.n(getContext()) - dimensionPixelOffset2) - this.f11356g).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
    }

    public c getDragImageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (c) invokeV.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.f11357h = getHeight() + this.j;
            this.f11358i = getWidth() - this.j;
            if (r) {
                Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.f11357h + ", mScreenHeight = " + this.f11358i);
            }
            e();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            if (this.f11354e == null) {
                View findViewById = findViewById(f.float_imgview);
                this.f11354e = findViewById;
                b(findViewById);
            }
            this.f11354e.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.l = true;
                this.n = x;
                this.o = y;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.f11357h = getWidth();
            this.f11358i = getHeight();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f11354e.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.n = x;
                    this.o = y;
                    this.l = true;
                    this.k = true;
                    postDelayed(this.p, ViewConfiguration.getTapTimeout());
                }
            } else if (action == 1) {
                if (this.k) {
                    c cVar2 = this.q;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.p);
                } else if (this.l && (cVar = this.q) != null) {
                    cVar.a();
                }
                if (r) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.k);
                }
                if (this.m && !this.k) {
                    int i2 = this.f11355f;
                    if (x > i2 / 2 && x < this.f11357h - (i2 / 2)) {
                        int i3 = this.f11356g;
                        if (y > i3 / 2 && y < this.f11358i - (i3 / 2)) {
                            int c2 = c(x, y);
                            if (r) {
                                Log.e("FullScreenFloatView", "mScreenHeight = " + this.f11358i + ", mintype = " + c2);
                            }
                            if (c2 == 1) {
                                x = 0.0f;
                            } else if (c2 == 2) {
                                x = this.f11357h - this.f11355f;
                            } else if (c2 == 3) {
                                y = 0.0f;
                            } else if (c2 == 4) {
                                y = this.f11358i - this.f11356g;
                            }
                            if (c2 == 1 || c2 == 2) {
                                this.f11354e.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            } else if (c2 == 3 || c2 == 4) {
                                this.f11354e.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            }
                        }
                    }
                }
                this.k = false;
                this.l = false;
            } else if (action == 2) {
                float abs = Math.abs(x - this.n);
                float abs2 = Math.abs(y - this.o);
                if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                    this.k = false;
                }
                d(x, y);
            } else if (action == 3) {
                this.k = false;
                this.l = false;
            } else if (action == 4) {
                this.k = false;
                this.l = false;
            }
            return this.k || this.l;
        }
        return invokeL.booleanValue;
    }

    public void setAutoAttachEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void setDragImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.q = cVar;
        }
    }

    public void setFloatButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View findViewById = findViewById(f.float_imgview);
            if (findViewById instanceof Button) {
                ((Button) findViewById).setText(str);
            }
        }
    }

    public void setFloatImageBackground(int i2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (findViewById = findViewById(f.float_imgview)) == null) {
            return;
        }
        findViewById.setBackgroundResource(i2);
    }

    public void setStatusBarHeight() {
        int identifier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (identifier = getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return;
        }
        this.j = getResources().getDimensionPixelSize(identifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 66;
        this.k = false;
        this.l = false;
        this.m = true;
        this.p = new b(this, null);
        setStatusBarHeight();
    }
}
