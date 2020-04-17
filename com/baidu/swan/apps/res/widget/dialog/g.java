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
    private a cmY;

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

    public a aks() {
        return this.cmY;
    }

    void a(a aVar) {
        this.cmY = aVar;
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
        protected final g bNx;
        protected final b cmZ;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bNx = bK(context);
            this.bNx.a(this);
            this.cmZ = new b((ViewGroup) this.bNx.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a akt() {
            if (af.isScreenLand()) {
                gb(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                fY(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bK(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a eI(int i) {
            this.cmZ.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cmZ.mTitle.setText(charSequence);
            } else {
                ey(true);
            }
            return this;
        }

        public a ey(boolean z) {
            this.cmZ.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eH(int i) {
            if (this.cmZ.mMessageContent.getVisibility() != 0) {
                this.cmZ.mMessageContent.setVisibility(0);
            }
            this.cmZ.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a lV(String str) {
            if (this.cmZ.mMessageContent.getVisibility() != 0) {
                this.cmZ.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cmZ.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cmZ.mMessageContent.getVisibility() != 0) {
                this.cmZ.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cmZ.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cmZ.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aku() {
            this.cmZ.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cmZ.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fY(int i) {
            this.cmZ.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cmZ.mPositiveButton.setVisibility(8);
                if (this.cmZ.mNegativeButton.getVisibility() == 0) {
                    this.cmZ.mDivider3.setVisibility(8);
                }
            } else {
                this.cmZ.mPositiveButton.setVisibility(0);
                if (this.cmZ.mNegativeButton.getVisibility() == 0) {
                    this.cmZ.mDivider3.setVisibility(0);
                }
                this.cmZ.mPositiveButton.setText(charSequence);
                this.cmZ.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bNx.onButtonClick(-1);
                        a.this.bNx.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bNx, -1);
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
                        a.this.bNx.onButtonClick(i);
                        a.this.bNx.dismiss();
                        onClickListener.onClick(a.this.bNx, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cmZ.mPositiveButton == null || this.cmZ.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cmZ.mPositiveButton;
                i = 1;
            }
            if (this.cmZ.mNegativeButton != null && this.cmZ.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cmZ.mNegativeButton;
            }
            if (this.cmZ.mNeutralButton != null && this.cmZ.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cmZ.mNeutralButton;
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
                this.cmZ.mNegativeButton.setVisibility(8);
                if (this.cmZ.mPositiveButton.getVisibility() == 0) {
                    this.cmZ.mDivider3.setVisibility(8);
                }
            } else {
                this.cmZ.mNegativeButton.setVisibility(0);
                if (this.cmZ.mPositiveButton.getVisibility() == 0) {
                    this.cmZ.mDivider3.setVisibility(0);
                }
                this.cmZ.mNegativeButton.setText(charSequence);
                this.cmZ.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bNx.onButtonClick(-2);
                        a.this.bNx.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bNx, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a ez(boolean z) {
            if (z) {
                this.cmZ.mDivider2.setVisibility(0);
            } else {
                this.cmZ.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fZ(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cmZ.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void ga(int i) {
            this.cmZ.mDialogLayout.getLayoutParams().height = i;
            this.cmZ.mDialogLayout.requestLayout();
        }

        public void gb(int i) {
            this.cmZ.mDialogLayout.getLayoutParams().width = i;
            this.cmZ.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cmZ.mNeutralButton.setVisibility(0);
            if (this.cmZ.mPositiveButton.getVisibility() == 0) {
                this.cmZ.mDivider4.setVisibility(0);
            }
            this.cmZ.mNeutralButton.setText(charSequence);
            this.cmZ.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bNx.onButtonClick(-3);
                    a.this.bNx.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bNx, -3);
                    }
                }
            });
            return this;
        }

        public a gc(int i) {
            this.cmZ.mIcon.setImageResource(i);
            return this;
        }

        public a ao(View view) {
            this.cmZ.mDialogContent.removeAllViews();
            this.cmZ.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cmZ.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a akv() {
            this.cmZ.cnd.setPadding(0, 0, 0, 0);
            return this;
        }

        public a akw() {
            ((ViewGroup.MarginLayoutParams) this.cmZ.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a eA(boolean z) {
            this.cmZ.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cmZ.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cmZ.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cmZ.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cmZ.cnc = cVar;
            return this;
        }

        public a eB(boolean z) {
            this.cmZ.cnf.setVisibility(z ? 0 : 8);
            return this;
        }

        public g WU() {
            this.bNx.setCancelable(this.cmZ.mCancelable.booleanValue());
            if (this.cmZ.mCancelable.booleanValue()) {
                this.bNx.setCanceledOnTouchOutside(false);
            }
            this.bNx.setOnCancelListener(this.cmZ.mOnCancelListener);
            this.bNx.setOnDismissListener(this.cmZ.mOnDismissListener);
            this.bNx.setOnShowListener(this.cmZ.mOnShowListener);
            if (this.cmZ.mOnKeyListener != null) {
                this.bNx.setOnKeyListener(this.cmZ.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cmZ.cnc != null) {
                this.cmZ.cnc.a(this.bNx, this.cmZ);
            }
            this.bNx.a(this);
            return this.bNx;
        }

        @Deprecated
        public g eC(boolean z) {
            return akx();
        }

        public g akx() {
            g WU = WU();
            if (this.mSystemDialog) {
                WU.getWindow().setType(2003);
            }
            try {
                WU.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return WU;
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
            this.cmZ.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cmZ.cng != -1 ? this.cmZ.cng : a.e.aiapps_dialog_bg_white));
            this.cmZ.mTitle.setTextColor(color);
            this.cmZ.mMessage.setTextColor(color4);
            this.cmZ.mPositiveButton.setTextColor(this.cmZ.mPositiveBtnTextColor != color3 ? this.cmZ.mPositiveBtnTextColor : color3);
            if (this.cmZ.mNegativeBtnTextColor != color2) {
                this.cmZ.mNegativeButton.setTextColor(this.cmZ.mNegativeBtnTextColor);
            } else if (this.cmZ.cnb != -1) {
                this.cmZ.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cmZ.cnb));
            } else {
                this.cmZ.mNegativeButton.setTextColor(color2);
            }
            this.cmZ.mNeutralButton.setTextColor(color2);
            int color6 = this.cmZ.cnh != -1 ? getAlertDialogResources().getColor(this.cmZ.cnh) : color5;
            this.cmZ.mDivider2.setBackgroundColor(color6);
            this.cmZ.mDivider3.setBackgroundColor(color6);
            this.cmZ.mDivider4.setBackgroundColor(color6);
            this.cmZ.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cmZ.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cmZ.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cmZ.cni ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a eD(boolean z) {
            this.cmZ.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a eE(boolean z) {
            this.cmZ.cni = z;
            return this;
        }

        public a eF(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cmZ.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a gd(int i) {
            return ge(getAlertDialogResources().getColor(i));
        }

        public a L(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ge(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gd(i);
            }
            return this;
        }

        public a ge(int i) {
            this.cmZ.mPositiveBtnTextColor = i;
            this.cmZ.mPositiveButton.setTextColor(i);
            return this;
        }

        public a gf(int i) {
            return gh(this.mContext.getResources().getColor(i));
        }

        public a gg(int i) {
            this.cmZ.cnb = i;
            return this;
        }

        public a M(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gh(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gf(i);
            }
            return this;
        }

        public a gh(int i) {
            this.cmZ.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cmZ.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cmZ.cne.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gi(int i) {
            this.cmZ.cng = i;
            this.cmZ.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gj(int i) {
            this.cmZ.cnh = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView cjF;
        public c cnc;
        public FrameLayout cnd;
        public FrameLayout cne;
        public View cnf;
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
        public int cnb = -1;
        public int cng = -1;
        public int cnh = -1;
        public boolean cni = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cne = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cjF = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cnd = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cnf = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cjF.setMaxHeight(i);
        }
    }
}
