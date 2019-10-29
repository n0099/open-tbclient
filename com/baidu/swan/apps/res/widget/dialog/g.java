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
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a biv;

    /* loaded from: classes2.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    protected void el(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Qp() {
        return this.biv;
    }

    void a(a aVar) {
        this.biv = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int bhM = a.h.aiapps_dialog_negative_title_cancel;
        public static final int bhN = a.h.aiapps_dialog_positive_title_ok;
        protected final g aLT;
        protected int bhK;
        protected final b biw;
        private boolean bix = false;
        private Context mContext;

        public a(Context context) {
            this.aLT = aW(context);
            this.aLT.a(this);
            this.biw = new b((ViewGroup) this.aLT.getWindow().getDecorView());
            this.mContext = context;
            this.bhK = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected g aW(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a dj(int i) {
            this.biw.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.biw.mTitle.setText(charSequence);
            } else {
                ct(true);
            }
            return this;
        }

        public a ct(boolean z) {
            this.biw.biA.setVisibility(z ? 8 : 0);
            return this;
        }

        public a di(int i) {
            if (this.biw.bhz.getVisibility() != 0) {
                this.biw.bhz.setVisibility(0);
            }
            this.biw.bhy.setText(this.mContext.getText(i));
            Qr();
            return this;
        }

        public a hi(String str) {
            if (this.biw.bhz.getVisibility() != 0) {
                this.biw.bhz.setVisibility(0);
            }
            if (str != null) {
                this.biw.bhy.setText(str);
                Qr();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.biw.bhz.getVisibility() != 0) {
                this.biw.bhz.setVisibility(0);
            }
            if (spanned != null) {
                this.biw.bhy.setMovementMethod(LinkMovementMethod.getInstance());
                this.biw.bhy.setText(spanned);
                Qr();
            }
            return this;
        }

        public a Qq() {
            this.biw.bhy.setGravity(3);
            return this;
        }

        private void Qr() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhK);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.biw.bhJ.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.biw.bhA.setVisibility(8);
                if (this.biw.bhB.getVisibility() == 0) {
                    this.biw.bhE.setVisibility(8);
                }
            } else {
                this.biw.bhA.setVisibility(0);
                if (this.biw.bhB.getVisibility() == 0) {
                    this.biw.bhE.setVisibility(0);
                }
                this.biw.bhA.setText(charSequence);
                this.biw.bhA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aLT.el(-1);
                        a.this.aLT.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.aLT, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Ql() {
            int i;
            TextView textView;
            if (this.biw.bhA == null || this.biw.bhA.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.biw.bhA;
                i = 1;
            }
            if (this.biw.bhB != null && this.biw.bhB.getVisibility() == 0) {
                i++;
                textView = this.biw.bhB;
            }
            if (this.biw.bhC != null && this.biw.bhC.getVisibility() == 0) {
                i++;
                textView = this.biw.bhC;
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
                this.biw.bhB.setVisibility(8);
                if (this.biw.bhA.getVisibility() == 0) {
                    this.biw.bhE.setVisibility(8);
                }
            } else {
                this.biw.bhB.setVisibility(0);
                if (this.biw.bhA.getVisibility() == 0) {
                    this.biw.bhE.setVisibility(0);
                }
                this.biw.bhB.setText(charSequence);
                this.biw.bhB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aLT.el(-2);
                        a.this.aLT.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.aLT, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void cu(boolean z) {
            if (z) {
                this.biw.bhD.setVisibility(0);
            } else {
                this.biw.bhD.setVisibility(8);
            }
        }

        public a eo(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.biw.bhD.setLayoutParams(layoutParams);
            return this;
        }

        public void ep(int i) {
            this.biw.bhH.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        }

        public a eq(int i) {
            this.biw.mIcon.setImageResource(i);
            return this;
        }

        public a al(View view) {
            this.biw.bhG.removeAllViews();
            this.biw.bhG.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhK);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.biw.bhJ.setLayoutParams(layoutParams);
            return this;
        }

        public a Qs() {
            this.biw.biJ.setPadding(0, 0, 0, 0);
            return this;
        }

        public a Qt() {
            ((ViewGroup.MarginLayoutParams) this.biw.biD.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a cv(boolean z) {
            this.biw.biB = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.biw.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.biw.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(c cVar) {
            this.biw.biI = cVar;
            return this;
        }

        public a cw(boolean z) {
            this.biw.biL.setVisibility(z ? 0 : 8);
            return this;
        }

        public g FW() {
            this.aLT.setCancelable(this.biw.biB.booleanValue());
            if (this.biw.biB.booleanValue()) {
                this.aLT.setCanceledOnTouchOutside(false);
            }
            this.aLT.setOnCancelListener(this.biw.mOnCancelListener);
            this.aLT.setOnDismissListener(this.biw.mOnDismissListener);
            this.aLT.setOnShowListener(this.biw.biC);
            if (this.biw.mOnKeyListener != null) {
                this.aLT.setOnKeyListener(this.biw.mOnKeyListener);
            }
            Qw();
            if (this.biw.biI != null) {
                this.biw.biI.a(this.aLT, this.biw);
            }
            this.aLT.a(this);
            return this.aLT;
        }

        @Deprecated
        public g cx(boolean z) {
            return Qu();
        }

        public g Qu() {
            g FW = FW();
            if (this.bix) {
                FW.getWindow().setType(2003);
            }
            try {
                FW.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return FW;
        }

        protected Resources Qv() {
            return this.mContext.getResources();
        }

        private void Qw() {
            int color = Qv().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = Qv().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = Qv().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = Qv().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = Qv().getColor(a.c.aiapps_dialog_gray);
            this.biw.bhH.setBackground(Qv().getDrawable(this.biw.biM != -1 ? this.biw.biM : a.e.aiapps_dialog_bg_white));
            this.biw.mTitle.setTextColor(color);
            this.biw.bhy.setTextColor(color4);
            this.biw.bhA.setTextColor(this.biw.biF != color3 ? this.biw.biF : color3);
            if (this.biw.biG != color2) {
                this.biw.bhB.setTextColor(this.biw.biG);
            } else if (this.biw.biH != -1) {
                this.biw.bhB.setTextColor(Qv().getColorStateList(this.biw.biH));
            } else {
                this.biw.bhB.setTextColor(color2);
            }
            this.biw.bhC.setTextColor(color2);
            int color6 = this.biw.biN != -1 ? Qv().getColor(this.biw.biN) : color5;
            this.biw.bhD.setBackgroundColor(color6);
            this.biw.bhE.setBackgroundColor(color6);
            this.biw.bhF.setBackgroundColor(color6);
            this.biw.bhA.setBackground(Qv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.biw.bhB.setBackground(Qv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.biw.bhC.setBackground(Qv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Ql = Ql();
            if (Ql != null) {
                Ql.setBackground(this.biw.biO ? Qv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a cy(boolean z) {
            this.biw.bhJ.setVisibility(z ? 0 : 8);
            return this;
        }

        public a cz(boolean z) {
            this.biw.biO = z;
            return this;
        }

        public a cA(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.biw.biE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a er(int i) {
            return es(Qv().getColor(i));
        }

        public a C(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    es(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                er(i);
            }
            return this;
        }

        public a es(int i) {
            this.biw.biF = i;
            this.biw.bhA.setTextColor(i);
            return this;
        }

        public a et(int i) {
            return ev(this.mContext.getResources().getColor(i));
        }

        public a eu(int i) {
            this.biw.biH = i;
            return this;
        }

        public a D(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ev(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                et(i);
            }
            return this;
        }

        public a ev(int i) {
            this.biw.biG = i;
            return this;
        }

        public ViewGroup Qx() {
            return this.biw.bhG;
        }

        public a k(int i, int i2, int i3, int i4) {
            this.biw.biK.setPadding(i, i2, i3, i4);
            return this;
        }

        public a ew(int i) {
            this.biw.biM = i;
            this.biw.bhH.setBackgroundResource(i);
            return this;
        }

        public a ex(int i) {
            this.biw.biN = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public ViewGroup Zo;
        public SwanAppScrollView bcL;
        public TextView bhA;
        public TextView bhB;
        public TextView bhC;
        public View bhD;
        public View bhE;
        public View bhF;
        public FrameLayout bhG;
        public RelativeLayout bhH;
        public LinearLayout bhJ;
        public TextView bhy;
        public LinearLayout bhz;
        public LinearLayout biA;
        public DialogInterface.OnShowListener biC;
        public View biD;
        public View biE;
        public int biF;
        public int biG;
        public c biI;
        public FrameLayout biJ;
        public FrameLayout biK;
        public View biL;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean biB = true;
        public int biH = -1;
        public int biM = -1;
        public int biN = -1;
        public boolean biO = true;

        public b(ViewGroup viewGroup) {
            this.Zo = viewGroup;
            this.biK = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.biA = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.bhy = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.bhz = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.bhA = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.bhB = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.bhC = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.bhE = viewGroup.findViewById(a.f.divider3);
            this.bhF = viewGroup.findViewById(a.f.divider4);
            this.biD = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bhG = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.bhH = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.bhD = viewGroup.findViewById(a.f.divider2);
            this.bcL = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.bhJ = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.biE = viewGroup.findViewById(a.f.dialog_customPanel);
            this.biJ = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.biL = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.TZ() || com.baidu.swan.apps.an.a.TY()) {
                int dimensionPixelSize = this.bhy.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.bhy.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.Zo.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.biF = color;
            this.biG = color;
        }
    }
}
