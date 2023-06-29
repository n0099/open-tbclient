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
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.bu3;
import com.baidu.tieba.dp3;
import com.baidu.tieba.ds3;
import com.baidu.tieba.jv2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.ub3;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    public BdBaseImageView j;
    public BdBaseImageView k;
    public AccountSmsLoginView l;
    public FrameLayout m;
    public CheckBox n;
    public TextView o;
    public boolean p = false;
    public boolean q;
    public EditText r;
    public TextView s;
    public View t;

    /* loaded from: classes4.dex */
    public interface g {
        void onCheckCodeViewHide();

        void onCheckCodeViewShow();

        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            swanAppPhoneLoginDialog.O1(!swanAppPhoneLoginDialog.q);
            SwanAppPhoneLoginDialog.this.I1();
            if (SwanAppPhoneLoginDialog.this.q) {
                FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = SwanAppPhoneLoginDialog.this;
                bu3.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.h, swanAppPhoneLoginDialog2.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.O1(true);
            SwanAppPhoneLoginDialog.this.I1();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.O1(false);
            SwanAppPhoneLoginDialog.this.I1();
            FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            bu3.a("show", "quickLogin", null, swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements g {
        public d() {
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onCheckCodeViewHide() {
            SwanAppPhoneLoginDialog.this.n.setVisibility(0);
            SwanAppPhoneLoginDialog.this.s.setVisibility(0);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onCheckCodeViewShow() {
            SwanAppPhoneLoginDialog.this.n.setVisibility(8);
            SwanAppPhoneLoginDialog.this.s.setVisibility(8);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onFailure() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            bu3.a("click", "telLogin", "fail", swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            if (SwanAppPhoneLoginDialog.this.p) {
                SwanAppPhoneLoginDialog.this.I1();
                return;
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.a;
            if (bVar != null) {
                bVar.onLoginResult(-1);
            }
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                dp3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            bu3.a("click", "telLogin", "succ_agree", swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                dp3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.a;
            if (bVar != null) {
                bVar.onLoginResult(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppPhoneLoginDialog.this.l != null) {
                SwanAppPhoneLoginDialog.this.l.clean();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ub3.f(SwanAppPhoneLoginDialog.this.b, R.string.obfuscated_res_0x7f0f1562).H(true);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void I1() {
        AccountSmsLoginView accountSmsLoginView = this.l;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.I1();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AccountSmsLoginView accountSmsLoginView = this.l;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDestroyView();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void L1(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        super.L1(z);
        if (this.m != null && (accountSmsLoginView = this.l) != null) {
            accountSmsLoginView.close();
            this.m.removeView(this.l);
        }
        J1();
    }

    public void Y1(boolean z) {
        this.q = z;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(this.b, getTheme());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        AccountSmsLoginView accountSmsLoginView = this.l;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void J1() {
        CheckBox checkBox = this.n;
        if (checkBox != null) {
            checkBox.setVisibility(0);
            this.n.setOnCheckedChangeListener(this);
        }
        TextView textView = this.s;
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
        ds3.P(getContext(), new d(), str);
        AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
        this.l = accountSmsLoginView;
        this.m.addView(accountSmsLoginView);
        this.r = (EditText) this.d.findViewById(R.id.obfuscated_res_0x7f091c2c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, tp3.g(80.0f));
        layoutParams.setMargins(tp3.g(40.0f), 0, tp3.g(40.0f), 0);
        this.m.addView(this.t, layoutParams);
        this.t.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void K1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08eb, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09071d);
        this.k = (BdBaseImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090322);
        this.n = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091c33);
        this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091639);
        this.t = new View(getContext());
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09250e);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0927f8);
        Z1();
        this.j.setOnClickListener(new b());
        if (this.q) {
            this.k.setVisibility(0);
            this.k.setOnClickListener(new c());
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void R1() {
        int i;
        int i2;
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08143c));
        this.k.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08011d));
        TextView textView = this.o;
        boolean z = this.c;
        int i3 = R.color.obfuscated_res_0x7f060445;
        if (z) {
            i = R.color.obfuscated_res_0x7f060445;
        } else {
            i = R.color.obfuscated_res_0x7f060444;
        }
        textView.setTextColor(resources.getColor(i));
        CheckBox checkBox = this.n;
        if (!this.c) {
            i3 = R.color.obfuscated_res_0x7f060444;
        }
        checkBox.setTextColor(resources.getColor(i3));
        CheckBox checkBox2 = this.n;
        if (this.c) {
            i2 = R.drawable.obfuscated_res_0x7f0800eb;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f0800ea;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void Z1() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1548));
        H1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1547), jv2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1545));
        H1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1544), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setText(spannableStringBuilder);
    }

    public final void X1() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f1528);
        CheckBox checkBox = this.n;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f14eb), this.e);
        }
        checkBox.setText(string);
        this.l.postDelayed(new e(), 150L);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.t.setVisibility(8);
            this.r.setEnabled(true);
            this.l.p();
            return;
        }
        this.t.setVisibility(0);
        this.t.setOnClickListener(new f());
        this.r.setEnabled(false);
        ub3.f(this.b, R.string.obfuscated_res_0x7f0f1562).H(true);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        X1();
        return this.d;
    }
}
