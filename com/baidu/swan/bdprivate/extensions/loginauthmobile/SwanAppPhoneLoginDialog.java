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
    private CheckBox diA;
    private boolean diB = false;
    private boolean diC;
    private EditText diD;
    private TextView diE;
    private View diF;
    private BdBaseImageView diw;
    private BdBaseImageView dix;
    private AccountSmsLoginView diy;
    private FrameLayout diz;
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
        aHp();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dit, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.gk(!SwanAppPhoneLoginDialog.this.diC);
                SwanAppPhoneLoginDialog.this.aHo();
                if (SwanAppPhoneLoginDialog.this.diC) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dik, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.diw = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dix = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.diA = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.diz = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.diF = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.diE = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aHq();
        this.diw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.gk(true);
                SwanAppPhoneLoginDialog.this.aHo();
            }
        });
        if (this.diC) {
            this.dix.setVisibility(0);
            this.dix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.gk(false);
                    SwanAppPhoneLoginDialog.this.aHo();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dik, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void gm(boolean z) {
        this.diC = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.diw.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dix.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.cOL ? b.C0460b.aiapps_login_dialog_title_dark : b.C0460b.aiapps_login_dialog_title));
            this.diA.setTextColor(resources.getColor(this.cOL ? b.C0460b.aiapps_login_dialog_title_dark : b.C0460b.aiapps_login_dialog_title));
            this.diA.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cOL ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aHn() {
        if (this.diA != null) {
            this.diA.setVisibility(0);
            this.diA.setOnCheckedChangeListener(this);
        }
        if (this.diE != null) {
            this.diE.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.diA.setVisibility(8);
                SwanAppPhoneLoginDialog.this.diE.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.diA.setVisibility(0);
                SwanAppPhoneLoginDialog.this.diE.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dik, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dit != null && SwanAppPhoneLoginDialog.this.dit.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dit, SwanAppPhoneLoginDialog.this.dit.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.diq != null) {
                    SwanAppPhoneLoginDialog.this.diq.kL(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dik, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.diB) {
                    SwanAppPhoneLoginDialog.this.aHo();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.diq != null) {
                    SwanAppPhoneLoginDialog.this.diq.kL(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dit != null && SwanAppPhoneLoginDialog.this.dit.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dit, SwanAppPhoneLoginDialog.this.dit.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.diy = new AccountSmsLoginView(getContext());
        this.diz.addView(this.diy);
        this.diD = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.H(80.0f));
        layoutParams.setMargins(ah.H(40.0f), 0, ah.H(40.0f), 0);
        this.diz.addView(this.diF, layoutParams);
        this.diF.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void gl(boolean z) {
        super.gl(z);
        if (this.diz != null && this.diy != null) {
            this.diy.close();
            this.diz.removeView(this.diy);
        }
        aHn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aHo() {
        if (this.diy != null) {
            this.diy.close();
        }
        super.aHo();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.diy != null) {
            this.diy.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.diy != null) {
            this.diy.close();
        }
        super.onDestroyView();
    }

    private void aHp() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.diA;
        if (!TextUtils.isEmpty(this.dih)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dih);
        }
        checkBox.setText(string);
        this.diy.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.diy != null) {
                    SwanAppPhoneLoginDialog.this.diy.clean();
                }
            }
        }, 150L);
    }

    private void aHq() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.apG().aaY());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.diE.setMovementMethod(LinkMovementMethod.getInstance());
        this.diE.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.diF.setVisibility(8);
            this.diD.setEnabled(true);
            this.diy.aHh();
            return;
        }
        this.diF.setVisibility(0);
        this.diF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dit, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.diD.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dit, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
