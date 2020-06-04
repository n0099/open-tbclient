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
    private a cyK;

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

    public a aoi() {
        return this.cyK;
    }

    void a(a aVar) {
        this.cyK = aVar;
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
        protected final g bWI;
        protected final b cyL;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bWI = bH(context);
            this.bWI.a(this);
            this.cyL = new b((ViewGroup) this.bWI.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aoj() {
            if (ag.isScreenLand()) {
                gv(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                gs(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bH(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a eT(int i) {
            this.cyL.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cyL.mTitle.setText(charSequence);
            } else {
                eR(true);
            }
            return this;
        }

        public a eR(boolean z) {
            this.cyL.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a eS(int i) {
            if (this.cyL.mMessageContent.getVisibility() != 0) {
                this.cyL.mMessageContent.setVisibility(0);
            }
            this.cyL.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a nq(String str) {
            if (this.cyL.mMessageContent.getVisibility() != 0) {
                this.cyL.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cyL.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cyL.mMessageContent.getVisibility() != 0) {
                this.cyL.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cyL.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cyL.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aok() {
            this.cyL.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cyL.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a gs(int i) {
            this.cyL.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cyL.mPositiveButton.setVisibility(8);
                if (this.cyL.mNegativeButton.getVisibility() == 0) {
                    this.cyL.mDivider3.setVisibility(8);
                }
            } else {
                this.cyL.mPositiveButton.setVisibility(0);
                if (this.cyL.mNegativeButton.getVisibility() == 0) {
                    this.cyL.mDivider3.setVisibility(0);
                }
                this.cyL.mPositiveButton.setText(charSequence);
                this.cyL.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bWI.onButtonClick(-1);
                        a.this.bWI.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bWI, -1);
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
                        a.this.bWI.onButtonClick(i);
                        a.this.bWI.dismiss();
                        onClickListener.onClick(a.this.bWI, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cyL.mPositiveButton == null || this.cyL.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cyL.mPositiveButton;
                i = 1;
            }
            if (this.cyL.mNegativeButton != null && this.cyL.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cyL.mNegativeButton;
            }
            if (this.cyL.mNeutralButton != null && this.cyL.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cyL.mNeutralButton;
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
                this.cyL.mNegativeButton.setVisibility(8);
                if (this.cyL.mPositiveButton.getVisibility() == 0) {
                    this.cyL.mDivider3.setVisibility(8);
                }
            } else {
                this.cyL.mNegativeButton.setVisibility(0);
                if (this.cyL.mPositiveButton.getVisibility() == 0) {
                    this.cyL.mDivider3.setVisibility(0);
                }
                this.cyL.mNegativeButton.setText(charSequence);
                this.cyL.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bWI.onButtonClick(-2);
                        a.this.bWI.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.bWI, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a eS(boolean z) {
            if (z) {
                this.cyL.mDivider2.setVisibility(0);
            } else {
                this.cyL.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a gt(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cyL.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void gu(int i) {
            this.cyL.mDialogLayout.getLayoutParams().height = i;
            this.cyL.mDialogLayout.requestLayout();
        }

        public void gv(int i) {
            this.cyL.mDialogLayout.getLayoutParams().width = i;
            this.cyL.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cyL.mNeutralButton.setVisibility(0);
            if (this.cyL.mPositiveButton.getVisibility() == 0) {
                this.cyL.mDivider4.setVisibility(0);
            }
            this.cyL.mNeutralButton.setText(charSequence);
            this.cyL.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bWI.onButtonClick(-3);
                    a.this.bWI.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bWI, -3);
                    }
                }
            });
            return this;
        }

        public a gw(int i) {
            this.cyL.mIcon.setImageResource(i);
            return this;
        }

        public a ao(View view) {
            this.cyL.mDialogContent.removeAllViews();
            this.cyL.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cyL.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aol() {
            this.cyL.cyP.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aom() {
            ((ViewGroup.MarginLayoutParams) this.cyL.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a eT(boolean z) {
            this.cyL.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cyL.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cyL.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cyL.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cyL.cyO = cVar;
            return this;
        }

        public a eU(boolean z) {
            this.cyL.cyR.setVisibility(z ? 0 : 8);
            return this;
        }

        public g ZF() {
            this.bWI.setCancelable(this.cyL.mCancelable.booleanValue());
            if (this.cyL.mCancelable.booleanValue()) {
                this.bWI.setCanceledOnTouchOutside(false);
            }
            this.bWI.setOnCancelListener(this.cyL.mOnCancelListener);
            this.bWI.setOnDismissListener(this.cyL.mOnDismissListener);
            this.bWI.setOnShowListener(this.cyL.mOnShowListener);
            if (this.cyL.mOnKeyListener != null) {
                this.bWI.setOnKeyListener(this.cyL.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cyL.cyO != null) {
                this.cyL.cyO.a(this.bWI, this.cyL);
            }
            this.bWI.a(this);
            return this.bWI;
        }

        @Deprecated
        public g eV(boolean z) {
            return aon();
        }

        public g aon() {
            g ZF = ZF();
            if (this.mSystemDialog) {
                ZF.getWindow().setType(2003);
            }
            try {
                ZF.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return ZF;
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
            this.cyL.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cyL.cyS != -1 ? this.cyL.cyS : a.e.aiapps_dialog_bg_white));
            this.cyL.mTitle.setTextColor(color);
            this.cyL.mMessage.setTextColor(color4);
            this.cyL.mPositiveButton.setTextColor(this.cyL.mPositiveBtnTextColor != color3 ? this.cyL.mPositiveBtnTextColor : color3);
            if (this.cyL.mNegativeBtnTextColor != color2) {
                this.cyL.mNegativeButton.setTextColor(this.cyL.mNegativeBtnTextColor);
            } else if (this.cyL.cyN != -1) {
                this.cyL.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cyL.cyN));
            } else {
                this.cyL.mNegativeButton.setTextColor(color2);
            }
            this.cyL.mNeutralButton.setTextColor(color2);
            int color6 = this.cyL.cyT != -1 ? getAlertDialogResources().getColor(this.cyL.cyT) : color5;
            this.cyL.mDivider2.setBackgroundColor(color6);
            this.cyL.mDivider3.setBackgroundColor(color6);
            this.cyL.mDivider4.setBackgroundColor(color6);
            this.cyL.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cyL.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cyL.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cyL.cyU ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a eW(boolean z) {
            this.cyL.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a eX(boolean z) {
            this.cyL.cyU = z;
            return this;
        }

        public a eY(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cyL.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a gx(int i) {
            return gy(getAlertDialogResources().getColor(i));
        }

        public a P(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gy(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gx(i);
            }
            return this;
        }

        public a gy(int i) {
            this.cyL.mPositiveBtnTextColor = i;
            this.cyL.mPositiveButton.setTextColor(i);
            return this;
        }

        public a gz(int i) {
            return gB(this.mContext.getResources().getColor(i));
        }

        public a gA(int i) {
            this.cyL.cyN = i;
            return this;
        }

        public a Q(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gB(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gz(i);
            }
            return this;
        }

        public a gB(int i) {
            this.cyL.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cyL.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cyL.cyQ.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gC(int i) {
            this.cyL.cyS = i;
            this.cyL.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gD(int i) {
            this.cyL.cyT = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public SwanAppScrollView cvp;
        public c cyO;
        public FrameLayout cyP;
        public FrameLayout cyQ;
        public View cyR;
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
        public int cyN = -1;
        public int cyS = -1;
        public int cyT = -1;
        public boolean cyU = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cyQ = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cvp = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cyP = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cyR = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.aq.b.isGingerbread() || com.baidu.swan.apps.aq.b.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cvp.setMaxHeight(i);
        }
    }
}
