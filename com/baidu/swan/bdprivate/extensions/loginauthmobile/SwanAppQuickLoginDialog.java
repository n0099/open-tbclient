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
    private CheckBox diA;
    private TextView diE;
    private TextView diH;
    private Button diI;
    private TextView diJ;
    private BdBaseImageView diw;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dit, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.gk(true);
                SwanAppQuickLoginDialog.this.aHo();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.diw = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.diA = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.diH = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.diI = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.diJ = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.diE = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aHq();
        aHr();
        if (this.dij != null) {
            this.diH.setText(this.dij.encryptPhoneNum);
        }
        this.diJ.setOnClickListener(this);
        this.diI.setOnClickListener(this);
        this.diw.setOnClickListener(this);
        this.diA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.diI.setClickable(true);
                    SwanAppQuickLoginDialog.this.diI.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.diI.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dit, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.diI.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aHr() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.diA;
        if (!TextUtils.isEmpty(this.dih)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dih);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aHn() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.diw.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.cOL ? b.C0460b.aiapps_login_dialog_title_dark : b.C0460b.aiapps_login_dialog_title));
        this.diH.setTextColor(resources.getColor(this.cOL ? b.C0460b.aiapps_login_dialog_title_dark : b.C0460b.swan_app_color_000000));
        this.diA.setTextColor(resources.getColor(this.cOL ? b.C0460b.aiapps_login_dialog_title_dark : b.C0460b.aiapps_login_dialog_title));
        this.diA.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cOL ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aHs();
        } else if (id == b.e.user_quick_login) {
            aHt();
        } else if (id == b.e.close) {
            gk(true);
            aHo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHs() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            gk(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dih, this.cOL, null, this.dik, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.gm(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dit);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dik, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aHt() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dit)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dit, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dij != null) {
            f.a(this.dit, this.dij.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.diq.kL(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aHs();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dik, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aHq() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dij != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dij.agreeText, this.dij.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.apG().aaY());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.diE.setMovementMethod(LinkMovementMethod.getInstance());
        this.diE.setText(spannableStringBuilder);
    }
}
