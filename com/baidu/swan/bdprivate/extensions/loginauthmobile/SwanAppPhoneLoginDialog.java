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
import com.baidu.tieba.bk3;
import com.baidu.tieba.c63;
import com.baidu.tieba.jo3;
import com.baidu.tieba.lj3;
import com.baidu.tieba.lm3;
import com.baidu.tieba.rp2;
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
            swanAppPhoneLoginDialog.N2(!swanAppPhoneLoginDialog.q);
            SwanAppPhoneLoginDialog.this.H2();
            if (SwanAppPhoneLoginDialog.this.q) {
                FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = SwanAppPhoneLoginDialog.this;
                jo3.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.h, swanAppPhoneLoginDialog2.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.N2(true);
            SwanAppPhoneLoginDialog.this.H2();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.N2(false);
            SwanAppPhoneLoginDialog.this.H2();
            FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            jo3.a("show", "quickLogin", null, swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
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
            jo3.a("click", "telLogin", "fail", swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            if (SwanAppPhoneLoginDialog.this.p) {
                SwanAppPhoneLoginDialog.this.H2();
                return;
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.a;
            if (bVar != null) {
                bVar.onLoginResult(-1);
            }
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                lj3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            jo3.a("click", "telLogin", "succ_agree", swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                lj3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
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
            c63.f(SwanAppPhoneLoginDialog.this.b, R.string.obfuscated_res_0x7f0f15df).H(true);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void H2() {
        AccountSmsLoginView accountSmsLoginView = this.l;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.H2();
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
    public void K2(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        super.K2(z);
        if (this.m != null && (accountSmsLoginView = this.l) != null) {
            accountSmsLoginView.close();
            this.m.removeView(this.l);
        }
        I2();
    }

    public void X2(boolean z) {
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
    public void I2() {
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
        lm3.P(getContext(), new d(), str);
        AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
        this.l = accountSmsLoginView;
        this.m.addView(accountSmsLoginView);
        this.r = (EditText) this.d.findViewById(R.id.obfuscated_res_0x7f091d50);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, bk3.g(80.0f));
        layoutParams.setMargins(bk3.g(40.0f), 0, bk3.g(40.0f), 0);
        this.m.addView(this.t, layoutParams);
        this.t.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void J2(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d094e, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090776);
        this.k = (BdBaseImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09034f);
        this.n = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091d57);
        this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091735);
        this.t = new View(getContext());
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092685);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09295b);
        Y2();
        this.j.setOnClickListener(new b());
        if (this.q) {
            this.k.setVisibility(0);
            this.k.setOnClickListener(new c());
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void Q2() {
        int i;
        int i2;
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0814ca));
        this.k.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080123));
        TextView textView = this.o;
        boolean z = this.c;
        int i3 = R.color.obfuscated_res_0x7f06044f;
        if (z) {
            i = R.color.obfuscated_res_0x7f06044f;
        } else {
            i = R.color.obfuscated_res_0x7f06044e;
        }
        textView.setTextColor(resources.getColor(i));
        CheckBox checkBox = this.n;
        if (!this.c) {
            i3 = R.color.obfuscated_res_0x7f06044e;
        }
        checkBox.setTextColor(resources.getColor(i3));
        CheckBox checkBox2 = this.n;
        if (this.c) {
            i2 = R.drawable.obfuscated_res_0x7f0800f1;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f0800f0;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void Y2() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f15c5));
        G2(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f15c4), rp2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f15c2));
        G2(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f15c1), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setText(spannableStringBuilder);
    }

    public final void W2() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f15a5);
        CheckBox checkBox = this.n;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f1568), this.e);
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
        c63.f(this.b, R.string.obfuscated_res_0x7f0f15df).H(true);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        W2();
        return this.d;
    }
}
