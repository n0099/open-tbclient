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
/* loaded from: classes10.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a bJV;

    /* loaded from: classes10.dex */
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

    public a ZU() {
        return this.bJV;
    }

    void a(a aVar) {
        this.bJV = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b bJW;
        protected final g bkS;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bkS = bT(context);
            this.bkS.a(this);
            this.bJW = new b((ViewGroup) this.bkS.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a ZV() {
            if (af.isScreenLand()) {
                fE(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                fB(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bT(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a en(int i) {
            this.bJW.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bJW.mTitle.setText(charSequence);
            } else {
                du(true);
            }
            return this;
        }

        public a du(boolean z) {
            this.bJW.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a em(int i) {
            if (this.bJW.mMessageContent.getVisibility() != 0) {
                this.bJW.mMessageContent.setVisibility(0);
            }
            this.bJW.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a ku(String str) {
            if (this.bJW.mMessageContent.getVisibility() != 0) {
                this.bJW.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.bJW.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bJW.mMessageContent.getVisibility() != 0) {
                this.bJW.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.bJW.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.bJW.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a ZW() {
            this.bJW.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bJW.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fB(int i) {
            this.bJW.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bJW.mPositiveButton.setVisibility(8);
                if (this.bJW.mNegativeButton.getVisibility() == 0) {
                    this.bJW.mDivider3.setVisibility(8);
                }
            } else {
                this.bJW.mPositiveButton.setVisibility(0);
                if (this.bJW.mNegativeButton.getVisibility() == 0) {
                    this.bJW.mDivider3.setVisibility(0);
                }
                this.bJW.mPositiveButton.setText(charSequence);
                this.bJW.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bkS.onButtonClick(-1);
                        a.this.bkS.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bkS, -1);
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
                        a.this.bkS.onButtonClick(i);
                        a.this.bkS.dismiss();
                        onClickListener.onClick(a.this.bkS, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.bJW.mPositiveButton == null || this.bJW.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bJW.mPositiveButton;
                i = 1;
            }
            if (this.bJW.mNegativeButton != null && this.bJW.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.bJW.mNegativeButton;
            }
            if (this.bJW.mNeutralButton != null && this.bJW.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.bJW.mNeutralButton;
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
                this.bJW.mNegativeButton.setVisibility(8);
                if (this.bJW.mPositiveButton.getVisibility() == 0) {
                    this.bJW.mDivider3.setVisibility(8);
                }
            } else {
                this.bJW.mNegativeButton.setVisibility(0);
                if (this.bJW.mPositiveButton.getVisibility() == 0) {
                    this.bJW.mDivider3.setVisibility(0);
                }
                this.bJW.mNegativeButton.setText(charSequence);
                this.bJW.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bkS.onButtonClick(-2);
                        a.this.bkS.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bkS, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a dv(boolean z) {
            if (z) {
                this.bJW.mDivider2.setVisibility(0);
            } else {
                this.bJW.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fC(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bJW.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void fD(int i) {
            this.bJW.mDialogLayout.getLayoutParams().height = i;
            this.bJW.mDialogLayout.requestLayout();
        }

        public void fE(int i) {
            this.bJW.mDialogLayout.getLayoutParams().width = i;
            this.bJW.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bJW.mNeutralButton.setVisibility(0);
            if (this.bJW.mPositiveButton.getVisibility() == 0) {
                this.bJW.mDivider4.setVisibility(0);
            }
            this.bJW.mNeutralButton.setText(charSequence);
            this.bJW.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkS.onButtonClick(-3);
                    a.this.bkS.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bkS, -3);
                    }
                }
            });
            return this;
        }

        public a fF(int i) {
            this.bJW.mIcon.setImageResource(i);
            return this;
        }

        public a an(View view) {
            this.bJW.mDialogContent.removeAllViews();
            this.bJW.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bJW.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a ZX() {
            this.bJW.bKa.setPadding(0, 0, 0, 0);
            return this;
        }

        public a ZY() {
            ((ViewGroup.MarginLayoutParams) this.bJW.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a dw(boolean z) {
            this.bJW.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bJW.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bJW.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.bJW.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.bJW.bJZ = cVar;
            return this;
        }

        public a dx(boolean z) {
            this.bJW.bKc.setVisibility(z ? 0 : 8);
            return this;
        }

        public g MM() {
            this.bkS.setCancelable(this.bJW.mCancelable.booleanValue());
            if (this.bJW.mCancelable.booleanValue()) {
                this.bkS.setCanceledOnTouchOutside(false);
            }
            this.bkS.setOnCancelListener(this.bJW.mOnCancelListener);
            this.bkS.setOnDismissListener(this.bJW.mOnDismissListener);
            this.bkS.setOnShowListener(this.bJW.mOnShowListener);
            if (this.bJW.mOnKeyListener != null) {
                this.bkS.setOnKeyListener(this.bJW.mOnKeyListener);
            }
            updateDialogUI();
            if (this.bJW.bJZ != null) {
                this.bJW.bJZ.a(this.bkS, this.bJW);
            }
            this.bkS.a(this);
            return this.bkS;
        }

        @Deprecated
        public g dy(boolean z) {
            return ZZ();
        }

        public g ZZ() {
            g MM = MM();
            if (this.mSystemDialog) {
                MM.getWindow().setType(2003);
            }
            try {
                MM.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return MM;
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
            this.bJW.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.bJW.bKd != -1 ? this.bJW.bKd : a.e.aiapps_dialog_bg_white));
            this.bJW.mTitle.setTextColor(color);
            this.bJW.mMessage.setTextColor(color4);
            this.bJW.mPositiveButton.setTextColor(this.bJW.mPositiveBtnTextColor != color3 ? this.bJW.mPositiveBtnTextColor : color3);
            if (this.bJW.mNegativeBtnTextColor != color2) {
                this.bJW.mNegativeButton.setTextColor(this.bJW.mNegativeBtnTextColor);
            } else if (this.bJW.bJY != -1) {
                this.bJW.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.bJW.bJY));
            } else {
                this.bJW.mNegativeButton.setTextColor(color2);
            }
            this.bJW.mNeutralButton.setTextColor(color2);
            int color6 = this.bJW.bKe != -1 ? getAlertDialogResources().getColor(this.bJW.bKe) : color5;
            this.bJW.mDivider2.setBackgroundColor(color6);
            this.bJW.mDivider3.setBackgroundColor(color6);
            this.bJW.mDivider4.setBackgroundColor(color6);
            this.bJW.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bJW.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bJW.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.bJW.bKf ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a dz(boolean z) {
            this.bJW.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a dA(boolean z) {
            this.bJW.bKf = z;
            return this;
        }

        public a dB(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bJW.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a fG(int i) {
            return fH(getAlertDialogResources().getColor(i));
        }

        public a F(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fH(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fG(i);
            }
            return this;
        }

        public a fH(int i) {
            this.bJW.mPositiveBtnTextColor = i;
            this.bJW.mPositiveButton.setTextColor(i);
            return this;
        }

        public a fI(int i) {
            return fK(this.mContext.getResources().getColor(i));
        }

        public a fJ(int i) {
            this.bJW.bJY = i;
            return this;
        }

        public a G(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fK(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                fI(i);
            }
            return this;
        }

        public a fK(int i) {
            this.bJW.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.bJW.mDialogContent;
        }

        public a o(int i, int i2, int i3, int i4) {
            this.bJW.bKb.setPadding(i, i2, i3, i4);
            return this;
        }

        public a fL(int i) {
            this.bJW.bKd = i;
            this.bJW.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a fM(int i) {
            this.bJW.bKe = i;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public SwanAppScrollView bGD;
        public c bJZ;
        public FrameLayout bKa;
        public FrameLayout bKb;
        public View bKc;
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
        public int bJY = -1;
        public int bKd = -1;
        public int bKe = -1;
        public boolean bKf = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.bKb = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.bGD = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bKa = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bKc = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.bGD.setMaxHeight(i);
        }
    }
}
