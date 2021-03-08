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
    private a dDI;

    /* loaded from: classes8.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    public void iN(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a aHU() {
        return this.dDI;
    }

    void a(a aVar) {
        this.dDI = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static final int dDc = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dDd = a.h.aiapps_dialog_positive_title_ok;
        protected final g cUR;
        protected final b dDJ;
        private boolean dDK = false;
        protected int dDa;
        private Context mContext;

        public a(Context context) {
            this.cUR = cI(context);
            this.cUR.a(this);
            this.dDJ = new b((ViewGroup) this.cUR.getWindow().getDecorView());
            this.mContext = context;
            this.dDa = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aHV() {
            if (ah.isScreenLand()) {
                iU(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                iR(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g cI(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a gS(int i) {
            this.dDJ.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dDJ.mTitle.setText(charSequence);
            } else {
                gR(true);
            }
            return this;
        }

        public a gR(boolean z) {
            this.dDJ.dDN.setVisibility(z ? 8 : 0);
            return this;
        }

        public a gR(int i) {
            if (this.dDJ.dCP.getVisibility() != 0) {
                this.dDJ.dCP.setVisibility(0);
            }
            this.dDJ.dCO.setText(this.mContext.getText(i));
            aHX();
            return this;
        }

        public a rE(String str) {
            if (this.dDJ.dCP.getVisibility() != 0) {
                this.dDJ.dCP.setVisibility(0);
            }
            if (str != null) {
                this.dDJ.dCO.setText(str);
                aHX();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dDJ.dCP.getVisibility() != 0) {
                this.dDJ.dCP.setVisibility(0);
            }
            if (spanned != null) {
                this.dDJ.dCO.setMovementMethod(LinkMovementMethod.getInstance());
                this.dDJ.dCO.setText(spanned);
                aHX();
            }
            return this;
        }

        public a aHW() {
            this.dDJ.dCO.setGravity(3);
            return this;
        }

        private void aHX() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dDa);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dDJ.dCZ.setLayoutParams(layoutParams);
        }

        public a iR(int i) {
            this.dDJ.jd(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dDJ.dCQ.setVisibility(8);
                if (this.dDJ.dCR.getVisibility() == 0) {
                    this.dDJ.dCU.setVisibility(8);
                }
            } else {
                this.dDJ.dCQ.setVisibility(0);
                if (this.dDJ.dCR.getVisibility() == 0) {
                    this.dDJ.dCU.setVisibility(0);
                }
                this.dDJ.dCQ.setText(charSequence);
                this.dDJ.dCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cUR.iN(-1);
                        a.this.cUR.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cUR, -1);
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
                        a.this.cUR.iN(i);
                        a.this.cUR.dismiss();
                        onClickListener.onClick(a.this.cUR, i);
                    }
                });
            }
        }

        public TextView aHP() {
            TextView textView;
            int i = 0;
            if (this.dDJ.dCQ == null || this.dDJ.dCQ.getVisibility() != 0) {
                textView = null;
            } else {
                textView = this.dDJ.dCQ;
                i = 1;
            }
            if (this.dDJ.dCR != null && this.dDJ.dCR.getVisibility() == 0) {
                i++;
                textView = this.dDJ.dCR;
            }
            if (this.dDJ.dCS != null && this.dDJ.dCS.getVisibility() == 0) {
                i++;
                textView = this.dDJ.dCS;
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
                this.dDJ.dCR.setVisibility(8);
                if (this.dDJ.dCQ.getVisibility() == 0) {
                    this.dDJ.dCU.setVisibility(8);
                }
            } else {
                this.dDJ.dCR.setVisibility(0);
                if (this.dDJ.dCQ.getVisibility() == 0) {
                    this.dDJ.dCU.setVisibility(0);
                }
                this.dDJ.dCR.setText(charSequence);
                this.dDJ.dCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cUR.iN(-2);
                        a.this.cUR.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cUR, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gS(boolean z) {
            if (z) {
                this.dDJ.dCT.setVisibility(0);
            } else {
                this.dDJ.dCT.setVisibility(8);
            }
            return this;
        }

        public a iS(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dDJ.dCT.setLayoutParams(layoutParams);
            return this;
        }

        public void iT(int i) {
            this.dDJ.dCX.getLayoutParams().height = i;
            this.dDJ.dCX.requestLayout();
        }

        public void iU(int i) {
            this.dDJ.dCX.getLayoutParams().width = i;
            this.dDJ.dCX.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dDJ.dCS.setVisibility(0);
            if (this.dDJ.dCQ.getVisibility() == 0) {
                this.dDJ.dCV.setVisibility(0);
            }
            this.dDJ.dCS.setText(charSequence);
            this.dDJ.dCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cUR.iN(-3);
                    a.this.cUR.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cUR, -3);
                    }
                }
            });
            return this;
        }

        public a iV(int i) {
            this.dDJ.dwR.setImageResource(i);
            return this;
        }

        public a aG(View view) {
            this.dDJ.dCW.removeAllViews();
            this.dDJ.dCW.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dDa);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dDJ.dCZ.setLayoutParams(layoutParams);
            return this;
        }

        public a aHY() {
            this.dDJ.dDW.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aHZ() {
            ((ViewGroup.MarginLayoutParams) this.dDJ.dDQ.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gT(boolean z) {
            this.dDJ.dDO = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dDJ.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dDJ.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dDJ.dDP = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dDJ.dDV = cVar;
            return this;
        }

        public a gU(boolean z) {
            this.dDJ.dDY.setVisibility(z ? 0 : 8);
            return this;
        }

        public g aqn() {
            this.cUR.setCancelable(this.dDJ.dDO.booleanValue());
            if (this.dDJ.dDO.booleanValue()) {
                this.cUR.setCanceledOnTouchOutside(false);
            }
            this.cUR.setOnCancelListener(this.dDJ.mOnCancelListener);
            this.cUR.setOnDismissListener(this.dDJ.mOnDismissListener);
            this.cUR.setOnShowListener(this.dDJ.dDP);
            if (this.dDJ.mOnKeyListener != null) {
                this.cUR.setOnKeyListener(this.dDJ.mOnKeyListener);
            }
            aIc();
            if (this.dDJ.dDV != null) {
                this.dDJ.dDV.a(this.cUR, this.dDJ);
            }
            this.cUR.a(this);
            return this.cUR;
        }

        @Deprecated
        public g gV(boolean z) {
            return aIa();
        }

        public g aIa() {
            g aqn = aqn();
            if (this.dDK) {
                aqn.getWindow().setType(2003);
            }
            try {
                aqn.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return aqn;
        }

        protected Resources aIb() {
            return this.mContext.getResources();
        }

        private void aIc() {
            int color = aIb().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = aIb().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = aIb().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = aIb().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = aIb().getColor(a.c.aiapps_dialog_gray);
            this.dDJ.dCX.setBackground(aIb().getDrawable(this.dDJ.dDZ != -1 ? this.dDJ.dDZ : a.e.aiapps_dialog_bg_white));
            this.dDJ.mTitle.setTextColor(color);
            this.dDJ.dCO.setTextColor(color4);
            this.dDJ.dCQ.setTextColor(this.dDJ.dDS != color3 ? this.dDJ.dDS : color3);
            if (this.dDJ.dDT != color2) {
                this.dDJ.dCR.setTextColor(this.dDJ.dDT);
            } else if (this.dDJ.dDU != -1) {
                this.dDJ.dCR.setTextColor(aIb().getColorStateList(this.dDJ.dDU));
            } else {
                this.dDJ.dCR.setTextColor(color2);
            }
            this.dDJ.dCS.setTextColor(color2);
            int color6 = this.dDJ.dEa != -1 ? aIb().getColor(this.dDJ.dEa) : color5;
            this.dDJ.dCT.setBackgroundColor(color6);
            this.dDJ.dCU.setBackgroundColor(color6);
            this.dDJ.dCV.setBackgroundColor(color6);
            this.dDJ.dCQ.setBackground(aIb().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dDJ.dCR.setBackground(aIb().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dDJ.dCS.setBackground(aIb().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView aHP = aHP();
            if (aHP != null) {
                aHP.setBackground(this.dDJ.dEb ? aIb().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gW(boolean z) {
            this.dDJ.dCZ.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gX(boolean z) {
            this.dDJ.dEb = z;
            return this;
        }

        public a gY(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dDJ.dDR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a iW(int i) {
            return iX(aIb().getColor(i));
        }

        public a aa(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    iX(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iW(i);
            }
            return this;
        }

        public a iX(int i) {
            this.dDJ.dDS = i;
            this.dDJ.dCQ.setTextColor(i);
            return this;
        }

        public a iY(int i) {
            return ja(this.mContext.getResources().getColor(i));
        }

        public a iZ(int i) {
            this.dDJ.dDU = i;
            return this;
        }

        public a ab(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ja(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iY(i);
            }
            return this;
        }

        public a ja(int i) {
            this.dDJ.dDT = i;
            return this;
        }

        public ViewGroup aId() {
            return this.dDJ.dCW;
        }

        public a r(int i, int i2, int i3, int i4) {
            this.dDJ.dDX.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jb(int i) {
            this.dDJ.dDZ = i;
            this.dDJ.dCX.setBackgroundResource(i);
            return this;
        }

        public a jc(int i) {
            this.dDJ.dEa = i;
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public ViewGroup bcD;
        public TextView dCO;
        public LinearLayout dCP;
        public TextView dCQ;
        public TextView dCR;
        public TextView dCS;
        public View dCT;
        public View dCU;
        public View dCV;
        public FrameLayout dCW;
        public RelativeLayout dCX;
        public LinearLayout dCZ;
        public LinearLayout dDN;
        public DialogInterface.OnShowListener dDP;
        public View dDQ;
        public View dDR;
        public int dDS;
        public int dDT;
        public c dDV;
        public FrameLayout dDW;
        public FrameLayout dDX;
        public View dDY;
        public ImageView dwR;
        public SwanAppScrollView dxi;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean dDO = true;
        public int dDU = -1;
        public int dDZ = -1;
        public int dEa = -1;
        public boolean dEb = true;

        public b(ViewGroup viewGroup) {
            this.bcD = viewGroup;
            this.dDX = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dDN = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.dCO = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.dCP = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.dCQ = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dCR = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dCS = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.dCU = viewGroup.findViewById(a.f.divider3);
            this.dCV = viewGroup.findViewById(a.f.divider4);
            this.dDQ = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dCW = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dwR = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.dCX = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dCT = viewGroup.findViewById(a.f.divider2);
            this.dxi = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.dCZ = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dDR = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dDW = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dDY = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.dCO.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.dCO.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.bcD.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.dDS = color;
            this.dDT = color;
        }

        public void jd(int i) {
            this.dxi.setMaxHeight(i);
        }
    }
}
