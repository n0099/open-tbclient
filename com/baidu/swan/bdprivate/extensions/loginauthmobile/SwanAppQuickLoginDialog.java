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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import c.a.p0.b.e;
import c.a.p0.b.f;
import c.a.p0.b.g;
import c.a.p0.b.h;
import c.a.p0.b.p.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseImageView f46765f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46766g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46767h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f46768i;

    /* renamed from: j  reason: collision with root package name */
    public Button f46769j;
    public TextView k;
    public TextView l;

    /* loaded from: classes6.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f46770e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppQuickLoginDialog swanAppQuickLoginDialog, Context context, int i2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog, context, Integer.valueOf(i2)};
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
            this.f46770e = swanAppQuickLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46770e.setFinishActivity(true);
                this.f46770e.finishDialog();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f46771e;

        public b(SwanAppQuickLoginDialog swanAppQuickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46771e = swanAppQuickLoginDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.f46771e.f46769j.setClickable(true);
                    this.f46771e.f46769j.setBackgroundResource(e.swan_reply_editor_publish_selector);
                    return;
                }
                this.f46771e.f46769j.setClickable(false);
                c.a.p0.a.z1.b.f.e.f(this.f46771e.mActivity, h.swanapp_unchecked_auth_tip).G(true);
                this.f46771e.f46769j.setBackgroundResource(e.swanapp_reply_editor_publish_disabled);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.p0.b.p.g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f46772a;

        public c(SwanAppQuickLoginDialog swanAppQuickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46772a = swanAppQuickLoginDialog;
        }

        @Override // c.a.p0.b.p.g.e
        public void onResult(int i2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f46772a.mDialogCallback.onLoginResult(i2);
                if (i2 == 0) {
                    str = "succ_agree";
                } else {
                    this.f46772a.k();
                    str = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                }
                SwanAppQuickLoginDialog swanAppQuickLoginDialog = this.f46772a;
                d.a(PrefetchEvent.STATE_CLICK, "quickLogin", str, swanAppQuickLoginDialog.mLaunchFrom, swanAppQuickLoginDialog.mAppId);
            }
        }
    }

    public SwanAppQuickLoginDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void handleLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void inflateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(g.swan_app_quick_login_dialog_layout, viewGroup, false);
            this.mRootView = linearLayout;
            this.f46765f = (BdBaseImageView) linearLayout.findViewById(f.close);
            this.f46766g = (TextView) this.mRootView.findViewById(f.title);
            this.f46768i = (CheckBox) this.mRootView.findViewById(f.phonenum_autho_switch);
            this.f46767h = (TextView) this.mRootView.findViewById(f.user_phone_number);
            this.f46769j = (Button) this.mRootView.findViewById(f.user_quick_login);
            this.k = (TextView) this.mRootView.findViewById(f.user_login_with_other_phone);
            this.l = (TextView) this.mRootView.findViewById(f.user_service_agreement);
            n();
            m();
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo != null) {
                this.f46767h.setText(quickLoginInfo.encryptPhoneNum);
            }
            this.k.setOnClickListener(this);
            this.f46769j.setOnClickListener(this);
            this.f46765f.setOnClickListener(this);
            this.f46768i.setOnCheckedChangeListener(new b(this));
        }
    }

    public final void k() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fragmentManager = getFragmentManager()) == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        setFinishActivity(false);
        SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) c.a.p0.b.p.d.e.a(this.mAuthTip, this.mIsNightMode, null, this.mLaunchFrom, this.mAppId);
        swanAppPhoneLoginDialog.setActivity(getActivity());
        swanAppPhoneLoginDialog.setBackView(true);
        swanAppPhoneLoginDialog.setLoginStatusCallback((SwanAppLoginAndGetMobileDialog.b) this.mActivity);
        swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
        d.a("show", "telLogin", null, this.mLaunchFrom, this.mAppId);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!SwanAppNetworkUtils.i(this.mActivity)) {
                c.a.p0.a.z1.b.f.e.f(this.mActivity, h.swanapp_login_not_internet).G(true);
                return;
            }
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo == null) {
                return;
            }
            c.a.p0.b.p.g.f.e(this.mActivity, quickLoginInfo.loginMode, new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String string = getContext().getString(h.swanapp_phonenum_checkbox_tip);
            CheckBox checkBox = this.f46768i;
            if (!TextUtils.isEmpty(this.mAuthTip)) {
                string = String.format(getString(h.swanapp_auth_switch_tip), this.mAuthTip);
            }
            checkBox.setText(string);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(h.swanapp_service_agreement_tip));
            if (this.mQuickLoginInfo != null) {
                int length = spannableStringBuilder.length();
                QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
                addClickableText(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
                spannableStringBuilder.append((CharSequence) getString(h.swanapp_service_agreement_comma));
            }
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(h.swanapp_service_agreement_swan), c.a.p0.a.c1.a.n().D());
            spannableStringBuilder.append((CharSequence) getString(h.swanapp_service_agreement_comma));
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(h.swanapp_service_agreement_baidu), SwanAppPhoneLoginDialog.PASS_ACCOUNT_AGREE);
            spannableStringBuilder.append((CharSequence) getString(h.swanapp_service_agreement_register_tip));
            this.l.setMovementMethod(LinkMovementMethod.getInstance());
            this.l.setText(spannableStringBuilder);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            int id = view.getId();
            if (id == f.user_login_with_other_phone) {
                k();
            } else if (id == f.user_quick_login) {
                l();
            } else if (id == f.close) {
                setFinishActivity(true);
                finishDialog();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) ? new a(this, this.mActivity, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Resources resources = getContext().getResources();
            this.f46765f.setImageDrawable(resources.getDrawable(e.swanapp_login_dialog_close));
            this.f46766g.setTextColor(resources.getColor(this.mIsNightMode ? c.a.p0.b.c.aiapps_login_dialog_title_dark : c.a.p0.b.c.aiapps_login_dialog_title));
            this.f46767h.setTextColor(resources.getColor(this.mIsNightMode ? c.a.p0.b.c.aiapps_login_dialog_title_dark : c.a.p0.b.c.swan_app_color_000000));
            this.f46768i.setTextColor(resources.getColor(this.mIsNightMode ? c.a.p0.b.c.aiapps_login_dialog_title_dark : c.a.p0.b.c.aiapps_login_dialog_title));
            this.f46768i.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.mIsNightMode ? e.aiapp_login_and_phonenum_autho_selector_dark : e.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
