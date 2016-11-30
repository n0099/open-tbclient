package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String VY;
    private String VZ;
    private b Wc;
    private b Wd;
    private DialogInterface.OnCancelListener We;
    private DialogInterface.OnKeyListener Wf;
    private AlertDialog Wg;
    private final ViewGroup Wh;
    private ViewGroup Wi;
    private Object Wl;
    private TextView Wm;
    private TextView Wn;
    private View Wo;
    private View Wp;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int VV = -1;
    private boolean VW = false;
    private boolean VX = false;
    private int Wa = -1;
    private int Wb = 0;
    private boolean Wj = false;
    private boolean Wk = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cE(String str) {
        this.mTitle = str;
        return this;
    }

    public a bZ(int i) {
        cE(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cF(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.We = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.VY = str;
        this.Wc = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.VZ = str;
        this.Wd = bVar;
        return this;
    }

    public a ca(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.VY = this.mActivity.getResources().getString(i);
            this.Wc = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.VZ = this.mActivity.getResources().getString(i);
            this.Wd = bVar;
        }
        return this;
    }

    public a at(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a au(boolean z) {
        this.Wk = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.Wh = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdalert, (ViewGroup) null);
        this.Wi = (ViewGroup) this.Wh.findViewById(r.g.real_view);
    }

    public a cb(int i) {
        if (isAutoNight()) {
            this.Wa = at.getColor(i);
        } else {
            this.Wa = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cc(int i) {
        this.Wb = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.Wj) {
            this.Wj = true;
            LinearLayout linearLayout = (LinearLayout) this.Wh.findViewById(r.g.dialog_content);
            this.Wm = (TextView) this.Wh.findViewById(r.g.yes);
            this.Wn = (TextView) this.Wh.findViewById(r.g.no);
            this.Wo = this.Wh.findViewById(r.g.divider_yes_no_button);
            this.Wp = this.Wh.findViewById(r.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tn = tn();
                if (tn != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tn);
                }
            }
            c(hVar);
            if (this.Wa != -1) {
                if (this.Wm != null) {
                    this.Wm.setTextColor(this.Wa);
                }
                if (this.Wn != null) {
                    this.Wn.setTextColor(this.Wa);
                }
            }
            if (TextUtils.isEmpty(this.VY) || this.Wm == null) {
                z = false;
            } else {
                this.Wm.setText(this.VY);
                this.Wm.setTag(this.Wl);
                if (this.Wc != null) {
                    this.Wm.setOnClickListener(new View$OnClickListenerC0035a(this, this.Wc));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.VZ) || this.Wn == null) {
                z2 = false;
            } else {
                this.Wn.setText(this.VZ);
                if (this.Wd != null) {
                    this.Wn.setOnClickListener(new View$OnClickListenerC0035a(this, this.Wd));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View tn() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(r.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(r.g.message_view);
                if (this.VW) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.VX) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(r.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wh);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        if (this.Wh != null) {
            this.Wh.setBackgroundResource(r.f.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.Wo != null) {
                this.Wo.setVisibility(0);
            }
            if (this.Wp != null) {
                this.Wp.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.Wo != null) {
            this.Wo.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.Wm != null && this.Wn != null && this.Wo != null && this.Wp != null) {
                this.Wm.setVisibility(8);
                this.Wn.setVisibility(8);
                this.Wo.setVisibility(8);
                this.Wp.setVisibility(8);
            }
        } else if (z) {
            at.d(this.Wm, r.f.dialog_single_button_bg_selector, skinType);
            if (this.Wn != null && this.Wo != null && this.Wp != null) {
                this.Wp.setVisibility(0);
                this.Wm.setVisibility(0);
                this.Wn.setVisibility(8);
            }
        } else if (z2) {
            at.d(this.Wn, r.f.dialog_single_button_bg_selector, skinType);
            if (this.Wm != null && this.Wo != null && this.Wp != null) {
                this.Wp.setVisibility(0);
                this.Wn.setVisibility(0);
                this.Wm.setVisibility(8);
            }
        } else if (this.Wm != null && this.Wn != null && this.Wp != null) {
            this.Wp.setVisibility(8);
            this.Wm.setVisibility(8);
            this.Wn.setVisibility(8);
        }
    }

    public a to() {
        return av(false);
    }

    private a av(boolean z) {
        if (!this.Wj) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wg != null) {
            if (z) {
                j.a(this.Wg, this.mActivity);
            } else {
                this.Wg.show();
            }
        } else {
            this.Wg = new AlertDialog.Builder(this.mActivity).create();
            this.Wg.setCanceledOnTouchOutside(this.Wk && !this.mCancelable);
            this.Wg.setCancelable(this.mCancelable);
            this.Wg.setOnKeyListener(this.Wf);
            if (this.We != null) {
                this.Wg.setOnCancelListener(this.We);
            }
            if (z) {
                j.a(this.Wg, this.mActivity);
            } else {
                this.Wg.show();
            }
            if (this.Wg.getWindow().getDecorView().getParent() != null) {
                Window window = this.Wg.getWindow();
                if (this.VV == -1) {
                    this.VV = 17;
                }
                window.setGravity(this.VV);
                window.setBackgroundDrawableResource(r.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    attributes.width = n.widthPixels - (tp() * 2);
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.Wh);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bk.a(this.Wh, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tp() {
        return this.Wb == 1 ? k.e(this.mActivity, r.e.ds40) : k.e(this.mActivity, r.e.ds90);
    }

    public boolean isShowing() {
        if (this.Wg != null) {
            return this.Wg.isShowing();
        }
        return false;
    }

    public void aw(boolean z) {
        if (this.Wm != null) {
            this.Wm.setClickable(z);
        }
    }

    public void ax(boolean z) {
        if (this.Wn != null) {
            this.Wn.setClickable(z);
        }
    }

    public a tq() {
        return av(true);
    }

    public void hide() {
        if (this.Wg != null) {
            this.Wg.hide();
        }
    }

    public void dismiss() {
        if (this.Wg != null) {
            j.b(this.Wg, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a FF;
        private final b Ws;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.FF = aVar;
            this.Ws = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Ws != null) {
                this.Ws.onClick(this.FF);
            }
        }
    }

    public ViewGroup tr() {
        return this.Wi;
    }

    public void A(Object obj) {
        this.Wl = obj;
    }

    public Object ts() {
        return this.Wl;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.Wg.getWindow();
    }

    public Dialog getDialog() {
        return this.Wg;
    }

    public void ay(boolean z) {
        this.VW = z;
    }

    public void az(boolean z) {
        this.VX = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.Wf = onKeyListener;
    }

    public void reset() {
        this.Wj = false;
    }
}
