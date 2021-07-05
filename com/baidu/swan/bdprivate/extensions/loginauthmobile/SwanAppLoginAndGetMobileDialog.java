package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.b.d;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f11629e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentActivity f11630f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11631g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f11632h;

    /* renamed from: i  reason: collision with root package name */
    public String f11633i;
    public QuickLoginInfo j;
    public boolean k;
    public String l;
    public String m;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLoginAndGetMobileDialog f11634e;

        public a(SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLoginAndGetMobileDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11634e = swanAppLoginAndGetMobileDialog;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    this.f11634e.N0(true);
                    this.f11634e.H0();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onDialogDismiss(boolean z);

        void onLoginResult(int i2);
    }

    /* loaded from: classes4.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f11635e;

        /* renamed from: f  reason: collision with root package name */
        public String f11636f;

        public c(String str, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11636f = str;
            this.f11635e = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.f11635e.get()) == null) {
                return;
            }
            Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
            intent.putExtra("url", this.f11636f);
            activity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor("#3388FF"));
            }
        }
    }

    public SwanAppLoginAndGetMobileDialog() {
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
        this.f11631g = false;
        this.f11633i = "";
        this.k = true;
    }

    public void G0(SpannableStringBuilder spannableStringBuilder, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, spannableStringBuilder, i2, str, str2) == null) {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new c(str2, this.f11630f), i2, spannableStringBuilder.length(), 33);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.f11629e;
            if (bVar != null) {
                bVar.onDialogDismiss(this.k);
            }
            dismissAllowingStateLoss();
        }
    }

    public abstract void I0();

    public abstract void J0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f11631g = z;
            Window window = getDialog().getWindow();
            if (window != null) {
                window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f11631g ? d.aiapps_login_getmobile_dark_bg : d.aiapps_login_getmobile_bg));
            }
            Q0();
        }
    }

    public final void L0() {
        Bundle arguments;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (arguments = getArguments()) == null) {
            return;
        }
        this.f11633i = arguments.getString("auth_tip");
        this.f11631g = arguments.getBoolean("is_night");
        this.j = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
        this.l = arguments.getString("launch_from");
        this.m = arguments.getString("app_id");
    }

    public void M0(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fragmentActivity) == null) {
            this.f11630f = fragmentActivity;
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    public void O0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f11629e = bVar;
        }
    }

    public final void P0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, window) == null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f11631g ? d.aiapps_login_getmobile_dark_bg : d.aiapps_login_getmobile_bg));
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setFlags(32, 32);
            window.setFlags(262144, 262144);
            window.getDecorView().setOnTouchListener(new a(this));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public abstract void Q0();

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            H0();
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            L0();
            getDialog().requestWindowFeature(1);
            getDialog().setCanceledOnTouchOutside(true);
            Window window = getDialog().getWindow();
            if (window == null) {
                return null;
            }
            P0(window);
            J0(layoutInflater, viewGroup);
            Q0();
            I0();
            return this.f11632h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.f11629e;
            if (bVar != null) {
                bVar.onDialogDismiss(this.k);
            }
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dialogInterface) == null) {
            b bVar = this.f11629e;
            if (bVar != null) {
                bVar.onDialogDismiss(this.k);
            }
            super.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            boolean a2 = d.a.q0.a.c1.a.H().a();
            if (a2 != this.f11631g) {
                K0(a2);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, fragmentManager, str) == null) {
            try {
                super.show(fragmentManager, str);
            } catch (IllegalStateException unused) {
            }
        }
    }
}
