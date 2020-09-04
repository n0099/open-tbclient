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
/* loaded from: classes8.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cPj;

    /* loaded from: classes8.dex */
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

    public a azk() {
        return this.cPj;
    }

    void a(a aVar) {
        this.cPj = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b cPk;
        protected final g cjc;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cjc = bS(context);
            this.cjc.a(this);
            this.cPk = new b((ViewGroup) this.cjc.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a azl() {
            if (ah.isScreenLand()) {
                iW(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                iT(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bS(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a he(int i) {
            this.cPk.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cPk.mTitle.setText(charSequence);
            } else {
                fz(true);
            }
            return this;
        }

        public a fz(boolean z) {
            this.cPk.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a hd(int i) {
            if (this.cPk.mMessageContent.getVisibility() != 0) {
                this.cPk.mMessageContent.setVisibility(0);
            }
            this.cPk.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a qf(String str) {
            if (this.cPk.mMessageContent.getVisibility() != 0) {
                this.cPk.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cPk.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cPk.mMessageContent.getVisibility() != 0) {
                this.cPk.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cPk.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cPk.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a azm() {
            this.cPk.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cPk.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a iT(int i) {
            this.cPk.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cPk.mPositiveButton.setVisibility(8);
                if (this.cPk.mNegativeButton.getVisibility() == 0) {
                    this.cPk.mDivider3.setVisibility(8);
                }
            } else {
                this.cPk.mPositiveButton.setVisibility(0);
                if (this.cPk.mNegativeButton.getVisibility() == 0) {
                    this.cPk.mDivider3.setVisibility(0);
                }
                this.cPk.mPositiveButton.setText(charSequence);
                this.cPk.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cjc.onButtonClick(-1);
                        a.this.cjc.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cjc, -1);
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
                        a.this.cjc.onButtonClick(i);
                        a.this.cjc.dismiss();
                        onClickListener.onClick(a.this.cjc, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cPk.mPositiveButton == null || this.cPk.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cPk.mPositiveButton;
                i = 1;
            }
            if (this.cPk.mNegativeButton != null && this.cPk.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cPk.mNegativeButton;
            }
            if (this.cPk.mNeutralButton != null && this.cPk.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cPk.mNeutralButton;
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
                this.cPk.mNegativeButton.setVisibility(8);
                if (this.cPk.mPositiveButton.getVisibility() == 0) {
                    this.cPk.mDivider3.setVisibility(8);
                }
            } else {
                this.cPk.mNegativeButton.setVisibility(0);
                if (this.cPk.mPositiveButton.getVisibility() == 0) {
                    this.cPk.mDivider3.setVisibility(0);
                }
                this.cPk.mNegativeButton.setText(charSequence);
                this.cPk.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cjc.onButtonClick(-2);
                        a.this.cjc.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cjc, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a fA(boolean z) {
            if (z) {
                this.cPk.mDivider2.setVisibility(0);
            } else {
                this.cPk.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a iU(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cPk.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void iV(int i) {
            this.cPk.mDialogLayout.getLayoutParams().height = i;
            this.cPk.mDialogLayout.requestLayout();
        }

        public void iW(int i) {
            this.cPk.mDialogLayout.getLayoutParams().width = i;
            this.cPk.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cPk.mNeutralButton.setVisibility(0);
            if (this.cPk.mPositiveButton.getVisibility() == 0) {
                this.cPk.mDivider4.setVisibility(0);
            }
            this.cPk.mNeutralButton.setText(charSequence);
            this.cPk.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cjc.onButtonClick(-3);
                    a.this.cjc.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cjc, -3);
                    }
                }
            });
            return this;
        }

        public a iX(int i) {
            this.cPk.mIcon.setImageResource(i);
            return this;
        }

        public a as(View view) {
            this.cPk.mDialogContent.removeAllViews();
            this.cPk.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cPk.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a azn() {
            this.cPk.cPo.setPadding(0, 0, 0, 0);
            return this;
        }

        public a azo() {
            ((ViewGroup.MarginLayoutParams) this.cPk.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a fB(boolean z) {
            this.cPk.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cPk.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cPk.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cPk.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cPk.cPn = cVar;
            return this;
        }

        public a fC(boolean z) {
            this.cPk.cPq.setVisibility(z ? 0 : 8);
            return this;
        }

        public g ahZ() {
            this.cjc.setCancelable(this.cPk.mCancelable.booleanValue());
            if (this.cPk.mCancelable.booleanValue()) {
                this.cjc.setCanceledOnTouchOutside(false);
            }
            this.cjc.setOnCancelListener(this.cPk.mOnCancelListener);
            this.cjc.setOnDismissListener(this.cPk.mOnDismissListener);
            this.cjc.setOnShowListener(this.cPk.mOnShowListener);
            if (this.cPk.mOnKeyListener != null) {
                this.cjc.setOnKeyListener(this.cPk.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cPk.cPn != null) {
                this.cPk.cPn.a(this.cjc, this.cPk);
            }
            this.cjc.a(this);
            return this.cjc;
        }

        @Deprecated
        public g fD(boolean z) {
            return azp();
        }

        public g azp() {
            g ahZ = ahZ();
            if (this.mSystemDialog) {
                ahZ.getWindow().setType(2003);
            }
            try {
                ahZ.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return ahZ;
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
            this.cPk.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cPk.cPr != -1 ? this.cPk.cPr : a.e.aiapps_dialog_bg_white));
            this.cPk.mTitle.setTextColor(color);
            this.cPk.mMessage.setTextColor(color4);
            this.cPk.mPositiveButton.setTextColor(this.cPk.mPositiveBtnTextColor != color3 ? this.cPk.mPositiveBtnTextColor : color3);
            if (this.cPk.mNegativeBtnTextColor != color2) {
                this.cPk.mNegativeButton.setTextColor(this.cPk.mNegativeBtnTextColor);
            } else if (this.cPk.cPm != -1) {
                this.cPk.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cPk.cPm));
            } else {
                this.cPk.mNegativeButton.setTextColor(color2);
            }
            this.cPk.mNeutralButton.setTextColor(color2);
            int color6 = this.cPk.cPs != -1 ? getAlertDialogResources().getColor(this.cPk.cPs) : color5;
            this.cPk.mDivider2.setBackgroundColor(color6);
            this.cPk.mDivider3.setBackgroundColor(color6);
            this.cPk.mDivider4.setBackgroundColor(color6);
            this.cPk.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cPk.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cPk.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cPk.cPt ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fE(boolean z) {
            this.cPk.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fF(boolean z) {
            this.cPk.cPt = z;
            return this;
        }

        public a fG(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cPk.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a iY(int i) {
            return iZ(getAlertDialogResources().getColor(i));
        }

        public a R(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    iZ(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                iY(i);
            }
            return this;
        }

        public a iZ(int i) {
            this.cPk.mPositiveBtnTextColor = i;
            this.cPk.mPositiveButton.setTextColor(i);
            return this;
        }

        public a ja(int i) {
            return jc(this.mContext.getResources().getColor(i));
        }

        public a jb(int i) {
            this.cPk.cPm = i;
            return this;
        }

        public a S(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jc(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                ja(i);
            }
            return this;
        }

        public a jc(int i) {
            this.cPk.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cPk.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cPk.cPp.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jd(int i) {
            this.cPk.cPr = i;
            this.cPk.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a je(int i) {
            this.cPk.cPs = i;
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public SwanAppScrollView cLd;
        public c cPn;
        public FrameLayout cPo;
        public FrameLayout cPp;
        public View cPq;
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
        public int cPm = -1;
        public int cPr = -1;
        public int cPs = -1;
        public boolean cPt = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cPp = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cLd = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cPo = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cPq = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cLd.setMaxHeight(i);
        }
    }
}
