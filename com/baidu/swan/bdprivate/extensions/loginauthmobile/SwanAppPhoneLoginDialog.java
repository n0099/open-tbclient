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
    private BdBaseImageView dCZ;
    private BdBaseImageView dDa;
    private AccountSmsLoginView dDb;
    private FrameLayout dDc;
    private CheckBox dDd;
    private boolean dDe = false;
    private boolean dDf;
    private EditText dDg;
    private TextView dDh;
    private View dDi;
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
        aLS();
        return this.mRootView;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(this.dCW, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.gT(!SwanAppPhoneLoginDialog.this.dDf);
                SwanAppPhoneLoginDialog.this.aLR();
                if (SwanAppPhoneLoginDialog.this.dDf) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dCP, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dCZ = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dDa = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dDd = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dDc = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dDi = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dDh = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aLT();
        this.dCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.gT(true);
                SwanAppPhoneLoginDialog.this.aLR();
            }
        });
        if (this.dDf) {
            this.dDa.setVisibility(0);
            this.dDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.gT(false);
                    SwanAppPhoneLoginDialog.this.aLR();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dCP, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void gV(boolean z) {
        this.dDf = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dCZ.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dDa.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.djs ? b.C0491b.aiapps_login_dialog_title_dark : b.C0491b.aiapps_login_dialog_title));
            this.dDd.setTextColor(resources.getColor(this.djs ? b.C0491b.aiapps_login_dialog_title_dark : b.C0491b.aiapps_login_dialog_title));
            this.dDd.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.djs ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aLQ() {
        if (this.dDd != null) {
            this.dDd.setVisibility(0);
            this.dDd.setOnCheckedChangeListener(this);
        }
        if (this.dDh != null) {
            this.dDh.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dDd.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dDh.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dDd.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dDh.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dCP, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dCW != null && SwanAppPhoneLoginDialog.this.dCW.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dCW, SwanAppPhoneLoginDialog.this.dCW.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dCV != null) {
                    SwanAppPhoneLoginDialog.this.dCV.lt(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dCP, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dDe) {
                    SwanAppPhoneLoginDialog.this.aLR();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dCV != null) {
                    SwanAppPhoneLoginDialog.this.dCV.lt(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dCW != null && SwanAppPhoneLoginDialog.this.dCW.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dCW, SwanAppPhoneLoginDialog.this.dCW.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dDb = new AccountSmsLoginView(getContext());
        this.dDc.addView(this.dDb);
        this.dDg = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.L(80.0f));
        layoutParams.setMargins(ah.L(40.0f), 0, ah.L(40.0f), 0);
        this.dDc.addView(this.dDi, layoutParams);
        this.dDi.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void gU(boolean z) {
        super.gU(z);
        if (this.dDc != null && this.dDb != null) {
            this.dDb.close();
            this.dDc.removeView(this.dDb);
        }
        aLQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aLR() {
        if (this.dDb != null) {
            this.dDb.close();
        }
        super.aLR();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dDb != null) {
            this.dDb.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dDb != null) {
            this.dDb.close();
        }
        super.onDestroyView();
    }

    private void aLS() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dDd;
        if (!TextUtils.isEmpty(this.dCM)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dCM);
        }
        checkBox.setText(string);
        this.dDb.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dDb != null) {
                    SwanAppPhoneLoginDialog.this.dDb.clean();
                }
            }
        }, 150L);
    }

    private void aLT() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_tip));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_swan), com.baidu.swan.apps.t.a.aum().afE());
        spannableStringBuilder.append((CharSequence) getString(b.g.swanapp_service_agreement_comma));
        a(spannableStringBuilder, spannableStringBuilder.length(), getString(b.g.swanapp_service_agreement_baidu), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
        this.dDh.setMovementMethod(LinkMovementMethod.getInstance());
        this.dDh.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dDi.setVisibility(8);
            this.dDg.setEnabled(true);
            this.dDb.aLK();
            return;
        }
        this.dDi.setVisibility(0);
        this.dDi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dCW, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dDg.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dCW, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
