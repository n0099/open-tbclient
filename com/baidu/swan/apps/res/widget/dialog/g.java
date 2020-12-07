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
/* loaded from: classes25.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dxf;

    /* loaded from: classes25.dex */
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

    public a aJw() {
        return this.dxf;
    }

    void a(a aVar) {
        this.dxf = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("hide"));
    }

    /* loaded from: classes25.dex */
    public static class a {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = a.h.aiapps_dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = a.h.aiapps_dialog_positive_title_ok;
        protected final g cQT;
        protected final b dxg;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cQT = cD(context);
            this.cQT.a(this);
            this.dxg = new b((ViewGroup) this.cQT.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aJx() {
            if (ah.isScreenLand()) {
                kt(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                kq(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g cD(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a iz(int i) {
            this.dxg.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dxg.mTitle.setText(charSequence);
            } else {
                gH(true);
            }
            return this;
        }

        public a gH(boolean z) {
            this.dxg.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a iy(int i) {
            if (this.dxg.mMessageContent.getVisibility() != 0) {
                this.dxg.mMessageContent.setVisibility(0);
            }
            this.dxg.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a st(String str) {
            if (this.dxg.mMessageContent.getVisibility() != 0) {
                this.dxg.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.dxg.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dxg.mMessageContent.getVisibility() != 0) {
                this.dxg.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.dxg.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.dxg.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aJy() {
            this.dxg.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dxg.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a kq(int i) {
            this.dxg.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dxg.mPositiveButton.setVisibility(8);
                if (this.dxg.mNegativeButton.getVisibility() == 0) {
                    this.dxg.mDivider3.setVisibility(8);
                }
            } else {
                this.dxg.mPositiveButton.setVisibility(0);
                if (this.dxg.mNegativeButton.getVisibility() == 0) {
                    this.dxg.mDivider3.setVisibility(0);
                }
                this.dxg.mPositiveButton.setText(charSequence);
                this.dxg.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cQT.onButtonClick(-1);
                        a.this.cQT.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cQT, -1);
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
                        a.this.cQT.onButtonClick(i);
                        a.this.cQT.dismiss();
                        onClickListener.onClick(a.this.cQT, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.dxg.mPositiveButton == null || this.dxg.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.dxg.mPositiveButton;
                i = 1;
            }
            if (this.dxg.mNegativeButton != null && this.dxg.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.dxg.mNegativeButton;
            }
            if (this.dxg.mNeutralButton != null && this.dxg.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.dxg.mNeutralButton;
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
                this.dxg.mNegativeButton.setVisibility(8);
                if (this.dxg.mPositiveButton.getVisibility() == 0) {
                    this.dxg.mDivider3.setVisibility(8);
                }
            } else {
                this.dxg.mNegativeButton.setVisibility(0);
                if (this.dxg.mPositiveButton.getVisibility() == 0) {
                    this.dxg.mDivider3.setVisibility(0);
                }
                this.dxg.mNegativeButton.setText(charSequence);
                this.dxg.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cQT.onButtonClick(-2);
                        a.this.cQT.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cQT, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gI(boolean z) {
            if (z) {
                this.dxg.mDivider2.setVisibility(0);
            } else {
                this.dxg.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a kr(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dxg.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void ks(int i) {
            this.dxg.mDialogLayout.getLayoutParams().height = i;
            this.dxg.mDialogLayout.requestLayout();
        }

        public void kt(int i) {
            this.dxg.mDialogLayout.getLayoutParams().width = i;
            this.dxg.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dxg.mNeutralButton.setVisibility(0);
            if (this.dxg.mPositiveButton.getVisibility() == 0) {
                this.dxg.mDivider4.setVisibility(0);
            }
            this.dxg.mNeutralButton.setText(charSequence);
            this.dxg.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cQT.onButtonClick(-3);
                    a.this.cQT.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cQT, -3);
                    }
                }
            });
            return this;
        }

        public a ku(int i) {
            this.dxg.mIcon.setImageResource(i);
            return this;
        }

        public a aC(View view) {
            this.dxg.mDialogContent.removeAllViews();
            this.dxg.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dxg.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aJz() {
            this.dxg.dxk.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aJA() {
            ((ViewGroup.MarginLayoutParams) this.dxg.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gJ(boolean z) {
            this.dxg.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.dxg.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dxg.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dxg.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dxg.dxj = cVar;
            return this;
        }

        public a gK(boolean z) {
            this.dxg.dxm.setVisibility(z ? 0 : 8);
            return this;
        }

        public g asp() {
            this.cQT.setCancelable(this.dxg.mCancelable.booleanValue());
            if (this.dxg.mCancelable.booleanValue()) {
                this.cQT.setCanceledOnTouchOutside(false);
            }
            this.cQT.setOnCancelListener(this.dxg.mOnCancelListener);
            this.cQT.setOnDismissListener(this.dxg.mOnDismissListener);
            this.cQT.setOnShowListener(this.dxg.mOnShowListener);
            if (this.dxg.mOnKeyListener != null) {
                this.cQT.setOnKeyListener(this.dxg.mOnKeyListener);
            }
            updateDialogUI();
            if (this.dxg.dxj != null) {
                this.dxg.dxj.a(this.cQT, this.dxg);
            }
            this.cQT.a(this);
            return this.cQT;
        }

        @Deprecated
        public g gL(boolean z) {
            return aJB();
        }

        public g aJB() {
            g asp = asp();
            if (this.mSystemDialog) {
                asp.getWindow().setType(2003);
            }
            try {
                asp.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return asp;
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
            this.dxg.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.dxg.dxn != -1 ? this.dxg.dxn : a.e.aiapps_dialog_bg_white));
            this.dxg.mTitle.setTextColor(color);
            this.dxg.mMessage.setTextColor(color4);
            this.dxg.mPositiveButton.setTextColor(this.dxg.mPositiveBtnTextColor != color3 ? this.dxg.mPositiveBtnTextColor : color3);
            if (this.dxg.mNegativeBtnTextColor != color2) {
                this.dxg.mNegativeButton.setTextColor(this.dxg.mNegativeBtnTextColor);
            } else if (this.dxg.dxi != -1) {
                this.dxg.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.dxg.dxi));
            } else {
                this.dxg.mNegativeButton.setTextColor(color2);
            }
            this.dxg.mNeutralButton.setTextColor(color2);
            int color6 = this.dxg.dxo != -1 ? getAlertDialogResources().getColor(this.dxg.dxo) : color5;
            this.dxg.mDivider2.setBackgroundColor(color6);
            this.dxg.mDivider3.setBackgroundColor(color6);
            this.dxg.mDivider4.setBackgroundColor(color6);
            this.dxg.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dxg.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dxg.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.dxg.dxp ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gM(boolean z) {
            this.dxg.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gN(boolean z) {
            this.dxg.dxp = z;
            return this;
        }

        public a gO(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dxg.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a kv(int i) {
            return kw(getAlertDialogResources().getColor(i));
        }

        public a V(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kw(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                kv(i);
            }
            return this;
        }

        public a kw(int i) {
            this.dxg.mPositiveBtnTextColor = i;
            this.dxg.mPositiveButton.setTextColor(i);
            return this;
        }

        public a kx(int i) {
            return kz(this.mContext.getResources().getColor(i));
        }

        public a ky(int i) {
            this.dxg.dxi = i;
            return this;
        }

        public a W(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kz(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                kx(i);
            }
            return this;
        }

        public a kz(int i) {
            this.dxg.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.dxg.mDialogContent;
        }

        public a q(int i, int i2, int i3, int i4) {
            this.dxg.dxl.setPadding(i, i2, i3, i4);
            return this;
        }

        public a kA(int i) {
            this.dxg.dxn = i;
            this.dxg.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a kB(int i) {
            this.dxg.dxo = i;
            return this;
        }
    }

    /* loaded from: classes25.dex */
    public static class b {
        public SwanAppScrollView dsW;
        public c dxj;
        public FrameLayout dxk;
        public FrameLayout dxl;
        public View dxm;
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
        public int dxi = -1;
        public int dxn = -1;
        public int dxo = -1;
        public boolean dxp = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.dxl = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.dsW = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dxk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dxm = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.dsW.setMaxHeight(i);
        }
    }
}
