package com.baidu.apollon.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes10.dex */
public class StatusBarManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mBarParams;

    /* renamed from: com.baidu.apollon.statusbar.StatusBarManager$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public StatusBarManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        buildParams();
    }

    private void setupStatusBarView(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, activity) == null) {
            a aVar = this.mBarParams;
            if (aVar.f32656d == null) {
                aVar.f32656d = new View(activity);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity));
            layoutParams.gravity = 48;
            this.mBarParams.f32656d.setLayoutParams(layoutParams);
            a aVar2 = this.mBarParams;
            aVar2.f32656d.setBackgroundColor(StatusBarUtils.blendARGB(aVar2.a, aVar2.f32654b, aVar2.f32655c));
            this.mBarParams.f32656d.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.mBarParams.f32656d.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mBarParams.f32656d);
            }
            ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mBarParams.f32656d);
        }
    }

    public void apply(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || activity == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            r2 = this.mBarParams.f32657e ? 9472 : 1280;
            Window window = activity.getWindow();
            a aVar = this.mBarParams;
            window.setStatusBarColor(StatusBarUtils.blendARGB(aVar.a, aVar.f32654b, aVar.f32655c));
            activity.getWindow().getDecorView().setSystemUiVisibility(r2);
        } else if (i2 >= 19) {
            int i3 = 256;
            if (i2 >= 21 && !ImmersiveOSUtils.isEMUI3_1()) {
                activity.getWindow().clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                r2 = (Build.VERSION.SDK_INT < 23 || !this.mBarParams.f32657e) ? 1280 : 1280;
                Window window2 = activity.getWindow();
                a aVar2 = this.mBarParams;
                window2.setStatusBarColor(StatusBarUtils.blendARGB(aVar2.a, aVar2.f32654b, aVar2.f32655c));
                i3 = r2;
            } else {
                activity.getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                setupStatusBarView(activity);
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i3);
            if (ImmersiveOSUtils.isMIUI6Plus()) {
                StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), this.mBarParams.f32657e);
            }
            if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                a aVar3 = this.mBarParams;
                int i4 = aVar3.f32658f;
                if (i4 != 0) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, i4);
                } else if (Build.VERSION.SDK_INT < 23) {
                    FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, aVar3.f32657e);
                }
            }
        }
    }

    public void buildParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mBarParams = new a(this, null);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mBarParams = null;
        }
    }

    public void setFlymeStatusBarFontColor(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, context, i2) == null) {
            this.mBarParams.f32658f = context.getResources().getColor(i2);
        }
    }

    public void setTitleAlpha(View view, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || view == null) {
            return;
        }
        view.setBackgroundColor(StatusBarUtils.blendARGB(0, view.getContext().getResources().getColor(i2), f2));
    }

    public void statusBarAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mBarParams.f32655c = f2;
        }
    }

    public void statusBarColor(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i2) == null) {
            statusBarColorInt(context.getResources().getColor(i2));
        }
    }

    public void statusBarColorInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mBarParams.a = i2;
        }
    }

    public void statusBarDarkFont(boolean z, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            if (!z) {
                this.mBarParams.f32658f = 0;
            }
            if (ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
                if (ImmersiveOSUtils.isSpecialOS() && z) {
                    a aVar = this.mBarParams;
                    aVar.f32655c = f2;
                    aVar.f32657e = false;
                    return;
                }
                a aVar2 = this.mBarParams;
                aVar2.f32657e = z;
                aVar2.f32655c = 0.0f;
                return;
            }
            this.mBarParams.f32655c = f2;
        }
    }

    /* loaded from: classes10.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f32654b;

        /* renamed from: c  reason: collision with root package name */
        public float f32655c;

        /* renamed from: d  reason: collision with root package name */
        public View f32656d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32657e;

        /* renamed from: f  reason: collision with root package name */
        public int f32658f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ StatusBarManager f32659g;

        public a(StatusBarManager statusBarManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {statusBarManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32659g = statusBarManager;
            this.a = 0;
            this.f32654b = -16777216;
            this.f32655c = 0.0f;
            this.f32657e = false;
        }

        public /* synthetic */ a(StatusBarManager statusBarManager, AnonymousClass1 anonymousClass1) {
            this(statusBarManager);
        }
    }
}
