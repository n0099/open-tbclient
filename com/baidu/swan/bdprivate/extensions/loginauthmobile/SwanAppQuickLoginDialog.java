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
    private TextView dgA;
    private Button dgB;
    private TextView dgC;
    private BdBaseImageView dgp;
    private CheckBox dgt;
    private TextView dgx;
    private TextView mTitle;

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dgm, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppQuickLoginDialog.this.gl(true);
                SwanAppQuickLoginDialog.this.aGE();
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_quick_login_dialog_layout, viewGroup, false);
        this.dgp = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dgt = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dgA = (TextView) this.mRootView.findViewById(b.e.user_phone_number);
        this.dgB = (Button) this.mRootView.findViewById(b.e.user_quick_login);
        this.dgC = (TextView) this.mRootView.findViewById(b.e.user_login_with_other_phone);
        this.dgx = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aGG();
        aGH();
        if (this.dge != null) {
            this.dgA.setText(this.dge.encryptPhoneNum);
        }
        this.dgC.setOnClickListener(this);
        this.dgB.setOnClickListener(this);
        this.dgp.setOnClickListener(this);
        this.dgt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SwanAppQuickLoginDialog.this.dgB.setClickable(true);
                    SwanAppQuickLoginDialog.this.dgB.setBackgroundResource(b.d.swan_reply_editor_publish_selector);
                    return;
                }
                SwanAppQuickLoginDialog.this.dgB.setClickable(false);
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppQuickLoginDialog.this.dgm, b.g.swanapp_unchecked_auth_tip).showToast(true);
                SwanAppQuickLoginDialog.this.dgB.setBackgroundResource(b.d.swan_reply_editor_publish_disabled);
            }
        });
    }

    private void aGH() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dgt;
        if (!TextUtils.isEmpty(this.dgc)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dgc);
        }
        checkBox.setText(string);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aGD() {
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        this.dgp.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
        this.mTitle.setTextColor(resources.getColor(this.cMH ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
        this.dgA.setTextColor(resources.getColor(this.cMH ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.swan_app_color_000000));
        this.dgt.setTextColor(resources.getColor(this.cMH ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
        this.dgt.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cMH ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b.e.user_login_with_other_phone) {
            aGI();
        } else if (id == b.e.user_quick_login) {
            aGJ();
        } else if (id == b.e.close) {
            gl(true);
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
            gl(false);
            SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) e.a(this.dgc, this.cMH, null, this.dgf, this.mAppId);
            swanAppPhoneLoginDialog.d(getActivity());
            swanAppPhoneLoginDialog.gn(true);
            swanAppPhoneLoginDialog.a((SwanAppLoginAndGetMobileDialog.a) this.dgm);
            swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
            d.g("show", "telLogin", null, this.dgf, this.mAppId);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void aGJ() {
        if (!SwanAppNetworkUtils.isNetworkConnected(this.dgm)) {
            com.baidu.swan.apps.res.widget.b.d.k(this.dgm, b.g.swanapp_login_not_internet).showToast(true);
        } else if (this.dge != null) {
            f.a(this.dgm, this.dge.loginMode, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog.3
                @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                public void onResult(int i) {
                    String str;
                    SwanAppQuickLoginDialog.this.dgl.kA(i);
                    if (i != 0) {
                        SwanAppQuickLoginDialog.this.aGI();
                        str = "fail";
                    } else {
                        str = "succ_agree";
                    }
                    d.g("click", "quickLogin", str, SwanAppQuickLoginDialog.this.dgf, SwanAppQuickLoginDialog.this.mAppId);
                }
            });
        }
    }

    private void aGG() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        if (this.dge != null) {
            a(spannableStringBuilder, spannableStringBuilder.length(), this.dge.agreeText, this.dge.serviceAgreement);
            spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        }
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aoV().aap());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_register_tip));
        this.dgx.setMovementMethod(LinkMovementMethod.getInstance());
        this.dgx.setText(spannableStringBuilder);
    }
}
