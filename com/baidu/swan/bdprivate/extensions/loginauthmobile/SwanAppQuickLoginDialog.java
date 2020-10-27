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
    private BdBaseImageView dCZ;
    private CheckBox dDd;
    private TextView dDh;
    private TextView dDk;
    private Button dDl;
    private TextView dDm;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dCW, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.gT(true);
                SwanAppQuickLoginDialog.this.aLR();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dCZ = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dDd = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dDk = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dDl = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dDm = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dDh = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aLT();
        aLU();
        if (this.dCO != null) {
            this.dDk.setText(this.dCO.encryptPhoneNum);
        }
        this.dDm.setOnClickListener(this);
        this.dDl.setOnClickListener(this);
        this.dCZ.setOnClickListener(this);
        this.dDd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dDl.setClickable(true);
                    SwanAppQuickLoginDialog.this.dDl.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dDl.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dCW, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dDl.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aLU() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dDd;
        if (!TextUtils.isEmpty(this.dCM)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dCM);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aLQ() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dCZ.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.djs ? b.C0491b.aiapps_login_dialog_title_dark : b.C0491b.aiapps_login_dialog_title));
        this.dDk.setTextColor(resources.getColor(this.djs ? b.C0491b.aiapps_login_dialog_title_dark : b.C0491b.swan_app_color_000000));
        this.dDd.setTextColor(resources.getColor(this.djs ? b.C0491b.aiapps_login_dialog_title_dark : b.C0491b.aiapps_login_dialog_title));
        this.dDd.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.djs ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aLV();
        } else if (id == b.e.user_quick_login) {
            aLW();
        } else if (id == b.e.close) {
            gT(true);
            aLR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLV() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            gT(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dCM, this.djs, null, this.dCP, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.gV(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dCW);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dCP, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aLW() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dCW)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dCW, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dCO != null) {
            f.a(this.dCW, this.dCO.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dCV.lt(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aLV();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dCP, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aLT() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dCO != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dCO.agreeText, this.dCO.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aum().afE());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dDh.setMovementMethod(LinkMovementMethod.getInstance());
        this.dDh.setText(spannableStringBuilder);
    }
}
