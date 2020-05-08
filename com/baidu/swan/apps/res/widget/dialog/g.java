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
    private a cne;

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

    public a akr() {
        return this.cne;
    }

    void a(a aVar) {
        this.cne = aVar;
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
        protected final g bNC;
        protected final b cnf;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bNC = by(context);
            this.bNC.a(this);
            this.cnf = new b((ViewGroup) this.bNC.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aks() {
            if (af.isScreenLand()) {
                gb(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                fY(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g by(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a eI(int i) {
            this.cnf.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cnf.mTitle.setText(charSequence);
            } else {
                ey(true);
            }
            return this;
        }

        public a ey(boolean z) {
            this.cnf.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eH(int i) {
            if (this.cnf.mMessageContent.getVisibility() != 0) {
                this.cnf.mMessageContent.setVisibility(0);
            }
            this.cnf.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a lV(String str) {
            if (this.cnf.mMessageContent.getVisibility() != 0) {
                this.cnf.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cnf.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cnf.mMessageContent.getVisibility() != 0) {
                this.cnf.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cnf.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cnf.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a akt() {
            this.cnf.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cnf.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a fY(int i) {
            this.cnf.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cnf.mPositiveButton.setVisibility(8);
                if (this.cnf.mNegativeButton.getVisibility() == 0) {
                    this.cnf.mDivider3.setVisibility(8);
                }
            } else {
                this.cnf.mPositiveButton.setVisibility(0);
                if (this.cnf.mNegativeButton.getVisibility() == 0) {
                    this.cnf.mDivider3.setVisibility(0);
                }
                this.cnf.mPositiveButton.setText(charSequence);
                this.cnf.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bNC.onButtonClick(-1);
                        a.this.bNC.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bNC, -1);
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
                        a.this.bNC.onButtonClick(i);
                        a.this.bNC.dismiss();
                        onClickListener.onClick(a.this.bNC, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cnf.mPositiveButton == null || this.cnf.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cnf.mPositiveButton;
                i = 1;
            }
            if (this.cnf.mNegativeButton != null && this.cnf.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cnf.mNegativeButton;
            }
            if (this.cnf.mNeutralButton != null && this.cnf.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cnf.mNeutralButton;
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
                this.cnf.mNegativeButton.setVisibility(8);
                if (this.cnf.mPositiveButton.getVisibility() == 0) {
                    this.cnf.mDivider3.setVisibility(8);
                }
            } else {
                this.cnf.mNegativeButton.setVisibility(0);
                if (this.cnf.mPositiveButton.getVisibility() == 0) {
                    this.cnf.mDivider3.setVisibility(0);
                }
                this.cnf.mNegativeButton.setText(charSequence);
                this.cnf.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bNC.onButtonClick(-2);
                        a.this.bNC.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bNC, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a ez(boolean z) {
            if (z) {
                this.cnf.mDivider2.setVisibility(0);
            } else {
                this.cnf.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a fZ(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cnf.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void ga(int i) {
            this.cnf.mDialogLayout.getLayoutParams().height = i;
            this.cnf.mDialogLayout.requestLayout();
        }

        public void gb(int i) {
            this.cnf.mDialogLayout.getLayoutParams().width = i;
            this.cnf.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cnf.mNeutralButton.setVisibility(0);
            if (this.cnf.mPositiveButton.getVisibility() == 0) {
                this.cnf.mDivider4.setVisibility(0);
            }
            this.cnf.mNeutralButton.setText(charSequence);
            this.cnf.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bNC.onButtonClick(-3);
                    a.this.bNC.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bNC, -3);
                    }
                }
            });
            return this;
        }

        public a gc(int i) {
            this.cnf.mIcon.setImageResource(i);
            return this;
        }

        public a ao(View view) {
            this.cnf.mDialogContent.removeAllViews();
            this.cnf.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cnf.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aku() {
            this.cnf.cnj.setPadding(0, 0, 0, 0);
            return this;
        }

        public a akv() {
            ((ViewGroup.MarginLayoutParams) this.cnf.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a eA(boolean z) {
            this.cnf.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cnf.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cnf.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cnf.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cnf.cni = cVar;
            return this;
        }

        public a eB(boolean z) {
            this.cnf.cnl.setVisibility(z ? 0 : 8);
            return this;
        }

        public g WT() {
            this.bNC.setCancelable(this.cnf.mCancelable.booleanValue());
            if (this.cnf.mCancelable.booleanValue()) {
                this.bNC.setCanceledOnTouchOutside(false);
            }
            this.bNC.setOnCancelListener(this.cnf.mOnCancelListener);
            this.bNC.setOnDismissListener(this.cnf.mOnDismissListener);
            this.bNC.setOnShowListener(this.cnf.mOnShowListener);
            if (this.cnf.mOnKeyListener != null) {
                this.bNC.setOnKeyListener(this.cnf.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cnf.cni != null) {
                this.cnf.cni.a(this.bNC, this.cnf);
            }
            this.bNC.a(this);
            return this.bNC;
        }

        @Deprecated
        public g eC(boolean z) {
            return akw();
        }

        public g akw() {
            g WT = WT();
            if (this.mSystemDialog) {
                WT.getWindow().setType(2003);
            }
            try {
                WT.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return WT;
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
            this.cnf.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cnf.cnm != -1 ? this.cnf.cnm : a.e.aiapps_dialog_bg_white));
            this.cnf.mTitle.setTextColor(color);
            this.cnf.mMessage.setTextColor(color4);
            this.cnf.mPositiveButton.setTextColor(this.cnf.mPositiveBtnTextColor != color3 ? this.cnf.mPositiveBtnTextColor : color3);
            if (this.cnf.mNegativeBtnTextColor != color2) {
                this.cnf.mNegativeButton.setTextColor(this.cnf.mNegativeBtnTextColor);
            } else if (this.cnf.cnh != -1) {
                this.cnf.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cnf.cnh));
            } else {
                this.cnf.mNegativeButton.setTextColor(color2);
            }
            this.cnf.mNeutralButton.setTextColor(color2);
            int color6 = this.cnf.cnn != -1 ? getAlertDialogResources().getColor(this.cnf.cnn) : color5;
            this.cnf.mDivider2.setBackgroundColor(color6);
            this.cnf.mDivider3.setBackgroundColor(color6);
            this.cnf.mDivider4.setBackgroundColor(color6);
            this.cnf.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cnf.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cnf.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cnf.cno ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a eD(boolean z) {
            this.cnf.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a eE(boolean z) {
            this.cnf.cno = z;
            return this;
        }

        public a eF(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cnf.mCustomPanel.getLayoutParams();
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
            this.cnf.mPositiveBtnTextColor = i;
            this.cnf.mPositiveButton.setTextColor(i);
            return this;
        }

        public a gf(int i) {
            return gh(this.mContext.getResources().getColor(i));
        }

        public a gg(int i) {
            this.cnf.cnh = i;
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
            this.cnf.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cnf.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cnf.cnk.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gi(int i) {
            this.cnf.cnm = i;
            this.cnf.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gj(int i) {
            this.cnf.cnn = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView cjL;
        public c cni;
        public FrameLayout cnj;
        public FrameLayout cnk;
        public View cnl;
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
        public int cnh = -1;
        public int cnm = -1;
        public int cnn = -1;
        public boolean cno = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cnk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cjL = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cnj = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cnl = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.as.a.isGingerbread() || com.baidu.swan.apps.as.a.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cjL.setMaxHeight(i);
        }
    }
}
