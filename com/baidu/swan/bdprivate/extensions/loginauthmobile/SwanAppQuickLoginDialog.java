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
/* loaded from: classes25.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private BdBaseImageView dOh;
    private CheckBox dOl;
    private TextView dOp;
    private TextView dOs;
    private Button dOt;
    private TextView dOu;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dOe, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hu(true);
                SwanAppQuickLoginDialog.this.aQP();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dOh = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dOl = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dOs = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dOt = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dOu = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dOp = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aQR();
        aQS();
        if (this.dNW != null) {
            this.dOs.setText(this.dNW.encryptPhoneNum);
        }
        this.dOu.setOnClickListener(this);
        this.dOt.setOnClickListener(this);
        this.dOh.setOnClickListener(this);
        this.dOl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dOt.setClickable(true);
                    SwanAppQuickLoginDialog.this.dOt.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dOt.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.t(SwanAppQuickLoginDialog.this.dOe, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dOt.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aQS() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dOl;
        if (!TextUtils.isEmpty(this.dNU)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dNU);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aQO() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dOh.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.duG ? b.C0513b.aiapps_login_dialog_title_dark : b.C0513b.aiapps_login_dialog_title));
        this.dOs.setTextColor(resources.getColor(this.duG ? b.C0513b.aiapps_login_dialog_title_dark : b.C0513b.swan_app_color_000000));
        this.dOl.setTextColor(resources.getColor(this.duG ? b.C0513b.aiapps_login_dialog_title_dark : b.C0513b.aiapps_login_dialog_title));
        this.dOl.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.duG ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aQT();
        } else if (id == b.e.user_quick_login) {
            aQU();
        } else if (id == b.e.close) {
            hu(true);
            aQP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQT() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hu(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dNU, this.duG, null, this.dNX, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.hw(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dOe);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dNX, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aQU() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dOe)) {
            com.baidu.swan.apps.res.widget.b.d.t(this.dOe, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dNW != null) {
            f.a(this.dOe, this.dNW.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dOd.lX(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aQT();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dNX, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aQR() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dNW != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dNW.agreeText, this.dNW.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.azm().akE());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dOp.setMovementMethod(LinkMovementMethod.getInstance());
        this.dOp.setText(spannableStringBuilder);
    }
}
