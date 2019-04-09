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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes2.dex */
public class e extends com.baidu.swan.apps.res.widget.dialog.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a aMl;

    /* loaded from: classes2.dex */
    public interface c {
        void a(e eVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, int i) {
        super(context, i);
        init();
    }

    protected void dh(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Ip() {
        return this.aMl;
    }

    void a(a aVar) {
        this.aMl = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLF = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aLG = a.h.aiapps_dialog_positive_title_ok;
        protected int aLD;
        protected final b aMm;
        private boolean aMn = false;
        protected final e arw;
        private Context mContext;

        public a(Context context) {
            this.arw = bB(context);
            this.arw.a(this);
            this.aMm = new b((ViewGroup) this.arw.getWindow().getDecorView());
            this.mContext = context;
            this.aLD = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected e bB(Context context) {
            return new e(context, a.i.NoTitleDialog);
        }

        public a cm(int i) {
            this.aMm.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aMm.mTitle.setText(charSequence);
            } else {
                bP(true);
            }
            return this;
        }

        public a bP(boolean z) {
            this.aMm.aMq.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cl(int i) {
            if (this.aMm.aLs.getVisibility() != 0) {
                this.aMm.aLs.setVisibility(0);
            }
            this.aMm.aLr.setText(this.mContext.getText(i));
            Ir();
            return this;
        }

        public a ge(String str) {
            if (this.aMm.aLs.getVisibility() != 0) {
                this.aMm.aLs.setVisibility(0);
            }
            if (str != null) {
                this.aMm.aLr.setText(str);
                Ir();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aMm.aLs.getVisibility() != 0) {
                this.aMm.aLs.setVisibility(0);
            }
            if (spanned != null) {
                this.aMm.aLr.setMovementMethod(LinkMovementMethod.getInstance());
                this.aMm.aLr.setText(spanned);
                Ir();
            }
            return this;
        }

        public a Iq() {
            this.aMm.aLr.setGravity(3);
            return this;
        }

        private void Ir() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLD);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aMm.aLC.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMm.aLt.setVisibility(8);
                if (this.aMm.aLu.getVisibility() == 0) {
                    this.aMm.aLx.setVisibility(8);
                }
            } else {
                this.aMm.aLt.setVisibility(0);
                if (this.aMm.aLu.getVisibility() == 0) {
                    this.aMm.aLx.setVisibility(0);
                }
                this.aMm.aLt.setText(charSequence);
                this.aMm.aLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arw.dh(-1);
                        a.this.arw.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arw, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Il() {
            int i;
            TextView textView;
            if (this.aMm.aLt == null || this.aMm.aLt.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aMm.aLt;
                i = 1;
            }
            if (this.aMm.aLu != null && this.aMm.aLu.getVisibility() == 0) {
                i++;
                textView = this.aMm.aLu;
            }
            if (this.aMm.aLv != null && this.aMm.aLv.getVisibility() == 0) {
                i++;
                textView = this.aMm.aLv;
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
                this.aMm.aLu.setVisibility(8);
                if (this.aMm.aLt.getVisibility() == 0) {
                    this.aMm.aLx.setVisibility(8);
                }
            } else {
                this.aMm.aLu.setVisibility(0);
                if (this.aMm.aLt.getVisibility() == 0) {
                    this.aMm.aLx.setVisibility(0);
                }
                this.aMm.aLu.setText(charSequence);
                this.aMm.aLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arw.dh(-2);
                        a.this.arw.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arw, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void bQ(boolean z) {
            if (z) {
                this.aMm.aLw.setVisibility(0);
            } else {
                this.aMm.aLw.setVisibility(8);
            }
        }

        public a dk(int i) {
            this.aMm.mIcon.setImageResource(i);
            return this;
        }

        public a ad(View view) {
            this.aMm.aLz.removeAllViews();
            this.aMm.aLz.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLD);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aMm.aLC.setLayoutParams(layoutParams);
            return this;
        }

        public a bR(boolean z) {
            this.aMm.aMr = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aMm.mOnCancelListener = onCancelListener;
            return this;
        }

        public a a(c cVar) {
            this.aMm.aMx = cVar;
            return this;
        }

        public a bS(boolean z) {
            this.aMm.aMA.setVisibility(z ? 0 : 8);
            return this;
        }

        public e zq() {
            this.arw.setCancelable(this.aMm.aMr.booleanValue());
            if (this.aMm.aMr.booleanValue()) {
                this.arw.setCanceledOnTouchOutside(false);
            }
            this.arw.setOnCancelListener(this.aMm.mOnCancelListener);
            this.arw.setOnDismissListener(this.aMm.mOnDismissListener);
            this.arw.setOnShowListener(this.aMm.aMs);
            if (this.aMm.mOnKeyListener != null) {
                this.arw.setOnKeyListener(this.aMm.mOnKeyListener);
            }
            Iu();
            if (this.aMm.aMx != null) {
                this.aMm.aMx.a(this.arw, this.aMm);
            }
            this.arw.a(this);
            return this.arw;
        }

        @Deprecated
        public e bT(boolean z) {
            return Is();
        }

        public e Is() {
            e zq = zq();
            if (this.aMn) {
                zq.getWindow().setType(2003);
            }
            try {
                zq.show();
            } catch (WindowManager.BadTokenException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
            return zq;
        }

        protected Resources It() {
            return this.mContext.getResources();
        }

        private void Iu() {
            int color = It().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = It().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = It().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = It().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = It().getColor(a.c.aiapps_dialog_gray);
            this.aMm.aLA.setBackground(It().getDrawable(a.e.aiapps_dialog_bg_white));
            this.aMm.mTitle.setTextColor(color);
            this.aMm.aLr.setTextColor(color4);
            TextView textView = this.aMm.aLt;
            if (this.aMm.aMv != -1) {
                color3 = this.aMm.aMv;
            }
            textView.setTextColor(color3);
            this.aMm.aLu.setTextColor(this.aMm.aMw != -1 ? this.aMm.aMw : color2);
            this.aMm.aLv.setTextColor(color2);
            this.aMm.aLw.setBackgroundColor(color5);
            this.aMm.aLx.setBackgroundColor(color5);
            this.aMm.aLy.setBackgroundColor(color5);
            this.aMm.aLt.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aMm.aLu.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aMm.aLv.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Il = Il();
            if (Il != null) {
                Il.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            }
        }

        public a bU(boolean z) {
            this.aMm.aLC.setVisibility(z ? 0 : 8);
            return this;
        }

        public a bV(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aMm.aMu.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a dl(int i) {
            return dm(It().getColor(i));
        }

        public a F(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dm(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (e.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dl(i);
            }
            return this;
        }

        public a dm(int i) {
            this.aMm.aMv = i;
            this.aMm.aLt.setTextColor(i);
            return this;
        }

        public a dn(int i) {
            return m15do(this.mContext.getResources().getColor(i));
        }

        public a G(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    m15do(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (e.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dn(i);
            }
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m15do(int i) {
            this.aMm.aMw = i;
            this.aMm.aLu.setTextColor(i);
            return this;
        }

        public ViewGroup Iv() {
            return this.aMm.aLz;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aGy;
        public RelativeLayout aLA;
        public LinearLayout aLC;
        public TextView aLr;
        public LinearLayout aLs;
        public TextView aLt;
        public TextView aLu;
        public TextView aLv;
        public View aLw;
        public View aLx;
        public View aLy;
        public FrameLayout aLz;
        public View aMA;
        public LinearLayout aMq;
        public DialogInterface.OnShowListener aMs;
        public View aMt;
        public View aMu;
        public c aMx;
        public FrameLayout aMy;
        public FrameLayout aMz;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aMr = true;
        public int aMv = -1;
        public int aMw = -1;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aMz = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMq = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aLr = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aLs = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aLt = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aLu = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aLv = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aLx = viewGroup.findViewById(a.f.divider3);
            this.aLy = viewGroup.findViewById(a.f.divider4);
            this.aMt = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aLz = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aLA = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aLw = viewGroup.findViewById(a.f.divider2);
            this.aGy = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aLC = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aMu = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aMy = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMA = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.LJ() || com.baidu.swan.apps.an.a.LI()) {
                int dimensionPixelSize = this.aLr.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aLr.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }
}
