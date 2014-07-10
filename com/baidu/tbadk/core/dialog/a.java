package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    protected final Activity a;
    private String c;
    private View d;
    private String e;
    private String f;
    private String g;
    private String h;
    private d i;
    private d j;
    private d k;
    private DialogInterface.OnCancelListener l;
    private AlertDialog m;
    private final ViewGroup n;
    private final LayoutInflater o;
    private int b = -1;
    private boolean p = false;
    private boolean q = true;

    public a a(String str) {
        this.c = str;
        return this;
    }

    public a a(int i) {
        a(this.a.getResources().getString(i));
        return this;
    }

    public a b(String str) {
        this.e = str;
        return this;
    }

    public a a(View view) {
        this.d = view;
        return this;
    }

    public a b(int i) {
        if (this.a != null) {
            this.e = this.a.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, d dVar) {
        if (this.a != null) {
            this.f = this.a.getResources().getString(i);
            this.i = dVar;
        }
        return this;
    }

    public a b(int i, d dVar) {
        if (this.a != null) {
            this.g = this.a.getResources().getString(i);
            this.j = dVar;
        }
        return this;
    }

    public a a(boolean z) {
        this.q = z;
        return this;
    }

    public a(Activity activity) {
        this.a = activity;
        this.o = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.n = (ViewGroup) this.o.inflate(w.dialog_bdalert, (ViewGroup) null);
    }

    public a a() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (!this.p) {
            this.p = true;
            d();
            TextView textView = (TextView) this.n.findViewById(v.title);
            LinearLayout linearLayout = (LinearLayout) this.n.findViewById(v.content);
            TextView textView2 = (TextView) this.n.findViewById(v.message);
            Button button = (Button) this.n.findViewById(v.yes);
            Button button2 = (Button) this.n.findViewById(v.no);
            Button button3 = (Button) this.n.findViewById(v.cancel);
            if (!TextUtils.isEmpty(this.c)) {
                textView.setText(this.c);
            } else {
                textView.setVisibility(8);
            }
            if (this.d != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                textView2.setText(this.e);
            }
            if (TextUtils.isEmpty(this.f)) {
                z = false;
            } else {
                button.setText(this.f);
                if (this.i != null) {
                    button.setOnClickListener(new c(this, this, this.i));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.g)) {
                z2 = false;
            } else {
                button2.setText(this.g);
                if (this.j != null) {
                    button2.setOnClickListener(new c(this, this, this.j));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.h)) {
                z3 = false;
            } else {
                button3.setText(this.h);
                if (this.k != null) {
                    button3.setOnClickListener(new c(this, this, this.k));
                }
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void d() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            baseActivity.getLayoutMode().a(skinType == 1);
            baseActivity.getLayoutMode().a((View) this.n);
        } else if (this.a instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.a;
            baseFragmentActivity.c().a(skinType == 1);
            baseFragmentActivity.c().a((View) this.n);
        }
    }

    private void a(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        boolean[] zArr = {z2, z, z3};
        Button[] buttonArr = {button2, button, button3};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (zArr[i]) {
                arrayList.add(buttonArr[i]);
                buttonArr[i].setVisibility(0);
            } else {
                buttonArr[i].setVisibility(8);
            }
        }
        if (arrayList.size() == 3) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                a((Button) arrayList.get(i3), 0, i3 == 2 ? 0 : 20);
                i2 = i3 + 1;
            }
        }
        if (arrayList.size() == 2) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 2) {
                    break;
                }
                a((Button) arrayList.get(i5), 0, i5 == 1 ? 0 : 20);
                i4 = i5 + 1;
            }
        }
        if (arrayList.size() == 1) {
            a((Button) arrayList.get(0), 0, 0);
        }
    }

    private void a(Button button, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = a(this.a, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    public a b() {
        if (!this.p) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.m != null) {
            this.m.show();
        } else {
            this.m = new AlertDialog.Builder(this.a).create();
            this.m.setCanceledOnTouchOutside(this.q);
            if (this.l != null) {
                this.m.setOnCancelListener(this.l);
            }
            this.m.show();
            Window window = this.m.getWindow();
            if (this.b == -1) {
                this.b = 17;
            }
            window.setGravity(this.b);
            window.setLayout(-2, -2);
            window.setContentView(this.n);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bx.a(this.n, false, (bz) new b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public void c() {
        if (this.m != null) {
            this.m.dismiss();
        }
    }

    private int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
