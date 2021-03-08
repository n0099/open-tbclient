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
    private BdBaseImageView dVV;
    private CheckBox dVZ;
    private TextView dWd;
    private TextView dWg;
    private Button dWh;
    private TextView dWi;
    private TextView mTitle;

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dVS, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hK(true);
                SwanAppQuickLoginDialog.this.aPN();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dVV = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dVZ = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dWg = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dWh = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dWi = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dWd = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPP();
        aPQ();
        if (this.dVK != null) {
            this.dWg.setText(this.dVK.encryptPhoneNum);
        }
        this.dWi.setOnClickListener(this);
        this.dWh.setOnClickListener(this);
        this.dVV.setOnClickListener(this);
        this.dVZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dWh.setClickable(true);
                    SwanAppQuickLoginDialog.this.dWh.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dWh.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppQuickLoginDialog.this.dVS, b.g.swanapp_unchecked_auth_tip).hd(true);
                SwanAppQuickLoginDialog.this.dWh.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aPQ() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dVZ;
        if (!TextUtils.isEmpty(this.dVI)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dVI);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPM() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dVV.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dzL ? b.C0492b.aiapps_login_dialog_title_dark : b.C0492b.aiapps_login_dialog_title));
        this.dWg.setTextColor(resources.getColor(this.dzL ? b.C0492b.aiapps_login_dialog_title_dark : b.C0492b.swan_app_color_000000));
        this.dVZ.setTextColor(resources.getColor(this.dzL ? b.C0492b.aiapps_login_dialog_title_dark : b.C0492b.aiapps_login_dialog_title));
        this.dVZ.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dzL ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aPR();
        } else if (id == b.e.user_quick_login) {
            aPS();
        } else if (id == b.e.close) {
            hK(true);
            aPN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPR() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hK(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dVI, this.dzL, null, this.dVL, this.mAppId);
            swanAppPhoneLoginDialog.a(getActivity());
            swanAppPhoneLoginDialog.hM(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dVS);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dVL, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aPS() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dVS)) {
            com.baidu.swan.apps.res.widget.b.d.u(this.dVS, b.g.swanapp_login_not_internet).hd(true);
        } else if (this.dVK != null) {
            f.a(this.dVS, this.dVK.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dVR.kC(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aPR();
                        str = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dVL, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aPP() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dVK != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dVK.agreeText, this.dVK.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.axl().aiw());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dWd.setMovementMethod(LinkMovementMethod.getInstance());
        this.dWd.setText(spannableStringBuilder);
    }
}
