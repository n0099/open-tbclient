package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String Xf;
    private String Xh;
    private String Xi;
    private b Xl;
    private b Xm;
    private DialogInterface.OnCancelListener Xn;
    private AlertDialog Xo;
    private ViewGroup Xp;
    private Object Xs;
    private TextView Xt;
    private TextView Xu;
    private View Xv;
    private View Xw;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Xe = -1;
    private boolean Xg = false;
    private int Xj = -1;
    private int Xk = 0;
    private boolean Xq = false;
    private boolean Xr = true;
    private boolean Xx = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cB(String str) {
        this.mTitle = str;
        return this;
    }

    public a bM(int i) {
        cB(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cC(String str) {
        this.Xf = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Xn = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Xh = str;
        this.Xl = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Xi = str;
        this.Xm = bVar;
        return this;
    }

    public a bN(int i) {
        if (this.mActivity != null) {
            this.Xf = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Xh = this.mActivity.getResources().getString(i);
            this.Xl = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Xi = this.mActivity.getResources().getString(i);
            this.Xm = bVar;
        }
        return this;
    }

    public a al(boolean z) {
        this.Xr = z;
        return this;
    }

    public a am(boolean z) {
        this.Xr = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.g.dialog_bdalert, (ViewGroup) null);
        this.Xp = (ViewGroup) this.mRootView.findViewById(n.f.real_view);
    }

    public a bO(int i) {
        if (ty()) {
            this.Xj = as.getColor(i);
        } else {
            this.Xj = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bP(int i) {
        this.Xk = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.Xq) {
            this.Xq = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(n.f.dialog_content);
            this.Xt = (TextView) this.mRootView.findViewById(n.f.yes);
            this.Xu = (TextView) this.mRootView.findViewById(n.f.no);
            this.Xv = this.mRootView.findViewById(n.f.divider_yes_no_button);
            this.Xw = this.mRootView.findViewById(n.f.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tt = tt();
                if (tt != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tt);
                }
            }
            c(hVar);
            if (this.Xj != -1) {
                this.Xt.setTextColor(this.Xj);
                this.Xu.setTextColor(this.Xj);
            }
            if (TextUtils.isEmpty(this.Xh)) {
                z = false;
            } else {
                this.Xt.setText(this.Xh);
                this.Xt.setTag(this.Xs);
                if (this.Xl != null) {
                    this.Xt.setOnClickListener(new View$OnClickListenerC0042a(this, this.Xl));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Xi)) {
                z2 = false;
            } else {
                this.Xu.setText(this.Xi);
                if (this.Xm != null) {
                    this.Xu.setOnClickListener(new View$OnClickListenerC0042a(this, this.Xm));
                }
                z2 = true;
            }
            if (this.Xk == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, n.d.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.Xp.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View tt() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.Xf) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(n.g.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(n.f.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(n.f.message_view);
                if (this.Xg) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.Xf);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(n.g.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(n.f.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.Xf);
            return linearLayout2;
        }
        return null;
    }

    private void c(h<?> hVar) {
        int skinType = ty() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().k(this.mContentView);
            }
        }
        this.mRootView.setBackgroundResource(n.e.transparent_bg);
    }

    private void e(boolean z, boolean z2) {
        if (z && z2) {
            this.Xv.setVisibility(0);
            this.Xw.setVisibility(0);
            return;
        }
        int skinType = ty() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.Xv.setVisibility(8);
        if (!z && !z2) {
            this.Xt.setVisibility(8);
            this.Xu.setVisibility(8);
            this.Xv.setVisibility(8);
            this.Xw.setVisibility(8);
        } else if (z) {
            as.c(this.Xt, n.e.dialog_single_button_bg_selector, skinType);
            this.Xw.setVisibility(0);
            this.Xt.setVisibility(0);
            this.Xu.setVisibility(8);
        } else if (z2) {
            as.c(this.Xu, n.e.dialog_single_button_bg_selector, skinType);
            this.Xw.setVisibility(0);
            this.Xu.setVisibility(0);
            this.Xt.setVisibility(8);
        } else {
            this.Xw.setVisibility(8);
            this.Xt.setVisibility(8);
            this.Xu.setVisibility(8);
        }
    }

    public a tu() {
        return an(false);
    }

    private a an(boolean z) {
        if (!this.Xq) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Xo != null) {
            if (z) {
                j.a(this.Xo, this.mActivity);
            } else {
                this.Xo.show();
            }
        } else {
            this.Xo = new AlertDialog.Builder(this.mActivity).create();
            this.Xo.setCanceledOnTouchOutside(this.Xr);
            this.Xo.setCancelable(this.Xr);
            if (this.Xn != null) {
                this.Xo.setOnCancelListener(this.Xn);
            }
            if (z) {
                j.a(this.Xo, this.mActivity);
            } else {
                this.Xo.show();
            }
            Window window = this.Xo.getWindow();
            if (this.Xe == -1) {
                this.Xe = 17;
            }
            window.setGravity(this.Xe);
            window.setBackgroundDrawableResource(n.e.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bj.a(this.mRootView, false, (bj.a) new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.Xo != null) {
            return this.Xo.isShowing();
        }
        return false;
    }

    public void ao(boolean z) {
        if (this.Xt != null) {
            this.Xt.setClickable(z);
        }
    }

    public void ap(boolean z) {
        if (this.Xu != null) {
            this.Xu.setClickable(z);
        }
    }

    public a tv() {
        return an(true);
    }

    public void hide() {
        if (this.Xo != null) {
            this.Xo.hide();
        }
    }

    public void dismiss() {
        if (this.Xo != null) {
            j.b(this.Xo, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0042a implements View.OnClickListener {
        private final a LN;
        private final b XA;

        public View$OnClickListenerC0042a(a aVar, b bVar) {
            this.LN = aVar;
            this.XA = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.XA != null) {
                this.XA.onClick(this.LN);
            }
        }
    }

    public ViewGroup tw() {
        return this.Xp;
    }

    public void x(Object obj) {
        this.Xs = obj;
    }

    public Object tx() {
        return this.Xs;
    }

    public boolean ty() {
        return this.Xx;
    }

    public void aq(boolean z) {
        this.Xx = z;
    }

    public Window getWindow() {
        return this.Xo.getWindow();
    }

    public Dialog getDialog() {
        return this.Xo;
    }

    public void ar(boolean z) {
        this.Xg = z;
    }
}
