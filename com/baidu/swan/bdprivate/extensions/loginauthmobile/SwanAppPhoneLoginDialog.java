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
    private BdBaseImageView dIR;
    private BdBaseImageView dIS;
    private AccountSmsLoginView dIT;
    private FrameLayout dIU;
    private CheckBox dIV;
    private boolean dIW = false;
    private boolean dIX;
    private EditText dIY;
    private TextView dIZ;
    private View dJa;
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
        aOs();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dIO, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hc(!SwanAppPhoneLoginDialog.this.dIX);
                SwanAppPhoneLoginDialog.this.aOr();
                if (SwanAppPhoneLoginDialog.this.dIX) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dIH, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dIR = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dIS = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dIV = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dIU = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dJa = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dIZ = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aOt();
        this.dIR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hc(true);
                SwanAppPhoneLoginDialog.this.aOr();
            }
        });
        if (this.dIX) {
            this.dIS.setVisibility(0);
            this.dIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hc(false);
                    SwanAppPhoneLoginDialog.this.aOr();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dIH, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void he(boolean z) {
        this.dIX = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dIR.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dIS.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dpn ? b.C0503b.aiapps_login_dialog_title_dark : b.C0503b.aiapps_login_dialog_title));
            this.dIV.setTextColor(resources.getColor(this.dpn ? b.C0503b.aiapps_login_dialog_title_dark : b.C0503b.aiapps_login_dialog_title));
            this.dIV.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dpn ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aOq() {
        if (this.dIV != null) {
            this.dIV.setVisibility(0);
            this.dIV.setOnCheckedChangeListener(this);
        }
        if (this.dIZ != null) {
            this.dIZ.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dIV.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dIZ.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dIV.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dIZ.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dIH, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dIO != null && SwanAppPhoneLoginDialog.this.dIO.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dIO, SwanAppPhoneLoginDialog.this.dIO.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dIN != null) {
                    SwanAppPhoneLoginDialog.this.dIN.lD(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dIH, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dIW) {
                    SwanAppPhoneLoginDialog.this.aOr();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dIN != null) {
                    SwanAppPhoneLoginDialog.this.dIN.lD(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dIO != null && SwanAppPhoneLoginDialog.this.dIO.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dIO, SwanAppPhoneLoginDialog.this.dIO.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dIT = new AccountSmsLoginView(getContext());
        this.dIU.addView(this.dIT);
        this.dIY = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.N(80.0f));
        layoutParams.setMargins(ah.N(40.0f), 0, ah.N(40.0f), 0);
        this.dIU.addView(this.dJa, layoutParams);
        this.dJa.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hd(boolean z) {
        super.hd(z);
        if (this.dIU != null && this.dIT != null) {
            this.dIT.close();
            this.dIU.removeView(this.dIT);
        }
        aOq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aOr() {
        if (this.dIT != null) {
            this.dIT.close();
        }
        super.aOr();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dIT != null) {
            this.dIT.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dIT != null) {
            this.dIT.close();
        }
        super.onDestroyView();
    }

    private void aOs() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dIV;
        if (!TextUtils.isEmpty(this.dIE)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dIE);
        }
        checkBox.setText(string);
        this.dIT.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dIT != null) {
                    SwanAppPhoneLoginDialog.this.dIT.clean();
                }
            }
        }, 150L);
    }

    private void aOt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awM().aie());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dIZ.setMovementMethod(LinkMovementMethod.getInstance());
        this.dIZ.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dJa.setVisibility(8);
            this.dIY.setEnabled(true);
            this.dIT.aOk();
            return;
        }
        this.dJa.setVisibility(0);
        this.dJa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dIO, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dIY.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dIO, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
