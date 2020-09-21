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
/* loaded from: classes3.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cRj;

    /* loaded from: classes3.dex */
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

    public a azT() {
        return this.cRj;
    }

    void a(a aVar) {
        this.cRj = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final b cRk;
        protected final g cld;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cld = bR(context);
            this.cld.a(this);
            this.cRk = new b((ViewGroup) this.cld.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a azU() {
            if (ah.isScreenLand()) {
                jh(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                je(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bR(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a hn(int i) {
            this.cRk.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a e(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.cRk.mTitle.setText(charSequence);
            } else {
                fx(true);
            }
            return this;
        }

        public a fx(boolean z) {
            this.cRk.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a hm(int i) {
            if (this.cRk.mMessageContent.getVisibility() != 0) {
                this.cRk.mMessageContent.setVisibility(0);
            }
            this.cRk.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a qy(String str) {
            if (this.cRk.mMessageContent.getVisibility() != 0) {
                this.cRk.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.cRk.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.cRk.mMessageContent.getVisibility() != 0) {
                this.cRk.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.cRk.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.cRk.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a azV() {
            this.cRk.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.cRk.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a je(int i) {
            this.cRk.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.cRk.mPositiveButton.setVisibility(8);
                if (this.cRk.mNegativeButton.getVisibility() == 0) {
                    this.cRk.mDivider3.setVisibility(8);
                }
            } else {
                this.cRk.mPositiveButton.setVisibility(0);
                if (this.cRk.mNegativeButton.getVisibility() == 0) {
                    this.cRk.mDivider3.setVisibility(0);
                }
                this.cRk.mPositiveButton.setText(charSequence);
                this.cRk.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cld.onButtonClick(-1);
                        a.this.cld.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cld, -1);
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
                        a.this.cld.onButtonClick(i);
                        a.this.cld.dismiss();
                        onClickListener.onClick(a.this.cld, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.cRk.mPositiveButton == null || this.cRk.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.cRk.mPositiveButton;
                i = 1;
            }
            if (this.cRk.mNegativeButton != null && this.cRk.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.cRk.mNegativeButton;
            }
            if (this.cRk.mNeutralButton != null && this.cRk.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.cRk.mNeutralButton;
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
                this.cRk.mNegativeButton.setVisibility(8);
                if (this.cRk.mPositiveButton.getVisibility() == 0) {
                    this.cRk.mDivider3.setVisibility(8);
                }
            } else {
                this.cRk.mNegativeButton.setVisibility(0);
                if (this.cRk.mPositiveButton.getVisibility() == 0) {
                    this.cRk.mDivider3.setVisibility(0);
                }
                this.cRk.mNegativeButton.setText(charSequence);
                this.cRk.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cld.onButtonClick(-2);
                        a.this.cld.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cld, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a fy(boolean z) {
            if (z) {
                this.cRk.mDivider2.setVisibility(0);
            } else {
                this.cRk.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a jf(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.cRk.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void jg(int i) {
            this.cRk.mDialogLayout.getLayoutParams().height = i;
            this.cRk.mDialogLayout.requestLayout();
        }

        public void jh(int i) {
            this.cRk.mDialogLayout.getLayoutParams().width = i;
            this.cRk.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cRk.mNeutralButton.setVisibility(0);
            if (this.cRk.mPositiveButton.getVisibility() == 0) {
                this.cRk.mDivider4.setVisibility(0);
            }
            this.cRk.mNeutralButton.setText(charSequence);
            this.cRk.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cld.onButtonClick(-3);
                    a.this.cld.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cld, -3);
                    }
                }
            });
            return this;
        }

        public a ji(int i) {
            this.cRk.mIcon.setImageResource(i);
            return this;
        }

        public a au(View view) {
            this.cRk.mDialogContent.removeAllViews();
            this.cRk.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.cRk.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a azW() {
            this.cRk.cRo.setPadding(0, 0, 0, 0);
            return this;
        }

        public a azX() {
            ((ViewGroup.MarginLayoutParams) this.cRk.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a fz(boolean z) {
            this.cRk.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.cRk.mOnCancelListener = onCancelListener;
            return this;
        }

        public a b(DialogInterface.OnDismissListener onDismissListener) {
            this.cRk.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.cRk.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.cRk.cRn = cVar;
            return this;
        }

        public a fA(boolean z) {
            this.cRk.cRq.setVisibility(z ? 0 : 8);
            return this;
        }

        public g aiJ() {
            this.cld.setCancelable(this.cRk.mCancelable.booleanValue());
            if (this.cRk.mCancelable.booleanValue()) {
                this.cld.setCanceledOnTouchOutside(false);
            }
            this.cld.setOnCancelListener(this.cRk.mOnCancelListener);
            this.cld.setOnDismissListener(this.cRk.mOnDismissListener);
            this.cld.setOnShowListener(this.cRk.mOnShowListener);
            if (this.cRk.mOnKeyListener != null) {
                this.cld.setOnKeyListener(this.cRk.mOnKeyListener);
            }
            updateDialogUI();
            if (this.cRk.cRn != null) {
                this.cRk.cRn.a(this.cld, this.cRk);
            }
            this.cld.a(this);
            return this.cld;
        }

        @Deprecated
        public g fB(boolean z) {
            return azY();
        }

        public g azY() {
            g aiJ = aiJ();
            if (this.mSystemDialog) {
                aiJ.getWindow().setType(2003);
            }
            try {
                aiJ.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return aiJ;
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
            this.cRk.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.cRk.cRr != -1 ? this.cRk.cRr : a.e.aiapps_dialog_bg_white));
            this.cRk.mTitle.setTextColor(color);
            this.cRk.mMessage.setTextColor(color4);
            this.cRk.mPositiveButton.setTextColor(this.cRk.mPositiveBtnTextColor != color3 ? this.cRk.mPositiveBtnTextColor : color3);
            if (this.cRk.mNegativeBtnTextColor != color2) {
                this.cRk.mNegativeButton.setTextColor(this.cRk.mNegativeBtnTextColor);
            } else if (this.cRk.cRm != -1) {
                this.cRk.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.cRk.cRm));
            } else {
                this.cRk.mNegativeButton.setTextColor(color2);
            }
            this.cRk.mNeutralButton.setTextColor(color2);
            int color6 = this.cRk.cRs != -1 ? getAlertDialogResources().getColor(this.cRk.cRs) : color5;
            this.cRk.mDivider2.setBackgroundColor(color6);
            this.cRk.mDivider3.setBackgroundColor(color6);
            this.cRk.mDivider4.setBackgroundColor(color6);
            this.cRk.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.cRk.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.cRk.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.cRk.cRt ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a fC(boolean z) {
            this.cRk.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a fD(boolean z) {
            this.cRk.cRt = z;
            return this;
        }

        public a fE(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.cRk.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a jj(int i) {
            return jk(getAlertDialogResources().getColor(i));
        }

        public a R(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jk(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jj(i);
            }
            return this;
        }

        public a jk(int i) {
            this.cRk.mPositiveBtnTextColor = i;
            this.cRk.mPositiveButton.setTextColor(i);
            return this;
        }

        public a jl(int i) {
            return jn(this.mContext.getResources().getColor(i));
        }

        public a jm(int i) {
            this.cRk.cRm = i;
            return this;
        }

        public a S(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jn(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jl(i);
            }
            return this;
        }

        public a jn(int i) {
            this.cRk.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.cRk.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.cRk.cRp.setPadding(i, i2, i3, i4);
            return this;
        }

        public a jo(int i) {
            this.cRk.cRr = i;
            this.cRk.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a jp(int i) {
            this.cRk.cRs = i;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public SwanAppScrollView cNd;
        public c cRn;
        public FrameLayout cRo;
        public FrameLayout cRp;
        public View cRq;
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
        public int cRm = -1;
        public int cRr = -1;
        public int cRs = -1;
        public boolean cRt = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cRp = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.cNd = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cRo = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cRq = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.cNd.setMaxHeight(i);
        }
    }
}
