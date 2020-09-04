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
/* loaded from: classes3.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private EditText dgA;
    private TextView dgB;
    private View dgC;
    private BdBaseImageView dgt;
    private BdBaseImageView dgu;
    private AccountSmsLoginView dgv;
    private FrameLayout dgw;
    private CheckBox dgx;
    private boolean dgy = false;
    private boolean dgz;
    private TextView mTitle;

    /* loaded from: classes3.dex */
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
        aGF();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dgq, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.gm(!SwanAppPhoneLoginDialog.this.dgz);
                SwanAppPhoneLoginDialog.this.aGE();
                if (SwanAppPhoneLoginDialog.this.dgz) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dgj, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dgt = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dgu = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dgx = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dgw = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dgC = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dgB = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aGG();
        this.dgt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.gm(true);
                SwanAppPhoneLoginDialog.this.aGE();
            }
        });
        if (this.dgz) {
            this.dgu.setVisibility(0);
            this.dgu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.gm(false);
                    SwanAppPhoneLoginDialog.this.aGE();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dgj, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void go(boolean z) {
        this.dgz = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dgt.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dgu.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.cML ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
            this.dgx.setTextColor(resources.getColor(this.cML ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
            this.dgx.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cML ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aGD() {
        if (this.dgx != null) {
            this.dgx.setVisibility(0);
            this.dgx.setOnCheckedChangeListener(this);
        }
        if (this.dgB != null) {
            this.dgB.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dgx.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dgB.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dgx.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dgB.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dgj, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dgq != null && SwanAppPhoneLoginDialog.this.dgq.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dgq, SwanAppPhoneLoginDialog.this.dgq.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dgp != null) {
                    SwanAppPhoneLoginDialog.this.dgp.kA(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dgj, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dgy) {
                    SwanAppPhoneLoginDialog.this.aGE();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dgp != null) {
                    SwanAppPhoneLoginDialog.this.dgp.kA(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dgq != null && SwanAppPhoneLoginDialog.this.dgq.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dgq, SwanAppPhoneLoginDialog.this.dgq.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dgv = new AccountSmsLoginView(getContext());
        this.dgw.addView(this.dgv);
        this.dgA = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.H(80.0f));
        layoutParams.setMargins(ah.H(40.0f), 0, ah.H(40.0f), 0);
        this.dgw.addView(this.dgC, layoutParams);
        this.dgC.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void gn(boolean z) {
        super.gn(z);
        if (this.dgw != null && this.dgv != null) {
            this.dgv.close();
            this.dgw.removeView(this.dgv);
        }
        aGD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aGE() {
        if (this.dgv != null) {
            this.dgv.close();
        }
        super.aGE();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dgv != null) {
            this.dgv.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dgv != null) {
            this.dgv.close();
        }
        super.onDestroyView();
    }

    private void aGF() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dgx;
        if (!TextUtils.isEmpty(this.dgg)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dgg);
        }
        checkBox.setText(string);
        this.dgv.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dgv != null) {
                    SwanAppPhoneLoginDialog.this.dgv.clean();
                }
            }
        }, 150L);
    }

    private void aGG() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aoV().aap());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dgB.setMovementMethod(LinkMovementMethod.getInstance());
        this.dgB.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dgC.setVisibility(8);
            this.dgA.setEnabled(true);
            this.dgv.aGx();
            return;
        }
        this.dgC.setVisibility(0);
        this.dgC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dgq, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dgA.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dgq, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
