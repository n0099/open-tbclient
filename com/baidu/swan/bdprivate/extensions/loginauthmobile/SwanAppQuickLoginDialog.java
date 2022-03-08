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
import c.a.p0.a.s1.b.f.e;
import c.a.p0.b.g.b.d;
import c.a.p0.b.g.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseImageView f38183f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38184g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38185h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f38186i;

    /* renamed from: j  reason: collision with root package name */
    public Button f38187j;
    public TextView k;
    public TextView l;

    /* loaded from: classes5.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f38188e;

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
            this.f38188e = swanAppQuickLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38188e.setFinishActivity(true);
                this.f38188e.finishDialog();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f38189e;

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
            this.f38189e = swanAppQuickLoginDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.f38189e.f38187j.setClickable(true);
                    this.f38189e.f38187j.setBackgroundResource(R.drawable.swan_reply_editor_publish_selector);
                    return;
                }
                this.f38189e.f38187j.setClickable(false);
                e.f(this.f38189e.mActivity, R.string.swanapp_unchecked_auth_tip).H(true);
                this.f38189e.f38187j.setBackgroundResource(R.drawable.swanapp_reply_editor_publish_disabled);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.p0.b.g.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppQuickLoginDialog a;

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
            this.a = swanAppQuickLoginDialog;
        }

        @Override // c.a.p0.b.g.d.e
        public void onResult(int i2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.mDialogCallback.onLoginResult(i2);
                if (i2 == 0) {
                    str = "succ_agree";
                } else {
                    this.a.n();
                    str = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                }
                SwanAppQuickLoginDialog swanAppQuickLoginDialog = this.a;
                d.a("click", "quickLogin", str, swanAppQuickLoginDialog.mLaunchFrom, swanAppQuickLoginDialog.mAppId);
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
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.swan_app_quick_login_dialog_layout, viewGroup, false);
            this.mRootView = linearLayout;
            this.f38183f = (BdBaseImageView) linearLayout.findViewById(R.id.close);
            this.f38184g = (TextView) this.mRootView.findViewById(R.id.title);
            this.f38186i = (CheckBox) this.mRootView.findViewById(R.id.phonenum_autho_switch);
            this.f38185h = (TextView) this.mRootView.findViewById(R.id.user_phone_number);
            this.f38187j = (Button) this.mRootView.findViewById(R.id.user_quick_login);
            this.k = (TextView) this.mRootView.findViewById(R.id.user_login_with_other_phone);
            this.l = (TextView) this.mRootView.findViewById(R.id.user_service_agreement);
            q();
            p();
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo != null) {
                this.f38185h.setText(quickLoginInfo.encryptPhoneNum);
            }
            this.k.setOnClickListener(this);
            this.f38187j.setOnClickListener(this);
            this.f38183f.setOnClickListener(this);
            this.f38186i.setOnCheckedChangeListener(new b(this));
        }
    }

    public final void n() {
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
        SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) c.a.p0.b.g.b.e.a(this.mAuthTip, this.mIsNightMode, null, this.mLaunchFrom, this.mAppId);
        swanAppPhoneLoginDialog.setActivity(getActivity());
        swanAppPhoneLoginDialog.setBackView(true);
        swanAppPhoneLoginDialog.setLoginStatusCallback((SwanAppLoginAndGetMobileDialog.b) this.mActivity);
        swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
        d.a("show", "telLogin", null, this.mLaunchFrom, this.mAppId);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!SwanAppNetworkUtils.i(this.mActivity)) {
                e.f(this.mActivity, R.string.swanapp_login_not_internet).H(true);
                return;
            }
            QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
            if (quickLoginInfo == null) {
                return;
            }
            f.e(this.mActivity, quickLoginInfo.loginMode, new c(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            int id = view.getId();
            if (id == R.id.user_login_with_other_phone) {
                n();
            } else if (id == R.id.user_quick_login) {
                o();
            } else if (id == R.id.close) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) ? new a(this, this.mActivity, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String string = getContext().getString(R.string.swanapp_phonenum_checkbox_tip);
            CheckBox checkBox = this.f38186i;
            if (!TextUtils.isEmpty(this.mAuthTip)) {
                string = String.format(getString(R.string.swanapp_auth_switch_tip), this.mAuthTip);
            }
            checkBox.setText(string);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_tip));
            if (this.mQuickLoginInfo != null) {
                int length = spannableStringBuilder.length();
                QuickLoginInfo quickLoginInfo = this.mQuickLoginInfo;
                addClickableText(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
                spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_comma));
            }
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.swanapp_service_agreement_swan), c.a.p0.a.s0.a.o().G());
            spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_comma));
            addClickableText(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.swanapp_service_agreement_baidu), SwanAppPhoneLoginDialog.PASS_ACCOUNT_AGREE);
            spannableStringBuilder.append((CharSequence) getString(R.string.swanapp_service_agreement_register_tip));
            this.l.setMovementMethod(LinkMovementMethod.getInstance());
            this.l.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Resources resources = getContext().getResources();
            this.f38183f.setImageDrawable(resources.getDrawable(R.drawable.swanapp_login_dialog_close));
            TextView textView = this.f38184g;
            boolean z = this.mIsNightMode;
            int i2 = R.color.aiapps_login_dialog_title;
            textView.setTextColor(resources.getColor(z ? R.color.aiapps_login_dialog_title_dark : R.color.aiapps_login_dialog_title));
            this.f38185h.setTextColor(resources.getColor(this.mIsNightMode ? R.color.aiapps_login_dialog_title_dark : R.color.swan_app_color_000000));
            CheckBox checkBox = this.f38186i;
            if (this.mIsNightMode) {
                i2 = R.color.aiapps_login_dialog_title_dark;
            }
            checkBox.setTextColor(resources.getColor(i2));
            this.f38186i.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.mIsNightMode ? R.drawable.aiapp_login_and_phonenum_autho_selector_dark : R.drawable.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
