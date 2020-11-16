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
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.res.widget.dialog.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dqe;

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

    public a aGo() {
        return this.dqe;
    }

    void a(a aVar) {
        this.dqe = aVar;
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
        protected final g cKa;
        protected final b dqf;
        protected int mBtnHeight;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cKa = bX(context);
            this.cKa.a(this);
            this.dqf = new b((ViewGroup) this.cKa.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_btns_height);
        }

        public a aGp() {
            if (ah.isScreenLand()) {
                jV(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_default_width));
                jS(this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_landscape_content_default_height));
            }
            return this;
        }

        protected g bX(Context context) {
            return new g(context, a.i.NoTitleDialog);
        }

        public a ib(int i) {
            this.dqf.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public a f(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.dqf.mTitle.setText(charSequence);
            } else {
                gs(true);
            }
            return this;
        }

        public a gs(boolean z) {
            this.dqf.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public a ia(int i) {
            if (this.dqf.mMessageContent.getVisibility() != 0) {
                this.dqf.mMessageContent.setVisibility(0);
            }
            this.dqf.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public a rL(String str) {
            if (this.dqf.mMessageContent.getVisibility() != 0) {
                this.dqf.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.dqf.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public a a(Spanned spanned) {
            if (this.dqf.mMessageContent.getVisibility() != 0) {
                this.dqf.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.dqf.mMessage.setMovementMethod(LinkMovementMethod.getInstance());
                this.dqf.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public a aGq() {
            this.dqf.mMessage.setGravity(3);
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_message_content);
            this.dqf.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public a jS(int i) {
            this.dqf.setMessageMaxHeight(i);
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(this.mContext.getText(i), onClickListener);
        }

        public a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dqf.mPositiveButton.setVisibility(8);
                if (this.dqf.mNegativeButton.getVisibility() == 0) {
                    this.dqf.mDivider3.setVisibility(8);
                }
            } else {
                this.dqf.mPositiveButton.setVisibility(0);
                if (this.dqf.mNegativeButton.getVisibility() == 0) {
                    this.dqf.mDivider3.setVisibility(0);
                }
                this.dqf.mPositiveButton.setText(charSequence);
                this.dqf.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cKa.onButtonClick(-1);
                        a.this.cKa.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cKa, -1);
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
                        a.this.cKa.onButtonClick(i);
                        a.this.cKa.dismiss();
                        onClickListener.onClick(a.this.cKa, i);
                    }
                });
            }
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.dqf.mPositiveButton == null || this.dqf.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.dqf.mPositiveButton;
                i = 1;
            }
            if (this.dqf.mNegativeButton != null && this.dqf.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.dqf.mNegativeButton;
            }
            if (this.dqf.mNeutralButton != null && this.dqf.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.dqf.mNeutralButton;
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
                this.dqf.mNegativeButton.setVisibility(8);
                if (this.dqf.mPositiveButton.getVisibility() == 0) {
                    this.dqf.mDivider3.setVisibility(8);
                }
            } else {
                this.dqf.mNegativeButton.setVisibility(0);
                if (this.dqf.mPositiveButton.getVisibility() == 0) {
                    this.dqf.mDivider3.setVisibility(0);
                }
                this.dqf.mNegativeButton.setText(charSequence);
                this.dqf.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.cKa.onButtonClick(-2);
                        a.this.cKa.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(a.this.cKa, -2);
                        }
                    }
                });
            }
            return this;
        }

        public a gt(boolean z) {
            if (z) {
                this.dqf.mDivider2.setVisibility(0);
            } else {
                this.dqf.mDivider2.setVisibility(8);
            }
            return this;
        }

        public a jT(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, a.f.btn_panel);
            this.dqf.mDivider2.setLayoutParams(layoutParams);
            return this;
        }

        public void jU(int i) {
            this.dqf.mDialogLayout.getLayoutParams().height = i;
            this.dqf.mDialogLayout.requestLayout();
        }

        public void jV(int i) {
            this.dqf.mDialogLayout.getLayoutParams().width = i;
            this.dqf.mDialogLayout.requestLayout();
        }

        public a e(int i, DialogInterface.OnClickListener onClickListener) {
            return c(this.mContext.getText(i), onClickListener);
        }

        public a c(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dqf.mNeutralButton.setVisibility(0);
            if (this.dqf.mPositiveButton.getVisibility() == 0) {
                this.dqf.mDivider4.setVisibility(0);
            }
            this.dqf.mNeutralButton.setText(charSequence);
            this.dqf.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.g.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cKa.onButtonClick(-3);
                    a.this.cKa.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cKa, -3);
                    }
                }
            });
            return this;
        }

        public a jW(int i) {
            this.dqf.mIcon.setImageResource(i);
            return this;
        }

        public a aA(View view) {
            this.dqf.mDialogContent.removeAllViews();
            this.dqf.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, a.f.dialog_customPanel);
            this.dqf.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public a aGr() {
            this.dqf.dqj.setPadding(0, 0, 0, 0);
            return this;
        }

        public a aGs() {
            ((ViewGroup.MarginLayoutParams) this.dqf.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public a gu(boolean z) {
            this.dqf.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.dqf.mOnCancelListener = onCancelListener;
            return this;
        }

        public a c(DialogInterface.OnDismissListener onDismissListener) {
            this.dqf.mOnDismissListener = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnShowListener onShowListener) {
            this.dqf.mOnShowListener = onShowListener;
            return this;
        }

        public a a(c cVar) {
            this.dqf.dqi = cVar;
            return this;
        }

        public a gv(boolean z) {
            this.dqf.dql.setVisibility(z ? 0 : 8);
            return this;
        }

        public g apg() {
            this.cKa.setCancelable(this.dqf.mCancelable.booleanValue());
            if (this.dqf.mCancelable.booleanValue()) {
                this.cKa.setCanceledOnTouchOutside(false);
            }
            this.cKa.setOnCancelListener(this.dqf.mOnCancelListener);
            this.cKa.setOnDismissListener(this.dqf.mOnDismissListener);
            this.cKa.setOnShowListener(this.dqf.mOnShowListener);
            if (this.dqf.mOnKeyListener != null) {
                this.cKa.setOnKeyListener(this.dqf.mOnKeyListener);
            }
            updateDialogUI();
            if (this.dqf.dqi != null) {
                this.dqf.dqi.a(this.cKa, this.dqf);
            }
            this.cKa.a(this);
            return this.cKa;
        }

        @Deprecated
        public g gw(boolean z) {
            return aGt();
        }

        public g aGt() {
            g apg = apg();
            if (this.mSystemDialog) {
                apg.getWindow().setType(2003);
            }
            try {
                apg.show();
            } catch (WindowManager.BadTokenException e) {
                if (g.DEBUG) {
                    e.printStackTrace();
                }
            }
            EventBusWrapper.post(new com.baidu.swan.apps.res.widget.dialog.a("show"));
            return apg;
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
            this.dqf.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(this.dqf.dqm != -1 ? this.dqf.dqm : a.e.aiapps_dialog_bg_white));
            this.dqf.mTitle.setTextColor(color);
            this.dqf.mMessage.setTextColor(color4);
            this.dqf.mPositiveButton.setTextColor(this.dqf.mPositiveBtnTextColor != color3 ? this.dqf.mPositiveBtnTextColor : color3);
            if (this.dqf.mNegativeBtnTextColor != color2) {
                this.dqf.mNegativeButton.setTextColor(this.dqf.mNegativeBtnTextColor);
            } else if (this.dqf.dqh != -1) {
                this.dqf.mNegativeButton.setTextColor(getAlertDialogResources().getColorStateList(this.dqf.dqh));
            } else {
                this.dqf.mNegativeButton.setTextColor(color2);
            }
            this.dqf.mNeutralButton.setTextColor(color2);
            int color6 = this.dqf.dqn != -1 ? getAlertDialogResources().getColor(this.dqf.dqn) : color5;
            this.dqf.mDivider2.setBackgroundColor(color6);
            this.dqf.mDivider3.setBackgroundColor(color6);
            this.dqf.mDivider4.setBackgroundColor(color6);
            this.dqf.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.dqf.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.dqf.mNeutralButton.setBackground(getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(this.dqf.dqo ? getAlertDialogResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a gx(boolean z) {
            this.dqf.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public a gy(boolean z) {
            this.dqf.dqo = z;
            return this;
        }

        public a gz(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.dqf.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a jX(int i) {
            return jY(getAlertDialogResources().getColor(i));
        }

        public a U(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jY(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jX(i);
            }
            return this;
        }

        public a jY(int i) {
            this.dqf.mPositiveBtnTextColor = i;
            this.dqf.mPositiveButton.setTextColor(i);
            return this;
        }

        public a jZ(int i) {
            return kb(this.mContext.getResources().getColor(i));
        }

        public a ka(int i) {
            this.dqf.dqh = i;
            return this;
        }

        public a V(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    kb(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                    if (g.DEBUG) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            if (i > 0) {
                jZ(i);
            }
            return this;
        }

        public a kb(int i) {
            this.dqf.mNegativeBtnTextColor = i;
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.dqf.mDialogContent;
        }

        public a n(int i, int i2, int i3, int i4) {
            this.dqf.dqk.setPadding(i, i2, i3, i4);
            return this;
        }

        public a kc(int i) {
            this.dqf.dqm = i;
            this.dqf.mDialogLayout.setBackgroundResource(i);
            return this;
        }

        public a kd(int i) {
            this.dqf.dqn = i;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public SwanAppScrollView dlV;
        public c dqi;
        public FrameLayout dqj;
        public FrameLayout dqk;
        public View dql;
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
        public int dqh = -1;
        public int dqm = -1;
        public int dqn = -1;
        public boolean dqo = true;

        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.dqk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
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
            this.dlV = (SwanAppScrollView) viewGroup.findViewById(a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dqj = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dql = viewGroup.findViewById(a.f.nightmode_mask);
            if (com.baidu.swan.apps.ap.c.isGingerbread() || com.baidu.swan.apps.ap.c.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.mRoot.getResources().getColor(a.c.aiapps_dialog_btn_text_color);
            this.mPositiveBtnTextColor = color;
            this.mNegativeBtnTextColor = color;
        }

        public void setMessageMaxHeight(int i) {
            this.dlV.setMaxHeight(i);
        }
    }
}
