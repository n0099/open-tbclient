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
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.w;
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
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            swanAppPhoneLoginDialog.L0(!swanAppPhoneLoginDialog.u);
            SwanAppPhoneLoginDialog.this.F0();
            if (SwanAppPhoneLoginDialog.this.u) {
                FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = SwanAppPhoneLoginDialog.this;
                d.b.g0.b.m.d.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.l, swanAppPhoneLoginDialog2.m);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppPhoneLoginDialog.this.L0(true);
            SwanAppPhoneLoginDialog.this.F0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppPhoneLoginDialog.this.L0(false);
            SwanAppPhoneLoginDialog.this.F0();
            FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            d.b.g0.b.m.d.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
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
            d.b.g0.b.m.d.d.a(PrefetchEvent.STATE_CLICK, "telLogin", "fail", swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
            if (SwanAppPhoneLoginDialog.this.t) {
                SwanAppPhoneLoginDialog.this.F0();
                return;
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.f12713e;
            if (bVar != null) {
                bVar.onLoginResult(-1);
            }
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.f12714f;
            if (fragmentActivity == null || fragmentActivity.getWindow() == null) {
                return;
            }
            FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.f12714f;
            w.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            d.b.g0.b.m.d.d.a(PrefetchEvent.STATE_CLICK, "telLogin", "succ_agree", swanAppPhoneLoginDialog.l, swanAppPhoneLoginDialog.m);
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.f12714f;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.f12714f;
                w.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.f12713e;
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
            d.b.g0.a.q1.b.f.d.e(SwanAppPhoneLoginDialog.this.f12714f, d.b.g0.b.g.swanapp_unchecked_auth_tip).D(true);
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
    public void F0() {
        AccountSmsLoginView accountSmsLoginView = this.p;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.F0();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void G0() {
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
        d.b.g0.b.i.a.S(getContext(), new d(), str);
        AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
        this.p = accountSmsLoginView;
        this.q.addView(accountSmsLoginView);
        this.v = (EditText) this.f12716h.findViewById(d.b.g0.b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, h0.f(80.0f));
        layoutParams.setMargins(h0.f(40.0f), 0, h0.f(40.0f), 0);
        this.q.addView(this.x, layoutParams);
        this.x.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void H0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(d.b.g0.b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.f12716h = linearLayout;
        this.n = (BdBaseImageView) linearLayout.findViewById(d.b.g0.b.e.close);
        this.o = (BdBaseImageView) this.f12716h.findViewById(d.b.g0.b.e.back);
        this.r = (CheckBox) this.f12716h.findViewById(d.b.g0.b.e.phonenum_autho_switch);
        this.q = (FrameLayout) this.f12716h.findViewById(d.b.g0.b.e.login_input_layout);
        this.x = new View(getContext());
        this.s = (TextView) this.f12716h.findViewById(d.b.g0.b.e.title);
        this.w = (TextView) this.f12716h.findViewById(d.b.g0.b.e.user_service_agreement);
        W0();
        this.n.setOnClickListener(new b());
        if (this.u) {
            this.o.setVisibility(0);
            this.o.setOnClickListener(new c());
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void I0(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        super.I0(z);
        if (this.q != null && (accountSmsLoginView = this.p) != null) {
            accountSmsLoginView.close();
            this.q.removeView(this.p);
        }
        G0();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void O0() {
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        this.n.setImageDrawable(resources.getDrawable(d.b.g0.b.d.swanapp_login_dialog_close));
        this.o.setImageDrawable(resources.getDrawable(d.b.g0.b.d.aiapps_action_bar_back_selector));
        this.s.setTextColor(resources.getColor(this.f12715g ? d.b.g0.b.c.aiapps_login_dialog_title_dark : d.b.g0.b.c.aiapps_login_dialog_title));
        this.r.setTextColor(resources.getColor(this.f12715g ? d.b.g0.b.c.aiapps_login_dialog_title_dark : d.b.g0.b.c.aiapps_login_dialog_title));
        this.r.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f12715g ? d.b.g0.b.d.aiapp_login_and_phonenum_autho_selector_dark : d.b.g0.b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void U0() {
        String string = getContext().getString(d.b.g0.b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.r;
        if (!TextUtils.isEmpty(this.i)) {
            string = String.format(getString(d.b.g0.b.g.swanapp_auth_switch_tip), this.i);
        }
        checkBox.setText(string);
        this.p.postDelayed(new e(), 150L);
    }

    public void V0(boolean z) {
        this.u = z;
    }

    public final void W0() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(d.b.g0.b.g.swanapp_service_agreement_tip));
        E0(spannableStringBuilder, spannableStringBuilder.length(), getString(d.b.g0.b.g.swanapp_service_agreement_swan), d.b.g0.a.w0.a.l().D());
        spannableStringBuilder.append((CharSequence) getString(d.b.g0.b.g.swanapp_service_agreement_comma));
        E0(spannableStringBuilder, spannableStringBuilder.length(), getString(d.b.g0.b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.w.setMovementMethod(LinkMovementMethod.getInstance());
        this.w.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.x.setVisibility(8);
            this.v.setEnabled(true);
            this.p.n();
            return;
        }
        this.x.setVisibility(0);
        this.x.setOnClickListener(new f());
        this.v.setEnabled(false);
        d.b.g0.a.q1.b.f.d.e(this.f12714f, d.b.g0.b.g.swanapp_unchecked_auth_tip).D(true);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(this.f12714f, getTheme());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        U0();
        return this.f12716h;
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
