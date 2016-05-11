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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String RA;
    private b RD;
    private b RE;
    private DialogInterface.OnCancelListener RF;
    private DialogInterface.OnKeyListener RG;
    private AlertDialog RH;
    private final ViewGroup RI;
    private ViewGroup RJ;
    private Object RM;
    private TextView RO;
    private TextView RP;
    private View RQ;
    private View RR;
    private String Rz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Rw = -1;
    private boolean Rx = false;
    private boolean Ry = false;
    private int RB = -1;
    private int RC = 0;
    private boolean RK = false;
    private boolean RL = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    public a cz(String str) {
        this.mTitle = str;
        return this;
    }

    public a bL(int i) {
        cz(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cA(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.RF = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Rz = str;
        this.RD = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.RA = str;
        this.RE = bVar;
        return this;
    }

    public a bM(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Rz = this.mActivity.getResources().getString(i);
            this.RD = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.RA = this.mActivity.getResources().getString(i);
            this.RE = bVar;
        }
        return this;
    }

    public a ap(boolean z) {
        this.RL = z;
        return this;
    }

    public a aq(boolean z) {
        this.RL = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.RI = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdalert, (ViewGroup) null);
        this.RJ = (ViewGroup) this.RI.findViewById(t.g.real_view);
    }

    public a bN(int i) {
        if (isAutoNight()) {
            this.RB = at.getColor(i);
        } else {
            this.RB = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bO(int i) {
        this.RC = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.RK) {
            this.RK = true;
            LinearLayout linearLayout = (LinearLayout) this.RI.findViewById(t.g.dialog_content);
            this.RO = (TextView) this.RI.findViewById(t.g.yes);
            this.RP = (TextView) this.RI.findViewById(t.g.no);
            this.RQ = this.RI.findViewById(t.g.divider_yes_no_button);
            this.RR = this.RI.findViewById(t.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View rS = rS();
                if (rS != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(rS);
                }
            }
            c(hVar);
            if (this.RB != -1) {
                if (this.RO != null) {
                    this.RO.setTextColor(this.RB);
                }
                if (this.RP != null) {
                    this.RP.setTextColor(this.RB);
                }
            }
            if (TextUtils.isEmpty(this.Rz) || this.RO == null) {
                z = false;
            } else {
                this.RO.setText(this.Rz);
                this.RO.setTag(this.RM);
                if (this.RD != null) {
                    this.RO.setOnClickListener(new View$OnClickListenerC0034a(this, this.RD));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.RA) || this.RP == null) {
                z2 = false;
            } else {
                this.RP.setText(this.RA);
                if (this.RE != null) {
                    this.RP.setOnClickListener(new View$OnClickListenerC0034a(this, this.RE));
                }
            }
            d(z, z2);
        }
        return this;
    }

    public View rS() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(t.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(t.g.message_view);
                if (this.Rx) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Ry) {
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

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m11getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ae(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.RI);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        if (this.RI != null) {
            this.RI.setBackgroundResource(t.f.transparent_bg);
        }
    }

    private void d(boolean z, boolean z2) {
        if (z && z2) {
            if (this.RQ != null) {
                this.RQ.setVisibility(0);
            }
            if (this.RR != null) {
                this.RR.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m11getInst().getSkinType() : 0;
        if (this.RQ != null) {
            this.RQ.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.RO != null && this.RP != null && this.RQ != null && this.RR != null) {
                this.RO.setVisibility(8);
                this.RP.setVisibility(8);
                this.RQ.setVisibility(8);
                this.RR.setVisibility(8);
            }
        } else if (z) {
            at.d(this.RO, t.f.dialog_single_button_bg_selector, skinType);
            if (this.RP != null && this.RQ != null && this.RR != null) {
                this.RR.setVisibility(0);
                this.RO.setVisibility(0);
                this.RP.setVisibility(8);
            }
        } else if (z2) {
            at.d(this.RP, t.f.dialog_single_button_bg_selector, skinType);
            if (this.RO != null && this.RQ != null && this.RR != null) {
                this.RR.setVisibility(0);
                this.RP.setVisibility(0);
                this.RO.setVisibility(8);
            }
        } else if (this.RO != null && this.RP != null && this.RR != null) {
            this.RR.setVisibility(8);
            this.RO.setVisibility(8);
            this.RP.setVisibility(8);
        }
    }

    public a rT() {
        return ar(false);
    }

    private a ar(boolean z) {
        if (!this.RK) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.RH != null) {
            if (z) {
                j.a(this.RH, this.mActivity);
            } else {
                this.RH.show();
            }
        } else {
            this.RH = new AlertDialog.Builder(this.mActivity).create();
            this.RH.setCanceledOnTouchOutside(this.RL);
            this.RH.setCancelable(this.RL);
            this.RH.setOnKeyListener(this.RG);
            if (this.RF != null) {
                this.RH.setOnCancelListener(this.RF);
            }
            if (z) {
                j.a(this.RH, this.mActivity);
            } else {
                this.RH.show();
            }
            Window window = this.RH.getWindow();
            if (this.Rw == -1) {
                this.Rw = 17;
            }
            window.setGravity(this.Rw);
            window.setBackgroundDrawableResource(t.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics h = k.h(this.mActivity);
            if (h != null) {
                attributes.width = h.widthPixels - ((this.RC == 1 ? k.c(this.mActivity, t.e.ds40) : k.c(this.mActivity, t.e.ds90)) * 2);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.RI);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bl.a(this.RI, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.RH != null) {
            return this.RH.isShowing();
        }
        return false;
    }

    public void as(boolean z) {
        if (this.RO != null) {
            this.RO.setClickable(z);
        }
    }

    public void at(boolean z) {
        if (this.RP != null) {
            this.RP.setClickable(z);
        }
    }

    public a rU() {
        return ar(true);
    }

    public void hide() {
        if (this.RH != null) {
            this.RH.hide();
        }
    }

    public void dismiss() {
        if (this.RH != null) {
            j.b(this.RH, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0034a implements View.OnClickListener {
        private final a CP;
        private final b RU;

        public View$OnClickListenerC0034a(a aVar, b bVar) {
            this.CP = aVar;
            this.RU = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.RU != null) {
                this.RU.a(this.CP);
            }
        }
    }

    public ViewGroup rV() {
        return this.RJ;
    }

    public void x(Object obj) {
        this.RM = obj;
    }

    public Object rW() {
        return this.RM;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.RH.getWindow();
    }

    public Dialog getDialog() {
        return this.RH;
    }

    public void au(boolean z) {
        this.Rx = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.RG = onKeyListener;
    }
}
