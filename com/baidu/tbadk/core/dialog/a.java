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
    private String XH;
    private String XK;
    private String XL;
    private b XO;
    private b XP;
    private DialogInterface.OnCancelListener XQ;
    private AlertDialog XR;
    private ViewGroup XS;
    private Object XV;
    private TextView XW;
    private TextView XX;
    private View XY;
    private View XZ;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int XG = -1;
    private boolean XI = false;
    private boolean XJ = false;
    private int XM = -1;
    private int XN = 0;
    private boolean XT = false;
    private boolean XU = true;
    private boolean Ya = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cE(String str) {
        this.mTitle = str;
        return this;
    }

    public a bF(int i) {
        cE(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cF(String str) {
        this.XH = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.XQ = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.XK = str;
        this.XO = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.XL = str;
        this.XP = bVar;
        return this;
    }

    public a bG(int i) {
        if (this.mActivity != null) {
            this.XH = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.XK = this.mActivity.getResources().getString(i);
            this.XO = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.XL = this.mActivity.getResources().getString(i);
            this.XP = bVar;
        }
        return this;
    }

    public a ai(boolean z) {
        this.XU = z;
        return this;
    }

    public a aj(boolean z) {
        this.XU = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(n.h.dialog_bdalert, (ViewGroup) null);
        this.XS = (ViewGroup) this.mRootView.findViewById(n.g.real_view);
    }

    public a bH(int i) {
        if (ti()) {
            this.XM = as.getColor(i);
        } else {
            this.XM = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bI(int i) {
        this.XN = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.XT) {
            this.XT = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(n.g.dialog_content);
            this.XW = (TextView) this.mRootView.findViewById(n.g.yes);
            this.XX = (TextView) this.mRootView.findViewById(n.g.no);
            this.XY = this.mRootView.findViewById(n.g.divider_yes_no_button);
            this.XZ = this.mRootView.findViewById(n.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View td = td();
                if (td != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(td);
                }
            }
            c(hVar);
            if (this.XM != -1) {
                this.XW.setTextColor(this.XM);
                this.XX.setTextColor(this.XM);
            }
            if (TextUtils.isEmpty(this.XK)) {
                z = false;
            } else {
                this.XW.setText(this.XK);
                this.XW.setTag(this.XV);
                if (this.XO != null) {
                    this.XW.setOnClickListener(new View$OnClickListenerC0042a(this, this.XO));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.XL)) {
                z2 = false;
            } else {
                this.XX.setText(this.XL);
                if (this.XP != null) {
                    this.XX.setOnClickListener(new View$OnClickListenerC0042a(this, this.XP));
                }
                z2 = true;
            }
            if (this.XN == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, n.e.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.XS.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View td() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.XH) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(n.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(n.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(n.g.message_view);
                if (this.XI) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.XJ) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.XH);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(n.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(n.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.XH);
            return linearLayout2;
        }
        return null;
    }

    private void c(h<?> hVar) {
        int skinType = ti() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ac(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().k(this.mContentView);
            }
        }
        this.mRootView.setBackgroundResource(n.f.transparent_bg);
    }

    private void e(boolean z, boolean z2) {
        if (z && z2) {
            this.XY.setVisibility(0);
            this.XZ.setVisibility(0);
            return;
        }
        int skinType = ti() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.XY.setVisibility(8);
        if (!z && !z2) {
            this.XW.setVisibility(8);
            this.XX.setVisibility(8);
            this.XY.setVisibility(8);
            this.XZ.setVisibility(8);
        } else if (z) {
            as.c(this.XW, n.f.dialog_single_button_bg_selector, skinType);
            this.XZ.setVisibility(0);
            this.XW.setVisibility(0);
            this.XX.setVisibility(8);
        } else if (z2) {
            as.c(this.XX, n.f.dialog_single_button_bg_selector, skinType);
            this.XZ.setVisibility(0);
            this.XX.setVisibility(0);
            this.XW.setVisibility(8);
        } else {
            this.XZ.setVisibility(8);
            this.XW.setVisibility(8);
            this.XX.setVisibility(8);
        }
    }

    public a te() {
        return ak(false);
    }

    private a ak(boolean z) {
        if (!this.XT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.XR != null) {
            if (z) {
                j.a(this.XR, this.mActivity);
            } else {
                this.XR.show();
            }
        } else {
            this.XR = new AlertDialog.Builder(this.mActivity).create();
            this.XR.setCanceledOnTouchOutside(this.XU);
            this.XR.setCancelable(this.XU);
            if (this.XQ != null) {
                this.XR.setOnCancelListener(this.XQ);
            }
            if (z) {
                j.a(this.XR, this.mActivity);
            } else {
                this.XR.show();
            }
            Window window = this.XR.getWindow();
            if (this.XG == -1) {
                this.XG = 17;
            }
            window.setGravity(this.XG);
            window.setBackgroundDrawableResource(n.f.transparent_bg);
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
        if (this.XR != null) {
            return this.XR.isShowing();
        }
        return false;
    }

    public void al(boolean z) {
        if (this.XW != null) {
            this.XW.setClickable(z);
        }
    }

    public void am(boolean z) {
        if (this.XX != null) {
            this.XX.setClickable(z);
        }
    }

    public a tf() {
        return ak(true);
    }

    public void hide() {
        if (this.XR != null) {
            this.XR.hide();
        }
    }

    public void dismiss() {
        if (this.XR != null) {
            j.b(this.XR, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0042a implements View.OnClickListener {
        private final a Md;
        private final b Yd;

        public View$OnClickListenerC0042a(a aVar, b bVar) {
            this.Md = aVar;
            this.Yd = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Yd != null) {
                this.Yd.onClick(this.Md);
            }
        }
    }

    public ViewGroup tg() {
        return this.XS;
    }

    public void x(Object obj) {
        this.XV = obj;
    }

    public Object th() {
        return this.XV;
    }

    public boolean ti() {
        return this.Ya;
    }

    public void an(boolean z) {
        this.Ya = z;
    }

    public Window getWindow() {
        return this.XR.getWindow();
    }

    public Dialog getDialog() {
        return this.XR;
    }

    public void ao(boolean z) {
        this.XI = z;
    }
}
