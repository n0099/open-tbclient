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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bu;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private h FG;
    private h FH;
    private h FI;
    private DialogInterface.OnKeyListener FJ;
    private String Fp;
    private String Fq;
    private String Fr;
    private DialogInterface.OnCancelListener Fv;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Fo = -1;
    private int FD = -1;
    private int FE = v.btn_blue_bg;
    private int FF = t.cp_cont_g;
    private boolean Fx = false;
    private boolean Fy = true;

    public e bz(int i) {
        this.FD = i;
        return this;
    }

    public e bA(int i) {
        this.FE = i;
        return this;
    }

    public e bB(int i) {
        this.FF = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.FJ = onKeyListener;
        return this;
    }

    public e bC(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, h hVar) {
        if (this.mActivity != null) {
            this.Fp = this.mActivity.getResources().getString(i);
            this.FG = hVar;
        }
        return this;
    }

    public e b(int i, h hVar) {
        if (this.mActivity != null) {
            this.Fq = this.mActivity.getResources().getString(i);
            this.FH = hVar;
        }
        return this;
    }

    public e ak(boolean z) {
        this.Fy = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ei().inflate(activity, x.dialog_icon_bdalert, null);
    }

    public e d(com.baidu.adp.base.j<?> jVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Fx) {
            this.Fx = true;
            c(jVar);
            TextView textView = (TextView) this.mRootView.findViewById(w.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(w.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(w.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(w.message);
            Button button = (Button) this.mRootView.findViewById(w.yes);
            bc.i((View) button, this.FE);
            bc.b(button, this.FF, 3);
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
            if (this.FD != -1) {
                bc.c(imageView, this.FD);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.Fp)) {
                z = false;
            } else {
                button.setText(this.Fp);
                if (this.FG != null) {
                    button.setOnClickListener(new g(this, this, this.FG));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Fq)) {
                z2 = false;
            } else {
                button2.setText(this.Fq);
                if (this.FH != null) {
                    button2.setOnClickListener(new g(this, this, this.FH));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Fr)) {
                z3 = false;
            } else {
                button3.setText(this.Fr);
                if (this.FI != null) {
                    button3.setOnClickListener(new g(this, this, this.FI));
                }
                z3 = true;
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

    private e al(boolean z) {
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
            if (this.FJ != null) {
                this.mDialog.setOnKeyListener(this.FJ);
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
            bu.a(this.mRootView, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e nY() {
        return al(true);
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
