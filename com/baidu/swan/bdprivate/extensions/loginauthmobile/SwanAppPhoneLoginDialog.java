package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView dOh;
    private BdBaseImageView dOi;
    private AccountSmsLoginView dOj;
    private FrameLayout dOk;
    private CheckBox dOl;
    private boolean dOm = false;
    private boolean dOn;
    private EditText dOo;
    private TextView dOp;
    private View dOq;
    private TextView mTitle;

    /* loaded from: classes25.dex */
    public interface a {
        void onCheckCodeViewHide();

        void onCheckCodeViewShow();

        void onFailure();

        void onSuccess();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        aQQ();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dOe, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hu(!SwanAppPhoneLoginDialog.this.dOn);
                SwanAppPhoneLoginDialog.this.aQP();
                if (SwanAppPhoneLoginDialog.this.dOn) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dNX, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dOh = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dOi = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dOl = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dOk = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dOq = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dOp = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aQR();
        this.dOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hu(true);
                SwanAppPhoneLoginDialog.this.aQP();
            }
        });
        if (this.dOn) {
            this.dOi.setVisibility(0);
            this.dOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hu(false);
                    SwanAppPhoneLoginDialog.this.aQP();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dNX, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hw(boolean z) {
        this.dOn = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dOh.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dOi.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.duG ? b.C0513b.aiapps_login_dialog_title_dark : b.C0513b.aiapps_login_dialog_title));
            this.dOl.setTextColor(resources.getColor(this.duG ? b.C0513b.aiapps_login_dialog_title_dark : b.C0513b.aiapps_login_dialog_title));
            this.dOl.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.duG ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aQO() {
        if (this.dOl != null) {
            this.dOl.setVisibility(0);
            this.dOl.setOnCheckedChangeListener(this);
        }
        if (this.dOp != null) {
            this.dOp.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dOl.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dOp.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dOl.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dOp.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dNX, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dOe != null && SwanAppPhoneLoginDialog.this.dOe.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dOe, SwanAppPhoneLoginDialog.this.dOe.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dOd != null) {
                    SwanAppPhoneLoginDialog.this.dOd.lX(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dNX, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dOm) {
                    SwanAppPhoneLoginDialog.this.aQP();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dOd != null) {
                    SwanAppPhoneLoginDialog.this.dOd.lX(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dOe != null && SwanAppPhoneLoginDialog.this.dOe.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dOe, SwanAppPhoneLoginDialog.this.dOe.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dOj = new AccountSmsLoginView(getContext());
        this.dOk.addView(this.dOj);
        this.dOo = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.M(80.0f));
        layoutParams.setMargins(ah.M(40.0f), 0, ah.M(40.0f), 0);
        this.dOk.addView(this.dOq, layoutParams);
        this.dOq.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hv(boolean z) {
        super.hv(z);
        if (this.dOk != null && this.dOj != null) {
            this.dOj.close();
            this.dOk.removeView(this.dOj);
        }
        aQO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aQP() {
        if (this.dOj != null) {
            this.dOj.close();
        }
        super.aQP();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dOj != null) {
            this.dOj.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dOj != null) {
            this.dOj.close();
        }
        super.onDestroyView();
    }

    private void aQQ() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dOl;
        if (!TextUtils.isEmpty(this.dNU)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dNU);
        }
        checkBox.setText(string);
        this.dOj.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dOj != null) {
                    SwanAppPhoneLoginDialog.this.dOj.clean();
                }
            }
        }, 150L);
    }

    private void aQR() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.azm().akE());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dOp.setMovementMethod(LinkMovementMethod.getInstance());
        this.dOp.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dOq.setVisibility(8);
            this.dOo.setEnabled(true);
            this.dOj.aQI();
            return;
        }
        this.dOq.setVisibility(0);
        this.dOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.t(SwanAppPhoneLoginDialog.this.dOe, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dOo.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.t(this.dOe, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
