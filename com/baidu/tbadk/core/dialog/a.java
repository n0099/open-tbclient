package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
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
    private Object WC;
    private TextView WD;
    private TextView WE;
    private View WF;
    private View WG;
    private String Wp;
    private String Wq;
    private b Wt;
    private b Wu;
    private DialogInterface.OnCancelListener Wv;
    private DialogInterface.OnKeyListener Ww;
    private AlertDialog Wx;
    private final ViewGroup Wy;
    private ViewGroup Wz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Wm = -1;
    private boolean Wn = false;
    private boolean Wo = false;
    private int Wr = -1;
    private int Ws = 0;
    private boolean WA = false;
    private boolean WB = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    public a cB(String str) {
        this.mTitle = str;
        return this;
    }

    public a bZ(int i) {
        cB(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cC(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.Wv = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.Wp = str;
        this.Wt = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.Wq = str;
        this.Wu = bVar;
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
            this.Wp = this.mActivity.getResources().getString(i);
            this.Wt = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
            this.Wu = bVar;
        }
        return this;
    }

    public a am(boolean z) {
        this.WB = z;
        return this;
    }

    public a an(boolean z) {
        this.WB = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.Wy = (ViewGroup) LayoutInflater.from(activity).inflate(t.h.dialog_bdalert, (ViewGroup) null);
        this.Wz = (ViewGroup) this.Wy.findViewById(t.g.real_view);
    }

    public a cb(int i) {
        if (isAutoNight()) {
            this.Wr = at.getColor(i);
        } else {
            this.Wr = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cc(int i) {
        this.Ws = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        if (!this.WA) {
            this.WA = true;
            LinearLayout linearLayout = (LinearLayout) this.Wy.findViewById(t.g.dialog_content);
            this.WD = (TextView) this.Wy.findViewById(t.g.yes);
            this.WE = (TextView) this.Wy.findViewById(t.g.no);
            this.WF = this.Wy.findViewById(t.g.divider_yes_no_button);
            this.WG = this.Wy.findViewById(t.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View un = un();
                if (un != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(un);
                }
            }
            c(hVar);
            if (this.Wr != -1) {
                this.WD.setTextColor(this.Wr);
                this.WE.setTextColor(this.Wr);
            }
            if (TextUtils.isEmpty(this.Wp)) {
                z = false;
            } else {
                this.WD.setText(this.Wp);
                this.WD.setTag(this.WC);
                if (this.Wt != null) {
                    this.WD.setOnClickListener(new View$OnClickListenerC0043a(this, this.Wt));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wq)) {
                z2 = false;
            } else {
                this.WE.setText(this.Wq);
                if (this.Wu != null) {
                    this.WE.setOnClickListener(new View$OnClickListenerC0043a(this, this.Wu));
                }
                z2 = true;
            }
            if (this.Ws == 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int c = k.c(this.mActivity, t.e.ds40);
                layoutParams.setMargins(c, 0, c, 0);
                this.Wz.setLayoutParams(layoutParams);
            }
            d(z, z2);
        }
        return this;
    }

    public View un() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(t.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(t.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(t.g.message_view);
                if (this.Wn) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Wo) {
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
        int skinType = isAutoNight() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ab(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.Wy);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        this.Wy.setBackgroundResource(t.f.transparent_bg);
    }

    private void d(boolean z, boolean z2) {
        if (z && z2) {
            this.WF.setVisibility(0);
            this.WG.setVisibility(0);
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
        this.WF.setVisibility(8);
        if (!z && !z2) {
            this.WD.setVisibility(8);
            this.WE.setVisibility(8);
            this.WF.setVisibility(8);
            this.WG.setVisibility(8);
        } else if (z) {
            at.c(this.WD, t.f.dialog_single_button_bg_selector, skinType);
            this.WG.setVisibility(0);
            this.WD.setVisibility(0);
            this.WE.setVisibility(8);
        } else if (z2) {
            at.c(this.WE, t.f.dialog_single_button_bg_selector, skinType);
            this.WG.setVisibility(0);
            this.WE.setVisibility(0);
            this.WD.setVisibility(8);
        } else {
            this.WG.setVisibility(8);
            this.WD.setVisibility(8);
            this.WE.setVisibility(8);
        }
    }

    public a uo() {
        return ao(false);
    }

    private a ao(boolean z) {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wx != null) {
            if (z) {
                j.a(this.Wx, this.mActivity);
            } else {
                this.Wx.show();
            }
        } else {
            this.Wx = new AlertDialog.Builder(this.mActivity).create();
            this.Wx.setCanceledOnTouchOutside(this.WB);
            this.Wx.setCancelable(this.WB);
            this.Wx.setOnKeyListener(this.Ww);
            if (this.Wv != null) {
                this.Wx.setOnCancelListener(this.Wv);
            }
            if (z) {
                j.a(this.Wx, this.mActivity);
            } else {
                this.Wx.show();
            }
            Window window = this.Wx.getWindow();
            if (this.Wm == -1) {
                this.Wm = 17;
            }
            window.setGravity(this.Wm);
            window.setBackgroundDrawableResource(t.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.Wy);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bl.a(this.Wy, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public boolean isShowing() {
        if (this.Wx != null) {
            return this.Wx.isShowing();
        }
        return false;
    }

    public void ap(boolean z) {
        if (this.WD != null) {
            this.WD.setClickable(z);
        }
    }

    public void aq(boolean z) {
        if (this.WE != null) {
            this.WE.setClickable(z);
        }
    }

    public a up() {
        return ao(true);
    }

    public void hide() {
        if (this.Wx != null) {
            this.Wx.hide();
        }
    }

    public void dismiss() {
        if (this.Wx != null) {
            j.b(this.Wx, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0043a implements View.OnClickListener {
        private final a My;
        private final b WJ;

        public View$OnClickListenerC0043a(a aVar, b bVar) {
            this.My = aVar;
            this.WJ = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.WJ != null) {
                this.WJ.a(this.My);
            }
        }
    }

    public ViewGroup uq() {
        return this.Wz;
    }

    public void x(Object obj) {
        this.WC = obj;
    }

    public Object ur() {
        return this.WC;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.Wx.getWindow();
    }

    public Dialog getDialog() {
        return this.Wx;
    }

    public void ar(boolean z) {
        this.Wn = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.Ww = onKeyListener;
    }
}
