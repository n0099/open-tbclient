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
    private BdBaseImageView dSo;
    private BdBaseImageView dSp;
    private AccountSmsLoginView dSq;
    private FrameLayout dSr;
    private CheckBox dSs;
    private boolean dSt = false;
    private boolean dSu;
    private EditText dSv;
    private TextView dSw;
    private View dSx;
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
        aPs();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dSl, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.hI(!SwanAppPhoneLoginDialog.this.dSu);
                SwanAppPhoneLoginDialog.this.aPr();
                if (SwanAppPhoneLoginDialog.this.dSu) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dSe, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dSo = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dSp = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dSs = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dSr = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dSx = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dSw = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aPt();
        this.dSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.hI(true);
                SwanAppPhoneLoginDialog.this.aPr();
            }
        });
        if (this.dSu) {
            this.dSp.setVisibility(0);
            this.dSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.hI(false);
                    SwanAppPhoneLoginDialog.this.aPr();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dSe, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void hK(boolean z) {
        this.dSu = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dSo.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dSp.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.dwd ? b.C0489b.aiapps_login_dialog_title_dark : b.C0489b.aiapps_login_dialog_title));
            this.dSs.setTextColor(resources.getColor(this.dwd ? b.C0489b.aiapps_login_dialog_title_dark : b.C0489b.aiapps_login_dialog_title));
            this.dSs.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.dwd ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aPq() {
        if (this.dSs != null) {
            this.dSs.setVisibility(0);
            this.dSs.setOnCheckedChangeListener(this);
        }
        if (this.dSw != null) {
            this.dSw.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dSs.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dSw.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dSs.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dSw.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dSe, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dSl != null && SwanAppPhoneLoginDialog.this.dSl.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dSl, SwanAppPhoneLoginDialog.this.dSl.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dSk != null) {
                    SwanAppPhoneLoginDialog.this.dSk.ky(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", com.baidu.pass.biometrics.face.liveness.c.a.p, SwanAppPhoneLoginDialog.this.dSe, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dSt) {
                    SwanAppPhoneLoginDialog.this.aPr();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dSk != null) {
                    SwanAppPhoneLoginDialog.this.dSk.ky(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dSl != null && SwanAppPhoneLoginDialog.this.dSl.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dSl, SwanAppPhoneLoginDialog.this.dSl.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dSq = new AccountSmsLoginView(getContext());
        this.dSr.addView(this.dSq);
        this.dSv = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.O(80.0f));
        layoutParams.setMargins(ah.O(40.0f), 0, ah.O(40.0f), 0);
        this.dSr.addView(this.dSx, layoutParams);
        this.dSx.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void hJ(boolean z) {
        super.hJ(z);
        if (this.dSr != null && this.dSq != null) {
            this.dSq.close();
            this.dSr.removeView(this.dSq);
        }
        aPq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aPr() {
        if (this.dSq != null) {
            this.dSq.close();
        }
        super.aPr();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dSq != null) {
            this.dSq.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.dSq != null) {
            this.dSq.close();
        }
        super.onDestroyView();
    }

    private void aPs() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dSs;
        if (!TextUtils.isEmpty(this.dSb)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dSb);
        }
        checkBox.setText(string);
        this.dSq.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dSq != null) {
                    SwanAppPhoneLoginDialog.this.dSq.clean();
                }
            }
        }, 150L);
    }

    private void aPt() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.awK().ahV());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dSw.setMovementMethod(LinkMovementMethod.getInstance());
        this.dSw.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dSx.setVisibility(8);
            this.dSv.setEnabled(true);
            this.dSq.aPk();
            return;
        }
        this.dSx.setVisibility(0);
        this.dSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.u(SwanAppPhoneLoginDialog.this.dSl, b.g.swanapp_unchecked_auth_tip).hb(true);
            }
        });
        this.dSv.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.u(this.dSl, b.g.swanapp_unchecked_auth_tip).hb(true);
    }
}
