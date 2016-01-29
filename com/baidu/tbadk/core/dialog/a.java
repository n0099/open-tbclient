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
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String XT;
    private String XW;
    private String XX;
    private b Ya;
    private b Yb;
    private DialogInterface.OnCancelListener Yc;
    private AlertDialog Yd;
    private final ViewGroup Ye;
    private ViewGroup Yf;
    private Object Yi;
    private TextView Yj;
    private TextView Yk;
    private View Yl;
    private View Ym;
    protected final Activity mActivity;
    private View mContentView;
    private String mTitle;
    private int XS = -1;
    private boolean XU = false;
    private boolean XV = false;
    private int XY = -1;
    private int XZ = 0;
    private boolean Yg = false;
    private boolean Yh = true;
    private boolean Yn = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    public a cD(String str) {
        this.mTitle = str;
        return this;
    }

    public a bX(int i) {
        cD(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cE(String str) {
        this.XT = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Yc = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.XW = str;
        this.Ya = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.XX = str;
        this.Yb = bVar;
        return this;
    }

    public a bY(int i) {
        if (this.mActivity != null) {
            this.XT = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.XW = this.mActivity.getResources().getString(i);
            this.Ya = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.XX = this.mActivity.getResources().getString(i);
            this.Yb = bVar;
        }
        return this;
    }

    public a aj(boolean z) {
        this.Yh = z;
        return this;
    }

    public a ak(boolean z) {
        this.Yh = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.Ye = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdalert, (ViewGroup) null);
        this.Yf = (ViewGroup) this.Ye.findViewById(t.g.real_view);
    }

    public a bZ(int i) {
        if (um()) {
            this.XY = ar.getColor(i);
        } else {
            this.XY = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ca(int i) {
        this.XZ = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.Yg) {
            this.Yg = true;
            LinearLayout linearLayout = (LinearLayout) this.Ye.findViewById(t.g.dialog_content);
            this.Yj = (TextView) this.Ye.findViewById(t.g.yes);
            this.Yk = (TextView) this.Ye.findViewById(t.g.no);
            this.Yl = this.Ye.findViewById(t.g.divider_yes_no_button);
            this.Ym = this.Ye.findViewById(t.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View uh = uh();
                if (uh != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(uh);
                }
            }
            c(hVar);
            if (this.XY != -1) {
                this.Yj.setTextColor(this.XY);
                this.Yk.setTextColor(this.XY);
            }
            if (TextUtils.isEmpty(this.XW)) {
                z = false;
            } else {
                this.Yj.setText(this.XW);
                this.Yj.setTag(this.Yi);
                if (this.Ya != null) {
                    this.Yj.setOnClickListener(new View$OnClickListenerC0043a(this, this.Ya));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.XX)) {
                z2 = false;
            } else {
                this.Yk.setText(this.XX);
                if (this.Yb != null) {
                    this.Yk.setOnClickListener(new View$OnClickListenerC0043a(this, this.Yb));
                }
                z2 = true;
            }
            if (this.XZ == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int c = k.c(this.mActivity, t.e.ds40);
                layoutParams.setMargins(c, 0, c, 0);
                this.Yf.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View uh() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.XT) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(t.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(t.g.message_view);
                if (this.XU) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.XV) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.XT);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(t.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.XT);
            return linearLayout2;
        }
        return null;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = um() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Ye);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        this.Ye.setBackgroundResource(t.f.transparent_bg);
    }

    private void e(boolean z, boolean z2) {
        if (z && z2) {
            this.Yl.setVisibility(0);
            this.Ym.setVisibility(0);
            return;
        }
        int skinType = um() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.Yl.setVisibility(8);
        if (!z && !z2) {
            this.Yj.setVisibility(8);
            this.Yk.setVisibility(8);
            this.Yl.setVisibility(8);
            this.Ym.setVisibility(8);
        } else if (z) {
            ar.c(this.Yj, t.f.dialog_single_button_bg_selector, skinType);
            this.Ym.setVisibility(0);
            this.Yj.setVisibility(0);
            this.Yk.setVisibility(8);
        } else if (z2) {
            ar.c(this.Yk, t.f.dialog_single_button_bg_selector, skinType);
            this.Ym.setVisibility(0);
            this.Yk.setVisibility(0);
            this.Yj.setVisibility(8);
        } else {
            this.Ym.setVisibility(8);
            this.Yj.setVisibility(8);
            this.Yk.setVisibility(8);
        }
    }

    public a ui() {
        return al(false);
    }

    private a al(boolean z) {
        if (!this.Yg) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Yd != null) {
            if (z) {
                j.a(this.Yd, this.mActivity);
            } else {
                this.Yd.show();
            }
        } else {
            this.Yd = new AlertDialog.Builder(this.mActivity).create();
            this.Yd.setCanceledOnTouchOutside(this.Yh);
            this.Yd.setCancelable(this.Yh);
            if (this.Yc != null) {
                this.Yd.setOnCancelListener(this.Yc);
            }
            if (z) {
                j.a(this.Yd, this.mActivity);
            } else {
                this.Yd.show();
            }
            Window window = this.Yd.getWindow();
            if (this.XS == -1) {
                this.XS = 17;
            }
            window.setGravity(this.XS);
            window.setBackgroundDrawableResource(t.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.Ye);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bi.a(this.Ye, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.Yd != null) {
            return this.Yd.isShowing();
        }
        return false;
    }

    public void am(boolean z) {
        if (this.Yj != null) {
            this.Yj.setClickable(z);
        }
    }

    public void an(boolean z) {
        if (this.Yk != null) {
            this.Yk.setClickable(z);
        }
    }

    public a uj() {
        return al(true);
    }

    public void hide() {
        if (this.Yd != null) {
            this.Yd.hide();
        }
    }

    public void dismiss() {
        if (this.Yd != null) {
            j.b(this.Yd, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0043a implements View.OnClickListener {
        private final a Ms;
        private final b Yq;

        public View$OnClickListenerC0043a(a aVar, b bVar) {
            this.Ms = aVar;
            this.Yq = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Yq != null) {
                this.Yq.a(this.Ms);
            }
        }
    }

    public ViewGroup uk() {
        return this.Yf;
    }

    public void x(Object obj) {
        this.Yi = obj;
    }

    public Object ul() {
        return this.Yi;
    }

    public boolean um() {
        return this.Yn;
    }

    public void ao(boolean z) {
        this.Yn = z;
    }

    public Window getWindow() {
        return this.Yd.getWindow();
    }

    public Dialog getDialog() {
        return this.Yd;
    }

    public void ap(boolean z) {
        this.XU = z;
    }
}
