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
import com.baidu.tieba.gt3;
import com.baidu.tieba.ht3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pt3;
import com.baidu.tieba.qt3;
import com.baidu.tieba.za3;
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
    public void Y1() {
    }

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppQuickLoginDialog.this.d2(true);
            SwanAppQuickLoginDialog.this.X1();
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
                SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f081462);
                return;
            }
            SwanAppQuickLoginDialog.this.n.setClickable(false);
            za3.f(SwanAppQuickLoginDialog.this.b, R.string.obfuscated_res_0x7f0f15a3).H(true);
            SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f0814a8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pt3 {
        public c() {
        }

        @Override // com.baidu.tieba.pt3
        public void onResult(int i) {
            String str;
            SwanAppQuickLoginDialog.this.a.onLoginResult(i);
            if (i == 0) {
                str = "succ_agree";
            } else {
                SwanAppQuickLoginDialog.this.j2();
                str = "fail";
            }
            SwanAppQuickLoginDialog swanAppQuickLoginDialog = SwanAppQuickLoginDialog.this;
            gt3.a("click", "quickLogin", str, swanAppQuickLoginDialog.h, swanAppQuickLoginDialog.i);
        }
    }

    public final void k2() {
        if (!SwanAppNetworkUtils.i(this.b)) {
            za3.f(this.b, R.string.obfuscated_res_0x7f0f1557).H(true);
            return;
        }
        QuickLoginInfo quickLoginInfo = this.f;
        if (quickLoginInfo == null) {
            return;
        }
        qt3.e(this.b, quickLoginInfo.loginMode, new c());
    }

    public final void l2() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f1569);
        CheckBox checkBox = this.m;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f152c), this.e);
        }
        checkBox.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092894) {
            j2();
        } else if (id == R.id.obfuscated_res_0x7f0928a4) {
            k2();
        } else if (id == R.id.obfuscated_res_0x7f090727) {
            d2(true);
            X1();
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
    public void Z1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0933, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090727);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0925d1);
        this.m = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091ca2);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09289f);
        this.n = (Button) this.d.findViewById(R.id.obfuscated_res_0x7f0928a4);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092894);
        this.p = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0928b2);
        m2();
        l2();
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
    public void g2() {
        int i;
        int i2;
        int i3;
        Resources resources = getContext().getResources();
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081495));
        TextView textView = this.k;
        boolean z = this.c;
        int i4 = R.color.obfuscated_res_0x7f06044c;
        if (z) {
            i = R.color.obfuscated_res_0x7f06044d;
        } else {
            i = R.color.obfuscated_res_0x7f06044c;
        }
        textView.setTextColor(resources.getColor(i));
        TextView textView2 = this.l;
        if (this.c) {
            i2 = R.color.obfuscated_res_0x7f06044d;
        } else {
            i2 = R.color.obfuscated_res_0x7f060ac2;
        }
        textView2.setTextColor(resources.getColor(i2));
        CheckBox checkBox = this.m;
        if (this.c) {
            i4 = R.color.obfuscated_res_0x7f06044d;
        }
        checkBox.setTextColor(resources.getColor(i4));
        CheckBox checkBox2 = this.m;
        if (this.c) {
            i3 = R.drawable.obfuscated_res_0x7f0800ec;
        } else {
            i3 = R.drawable.obfuscated_res_0x7f0800eb;
        }
        checkBox2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i3), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void m2() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1589));
        if (this.f != null) {
            int length = spannableStringBuilder.length();
            QuickLoginInfo quickLoginInfo = this.f;
            W1(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1586));
        }
        W1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1588), ou2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1586));
        W1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1585), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1587));
        this.p.setMovementMethod(LinkMovementMethod.getInstance());
        this.p.setText(spannableStringBuilder);
    }

    public final void j2() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            d2(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) ht3.a(this.e, this.c, null, this.h, this.i);
            swanAppPhoneLoginDialog.c2(getActivity());
            swanAppPhoneLoginDialog.n2(true);
            swanAppPhoneLoginDialog.e2((SwanAppLoginAndGetMobileDialog.b) this.b);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            gt3.a("show", "telLogin", null, this.h, this.i);
        }
    }
}
