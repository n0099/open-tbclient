package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SapiFastRegActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity<Login2Activity> {
    private ah PW;
    private ah PX;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String PY = null;
    private String mVcodeUrl = null;
    private int PZ = 0;
    private boolean Qa = true;
    private boolean Qb = false;
    private boolean Qc = false;
    private boolean Qd = true;
    private EditText Qe = null;
    private EditText Qf = null;
    private EditText Qg = null;
    private View Qh = null;
    private ImageView Qi = null;
    private ImageView Qj = null;
    private ImageView Qk = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar Ql = null;
    private Button Qm = null;
    private View Qn = null;
    private View Qo = null;
    private View Qp = null;
    private View Qq = null;
    private Button Qr = null;
    private Button Qs = null;
    private Button Qt = null;
    private TextView Qu = null;
    private TextView Qv = null;
    private TextView Qw = null;
    private TextView Qx = null;
    private Button Qy = null;
    private Button Qz = null;
    RelativeLayout QB = null;
    private aj QC = null;
    private com.baidu.tbadk.core.data.n QD = null;
    private ai QE = null;
    InputMethodManager mInputManager = null;
    com.baidu.tbadk.coreExtra.view.t PT = null;
    private AccountData QF = null;
    private String mInfo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_login_activity);
        this.mInfo = getIntent().getStringExtra(LoginActivityConfig.INFO);
        initUI();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(LoginActivityConfig.ACCOUNT);
        this.Qa = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.Qb = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.PZ = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.PZ = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.PZ = 1;
        }
        if (stringExtra != null) {
            this.Qe.setText(stringExtra);
        }
        this.Qe.requestFocus();
        if (this.Qa) {
            this.Qn.setVisibility(4);
        } else {
            this.Qn.setVisibility(0);
        }
        if (this.PZ == 0) {
            cy(com.baidu.tieba.w.normal_login);
        } else if (this.PZ == 1) {
            cy(com.baidu.tieba.w.mobile_login);
        }
        ShowSoftKeyPadDelay(this.Qe, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.PZ = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.PZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            rA();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.PT != null) {
            this.PT.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.PT == null || !this.PT.isShowing()) {
            ShowSoftKeyPadDelay(this.Qe, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Qa) {
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
                rn();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn() {
        int i = 1;
        TbadkCoreApplication.m255getInst().onUserChanged();
        if (this.Qb) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.QB = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.Qn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_regedit), new z(this));
        this.Qe = (EditText) findViewById(com.baidu.tieba.w.login_edit_account);
        this.Qf = (EditText) findViewById(com.baidu.tieba.w.login_edit_password);
        this.Qg = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Qo = findViewById(com.baidu.tieba.w.layout_account);
        this.Qp = findViewById(com.baidu.tieba.w.layout_password);
        this.Qq = findViewById(com.baidu.tieba.w.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.Qj = (ImageView) findViewById(com.baidu.tieba.w.image_vcode1);
        this.Qk = (ImageView) findViewById(com.baidu.tieba.w.image_vcode2);
        this.Qi = this.Qj;
        this.Ql = (ProgressBar) findViewById(com.baidu.tieba.w.progress_login);
        this.Qm = (Button) findViewById(com.baidu.tieba.w.button_vcode_refresh);
        this.Qr = (Button) findViewById(com.baidu.tieba.w.button_account_del);
        this.Qs = (Button) findViewById(com.baidu.tieba.w.button_pass_del);
        this.Qt = (Button) findViewById(com.baidu.tieba.w.button_vcode_del);
        this.Qu = (TextView) findViewById(com.baidu.tieba.w.text_title_account);
        this.Qv = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.Qw = (TextView) findViewById(com.baidu.tieba.w.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.Qw.setText(this.mInfo);
            this.Qw.setVisibility(0);
        }
        this.Qx = (TextView) findViewById(com.baidu.tieba.w.text_login);
        this.Qy = (Button) findViewById(com.baidu.tieba.w.normal_login);
        this.Qz = (Button) findViewById(com.baidu.tieba.w.mobile_login);
        aa aaVar = new aa(this);
        this.Qe.setOnFocusChangeListener(aaVar);
        this.Qf.setOnFocusChangeListener(aaVar);
        this.Qg.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.Qf.setOnEditorActionListener(abVar);
        this.Qg.setOnEditorActionListener(abVar);
        this.Qe.addTextChangedListener(new ac(this));
        this.Qf.addTextChangedListener(new ad(this));
        this.Qg.addTextChangedListener(new ae(this));
        this.Qh = findViewById(com.baidu.tieba.w.layout_login);
        this.Qh.setEnabled(false);
        this.Qh.setOnClickListener(new af(this));
        rw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bc.b(this.Qx, i);
        bc.g(this.QB, i);
        if (i == 1) {
            this.Qw.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
        } else {
            this.Qw.setTextColor(-13279809);
        }
        rz();
        rp();
    }

    private void rp() {
        if (this.PZ == 0) {
            if (this.mSkinType == 1) {
                this.Qy.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.Qz.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.Qy.setTextColor(Color.rgb(50, 137, 203));
                this.Qz.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bc.i((View) this.Qy, com.baidu.tieba.v.login_tab_pressed);
            bc.i((View) this.Qz, com.baidu.tieba.v.login_tab_normal);
        } else if (this.PZ == 1) {
            if (this.mSkinType == 1) {
                this.Qz.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.Qy.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.Qz.setTextColor(Color.rgb(50, 137, 203));
                this.Qy.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bc.i((View) this.Qz, com.baidu.tieba.v.login_tab_pressed);
            bc.i((View) this.Qy, com.baidu.tieba.v.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        boolean z;
        String editable = this.Qe.getText().toString();
        String editable2 = this.Qf.getText().toString();
        String editable3 = this.Qg.getText().toString();
        if (this.Qq.getVisibility() == 8) {
            z = bf.isEmpty(editable) || bf.isEmpty(editable2);
        } else {
            z = bf.isEmpty(editable) || bf.isEmpty(editable2) || bf.isEmpty(editable3);
        }
        if (!z) {
            this.Qh.setEnabled(true);
        } else {
            this.Qh.setEnabled(false);
        }
    }

    private void cy(int i) {
        if (i == com.baidu.tieba.w.normal_login) {
            this.Qi = this.Qj;
            this.Qj.setVisibility(0);
            this.Qk.setVisibility(8);
            rs();
            this.PZ = 0;
            rr();
            this.Qe.setHint(com.baidu.tieba.z.account_hint_normal);
            this.Qu.setText(com.baidu.tieba.z.account_account);
            this.Qe.requestFocus();
            this.Qe.setInputType(1);
            rp();
        } else if (i == com.baidu.tieba.w.mobile_login) {
            this.Qi = this.Qk;
            this.Qj.setVisibility(8);
            this.Qk.setVisibility(0);
            rs();
            this.PZ = 1;
            rr();
            this.Qe.setHint(com.baidu.tieba.z.account_mobile);
            this.Qu.setText(com.baidu.tieba.z.account_mobile);
            this.Qe.requestFocus();
            this.Qe.setInputType(3);
            rp();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.w.normal_login || id == com.baidu.tieba.w.mobile_login) {
            cy(view.getId());
        } else if (id == com.baidu.tieba.w.button_account_del) {
            this.Qe.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_pass_del) {
            this.Qf.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_del) {
            this.Qg.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_refresh || id == com.baidu.tieba.w.image_vcode1 || id == com.baidu.tieba.w.image_vcode2) {
            de(this.mVcodeUrl);
        }
    }

    private void rr() {
        if (this.PZ == 0) {
            if (this.PW == null) {
                this.mAccount = null;
                this.Qe.setText((CharSequence) null);
                this.Qf.setText((CharSequence) null);
                this.Qg.setText((CharSequence) null);
                this.Qq.setVisibility(8);
                this.Qv.setVisibility(4);
                this.Qd = true;
                this.Qc = false;
            } else {
                this.mAccount = this.PW.mAccount;
                this.Qe.setText(this.PW.mAccount);
                this.Qf.setText(this.PW.mPassword);
                this.Qg.setText(this.PW.mVcode);
                this.Qv.setText(this.PW.Gp);
                this.Qq.setVisibility(this.PW.QH);
                this.Qv.setVisibility(this.PW.QI);
                this.Qd = this.PW.Qd;
                this.Qc = this.PW.QH == 0;
            }
        }
        if (this.PZ == 1) {
            if (this.PX == null) {
                this.mAccount = null;
                this.Qe.setText((CharSequence) null);
                this.Qf.setText((CharSequence) null);
                this.Qg.setText((CharSequence) null);
                this.Qq.setVisibility(8);
                this.Qv.setVisibility(4);
                this.Qd = true;
                this.Qc = false;
            } else {
                this.mAccount = this.PX.mAccount;
                this.Qe.setText(this.PX.mAccount);
                this.Qf.setText(this.PX.mPassword);
                this.Qg.setText(this.PX.mVcode);
                this.Qv.setText(this.PX.Gp);
                this.Qq.setVisibility(this.PX.QH);
                this.Qv.setVisibility(this.PX.QI);
                this.Qd = this.PX.Qd;
                this.Qc = this.PX.QH == 0;
            }
        }
        rz();
        rq();
    }

    private void rs() {
        if (this.PZ == 0) {
            this.PW = new ah(this, null);
            this.PW.mAccount = this.Qe.getText().toString();
            this.PW.mPassword = this.Qf.getText().toString();
            this.PW.mVcode = this.Qg.getText().toString();
            this.PW.Gp = this.Qv.getText().toString();
            this.PW.QH = this.Qq.getVisibility();
            this.PW.QI = this.Qv.getVisibility();
            this.PW.Qd = this.Qd;
        }
        if (this.PZ == 1) {
            this.PX = new ah(this, null);
            this.PX.mAccount = this.Qe.getText().toString();
            this.PX.mPassword = this.Qf.getText().toString();
            this.PX.mVcode = this.Qg.getText().toString();
            this.PX.Gp = this.Qv.getText().toString();
            this.PX.QH = this.Qq.getVisibility();
            this.PX.QI = this.Qv.getVisibility();
            this.PX.Qd = this.Qd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt() {
        if (this.QC == null) {
            String editable = this.Qe.getText().toString();
            this.mPassword = bf.base64Encode(this.Qf.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.Qc || !bf.isEmpty(this.Qg.getText().toString())) {
                    rx();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.PZ)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId()));
                    if (this.Qq != null && this.Qq.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.Qg.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.PY));
                    }
                    rA();
                    this.QC = new aj(this, sb.toString(), arrayList);
                    this.QC.setPriority(3);
                    this.QC.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.QD.getUser().getUserName());
        if (this.QD.getUser().getPassword() != null) {
            accountData.setPassword(this.QD.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.QD.getUser().getUserId());
        accountData.setBDUSS(this.QD.getUser().getBDUSS());
        accountData.setPortrait(this.QD.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.QD.mR() != null) {
            accountData.setTbs(this.QD.mR().getTbs());
        }
        this.QF = accountData;
        if (!TextUtils.isEmpty(this.QF.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(this.QF, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.QF.getID();
            sapiAccount.displayname = this.QF.getAccount();
            sapiAccount.bduss = this.QF.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            rn();
            return;
        }
        if (this.PT == null) {
            this.PT = new com.baidu.tbadk.coreExtra.view.t(this);
            this.PT.a(new ag(this));
        }
        this.PT.tM();
        this.PT.setPhone(this.Qe.getText().toString());
        this.PT.g(this.QF);
        this.PT.tJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        this.Qd = false;
        rz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str) {
        if (this.QE != null) {
            this.QE.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.Qi.setImageDrawable(null);
        rA();
        this.QE = new ai(this, null);
        this.QE.setPriority(3);
        this.QE.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        this.Qc = true;
        this.Qq.setVisibility(0);
        this.Qg.setText((CharSequence) null);
        if (this.Qd) {
            bc.i(this.Qp, com.baidu.tieba.v.login_input_middle);
        } else {
            bc.i(this.Qp, com.baidu.tieba.v.login_input_middlewrong);
        }
        rq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw() {
        this.Qc = false;
        this.Qq.setVisibility(8);
        if (this.Qd) {
            this.Qp.setBackgroundResource(com.baidu.tieba.v.login_input_under);
        } else {
            this.Qp.setBackgroundResource(com.baidu.tieba.v.login_input_underwrong);
        }
        rq();
    }

    private void rx() {
        this.Qe.setEnabled(false);
        this.Qf.setEnabled(false);
        this.Qg.setEnabled(false);
        this.Qm.setEnabled(false);
        this.Qi.setEnabled(false);
        this.Qr.setEnabled(false);
        this.Qs.setEnabled(false);
        this.Qt.setEnabled(false);
        this.Qy.setEnabled(false);
        this.Qz.setEnabled(false);
        this.Qe.setTextColor(Color.rgb(136, 136, 136));
        this.Qf.setTextColor(Color.rgb(136, 136, 136));
        this.Qg.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        this.Qe.setEnabled(true);
        this.Qf.setEnabled(true);
        this.Qg.setEnabled(true);
        this.Qm.setEnabled(true);
        this.Qi.setEnabled(true);
        this.Qr.setEnabled(true);
        this.Qs.setEnabled(true);
        this.Qt.setEnabled(true);
        this.Qy.setEnabled(true);
        this.Qz.setEnabled(true);
        this.Qe.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.Qf.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.Qg.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz() {
        if (this.Qd) {
            bc.i(this.Qo, com.baidu.tieba.v.login_input_top);
            if (this.Qc) {
                bc.i(this.Qp, com.baidu.tieba.v.login_input_middle);
            } else {
                bc.i(this.Qp, com.baidu.tieba.v.login_input_under);
            }
            bc.i(this.Qq, com.baidu.tieba.v.login_input_under);
            return;
        }
        bc.i(this.Qo, com.baidu.tieba.v.login_input_topwrong);
        if (this.Qc) {
            bc.i(this.Qp, com.baidu.tieba.v.login_input_middlewrong);
        } else {
            bc.i(this.Qp, com.baidu.tieba.v.login_input_underwrong);
        }
        bc.i(this.Qq, com.baidu.tieba.v.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (this.QC != null) {
            this.QC.cancel();
            this.QC = null;
        }
        if (this.QE != null) {
            this.QE.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rB() {
        rA();
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(getPageContext().getPageActivity());
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
