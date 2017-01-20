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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String UH;
    private String UI;
    private b UL;
    private b UM;
    private DialogInterface.OnCancelListener UN;
    private DialogInterface.OnKeyListener UO;
    private AlertDialog UQ;
    private final ViewGroup UR;
    private ViewGroup US;
    private Object UV;
    private TextView UW;
    private TextView UX;
    private View UY;
    private View UZ;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int UE = -1;
    private boolean UF = false;
    private boolean UG = false;
    private int UJ = -1;
    private int UK = 0;
    private boolean UT = false;
    private boolean UU = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cD(String str) {
        this.mTitle = str;
        return this;
    }

    public a bZ(int i) {
        cD(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cE(String str) {
        this.mMessage = str;
        return this;
    }

    public a x(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.UN = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.UH = str;
        this.UL = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.UI = str;
        this.UM = bVar;
        return this;
    }

    public a ca(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.UH = this.mActivity.getResources().getString(i);
            this.UL = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.UI = this.mActivity.getResources().getString(i);
            this.UM = bVar;
        }
        return this;
    }

    public a au(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a av(boolean z) {
        this.UU = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.UR = (ViewGroup) LayoutInflater.from(activity).inflate(r.j.dialog_bdalert, (ViewGroup) null);
        this.US = (ViewGroup) this.UR.findViewById(r.h.real_view);
    }

    public a cb(int i) {
        if (isAutoNight()) {
            this.UJ = ap.getColor(i);
        } else {
            this.UJ = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cc(int i) {
        this.UK = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.UT) {
            this.UT = true;
            LinearLayout linearLayout = (LinearLayout) this.UR.findViewById(r.h.dialog_content);
            this.UW = (TextView) this.UR.findViewById(r.h.yes);
            this.UX = (TextView) this.UR.findViewById(r.h.no);
            this.UY = this.UR.findViewById(r.h.divider_yes_no_button);
            this.UZ = this.UR.findViewById(r.h.bdDialog_divider_line);
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
            c(gVar);
            if (this.UJ != -1) {
                if (this.UW != null) {
                    this.UW.setTextColor(this.UJ);
                }
                if (this.UX != null) {
                    this.UX.setTextColor(this.UJ);
                }
            }
            if (TextUtils.isEmpty(this.UH) || this.UW == null) {
                z = false;
            } else {
                this.UW.setText(this.UH);
                this.UW.setTag(this.UV);
                if (this.UL != null) {
                    this.UW.setOnClickListener(new View$OnClickListenerC0035a(this, this.UL));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.UI) || this.UX == null) {
                z2 = false;
            } else {
                this.UX.setText(this.UI);
                if (this.UM != null) {
                    this.UX.setOnClickListener(new View$OnClickListenerC0035a(this, this.UM));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View sS() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(r.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(r.h.message_view);
                if (this.UF) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.UG) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.j.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(r.h.message_view);
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
            ((TbPageContext) gVar).getLayoutMode().v(this.UR);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().v(this.mContentView);
            }
        }
        if (this.UR != null) {
            this.UR.setBackgroundResource(r.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.UY != null) {
                this.UY.setVisibility(0);
            }
            if (this.UZ != null) {
                this.UZ.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.UY != null) {
            this.UY.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.UW != null && this.UX != null && this.UY != null && this.UZ != null) {
                this.UW.setVisibility(8);
                this.UX.setVisibility(8);
                this.UY.setVisibility(8);
                this.UZ.setVisibility(8);
            }
        } else if (z) {
            ap.d(this.UW, r.g.dialog_single_button_bg_selector, skinType);
            if (this.UX != null && this.UY != null && this.UZ != null) {
                this.UZ.setVisibility(0);
                this.UW.setVisibility(0);
                this.UX.setVisibility(8);
            }
        } else if (z2) {
            ap.d(this.UX, r.g.dialog_single_button_bg_selector, skinType);
            if (this.UW != null && this.UY != null && this.UZ != null) {
                this.UZ.setVisibility(0);
                this.UX.setVisibility(0);
                this.UW.setVisibility(8);
            }
        } else if (this.UW != null && this.UX != null && this.UZ != null) {
            this.UZ.setVisibility(8);
            this.UW.setVisibility(8);
            this.UX.setVisibility(8);
        }
    }

    public a sT() {
        return aw(false);
    }

    private a aw(boolean z) {
        if (!this.UT) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.UQ != null) {
            if (z) {
                j.a(this.UQ, this.mActivity);
            } else {
                this.UQ.show();
            }
        } else {
            this.UQ = new AlertDialog.Builder(this.mActivity).create();
            this.UQ.setCanceledOnTouchOutside(this.UU && !this.mCancelable);
            this.UQ.setCancelable(this.mCancelable);
            this.UQ.setOnKeyListener(this.UO);
            if (this.UN != null) {
                this.UQ.setOnCancelListener(this.UN);
            }
            if (z) {
                j.a(this.UQ, this.mActivity);
            } else {
                this.UQ.show();
            }
            if (this.UQ.getWindow().getDecorView().getParent() != null) {
                Window window = this.UQ.getWindow();
                if (this.UE == -1) {
                    this.UE = 17;
                }
                window.setGravity(this.UE);
                window.setBackgroundDrawableResource(r.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    attributes.width = n.widthPixels - (sU() * 2);
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.UR);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bf.a(this.UR, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int sU() {
        return this.UK == 1 ? k.e(this.mActivity, r.f.ds40) : k.e(this.mActivity, r.f.ds90);
    }

    public boolean isShowing() {
        if (this.UQ != null) {
            return this.UQ.isShowing();
        }
        return false;
    }

    public void ax(boolean z) {
        if (this.UW != null) {
            this.UW.setClickable(z);
        }
    }

    public void ay(boolean z) {
        if (this.UX != null) {
            this.UX.setClickable(z);
        }
    }

    public a sV() {
        return aw(true);
    }

    public void hide() {
        if (this.UQ != null) {
            this.UQ.hide();
        }
    }

    public void dismiss() {
        if (this.UQ != null) {
            j.b(this.UQ, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a ER;
        private final b Vc;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.ER = aVar;
            this.Vc = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Vc != null) {
                this.Vc.onClick(this.ER);
            }
        }
    }

    public ViewGroup sW() {
        return this.US;
    }

    public void A(Object obj) {
        this.UV = obj;
    }

    public Object sX() {
        return this.UV;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.UQ.getWindow();
    }

    public Dialog getDialog() {
        return this.UQ;
    }

    public void az(boolean z) {
        this.UF = z;
    }

    public void aA(boolean z) {
        this.UG = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.UO = onKeyListener;
    }

    public void reset() {
        this.UT = false;
    }
}
