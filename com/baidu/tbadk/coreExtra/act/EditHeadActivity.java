package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity {
    public static String a = "resourceid";
    public static String b = "pic_info";
    public static String c = "delete";
    public static String d = "change";
    public static String e = "file_name";
    private static String[] f = null;
    private LinearLayout C;
    private int E;
    private HashMap<String, Bitmap> F;
    private HashMap<String, ImageView> G;
    private NavigationBar H;
    private View I;
    private RadioButton q;
    private RadioButton r;
    private EditHeadsImageView g = null;
    private Bitmap h = null;
    private int i = 0;
    private TextView j = null;
    private Button k = null;
    private Button l = null;
    private HorizontalScrollView m = null;
    private ProgressBar n = null;
    private m o = null;
    private j p = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private o u = null;
    private TextView v = null;
    private Bitmap w = null;
    private n x = null;
    private int y = 0;
    private int z = 0;
    private boolean A = true;
    private String B = null;
    private boolean D = false;
    private final Handler J = new Handler();

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData) {
        a(activity, i, i2, uri, accountData, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.f.a().b("motu_sdk") == 1) {
            this.A = false;
        } else {
            this.A = true;
        }
        TbadkApplication.m252getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.v.edit_head_activity);
        Intent intent = getIntent();
        this.i = intent.getIntExtra("edit_type", 0);
        this.E = intent.getIntExtra("request", 0);
        if (this.E == 12002 || this.E == 12001) {
            e();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.E, intent.getData(), bb.a().e());
            } else {
                TiebaPrepareImageService.StartService(this.E, null, bb.a().e());
            }
            f();
        } else {
            e();
            c();
        }
        f = getResources().getStringArray(com.baidu.tieba.p.fiter_name);
        if (this.A) {
            TbadkApplication.m252getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.H.c(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.g.setImageDrawable(null);
        b();
    }

    private void b() {
        if (this.G != null) {
            for (Map.Entry<String, ImageView> entry : this.G.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.G.clear();
            this.G = null;
        }
        if (this.F != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.F.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.F.clear();
            this.F = null;
        }
    }

    public void c() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.o = new m(this, null);
        this.o.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TbadkApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getBaseContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.g.j();
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        if (this.w != null && !this.w.isRecycled()) {
            this.w.recycle();
            this.w = null;
        }
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        this.n.setVisibility(8);
        if (this.E == 12002 || this.E == 12001) {
            unregisterReceiver(this.x);
        }
        TbadkApplication.m252getInst().delRemoteActivity(this);
    }

    public void d() {
        if (this.u != null) {
            this.u.cancel();
        }
        this.u = new o(this, null);
        this.u.execute(new String[0]);
    }

    private void e() {
        this.H = (NavigationBar) findViewById(com.baidu.tieba.u.navigation_bar);
        this.n = (ProgressBar) findViewById(com.baidu.tieba.u.progress);
        this.n.setVisibility(8);
        this.g = (EditHeadsImageView) findViewById(com.baidu.tieba.u.image);
        if (this.h != null) {
            this.g.setImageBitmap(this.h);
        }
        this.m = (HorizontalScrollView) findViewById(com.baidu.tieba.u.filters_layout);
        this.H.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.l = (Button) findViewById(com.baidu.tieba.u.show_button);
        this.l.setOnClickListener(new b(this));
        this.k = (Button) findViewById(com.baidu.tieba.u.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new c(this));
        this.j = this.H.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.x.done), new d(this));
        this.j.setEnabled(false);
        this.v = this.H.a(getString(com.baidu.tieba.x.beautify));
        if (this.i == 2) {
            this.v.setText(getString(com.baidu.tieba.x.beautify));
            this.j.setText(getString(com.baidu.tieba.x.done));
        }
        this.C = (LinearLayout) findViewById(com.baidu.tieba.u.filters);
        this.y = com.baidu.adp.lib.util.j.a((Context) this, 2.0f);
        this.t = (LinearLayout) findViewById(com.baidu.tieba.u.beautify_rotate);
        this.s = (LinearLayout) findViewById(com.baidu.tieba.u.rotate);
        this.q = (RadioButton) findViewById(com.baidu.tieba.u.beautify_btn);
        this.r = (RadioButton) findViewById(com.baidu.tieba.u.rotate_btn);
        f fVar = new f(this);
        this.q.setOnCheckedChangeListener(fVar);
        this.r.setOnCheckedChangeListener(fVar);
        this.q.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.u.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.u.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.u.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.u.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        g gVar = new g(this);
        button.setOnClickListener(gVar);
        button2.setOnClickListener(gVar);
        button3.setOnClickListener(gVar);
        button4.setOnClickListener(gVar);
    }

    public void a(String str) {
        if (this.p != null) {
            this.p.cancel();
        }
        this.p = new j(this, null);
        this.p.execute(str);
    }

    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.s.a((String) null, str, bitmap, 80);
            if (this.D) {
                new aw("motu_pic", String.valueOf(this.z)).start();
            }
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return false;
        }
    }

    public void a(String[] strArr) {
        if (this.F != null && strArr != null) {
            this.C.removeAllViews();
            View inflate = getLayoutInflater().inflate(com.baidu.tieba.v.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.u.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = getLayoutInflater().inflate(com.baidu.tieba.v.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.u.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.u.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.k.a(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new h(this, substring, i2));
                    this.I = imageView2;
                } else {
                    imageView2.setOnClickListener(new i(this, substring, i2));
                }
                this.C.addView(inflate2);
                this.G.put(substring, imageView2);
                i++;
                i2 = i3;
            }
            b("normal");
        }
    }

    public void b(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.B != null && (imageView = this.G.get(this.B)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.y, this.y, this.y, this.y);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.G.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.t.round_corner);
                imageView2.setPadding(this.y, this.y, this.y, this.y);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.B = str;
        }
    }

    private void f() {
        this.x = new n(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.x, intentFilter);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
