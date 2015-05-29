package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.util.bs;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private d RC;
    private d RE;
    private DialogInterface.OnCancelListener RF;
    private ViewGroup RG;
    private Object RJ;
    private TextView RK;
    private TextView RL;
    private View RM;
    private String Ry;
    private String Rz;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Rx = -1;
    private int RA = -1;
    private int RB = 0;
    private boolean RH = false;
    private boolean RI = true;

    public a cm(String str) {
        this.mTitle = str;
        return this;
    }

    public a bt(int i) {
        cm(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cn(String str) {
        this.mMessage = str;
        return this;
    }

    public a l(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.RF = onCancelListener;
        return this;
    }

    public a a(String str, d dVar) {
        this.Ry = str;
        this.RC = dVar;
        return this;
    }

    public a b(String str, d dVar) {
        this.Rz = str;
        this.RE = dVar;
        return this;
    }

    public a bu(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, d dVar) {
        if (this.mActivity != null) {
            this.Ry = this.mActivity.getResources().getString(i);
            this.RC = dVar;
        }
        return this;
    }

    public a b(int i, d dVar) {
        if (this.mActivity != null) {
            this.Rz = this.mActivity.getResources().getString(i);
            this.RE = dVar;
        }
        return this;
    }

    public a ag(boolean z) {
        this.RI = z;
        return this;
    }

    public a ah(boolean z) {
        this.RI = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hr().inflate(activity, r.dialog_bdalert, null);
        this.RG = (ViewGroup) this.mRootView.findViewById(q.real_view);
    }

    public a bv(int i) {
        this.RA = ay.getColor(i);
        return this;
    }

    public a bw(int i) {
        this.RB = i;
        return this;
    }

    public a b(com.baidu.adp.base.j<?> jVar) {
        boolean z;
        boolean z2;
        if (!this.RH) {
            this.RH = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(q.content);
            this.RK = (TextView) this.mRootView.findViewById(q.yes);
            this.RL = (TextView) this.mRootView.findViewById(q.no);
            this.RM = this.mRootView.findViewById(q.divider_yes_no_button);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View rJ = rJ();
                if (rJ != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(rJ);
                }
            }
            c(jVar);
            if (this.RA != -1) {
                this.RK.setTextColor(this.RA);
                this.RL.setTextColor(this.RA);
            }
            if (TextUtils.isEmpty(this.Ry)) {
                z = false;
            } else {
                this.RK.setText(this.Ry);
                this.RK.setTag(this.RJ);
                if (this.RC != null) {
                    this.RK.setOnClickListener(new c(this, this, this.RC));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Rz)) {
                z2 = false;
            } else {
                this.RL.setText(this.Rz);
                if (this.RE != null) {
                    this.RL.setOnClickListener(new c(this, this, this.RE));
                }
                z2 = true;
            }
            if (this.RB == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = n.d(this.mActivity, o.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.RG.setLayoutParams(layoutParams);
            }
            b(z, z2);
        }
        return this;
    }

    public View rJ() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(this.mActivity, r.bdalert_two_message_view, null);
                ((TextView) linearLayout.findViewById(q.title_view)).setText(this.mTitle);
                ((TextView) linearLayout.findViewById(q.message_view)).setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(this.mActivity, r.bdalert_one_message_view, null);
            TextView textView = (TextView) linearLayout2.findViewById(q.message_view);
            if (z) {
                textView.setText(this.mTitle);
                return linearLayout2;
            }
            textView.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    private void c(com.baidu.adp.base.j<?> jVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) jVar).getLayoutMode().j(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) jVar).getLayoutMode().j(this.mContentView);
            }
        } else if (this.mActivity instanceof ActivityProxy) {
            ActivityProxy activityProxy = (ActivityProxy) this.mActivity;
            if (activityProxy.kN() != null && (activityProxy.kN() instanceof ProxyAdkBaseActivity)) {
                ProxyAdkBaseActivity proxyAdkBaseActivity = (ProxyAdkBaseActivity) activityProxy.kN();
                proxyAdkBaseActivity.getLayoutMode().ab(skinType == 1);
                proxyAdkBaseActivity.getLayoutMode().j(this.mRootView);
                if (this.mContentView != null) {
                    proxyAdkBaseActivity.getLayoutMode().j(this.mContentView);
                }
            }
        }
        this.mRootView.setBackgroundResource(p.transparent_bg);
    }

    private void b(boolean z, boolean z2) {
        if (z && z2) {
            this.RM.setVisibility(0);
            return;
        }
        this.RM.setVisibility(8);
        if (z) {
            ay.i((View) this.RK, p.dialog_single_button_bg_selector);
            this.RK.setVisibility(0);
            this.RL.setVisibility(8);
        } else if (z2) {
            ay.i((View) this.RL, p.dialog_single_button_bg_selector);
            this.RL.setVisibility(0);
            this.RK.setVisibility(8);
        }
    }

    public a rK() {
        return ai(false);
    }

    private a ai(boolean z) {
        if (!this.RH) {
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
            this.mDialog.setCanceledOnTouchOutside(this.RI);
            if (this.RF != null) {
                this.mDialog.setOnCancelListener(this.RF);
            }
            if (z) {
                com.baidu.adp.lib.g.k.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.Rx == -1) {
                this.Rx = 17;
            }
            window.setGravity(this.Rx);
            window.setBackgroundDrawableResource(p.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bq.a(this.mRootView, false, (bs) new b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public void aj(boolean z) {
        if (this.RK != null) {
            this.RK.setClickable(z);
        }
    }

    public void ak(boolean z) {
        if (this.RL != null) {
            this.RL.setClickable(z);
        }
    }

    public a rL() {
        return ai(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mDialog, this.mActivity);
        }
    }

    public void v(Object obj) {
        this.RJ = obj;
    }

    public Object rM() {
        return this.RJ;
    }
}
