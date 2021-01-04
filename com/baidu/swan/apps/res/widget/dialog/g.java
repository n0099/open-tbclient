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
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dEO;

    /* loaded from: classes9.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    public void kp(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a aLr() {
        return this.dEO;
    }

    void a(a aVar) {
        this.dEO = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final int dEi = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dEj = a.h.aiapps_dialog_positive_title_ok;
        protected final g cVQ;
        protected final b dEP;
        private boolean dEQ = false;
        protected int dEg;
        private Context mContext;

        public a(Context context) {
            this.cVQ = cL(context);
            this.cVQ.a(this);
            this.dEP = new b((ViewGroup) this.cVQ.getWindow().getDecorView());
            this.mContext = context;
            this.dEg = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aLs() {
            if (ah.isScreenLand()) {
                kw(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                kt(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g cL(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a iu(int i) {
            this.dEP.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dEP.mTitle.setText(charSequence);
            } else {
                gT(true);
            }
            return this;
        }

        public a gT(boolean z) {
            this.dEP.dET.setVisibility(z ? 8 : 0);
            return this;
        }

        public a it(int i) {
            if (this.dEP.dDV.getVisibility() != 0) {
                this.dEP.dDV.setVisibility(0);
            }
            this.dEP.dDU.setText(this.mContext.getText(i));
            aLu();
            return this;
        }

        public a sp(String str) {
            if (this.dEP.dDV.getVisibility() != 0) {
                this.dEP.dDV.setVisibility(0);
            }
            if (str != null) {
                this.dEP.dDU.setText(str);
                aLu();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dEP.dDV.getVisibility() != 0) {
                this.dEP.dDV.setVisibility(0);
            }
            if (spanned != null) {
                this.dEP.dDU.setMovementMethod(LinkMovementMethod.getInstance());
                this.dEP.dDU.setText(spanned);
                aLu();
            }
            return this;
        }

        public a aLt() {
            this.dEP.dDU.setGravity(3);
            return this;
        }

        private void aLu() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dEg);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dEP.dEf.setLayoutParams(layoutParams);
        }

        public a kt(int i) {
            this.dEP.kF(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dEP.dDW.setVisibility(8);
                if (this.dEP.dDX.getVisibility() == 0) {
                    this.dEP.dEa.setVisibility(8);
                }
            } else {
                this.dEP.dDW.setVisibility(0);
                if (this.dEP.dDX.getVisibility() == 0) {
                    this.dEP.dEa.setVisibility(0);
                }
                this.dEP.dDW.setText(charSequence);
                this.dEP.dDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cVQ.kp(-1);
                        a.this.cVQ.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cVQ, -1);
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
                        a.this.cVQ.kp(i);
                        a.this.cVQ.dismiss();
                        onClickListener.onClick(a.this.cVQ, i);
                    }
                });
            }
        }

        public TextView aLm() {
            TextView textView;
            int i = 0;
            if (this.dEP.dDW == null || this.dEP.dDW.getVisibility() != 0) {
                textView = null;
            } else {
                textView = this.dEP.dDW;
                i = 1;
            }
            if (this.dEP.dDX != null && this.dEP.dDX.getVisibility() == 0) {
                i++;
                textView = this.dEP.dDX;
            }
            if (this.dEP.dDY != null && this.dEP.dDY.getVisibility() == 0) {
                i++;
                textView = this.dEP.dDY;
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
                this.dEP.dDX.setVisibility(8);
                if (this.dEP.dDW.getVisibility() == 0) {
                    this.dEP.dEa.setVisibility(8);
                }
            } else {
                this.dEP.dDX.setVisibility(0);
                if (this.dEP.dDW.getVisibility() == 0) {
                    this.dEP.dEa.setVisibility(0);
                }
                this.dEP.dDX.setText(charSequence);
                this.dEP.dDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cVQ.kp(-2);
                        a.this.cVQ.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cVQ, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gU(boolean z) {
            if (z) {
                this.dEP.dDZ.setVisibility(0);
            } else {
                this.dEP.dDZ.setVisibility(8);
            }
            return this;
        }

        public a ku(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dEP.dDZ.setLayoutParams(layoutParams);
            return this;
        }

        public void kv(int i) {
            this.dEP.dEd.getLayoutParams().height = i;
            this.dEP.dEd.requestLayout();
        }

        public void kw(int i) {
            this.dEP.dEd.getLayoutParams().width = i;
            this.dEP.dEd.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dEP.dDY.setVisibility(0);
            if (this.dEP.dDW.getVisibility() == 0) {
                this.dEP.dEb.setVisibility(0);
            }
            this.dEP.dDY.setText(charSequence);
            this.dEP.dDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cVQ.kp(-3);
                    a.this.cVQ.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cVQ, -3);
                    }
                }
            });
            return this;
        }

        public a kx(int i) {
            this.dEP.dxS.setImageResource(i);
            return this;
        }

        public a aK(View view) {
            this.dEP.dEc.removeAllViews();
            this.dEP.dEc.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dEg);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dEP.dEf.setLayoutParams(layoutParams);
            return this;
        }

        public a aLv() {
            this.dEP.dFc.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aLw() {
            ((ViewGroup.MarginLayoutParams) this.dEP.dEW.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gV(boolean z) {
            this.dEP.dEU = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dEP.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dEP.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dEP.dEV = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dEP.dFb = cVar;
            return this;
        }

        public a gW(boolean z) {
            this.dEP.dFe.setVisibility(z ? 0 : 8);
            return this;
        }

        public g atG() {
            this.cVQ.setCancelable(this.dEP.dEU.booleanValue());
            if (this.dEP.dEU.booleanValue()) {
                this.cVQ.setCanceledOnTouchOutside(false);
            }
            this.cVQ.setOnCancelListener(this.dEP.mOnCancelListener);
            this.cVQ.setOnDismissListener(this.dEP.mOnDismissListener);
            this.cVQ.setOnShowListener(this.dEP.dEV);
            if (this.dEP.mOnKeyListener != null) {
                this.cVQ.setOnKeyListener(this.dEP.mOnKeyListener);
            }
            aLz();
            if (this.dEP.dFb != null) {
                this.dEP.dFb.a(this.cVQ, this.dEP);
            }
            this.cVQ.a(this);
            return this.cVQ;
        }

        @Deprecated
        public g gX(boolean z) {
            return aLx();
        }

        public g aLx() {
            g atG = atG();
            if (this.dEQ) {
                atG.getWindow().setType(2003);
            }
            try {
                atG.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return atG;
        }

        protected Resources aLy() {
            return this.mContext.getResources();
        }

        private void aLz() {
            int color = aLy().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = aLy().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = aLy().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = aLy().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = aLy().getColor(a.c.aiapps_dialog_gray);
            this.dEP.dEd.setBackground(aLy().getDrawable(this.dEP.dFf != -1 ? this.dEP.dFf : a.e.aiapps_dialog_bg_white));
            this.dEP.mTitle.setTextColor(color);
            this.dEP.dDU.setTextColor(color4);
            this.dEP.dDW.setTextColor(this.dEP.dEY != color3 ? this.dEP.dEY : color3);
            if (this.dEP.dEZ != color2) {
                this.dEP.dDX.setTextColor(this.dEP.dEZ);
            } else if (this.dEP.dFa != -1) {
                this.dEP.dDX.setTextColor(aLy().getColorStateList(this.dEP.dFa));
            } else {
                this.dEP.dDX.setTextColor(color2);
            }
            this.dEP.dDY.setTextColor(color2);
            int color6 = this.dEP.dFg != -1 ? aLy().getColor(this.dEP.dFg) : color5;
            this.dEP.dDZ.setBackgroundColor(color6);
            this.dEP.dEa.setBackgroundColor(color6);
            this.dEP.dEb.setBackgroundColor(color6);
            this.dEP.dDW.setBackground(aLy().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dEP.dDX.setBackground(aLy().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dEP.dDY.setBackground(aLy().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView aLm = aLm();
            if (aLm != null) {
                aLm.setBackground(this.dEP.dFh ? aLy().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gY(boolean z) {
            this.dEP.dEf.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gZ(boolean z) {
            this.dEP.dFh = z;
            return this;
        }

        public a ha(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dEP.dEX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a ky(int i) {
            return kz(aLy().getColor(i));
        }

        public a X(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kz(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                ky(i);
            }
            return this;
        }

        public a kz(int i) {
            this.dEP.dEY = i;
            this.dEP.dDW.setTextColor(i);
            return this;
        }

        public a kA(int i) {
            return kC(this.mContext.getResources().getColor(i));
        }

        public a kB(int i) {
            this.dEP.dFa = i;
            return this;
        }

        public a Y(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kC(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                kA(i);
            }
            return this;
        }

        public a kC(int i) {
            this.dEP.dEZ = i;
            return this;
        }

        public ViewGroup aLA() {
            return this.dEP.dEc;
        }

        public a r(int i, int i2, int i3, int i4) {
            this.dEP.dFd.setPadding(i, i2, i3, i4);
            return this;
        }

        public a kD(int i) {
            this.dEP.dFf = i;
            this.dEP.dEd.setBackgroundResource(i);
            return this;
        }

        public a kE(int i) {
            this.dEP.dFg = i;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public ViewGroup bcK;
        public TextView dDU;
        public LinearLayout dDV;
        public TextView dDW;
        public TextView dDX;
        public TextView dDY;
        public View dDZ;
        public LinearLayout dET;
        public DialogInterface.OnShowListener dEV;
        public View dEW;
        public View dEX;
        public int dEY;
        public int dEZ;
        public View dEa;
        public View dEb;
        public FrameLayout dEc;
        public RelativeLayout dEd;
        public LinearLayout dEf;
        public c dFb;
        public FrameLayout dFc;
        public FrameLayout dFd;
        public View dFe;
        public ImageView dxS;
        public SwanAppScrollView dyj;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean dEU = true;
        public int dFa = -1;
        public int dFf = -1;
        public int dFg = -1;
        public boolean dFh = true;

        public b(ViewGroup viewGroup) {
            this.bcK = viewGroup;
            this.dFd = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dET = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.dDU = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.dDV = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.dDW = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dDX = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dDY = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.dEa = viewGroup.findViewById(a.f.divider3);
            this.dEb = viewGroup.findViewById(a.f.divider4);
            this.dEW = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dEc = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dxS = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.dEd = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dDZ = viewGroup.findViewById(a.f.divider2);
            this.dyj = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.dEf = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dEX = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dFc = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dFe = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.dDU.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.dDU.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.bcK.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.dEY = color;
            this.dEZ = color;
        }

        public void kF(int i) {
            this.dyj.setMaxHeight(i);
        }
    }
}
