package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private View bdDialog_divider_line;
    private b cVj;
    private b cVk;
    private b cVl;
    private Button cVm;
    private View dividerWithButton;
    protected final Activity mActivity;
    private DialogInterface.OnCancelListener mCancelListenr;
    private View mContentView;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mDismissListener;
    private String mMessage;
    private String mNegativeButtonTip;
    private DialogInterface.OnKeyListener mOnKeyListener;
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
    private int cVi = -1;
    private int dialogSize = 0;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a sR(String str) {
        this.mTitle = str;
        return this;
    }

    public a jV(int i) {
        sR(this.mActivity.getResources().getString(i));
        return this;
    }

    public a sS(String str) {
        this.mMessage = str;
        return this;
    }

    public a aO(View view) {
        this.mContentView = view;
        return this;
    }

    public a d(DialogInterface.OnCancelListener onCancelListener) {
        this.mCancelListenr = onCancelListener;
        return this;
    }

    public a c(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.mPositiveButtonTip = str;
        this.cVj = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.mNegativeButtonTip = str;
        this.cVk = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.cVl = bVar;
        }
        return this;
    }

    public a jW(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.cVj = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.cVk = bVar;
        }
        return this;
    }

    public a fH(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a fI(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.mRealView = (ViewGroup) this.mRootView.findViewById(R.id.real_view);
    }

    public a jX(int i) {
        if (isAutoNight()) {
            this.mButtonTextColor = am.getColor(i);
        } else {
            this.mButtonTextColor = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a jY(int i) {
        if (isAutoNight()) {
            this.cVi = am.getColor(i);
        } else {
            this.cVi = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a jZ(int i) {
        this.dialogSize = i;
        return this;
    }

    public a b(@Nullable com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2 = true;
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
            this.yesButton = (TextView) this.mRootView.findViewById(R.id.yes);
            this.noButton = (TextView) this.mRootView.findViewById(R.id.no);
            this.dividerWithButton = this.mRootView.findViewById(R.id.divider_yes_no_button);
            this.bdDialog_divider_line = this.mRootView.findViewById(R.id.bdDialog_divider_line);
            this.cVm = (Button) this.mRootView.findViewById(R.id.close_btn);
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
            c(eVar);
            if (this.cVl != null) {
                this.cVm.setVisibility(0);
                this.cVm.setOnClickListener(new View$OnClickListenerC0376a(this, this.cVl));
                am.setBackgroundResource(this.cVm, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.mButtonTextColor != -1) {
                if (this.yesButton != null) {
                    this.yesButton.setTextColor(this.mButtonTextColor);
                }
                if (this.noButton != null) {
                    this.noButton.setTextColor(this.mButtonTextColor);
                }
            }
            if (this.cVi != -1 && this.noButton != null) {
                this.noButton.setTextColor(this.cVi);
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip) || this.yesButton == null) {
                z = false;
            } else {
                this.yesButton.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                if (this.cVj != null) {
                    this.yesButton.setOnClickListener(new View$OnClickListenerC0376a(this, this.cVj));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip) || this.noButton == null) {
                z2 = false;
            } else {
                this.noButton.setText(this.mNegativeButtonTip);
                if (this.cVk != null) {
                    this.noButton.setOnClickListener(new View$OnClickListenerC0376a(this, this.cVk));
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
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.isMessageShowCenter) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.isTitleShowCenter) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.message_view);
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

    public void c(@Nullable com.baidu.adp.base.e<?> eVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().cLN = isAutoNight() ? false : true;
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
            if (this.mContentView != null) {
                ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mContentView);
            }
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
        }
        if (this.mRealView != null && this.dialogSize == 2) {
            this.mRealView.setBackgroundResource(R.drawable.dialog_private_background);
        } else {
            am.setBackgroundResource(this.mRealView, R.drawable.dialog_background, skinType);
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
            am.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.noButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                this.bdDialog_divider_line.setVisibility(0);
                this.yesButton.setVisibility(0);
                this.noButton.setVisibility(8);
            }
        } else if (z2) {
            am.setBackgroundResource(this.noButton, R.drawable.dialog_single_button_bg_selector, skinType);
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

    private a fJ(boolean z) {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, this.mActivity);
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
                com.baidu.adp.lib.f.g.showDialog(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() != null) {
                Window window = this.mDialog.getWindow();
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                window.setGravity(this.mDialogGravity);
                window.setBackgroundDrawableResource(R.drawable.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics screenSize = com.baidu.adp.lib.util.l.getScreenSize(this.mActivity);
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
                bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tbadk.core.dialog.a.1
                    @Override // com.baidu.tbadk.core.util.bc.a
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

    public int getDialogMargin() {
        int i = R.dimen.tbds0;
        if (this.dialogSize == 0) {
            i = R.dimen.ds90;
        } else if (this.dialogSize == 1) {
            i = R.dimen.ds40;
        } else if (this.dialogSize == 2) {
            i = R.dimen.tbds44;
        } else if (this.dialogSize == 3) {
            i = R.dimen.tbds45;
        }
        return com.baidu.adp.lib.util.l.getDimens(this.mActivity, i);
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

    public a aEG() {
        return fJ(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0376a implements View.OnClickListener {
        private final a FR;
        private final b cVo;

        public View$OnClickListenerC0376a(a aVar, b bVar) {
            this.FR = aVar;
            this.cVo = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.cVo != null) {
                this.cVo.onClick(this.FR);
            }
        }
    }

    public ViewGroup getRealView() {
        return this.mRealView;
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

    public void setOnlyMessageShowCenter(boolean z) {
        this.isOnlyMessageShowCenter = z;
    }

    public void setMessageShowCenter(boolean z) {
        this.isMessageShowCenter = z;
    }

    public void setTitleShowCenter(boolean z) {
        this.isTitleShowCenter = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }
}
