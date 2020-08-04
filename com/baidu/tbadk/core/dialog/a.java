package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private TextView aRC;
    private View bdDialog_divider_line;
    private TextView dVA;
    private ImageView dVB;
    private TextView dVC;
    private c dVE;
    private b dVv;
    private b dVw;
    private b dVx;
    private Button dVy;
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
    private int dVu = -1;
    private int dialogSize = 0;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;
    private boolean dVz = false;
    private boolean dVD = false;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aYM();
    }

    public a xk(String str) {
        this.mTitle = str;
        return this;
    }

    public a lm(int i) {
        xk(this.mActivity.getResources().getString(i));
        return this;
    }

    public a xl(String str) {
        this.mMessage = str;
        return this;
    }

    public a aV(View view) {
        this.mContentView = view;
        return this;
    }

    public a c(DialogInterface.OnCancelListener onCancelListener) {
        this.mCancelListenr = onCancelListener;
        return this;
    }

    public a b(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.mPositiveButtonTip = str;
        this.dVv = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.mNegativeButtonTip = str;
        this.dVw = bVar;
        return this;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.dVx = bVar;
        }
        return this;
    }

    public a ln(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.dVv = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.dVw = bVar;
        }
        return this;
    }

    public a hJ(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a hK(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.mRealView = (ViewGroup) this.mRootView.findViewById(R.id.real_view);
    }

    public a lo(int i) {
        if (isAutoNight()) {
            this.mButtonTextColor = ao.getColor(i);
        } else {
            this.mButtonTextColor = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a lp(int i) {
        if (isAutoNight()) {
            this.dVu = ao.getColor(i);
        } else {
            this.dVu = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a lq(int i) {
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
            this.dVy = (Button) this.mRootView.findViewById(R.id.close_btn);
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
                View aYH = this.dVz ? aYH() : isShowTitleAndMessage();
                if (aYH != null) {
                    linearLayout.removeAllViews();
                    if (aYH.getParent() != null) {
                        if (aYH.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aYH.getParent()).removeView(aYH);
                            linearLayout.addView(aYH);
                        }
                    } else {
                        linearLayout.addView(aYH);
                    }
                }
            }
            c(eVar);
            if (this.dVx != null) {
                this.dVy.setVisibility(0);
                this.dVy.setOnClickListener(new View$OnClickListenerC0491a(this, this.dVx));
                ao.setBackgroundResource(this.dVy, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.mButtonTextColor != -1) {
                if (this.yesButton != null) {
                    this.yesButton.setTextColor(this.mButtonTextColor);
                }
                if (this.noButton != null) {
                    this.noButton.setTextColor(this.mButtonTextColor);
                }
            }
            if (this.dVu != -1 && this.noButton != null) {
                this.noButton.setTextColor(this.dVu);
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip) || this.yesButton == null) {
                z = false;
            } else {
                this.yesButton.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                if (this.dVv != null) {
                    this.yesButton.setOnClickListener(new View$OnClickListenerC0491a(this, this.dVv));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip) || this.noButton == null) {
                z2 = false;
            } else {
                this.noButton.setText(this.mNegativeButtonTip);
                if (this.dVw != null) {
                    this.noButton.setOnClickListener(new View$OnClickListenerC0491a(this, this.dVw));
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

    public View aYH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_content_with_no_tip_again, (ViewGroup) null);
        this.aRC = (TextView) inflate.findViewById(R.id.title);
        this.aRC.setText(this.mTitle);
        this.dVA = (TextView) inflate.findViewById(R.id.intro);
        this.dVA.setText(this.mMessage);
        this.dVC = (TextView) inflate.findViewById(R.id.no_tip_again_text);
        this.dVB = (ImageView) inflate.findViewById(R.id.checkbox);
        aYI();
        this.dVB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dVD = !a.this.dVD;
                a.this.aYI();
                if (a.this.dVE != null) {
                    a.this.dVE.aYM();
                }
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        Drawable a;
        if (this.dVB != null) {
            ImageView imageView = this.dVB;
            if (this.dVD) {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.baR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public boolean aYJ() {
        return this.dVD;
    }

    private void aYK() {
        ao.setViewTextColor(this.aRC, R.color.cp_cont_b);
        ao.setViewTextColor(this.dVA, R.color.cp_cont_j);
        aYI();
        ao.setViewTextColor(this.dVC, R.color.cp_cont_j);
    }

    public void c(@Nullable com.baidu.adp.base.e<?> eVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().dLp = isAutoNight() ? false : true;
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
            ao.setBackgroundResource(this.mRealView, R.drawable.dialog_background, skinType);
        }
        aYK();
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
            ao.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector, skinType);
            if (this.noButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                this.bdDialog_divider_line.setVisibility(0);
                this.yesButton.setVisibility(0);
                this.noButton.setVisibility(8);
            }
        } else if (z2) {
            ao.setBackgroundResource(this.noButton, R.drawable.dialog_single_button_bg_selector, skinType);
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

    private a hL(boolean z) {
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
                bf.a(this.mRootView, false, new bf.a() { // from class: com.baidu.tbadk.core.dialog.a.2
                    @Override // com.baidu.tbadk.core.util.bf.a
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

    public a aYL() {
        return hL(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0491a implements View.OnClickListener {
        private final a ZV;
        private final b dVG;

        public View$OnClickListenerC0491a(a aVar, b bVar) {
            this.ZV = aVar;
            this.dVG = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dVG != null) {
                this.dVG.onClick(this.ZV);
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

    public void hM(boolean z) {
        this.dVz = z;
    }
}
