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
    private a aMk;

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
        return this.aMk;
    }

    void a(a aVar) {
        this.aMk = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLE = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aLF = a.h.aiapps_dialog_positive_title_ok;
        protected int aLC;
        protected final b aMl;
        private boolean aMm = false;
        protected final e arv;
        private Context mContext;

        public a(Context context) {
            this.arv = bB(context);
            this.arv.a(this);
            this.aMl = new b((ViewGroup) this.arv.getWindow().getDecorView());
            this.mContext = context;
            this.aLC = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected e bB(Context context) {
            return new e(context, a.i.NoTitleDialog);
        }

        public a cm(int i) {
            this.aMl.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aMl.mTitle.setText(charSequence);
            } else {
                bP(true);
            }
            return this;
        }

        public a bP(boolean z) {
            this.aMl.aMp.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cl(int i) {
            if (this.aMl.aLr.getVisibility() != 0) {
                this.aMl.aLr.setVisibility(0);
            }
            this.aMl.aLq.setText(this.mContext.getText(i));
            Ir();
            return this;
        }

        public a ge(String str) {
            if (this.aMl.aLr.getVisibility() != 0) {
                this.aMl.aLr.setVisibility(0);
            }
            if (str != null) {
                this.aMl.aLq.setText(str);
                Ir();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aMl.aLr.getVisibility() != 0) {
                this.aMl.aLr.setVisibility(0);
            }
            if (spanned != null) {
                this.aMl.aLq.setMovementMethod(LinkMovementMethod.getInstance());
                this.aMl.aLq.setText(spanned);
                Ir();
            }
            return this;
        }

        public a Iq() {
            this.aMl.aLq.setGravity(3);
            return this;
        }

        private void Ir() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLC);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aMl.aLB.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMl.aLs.setVisibility(8);
                if (this.aMl.aLt.getVisibility() == 0) {
                    this.aMl.aLw.setVisibility(8);
                }
            } else {
                this.aMl.aLs.setVisibility(0);
                if (this.aMl.aLt.getVisibility() == 0) {
                    this.aMl.aLw.setVisibility(0);
                }
                this.aMl.aLs.setText(charSequence);
                this.aMl.aLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arv.dh(-1);
                        a.this.arv.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arv, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Il() {
            int i;
            TextView textView;
            if (this.aMl.aLs == null || this.aMl.aLs.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aMl.aLs;
                i = 1;
            }
            if (this.aMl.aLt != null && this.aMl.aLt.getVisibility() == 0) {
                i++;
                textView = this.aMl.aLt;
            }
            if (this.aMl.aLu != null && this.aMl.aLu.getVisibility() == 0) {
                i++;
                textView = this.aMl.aLu;
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
                this.aMl.aLt.setVisibility(8);
                if (this.aMl.aLs.getVisibility() == 0) {
                    this.aMl.aLw.setVisibility(8);
                }
            } else {
                this.aMl.aLt.setVisibility(0);
                if (this.aMl.aLs.getVisibility() == 0) {
                    this.aMl.aLw.setVisibility(0);
                }
                this.aMl.aLt.setText(charSequence);
                this.aMl.aLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arv.dh(-2);
                        a.this.arv.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arv, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void bQ(boolean z) {
            if (z) {
                this.aMl.aLv.setVisibility(0);
            } else {
                this.aMl.aLv.setVisibility(8);
            }
        }

        public a dk(int i) {
            this.aMl.mIcon.setImageResource(i);
            return this;
        }

        public a ad(View view) {
            this.aMl.aLy.removeAllViews();
            this.aMl.aLy.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLC);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aMl.aLB.setLayoutParams(layoutParams);
            return this;
        }

        public a bR(boolean z) {
            this.aMl.aMq = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aMl.mOnCancelListener = onCancelListener;
            return this;
        }

        public a a(c cVar) {
            this.aMl.aMw = cVar;
            return this;
        }

        public a bS(boolean z) {
            this.aMl.aMz.setVisibility(z ? 0 : 8);
            return this;
        }

        public e zq() {
            this.arv.setCancelable(this.aMl.aMq.booleanValue());
            if (this.aMl.aMq.booleanValue()) {
                this.arv.setCanceledOnTouchOutside(false);
            }
            this.arv.setOnCancelListener(this.aMl.mOnCancelListener);
            this.arv.setOnDismissListener(this.aMl.mOnDismissListener);
            this.arv.setOnShowListener(this.aMl.aMr);
            if (this.aMl.mOnKeyListener != null) {
                this.arv.setOnKeyListener(this.aMl.mOnKeyListener);
            }
            Iu();
            if (this.aMl.aMw != null) {
                this.aMl.aMw.a(this.arv, this.aMl);
            }
            this.arv.a(this);
            return this.arv;
        }

        @Deprecated
        public e bT(boolean z) {
            return Is();
        }

        public e Is() {
            e zq = zq();
            if (this.aMm) {
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
            this.aMl.aLz.setBackground(It().getDrawable(a.e.aiapps_dialog_bg_white));
            this.aMl.mTitle.setTextColor(color);
            this.aMl.aLq.setTextColor(color4);
            TextView textView = this.aMl.aLs;
            if (this.aMl.aMu != -1) {
                color3 = this.aMl.aMu;
            }
            textView.setTextColor(color3);
            this.aMl.aLt.setTextColor(this.aMl.aMv != -1 ? this.aMl.aMv : color2);
            this.aMl.aLu.setTextColor(color2);
            this.aMl.aLv.setBackgroundColor(color5);
            this.aMl.aLw.setBackgroundColor(color5);
            this.aMl.aLx.setBackgroundColor(color5);
            this.aMl.aLs.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aMl.aLt.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aMl.aLu.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Il = Il();
            if (Il != null) {
                Il.setBackground(It().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            }
        }

        public a bU(boolean z) {
            this.aMl.aLB.setVisibility(z ? 0 : 8);
            return this;
        }

        public a bV(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aMl.aMt.getLayoutParams();
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
            this.aMl.aMu = i;
            this.aMl.aLs.setTextColor(i);
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
            this.aMl.aMv = i;
            this.aMl.aLt.setTextColor(i);
            return this;
        }

        public ViewGroup Iv() {
            return this.aMl.aLy;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aGx;
        public LinearLayout aLB;
        public TextView aLq;
        public LinearLayout aLr;
        public TextView aLs;
        public TextView aLt;
        public TextView aLu;
        public View aLv;
        public View aLw;
        public View aLx;
        public FrameLayout aLy;
        public RelativeLayout aLz;
        public LinearLayout aMp;
        public DialogInterface.OnShowListener aMr;
        public View aMs;
        public View aMt;
        public c aMw;
        public FrameLayout aMx;
        public FrameLayout aMy;
        public View aMz;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aMq = true;
        public int aMu = -1;
        public int aMv = -1;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aMy = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMp = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aLq = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aLr = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aLs = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aLt = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aLu = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aLw = viewGroup.findViewById(a.f.divider3);
            this.aLx = viewGroup.findViewById(a.f.divider4);
            this.aMs = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aLy = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aLz = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aLv = viewGroup.findViewById(a.f.divider2);
            this.aGx = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aLB = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aMt = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aMx = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMz = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.LJ() || com.baidu.swan.apps.an.a.LI()) {
                int dimensionPixelSize = this.aLq.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aLq.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }
}
