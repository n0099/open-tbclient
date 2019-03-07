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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes2.dex */
public class e extends com.baidu.swan.apps.res.widget.dialog.b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private a aMg;

    /* loaded from: classes2.dex */
    public interface c {
        void a(e eVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, int i) {
        super(context, i);
        init();
    }

    protected void di(int i) {
    }

    protected void init() {
        setContentView(b.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Ir() {
        return this.aMg;
    }

    void a(a aVar) {
        this.aMg = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLA = b.h.aiapps_dialog_negative_title_cancel;
        public static final int aLB = b.h.aiapps_dialog_positive_title_ok;
        protected int aLy;
        protected final b aMh;
        private boolean aMi = false;
        protected final e arq;
        private Context mContext;

        public a(Context context) {
            this.arq = bB(context);
            this.arq.a(this);
            this.aMh = new b((ViewGroup) this.arq.getWindow().getDecorView());
            this.mContext = context;
            this.aLy = this.mContext.getResources().getDimensionPixelSize(b.d.aiapps_dialog_btns_height);
        }

        protected e bB(Context context) {
            return new e(context, b.i.NoTitleDialog);
        }

        public a cn(int i) {
            this.aMh.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aMh.mTitle.setText(charSequence);
            } else {
                bP(true);
            }
            return this;
        }

        public a bP(boolean z) {
            this.aMh.aMl.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cm(int i) {
            if (this.aMh.aLn.getVisibility() != 0) {
                this.aMh.aLn.setVisibility(0);
            }
            this.aMh.aLm.setText(this.mContext.getText(i));
            It();
            return this;
        }

        public a gd(String str) {
            if (this.aMh.aLn.getVisibility() != 0) {
                this.aMh.aLn.setVisibility(0);
            }
            if (str != null) {
                this.aMh.aLm.setText(str);
                It();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aMh.aLn.getVisibility() != 0) {
                this.aMh.aLn.setVisibility(0);
            }
            if (spanned != null) {
                this.aMh.aLm.setMovementMethod(LinkMovementMethod.getInstance());
                this.aMh.aLm.setText(spanned);
                It();
            }
            return this;
        }

        public a Is() {
            this.aMh.aLm.setGravity(3);
            return this;
        }

        private void It() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLy);
            layoutParams.addRule(3, b.f.dialog_message_content);
            this.aMh.aLx.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMh.aLo.setVisibility(8);
                if (this.aMh.aLp.getVisibility() == 0) {
                    this.aMh.aLs.setVisibility(8);
                }
            } else {
                this.aMh.aLo.setVisibility(0);
                if (this.aMh.aLp.getVisibility() == 0) {
                    this.aMh.aLs.setVisibility(0);
                }
                this.aMh.aLo.setText(charSequence);
                this.aMh.aLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arq.di(-1);
                        a.this.arq.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arq, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView In() {
            int i;
            TextView textView;
            if (this.aMh.aLo == null || this.aMh.aLo.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aMh.aLo;
                i = 1;
            }
            if (this.aMh.aLp != null && this.aMh.aLp.getVisibility() == 0) {
                i++;
                textView = this.aMh.aLp;
            }
            if (this.aMh.aLq != null && this.aMh.aLq.getVisibility() == 0) {
                i++;
                textView = this.aMh.aLq;
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
                this.aMh.aLp.setVisibility(8);
                if (this.aMh.aLo.getVisibility() == 0) {
                    this.aMh.aLs.setVisibility(8);
                }
            } else {
                this.aMh.aLp.setVisibility(0);
                if (this.aMh.aLo.getVisibility() == 0) {
                    this.aMh.aLs.setVisibility(0);
                }
                this.aMh.aLp.setText(charSequence);
                this.aMh.aLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arq.di(-2);
                        a.this.arq.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arq, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void bQ(boolean z) {
            if (z) {
                this.aMh.aLr.setVisibility(0);
            } else {
                this.aMh.aLr.setVisibility(8);
            }
        }

        public a dl(int i) {
            this.aMh.mIcon.setImageResource(i);
            return this;
        }

        public a ad(View view) {
            this.aMh.aLu.removeAllViews();
            this.aMh.aLu.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLy);
            layoutParams.addRule(3, b.f.dialog_customPanel);
            this.aMh.aLx.setLayoutParams(layoutParams);
            return this;
        }

        public a bR(boolean z) {
            this.aMh.aMm = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aMh.mOnCancelListener = onCancelListener;
            return this;
        }

        public a a(c cVar) {
            this.aMh.aMs = cVar;
            return this;
        }

        public a bS(boolean z) {
            this.aMh.aMv.setVisibility(z ? 0 : 8);
            return this;
        }

        public e zr() {
            this.arq.setCancelable(this.aMh.aMm.booleanValue());
            if (this.aMh.aMm.booleanValue()) {
                this.arq.setCanceledOnTouchOutside(false);
            }
            this.arq.setOnCancelListener(this.aMh.mOnCancelListener);
            this.arq.setOnDismissListener(this.aMh.mOnDismissListener);
            this.arq.setOnShowListener(this.aMh.aMn);
            if (this.aMh.mOnKeyListener != null) {
                this.arq.setOnKeyListener(this.aMh.mOnKeyListener);
            }
            Iw();
            if (this.aMh.aMs != null) {
                this.aMh.aMs.a(this.arq, this.aMh);
            }
            this.arq.a(this);
            return this.arq;
        }

        @Deprecated
        public e bT(boolean z) {
            return Iu();
        }

        public e Iu() {
            e zr = zr();
            if (this.aMi) {
                zr.getWindow().setType(2003);
            }
            try {
                zr.show();
            } catch (WindowManager.BadTokenException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
            return zr;
        }

        protected Resources Iv() {
            return this.mContext.getResources();
        }

        private void Iw() {
            int color = Iv().getColor(b.c.aiapps_dialog_title_text_color);
            int color2 = Iv().getColor(b.c.aiapps_dialog_btn_text_color);
            int color3 = Iv().getColor(b.c.aiapps_dialog_btn_text_color);
            int color4 = Iv().getColor(b.c.aiapps_box_dialog_message_text_color);
            int color5 = Iv().getColor(b.c.aiapps_dialog_gray);
            this.aMh.aLv.setBackground(Iv().getDrawable(b.e.aiapps_dialog_bg_white));
            this.aMh.mTitle.setTextColor(color);
            this.aMh.aLm.setTextColor(color4);
            TextView textView = this.aMh.aLo;
            if (this.aMh.aMq != -1) {
                color3 = this.aMh.aMq;
            }
            textView.setTextColor(color3);
            this.aMh.aLp.setTextColor(this.aMh.aMr != -1 ? this.aMh.aMr : color2);
            this.aMh.aLq.setTextColor(color2);
            this.aMh.aLr.setBackgroundColor(color5);
            this.aMh.aLs.setBackgroundColor(color5);
            this.aMh.aLt.setBackgroundColor(color5);
            this.aMh.aLo.setBackground(Iv().getDrawable(b.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aMh.aLp.setBackground(Iv().getDrawable(b.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aMh.aLq.setBackground(Iv().getDrawable(b.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView In = In();
            if (In != null) {
                In.setBackground(Iv().getDrawable(b.e.aiapp_alertdialog_button_day_bg_all_selector));
            }
        }

        public a bU(boolean z) {
            this.aMh.aLx.setVisibility(z ? 0 : 8);
            return this;
        }

        public a bV(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aMh.aMp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(b.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a dm(int i) {
            return dn(Iv().getColor(i));
        }

        public a F(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dn(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (e.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dm(i);
            }
            return this;
        }

        public a dn(int i) {
            this.aMh.aMq = i;
            this.aMh.aLo.setTextColor(i);
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m14do(int i) {
            return dp(this.mContext.getResources().getColor(i));
        }

        public a G(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dp(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (e.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                m14do(i);
            }
            return this;
        }

        public a dp(int i) {
            this.aMh.aMr = i;
            this.aMh.aLp.setTextColor(i);
            return this;
        }

        public ViewGroup Ix() {
            return this.aMh.aLu;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aGt;
        public TextView aLm;
        public LinearLayout aLn;
        public TextView aLo;
        public TextView aLp;
        public TextView aLq;
        public View aLr;
        public View aLs;
        public View aLt;
        public FrameLayout aLu;
        public RelativeLayout aLv;
        public LinearLayout aLx;
        public LinearLayout aMl;
        public DialogInterface.OnShowListener aMn;
        public View aMo;
        public View aMp;
        public c aMs;
        public FrameLayout aMt;
        public FrameLayout aMu;
        public View aMv;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aMm = true;
        public int aMq = -1;
        public int aMr = -1;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aMu = (FrameLayout) viewGroup.findViewById(b.f.dialog_root);
            this.aMl = (LinearLayout) viewGroup.findViewById(b.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(b.f.dialog_title);
            this.aLm = (TextView) viewGroup.findViewById(b.f.dialog_message);
            this.aLn = (LinearLayout) viewGroup.findViewById(b.f.dialog_message_content);
            this.aLo = (TextView) viewGroup.findViewById(b.f.positive_button);
            this.aLp = (TextView) viewGroup.findViewById(b.f.negative_button);
            this.aLq = (TextView) viewGroup.findViewById(b.f.neutral_button);
            this.aLs = viewGroup.findViewById(b.f.divider3);
            this.aLt = viewGroup.findViewById(b.f.divider4);
            this.aMo = viewGroup.findViewById(b.f.dialog_customPanel);
            this.aLu = (FrameLayout) viewGroup.findViewById(b.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(b.f.dialog_icon);
            this.aLv = (RelativeLayout) viewGroup.findViewById(b.f.searchbox_alert_dialog);
            this.aLr = viewGroup.findViewById(b.f.divider2);
            this.aGt = (SwanAppScrollView) viewGroup.findViewById(b.f.message_scrollview);
            this.aLx = (LinearLayout) viewGroup.findViewById(b.f.btn_panel);
            this.aMp = viewGroup.findViewById(b.f.dialog_customPanel);
            this.aMt = (FrameLayout) viewGroup.findViewById(b.f.dialog_root);
            this.aMv = viewGroup.findViewById(b.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.LL() || com.baidu.swan.apps.an.a.LK()) {
                int dimensionPixelSize = this.aLm.getResources().getDimensionPixelSize(b.d.aiapps_dialog_text_padding);
                this.aLm.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }
}
