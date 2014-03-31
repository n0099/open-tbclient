package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tbadk.a {
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
    private k o = null;
    private j p = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private m u = null;
    private TextView v = null;
    private Bitmap w = null;
    private l x = null;
    private int y = 0;
    private int z = 0;
    private boolean A = true;
    private String B = null;
    private boolean D = false;

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

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.f.a().b("motu_sdk") == 1) {
            this.A = false;
        } else {
            this.A = true;
        }
        TbadkApplication.j().a(this);
        setContentView(com.baidu.tbadk.k.edit_head_activity);
        Intent intent = getIntent();
        this.i = intent.getIntExtra("edit_type", 0);
        this.E = intent.getIntExtra("request", 0);
        if (this.E == 12002 || this.E == 12001) {
            c();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.E, intent.getData(), bd.a().e());
            } else {
                TiebaPrepareImageService.a(this.E, null, bd.a().e());
            }
            this.x = new l(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tbadk.core.data.n.t());
            registerReceiver(this.x, intentFilter);
        } else {
            c();
            b();
        }
        f = getResources().getStringArray(com.baidu.tbadk.f.fiter_name);
        if (this.A) {
            TbadkApplication.j().a(1, 1, "motu_pic");
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.o == null) {
            this.o = new k(this, (byte) 0);
            this.o.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.H.b(i);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.g.setImageBitmap(null);
        if (this.G != null) {
            for (Map.Entry<String, ImageView> entry : this.G.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageBitmap(null);
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

    public void b() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.o = new k(this, (byte) 0);
        this.o.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TbadkApplication.a(accountData, getBaseContext());
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.g.i();
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
        TbadkApplication.j().b(this);
    }

    public static /* synthetic */ void o(EditHeadActivity editHeadActivity) {
        if (editHeadActivity.u != null) {
            editHeadActivity.u.cancel();
        }
        editHeadActivity.u = new m(editHeadActivity, (byte) 0);
        editHeadActivity.u.execute(new String[0]);
    }

    private void c() {
        this.H = (NavigationBar) findViewById(com.baidu.tbadk.j.navigation_bar);
        this.n = (ProgressBar) findViewById(com.baidu.tbadk.j.progress);
        this.n.setVisibility(8);
        this.g = (EditHeadsImageView) findViewById(com.baidu.tbadk.j.image);
        this.g.setImageBitmap(this.h);
        this.m = (HorizontalScrollView) findViewById(com.baidu.tbadk.j.filters_layout);
        this.H.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.l = (Button) findViewById(com.baidu.tbadk.j.show_button);
        this.l.setOnClickListener(new b(this));
        this.k = (Button) findViewById(com.baidu.tbadk.j.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new c(this));
        this.j = this.H.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tbadk.l.done), new d(this));
        this.j.setEnabled(false);
        this.v = this.H.a(getString(com.baidu.tbadk.l.beautify));
        if (this.i == 2) {
            this.v.setText(getString(com.baidu.tbadk.l.beautify));
            this.j.setText(getString(com.baidu.tbadk.l.done));
        }
        this.C = (LinearLayout) findViewById(com.baidu.tbadk.j.filters);
        this.y = com.baidu.adp.lib.util.i.a((Context) this, 2.0f);
        this.t = (LinearLayout) findViewById(com.baidu.tbadk.j.beautify_rotate);
        this.s = (LinearLayout) findViewById(com.baidu.tbadk.j.rotate);
        this.q = (RadioButton) findViewById(com.baidu.tbadk.j.beautify_btn);
        this.r = (RadioButton) findViewById(com.baidu.tbadk.j.rotate_btn);
        f fVar = new f(this);
        this.q.setOnCheckedChangeListener(fVar);
        this.r.setOnCheckedChangeListener(fVar);
        this.q.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tbadk.j.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tbadk.j.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tbadk.j.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tbadk.j.rotate_up_down);
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

    public static /* synthetic */ void a(EditHeadActivity editHeadActivity, String str) {
        if (editHeadActivity.p != null) {
            editHeadActivity.p.cancel();
        }
        editHeadActivity.p = new j(editHeadActivity, (byte) 0);
        editHeadActivity.p.execute(str);
    }

    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.w.a((String) null, str, bitmap, 80);
            if (this.D) {
                new ax("motu_pic", String.valueOf(this.z)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    public static /* synthetic */ void a(EditHeadActivity editHeadActivity, String[] strArr) {
        if (editHeadActivity.F == null || strArr == null) {
            return;
        }
        editHeadActivity.C.removeAllViews();
        View inflate = editHeadActivity.getLayoutInflater().inflate(com.baidu.tbadk.k.filter_item, (ViewGroup) null);
        inflate.findViewById(com.baidu.tbadk.j.filter_immage);
        inflate.findViewById(com.baidu.tbadk.j.filter_text);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate2 = editHeadActivity.getLayoutInflater().inflate(com.baidu.tbadk.k.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tbadk.j.filter_immage);
            TextView textView = (TextView) inflate2.findViewById(com.baidu.tbadk.j.filter_text);
            textView.setText(substring2);
            imageView.setImageResource(com.baidu.tbadk.coreExtra.view.j.a(substring));
            imageView.setTag(textView);
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView.setOnClickListener(new h(editHeadActivity, substring, i2));
            } else {
                imageView.setOnClickListener(new i(editHeadActivity, substring, i2));
            }
            editHeadActivity.C.addView(inflate2);
            editHeadActivity.G.put(substring, imageView);
            i++;
            i2 = i3;
        }
        editHeadActivity.a("normal");
    }

    public void a(String str) {
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
                imageView2.setBackgroundResource(com.baidu.tbadk.i.round_corner);
                imageView2.setPadding(this.y, this.y, this.y, this.y);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.B = str;
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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
