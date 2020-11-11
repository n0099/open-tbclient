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
    private a drM;

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

    public a aGW() {
        return this.drM;
    }

    void a(a aVar) {
        this.drM = aVar;
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
        protected final g cLK;
        protected final b drN;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cLK = bX(context);
            this.cLK.a(this);
            this.drN = new b((ViewGroup) this.cLK.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aGX() {
            if (ah.isScreenLand()) {
                jZ(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                jW(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bX(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        /* renamed from: if */
        public a mo33if(int i) {
            this.drN.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.drN.mTitle.setText(charSequence);
            } else {
                gp(true);
            }
            return this;
        }

        public a gp(boolean z) {
            this.drN.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a ie(int i) {
            if (this.drN.mMessageContent.getVisibility() != 0) {
                this.drN.mMessageContent.setVisibility(0);
            }
            this.drN.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a rR(String str) {
            if (this.drN.mMessageContent.getVisibility() != 0) {
                this.drN.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.drN.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.drN.mMessageContent.getVisibility() != 0) {
                this.drN.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.drN.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.drN.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aGY() {
            this.drN.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.drN.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a jW(int i) {
            this.drN.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.drN.mPositiveButton.setVisibility(8);
                if (this.drN.mNegativeButton.getVisibility() == 0) {
                    this.drN.mDivider3.setVisibility(8);
                }
            } else {
                this.drN.mPositiveButton.setVisibility(0);
                if (this.drN.mNegativeButton.getVisibility() == 0) {
                    this.drN.mDivider3.setVisibility(0);
                }
                this.drN.mPositiveButton.setText(charSequence);
                this.drN.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cLK.onButtonClick(-1);
                        a.this.cLK.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cLK, -1);
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
                        a.this.cLK.onButtonClick(i);
                        a.this.cLK.dismiss();
                        onClickListener.onClick(a.this.cLK, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.drN.mPositiveButton == null || this.drN.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.drN.mPositiveButton;
                i = 1;
            }
            if (this.drN.mNegativeButton != null && this.drN.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.drN.mNegativeButton;
            }
            if (this.drN.mNeutralButton != null && this.drN.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.drN.mNeutralButton;
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
                this.drN.mNegativeButton.setVisibility(8);
                if (this.drN.mPositiveButton.getVisibility() == 0) {
                    this.drN.mDivider3.setVisibility(8);
                }
            } else {
                this.drN.mNegativeButton.setVisibility(0);
                if (this.drN.mPositiveButton.getVisibility() == 0) {
                    this.drN.mDivider3.setVisibility(0);
                }
                this.drN.mNegativeButton.setText(charSequence);
                this.drN.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cLK.onButtonClick(-2);
                        a.this.cLK.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cLK, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gq(boolean z) {
            if (z) {
                this.drN.mDivider2.setVisibility(0);
            } else {
                this.drN.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a jX(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.drN.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void jY(int i) {
            this.drN.mDialogLayout.getLayoutParams().height = i;
            this.drN.mDialogLayout.requestLayout();
        }

        public void jZ(int i) {
            this.drN.mDialogLayout.getLayoutParams().width = i;
            this.drN.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.drN.mNeutralButton.setVisibility(0);
            if (this.drN.mPositiveButton.getVisibility() == 0) {
                this.drN.mDivider4.setVisibility(0);
            }
            this.drN.mNeutralButton.setText(charSequence);
            this.drN.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cLK.onButtonClick(-3);
                    a.this.cLK.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cLK, -3);
                    }
                }
            });
            return this;
        }

        public a ka(int i) {
            this.drN.mIcon.setImageResource(i);
            return this;
        }

        public a aA(View view) {
            this.drN.mDialogContent.removeAllViews();
            this.drN.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.drN.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aGZ() {
            this.drN.drR.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aHa() {
            ((ViewGroup.MarginLayoutParams) this.drN.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gr(boolean z) {
            this.drN.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.drN.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.drN.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.drN.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.drN.drQ = cVar;
            return this;
        }

        public a gs(boolean z) {
            this.drN.drT.setVisibility(z ? 0 : 8);
            return this;
        }

        public g apP() {
            this.cLK.setCancelable(this.drN.mCancelable.booleanValue());
            if (this.drN.mCancelable.booleanValue()) {
                this.cLK.setCanceledOnTouchOutside(false);
            }
            this.cLK.setOnCancelListener(this.drN.mOnCancelListener);
            this.cLK.setOnDismissListener(this.drN.mOnDismissListener);
            this.cLK.setOnShowListener(this.drN.mOnShowListener);
            if (this.drN.mOnKeyListener != null) {
                this.cLK.setOnKeyListener(this.drN.mOnKeyListener);
            }
            updateDialogUI();
            if (this.drN.drQ != null) {
                this.drN.drQ.a(this.cLK, this.drN);
            }
            this.cLK.a(this);
            return this.cLK;
        }

        @Deprecated
        public g gt(boolean z) {
            return aHb();
        }

        public g aHb() {
            g apP = apP();
            if (this.mSystemDialog) {
                apP.getWindow().setType(2003);
            }
            try {
                apP.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return apP;
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
            this.drN.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.drN.drU != -1 ? this.drN.drU : a.e.aiapps_dialog_bg_white));
            this.drN.mTitle.setTextColor(color);
            this.drN.mMessage.setTextColor(color4);
            this.drN.mPositiveButton.setTextColor(this.drN.mPositiveBtnTextColor != color3 ? this.drN.mPositiveBtnTextColor : color3);
            if (this.drN.mNegativeBtnTextColor != color2) {
                this.drN.mNegativeButton.setTextColor(this.drN.mNegativeBtnTextColor);
            } else if (this.drN.drP != -1) {
                this.drN.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.drN.drP));
            } else {
                this.drN.mNegativeButton.setTextColor(color2);
            }
            this.drN.mNeutralButton.setTextColor(color2);
            int color6 = this.drN.drV != -1 ? getAlertDialogResources().getColor(this.drN.drV) : color5;
            this.drN.mDivider2.setBackgroundColor(color6);
            this.drN.mDivider3.setBackgroundColor(color6);
            this.drN.mDivider4.setBackgroundColor(color6);
            this.drN.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.drN.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.drN.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.drN.drW ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gu(boolean z) {
            this.drN.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gv(boolean z) {
            this.drN.drW = z;
            return this;
        }

        public a gw(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.drN.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a kb(int i) {
            return kc(getAlertDialogResources().getColor(i));
        }

        public a U(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kc(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                kb(i);
            }
            return this;
        }

        public a kc(int i) {
            this.drN.mPositiveBtnTextColor = i;
            this.drN.mPositiveButton.setTextColor(i);
            return this;
        }

        public a kd(int i) {
            return kf(this.mContext.getResources().getColor(i));
        }

        public a ke(int i) {
            this.drN.drP = i;
            return this;
        }

        public a V(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kf(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                kd(i);
            }
            return this;
        }

        public a kf(int i) {
            this.drN.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.drN.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.drN.drS.setPadding(i, i2, i3, i4);
            return this;
        }

        public a kg(int i) {
            this.drN.drU = i;
            this.drN.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a kh(int i) {
            this.drN.drV = i;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public SwanAppScrollView dnD;
        public c drQ;
        public FrameLayout drR;
        public FrameLayout drS;
        public View drT;
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
        public int drP = -1;
        public int drU = -1;
        public int drV = -1;
        public boolean drW = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.drS = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.dnD = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.drR = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.drT = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.dnD.setMaxHeight(i);
        }
    }
}
