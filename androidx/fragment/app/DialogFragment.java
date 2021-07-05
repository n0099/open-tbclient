package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SAVED_BACK_STACK_ID = "android:backStackId";
    public static final String SAVED_CANCELABLE = "android:cancelable";
    public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    public static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    public static final String SAVED_STYLE = "android:style";
    public static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackStackId;
    public boolean mCancelable;
    @Nullable
    public Dialog mDialog;
    public Runnable mDismissRunnable;
    public boolean mDismissed;
    public Handler mHandler;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public boolean mShownByMe;
    public boolean mShowsDialog;
    public int mStyle;
    public int mTheme;
    public boolean mViewDestroyed;

    public DialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDismissRunnable = new Runnable(this) { // from class: androidx.fragment.app.DialogFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogFragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    DialogFragment dialogFragment = this.this$0;
                    dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
                }
            }
        };
        this.mOnCancelListener = new DialogInterface.OnCancelListener(this) { // from class: androidx.fragment.app.DialogFragment.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogFragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(@Nullable DialogInterface dialogInterface) {
                DialogFragment dialogFragment;
                Dialog dialog;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (dialog = (dialogFragment = this.this$0).mDialog) == null) {
                    return;
                }
                dialogFragment.onCancel(dialog);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener(this) { // from class: androidx.fragment.app.DialogFragment.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogFragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(@Nullable DialogInterface dialogInterface) {
                DialogFragment dialogFragment;
                Dialog dialog;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (dialog = (dialogFragment = this.this$0).mDialog) == null) {
                    return;
                }
                dialogFragment.onDismiss(dialog);
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dismissInternal(false, false);
        }
    }

    public void dismissAllowingStateLoss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismissInternal(true, false);
        }
    }

    public void dismissInternal(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            getParentFragmentManager().popBackStack(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    @Nullable
    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDialog : (Dialog) invokeV.objValue;
    }

    public boolean getShowsDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mShowsDialog : invokeV.booleanValue;
    }

    @StyleRes
    public int getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTheme : invokeV.intValue;
    }

    public boolean isCancelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCancelable : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onActivityCreated(@Nullable Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.mShowsDialog) {
                View view = getView();
                if (view != null) {
                    if (view.getParent() == null) {
                        this.mDialog.setContentView(view);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    this.mDialog.setOwnerActivity(activity);
                }
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnCancelListener(this.mOnCancelListener);
                this.mDialog.setOnDismissListener(this.mOnDismissListener);
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                this.mDialog.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            super.onAttach(context);
            if (this.mShownByMe) {
                return;
            }
            this.mDismissed = false;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.mHandler = new Handler();
            this.mShowsDialog = this.mContainerId == 0;
            if (bundle != null) {
                this.mStyle = bundle.getInt(SAVED_STYLE, 0);
                this.mTheme = bundle.getInt(SAVED_THEME, 0);
                this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
                this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
                this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    @NonNull
    @MainThread
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) ? new Dialog(requireContext(), getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroyView();
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                this.mViewDestroyed = true;
                dialog.setOnDismissListener(null);
                this.mDialog.dismiss();
                if (!this.mDismissed) {
                    onDismiss(this.mDialog);
                }
                this.mDialog = null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetach();
            if (this.mShownByMe || this.mDismissed) {
                return;
            }
            this.mDismissed = true;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dialogInterface) == null) || this.mViewDestroyed) {
            return;
        }
        dismissInternal(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            if (!this.mShowsDialog) {
                return super.onGetLayoutInflater(bundle);
            }
            Dialog onCreateDialog = onCreateDialog(bundle);
            this.mDialog = onCreateDialog;
            if (onCreateDialog != null) {
                setupDialog(onCreateDialog, this.mStyle);
                return (LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater");
            }
            return (LayoutInflater) this.mHost.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Bundle onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            Dialog dialog = this.mDialog;
            if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
            int i2 = this.mStyle;
            if (i2 != 0) {
                bundle.putInt(SAVED_STYLE, i2);
            }
            int i3 = this.mTheme;
            if (i3 != 0) {
                bundle.putInt(SAVED_THEME, i3);
            }
            boolean z = this.mCancelable;
            if (!z) {
                bundle.putBoolean(SAVED_CANCELABLE, z);
            }
            boolean z2 = this.mShowsDialog;
            if (!z2) {
                bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
            }
            int i4 = this.mBackStackId;
            if (i4 != -1) {
                bundle.putInt(SAVED_BACK_STACK_ID, i4);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                this.mViewDestroyed = false;
                dialog.show();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                return dialog;
            }
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        return (Dialog) invokeV.objValue;
    }

    public void setCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mCancelable = z;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setCancelable(z);
            }
        }
    }

    public void setShowsDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mShowsDialog = z;
        }
    }

    public void setStyle(int i2, @StyleRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            this.mStyle = i2;
            if (i2 == 2 || i2 == 3) {
                this.mTheme = 16973913;
            }
            if (i3 != 0) {
                this.mTheme = i3;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, dialog, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            dialog.requestWindowFeature(1);
        }
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, fragmentManager, str) == null) {
            this.mDismissed = false;
            this.mShownByMe = true;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commit();
        }
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, fragmentManager, str) == null) {
            this.mDismissed = false;
            this.mShownByMe = true;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitNow();
        }
    }

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, fragmentTransaction, str)) == null) {
            this.mDismissed = false;
            this.mShownByMe = true;
            fragmentTransaction.add(this, str);
            this.mViewDestroyed = false;
            int commit = fragmentTransaction.commit();
            this.mBackStackId = commit;
            return commit;
        }
        return invokeLL.intValue;
    }
}
