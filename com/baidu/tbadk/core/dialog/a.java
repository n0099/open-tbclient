package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bs;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String Rd;
    private String Re;
    private String Rf;
    private d Rg;
    private d Rh;
    private d Ri;
    private DialogInterface.OnCancelListener Rj;
    private ViewGroup Rk;
    private Object Rn;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Rc = -1;
    private boolean Rl = false;
    private boolean Rm = true;

    public a bZ(String str) {
        this.mTitle = str;
        return this;
    }

    public a bw(int i) {
        bZ(this.mActivity.getResources().getString(i));
        return this;
    }

    public a ca(String str) {
        this.mMessage = str;
        return this;
    }

    public a j(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(String str, d dVar) {
        this.Rd = str;
        this.Rg = dVar;
        return this;
    }

    public a b(String str, d dVar) {
        this.Re = str;
        this.Rh = dVar;
        return this;
    }

    public a c(String str, d dVar) {
        this.Rf = str;
        this.Ri = dVar;
        return this;
    }

    public a bx(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, d dVar) {
        if (this.mActivity != null) {
            this.Rd = this.mActivity.getResources().getString(i);
            this.Rg = dVar;
        }
        return this;
    }

    public a b(int i, d dVar) {
        if (this.mActivity != null) {
            this.Re = this.mActivity.getResources().getString(i);
            this.Rh = dVar;
        }
        return this;
    }

    public a ac(boolean z) {
        this.Rm = z;
        return this;
    }

    public a ad(boolean z) {
        this.Rm = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(activity, w.dialog_bdalert, null);
        this.Rk = (ViewGroup) this.mRootView.findViewById(v.real_view);
    }

    public void a(LinearLayout.LayoutParams layoutParams) {
        if (this.Rk != null) {
            this.Rk.setLayoutParams(layoutParams);
        }
    }

    public a b(j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (!this.Rl) {
            this.Rl = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(v.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(v.content);
            TextView textView2 = (TextView) this.mRootView.findViewById(v.message);
            Button button = (Button) this.mRootView.findViewById(v.yes);
            Button button2 = (Button) this.mRootView.findViewById(v.no);
            Button button3 = (Button) this.mRootView.findViewById(v.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                linearLayout.setBackgroundDrawable(ba.getDrawable(u.bg_dailog));
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Rd)) {
                z = false;
            } else {
                button.setText(this.Rd);
                button.setTag(this.Rn);
                if (this.Rg != null) {
                    button.setOnClickListener(new c(this, this, this.Rg));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Re)) {
                z2 = false;
            } else {
                button2.setText(this.Re);
                if (this.Rh != null) {
                    button2.setOnClickListener(new c(this, this, this.Rh));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Rf)) {
                z3 = false;
            } else {
                button3.setText(this.Rf);
                if (this.Ri != null) {
                    button3.setOnClickListener(new c(this, this, this.Ri));
                }
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this.mRootView);
        } else if (this.mActivity instanceof ActivityProxy) {
            ActivityProxy activityProxy = (ActivityProxy) this.mActivity;
            if (activityProxy.kt() != null && (activityProxy.kt() instanceof ProxyAdkBaseActivity)) {
                ProxyAdkBaseActivity proxyAdkBaseActivity = (ProxyAdkBaseActivity) activityProxy.kt();
                proxyAdkBaseActivity.getLayoutMode().X(skinType == 1);
                proxyAdkBaseActivity.getLayoutMode().h(this.mRootView);
            }
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
        layoutParams.width = b(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    public a rd() {
        return ae(false);
    }

    private a ae(boolean z) {
        if (!this.Rl) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.Rm);
            if (this.Rj != null) {
                this.mDialog.setOnCancelListener(this.Rj);
            }
            if (z) {
                k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Rc == -1) {
                this.Rc = 17;
            }
            window.setGravity(this.Rc);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bs.a(this.mRootView, false, new b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public a re() {
        return ae(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            k.b(this.mDialog, this.mActivity);
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void v(Object obj) {
        this.Rn = obj;
    }

    public Object rf() {
        return this.Rn;
    }
}
