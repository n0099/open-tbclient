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
    private ah PT;
    private ah PU;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String PV = null;
    private String mVcodeUrl = null;
    private int PW = 0;
    private boolean PX = true;
    private boolean PY = false;
    private boolean PZ = false;
    private boolean Qa = true;
    private EditText Qb = null;
    private EditText Qc = null;
    private EditText Qd = null;
    private View Qe = null;
    private ImageView Qf = null;
    private ImageView Qg = null;
    private ImageView Qh = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar Qi = null;
    private Button Qj = null;
    private View Qk = null;
    private View Ql = null;
    private View Qm = null;
    private View Qn = null;
    private Button Qo = null;
    private Button Qp = null;
    private Button Qq = null;
    private TextView Qr = null;
    private TextView Qs = null;
    private TextView Qt = null;
    private TextView Qu = null;
    private Button Qv = null;
    private Button Qw = null;
    RelativeLayout Qx = null;
    private aj Qy = null;
    private com.baidu.tbadk.core.data.n Qz = null;
    private ai QB = null;
    InputMethodManager mInputManager = null;
    com.baidu.tbadk.coreExtra.view.t PP = null;
    private AccountData QC = null;
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
        this.PX = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.PY = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.PW = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.PW = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.PW = 1;
        }
        if (stringExtra != null) {
            this.Qb.setText(stringExtra);
        }
        this.Qb.requestFocus();
        if (this.PX) {
            this.Qk.setVisibility(4);
        } else {
            this.Qk.setVisibility(0);
        }
        if (this.PW == 0) {
            cy(com.baidu.tieba.w.normal_login);
        } else if (this.PW == 1) {
            cy(com.baidu.tieba.w.mobile_login);
        }
        ShowSoftKeyPadDelay(this.Qb, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.PW = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.PW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            ru();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.PP != null) {
            this.PP.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.PP == null || !this.PP.isShowing()) {
            ShowSoftKeyPadDelay(this.Qb, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.PX) {
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
                rh();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        int i = 1;
        TbadkCoreApplication.m255getInst().onUserChanged();
        if (this.PY) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.Qx = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.Qk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_regedit), new z(this));
        this.Qb = (EditText) findViewById(com.baidu.tieba.w.login_edit_account);
        this.Qc = (EditText) findViewById(com.baidu.tieba.w.login_edit_password);
        this.Qd = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Ql = findViewById(com.baidu.tieba.w.layout_account);
        this.Qm = findViewById(com.baidu.tieba.w.layout_password);
        this.Qn = findViewById(com.baidu.tieba.w.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.Qg = (ImageView) findViewById(com.baidu.tieba.w.image_vcode1);
        this.Qh = (ImageView) findViewById(com.baidu.tieba.w.image_vcode2);
        this.Qf = this.Qg;
        this.Qi = (ProgressBar) findViewById(com.baidu.tieba.w.progress_login);
        this.Qj = (Button) findViewById(com.baidu.tieba.w.button_vcode_refresh);
        this.Qo = (Button) findViewById(com.baidu.tieba.w.button_account_del);
        this.Qp = (Button) findViewById(com.baidu.tieba.w.button_pass_del);
        this.Qq = (Button) findViewById(com.baidu.tieba.w.button_vcode_del);
        this.Qr = (TextView) findViewById(com.baidu.tieba.w.text_title_account);
        this.Qs = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.Qt = (TextView) findViewById(com.baidu.tieba.w.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.Qt.setText(this.mInfo);
            this.Qt.setVisibility(0);
        }
        this.Qu = (TextView) findViewById(com.baidu.tieba.w.text_login);
        this.Qv = (Button) findViewById(com.baidu.tieba.w.normal_login);
        this.Qw = (Button) findViewById(com.baidu.tieba.w.mobile_login);
        aa aaVar = new aa(this);
        this.Qb.setOnFocusChangeListener(aaVar);
        this.Qc.setOnFocusChangeListener(aaVar);
        this.Qd.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.Qc.setOnEditorActionListener(abVar);
        this.Qd.setOnEditorActionListener(abVar);
        this.Qb.addTextChangedListener(new ac(this));
        this.Qc.addTextChangedListener(new ad(this));
        this.Qd.addTextChangedListener(new ae(this));
        this.Qe = findViewById(com.baidu.tieba.w.layout_login);
        this.Qe.setEnabled(false);
        this.Qe.setOnClickListener(new af(this));
        rq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bc.b(this.Qu, i);
        bc.g(this.Qx, i);
        if (i == 1) {
            this.Qt.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
        } else {
            this.Qt.setTextColor(-13279809);
        }
        rt();
        rj();
    }

    private void rj() {
        if (this.PW == 0) {
            if (this.mSkinType == 1) {
                this.Qv.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.Qw.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.Qv.setTextColor(Color.rgb(50, 137, 203));
                this.Qw.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bc.i((View) this.Qv, com.baidu.tieba.v.login_tab_pressed);
            bc.i((View) this.Qw, com.baidu.tieba.v.login_tab_normal);
        } else if (this.PW == 1) {
            if (this.mSkinType == 1) {
                this.Qw.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.Qv.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.Qw.setTextColor(Color.rgb(50, 137, 203));
                this.Qv.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bc.i((View) this.Qw, com.baidu.tieba.v.login_tab_pressed);
            bc.i((View) this.Qv, com.baidu.tieba.v.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        boolean z;
        String editable = this.Qb.getText().toString();
        String editable2 = this.Qc.getText().toString();
        String editable3 = this.Qd.getText().toString();
        if (this.Qn.getVisibility() == 8) {
            z = bf.isEmpty(editable) || bf.isEmpty(editable2);
        } else {
            z = bf.isEmpty(editable) || bf.isEmpty(editable2) || bf.isEmpty(editable3);
        }
        if (!z) {
            this.Qe.setEnabled(true);
        } else {
            this.Qe.setEnabled(false);
        }
    }

    private void cy(int i) {
        if (i == com.baidu.tieba.w.normal_login) {
            this.Qf = this.Qg;
            this.Qg.setVisibility(0);
            this.Qh.setVisibility(8);
            rm();
            this.PW = 0;
            rl();
            this.Qb.setHint(com.baidu.tieba.z.account_hint_normal);
            this.Qr.setText(com.baidu.tieba.z.account_account);
            this.Qb.requestFocus();
            this.Qb.setInputType(1);
            rj();
        } else if (i == com.baidu.tieba.w.mobile_login) {
            this.Qf = this.Qh;
            this.Qg.setVisibility(8);
            this.Qh.setVisibility(0);
            rm();
            this.PW = 1;
            rl();
            this.Qb.setHint(com.baidu.tieba.z.account_mobile);
            this.Qr.setText(com.baidu.tieba.z.account_mobile);
            this.Qb.requestFocus();
            this.Qb.setInputType(3);
            rj();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.w.normal_login || id == com.baidu.tieba.w.mobile_login) {
            cy(view.getId());
        } else if (id == com.baidu.tieba.w.button_account_del) {
            this.Qb.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_pass_del) {
            this.Qc.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_del) {
            this.Qd.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_refresh || id == com.baidu.tieba.w.image_vcode1 || id == com.baidu.tieba.w.image_vcode2) {
            db(this.mVcodeUrl);
        }
    }

    private void rl() {
        if (this.PW == 0) {
            if (this.PT == null) {
                this.mAccount = null;
                this.Qb.setText((CharSequence) null);
                this.Qc.setText((CharSequence) null);
                this.Qd.setText((CharSequence) null);
                this.Qn.setVisibility(8);
                this.Qs.setVisibility(4);
                this.Qa = true;
                this.PZ = false;
            } else {
                this.mAccount = this.PT.mAccount;
                this.Qb.setText(this.PT.mAccount);
                this.Qc.setText(this.PT.mPassword);
                this.Qd.setText(this.PT.mVcode);
                this.Qs.setText(this.PT.Gm);
                this.Qn.setVisibility(this.PT.QE);
                this.Qs.setVisibility(this.PT.QF);
                this.Qa = this.PT.Qa;
                this.PZ = this.PT.QE == 0;
            }
        }
        if (this.PW == 1) {
            if (this.PU == null) {
                this.mAccount = null;
                this.Qb.setText((CharSequence) null);
                this.Qc.setText((CharSequence) null);
                this.Qd.setText((CharSequence) null);
                this.Qn.setVisibility(8);
                this.Qs.setVisibility(4);
                this.Qa = true;
                this.PZ = false;
            } else {
                this.mAccount = this.PU.mAccount;
                this.Qb.setText(this.PU.mAccount);
                this.Qc.setText(this.PU.mPassword);
                this.Qd.setText(this.PU.mVcode);
                this.Qs.setText(this.PU.Gm);
                this.Qn.setVisibility(this.PU.QE);
                this.Qs.setVisibility(this.PU.QF);
                this.Qa = this.PU.Qa;
                this.PZ = this.PU.QE == 0;
            }
        }
        rt();
        rk();
    }

    private void rm() {
        if (this.PW == 0) {
            this.PT = new ah(this, null);
            this.PT.mAccount = this.Qb.getText().toString();
            this.PT.mPassword = this.Qc.getText().toString();
            this.PT.mVcode = this.Qd.getText().toString();
            this.PT.Gm = this.Qs.getText().toString();
            this.PT.QE = this.Qn.getVisibility();
            this.PT.QF = this.Qs.getVisibility();
            this.PT.Qa = this.Qa;
        }
        if (this.PW == 1) {
            this.PU = new ah(this, null);
            this.PU.mAccount = this.Qb.getText().toString();
            this.PU.mPassword = this.Qc.getText().toString();
            this.PU.mVcode = this.Qd.getText().toString();
            this.PU.Gm = this.Qs.getText().toString();
            this.PU.QE = this.Qn.getVisibility();
            this.PU.QF = this.Qs.getVisibility();
            this.PU.Qa = this.Qa;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn() {
        if (this.Qy == null) {
            String editable = this.Qb.getText().toString();
            this.mPassword = bf.base64Encode(this.Qc.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.PZ || !bf.isEmpty(this.Qd.getText().toString())) {
                    rr();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.PW)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId()));
                    if (this.Qn != null && this.Qn.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.Qd.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.PV));
                    }
                    ru();
                    this.Qy = new aj(this, sb.toString(), arrayList);
                    this.Qy.setPriority(3);
                    this.Qy.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.Qz.getUser().getUserName());
        if (this.Qz.getUser().getPassword() != null) {
            accountData.setPassword(this.Qz.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.Qz.getUser().getUserId());
        accountData.setBDUSS(this.Qz.getUser().getBDUSS());
        accountData.setPortrait(this.Qz.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.Qz.mK() != null) {
            accountData.setTbs(this.Qz.mK().getTbs());
        }
        this.QC = accountData;
        if (!TextUtils.isEmpty(this.QC.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(this.QC, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.QC.getID();
            sapiAccount.displayname = this.QC.getAccount();
            sapiAccount.bduss = this.QC.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            rh();
            return;
        }
        if (this.PP == null) {
            this.PP = new com.baidu.tbadk.coreExtra.view.t(this);
            this.PP.a(new ag(this));
        }
        this.PP.tG();
        this.PP.setPhone(this.Qb.getText().toString());
        this.PP.g(this.QC);
        this.PP.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro() {
        this.Qa = false;
        rt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(String str) {
        if (this.QB != null) {
            this.QB.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.Qf.setImageDrawable(null);
        ru();
        this.QB = new ai(this, null);
        this.QB.setPriority(3);
        this.QB.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        this.PZ = true;
        this.Qn.setVisibility(0);
        this.Qd.setText((CharSequence) null);
        if (this.Qa) {
            bc.i(this.Qm, com.baidu.tieba.v.login_input_middle);
        } else {
            bc.i(this.Qm, com.baidu.tieba.v.login_input_middlewrong);
        }
        rk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        this.PZ = false;
        this.Qn.setVisibility(8);
        if (this.Qa) {
            this.Qm.setBackgroundResource(com.baidu.tieba.v.login_input_under);
        } else {
            this.Qm.setBackgroundResource(com.baidu.tieba.v.login_input_underwrong);
        }
        rk();
    }

    private void rr() {
        this.Qb.setEnabled(false);
        this.Qc.setEnabled(false);
        this.Qd.setEnabled(false);
        this.Qj.setEnabled(false);
        this.Qf.setEnabled(false);
        this.Qo.setEnabled(false);
        this.Qp.setEnabled(false);
        this.Qq.setEnabled(false);
        this.Qv.setEnabled(false);
        this.Qw.setEnabled(false);
        this.Qb.setTextColor(Color.rgb(136, 136, 136));
        this.Qc.setTextColor(Color.rgb(136, 136, 136));
        this.Qd.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs() {
        this.Qb.setEnabled(true);
        this.Qc.setEnabled(true);
        this.Qd.setEnabled(true);
        this.Qj.setEnabled(true);
        this.Qf.setEnabled(true);
        this.Qo.setEnabled(true);
        this.Qp.setEnabled(true);
        this.Qq.setEnabled(true);
        this.Qv.setEnabled(true);
        this.Qw.setEnabled(true);
        this.Qb.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.Qc.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.Qd.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt() {
        if (this.Qa) {
            bc.i(this.Ql, com.baidu.tieba.v.login_input_top);
            if (this.PZ) {
                bc.i(this.Qm, com.baidu.tieba.v.login_input_middle);
            } else {
                bc.i(this.Qm, com.baidu.tieba.v.login_input_under);
            }
            bc.i(this.Qn, com.baidu.tieba.v.login_input_under);
            return;
        }
        bc.i(this.Ql, com.baidu.tieba.v.login_input_topwrong);
        if (this.PZ) {
            bc.i(this.Qm, com.baidu.tieba.v.login_input_middlewrong);
        } else {
            bc.i(this.Qm, com.baidu.tieba.v.login_input_underwrong);
        }
        bc.i(this.Qn, com.baidu.tieba.v.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        if (this.Qy != null) {
            this.Qy.cancel();
            this.Qy = null;
        }
        if (this.QB != null) {
            this.QB.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        ru();
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(getPageContext().getPageActivity());
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
