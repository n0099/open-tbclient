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
    private a bib;

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

    public a Qq() {
        return this.bib;
    }

    void a(a aVar) {
        this.bib = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int bhu = a.h.aiapps_dialog_negative_title_cancel;
        public static final int bhv = a.h.aiapps_dialog_positive_title_ok;
        protected final g aLB;
        protected int bhs;
        protected final b bic;
        private boolean bie = false;
        private Context mContext;

        public a(Context context) {
            this.aLB = aW(context);
            this.aLB.a(this);
            this.bic = new b((ViewGroup) this.aLB.getWindow().getDecorView());
            this.mContext = context;
            this.bhs = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected g aW(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a dj(int i) {
            this.bic.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bic.mTitle.setText(charSequence);
            } else {
                ct(true);
            }
            return this;
        }

        public a ct(boolean z) {
            this.bic.bii.setVisibility(z ? 8 : 0);
            return this;
        }

        public a di(int i) {
            if (this.bic.bhh.getVisibility() != 0) {
                this.bic.bhh.setVisibility(0);
            }
            this.bic.bhg.setText(this.mContext.getText(i));
            Qs();
            return this;
        }

        public a hi(String str) {
            if (this.bic.bhh.getVisibility() != 0) {
                this.bic.bhh.setVisibility(0);
            }
            if (str != null) {
                this.bic.bhg.setText(str);
                Qs();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bic.bhh.getVisibility() != 0) {
                this.bic.bhh.setVisibility(0);
            }
            if (spanned != null) {
                this.bic.bhg.setMovementMethod(LinkMovementMethod.getInstance());
                this.bic.bhg.setText(spanned);
                Qs();
            }
            return this;
        }

        public a Qr() {
            this.bic.bhg.setGravity(3);
            return this;
        }

        private void Qs() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhs);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bic.bhr.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bic.bhi.setVisibility(8);
                if (this.bic.bhj.getVisibility() == 0) {
                    this.bic.bhm.setVisibility(8);
                }
            } else {
                this.bic.bhi.setVisibility(0);
                if (this.bic.bhj.getVisibility() == 0) {
                    this.bic.bhm.setVisibility(0);
                }
                this.bic.bhi.setText(charSequence);
                this.bic.bhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aLB.el(-1);
                        a.this.aLB.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.aLB, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Qm() {
            int i;
            TextView textView;
            if (this.bic.bhi == null || this.bic.bhi.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bic.bhi;
                i = 1;
            }
            if (this.bic.bhj != null && this.bic.bhj.getVisibility() == 0) {
                i++;
                textView = this.bic.bhj;
            }
            if (this.bic.bhk != null && this.bic.bhk.getVisibility() == 0) {
                i++;
                textView = this.bic.bhk;
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
                this.bic.bhj.setVisibility(8);
                if (this.bic.bhi.getVisibility() == 0) {
                    this.bic.bhm.setVisibility(8);
                }
            } else {
                this.bic.bhj.setVisibility(0);
                if (this.bic.bhi.getVisibility() == 0) {
                    this.bic.bhm.setVisibility(0);
                }
                this.bic.bhj.setText(charSequence);
                this.bic.bhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aLB.el(-2);
                        a.this.aLB.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.aLB, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void cu(boolean z) {
            if (z) {
                this.bic.bhl.setVisibility(0);
            } else {
                this.bic.bhl.setVisibility(8);
            }
        }

        public a eo(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bic.bhl.setLayoutParams(layoutParams);
            return this;
        }

        public void ep(int i) {
            this.bic.bhp.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        }

        public a eq(int i) {
            this.bic.mIcon.setImageResource(i);
            return this;
        }

        public a al(View view) {
            this.bic.bho.removeAllViews();
            this.bic.bho.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.bhs);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bic.bhr.setLayoutParams(layoutParams);
            return this;
        }

        public a Qt() {
            this.bic.bir.setPadding(0, 0, 0, 0);
            return this;
        }

        public a Qu() {
            ((ViewGroup.MarginLayoutParams) this.bic.bil.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a cv(boolean z) {
            this.bic.bij = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bic.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bic.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(c cVar) {
            this.bic.biq = cVar;
            return this;
        }

        public a cw(boolean z) {
            this.bic.bit.setVisibility(z ? 0 : 8);
            return this;
        }

        public g FX() {
            this.aLB.setCancelable(this.bic.bij.booleanValue());
            if (this.bic.bij.booleanValue()) {
                this.aLB.setCanceledOnTouchOutside(false);
            }
            this.aLB.setOnCancelListener(this.bic.mOnCancelListener);
            this.aLB.setOnDismissListener(this.bic.mOnDismissListener);
            this.aLB.setOnShowListener(this.bic.bik);
            if (this.bic.mOnKeyListener != null) {
                this.aLB.setOnKeyListener(this.bic.mOnKeyListener);
            }
            Qx();
            if (this.bic.biq != null) {
                this.bic.biq.a(this.aLB, this.bic);
            }
            this.aLB.a(this);
            return this.aLB;
        }

        @Deprecated
        public g cx(boolean z) {
            return Qv();
        }

        public g Qv() {
            g FX = FX();
            if (this.bie) {
                FX.getWindow().setType(2003);
            }
            try {
                FX.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return FX;
        }

        protected Resources Qw() {
            return this.mContext.getResources();
        }

        private void Qx() {
            int color = Qw().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = Qw().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = Qw().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = Qw().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = Qw().getColor(a.c.aiapps_dialog_gray);
            this.bic.bhp.setBackground(Qw().getDrawable(this.bic.biu != -1 ? this.bic.biu : a.e.aiapps_dialog_bg_white));
            this.bic.mTitle.setTextColor(color);
            this.bic.bhg.setTextColor(color4);
            this.bic.bhi.setTextColor(this.bic.bin != color3 ? this.bic.bin : color3);
            if (this.bic.bio != color2) {
                this.bic.bhj.setTextColor(this.bic.bio);
            } else if (this.bic.bip != -1) {
                this.bic.bhj.setTextColor(Qw().getColorStateList(this.bic.bip));
            } else {
                this.bic.bhj.setTextColor(color2);
            }
            this.bic.bhk.setTextColor(color2);
            int color6 = this.bic.biv != -1 ? Qw().getColor(this.bic.biv) : color5;
            this.bic.bhl.setBackgroundColor(color6);
            this.bic.bhm.setBackgroundColor(color6);
            this.bic.bhn.setBackgroundColor(color6);
            this.bic.bhi.setBackground(Qw().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bic.bhj.setBackground(Qw().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bic.bhk.setBackground(Qw().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Qm = Qm();
            if (Qm != null) {
                Qm.setBackground(this.bic.biw ? Qw().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a cy(boolean z) {
            this.bic.bhr.setVisibility(z ? 0 : 8);
            return this;
        }

        public a cz(boolean z) {
            this.bic.biw = z;
            return this;
        }

        public a cA(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bic.bim.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a er(int i) {
            return es(Qw().getColor(i));
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
            this.bic.bin = i;
            this.bic.bhi.setTextColor(i);
            return this;
        }

        public a et(int i) {
            return ev(this.mContext.getResources().getColor(i));
        }

        public a eu(int i) {
            this.bic.bip = i;
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
            this.bic.bio = i;
            return this;
        }

        public ViewGroup Qy() {
            return this.bic.bho;
        }

        public a k(int i, int i2, int i3, int i4) {
            this.bic.bis.setPadding(i, i2, i3, i4);
            return this;
        }

        public a ew(int i) {
            this.bic.biu = i;
            this.bic.bhp.setBackgroundResource(i);
            return this;
        }

        public a ex(int i) {
            this.bic.biv = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public ViewGroup YW;
        public SwanAppScrollView bct;
        public TextView bhg;
        public LinearLayout bhh;
        public TextView bhi;
        public TextView bhj;
        public TextView bhk;
        public View bhl;
        public View bhm;
        public View bhn;
        public FrameLayout bho;
        public RelativeLayout bhp;
        public LinearLayout bhr;
        public LinearLayout bii;
        public DialogInterface.OnShowListener bik;
        public View bil;
        public View bim;
        public int bin;
        public int bio;
        public c biq;
        public FrameLayout bir;
        public FrameLayout bis;
        public View bit;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public TextView mTitle;
        public Boolean bij = true;
        public int bip = -1;
        public int biu = -1;
        public int biv = -1;
        public boolean biw = true;

        public b(ViewGroup viewGroup) {
            this.YW = viewGroup;
            this.bis = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bii = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.bhg = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.bhh = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.bhi = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.bhj = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.bhk = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.bhm = viewGroup.findViewById(a.f.divider3);
            this.bhn = viewGroup.findViewById(a.f.divider4);
            this.bil = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bho = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.bhp = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.bhl = viewGroup.findViewById(a.f.divider2);
            this.bct = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.bhr = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.bim = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bir = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bit = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.TX() || com.baidu.swan.apps.an.a.TW()) {
                int dimensionPixelSize = this.bhg.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.bhg.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.YW.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.bin = color;
            this.bio = color;
        }
    }
}
