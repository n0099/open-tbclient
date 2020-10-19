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
/* loaded from: classes8.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView duC;
    private BdBaseImageView duD;
    private AccountSmsLoginView duE;
    private FrameLayout duF;
    private CheckBox duG;
    private boolean duH = false;
    private boolean duI;
    private EditText duJ;
    private TextView duK;
    private View duL;
    private TextView mTitle;

    /* loaded from: classes8.dex */
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
        aJY();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.duz, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.gG(!SwanAppPhoneLoginDialog.this.duI);
                SwanAppPhoneLoginDialog.this.aJX();
                if (SwanAppPhoneLoginDialog.this.duI) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dus, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.duC = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.duD = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.duG = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.duF = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.duL = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.duK = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aJZ();
        this.duC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.gG(true);
                SwanAppPhoneLoginDialog.this.aJX();
            }
        });
        if (this.duI) {
            this.duD.setVisibility(0);
            this.duD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.gG(false);
                    SwanAppPhoneLoginDialog.this.aJX();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dus, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void gI(boolean z) {
        this.duI = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.duC.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.duD.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.daQ ? b.C0477b.aiapps_login_dialog_title_dark : b.C0477b.aiapps_login_dialog_title));
            this.duG.setTextColor(resources.getColor(this.daQ ? b.C0477b.aiapps_login_dialog_title_dark : b.C0477b.aiapps_login_dialog_title));
            this.duG.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.daQ ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aJW() {
        if (this.duG != null) {
            this.duG.setVisibility(0);
            this.duG.setOnCheckedChangeListener(this);
        }
        if (this.duK != null) {
            this.duK.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.duG.setVisibility(8);
                SwanAppPhoneLoginDialog.this.duK.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.duG.setVisibility(0);
                SwanAppPhoneLoginDialog.this.duK.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dus, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.duz != null && SwanAppPhoneLoginDialog.this.duz.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.duz, SwanAppPhoneLoginDialog.this.duz.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.duy != null) {
                    SwanAppPhoneLoginDialog.this.duy.li(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dus, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.duH) {
                    SwanAppPhoneLoginDialog.this.aJX();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.duy != null) {
                    SwanAppPhoneLoginDialog.this.duy.li(-1);
                }
                if (SwanAppPhoneLoginDialog.this.duz != null && SwanAppPhoneLoginDialog.this.duz.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.duz, SwanAppPhoneLoginDialog.this.duz.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.duE = new AccountSmsLoginView(getContext());
        this.duF.addView(this.duE);
        this.duJ = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.J(80.0f));
        layoutParams.setMargins(ah.J(40.0f), 0, ah.J(40.0f), 0);
        this.duF.addView(this.duL, layoutParams);
        this.duL.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void gH(boolean z) {
        super.gH(z);
        if (this.duF != null && this.duE != null) {
            this.duE.close();
            this.duF.removeView(this.duE);
        }
        aJW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aJX() {
        if (this.duE != null) {
            this.duE.close();
        }
        super.aJX();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.duE != null) {
            this.duE.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.duE != null) {
            this.duE.close();
        }
        super.onDestroyView();
    }

    private void aJY() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.duG;
        if (!TextUtils.isEmpty(this.dup)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dup);
        }
        checkBox.setText(string);
        this.duE.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.duE != null) {
                    SwanAppPhoneLoginDialog.this.duE.clean();
                }
            }
        }, 150L);
    }

    private void aJZ() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.ass().adK());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.duK.setMovementMethod(LinkMovementMethod.getInstance());
        this.duK.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.duL.setVisibility(8);
            this.duJ.setEnabled(true);
            this.duE.aJQ();
            return;
        }
        this.duL.setVisibility(0);
        this.duL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.duz, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.duJ.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.duz, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
