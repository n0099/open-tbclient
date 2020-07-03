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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cDu;

    /* loaded from: classes11.dex */
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

    public a app() {
        return this.cDu;
    }

    void a(a aVar) {
        this.cDu = aVar;
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
        protected final b cDv;
        protected final g cbw;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cbw = bI(context);
            this.cbw.a(this);
            this.cDv = new b((ViewGroup) this.cbw.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a apq() {
            if (ag.isScreenLand()) {
                gG(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                gD(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bI(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a fe(int i) {
            this.cDv.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cDv.mTitle.setText(charSequence);
            } else {
                eW(true);
            }
            return this;
        }

        public a eW(boolean z) {
            this.cDv.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a fd(int i) {
            if (this.cDv.mMessageContent.getVisibility() != 0) {
                this.cDv.mMessageContent.setVisibility(0);
            }
            this.cDv.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a ny(String str) {
            if (this.cDv.mMessageContent.getVisibility() != 0) {
                this.cDv.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cDv.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cDv.mMessageContent.getVisibility() != 0) {
                this.cDv.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cDv.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cDv.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a apr() {
            this.cDv.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cDv.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a gD(int i) {
            this.cDv.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cDv.mPositiveButton.setVisibility(8);
                if (this.cDv.mNegativeButton.getVisibility() == 0) {
                    this.cDv.mDivider3.setVisibility(8);
                }
            } else {
                this.cDv.mPositiveButton.setVisibility(0);
                if (this.cDv.mNegativeButton.getVisibility() == 0) {
                    this.cDv.mDivider3.setVisibility(0);
                }
                this.cDv.mPositiveButton.setText(charSequence);
                this.cDv.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cbw.onButtonClick(-1);
                        a.this.cbw.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cbw, -1);
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
                        a.this.cbw.onButtonClick(i);
                        a.this.cbw.dismiss();
                        onClickListener.onClick(a.this.cbw, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cDv.mPositiveButton == null || this.cDv.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cDv.mPositiveButton;
                i = 1;
            }
            if (this.cDv.mNegativeButton != null && this.cDv.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cDv.mNegativeButton;
            }
            if (this.cDv.mNeutralButton != null && this.cDv.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cDv.mNeutralButton;
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
                this.cDv.mNegativeButton.setVisibility(8);
                if (this.cDv.mPositiveButton.getVisibility() == 0) {
                    this.cDv.mDivider3.setVisibility(8);
                }
            } else {
                this.cDv.mNegativeButton.setVisibility(0);
                if (this.cDv.mPositiveButton.getVisibility() == 0) {
                    this.cDv.mDivider3.setVisibility(0);
                }
                this.cDv.mNegativeButton.setText(charSequence);
                this.cDv.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cbw.onButtonClick(-2);
                        a.this.cbw.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cbw, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a eX(boolean z) {
            if (z) {
                this.cDv.mDivider2.setVisibility(0);
            } else {
                this.cDv.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a gE(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cDv.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void gF(int i) {
            this.cDv.mDialogLayout.getLayoutParams().height = i;
            this.cDv.mDialogLayout.requestLayout();
        }

        public void gG(int i) {
            this.cDv.mDialogLayout.getLayoutParams().width = i;
            this.cDv.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cDv.mNeutralButton.setVisibility(0);
            if (this.cDv.mPositiveButton.getVisibility() == 0) {
                this.cDv.mDivider4.setVisibility(0);
            }
            this.cDv.mNeutralButton.setText(charSequence);
            this.cDv.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cbw.onButtonClick(-3);
                    a.this.cbw.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cbw, -3);
                    }
                }
            });
            return this;
        }

        public a gH(int i) {
            this.cDv.mIcon.setImageResource(i);
            return this;
        }

        public a ao(View view) {
            this.cDv.mDialogContent.removeAllViews();
            this.cDv.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cDv.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aps() {
            this.cDv.cDz.setPadding(0, 0, 0, 0);
            return this;
        }

        public a apt() {
            ((ViewGroup.MarginLayoutParams) this.cDv.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a eY(boolean z) {
            this.cDv.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cDv.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cDv.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cDv.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cDv.cDy = cVar;
            return this;
        }

        public a eZ(boolean z) {
            this.cDv.cDB.setVisibility(z ? 0 : 8);
            return this;
        }

        public g aaL() {
            this.cbw.setCancelable(this.cDv.mCancelable.booleanValue());
            if (this.cDv.mCancelable.booleanValue()) {
                this.cbw.setCanceledOnTouchOutside(false);
            }
            this.cbw.setOnCancelListener(this.cDv.mOnCancelListener);
            this.cbw.setOnDismissListener(this.cDv.mOnDismissListener);
            this.cbw.setOnShowListener(this.cDv.mOnShowListener);
            if (this.cDv.mOnKeyListener != null) {
                this.cbw.setOnKeyListener(this.cDv.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cDv.cDy != null) {
                this.cDv.cDy.a(this.cbw, this.cDv);
            }
            this.cbw.a(this);
            return this.cbw;
        }

        @Deprecated
        public g fa(boolean z) {
            return apu();
        }

        public g apu() {
            g aaL = aaL();
            if (this.mSystemDialog) {
                aaL.getWindow().setType(2003);
            }
            try {
                aaL.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return aaL;
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
            this.cDv.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cDv.cDC != -1 ? this.cDv.cDC : a.e.aiapps_dialog_bg_white));
            this.cDv.mTitle.setTextColor(color);
            this.cDv.mMessage.setTextColor(color4);
            this.cDv.mPositiveButton.setTextColor(this.cDv.mPositiveBtnTextColor != color3 ? this.cDv.mPositiveBtnTextColor : color3);
            if (this.cDv.mNegativeBtnTextColor != color2) {
                this.cDv.mNegativeButton.setTextColor(this.cDv.mNegativeBtnTextColor);
            } else if (this.cDv.cDx != -1) {
                this.cDv.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cDv.cDx));
            } else {
                this.cDv.mNegativeButton.setTextColor(color2);
            }
            this.cDv.mNeutralButton.setTextColor(color2);
            int color6 = this.cDv.cDD != -1 ? getAlertDialogResources().getColor(this.cDv.cDD) : color5;
            this.cDv.mDivider2.setBackgroundColor(color6);
            this.cDv.mDivider3.setBackgroundColor(color6);
            this.cDv.mDivider4.setBackgroundColor(color6);
            this.cDv.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cDv.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cDv.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cDv.cDE ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fb(boolean z) {
            this.cDv.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fc(boolean z) {
            this.cDv.cDE = z;
            return this;
        }

        public a fd(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cDv.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a gI(int i) {
            return gJ(getAlertDialogResources().getColor(i));
        }

        public a P(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gJ(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gI(i);
            }
            return this;
        }

        public a gJ(int i) {
            this.cDv.mPositiveBtnTextColor = i;
            this.cDv.mPositiveButton.setTextColor(i);
            return this;
        }

        public a gK(int i) {
            return gM(this.mContext.getResources().getColor(i));
        }

        public a gL(int i) {
            this.cDv.cDx = i;
            return this;
        }

        public a Q(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gM(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gK(i);
            }
            return this;
        }

        public a gM(int i) {
            this.cDv.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cDv.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cDv.cDA.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gN(int i) {
            this.cDv.cDC = i;
            this.cDv.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gO(int i) {
            this.cDv.cDD = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView cAa;
        public FrameLayout cDA;
        public View cDB;
        public c cDy;
        public FrameLayout cDz;
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
        public int cDx = -1;
        public int cDC = -1;
        public int cDD = -1;
        public boolean cDE = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cDA = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cAa = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cDz = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cDB = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.aq.b.isGingerbread() || com.baidu.swan.apps.aq.b.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cAa.setMaxHeight(i);
        }
    }
}
