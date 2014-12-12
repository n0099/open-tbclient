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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity<Login2Activity> {
    private ah Pt;
    private ah Pu;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String Pv = null;
    private String mVcodeUrl = null;
    private int Pw = 0;
    private boolean Px = true;
    private boolean Py = false;
    private boolean Pz = false;
    private boolean PA = true;
    private EditText PC = null;
    private EditText PD = null;
    private EditText PE = null;
    private View PF = null;
    private ImageView PG = null;
    private ImageView PH = null;
    private ImageView PJ = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar PK = null;
    private Button PL = null;
    private View PM = null;
    private View PN = null;
    private View PO = null;
    private View PP = null;
    private Button PQ = null;
    private Button PR = null;
    private Button PT = null;
    private TextView PU = null;
    private TextView PV = null;
    private TextView PW = null;
    private TextView PX = null;
    private Button PY = null;
    private Button PZ = null;
    RelativeLayout Qa = null;
    private aj Qb = null;
    private com.baidu.tbadk.core.data.m Qc = null;
    private ai Qd = null;
    InputMethodManager mInputManager = null;
    com.baidu.tbadk.coreExtra.view.t Pq = null;
    private AccountData Qe = null;
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
        this.Px = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.Py = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.Pw = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.Pw = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.Pw = 1;
        }
        if (stringExtra != null) {
            this.PC.setText(stringExtra);
        }
        this.PC.requestFocus();
        if (this.Px) {
            this.PM.setVisibility(4);
        } else {
            this.PM.setVisibility(0);
        }
        if (this.Pw == 0) {
            cr(com.baidu.tieba.w.normal_login);
        } else if (this.Pw == 1) {
            cr(com.baidu.tieba.w.mobile_login);
        }
        ShowSoftKeyPadDelay(this.PC, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.Pw = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.Pw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            rp();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.Pq != null) {
            this.Pq.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.Pq == null || !this.Pq.isShowing()) {
            ShowSoftKeyPadDelay(this.PC, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Px) {
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
                rc();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc() {
        int i = 1;
        TbadkCoreApplication.m255getInst().onUserChanged();
        if (this.Py) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.og().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.og().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.Qa = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.PM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_regedit), new z(this));
        this.PC = (EditText) findViewById(com.baidu.tieba.w.login_edit_account);
        this.PD = (EditText) findViewById(com.baidu.tieba.w.login_edit_password);
        this.PE = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.PN = findViewById(com.baidu.tieba.w.layout_account);
        this.PO = findViewById(com.baidu.tieba.w.layout_password);
        this.PP = findViewById(com.baidu.tieba.w.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.PH = (ImageView) findViewById(com.baidu.tieba.w.image_vcode1);
        this.PJ = (ImageView) findViewById(com.baidu.tieba.w.image_vcode2);
        this.PG = this.PH;
        this.PK = (ProgressBar) findViewById(com.baidu.tieba.w.progress_login);
        this.PL = (Button) findViewById(com.baidu.tieba.w.button_vcode_refresh);
        this.PQ = (Button) findViewById(com.baidu.tieba.w.button_account_del);
        this.PR = (Button) findViewById(com.baidu.tieba.w.button_pass_del);
        this.PT = (Button) findViewById(com.baidu.tieba.w.button_vcode_del);
        this.PU = (TextView) findViewById(com.baidu.tieba.w.text_title_account);
        this.PV = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.PW = (TextView) findViewById(com.baidu.tieba.w.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.PW.setText(this.mInfo);
            this.PW.setVisibility(0);
        }
        this.PX = (TextView) findViewById(com.baidu.tieba.w.text_login);
        this.PY = (Button) findViewById(com.baidu.tieba.w.normal_login);
        this.PZ = (Button) findViewById(com.baidu.tieba.w.mobile_login);
        aa aaVar = new aa(this);
        this.PC.setOnFocusChangeListener(aaVar);
        this.PD.setOnFocusChangeListener(aaVar);
        this.PE.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.PD.setOnEditorActionListener(abVar);
        this.PE.setOnEditorActionListener(abVar);
        this.PC.addTextChangedListener(new ac(this));
        this.PD.addTextChangedListener(new ad(this));
        this.PE.addTextChangedListener(new ae(this));
        this.PF = findViewById(com.baidu.tieba.w.layout_login);
        this.PF.setEnabled(false);
        this.PF.setOnClickListener(new af(this));
        rl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ax.b(this.PX, i);
        ax.g(this.Qa, i);
        if (i == 1) {
            this.PW.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
        } else {
            this.PW.setTextColor(-13279809);
        }
        ro();
        re();
    }

    private void re() {
        if (this.Pw == 0) {
            if (this.mSkinType == 1) {
                this.PY.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.PZ.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.PY.setTextColor(Color.rgb(50, 137, 203));
                this.PZ.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ax.i((View) this.PY, com.baidu.tieba.v.login_tab_pressed);
            ax.i((View) this.PZ, com.baidu.tieba.v.login_tab_normal);
        } else if (this.Pw == 1) {
            if (this.mSkinType == 1) {
                this.PZ.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
                this.PY.setTextColor(getResources().getColor(com.baidu.tieba.t.skin_1_tab_unsel_color));
            } else {
                this.PZ.setTextColor(Color.rgb(50, 137, 203));
                this.PY.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ax.i((View) this.PZ, com.baidu.tieba.v.login_tab_pressed);
            ax.i((View) this.PY, com.baidu.tieba.v.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf() {
        boolean z;
        String editable = this.PC.getText().toString();
        String editable2 = this.PD.getText().toString();
        String editable3 = this.PE.getText().toString();
        if (this.PP.getVisibility() == 8) {
            z = ba.isEmpty(editable) || ba.isEmpty(editable2);
        } else {
            z = ba.isEmpty(editable) || ba.isEmpty(editable2) || ba.isEmpty(editable3);
        }
        if (!z) {
            this.PF.setEnabled(true);
        } else {
            this.PF.setEnabled(false);
        }
    }

    private void cr(int i) {
        if (i == com.baidu.tieba.w.normal_login) {
            this.PG = this.PH;
            this.PH.setVisibility(0);
            this.PJ.setVisibility(8);
            rh();
            this.Pw = 0;
            rg();
            this.PC.setHint(com.baidu.tieba.z.account_hint_normal);
            this.PU.setText(com.baidu.tieba.z.account_account);
            this.PC.requestFocus();
            this.PC.setInputType(1);
            re();
        } else if (i == com.baidu.tieba.w.mobile_login) {
            this.PG = this.PJ;
            this.PH.setVisibility(8);
            this.PJ.setVisibility(0);
            rh();
            this.Pw = 1;
            rg();
            this.PC.setHint(com.baidu.tieba.z.account_mobile);
            this.PU.setText(com.baidu.tieba.z.account_mobile);
            this.PC.requestFocus();
            this.PC.setInputType(3);
            re();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.w.normal_login || id == com.baidu.tieba.w.mobile_login) {
            cr(view.getId());
        } else if (id == com.baidu.tieba.w.button_account_del) {
            this.PC.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_pass_del) {
            this.PD.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_del) {
            this.PE.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.w.button_vcode_refresh || id == com.baidu.tieba.w.image_vcode1 || id == com.baidu.tieba.w.image_vcode2) {
            df(this.mVcodeUrl);
        }
    }

    private void rg() {
        if (this.Pw == 0) {
            if (this.Pt == null) {
                this.mAccount = null;
                this.PC.setText((CharSequence) null);
                this.PD.setText((CharSequence) null);
                this.PE.setText((CharSequence) null);
                this.PP.setVisibility(8);
                this.PV.setVisibility(4);
                this.PA = true;
                this.Pz = false;
            } else {
                this.mAccount = this.Pt.mAccount;
                this.PC.setText(this.Pt.mAccount);
                this.PD.setText(this.Pt.mPassword);
                this.PE.setText(this.Pt.mVcode);
                this.PV.setText(this.Pt.Gm);
                this.PP.setVisibility(this.Pt.Qg);
                this.PV.setVisibility(this.Pt.Qh);
                this.PA = this.Pt.PA;
                this.Pz = this.Pt.Qg == 0;
            }
        }
        if (this.Pw == 1) {
            if (this.Pu == null) {
                this.mAccount = null;
                this.PC.setText((CharSequence) null);
                this.PD.setText((CharSequence) null);
                this.PE.setText((CharSequence) null);
                this.PP.setVisibility(8);
                this.PV.setVisibility(4);
                this.PA = true;
                this.Pz = false;
            } else {
                this.mAccount = this.Pu.mAccount;
                this.PC.setText(this.Pu.mAccount);
                this.PD.setText(this.Pu.mPassword);
                this.PE.setText(this.Pu.mVcode);
                this.PV.setText(this.Pu.Gm);
                this.PP.setVisibility(this.Pu.Qg);
                this.PV.setVisibility(this.Pu.Qh);
                this.PA = this.Pu.PA;
                this.Pz = this.Pu.Qg == 0;
            }
        }
        ro();
        rf();
    }

    private void rh() {
        if (this.Pw == 0) {
            this.Pt = new ah(this, null);
            this.Pt.mAccount = this.PC.getText().toString();
            this.Pt.mPassword = this.PD.getText().toString();
            this.Pt.mVcode = this.PE.getText().toString();
            this.Pt.Gm = this.PV.getText().toString();
            this.Pt.Qg = this.PP.getVisibility();
            this.Pt.Qh = this.PV.getVisibility();
            this.Pt.PA = this.PA;
        }
        if (this.Pw == 1) {
            this.Pu = new ah(this, null);
            this.Pu.mAccount = this.PC.getText().toString();
            this.Pu.mPassword = this.PD.getText().toString();
            this.Pu.mVcode = this.PE.getText().toString();
            this.Pu.Gm = this.PV.getText().toString();
            this.Pu.Qg = this.PP.getVisibility();
            this.Pu.Qh = this.PV.getVisibility();
            this.Pu.PA = this.PA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        if (this.Qb == null) {
            String editable = this.PC.getText().toString();
            this.mPassword = ba.base64Encode(this.PD.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.Pz || !ba.isEmpty(this.PE.getText().toString())) {
                    rm();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.Pw)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m255getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m255getInst().getPushChannelUserId()));
                    if (this.PP != null && this.PP.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.PE.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.Pv));
                    }
                    rp();
                    this.Qb = new aj(this, sb.toString(), arrayList);
                    this.Qb.setPriority(3);
                    this.Qb.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.Qc.getUser().getUserName());
        if (this.Qc.getUser().getPassword() != null) {
            accountData.setPassword(this.Qc.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.Qc.getUser().getUserId());
        accountData.setBDUSS(this.Qc.getUser().getBDUSS());
        accountData.setPortrait(this.Qc.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.Qc.mP() != null) {
            accountData.setTbs(this.Qc.mP().getTbs());
        }
        this.Qe = accountData;
        if (!TextUtils.isEmpty(this.Qe.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(this.Qe, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.Qe.getID();
            sapiAccount.displayname = this.Qe.getAccount();
            sapiAccount.bduss = this.Qe.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            rc();
            return;
        }
        if (this.Pq == null) {
            this.Pq = new com.baidu.tbadk.coreExtra.view.t(this);
            this.Pq.a(new ag(this));
        }
        this.Pq.tv();
        this.Pq.setPhone(this.PC.getText().toString());
        this.Pq.g(this.Qe);
        this.Pq.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj() {
        this.PA = false;
        ro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(String str) {
        if (this.Qd != null) {
            this.Qd.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.PG.setImageDrawable(null);
        rp();
        this.Qd = new ai(this, null);
        this.Qd.setPriority(3);
        this.Qd.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        this.Pz = true;
        this.PP.setVisibility(0);
        this.PE.setText((CharSequence) null);
        if (this.PA) {
            ax.i(this.PO, com.baidu.tieba.v.login_input_middle);
        } else {
            ax.i(this.PO, com.baidu.tieba.v.login_input_middlewrong);
        }
        rf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl() {
        this.Pz = false;
        this.PP.setVisibility(8);
        if (this.PA) {
            this.PO.setBackgroundResource(com.baidu.tieba.v.login_input_under);
        } else {
            this.PO.setBackgroundResource(com.baidu.tieba.v.login_input_underwrong);
        }
        rf();
    }

    private void rm() {
        this.PC.setEnabled(false);
        this.PD.setEnabled(false);
        this.PE.setEnabled(false);
        this.PL.setEnabled(false);
        this.PG.setEnabled(false);
        this.PQ.setEnabled(false);
        this.PR.setEnabled(false);
        this.PT.setEnabled(false);
        this.PY.setEnabled(false);
        this.PZ.setEnabled(false);
        this.PC.setTextColor(Color.rgb(136, 136, 136));
        this.PD.setTextColor(Color.rgb(136, 136, 136));
        this.PE.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn() {
        this.PC.setEnabled(true);
        this.PD.setEnabled(true);
        this.PE.setEnabled(true);
        this.PL.setEnabled(true);
        this.PG.setEnabled(true);
        this.PQ.setEnabled(true);
        this.PR.setEnabled(true);
        this.PT.setEnabled(true);
        this.PY.setEnabled(true);
        this.PZ.setEnabled(true);
        this.PC.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.PD.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.PE.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro() {
        if (this.PA) {
            ax.i(this.PN, com.baidu.tieba.v.login_input_top);
            if (this.Pz) {
                ax.i(this.PO, com.baidu.tieba.v.login_input_middle);
            } else {
                ax.i(this.PO, com.baidu.tieba.v.login_input_under);
            }
            ax.i(this.PP, com.baidu.tieba.v.login_input_under);
            return;
        }
        ax.i(this.PN, com.baidu.tieba.v.login_input_topwrong);
        if (this.Pz) {
            ax.i(this.PO, com.baidu.tieba.v.login_input_middlewrong);
        } else {
            ax.i(this.PO, com.baidu.tieba.v.login_input_underwrong);
        }
        ax.i(this.PP, com.baidu.tieba.v.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        if (this.Qb != null) {
            this.Qb.cancel();
            this.Qb = null;
        }
        if (this.Qd != null) {
            this.Qd.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register() {
        rp();
        SapiFastRegActivityConfig sapiFastRegActivityConfig = new SapiFastRegActivityConfig(getPageContext().getPageActivity());
        sapiFastRegActivityConfig.setRequestCode(22002);
        sapiFastRegActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, sapiFastRegActivityConfig));
    }
}
