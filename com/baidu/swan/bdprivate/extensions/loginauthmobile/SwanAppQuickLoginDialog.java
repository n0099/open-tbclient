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
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ct3;
import com.baidu.tieba.dt3;
import com.baidu.tieba.ku2;
import com.baidu.tieba.lt3;
import com.baidu.tieba.mt3;
import com.baidu.tieba.va3;
/* loaded from: classes4.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public BdBaseImageView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public Button n;
    public TextView o;
    public TextView p;

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void W1() {
    }

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppQuickLoginDialog.this.b2(true);
            SwanAppQuickLoginDialog.this.V1();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                SwanAppQuickLoginDialog.this.n.setClickable(true);
                SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f08143d);
                return;
            }
            SwanAppQuickLoginDialog.this.n.setClickable(false);
            va3.f(SwanAppQuickLoginDialog.this.b, R.string.obfuscated_res_0x7f0f158a).H(true);
            SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f081483);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements lt3 {
        public c() {
        }

        @Override // com.baidu.tieba.lt3
        public void onResult(int i) {
            String str;
            SwanAppQuickLoginDialog.this.a.onLoginResult(i);
            if (i == 0) {
                str = "succ_agree";
            } else {
                SwanAppQuickLoginDialog.this.h2();
                str = "fail";
            }
            SwanAppQuickLoginDialog swanAppQuickLoginDialog = SwanAppQuickLoginDialog.this;
            ct3.a("click", "quickLogin", str, swanAppQuickLoginDialog.h, swanAppQuickLoginDialog.i);
        }
    }

    public final void i2() {
        if (!SwanAppNetworkUtils.i(this.b)) {
            va3.f(this.b, R.string.obfuscated_res_0x7f0f153e).H(true);
            return;
        }
        QuickLoginInfo quickLoginInfo = this.f;
        if (quickLoginInfo == null) {
            return;
        }
        mt3.e(this.b, quickLoginInfo.loginMode, new c());
    }

    public final void j2() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f1550);
        CheckBox checkBox = this.m;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f1513), this.e);
        }
        checkBox.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092861) {
            h2();
        } else if (id == R.id.obfuscated_res_0x7f092871) {
            i2();
        } else if (id == R.id.obfuscated_res_0x7f090733) {
            b2(true);
            V1();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(this.b, getTheme());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void X1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d091e, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090733);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09258f);
        this.m = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091c89);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09286c);
        this.n = (Button) this.d.findViewById(R.id.obfuscated_res_0x7f092871);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092861);
        this.p = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09287f);
        k2();
        j2();
        QuickLoginInfo quickLoginInfo = this.f;
        if (quickLoginInfo != null) {
            this.l.setText(quickLoginInfo.encryptPhoneNum);
        }
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.m.setOnCheckedChangeListener(new b());
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void e2() {
        int i;
        int i2;
        int i3;
        Resources resources = getContext().getResources();
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081470));
        TextView textView = this.k;
        boolean z = this.c;
        int i4 = R.color.obfuscated_res_0x7f06044a;
        if (z) {
            i = R.color.obfuscated_res_0x7f06044b;
        } else {
            i = R.color.obfuscated_res_0x7f06044a;
        }
        textView.setTextColor(resources.getColor(i));
        TextView textView2 = this.l;
        if (this.c) {
            i2 = R.color.obfuscated_res_0x7f06044b;
        } else {
            i2 = R.color.obfuscated_res_0x7f060abb;
        }
        textView2.setTextColor(resources.getColor(i2));
        CheckBox checkBox = this.m;
        if (this.c) {
            i4 = R.color.obfuscated_res_0x7f06044b;
        }
        checkBox.setTextColor(resources.getColor(i4));
        CheckBox checkBox2 = this.m;
        if (this.c) {
            i3 = R.drawable.obfuscated_res_0x7f0800eb;
        } else {
            i3 = R.drawable.obfuscated_res_0x7f0800ea;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i3), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void k2() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1570));
        if (this.f != null) {
            int length = spannableStringBuilder.length();
            QuickLoginInfo quickLoginInfo = this.f;
            U1(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f156d));
        }
        U1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f156f), ku2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f156d));
        U1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f156c), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f156e));
        this.p.setMovementMethod(LinkMovementMethod.getInstance());
        this.p.setText(spannableStringBuilder);
    }

    public final void h2() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            b2(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) dt3.a(this.e, this.c, null, this.h, this.i);
            swanAppPhoneLoginDialog.a2(getActivity());
            swanAppPhoneLoginDialog.l2(true);
            swanAppPhoneLoginDialog.c2((SwanAppLoginAndGetMobileDialog.b) this.b);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            ct3.a("show", "telLogin", null, this.h, this.i);
        }
    }
}
