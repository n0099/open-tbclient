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
import com.baidu.tieba.u;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String SA;
    private String SB;
    private b SE;
    private b SF;
    private DialogInterface.OnCancelListener SG;
    private DialogInterface.OnKeyListener SH;
    private AlertDialog SI;
    private final ViewGroup SJ;
    private ViewGroup SK;
    private Object SN;
    private TextView SO;
    private TextView SP;
    private View SQ;
    private View SR;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Sx = -1;
    private boolean Sy = false;
    private boolean Sz = false;
    private int SC = -1;
    private int SD = 0;
    private boolean SL = false;
    private boolean SM = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    public a cy(String str) {
        this.mTitle = str;
        return this;
    }

    public a bL(int i) {
        cy(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cz(String str) {
        this.mMessage = str;
        return this;
    }

    public a y(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.SG = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.SA = str;
        this.SE = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.SB = str;
        this.SF = bVar;
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
            this.SA = this.mActivity.getResources().getString(i);
            this.SE = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.SB = this.mActivity.getResources().getString(i);
            this.SF = bVar;
        }
        return this;
    }

    public a ap(boolean z) {
        this.SM = z;
        return this;
    }

    public a aq(boolean z) {
        this.SM = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.SJ = (ViewGroup) LayoutInflater.from(activity).inflate(u.h.dialog_bdalert, (ViewGroup) null);
        this.SK = (ViewGroup) this.SJ.findViewById(u.g.real_view);
    }

    public a bN(int i) {
        if (isAutoNight()) {
            this.SC = av.getColor(i);
        } else {
            this.SC = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bO(int i) {
        this.SD = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.SL) {
            this.SL = true;
            LinearLayout linearLayout = (LinearLayout) this.SJ.findViewById(u.g.dialog_content);
            this.SO = (TextView) this.SJ.findViewById(u.g.yes);
            this.SP = (TextView) this.SJ.findViewById(u.g.no);
            this.SQ = this.SJ.findViewById(u.g.divider_yes_no_button);
            this.SR = this.SJ.findViewById(u.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View rP = rP();
                if (rP != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(rP);
                }
            }
            c(hVar);
            if (this.SC != -1) {
                if (this.SO != null) {
                    this.SO.setTextColor(this.SC);
                }
                if (this.SP != null) {
                    this.SP.setTextColor(this.SC);
                }
            }
            if (TextUtils.isEmpty(this.SA) || this.SO == null) {
                z = false;
            } else {
                this.SO.setText(this.SA);
                this.SO.setTag(this.SN);
                if (this.SE != null) {
                    this.SO.setOnClickListener(new View$OnClickListenerC0035a(this, this.SE));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.SB) || this.SP == null) {
                z2 = false;
            } else {
                this.SP.setText(this.SB);
                if (this.SF != null) {
                    this.SP.setOnClickListener(new View$OnClickListenerC0035a(this, this.SF));
                }
            }
            d(z, z2);
        }
        return this;
    }

    public View rP() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(u.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(u.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(u.g.message_view);
                if (this.Sy) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Sz) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(u.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(u.g.message_view);
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
        int skinType = isAutoNight() ? TbadkCoreApplication.m10getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().af(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.SJ);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().w(this.mContentView);
            }
        }
        if (this.SJ != null) {
            this.SJ.setBackgroundResource(u.f.transparent_bg);
        }
    }

    private void d(boolean z, boolean z2) {
        if (z && z2) {
            if (this.SQ != null) {
                this.SQ.setVisibility(0);
            }
            if (this.SR != null) {
                this.SR.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m10getInst().getSkinType() : 0;
        if (this.SQ != null) {
            this.SQ.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.SO != null && this.SP != null && this.SQ != null && this.SR != null) {
                this.SO.setVisibility(8);
                this.SP.setVisibility(8);
                this.SQ.setVisibility(8);
                this.SR.setVisibility(8);
            }
        } else if (z) {
            av.d(this.SO, u.f.dialog_single_button_bg_selector, skinType);
            if (this.SP != null && this.SQ != null && this.SR != null) {
                this.SR.setVisibility(0);
                this.SO.setVisibility(0);
                this.SP.setVisibility(8);
            }
        } else if (z2) {
            av.d(this.SP, u.f.dialog_single_button_bg_selector, skinType);
            if (this.SO != null && this.SQ != null && this.SR != null) {
                this.SR.setVisibility(0);
                this.SP.setVisibility(0);
                this.SO.setVisibility(8);
            }
        } else if (this.SO != null && this.SP != null && this.SR != null) {
            this.SR.setVisibility(8);
            this.SO.setVisibility(8);
            this.SP.setVisibility(8);
        }
    }

    public a rQ() {
        return ar(false);
    }

    private a ar(boolean z) {
        if (!this.SL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.SI != null) {
            if (z) {
                j.a(this.SI, this.mActivity);
            } else {
                this.SI.show();
            }
        } else {
            this.SI = new AlertDialog.Builder(this.mActivity).create();
            this.SI.setCanceledOnTouchOutside(this.SM);
            this.SI.setCancelable(this.SM);
            this.SI.setOnKeyListener(this.SH);
            if (this.SG != null) {
                this.SI.setOnCancelListener(this.SG);
            }
            if (z) {
                j.a(this.SI, this.mActivity);
            } else {
                this.SI.show();
            }
            Window window = this.SI.getWindow();
            if (this.Sx == -1) {
                this.Sx = 17;
            }
            window.setGravity(this.Sx);
            window.setBackgroundDrawableResource(u.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics j = k.j(this.mActivity);
            if (j != null) {
                attributes.width = j.widthPixels - (rR() * 2);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.SJ);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bn.a(this.SJ, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public int rR() {
        return this.SD == 1 ? k.c(this.mActivity, u.e.ds40) : k.c(this.mActivity, u.e.ds90);
    }

    public boolean isShowing() {
        if (this.SI != null) {
            return this.SI.isShowing();
        }
        return false;
    }

    public void as(boolean z) {
        if (this.SO != null) {
            this.SO.setClickable(z);
        }
    }

    public void at(boolean z) {
        if (this.SP != null) {
            this.SP.setClickable(z);
        }
    }

    public a rS() {
        return ar(true);
    }

    public void hide() {
        if (this.SI != null) {
            this.SI.hide();
        }
    }

    public void dismiss() {
        if (this.SI != null) {
            j.b(this.SI, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a Dq;
        private final b SU;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.Dq = aVar;
            this.SU = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.SU != null) {
                this.SU.a(this.Dq);
            }
        }
    }

    public ViewGroup rT() {
        return this.SK;
    }

    public void A(Object obj) {
        this.SN = obj;
    }

    public Object rU() {
        return this.SN;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.SI.getWindow();
    }

    public Dialog getDialog() {
        return this.SI;
    }

    public void au(boolean z) {
        this.Sy = z;
    }

    public void av(boolean z) {
        this.Sz = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.SH = onKeyListener;
    }

    public void reset() {
        this.SL = false;
    }
}
