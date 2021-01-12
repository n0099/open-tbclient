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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes8.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dAc;

    /* loaded from: classes8.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    public void iJ(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a aHy() {
        return this.dAc;
    }

    void a(a aVar) {
        this.dAc = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static final int dzw = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dzx = a.h.aiapps_dialog_positive_title_ok;
        protected final g cRe;
        protected final b dAd;
        private boolean dAe = false;
        protected int dzu;
        private Context mContext;

        public a(Context context) {
            this.cRe = cK(context);
            this.cRe.a(this);
            this.dAd = new b((ViewGroup) this.cRe.getWindow().getDecorView());
            this.mContext = context;
            this.dzu = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aHz() {
            if (ah.isScreenLand()) {
                iQ(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                iN(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g cK(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a gO(int i) {
            this.dAd.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dAd.mTitle.setText(charSequence);
            } else {
                gP(true);
            }
            return this;
        }

        public a gP(boolean z) {
            this.dAd.dAh.setVisibility(z ? 8 : 0);
            return this;
        }

        public a gN(int i) {
            if (this.dAd.dzj.getVisibility() != 0) {
                this.dAd.dzj.setVisibility(0);
            }
            this.dAd.dzi.setText(this.mContext.getText(i));
            aHB();
            return this;
        }

        public a re(String str) {
            if (this.dAd.dzj.getVisibility() != 0) {
                this.dAd.dzj.setVisibility(0);
            }
            if (str != null) {
                this.dAd.dzi.setText(str);
                aHB();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dAd.dzj.getVisibility() != 0) {
                this.dAd.dzj.setVisibility(0);
            }
            if (spanned != null) {
                this.dAd.dzi.setMovementMethod(LinkMovementMethod.getInstance());
                this.dAd.dzi.setText(spanned);
                aHB();
            }
            return this;
        }

        public a aHA() {
            this.dAd.dzi.setGravity(3);
            return this;
        }

        private void aHB() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dzu);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dAd.dzt.setLayoutParams(layoutParams);
        }

        public a iN(int i) {
            this.dAd.iZ(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dAd.dzk.setVisibility(8);
                if (this.dAd.dzl.getVisibility() == 0) {
                    this.dAd.dzo.setVisibility(8);
                }
            } else {
                this.dAd.dzk.setVisibility(0);
                if (this.dAd.dzl.getVisibility() == 0) {
                    this.dAd.dzo.setVisibility(0);
                }
                this.dAd.dzk.setText(charSequence);
                this.dAd.dzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cRe.iJ(-1);
                        a.this.cRe.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cRe, -1);
                        }
                    }
                });
            }
            return this;
        }

        public void a(View view, final int i, final DialogInterface.OnClickListener onClickListener) {
            if (view != null && onClickListener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        a.this.cRe.iJ(i);
                        a.this.cRe.dismiss();
                        onClickListener.onClick(a.this.cRe, i);
                    }
                });
            }
        }

        public TextView aHt() {
            TextView textView;
            int i = 0;
            if (this.dAd.dzk == null || this.dAd.dzk.getVisibility() != 0) {
                textView = null;
            } else {
                textView = this.dAd.dzk;
                i = 1;
            }
            if (this.dAd.dzl != null && this.dAd.dzl.getVisibility() == 0) {
                i++;
                textView = this.dAd.dzl;
            }
            if (this.dAd.dzm != null && this.dAd.dzm.getVisibility() == 0) {
                i++;
                textView = this.dAd.dzm;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            return b(this.mContext.getText(i), onClickListener);
        }

        public a b(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dAd.dzl.setVisibility(8);
                if (this.dAd.dzk.getVisibility() == 0) {
                    this.dAd.dzo.setVisibility(8);
                }
            } else {
                this.dAd.dzl.setVisibility(0);
                if (this.dAd.dzk.getVisibility() == 0) {
                    this.dAd.dzo.setVisibility(0);
                }
                this.dAd.dzl.setText(charSequence);
                this.dAd.dzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cRe.iJ(-2);
                        a.this.cRe.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cRe, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gQ(boolean z) {
            if (z) {
                this.dAd.dzn.setVisibility(0);
            } else {
                this.dAd.dzn.setVisibility(8);
            }
            return this;
        }

        public a iO(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dAd.dzn.setLayoutParams(layoutParams);
            return this;
        }

        public void iP(int i) {
            this.dAd.dzr.getLayoutParams().height = i;
            this.dAd.dzr.requestLayout();
        }

        public void iQ(int i) {
            this.dAd.dzr.getLayoutParams().width = i;
            this.dAd.dzr.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dAd.dzm.setVisibility(0);
            if (this.dAd.dzk.getVisibility() == 0) {
                this.dAd.dzp.setVisibility(0);
            }
            this.dAd.dzm.setText(charSequence);
            this.dAd.dzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cRe.iJ(-3);
                    a.this.cRe.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cRe, -3);
                    }
                }
            });
            return this;
        }

        public a iR(int i) {
            this.dAd.dtf.setImageResource(i);
            return this;
        }

        public a aK(View view) {
            this.dAd.dzq.removeAllViews();
            this.dAd.dzq.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dzu);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dAd.dzt.setLayoutParams(layoutParams);
            return this;
        }

        public a aHC() {
            this.dAd.dAq.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aHD() {
            ((ViewGroup.MarginLayoutParams) this.dAd.dAk.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gR(boolean z) {
            this.dAd.dAi = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dAd.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dAd.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dAd.dAj = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dAd.dAp = cVar;
            return this;
        }

        public a gS(boolean z) {
            this.dAd.dAs.setVisibility(z ? 0 : 8);
            return this;
        }

        public g apM() {
            this.cRe.setCancelable(this.dAd.dAi.booleanValue());
            if (this.dAd.dAi.booleanValue()) {
                this.cRe.setCanceledOnTouchOutside(false);
            }
            this.cRe.setOnCancelListener(this.dAd.mOnCancelListener);
            this.cRe.setOnDismissListener(this.dAd.mOnDismissListener);
            this.cRe.setOnShowListener(this.dAd.dAj);
            if (this.dAd.mOnKeyListener != null) {
                this.cRe.setOnKeyListener(this.dAd.mOnKeyListener);
            }
            aHG();
            if (this.dAd.dAp != null) {
                this.dAd.dAp.a(this.cRe, this.dAd);
            }
            this.cRe.a(this);
            return this.cRe;
        }

        @Deprecated
        public g gT(boolean z) {
            return aHE();
        }

        public g aHE() {
            g apM = apM();
            if (this.dAe) {
                apM.getWindow().setType(2003);
            }
            try {
                apM.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return apM;
        }

        protected Resources aHF() {
            return this.mContext.getResources();
        }

        private void aHG() {
            int color = aHF().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = aHF().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = aHF().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = aHF().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = aHF().getColor(a.c.aiapps_dialog_gray);
            this.dAd.dzr.setBackground(aHF().getDrawable(this.dAd.dAt != -1 ? this.dAd.dAt : a.e.aiapps_dialog_bg_white));
            this.dAd.mTitle.setTextColor(color);
            this.dAd.dzi.setTextColor(color4);
            this.dAd.dzk.setTextColor(this.dAd.dAm != color3 ? this.dAd.dAm : color3);
            if (this.dAd.dAn != color2) {
                this.dAd.dzl.setTextColor(this.dAd.dAn);
            } else if (this.dAd.dAo != -1) {
                this.dAd.dzl.setTextColor(aHF().getColorStateList(this.dAd.dAo));
            } else {
                this.dAd.dzl.setTextColor(color2);
            }
            this.dAd.dzm.setTextColor(color2);
            int color6 = this.dAd.dAu != -1 ? aHF().getColor(this.dAd.dAu) : color5;
            this.dAd.dzn.setBackgroundColor(color6);
            this.dAd.dzo.setBackgroundColor(color6);
            this.dAd.dzp.setBackgroundColor(color6);
            this.dAd.dzk.setBackground(aHF().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dAd.dzl.setBackground(aHF().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dAd.dzm.setBackground(aHF().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView aHt = aHt();
            if (aHt != null) {
                aHt.setBackground(this.dAd.dAv ? aHF().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gU(boolean z) {
            this.dAd.dzt.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gV(boolean z) {
            this.dAd.dAv = z;
            return this;
        }

        public a gW(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dAd.dAl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a iS(int i) {
            return iT(aHF().getColor(i));
        }

        public a X(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    iT(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iS(i);
            }
            return this;
        }

        public a iT(int i) {
            this.dAd.dAm = i;
            this.dAd.dzk.setTextColor(i);
            return this;
        }

        public a iU(int i) {
            return iW(this.mContext.getResources().getColor(i));
        }

        public a iV(int i) {
            this.dAd.dAo = i;
            return this;
        }

        public a Y(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    iW(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iU(i);
            }
            return this;
        }

        public a iW(int i) {
            this.dAd.dAn = i;
            return this;
        }

        public ViewGroup aHH() {
            return this.dAd.dzq;
        }

        public a r(int i, int i2, int i3, int i4) {
            this.dAd.dAr.setPadding(i, i2, i3, i4);
            return this;
        }

        public a iX(int i) {
            this.dAd.dAt = i;
            this.dAd.dzr.setBackgroundResource(i);
            return this;
        }

        public a iY(int i) {
            this.dAd.dAu = i;
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public ViewGroup aXW;
        public LinearLayout dAh;
        public DialogInterface.OnShowListener dAj;
        public View dAk;
        public View dAl;
        public int dAm;
        public int dAn;
        public c dAp;
        public FrameLayout dAq;
        public FrameLayout dAr;
        public View dAs;
        public ImageView dtf;
        public SwanAppScrollView dtx;
        public TextView dzi;
        public LinearLayout dzj;
        public TextView dzk;
        public TextView dzl;
        public TextView dzm;
        public View dzn;
        public View dzo;
        public View dzp;
        public FrameLayout dzq;
        public RelativeLayout dzr;
        public LinearLayout dzt;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean dAi = true;
        public int dAo = -1;
        public int dAt = -1;
        public int dAu = -1;
        public boolean dAv = true;

        public b(ViewGroup viewGroup) {
            this.aXW = viewGroup;
            this.dAr = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dAh = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.dzi = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.dzj = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.dzk = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dzl = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dzm = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.dzo = viewGroup.findViewById(a.f.divider3);
            this.dzp = viewGroup.findViewById(a.f.divider4);
            this.dAk = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dzq = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dtf = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.dzr = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dzn = viewGroup.findViewById(a.f.divider2);
            this.dtx = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.dzt = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dAl = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dAq = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dAs = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.dzi.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.dzi.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.aXW.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.dAm = color;
            this.dAn = color;
        }

        public void iZ(int i) {
            this.dtx.setMaxHeight(i);
        }
    }
}
