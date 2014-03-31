package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import com.baidu.tieba.person.PersonInfoActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends com.baidu.tbadk.a {
    private NavigationBar L;
    private w d;
    private w e;
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
    private y M = null;
    private com.baidu.tbadk.core.data.h N = null;
    private x O = null;
    private com.baidu.tbadk.core.a.n P = null;
    InputMethodManager b = null;
    com.baidu.tbadk.coreExtra.view.p c = null;
    private AccountData Q = null;
    private String R = null;

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.y.class, LoginActivity.class);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("locate_type", i);
        intent.putExtra("info", str);
        activity.startActivityForResult(intent, 11003);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("info", str);
        intent.putExtra("close", true);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("account", str);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tbadk.k.account_login_activity);
        this.R = getIntent().getStringExtra("info");
        this.b = (InputMethodManager) getSystemService("input_method");
        this.a = (RelativeLayout) findViewById(com.baidu.tbadk.j.container);
        this.L = (NavigationBar) findViewById(com.baidu.tbadk.j.view_navigation_bar);
        this.y = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new n(this));
        this.L.a(getString(com.baidu.tbadk.l.title_login));
        this.L.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tbadk.l.account_regedit), new o(this));
        this.o = (EditText) findViewById(com.baidu.tbadk.j.login_edit_account);
        this.p = (EditText) findViewById(com.baidu.tbadk.j.login_edit_password);
        this.q = (EditText) findViewById(com.baidu.tbadk.j.edit_vcode);
        this.z = findViewById(com.baidu.tbadk.j.layout_account);
        this.A = findViewById(com.baidu.tbadk.j.layout_password);
        this.B = findViewById(com.baidu.tbadk.j.layout_vcode);
        this.v = (ProgressBar) findViewById(com.baidu.tbadk.j.image_progress);
        this.t = (ImageView) findViewById(com.baidu.tbadk.j.image_vcode1);
        this.u = (ImageView) findViewById(com.baidu.tbadk.j.image_vcode2);
        this.s = this.t;
        this.w = (ProgressBar) findViewById(com.baidu.tbadk.j.progress_login);
        this.x = (Button) findViewById(com.baidu.tbadk.j.button_vcode_refresh);
        this.C = (Button) findViewById(com.baidu.tbadk.j.button_account_del);
        this.D = (Button) findViewById(com.baidu.tbadk.j.button_pass_del);
        this.E = (Button) findViewById(com.baidu.tbadk.j.button_vcode_del);
        this.F = (TextView) findViewById(com.baidu.tbadk.j.text_title_account);
        this.G = (TextView) findViewById(com.baidu.tbadk.j.text_error);
        this.H = (TextView) findViewById(com.baidu.tbadk.j.text_info);
        if (this.R != null && this.R.length() > 0) {
            this.H.setText(this.R);
            this.H.setVisibility(0);
        }
        this.I = (TextView) findViewById(com.baidu.tbadk.j.text_login);
        this.J = (Button) findViewById(com.baidu.tbadk.j.normal_login);
        this.K = (Button) findViewById(com.baidu.tbadk.j.mobile_login);
        p pVar = new p(this);
        this.o.setOnFocusChangeListener(pVar);
        this.p.setOnFocusChangeListener(pVar);
        this.q.setOnFocusChangeListener(pVar);
        q qVar = new q(this);
        this.p.setOnEditorActionListener(qVar);
        this.q.setOnEditorActionListener(qVar);
        this.o.addTextChangedListener(new r(this));
        this.p.addTextChangedListener(new s(this));
        this.q.addTextChangedListener(new t(this));
        this.r = findViewById(com.baidu.tbadk.j.layout_login);
        this.r.setEnabled(false);
        this.r.setOnClickListener(new u(this));
        f();
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
            a(com.baidu.tbadk.j.normal_login);
        } else if (this.j == 1) {
            a(com.baidu.tbadk.j.mobile_login);
        }
        ShowSoftKeyPadDelay(this.o, 150);
        new ax("login").start();
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        try {
            h();
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        if (this.c != null) {
            this.c.b();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        if (this.c == null || !this.c.c()) {
            ShowSoftKeyPadDelay(this.o, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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
        TbadkApplication.j();
        TbadkApplication.M();
        if (this.l) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkApplication.D());
            setResult(-1, intent);
        } else {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                intExtra = 1;
            }
            com.baidu.tbadk.core.d.b.a(this, intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.L.b(i);
        ba.a(this.I, i);
        ba.c(this.a, i);
        if (i == 1) {
            this.H.setTextColor(getResources().getColor(com.baidu.tbadk.g.skin_1_common_color));
        } else {
            this.H.setTextColor(-13279809);
        }
        g();
        b();
    }

    private void b() {
        if (this.j == 0) {
            if (this.mSkinType == 1) {
                this.J.setBackgroundResource(com.baidu.tbadk.i.login_tab_pressed_1);
                this.K.setBackgroundResource(com.baidu.tbadk.i.login_tab_normal_1);
                this.J.setTextColor(getResources().getColor(com.baidu.tbadk.g.skin_1_common_color));
                this.K.setTextColor(getResources().getColor(com.baidu.tbadk.g.skin_1_tab_unsel_color));
                return;
            }
            this.J.setBackgroundResource(com.baidu.tbadk.i.login_tab_pressed);
            this.K.setBackgroundResource(com.baidu.tbadk.i.login_tab_normal);
            this.J.setTextColor(Color.rgb(50, 137, 203));
            this.K.setTextColor(-16777216);
        } else if (this.j == 1) {
            if (this.mSkinType == 1) {
                this.K.setBackgroundResource(com.baidu.tbadk.i.login_tab_pressed_1);
                this.J.setBackgroundResource(com.baidu.tbadk.i.login_tab_normal_1);
                this.K.setTextColor(getResources().getColor(com.baidu.tbadk.g.skin_1_common_color));
                this.J.setTextColor(getResources().getColor(com.baidu.tbadk.g.skin_1_tab_unsel_color));
                return;
            }
            this.K.setBackgroundResource(com.baidu.tbadk.i.login_tab_pressed);
            this.J.setBackgroundResource(com.baidu.tbadk.i.login_tab_normal);
            this.K.setTextColor(Color.rgb(50, 137, 203));
            this.J.setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z;
        String editable = this.o.getText().toString();
        String editable2 = this.p.getText().toString();
        String editable3 = this.q.getText().toString();
        if (this.B.getVisibility() == 8) {
            z = bc.c(editable) || bc.c(editable2);
        } else {
            z = bc.c(editable) || bc.c(editable2) || bc.c(editable3);
        }
        if (!z) {
            this.r.setEnabled(true);
        } else {
            this.r.setEnabled(false);
        }
    }

    private void a(int i) {
        if (i == com.baidu.tbadk.j.normal_login) {
            this.s = this.t;
            this.t.setVisibility(0);
            this.u.setVisibility(8);
            e();
            this.j = 0;
            d();
            this.o.setHint(com.baidu.tbadk.l.account_hint_normal);
            this.F.setText(com.baidu.tbadk.l.account_account);
            this.o.requestFocus();
            this.o.setInputType(1);
            b();
        } else if (i == com.baidu.tbadk.j.mobile_login) {
            this.s = this.u;
            this.t.setVisibility(8);
            this.u.setVisibility(0);
            e();
            this.j = 1;
            d();
            this.o.setHint(com.baidu.tbadk.l.account_mobile);
            this.F.setText(com.baidu.tbadk.l.account_mobile);
            this.o.requestFocus();
            this.o.setInputType(3);
            b();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tbadk.j.normal_login || id == com.baidu.tbadk.j.mobile_login) {
            a(view.getId());
        } else if (id == com.baidu.tbadk.j.button_account_del) {
            this.o.setText((CharSequence) null);
        } else if (id == com.baidu.tbadk.j.button_pass_del) {
            this.p.setText((CharSequence) null);
        } else if (id == com.baidu.tbadk.j.button_vcode_del) {
            this.q.setText((CharSequence) null);
        } else if (id == com.baidu.tbadk.j.button_vcode_refresh || id == com.baidu.tbadk.j.image_vcode1 || id == com.baidu.tbadk.j.image_vcode2) {
            a(this.i);
        }
    }

    private void d() {
        LoginActivity loginActivity;
        LoginActivity loginActivity2;
        boolean z;
        LoginActivity loginActivity3;
        boolean z2 = true;
        if (this.j == 0) {
            if (this.d == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.B.setVisibility(8);
                this.G.setVisibility(4);
                this.n = true;
                loginActivity2 = this;
            } else {
                this.f = this.d.a;
                this.o.setText(this.d.a);
                this.p.setText(this.d.b);
                this.q.setText(this.d.c);
                this.G.setText(this.d.d);
                this.B.setVisibility(this.d.e);
                this.G.setVisibility(this.d.f);
                this.n = this.d.g;
                if (this.d.e == 0) {
                    z = true;
                    loginActivity3 = this;
                    loginActivity3.m = z;
                } else {
                    loginActivity2 = this;
                }
            }
            loginActivity3 = loginActivity2;
            z = false;
            loginActivity3.m = z;
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
                loginActivity = this;
            } else {
                this.f = this.e.a;
                this.o.setText(this.e.a);
                this.p.setText(this.e.b);
                this.q.setText(this.e.c);
                this.G.setText(this.e.d);
                this.B.setVisibility(this.e.e);
                this.G.setVisibility(this.e.f);
                this.n = this.e.g;
                if (this.e.e == 0) {
                    loginActivity = this;
                    loginActivity.m = z2;
                } else {
                    loginActivity = this;
                }
            }
            z2 = false;
            loginActivity.m = z2;
        }
        g();
        c();
    }

    private void e() {
        if (this.j == 0) {
            this.d = new w(this, (byte) 0);
            this.d.a = this.o.getText().toString();
            this.d.b = this.p.getText().toString();
            this.d.c = this.q.getText().toString();
            this.d.d = this.G.getText().toString();
            this.d.e = this.B.getVisibility();
            this.d.f = this.G.getVisibility();
            this.d.g = this.n;
        }
        if (this.j == 1) {
            this.e = new w(this, (byte) 0);
            this.e.a = this.o.getText().toString();
            this.e.b = this.p.getText().toString();
            this.e.c = this.q.getText().toString();
            this.e.d = this.G.getText().toString();
            this.e.e = this.B.getVisibility();
            this.e.f = this.G.getVisibility();
            this.e.g = this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(LoginActivity loginActivity) {
        if (loginActivity.M == null) {
            String editable = loginActivity.o.getText().toString();
            loginActivity.g = bc.a(loginActivity.p.getText().toString().getBytes());
            if (editable.length() <= 0 || loginActivity.g.length() <= 0) {
                return;
            }
            if (loginActivity.m && bc.c(loginActivity.q.getText().toString())) {
                return;
            }
            loginActivity.o.setEnabled(false);
            loginActivity.p.setEnabled(false);
            loginActivity.q.setEnabled(false);
            loginActivity.x.setEnabled(false);
            loginActivity.s.setEnabled(false);
            loginActivity.C.setEnabled(false);
            loginActivity.D.setEnabled(false);
            loginActivity.E.setEnabled(false);
            loginActivity.J.setEnabled(false);
            loginActivity.K.setEnabled(false);
            loginActivity.o.setTextColor(Color.rgb(136, 136, 136));
            loginActivity.p.setTextColor(Color.rgb(136, 136, 136));
            loginActivity.q.setTextColor(Color.rgb(136, 136, 136));
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tbadk.core.data.n.a);
            stringBuffer.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(PersonInfoActivity.TAG_ID, editable));
            arrayList.add(new BasicNameValuePair("passwd", loginActivity.g));
            arrayList.add(new BasicNameValuePair("isphone", String.valueOf(loginActivity.j)));
            arrayList.add(new BasicNameValuePair("channel_id", TbadkApplication.j().S()));
            arrayList.add(new BasicNameValuePair("channel_uid", TbadkApplication.j().R()));
            if (loginActivity.B != null && loginActivity.B.getVisibility() == 0) {
                arrayList.add(new BasicNameValuePair("vcode", loginActivity.q.getText().toString()));
                arrayList.add(new BasicNameValuePair("vcode_md5", loginActivity.h));
            }
            loginActivity.h();
            loginActivity.M = new y(loginActivity, stringBuffer.toString(), arrayList);
            loginActivity.M.setPriority(3);
            loginActivity.M.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(LoginActivity loginActivity) {
        com.baidu.adp.framework.c.a().b(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(loginActivity.N.a().getUserName());
        if (loginActivity.N.a().getPassword() != null) {
            accountData.setPassword(loginActivity.N.a().getPassword());
        } else {
            accountData.setPassword(loginActivity.g);
        }
        accountData.setID(loginActivity.N.a().getUserId());
        accountData.setBDUSS(loginActivity.N.a().getBDUSS());
        accountData.setPortrait(loginActivity.N.a().getPortrait());
        accountData.setIsActive(1);
        if (loginActivity.N.b() != null) {
            accountData.setTbs(loginActivity.N.b().getTbs());
        }
        loginActivity.Q = accountData;
        if (loginActivity.Q.getAccount() != null) {
            com.baidu.tbadk.core.a.o.a(accountData);
            TbadkApplication.a(loginActivity.Q, loginActivity.getBaseContext());
            if (loginActivity.P != null) {
                com.baidu.tbadk.core.a.l a = com.baidu.tbadk.core.a.l.a();
                com.baidu.tbadk.core.a.n nVar = loginActivity.P;
                a.b();
            }
            loginActivity.a();
            return;
        }
        if (loginActivity.c == null) {
            loginActivity.c = new com.baidu.tbadk.coreExtra.view.p(loginActivity);
            loginActivity.c.a(new v(loginActivity));
        }
        loginActivity.c.e();
        loginActivity.c.a(loginActivity.o.getText().toString());
        loginActivity.c.a(loginActivity.Q);
        loginActivity.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(LoginActivity loginActivity) {
        loginActivity.n = false;
        loginActivity.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.O != null) {
            this.O.cancel();
        }
        this.v.setVisibility(0);
        this.s.setImageBitmap(null);
        h();
        this.O = new x(this, (byte) 0);
        this.O.setPriority(3);
        this.O.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(LoginActivity loginActivity) {
        loginActivity.m = true;
        loginActivity.B.setVisibility(0);
        loginActivity.q.setText((CharSequence) null);
        if (loginActivity.n) {
            if (loginActivity.mSkinType == 1) {
                loginActivity.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middle_1);
            } else {
                loginActivity.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middle);
            }
        } else if (loginActivity.mSkinType == 1) {
            loginActivity.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middlewrong_1);
        } else {
            loginActivity.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middlewrong);
        }
        loginActivity.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.m = false;
        this.B.setVisibility(8);
        if (this.n) {
            this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_under);
        } else {
            this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_underwrong);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(LoginActivity loginActivity) {
        loginActivity.o.setEnabled(true);
        loginActivity.p.setEnabled(true);
        loginActivity.q.setEnabled(true);
        loginActivity.x.setEnabled(true);
        loginActivity.s.setEnabled(true);
        loginActivity.C.setEnabled(true);
        loginActivity.D.setEnabled(true);
        loginActivity.E.setEnabled(true);
        loginActivity.J.setEnabled(true);
        loginActivity.K.setEnabled(true);
        loginActivity.o.setTextColor(-16777216);
        loginActivity.p.setTextColor(-16777216);
        loginActivity.q.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.n) {
            if (this.mSkinType == 1) {
                this.z.setBackgroundResource(com.baidu.tbadk.i.login_input_top_1);
                if (this.m) {
                    this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middle_1);
                } else {
                    this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_under_1);
                }
                this.B.setBackgroundResource(com.baidu.tbadk.i.login_input_under_1);
                return;
            }
            this.z.setBackgroundResource(com.baidu.tbadk.i.login_input_top);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middle);
            } else {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_under);
            }
            this.B.setBackgroundResource(com.baidu.tbadk.i.login_input_under);
        } else if (this.mSkinType == 1) {
            this.z.setBackgroundResource(com.baidu.tbadk.i.login_input_topwrong_1);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middlewrong_1);
            } else {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_underwrong_1);
            }
            this.B.setBackgroundResource(com.baidu.tbadk.i.login_input_underwrong_1);
        } else {
            this.z.setBackgroundResource(com.baidu.tbadk.i.login_input_topwrong);
            if (this.m) {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_middlewrong);
            } else {
                this.A.setBackgroundResource(com.baidu.tbadk.i.login_input_underwrong);
            }
            this.B.setBackgroundResource(com.baidu.tbadk.i.login_input_underwrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.M != null) {
            this.M.cancel();
            this.M = null;
        }
        if (this.O != null) {
            this.O.cancel();
        }
    }
}
