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
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a aOO;

    /* loaded from: classes2.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    protected void dp(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a Ls() {
        return this.aOO;
    }

    void a(a aVar) {
        this.aOO = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aOh = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aOi = a.h.aiapps_dialog_positive_title_ok;
        protected final b aOP;
        private boolean aOQ = false;
        protected int aOf;
        protected final g asf;
        private Context mContext;

        public a(Context context) {
            this.asf = aU(context);
            this.asf.a(this);
            this.aOP = new b((ViewGroup) this.asf.getWindow().getDecorView());
            this.mContext = context;
            this.aOf = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected g aU(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a cm(int i) {
            this.aOP.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aOP.mTitle.setText(charSequence);
            } else {
                cc(true);
            }
            return this;
        }

        public a cc(boolean z) {
            this.aOP.aOT.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cl(int i) {
            if (this.aOP.aNU.getVisibility() != 0) {
                this.aOP.aNU.setVisibility(0);
            }
            this.aOP.aNT.setText(this.mContext.getText(i));
            Lu();
            return this;
        }

        public a gC(String str) {
            if (this.aOP.aNU.getVisibility() != 0) {
                this.aOP.aNU.setVisibility(0);
            }
            if (str != null) {
                this.aOP.aNT.setText(str);
                Lu();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aOP.aNU.getVisibility() != 0) {
                this.aOP.aNU.setVisibility(0);
            }
            if (spanned != null) {
                this.aOP.aNT.setMovementMethod(LinkMovementMethod.getInstance());
                this.aOP.aNT.setText(spanned);
                Lu();
            }
            return this;
        }

        public a Lt() {
            this.aOP.aNT.setGravity(3);
            return this;
        }

        private void Lu() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOf);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aOP.aOe.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aOP.aNV.setVisibility(8);
                if (this.aOP.aNW.getVisibility() == 0) {
                    this.aOP.aNZ.setVisibility(8);
                }
            } else {
                this.aOP.aNV.setVisibility(0);
                if (this.aOP.aNW.getVisibility() == 0) {
                    this.aOP.aNZ.setVisibility(0);
                }
                this.aOP.aNV.setText(charSequence);
                this.aOP.aNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.asf.dp(-1);
                        a.this.asf.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.asf, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView Lo() {
            int i;
            TextView textView;
            if (this.aOP.aNV == null || this.aOP.aNV.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aOP.aNV;
                i = 1;
            }
            if (this.aOP.aNW != null && this.aOP.aNW.getVisibility() == 0) {
                i++;
                textView = this.aOP.aNW;
            }
            if (this.aOP.aNX != null && this.aOP.aNX.getVisibility() == 0) {
                i++;
                textView = this.aOP.aNX;
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
                this.aOP.aNW.setVisibility(8);
                if (this.aOP.aNV.getVisibility() == 0) {
                    this.aOP.aNZ.setVisibility(8);
                }
            } else {
                this.aOP.aNW.setVisibility(0);
                if (this.aOP.aNV.getVisibility() == 0) {
                    this.aOP.aNZ.setVisibility(0);
                }
                this.aOP.aNW.setText(charSequence);
                this.aOP.aNW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.asf.dp(-2);
                        a.this.asf.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.asf, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void cd(boolean z) {
            if (z) {
                this.aOP.aNY.setVisibility(0);
            } else {
                this.aOP.aNY.setVisibility(8);
            }
        }

        public a ds(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.aOP.aNY.setLayoutParams(layoutParams);
            return this;
        }

        public void dt(int i) {
            this.aOP.aOc.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        }

        public a du(int i) {
            this.aOP.mIcon.setImageResource(i);
            return this;
        }

        public a af(View view) {
            this.aOP.aOb.removeAllViews();
            this.aOP.aOb.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aOf);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aOP.aOe.setLayoutParams(layoutParams);
            return this;
        }

        public a Lv() {
            this.aOP.aPc.setPadding(0, 0, 0, 0);
            return this;
        }

        public a Lw() {
            ((ViewGroup.MarginLayoutParams) this.aOP.aOW.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a ce(boolean z) {
            this.aOP.aOU = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aOP.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.aOP.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(c cVar) {
            this.aOP.aPb = cVar;
            return this;
        }

        public a cf(boolean z) {
            this.aOP.aPe.setVisibility(z ? 0 : 8);
            return this;
        }

        public g AX() {
            this.asf.setCancelable(this.aOP.aOU.booleanValue());
            if (this.aOP.aOU.booleanValue()) {
                this.asf.setCanceledOnTouchOutside(false);
            }
            this.asf.setOnCancelListener(this.aOP.mOnCancelListener);
            this.asf.setOnDismissListener(this.aOP.mOnDismissListener);
            this.asf.setOnShowListener(this.aOP.aOV);
            if (this.aOP.mOnKeyListener != null) {
                this.asf.setOnKeyListener(this.aOP.mOnKeyListener);
            }
            Lz();
            if (this.aOP.aPb != null) {
                this.aOP.aPb.a(this.asf, this.aOP);
            }
            this.asf.a(this);
            return this.asf;
        }

        @Deprecated
        public g cg(boolean z) {
            return Lx();
        }

        public g Lx() {
            g AX = AX();
            if (this.aOQ) {
                AX.getWindow().setType(2003);
            }
            try {
                AX.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a(SmsLoginView.StatEvent.LOGIN_SHOW));
            return AX;
        }

        protected Resources Ly() {
            return this.mContext.getResources();
        }

        private void Lz() {
            int color = Ly().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = Ly().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = Ly().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = Ly().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = Ly().getColor(a.c.aiapps_dialog_gray);
            this.aOP.aOc.setBackground(Ly().getDrawable(this.aOP.aPf != -1 ? this.aOP.aPf : a.e.aiapps_dialog_bg_white));
            this.aOP.mTitle.setTextColor(color);
            this.aOP.aNT.setTextColor(color4);
            this.aOP.aNV.setTextColor(this.aOP.aOY != color3 ? this.aOP.aOY : color3);
            if (this.aOP.aOZ != color2) {
                this.aOP.aNW.setTextColor(this.aOP.aOZ);
            } else if (this.aOP.aPa != -1) {
                this.aOP.aNW.setTextColor(Ly().getColorStateList(this.aOP.aPa));
            } else {
                this.aOP.aNW.setTextColor(color2);
            }
            this.aOP.aNX.setTextColor(color2);
            int color6 = this.aOP.aPg != -1 ? Ly().getColor(this.aOP.aPg) : color5;
            this.aOP.aNY.setBackgroundColor(color6);
            this.aOP.aNZ.setBackgroundColor(color6);
            this.aOP.aOa.setBackgroundColor(color6);
            this.aOP.aNV.setBackground(Ly().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aOP.aNW.setBackground(Ly().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aOP.aNX.setBackground(Ly().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView Lo = Lo();
            if (Lo != null) {
                Lo.setBackground(this.aOP.aPh ? Ly().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a ch(boolean z) {
            this.aOP.aOe.setVisibility(z ? 0 : 8);
            return this;
        }

        public a ci(boolean z) {
            this.aOP.aPh = z;
            return this;
        }

        public a cj(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aOP.aOX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a dv(int i) {
            return dw(Ly().getColor(i));
        }

        public a C(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dw(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dv(i);
            }
            return this;
        }

        public a dw(int i) {
            this.aOP.aOY = i;
            this.aOP.aNV.setTextColor(i);
            return this;
        }

        public a dx(int i) {
            return dz(this.mContext.getResources().getColor(i));
        }

        public a dy(int i) {
            this.aOP.aPa = i;
            return this;
        }

        public a D(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dz(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                dx(i);
            }
            return this;
        }

        public a dz(int i) {
            this.aOP.aOZ = i;
            return this;
        }

        public ViewGroup LA() {
            return this.aOP.aOb;
        }

        public a g(int i, int i2, int i3, int i4) {
            this.aOP.aPd.setPadding(i, i2, i3, i4);
            return this;
        }

        public a dA(int i) {
            this.aOP.aPf = i;
            this.aOP.aOc.setBackgroundResource(i);
            return this;
        }

        public a dB(int i) {
            this.aOP.aPg = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aIZ;
        public TextView aNT;
        public LinearLayout aNU;
        public TextView aNV;
        public TextView aNW;
        public TextView aNX;
        public View aNY;
        public View aNZ;
        public LinearLayout aOT;
        public DialogInterface.OnShowListener aOV;
        public View aOW;
        public View aOX;
        public int aOY;
        public int aOZ;
        public View aOa;
        public FrameLayout aOb;
        public RelativeLayout aOc;
        public LinearLayout aOe;
        public c aPb;
        public FrameLayout aPc;
        public FrameLayout aPd;
        public View aPe;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aOU = true;
        public int aPa = -1;
        public int aPf = -1;
        public int aPg = -1;
        public boolean aPh = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aPd = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aOT = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aNT = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aNU = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aNV = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aNW = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aNX = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aNZ = viewGroup.findViewById(a.f.divider3);
            this.aOa = viewGroup.findViewById(a.f.divider4);
            this.aOW = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aOb = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aOc = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aNY = viewGroup.findViewById(a.f.divider2);
            this.aIZ = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aOe = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aOX = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aPc = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aPe = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.Pf() || com.baidu.swan.apps.an.a.Pe()) {
                int dimensionPixelSize = this.aNT.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aNT.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.aOY = color;
            this.aOZ = color;
        }
    }
}
