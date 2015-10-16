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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private Object WC;
    private TextView WD;
    private TextView WE;
    private View WF;
    private View WG;
    private String Wq;
    private String Wr;
    private String Ws;
    private b Wv;
    private b Ww;
    private DialogInterface.OnCancelListener Wx;
    private AlertDialog Wy;
    private ViewGroup Wz;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wp = -1;
    private int Wt = -1;
    private int Wu = 0;
    private boolean WA = false;
    private boolean WB = true;
    private boolean WH = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a ct(String str) {
        this.mTitle = str;
        return this;
    }

    public a bE(int i) {
        ct(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cu(String str) {
        this.Wq = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Wx = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Wr = str;
        this.Wv = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Ws = str;
        this.Ww = bVar;
        return this;
    }

    public a bF(int i) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wr = this.mActivity.getResources().getString(i);
            this.Wv = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Ws = this.mActivity.getResources().getString(i);
            this.Ww = bVar;
        }
        return this;
    }

    public a aj(boolean z) {
        this.WB = z;
        return this;
    }

    public a ak(boolean z) {
        this.WB = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdalert, (ViewGroup) null);
        this.Wz = (ViewGroup) this.mRootView.findViewById(i.f.real_view);
    }

    public a bG(int i) {
        if (sT()) {
            this.Wt = an.getColor(i);
        } else {
            this.Wt = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bH(int i) {
        this.Wu = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.WA) {
            this.WA = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.dialog_content);
            this.WD = (TextView) this.mRootView.findViewById(i.f.yes);
            this.WE = (TextView) this.mRootView.findViewById(i.f.no);
            this.WF = this.mRootView.findViewById(i.f.divider_yes_no_button);
            this.WG = this.mRootView.findViewById(i.f.bdDialog_divider_line);
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
            if (this.Wt != -1) {
                this.WD.setTextColor(this.Wt);
                this.WE.setTextColor(this.Wt);
            }
            if (TextUtils.isEmpty(this.Wr)) {
                z = false;
            } else {
                this.WD.setText(this.Wr);
                this.WD.setTag(this.WC);
                if (this.Wv != null) {
                    this.WD.setOnClickListener(new View$OnClickListenerC0041a(this, this.Wv));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Ws)) {
                z2 = false;
            } else {
                this.WE.setText(this.Ws);
                if (this.Ww != null) {
                    this.WE.setOnClickListener(new View$OnClickListenerC0041a(this, this.Ww));
                }
                z2 = true;
            }
            if (this.Wu == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, i.d.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.Wz.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View sP() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.Wq) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_two_message_view, (ViewGroup) null);
                ((TextView) linearLayout.findViewById(i.f.title_view)).setText(this.mTitle);
                ((TextView) linearLayout.findViewById(i.f.message_view)).setText(this.Wq);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_one_message_view, (ViewGroup) null);
            TextView textView = (TextView) linearLayout2.findViewById(i.f.message_view);
            if (z) {
                textView.setText(this.mTitle);
                return linearLayout2;
            }
            textView.setText(this.Wq);
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
            this.WF.setVisibility(0);
            this.WG.setVisibility(0);
            return;
        }
        int skinType = sT() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.WF.setVisibility(8);
        if (!z && !z2) {
            this.WD.setVisibility(8);
            this.WE.setVisibility(8);
            this.WF.setVisibility(8);
        } else if (z) {
            an.c(this.WD, i.e.dialog_single_button_bg_selector, skinType);
            this.WG.setVisibility(0);
            this.WD.setVisibility(0);
            this.WE.setVisibility(8);
        } else if (z2) {
            an.c(this.WE, i.e.dialog_single_button_bg_selector, skinType);
            this.WG.setVisibility(0);
            this.WE.setVisibility(0);
            this.WD.setVisibility(8);
        } else {
            this.WG.setVisibility(8);
            this.WD.setVisibility(8);
            this.WE.setVisibility(8);
        }
    }

    public a sQ() {
        return al(false);
    }

    private a al(boolean z) {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wy != null) {
            if (z) {
                j.a(this.Wy, this.mActivity);
            } else {
                this.Wy.show();
            }
        } else {
            this.Wy = new AlertDialog.Builder(this.mActivity).create();
            this.Wy.setCanceledOnTouchOutside(this.WB);
            if (this.Wx != null) {
                this.Wy.setOnCancelListener(this.Wx);
            }
            if (z) {
                j.a(this.Wy, this.mActivity);
            } else {
                this.Wy.show();
            }
            Window window = this.Wy.getWindow();
            if (this.Wp == -1) {
                this.Wp = 17;
            }
            window.setGravity(this.Wp);
            window.setBackgroundDrawableResource(i.e.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bd.a(this.mRootView, false, (bd.a) new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.Wy != null) {
            return this.Wy.isShowing();
        }
        return false;
    }

    public void am(boolean z) {
        if (this.WD != null) {
            this.WD.setClickable(z);
        }
    }

    public void an(boolean z) {
        if (this.WE != null) {
            this.WE.setClickable(z);
        }
    }

    public a sR() {
        return al(true);
    }

    public void dismiss() {
        if (this.Wy != null) {
            j.b(this.Wy, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0041a implements View.OnClickListener {
        private final a Lu;
        private final b WK;

        public View$OnClickListenerC0041a(a aVar, b bVar) {
            this.Lu = aVar;
            this.WK = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.WK != null) {
                this.WK.onClick(this.Lu);
            }
        }
    }

    public void x(Object obj) {
        this.WC = obj;
    }

    public Object sS() {
        return this.WC;
    }

    public boolean sT() {
        return this.WH;
    }

    public void ao(boolean z) {
        this.WH = z;
    }

    public Window getWindow() {
        return this.Wy.getWindow();
    }
}
