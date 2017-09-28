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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String aaH;
    private String aaI;
    private b aaL;
    private b aaM;
    private DialogInterface.OnCancelListener aaN;
    private DialogInterface.OnKeyListener aaO;
    private AlertDialog aaP;
    private final ViewGroup aaQ;
    private ViewGroup aaR;
    private Object aaU;
    private TextView aaV;
    private TextView aaW;
    private View aaX;
    private View aaY;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aaE = -1;
    private boolean aaF = false;
    private boolean aaG = false;
    private int aaJ = -1;
    private int aaK = 0;
    private boolean aaS = false;
    private boolean aaT = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cL(String str) {
        this.mTitle = str;
        return this;
    }

    public a cc(int i) {
        cL(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cM(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aaN = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aaH = str;
        this.aaL = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aaI = str;
        this.aaM = bVar;
        return this;
    }

    public a cd(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aaH = this.mActivity.getResources().getString(i);
            this.aaL = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aaI = this.mActivity.getResources().getString(i);
            this.aaM = bVar;
        }
        return this;
    }

    public a ar(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a as(boolean z) {
        this.aaT = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aaQ = (ViewGroup) LayoutInflater.from(activity).inflate(d.j.dialog_bdalert, (ViewGroup) null);
        this.aaR = (ViewGroup) this.aaQ.findViewById(d.h.real_view);
    }

    public a ce(int i) {
        if (isAutoNight()) {
            this.aaJ = aj.getColor(i);
        } else {
            this.aaJ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cf(int i) {
        this.aaK = i;
        return this;
    }

    public a b(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aaS) {
            this.aaS = true;
            LinearLayout linearLayout = (LinearLayout) this.aaQ.findViewById(d.h.dialog_content);
            this.aaV = (TextView) this.aaQ.findViewById(d.h.yes);
            this.aaW = (TextView) this.aaQ.findViewById(d.h.no);
            this.aaX = this.aaQ.findViewById(d.h.divider_yes_no_button);
            this.aaY = this.aaQ.findViewById(d.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tf = tf();
                if (tf != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tf);
                }
            }
            c(eVar);
            if (this.aaJ != -1) {
                if (this.aaV != null) {
                    this.aaV.setTextColor(this.aaJ);
                }
                if (this.aaW != null) {
                    this.aaW.setTextColor(this.aaJ);
                }
            }
            if (TextUtils.isEmpty(this.aaH) || this.aaV == null) {
                z = false;
            } else {
                this.aaV.setText(this.aaH);
                this.aaV.setTag(this.aaU);
                if (this.aaL != null) {
                    this.aaV.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaL));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aaI) || this.aaW == null) {
                z2 = false;
            } else {
                this.aaW.setText(this.aaI);
                if (this.aaM != null) {
                    this.aaW.setOnClickListener(new View$OnClickListenerC0046a(this, this.aaM));
                }
            }
            h(z, z2);
        }
        return this;
    }

    public View tf() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(d.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(d.h.message_view);
                if (this.aaF) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aaG) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(d.j.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(d.h.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.e<?> eVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().t(this.aaQ);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aaQ != null) {
            this.aaQ.setBackgroundResource(d.g.transparent_bg);
        }
    }

    private void h(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aaX != null) {
                this.aaX.setVisibility(0);
            }
            if (this.aaY != null) {
                this.aaY.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.aaX != null) {
            this.aaX.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aaV != null && this.aaW != null && this.aaX != null && this.aaY != null) {
                this.aaV.setVisibility(8);
                this.aaW.setVisibility(8);
                this.aaX.setVisibility(8);
                this.aaY.setVisibility(8);
            }
        } else if (z) {
            aj.d(this.aaV, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aaW != null && this.aaX != null && this.aaY != null) {
                this.aaY.setVisibility(0);
                this.aaV.setVisibility(0);
                this.aaW.setVisibility(8);
            }
        } else if (z2) {
            aj.d(this.aaW, d.g.dialog_single_button_bg_selector, skinType);
            if (this.aaV != null && this.aaX != null && this.aaY != null) {
                this.aaY.setVisibility(0);
                this.aaW.setVisibility(0);
                this.aaV.setVisibility(8);
            }
        } else if (this.aaV != null && this.aaW != null && this.aaY != null) {
            this.aaY.setVisibility(8);
            this.aaV.setVisibility(8);
            this.aaW.setVisibility(8);
        }
    }

    public a tg() {
        return at(false);
    }

    private a at(boolean z) {
        if (!this.aaS) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aaP != null) {
            if (z) {
                g.a(this.aaP, this.mActivity);
            } else {
                this.aaP.show();
            }
        } else {
            this.aaP = new AlertDialog.Builder(this.mActivity).create();
            this.aaP.setCanceledOnTouchOutside(this.aaT);
            this.aaP.setCancelable(this.mCancelable);
            this.aaP.setOnKeyListener(this.aaO);
            if (this.aaN != null) {
                this.aaP.setOnCancelListener(this.aaN);
            }
            if (z) {
                g.a(this.aaP, this.mActivity);
            } else {
                this.aaP.show();
            }
            if (this.aaP.getWindow().getDecorView().getParent() != null) {
                Window window = this.aaP.getWindow();
                if (this.aaE == -1) {
                    this.aaE = 17;
                }
                window.setGravity(this.aaE);
                window.setBackgroundDrawableResource(d.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics o = l.o(this.mActivity);
                if (o != null) {
                    int th = th();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = o.heightPixels - (th * 2);
                    } else {
                        attributes.width = o.widthPixels - (th * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aaQ);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ax.a(this.aaQ, false, new ax.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.ax.a
                    public boolean w(View view) {
                        if (view instanceof EditText) {
                            atomicBoolean.set(true);
                            return true;
                        }
                        return false;
                    }
                });
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int th() {
        return this.aaK == 1 ? l.f(this.mActivity, d.f.ds40) : l.f(this.mActivity, d.f.ds90);
    }

    public boolean isShowing() {
        if (this.aaP != null) {
            return this.aaP.isShowing();
        }
        return false;
    }

    public void au(boolean z) {
        if (this.aaV != null) {
            this.aaV.setClickable(z);
        }
    }

    public void av(boolean z) {
        if (this.aaW != null) {
            this.aaW.setClickable(z);
        }
    }

    public a ti() {
        return at(true);
    }

    public void hide() {
        if (this.aaP != null) {
            this.aaP.hide();
        }
    }

    public void dismiss() {
        if (this.aaP != null) {
            g.b(this.aaP, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0046a implements View.OnClickListener {
        private final a KA;
        private final b abb;

        public View$OnClickListenerC0046a(a aVar, b bVar) {
            this.KA = aVar;
            this.abb = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.abb != null) {
                this.abb.onClick(this.KA);
            }
        }
    }

    public ViewGroup tj() {
        return this.aaR;
    }

    public void z(Object obj) {
        this.aaU = obj;
    }

    public Object tk() {
        return this.aaU;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aaP.getWindow();
    }

    public Dialog getDialog() {
        return this.aaP;
    }

    public void aw(boolean z) {
        this.aaF = z;
    }

    public void ax(boolean z) {
        this.aaG = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aaO = onKeyListener;
    }

    public void reset() {
        this.aaS = false;
    }
}
