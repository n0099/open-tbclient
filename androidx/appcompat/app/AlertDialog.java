package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LAYOUT_HINT_NONE = 0;
    public static final int LAYOUT_HINT_SIDE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertController mAlert;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AlertController.AlertParams P;
        public final int mTheme;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NonNull Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @NonNull
        public AlertDialog create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
                this.P.apply(alertDialog.mAlert);
                alertDialog.setCancelable(this.P.mCancelable);
                if (this.P.mCancelable) {
                    alertDialog.setCanceledOnTouchOutside(true);
                }
                alertDialog.setOnCancelListener(this.P.mOnCancelListener);
                alertDialog.setOnDismissListener(this.P.mOnDismissListener);
                DialogInterface.OnKeyListener onKeyListener = this.P.mOnKeyListener;
                if (onKeyListener != null) {
                    alertDialog.setOnKeyListener(onKeyListener);
                }
                return alertDialog;
            }
            return (AlertDialog) invokeV.objValue;
        }

        @NonNull
        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.P.mContext : (Context) invokeV.objValue;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, listAdapter, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mAdapter = listAdapter;
                alertParams.mOnClickListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setCancelable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.P.mCancelable = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, cursor, onClickListener, str)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mCursor = cursor;
                alertParams.mLabelColumn = str;
                alertParams.mOnClickListener = onClickListener;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setCustomTitle(@Nullable View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
                this.P.mCustomTitleView = view;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIcon(@DrawableRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.P.mIconId = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconAttribute(@AttrRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                TypedValue typedValue = new TypedValue();
                this.P.mContext.getTheme().resolveAttribute(i2, typedValue, true);
                this.P.mIconId = typedValue.resourceId;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.P.mForceInverseBackground = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setItems(@ArrayRes int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
                this.P.mOnClickListener = onClickListener;
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setMessage(@StringRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mMessage = alertParams.mContext.getText(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i2, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048590, this, i2, zArr, onMultiChoiceClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
                AlertController.AlertParams alertParams2 = this.P;
                alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
                alertParams2.mCheckedItems = zArr;
                alertParams2.mIsMultiChoice = true;
                return this;
            }
            return (Builder) invokeILL.objValue;
        }

        public Builder setNegativeButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mNegativeButtonText = alertParams.mContext.getText(i2);
                this.P.mNegativeButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, drawable)) == null) {
                this.P.mNegativeButtonIcon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNeutralButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mNeutralButtonText = alertParams.mContext.getText(i2);
                this.P.mNeutralButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, drawable)) == null) {
                this.P.mNeutralButtonIcon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, onCancelListener)) == null) {
                this.P.mOnCancelListener = onCancelListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, onDismissListener)) == null) {
                this.P.mOnDismissListener = onDismissListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, onItemSelectedListener)) == null) {
                this.P.mOnItemSelectedListener = onItemSelectedListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, onKeyListener)) == null) {
                this.P.mOnKeyListener = onKeyListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPositiveButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mPositiveButtonText = alertParams.mContext.getText(i2);
                this.P.mPositiveButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, drawable)) == null) {
                this.P.mPositiveButtonIcon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
                this.P.mRecycleOnMeasure = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048607, this, i2, i3, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
                AlertController.AlertParams alertParams2 = this.P;
                alertParams2.mOnClickListener = onClickListener;
                alertParams2.mCheckedItem = i3;
                alertParams2.mIsSingleChoice = true;
                return this;
            }
            return (Builder) invokeIIL.objValue;
        }

        public Builder setTitle(@StringRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mTitle = alertParams.mContext.getText(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setView(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mView = null;
                alertParams.mViewLayoutResId = i2;
                alertParams.mViewSpacingSpecified = false;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public AlertDialog show() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
                AlertDialog create = create();
                create.show();
                return create;
            }
            return (AlertDialog) invokeV.objValue;
        }

        public Builder(@NonNull Context context, @StyleRes int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i2)));
            this.mTheme = i2;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, drawable)) == null) {
                this.P.mIcon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
                this.P.mMessage = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, charSequence)) == null) {
                this.P.mTitle = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, charSequenceArr, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = charSequenceArr;
                alertParams.mOnClickListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, charSequence, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mNegativeButtonText = charSequence;
                alertParams.mNegativeButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, charSequence, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mNeutralButtonText = charSequence;
                alertParams.mNeutralButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, charSequence, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mPositiveButtonText = charSequence;
                alertParams.mPositiveButtonListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mView = view;
                alertParams.mViewLayoutResId = 0;
                alertParams.mViewSpacingSpecified = false;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, charSequenceArr, zArr, onMultiChoiceClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = charSequenceArr;
                alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
                alertParams.mCheckedItems = zArr;
                alertParams.mIsMultiChoice = true;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i2, String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048608, this, cursor, i2, str, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mCursor = cursor;
                alertParams.mOnClickListener = onClickListener;
                alertParams.mCheckedItem = i2;
                alertParams.mLabelColumn = str;
                alertParams.mIsSingleChoice = true;
                return this;
            }
            return (Builder) invokeLILL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public Builder setView(View view, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mView = view;
                alertParams.mViewLayoutResId = 0;
                alertParams.mViewSpacingSpecified = true;
                alertParams.mViewSpacingLeft = i2;
                alertParams.mViewSpacingTop = i3;
                alertParams.mViewSpacingRight = i4;
                alertParams.mViewSpacingBottom = i5;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, cursor, str, str2, onMultiChoiceClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mCursor = cursor;
                alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
                alertParams.mIsCheckedColumn = str;
                alertParams.mLabelColumn = str2;
                alertParams.mIsMultiChoice = true;
                return this;
            }
            return (Builder) invokeLLLL.objValue;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048610, this, charSequenceArr, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mItems = charSequenceArr;
                alertParams.mOnClickListener = onClickListener;
                alertParams.mCheckedItem = i2;
                alertParams.mIsSingleChoice = true;
                return this;
            }
            return (Builder) invokeLIL.objValue;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048609, this, listAdapter, i2, onClickListener)) == null) {
                AlertController.AlertParams alertParams = this.P;
                alertParams.mAdapter = listAdapter;
                alertParams.mOnClickListener = onClickListener;
                alertParams.mCheckedItem = i2;
                alertParams.mIsSingleChoice = true;
                return this;
            }
            return (Builder) invokeLIL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlertDialog(@NonNull Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int resolveDialogTheme(@NonNull Context context, @StyleRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            if (((i2 >>> 24) & 255) >= 1) {
                return i2;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return invokeLI.intValue;
    }

    public Button getButton(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.mAlert.getButton(i2) : (Button) invokeI.objValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAlert.getListView() : (ListView) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAlert.installContent();
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (this.mAlert.onKeyDown(i2, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (this.mAlert.onKeyUp(i2, keyEvent)) {
                return true;
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void setButton(int i2, CharSequence charSequence, Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, charSequence, message) == null) {
            this.mAlert.setButton(i2, charSequence, null, message, null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setButtonPanelLayoutHint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mAlert.setButtonPanelLayoutHint(i2);
        }
    }

    public void setCustomTitle(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.mAlert.setCustomTitle(view);
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mAlert.setIcon(i2);
        }
    }

    public void setIconAttribute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(i2, typedValue, true);
            this.mAlert.setIcon(typedValue.resourceId);
        }
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, charSequence) == null) {
            this.mAlert.setMessage(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            super.setTitle(charSequence);
            this.mAlert.setTitle(charSequence);
        }
    }

    public void setView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            this.mAlert.setView(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, resolveDialogTheme(context, i2));
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
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, charSequence, onClickListener) == null) {
            this.mAlert.setButton(i2, charSequence, onClickListener, null, null);
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.mAlert.setIcon(drawable);
        }
    }

    public void setView(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mAlert.setView(view, i2, i3, i4, i5);
        }
    }

    public void setButton(int i2, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), charSequence, drawable, onClickListener}) == null) {
            this.mAlert.setButton(i2, charSequence, onClickListener, null, drawable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlertDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
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
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }
}
