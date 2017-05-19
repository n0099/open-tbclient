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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String ZF;
    private String ZG;
    private b ZJ;
    private b ZK;
    private DialogInterface.OnCancelListener ZL;
    private DialogInterface.OnKeyListener ZM;
    private AlertDialog ZN;
    private final ViewGroup ZO;
    private ViewGroup ZP;
    private Object ZS;
    private TextView ZT;
    private TextView ZU;
    private View ZV;
    private View ZW;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int ZC = -1;
    private boolean ZD = false;
    private boolean ZE = false;
    private int ZH = -1;
    private int ZI = 0;
    private boolean ZQ = false;
    private boolean ZR = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cB(String str) {
        this.mTitle = str;
        return this;
    }

    public a bW(int i) {
        cB(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cC(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.ZL = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.ZF = str;
        this.ZJ = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.ZG = str;
        this.ZK = bVar;
        return this;
    }

    public a bX(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZF = this.mActivity.getResources().getString(i);
            this.ZJ = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZG = this.mActivity.getResources().getString(i);
            this.ZK = bVar;
        }
        return this;
    }

    public a as(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a at(boolean z) {
        this.ZR = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.ZO = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdalert, (ViewGroup) null);
        this.ZP = (ViewGroup) this.ZO.findViewById(w.h.real_view);
    }

    public a bY(int i) {
        if (isAutoNight()) {
            this.ZH = aq.getColor(i);
        } else {
            this.ZH = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bZ(int i) {
        this.ZI = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.ZQ) {
            this.ZQ = true;
            LinearLayout linearLayout = (LinearLayout) this.ZO.findViewById(w.h.dialog_content);
            this.ZT = (TextView) this.ZO.findViewById(w.h.yes);
            this.ZU = (TextView) this.ZO.findViewById(w.h.no);
            this.ZV = this.ZO.findViewById(w.h.divider_yes_no_button);
            this.ZW = this.ZO.findViewById(w.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View ta = ta();
                if (ta != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(ta);
                }
            }
            c(gVar);
            if (this.ZH != -1) {
                if (this.ZT != null) {
                    this.ZT.setTextColor(this.ZH);
                }
                if (this.ZU != null) {
                    this.ZU.setTextColor(this.ZH);
                }
            }
            if (TextUtils.isEmpty(this.ZF) || this.ZT == null) {
                z = false;
            } else {
                this.ZT.setText(this.ZF);
                this.ZT.setTag(this.ZS);
                if (this.ZJ != null) {
                    this.ZT.setOnClickListener(new View$OnClickListenerC0038a(this, this.ZJ));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.ZG) || this.ZU == null) {
                z2 = false;
            } else {
                this.ZU.setText(this.ZG);
                if (this.ZK != null) {
                    this.ZU.setOnClickListener(new View$OnClickListenerC0038a(this, this.ZK));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View ta() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(w.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(w.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(w.h.message_view);
                if (this.ZD) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.ZE) {
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
            ((TbPageContext) gVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.ZO);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.ZO != null) {
            this.ZO.setBackgroundResource(w.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.ZV != null) {
                this.ZV.setVisibility(0);
            }
            if (this.ZW != null) {
                this.ZW.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.ZV != null) {
            this.ZV.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.ZT != null && this.ZU != null && this.ZV != null && this.ZW != null) {
                this.ZT.setVisibility(8);
                this.ZU.setVisibility(8);
                this.ZV.setVisibility(8);
                this.ZW.setVisibility(8);
            }
        } else if (z) {
            aq.d(this.ZT, w.g.dialog_single_button_bg_selector, skinType);
            if (this.ZU != null && this.ZV != null && this.ZW != null) {
                this.ZW.setVisibility(0);
                this.ZT.setVisibility(0);
                this.ZU.setVisibility(8);
            }
        } else if (z2) {
            aq.d(this.ZU, w.g.dialog_single_button_bg_selector, skinType);
            if (this.ZT != null && this.ZV != null && this.ZW != null) {
                this.ZW.setVisibility(0);
                this.ZU.setVisibility(0);
                this.ZT.setVisibility(8);
            }
        } else if (this.ZT != null && this.ZU != null && this.ZW != null) {
            this.ZW.setVisibility(8);
            this.ZT.setVisibility(8);
            this.ZU.setVisibility(8);
        }
    }

    public a tb() {
        return au(false);
    }

    private a au(boolean z) {
        if (!this.ZQ) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ZN != null) {
            if (z) {
                j.a(this.ZN, this.mActivity);
            } else {
                this.ZN.show();
            }
        } else {
            this.ZN = new AlertDialog.Builder(this.mActivity).create();
            this.ZN.setCanceledOnTouchOutside(this.ZR && !this.mCancelable);
            this.ZN.setCancelable(this.mCancelable);
            this.ZN.setOnKeyListener(this.ZM);
            if (this.ZL != null) {
                this.ZN.setOnCancelListener(this.ZL);
            }
            if (z) {
                j.a(this.ZN, this.mActivity);
            } else {
                this.ZN.show();
            }
            if (this.ZN.getWindow().getDecorView().getParent() != null) {
                Window window = this.ZN.getWindow();
                if (this.ZC == -1) {
                    this.ZC = 17;
                }
                window.setGravity(this.ZC);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    int tc = tc();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = n.heightPixels - (tc * 2);
                    } else {
                        attributes.width = n.widthPixels - (tc * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.ZO);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bg.a(this.ZO, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tc() {
        return this.ZI == 1 ? k.g(this.mActivity, w.f.ds40) : k.g(this.mActivity, w.f.ds90);
    }

    public boolean isShowing() {
        if (this.ZN != null) {
            return this.ZN.isShowing();
        }
        return false;
    }

    public void av(boolean z) {
        if (this.ZT != null) {
            this.ZT.setClickable(z);
        }
    }

    public void aw(boolean z) {
        if (this.ZU != null) {
            this.ZU.setClickable(z);
        }
    }

    public a td() {
        return au(true);
    }

    public void hide() {
        if (this.ZN != null) {
            this.ZN.hide();
        }
    }

    public void dismiss() {
        if (this.ZN != null) {
            j.b(this.ZN, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0038a implements View.OnClickListener {
        private final a La;
        private final b ZZ;

        public View$OnClickListenerC0038a(a aVar, b bVar) {
            this.La = aVar;
            this.ZZ = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ZZ != null) {
                this.ZZ.onClick(this.La);
            }
        }
    }

    public ViewGroup te() {
        return this.ZP;
    }

    public void A(Object obj) {
        this.ZS = obj;
    }

    public Object tf() {
        return this.ZS;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.ZN.getWindow();
    }

    public Dialog getDialog() {
        return this.ZN;
    }

    public void ax(boolean z) {
        this.ZD = z;
    }

    public void ay(boolean z) {
        this.ZE = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.ZM = onKeyListener;
    }

    public void reset() {
        this.ZQ = false;
    }
}
