package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PASS_ACCOUNT_AGREE = "https://passport.baidu.com/static/passpc-account/html/protocal.html";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseImageView f38173f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseImageView f38174g;

    /* renamed from: h  reason: collision with root package name */
    public AccountSmsLoginView f38175h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f38176i;

    /* renamed from: j  reason: collision with root package name */
    public CheckBox f38177j;
    public TextView k;
    public boolean l;
    public boolean m;
    public EditText n;
    public TextView o;
    public View p;

    /* loaded from: classes5.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog f38178e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog, Context context, int i2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38178e = swanAppPhoneLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.f38178e;
                swanAppPhoneLoginDialog.setFinishActivity(!swanAppPhoneLoginDialog.m);
                this.f38178e.finishDialog();
                if (this.f38178e.m) {
                    FragmentManager fragmentManager = this.f38178e.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = this.f38178e;
                    c.a.p0.b.g.b.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.mLaunchFrom, swanAppPhoneLoginDialog2.mAppId);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog f38179e;

        public b(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38179e = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38179e.setFinishActivity(true);
                this.f38179e.finishDialog();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog f38180e;

        public c(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38180e = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38180e.setFinishActivity(false);
                this.f38180e.finishDialog();
                FragmentManager fragmentManager = this.f38180e.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.f38180e;
                c.a.p0.b.g.b.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog.mLaunchFrom, swanAppPhoneLoginDialog.mAppId);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public d(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f38177j.setVisibility(8);
                this.a.o.setVisibility(8);
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f38177j.setVisibility(0);
                this.a.o.setVisibility(0);
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                c.a.p0.b.g.b.d.a("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0, swanAppPhoneLoginDialog.mLaunchFrom, swanAppPhoneLoginDialog.mAppId);
                if (this.a.l) {
                    this.a.finishDialog();
                    return;
                }
                SwanAppLoginAndGetMobileDialog.b bVar = this.a.mDialogCallback;
                if (bVar != null) {
                    bVar.onLoginResult(-1);
                }
                FragmentActivity fragmentActivity = this.a.mActivity;
                if (fragmentActivity == null || fragmentActivity.getWindow() == null) {
                    return;
                }
                FragmentActivity fragmentActivity2 = this.a.mActivity;
                x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                c.a.p0.b.g.b.d.a("click", "telLogin", "succ_agree", swanAppPhoneLoginDialog.mLaunchFrom, swanAppPhoneLoginDialog.mAppId);
                FragmentActivity fragmentActivity = this.a.mActivity;
                if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                    FragmentActivity fragmentActivity2 = this.a.mActivity;
                    x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
                }
                SwanAppLoginAndGetMobileDialog.b bVar = this.a.mDialogCallback;
                if (bVar != null) {
                    bVar.onLoginResult(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog f38181e;

        public e(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38181e = swanAppPhoneLoginDialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38181e.f38175h == null) {
                return;
            }
            this.f38181e.f38175h.clean();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog f38182e;

        public f(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38182e = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.s1.b.f.e.f(this.f38182e.mActivity, R.string.swanapp_unchecked_auth_tip).H(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();

        void b();

        void onFailure();

        void onSuccess();
    }

    public SwanAppPhoneLoginDialog() {
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
        this.l = false;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void finishDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AccountSmsLoginView accountSmsLoginView = this.f38175h;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.finishDialog();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void handleLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CheckBox checkBox = this.f38177j;
            if (checkBox != null) {
                checkBox.setVisibility(0);
                this.f38177j.setOnCheckedChangeListener(this);
            }
            TextView textView = this.o;
            if (textView != null) {
                textView.setVisibility(0);
            }
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("sms_login", "native");
                str = URLEncoder.encode(jSONObject.toString(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            c.a.p0.b.c.a.P(getContext(), new d(this), str);
            AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
            this.f38175h = accountSmsLoginView;
            this.f38176i.addView(accountSmsLoginView);
            this.n = (EditText) this.mRootView.findViewById(R.id.phone);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n0.g(80.0f));
            layoutParams.setMargins(n0.g(40.0f), 0, n0.g(40.0f), 0);
            this.f38176i.addView(this.p, layoutParams);
            this.p.setVisibility(8);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void inflateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
            this.mRootView = linearLayout;
            this.f38173f = (BdBaseImageView) linearLayout.findViewById(R.id.close);
            this.f38174g = (BdBaseImageView) this.mRootView.findViewById(R.id.back);
            this.f38177j = (CheckBox) this.mRootView.findViewById(R.id.phonenum_autho_switch);
            this.f38176i = (FrameLayout) this.mRootView.findViewById(R.id.login_input_layout);
            this.p = new View(getContext());
            this.k = (TextView) this.mRootView.findViewById(R.id.title);
            this.o = (TextView) this.mRootView.findViewById(R.id.user_service_agreement);
            r();
            this.f38173f.setOnClickListener(new b(this));
            if (this.m) {
                this.f38174g.setVisibility(0);
                this.f38174g.setOnClickListener(new c(this));
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, compoundButton, z) == null) {
            if (z) {
                this.p.setVisibility(8);
                this.n.setEnabled(true);
                this.f38175h.requestFocusAndShowKeyBoard();
                return;
            }
            this.p.setVisibility(0);
            this.p.setOnClickListener(new f(this));
            this.n.setEnabled(false);
            c.a.p0.a.s1.b.f.e.f(this.mActivity, R.string.swanapp_unchecked_auth_tip).H(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) ? new a(this, this.mActivity, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            q();
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AccountSmsLoginView accountSmsLoginView = this.f38175h;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) {
            AccountSmsLoginView accountSmsLoginView = this.f38175h;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.onDismiss(dialogInterface);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String string = getContext().getString(R.string.swanapp_phonenum_checkbox_tip);
            CheckBox checkBox = this.f38177j;
            if (!TextUtils.isEmpty(this.mAuthTip)) {
                string = String.format(getString(R.string.swanapp_auth_switch_tip), this.mAuthTip);
            }
            checkBox.setText(string);
            this.f38175h.postDelayed(new e(this), 150L);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_tip));
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.swanapp_service_agreement_swan), c.a.p0.a.s0.a.o().G());
            spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_comma));
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.swanapp_service_agreement_baidu), PASS_ACCOUNT_AGREE);
            this.o.setMovementMethod(LinkMovementMethod.getInstance());
            this.o.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void refreshUI(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.refreshUI(z);
            if (this.f38176i != null && (accountSmsLoginView = this.f38175h) != null) {
                accountSmsLoginView.close();
                this.f38176i.removeView(this.f38175h);
            }
            handleLogin();
        }
    }

    public void setBackView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void updateUI() {
        Resources resources;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (resources = getContext().getResources()) == null) {
            return;
        }
        this.f38173f.setImageDrawable(resources.getDrawable(R.drawable.swanapp_login_dialog_close));
        this.f38174g.setImageDrawable(resources.getDrawable(R.drawable.aiapps_action_bar_back_selector));
        TextView textView = this.k;
        boolean z = this.mIsNightMode;
        int i2 = R.color.aiapps_login_dialog_title_dark;
        textView.setTextColor(resources.getColor(z ? R.color.aiapps_login_dialog_title_dark : R.color.aiapps_login_dialog_title));
        CheckBox checkBox = this.f38177j;
        if (!this.mIsNightMode) {
            i2 = R.color.aiapps_login_dialog_title;
        }
        checkBox.setTextColor(resources.getColor(i2));
        this.f38177j.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.mIsNightMode ? R.drawable.aiapp_login_and_phonenum_autho_selector_dark : R.drawable.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
