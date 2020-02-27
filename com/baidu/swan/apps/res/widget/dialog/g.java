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
    private a bOa;

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

    public a aci() {
        return this.bOa;
    }

    void a(a aVar) {
        this.bOa = aVar;
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
        protected final b bOb;
        protected final g bpc;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bpc = bX(context);
            this.bpc.a(this);
            this.bOb = new b((ViewGroup) this.bpc.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a acj() {
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
            this.bOb.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bOb.mTitle.setText(charSequence);
            } else {
                dB(true);
            }
            return this;
        }

        public a dB(boolean z) {
            this.bOb.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eC(int i) {
            if (this.bOb.mMessageContent.getVisibility() != 0) {
                this.bOb.mMessageContent.setVisibility(0);
            }
            this.bOb.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a kJ(String str) {
            if (this.bOb.mMessageContent.getVisibility() != 0) {
                this.bOb.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.bOb.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bOb.mMessageContent.getVisibility() != 0) {
                this.bOb.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.bOb.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.bOb.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a ack() {
            this.bOb.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bOb.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fR(int i) {
            this.bOb.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bOb.mPositiveButton.setVisibility(8);
                if (this.bOb.mNegativeButton.getVisibility() == 0) {
                    this.bOb.mDivider3.setVisibility(8);
                }
            } else {
                this.bOb.mPositiveButton.setVisibility(0);
                if (this.bOb.mNegativeButton.getVisibility() == 0) {
                    this.bOb.mDivider3.setVisibility(0);
                }
                this.bOb.mPositiveButton.setText(charSequence);
                this.bOb.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpc.onButtonClick(-1);
                        a.this.bpc.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpc, -1);
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
                        a.this.bpc.onButtonClick(i);
                        a.this.bpc.dismiss();
                        onClickListener.onClick(a.this.bpc, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.bOb.mPositiveButton == null || this.bOb.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bOb.mPositiveButton;
                i = 1;
            }
            if (this.bOb.mNegativeButton != null && this.bOb.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.bOb.mNegativeButton;
            }
            if (this.bOb.mNeutralButton != null && this.bOb.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.bOb.mNeutralButton;
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
                this.bOb.mNegativeButton.setVisibility(8);
                if (this.bOb.mPositiveButton.getVisibility() == 0) {
                    this.bOb.mDivider3.setVisibility(8);
                }
            } else {
                this.bOb.mNegativeButton.setVisibility(0);
                if (this.bOb.mPositiveButton.getVisibility() == 0) {
                    this.bOb.mDivider3.setVisibility(0);
                }
                this.bOb.mNegativeButton.setText(charSequence);
                this.bOb.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpc.onButtonClick(-2);
                        a.this.bpc.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpc, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a dC(boolean z) {
            if (z) {
                this.bOb.mDivider2.setVisibility(0);
            } else {
                this.bOb.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fS(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bOb.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void fT(int i) {
            this.bOb.mDialogLayout.getLayoutParams().height = i;
            this.bOb.mDialogLayout.requestLayout();
        }

        public void fU(int i) {
            this.bOb.mDialogLayout.getLayoutParams().width = i;
            this.bOb.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOb.mNeutralButton.setVisibility(0);
            if (this.bOb.mPositiveButton.getVisibility() == 0) {
                this.bOb.mDivider4.setVisibility(0);
            }
            this.bOb.mNeutralButton.setText(charSequence);
            this.bOb.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bpc.onButtonClick(-3);
                    a.this.bpc.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bpc, -3);
                    }
                }
            });
            return this;
        }

        public a fV(int i) {
            this.bOb.mIcon.setImageResource(i);
            return this;
        }

        public a an(View view) {
            this.bOb.mDialogContent.removeAllViews();
            this.bOb.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bOb.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a acl() {
            this.bOb.bOf.setPadding(0, 0, 0, 0);
            return this;
        }

        public a acm() {
            ((ViewGroup.MarginLayoutParams) this.bOb.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a dD(boolean z) {
            this.bOb.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bOb.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bOb.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.bOb.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.bOb.bOe = cVar;
            return this;
        }

        public a dE(boolean z) {
            this.bOb.bOh.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Pa() {
            this.bpc.setCancelable(this.bOb.mCancelable.booleanValue());
            if (this.bOb.mCancelable.booleanValue()) {
                this.bpc.setCanceledOnTouchOutside(false);
            }
            this.bpc.setOnCancelListener(this.bOb.mOnCancelListener);
            this.bpc.setOnDismissListener(this.bOb.mOnDismissListener);
            this.bpc.setOnShowListener(this.bOb.mOnShowListener);
            if (this.bOb.mOnKeyListener != null) {
                this.bpc.setOnKeyListener(this.bOb.mOnKeyListener);
            }
            updateDialogUI();
            if (this.bOb.bOe != null) {
                this.bOb.bOe.a(this.bpc, this.bOb);
            }
            this.bpc.a(this);
            return this.bpc;
        }

        @Deprecated
        public g dF(boolean z) {
            return acn();
        }

        public g acn() {
            g Pa = Pa();
            if (this.mSystemDialog) {
                Pa.getWindow().setType(2003);
            }
            try {
                Pa.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return Pa;
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
            this.bOb.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.bOb.bOi != -1 ? this.bOb.bOi : a.e.aiapps_dialog_bg_white));
            this.bOb.mTitle.setTextColor(color);
            this.bOb.mMessage.setTextColor(color4);
            this.bOb.mPositiveButton.setTextColor(this.bOb.mPositiveBtnTextColor != color3 ? this.bOb.mPositiveBtnTextColor : color3);
            if (this.bOb.mNegativeBtnTextColor != color2) {
                this.bOb.mNegativeButton.setTextColor(this.bOb.mNegativeBtnTextColor);
            } else if (this.bOb.bOd != -1) {
                this.bOb.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.bOb.bOd));
            } else {
                this.bOb.mNegativeButton.setTextColor(color2);
            }
            this.bOb.mNeutralButton.setTextColor(color2);
            int color6 = this.bOb.bOj != -1 ? getAlertDialogResources().getColor(this.bOb.bOj) : color5;
            this.bOb.mDivider2.setBackgroundColor(color6);
            this.bOb.mDivider3.setBackgroundColor(color6);
            this.bOb.mDivider4.setBackgroundColor(color6);
            this.bOb.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bOb.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bOb.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.bOb.bOk ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a dG(boolean z) {
            this.bOb.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a dH(boolean z) {
            this.bOb.bOk = z;
            return this;
        }

        public a dI(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bOb.mCustomPanel.getLayoutParams();
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
            this.bOb.mPositiveBtnTextColor = i;
            this.bOb.mPositiveButton.setTextColor(i);
            return this;
        }

        public a fY(int i) {
            return ga(this.mContext.getResources().getColor(i));
        }

        public a fZ(int i) {
            this.bOb.bOd = i;
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
            this.bOb.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.bOb.mDialogContent;
        }

        public a o(int i, int i2, int i3, int i4) {
            this.bOb.bOg.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gb(int i) {
            this.bOb.bOi = i;
            this.bOb.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gc(int i) {
            this.bOb.bOj = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView bKI;
        public c bOe;
        public FrameLayout bOf;
        public FrameLayout bOg;
        public View bOh;
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
        public int bOd = -1;
        public int bOi = -1;
        public int bOj = -1;
        public boolean bOk = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.bOg = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.bKI = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOf = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOh = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.bKI.setMaxHeight(i);
        }
    }
}
