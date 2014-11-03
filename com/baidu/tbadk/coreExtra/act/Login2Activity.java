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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity {
    private ah Kl;
    private ah Km;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String Kn = null;
    private String mVcodeUrl = null;
    private int Ko = 0;
    private boolean Kp = true;
    private boolean Kq = false;
    private boolean Kr = false;
    private boolean Ks = true;
    private EditText Kt = null;
    private EditText Ku = null;
    private EditText Kv = null;
    private View Kw = null;
    private ImageView Kx = null;
    private ImageView Ky = null;
    private ImageView Kz = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar KA = null;
    private Button KB = null;
    private View KC = null;
    private View KD = null;
    private View KE = null;
    private View KF = null;
    private Button KG = null;
    private Button KH = null;
    private Button KI = null;
    private TextView KJ = null;
    private TextView KK = null;
    private TextView KL = null;
    private TextView KM = null;
    private Button KN = null;
    private Button KO = null;
    RelativeLayout KP = null;
    private aj KQ = null;
    private com.baidu.tbadk.core.data.j KR = null;
    private ai KS = null;
    InputMethodManager mInputManager = null;
    com.baidu.tbadk.coreExtra.view.r Ki = null;
    private AccountData KT = null;
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
        this.Kp = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.Kq = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.Ko = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.Ko = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.Ko = 1;
        }
        if (stringExtra != null) {
            this.Kt.setText(stringExtra);
        }
        this.Kt.requestFocus();
        if (this.Kp) {
            this.KC.setVisibility(4);
        } else {
            this.KC.setVisibility(0);
        }
        if (this.Ko == 0) {
            bU(com.baidu.tieba.v.normal_login);
        } else if (this.Ko == 1) {
            bU(com.baidu.tieba.v.mobile_login);
        }
        ShowSoftKeyPadDelay(this.Kt, 150);
        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.Ko = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.Ko);
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
        if (this.Ki != null) {
            this.Ki.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.Ki == null || !this.Ki.isShowing()) {
            ShowSoftKeyPadDelay(this.Kt, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Kp) {
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
        if (this.Kq) {
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
        this.KP = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.KC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.account_regedit), new z(this));
        this.Kt = (EditText) findViewById(com.baidu.tieba.v.login_edit_account);
        this.Ku = (EditText) findViewById(com.baidu.tieba.v.login_edit_password);
        this.Kv = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.KD = findViewById(com.baidu.tieba.v.layout_account);
        this.KE = findViewById(com.baidu.tieba.v.layout_password);
        this.KF = findViewById(com.baidu.tieba.v.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.Ky = (ImageView) findViewById(com.baidu.tieba.v.image_vcode1);
        this.Kz = (ImageView) findViewById(com.baidu.tieba.v.image_vcode2);
        this.Kx = this.Ky;
        this.KA = (ProgressBar) findViewById(com.baidu.tieba.v.progress_login);
        this.KB = (Button) findViewById(com.baidu.tieba.v.button_vcode_refresh);
        this.KG = (Button) findViewById(com.baidu.tieba.v.button_account_del);
        this.KH = (Button) findViewById(com.baidu.tieba.v.button_pass_del);
        this.KI = (Button) findViewById(com.baidu.tieba.v.button_vcode_del);
        this.KJ = (TextView) findViewById(com.baidu.tieba.v.text_title_account);
        this.KK = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.KL = (TextView) findViewById(com.baidu.tieba.v.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.KL.setText(this.mInfo);
            this.KL.setVisibility(0);
        }
        this.KM = (TextView) findViewById(com.baidu.tieba.v.text_login);
        this.KN = (Button) findViewById(com.baidu.tieba.v.normal_login);
        this.KO = (Button) findViewById(com.baidu.tieba.v.mobile_login);
        aa aaVar = new aa(this);
        this.Kt.setOnFocusChangeListener(aaVar);
        this.Ku.setOnFocusChangeListener(aaVar);
        this.Kv.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.Ku.setOnEditorActionListener(abVar);
        this.Kv.setOnEditorActionListener(abVar);
        this.Kt.addTextChangedListener(new ac(this));
        this.Ku.addTextChangedListener(new ad(this));
        this.Kv.addTextChangedListener(new ae(this));
        this.Kw = findViewById(com.baidu.tieba.v.layout_login);
        this.Kw.setEnabled(false);
        this.Kw.setOnClickListener(new af(this));
        ok();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.a(this.KM, i);
        aw.f(this.KP, i);
        if (i == 1) {
            this.KL.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
        } else {
            this.KL.setTextColor(-13279809);
        }
        on();
        od();
    }

    private void od() {
        if (this.Ko == 0) {
            if (this.mSkinType == 1) {
                this.KN.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.KO.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
            } else {
                this.KN.setTextColor(Color.rgb(50, 137, 203));
                this.KO.setTextColor(-16777216);
            }
            aw.h((View) this.KN, com.baidu.tieba.u.login_tab_pressed);
            aw.h((View) this.KO, com.baidu.tieba.u.login_tab_normal);
        } else if (this.Ko == 1) {
            if (this.mSkinType == 1) {
                this.KO.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.KN.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
            } else {
                this.KO.setTextColor(Color.rgb(50, 137, 203));
                this.KN.setTextColor(-16777216);
            }
            aw.h((View) this.KO, com.baidu.tieba.u.login_tab_pressed);
            aw.h((View) this.KN, com.baidu.tieba.u.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe() {
        boolean z;
        String editable = this.Kt.getText().toString();
        String editable2 = this.Ku.getText().toString();
        String editable3 = this.Kv.getText().toString();
        if (this.KF.getVisibility() == 8) {
            z = az.aA(editable) || az.aA(editable2);
        } else {
            z = az.aA(editable) || az.aA(editable2) || az.aA(editable3);
        }
        if (!z) {
            this.Kw.setEnabled(true);
        } else {
            this.Kw.setEnabled(false);
        }
    }

    private void bU(int i) {
        if (i == com.baidu.tieba.v.normal_login) {
            this.Kx = this.Ky;
            this.Ky.setVisibility(0);
            this.Kz.setVisibility(8);
            og();
            this.Ko = 0;
            of();
            this.Kt.setHint(com.baidu.tieba.y.account_hint_normal);
            this.KJ.setText(com.baidu.tieba.y.account_account);
            this.Kt.requestFocus();
            this.Kt.setInputType(1);
            od();
        } else if (i == com.baidu.tieba.v.mobile_login) {
            this.Kx = this.Kz;
            this.Ky.setVisibility(8);
            this.Kz.setVisibility(0);
            og();
            this.Ko = 1;
            of();
            this.Kt.setHint(com.baidu.tieba.y.account_mobile);
            this.KJ.setText(com.baidu.tieba.y.account_mobile);
            this.Kt.requestFocus();
            this.Kt.setInputType(3);
            od();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.normal_login || id == com.baidu.tieba.v.mobile_login) {
            bU(view.getId());
        } else if (id == com.baidu.tieba.v.button_account_del) {
            this.Kt.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_pass_del) {
            this.Ku.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_del) {
            this.Kv.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_refresh || id == com.baidu.tieba.v.image_vcode1 || id == com.baidu.tieba.v.image_vcode2) {
            cm(this.mVcodeUrl);
        }
    }

    private void of() {
        if (this.Ko == 0) {
            if (this.Kl == null) {
                this.mAccount = null;
                this.Kt.setText((CharSequence) null);
                this.Ku.setText((CharSequence) null);
                this.Kv.setText((CharSequence) null);
                this.KF.setVisibility(8);
                this.KK.setVisibility(4);
                this.Ks = true;
                this.Kr = false;
            } else {
                this.mAccount = this.Kl.mAccount;
                this.Kt.setText(this.Kl.mAccount);
                this.Ku.setText(this.Kl.mPassword);
                this.Kv.setText(this.Kl.mVcode);
                this.KK.setText(this.Kl.Cb);
                this.KF.setVisibility(this.Kl.KV);
                this.KK.setVisibility(this.Kl.KW);
                this.Ks = this.Kl.Ks;
                this.Kr = this.Kl.KV == 0;
            }
        }
        if (this.Ko == 1) {
            if (this.Km == null) {
                this.mAccount = null;
                this.Kt.setText((CharSequence) null);
                this.Ku.setText((CharSequence) null);
                this.Kv.setText((CharSequence) null);
                this.KF.setVisibility(8);
                this.KK.setVisibility(4);
                this.Ks = true;
                this.Kr = false;
            } else {
                this.mAccount = this.Km.mAccount;
                this.Kt.setText(this.Km.mAccount);
                this.Ku.setText(this.Km.mPassword);
                this.Kv.setText(this.Km.mVcode);
                this.KK.setText(this.Km.Cb);
                this.KF.setVisibility(this.Km.KV);
                this.KK.setVisibility(this.Km.KW);
                this.Ks = this.Km.Ks;
                this.Kr = this.Km.KV == 0;
            }
        }
        on();
        oe();
    }

    private void og() {
        if (this.Ko == 0) {
            this.Kl = new ah(this, null);
            this.Kl.mAccount = this.Kt.getText().toString();
            this.Kl.mPassword = this.Ku.getText().toString();
            this.Kl.mVcode = this.Kv.getText().toString();
            this.Kl.Cb = this.KK.getText().toString();
            this.Kl.KV = this.KF.getVisibility();
            this.Kl.KW = this.KK.getVisibility();
            this.Kl.Ks = this.Ks;
        }
        if (this.Ko == 1) {
            this.Km = new ah(this, null);
            this.Km.mAccount = this.Kt.getText().toString();
            this.Km.mPassword = this.Ku.getText().toString();
            this.Km.mVcode = this.Kv.getText().toString();
            this.Km.Cb = this.KK.getText().toString();
            this.Km.KV = this.KF.getVisibility();
            this.Km.KW = this.KK.getVisibility();
            this.Km.Ks = this.Ks;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh() {
        if (this.KQ == null) {
            String editable = this.Kt.getText().toString();
            this.mPassword = az.k(this.Ku.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.Kr || !az.aA(this.Kv.getText().toString())) {
                    ol();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.Ko)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkApplication.m251getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkApplication.m251getInst().getPushChannelUserId()));
                    if (this.KF != null && this.KF.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.Kv.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.Kn));
                    }
                    oo();
                    this.KQ = new aj(this, sb.toString(), arrayList);
                    this.KQ.setPriority(3);
                    this.KQ.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.KR.getUser().getUserName());
        if (this.KR.getUser().getPassword() != null) {
            accountData.setPassword(this.KR.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.KR.getUser().getUserId());
        accountData.setBDUSS(this.KR.getUser().getBDUSS());
        accountData.setPortrait(this.KR.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.KR.jZ() != null) {
            accountData.setTbs(this.KR.jZ().getTbs());
        }
        this.KT = accountData;
        if (!TextUtils.isEmpty(this.KT.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(this.KT, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.KT.getID();
            sapiAccount.displayname = this.KT.getAccount();
            sapiAccount.bduss = this.KT.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            ob();
            return;
        }
        if (this.Ki == null) {
            this.Ki = new com.baidu.tbadk.coreExtra.view.r(this);
            this.Ki.a(new ag(this));
        }
        this.Ki.qc();
        this.Ki.setPhone(this.Kt.getText().toString());
        this.Ki.g(this.KT);
        this.Ki.pZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        this.Ks = false;
        on();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(String str) {
        if (this.KS != null) {
            this.KS.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.Kx.setImageDrawable(null);
        oo();
        this.KS = new ai(this, null);
        this.KS.setPriority(3);
        this.KS.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj() {
        this.Kr = true;
        this.KF.setVisibility(0);
        this.Kv.setText((CharSequence) null);
        if (this.Ks) {
            aw.h(this.KE, com.baidu.tieba.u.login_input_middle);
        } else {
            aw.h(this.KE, com.baidu.tieba.u.login_input_middlewrong);
        }
        oe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok() {
        this.Kr = false;
        this.KF.setVisibility(8);
        if (this.Ks) {
            this.KE.setBackgroundResource(com.baidu.tieba.u.login_input_under);
        } else {
            this.KE.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong);
        }
        oe();
    }

    private void ol() {
        this.Kt.setEnabled(false);
        this.Ku.setEnabled(false);
        this.Kv.setEnabled(false);
        this.KB.setEnabled(false);
        this.Kx.setEnabled(false);
        this.KG.setEnabled(false);
        this.KH.setEnabled(false);
        this.KI.setEnabled(false);
        this.KN.setEnabled(false);
        this.KO.setEnabled(false);
        this.Kt.setTextColor(Color.rgb(136, 136, 136));
        this.Ku.setTextColor(Color.rgb(136, 136, 136));
        this.Kv.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om() {
        this.Kt.setEnabled(true);
        this.Ku.setEnabled(true);
        this.Kv.setEnabled(true);
        this.KB.setEnabled(true);
        this.Kx.setEnabled(true);
        this.KG.setEnabled(true);
        this.KH.setEnabled(true);
        this.KI.setEnabled(true);
        this.KN.setEnabled(true);
        this.KO.setEnabled(true);
        this.Kt.setTextColor(-16777216);
        this.Ku.setTextColor(-16777216);
        this.Kv.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on() {
        if (this.Ks) {
            aw.h(this.KD, com.baidu.tieba.u.login_input_top);
            if (this.Kr) {
                aw.h(this.KE, com.baidu.tieba.u.login_input_middle);
            } else {
                aw.h(this.KE, com.baidu.tieba.u.login_input_under);
            }
            aw.h(this.KF, com.baidu.tieba.u.login_input_under);
            return;
        }
        aw.h(this.KD, com.baidu.tieba.u.login_input_topwrong);
        if (this.Kr) {
            aw.h(this.KE, com.baidu.tieba.u.login_input_middlewrong);
        } else {
            aw.h(this.KE, com.baidu.tieba.u.login_input_underwrong);
        }
        aw.h(this.KF, com.baidu.tieba.u.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo() {
        if (this.KQ != null) {
            this.KQ.cancel();
            this.KQ = null;
        }
        if (this.KS != null) {
            this.KS.cancel();
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
