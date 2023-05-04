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
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.er2;
import com.baidu.tieba.ol3;
import com.baidu.tieba.p73;
import com.baidu.tieba.wp3;
import com.baidu.tieba.yk3;
import com.baidu.tieba.yn3;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface g {
        void a();

        void b();

        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            swanAppPhoneLoginDialog.M1(!swanAppPhoneLoginDialog.q);
            SwanAppPhoneLoginDialog.this.G1();
            if (SwanAppPhoneLoginDialog.this.q) {
                FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = SwanAppPhoneLoginDialog.this;
                wp3.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.h, swanAppPhoneLoginDialog2.i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.M1(true);
            SwanAppPhoneLoginDialog.this.G1();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppPhoneLoginDialog.this.M1(false);
            SwanAppPhoneLoginDialog.this.G1();
            FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            wp3.a("show", "quickLogin", null, swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements g {
        public d() {
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void a() {
            SwanAppPhoneLoginDialog.this.n.setVisibility(8);
            SwanAppPhoneLoginDialog.this.s.setVisibility(8);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void b() {
            SwanAppPhoneLoginDialog.this.n.setVisibility(0);
            SwanAppPhoneLoginDialog.this.s.setVisibility(0);
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onFailure() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            wp3.a("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0, swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            if (SwanAppPhoneLoginDialog.this.p) {
                SwanAppPhoneLoginDialog.this.G1();
                return;
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.a;
            if (bVar != null) {
                bVar.c0(-1);
            }
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                yk3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = SwanAppPhoneLoginDialog.this;
            wp3.a("click", "telLogin", "succ_agree", swanAppPhoneLoginDialog.h, swanAppPhoneLoginDialog.i);
            FragmentActivity fragmentActivity = SwanAppPhoneLoginDialog.this.b;
            if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                FragmentActivity fragmentActivity2 = SwanAppPhoneLoginDialog.this.b;
                yk3.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
            SwanAppLoginAndGetMobileDialog.b bVar = SwanAppPhoneLoginDialog.this.a;
            if (bVar != null) {
                bVar.c0(0);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            p73.f(SwanAppPhoneLoginDialog.this.b, R.string.obfuscated_res_0x7f0f141d).H(true);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void G1() {
        AccountSmsLoginView accountSmsLoginView = this.l;
        if (accountSmsLoginView != null) {
            accountSmsLoginView.close();
        }
        super.G1();
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
    public void J1(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        super.J1(z);
        if (this.m != null && (accountSmsLoginView = this.l) != null) {
            accountSmsLoginView.close();
            this.m.removeView(this.l);
        }
        H1();
    }

    public void W1(boolean z) {
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
    public void H1() {
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
            str = URLEncoder.encode(jSONObject.toString(), IMAudioTransRequest.CHARSET);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        yn3.P(getContext(), new d(), str);
        AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
        this.l = accountSmsLoginView;
        this.m.addView(accountSmsLoginView);
        this.r = (EditText) this.d.findViewById(R.id.obfuscated_res_0x7f091b4c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ol3.g(80.0f));
        layoutParams.setMargins(ol3.g(40.0f), 0, ol3.g(40.0f), 0);
        this.m.addView(this.t, layoutParams);
        this.t.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void I1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d088b, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0906f8);
        this.k = (BdBaseImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090315);
        this.n = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091b53);
        this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0915c0);
        this.t = new View(getContext());
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09240b);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0926e5);
        X1();
        this.j.setOnClickListener(new b());
        if (this.q) {
            this.k.setVisibility(0);
            this.k.setOnClickListener(new c());
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void P1() {
        int i;
        int i2;
        Resources resources = getContext().getResources();
        if (resources == null) {
            return;
        }
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081268));
        this.k.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080105));
        TextView textView = this.o;
        boolean z = this.c;
        int i3 = R.color.obfuscated_res_0x7f06032c;
        if (z) {
            i = R.color.obfuscated_res_0x7f06032c;
        } else {
            i = R.color.obfuscated_res_0x7f06032b;
        }
        textView.setTextColor(resources.getColor(i));
        CheckBox checkBox = this.n;
        if (!this.c) {
            i3 = R.color.obfuscated_res_0x7f06032b;
        }
        checkBox.setTextColor(resources.getColor(i3));
        CheckBox checkBox2 = this.n;
        if (this.c) {
            i2 = R.drawable.obfuscated_res_0x7f0800d3;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f0800d2;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void X1() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1403));
        F1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1402), er2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1400));
        F1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f13ff), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setText(spannableStringBuilder);
    }

    public final void V1() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f13e3);
        CheckBox checkBox = this.n;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f13a6), this.e);
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
        p73.f(this.b, R.string.obfuscated_res_0x7f0f141d).H(true);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        V1();
        return this.d;
    }
}
