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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    public BdBaseImageView n;
    public BdBaseImageView o;
    public AccountSmsLoginView p;
    public FrameLayout q;
    public CheckBox r;
    public TextView s;
    public boolean t = false;
    public boolean u;
    public EditText v;
    public TextView w;
    public View x;

    /* loaded from: classes3.dex */
    public class a extends Dialog {
        public a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            swanAppPhoneLoginDialog.N0(!swanAppPhoneLoginDialog.u);
            SwanAppPhoneLoginDialog.this.H0();
            if (SwanAppPhoneLoginDialog.this.u) {
                FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = SwanAppPhoneLoginDialog.this;
                d.a.l0.b.n.d.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.l, swanAppPhoneLoginDialog2.m);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppPhoneLoginDialog.this.N0(true);
            SwanAppPhoneLoginDialog.this.H0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppPhoneLoginDialog.this.N0(false);
            SwanAppPhoneLoginDialog.this.H0();
            FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            d.a.l0.b.n.d.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements g {
        public d() {
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void a() {
            SwanAppPhoneLoginDialog.this.r.setVisibility(8);
            SwanAppPhoneLoginDialog.this.w.setVisibility(8);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void b() {
            SwanAppPhoneLoginDialog.this.r.setVisibility(0);
            SwanAppPhoneLoginDialog.this.w.setVisibility(0);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onFailure() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            d.a.l0.b.n.d.d.a(PrefetchEvent.STATE_CLICK, "telLogin", com.baidu.pass.biometrics.face.liveness.b.b.g0, swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
            if (SwanAppPhoneLoginDialog.this.t) {
                SwanAppPhoneLoginDialog.this.H0();
                return;
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.f11480e;
            if (bVar != null) {
                bVar.onLoginResult(-1);
            }
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.f11481f;
            if (fragmentActivity == null || fragmentActivity.getWindow() == null) {
                return;
            }
            FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.f11481f;
            x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            d.a.l0.b.n.d.d.a(PrefetchEvent.STATE_CLICK, "telLogin", "succ_agree", swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.f11481f;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.f11481f;
                x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.f11480e;
            if (bVar != null) {
                bVar.onLoginResult(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppPhoneLoginDialog.this.p != null) {
                SwanAppPhoneLoginDialog.this.p.clean();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.l0.a.z1.b.f.e.f(SwanAppPhoneLoginDialog.this.f11481f, d.a.l0.b.g.swanapp_unchecked_auth_tip).G(true);
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();

        void b();

        void onFailure();

        void onSuccess();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void H0() {
        AccountSmsLoginView accountSmsLoginView = this.p;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.H0();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void I0() {
        CheckBox checkBox = this.r;
        if (checkBox != null) {
            checkBox.setVisibility(0);
            this.r.setOnCheckedChangeListener(this);
        }
        TextView textView = this.w;
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
        d.a.l0.b.j.a.Q(getContext(), new d(), str);
        AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
        this.p = accountSmsLoginView;
        this.q.addView(accountSmsLoginView);
        this.v = (EditText) this.f11483h.findViewById(d.a.l0.b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n0.g(80.0f));
        layoutParams.setMargins(n0.g(40.0f), 0, n0.g(40.0f), 0);
        this.q.addView(this.x, layoutParams);
        this.x.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void J0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(d.a.l0.b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.f11483h = linearLayout;
        this.n = (BdBaseImageView) linearLayout.findViewById(d.a.l0.b.e.close);
        this.o = (BdBaseImageView) this.f11483h.findViewById(d.a.l0.b.e.back);
        this.r = (CheckBox) this.f11483h.findViewById(d.a.l0.b.e.phonenum_autho_switch);
        this.q = (FrameLayout) this.f11483h.findViewById(d.a.l0.b.e.login_input_layout);
        this.x = new View(getContext());
        this.s = (TextView) this.f11483h.findViewById(d.a.l0.b.e.title);
        this.w = (TextView) this.f11483h.findViewById(d.a.l0.b.e.user_service_agreement);
        Y0();
        this.n.setOnClickListener(new b());
        if (this.u) {
            this.o.setVisibility(0);
            this.o.setOnClickListener(new c());
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void K0(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        super.K0(z);
        if (this.q != null && (accountSmsLoginView = this.p) != null) {
            accountSmsLoginView.close();
            this.q.removeView(this.p);
        }
        I0();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void Q0() {
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        this.n.setImageDrawable(resources.getDrawable(d.a.l0.b.d.swanapp_login_dialog_close));
        this.o.setImageDrawable(resources.getDrawable(d.a.l0.b.d.aiapps_action_bar_back_selector));
        this.s.setTextColor(resources.getColor(this.f11482g ? d.a.l0.b.c.aiapps_login_dialog_title_dark : d.a.l0.b.c.aiapps_login_dialog_title));
        this.r.setTextColor(resources.getColor(this.f11482g ? d.a.l0.b.c.aiapps_login_dialog_title_dark : d.a.l0.b.c.aiapps_login_dialog_title));
        this.r.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f11482g ? d.a.l0.b.d.aiapp_login_and_phonenum_autho_selector_dark : d.a.l0.b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void W0() {
        String string = getContext().getString(d.a.l0.b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.r;
        if (!TextUtils.isEmpty(this.f11484i)) {
            string = String.format(getString(d.a.l0.b.g.swanapp_auth_switch_tip), this.f11484i);
        }
        checkBox.setText(string);
        this.p.postDelayed(new e(), 150L);
    }

    public void X0(boolean z) {
        this.u = z;
    }

    public final void Y0() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(d.a.l0.b.g.swanapp_service_agreement_tip));
        G0(spannableStringBuilder, spannableStringBuilder.length(), getString(d.a.l0.b.g.swanapp_service_agreement_swan), d.a.l0.a.c1.a.n().D());
        spannableStringBuilder.append((CharSequence) getString(d.a.l0.b.g.swanapp_service_agreement_comma));
        G0(spannableStringBuilder, spannableStringBuilder.length(), getString(d.a.l0.b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.w.setMovementMethod(LinkMovementMethod.getInstance());
        this.w.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.x.setVisibility(8);
            this.v.setEnabled(true);
            this.p.o();
            return;
        }
        this.x.setVisibility(0);
        this.x.setOnClickListener(new f());
        this.v.setEnabled(false);
        d.a.l0.a.z1.b.f.e.f(this.f11481f, d.a.l0.b.g.swanapp_unchecked_auth_tip).G(true);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(this.f11481f, getTheme());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        W0();
        return this.f11483h;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AccountSmsLoginView accountSmsLoginView = this.p;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDestroyView();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        AccountSmsLoginView accountSmsLoginView = this.p;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDismiss(dialogInterface);
    }
}
