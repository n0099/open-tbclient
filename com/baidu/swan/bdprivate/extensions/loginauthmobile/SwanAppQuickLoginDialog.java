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
import com.baidu.tieba.ar2;
import com.baidu.tieba.bq3;
import com.baidu.tieba.cq3;
import com.baidu.tieba.l73;
import com.baidu.tieba.sp3;
import com.baidu.tieba.tp3;
/* loaded from: classes3.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public BdBaseImageView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public Button n;
    public TextView o;
    public TextView p;

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void G1() {
    }

    /* loaded from: classes3.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppQuickLoginDialog.this.L1(true);
            SwanAppQuickLoginDialog.this.F1();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                SwanAppQuickLoginDialog.this.n.setClickable(true);
                SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f08121a);
                return;
            }
            SwanAppQuickLoginDialog.this.n.setClickable(false);
            l73.f(SwanAppQuickLoginDialog.this.b, R.string.obfuscated_res_0x7f0f140d).H(true);
            SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f081260);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements bq3 {
        public c() {
        }

        @Override // com.baidu.tieba.bq3
        public void onResult(int i) {
            String str;
            SwanAppQuickLoginDialog.this.a.b0(i);
            if (i == 0) {
                str = "succ_agree";
            } else {
                SwanAppQuickLoginDialog.this.R1();
                str = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            }
            SwanAppQuickLoginDialog swanAppQuickLoginDialog = SwanAppQuickLoginDialog.this;
            sp3.a("click", "quickLogin", str, swanAppQuickLoginDialog.h, swanAppQuickLoginDialog.i);
        }
    }

    public final void S1() {
        if (!SwanAppNetworkUtils.i(this.b)) {
            l73.f(this.b, R.string.obfuscated_res_0x7f0f13c1).H(true);
            return;
        }
        QuickLoginInfo quickLoginInfo = this.f;
        if (quickLoginInfo == null) {
            return;
        }
        cq3.e(this.b, quickLoginInfo.loginMode, new c());
    }

    public final void T1() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f13d3);
        CheckBox checkBox = this.m;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f1396), this.e);
        }
        checkBox.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0926b6) {
            R1();
        } else if (id == R.id.obfuscated_res_0x7f0926c6) {
            S1();
        } else if (id == R.id.obfuscated_res_0x7f0906f1) {
            L1(true);
            F1();
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
    public void H1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d088b, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0906f1);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0923fe);
        this.m = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091b54);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0926c1);
        this.n = (Button) this.d.findViewById(R.id.obfuscated_res_0x7f0926c6);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0926b6);
        this.p = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0926d4);
        U1();
        T1();
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
    public void O1() {
        int i;
        int i2;
        int i3;
        Resources resources = getContext().getResources();
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08124d));
        TextView textView = this.k;
        boolean z = this.c;
        int i4 = R.color.obfuscated_res_0x7f060327;
        if (z) {
            i = R.color.obfuscated_res_0x7f060328;
        } else {
            i = R.color.obfuscated_res_0x7f060327;
        }
        textView.setTextColor(resources.getColor(i));
        TextView textView2 = this.l;
        if (this.c) {
            i2 = R.color.obfuscated_res_0x7f060328;
        } else {
            i2 = R.color.obfuscated_res_0x7f060918;
        }
        textView2.setTextColor(resources.getColor(i2));
        CheckBox checkBox = this.m;
        if (this.c) {
            i4 = R.color.obfuscated_res_0x7f060328;
        }
        checkBox.setTextColor(resources.getColor(i4));
        CheckBox checkBox2 = this.m;
        if (this.c) {
            i3 = R.drawable.obfuscated_res_0x7f0800d2;
        } else {
            i3 = R.drawable.obfuscated_res_0x7f0800d1;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i3), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void U1() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13f3));
        if (this.f != null) {
            int length = spannableStringBuilder.length();
            QuickLoginInfo quickLoginInfo = this.f;
            E1(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13f0));
        }
        E1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f13f2), ar2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13f0));
        E1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f13ef), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13f1));
        this.p.setMovementMethod(LinkMovementMethod.getInstance());
        this.p.setText(spannableStringBuilder);
    }

    public final void R1() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            L1(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) tp3.a(this.e, this.c, null, this.h, this.i);
            swanAppPhoneLoginDialog.K1(getActivity());
            swanAppPhoneLoginDialog.V1(true);
            swanAppPhoneLoginDialog.M1((SwanAppLoginAndGetMobileDialog.b) this.b);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            sp3.a("show", "telLogin", null, this.h, this.i);
        }
    }
}
