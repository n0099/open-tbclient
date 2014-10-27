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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String AX;
    private String AY;
    private String AZ;
    private String Ba;
    private DialogInterface.OnCancelListener Be;
    private AlertDialog Bf;
    private h Bq;
    private h Br;
    private h Bs;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int AW = -1;
    private int Bn = -1;
    private int Bo = u.btn_blue_bg;
    private int Bp = s.cp_cont_g;
    private boolean Bh = false;
    private boolean Bi = true;

    public e aY(int i) {
        this.Bn = i;
        return this;
    }

    public e aZ(int i) {
        this.Bo = i;
        return this;
    }

    public e ba(int i) {
        this.Bp = i;
        return this;
    }

    public e bb(int i) {
        if (this.mActivity != null) {
            this.AX = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, h hVar) {
        if (this.mActivity != null) {
            this.AY = this.mActivity.getResources().getString(i);
            this.Bq = hVar;
        }
        return this;
    }

    public e b(int i, h hVar) {
        if (this.mActivity != null) {
            this.AZ = this.mActivity.getResources().getString(i);
            this.Br = hVar;
        }
        return this;
    }

    public e R(boolean z) {
        this.Bi = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(activity, w.dialog_icon_bdalert, null);
    }

    public e kX() {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.Bh) {
            this.Bh = true;
            kU();
            TextView textView = (TextView) this.mRootView.findViewById(v.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(v.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(v.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(v.message);
            Button button = (Button) this.mRootView.findViewById(v.yes);
            aw.h((View) button, this.Bo);
            aw.b(button, this.Bp, 3);
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
            if (this.Bn != -1) {
                aw.c(imageView, this.Bn);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.AX)) {
                textView2.setText(this.AX);
            }
            if (TextUtils.isEmpty(this.AY)) {
                z = false;
            } else {
                button.setText(this.AY);
                if (this.Bq != null) {
                    button.setOnClickListener(new g(this, this, this.Bq));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.AZ)) {
                z2 = false;
            } else {
                button2.setText(this.AZ);
                if (this.Br != null) {
                    button2.setOnClickListener(new g(this, this, this.Br));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.Ba)) {
                z3 = false;
            } else {
                button3.setText(this.Ba);
                if (this.Bs != null) {
                    button3.setOnClickListener(new g(this, this, this.Bs));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void kU() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.mActivity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mActivity;
            baseActivity.getLayoutMode().L(skinType == 1);
            baseActivity.getLayoutMode().h(this.mRootView);
        } else if (this.mActivity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mActivity;
            baseFragmentActivity.getLayoutMode().L(skinType == 1);
            baseFragmentActivity.getLayoutMode().h(this.mRootView);
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

    private e S(boolean z) {
        if (!this.Bh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Bf != null) {
            if (z) {
                com.baidu.adp.lib.g.j.a(this.Bf, this.mActivity);
            } else {
                this.Bf.show();
            }
        } else {
            this.Bf = new AlertDialog.Builder(this.mActivity).create();
            this.Bf.setCanceledOnTouchOutside(this.Bi);
            if (this.Be != null) {
                this.Bf.setOnCancelListener(this.Be);
            }
            if (z) {
                com.baidu.adp.lib.g.j.a(this.Bf, this.mActivity);
            } else {
                this.Bf.show();
            }
            Window window = this.Bf.getWindow();
            if (this.AW == -1) {
                this.AW = 17;
            }
            window.setGravity(this.AW);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bn.a(this.mRootView, false, new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e kY() {
        return S(true);
    }

    public void dismiss() {
        if (this.Bf != null) {
            com.baidu.adp.lib.g.j.b(this.Bf, this.mActivity);
        }
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
