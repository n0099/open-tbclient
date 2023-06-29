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
import com.baidu.tieba.bu3;
import com.baidu.tieba.cu3;
import com.baidu.tieba.jv2;
import com.baidu.tieba.ku3;
import com.baidu.tieba.lu3;
import com.baidu.tieba.ub3;
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
    public void J1() {
    }

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            SwanAppQuickLoginDialog.this.O1(true);
            SwanAppQuickLoginDialog.this.I1();
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
                SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f081409);
                return;
            }
            SwanAppQuickLoginDialog.this.n.setClickable(false);
            ub3.f(SwanAppQuickLoginDialog.this.b, R.string.obfuscated_res_0x7f0f1562).H(true);
            SwanAppQuickLoginDialog.this.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f08144f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ku3 {
        public c() {
        }

        @Override // com.baidu.tieba.ku3
        public void onResult(int i) {
            String str;
            SwanAppQuickLoginDialog.this.a.onLoginResult(i);
            if (i == 0) {
                str = "succ_agree";
            } else {
                SwanAppQuickLoginDialog.this.U1();
                str = "fail";
            }
            SwanAppQuickLoginDialog swanAppQuickLoginDialog = SwanAppQuickLoginDialog.this;
            bu3.a("click", "quickLogin", str, swanAppQuickLoginDialog.h, swanAppQuickLoginDialog.i);
        }
    }

    public final void V1() {
        if (!SwanAppNetworkUtils.i(this.b)) {
            ub3.f(this.b, R.string.obfuscated_res_0x7f0f1516).H(true);
            return;
        }
        QuickLoginInfo quickLoginInfo = this.f;
        if (quickLoginInfo == null) {
            return;
        }
        lu3.e(this.b, quickLoginInfo.loginMode, new c());
    }

    public final void W1() {
        String string = getContext().getString(R.string.obfuscated_res_0x7f0f1528);
        CheckBox checkBox = this.m;
        if (!TextUtils.isEmpty(this.e)) {
            string = String.format(getString(R.string.obfuscated_res_0x7f0f14eb), this.e);
        }
        checkBox.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0927da) {
            U1();
        } else if (id == R.id.obfuscated_res_0x7f0927ea) {
            V1();
        } else if (id == R.id.obfuscated_res_0x7f09071d) {
            O1(true);
            I1();
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
    public void K1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08f2, viewGroup, false);
        this.d = linearLayout;
        this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09071d);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09250e);
        this.m = (CheckBox) this.d.findViewById(R.id.obfuscated_res_0x7f091c33);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0927e5);
        this.n = (Button) this.d.findViewById(R.id.obfuscated_res_0x7f0927ea);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0927da);
        this.p = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0927f8);
        X1();
        W1();
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
    public void R1() {
        int i;
        int i2;
        int i3;
        Resources resources = getContext().getResources();
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08143c));
        TextView textView = this.k;
        boolean z = this.c;
        int i4 = R.color.obfuscated_res_0x7f060444;
        if (z) {
            i = R.color.obfuscated_res_0x7f060445;
        } else {
            i = R.color.obfuscated_res_0x7f060444;
        }
        textView.setTextColor(resources.getColor(i));
        TextView textView2 = this.l;
        if (this.c) {
            i2 = R.color.obfuscated_res_0x7f060445;
        } else {
            i2 = R.color.obfuscated_res_0x7f060aae;
        }
        textView2.setTextColor(resources.getColor(i2));
        CheckBox checkBox = this.m;
        if (this.c) {
            i4 = R.color.obfuscated_res_0x7f060445;
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

    public final void X1() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1548));
        if (this.f != null) {
            int length = spannableStringBuilder.length();
            QuickLoginInfo quickLoginInfo = this.f;
            H1(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1545));
        }
        H1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1547), jv2.o().G());
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1545));
        H1(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f1544), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1546));
        this.p.setMovementMethod(LinkMovementMethod.getInstance());
        this.p.setText(spannableStringBuilder);
    }

    public final void U1() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            O1(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) cu3.a(this.e, this.c, null, this.h, this.i);
            swanAppPhoneLoginDialog.N1(getActivity());
            swanAppPhoneLoginDialog.Y1(true);
            swanAppPhoneLoginDialog.P1((SwanAppLoginAndGetMobileDialog.b) this.b);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            bu3.a("show", "telLogin", null, this.h, this.i);
        }
    }
}
