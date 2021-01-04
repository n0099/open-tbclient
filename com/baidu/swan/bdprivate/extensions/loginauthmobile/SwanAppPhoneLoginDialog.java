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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView dXa;
    private BdBaseImageView dXb;
    private AccountSmsLoginView dXc;
    private FrameLayout dXd;
    private CheckBox dXe;
    private boolean dXf = false;
    private boolean dXg;
    private EditText dXh;
    private TextView dXi;
    private View dXj;
    private TextView mTitle;

    /* loaded from: classes9.dex */
    public interface a {
        void onCheckCodeViewHide();

        void onCheckCodeViewShow();

        void onFailure();

        void onSuccess();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        aTl();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dWX, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hM(!SwanAppPhoneLoginDialog.this.dXg);
                SwanAppPhoneLoginDialog.this.aTk();
                if (SwanAppPhoneLoginDialog.this.dXg) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dWQ, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dXa = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dXb = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dXe = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dXd = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dXj = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dXi = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aTm();
        this.dXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hM(true);
                SwanAppPhoneLoginDialog.this.aTk();
            }
        });
        if (this.dXg) {
            this.dXb.setVisibility(0);
            this.dXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hM(false);
                    SwanAppPhoneLoginDialog.this.aTk();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dWQ, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hO(boolean z) {
        this.dXg = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dXa.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dXb.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dAP ? b.C0506b.aiapps_login_dialog_title_dark : b.C0506b.aiapps_login_dialog_title));
            this.dXe.setTextColor(resources.getColor(this.dAP ? b.C0506b.aiapps_login_dialog_title_dark : b.C0506b.aiapps_login_dialog_title));
            this.dXe.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dAP ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aTj() {
        if (this.dXe != null) {
            this.dXe.setVisibility(0);
            this.dXe.setOnCheckedChangeListener(this);
        }
        if (this.dXi != null) {
            this.dXi.setVisibility(0);
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            jSONObject.put("sms_login", "native");
            str = URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.baidu.swan.bdprivate.a.a.a(getContext(), new a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.4
            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewShow() {
                SwanAppPhoneLoginDialog.this.dXe.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dXi.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dXe.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dXi.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dWQ, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dWX != null && SwanAppPhoneLoginDialog.this.dWX.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dWX, SwanAppPhoneLoginDialog.this.dWX.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dWW != null) {
                    SwanAppPhoneLoginDialog.this.dWW.me(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", com.baidu.pass.biometrics.face.liveness.c.a.p, SwanAppPhoneLoginDialog.this.dWQ, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dXf) {
                    SwanAppPhoneLoginDialog.this.aTk();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dWW != null) {
                    SwanAppPhoneLoginDialog.this.dWW.me(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dWX != null && SwanAppPhoneLoginDialog.this.dWX.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dWX, SwanAppPhoneLoginDialog.this.dWX.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dXc = new AccountSmsLoginView(getContext());
        this.dXd.addView(this.dXc);
        this.dXh = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.O(80.0f));
        layoutParams.setMargins(ah.O(40.0f), 0, ah.O(40.0f), 0);
        this.dXd.addView(this.dXj, layoutParams);
        this.dXj.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hN(boolean z) {
        super.hN(z);
        if (this.dXd != null && this.dXc != null) {
            this.dXc.close();
            this.dXd.removeView(this.dXc);
        }
        aTj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aTk() {
        if (this.dXc != null) {
            this.dXc.close();
        }
        super.aTk();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dXc != null) {
            this.dXc.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.dXc != null) {
            this.dXc.close();
        }
        super.onDestroyView();
    }

    private void aTl() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dXe;
        if (!TextUtils.isEmpty(this.dWN)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dWN);
        }
        checkBox.setText(string);
        this.dXc.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dXc != null) {
                    SwanAppPhoneLoginDialog.this.dXc.clean();
                }
            }
        }, 150L);
    }

    private void aTm() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aAD().alO());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dXi.setMovementMethod(LinkMovementMethod.getInstance());
        this.dXi.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dXj.setVisibility(8);
            this.dXh.setEnabled(true);
            this.dXc.aTd();
            return;
        }
        this.dXj.setVisibility(0);
        this.dXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppPhoneLoginDialog.this.dWX, b.g.swanapp_unchecked_auth_tip).hf(true);
            }
        });
        this.dXh.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.u(this.dWX, b.g.swanapp_unchecked_auth_tip).hf(true);
    }
}
