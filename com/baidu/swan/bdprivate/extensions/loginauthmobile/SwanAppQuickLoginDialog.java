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
/* loaded from: classes9.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    private BdBaseImageView dXa;
    private CheckBox dXe;
    private TextView dXi;
    private TextView dXl;
    private Button dXm;
    private TextView dXn;
    private TextView mTitle;

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dWX, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hM(true);
                SwanAppQuickLoginDialog.this.aTl();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dXa = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dXe = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dXl = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dXm = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dXn = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dXi = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aTn();
        aTo();
        if (this.dWP != null) {
            this.dXl.setText(this.dWP.encryptPhoneNum);
        }
        this.dXn.setOnClickListener(this);
        this.dXm.setOnClickListener(this);
        this.dXa.setOnClickListener(this);
        this.dXe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dXm.setClickable(true);
                    SwanAppQuickLoginDialog.this.dXm.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dXm.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppQuickLoginDialog.this.dWX, b.g.swanapp_unchecked_auth_tip).hf(true);
                SwanAppQuickLoginDialog.this.dXm.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aTo() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dXe;
        if (!TextUtils.isEmpty(this.dWN)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dWN);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aTk() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dXa.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dAP ? b.C0506b.aiapps_login_dialog_title_dark : b.C0506b.aiapps_login_dialog_title));
        this.dXl.setTextColor(resources.getColor(this.dAP ? b.C0506b.aiapps_login_dialog_title_dark : b.C0506b.swan_app_color_000000));
        this.dXe.setTextColor(resources.getColor(this.dAP ? b.C0506b.aiapps_login_dialog_title_dark : b.C0506b.aiapps_login_dialog_title));
        this.dXe.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dAP ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aTp();
        } else if (id == b.e.user_quick_login) {
            aTq();
        } else if (id == b.e.close) {
            hM(true);
            aTl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hM(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dWN, this.dAP, null, this.dWQ, this.mAppId);
            swanAppPhoneLoginDialog.a(getActivity());
            swanAppPhoneLoginDialog.hO(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dWX);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dWQ, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aTq() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dWX)) {
            com.baidu.swan.apps.res.widget.b.d.u(this.dWX, b.g.swanapp_login_not_internet).hf(true);
        } else if (this.dWP != null) {
            f.a(this.dWX, this.dWP.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dWW.me(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aTp();
                        str = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dWQ, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aTn() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dWP != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dWP.agreeText, this.dWP.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aAE().alP());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dXi.setMovementMethod(LinkMovementMethod.getInstance());
        this.dXi.setText(spannableStringBuilder);
    }
}
