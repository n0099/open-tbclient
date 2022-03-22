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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentActivity f29377b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29378c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f29379d;

    /* renamed from: e  reason: collision with root package name */
    public String f29380e;

    /* renamed from: f  reason: collision with root package name */
    public QuickLoginInfo f29381f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29382g;

    /* renamed from: h  reason: collision with root package name */
    public String f29383h;
    public String i;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppLoginAndGetMobileDialog a;

        public a(SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLoginAndGetMobileDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppLoginAndGetMobileDialog;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    this.a.J0(true);
                    this.a.D0();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onDialogDismiss(boolean z);

        void onLoginResult(int i);
    }

    /* loaded from: classes4.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Activity> a;

        /* renamed from: b  reason: collision with root package name */
        public String f29384b;

        public c(String str, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29384b = str;
            this.a = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.a.get()) == null) {
                return;
            }
            Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
            intent.putExtra("url", this.f29384b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29378c = false;
        this.f29380e = "";
        this.f29382g = true;
    }

    public void C0(SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, spannableStringBuilder, i, str, str2) == null) {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new c(str2, this.f29377b), i, spannableStringBuilder.length(), 33);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f29382g);
            }
            dismissAllowingStateLoss();
        }
    }

    public abstract void E0();

    public abstract void F0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f29378c = z;
            Window window = getDialog().getWindow();
            if (window != null) {
                window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f29378c ? R.drawable.obfuscated_res_0x7f08019a : R.drawable.obfuscated_res_0x7f080199));
            }
            M0();
        }
    }

    public final void H0() {
        Bundle arguments;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (arguments = getArguments()) == null) {
            return;
        }
        this.f29380e = arguments.getString("auth_tip");
        this.f29378c = arguments.getBoolean("is_night");
        this.f29381f = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
        this.f29383h = arguments.getString("launch_from");
        this.i = arguments.getString("app_id");
    }

    public void I0(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fragmentActivity) == null) {
            this.f29377b = fragmentActivity;
        }
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f29382g = z;
        }
    }

    public void K0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public final void L0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, window) == null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f29378c ? R.drawable.obfuscated_res_0x7f08019a : R.drawable.obfuscated_res_0x7f080199));
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

    public abstract void M0();

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            D0();
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
            H0();
            getDialog().requestWindowFeature(1);
            getDialog().setCanceledOnTouchOutside(true);
            Window window = getDialog().getWindow();
            if (window == null) {
                return null;
            }
            L0(window);
            F0(layoutInflater, viewGroup);
            M0();
            E0();
            return this.f29379d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f29382g);
            }
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dialogInterface) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f29382g);
            }
            super.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            boolean a2 = c.a.n0.a.s0.a.M().a();
            if (a2 != this.f29378c) {
                G0(a2);
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
