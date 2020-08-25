package com.baidu.live.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class BdAlertDialog {
    public static final int DIALOG_SIZE_BIG = 1;
    public static final int DIALOG_SIZE_SMALL = 0;
    private View bdDialog_divider_line;
    private View dividerWithButton;
    protected final Activity mActivity;
    private DialogInterface.OnCancelListener mCancelListenr;
    private View mContentView;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mDismissListener;
    private String mMessage;
    private ColorStateList mNagetiveButtonColorStateList;
    private OnClickListener mNegativeButtonListener;
    private String mNegativeButtonTip;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private ColorStateList mPositiveButtonColorStateList;
    private OnClickListener mPositiveButtonListener;
    private String mPositiveButtonTip;
    private ViewGroup mRealView;
    private final ViewGroup mRootView;
    private String mTitle;
    private TextView noButton;
    private TextView yesButton;
    private Object yesTag;
    private int mDialogGravity = -1;
    private boolean isOnlyMessageShowCenter = true;
    private boolean isMessageShowCenter = false;
    private boolean isTitleShowCenter = false;
    private int mButtonTextColor = -1;
    private int mPositiveButtonTextColor = -1;
    private int mNagetiveButtonTextColor = -1;
    private int dialogSize = 0;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private boolean mCancelable = true;
    private int messageTextColor = -1;
    private boolean isAutoNight = true;

    /* loaded from: classes7.dex */
    public interface OnClickListener {
        void onClick(BdAlertDialog bdAlertDialog);
    }

    public BdAlertDialog setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public BdAlertDialog setTitle(int i) {
        setTitle(this.mActivity.getResources().getString(i));
        return this;
    }

    public BdAlertDialog setMessage(String str) {
        this.mMessage = str;
        return this;
    }

    public BdAlertDialog setContentView(View view) {
        this.mContentView = view;
        return this;
    }

    public BdAlertDialog setOnCalcelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mCancelListenr = onCancelListener;
        return this;
    }

    public BdAlertDialog setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    public BdAlertDialog setPositiveButton(String str, OnClickListener onClickListener) {
        this.mPositiveButtonTip = str;
        this.mPositiveButtonListener = onClickListener;
        return this;
    }

    public BdAlertDialog setPositiveButton(int i, OnClickListener onClickListener) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.mPositiveButtonListener = onClickListener;
        }
        return this;
    }

    public BdAlertDialog setNegativeButton(String str, OnClickListener onClickListener) {
        this.mNegativeButtonTip = str;
        this.mNegativeButtonListener = onClickListener;
        return this;
    }

    public BdAlertDialog setNegativeButton(int i, OnClickListener onClickListener) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.mNegativeButtonListener = onClickListener;
        }
        return this;
    }

    public BdAlertDialog setContentViewId(int i) {
        if (this.mActivity != null) {
            this.mContentView = LayoutInflater.from(this.mActivity).inflate(i, (ViewGroup) null);
        }
        return this;
    }

    public BdAlertDialog setMessageId(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public BdAlertDialog setMessageId(int i, Object... objArr) {
        if (this.mActivity != null) {
            if (objArr != null && objArr.length > 0) {
                this.mMessage = this.mActivity.getResources().getString(i, objArr);
            } else {
                this.mMessage = this.mActivity.getResources().getString(i);
            }
        }
        return this;
    }

    public BdAlertDialog setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public BdAlertDialog setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public BdAlertDialog(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.h.sdk_dialog_bdalert, (ViewGroup) null);
        this.mRealView = (ViewGroup) this.mRootView.findViewById(a.g.real_view);
    }

    public BdAlertDialog setGravity(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public BdAlertDialog setButtonTextColor(int i) {
        if (isAutoNight()) {
            this.mButtonTextColor = SkinManager.getColor(i);
        } else {
            this.mButtonTextColor = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public BdAlertDialog setPositiveButtonTextColor(int i) {
        this.mPositiveButtonTextColor = i;
        return this;
    }

    public BdAlertDialog setPositiveButtonTextColor(ColorStateList colorStateList) {
        this.mPositiveButtonColorStateList = colorStateList;
        return this;
    }

    public BdAlertDialog setNagetiveButtonTextColor(int i) {
        this.mNagetiveButtonTextColor = i;
        return this;
    }

    public BdAlertDialog setNagetiveButtonTextColor(ColorStateList colorStateList) {
        this.mNagetiveButtonColorStateList = colorStateList;
        return this;
    }

    public BdAlertDialog setContentViewSize(int i) {
        this.dialogSize = i;
        return this;
    }

    public BdAlertDialog create(BdPageContext<?> bdPageContext) {
        boolean z;
        boolean z2 = true;
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(a.g.dialog_content);
            this.yesButton = (TextView) this.mRootView.findViewById(a.g.yes);
            this.noButton = (TextView) this.mRootView.findViewById(a.g.no);
            this.dividerWithButton = this.mRootView.findViewById(a.g.divider_yes_no_button);
            this.bdDialog_divider_line = this.mRootView.findViewById(a.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                if (this.mContentView.getParent() != null) {
                    if (this.mContentView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                        linearLayout.addView(this.mContentView);
                    }
                } else {
                    linearLayout.addView(this.mContentView);
                }
            } else {
                View isShowTitleAndMessage = isShowTitleAndMessage();
                if (isShowTitleAndMessage != null) {
                    linearLayout.removeAllViews();
                    if (isShowTitleAndMessage.getParent() != null) {
                        if (isShowTitleAndMessage.getParent() instanceof ViewGroup) {
                            ((ViewGroup) isShowTitleAndMessage.getParent()).removeView(isShowTitleAndMessage);
                            linearLayout.addView(isShowTitleAndMessage);
                        }
                    } else {
                        linearLayout.addView(isShowTitleAndMessage);
                    }
                }
            }
            autoChangeSkinType(bdPageContext);
            if (this.mButtonTextColor != -1) {
                if (this.yesButton != null) {
                    this.yesButton.setTextColor(this.mButtonTextColor);
                }
                if (this.noButton != null) {
                    this.noButton.setTextColor(this.mButtonTextColor);
                }
            } else {
                if (this.yesButton != null) {
                    if (this.mPositiveButtonTextColor != -1) {
                        this.yesButton.setTextColor(this.mPositiveButtonTextColor);
                    } else if (this.mPositiveButtonColorStateList != null) {
                        this.yesButton.setTextColor(this.mPositiveButtonColorStateList);
                    }
                }
                if (this.noButton != null) {
                    if (this.mNagetiveButtonTextColor != -1) {
                        this.noButton.setTextColor(this.mNagetiveButtonTextColor);
                    } else if (this.mNagetiveButtonColorStateList != null) {
                        this.noButton.setTextColor(this.mNagetiveButtonColorStateList);
                    }
                }
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip) || this.yesButton == null) {
                z = false;
            } else {
                this.yesButton.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                if (this.mPositiveButtonListener != null) {
                    this.yesButton.setOnClickListener(new ButtonEvent(this, this.mPositiveButtonListener));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip) || this.noButton == null) {
                z2 = false;
            } else {
                this.noButton.setText(this.mNegativeButtonTip);
                if (this.mNegativeButtonListener != null) {
                    this.noButton.setOnClickListener(new ButtonEvent(this, this.mNegativeButtonListener));
                }
            }
            mouldButtons(z, z2);
        }
        return this;
    }

    public View isShowTitleAndMessage() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(a.h.sdk_bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(a.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(a.g.message_view);
                if (this.isMessageShowCenter) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.isTitleShowCenter) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                if (this.messageTextColor != -1) {
                    textView2.setTextColor(this.messageTextColor);
                    return linearLayout;
                }
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(a.h.sdk_bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(a.g.message_view);
            if (this.messageTextColor != -1) {
                textView3.setTextColor(this.messageTextColor);
            }
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            if (this.isOnlyMessageShowCenter) {
                textView3.setGravity(17);
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void setMessageTextColor(int i) {
        this.messageTextColor = i;
    }

    public void autoChangeSkinType(BdPageContext<?> bdPageContext) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (bdPageContext instanceof TbPageContext) {
            ((TbPageContext) bdPageContext).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) bdPageContext).getLayoutMode().onModeChanged(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) bdPageContext).getLayoutMode().onModeChanged(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(a.f.sdk_transparent_bg);
        }
    }

    private void mouldButtons(boolean z, boolean z2) {
        if (z && z2) {
            if (this.dividerWithButton != null) {
                this.dividerWithButton.setVisibility(0);
            }
            if (this.bdDialog_divider_line != null) {
                this.bdDialog_divider_line.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (this.dividerWithButton != null) {
            this.dividerWithButton.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.yesButton != null && this.noButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                this.yesButton.setVisibility(8);
                this.noButton.setVisibility(8);
                this.dividerWithButton.setVisibility(8);
                this.bdDialog_divider_line.setVisibility(8);
            }
        } else if (z) {
            SkinManager.setBackgroundResource(this.yesButton, a.f.sdk_dialog_single_button_bg_selector, skinType);
            if (this.noButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                this.bdDialog_divider_line.setVisibility(0);
                this.yesButton.setVisibility(0);
                this.noButton.setVisibility(8);
            }
        } else if (z2) {
            SkinManager.setBackgroundResource(this.noButton, a.f.sdk_dialog_single_button_bg_selector, skinType);
            if (this.yesButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                this.bdDialog_divider_line.setVisibility(0);
                this.noButton.setVisibility(0);
                this.yesButton.setVisibility(8);
            }
        } else if (this.yesButton != null && this.noButton != null && this.bdDialog_divider_line != null) {
            this.bdDialog_divider_line.setVisibility(8);
            this.yesButton.setVisibility(8);
            this.noButton.setVisibility(8);
        }
    }

    public BdAlertDialog showNoCheck() {
        return show(false);
    }

    private BdAlertDialog show(boolean z) {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        ShowUtil.windowCount++;
        if (this.mDialog != null) {
            if (z) {
                ShowUtil.showDialog(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            if (this.mCancelListenr != null) {
                this.mDialog.setOnCancelListener(this.mCancelListenr);
            }
            if (this.mDismissListener != null) {
                this.mDialog.setOnDismissListener(this.mDismissListener);
            }
            if (z) {
                ShowUtil.showDialog(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                window.setGravity(this.mDialogGravity);
                window.setWindowAnimations(a.j.sdk_dialog_windowanim);
                window.setBackgroundDrawableResource(a.f.sdk_transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.65f;
                attributes.width = -1;
                DisplayMetrics screenSize = BdUtilHelper.getScreenSize(this.mActivity);
                if (screenSize != null) {
                    int dialogMargin = getDialogMargin();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = screenSize.heightPixels - (dialogMargin * 2);
                    } else {
                        attributes.width = screenSize.widthPixels - (dialogMargin * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.mRootView, false, new ViewHelper.ViewCallback() { // from class: com.baidu.live.tbadk.core.dialog.BdAlertDialog.1
                    @Override // com.baidu.live.tbadk.core.util.ViewHelper.ViewCallback
                    public boolean onViewFound(View view) {
                        if (view instanceof EditText) {
                            atomicBoolean.set(true);
                            return true;
                        }
                        return false;
                    }
                });
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
            }
        }
        return this;
    }

    public BdAlertDialog show() {
        return show(true);
    }

    public int getDialogMargin() {
        if (this.dialogSize == 1) {
            return BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds40);
        }
        return (int) (BdUtilHelper.getEquipmentWidth(this.mActivity) * 0.09f);
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public void setYesBtnClickable(boolean z) {
        if (this.yesButton != null) {
            this.yesButton.setClickable(z);
        }
    }

    public void setNoBtnClickable(boolean z) {
        if (this.noButton != null) {
            this.noButton.setClickable(z);
        }
    }

    public void hide() {
        if (this.mDialog != null) {
            this.mDialog.hide();
        }
    }

    public void dismiss() {
        if (this.mDialog != null) {
            ShowUtil.dismissDialog(this.mDialog, this.mActivity);
            if (ShowUtil.windowCount > 0) {
                ShowUtil.windowCount--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class ButtonEvent implements View.OnClickListener {
        private final OnClickListener listener;
        private final BdAlertDialog mDialog;

        public ButtonEvent(BdAlertDialog bdAlertDialog, OnClickListener onClickListener) {
            this.mDialog = bdAlertDialog;
            this.listener = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.listener != null) {
                this.listener.onClick(this.mDialog);
            }
        }
    }

    public ViewGroup getRealView() {
        return this.mRealView;
    }

    public void setRealView(ViewGroup viewGroup) {
        this.mRealView = viewGroup;
    }

    public void setYesButtonTag(Object obj) {
        this.yesTag = obj;
    }

    public Object getYesButtonTag() {
        return this.yesTag;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.mDialog.getWindow();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public void setOnlyMessageShowCenter(boolean z) {
        this.isOnlyMessageShowCenter = z;
    }

    public void setMessageShowCenter(boolean z) {
        this.isMessageShowCenter = z;
    }

    public void setTitleShowCenter(boolean z) {
        this.isTitleShowCenter = z;
    }

    public DialogInterface.OnKeyListener getOnKeyListener() {
        return this.mOnKeyListener;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void reset() {
        this.mDialogCreated = false;
    }
}
