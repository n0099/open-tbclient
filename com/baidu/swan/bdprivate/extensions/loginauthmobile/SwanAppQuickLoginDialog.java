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
    private TextView dUC;
    private TextView dUF;
    private Button dUG;
    private TextView dUH;
    private BdBaseImageView dUu;
    private CheckBox dUy;
    private TextView mTitle;

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dUr, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.hK(true);
                SwanAppQuickLoginDialog.this.aPK();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dUu = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dUy = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dUF = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dUG = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dUH = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dUC = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPM();
        aPN();
        if (this.dUj != null) {
            this.dUF.setText(this.dUj.encryptPhoneNum);
        }
        this.dUH.setOnClickListener(this);
        this.dUG.setOnClickListener(this);
        this.dUu.setOnClickListener(this);
        this.dUy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dUG.setClickable(true);
                    SwanAppQuickLoginDialog.this.dUG.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dUG.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppQuickLoginDialog.this.dUr, b.g.swanapp_unchecked_auth_tip).hd(true);
                SwanAppQuickLoginDialog.this.dUG.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aPN() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dUy;
        if (!TextUtils.isEmpty(this.dUh)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dUh);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPJ() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dUu.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.dyk ? b.C0486b.aiapps_login_dialog_title_dark : b.C0486b.aiapps_login_dialog_title));
        this.dUF.setTextColor(resources.getColor(this.dyk ? b.C0486b.aiapps_login_dialog_title_dark : b.C0486b.swan_app_color_000000));
        this.dUy.setTextColor(resources.getColor(this.dyk ? b.C0486b.aiapps_login_dialog_title_dark : b.C0486b.aiapps_login_dialog_title));
        this.dUy.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dyk ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aPO();
        } else if (id == b.e.user_quick_login) {
            aPP();
        } else if (id == b.e.close) {
            hK(true);
            aPK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPO() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            hK(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dUh, this.dyk, null, this.dUk, this.mAppId);
            swanAppPhoneLoginDialog.a(getActivity());
            swanAppPhoneLoginDialog.hM(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dUr);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dUk, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aPP() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dUr)) {
            com.baidu.swan.apps.res.widget.b.d.u(this.dUr, b.g.swanapp_login_not_internet).hd(true);
        } else if (this.dUj != null) {
            f.a(this.dUr, this.dUj.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dUq.kB(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aPO();
                        str = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dUk, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aPM() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dUj != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dUj.agreeText, this.dUj.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.axi().ait());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dUC.setMovementMethod(LinkMovementMethod.getInstance());
        this.dUC.setText(spannableStringBuilder);
    }
}
