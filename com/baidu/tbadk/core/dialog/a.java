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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private ViewGroup VA;
    private Object VD;
    private TextView VE;
    private TextView VF;
    private View VG;
    private View VH;
    private String Vq;
    private String Vr;
    private b Vu;
    private b Vv;
    private DialogInterface.OnCancelListener Vw;
    private DialogInterface.OnKeyListener Vx;
    private AlertDialog Vy;
    private final ViewGroup Vz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Vn = -1;
    private boolean Vo = false;
    private boolean Vp = false;
    private int Vs = -1;
    private int Vt = 0;
    private boolean VB = false;
    private boolean VC = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cA(String str) {
        this.mTitle = str;
        return this;
    }

    public a bY(int i) {
        cA(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cB(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Vw = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Vq = str;
        this.Vu = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Vr = str;
        this.Vv = bVar;
        return this;
    }

    public a bZ(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Vq = this.mActivity.getResources().getString(i);
            this.Vu = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Vr = this.mActivity.getResources().getString(i);
            this.Vv = bVar;
        }
        return this;
    }

    public a aq(boolean z) {
        this.VC = z;
        return this;
    }

    public a ar(boolean z) {
        this.VC = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.Vz = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdalert, (ViewGroup) null);
        this.VA = (ViewGroup) this.Vz.findViewById(t.g.real_view);
    }

    public a ca(int i) {
        if (isAutoNight()) {
            this.Vs = av.getColor(i);
        } else {
            this.Vs = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cb(int i) {
        this.Vt = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.VB) {
            this.VB = true;
            LinearLayout linearLayout = (LinearLayout) this.Vz.findViewById(t.g.dialog_content);
            this.VE = (TextView) this.Vz.findViewById(t.g.yes);
            this.VF = (TextView) this.Vz.findViewById(t.g.no);
            this.VG = this.Vz.findViewById(t.g.divider_yes_no_button);
            this.VH = this.Vz.findViewById(t.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View sU = sU();
                if (sU != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(sU);
                }
            }
            c(hVar);
            if (this.Vs != -1) {
                if (this.VE != null) {
                    this.VE.setTextColor(this.Vs);
                }
                if (this.VF != null) {
                    this.VF.setTextColor(this.Vs);
                }
            }
            if (TextUtils.isEmpty(this.Vq) || this.VE == null) {
                z = false;
            } else {
                this.VE.setText(this.Vq);
                this.VE.setTag(this.VD);
                if (this.Vu != null) {
                    this.VE.setOnClickListener(new View$OnClickListenerC0035a(this, this.Vu));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Vr) || this.VF == null) {
                z2 = false;
            } else {
                this.VF.setText(this.Vr);
                if (this.Vv != null) {
                    this.VF.setOnClickListener(new View$OnClickListenerC0035a(this, this.Vv));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View sU() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(t.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(t.g.message_view);
                if (this.Vo) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Vp) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(t.g.message_view);
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
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Vz);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        if (this.Vz != null) {
            this.Vz.setBackgroundResource(t.f.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.VG != null) {
                this.VG.setVisibility(0);
            }
            if (this.VH != null) {
                this.VH.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.VG != null) {
            this.VG.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.VE != null && this.VF != null && this.VG != null && this.VH != null) {
                this.VE.setVisibility(8);
                this.VF.setVisibility(8);
                this.VG.setVisibility(8);
                this.VH.setVisibility(8);
            }
        } else if (z) {
            av.d(this.VE, t.f.dialog_single_button_bg_selector, skinType);
            if (this.VF != null && this.VG != null && this.VH != null) {
                this.VH.setVisibility(0);
                this.VE.setVisibility(0);
                this.VF.setVisibility(8);
            }
        } else if (z2) {
            av.d(this.VF, t.f.dialog_single_button_bg_selector, skinType);
            if (this.VE != null && this.VG != null && this.VH != null) {
                this.VH.setVisibility(0);
                this.VF.setVisibility(0);
                this.VE.setVisibility(8);
            }
        } else if (this.VE != null && this.VF != null && this.VH != null) {
            this.VH.setVisibility(8);
            this.VE.setVisibility(8);
            this.VF.setVisibility(8);
        }
    }

    public a sV() {
        return as(false);
    }

    private a as(boolean z) {
        if (!this.VB) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Vy != null) {
            if (z) {
                j.a(this.Vy, this.mActivity);
            } else {
                this.Vy.show();
            }
        } else {
            this.Vy = new AlertDialog.Builder(this.mActivity).create();
            this.Vy.setCanceledOnTouchOutside(this.VC);
            this.Vy.setCancelable(this.VC);
            this.Vy.setOnKeyListener(this.Vx);
            if (this.Vw != null) {
                this.Vy.setOnCancelListener(this.Vw);
            }
            if (z) {
                j.a(this.Vy, this.mActivity);
            } else {
                this.Vy.show();
            }
            Window window = this.Vy.getWindow();
            if (this.Vn == -1) {
                this.Vn = 17;
            }
            window.setGravity(this.Vn);
            window.setBackgroundDrawableResource(t.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics n = k.n(this.mActivity);
            if (n != null) {
                attributes.width = n.widthPixels - (sW() * 2);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.Vz);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bn.a(this.Vz, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public int sW() {
        return this.Vt == 1 ? k.e(this.mActivity, t.e.ds40) : k.e(this.mActivity, t.e.ds90);
    }

    public boolean isShowing() {
        if (this.Vy != null) {
            return this.Vy.isShowing();
        }
        return false;
    }

    public void at(boolean z) {
        if (this.VE != null) {
            this.VE.setClickable(z);
        }
    }

    public void au(boolean z) {
        if (this.VF != null) {
            this.VF.setClickable(z);
        }
    }

    public a sX() {
        return as(true);
    }

    public void hide() {
        if (this.Vy != null) {
            this.Vy.hide();
        }
    }

    public void dismiss() {
        if (this.Vy != null) {
            j.b(this.Vy, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a FD;
        private final b VK;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.FD = aVar;
            this.VK = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.VK != null) {
                this.VK.onClick(this.FD);
            }
        }
    }

    public ViewGroup sY() {
        return this.VA;
    }

    public void A(Object obj) {
        this.VD = obj;
    }

    public Object sZ() {
        return this.VD;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.Vy.getWindow();
    }

    public Dialog getDialog() {
        return this.Vy;
    }

    public void av(boolean z) {
        this.Vo = z;
    }

    public void aw(boolean z) {
        this.Vp = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.Vx = onKeyListener;
    }

    public void reset() {
        this.VB = false;
    }
}
