package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity {
    private ah Kk;
    private ah Kl;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String Km = null;
    private String mVcodeUrl = null;
    private int Kn = 0;
    private boolean Ko = true;
    private boolean Kp = false;
    private boolean Kq = false;
    private boolean Kr = true;
    private EditText Ks = null;
    private EditText Kt = null;
    private EditText Ku = null;
    private View Kv = null;
    private ImageView Kw = null;
    private ImageView Kx = null;
    private ImageView Ky = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar Kz = null;
    private Button KA = null;
    private View KB = null;
    private View KC = null;
    private View KD = null;
    private View KE = null;
    private Button KF = null;
    private Button KG = null;
    private Button KH = null;
    private TextView KI = null;
    private TextView KJ = null;
    private TextView KK = null;
    private TextView KL = null;
    private Button KM = null;
    private Button KN = null;
    RelativeLayout KO = null;
    private aj KP = null;
    private com.baidu.tbadk.core.data.j KQ = null;
    private ai KR = null;
    InputMethodManager mInputManager = null;
    com.baidu.tbadk.coreExtra.view.r Kh = null;
    private AccountData KS = null;
    private String mInfo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_login_activity);
        this.mInfo = getIntent().getStringExtra(LoginActivityConfig.INFO);
        initUI();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(LoginActivityConfig.ACCOUNT);
        this.Ko = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.Kp = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.Kn = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.Kn = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.Kn = 1;
        }
        if (stringExtra != null) {
            this.Ks.setText(stringExtra);
        }
        this.Ks.requestFocus();
        if (this.Ko) {
            this.KB.setVisibility(4);
        } else {
            this.KB.setVisibility(0);
        }
        if (this.Kn == 0) {
            bU(com.baidu.tieba.v.normal_login);
        } else if (this.Kn == 1) {
            bU(com.baidu.tieba.v.mobile_login);
        }
        ShowSoftKeyPadDelay(this.Ks, 150);
        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.Kn = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.Kn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            oo();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.Kh != null) {
            this.Kh.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.Kh == null || !this.Kh.isShowing()) {
            ShowSoftKeyPadDelay(this.Ks, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Ko) {
                quitDialog();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                ob();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        int i = 1;
        TbadkApplication.m251getInst().onUserChanged();
        if (this.Kp) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), true)) {
                i = 4;
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(this, i, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.KO = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.KB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.account_regedit), new z(this));
        this.Ks = (EditText) findViewById(com.baidu.tieba.v.login_edit_account);
        this.Kt = (EditText) findViewById(com.baidu.tieba.v.login_edit_password);
        this.Ku = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.KC = findViewById(com.baidu.tieba.v.layout_account);
        this.KD = findViewById(com.baidu.tieba.v.layout_password);
        this.KE = findViewById(com.baidu.tieba.v.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.Kx = (ImageView) findViewById(com.baidu.tieba.v.image_vcode1);
        this.Ky = (ImageView) findViewById(com.baidu.tieba.v.image_vcode2);
        this.Kw = this.Kx;
        this.Kz = (ProgressBar) findViewById(com.baidu.tieba.v.progress_login);
        this.KA = (Button) findViewById(com.baidu.tieba.v.button_vcode_refresh);
        this.KF = (Button) findViewById(com.baidu.tieba.v.button_account_del);
        this.KG = (Button) findViewById(com.baidu.tieba.v.button_pass_del);
        this.KH = (Button) findViewById(com.baidu.tieba.v.button_vcode_del);
        this.KI = (TextView) findViewById(com.baidu.tieba.v.text_title_account);
        this.KJ = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.KK = (TextView) findViewById(com.baidu.tieba.v.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.KK.setText(this.mInfo);
            this.KK.setVisibility(0);
        }
        this.KL = (TextView) findViewById(com.baidu.tieba.v.text_login);
        this.KM = (Button) findViewById(com.baidu.tieba.v.normal_login);
        this.KN = (Button) findViewById(com.baidu.tieba.v.mobile_login);
        aa aaVar = new aa(this);
        this.Ks.setOnFocusChangeListener(aaVar);
        this.Kt.setOnFocusChangeListener(aaVar);
        this.Ku.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.Kt.setOnEditorActionListener(abVar);
        this.Ku.setOnEditorActionListener(abVar);
        this.Ks.addTextChangedListener(new ac(this));
        this.Kt.addTextChangedListener(new ad(this));
        this.Ku.addTextChangedListener(new ae(this));
        this.Kv = findViewById(com.baidu.tieba.v.layout_login);
        this.Kv.setEnabled(false);
        this.Kv.setOnClickListener(new af(this));
        ok();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.a(this.KL, i);
        aw.f(this.KO, i);
        if (i == 1) {
            this.KK.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
        } else {
            this.KK.setTextColor(-13279809);
        }
        on();
        od();
    }

    private void od() {
        if (this.Kn == 0) {
            if (this.mSkinType == 1) {
                this.KM.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.KN.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
            } else {
                this.KM.setTextColor(Color.rgb(50, 137, 203));
                this.KN.setTextColor(-16777216);
            }
            aw.h((View) this.KM, com.baidu.tieba.u.login_tab_pressed);
            aw.h((View) this.KN, com.baidu.tieba.u.login_tab_normal);
        } else if (this.Kn == 1) {
            if (this.mSkinType == 1) {
                this.KN.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.KM.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
            } else {
                this.KN.setTextColor(Color.rgb(50, 137, 203));
                this.KM.setTextColor(-16777216);
            }
            aw.h((View) this.KN, com.baidu.tieba.u.login_tab_pressed);
            aw.h((View) this.KM, com.baidu.tieba.u.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe() {
        boolean z;
        String editable = this.Ks.getText().toString();
        String editable2 = this.Kt.getText().toString();
        String editable3 = this.Ku.getText().toString();
        if (this.KE.getVisibility() == 8) {
            z = ay.aA(editable) || ay.aA(editable2);
        } else {
            z = ay.aA(editable) || ay.aA(editable2) || ay.aA(editable3);
        }
        if (!z) {
            this.Kv.setEnabled(true);
        } else {
            this.Kv.setEnabled(false);
        }
    }

    private void bU(int i) {
        if (i == com.baidu.tieba.v.normal_login) {
            this.Kw = this.Kx;
            this.Kx.setVisibility(0);
            this.Ky.setVisibility(8);
            og();
            this.Kn = 0;
            of();
            this.Ks.setHint(com.baidu.tieba.y.account_hint_normal);
            this.KI.setText(com.baidu.tieba.y.account_account);
            this.Ks.requestFocus();
            this.Ks.setInputType(1);
            od();
        } else if (i == com.baidu.tieba.v.mobile_login) {
            this.Kw = this.Ky;
            this.Kx.setVisibility(8);
            this.Ky.setVisibility(0);
            og();
            this.Kn = 1;
            of();
            this.Ks.setHint(com.baidu.tieba.y.account_mobile);
            this.KI.setText(com.baidu.tieba.y.account_mobile);
            this.Ks.requestFocus();
            this.Ks.setInputType(3);
            od();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.normal_login || id == com.baidu.tieba.v.mobile_login) {
            bU(view.getId());
        } else if (id == com.baidu.tieba.v.button_account_del) {
            this.Ks.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_pass_del) {
            this.Kt.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_del) {
            this.Ku.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_refresh || id == com.baidu.tieba.v.image_vcode1 || id == com.baidu.tieba.v.image_vcode2) {
            cm(this.mVcodeUrl);
        }
    }

    private void of() {
        if (this.Kn == 0) {
            if (this.Kk == null) {
                this.mAccount = null;
                this.Ks.setText((CharSequence) null);
                this.Kt.setText((CharSequence) null);
                this.Ku.setText((CharSequence) null);
                this.KE.setVisibility(8);
                this.KJ.setVisibility(4);
                this.Kr = true;
                this.Kq = false;
            } else {
                this.mAccount = this.Kk.mAccount;
                this.Ks.setText(this.Kk.mAccount);
                this.Kt.setText(this.Kk.mPassword);
                this.Ku.setText(this.Kk.mVcode);
                this.KJ.setText(this.Kk.Ca);
                this.KE.setVisibility(this.Kk.KU);
                this.KJ.setVisibility(this.Kk.KV);
                this.Kr = this.Kk.Kr;
                this.Kq = this.Kk.KU == 0;
            }
        }
        if (this.Kn == 1) {
            if (this.Kl == null) {
                this.mAccount = null;
                this.Ks.setText((CharSequence) null);
                this.Kt.setText((CharSequence) null);
                this.Ku.setText((CharSequence) null);
                this.KE.setVisibility(8);
                this.KJ.setVisibility(4);
                this.Kr = true;
                this.Kq = false;
            } else {
                this.mAccount = this.Kl.mAccount;
                this.Ks.setText(this.Kl.mAccount);
                this.Kt.setText(this.Kl.mPassword);
                this.Ku.setText(this.Kl.mVcode);
                this.KJ.setText(this.Kl.Ca);
                this.KE.setVisibility(this.Kl.KU);
                this.KJ.setVisibility(this.Kl.KV);
                this.Kr = this.Kl.Kr;
                this.Kq = this.Kl.KU == 0;
            }
        }
        on();
        oe();
    }

    private void og() {
        if (this.Kn == 0) {
            this.Kk = new ah(this, null);
            this.Kk.mAccount = this.Ks.getText().toString();
            this.Kk.mPassword = this.Kt.getText().toString();
            this.Kk.mVcode = this.Ku.getText().toString();
            this.Kk.Ca = this.KJ.getText().toString();
            this.Kk.KU = this.KE.getVisibility();
            this.Kk.KV = this.KJ.getVisibility();
            this.Kk.Kr = this.Kr;
        }
        if (this.Kn == 1) {
            this.Kl = new ah(this, null);
            this.Kl.mAccount = this.Ks.getText().toString();
            this.Kl.mPassword = this.Kt.getText().toString();
            this.Kl.mVcode = this.Ku.getText().toString();
            this.Kl.Ca = this.KJ.getText().toString();
            this.Kl.KU = this.KE.getVisibility();
            this.Kl.KV = this.KJ.getVisibility();
            this.Kl.Kr = this.Kr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh() {
        if (this.KP == null) {
            String editable = this.Ks.getText().toString();
            this.mPassword = ay.k(this.Kt.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.Kq || !ay.aA(this.Ku.getText().toString())) {
                    ol();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.Kn)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkApplication.m251getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId()));
                    if (this.KE != null && this.KE.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.Ku.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.Km));
                    }
                    oo();
                    this.KP = new aj(this, sb.toString(), arrayList);
                    this.KP.setPriority(3);
                    this.KP.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.KQ.getUser().getUserName());
        if (this.KQ.getUser().getPassword() != null) {
            accountData.setPassword(this.KQ.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.KQ.getUser().getUserId());
        accountData.setBDUSS(this.KQ.getUser().getBDUSS());
        accountData.setPortrait(this.KQ.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.KQ.jZ() != null) {
            accountData.setTbs(this.KQ.jZ().getTbs());
        }
        this.KS = accountData;
        if (!TextUtils.isEmpty(this.KS.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(this.KS, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.KS.getID();
            sapiAccount.displayname = this.KS.getAccount();
            sapiAccount.bduss = this.KS.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            ob();
            return;
        }
        if (this.Kh == null) {
            this.Kh = new com.baidu.tbadk.coreExtra.view.r(this);
            this.Kh.a(new ag(this));
        }
        this.Kh.qa();
        this.Kh.setPhone(this.Ks.getText().toString());
        this.Kh.g(this.KS);
        this.Kh.pX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        this.Kr = false;
        on();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(String str) {
        if (this.KR != null) {
            this.KR.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.Kw.setImageDrawable(null);
        oo();
        this.KR = new ai(this, null);
        this.KR.setPriority(3);
        this.KR.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj() {
        this.Kq = true;
        this.KE.setVisibility(0);
        this.Ku.setText((CharSequence) null);
        if (this.Kr) {
            aw.h(this.KD, com.baidu.tieba.u.login_input_middle);
        } else {
            aw.h(this.KD, com.baidu.tieba.u.login_input_middlewrong);
        }
        oe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok() {
        this.Kq = false;
        this.KE.setVisibility(8);
        if (this.Kr) {
            this.KD.setBackgroundResource(com.baidu.tieba.u.login_input_under);
        } else {
            this.KD.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong);
        }
        oe();
    }

    private void ol() {
        this.Ks.setEnabled(false);
        this.Kt.setEnabled(false);
        this.Ku.setEnabled(false);
        this.KA.setEnabled(false);
        this.Kw.setEnabled(false);
        this.KF.setEnabled(false);
        this.KG.setEnabled(false);
        this.KH.setEnabled(false);
        this.KM.setEnabled(false);
        this.KN.setEnabled(false);
        this.Ks.setTextColor(Color.rgb(136, 136, 136));
        this.Kt.setTextColor(Color.rgb(136, 136, 136));
        this.Ku.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om() {
        this.Ks.setEnabled(true);
        this.Kt.setEnabled(true);
        this.Ku.setEnabled(true);
        this.KA.setEnabled(true);
        this.Kw.setEnabled(true);
        this.KF.setEnabled(true);
        this.KG.setEnabled(true);
        this.KH.setEnabled(true);
        this.KM.setEnabled(true);
        this.KN.setEnabled(true);
        this.Ks.setTextColor(-16777216);
        this.Kt.setTextColor(-16777216);
        this.Ku.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on() {
        if (this.Kr) {
            aw.h(this.KC, com.baidu.tieba.u.login_input_top);
            if (this.Kq) {
                aw.h(this.KD, com.baidu.tieba.u.login_input_middle);
            } else {
                aw.h(this.KD, com.baidu.tieba.u.login_input_under);
            }
            aw.h(this.KE, com.baidu.tieba.u.login_input_under);
            return;
        }
        aw.h(this.KC, com.baidu.tieba.u.login_input_topwrong);
        if (this.Kq) {
            aw.h(this.KD, com.baidu.tieba.u.login_input_middlewrong);
        } else {
            aw.h(this.KD, com.baidu.tieba.u.login_input_underwrong);
        }
        aw.h(this.KE, com.baidu.tieba.u.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo() {
        if (this.KP != null) {
            this.KP.cancel();
            this.KP = null;
        }
        if (this.KR != null) {
            this.KR.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op() {
        oo();
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(this);
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
