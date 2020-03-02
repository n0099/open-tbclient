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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a bOb;

    /* loaded from: classes11.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    protected void onButtonClick(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a ack() {
        return this.bOb;
    }

    void a(a aVar) {
        this.bOb = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b bOc;
        protected final g bpd;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bpd = bX(context);
            this.bpd.a(this);
            this.bOc = new b((ViewGroup) this.bpd.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a acl() {
            if (af.isScreenLand()) {
                fU(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                fR(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bX(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a eD(int i) {
            this.bOc.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bOc.mTitle.setText(charSequence);
            } else {
                dB(true);
            }
            return this;
        }

        public a dB(boolean z) {
            this.bOc.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eC(int i) {
            if (this.bOc.mMessageContent.getVisibility() != 0) {
                this.bOc.mMessageContent.setVisibility(0);
            }
            this.bOc.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a kJ(String str) {
            if (this.bOc.mMessageContent.getVisibility() != 0) {
                this.bOc.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.bOc.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bOc.mMessageContent.getVisibility() != 0) {
                this.bOc.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.bOc.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.bOc.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a acm() {
            this.bOc.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bOc.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fR(int i) {
            this.bOc.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bOc.mPositiveButton.setVisibility(8);
                if (this.bOc.mNegativeButton.getVisibility() == 0) {
                    this.bOc.mDivider3.setVisibility(8);
                }
            } else {
                this.bOc.mPositiveButton.setVisibility(0);
                if (this.bOc.mNegativeButton.getVisibility() == 0) {
                    this.bOc.mDivider3.setVisibility(0);
                }
                this.bOc.mPositiveButton.setText(charSequence);
                this.bOc.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpd.onButtonClick(-1);
                        a.this.bpd.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpd, -1);
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
                        a.this.bpd.onButtonClick(i);
                        a.this.bpd.dismiss();
                        onClickListener.onClick(a.this.bpd, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.bOc.mPositiveButton == null || this.bOc.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bOc.mPositiveButton;
                i = 1;
            }
            if (this.bOc.mNegativeButton != null && this.bOc.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.bOc.mNegativeButton;
            }
            if (this.bOc.mNeutralButton != null && this.bOc.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.bOc.mNeutralButton;
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
                this.bOc.mNegativeButton.setVisibility(8);
                if (this.bOc.mPositiveButton.getVisibility() == 0) {
                    this.bOc.mDivider3.setVisibility(8);
                }
            } else {
                this.bOc.mNegativeButton.setVisibility(0);
                if (this.bOc.mPositiveButton.getVisibility() == 0) {
                    this.bOc.mDivider3.setVisibility(0);
                }
                this.bOc.mNegativeButton.setText(charSequence);
                this.bOc.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpd.onButtonClick(-2);
                        a.this.bpd.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpd, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a dC(boolean z) {
            if (z) {
                this.bOc.mDivider2.setVisibility(0);
            } else {
                this.bOc.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fS(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bOc.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void fT(int i) {
            this.bOc.mDialogLayout.getLayoutParams().height = i;
            this.bOc.mDialogLayout.requestLayout();
        }

        public void fU(int i) {
            this.bOc.mDialogLayout.getLayoutParams().width = i;
            this.bOc.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOc.mNeutralButton.setVisibility(0);
            if (this.bOc.mPositiveButton.getVisibility() == 0) {
                this.bOc.mDivider4.setVisibility(0);
            }
            this.bOc.mNeutralButton.setText(charSequence);
            this.bOc.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bpd.onButtonClick(-3);
                    a.this.bpd.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bpd, -3);
                    }
                }
            });
            return this;
        }

        public a fV(int i) {
            this.bOc.mIcon.setImageResource(i);
            return this;
        }

        public a an(View view) {
            this.bOc.mDialogContent.removeAllViews();
            this.bOc.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bOc.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a acn() {
            this.bOc.bOg.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aco() {
            ((ViewGroup.MarginLayoutParams) this.bOc.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a dD(boolean z) {
            this.bOc.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bOc.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bOc.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.bOc.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.bOc.bOf = cVar;
            return this;
        }

        public a dE(boolean z) {
            this.bOc.bOi.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Pc() {
            this.bpd.setCancelable(this.bOc.mCancelable.booleanValue());
            if (this.bOc.mCancelable.booleanValue()) {
                this.bpd.setCanceledOnTouchOutside(false);
            }
            this.bpd.setOnCancelListener(this.bOc.mOnCancelListener);
            this.bpd.setOnDismissListener(this.bOc.mOnDismissListener);
            this.bpd.setOnShowListener(this.bOc.mOnShowListener);
            if (this.bOc.mOnKeyListener != null) {
                this.bpd.setOnKeyListener(this.bOc.mOnKeyListener);
            }
            updateDialogUI();
            if (this.bOc.bOf != null) {
                this.bOc.bOf.a(this.bpd, this.bOc);
            }
            this.bpd.a(this);
            return this.bpd;
        }

        @Deprecated
        public g dF(boolean z) {
            return acp();
        }

        public g acp() {
            g Pc = Pc();
            if (this.mSystemDialog) {
                Pc.getWindow().setType(2003);
            }
            try {
                Pc.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return Pc;
        }

        protected Resources getAlertDialogResources() {
            return this.mContext.getResources();
        }

        private void updateDialogUI() {
            int color = getAlertDialogResources().getColor(a.c.aiapps_dialog_title_text_color);
            int color2 = getAlertDialogResources().getColor(a.c.aiapps_dialog_btn_text_color);
            int color3 = getAlertDialogResources().getColor(a.c.aiapps_dialog_btn_text_color);
            int color4 = getAlertDialogResources().getColor(a.c.aiapps_box_dialog_message_text_color);
            int color5 = getAlertDialogResources().getColor(a.c.aiapps_dialog_gray);
            this.bOc.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.bOc.bOj != -1 ? this.bOc.bOj : a.e.aiapps_dialog_bg_white));
            this.bOc.mTitle.setTextColor(color);
            this.bOc.mMessage.setTextColor(color4);
            this.bOc.mPositiveButton.setTextColor(this.bOc.mPositiveBtnTextColor != color3 ? this.bOc.mPositiveBtnTextColor : color3);
            if (this.bOc.mNegativeBtnTextColor != color2) {
                this.bOc.mNegativeButton.setTextColor(this.bOc.mNegativeBtnTextColor);
            } else if (this.bOc.bOe != -1) {
                this.bOc.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.bOc.bOe));
            } else {
                this.bOc.mNegativeButton.setTextColor(color2);
            }
            this.bOc.mNeutralButton.setTextColor(color2);
            int color6 = this.bOc.bOk != -1 ? getAlertDialogResources().getColor(this.bOc.bOk) : color5;
            this.bOc.mDivider2.setBackgroundColor(color6);
            this.bOc.mDivider3.setBackgroundColor(color6);
            this.bOc.mDivider4.setBackgroundColor(color6);
            this.bOc.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bOc.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bOc.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.bOc.bOl ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a dG(boolean z) {
            this.bOc.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a dH(boolean z) {
            this.bOc.bOl = z;
            return this;
        }

        public a dI(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bOc.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a fW(int i) {
            return fX(getAlertDialogResources().getColor(i));
        }

        public a D(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fX(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fW(i);
            }
            return this;
        }

        public a fX(int i) {
            this.bOc.mPositiveBtnTextColor = i;
            this.bOc.mPositiveButton.setTextColor(i);
            return this;
        }

        public a fY(int i) {
            return ga(this.mContext.getResources().getColor(i));
        }

        public a fZ(int i) {
            this.bOc.bOe = i;
            return this;
        }

        public a E(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ga(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fY(i);
            }
            return this;
        }

        public a ga(int i) {
            this.bOc.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.bOc.mDialogContent;
        }

        public a o(int i, int i2, int i3, int i4) {
            this.bOc.bOh.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gb(int i) {
            this.bOc.bOj = i;
            this.bOc.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gc(int i) {
            this.bOc.bOk = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView bKJ;
        public c bOf;
        public FrameLayout bOg;
        public FrameLayout bOh;
        public View bOi;
        public LinearLayout mBtnPanelLayout;
        public View mCustomPanel;
        public FrameLayout mDialogContent;
        public View mDialogContentPanel;
        public RelativeLayout mDialogLayout;
        public View mDivider2;
        public View mDivider3;
        public View mDivider4;
        public ImageView mIcon;
        public TextView mMessage;
        public LinearLayout mMessageContent;
        public int mNegativeBtnTextColor;
        public TextView mNegativeButton;
        public TextView mNeutralButton;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public DialogInterface.OnShowListener mOnShowListener;
        public int mPositiveBtnTextColor;
        public TextView mPositiveButton;
        public ViewGroup mRoot;
        public TextView mTitle;
        public LinearLayout mTitlePanel;
        public Boolean mCancelable = true;
        public int bOe = -1;
        public int bOj = -1;
        public int bOk = -1;
        public boolean bOl = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.bOh = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mTitlePanel = (LinearLayout) viewGroup.findViewById(a.f.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(a.f.dialog_title);
            this.mMessage = (TextView) viewGroup.findViewById(a.f.dialog_message);
            this.mMessageContent = (LinearLayout) viewGroup.findViewById(a.f.dialog_message_content);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mNeutralButton = (TextView) viewGroup.findViewById(a.f.neutral_button);
            this.mDivider3 = viewGroup.findViewById(a.f.divider3);
            this.mDivider4 = viewGroup.findViewById(a.f.divider4);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(a.f.dialog_icon);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mDivider2 = viewGroup.findViewById(a.f.divider2);
            this.bKJ = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOg = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOi = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.bKJ.setMaxHeight(i);
        }
    }
}
