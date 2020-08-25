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
    private BdBaseImageView dgp;
    private BdBaseImageView dgq;
    private AccountSmsLoginView dgr;
    private FrameLayout dgs;
    private CheckBox dgt;
    private boolean dgu = false;
    private boolean dgv;
    private EditText dgw;
    private TextView dgx;
    private View dgy;
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
        return new Dialog(this.dgm, getTheme()) { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                SwanAppPhoneLoginDialog.this.gl(!SwanAppPhoneLoginDialog.this.dgv);
                SwanAppPhoneLoginDialog.this.aGE();
                if (SwanAppPhoneLoginDialog.this.dgv) {
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dgf, SwanAppPhoneLoginDialog.this.mAppId);
                }
            }
        };
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.mRootView = (LinearLayout) layoutInflater.inflate(b.f.swan_app_login_and_getphonenum_dialog_layout, viewGroup, false);
        this.dgp = (BdBaseImageView) this.mRootView.findViewById(b.e.close);
        this.dgq = (BdBaseImageView) this.mRootView.findViewById(b.e.back);
        this.dgt = (CheckBox) this.mRootView.findViewById(b.e.phonenum_autho_switch);
        this.dgs = (FrameLayout) this.mRootView.findViewById(b.e.login_input_layout);
        this.dgy = new View(getContext());
        this.mTitle = (TextView) this.mRootView.findViewById(b.e.title);
        this.dgx = (TextView) this.mRootView.findViewById(b.e.user_service_agreement);
        aGG();
        this.dgp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppPhoneLoginDialog.this.gl(true);
                SwanAppPhoneLoginDialog.this.aGE();
            }
        });
        if (this.dgv) {
            this.dgq.setVisibility(0);
            this.dgq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SwanAppPhoneLoginDialog.this.gl(false);
                    SwanAppPhoneLoginDialog.this.aGE();
                    FragmentManager fragmentManager = SwanAppPhoneLoginDialog.this.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    d.g("show", "quickLogin", null, SwanAppPhoneLoginDialog.this.dgf, SwanAppPhoneLoginDialog.this.mAppId);
                }
            });
        }
    }

    public void gn(boolean z) {
        this.dgv = z;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void updateUI() {
        Resources resources = getContext().getResources();
        if (resources != null) {
            this.dgp.setImageDrawable(resources.getDrawable(b.d.swanapp_login_dialog_close));
            this.dgq.setImageDrawable(resources.getDrawable(b.d.aiapps_action_bar_back_selector));
            this.mTitle.setTextColor(resources.getColor(this.cMH ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
            this.dgt.setTextColor(resources.getColor(this.cMH ? b.C0465b.aiapps_login_dialog_title_dark : b.C0465b.aiapps_login_dialog_title));
            this.dgt.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.cMH ? b.d.aiapp_login_and_phonenum_autho_selector_dark : b.d.aiapp_login_and_phonenum_autho_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    protected void aGD() {
        if (this.dgt != null) {
            this.dgt.setVisibility(0);
            this.dgt.setOnCheckedChangeListener(this);
        }
        if (this.dgx != null) {
            this.dgx.setVisibility(0);
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
                SwanAppPhoneLoginDialog.this.dgt.setVisibility(8);
                SwanAppPhoneLoginDialog.this.dgx.setVisibility(8);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onCheckCodeViewHide() {
                SwanAppPhoneLoginDialog.this.dgt.setVisibility(0);
                SwanAppPhoneLoginDialog.this.dgx.setVisibility(0);
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onSuccess() {
                d.g("click", "telLogin", "succ_agree", SwanAppPhoneLoginDialog.this.dgf, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dgm != null && SwanAppPhoneLoginDialog.this.dgm.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dgm, SwanAppPhoneLoginDialog.this.dgm.getWindow().getDecorView().getWindowToken());
                }
                if (SwanAppPhoneLoginDialog.this.dgl != null) {
                    SwanAppPhoneLoginDialog.this.dgl.kA(0);
                }
            }

            @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.a
            public void onFailure() {
                d.g("click", "telLogin", "fail", SwanAppPhoneLoginDialog.this.dgf, SwanAppPhoneLoginDialog.this.mAppId);
                if (SwanAppPhoneLoginDialog.this.dgu) {
                    SwanAppPhoneLoginDialog.this.aGE();
                    return;
                }
                if (SwanAppPhoneLoginDialog.this.dgl != null) {
                    SwanAppPhoneLoginDialog.this.dgl.kA(-1);
                }
                if (SwanAppPhoneLoginDialog.this.dgm != null && SwanAppPhoneLoginDialog.this.dgm.getWindow() != null) {
                    w.forceHiddenSoftInput(SwanAppPhoneLoginDialog.this.dgm, SwanAppPhoneLoginDialog.this.dgm.getWindow().getDecorView().getWindowToken());
                }
            }
        }, str);
        this.dgr = new AccountSmsLoginView(getContext());
        this.dgs.addView(this.dgr);
        this.dgw = (EditText) this.mRootView.findViewById(b.e.phone);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.H(80.0f));
        layoutParams.setMargins(ah.H(40.0f), 0, ah.H(40.0f), 0);
        this.dgs.addView(this.dgy, layoutParams);
        this.dgy.setVisibility(8);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void gm(boolean z) {
        super.gm(z);
        if (this.dgs != null && this.dgr != null) {
            this.dgr.close();
            this.dgs.removeView(this.dgr);
        }
        aGD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void aGE() {
        if (this.dgr != null) {
            this.dgr.close();
        }
        super.aGE();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dgr != null) {
            this.dgr.close();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dgr != null) {
            this.dgr.close();
        }
        super.onDestroyView();
    }

    private void aGF() {
        String string = getContext().getString(b.g.swanapp_phonenum_checkbox_tip);
        CheckBox checkBox = this.dgt;
        if (!TextUtils.isEmpty(this.dgc)) {
            string = String.format(getString(b.g.swanapp_auth_switch_tip), this.dgc);
        }
        checkBox.setText(string);
        this.dgr.postDelayed(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.5
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppPhoneLoginDialog.this.dgr != null) {
                    SwanAppPhoneLoginDialog.this.dgr.clean();
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
        this.dgx.setMovementMethod(LinkMovementMethod.getInstance());
        this.dgx.setText(spannableStringBuilder);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dgy.setVisibility(8);
            this.dgw.setEnabled(true);
            this.dgr.aGx();
            return;
        }
        this.dgy.setVisibility(0);
        this.dgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.apps.res.widget.b.d.k(SwanAppPhoneLoginDialog.this.dgm, b.g.swanapp_unchecked_auth_tip).showToast(true);
            }
        });
        this.dgw.setEnabled(false);
        com.baidu.swan.apps.res.widget.b.d.k(this.dgm, b.g.swanapp_unchecked_auth_tip).showToast(true);
    }
}
