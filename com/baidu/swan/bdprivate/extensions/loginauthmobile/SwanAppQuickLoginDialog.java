package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.f;
/* loaded from: classes8.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private BdBaseImageView dIR;
    private CheckBox dIV;
    private TextView dIZ;
    private TextView dJc;
    private Button dJd;
    private TextView dJe;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dIO, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hc(true);
                SwanAppQuickLoginDialog.this.aOr();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dIR = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dIV = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dJc = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dJd = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dJe = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dIZ = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aOt();
        aOu();
        if (this.dIG != null) {
            this.dJc.setText(this.dIG.encryptPhoneNum);
        }
        this.dJe.setOnClickListener(this);
        this.dJd.setOnClickListener(this);
        this.dIR.setOnClickListener(this);
        this.dIV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dJd.setClickable(true);
                    SwanAppQuickLoginDialog.this.dJd.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dJd.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dIO, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dJd.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aOu() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dIV;
        if (!TextUtils.isEmpty(this.dIE)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dIE);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aOq() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dIR.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dpn ? b.C0503b.aiapps_login_dialog_title_dark : b.C0503b.aiapps_login_dialog_title));
        this.dJc.setTextColor(resources.getColor(this.dpn ? b.C0503b.aiapps_login_dialog_title_dark : b.C0503b.swan_app_color_000000));
        this.dIV.setTextColor(resources.getColor(this.dpn ? b.C0503b.aiapps_login_dialog_title_dark : b.C0503b.aiapps_login_dialog_title));
        this.dIV.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dpn ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aOv();
        } else if (id == b.e.user_quick_login) {
            aOw();
        } else if (id == b.e.close) {
            hc(true);
            aOr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOv() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hc(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dIE, this.dpn, null, this.dIH, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.he(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dIO);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dIH, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aOw() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dIO)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dIO, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dIG != null) {
            f.a(this.dIO, this.dIG.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dIN.lD(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aOv();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dIH, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aOt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dIG != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dIG.agreeText, this.dIG.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awM().aie());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dIZ.setMovementMethod(LinkMovementMethod.getInstance());
        this.dIZ.setText(spannableStringBuilder);
    }
}
