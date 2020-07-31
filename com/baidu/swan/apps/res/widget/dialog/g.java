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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cGh;

    /* loaded from: classes7.dex */
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

    public a aqY() {
        return this.cGh;
    }

    void a(a aVar) {
        this.cGh = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b cGi;
        protected final g ccZ;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.ccZ = bL(context);
            this.ccZ.a(this);
            this.cGi = new b((ViewGroup) this.ccZ.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aqZ() {
            if (ai.isScreenLand()) {
                gP(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                gM(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bL(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a fi(int i) {
            this.cGi.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cGi.mTitle.setText(charSequence);
            } else {
                ff(true);
            }
            return this;
        }

        public a ff(boolean z) {
            this.cGi.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a fh(int i) {
            if (this.cGi.mMessageContent.getVisibility() != 0) {
                this.cGi.mMessageContent.setVisibility(0);
            }
            this.cGi.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a og(String str) {
            if (this.cGi.mMessageContent.getVisibility() != 0) {
                this.cGi.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cGi.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cGi.mMessageContent.getVisibility() != 0) {
                this.cGi.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cGi.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cGi.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a ara() {
            this.cGi.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cGi.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a gM(int i) {
            this.cGi.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cGi.mPositiveButton.setVisibility(8);
                if (this.cGi.mNegativeButton.getVisibility() == 0) {
                    this.cGi.mDivider3.setVisibility(8);
                }
            } else {
                this.cGi.mPositiveButton.setVisibility(0);
                if (this.cGi.mNegativeButton.getVisibility() == 0) {
                    this.cGi.mDivider3.setVisibility(0);
                }
                this.cGi.mPositiveButton.setText(charSequence);
                this.cGi.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ccZ.onButtonClick(-1);
                        a.this.ccZ.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.ccZ, -1);
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
                        a.this.ccZ.onButtonClick(i);
                        a.this.ccZ.dismiss();
                        onClickListener.onClick(a.this.ccZ, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cGi.mPositiveButton == null || this.cGi.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cGi.mPositiveButton;
                i = 1;
            }
            if (this.cGi.mNegativeButton != null && this.cGi.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cGi.mNegativeButton;
            }
            if (this.cGi.mNeutralButton != null && this.cGi.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cGi.mNeutralButton;
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
                this.cGi.mNegativeButton.setVisibility(8);
                if (this.cGi.mPositiveButton.getVisibility() == 0) {
                    this.cGi.mDivider3.setVisibility(8);
                }
            } else {
                this.cGi.mNegativeButton.setVisibility(0);
                if (this.cGi.mPositiveButton.getVisibility() == 0) {
                    this.cGi.mDivider3.setVisibility(0);
                }
                this.cGi.mNegativeButton.setText(charSequence);
                this.cGi.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ccZ.onButtonClick(-2);
                        a.this.ccZ.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.ccZ, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a fg(boolean z) {
            if (z) {
                this.cGi.mDivider2.setVisibility(0);
            } else {
                this.cGi.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a gN(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cGi.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void gO(int i) {
            this.cGi.mDialogLayout.getLayoutParams().height = i;
            this.cGi.mDialogLayout.requestLayout();
        }

        public void gP(int i) {
            this.cGi.mDialogLayout.getLayoutParams().width = i;
            this.cGi.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cGi.mNeutralButton.setVisibility(0);
            if (this.cGi.mPositiveButton.getVisibility() == 0) {
                this.cGi.mDivider4.setVisibility(0);
            }
            this.cGi.mNeutralButton.setText(charSequence);
            this.cGi.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ccZ.onButtonClick(-3);
                    a.this.ccZ.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.ccZ, -3);
                    }
                }
            });
            return this;
        }

        public a gQ(int i) {
            this.cGi.mIcon.setImageResource(i);
            return this;
        }

        public a ar(View view) {
            this.cGi.mDialogContent.removeAllViews();
            this.cGi.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cGi.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a arb() {
            this.cGi.cGm.setPadding(0, 0, 0, 0);
            return this;
        }

        public a arc() {
            ((ViewGroup.MarginLayoutParams) this.cGi.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a fh(boolean z) {
            this.cGi.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cGi.mOnCancelListener = onCancelListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.cGi.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cGi.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cGi.cGl = cVar;
            return this;
        }

        public a fi(boolean z) {
            this.cGi.cGo.setVisibility(z ? 0 : 8);
            return this;
        }

        public g abN() {
            this.ccZ.setCancelable(this.cGi.mCancelable.booleanValue());
            if (this.cGi.mCancelable.booleanValue()) {
                this.ccZ.setCanceledOnTouchOutside(false);
            }
            this.ccZ.setOnCancelListener(this.cGi.mOnCancelListener);
            this.ccZ.setOnDismissListener(this.cGi.mOnDismissListener);
            this.ccZ.setOnShowListener(this.cGi.mOnShowListener);
            if (this.cGi.mOnKeyListener != null) {
                this.ccZ.setOnKeyListener(this.cGi.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cGi.cGl != null) {
                this.cGi.cGl.a(this.ccZ, this.cGi);
            }
            this.ccZ.a(this);
            return this.ccZ;
        }

        @Deprecated
        public g fj(boolean z) {
            return ard();
        }

        public g ard() {
            g abN = abN();
            if (this.mSystemDialog) {
                abN.getWindow().setType(2003);
            }
            try {
                abN.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return abN;
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
            this.cGi.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cGi.cGp != -1 ? this.cGi.cGp : a.e.aiapps_dialog_bg_white));
            this.cGi.mTitle.setTextColor(color);
            this.cGi.mMessage.setTextColor(color4);
            this.cGi.mPositiveButton.setTextColor(this.cGi.mPositiveBtnTextColor != color3 ? this.cGi.mPositiveBtnTextColor : color3);
            if (this.cGi.mNegativeBtnTextColor != color2) {
                this.cGi.mNegativeButton.setTextColor(this.cGi.mNegativeBtnTextColor);
            } else if (this.cGi.cGk != -1) {
                this.cGi.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cGi.cGk));
            } else {
                this.cGi.mNegativeButton.setTextColor(color2);
            }
            this.cGi.mNeutralButton.setTextColor(color2);
            int color6 = this.cGi.cGq != -1 ? getAlertDialogResources().getColor(this.cGi.cGq) : color5;
            this.cGi.mDivider2.setBackgroundColor(color6);
            this.cGi.mDivider3.setBackgroundColor(color6);
            this.cGi.mDivider4.setBackgroundColor(color6);
            this.cGi.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cGi.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cGi.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cGi.cGr ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fk(boolean z) {
            this.cGi.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fl(boolean z) {
            this.cGi.cGr = z;
            return this;
        }

        public a fm(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cGi.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a gR(int i) {
            return gS(getAlertDialogResources().getColor(i));
        }

        public a P(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gS(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gR(i);
            }
            return this;
        }

        public a gS(int i) {
            this.cGi.mPositiveBtnTextColor = i;
            this.cGi.mPositiveButton.setTextColor(i);
            return this;
        }

        public a gT(int i) {
            return gV(this.mContext.getResources().getColor(i));
        }

        public a gU(int i) {
            this.cGi.cGk = i;
            return this;
        }

        public a Q(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    gV(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                gT(i);
            }
            return this;
        }

        public a gV(int i) {
            this.cGi.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cGi.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cGi.cGn.setPadding(i, i2, i3, i4);
            return this;
        }

        public a gW(int i) {
            this.cGi.cGp = i;
            this.cGi.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a gX(int i) {
            this.cGi.cGq = i;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public SwanAppScrollView cCL;
        public c cGl;
        public FrameLayout cGm;
        public FrameLayout cGn;
        public View cGo;
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
        public int cGk = -1;
        public int cGp = -1;
        public int cGq = -1;
        public boolean cGr = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cGn = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cCL = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cGm = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cGo = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.aq.c.isGingerbread() || com.baidu.swan.apps.aq.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cCL.setMaxHeight(i);
        }
    }
}
