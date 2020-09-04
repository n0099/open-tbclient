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
/* loaded from: classes3.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private TextView dgB;
    private TextView dgE;
    private Button dgF;
    private TextView dgG;
    private BdBaseImageView dgt;
    private CheckBox dgx;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dgq, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.gm(true);
                SwanAppQuickLoginDialog.this.aGE();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dgt = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dgx = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dgE = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dgF = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dgG = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dgB = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aGG();
        aGH();
        if (this.dgi != null) {
            this.dgE.setText(this.dgi.encryptPhoneNum);
        }
        this.dgG.setOnClickListener(this);
        this.dgF.setOnClickListener(this);
        this.dgt.setOnClickListener(this);
        this.dgx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dgF.setClickable(true);
                    SwanAppQuickLoginDialog.this.dgF.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dgF.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dgq, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dgF.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aGH() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dgx;
        if (!TextUtils.isEmpty(this.dgg)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dgg);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aGD() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dgt.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.cML ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
        this.dgE.setTextColor(resources.getColor(this.cML ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.swan_app_color_000000));
        this.dgx.setTextColor(resources.getColor(this.cML ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
        this.dgx.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cML ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aGI();
        } else if (id == b.e.user_quick_login) {
            aGJ();
        } else if (id == b.e.close) {
            gm(true);
            aGE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGI() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            gm(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dgg, this.cML, null, this.dgj, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.go(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dgq);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dgj, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aGJ() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dgq)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dgq, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dgi != null) {
            f.a(this.dgq, this.dgi.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dgp.kA(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aGI();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dgj, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aGG() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dgi != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dgi.agreeText, this.dgi.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aoV().aap());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dgB.setMovementMethod(LinkMovementMethod.getInstance());
        this.dgB.setText(spannableStringBuilder);
    }
}
