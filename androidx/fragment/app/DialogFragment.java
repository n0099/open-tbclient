package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
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
    public boolean mCreatingDialog;
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

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface) == null) {
        }
    }

    public DialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    this.this$0.mOnDismissListener.onDismiss(this.this$0.mDialog);
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.this$0.mDialog != null) {
                    DialogFragment dialogFragment = this.this$0;
                    dialogFragment.onCancel(dialogFragment.mDialog);
                }
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.this$0.mDialog != null) {
                    DialogFragment dialogFragment = this.this$0;
                    dialogFragment.onDismiss(dialogFragment.mDialog);
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
    }

    public final Dialog requireDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                return dialog;
            }
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        return (Dialog) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            super.onAttach(context);
            if (!this.mShownByMe) {
                this.mDismissed = false;
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bundle)) == null) {
            return new Dialog(requireContext(), getTheme());
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dialogInterface) == null) && !this.mViewDestroyed) {
            dismissInternal(true, true);
        }
    }

    public void setCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mCancelable = z;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setCancelable(z);
            }
        }
    }

    public void setShowsDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mShowsDialog = z;
        }
    }

    private void dismissInternal(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.mDismissed) {
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

    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDialog;
        }
        return (Dialog) invokeV.objValue;
    }

    public boolean getShowsDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mShowsDialog;
        }
        return invokeV.booleanValue;
    }

    public int getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTheme;
        }
        return invokeV.intValue;
    }

    public boolean isCancelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCancelable;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetach();
            if (!this.mShownByMe && !this.mDismissed) {
                this.mDismissed = true;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStart();
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                this.mViewDestroyed = false;
                dialog.show();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStop();
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (!this.mShowsDialog) {
                return;
            }
            View view2 = getView();
            if (this.mDialog != null) {
                if (view2 != null) {
                    if (view2.getParent() == null) {
                        this.mDialog.setContentView(view2);
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
                if (bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
                    this.mDialog.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.mHandler = new Handler();
            if (this.mContainerId == 0) {
                z = true;
            } else {
                z = false;
            }
            this.mShowsDialog = z;
            if (bundle != null) {
                this.mStyle = bundle.getInt(SAVED_STYLE, 0);
                this.mTheme = bundle.getInt(SAVED_THEME, 0);
                this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
                this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
                this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                bundle.putBundle(SAVED_DIALOG_STATE_TAG, dialog.onSaveInstanceState());
            }
            int i = this.mStyle;
            if (i != 0) {
                bundle.putInt(SAVED_STYLE, i);
            }
            int i2 = this.mTheme;
            if (i2 != 0) {
                bundle.putInt(SAVED_THEME, i2);
            }
            boolean z = this.mCancelable;
            if (!z) {
                bundle.putBoolean(SAVED_CANCELABLE, z);
            }
            boolean z2 = this.mShowsDialog;
            if (!z2) {
                bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
            }
            int i3 = this.mBackStackId;
            if (i3 != -1) {
                bundle.putInt(SAVED_BACK_STACK_ID, i3);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
            if (this.mShowsDialog && !this.mCreatingDialog) {
                try {
                    this.mCreatingDialog = true;
                    Dialog onCreateDialog = onCreateDialog(bundle);
                    this.mDialog = onCreateDialog;
                    setupDialog(onCreateDialog, this.mStyle);
                    this.mCreatingDialog = false;
                    return onGetLayoutInflater.cloneInContext(requireDialog().getContext());
                } catch (Throwable th) {
                    this.mCreatingDialog = false;
                    throw th;
                }
            }
            return onGetLayoutInflater;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void setStyle(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            this.mStyle = i;
            if (i == 2 || i == 3) {
                this.mTheme = 16973913;
            }
            if (i2 != 0) {
                this.mTheme = i2;
            }
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, dialog, i) == null) {
            if (i != 1 && i != 2) {
                if (i == 3) {
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.addFlags(24);
                    }
                } else {
                    return;
                }
            }
            dialog.requestWindowFeature(1);
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, fragmentTransaction, str)) == null) {
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

    public void showNow(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, fragmentManager, str) == null) {
            this.mDismissed = false;
            this.mShownByMe = true;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitNow();
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, fragmentManager, str) == null) {
            this.mDismissed = false;
            this.mShownByMe = true;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commit();
        }
    }
}
