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
/* loaded from: classes8.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    private BdBaseImageView dVV;
    private BdBaseImageView dVW;
    private AccountSmsLoginView dVX;
    private FrameLayout dVY;
    private CheckBox dVZ;
    private boolean dWa = false;
    private boolean dWb;
    private EditText dWc;
    private TextView dWd;
    private View dWe;
    private TextView mTitle;

    /* loaded from: classes8.dex */
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
        aPO();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dVS, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hK(!SwanAppPhoneLoginDialog.this.dWb);
                SwanAppPhoneLoginDialog.this.aPN();
                if (SwanAppPhoneLoginDialog.this.dWb) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dVL, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dVV = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dVW = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dVZ = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dVY = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dWe = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dWd = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPP();
        this.dVV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hK(true);
                SwanAppPhoneLoginDialog.this.aPN();
            }
        });
        if (this.dWb) {
            this.dVW.setVisibility(0);
            this.dVW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hK(false);
                    SwanAppPhoneLoginDialog.this.aPN();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dVL, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hM(boolean z) {
        this.dWb = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dVV.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dVW.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dzL ? b.C0492b.aiapps_login_dialog_title_dark : b.C0492b.aiapps_login_dialog_title));
            this.dVZ.setTextColor(resources.getColor(this.dzL ? b.C0492b.aiapps_login_dialog_title_dark : b.C0492b.aiapps_login_dialog_title));
            this.dVZ.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dzL ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPM() {
        if (this.dVZ != null) {
            this.dVZ.setVisibility(0);
            this.dVZ.setOnCheckedChangeListener(this);
        }
        if (this.dWd != null) {
            this.dWd.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dVZ.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dWd.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dVZ.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dWd.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dVL, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dVS != null && SwanAppPhoneLoginDialog.this.dVS.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dVS, SwanAppPhoneLoginDialog.this.dVS.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dVR != null) {
                    SwanAppPhoneLoginDialog.this.dVR.kC(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", com.baidu.pass.biometrics.face.liveness.c.a.p, SwanAppPhoneLoginDialog.this.dVL, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dWa) {
                    SwanAppPhoneLoginDialog.this.aPN();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dVR != null) {
                    SwanAppPhoneLoginDialog.this.dVR.kC(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dVS != null && SwanAppPhoneLoginDialog.this.dVS.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dVS, SwanAppPhoneLoginDialog.this.dVS.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dVX = new AccountSmsLoginView(getContext());
        this.dVY.addView(this.dVX);
        this.dWc = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.T(80.0f));
        layoutParams.setMargins(ah.T(40.0f), 0, ah.T(40.0f), 0);
        this.dVY.addView(this.dWe, layoutParams);
        this.dWe.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hL(boolean z) {
        super.hL(z);
        if (this.dVY != null && this.dVX != null) {
            this.dVX.close();
            this.dVY.removeView(this.dVX);
        }
        aPM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aPN() {
        if (this.dVX != null) {
            this.dVX.close();
        }
        super.aPN();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dVX != null) {
            this.dVX.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.dVX != null) {
            this.dVX.close();
        }
        super.onDestroyView();
    }

    private void aPO() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dVZ;
        if (!TextUtils.isEmpty(this.dVI)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dVI);
        }
        checkBox.setText(string);
        this.dVX.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dVX != null) {
                    SwanAppPhoneLoginDialog.this.dVX.clean();
                }
            }
        }, 150L);
    }

    private void aPP() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.axl().aiw());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dWd.setMovementMethod(LinkMovementMethod.getInstance());
        this.dWd.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dWe.setVisibility(8);
            this.dWc.setEnabled(true);
            this.dVX.aPG();
            return;
        }
        this.dWe.setVisibility(0);
        this.dWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppPhoneLoginDialog.this.dVS, b.g.swanapp_unchecked_auth_tip).hd(true);
            }
        });
        this.dWc.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.u(this.dVS, b.g.swanapp_unchecked_auth_tip).hd(true);
    }
}
