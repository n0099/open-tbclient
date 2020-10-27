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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes10.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dlQ;

    /* loaded from: classes10.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, int i) {
        super(context, i);
        init();
    }

    public void onButtonClick(int i) {
    }

    protected void init() {
        setContentView(a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    public a aEw() {
        return this.dlQ;
    }

    void a(a aVar) {
        this.dlQ = aVar;
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
        protected final g cFR;
        protected final b dlR;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cFR = bX(context);
            this.cFR.a(this);
            this.dlR = new b((ViewGroup) this.cFR.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aEx() {
            if (ah.isScreenLand()) {
                jP(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                jM(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bX(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a hV(int i) {
            this.dlR.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dlR.mTitle.setText(charSequence);
            } else {
                gg(true);
            }
            return this;
        }

        public a gg(boolean z) {
            this.dlR.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a hU(int i) {
            if (this.dlR.mMessageContent.getVisibility() != 0) {
                this.dlR.mMessageContent.setVisibility(0);
            }
            this.dlR.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a rD(String str) {
            if (this.dlR.mMessageContent.getVisibility() != 0) {
                this.dlR.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.dlR.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dlR.mMessageContent.getVisibility() != 0) {
                this.dlR.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.dlR.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.dlR.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aEy() {
            this.dlR.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dlR.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a jM(int i) {
            this.dlR.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dlR.mPositiveButton.setVisibility(8);
                if (this.dlR.mNegativeButton.getVisibility() == 0) {
                    this.dlR.mDivider3.setVisibility(8);
                }
            } else {
                this.dlR.mPositiveButton.setVisibility(0);
                if (this.dlR.mNegativeButton.getVisibility() == 0) {
                    this.dlR.mDivider3.setVisibility(0);
                }
                this.dlR.mPositiveButton.setText(charSequence);
                this.dlR.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cFR.onButtonClick(-1);
                        a.this.cFR.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cFR, -1);
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
                        a.this.cFR.onButtonClick(i);
                        a.this.cFR.dismiss();
                        onClickListener.onClick(a.this.cFR, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.dlR.mPositiveButton == null || this.dlR.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.dlR.mPositiveButton;
                i = 1;
            }
            if (this.dlR.mNegativeButton != null && this.dlR.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.dlR.mNegativeButton;
            }
            if (this.dlR.mNeutralButton != null && this.dlR.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.dlR.mNeutralButton;
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
                this.dlR.mNegativeButton.setVisibility(8);
                if (this.dlR.mPositiveButton.getVisibility() == 0) {
                    this.dlR.mDivider3.setVisibility(8);
                }
            } else {
                this.dlR.mNegativeButton.setVisibility(0);
                if (this.dlR.mPositiveButton.getVisibility() == 0) {
                    this.dlR.mDivider3.setVisibility(0);
                }
                this.dlR.mNegativeButton.setText(charSequence);
                this.dlR.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cFR.onButtonClick(-2);
                        a.this.cFR.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cFR, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gh(boolean z) {
            if (z) {
                this.dlR.mDivider2.setVisibility(0);
            } else {
                this.dlR.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a jN(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dlR.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void jO(int i) {
            this.dlR.mDialogLayout.getLayoutParams().height = i;
            this.dlR.mDialogLayout.requestLayout();
        }

        public void jP(int i) {
            this.dlR.mDialogLayout.getLayoutParams().width = i;
            this.dlR.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dlR.mNeutralButton.setVisibility(0);
            if (this.dlR.mPositiveButton.getVisibility() == 0) {
                this.dlR.mDivider4.setVisibility(0);
            }
            this.dlR.mNeutralButton.setText(charSequence);
            this.dlR.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cFR.onButtonClick(-3);
                    a.this.cFR.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cFR, -3);
                    }
                }
            });
            return this;
        }

        public a jQ(int i) {
            this.dlR.mIcon.setImageResource(i);
            return this;
        }

        public a aw(View view) {
            this.dlR.mDialogContent.removeAllViews();
            this.dlR.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dlR.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aEz() {
            this.dlR.dlV.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aEA() {
            ((ViewGroup.MarginLayoutParams) this.dlR.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gi(boolean z) {
            this.dlR.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.dlR.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dlR.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dlR.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dlR.dlU = cVar;
            return this;
        }

        public a gj(boolean z) {
            this.dlR.dlX.setVisibility(z ? 0 : 8);
            return this;
        }

        public g ano() {
            this.cFR.setCancelable(this.dlR.mCancelable.booleanValue());
            if (this.dlR.mCancelable.booleanValue()) {
                this.cFR.setCanceledOnTouchOutside(false);
            }
            this.cFR.setOnCancelListener(this.dlR.mOnCancelListener);
            this.cFR.setOnDismissListener(this.dlR.mOnDismissListener);
            this.cFR.setOnShowListener(this.dlR.mOnShowListener);
            if (this.dlR.mOnKeyListener != null) {
                this.cFR.setOnKeyListener(this.dlR.mOnKeyListener);
            }
            updateDialogUI();
            if (this.dlR.dlU != null) {
                this.dlR.dlU.a(this.cFR, this.dlR);
            }
            this.cFR.a(this);
            return this.cFR;
        }

        @Deprecated
        public g gk(boolean z) {
            return aEB();
        }

        public g aEB() {
            g ano = ano();
            if (this.mSystemDialog) {
                ano.getWindow().setType(2003);
            }
            try {
                ano.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return ano;
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
            this.dlR.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.dlR.dlY != -1 ? this.dlR.dlY : a.e.aiapps_dialog_bg_white));
            this.dlR.mTitle.setTextColor(color);
            this.dlR.mMessage.setTextColor(color4);
            this.dlR.mPositiveButton.setTextColor(this.dlR.mPositiveBtnTextColor != color3 ? this.dlR.mPositiveBtnTextColor : color3);
            if (this.dlR.mNegativeBtnTextColor != color2) {
                this.dlR.mNegativeButton.setTextColor(this.dlR.mNegativeBtnTextColor);
            } else if (this.dlR.dlT != -1) {
                this.dlR.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.dlR.dlT));
            } else {
                this.dlR.mNegativeButton.setTextColor(color2);
            }
            this.dlR.mNeutralButton.setTextColor(color2);
            int color6 = this.dlR.dlZ != -1 ? getAlertDialogResources().getColor(this.dlR.dlZ) : color5;
            this.dlR.mDivider2.setBackgroundColor(color6);
            this.dlR.mDivider3.setBackgroundColor(color6);
            this.dlR.mDivider4.setBackgroundColor(color6);
            this.dlR.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dlR.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dlR.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.dlR.dma ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gl(boolean z) {
            this.dlR.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gm(boolean z) {
            this.dlR.dma = z;
            return this;
        }

        public a gn(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dlR.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a jR(int i) {
            return jS(getAlertDialogResources().getColor(i));
        }

        public a S(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jS(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jR(i);
            }
            return this;
        }

        public a jS(int i) {
            this.dlR.mPositiveBtnTextColor = i;
            this.dlR.mPositiveButton.setTextColor(i);
            return this;
        }

        public a jT(int i) {
            return jV(this.mContext.getResources().getColor(i));
        }

        public a jU(int i) {
            this.dlR.dlT = i;
            return this;
        }

        public a T(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jV(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jT(i);
            }
            return this;
        }

        public a jV(int i) {
            this.dlR.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.dlR.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.dlR.dlW.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jW(int i) {
            this.dlR.dlY = i;
            this.dlR.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a jX(int i) {
            this.dlR.dlZ = i;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public SwanAppScrollView dhH;
        public c dlU;
        public FrameLayout dlV;
        public FrameLayout dlW;
        public View dlX;
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
        public int dlT = -1;
        public int dlY = -1;
        public int dlZ = -1;
        public boolean dma = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.dlW = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.dhH = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dlV = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dlX = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.dhH.setMaxHeight(i);
        }
    }
}
