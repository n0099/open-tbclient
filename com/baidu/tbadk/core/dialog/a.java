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
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private AlertDialog VA;
    private final ViewGroup VB;
    private ViewGroup VC;
    private Object VF;
    private TextView VG;
    private TextView VH;
    private View VI;
    private View VJ;
    private String Vs;
    private String Vt;
    private b Vw;
    private b Vx;
    private DialogInterface.OnCancelListener Vy;
    private DialogInterface.OnKeyListener Vz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Vp = -1;
    private boolean Vq = false;
    private boolean Vr = false;
    private int Vu = -1;
    private int Vv = 0;
    private boolean VD = false;
    private boolean VE = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cF(String str) {
        this.mTitle = str;
        return this;
    }

    public a ca(int i) {
        cF(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cG(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Vy = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Vs = str;
        this.Vw = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Vt = str;
        this.Vx = bVar;
        return this;
    }

    public a cb(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Vs = this.mActivity.getResources().getString(i);
            this.Vw = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Vt = this.mActivity.getResources().getString(i);
            this.Vx = bVar;
        }
        return this;
    }

    public a au(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a av(boolean z) {
        this.VE = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.VB = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdalert, (ViewGroup) null);
        this.VC = (ViewGroup) this.VB.findViewById(r.g.real_view);
    }

    public a cc(int i) {
        if (isAutoNight()) {
            this.Vu = ar.getColor(i);
        } else {
            this.Vu = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cd(int i) {
        this.Vv = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.VD) {
            this.VD = true;
            LinearLayout linearLayout = (LinearLayout) this.VB.findViewById(r.g.dialog_content);
            this.VG = (TextView) this.VB.findViewById(r.g.yes);
            this.VH = (TextView) this.VB.findViewById(r.g.no);
            this.VI = this.VB.findViewById(r.g.divider_yes_no_button);
            this.VJ = this.VB.findViewById(r.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sY = sY();
                if (sY != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sY);
                }
            }
            c(hVar);
            if (this.Vu != -1) {
                if (this.VG != null) {
                    this.VG.setTextColor(this.Vu);
                }
                if (this.VH != null) {
                    this.VH.setTextColor(this.Vu);
                }
            }
            if (TextUtils.isEmpty(this.Vs) || this.VG == null) {
                z = false;
            } else {
                this.VG.setText(this.Vs);
                this.VG.setTag(this.VF);
                if (this.Vw != null) {
                    this.VG.setOnClickListener(new View$OnClickListenerC0035a(this, this.Vw));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Vt) || this.VH == null) {
                z2 = false;
            } else {
                this.VH.setText(this.Vt);
                if (this.Vx != null) {
                    this.VH.setOnClickListener(new View$OnClickListenerC0035a(this, this.Vx));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View sY() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(r.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(r.g.message_view);
                if (this.Vq) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Vr) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(r.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ai(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VB);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        if (this.VB != null) {
            this.VB.setBackgroundResource(r.f.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.VI != null) {
                this.VI.setVisibility(0);
            }
            if (this.VJ != null) {
                this.VJ.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.VI != null) {
            this.VI.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.VG != null && this.VH != null && this.VI != null && this.VJ != null) {
                this.VG.setVisibility(8);
                this.VH.setVisibility(8);
                this.VI.setVisibility(8);
                this.VJ.setVisibility(8);
            }
        } else if (z) {
            ar.d(this.VG, r.f.dialog_single_button_bg_selector, skinType);
            if (this.VH != null && this.VI != null && this.VJ != null) {
                this.VJ.setVisibility(0);
                this.VG.setVisibility(0);
                this.VH.setVisibility(8);
            }
        } else if (z2) {
            ar.d(this.VH, r.f.dialog_single_button_bg_selector, skinType);
            if (this.VG != null && this.VI != null && this.VJ != null) {
                this.VJ.setVisibility(0);
                this.VH.setVisibility(0);
                this.VG.setVisibility(8);
            }
        } else if (this.VG != null && this.VH != null && this.VJ != null) {
            this.VJ.setVisibility(8);
            this.VG.setVisibility(8);
            this.VH.setVisibility(8);
        }
    }

    public a sZ() {
        return aw(false);
    }

    private a aw(boolean z) {
        if (!this.VD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VA != null) {
            if (z) {
                j.a(this.VA, this.mActivity);
            } else {
                this.VA.show();
            }
        } else {
            this.VA = new AlertDialog.Builder(this.mActivity).create();
            this.VA.setCanceledOnTouchOutside(this.VE && !this.mCancelable);
            this.VA.setCancelable(this.mCancelable);
            this.VA.setOnKeyListener(this.Vz);
            if (this.Vy != null) {
                this.VA.setOnCancelListener(this.Vy);
            }
            if (z) {
                j.a(this.VA, this.mActivity);
            } else {
                this.VA.show();
            }
            if (this.VA.getWindow().getDecorView().getParent() != null) {
                Window window = this.VA.getWindow();
                if (this.Vp == -1) {
                    this.Vp = 17;
                }
                window.setGravity(this.Vp);
                window.setBackgroundDrawableResource(r.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    attributes.width = n.widthPixels - (ta() * 2);
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.VB);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bh.a(this.VB, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int ta() {
        return this.Vv == 1 ? k.e(this.mActivity, r.e.ds40) : k.e(this.mActivity, r.e.ds90);
    }

    public boolean isShowing() {
        if (this.VA != null) {
            return this.VA.isShowing();
        }
        return false;
    }

    public void ax(boolean z) {
        if (this.VG != null) {
            this.VG.setClickable(z);
        }
    }

    public void ay(boolean z) {
        if (this.VH != null) {
            this.VH.setClickable(z);
        }
    }

    public a tb() {
        return aw(true);
    }

    public void hide() {
        if (this.VA != null) {
            this.VA.hide();
        }
    }

    public void dismiss() {
        if (this.VA != null) {
            j.b(this.VA, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a FG;
        private final b VM;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.FG = aVar;
            this.VM = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.VM != null) {
                this.VM.onClick(this.FG);
            }
        }
    }

    public ViewGroup tc() {
        return this.VC;
    }

    public void A(Object obj) {
        this.VF = obj;
    }

    public Object td() {
        return this.VF;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.VA.getWindow();
    }

    public Dialog getDialog() {
        return this.VA;
    }

    public void az(boolean z) {
        this.Vq = z;
    }

    public void aA(boolean z) {
        this.Vr = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.Vz = onKeyListener;
    }

    public void reset() {
        this.VD = false;
    }
}
