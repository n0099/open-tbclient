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
    private String ZT;
    private String ZU;
    private b ZX;
    private b ZY;
    private DialogInterface.OnCancelListener ZZ;
    private DialogInterface.OnKeyListener aaa;
    private AlertDialog aab;
    private final ViewGroup aac;
    private ViewGroup aad;
    private Object aag;
    private TextView aah;
    private TextView aai;
    private View aaj;
    private View aak;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int ZQ = -1;
    private boolean ZR = false;
    private boolean ZS = false;
    private int ZV = -1;
    private int ZW = 0;
    private boolean aae = false;
    private boolean aaf = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cw(String str) {
        this.mTitle = str;
        return this;
    }

    public a bV(int i) {
        cw(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cx(String str) {
        this.mMessage = str;
        return this;
    }

    public a v(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.ZZ = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.ZT = str;
        this.ZX = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.ZU = str;
        this.ZY = bVar;
        return this;
    }

    public a bW(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZT = this.mActivity.getResources().getString(i);
            this.ZX = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.ZU = this.mActivity.getResources().getString(i);
            this.ZY = bVar;
        }
        return this;
    }

    public a at(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a au(boolean z) {
        this.aaf = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.aac = (ViewGroup) LayoutInflater.from(activity).inflate(w.j.dialog_bdalert, (ViewGroup) null);
        this.aad = (ViewGroup) this.aac.findViewById(w.h.real_view);
    }

    public a bX(int i) {
        if (isAutoNight()) {
            this.ZV = aq.getColor(i);
        } else {
            this.ZV = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a bY(int i) {
        this.ZW = i;
        return this;
    }

    public a b(com.baidu.adp.base.g<?> gVar) {
        boolean z;
        boolean z2 = true;
        if (!this.aae) {
            this.aae = true;
            LinearLayout linearLayout = (LinearLayout) this.aac.findViewById(w.h.dialog_content);
            this.aah = (TextView) this.aac.findViewById(w.h.yes);
            this.aai = (TextView) this.aac.findViewById(w.h.no);
            this.aaj = this.aac.findViewById(w.h.divider_yes_no_button);
            this.aak = this.aac.findViewById(w.h.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tp = tp();
                if (tp != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tp);
                }
            }
            c(gVar);
            if (this.ZV != -1) {
                if (this.aah != null) {
                    this.aah.setTextColor(this.ZV);
                }
                if (this.aai != null) {
                    this.aai.setTextColor(this.ZV);
                }
            }
            if (TextUtils.isEmpty(this.ZT) || this.aah == null) {
                z = false;
            } else {
                this.aah.setText(this.ZT);
                this.aah.setTag(this.aag);
                if (this.ZX != null) {
                    this.aah.setOnClickListener(new View$OnClickListenerC0034a(this, this.ZX));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.ZU) || this.aai == null) {
                z2 = false;
            } else {
                this.aai.setText(this.ZU);
                if (this.ZY != null) {
                    this.aai.setOnClickListener(new View$OnClickListenerC0034a(this, this.ZY));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View tp() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(w.j.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(w.h.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(w.h.message_view);
                if (this.ZR) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.ZS) {
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
            ((TbPageContext) gVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) gVar).getLayoutMode().t(this.aac);
            if (this.mContentView != null) {
                ((TbPageContext) gVar).getLayoutMode().t(this.mContentView);
            }
        }
        if (this.aac != null) {
            this.aac.setBackgroundResource(w.g.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.aaj != null) {
                this.aaj.setVisibility(0);
            }
            if (this.aak != null) {
                this.aak.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.aaj != null) {
            this.aaj.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.aah != null && this.aai != null && this.aaj != null && this.aak != null) {
                this.aah.setVisibility(8);
                this.aai.setVisibility(8);
                this.aaj.setVisibility(8);
                this.aak.setVisibility(8);
            }
        } else if (z) {
            aq.d(this.aah, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aai != null && this.aaj != null && this.aak != null) {
                this.aak.setVisibility(0);
                this.aah.setVisibility(0);
                this.aai.setVisibility(8);
            }
        } else if (z2) {
            aq.d(this.aai, w.g.dialog_single_button_bg_selector, skinType);
            if (this.aah != null && this.aaj != null && this.aak != null) {
                this.aak.setVisibility(0);
                this.aai.setVisibility(0);
                this.aah.setVisibility(8);
            }
        } else if (this.aah != null && this.aai != null && this.aak != null) {
            this.aak.setVisibility(8);
            this.aah.setVisibility(8);
            this.aai.setVisibility(8);
        }
    }

    public a tq() {
        return av(false);
    }

    private a av(boolean z) {
        if (!this.aae) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aab != null) {
            if (z) {
                j.a(this.aab, this.mActivity);
            } else {
                this.aab.show();
            }
        } else {
            this.aab = new AlertDialog.Builder(this.mActivity).create();
            this.aab.setCanceledOnTouchOutside(this.aaf && !this.mCancelable);
            this.aab.setCancelable(this.mCancelable);
            this.aab.setOnKeyListener(this.aaa);
            if (this.ZZ != null) {
                this.aab.setOnCancelListener(this.ZZ);
            }
            if (z) {
                j.a(this.aab, this.mActivity);
            } else {
                this.aab.show();
            }
            if (this.aab.getWindow().getDecorView().getParent() != null) {
                Window window = this.aab.getWindow();
                if (this.ZQ == -1) {
                    this.ZQ = 17;
                }
                window.setGravity(this.ZQ);
                window.setBackgroundDrawableResource(w.g.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics n = k.n(this.mActivity);
                if (n != null) {
                    attributes.width = n.widthPixels - (tr() * 2);
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.aac);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                bg.a(this.aac, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public int tr() {
        return this.ZW == 1 ? k.g(this.mActivity, w.f.ds40) : k.g(this.mActivity, w.f.ds90);
    }

    public boolean isShowing() {
        if (this.aab != null) {
            return this.aab.isShowing();
        }
        return false;
    }

    public void aw(boolean z) {
        if (this.aah != null) {
            this.aah.setClickable(z);
        }
    }

    public void ax(boolean z) {
        if (this.aai != null) {
            this.aai.setClickable(z);
        }
    }

    public a ts() {
        return av(true);
    }

    public void hide() {
        if (this.aab != null) {
            this.aab.hide();
        }
    }

    public void dismiss() {
        if (this.aab != null) {
            j.b(this.aab, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0034a implements View.OnClickListener {
        private final a Mf;
        private final b aan;

        public View$OnClickListenerC0034a(a aVar, b bVar) {
            this.Mf = aVar;
            this.aan = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.aan != null) {
                this.aan.onClick(this.Mf);
            }
        }
    }

    public ViewGroup tt() {
        return this.aad;
    }

    public void A(Object obj) {
        this.aag = obj;
    }

    public Object tu() {
        return this.aag;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.aab.getWindow();
    }

    public Dialog getDialog() {
        return this.aab;
    }

    public void ay(boolean z) {
        this.ZR = z;
    }

    public void az(boolean z) {
        this.ZS = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.aaa = onKeyListener;
    }

    public void reset() {
        this.aae = false;
    }
}
