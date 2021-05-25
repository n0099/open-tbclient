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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import d.a.l0.a.z1.b.f.e;
import d.a.l0.b.d;
import d.a.l0.b.f;
import d.a.l0.b.g;
/* loaded from: classes3.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public BdBaseImageView n;
    public TextView o;
    public TextView p;
    public CheckBox q;
    public Button r;
    public TextView s;
    public TextView t;

    /* loaded from: classes3.dex */
    public class a extends Dialog {
        public a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppQuickLoginDialog.this.K0(true);
            SwanAppQuickLoginDialog.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                SwanAppQuickLoginDialog.this.r.setClickable(true);
                SwanAppQuickLoginDialog.this.r.setBackgroundResource(d.swan_reply_editor_publish_selector);
                return;
            }
            SwanAppQuickLoginDialog.this.r.setClickable(false);
            e.f(SwanAppQuickLoginDialog.this.f11419f, g.swanapp_unchecked_auth_tip).G(true);
            SwanAppQuickLoginDialog.this.r.setBackgroundResource(d.swanapp_reply_editor_publish_disabled);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.b.n.g.e {
        public c() {
        }

        @Override // d.a.l0.b.n.g.e
        public void onResult(int i2) {
            String str;
            SwanAppQuickLoginDialog.this.f11418e.onLoginResult(i2);
            if (i2 == 0) {
                str = "succ_agree";
            } else {
                SwanAppQuickLoginDialog.this.Q0();
                str = "fail";
            }
            SwanAppQuickLoginDialog swanAppQuickLoginDialog = SwanAppQuickLoginDialog.this;
            d.a.l0.b.n.d.d.a(PrefetchEvent.STATE_CLICK, "quickLogin", str, swanAppQuickLoginDialog.l, swanAppQuickLoginDialog.m);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void F0() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void G0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.f11421h = linearLayout;
        this.n = (BdBaseImageView) linearLayout.findViewById(d.a.l0.b.e.close);
        this.o = (TextView) this.f11421h.findViewById(d.a.l0.b.e.title);
        this.q = (CheckBox) this.f11421h.findViewById(d.a.l0.b.e.phonenum_autho_switch);
        this.p = (TextView) this.f11421h.findViewById(d.a.l0.b.e.user_phone_number);
        this.r = (Button) this.f11421h.findViewById(d.a.l0.b.e.user_quick_login);
        this.s = (TextView) this.f11421h.findViewById(d.a.l0.b.e.user_login_with_other_phone);
        this.t = (TextView) this.f11421h.findViewById(d.a.l0.b.e.user_service_agreement);
        T0();
        S0();
        QuickLoginInfo quickLoginInfo = this.j;
        if (quickLoginInfo != null) {
            this.p.setText(quickLoginInfo.encryptPhoneNum);
        }
        this.s.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.q.setOnCheckedChangeListener(new b());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void N0() {
        Resources resources = getContext().getResources();
        this.n.setImageDrawable(resources.getDrawable(d.swanapp_login_dialog_close));
        this.o.setTextColor(resources.getColor(this.f11420g ? d.a.l0.b.c.aiapps_login_dialog_title_dark : d.a.l0.b.c.aiapps_login_dialog_title));
        this.p.setTextColor(resources.getColor(this.f11420g ? d.a.l0.b.c.aiapps_login_dialog_title_dark : d.a.l0.b.c.swan_app_color_000000));
        this.q.setTextColor(resources.getColor(this.f11420g ? d.a.l0.b.c.aiapps_login_dialog_title_dark : d.a.l0.b.c.aiapps_login_dialog_title));
        this.q.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f11420g ? d.aiapp_login_and_phonenum_autho_selector_dark : d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void Q0() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            K0(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) d.a.l0.b.n.d.e.a(this.f11422i, this.f11420g, null, this.l, this.m);
            swanAppPhoneLoginDialog.J0(getActivity());
            swanAppPhoneLoginDialog.U0(true);
            swanAppPhoneLoginDialog.L0((SwanAppLoginAndGetMobileDialog.b) this.f11419f);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.a.l0.b.n.d.d.a("show", "telLogin", null, this.l, this.m);
        }
    }

    public final void R0() {
        if (!SwanAppNetworkUtils.i(this.f11419f)) {
            e.f(this.f11419f, g.swanapp_login_not_internet).G(true);
            return;
        }
        QuickLoginInfo quickLoginInfo = this.j;
        if (quickLoginInfo == null) {
            return;
        }
        d.a.l0.b.n.g.f.e(this.f11419f, quickLoginInfo.loginMode, new c());
    }

    public final void S0() {
        String string = getContext().getString(g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.q;
        if (!TextUtils.isEmpty(this.f11422i)) {
            string = String.format(getString(g.swanapp_auth_switch_tip), this.f11422i);
        }
        checkBox.setText(string);
    }

    public final void T0() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_tip));
        if (this.j != null) {
            int length = spannableStringBuilder.length();
            QuickLoginInfo quickLoginInfo = this.j;
            D0(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_comma));
        }
        D0(spannableStringBuilder, spannableStringBuilder.length(), getString(g.swanapp_service_agreement_swan), d.a.l0.a.c1.a.n().D());
        spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_comma));
        D0(spannableStringBuilder, spannableStringBuilder.length(), getString(g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(g.swanapp_service_agreement_register_tip));
        this.t.setMovementMethod(LinkMovementMethod.getInstance());
        this.t.setText(spannableStringBuilder);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.a.l0.b.e.user_login_with_other_phone) {
            Q0();
        } else if (id == d.a.l0.b.e.user_quick_login) {
            R0();
        } else if (id == d.a.l0.b.e.close) {
            K0(true);
            E0();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(this.f11419f, getTheme());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
