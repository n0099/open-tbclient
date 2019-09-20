package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a aPm;

    /* loaded from: classes2.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    protected void dq(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Lw() {
        return this.aPm;
    }

    void a(a aVar) {
        this.aPm = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aOF = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aOG = a.h.aiapps_dialog_positive_title_ok;
        protected int aOD;
        protected final b aPn;
        private boolean aPo = false;
        protected final g asD;
        private Context mContext;

        public a(Context context) {
            this.asD = aU(context);
            this.asD.a(this);
            this.aPn = new b((ViewGroup) this.asD.getWindow().getDecorView());
            this.mContext = context;
            this.aOD = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected g aU(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a cn(int i) {
            this.aPn.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aPn.mTitle.setText(charSequence);
            } else {
                cc(true);
            }
            return this;
        }

        public a cc(boolean z) {
            this.aPn.aPr.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cm(int i) {
            if (this.aPn.aOs.getVisibility() != 0) {
                this.aPn.aOs.setVisibility(0);
            }
            this.aPn.aOr.setText(this.mContext.getText(i));
            Ly();
            return this;
        }

        public a gE(String str) {
            if (this.aPn.aOs.getVisibility() != 0) {
                this.aPn.aOs.setVisibility(0);
            }
            if (str != null) {
                this.aPn.aOr.setText(str);
                Ly();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aPn.aOs.getVisibility() != 0) {
                this.aPn.aOs.setVisibility(0);
            }
            if (spanned != null) {
                this.aPn.aOr.setMovementMethod(LinkMovementMethod.getInstance());
                this.aPn.aOr.setText(spanned);
                Ly();
            }
            return this;
        }

        public a Lx() {
            this.aPn.aOr.setGravity(3);
            return this;
        }

        private void Ly() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOD);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aPn.aOC.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aPn.aOt.setVisibility(8);
                if (this.aPn.aOu.getVisibility() == 0) {
                    this.aPn.aOx.setVisibility(8);
                }
            } else {
                this.aPn.aOt.setVisibility(0);
                if (this.aPn.aOu.getVisibility() == 0) {
                    this.aPn.aOx.setVisibility(0);
                }
                this.aPn.aOt.setText(charSequence);
                this.aPn.aOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.asD.dq(-1);
                        a.this.asD.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.asD, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Ls() {
            int i;
            TextView textView;
            if (this.aPn.aOt == null || this.aPn.aOt.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aPn.aOt;
                i = 1;
            }
            if (this.aPn.aOu != null && this.aPn.aOu.getVisibility() == 0) {
                i++;
                textView = this.aPn.aOu;
            }
            if (this.aPn.aOv != null && this.aPn.aOv.getVisibility() == 0) {
                i++;
                textView = this.aPn.aOv;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aPn.aOu.setVisibility(8);
                if (this.aPn.aOt.getVisibility() == 0) {
                    this.aPn.aOx.setVisibility(8);
                }
            } else {
                this.aPn.aOu.setVisibility(0);
                if (this.aPn.aOt.getVisibility() == 0) {
                    this.aPn.aOx.setVisibility(0);
                }
                this.aPn.aOu.setText(charSequence);
                this.aPn.aOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.asD.dq(-2);
                        a.this.asD.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.asD, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void cd(boolean z) {
            if (z) {
                this.aPn.aOw.setVisibility(0);
            } else {
                this.aPn.aOw.setVisibility(8);
            }
        }

        public a dt(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.aPn.aOw.setLayoutParams(layoutParams);
            return this;
        }

        public void du(int i) {
            this.aPn.aOA.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        }

        public a dv(int i) {
            this.aPn.mIcon.setImageResource(i);
            return this;
        }

        public a af(View view) {
            this.aPn.aOz.removeAllViews();
            this.aPn.aOz.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOD);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aPn.aOC.setLayoutParams(layoutParams);
            return this;
        }

        public a Lz() {
            this.aPn.aPA.setPadding(0, 0, 0, 0);
            return this;
        }

        public a LA() {
            ((ViewGroup.MarginLayoutParams) this.aPn.aPu.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a ce(boolean z) {
            this.aPn.aPs = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aPn.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.aPn.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(c cVar) {
            this.aPn.aPz = cVar;
            return this;
        }

        public a cf(boolean z) {
            this.aPn.aPC.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Bb() {
            this.asD.setCancelable(this.aPn.aPs.booleanValue());
            if (this.aPn.aPs.booleanValue()) {
                this.asD.setCanceledOnTouchOutside(false);
            }
            this.asD.setOnCancelListener(this.aPn.mOnCancelListener);
            this.asD.setOnDismissListener(this.aPn.mOnDismissListener);
            this.asD.setOnShowListener(this.aPn.aPt);
            if (this.aPn.mOnKeyListener != null) {
                this.asD.setOnKeyListener(this.aPn.mOnKeyListener);
            }
            LD();
            if (this.aPn.aPz != null) {
                this.aPn.aPz.a(this.asD, this.aPn);
            }
            this.asD.a(this);
            return this.asD;
        }

        @Deprecated
        public g cg(boolean z) {
            return LB();
        }

        public g LB() {
            g Bb = Bb();
            if (this.aPo) {
                Bb.getWindow().setType(2003);
            }
            try {
                Bb.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a(SmsLoginView.StatEvent.LOGIN_SHOW));
            return Bb;
        }

        protected Resources LC() {
            return this.mContext.getResources();
        }

        private void LD() {
            int color = LC().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = LC().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = LC().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = LC().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = LC().getColor(a.c.aiapps_dialog_gray);
            this.aPn.aOA.setBackground(LC().getDrawable(this.aPn.aPD != -1 ? this.aPn.aPD : a.e.aiapps_dialog_bg_white));
            this.aPn.mTitle.setTextColor(color);
            this.aPn.aOr.setTextColor(color4);
            this.aPn.aOt.setTextColor(this.aPn.aPw != color3 ? this.aPn.aPw : color3);
            if (this.aPn.aPx != color2) {
                this.aPn.aOu.setTextColor(this.aPn.aPx);
            } else if (this.aPn.aPy != -1) {
                this.aPn.aOu.setTextColor(LC().getColorStateList(this.aPn.aPy));
            } else {
                this.aPn.aOu.setTextColor(color2);
            }
            this.aPn.aOv.setTextColor(color2);
            int color6 = this.aPn.aPE != -1 ? LC().getColor(this.aPn.aPE) : color5;
            this.aPn.aOw.setBackgroundColor(color6);
            this.aPn.aOx.setBackgroundColor(color6);
            this.aPn.aOy.setBackgroundColor(color6);
            this.aPn.aOt.setBackground(LC().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aPn.aOu.setBackground(LC().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aPn.aOv.setBackground(LC().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Ls = Ls();
            if (Ls != null) {
                Ls.setBackground(this.aPn.aPF ? LC().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a ch(boolean z) {
            this.aPn.aOC.setVisibility(z ? 0 : 8);
            return this;
        }

        public a ci(boolean z) {
            this.aPn.aPF = z;
            return this;
        }

        public a cj(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aPn.aPv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a dw(int i) {
            return dx(LC().getColor(i));
        }

        public a C(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dx(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dw(i);
            }
            return this;
        }

        public a dx(int i) {
            this.aPn.aPw = i;
            this.aPn.aOt.setTextColor(i);
            return this;
        }

        public a dy(int i) {
            return dA(this.mContext.getResources().getColor(i));
        }

        public a dz(int i) {
            this.aPn.aPy = i;
            return this;
        }

        public a D(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dA(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dy(i);
            }
            return this;
        }

        public a dA(int i) {
            this.aPn.aPx = i;
            return this;
        }

        public ViewGroup LE() {
            return this.aPn.aOz;
        }

        public a j(int i, int i2, int i3, int i4) {
            this.aPn.aPB.setPadding(i, i2, i3, i4);
            return this;
        }

        public a dB(int i) {
            this.aPn.aPD = i;
            this.aPn.aOA.setBackgroundResource(i);
            return this;
        }

        public a dC(int i) {
            this.aPn.aPE = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aJx;
        public RelativeLayout aOA;
        public LinearLayout aOC;
        public TextView aOr;
        public LinearLayout aOs;
        public TextView aOt;
        public TextView aOu;
        public TextView aOv;
        public View aOw;
        public View aOx;
        public View aOy;
        public FrameLayout aOz;
        public FrameLayout aPA;
        public FrameLayout aPB;
        public View aPC;
        public LinearLayout aPr;
        public DialogInterface.OnShowListener aPt;
        public View aPu;
        public View aPv;
        public int aPw;
        public int aPx;
        public c aPz;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aPs = true;
        public int aPy = -1;
        public int aPD = -1;
        public int aPE = -1;
        public boolean aPF = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aPB = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aPr = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aOr = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aOs = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aOt = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aOu = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aOv = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aOx = viewGroup.findViewById(a.f.divider3);
            this.aOy = viewGroup.findViewById(a.f.divider4);
            this.aPu = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aOz = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aOA = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aOw = viewGroup.findViewById(a.f.divider2);
            this.aJx = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aOC = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aPv = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aPA = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aPC = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.Pj() || com.baidu.swan.apps.an.a.Pi()) {
                int dimensionPixelSize = this.aOr.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aOr.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.aPw = color;
            this.aPx = color;
        }
    }
}
