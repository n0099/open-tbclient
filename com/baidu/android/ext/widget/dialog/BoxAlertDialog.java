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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.AlignTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BoxAlertDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int HUNDRED = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public Builder mBuilder;

    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL;
        public static final int DIALOG_POSITIVE_TEXT_OK;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBtnHeight;
        public Context mContext;
        public final BoxAlertDialog mDialog;
        public final DialogElement mDialogElement;
        public boolean mSystemDialog;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2018612307, "Lcom/baidu/android/ext/widget/dialog/BoxAlertDialog$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2018612307, "Lcom/baidu/android/ext/widget/dialog/BoxAlertDialog$Builder;");
                    return;
                }
            }
            DIALOG_NEGATIVE_TEXT_CANCEL = R.string.dialog_negative_title_cancel;
            DIALOG_POSITIVE_TEXT_OK = R.string.dialog_positive_title_ok;
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mSystemDialog = false;
            BoxAlertDialog onCreateDialog = onCreateDialog(context);
            this.mDialog = onCreateDialog;
            onCreateDialog.setBuilder(this);
            this.mDialogElement = new DialogElement((ViewGroup) this.mDialog.getWindow().getDecorView());
            this.mContext = context;
            this.mBtnHeight = context.getResources().getDimensionPixelSize(R.dimen.dialog_btns_height);
        }

        private void setMsgContentParams() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.dialog_message_content);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
            }
        }

        private void updateDialogUI() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                int color = getAlertDialogResources().getColor(R.color.dialog_title_text_color);
                int color2 = getAlertDialogResources().getColor(R.color.dialog_btn_text_color);
                int color3 = getAlertDialogResources().getColor(R.color.dialog_btn_text_color);
                int color4 = getAlertDialogResources().getColor(R.color.box_dialog_message_text_color);
                int color5 = getAlertDialogResources().getColor(R.color.dialog_gray);
                this.mDialogElement.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(R.drawable.custom_dialog_corner_bg));
                this.mDialogElement.mTitle.setTextColor(color);
                this.mDialogElement.mMessage.setTextColor(color4);
                DialogElement dialogElement = this.mDialogElement;
                TextView textView = dialogElement.mPositiveButton;
                int i2 = dialogElement.mPositiveBtnTextColor;
                if (i2 != -1) {
                    color3 = i2;
                }
                textView.setTextColor(color3);
                DialogElement dialogElement2 = this.mDialogElement;
                TextView textView2 = dialogElement2.mNegativeButton;
                int i3 = dialogElement2.mNegativeBtnTextColor;
                if (i3 == -1) {
                    i3 = color2;
                }
                textView2.setTextColor(i3);
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
        }

        public Builder clearViewTopMargin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ((ViewGroup.MarginLayoutParams) this.mDialogElement.mDialogContentPanel.getLayoutParams()).setMargins(0, 0, 0, 0);
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public BoxAlertDialog create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.mDialog.setCancelable(this.mDialogElement.mCancelable.booleanValue());
                if (this.mDialogElement.mCancelable.booleanValue()) {
                    this.mDialog.setCanceledOnTouchOutside(false);
                }
                this.mDialog.setOnCancelListener(this.mDialogElement.mOnCancelListener);
                this.mDialog.setOnDismissListener(this.mDialogElement.mOnDismissListener);
                this.mDialog.setOnShowListener(this.mDialogElement.mOnShowListener);
                DialogInterface.OnKeyListener onKeyListener = this.mDialogElement.mOnKeyListener;
                if (onKeyListener != null) {
                    this.mDialog.setOnKeyListener(onKeyListener);
                }
                updateDialogUI();
                DialogElement dialogElement = this.mDialogElement;
                IDecorate iDecorate = dialogElement.mDecorate;
                if (iDecorate != null) {
                    iDecorate.decorate(this.mDialog, dialogElement);
                }
                this.mDialog.setBuilder(this);
                return this.mDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public Resources getAlertDialogResources() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mContext.getResources() : (Resources) invokeV.objValue;
        }

        public ViewGroup getCustomContentParent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDialogElement.mDialogContent : (ViewGroup) invokeV.objValue;
        }

        public boolean hasNegativeButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TextView textView = this.mDialogElement.mNegativeButton;
                return textView != null && textView.getVisibility() == 0;
            }
            return invokeV.booleanValue;
        }

        public boolean hasNeutralButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                TextView textView = this.mDialogElement.mNeutralButton;
                return textView != null && textView.getVisibility() == 0;
            }
            return invokeV.booleanValue;
        }

        public boolean hasPositiveButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TextView textView = this.mDialogElement.mPositiveButton;
                return textView != null && textView.getVisibility() == 0;
            }
            return invokeV.booleanValue;
        }

        public Builder hideTitle(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mDialogElement.mTitlePanel.setVisibility(z ? 8 : 0);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public TextView ifOnlyOneBtnGetIt() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                TextView textView2 = this.mDialogElement.mPositiveButton;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.mDialogElement.mPositiveButton;
                    i2 = 1;
                }
                TextView textView3 = this.mDialogElement.mNegativeButton;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.mDialogElement.mNegativeButton;
                }
                TextView textView4 = this.mDialogElement.mNeutralButton;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.mDialogElement.mNeutralButton;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public BoxAlertDialog onCreateDialog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? new BoxAlertDialog(context, R.style.NoTitleDialog) : (BoxAlertDialog) invokeL.objValue;
        }

        public Builder removeCustomPanelMargin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                ViewGroup.LayoutParams layoutParams = this.mDialogElement.mCustomPanel.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.mContext.getResources().getDimensionPixelSize(R.dimen.dialog_content_margin_top), 0, 0);
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setBtnsVersible(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.mDialogElement.mBtnPanelLayout.setVisibility(z ? 0 : 8);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setCancelable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.mDialogElement.mCancelable = Boolean.valueOf(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDecorate(IDecorate iDecorate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, iDecorate)) == null) {
                this.mDialogElement.mDecorate = iDecorate;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void setDividerVisible(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                if (z) {
                    this.mDialogElement.mDivider2.setVisibility(0);
                } else {
                    this.mDialogElement.mDivider2.setVisibility(8);
                }
            }
        }

        public Builder setIcon(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.mDialogElement.mIcon.setImageResource(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                    this.mDialogElement.mMessageContent.setVisibility(0);
                }
                this.mDialogElement.mMessage.setText(this.mContext.getText(i2));
                setMsgContentParams();
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageAlign(AlignTextView.Align align) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, align)) == null) {
                if (align != null) {
                    TextView textView = this.mDialogElement.mMessage;
                    if (textView instanceof AlignTextView) {
                        ((AlignTextView) textView).setAlign(align);
                    }
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessageHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                this.mDialogElement.mScrollView.getLayoutParams().height = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageHeightResId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                this.mDialogElement.mScrollView.getLayoutParams().height = this.mContext.getResources().getDimensionPixelSize(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageMaxHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.mDialogElement.setMessageMaxHeight(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageMaxHeightResId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                this.mDialogElement.setMessageMaxHeight(this.mContext.getResources().getDimensionPixelSize(i2));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeButton(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, onClickListener)) == null) ? setNegativeButton(this.mContext.getText(i2), onClickListener) : (Builder) invokeIL.objValue;
        }

        public Builder setNegativeTextColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? setNegativeTextColorValue(this.mContext.getResources().getColor(i2)) : (Builder) invokeI.objValue;
        }

        public Builder setNegativeTextColorValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                DialogElement dialogElement = this.mDialogElement;
                dialogElement.mNegativeBtnTextColor = i2;
                dialogElement.mNegativeButton.setTextColor(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNeutralButton(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, onClickListener)) == null) ? setNeutralButton(this.mContext.getText(i2), onClickListener) : (Builder) invokeIL.objValue;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, onCancelListener)) == null) {
                this.mDialogElement.mOnCancelListener = onCancelListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, onDismissListener)) == null) {
                this.mDialogElement.mOnDismissListener = onDismissListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, onKeyListener)) == null) {
                this.mDialogElement.mOnKeyListener = onKeyListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, onShowListener)) == null) {
                this.mDialogElement.mOnShowListener = onShowListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void setPositiveBtnText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
                this.mDialogElement.mPositiveButton.setText(str);
            }
        }

        public Builder setPositiveButton(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, onClickListener)) == null) ? setPositiveButton(this.mContext.getText(i2), onClickListener) : (Builder) invokeIL.objValue;
        }

        public void setPositiveEnable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
                this.mDialogElement.mPositiveButton.setEnabled(z);
            }
        }

        public Builder setPositiveTextColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) ? setPositiveTextColorValue(getAlertDialogResources().getColor(i2)) : (Builder) invokeI.objValue;
        }

        public Builder setPositiveTextColorValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
                DialogElement dialogElement = this.mDialogElement;
                dialogElement.mPositiveBtnTextColor = i2;
                dialogElement.mPositiveButton.setTextColor(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSystemDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
                this.mSystemDialog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
                this.mDialogElement.mTitle.setText(this.mContext.getText(i2));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
                if (i2 != -1) {
                    this.mDialogElement.mTitle.setTextColor(i2);
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view)) == null) {
                this.mDialogElement.mDialogContent.removeAllViews();
                this.mDialogElement.mDialogContent.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public BoxAlertDialog show(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) ? show() : (BoxAlertDialog) invokeZ.objValue;
        }

        public Builder setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
                this.mDialogElement.mIcon.setImageDrawable(drawable);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.mDialogElement.mNegativeButton.setVisibility(8);
                    if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                        this.mDialogElement.mDivider3.setVisibility(8);
                    }
                    return this;
                }
                this.mDialogElement.mNegativeButton.setVisibility(0);
                if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(0);
                }
                this.mDialogElement.mNegativeButton.setText(charSequence);
                this.mDialogElement.mNegativeButton.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ DialogInterface.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.mDialog.onButtonClick(-2);
                            this.this$0.mDialog.dismiss();
                            DialogInterface.OnClickListener onClickListener2 = this.val$listener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(this.this$0.mDialog, -2);
                            }
                        }
                    }
                });
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setNegativeTextColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? setNegativeTextColor(str, -1) : (Builder) invokeL.objValue;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, charSequence, onClickListener)) == null) {
                this.mDialogElement.mNeutralButton.setVisibility(0);
                if (this.mDialogElement.mPositiveButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider4.setVisibility(0);
                }
                this.mDialogElement.mNeutralButton.setText(charSequence);
                this.mDialogElement.mNeutralButton.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ DialogInterface.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.mDialog.onButtonClick(-3);
                            this.this$0.mDialog.dismiss();
                            DialogInterface.OnClickListener onClickListener2 = this.val$listener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(this.this$0.mDialog, -3);
                            }
                        }
                    }
                });
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.mDialogElement.mPositiveButton.setVisibility(8);
                    if (this.mDialogElement.mNegativeButton.getVisibility() == 0) {
                        this.mDialogElement.mDivider3.setVisibility(8);
                    }
                    return this;
                }
                this.mDialogElement.mPositiveButton.setVisibility(0);
                if (this.mDialogElement.mNegativeButton.getVisibility() == 0) {
                    this.mDialogElement.mDivider3.setVisibility(0);
                }
                this.mDialogElement.mPositiveButton.setText(charSequence);
                this.mDialogElement.mPositiveButton.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ DialogInterface.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.mDialog.onButtonClick(-1);
                            this.this$0.mDialog.dismiss();
                            DialogInterface.OnClickListener onClickListener2 = this.val$listener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(this.this$0.mDialog, -1);
                            }
                        }
                    }
                });
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveTextColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) ? setPositiveTextColor(str, -1) : (Builder) invokeL.objValue;
        }

        public Builder setTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.mDialogElement.mTitle.setText(charSequence);
                } else {
                    hideTitle(true);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public BoxAlertDialog show() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
                BoxAlertDialog create = create();
                if (this.mSystemDialog) {
                    create.getWindow().setType(2003);
                }
                try {
                    create.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return create;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public Builder setNegativeTextColor(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        setNegativeTextColorValue(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (i2 > 0) {
                    setNegativeTextColor(i2);
                }
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        public Builder setPositiveTextColor(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048620, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        setPositiveTextColorValue(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (i2 > 0) {
                    setPositiveTextColor(i2);
                }
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        public Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, charSequence)) == null) {
                if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                    this.mDialogElement.mMessageContent.setVisibility(0);
                }
                if (charSequence != null) {
                    this.mDialogElement.mMessage.setText(charSequence);
                    setMsgContentParams();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(CharSequence charSequence, TextView.BufferType bufferType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, charSequence, bufferType)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.mDialogElement.mTitle.setText(charSequence, bufferType);
                } else {
                    hideTitle(true);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setView(View view, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                this.mDialogElement.mDialogContent.removeAllViews();
                this.mDialogElement.mDialogContent.addView(view);
                this.mDialogElement.mDialogContent.setPadding(i2, i3, i4, i5);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setMessage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                    this.mDialogElement.mMessageContent.setVisibility(0);
                }
                if (str != null) {
                    this.mDialogElement.mMessage.setText(str);
                    setMsgContentParams();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessage(Spanned spanned) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, spanned)) == null) {
                if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                    this.mDialogElement.mMessageContent.setVisibility(0);
                }
                if (spanned != null) {
                    this.mDialogElement.mMessage.setText(spanned);
                    setMsgContentParams();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class DialogElement {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout mBtnPanelLayout;
        public Boolean mCancelable;
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
        public BoxScrollView mScrollView;
        public TextView mTitle;
        public LinearLayout mTitlePanel;

        public DialogElement(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCancelable = Boolean.TRUE;
            this.mPositiveBtnTextColor = -1;
            this.mNegativeBtnTextColor = -1;
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

        public void setMessageMaxHeight(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.mScrollView.setMaxHeight(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface IDecorate {
        void decorate(BoxAlertDialog boxAlertDialog, DialogElement dialogElement);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBuilder : (Builder) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.custom_dialog_layout);
            getWindow().setLayout(-1, -1);
        }
    }

    public void onButtonClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }

    public void setBuilder(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, builder) == null) {
            this.mBuilder = builder;
        }
    }

    public void setMessage(String str) {
        Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (builder = this.mBuilder) == null) {
            return;
        }
        builder.setMessage(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }
}
