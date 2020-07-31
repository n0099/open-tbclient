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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView cXg;
    private BdBaseImageView cXh;
    private AccountSmsLoginView cXi;
    private FrameLayout cXj;
    private CheckBox cXk;
    private boolean cXl = false;
    private boolean cXm;
    private EditText cXn;
    private TextView cXo;
    private View cXp;
    private TextView mTitle;

    /* loaded from: classes11.dex */
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
        ayw();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.cXd, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.fS(!SwanAppPhoneLoginDialog.this.cXm);
                SwanAppPhoneLoginDialog.this.ayv();
                if (SwanAppPhoneLoginDialog.this.cXm) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.f("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.cWW, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.cXg = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.cXh = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.cXk = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.cXj = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.cXp = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.cXo = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        ayx();
        this.cXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.fS(true);
                SwanAppPhoneLoginDialog.this.ayv();
            }
        });
        if (this.cXm) {
            this.cXh.setVisibility(0);
            this.cXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.fS(false);
                    SwanAppPhoneLoginDialog.this.ayv();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.f("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.cWW, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void fU(boolean z) {
        this.cXm = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.cXg.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.cXh.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.cDJ ? b.C0422b.aiapps_login_dialog_title_dark : b.C0422b.aiapps_login_dialog_title));
            this.cXk.setTextColor(resources.getColor(this.cDJ ? b.C0422b.aiapps_login_dialog_title_dark : b.C0422b.aiapps_login_dialog_title));
            this.cXk.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cDJ ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void ayu() {
        if (this.cXk != null) {
            this.cXk.setVisibility(0);
            this.cXk.setOnCheckedChangeListener(this);
        }
        if (this.cXo != null) {
            this.cXo.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.cXk.setVisibility(8);
                SwanAppPhoneLoginDialog.this.cXo.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.cXk.setVisibility(0);
                SwanAppPhoneLoginDialog.this.cXo.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.f("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.cWW, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.cXd != null && SwanAppPhoneLoginDialog.this.cXd.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.cXd, SwanAppPhoneLoginDialog.this.cXd.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.cXc != null) {
                    SwanAppPhoneLoginDialog.this.cXc.is(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.f("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.cWW, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.cXl) {
                    SwanAppPhoneLoginDialog.this.ayv();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.cXc != null) {
                    SwanAppPhoneLoginDialog.this.cXc.is(-1);
                }
                if (SwanAppPhoneLoginDialog.this.cXd != null && SwanAppPhoneLoginDialog.this.cXd.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.cXd, SwanAppPhoneLoginDialog.this.cXd.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.cXi = new AccountSmsLoginView(getContext());
        this.cXj.addView(this.cXi);
        this.cXn = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ai.D(80.0f));
        layoutParams.setMargins(ai.D(40.0f), 0, ai.D(40.0f), 0);
        this.cXj.addView(this.cXp, layoutParams);
        this.cXp.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void fT(boolean z) {
        super.fT(z);
        if (this.cXj != null && this.cXi != null) {
            this.cXi.close();
            this.cXj.removeView(this.cXi);
        }
        ayu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void ayv() {
        if (this.cXi != null) {
            this.cXi.close();
        }
        super.ayv();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.cXi != null) {
            this.cXi.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cXi != null) {
            this.cXi.close();
        }
        super.onDestroyView();
    }

    private void ayw() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.cXk;
        if (!TextUtils.isEmpty(this.cWT)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.cWT);
        }
        checkBox.setText(string);
        this.cXi.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.cXi != null) {
                    SwanAppPhoneLoginDialog.this.cXi.clean();
                }
            }
        }, 150L);
    }

    private void ayx() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.ahv().Un());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.cXo.setMovementMethod(LinkMovementMethod.getInstance());
        this.cXo.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.cXp.setVisibility(8);
            this.cXn.setEnabled(true);
            this.cXi.ayo();
            return;
        }
        this.cXp.setVisibility(0);
        this.cXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.cXd, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.cXn.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.cXd, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
