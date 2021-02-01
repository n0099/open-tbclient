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
    private a dCh;

    /* loaded from: classes9.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    public void iM(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a aHR() {
        return this.dCh;
    }

    void a(a aVar) {
        this.dCh = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final int dBB = a.h.aiapps_dialog_negative_title_cancel;
        public static final int dBC = a.h.aiapps_dialog_positive_title_ok;
        protected final g cTr;
        protected int dBz;
        protected final b dCi;
        private boolean dCj = false;
        private Context mContext;

        public a(Context context) {
            this.cTr = cJ(context);
            this.cTr.a(this);
            this.dCi = new b((ViewGroup) this.cTr.getWindow().getDecorView());
            this.mContext = context;
            this.dBz = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aHS() {
            if (ah.isScreenLand()) {
                iT(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                iQ(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g cJ(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a gR(int i) {
            this.dCi.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dCi.mTitle.setText(charSequence);
            } else {
                gR(true);
            }
            return this;
        }

        public a gR(boolean z) {
            this.dCi.dCm.setVisibility(z ? 8 : 0);
            return this;
        }

        public a gQ(int i) {
            if (this.dCi.dBo.getVisibility() != 0) {
                this.dCi.dBo.setVisibility(0);
            }
            this.dCi.dBn.setText(this.mContext.getText(i));
            aHU();
            return this;
        }

        public a rx(String str) {
            if (this.dCi.dBo.getVisibility() != 0) {
                this.dCi.dBo.setVisibility(0);
            }
            if (str != null) {
                this.dCi.dBn.setText(str);
                aHU();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dCi.dBo.getVisibility() != 0) {
                this.dCi.dBo.setVisibility(0);
            }
            if (spanned != null) {
                this.dCi.dBn.setMovementMethod(LinkMovementMethod.getInstance());
                this.dCi.dBn.setText(spanned);
                aHU();
            }
            return this;
        }

        public a aHT() {
            this.dCi.dBn.setGravity(3);
            return this;
        }

        private void aHU() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dBz);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dCi.dBy.setLayoutParams(layoutParams);
        }

        public a iQ(int i) {
            this.dCi.jc(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dCi.dBp.setVisibility(8);
                if (this.dCi.dBq.getVisibility() == 0) {
                    this.dCi.dBt.setVisibility(8);
                }
            } else {
                this.dCi.dBp.setVisibility(0);
                if (this.dCi.dBq.getVisibility() == 0) {
                    this.dCi.dBt.setVisibility(0);
                }
                this.dCi.dBp.setText(charSequence);
                this.dCi.dBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cTr.iM(-1);
                        a.this.cTr.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cTr, -1);
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
                        a.this.cTr.iM(i);
                        a.this.cTr.dismiss();
                        onClickListener.onClick(a.this.cTr, i);
                    }
                });
            }
        }

        public TextView aHM() {
            TextView textView;
            int i = 0;
            if (this.dCi.dBp == null || this.dCi.dBp.getVisibility() != 0) {
                textView = null;
            } else {
                textView = this.dCi.dBp;
                i = 1;
            }
            if (this.dCi.dBq != null && this.dCi.dBq.getVisibility() == 0) {
                i++;
                textView = this.dCi.dBq;
            }
            if (this.dCi.dBr != null && this.dCi.dBr.getVisibility() == 0) {
                i++;
                textView = this.dCi.dBr;
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
                this.dCi.dBq.setVisibility(8);
                if (this.dCi.dBp.getVisibility() == 0) {
                    this.dCi.dBt.setVisibility(8);
                }
            } else {
                this.dCi.dBq.setVisibility(0);
                if (this.dCi.dBp.getVisibility() == 0) {
                    this.dCi.dBt.setVisibility(0);
                }
                this.dCi.dBq.setText(charSequence);
                this.dCi.dBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cTr.iM(-2);
                        a.this.cTr.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cTr, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gS(boolean z) {
            if (z) {
                this.dCi.dBs.setVisibility(0);
            } else {
                this.dCi.dBs.setVisibility(8);
            }
            return this;
        }

        public a iR(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dCi.dBs.setLayoutParams(layoutParams);
            return this;
        }

        public void iS(int i) {
            this.dCi.dBw.getLayoutParams().height = i;
            this.dCi.dBw.requestLayout();
        }

        public void iT(int i) {
            this.dCi.dBw.getLayoutParams().width = i;
            this.dCi.dBw.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dCi.dBr.setVisibility(0);
            if (this.dCi.dBp.getVisibility() == 0) {
                this.dCi.dBu.setVisibility(0);
            }
            this.dCi.dBr.setText(charSequence);
            this.dCi.dBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cTr.iM(-3);
                    a.this.cTr.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cTr, -3);
                    }
                }
            });
            return this;
        }

        public a iU(int i) {
            this.dCi.dvq.setImageResource(i);
            return this;
        }

        public a aG(View view) {
            this.dCi.dBv.removeAllViews();
            this.dCi.dBv.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dBz);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dCi.dBy.setLayoutParams(layoutParams);
            return this;
        }

        public a aHV() {
            this.dCi.dCv.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aHW() {
            ((ViewGroup.MarginLayoutParams) this.dCi.dCp.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gT(boolean z) {
            this.dCi.dCn = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dCi.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dCi.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dCi.dCo = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dCi.dCu = cVar;
            return this;
        }

        public a gU(boolean z) {
            this.dCi.dCx.setVisibility(z ? 0 : 8);
            return this;
        }

        public g aqk() {
            this.cTr.setCancelable(this.dCi.dCn.booleanValue());
            if (this.dCi.dCn.booleanValue()) {
                this.cTr.setCanceledOnTouchOutside(false);
            }
            this.cTr.setOnCancelListener(this.dCi.mOnCancelListener);
            this.cTr.setOnDismissListener(this.dCi.mOnDismissListener);
            this.cTr.setOnShowListener(this.dCi.dCo);
            if (this.dCi.mOnKeyListener != null) {
                this.cTr.setOnKeyListener(this.dCi.mOnKeyListener);
            }
            aHZ();
            if (this.dCi.dCu != null) {
                this.dCi.dCu.a(this.cTr, this.dCi);
            }
            this.cTr.a(this);
            return this.cTr;
        }

        @Deprecated
        public g gV(boolean z) {
            return aHX();
        }

        public g aHX() {
            g aqk = aqk();
            if (this.dCj) {
                aqk.getWindow().setType(2003);
            }
            try {
                aqk.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return aqk;
        }

        protected Resources aHY() {
            return this.mContext.getResources();
        }

        private void aHZ() {
            int color = aHY().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = aHY().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = aHY().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = aHY().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = aHY().getColor(a.c.aiapps_dialog_gray);
            this.dCi.dBw.setBackground(aHY().getDrawable(this.dCi.dCy != -1 ? this.dCi.dCy : a.e.aiapps_dialog_bg_white));
            this.dCi.mTitle.setTextColor(color);
            this.dCi.dBn.setTextColor(color4);
            this.dCi.dBp.setTextColor(this.dCi.dCr != color3 ? this.dCi.dCr : color3);
            if (this.dCi.dCs != color2) {
                this.dCi.dBq.setTextColor(this.dCi.dCs);
            } else if (this.dCi.dCt != -1) {
                this.dCi.dBq.setTextColor(aHY().getColorStateList(this.dCi.dCt));
            } else {
                this.dCi.dBq.setTextColor(color2);
            }
            this.dCi.dBr.setTextColor(color2);
            int color6 = this.dCi.dCz != -1 ? aHY().getColor(this.dCi.dCz) : color5;
            this.dCi.dBs.setBackgroundColor(color6);
            this.dCi.dBt.setBackgroundColor(color6);
            this.dCi.dBu.setBackgroundColor(color6);
            this.dCi.dBp.setBackground(aHY().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dCi.dBq.setBackground(aHY().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dCi.dBr.setBackground(aHY().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView aHM = aHM();
            if (aHM != null) {
                aHM.setBackground(this.dCi.dCA ? aHY().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gW(boolean z) {
            this.dCi.dBy.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gX(boolean z) {
            this.dCi.dCA = z;
            return this;
        }

        public a gY(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dCi.dCq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a iV(int i) {
            return iW(aHY().getColor(i));
        }

        public a Z(String str, int i) {
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
                iV(i);
            }
            return this;
        }

        public a iW(int i) {
            this.dCi.dCr = i;
            this.dCi.dBp.setTextColor(i);
            return this;
        }

        public a iX(int i) {
            return iZ(this.mContext.getResources().getColor(i));
        }

        public a iY(int i) {
            this.dCi.dCt = i;
            return this;
        }

        public a aa(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    iZ(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iX(i);
            }
            return this;
        }

        public a iZ(int i) {
            this.dCi.dCs = i;
            return this;
        }

        public ViewGroup aIa() {
            return this.dCi.dBv;
        }

        public a r(int i, int i2, int i3, int i4) {
            this.dCi.dCw.setPadding(i, i2, i3, i4);
            return this;
        }

        public a ja(int i) {
            this.dCi.dCy = i;
            this.dCi.dBw.setBackgroundResource(i);
            return this;
        }

        public a jb(int i) {
            this.dCi.dCz = i;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public ViewGroup bbd;
        public TextView dBn;
        public LinearLayout dBo;
        public TextView dBp;
        public TextView dBq;
        public TextView dBr;
        public View dBs;
        public View dBt;
        public View dBu;
        public FrameLayout dBv;
        public RelativeLayout dBw;
        public LinearLayout dBy;
        public LinearLayout dCm;
        public DialogInterface.OnShowListener dCo;
        public View dCp;
        public View dCq;
        public int dCr;
        public int dCs;
        public c dCu;
        public FrameLayout dCv;
        public FrameLayout dCw;
        public View dCx;
        public SwanAppScrollView dvH;
        public ImageView dvq;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean dCn = true;
        public int dCt = -1;
        public int dCy = -1;
        public int dCz = -1;
        public boolean dCA = true;

        public b(ViewGroup viewGroup) {
            this.bbd = viewGroup;
            this.dCw = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dCm = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.dBn = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.dBo = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.dBp = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dBq = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dBr = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.dBt = viewGroup.findViewById(a.f.divider3);
            this.dBu = viewGroup.findViewById(a.f.divider4);
            this.dCp = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dBv = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dvq = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.dBw = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dBs = viewGroup.findViewById(a.f.divider2);
            this.dvH = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.dBy = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dCq = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dCv = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dCx = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ao.c.isGingerbread() || com.baidu.swan.apps.ao.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.dBn.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.dBn.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.bbd.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.dCr = color;
            this.dCs = color;
        }

        public void jc(int i) {
            this.dvH.setMaxHeight(i);
        }
    }
}
