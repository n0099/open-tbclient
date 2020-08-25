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
    private a cPf;

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
        return this.cPf;
    }

    void a(a aVar) {
        this.cPf = aVar;
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
        protected final b cPg;
        protected final g ciY;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.ciY = bS(context);
            this.ciY.a(this);
            this.cPg = new b((ViewGroup) this.ciY.getWindow().getDecorView());
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
            this.cPg.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cPg.mTitle.setText(charSequence);
            } else {
                fy(true);
            }
            return this;
        }

        public a fy(boolean z) {
            this.cPg.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a hd(int i) {
            if (this.cPg.mMessageContent.getVisibility() != 0) {
                this.cPg.mMessageContent.setVisibility(0);
            }
            this.cPg.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a qe(String str) {
            if (this.cPg.mMessageContent.getVisibility() != 0) {
                this.cPg.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cPg.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cPg.mMessageContent.getVisibility() != 0) {
                this.cPg.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cPg.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cPg.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a azm() {
            this.cPg.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cPg.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a iT(int i) {
            this.cPg.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cPg.mPositiveButton.setVisibility(8);
                if (this.cPg.mNegativeButton.getVisibility() == 0) {
                    this.cPg.mDivider3.setVisibility(8);
                }
            } else {
                this.cPg.mPositiveButton.setVisibility(0);
                if (this.cPg.mNegativeButton.getVisibility() == 0) {
                    this.cPg.mDivider3.setVisibility(0);
                }
                this.cPg.mPositiveButton.setText(charSequence);
                this.cPg.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ciY.onButtonClick(-1);
                        a.this.ciY.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.ciY, -1);
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
                        a.this.ciY.onButtonClick(i);
                        a.this.ciY.dismiss();
                        onClickListener.onClick(a.this.ciY, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cPg.mPositiveButton == null || this.cPg.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cPg.mPositiveButton;
                i = 1;
            }
            if (this.cPg.mNegativeButton != null && this.cPg.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cPg.mNegativeButton;
            }
            if (this.cPg.mNeutralButton != null && this.cPg.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cPg.mNeutralButton;
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
                this.cPg.mNegativeButton.setVisibility(8);
                if (this.cPg.mPositiveButton.getVisibility() == 0) {
                    this.cPg.mDivider3.setVisibility(8);
                }
            } else {
                this.cPg.mNegativeButton.setVisibility(0);
                if (this.cPg.mPositiveButton.getVisibility() == 0) {
                    this.cPg.mDivider3.setVisibility(0);
                }
                this.cPg.mNegativeButton.setText(charSequence);
                this.cPg.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ciY.onButtonClick(-2);
                        a.this.ciY.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.ciY, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a fz(boolean z) {
            if (z) {
                this.cPg.mDivider2.setVisibility(0);
            } else {
                this.cPg.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a iU(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cPg.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void iV(int i) {
            this.cPg.mDialogLayout.getLayoutParams().height = i;
            this.cPg.mDialogLayout.requestLayout();
        }

        public void iW(int i) {
            this.cPg.mDialogLayout.getLayoutParams().width = i;
            this.cPg.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cPg.mNeutralButton.setVisibility(0);
            if (this.cPg.mPositiveButton.getVisibility() == 0) {
                this.cPg.mDivider4.setVisibility(0);
            }
            this.cPg.mNeutralButton.setText(charSequence);
            this.cPg.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ciY.onButtonClick(-3);
                    a.this.ciY.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.ciY, -3);
                    }
                }
            });
            return this;
        }

        public a iX(int i) {
            this.cPg.mIcon.setImageResource(i);
            return this;
        }

        public a as(View view) {
            this.cPg.mDialogContent.removeAllViews();
            this.cPg.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cPg.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a azn() {
            this.cPg.cPk.setPadding(0, 0, 0, 0);
            return this;
        }

        public a azo() {
            ((ViewGroup.MarginLayoutParams) this.cPg.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a fA(boolean z) {
            this.cPg.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cPg.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cPg.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cPg.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cPg.cPj = cVar;
            return this;
        }

        public a fB(boolean z) {
            this.cPg.cPm.setVisibility(z ? 0 : 8);
            return this;
        }

        public g ahZ() {
            this.ciY.setCancelable(this.cPg.mCancelable.booleanValue());
            if (this.cPg.mCancelable.booleanValue()) {
                this.ciY.setCanceledOnTouchOutside(false);
            }
            this.ciY.setOnCancelListener(this.cPg.mOnCancelListener);
            this.ciY.setOnDismissListener(this.cPg.mOnDismissListener);
            this.ciY.setOnShowListener(this.cPg.mOnShowListener);
            if (this.cPg.mOnKeyListener != null) {
                this.ciY.setOnKeyListener(this.cPg.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cPg.cPj != null) {
                this.cPg.cPj.a(this.ciY, this.cPg);
            }
            this.ciY.a(this);
            return this.ciY;
        }

        @Deprecated
        public g fC(boolean z) {
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
            this.cPg.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cPg.cPn != -1 ? this.cPg.cPn : a.e.aiapps_dialog_bg_white));
            this.cPg.mTitle.setTextColor(color);
            this.cPg.mMessage.setTextColor(color4);
            this.cPg.mPositiveButton.setTextColor(this.cPg.mPositiveBtnTextColor != color3 ? this.cPg.mPositiveBtnTextColor : color3);
            if (this.cPg.mNegativeBtnTextColor != color2) {
                this.cPg.mNegativeButton.setTextColor(this.cPg.mNegativeBtnTextColor);
            } else if (this.cPg.cPi != -1) {
                this.cPg.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cPg.cPi));
            } else {
                this.cPg.mNegativeButton.setTextColor(color2);
            }
            this.cPg.mNeutralButton.setTextColor(color2);
            int color6 = this.cPg.cPo != -1 ? getAlertDialogResources().getColor(this.cPg.cPo) : color5;
            this.cPg.mDivider2.setBackgroundColor(color6);
            this.cPg.mDivider3.setBackgroundColor(color6);
            this.cPg.mDivider4.setBackgroundColor(color6);
            this.cPg.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cPg.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cPg.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cPg.cPp ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fD(boolean z) {
            this.cPg.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fE(boolean z) {
            this.cPg.cPp = z;
            return this;
        }

        public a fF(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cPg.mCustomPanel.getLayoutParams();
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
            this.cPg.mPositiveBtnTextColor = i;
            this.cPg.mPositiveButton.setTextColor(i);
            return this;
        }

        public a ja(int i) {
            return jc(this.mContext.getResources().getColor(i));
        }

        public a jb(int i) {
            this.cPg.cPi = i;
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
            this.cPg.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cPg.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cPg.cPl.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jd(int i) {
            this.cPg.cPn = i;
            this.cPg.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a je(int i) {
            this.cPg.cPo = i;
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public SwanAppScrollView cKZ;
        public c cPj;
        public FrameLayout cPk;
        public FrameLayout cPl;
        public View cPm;
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
        public int cPi = -1;
        public int cPn = -1;
        public int cPo = -1;
        public boolean cPp = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cPl = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cKZ = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cPk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cPm = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cKZ.setMaxHeight(i);
        }
    }
}
