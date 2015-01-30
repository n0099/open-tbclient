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
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bu;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String Fp;
    private String Fq;
    private String Fr;
    private d Fs;
    private d Ft;
    private d Fu;
    private DialogInterface.OnCancelListener Fv;
    private ViewGroup Fw;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Fo = -1;
    private boolean Fx = false;
    private boolean Fy = true;

    public a bV(String str) {
        this.mTitle = str;
        return this;
    }

    public a bx(int i) {
        bV(this.mActivity.getResources().getString(i));
        return this;
    }

    public a bW(String str) {
        this.mMessage = str;
        return this;
    }

    public a j(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(String str, d dVar) {
        this.Fp = str;
        this.Fs = dVar;
        return this;
    }

    public a b(String str, d dVar) {
        this.Fq = str;
        this.Ft = dVar;
        return this;
    }

    public a c(String str, d dVar) {
        this.Fr = str;
        this.Fu = dVar;
        return this;
    }

    public a by(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, d dVar) {
        if (this.mActivity != null) {
            this.Fp = this.mActivity.getResources().getString(i);
            this.Fs = dVar;
        }
        return this;
    }

    public a b(int i, d dVar) {
        if (this.mActivity != null) {
            this.Fq = this.mActivity.getResources().getString(i);
            this.Ft = dVar;
        }
        return this;
    }

    public a ah(boolean z) {
        this.Fy = z;
        return this;
    }

    public a ai(boolean z) {
        this.Fy = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ei().inflate(activity, x.dialog_bdalert, null);
        this.Fw = (ViewGroup) this.mRootView.findViewById(w.real_view);
    }

    public void a(LinearLayout.LayoutParams layoutParams) {
        if (this.Fw != null) {
            this.Fw.setLayoutParams(layoutParams);
        }
    }

    public a b(com.baidu.adp.base.j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (!this.Fx) {
            this.Fx = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(w.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(w.content);
            TextView textView2 = (TextView) this.mRootView.findViewById(w.message);
            Button button = (Button) this.mRootView.findViewById(w.yes);
            Button button2 = (Button) this.mRootView.findViewById(w.no);
            Button button3 = (Button) this.mRootView.findViewById(w.cancel);
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
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Fp)) {
                z = false;
            } else {
                button.setText(this.Fp);
                if (this.Fs != null) {
                    button.setOnClickListener(new c(this, this, this.Fs));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Fq)) {
                z2 = false;
            } else {
                button2.setText(this.Fq);
                if (this.Ft != null) {
                    button2.setOnClickListener(new c(this, this, this.Ft));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Fr)) {
                z3 = false;
            } else {
                button3.setText(this.Fr);
                if (this.Fu != null) {
                    button3.setOnClickListener(new c(this, this, this.Fu));
                }
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this.mRootView);
        } else if (this.mActivity instanceof ActivityProxy) {
            ActivityProxy activityProxy = (ActivityProxy) this.mActivity;
            if (activityProxy.hg() != null && (activityProxy.hg() instanceof ProxyAdkBaseActivity)) {
                ProxyAdkBaseActivity proxyAdkBaseActivity = (ProxyAdkBaseActivity) activityProxy.hg();
                proxyAdkBaseActivity.getLayoutMode().ab(skinType == 1);
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

    public a nW() {
        return aj(false);
    }

    private a aj(boolean z) {
        if (!this.Fx) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.Fy);
            if (this.Fv != null) {
                this.mDialog.setOnCancelListener(this.Fv);
            }
            if (z) {
                com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Fo == -1) {
                this.Fo = 17;
            }
            window.setGravity(this.Fo);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bu.a(this.mRootView, false, new b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public a nX() {
        return aj(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mDialog, this.mActivity);
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
