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
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a bJl;

    /* loaded from: classes9.dex */
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

    public a Zx() {
        return this.bJl;
    }

    void a(a aVar) {
        this.bJl = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b bJm;
        protected final g bkd;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bkd = bT(context);
            this.bkd.a(this);
            this.bJm = new b((ViewGroup) this.bkd.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a Zy() {
            if (af.isScreenLand()) {
                fD(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                fA(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bT(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a em(int i) {
            this.bJm.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bJm.mTitle.setText(charSequence);
            } else {
                dp(true);
            }
            return this;
        }

        public a dp(boolean z) {
            this.bJm.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a el(int i) {
            if (this.bJm.mMessageContent.getVisibility() != 0) {
                this.bJm.mMessageContent.setVisibility(0);
            }
            this.bJm.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a kr(String str) {
            if (this.bJm.mMessageContent.getVisibility() != 0) {
                this.bJm.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.bJm.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bJm.mMessageContent.getVisibility() != 0) {
                this.bJm.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.bJm.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.bJm.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a Zz() {
            this.bJm.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bJm.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fA(int i) {
            this.bJm.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bJm.mPositiveButton.setVisibility(8);
                if (this.bJm.mNegativeButton.getVisibility() == 0) {
                    this.bJm.mDivider3.setVisibility(8);
                }
            } else {
                this.bJm.mPositiveButton.setVisibility(0);
                if (this.bJm.mNegativeButton.getVisibility() == 0) {
                    this.bJm.mDivider3.setVisibility(0);
                }
                this.bJm.mPositiveButton.setText(charSequence);
                this.bJm.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bkd.onButtonClick(-1);
                        a.this.bkd.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bkd, -1);
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
                        a.this.bkd.onButtonClick(i);
                        a.this.bkd.dismiss();
                        onClickListener.onClick(a.this.bkd, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.bJm.mPositiveButton == null || this.bJm.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bJm.mPositiveButton;
                i = 1;
            }
            if (this.bJm.mNegativeButton != null && this.bJm.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.bJm.mNegativeButton;
            }
            if (this.bJm.mNeutralButton != null && this.bJm.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.bJm.mNeutralButton;
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
                this.bJm.mNegativeButton.setVisibility(8);
                if (this.bJm.mPositiveButton.getVisibility() == 0) {
                    this.bJm.mDivider3.setVisibility(8);
                }
            } else {
                this.bJm.mNegativeButton.setVisibility(0);
                if (this.bJm.mPositiveButton.getVisibility() == 0) {
                    this.bJm.mDivider3.setVisibility(0);
                }
                this.bJm.mNegativeButton.setText(charSequence);
                this.bJm.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bkd.onButtonClick(-2);
                        a.this.bkd.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bkd, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a dq(boolean z) {
            if (z) {
                this.bJm.mDivider2.setVisibility(0);
            } else {
                this.bJm.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fB(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bJm.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void fC(int i) {
            this.bJm.mDialogLayout.getLayoutParams().height = i;
            this.bJm.mDialogLayout.requestLayout();
        }

        public void fD(int i) {
            this.bJm.mDialogLayout.getLayoutParams().width = i;
            this.bJm.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bJm.mNeutralButton.setVisibility(0);
            if (this.bJm.mPositiveButton.getVisibility() == 0) {
                this.bJm.mDivider4.setVisibility(0);
            }
            this.bJm.mNeutralButton.setText(charSequence);
            this.bJm.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkd.onButtonClick(-3);
                    a.this.bkd.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bkd, -3);
                    }
                }
            });
            return this;
        }

        public a fE(int i) {
            this.bJm.mIcon.setImageResource(i);
            return this;
        }

        public a aj(View view) {
            this.bJm.mDialogContent.removeAllViews();
            this.bJm.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bJm.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a ZA() {
            this.bJm.bJq.setPadding(0, 0, 0, 0);
            return this;
        }

        public a ZB() {
            ((ViewGroup.MarginLayoutParams) this.bJm.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a dr(boolean z) {
            this.bJm.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bJm.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bJm.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.bJm.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.bJm.bJp = cVar;
            return this;
        }

        public a ds(boolean z) {
            this.bJm.bJs.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Mq() {
            this.bkd.setCancelable(this.bJm.mCancelable.booleanValue());
            if (this.bJm.mCancelable.booleanValue()) {
                this.bkd.setCanceledOnTouchOutside(false);
            }
            this.bkd.setOnCancelListener(this.bJm.mOnCancelListener);
            this.bkd.setOnDismissListener(this.bJm.mOnDismissListener);
            this.bkd.setOnShowListener(this.bJm.mOnShowListener);
            if (this.bJm.mOnKeyListener != null) {
                this.bkd.setOnKeyListener(this.bJm.mOnKeyListener);
            }
            updateDialogUI();
            if (this.bJm.bJp != null) {
                this.bJm.bJp.a(this.bkd, this.bJm);
            }
            this.bkd.a(this);
            return this.bkd;
        }

        @Deprecated
        public g dt(boolean z) {
            return ZC();
        }

        public g ZC() {
            g Mq = Mq();
            if (this.mSystemDialog) {
                Mq.getWindow().setType(2003);
            }
            try {
                Mq.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return Mq;
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
            this.bJm.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.bJm.bJt != -1 ? this.bJm.bJt : a.e.aiapps_dialog_bg_white));
            this.bJm.mTitle.setTextColor(color);
            this.bJm.mMessage.setTextColor(color4);
            this.bJm.mPositiveButton.setTextColor(this.bJm.mPositiveBtnTextColor != color3 ? this.bJm.mPositiveBtnTextColor : color3);
            if (this.bJm.mNegativeBtnTextColor != color2) {
                this.bJm.mNegativeButton.setTextColor(this.bJm.mNegativeBtnTextColor);
            } else if (this.bJm.bJo != -1) {
                this.bJm.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.bJm.bJo));
            } else {
                this.bJm.mNegativeButton.setTextColor(color2);
            }
            this.bJm.mNeutralButton.setTextColor(color2);
            int color6 = this.bJm.bJu != -1 ? getAlertDialogResources().getColor(this.bJm.bJu) : color5;
            this.bJm.mDivider2.setBackgroundColor(color6);
            this.bJm.mDivider3.setBackgroundColor(color6);
            this.bJm.mDivider4.setBackgroundColor(color6);
            this.bJm.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bJm.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bJm.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.bJm.bJv ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a du(boolean z) {
            this.bJm.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a dv(boolean z) {
            this.bJm.bJv = z;
            return this;
        }

        public a dw(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bJm.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a fF(int i) {
            return fG(getAlertDialogResources().getColor(i));
        }

        public a F(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fG(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fF(i);
            }
            return this;
        }

        public a fG(int i) {
            this.bJm.mPositiveBtnTextColor = i;
            this.bJm.mPositiveButton.setTextColor(i);
            return this;
        }

        public a fH(int i) {
            return fJ(this.mContext.getResources().getColor(i));
        }

        public a fI(int i) {
            this.bJm.bJo = i;
            return this;
        }

        public a G(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fJ(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fH(i);
            }
            return this;
        }

        public a fJ(int i) {
            this.bJm.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.bJm.mDialogContent;
        }

        public a o(int i, int i2, int i3, int i4) {
            this.bJm.bJr.setPadding(i, i2, i3, i4);
            return this;
        }

        public a fK(int i) {
            this.bJm.bJt = i;
            this.bJm.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a fL(int i) {
            this.bJm.bJu = i;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public SwanAppScrollView bFS;
        public c bJp;
        public FrameLayout bJq;
        public FrameLayout bJr;
        public View bJs;
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
        public int bJo = -1;
        public int bJt = -1;
        public int bJu = -1;
        public boolean bJv = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.bJr = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.bFS = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bJq = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bJs = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.bFS.setMaxHeight(i);
        }
    }
}
