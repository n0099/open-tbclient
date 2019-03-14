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
    private a aMh;

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
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Ir() {
        return this.aMh;
    }

    void a(a aVar) {
        this.aMh = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aLB = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aLC = a.h.aiapps_dialog_positive_title_ok;
        protected int aLz;
        protected final b aMi;
        private boolean aMj = false;
        protected final e arr;
        private Context mContext;

        public a(Context context) {
            this.arr = bB(context);
            this.arr.a(this);
            this.aMi = new b((ViewGroup) this.arr.getWindow().getDecorView());
            this.mContext = context;
            this.aLz = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected e bB(Context context) {
            return new e(context, a.i.NoTitleDialog);
        }

        public a cn(int i) {
            this.aMi.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aMi.mTitle.setText(charSequence);
            } else {
                bP(true);
            }
            return this;
        }

        public a bP(boolean z) {
            this.aMi.aMm.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cm(int i) {
            if (this.aMi.aLo.getVisibility() != 0) {
                this.aMi.aLo.setVisibility(0);
            }
            this.aMi.aLn.setText(this.mContext.getText(i));
            It();
            return this;
        }

        public a gd(String str) {
            if (this.aMi.aLo.getVisibility() != 0) {
                this.aMi.aLo.setVisibility(0);
            }
            if (str != null) {
                this.aMi.aLn.setText(str);
                It();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aMi.aLo.getVisibility() != 0) {
                this.aMi.aLo.setVisibility(0);
            }
            if (spanned != null) {
                this.aMi.aLn.setMovementMethod(LinkMovementMethod.getInstance());
                this.aMi.aLn.setText(spanned);
                It();
            }
            return this;
        }

        public a Is() {
            this.aMi.aLn.setGravity(3);
            return this;
        }

        private void It() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLz);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aMi.aLy.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aMi.aLp.setVisibility(8);
                if (this.aMi.aLq.getVisibility() == 0) {
                    this.aMi.aLt.setVisibility(8);
                }
            } else {
                this.aMi.aLp.setVisibility(0);
                if (this.aMi.aLq.getVisibility() == 0) {
                    this.aMi.aLt.setVisibility(0);
                }
                this.aMi.aLp.setText(charSequence);
                this.aMi.aLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arr.di(-1);
                        a.this.arr.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arr, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView In() {
            int i;
            TextView textView;
            if (this.aMi.aLp == null || this.aMi.aLp.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aMi.aLp;
                i = 1;
            }
            if (this.aMi.aLq != null && this.aMi.aLq.getVisibility() == 0) {
                i++;
                textView = this.aMi.aLq;
            }
            if (this.aMi.aLr != null && this.aMi.aLr.getVisibility() == 0) {
                i++;
                textView = this.aMi.aLr;
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
                this.aMi.aLq.setVisibility(8);
                if (this.aMi.aLp.getVisibility() == 0) {
                    this.aMi.aLt.setVisibility(8);
                }
            } else {
                this.aMi.aLq.setVisibility(0);
                if (this.aMi.aLp.getVisibility() == 0) {
                    this.aMi.aLt.setVisibility(0);
                }
                this.aMi.aLq.setText(charSequence);
                this.aMi.aLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.e.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arr.di(-2);
                        a.this.arr.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arr, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void bQ(boolean z) {
            if (z) {
                this.aMi.aLs.setVisibility(0);
            } else {
                this.aMi.aLs.setVisibility(8);
            }
        }

        public a dl(int i) {
            this.aMi.mIcon.setImageResource(i);
            return this;
        }

        public a ad(View view) {
            this.aMi.aLv.removeAllViews();
            this.aMi.aLv.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aLz);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aMi.aLy.setLayoutParams(layoutParams);
            return this;
        }

        public a bR(boolean z) {
            this.aMi.aMn = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aMi.mOnCancelListener = onCancelListener;
            return this;
        }

        public a a(c cVar) {
            this.aMi.aMt = cVar;
            return this;
        }

        public a bS(boolean z) {
            this.aMi.aMw.setVisibility(z ? 0 : 8);
            return this;
        }

        public e zr() {
            this.arr.setCancelable(this.aMi.aMn.booleanValue());
            if (this.aMi.aMn.booleanValue()) {
                this.arr.setCanceledOnTouchOutside(false);
            }
            this.arr.setOnCancelListener(this.aMi.mOnCancelListener);
            this.arr.setOnDismissListener(this.aMi.mOnDismissListener);
            this.arr.setOnShowListener(this.aMi.aMo);
            if (this.aMi.mOnKeyListener != null) {
                this.arr.setOnKeyListener(this.aMi.mOnKeyListener);
            }
            Iw();
            if (this.aMi.aMt != null) {
                this.aMi.aMt.a(this.arr, this.aMi);
            }
            this.arr.a(this);
            return this.arr;
        }

        @Deprecated
        public e bT(boolean z) {
            return Iu();
        }

        public e Iu() {
            e zr = zr();
            if (this.aMj) {
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
            int color = Iv().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = Iv().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = Iv().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = Iv().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = Iv().getColor(a.c.aiapps_dialog_gray);
            this.aMi.aLw.setBackground(Iv().getDrawable(a.e.aiapps_dialog_bg_white));
            this.aMi.mTitle.setTextColor(color);
            this.aMi.aLn.setTextColor(color4);
            TextView textView = this.aMi.aLp;
            if (this.aMi.aMr != -1) {
                color3 = this.aMi.aMr;
            }
            textView.setTextColor(color3);
            this.aMi.aLq.setTextColor(this.aMi.aMs != -1 ? this.aMi.aMs : color2);
            this.aMi.aLr.setTextColor(color2);
            this.aMi.aLs.setBackgroundColor(color5);
            this.aMi.aLt.setBackgroundColor(color5);
            this.aMi.aLu.setBackgroundColor(color5);
            this.aMi.aLp.setBackground(Iv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aMi.aLq.setBackground(Iv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aMi.aLr.setBackground(Iv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView In = In();
            if (In != null) {
                In.setBackground(Iv().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            }
        }

        public a bU(boolean z) {
            this.aMi.aLy.setVisibility(z ? 0 : 8);
            return this;
        }

        public a bV(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aMi.aMq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
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
            this.aMi.aMr = i;
            this.aMi.aLp.setTextColor(i);
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m15do(int i) {
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
                m15do(i);
            }
            return this;
        }

        public a dp(int i) {
            this.aMi.aMs = i;
            this.aMi.aLq.setTextColor(i);
            return this;
        }

        public ViewGroup Ix() {
            return this.aMi.aLv;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aGu;
        public TextView aLn;
        public LinearLayout aLo;
        public TextView aLp;
        public TextView aLq;
        public TextView aLr;
        public View aLs;
        public View aLt;
        public View aLu;
        public FrameLayout aLv;
        public RelativeLayout aLw;
        public LinearLayout aLy;
        public LinearLayout aMm;
        public DialogInterface.OnShowListener aMo;
        public View aMp;
        public View aMq;
        public c aMt;
        public FrameLayout aMu;
        public FrameLayout aMv;
        public View aMw;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aMn = true;
        public int aMr = -1;
        public int aMs = -1;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aMv = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMm = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aLn = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aLo = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aLp = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aLq = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aLr = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aLt = viewGroup.findViewById(a.f.divider3);
            this.aLu = viewGroup.findViewById(a.f.divider4);
            this.aMp = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aLv = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aLw = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aLs = viewGroup.findViewById(a.f.divider2);
            this.aGu = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aLy = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aMq = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aMu = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aMw = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.LL() || com.baidu.swan.apps.an.a.LK()) {
                int dimensionPixelSize = this.aLn.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aLn.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }
}
