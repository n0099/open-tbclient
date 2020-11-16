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
/* loaded from: classes7.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private BdBaseImageView dHj;
    private CheckBox dHn;
    private TextView dHr;
    private TextView dHu;
    private Button dHv;
    private TextView dHw;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dHg, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hf(true);
                SwanAppQuickLoginDialog.this.aNJ();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dHj = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dHn = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dHu = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dHv = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dHw = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dHr = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aNL();
        aNM();
        if (this.dGY != null) {
            this.dHu.setText(this.dGY.encryptPhoneNum);
        }
        this.dHw.setOnClickListener(this);
        this.dHv.setOnClickListener(this);
        this.dHj.setOnClickListener(this);
        this.dHn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dHv.setClickable(true);
                    SwanAppQuickLoginDialog.this.dHv.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dHv.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dHg, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dHv.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aNM() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dHn;
        if (!TextUtils.isEmpty(this.dGW)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dGW);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aNI() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dHj.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dnE ? b.C0501b.aiapps_login_dialog_title_dark : b.C0501b.aiapps_login_dialog_title));
        this.dHu.setTextColor(resources.getColor(this.dnE ? b.C0501b.aiapps_login_dialog_title_dark : b.C0501b.swan_app_color_000000));
        this.dHn.setTextColor(resources.getColor(this.dnE ? b.C0501b.aiapps_login_dialog_title_dark : b.C0501b.aiapps_login_dialog_title));
        this.dHn.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dnE ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aNN();
        } else if (id == b.e.user_quick_login) {
            aNO();
        } else if (id == b.e.close) {
            hf(true);
            aNJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNN() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hf(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dGW, this.dnE, null, this.dGZ, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.hh(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dHg);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dGZ, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aNO() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dHg)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dHg, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dGY != null) {
            f.a(this.dHg, this.dGY.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dHf.lz(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aNN();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dGZ, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aNL() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dGY != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dGY.agreeText, this.dGY.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awe().ahw());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dHr.setMovementMethod(LinkMovementMethod.getInstance());
        this.dHr.setText(spannableStringBuilder);
    }
}
