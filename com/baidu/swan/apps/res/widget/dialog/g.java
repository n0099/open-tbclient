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
    private a aOe;

    /* loaded from: classes2.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    protected void dm(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a KF() {
        return this.aOe;
    }

    void a(a aVar) {
        this.aOe = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static final int aNy = a.h.aiapps_dialog_negative_title_cancel;
        public static final int aNz = a.h.aiapps_dialog_positive_title_ok;
        protected int aNw;
        protected final b aOf;
        private boolean aOg = false;
        protected final g arC;
        private Context mContext;

        public a(Context context) {
            this.arC = aU(context);
            this.arC.a(this);
            this.aOf = new b((ViewGroup) this.arC.getWindow().getDecorView());
            this.mContext = context;
            this.aNw = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        protected g aU(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a cm(int i) {
            this.aOf.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a d(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.aOf.mTitle.setText(charSequence);
            } else {
                bZ(true);
            }
            return this;
        }

        public a bZ(boolean z) {
            this.aOf.aOj.setVisibility(z ? 8 : 0);
            return this;
        }

        public a cl(int i) {
            if (this.aOf.aNl.getVisibility() != 0) {
                this.aOf.aNl.setVisibility(0);
            }
            this.aOf.aNk.setText(this.mContext.getText(i));
            KH();
            return this;
        }

        public a gw(String str) {
            if (this.aOf.aNl.getVisibility() != 0) {
                this.aOf.aNl.setVisibility(0);
            }
            if (str != null) {
                this.aOf.aNk.setText(str);
                KH();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.aOf.aNl.getVisibility() != 0) {
                this.aOf.aNl.setVisibility(0);
            }
            if (spanned != null) {
                this.aOf.aNk.setMovementMethod(LinkMovementMethod.getInstance());
                this.aOf.aNk.setText(spanned);
                KH();
            }
            return this;
        }

        public a KG() {
            this.aOf.aNk.setGravity(3);
            return this;
        }

        private void KH() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aNw);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.aOf.aNv.setLayoutParams(layoutParams);
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.aOf.aNm.setVisibility(8);
                if (this.aOf.aNn.getVisibility() == 0) {
                    this.aOf.aNq.setVisibility(8);
                }
            } else {
                this.aOf.aNm.setVisibility(0);
                if (this.aOf.aNn.getVisibility() == 0) {
                    this.aOf.aNq.setVisibility(0);
                }
                this.aOf.aNm.setText(charSequence);
                this.aOf.aNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arC.dm(-1);
                        a.this.arC.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arC, -1);
                        }
                    }
                });
            }
            return this;
        }

        public TextView KB() {
            int i;
            TextView textView;
            if (this.aOf.aNm == null || this.aOf.aNm.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.aOf.aNm;
                i = 1;
            }
            if (this.aOf.aNn != null && this.aOf.aNn.getVisibility() == 0) {
                i++;
                textView = this.aOf.aNn;
            }
            if (this.aOf.aNo != null && this.aOf.aNo.getVisibility() == 0) {
                i++;
                textView = this.aOf.aNo;
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
                this.aOf.aNn.setVisibility(8);
                if (this.aOf.aNm.getVisibility() == 0) {
                    this.aOf.aNq.setVisibility(8);
                }
            } else {
                this.aOf.aNn.setVisibility(0);
                if (this.aOf.aNm.getVisibility() == 0) {
                    this.aOf.aNq.setVisibility(0);
                }
                this.aOf.aNn.setText(charSequence);
                this.aOf.aNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.arC.dm(-2);
                        a.this.arC.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.arC, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void ca(boolean z) {
            if (z) {
                this.aOf.aNp.setVisibility(0);
            } else {
                this.aOf.aNp.setVisibility(8);
            }
        }

        public a dp(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.aOf.aNp.setLayoutParams(layoutParams);
            return this;
        }

        public void dq(int i) {
            this.aOf.aNt.setLayoutParams(new FrameLayout.LayoutParams(-1, i));
        }

        public a dr(int i) {
            this.aOf.mIcon.setImageResource(i);
            return this;
        }

        public a ad(View view) {
            this.aOf.aNs.removeAllViews();
            this.aOf.aNs.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aNw);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.aOf.aNv.setLayoutParams(layoutParams);
            return this;
        }

        public a KI() {
            this.aOf.aOs.setPadding(0, 0, 0, 0);
            return this;
        }

        public a KJ() {
            ((ViewGroup.MarginLayoutParams) this.aOf.aOm.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a cb(boolean z) {
            this.aOf.aOk = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aOf.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.aOf.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(c cVar) {
            this.aOf.aOr = cVar;
            return this;
        }

        public a cc(boolean z) {
            this.aOf.aOu.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Aq() {
            this.arC.setCancelable(this.aOf.aOk.booleanValue());
            if (this.aOf.aOk.booleanValue()) {
                this.arC.setCanceledOnTouchOutside(false);
            }
            this.arC.setOnCancelListener(this.aOf.mOnCancelListener);
            this.arC.setOnDismissListener(this.aOf.mOnDismissListener);
            this.arC.setOnShowListener(this.aOf.aOl);
            if (this.aOf.mOnKeyListener != null) {
                this.arC.setOnKeyListener(this.aOf.mOnKeyListener);
            }
            KM();
            if (this.aOf.aOr != null) {
                this.aOf.aOr.a(this.arC, this.aOf);
            }
            this.arC.a(this);
            return this.arC;
        }

        @Deprecated
        public g cd(boolean z) {
            return KK();
        }

        public g KK() {
            g Aq = Aq();
            if (this.aOg) {
                Aq.getWindow().setType(2003);
            }
            try {
                Aq.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a(SmsLoginView.StatEvent.LOGIN_SHOW));
            return Aq;
        }

        protected Resources KL() {
            return this.mContext.getResources();
        }

        private void KM() {
            int color = KL().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = KL().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = KL().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = KL().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = KL().getColor(a.c.aiapps_dialog_gray);
            this.aOf.aNt.setBackground(KL().getDrawable(this.aOf.aOv != -1 ? this.aOf.aOv : a.e.aiapps_dialog_bg_white));
            this.aOf.mTitle.setTextColor(color);
            this.aOf.aNk.setTextColor(color4);
            this.aOf.aNm.setTextColor(this.aOf.aOo != color3 ? this.aOf.aOo : color3);
            if (this.aOf.aOp != color2) {
                this.aOf.aNn.setTextColor(this.aOf.aOp);
            } else if (this.aOf.aOq != -1) {
                this.aOf.aNn.setTextColor(KL().getColorStateList(this.aOf.aOq));
            } else {
                this.aOf.aNn.setTextColor(color2);
            }
            this.aOf.aNo.setTextColor(color2);
            int color6 = this.aOf.aOw != -1 ? KL().getColor(this.aOf.aOw) : color5;
            this.aOf.aNp.setBackgroundColor(color6);
            this.aOf.aNq.setBackgroundColor(color6);
            this.aOf.aNr.setBackgroundColor(color6);
            this.aOf.aNm.setBackground(KL().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.aOf.aNn.setBackground(KL().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.aOf.aNo.setBackground(KL().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView KB = KB();
            if (KB != null) {
                KB.setBackground(this.aOf.aOx ? KL().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a ce(boolean z) {
            this.aOf.aNv.setVisibility(z ? 0 : 8);
            return this;
        }

        public a cf(boolean z) {
            this.aOf.aOx = z;
            return this;
        }

        public a cg(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.aOf.aOn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a ds(int i) {
            return dt(KL().getColor(i));
        }

        public a C(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    dt(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                ds(i);
            }
            return this;
        }

        public a dt(int i) {
            this.aOf.aOo = i;
            this.aOf.aNm.setTextColor(i);
            return this;
        }

        public a du(int i) {
            return dw(this.mContext.getResources().getColor(i));
        }

        public a dv(int i) {
            this.aOf.aOq = i;
            return this;
        }

        public a D(String str, int i) {
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
                du(i);
            }
            return this;
        }

        public a dw(int i) {
            this.aOf.aOp = i;
            return this;
        }

        public ViewGroup KN() {
            return this.aOf.aNs;
        }

        public a f(int i, int i2, int i3, int i4) {
            this.aOf.aOt.setPadding(i, i2, i3, i4);
            return this;
        }

        public a dx(int i) {
            this.aOf.aOv = i;
            this.aOf.aNt.setBackgroundResource(i);
            return this;
        }

        public a dy(int i) {
            this.aOf.aOw = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public SwanAppScrollView aIr;
        public TextView aNk;
        public LinearLayout aNl;
        public TextView aNm;
        public TextView aNn;
        public TextView aNo;
        public View aNp;
        public View aNq;
        public View aNr;
        public FrameLayout aNs;
        public RelativeLayout aNt;
        public LinearLayout aNv;
        public LinearLayout aOj;
        public DialogInterface.OnShowListener aOl;
        public View aOm;
        public View aOn;
        public int aOo;
        public int aOp;
        public c aOr;
        public FrameLayout aOs;
        public FrameLayout aOt;
        public View aOu;
        public ImageView mIcon;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public ViewGroup mRoot;
        public TextView mTitle;
        public Boolean aOk = true;
        public int aOq = -1;
        public int aOv = -1;
        public int aOw = -1;
        public boolean aOx = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.aOt = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aOj = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.aNk = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.aNl = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.aNm = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.aNn = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.aNo = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.aNq = viewGroup.findViewById(a.f.divider3);
            this.aNr = viewGroup.findViewById(a.f.divider4);
            this.aOm = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aNs = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.aNt = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.aNp = viewGroup.findViewById(a.f.divider2);
            this.aIr = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.aNv = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.aOn = viewGroup.findViewById(a.f.dialog_customPanel);
            this.aOs = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.aOu = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.an.a.Oq() || com.baidu.swan.apps.an.a.Op()) {
                int dimensionPixelSize = this.aNk.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.aNk.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.aOo = color;
            this.aOp = color;
        }
    }
}
