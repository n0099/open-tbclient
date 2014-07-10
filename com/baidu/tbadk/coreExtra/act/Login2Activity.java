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
import com.baidu.tbadk.core.atomData.bi;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity {
    private NavigationBar L;
    private ah d;
    private ah e;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private int j = 0;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;
    private EditText o = null;
    private EditText p = null;
    private EditText q = null;
    private View r = null;
    private ImageView s = null;
    private ImageView t = null;
    private ImageView u = null;
    private ProgressBar v = null;
    private ProgressBar w = null;
    private Button x = null;
    private View y = null;
    private View z = null;
    private View A = null;
    private View B = null;
    private Button C = null;
    private Button D = null;
    private Button E = null;
    private TextView F = null;
    private TextView G = null;
    private TextView H = null;
    private TextView I = null;
    private Button J = null;
    private Button K = null;
    RelativeLayout a = null;
    private aj M = null;
    private com.baidu.tbadk.core.data.i N = null;
    private ai O = null;
    InputMethodManager b = null;
    com.baidu.tbadk.coreExtra.view.s c = null;
    private AccountData P = null;
    private String Q = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_login_activity);
        this.Q = getIntent().getStringExtra("info");
        b();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("account");
        this.k = intent.getBooleanExtra("has_exit_dialog", true);
        this.l = intent.getBooleanExtra("close", false);
        if (bundle != null) {
            this.j = bundle.getInt("type_login");
        } else {
            this.j = 0;
        }
        if (intent.getIntExtra("login_type", 0) == 1) {
            this.j = 1;
        }
        if (stringExtra != null) {
            this.o.setText(stringExtra);
        }
        this.o.requestFocus();
        if (this.k) {
            this.y.setVisibility(4);
        } else {
            this.y.setVisibility(0);
        }
        if (this.j == 0) {
            a(com.baidu.tieba.v.normal_login);
        } else if (this.j == 1) {
            a(com.baidu.tieba.v.mobile_login);
        }
        ShowSoftKeyPadDelay(this.o, 150);
        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.j = bundle.getInt("type_login");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type_login", this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            o();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.c != null) {
            this.c.b();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.c == null || !this.c.c()) {
            ShowSoftKeyPadDelay(this.o, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.k) {
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
                a();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TbadkApplication.m252getInst().onUserChanged();
        if (this.l) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                intExtra = 1;
            }
            com.baidu.tbadk.core.b.b.a(this, intExtra, false);
        }
        finish();
    }

    private void b() {
        this.b = (InputMethodManager) getSystemService("input_method");
        this.a = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.L = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.y = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        this.L.a(getString(com.baidu.tieba.y.title_login));
        this.L.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.account_regedit), new z(this));
        this.o = (EditText) findViewById(com.baidu.tieba.v.login_edit_account);
        this.p = (EditText) findViewById(com.baidu.tieba.v.login_edit_password);
        this.q = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.z = findViewById(com.baidu.tieba.v.layout_account);
        this.A = findViewById(com.baidu.tieba.v.layout_password);
        this.B = findViewById(com.baidu.tieba.v.layout_vcode);
        this.v = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.t = (ImageView) findViewById(com.baidu.tieba.v.image_vcode1);
        this.u = (ImageView) findViewById(com.baidu.tieba.v.image_vcode2);
        this.s = this.t;
        this.w = (ProgressBar) findViewById(com.baidu.tieba.v.progress_login);
        this.x = (Button) findViewById(com.baidu.tieba.v.button_vcode_refresh);
        this.C = (Button) findViewById(com.baidu.tieba.v.button_account_del);
        this.D = (Button) findViewById(com.baidu.tieba.v.button_pass_del);
        this.E = (Button) findViewById(com.baidu.tieba.v.button_vcode_del);
        this.F = (TextView) findViewById(com.baidu.tieba.v.text_title_account);
        this.G = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.H = (TextView) findViewById(com.baidu.tieba.v.text_info);
        if (this.Q != null && this.Q.length() > 0) {
            this.H.setText(this.Q);
            this.H.setVisibility(0);
        }
        this.I = (TextView) findViewById(com.baidu.tieba.v.text_login);
        this.J = (Button) findViewById(com.baidu.tieba.v.normal_login);
        this.K = (Button) findViewById(com.baidu.tieba.v.mobile_login);
        aa aaVar = new aa(this);
        this.o.setOnFocusChangeListener(aaVar);
        this.p.setOnFocusChangeListener(aaVar);
        this.q.setOnFocusChangeListener(aaVar);
        ab abVar = new ab(this);
        this.p.setOnEditorActionListener(abVar);
        this.q.setOnEditorActionListener(abVar);
        this.o.addTextChangedListener(new ac(this));
        this.p.addTextChangedListener(new ad(this));
        this.q.addTextChangedListener(new ae(this));
        this.r = findViewById(com.baidu.tieba.v.layout_login);
        this.r.setEnabled(false);
        this.r.setOnClickListener(new af(this));
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.L.c(i);
        bk.a(this.I, i);
        bk.c(this.a, i);
        if (i == 1) {
            this.H.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
        } else {
            this.H.setTextColor(-13279809);
        }
        n();
        c();
    }

    private void c() {
        if (this.j == 0) {
            if (this.mSkinType == 1) {
                this.J.setBackgroundResource(com.baidu.tieba.u.login_tab_pressed_1);
                this.K.setBackgroundResource(com.baidu.tieba.u.login_tab_normal_1);
                this.J.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.K.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
                return;
            }
            this.J.setBackgroundResource(com.baidu.tieba.u.login_tab_pressed);
            this.K.setBackgroundResource(com.baidu.tieba.u.login_tab_normal);
            this.J.setTextColor(Color.rgb(50, 137, 203));
            this.K.setTextColor(-16777216);
        } else if (this.j == 1) {
            if (this.mSkinType == 1) {
                this.K.setBackgroundResource(com.baidu.tieba.u.login_tab_pressed_1);
                this.J.setBackgroundResource(com.baidu.tieba.u.login_tab_normal_1);
                this.K.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
                this.J.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_tab_unsel_color));
                return;
            }
            this.K.setBackgroundResource(com.baidu.tieba.u.login_tab_pressed);
            this.J.setBackgroundResource(com.baidu.tieba.u.login_tab_normal);
            this.K.setTextColor(Color.rgb(50, 137, 203));
            this.J.setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        boolean z;
        String editable = this.o.getText().toString();
        String editable2 = this.p.getText().toString();
        String editable3 = this.q.getText().toString();
        if (this.B.getVisibility() == 8) {
            z = bm.c(editable) || bm.c(editable2);
        } else {
            z = bm.c(editable) || bm.c(editable2) || bm.c(editable3);
        }
        if (!z) {
            this.r.setEnabled(true);
        } else {
            this.r.setEnabled(false);
        }
    }

    private void a(int i) {
        if (i == com.baidu.tieba.v.normal_login) {
            this.s = this.t;
            this.t.setVisibility(0);
            this.u.setVisibility(8);
            f();
            this.j = 0;
            e();
            this.o.setHint(com.baidu.tieba.y.account_hint_normal);
            this.F.setText(com.baidu.tieba.y.account_account);
            this.o.requestFocus();
            this.o.setInputType(1);
            c();
        } else if (i == com.baidu.tieba.v.mobile_login) {
            this.s = this.u;
            this.t.setVisibility(8);
            this.u.setVisibility(0);
            f();
            this.j = 1;
            e();
            this.o.setHint(com.baidu.tieba.y.account_mobile);
            this.F.setText(com.baidu.tieba.y.account_mobile);
            this.o.requestFocus();
            this.o.setInputType(3);
            c();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.normal_login || id == com.baidu.tieba.v.mobile_login) {
            a(view.getId());
        } else if (id == com.baidu.tieba.v.button_account_del) {
            this.o.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_pass_del) {
            this.p.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_del) {
            this.q.setText((CharSequence) null);
        } else if (id == com.baidu.tieba.v.button_vcode_refresh || id == com.baidu.tieba.v.image_vcode1 || id == com.baidu.tieba.v.image_vcode2) {
            a(this.i);
        }
    }

    private void e() {
        if (this.j == 0) {
            if (this.d == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.B.setVisibility(8);
                this.G.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.d.a;
                this.o.setText(this.d.a);
                this.p.setText(this.d.b);
                this.q.setText(this.d.c);
                this.G.setText(this.d.d);
                this.B.setVisibility(this.d.e);
                this.G.setVisibility(this.d.f);
                this.n = this.d.g;
                this.m = this.d.e == 0;
            }
        }
        if (this.j == 1) {
            if (this.e == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.B.setVisibility(8);
                this.G.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.e.a;
                this.o.setText(this.e.a);
                this.p.setText(this.e.b);
                this.q.setText(this.e.c);
                this.G.setText(this.e.d);
                this.B.setVisibility(this.e.e);
                this.G.setVisibility(this.e.f);
                this.n = this.e.g;
                this.m = this.e.e == 0;
            }
        }
        n();
        d();
    }

    private void f() {
        if (this.j == 0) {
            this.d = new ah(this, null);
            this.d.a = this.o.getText().toString();
            this.d.b = this.p.getText().toString();
            this.d.c = this.q.getText().toString();
            this.d.d = this.G.getText().toString();
            this.d.e = this.B.getVisibility();
            this.d.f = this.G.getVisibility();
            this.d.g = this.n;
        }
        if (this.j == 1) {
            this.e = new ah(this, null);
            this.e.a = this.o.getText().toString();
            this.e.b = this.p.getText().toString();
            this.e.c = this.q.getText().toString();
            this.e.d = this.G.getText().toString();
            this.e.e = this.B.getVisibility();
            this.e.f = this.G.getVisibility();
            this.e.g = this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.M == null) {
            String editable = this.o.getText().toString();
            this.g = bm.b(this.p.getText().toString().getBytes());
            if (editable.length() > 0 && this.g.length() > 0) {
                if (!this.m || !bm.c(this.q.getText().toString())) {
                    l();
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append(TbConfig.LOGIN_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.g));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.j)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkApplication.m252getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId()));
                    if (this.B != null && this.B.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.q.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.h));
                    }
                    o();
                    this.M = new aj(this, stringBuffer.toString(), arrayList);
                    this.M.setPriority(3);
                    this.M.execute(stringBuffer.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.N.a().getUserName());
        if (this.N.a().getPassword() != null) {
            accountData.setPassword(this.N.a().getPassword());
        } else {
            accountData.setPassword(this.g);
        }
        accountData.setID(this.N.a().getUserId());
        accountData.setBDUSS(this.N.a().getBDUSS());
        accountData.setPortrait(this.N.a().getPortrait());
        accountData.setIsActive(1);
        if (this.N.b() != null) {
            accountData.setTbs(this.N.b().getTbs());
        }
        this.P = accountData;
        if (!TextUtils.isEmpty(this.P.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(this.P, getBaseContext());
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.P.getID();
            sapiAccount.displayname = this.P.getAccount();
            sapiAccount.bduss = this.P.getBDUSS();
            SapiAccountManager.getInstance().validate(sapiAccount);
            a();
            return;
        }
        if (this.c == null) {
            this.c = new com.baidu.tbadk.coreExtra.view.s(this);
            this.c.a(new ag(this));
        }
        this.c.e();
        this.c.a(this.o.getText().toString());
        this.c.a(this.P);
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.n = false;
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.O != null) {
            this.O.cancel();
        }
        this.v.setVisibility(0);
        this.s.setImageBitmap(null);
        o();
        this.O = new ai(this, null);
        this.O.setPriority(3);
        this.O.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m = true;
        this.B.setVisibility(0);
        this.q.setText((CharSequence) null);
        if (this.n) {
            if (this.mSkinType == 1) {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middle_1);
            } else {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            }
        } else if (this.mSkinType == 1) {
            this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middlewrong_1);
        } else {
            this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middlewrong);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.m = false;
        this.B.setVisibility(8);
        if (this.n) {
            this.A.setBackgroundResource(com.baidu.tieba.u.login_input_under);
        } else {
            this.A.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong);
        }
        d();
    }

    private void l() {
        this.o.setEnabled(false);
        this.p.setEnabled(false);
        this.q.setEnabled(false);
        this.x.setEnabled(false);
        this.s.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
        this.E.setEnabled(false);
        this.J.setEnabled(false);
        this.K.setEnabled(false);
        this.o.setTextColor(Color.rgb(136, 136, 136));
        this.p.setTextColor(Color.rgb(136, 136, 136));
        this.q.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.o.setEnabled(true);
        this.p.setEnabled(true);
        this.q.setEnabled(true);
        this.x.setEnabled(true);
        this.s.setEnabled(true);
        this.C.setEnabled(true);
        this.D.setEnabled(true);
        this.E.setEnabled(true);
        this.J.setEnabled(true);
        this.K.setEnabled(true);
        this.o.setTextColor(-16777216);
        this.p.setTextColor(-16777216);
        this.q.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.n) {
            if (this.mSkinType == 1) {
                this.z.setBackgroundResource(com.baidu.tieba.u.login_input_top_1);
                if (this.m) {
                    this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middle_1);
                } else {
                    this.A.setBackgroundResource(com.baidu.tieba.u.login_input_under_1);
                }
                this.B.setBackgroundResource(com.baidu.tieba.u.login_input_under_1);
                return;
            }
            this.z.setBackgroundResource(com.baidu.tieba.u.login_input_top);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            } else {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_under);
            }
            this.B.setBackgroundResource(com.baidu.tieba.u.login_input_under);
        } else if (this.mSkinType == 1) {
            this.z.setBackgroundResource(com.baidu.tieba.u.login_input_topwrong_1);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middlewrong_1);
            } else {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong_1);
            }
            this.B.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong_1);
        } else {
            this.z.setBackgroundResource(com.baidu.tieba.u.login_input_topwrong);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_middlewrong);
            } else {
                this.A.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong);
            }
            this.B.setBackgroundResource(com.baidu.tieba.u.login_input_underwrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.M != null) {
            this.M.cancel();
            this.M = null;
        }
        if (this.O != null) {
            this.O.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        o();
        bi biVar = new bi(this);
        biVar.setRequestCode(22002);
        biVar.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, biVar));
    }
}
