package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private b WB;
    private b WC;
    private DialogInterface.OnCancelListener WD;
    private AlertDialog WE;
    private ViewGroup WF;
    private Object WI;
    private TextView WJ;
    private TextView WK;
    private View WL;
    private View WM;
    private String Ww;
    private String Wx;
    private String Wy;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wv = -1;
    private int Wz = -1;
    private int WA = 0;
    private boolean WG = false;
    private boolean WH = true;
    private boolean WN = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cs(String str) {
        this.mTitle = str;
        return this;
    }

    public a bE(int i) {
        cs(this.mActivity.getResources().getString(i));
        return this;
    }

    public a ct(String str) {
        this.Ww = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.WD = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Wx = str;
        this.WB = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Wy = str;
        this.WC = bVar;
        return this;
    }

    public a bF(int i) {
        if (this.mActivity != null) {
            this.Ww = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wx = this.mActivity.getResources().getString(i);
            this.WB = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wy = this.mActivity.getResources().getString(i);
            this.WC = bVar;
        }
        return this;
    }

    public a aj(boolean z) {
        this.WH = z;
        return this;
    }

    public a ak(boolean z) {
        this.WH = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdalert, (ViewGroup) null);
        this.WF = (ViewGroup) this.mRootView.findViewById(i.f.real_view);
    }

    public a bG(int i) {
        if (sW()) {
            this.Wz = al.getColor(i);
        } else {
            this.Wz = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bH(int i) {
        this.WA = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.WG) {
            this.WG = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.dialog_content);
            this.WJ = (TextView) this.mRootView.findViewById(i.f.yes);
            this.WK = (TextView) this.mRootView.findViewById(i.f.no);
            this.WL = this.mRootView.findViewById(i.f.divider_yes_no_button);
            this.WM = this.mRootView.findViewById(i.f.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sS = sS();
                if (sS != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sS);
                }
            }
            c(hVar);
            if (this.Wz != -1) {
                this.WJ.setTextColor(this.Wz);
                this.WK.setTextColor(this.Wz);
            }
            if (TextUtils.isEmpty(this.Wx)) {
                z = false;
            } else {
                this.WJ.setText(this.Wx);
                this.WJ.setTag(this.WI);
                if (this.WB != null) {
                    this.WJ.setOnClickListener(new View$OnClickListenerC0041a(this, this.WB));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wy)) {
                z2 = false;
            } else {
                this.WK.setText(this.Wy);
                if (this.WC != null) {
                    this.WK.setOnClickListener(new View$OnClickListenerC0041a(this, this.WC));
                }
                z2 = true;
            }
            if (this.WA == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, i.d.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.WF.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View sS() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.Ww) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_two_message_view, (ViewGroup) null);
                ((TextView) linearLayout.findViewById(i.f.title_view)).setText(this.mTitle);
                ((TextView) linearLayout.findViewById(i.f.message_view)).setText(this.Ww);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_one_message_view, (ViewGroup) null);
            TextView textView = (TextView) linearLayout2.findViewById(i.f.message_view);
            if (z) {
                textView.setText(this.mTitle);
                return linearLayout2;
            }
            textView.setText(this.Ww);
            return linearLayout2;
        }
        return null;
    }

    private void c(h<?> hVar) {
        int skinType = sW() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().k(this.mContentView);
            }
        }
        this.mRootView.setBackgroundResource(i.e.transparent_bg);
    }

    private void e(boolean z, boolean z2) {
        if (z && z2) {
            this.WL.setVisibility(0);
            this.WM.setVisibility(0);
            return;
        }
        int skinType = sW() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.WL.setVisibility(8);
        if (!z && !z2) {
            this.WJ.setVisibility(8);
            this.WK.setVisibility(8);
            this.WL.setVisibility(8);
        } else if (z) {
            al.c(this.WJ, i.e.dialog_single_button_bg_selector, skinType);
            this.WM.setVisibility(0);
            this.WJ.setVisibility(0);
            this.WK.setVisibility(8);
        } else if (z2) {
            al.c(this.WK, i.e.dialog_single_button_bg_selector, skinType);
            this.WM.setVisibility(0);
            this.WK.setVisibility(0);
            this.WJ.setVisibility(8);
        } else {
            this.WM.setVisibility(8);
            this.WJ.setVisibility(8);
            this.WK.setVisibility(8);
        }
    }

    public a sT() {
        return al(false);
    }

    private a al(boolean z) {
        if (!this.WG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WE != null) {
            if (z) {
                j.a(this.WE, this.mActivity);
            } else {
                this.WE.show();
            }
        } else {
            this.WE = new AlertDialog.Builder(this.mActivity).create();
            this.WE.setCanceledOnTouchOutside(this.WH);
            if (this.WD != null) {
                this.WE.setOnCancelListener(this.WD);
            }
            if (z) {
                j.a(this.WE, this.mActivity);
            } else {
                this.WE.show();
            }
            Window window = this.WE.getWindow();
            if (this.Wv == -1) {
                this.Wv = 17;
            }
            window.setGravity(this.Wv);
            window.setBackgroundDrawableResource(i.e.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.mRootView, false, (bb.a) new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.WE != null) {
            return this.WE.isShowing();
        }
        return false;
    }

    public void am(boolean z) {
        if (this.WJ != null) {
            this.WJ.setClickable(z);
        }
    }

    public void an(boolean z) {
        if (this.WK != null) {
            this.WK.setClickable(z);
        }
    }

    public a sU() {
        return al(true);
    }

    public void dismiss() {
        if (this.WE != null) {
            j.b(this.WE, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0041a implements View.OnClickListener {
        private final a Lt;
        private final b WQ;

        public View$OnClickListenerC0041a(a aVar, b bVar) {
            this.Lt = aVar;
            this.WQ = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.WQ != null) {
                this.WQ.onClick(this.Lt);
            }
        }
    }

    public void x(Object obj) {
        this.WI = obj;
    }

    public Object sV() {
        return this.WI;
    }

    public boolean sW() {
        return this.WN;
    }

    public void ao(boolean z) {
        this.WN = z;
    }

    public Window getWindow() {
        return this.WE.getWindow();
    }
}
