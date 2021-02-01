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
    private boolean dUA;
    private EditText dUB;
    private TextView dUC;
    private View dUD;
    private BdBaseImageView dUu;
    private BdBaseImageView dUv;
    private AccountSmsLoginView dUw;
    private FrameLayout dUx;
    private CheckBox dUy;
    private boolean dUz = false;
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
        aPL();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dUr, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hK(!SwanAppPhoneLoginDialog.this.dUA);
                SwanAppPhoneLoginDialog.this.aPK();
                if (SwanAppPhoneLoginDialog.this.dUA) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dUk, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dUu = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dUv = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dUy = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dUx = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dUD = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dUC = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPM();
        this.dUu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hK(true);
                SwanAppPhoneLoginDialog.this.aPK();
            }
        });
        if (this.dUA) {
            this.dUv.setVisibility(0);
            this.dUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hK(false);
                    SwanAppPhoneLoginDialog.this.aPK();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dUk, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hM(boolean z) {
        this.dUA = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dUu.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dUv.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dyk ? b.C0486b.aiapps_login_dialog_title_dark : b.C0486b.aiapps_login_dialog_title));
            this.dUy.setTextColor(resources.getColor(this.dyk ? b.C0486b.aiapps_login_dialog_title_dark : b.C0486b.aiapps_login_dialog_title));
            this.dUy.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dyk ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPJ() {
        if (this.dUy != null) {
            this.dUy.setVisibility(0);
            this.dUy.setOnCheckedChangeListener(this);
        }
        if (this.dUC != null) {
            this.dUC.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dUy.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dUC.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dUy.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dUC.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dUk, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dUr != null && SwanAppPhoneLoginDialog.this.dUr.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dUr, SwanAppPhoneLoginDialog.this.dUr.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dUq != null) {
                    SwanAppPhoneLoginDialog.this.dUq.kB(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", com.baidu.pass.biometrics.face.liveness.c.a.p, SwanAppPhoneLoginDialog.this.dUk, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dUz) {
                    SwanAppPhoneLoginDialog.this.aPK();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dUq != null) {
                    SwanAppPhoneLoginDialog.this.dUq.kB(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dUr != null && SwanAppPhoneLoginDialog.this.dUr.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dUr, SwanAppPhoneLoginDialog.this.dUr.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dUw = new AccountSmsLoginView(getContext());
        this.dUx.addView(this.dUw);
        this.dUB = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.P(80.0f));
        layoutParams.setMargins(ah.P(40.0f), 0, ah.P(40.0f), 0);
        this.dUx.addView(this.dUD, layoutParams);
        this.dUD.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hL(boolean z) {
        super.hL(z);
        if (this.dUx != null && this.dUw != null) {
            this.dUw.close();
            this.dUx.removeView(this.dUw);
        }
        aPJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aPK() {
        if (this.dUw != null) {
            this.dUw.close();
        }
        super.aPK();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dUw != null) {
            this.dUw.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.dUw != null) {
            this.dUw.close();
        }
        super.onDestroyView();
    }

    private void aPL() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dUy;
        if (!TextUtils.isEmpty(this.dUh)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dUh);
        }
        checkBox.setText(string);
        this.dUw.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dUw != null) {
                    SwanAppPhoneLoginDialog.this.dUw.clean();
                }
            }
        }, 150L);
    }

    private void aPM() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.axi().ait());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dUC.setMovementMethod(LinkMovementMethod.getInstance());
        this.dUC.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dUD.setVisibility(8);
            this.dUB.setEnabled(true);
            this.dUw.aPD();
            return;
        }
        this.dUD.setVisibility(0);
        this.dUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppPhoneLoginDialog.this.dUr, b.g.swanapp_unchecked_auth_tip).hd(true);
            }
        });
        this.dUB.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.u(this.dUr, b.g.swanapp_unchecked_auth_tip).hd(true);
    }
}
