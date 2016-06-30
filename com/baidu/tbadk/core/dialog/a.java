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
    private String RR;
    private String RT;
    private b RW;
    private b RX;
    private DialogInterface.OnCancelListener RY;
    private DialogInterface.OnKeyListener RZ;
    private AlertDialog Sa;
    private final ViewGroup Sb;
    private ViewGroup Sc;
    private Object Sf;
    private TextView Sg;
    private TextView Sh;
    private View Si;
    private View Sj;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int RO = -1;
    private boolean RP = false;
    private boolean RQ = false;
    private int RU = -1;
    private int RV = 0;
    private boolean Sd = false;
    private boolean Se = true;
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
        this.RY = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.RR = str;
        this.RW = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.RT = str;
        this.RX = bVar;
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
            this.RR = this.mActivity.getResources().getString(i);
            this.RW = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.RT = this.mActivity.getResources().getString(i);
            this.RX = bVar;
        }
        return this;
    }

    public a an(boolean z) {
        this.Se = z;
        return this;
    }

    public a ao(boolean z) {
        this.Se = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.Sb = (ViewGroup) LayoutInflater.from(activity).inflate(u.h.dialog_bdalert, (ViewGroup) null);
        this.Sc = (ViewGroup) this.Sb.findViewById(u.g.real_view);
    }

    public a bN(int i) {
        if (isAutoNight()) {
            this.RU = av.getColor(i);
        } else {
            this.RU = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bO(int i) {
        this.RV = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.Sd) {
            this.Sd = true;
            LinearLayout linearLayout = (LinearLayout) this.Sb.findViewById(u.g.dialog_content);
            this.Sg = (TextView) this.Sb.findViewById(u.g.yes);
            this.Sh = (TextView) this.Sb.findViewById(u.g.no);
            this.Si = this.Sb.findViewById(u.g.divider_yes_no_button);
            this.Sj = this.Sb.findViewById(u.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View rQ = rQ();
                if (rQ != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(rQ);
                }
            }
            c(hVar);
            if (this.RU != -1) {
                if (this.Sg != null) {
                    this.Sg.setTextColor(this.RU);
                }
                if (this.Sh != null) {
                    this.Sh.setTextColor(this.RU);
                }
            }
            if (TextUtils.isEmpty(this.RR) || this.Sg == null) {
                z = false;
            } else {
                this.Sg.setText(this.RR);
                this.Sg.setTag(this.Sf);
                if (this.RW != null) {
                    this.Sg.setOnClickListener(new View$OnClickListenerC0034a(this, this.RW));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.RT) || this.Sh == null) {
                z2 = false;
            } else {
                this.Sh.setText(this.RT);
                if (this.RX != null) {
                    this.Sh.setOnClickListener(new View$OnClickListenerC0034a(this, this.RX));
                }
            }
            d(z, z2);
        }
        return this;
    }

    public View rQ() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(u.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(u.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(u.g.message_view);
                if (this.RP) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.RQ) {
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

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().w(this.Sb);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().w(this.mContentView);
            }
        }
        if (this.Sb != null) {
            this.Sb.setBackgroundResource(u.f.transparent_bg);
        }
    }

    private void d(boolean z, boolean z2) {
        if (z && z2) {
            if (this.Si != null) {
                this.Si.setVisibility(0);
            }
            if (this.Sj != null) {
                this.Sj.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.Si != null) {
            this.Si.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.Sg != null && this.Sh != null && this.Si != null && this.Sj != null) {
                this.Sg.setVisibility(8);
                this.Sh.setVisibility(8);
                this.Si.setVisibility(8);
                this.Sj.setVisibility(8);
            }
        } else if (z) {
            av.d(this.Sg, u.f.dialog_single_button_bg_selector, skinType);
            if (this.Sh != null && this.Si != null && this.Sj != null) {
                this.Sj.setVisibility(0);
                this.Sg.setVisibility(0);
                this.Sh.setVisibility(8);
            }
        } else if (z2) {
            av.d(this.Sh, u.f.dialog_single_button_bg_selector, skinType);
            if (this.Sg != null && this.Si != null && this.Sj != null) {
                this.Sj.setVisibility(0);
                this.Sh.setVisibility(0);
                this.Sg.setVisibility(8);
            }
        } else if (this.Sg != null && this.Sh != null && this.Sj != null) {
            this.Sj.setVisibility(8);
            this.Sg.setVisibility(8);
            this.Sh.setVisibility(8);
        }
    }

    public a rR() {
        return ap(false);
    }

    private a ap(boolean z) {
        if (!this.Sd) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Sa != null) {
            if (z) {
                j.a(this.Sa, this.mActivity);
            } else {
                this.Sa.show();
            }
        } else {
            this.Sa = new AlertDialog.Builder(this.mActivity).create();
            this.Sa.setCanceledOnTouchOutside(this.Se);
            this.Sa.setCancelable(this.Se);
            this.Sa.setOnKeyListener(this.RZ);
            if (this.RY != null) {
                this.Sa.setOnCancelListener(this.RY);
            }
            if (z) {
                j.a(this.Sa, this.mActivity);
            } else {
                this.Sa.show();
            }
            Window window = this.Sa.getWindow();
            if (this.RO == -1) {
                this.RO = 17;
            }
            window.setGravity(this.RO);
            window.setBackgroundDrawableResource(u.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics j = k.j(this.mActivity);
            if (j != null) {
                attributes.width = j.widthPixels - (rS() * 2);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.Sb);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bn.a(this.Sb, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public int rS() {
        return this.RV == 1 ? k.c(this.mActivity, u.e.ds40) : k.c(this.mActivity, u.e.ds90);
    }

    public boolean isShowing() {
        if (this.Sa != null) {
            return this.Sa.isShowing();
        }
        return false;
    }

    public void aq(boolean z) {
        if (this.Sg != null) {
            this.Sg.setClickable(z);
        }
    }

    public void ar(boolean z) {
        if (this.Sh != null) {
            this.Sh.setClickable(z);
        }
    }

    public a rT() {
        return ap(true);
    }

    public void hide() {
        if (this.Sa != null) {
            this.Sa.hide();
        }
    }

    public void dismiss() {
        if (this.Sa != null) {
            j.b(this.Sa, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0034a implements View.OnClickListener {
        private final a CQ;
        private final b Sm;

        public View$OnClickListenerC0034a(a aVar, b bVar) {
            this.CQ = aVar;
            this.Sm = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Sm != null) {
                this.Sm.a(this.CQ);
            }
        }
    }

    public ViewGroup rU() {
        return this.Sc;
    }

    public void x(Object obj) {
        this.Sf = obj;
    }

    public Object rV() {
        return this.Sf;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.Sa.getWindow();
    }

    public Dialog getDialog() {
        return this.Sa;
    }

    public void as(boolean z) {
        this.RP = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.RZ = onKeyListener;
    }
}
