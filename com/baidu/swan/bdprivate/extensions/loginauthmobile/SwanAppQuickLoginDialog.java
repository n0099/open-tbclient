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
/* loaded from: classes11.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private BdBaseImageView cXg;
    private CheckBox cXk;
    private TextView cXo;
    private TextView cXr;
    private Button cXs;
    private TextView cXt;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.cXd, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.fS(true);
                SwanAppQuickLoginDialog.this.ayv();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.cXg = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.cXk = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.cXr = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.cXs = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.cXt = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.cXo = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        ayx();
        ayy();
        if (this.cWV != null) {
            this.cXr.setText(this.cWV.encryptPhoneNum);
        }
        this.cXt.setOnClickListener(this);
        this.cXs.setOnClickListener(this);
        this.cXg.setOnClickListener(this);
        this.cXk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.cXs.setClickable(true);
                    SwanAppQuickLoginDialog.this.cXs.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.cXs.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.cXd, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.cXs.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void ayy() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.cXk;
        if (!TextUtils.isEmpty(this.cWT)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.cWT);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void ayu() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.cXg.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.cDJ ? b.C0422b.aiapps_login_dialog_title_dark : b.C0422b.aiapps_login_dialog_title));
        this.cXr.setTextColor(resources.getColor(this.cDJ ? b.C0422b.aiapps_login_dialog_title_dark : b.C0422b.swan_app_color_000000));
        this.cXk.setTextColor(resources.getColor(this.cDJ ? b.C0422b.aiapps_login_dialog_title_dark : b.C0422b.aiapps_login_dialog_title));
        this.cXk.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cDJ ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            ayz();
        } else if (id == b.e.user_quick_login) {
            ayA();
        } else if (id == b.e.close) {
            fS(true);
            ayv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayz() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            fS(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.cWT, this.cDJ, null, this.cWW, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.fU(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.cXd);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.f("show", "telLogin", null, this.cWW, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void ayA() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.cXd)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.cXd, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.cWV != null) {
            f.a(this.cXd, this.cWV.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.cXc.is(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.ayz();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.f("click", "quickLogin", str, SwanAppQuickLoginDialog.this.cWW, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void ayx() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.cWV != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.cWV.agreeText, this.cWV.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.ahv().Un());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.cXo.setMovementMethod(LinkMovementMethod.getInstance());
        this.cXo.setText(spannableStringBuilder);
    }
}
