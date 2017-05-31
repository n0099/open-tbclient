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
import com.baidu.adp.lib.g.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String ZE;
    private String ZF;
    private b ZI;
    private b ZJ;
    private DialogInterface.OnCancelListener ZK;
    private DialogInterface.OnKeyListener ZL;
    private AlertDialog ZM;
    private final ViewGroup ZN;
    private ViewGroup ZO;
    private Object ZR;
    private TextView ZS;
    private TextView ZT;
    private View ZU;
    private View ZV;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int ZB = -1;
    private boolean ZC = false;
    private boolean ZD = false;
    private int ZG = -1;
    private int ZH = 0;
    private boolean ZP = false;
    private boolean ZQ = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cA(String str) {
        this.mTitle = str;
        return this;
    }

    public a bX(int i) {
        cA(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cB(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.ZK = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.ZE = str;
        this.ZI = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.ZF = str;
        this.ZJ = bVar;
        return this;
    }

    public a bY(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZE = this.mActivity.getResources().getString(i);
            this.ZI = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZF = this.mActivity.getResources().getString(i);
            this.ZJ = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.ZQ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.ZN = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdalert, (ViewGroup) null);
        this.ZO = (ViewGroup) this.ZN.findViewById(w.h.real_view);
    }

    public a bZ(int i) {
        if (isAutoNight()) {
            this.ZG = aq.getColor(i);
        } else {
            this.ZG = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a ca(int i) {
        this.ZH = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.ZP) {
            this.ZP = true;
            LinearLayout linearLayout = (LinearLayout) this.ZN.findViewById(w.h.dialog_content);
            this.ZS = (TextView) this.ZN.findViewById(w.h.yes);
            this.ZT = (TextView) this.ZN.findViewById(w.h.no);
            this.ZU = this.ZN.findViewById(w.h.divider_yes_no_button);
            this.ZV = this.ZN.findViewById(w.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sZ = sZ();
                if (sZ != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sZ);
                }
            }
            c(gVar);
            if (this.ZG != -1) {
                if (this.ZS != null) {
                    this.ZS.setTextColor(this.ZG);
                }
                if (this.ZT != null) {
                    this.ZT.setTextColor(this.ZG);
                }
            }
            if (TextUtils.isEmpty(this.ZE) || this.ZS == null) {
                z = false;
            } else {
                this.ZS.setText(this.ZE);
                this.ZS.setTag(this.ZR);
                if (this.ZI != null) {
                    this.ZS.setOnClickListener(new View$OnClickListenerC0038a(this, this.ZI));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.ZF) || this.ZT == null) {
                z2 = false;
            } else {
                this.ZT.setText(this.ZF);
                if (this.ZJ != null) {
                    this.ZT.setOnClickListener(new View$OnClickListenerC0038a(this, this.ZJ));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View sZ() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(w.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(w.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(w.h.message_view);
                if (this.ZC) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.ZD) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(w.j.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(w.h.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.g<?> gVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (gVar instanceof TbPageContext) {
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZN);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.ZN != null) {
            this.ZN.setBackgroundResource(w.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.ZU != null) {
                this.ZU.setVisibility(0);
            }
            if (this.ZV != null) {
                this.ZV.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.ZU != null) {
            this.ZU.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.ZS != null && this.ZT != null && this.ZU != null && this.ZV != null) {
                this.ZS.setVisibility(8);
                this.ZT.setVisibility(8);
                this.ZU.setVisibility(8);
                this.ZV.setVisibility(8);
            }
        } else if (z) {
            aq.d(this.ZS, w.g.dialog_single_button_bg_selector, skinType);
            if (this.ZT != null && this.ZU != null && this.ZV != null) {
                this.ZV.setVisibility(0);
                this.ZS.setVisibility(0);
                this.ZT.setVisibility(8);
            }
        } else if (z2) {
            aq.d(this.ZT, w.g.dialog_single_button_bg_selector, skinType);
            if (this.ZS != null && this.ZU != null && this.ZV != null) {
                this.ZV.setVisibility(0);
                this.ZT.setVisibility(0);
                this.ZS.setVisibility(8);
            }
        } else if (this.ZS != null && this.ZT != null && this.ZV != null) {
            this.ZV.setVisibility(8);
            this.ZS.setVisibility(8);
            this.ZT.setVisibility(8);
        }
    }

    public a ta() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.ZP) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZM != null) {
            if (z) {
                j.a(this.ZM, this.mActivity);
            } else {
                this.ZM.show();
            }
        } else {
            this.ZM = new AlertDialog.Builder(this.mActivity).create();
            this.ZM.setCanceledOnTouchOutside(this.ZQ && !this.mCancelable);
            this.ZM.setCancelable(this.mCancelable);
            this.ZM.setOnKeyListener(this.ZL);
            if (this.ZK != null) {
                this.ZM.setOnCancelListener(this.ZK);
            }
            if (z) {
                j.a(this.ZM, this.mActivity);
            } else {
                this.ZM.show();
            }
            if (this.ZM.getWindow().getDecorView().getParent() != null) {
                Window window = this.ZM.getWindow();
                if (this.ZB == -1) {
                    this.ZB = 17;
                }
                window.setGravity(this.ZB);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = k.o(this.mActivity);
                if (o != null) {
                    int tb = tb();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (tb * 2);
                    } else {
                        attributes.width = o.widthPixels - (tb * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.ZN);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bh.a(this.ZN, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tb() {
        return this.ZH == 1 ? k.g(this.mActivity, w.f.ds40) : k.g(this.mActivity, w.f.ds90);
    }

    public boolean isShowing() {
        if (this.ZM != null) {
            return this.ZM.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.ZS != null) {
            this.ZS.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.ZT != null) {
            this.ZT.setClickable(z);
        }
    }

    public a tc() {
        return at(true);
    }

    public void hide() {
        if (this.ZM != null) {
            this.ZM.hide();
        }
    }

    public void dismiss() {
        if (this.ZM != null) {
            j.b(this.ZM, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0038a implements View.OnClickListener {
        private final a KO;
        private final b ZY;

        public View$OnClickListenerC0038a(a aVar, b bVar) {
            this.KO = aVar;
            this.ZY = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ZY != null) {
                this.ZY.onClick(this.KO);
            }
        }
    }

    public ViewGroup td() {
        return this.ZO;
    }

    public void A(Object obj) {
        this.ZR = obj;
    }

    public Object te() {
        return this.ZR;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.ZM.getWindow();
    }

    public Dialog getDialog() {
        return this.ZM;
    }

    public void aw(boolean z) {
        this.ZC = z;
    }

    public void ax(boolean z) {
        this.ZD = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.ZL = onKeyListener;
    }

    public void reset() {
        this.ZP = false;
    }
}
