package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Dialog;
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
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.f;
/* loaded from: classes8.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private Button dSA;
    private TextView dSB;
    private BdBaseImageView dSo;
    private CheckBox dSs;
    private TextView dSw;
    private TextView dSz;
    private TextView mTitle;

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dSl, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hI(true);
                SwanAppQuickLoginDialog.this.aPr();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dSo = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dSs = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dSz = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dSA = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dSB = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dSw = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPt();
        aPu();
        if (this.dSd != null) {
            this.dSz.setText(this.dSd.encryptPhoneNum);
        }
        this.dSB.setOnClickListener(this);
        this.dSA.setOnClickListener(this);
        this.dSo.setOnClickListener(this);
        this.dSs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dSA.setClickable(true);
                    SwanAppQuickLoginDialog.this.dSA.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dSA.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppQuickLoginDialog.this.dSl, b.g.swanapp_unchecked_auth_tip).hb(true);
                SwanAppQuickLoginDialog.this.dSA.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aPu() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dSs;
        if (!TextUtils.isEmpty(this.dSb)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dSb);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPq() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dSo.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dwd ? b.C0489b.aiapps_login_dialog_title_dark : b.C0489b.aiapps_login_dialog_title));
        this.dSz.setTextColor(resources.getColor(this.dwd ? b.C0489b.aiapps_login_dialog_title_dark : b.C0489b.swan_app_color_000000));
        this.dSs.setTextColor(resources.getColor(this.dwd ? b.C0489b.aiapps_login_dialog_title_dark : b.C0489b.aiapps_login_dialog_title));
        this.dSs.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dwd ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aPv();
        } else if (id == b.e.user_quick_login) {
            aPw();
        } else if (id == b.e.close) {
            hI(true);
            aPr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPv() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hI(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dSb, this.dwd, null, this.dSe, this.mAppId);
            swanAppPhoneLoginDialog.a(getActivity());
            swanAppPhoneLoginDialog.hK(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dSl);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dSe, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aPw() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dSl)) {
            com.baidu.swan.apps.res.widget.b.d.u(this.dSl, b.g.swanapp_login_not_internet).hb(true);
        } else if (this.dSd != null) {
            f.a(this.dSl, this.dSd.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dSk.ky(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aPv();
                        str = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dSe, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aPt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dSd != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dSd.agreeText, this.dSd.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awK().ahV());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dSw.setMovementMethod(LinkMovementMethod.getInstance());
        this.dSw.setText(spannableStringBuilder);
    }
}
