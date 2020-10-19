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
    private a ddp;

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

    public a aCC() {
        return this.ddp;
    }

    void a(a aVar) {
        this.ddp = aVar;
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
        protected final g cxv;
        protected final b ddq;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cxv = bX(context);
            this.cxv.a(this);
            this.ddq = new b((ViewGroup) this.cxv.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aCD() {
            if (ah.isScreenLand()) {
                jE(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                jB(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bX(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a hK(int i) {
            this.ddq.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.ddq.mTitle.setText(charSequence);
            } else {
                fT(true);
            }
            return this;
        }

        public a fT(boolean z) {
            this.ddq.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a hJ(int i) {
            if (this.ddq.mMessageContent.getVisibility() != 0) {
                this.ddq.mMessageContent.setVisibility(0);
            }
            this.ddq.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a rk(String str) {
            if (this.ddq.mMessageContent.getVisibility() != 0) {
                this.ddq.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.ddq.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.ddq.mMessageContent.getVisibility() != 0) {
                this.ddq.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.ddq.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.ddq.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aCE() {
            this.ddq.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.ddq.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a jB(int i) {
            this.ddq.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.ddq.mPositiveButton.setVisibility(8);
                if (this.ddq.mNegativeButton.getVisibility() == 0) {
                    this.ddq.mDivider3.setVisibility(8);
                }
            } else {
                this.ddq.mPositiveButton.setVisibility(0);
                if (this.ddq.mNegativeButton.getVisibility() == 0) {
                    this.ddq.mDivider3.setVisibility(0);
                }
                this.ddq.mPositiveButton.setText(charSequence);
                this.ddq.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cxv.onButtonClick(-1);
                        a.this.cxv.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cxv, -1);
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
                        a.this.cxv.onButtonClick(i);
                        a.this.cxv.dismiss();
                        onClickListener.onClick(a.this.cxv, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.ddq.mPositiveButton == null || this.ddq.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.ddq.mPositiveButton;
                i = 1;
            }
            if (this.ddq.mNegativeButton != null && this.ddq.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.ddq.mNegativeButton;
            }
            if (this.ddq.mNeutralButton != null && this.ddq.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.ddq.mNeutralButton;
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
                this.ddq.mNegativeButton.setVisibility(8);
                if (this.ddq.mPositiveButton.getVisibility() == 0) {
                    this.ddq.mDivider3.setVisibility(8);
                }
            } else {
                this.ddq.mNegativeButton.setVisibility(0);
                if (this.ddq.mPositiveButton.getVisibility() == 0) {
                    this.ddq.mDivider3.setVisibility(0);
                }
                this.ddq.mNegativeButton.setText(charSequence);
                this.ddq.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cxv.onButtonClick(-2);
                        a.this.cxv.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cxv, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a fU(boolean z) {
            if (z) {
                this.ddq.mDivider2.setVisibility(0);
            } else {
                this.ddq.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a jC(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.ddq.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void jD(int i) {
            this.ddq.mDialogLayout.getLayoutParams().height = i;
            this.ddq.mDialogLayout.requestLayout();
        }

        public void jE(int i) {
            this.ddq.mDialogLayout.getLayoutParams().width = i;
            this.ddq.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.ddq.mNeutralButton.setVisibility(0);
            if (this.ddq.mPositiveButton.getVisibility() == 0) {
                this.ddq.mDivider4.setVisibility(0);
            }
            this.ddq.mNeutralButton.setText(charSequence);
            this.ddq.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cxv.onButtonClick(-3);
                    a.this.cxv.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cxv, -3);
                    }
                }
            });
            return this;
        }

        public a jF(int i) {
            this.ddq.mIcon.setImageResource(i);
            return this;
        }

        public a av(View view) {
            this.ddq.mDialogContent.removeAllViews();
            this.ddq.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.ddq.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aCF() {
            this.ddq.ddv.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aCG() {
            ((ViewGroup.MarginLayoutParams) this.ddq.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a fV(boolean z) {
            this.ddq.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.ddq.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.ddq.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.ddq.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.ddq.ddt = cVar;
            return this;
        }

        public a fW(boolean z) {
            this.ddq.ddx.setVisibility(z ? 0 : 8);
            return this;
        }

        public g alu() {
            this.cxv.setCancelable(this.ddq.mCancelable.booleanValue());
            if (this.ddq.mCancelable.booleanValue()) {
                this.cxv.setCanceledOnTouchOutside(false);
            }
            this.cxv.setOnCancelListener(this.ddq.mOnCancelListener);
            this.cxv.setOnDismissListener(this.ddq.mOnDismissListener);
            this.cxv.setOnShowListener(this.ddq.mOnShowListener);
            if (this.ddq.mOnKeyListener != null) {
                this.cxv.setOnKeyListener(this.ddq.mOnKeyListener);
            }
            updateDialogUI();
            if (this.ddq.ddt != null) {
                this.ddq.ddt.a(this.cxv, this.ddq);
            }
            this.cxv.a(this);
            return this.cxv;
        }

        @Deprecated
        public g fX(boolean z) {
            return aCH();
        }

        public g aCH() {
            g alu = alu();
            if (this.mSystemDialog) {
                alu.getWindow().setType(2003);
            }
            try {
                alu.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return alu;
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
            this.ddq.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.ddq.ddy != -1 ? this.ddq.ddy : a.e.aiapps_dialog_bg_white));
            this.ddq.mTitle.setTextColor(color);
            this.ddq.mMessage.setTextColor(color4);
            this.ddq.mPositiveButton.setTextColor(this.ddq.mPositiveBtnTextColor != color3 ? this.ddq.mPositiveBtnTextColor : color3);
            if (this.ddq.mNegativeBtnTextColor != color2) {
                this.ddq.mNegativeButton.setTextColor(this.ddq.mNegativeBtnTextColor);
            } else if (this.ddq.dds != -1) {
                this.ddq.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.ddq.dds));
            } else {
                this.ddq.mNegativeButton.setTextColor(color2);
            }
            this.ddq.mNeutralButton.setTextColor(color2);
            int color6 = this.ddq.ddz != -1 ? getAlertDialogResources().getColor(this.ddq.ddz) : color5;
            this.ddq.mDivider2.setBackgroundColor(color6);
            this.ddq.mDivider3.setBackgroundColor(color6);
            this.ddq.mDivider4.setBackgroundColor(color6);
            this.ddq.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.ddq.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.ddq.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.ddq.ddA ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fY(boolean z) {
            this.ddq.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fZ(boolean z) {
            this.ddq.ddA = z;
            return this;
        }

        public a ga(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.ddq.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a jG(int i) {
            return jH(getAlertDialogResources().getColor(i));
        }

        public a S(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jH(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jG(i);
            }
            return this;
        }

        public a jH(int i) {
            this.ddq.mPositiveBtnTextColor = i;
            this.ddq.mPositiveButton.setTextColor(i);
            return this;
        }

        public a jI(int i) {
            return jK(this.mContext.getResources().getColor(i));
        }

        public a jJ(int i) {
            this.ddq.dds = i;
            return this;
        }

        public a T(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jK(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jI(i);
            }
            return this;
        }

        public a jK(int i) {
            this.ddq.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.ddq.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.ddq.ddw.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jL(int i) {
            this.ddq.ddy = i;
            this.ddq.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a jM(int i) {
            this.ddq.ddz = i;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public SwanAppScrollView cZg;
        public c ddt;
        public FrameLayout ddv;
        public FrameLayout ddw;
        public View ddx;
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
        public int dds = -1;
        public int ddy = -1;
        public int ddz = -1;
        public boolean ddA = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.ddw = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cZg = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.ddv = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.ddx = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cZg.setMaxHeight(i);
        }
    }
}
