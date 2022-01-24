package com.baidu.apollon.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class WalletToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f32406h = 3500;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32407i = 2000;

    /* renamed from: j  reason: collision with root package name */
    public static List<View> f32408j;
    public static CancleRunnable k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f32409b;

    /* renamed from: c  reason: collision with root package name */
    public int f32410c;

    /* renamed from: d  reason: collision with root package name */
    public int f32411d;

    /* renamed from: e  reason: collision with root package name */
    public int f32412e;

    /* renamed from: f  reason: collision with root package name */
    public float f32413f;

    /* renamed from: g  reason: collision with root package name */
    public float f32414g;
    public WindowManager l;
    public View m;
    public WindowManager.LayoutParams n;
    public Handler o;

    /* loaded from: classes10.dex */
    public class CancleRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WalletToast f32415b;

        public CancleRunnable(WalletToast walletToast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletToast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32415b = walletToast;
            this.a = false;
        }

        public void discard() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a) {
                return;
            }
            this.f32415b.a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1015857080, "Lcom/baidu/apollon/base/widget/WalletToast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1015857080, "Lcom/baidu/apollon/base/widget/WalletToast;");
                return;
            }
        }
        f32408j = new ArrayList();
    }

    public WalletToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new Handler(Looper.getMainLooper());
        this.l = (WindowManager) context.getSystemService("window");
        this.a = context;
        Toast toast = new Toast(context);
        this.f32412e = toast.getYOffset();
        a(toast);
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32409b : invokeV.intValue;
    }

    public int getGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32410c : invokeV.intValue;
    }

    public float getHorizontalMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32414g : invokeV.floatValue;
    }

    public float getVerticalMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32413f : invokeV.floatValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int getXOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32411d : invokeV.intValue;
    }

    public int getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32412e : invokeV.intValue;
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f32409b = i2;
        }
    }

    public void setGravity(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            this.f32410c = i2;
            this.f32411d = i3;
            this.f32412e = i4;
        }
    }

    public void setMargin(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f32414g = f2;
            this.f32413f = f3;
        }
    }

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            this.m = view;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.post(new Runnable(this) { // from class: com.baidu.apollon.base.widget.WalletToast.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletToast a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                        WalletToast walletToast = this.a;
                        walletToast.a(walletToast.m);
                    }
                }
            });
        }
    }

    private void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, view) == null) || view == null || view.getParent() == null) {
            return;
        }
        try {
            this.l.removeView(view);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Toast toast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, toast) == null) {
            try {
                Field declaredField = toast.getClass().getDeclaredField("mTN");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(toast);
                Field declaredField2 = obj.getClass().getDeclaredField("mParams");
                declaredField2.setAccessible(true);
                this.n = (WindowManager.LayoutParams) declaredField2.get(obj);
            } catch (Exception e2) {
                e2.printStackTrace();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                this.n = layoutParams;
                layoutParams.height = -2;
                layoutParams.width = -2;
                layoutParams.format = -3;
                layoutParams.type = 2005;
                layoutParams.windowAnimations = ResUtils.style(this.a, "EbpayActivityAnim2");
                this.n.setTitle("Toast");
                this.n.flags = 152;
            }
            this.f32410c = 17;
            this.f32412e = 0;
            this.m = toast.getView();
        }
    }

    @SuppressLint({"ShowToast"})
    public WalletToast(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = new Handler(Looper.getMainLooper());
        this.l = (WindowManager) context.getSystemService("window");
        this.a = context;
        Toast makeText = Toast.makeText(context, str, i2);
        this.f32412e = makeText.getYOffset();
        a(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            CancleRunnable cancleRunnable = k;
            if (cancleRunnable != null) {
                cancleRunnable.discard();
                this.o.removeCallbacks(k);
                k = null;
            }
            for (View view : f32408j) {
                b(view);
            }
            f32408j.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view) == null) {
            Context applicationContext = DxmApplicationContextImpl.getApplicationContext(this.a);
            if (applicationContext == null) {
                applicationContext = this.a;
            }
            this.l = (WindowManager) applicationContext.getSystemService("window");
            int i2 = this.f32410c;
            WindowManager.LayoutParams layoutParams = this.n;
            layoutParams.gravity = i2;
            if ((i2 & 7) == 7) {
                layoutParams.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                this.n.verticalWeight = 1.0f;
            }
            WindowManager.LayoutParams layoutParams2 = this.n;
            layoutParams2.x = this.f32411d;
            layoutParams2.y = this.f32412e;
            layoutParams2.verticalMargin = this.f32413f;
            layoutParams2.horizontalMargin = this.f32414g;
            try {
                if (view.getParent() != null) {
                    this.l.updateViewLayout(view, this.n);
                } else {
                    this.l.addView(view, this.n);
                }
                f32408j.add(view);
                CancleRunnable cancleRunnable = new CancleRunnable(this);
                k = cancleRunnable;
                this.o.postDelayed(cancleRunnable, this.f32409b == 1 ? 3500L : 2000L);
            } catch (Exception unused) {
            }
        }
    }
}
