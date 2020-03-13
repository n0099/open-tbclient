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
    private a bOc;

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
        return this.bOc;
    }

    void a(a aVar) {
        this.bOc = aVar;
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
        protected final b bOd;
        protected final g bpe;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bpe = bX(context);
            this.bpe.a(this);
            this.bOd = new b((ViewGroup) this.bpe.getWindow().getDecorView());
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
            this.bOd.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.bOd.mTitle.setText(charSequence);
            } else {
                dB(true);
            }
            return this;
        }

        public a dB(boolean z) {
            this.bOd.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eC(int i) {
            if (this.bOd.mMessageContent.getVisibility() != 0) {
                this.bOd.mMessageContent.setVisibility(0);
            }
            this.bOd.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a kJ(String str) {
            if (this.bOd.mMessageContent.getVisibility() != 0) {
                this.bOd.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.bOd.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.bOd.mMessageContent.getVisibility() != 0) {
                this.bOd.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.bOd.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.bOd.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a acm() {
            this.bOd.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.bOd.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fR(int i) {
            this.bOd.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.bOd.mPositiveButton.setVisibility(8);
                if (this.bOd.mNegativeButton.getVisibility() == 0) {
                    this.bOd.mDivider3.setVisibility(8);
                }
            } else {
                this.bOd.mPositiveButton.setVisibility(0);
                if (this.bOd.mNegativeButton.getVisibility() == 0) {
                    this.bOd.mDivider3.setVisibility(0);
                }
                this.bOd.mPositiveButton.setText(charSequence);
                this.bOd.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpe.onButtonClick(-1);
                        a.this.bpe.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpe, -1);
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
                        a.this.bpe.onButtonClick(i);
                        a.this.bpe.dismiss();
                        onClickListener.onClick(a.this.bpe, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.bOd.mPositiveButton == null || this.bOd.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.bOd.mPositiveButton;
                i = 1;
            }
            if (this.bOd.mNegativeButton != null && this.bOd.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.bOd.mNegativeButton;
            }
            if (this.bOd.mNeutralButton != null && this.bOd.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.bOd.mNeutralButton;
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
                this.bOd.mNegativeButton.setVisibility(8);
                if (this.bOd.mPositiveButton.getVisibility() == 0) {
                    this.bOd.mDivider3.setVisibility(8);
                }
            } else {
                this.bOd.mNegativeButton.setVisibility(0);
                if (this.bOd.mPositiveButton.getVisibility() == 0) {
                    this.bOd.mDivider3.setVisibility(0);
                }
                this.bOd.mNegativeButton.setText(charSequence);
                this.bOd.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bpe.onButtonClick(-2);
                        a.this.bpe.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bpe, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a dC(boolean z) {
            if (z) {
                this.bOd.mDivider2.setVisibility(0);
            } else {
                this.bOd.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fS(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.bOd.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void fT(int i) {
            this.bOd.mDialogLayout.getLayoutParams().height = i;
            this.bOd.mDialogLayout.requestLayout();
        }

        public void fU(int i) {
            this.bOd.mDialogLayout.getLayoutParams().width = i;
            this.bOd.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOd.mNeutralButton.setVisibility(0);
            if (this.bOd.mPositiveButton.getVisibility() == 0) {
                this.bOd.mDivider4.setVisibility(0);
            }
            this.bOd.mNeutralButton.setText(charSequence);
            this.bOd.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bpe.onButtonClick(-3);
                    a.this.bpe.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bpe, -3);
                    }
                }
            });
            return this;
        }

        public a fV(int i) {
            this.bOd.mIcon.setImageResource(i);
            return this;
        }

        public a an(View view) {
            this.bOd.mDialogContent.removeAllViews();
            this.bOd.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.bOd.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a acn() {
            this.bOd.bOh.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aco() {
            ((ViewGroup.MarginLayoutParams) this.bOd.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a dD(boolean z) {
            this.bOd.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.bOd.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.bOd.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.bOd.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.bOd.bOg = cVar;
            return this;
        }

        public a dE(boolean z) {
            this.bOd.bOj.setVisibility(z ? 0 : 8);
            return this;
        }

        public g Pc() {
            this.bpe.setCancelable(this.bOd.mCancelable.booleanValue());
            if (this.bOd.mCancelable.booleanValue()) {
                this.bpe.setCanceledOnTouchOutside(false);
            }
            this.bpe.setOnCancelListener(this.bOd.mOnCancelListener);
            this.bpe.setOnDismissListener(this.bOd.mOnDismissListener);
            this.bpe.setOnShowListener(this.bOd.mOnShowListener);
            if (this.bOd.mOnKeyListener != null) {
                this.bpe.setOnKeyListener(this.bOd.mOnKeyListener);
            }
            updateDialogUI();
            if (this.bOd.bOg != null) {
                this.bOd.bOg.a(this.bpe, this.bOd);
            }
            this.bpe.a(this);
            return this.bpe;
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
            this.bOd.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.bOd.bOk != -1 ? this.bOd.bOk : a.e.aiapps_dialog_bg_white));
            this.bOd.mTitle.setTextColor(color);
            this.bOd.mMessage.setTextColor(color4);
            this.bOd.mPositiveButton.setTextColor(this.bOd.mPositiveBtnTextColor != color3 ? this.bOd.mPositiveBtnTextColor : color3);
            if (this.bOd.mNegativeBtnTextColor != color2) {
                this.bOd.mNegativeButton.setTextColor(this.bOd.mNegativeBtnTextColor);
            } else if (this.bOd.bOf != -1) {
                this.bOd.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.bOd.bOf));
            } else {
                this.bOd.mNegativeButton.setTextColor(color2);
            }
            this.bOd.mNeutralButton.setTextColor(color2);
            int color6 = this.bOd.bOl != -1 ? getAlertDialogResources().getColor(this.bOd.bOl) : color5;
            this.bOd.mDivider2.setBackgroundColor(color6);
            this.bOd.mDivider3.setBackgroundColor(color6);
            this.bOd.mDivider4.setBackgroundColor(color6);
            this.bOd.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.bOd.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.bOd.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.bOd.bOm ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a dG(boolean z) {
            this.bOd.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a dH(boolean z) {
            this.bOd.bOm = z;
            return this;
        }

        public a dI(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.bOd.mCustomPanel.getLayoutParams();
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
            this.bOd.mPositiveBtnTextColor = i;
            this.bOd.mPositiveButton.setTextColor(i);
            return this;
        }

        public a fY(int i) {
            return ga(this.mContext.getResources().getColor(i));
        }

        public a fZ(int i) {
            this.bOd.bOf = i;
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
            this.bOd.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.bOd.mDialogContent;
        }

        public a o(int i, int i2, int i3, int i4) {
            this.bOd.bOi.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gb(int i) {
            this.bOd.bOk = i;
            this.bOd.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gc(int i) {
            this.bOd.bOl = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView bKK;
        public c bOg;
        public FrameLayout bOh;
        public FrameLayout bOi;
        public View bOj;
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
        public int bOf = -1;
        public int bOk = -1;
        public int bOl = -1;
        public boolean bOm = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.bOi = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.bKK = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOh = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOj = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.bKK.setMaxHeight(i);
        }
    }
}
