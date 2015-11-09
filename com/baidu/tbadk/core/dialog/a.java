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
    private DialogInterface.OnCancelListener WA;
    private AlertDialog WB;
    private ViewGroup WC;
    private Object WF;
    private TextView WG;
    private TextView WH;
    private View WI;
    private View WJ;
    private String Wt;
    private String Wu;
    private String Wv;
    private b Wy;
    private b Wz;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Ws = -1;
    private int Ww = -1;
    private int Wx = 0;
    private boolean WD = false;
    private boolean WE = true;
    private boolean WK = true;

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
        this.Wt = str;
        return this;
    }

    public a m(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.WA = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Wu = str;
        this.Wy = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Wv = str;
        this.Wz = bVar;
        return this;
    }

    public a bF(int i) {
        if (this.mActivity != null) {
            this.Wt = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wu = this.mActivity.getResources().getString(i);
            this.Wy = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wv = this.mActivity.getResources().getString(i);
            this.Wz = bVar;
        }
        return this;
    }

    public a aj(boolean z) {
        this.WE = z;
        return this;
    }

    public a ak(boolean z) {
        this.WE = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_bdalert, (ViewGroup) null);
        this.WC = (ViewGroup) this.mRootView.findViewById(i.f.real_view);
    }

    public a bG(int i) {
        if (sT()) {
            this.Ww = an.getColor(i);
        } else {
            this.Ww = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bH(int i) {
        this.Wx = i;
        return this;
    }

    public a b(h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.WD) {
            this.WD = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.dialog_content);
            this.WG = (TextView) this.mRootView.findViewById(i.f.yes);
            this.WH = (TextView) this.mRootView.findViewById(i.f.no);
            this.WI = this.mRootView.findViewById(i.f.divider_yes_no_button);
            this.WJ = this.mRootView.findViewById(i.f.bdDialog_divider_line);
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
            if (this.Ww != -1) {
                this.WG.setTextColor(this.Ww);
                this.WH.setTextColor(this.Ww);
            }
            if (TextUtils.isEmpty(this.Wu)) {
                z = false;
            } else {
                this.WG.setText(this.Wu);
                this.WG.setTag(this.WF);
                if (this.Wy != null) {
                    this.WG.setOnClickListener(new View$OnClickListenerC0041a(this, this.Wy));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wv)) {
                z2 = false;
            } else {
                this.WH.setText(this.Wv);
                if (this.Wz != null) {
                    this.WH.setOnClickListener(new View$OnClickListenerC0041a(this, this.Wz));
                }
                z2 = true;
            }
            if (this.Wx == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int d = k.d(this.mActivity, i.d.ds40);
                layoutParams.setMargins(d, 0, d, 0);
                this.WC.setLayoutParams(layoutParams);
            }
            e(z, z2);
        }
        return this;
    }

    public View sP() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.Wt) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_two_message_view, (ViewGroup) null);
                ((TextView) linearLayout.findViewById(i.f.title_view)).setText(this.mTitle);
                ((TextView) linearLayout.findViewById(i.f.message_view)).setText(this.Wt);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(i.g.bdalert_one_message_view, (ViewGroup) null);
            TextView textView = (TextView) linearLayout2.findViewById(i.f.message_view);
            if (z) {
                textView.setText(this.mTitle);
                return linearLayout2;
            }
            textView.setText(this.Wt);
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
            this.WI.setVisibility(0);
            this.WJ.setVisibility(0);
            return;
        }
        int skinType = sT() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.WI.setVisibility(8);
        if (!z && !z2) {
            this.WG.setVisibility(8);
            this.WH.setVisibility(8);
            this.WI.setVisibility(8);
        } else if (z) {
            an.c(this.WG, i.e.dialog_single_button_bg_selector, skinType);
            this.WJ.setVisibility(0);
            this.WG.setVisibility(0);
            this.WH.setVisibility(8);
        } else if (z2) {
            an.c(this.WH, i.e.dialog_single_button_bg_selector, skinType);
            this.WJ.setVisibility(0);
            this.WH.setVisibility(0);
            this.WG.setVisibility(8);
        } else {
            this.WJ.setVisibility(8);
            this.WG.setVisibility(8);
            this.WH.setVisibility(8);
        }
    }

    public a sQ() {
        return al(false);
    }

    private a al(boolean z) {
        if (!this.WD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WB != null) {
            if (z) {
                j.a(this.WB, this.mActivity);
            } else {
                this.WB.show();
            }
        } else {
            this.WB = new AlertDialog.Builder(this.mActivity).create();
            this.WB.setCanceledOnTouchOutside(this.WE);
            if (this.WA != null) {
                this.WB.setOnCancelListener(this.WA);
            }
            if (z) {
                j.a(this.WB, this.mActivity);
            } else {
                this.WB.show();
            }
            Window window = this.WB.getWindow();
            if (this.Ws == -1) {
                this.Ws = 17;
            }
            window.setGravity(this.Ws);
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
        if (this.WB != null) {
            return this.WB.isShowing();
        }
        return false;
    }

    public void am(boolean z) {
        if (this.WG != null) {
            this.WG.setClickable(z);
        }
    }

    public void an(boolean z) {
        if (this.WH != null) {
            this.WH.setClickable(z);
        }
    }

    public a sR() {
        return al(true);
    }

    public void dismiss() {
        if (this.WB != null) {
            j.b(this.WB, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0041a implements View.OnClickListener {
        private final a Lv;
        private final b WN;

        public View$OnClickListenerC0041a(a aVar, b bVar) {
            this.Lv = aVar;
            this.WN = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.WN != null) {
                this.WN.onClick(this.Lv);
            }
        }
    }

    public void x(Object obj) {
        this.WF = obj;
    }

    public Object sS() {
        return this.WF;
    }

    public boolean sT() {
        return this.WK;
    }

    public void ao(boolean z) {
        this.WK = z;
    }

    public Window getWindow() {
        return this.WB.getWindow();
    }
}
