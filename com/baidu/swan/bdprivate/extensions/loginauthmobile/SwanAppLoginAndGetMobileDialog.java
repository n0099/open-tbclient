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
import c.a.r0.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39537e;
    public FragmentActivity mActivity;
    public String mAppId;
    public String mAuthTip;
    public b mDialogCallback;
    public boolean mIsNightMode;
    public String mLaunchFrom;
    public QuickLoginInfo mQuickLoginInfo;
    public LinearLayout mRootView;

    /* loaded from: classes11.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLoginAndGetMobileDialog f39538e;

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
            this.f39538e = swanAppLoginAndGetMobileDialog;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    this.f39538e.setFinishActivity(true);
                    this.f39538e.finishDialog();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onDialogDismiss(boolean z);

        void onLoginResult(int i2);
    }

    /* loaded from: classes11.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f39539e;

        /* renamed from: f  reason: collision with root package name */
        public String f39540f;

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
            this.f39540f = str;
            this.f39539e = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (activity = this.f39539e.get()) == null) {
                return;
            }
            Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
            intent.putExtra("url", this.f39540f);
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
        this.mIsNightMode = false;
        this.mAuthTip = "";
        this.f39537e = true;
    }

    public void addClickableText(SpannableStringBuilder spannableStringBuilder, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, spannableStringBuilder, i2, str, str2) == null) {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new c(str2, this.mActivity), i2, spannableStringBuilder.length(), 33);
        }
    }

    public void finishDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.mDialogCallback;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f39537e);
            }
            dismissAllowingStateLoss();
        }
    }

    public abstract void handleLogin();

    public final void i() {
        Bundle arguments;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (arguments = getArguments()) == null) {
            return;
        }
        this.mAuthTip = arguments.getString("auth_tip");
        this.mIsNightMode = arguments.getBoolean("is_night");
        this.mQuickLoginInfo = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
        this.mLaunchFrom = arguments.getString("launch_from");
        this.mAppId = arguments.getString("app_id");
    }

    public abstract void inflateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    public final void j(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, window) == null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.mIsNightMode ? e.aiapps_login_getmobile_dark_bg : e.aiapps_login_getmobile_bg));
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

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            finishDialog();
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            i();
            getDialog().requestWindowFeature(1);
            getDialog().setCanceledOnTouchOutside(true);
            Window window = getDialog().getWindow();
            if (window == null) {
                return null;
            }
            j(window);
            inflateView(layoutInflater, viewGroup);
            updateUI();
            handleLogin();
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b bVar = this.mDialogCallback;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f39537e);
            }
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dialogInterface) == null) {
            b bVar = this.mDialogCallback;
            if (bVar != null) {
                bVar.onDialogDismiss(this.f39537e);
            }
            super.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            boolean a2 = c.a.r0.a.c1.a.M().a();
            if (a2 != this.mIsNightMode) {
                refreshUI(a2);
            }
        }
    }

    public void refreshUI(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mIsNightMode = z;
            Window window = getDialog().getWindow();
            if (window != null) {
                window.setBackgroundDrawable(getContext().getResources().getDrawable(this.mIsNightMode ? e.aiapps_login_getmobile_dark_bg : e.aiapps_login_getmobile_bg));
            }
            updateUI();
        }
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fragmentActivity) == null) {
            this.mActivity = fragmentActivity;
        }
    }

    public void setFinishActivity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f39537e = z;
        }
    }

    public void setLoginStatusCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.mDialogCallback = bVar;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, fragmentManager, str) == null) {
            try {
                super.show(fragmentManager, str);
            } catch (IllegalStateException unused) {
            }
        }
    }

    public abstract void updateUI();
}
