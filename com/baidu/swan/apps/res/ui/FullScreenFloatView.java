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
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eh1;
import com.repackage.le3;
/* loaded from: classes2.dex */
public class FullScreenFloatView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public float j;
    public float k;
    public b l;
    public c m;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenFloatView a;

        public b(FullScreenFloatView fullScreenFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenFloatView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g = false;
                if (FullScreenFloatView.n) {
                    Log.e("FullScreenFloatView", "CheckClick=====checkTap====");
                }
            }
        }

        public /* synthetic */ b(FullScreenFloatView fullScreenFloatView, a aVar) {
            this(fullScreenFloatView);
        }
    }

    /* loaded from: classes2.dex */
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
        n = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = 66;
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = new b(this, null);
        setStatusBarHeight();
    }

    public void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (this.d == 0) {
                this.d = getWidth();
            }
            if (this.e == 0) {
                this.e = getHeight();
            }
            this.b = view2.getWidth();
            this.c = view2.getHeight();
            if (n) {
                Log.e("FullScreenFloatView", "dragInit-> mScreenWidth = " + this.d + ", mScreenHeight = " + this.e + ",mFloatViewWidth = " + this.b + ", mFloatViewHeight = " + this.c);
            }
        }
    }

    public int c(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (n) {
                Log.e("FullScreenFloatView", "minDIstance---> x = " + f + ", y = " + f2);
            }
            boolean z = f <= ((float) this.d) - f;
            boolean z2 = f2 <= ((float) this.e) - f2;
            if (z && z2) {
                return f <= f2 ? 1 : 3;
            } else if (z && !z2) {
                return f <= ((float) this.e) - f2 ? 1 : 4;
            } else if (!z && z2) {
                return ((float) this.d) - f <= f2 ? 2 : 3;
            } else if (z || z2) {
                return 0;
            } else {
                return ((float) this.d) - f <= ((float) this.e) - f2 ? 2 : 4;
            }
        }
        return invokeCommon.intValue;
    }

    public final void d(float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || this.a == null) {
            return;
        }
        if (n) {
            Log.e("FullScreenFloatView", "move--> x = " + f + ", y = " + f2);
        }
        int i = (int) (f - (this.b / 2));
        int i2 = (int) (f2 - (this.c / 2));
        if (i <= 0) {
            i = 0;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int i3 = this.d;
        int i4 = this.b;
        if (i > i3 - i4) {
            i = i3 - i4;
        }
        int i5 = this.e;
        int i6 = this.c;
        if (i2 > i5 - i6) {
            i2 = i5 - i6;
        }
        int i7 = (this.d - i) - this.b;
        int i8 = (this.e - i2) - this.c;
        if (n) {
            Log.e("FullScreenFloatView", "move--> left = " + i + ", top = " + i2 + ", right = " + i7 + ",bottom = " + i8 + ", mStatusBarHeight = " + this.f);
        }
        this.a.setX(i);
        this.a.setY(i2);
        requestLayout();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07060b);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07060c);
        this.a.animate().x((le3.o(getContext()) - dimensionPixelOffset) - this.b).y((le3.n(getContext()) - dimensionPixelOffset2) - this.c).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
    }

    public c getDragImageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (c) invokeV.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.d = getHeight() + this.f;
            this.e = getWidth() - this.f;
            if (n) {
                Log.e("FullScreenFloatView", "onConfigurationChanged--> newConfig " + configuration.orientation + ", mScreenWidth = " + this.d + ", mScreenHeight = " + this.e);
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
            if (this.a == null) {
                View findViewById = findViewById(R.id.obfuscated_res_0x7f0909c9);
                this.a = findViewById;
                b(findViewById);
            }
            this.a.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.h = true;
                this.j = x;
                this.k = y;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            this.d = getWidth();
            this.e = getHeight();
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
                this.a.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.j = x;
                    this.k = y;
                    this.h = true;
                    this.g = true;
                    postDelayed(this.l, ViewConfiguration.getTapTimeout());
                }
            } else if (action == 1) {
                if (this.g) {
                    c cVar2 = this.m;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.l);
                } else if (this.h && (cVar = this.m) != null) {
                    cVar.a();
                }
                if (n) {
                    Log.e("FullScreenFloatView", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.g);
                }
                if (this.i && !this.g) {
                    int i = this.b;
                    if (x > i / 2 && x < this.d - (i / 2)) {
                        int i2 = this.c;
                        if (y > i2 / 2 && y < this.e - (i2 / 2)) {
                            int c2 = c(x, y);
                            if (n) {
                                Log.e("FullScreenFloatView", "mScreenHeight = " + this.e + ", mintype = " + c2);
                            }
                            if (c2 == 1) {
                                x = 0.0f;
                            } else if (c2 == 2) {
                                x = this.d - this.b;
                            } else if (c2 == 3) {
                                y = 0.0f;
                            } else if (c2 == 4) {
                                y = this.e - this.c;
                            }
                            if (c2 == 1 || c2 == 2) {
                                this.a.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            } else if (c2 == 3 || c2 == 4) {
                                this.a.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            }
                        }
                    }
                }
                this.g = false;
                this.h = false;
            } else if (action == 2) {
                float abs = Math.abs(x - this.j);
                float abs2 = Math.abs(y - this.k);
                if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                    this.g = false;
                }
                d(x, y);
            } else if (action == 3) {
                this.g = false;
                this.h = false;
            } else if (action == 4) {
                this.g = false;
                this.h = false;
            }
            return this.g || this.h;
        }
        return invokeL.booleanValue;
    }

    public void setAutoAttachEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i = z;
        }
    }

    public void setDragImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setFloatButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0909c9);
            if (findViewById instanceof Button) {
                ((Button) findViewById).setText(str);
            }
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f0909c9)) == null) {
            return;
        }
        findViewById.setBackgroundResource(i);
    }

    public void setStatusBarHeight() {
        int identifier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (identifier = getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android")) <= 0) {
            return;
        }
        this.f = getResources().getDimensionPixelSize(identifier);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 66;
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = new b(this, null);
        setStatusBarHeight();
    }
}
