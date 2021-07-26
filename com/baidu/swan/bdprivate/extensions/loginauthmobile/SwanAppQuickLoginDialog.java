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
import d.a.o0.a.z1.b.f.e;
import d.a.o0.b.d;
import d.a.o0.b.f;
import d.a.o0.b.g;
/* loaded from: classes3.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseImageView n;
    public TextView o;
    public TextView p;
    public CheckBox q;
    public Button r;
    public TextView s;
    public TextView t;

    /* loaded from: classes3.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f11686e;

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
            this.f11686e = swanAppQuickLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11686e.T0(true);
                this.f11686e.N0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f11687e;

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
            this.f11687e = swanAppQuickLoginDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.f11687e.r.setClickable(true);
                    this.f11687e.r.setBackgroundResource(d.swan_reply_editor_publish_selector);
                    return;
                }
                this.f11687e.r.setClickable(false);
                e.f(this.f11687e.f11673f, g.swanapp_unchecked_auth_tip).G(true);
                this.f11687e.r.setBackgroundResource(d.swanapp_reply_editor_publish_disabled);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.o0.b.n.g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppQuickLoginDialog f11688a;

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
            this.f11688a = swanAppQuickLoginDialog;
        }

        @Override // d.a.o0.b.n.g.e
        public void onResult(int i2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11688a.f11672e.onLoginResult(i2);
                if (i2 == 0) {
                    str = "succ_agree";
                } else {
                    this.f11688a.Z0();
                    str = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                }
                SwanAppQuickLoginDialog swanAppQuickLoginDialog = this.f11688a;
                d.a.o0.b.n.d.d.a(PrefetchEvent.STATE_CLICK, "quickLogin", str, swanAppQuickLoginDialog.l, swanAppQuickLoginDialog.m);
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
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void P0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(f.swan_app_quick_login_dialog_layout, viewGroup, false);
            this.f11675h = linearLayout;
            this.n = (BdBaseImageView) linearLayout.findViewById(d.a.o0.b.e.close);
            this.o = (TextView) this.f11675h.findViewById(d.a.o0.b.e.title);
            this.q = (CheckBox) this.f11675h.findViewById(d.a.o0.b.e.phonenum_autho_switch);
            this.p = (TextView) this.f11675h.findViewById(d.a.o0.b.e.user_phone_number);
            this.r = (Button) this.f11675h.findViewById(d.a.o0.b.e.user_quick_login);
            this.s = (TextView) this.f11675h.findViewById(d.a.o0.b.e.user_login_with_other_phone);
            this.t = (TextView) this.f11675h.findViewById(d.a.o0.b.e.user_service_agreement);
            c1();
            b1();
            QuickLoginInfo quickLoginInfo = this.j;
            if (quickLoginInfo != null) {
                this.p.setText(quickLoginInfo.encryptPhoneNum);
            }
            this.s.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.q.setOnCheckedChangeListener(new b(this));
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Resources resources = getContext().getResources();
            this.n.setImageDrawable(resources.getDrawable(d.swanapp_login_dialog_close));
            this.o.setTextColor(resources.getColor(this.f11674g ? d.a.o0.b.c.aiapps_login_dialog_title_dark : d.a.o0.b.c.aiapps_login_dialog_title));
            this.p.setTextColor(resources.getColor(this.f11674g ? d.a.o0.b.c.aiapps_login_dialog_title_dark : d.a.o0.b.c.swan_app_color_000000));
            this.q.setTextColor(resources.getColor(this.f11674g ? d.a.o0.b.c.aiapps_login_dialog_title_dark : d.a.o0.b.c.aiapps_login_dialog_title));
            this.q.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f11674g ? d.aiapp_login_and_phonenum_autho_selector_dark : d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final void Z0() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fragmentManager = getFragmentManager()) == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        T0(false);
        SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) d.a.o0.b.n.d.e.a(this.f11676i, this.f11674g, null, this.l, this.m);
        swanAppPhoneLoginDialog.S0(getActivity());
        swanAppPhoneLoginDialog.d1(true);
        swanAppPhoneLoginDialog.U0((SwanAppLoginAndGetMobileDialog.b) this.f11673f);
        swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
        d.a.o0.b.n.d.d.a("show", "telLogin", null, this.l, this.m);
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!SwanAppNetworkUtils.i(this.f11673f)) {
                e.f(this.f11673f, g.swanapp_login_not_internet).G(true);
                return;
            }
            QuickLoginInfo quickLoginInfo = this.j;
            if (quickLoginInfo == null) {
                return;
            }
            d.a.o0.b.n.g.f.e(this.f11673f, quickLoginInfo.loginMode, new c(this));
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String string = getContext().getString(g.swanapp_phonenum_checkbox_tip);
            CheckBox checkBox = this.q;
            if (!TextUtils.isEmpty(this.f11676i)) {
                string = String.format(getString(g.swanapp_auth_switch_tip), this.f11676i);
            }
            checkBox.setText(string);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_tip));
            if (this.j != null) {
                int length = spannableStringBuilder.length();
                QuickLoginInfo quickLoginInfo = this.j;
                M0(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
                spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_comma));
            }
            M0(spannableStringBuilder, spannableStringBuilder.length(), getString(g.swanapp_service_agreement_swan), d.a.o0.a.c1.a.n().D());
            spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_comma));
            M0(spannableStringBuilder, spannableStringBuilder.length(), getString(g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
            spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_register_tip));
            this.t.setMovementMethod(LinkMovementMethod.getInstance());
            this.t.setText(spannableStringBuilder);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            if (id == d.a.o0.b.e.user_login_with_other_phone) {
                Z0();
            } else if (id == d.a.o0.b.e.user_quick_login) {
                a1();
            } else if (id == d.a.o0.b.e.close) {
                T0(true);
                N0();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) ? new a(this, this.f11673f, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
        }
    }
}
