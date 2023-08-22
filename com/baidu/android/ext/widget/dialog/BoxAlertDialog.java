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
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.AlignTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BoxAlertDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int HUNDRED = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public Builder mBuilder;

    /* loaded from: classes.dex */
    public interface IDecorate {
        void decorate(BoxAlertDialog boxAlertDialog, DialogElement dialogElement);
    }

    public void onButtonClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = 2131690902;
        public static final int DIALOG_POSITIVE_TEXT_OK = 2131690906;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBtnHeight;
        public Context mContext;
        public final BoxAlertDialog mDialog;
        public final DialogElement mDialogElement;
        public boolean mSystemDialog;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2018612307, "Lcom/baidu/android/ext/widget/dialog/BoxAlertDialog$Builder;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2018612307, "Lcom/baidu/android/ext/widget/dialog/BoxAlertDialog$Builder;");
            }
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            this.mBtnHeight = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d7);
        }

        private void setMsgContentParams() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0908bf);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
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

        public Resources getAlertDialogResources() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mContext.getResources();
            }
            return (Resources) invokeV.objValue;
        }

        public ViewGroup getCustomContentParent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mDialogElement.mDialogContent;
            }
            return (ViewGroup) invokeV.objValue;
        }

        public boolean hasNegativeButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                TextView textView = this.mDialogElement.mNegativeButton;
                if (textView != null && textView.getVisibility() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean hasNeutralButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                TextView textView = this.mDialogElement.mNeutralButton;
                if (textView != null && textView.getVisibility() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean hasPositiveButton() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TextView textView = this.mDialogElement.mPositiveButton;
                if (textView != null && textView.getVisibility() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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

        private void updateDialogUI() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                int color = getAlertDialogResources().getColor(R.color.obfuscated_res_0x7f06071f);
                int color2 = getAlertDialogResources().getColor(R.color.obfuscated_res_0x7f06071b);
                int color3 = getAlertDialogResources().getColor(R.color.obfuscated_res_0x7f06071b);
                int color4 = getAlertDialogResources().getColor(R.color.obfuscated_res_0x7f0604c6);
                int color5 = getAlertDialogResources().getColor(R.color.obfuscated_res_0x7f06071c);
                this.mDialogElement.mDialogLayout.setBackground(getAlertDialogResources().getDrawable(R.drawable.obfuscated_res_0x7f080562));
                this.mDialogElement.mTitle.setTextColor(color);
                this.mDialogElement.mMessage.setTextColor(color4);
                DialogElement dialogElement = this.mDialogElement;
                TextView textView = dialogElement.mPositiveButton;
                int i = dialogElement.mPositiveBtnTextColor;
                if (i != -1) {
                    color3 = i;
                }
                textView.setTextColor(color3);
                DialogElement dialogElement2 = this.mDialogElement;
                TextView textView2 = dialogElement2.mNegativeButton;
                int i2 = dialogElement2.mNegativeBtnTextColor;
                if (i2 == -1) {
                    i2 = color2;
                }
                textView2.setTextColor(i2);
                this.mDialogElement.mNeutralButton.setTextColor(color2);
                this.mDialogElement.mDivider2.setBackgroundColor(color5);
                this.mDialogElement.mDivider3.setBackgroundColor(color5);
                this.mDialogElement.mDivider4.setBackgroundColor(color5);
                this.mDialogElement.mPositiveButton.setBackground(ResourcesCompat.getDrawable(getAlertDialogResources(), R.drawable.obfuscated_res_0x7f080561, null));
                this.mDialogElement.mNegativeButton.setBackground(ResourcesCompat.getDrawable(getAlertDialogResources(), R.drawable.obfuscated_res_0x7f08055d, null));
                this.mDialogElement.mNeutralButton.setBackground(ResourcesCompat.getDrawable(getAlertDialogResources(), R.drawable.obfuscated_res_0x7f08055f, null));
                TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
                if (ifOnlyOneBtnGetIt != null) {
                    ifOnlyOneBtnGetIt.setBackground(getAlertDialogResources().getDrawable(R.drawable.obfuscated_res_0x7f08055b));
                }
            }
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

        public Builder hideTitle(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                LinearLayout linearLayout = this.mDialogElement.mTitlePanel;
                if (z) {
                    i = 8;
                } else {
                    i = 0;
                }
                linearLayout.setVisibility(i);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public BoxAlertDialog onCreateDialog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
                return new BoxAlertDialog(context, R.style.obfuscated_res_0x7f10014f);
            }
            return (BoxAlertDialog) invokeL.objValue;
        }

        public Builder setBtnsVersible(boolean z) {
            InterceptResult invokeZ;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                LinearLayout linearLayout = this.mDialogElement.mBtnPanelLayout;
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                linearLayout.setVisibility(i);
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

        public Builder setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                this.mDialogElement.mIcon.setImageResource(i);
                return this;
            }
            return (Builder) invokeI.objValue;
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

        public Builder setMessageHeight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.mDialogElement.mScrollView.getLayoutParams().height = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageHeightResId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
                this.mDialogElement.mScrollView.getLayoutParams().height = this.mContext.getResources().getDimensionPixelSize(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageMaxHeight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                this.mDialogElement.setMessageMaxHeight(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageMaxHeightResId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
                this.mDialogElement.setMessageMaxHeight(this.mContext.getResources().getDimensionPixelSize(i));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                return setNegativeTextColorValue(this.mContext.getResources().getColor(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeTextColorValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
                DialogElement dialogElement = this.mDialogElement;
                dialogElement.mNegativeBtnTextColor = i;
                dialogElement.mNegativeButton.setTextColor(i);
                return this;
            }
            return (Builder) invokeI.objValue;
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

        public void setPositiveEnable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
                this.mDialogElement.mPositiveButton.setEnabled(z);
            }
        }

        public Builder setPositiveTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i)) == null) {
                return setPositiveTextColorValue(getAlertDialogResources().getColor(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPositiveTextColorValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
                DialogElement dialogElement = this.mDialogElement;
                dialogElement.mPositiveBtnTextColor = i;
                dialogElement.mPositiveButton.setTextColor(i);
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

        public Builder setTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
                this.mDialogElement.mTitle.setText(this.mContext.getText(i));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setTitleColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
                if (i != -1) {
                    this.mDialogElement.mTitle.setTextColor(i);
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @Deprecated
        public BoxAlertDialog show(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
                return show();
            }
            return (BoxAlertDialog) invokeZ.objValue;
        }

        public TextView ifOnlyOneBtnGetIt() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                TextView textView2 = this.mDialogElement.mPositiveButton;
                if (textView2 != null && textView2.getVisibility() == 0) {
                    textView = this.mDialogElement.mPositiveButton;
                    i = 1;
                } else {
                    i = 0;
                    textView = null;
                }
                TextView textView3 = this.mDialogElement.mNegativeButton;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i++;
                    textView = this.mDialogElement.mNegativeButton;
                }
                TextView textView4 = this.mDialogElement.mNeutralButton;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i++;
                    textView = this.mDialogElement.mNeutralButton;
                }
                if (i != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public Builder removeCustomPanelMargin(boolean z) {
            InterceptResult invokeZ;
            int dimensionPixelSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                ViewGroup.LayoutParams layoutParams = this.mDialogElement.mCustomPanel.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    if (z) {
                        dimensionPixelSize = 0;
                    } else {
                        dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d8);
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, dimensionPixelSize, 0, 0);
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMessage(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                    this.mDialogElement.mMessageContent.setVisibility(0);
                }
                this.mDialogElement.mMessage.setText(this.mContext.getText(i));
                setMsgContentParams();
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view2)) == null) {
                this.mDialogElement.mDialogContent.removeAllViews();
                this.mDialogElement.mDialogContent.addView(view2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0908b3);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
                return this;
            }
            return (Builder) invokeL.objValue;
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

        public Builder setNegativeTextColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                return setNegativeTextColor(str, -1);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPositiveTextColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
                return setPositiveTextColor(str, -1);
            }
            return (Builder) invokeL.objValue;
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

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, onClickListener)) == null) {
                return setNegativeButton(this.mContext.getText(i), onClickListener);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setNegativeTextColor(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        setNegativeTextColorValue(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (i > 0) {
                    setNegativeTextColor(i);
                }
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i, onClickListener)) == null) {
                return setNeutralButton(this.mContext.getText(i), onClickListener);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, onClickListener)) == null) {
                return setPositiveButton(this.mContext.getText(i), onClickListener);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setPositiveTextColor(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048620, this, str, i)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        setPositiveTextColorValue(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (i > 0) {
                    setPositiveTextColor(i);
                }
                return this;
            }
            return (Builder) invokeLI.objValue;
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
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

        public Builder setView(View view2, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                this.mDialogElement.mDialogContent.removeAllViews();
                this.mDialogElement.mDialogContent.addView(view2);
                this.mDialogElement.mDialogContent.setPadding(i, i2, i3, i4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0908b3);
                this.mDialogElement.mBtnPanelLayout.setLayoutParams(layoutParams);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCancelable = Boolean.TRUE;
            this.mPositiveBtnTextColor = -1;
            this.mNegativeBtnTextColor = -1;
            this.mRoot = viewGroup;
            this.mTitlePanel = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0925b1);
            this.mTitle = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.mMessage = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908be);
            this.mMessageContent = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908bf);
            this.mPositiveButton = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d11);
            this.mNegativeButton = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091913);
            this.mNeutralButton = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091928);
            this.mDivider3 = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908fd);
            this.mDivider4 = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908fe);
            this.mDialogContentPanel = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b3);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b4);
            this.mIcon = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b8);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09214a);
            this.mDivider2 = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908fc);
            this.mScrollView = (BoxScrollView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091769);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0904df);
            this.mCustomPanel = viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b3);
        }

        public void setMessageMaxHeight(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.mScrollView.setMaxHeight(i);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxAlertDialog(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }

    public Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBuilder;
        }
        return (Builder) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d023f);
            getWindow().setLayout(-1, -1);
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
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (builder = this.mBuilder) != null) {
            builder.setMessage(str);
        }
    }
}
