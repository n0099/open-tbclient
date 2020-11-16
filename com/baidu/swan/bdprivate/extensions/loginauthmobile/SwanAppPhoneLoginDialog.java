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
/* loaded from: classes7.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView dHj;
    private BdBaseImageView dHk;
    private AccountSmsLoginView dHl;
    private FrameLayout dHm;
    private CheckBox dHn;
    private boolean dHo = false;
    private boolean dHp;
    private EditText dHq;
    private TextView dHr;
    private View dHs;
    private TextView mTitle;

    /* loaded from: classes7.dex */
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
        aNK();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dHg, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hf(!SwanAppPhoneLoginDialog.this.dHp);
                SwanAppPhoneLoginDialog.this.aNJ();
                if (SwanAppPhoneLoginDialog.this.dHp) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dGZ, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dHj = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dHk = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dHn = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dHm = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dHs = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dHr = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aNL();
        this.dHj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hf(true);
                SwanAppPhoneLoginDialog.this.aNJ();
            }
        });
        if (this.dHp) {
            this.dHk.setVisibility(0);
            this.dHk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hf(false);
                    SwanAppPhoneLoginDialog.this.aNJ();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dGZ, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hh(boolean z) {
        this.dHp = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dHj.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dHk.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dnE ? b.C0501b.aiapps_login_dialog_title_dark : b.C0501b.aiapps_login_dialog_title));
            this.dHn.setTextColor(resources.getColor(this.dnE ? b.C0501b.aiapps_login_dialog_title_dark : b.C0501b.aiapps_login_dialog_title));
            this.dHn.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dnE ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aNI() {
        if (this.dHn != null) {
            this.dHn.setVisibility(0);
            this.dHn.setOnCheckedChangeListener(this);
        }
        if (this.dHr != null) {
            this.dHr.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dHn.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dHr.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dHn.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dHr.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dGZ, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dHg != null && SwanAppPhoneLoginDialog.this.dHg.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dHg, SwanAppPhoneLoginDialog.this.dHg.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dHf != null) {
                    SwanAppPhoneLoginDialog.this.dHf.lz(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dGZ, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dHo) {
                    SwanAppPhoneLoginDialog.this.aNJ();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dHf != null) {
                    SwanAppPhoneLoginDialog.this.dHf.lz(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dHg != null && SwanAppPhoneLoginDialog.this.dHg.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dHg, SwanAppPhoneLoginDialog.this.dHg.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dHl = new AccountSmsLoginView(getContext());
        this.dHm.addView(this.dHl);
        this.dHq = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.M(80.0f));
        layoutParams.setMargins(ah.M(40.0f), 0, ah.M(40.0f), 0);
        this.dHm.addView(this.dHs, layoutParams);
        this.dHs.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hg(boolean z) {
        super.hg(z);
        if (this.dHm != null && this.dHl != null) {
            this.dHl.close();
            this.dHm.removeView(this.dHl);
        }
        aNI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aNJ() {
        if (this.dHl != null) {
            this.dHl.close();
        }
        super.aNJ();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dHl != null) {
            this.dHl.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dHl != null) {
            this.dHl.close();
        }
        super.onDestroyView();
    }

    private void aNK() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dHn;
        if (!TextUtils.isEmpty(this.dGW)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dGW);
        }
        checkBox.setText(string);
        this.dHl.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dHl != null) {
                    SwanAppPhoneLoginDialog.this.dHl.clean();
                }
            }
        }, 150L);
    }

    private void aNL() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awe().ahw());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dHr.setMovementMethod(LinkMovementMethod.getInstance());
        this.dHr.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dHs.setVisibility(8);
            this.dHq.setEnabled(true);
            this.dHl.aNC();
            return;
        }
        this.dHs.setVisibility(0);
        this.dHs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dHg, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dHq.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dHg, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
