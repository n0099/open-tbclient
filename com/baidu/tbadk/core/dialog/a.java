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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.i;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private Object WA;
    private TextView WB;
    private TextView WC;
    private View WD;
    private View WE;
    private String Wo;
    private String Wp;
    private String Wq;
    private b Wt;
    private b Wu;
    private DialogInterface.OnCancelListener Wv;
    private AlertDialog Ww;
    private ViewGroup Wx;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wn = -1;
    private int Wr = -1;
    private int Ws = 0;
    private boolean Wy = false;
    private boolean Wz = true;
    private boolean WF = true;

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
        this.Wo = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Wv = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Wp = str;
        this.Wt = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Wq = str;
        this.Wu = bVar;
        return this;
    }

    public a bF(int i) {
        if (this.mActivity != null) {
            this.Wo = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wp = this.mActivity.getResources().getString(i);
            this.Wt = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
            this.Wu = bVar;
        }
        return this;
    }

    public a aj(boolean z) {
        this.Wz = z;
        return this;
    }

    public a ak(boolean z) {
        this.Wz = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdalert, (ViewGroup) null);
        this.Wx = (ViewGroup) this.mRootView.findViewById(i.f.real_view);
    }

    public a bG(int i) {
        if (sT()) {
            this.Wr = am.getColor(i);
        } else {
            this.Wr = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bH(int i) {
        this.Ws = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.Wy) {
            this.Wy = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.dialog_content);
            this.WB = (TextView) this.mRootView.findViewById(i.f.yes);
            this.WC = (TextView) this.mRootView.findViewById(i.f.no);
            this.WD = this.mRootView.findViewById(i.f.divider_yes_no_button);
            this.WE = this.mRootView.findViewById(i.f.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sP = sP();
                if (sP != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sP);
                }
            }
            c(hVar);
            if (this.Wr != -1) {
                this.WB.setTextColor(this.Wr);
                this.WC.setTextColor(this.Wr);
            }
            if (TextUtils.isEmpty(this.Wp)) {
                z = false;
            } else {
                this.WB.setText(this.Wp);
                this.WB.setTag(this.WA);
                if (this.Wt != null) {
                    this.WB.setOnClickListener(new View$OnClickListenerC0041a(this, this.Wt));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wq)) {
                z2 = false;
            } else {
                this.WC.setText(this.Wq);
                if (this.Wu != null) {
                    this.WC.setOnClickListener(new View$OnClickListenerC0041a(this, this.Wu));
                }
                z2 = true;
            }
            if (this.Ws == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, i.d.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.Wx.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View sP() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.Wo) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_two_message_view, (ViewGroup) null);
                ((TextView) linearLayout.findViewById(i.f.title_view)).setText(this.mTitle);
                ((TextView) linearLayout.findViewById(i.f.message_view)).setText(this.Wo);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_one_message_view, (ViewGroup) null);
            TextView textView = (TextView) linearLayout2.findViewById(i.f.message_view);
            if (z) {
                textView.setText(this.mTitle);
                return linearLayout2;
            }
            textView.setText(this.Wo);
            return linearLayout2;
        }
        return null;
    }

    private void c(h<?> hVar) {
        int skinType = sT() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
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
            this.WD.setVisibility(0);
            this.WE.setVisibility(0);
            return;
        }
        int skinType = sT() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.WD.setVisibility(8);
        if (!z && !z2) {
            this.WB.setVisibility(8);
            this.WC.setVisibility(8);
            this.WD.setVisibility(8);
        } else if (z) {
            am.c(this.WB, i.e.dialog_single_button_bg_selector, skinType);
            this.WE.setVisibility(0);
            this.WB.setVisibility(0);
            this.WC.setVisibility(8);
        } else if (z2) {
            am.c(this.WC, i.e.dialog_single_button_bg_selector, skinType);
            this.WE.setVisibility(0);
            this.WC.setVisibility(0);
            this.WB.setVisibility(8);
        } else {
            this.WE.setVisibility(8);
            this.WB.setVisibility(8);
            this.WC.setVisibility(8);
        }
    }

    public a sQ() {
        return al(false);
    }

    private a al(boolean z) {
        if (!this.Wy) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Ww != null) {
            if (z) {
                j.a(this.Ww, this.mActivity);
            } else {
                this.Ww.show();
            }
        } else {
            this.Ww = new AlertDialog.Builder(this.mActivity).create();
            this.Ww.setCanceledOnTouchOutside(this.Wz);
            if (this.Wv != null) {
                this.Ww.setOnCancelListener(this.Wv);
            }
            if (z) {
                j.a(this.Ww, this.mActivity);
            } else {
                this.Ww.show();
            }
            Window window = this.Ww.getWindow();
            if (this.Wn == -1) {
                this.Wn = 17;
            }
            window.setGravity(this.Wn);
            window.setBackgroundDrawableResource(i.e.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bc.a(this.mRootView, false, (bc.a) new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.Ww != null) {
            return this.Ww.isShowing();
        }
        return false;
    }

    public void am(boolean z) {
        if (this.WB != null) {
            this.WB.setClickable(z);
        }
    }

    public void an(boolean z) {
        if (this.WC != null) {
            this.WC.setClickable(z);
        }
    }

    public a sR() {
        return al(true);
    }

    public void dismiss() {
        if (this.Ww != null) {
            j.b(this.Ww, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0041a implements View.OnClickListener {
        private final a Lt;
        private final b WI;

        public View$OnClickListenerC0041a(a aVar, b bVar) {
            this.Lt = aVar;
            this.WI = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.WI != null) {
                this.WI.onClick(this.Lt);
            }
        }
    }

    public void x(Object obj) {
        this.WA = obj;
    }

    public Object sS() {
        return this.WA;
    }

    public boolean sT() {
        return this.WF;
    }

    public void ao(boolean z) {
        this.WF = z;
    }

    public Window getWindow() {
        return this.Ww.getWindow();
    }
}
