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
    private View aaA;
    private View aaB;
    private String aak;
    private String aal;
    private b aao;
    private b aap;
    private DialogInterface.OnCancelListener aaq;
    private DialogInterface.OnKeyListener aar;
    private AlertDialog aas;
    private final ViewGroup aat;
    private ViewGroup aau;
    private Object aax;
    private TextView aay;
    private TextView aaz;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int aah = -1;
    private boolean aai = false;
    private boolean aaj = false;
    private int aam = -1;
    private int aan = 0;
    private boolean aav = false;
    private boolean aaw = true;
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
        this.aaq = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.aak = str;
        this.aao = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.aal = str;
        this.aap = bVar;
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
            this.aak = this.mActivity.getResources().getString(i);
            this.aao = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aal = this.mActivity.getResources().getString(i);
            this.aap = bVar;
        }
        return this;
    }

    public a av(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a aw(boolean z) {
        this.aaw = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aat = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdalert, (ViewGroup) null);
        this.aau = (ViewGroup) this.aat.findViewById(w.h.real_view);
    }

    public a ca(int i) {
        if (isAutoNight()) {
            this.aam = aq.getColor(i);
        } else {
            this.aam = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cb(int i) {
        this.aan = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aav) {
            this.aav = true;
            LinearLayout linearLayout = (LinearLayout) this.aat.findViewById(w.h.dialog_content);
            this.aay = (TextView) this.aat.findViewById(w.h.yes);
            this.aaz = (TextView) this.aat.findViewById(w.h.no);
            this.aaA = this.aat.findViewById(w.h.divider_yes_no_button);
            this.aaB = this.aat.findViewById(w.h.bdDialog_divider_line);
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
            if (this.aam != -1) {
                if (this.aay != null) {
                    this.aay.setTextColor(this.aam);
                }
                if (this.aaz != null) {
                    this.aaz.setTextColor(this.aam);
                }
            }
            if (TextUtils.isEmpty(this.aak) || this.aay == null) {
                z = false;
            } else {
                this.aay.setText(this.aak);
                this.aay.setTag(this.aax);
                if (this.aao != null) {
                    this.aay.setOnClickListener(new View$OnClickListenerC0033a(this, this.aao));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aal) || this.aaz == null) {
                z2 = false;
            } else {
                this.aaz.setText(this.aal);
                if (this.aap != null) {
                    this.aaz.setOnClickListener(new View$OnClickListenerC0033a(this, this.aap));
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
                if (this.aai) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.aaj) {
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
            ((TbPageContext) gVar).getLayoutMode().t(this.aat);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aat != null) {
            this.aat.setBackgroundResource(w.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aaA != null) {
                this.aaA.setVisibility(0);
            }
            if (this.aaB != null) {
                this.aaB.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.aaA != null) {
            this.aaA.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aay != null && this.aaz != null && this.aaA != null && this.aaB != null) {
                this.aay.setVisibility(8);
                this.aaz.setVisibility(8);
                this.aaA.setVisibility(8);
                this.aaB.setVisibility(8);
            }
        } else if (z) {
            aq.d(this.aay, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aaz != null && this.aaA != null && this.aaB != null) {
                this.aaB.setVisibility(0);
                this.aay.setVisibility(0);
                this.aaz.setVisibility(8);
            }
        } else if (z2) {
            aq.d(this.aaz, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aay != null && this.aaA != null && this.aaB != null) {
                this.aaB.setVisibility(0);
                this.aaz.setVisibility(0);
                this.aay.setVisibility(8);
            }
        } else if (this.aay != null && this.aaz != null && this.aaB != null) {
            this.aaB.setVisibility(8);
            this.aay.setVisibility(8);
            this.aaz.setVisibility(8);
        }
    }

    public a tO() {
        return ax(false);
    }

    private a ax(boolean z) {
        if (!this.aav) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aas != null) {
            if (z) {
                j.a(this.aas, this.mActivity);
            } else {
                this.aas.show();
            }
        } else {
            this.aas = new AlertDialog.Builder(this.mActivity).create();
            this.aas.setCanceledOnTouchOutside(this.aaw && !this.mCancelable);
            this.aas.setCancelable(this.mCancelable);
            this.aas.setOnKeyListener(this.aar);
            if (this.aaq != null) {
                this.aas.setOnCancelListener(this.aaq);
            }
            if (z) {
                j.a(this.aas, this.mActivity);
            } else {
                this.aas.show();
            }
            if (this.aas.getWindow().getDecorView().getParent() != null) {
                Window window = this.aas.getWindow();
                if (this.aah == -1) {
                    this.aah = 17;
                }
                window.setGravity(this.aah);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    int tP = tP();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = n.heightPixels - (tP * 2);
                    } else {
                        attributes.width = n.widthPixels - (tP * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aat);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bg.a(this.aat, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tP() {
        return this.aan == 1 ? k.g(this.mActivity, w.f.ds40) : k.g(this.mActivity, w.f.ds90);
    }

    public boolean isShowing() {
        if (this.aas != null) {
            return this.aas.isShowing();
        }
        return false;
    }

    public void ay(boolean z) {
        if (this.aay != null) {
            this.aay.setClickable(z);
        }
    }

    public void az(boolean z) {
        if (this.aaz != null) {
            this.aaz.setClickable(z);
        }
    }

    public a tQ() {
        return ax(true);
    }

    public void hide() {
        if (this.aas != null) {
            this.aas.hide();
        }
    }

    public void dismiss() {
        if (this.aas != null) {
            j.b(this.aas, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0033a implements View.OnClickListener {
        private final a LI;
        private final b aaE;

        public View$OnClickListenerC0033a(a aVar, b bVar) {
            this.LI = aVar;
            this.aaE = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aaE != null) {
                this.aaE.onClick(this.LI);
            }
        }
    }

    public ViewGroup tR() {
        return this.aau;
    }

    public void A(Object obj) {
        this.aax = obj;
    }

    public Object tS() {
        return this.aax;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aas.getWindow();
    }

    public Dialog getDialog() {
        return this.aas;
    }

    public void aA(boolean z) {
        this.aai = z;
    }

    public void aB(boolean z) {
        this.aaj = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aar = onKeyListener;
    }

    public void reset() {
        this.aav = false;
    }
}
