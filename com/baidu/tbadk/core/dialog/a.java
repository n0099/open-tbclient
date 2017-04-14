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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private View aaA;
    private String aaj;
    private String aak;
    private b aan;
    private b aao;
    private DialogInterface.OnCancelListener aap;
    private DialogInterface.OnKeyListener aaq;
    private AlertDialog aar;
    private final ViewGroup aas;
    private ViewGroup aat;
    private Object aaw;
    private TextView aax;
    private TextView aay;
    private View aaz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aag = -1;
    private boolean aah = false;
    private boolean aai = false;
    private int aal = -1;
    private int aam = 0;
    private boolean aau = false;
    private boolean aav = true;
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

    public a bY(int i) {
        cD(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cE(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.aap = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aaj = str;
        this.aan = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aak = str;
        this.aao = bVar;
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
            this.aaj = this.mActivity.getResources().getString(i);
            this.aan = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aak = this.mActivity.getResources().getString(i);
            this.aao = bVar;
        }
        return this;
    }

    public a av(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aw(boolean z) {
        this.aav = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aas = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdalert, (ViewGroup) null);
        this.aat = (ViewGroup) this.aas.findViewById(w.h.real_view);
    }

    public a ca(int i) {
        if (isAutoNight()) {
            this.aal = aq.getColor(i);
        } else {
            this.aal = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cb(int i) {
        this.aam = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aau) {
            this.aau = true;
            LinearLayout linearLayout = (LinearLayout) this.aas.findViewById(w.h.dialog_content);
            this.aax = (TextView) this.aas.findViewById(w.h.yes);
            this.aay = (TextView) this.aas.findViewById(w.h.no);
            this.aaz = this.aas.findViewById(w.h.divider_yes_no_button);
            this.aaA = this.aas.findViewById(w.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tN = tN();
                if (tN != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tN);
                }
            }
            c(gVar);
            if (this.aal != -1) {
                if (this.aax != null) {
                    this.aax.setTextColor(this.aal);
                }
                if (this.aay != null) {
                    this.aay.setTextColor(this.aal);
                }
            }
            if (TextUtils.isEmpty(this.aaj) || this.aax == null) {
                z = false;
            } else {
                this.aax.setText(this.aaj);
                this.aax.setTag(this.aaw);
                if (this.aan != null) {
                    this.aax.setOnClickListener(new View$OnClickListenerC0033a(this, this.aan));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aak) || this.aay == null) {
                z2 = false;
            } else {
                this.aay.setText(this.aak);
                if (this.aao != null) {
                    this.aay.setOnClickListener(new View$OnClickListenerC0033a(this, this.aao));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View tN() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(w.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(w.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(w.h.message_view);
                if (this.aah) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aai) {
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
            ((TbPageContext) gVar).getLayoutMode().aj(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aas);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aas != null) {
            this.aas.setBackgroundResource(w.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aaz != null) {
                this.aaz.setVisibility(0);
            }
            if (this.aaA != null) {
                this.aaA.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.aaz != null) {
            this.aaz.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aax != null && this.aay != null && this.aaz != null && this.aaA != null) {
                this.aax.setVisibility(8);
                this.aay.setVisibility(8);
                this.aaz.setVisibility(8);
                this.aaA.setVisibility(8);
            }
        } else if (z) {
            aq.d(this.aax, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aay != null && this.aaz != null && this.aaA != null) {
                this.aaA.setVisibility(0);
                this.aax.setVisibility(0);
                this.aay.setVisibility(8);
            }
        } else if (z2) {
            aq.d(this.aay, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aax != null && this.aaz != null && this.aaA != null) {
                this.aaA.setVisibility(0);
                this.aay.setVisibility(0);
                this.aax.setVisibility(8);
            }
        } else if (this.aax != null && this.aay != null && this.aaA != null) {
            this.aaA.setVisibility(8);
            this.aax.setVisibility(8);
            this.aay.setVisibility(8);
        }
    }

    public a tO() {
        return ax(false);
    }

    private a ax(boolean z) {
        if (!this.aau) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aar != null) {
            if (z) {
                j.a(this.aar, this.mActivity);
            } else {
                this.aar.show();
            }
        } else {
            this.aar = new AlertDialog.Builder(this.mActivity).create();
            this.aar.setCanceledOnTouchOutside(this.aav && !this.mCancelable);
            this.aar.setCancelable(this.mCancelable);
            this.aar.setOnKeyListener(this.aaq);
            if (this.aap != null) {
                this.aar.setOnCancelListener(this.aap);
            }
            if (z) {
                j.a(this.aar, this.mActivity);
            } else {
                this.aar.show();
            }
            if (this.aar.getWindow().getDecorView().getParent() != null) {
                Window window = this.aar.getWindow();
                if (this.aag == -1) {
                    this.aag = 17;
                }
                window.setGravity(this.aag);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    attributes.width = n.widthPixels - (tP() * 2);
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aas);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bg.a(this.aas, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tP() {
        return this.aam == 1 ? k.g(this.mActivity, w.f.ds40) : k.g(this.mActivity, w.f.ds90);
    }

    public boolean isShowing() {
        if (this.aar != null) {
            return this.aar.isShowing();
        }
        return false;
    }

    public void ay(boolean z) {
        if (this.aax != null) {
            this.aax.setClickable(z);
        }
    }

    public void az(boolean z) {
        if (this.aay != null) {
            this.aay.setClickable(z);
        }
    }

    public a tQ() {
        return ax(true);
    }

    public void hide() {
        if (this.aar != null) {
            this.aar.hide();
        }
    }

    public void dismiss() {
        if (this.aar != null) {
            j.b(this.aar, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0033a implements View.OnClickListener {
        private final a LG;
        private final b aaD;

        public View$OnClickListenerC0033a(a aVar, b bVar) {
            this.LG = aVar;
            this.aaD = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aaD != null) {
                this.aaD.onClick(this.LG);
            }
        }
    }

    public ViewGroup tR() {
        return this.aat;
    }

    public void A(Object obj) {
        this.aaw = obj;
    }

    public Object tS() {
        return this.aaw;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aar.getWindow();
    }

    public Dialog getDialog() {
        return this.aar;
    }

    public void aA(boolean z) {
        this.aah = z;
    }

    public void aB(boolean z) {
        this.aai = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aaq = onKeyListener;
    }

    public void reset() {
        this.aau = false;
    }
}
