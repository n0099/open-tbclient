package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.ui.AlignTextView;
/* loaded from: classes20.dex */
public class BoxAlertDialog extends BaseDialog {
    private static final boolean DEBUG = false;
    public static final int HUNDRED = 100;
    private Builder mBuilder;

    /* loaded from: classes20.dex */
    public interface IDecorate {
        void decorate(BoxAlertDialog boxAlertDialog, DialogElement dialogElement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BoxAlertDialog(Context context) {
        super(context);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BoxAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BoxAlertDialog(Context context, int i) {
        super(context, i);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onButtonClick(int i) {
    }

    protected void init() {
        setContentView(R.layout.custom_dialog_layout);
        getWindow().setLayout(-1, -1);
    }

    public Builder getBuilder() {
        return this.mBuilder;
    }

    void setBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    public void setMessage(String str) {
        if (this.mBuilder != null) {
            this.mBuilder.setMessage(str);
        }
    }

    /* loaded from: classes20.dex */
    public static class Builder {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = R.string.dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = R.string.dialog_positive_title_ok;
        protected int mBtnHeight;
        private Context mContext;
        protected final BoxAlertDialog mDialog;
        protected final DialogElement mDialogElement;
        private boolean mSystemDialog = false;

        public Builder(Context context) {
            this.mDialog = onCreateDialog(context);
            this.mDialog.setBuilder(this);
            this.mDialogElement = new DialogElement((ViewGroup) this.mDialog.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.dialog_btns_height);
        }

        protected BoxAlertDialog onCreateDialog(Context context) {
            return new BoxAlertDialog(context, R.style.NoTitleDialog);
        }

        public Builder setTitle(int i) {
            this.mDialogElement.mTitle.setText(this.mContext.getText(i));
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.mDialogElement.mTitle.setText(charSequence);
            } else {
                hideTitle(true);
            }
            return this;
        }

        public Builder setTitle(CharSequence charSequence, TextView.BufferType bufferType) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.mDialogElement.mTitle.setText(charSequence, bufferType);
            } else {
                hideTitle(true);
            }
            return this;
        }

        public Builder setTitleColor(int i) {
            if (i != -1) {
                this.mDialogElement.mTitle.setTextColor(i);
            }
            return this;
        }

        public Builder hideTitle(boolean z) {
            this.mDialogElement.mTitlePanel.setVisibility(z ? 8 : 0);
            return this;
        }

        public Builder setSystemDialog(boolean z) {
            this.mSystemDialog = z;
            return this;
        }

        public Builder setMessage(int i) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            this.mDialogElement.mMessage.setText(this.mContext.getText(i));
            setMsgContentParams();
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            if (charSequence != null) {
                this.mDialogElement.mMessage.setText(charSequence);
                setMsgContentParams();
            }
            return this;
        }

        public Builder setMessage(String str) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            if (str != null) {
                this.mDialogElement.mMessage.setText(str);
                setMsgContentParams();
            }
            return this;
        }

        public Builder setMessage(Spanned spanned) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            if (spanned != null) {
                this.mDialogElement.mMessage.setText(spanned);
                setMsgContentParams();
            }
            return this;
        }

        public Builder setMessageAlign(AlignTextView.Align align) {
            if (align != null && (this.mDialogElement.mMessage instanceof AlignTextView)) {
                ((AlignTextView) this.mDialogElement.mMessage).setAlign(align);
            }
            return this;
        }

        private void setMsgContentParams() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, R.id.dialog_message_content);
            this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
        }

        public Builder setMessageHeightResId(int i) {
            this.mDialogElement.mScrollView.getLayoutParams().height = this.mContext.getResources().getDimensionPixelSize(i);
            return this;
        }

        public Builder setMessageHeight(int i) {
            this.mDialogElement.mScrollView.getLayoutParams().height = i;
            return this;
        }

        public Builder setMessageMaxHeightResId(int i) {
            this.mDialogElement.setMessageMaxHeight(this.mContext.getResources().getDimensionPixelSize(i));
            return this;
        }

        public Builder setMessageMaxHeight(int i) {
            this.mDialogElement.setMessageMaxHeight(i);
            return this;
        }

        public boolean hasPositiveButton() {
            return this.mDialogElement.mPositiveButton != null && this.mDialogElement.mPositiveButton.getVisibility() == 0;
        }

        public TextView ifOnlyOneBtnGetIt() {
            int i;
            TextView textView;
            if (this.mDialogElement.mPositiveButton == null || this.mDialogElement.mPositiveButton.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.mDialogElement.mPositiveButton;
                i = 1;
            }
            if (this.mDialogElement.mNegativeButton != null && this.mDialogElement.mNegativeButton.getVisibility() == 0) {
                i++;
                textView = this.mDialogElement.mNegativeButton;
            }
            if (this.mDialogElement.mNeutralButton != null && this.mDialogElement.mNeutralButton.getVisibility() == 0) {
                i++;
                textView = this.mDialogElement.mNeutralButton;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            return setPositiveButton(this.mContext.getText(i), onClickListener);
        }

        public Builder setPositiveButton(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mDialogElement.mPositiveButton.setVisibility(8);
                if (this.mDialogElement.mNegativeButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(8);
                }
            } else {
                this.mDialogElement.mPositiveButton.setVisibility(0);
                if (this.mDialogElement.mNegativeButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(0);
                }
                this.mDialogElement.mPositiveButton.setText(charSequence);
                this.mDialogElement.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Builder.this.mDialog.onButtonClick(-1);
                        Builder.this.mDialog.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(Builder.this.mDialog, -1);
                        }
                    }
                });
            }
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            return setNegativeButton(this.mContext.getText(i), onClickListener);
        }

        public Builder setNegativeButton(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mDialogElement.mNegativeButton.setVisibility(8);
                if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(8);
                }
            } else {
                this.mDialogElement.mNegativeButton.setVisibility(0);
                if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(0);
                }
                this.mDialogElement.mNegativeButton.setText(charSequence);
                this.mDialogElement.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Builder.this.mDialog.onButtonClick(-2);
                        Builder.this.mDialog.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(Builder.this.mDialog, -2);
                        }
                    }
                });
            }
            return this;
        }

        public void setDividerVisible(boolean z) {
            if (z) {
                this.mDialogElement.mDivider2.setVisibility(0);
            } else {
                this.mDialogElement.mDivider2.setVisibility(8);
            }
        }

        public boolean hasNegativeButton() {
            return this.mDialogElement.mNegativeButton != null && this.mDialogElement.mNegativeButton.getVisibility() == 0;
        }

        public boolean hasNeutralButton() {
            return this.mDialogElement.mNeutralButton != null && this.mDialogElement.mNeutralButton.getVisibility() == 0;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            return setNeutralButton(this.mContext.getText(i), onClickListener);
        }

        public Builder setNeutralButton(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.mDialogElement.mNeutralButton.setVisibility(0);
            if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                this.mDialogElement.mDivider4.setVisibility(0);
            }
            this.mDialogElement.mNeutralButton.setText(charSequence);
            this.mDialogElement.mNeutralButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.mDialog.onButtonClick(-3);
                    Builder.this.mDialog.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -3);
                    }
                }
            });
            return this;
        }

        public Builder setIcon(int i) {
            this.mDialogElement.mIcon.setImageResource(i);
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mDialogElement.mIcon.setImageDrawable(drawable);
            return this;
        }

        public Builder setView(View view) {
            this.mDialogElement.mDialogContent.removeAllViews();
            this.mDialogElement.mDialogContent.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, R.id.dialog_customPanel);
            this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.mDialogElement.mDialogContent.removeAllViews();
            this.mDialogElement.mDialogContent.addView(view);
            this.mDialogElement.mDialogContent.setPadding(i, i2, i3, i4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, R.id.dialog_customPanel);
            this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
            return this;
        }

        public Builder clearViewTopMargin() {
            ((ViewGroup.MarginLayoutParams) this.mDialogElement.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mDialogElement.mCancelable = Boolean.valueOf(z);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mDialogElement.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mDialogElement.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.mDialogElement.mOnShowListener = onShowListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.mDialogElement.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setDecorate(IDecorate iDecorate) {
            this.mDialogElement.mDecorate = iDecorate;
            return this;
        }

        public BoxAlertDialog create() {
            this.mDialog.setCancelable(this.mDialogElement.mCancelable.booleanValue());
            if (this.mDialogElement.mCancelable.booleanValue()) {
                this.mDialog.setCanceledOnTouchOutside(false);
            }
            this.mDialog.setOnCancelListener(this.mDialogElement.mOnCancelListener);
            this.mDialog.setOnDismissListener(this.mDialogElement.mOnDismissListener);
            this.mDialog.setOnShowListener(this.mDialogElement.mOnShowListener);
            if (this.mDialogElement.mOnKeyListener != null) {
                this.mDialog.setOnKeyListener(this.mDialogElement.mOnKeyListener);
            }
            updateDialogUI();
            if (this.mDialogElement.mDecorate != null) {
                this.mDialogElement.mDecorate.decorate(this.mDialog, this.mDialogElement);
            }
            this.mDialog.setBuilder(this);
            return this.mDialog;
        }

        @Deprecated
        public BoxAlertDialog show(boolean z) {
            return show();
        }

        public BoxAlertDialog show() {
            BoxAlertDialog create = create();
            if (this.mSystemDialog) {
                create.getWindow().setType(2003);
            }
            try {
                create.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return create;
        }

        protected Resources getAlertDialogResources() {
            return this.mContext.getResources();
        }

        private void updateDialogUI() {
            int color = getAlertDialogResources().getColor(R.color.dialog_title_text_color);
            int color2 = getAlertDialogResources().getColor(R.color.dialog_btn_text_color);
            int color3 = getAlertDialogResources().getColor(R.color.dialog_btn_text_color);
            int color4 = getAlertDialogResources().getColor(R.color.box_dialog_message_text_color);
            int color5 = getAlertDialogResources().getColor(R.color.dialog_gray);
            this.mDialogElement.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(R.drawable.custom_dialog_corner_bg));
            this.mDialogElement.mTitle.setTextColor(color);
            this.mDialogElement.mMessage.setTextColor(color4);
            TextView textView = this.mDialogElement.mPositiveButton;
            if (this.mDialogElement.mPositiveBtnTextColor != -1) {
                color3 = this.mDialogElement.mPositiveBtnTextColor;
            }
            textView.setTextColor(color3);
            this.mDialogElement.mNegativeButton.setTextColor(this.mDialogElement.mNegativeBtnTextColor != -1 ? this.mDialogElement.mNegativeBtnTextColor : color2);
            this.mDialogElement.mNeutralButton.setTextColor(color2);
            this.mDialogElement.mDivider2.setBackgroundColor(color5);
            this.mDialogElement.mDivider3.setBackgroundColor(color5);
            this.mDialogElement.mDivider4.setBackgroundColor(color5);
            this.mDialogElement.mPositiveButton.setBackground(getAlertDialogResources().getDrawable(R.drawable.custom_dialog_btn_right_corner_bg_selector));
            this.mDialogElement.mNegativeButton.setBackground(getAlertDialogResources().getDrawable(R.drawable.custom_dialog_btn_left_corner_bg_selector));
            this.mDialogElement.mNeutralButton.setBackgroundColor(getAlertDialogResources().getColor(R.color.custom_dialog_btn_bg_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(getAlertDialogResources().getDrawable(R.drawable.custom_dialog_btn_corner_bg_selector));
            }
        }

        public void setPositiveBtnText(String str) {
            this.mDialogElement.mPositiveButton.setText(str);
        }

        public void setPositiveEnable(boolean z) {
            this.mDialogElement.mPositiveButton.setEnabled(z);
        }

        public Builder setBtnsVersible(boolean z) {
            this.mDialogElement.mBtnPanelLayout.setVisibility(z ? 0 : 8);
            return this;
        }

        public Builder removeCustomPanelMargin(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.mDialogElement.mCustomPanel.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(R.dimen.dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public Builder setPositiveTextColor(int i) {
            return setPositiveTextColorValue(getAlertDialogResources().getColor(i));
        }

        public Builder setPositiveTextColor(String str) {
            return setPositiveTextColor(str, -1);
        }

        public Builder setPositiveTextColor(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    setPositiveTextColorValue(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                }
                return this;
            }
            if (i > 0) {
                setPositiveTextColor(i);
            }
            return this;
        }

        public Builder setPositiveTextColorValue(int i) {
            this.mDialogElement.mPositiveBtnTextColor = i;
            this.mDialogElement.mPositiveButton.setTextColor(i);
            return this;
        }

        public Builder setNegativeTextColor(int i) {
            return setNegativeTextColorValue(this.mContext.getResources().getColor(i));
        }

        public Builder setNegativeTextColor(String str) {
            return setNegativeTextColor(str, -1);
        }

        public Builder setNegativeTextColor(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    setNegativeTextColorValue(Color.parseColor(str));
                } catch (IllegalArgumentException e) {
                }
                return this;
            }
            if (i > 0) {
                setNegativeTextColor(i);
            }
            return this;
        }

        public Builder setNegativeTextColorValue(int i) {
            this.mDialogElement.mNegativeBtnTextColor = i;
            this.mDialogElement.mNegativeButton.setTextColor(i);
            return this;
        }

        public ViewGroup getCustomContentParent() {
            return this.mDialogElement.mDialogContent;
        }
    }

    /* loaded from: classes20.dex */
    public static class DialogElement {
        public LinearLayout mBtnPanelLayout;
        public View mCustomPanel;
        public IDecorate mDecorate;
        public FrameLayout mDialogContent;
        public View mDialogContentPanel;
        public RelativeLayout mDialogLayout;
        public View mDivider2;
        public View mDivider3;
        public View mDivider4;
        public ImageView mIcon;
        public TextView mMessage;
        public LinearLayout mMessageContent;
        public TextView mNegativeButton;
        public TextView mNeutralButton;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public DialogInterface.OnShowListener mOnShowListener;
        public TextView mPositiveButton;
        public ViewGroup mRoot;
        public BoxScrollView mScrollView;
        public TextView mTitle;
        public LinearLayout mTitlePanel;
        public Boolean mCancelable = true;
        public int mPositiveBtnTextColor = -1;
        public int mNegativeBtnTextColor = -1;

        public DialogElement(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.mTitlePanel = (LinearLayout) viewGroup.findViewById(R.id.title_panel);
            this.mTitle = (TextView) viewGroup.findViewById(R.id.dialog_title);
            this.mMessage = (TextView) viewGroup.findViewById(R.id.dialog_message);
            this.mMessageContent = (LinearLayout) viewGroup.findViewById(R.id.dialog_message_content);
            this.mPositiveButton = (TextView) viewGroup.findViewById(R.id.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(R.id.negative_button);
            this.mNeutralButton = (TextView) viewGroup.findViewById(R.id.neutral_button);
            this.mDivider3 = viewGroup.findViewById(R.id.divider3);
            this.mDivider4 = viewGroup.findViewById(R.id.divider4);
            this.mDialogContentPanel = viewGroup.findViewById(R.id.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(R.id.dialog_custom_content);
            this.mIcon = (ImageView) viewGroup.findViewById(R.id.dialog_icon);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(R.id.searchbox_alert_dialog);
            this.mDivider2 = viewGroup.findViewById(R.id.divider2);
            this.mScrollView = (BoxScrollView) viewGroup.findViewById(R.id.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(R.id.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(R.id.dialog_customPanel);
        }

        public void setMessageMaxHeight(int i) {
            this.mScrollView.setMaxHeight(i);
        }
    }
}
