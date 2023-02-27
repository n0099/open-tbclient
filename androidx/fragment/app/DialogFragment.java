package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
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
    public boolean mCreatingDialog;
    @Nullable
    public Dialog mDialog;
    public boolean mDismissed;
    public Handler mHandler;
    public boolean mShownByMe;
    public boolean mViewDestroyed;
    public Runnable mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.DialogFragment.1
        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        }
    };
    public DialogInterface.OnCancelListener mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.DialogFragment.2
        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.mDialog);
            }
        }
    };
    public DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.DialogFragment.3
        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.mDialog != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.mDialog);
            }
        }
    };
    public int mStyle = 0;
    public int mTheme = 0;
    public boolean mCancelable = true;
    public boolean mShowsDialog = true;
    public int mBackStackId = -1;

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
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

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    @NonNull
    @MainThread
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            dismissInternal(true, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
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

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (this.mDismissed) {
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

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onActivityCreated(@Nullable Bundle bundle) {
        Bundle bundle2;
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

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        boolean z;
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

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
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

    public void setStyle(int i, @StyleRes int i2) {
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = 16973913;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i) {
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

    public int show(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add(this, str);
        this.mViewDestroyed = false;
        int commit = fragmentTransaction.commit();
        this.mBackStackId = commit;
        return commit;
    }

    public void showNow(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitNow();
    }

    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commit();
    }
}
