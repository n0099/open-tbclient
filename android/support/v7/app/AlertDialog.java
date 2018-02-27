package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AlertController;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes2.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    final AlertController Cd;

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int i) {
        super(context, e(context, i));
        this.Cd = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int e(Context context, int i) {
        if (i < 16777216) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    public Button getButton(int i) {
        return this.Cd.getButton(i);
    }

    public ListView getListView() {
        return this.Cd.getListView();
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Cd.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.Cd.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.Cd.setMessage(charSequence);
    }

    public void setView(View view) {
        this.Cd.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.Cd.setView(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.Cd.a(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.Cd.a(i, charSequence, onClickListener, (Message) null);
    }

    public void setIcon(int i) {
        this.Cd.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.Cd.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.Cd.setIcon(typedValue.resourceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Cd.dR();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.Cd.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.Cd.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final AlertController.AlertParams Ce;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.e(context, 0));
        }

        public Builder(Context context, int i) {
            this.Ce = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.e(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.Ce.mContext;
        }

        public Builder setTitle(int i) {
            this.Ce.mTitle = this.Ce.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.Ce.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.Ce.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            this.Ce.mMessage = this.Ce.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.Ce.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.Ce.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.Ce.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.Ce.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.Ce.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mPositiveButtonText = this.Ce.mContext.getText(i);
            this.Ce.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mPositiveButtonText = charSequence;
            this.Ce.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mNegativeButtonText = this.Ce.mContext.getText(i);
            this.Ce.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mNegativeButtonText = charSequence;
            this.Ce.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mNeutralButtonText = this.Ce.mContext.getText(i);
            this.Ce.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mNeutralButtonText = charSequence;
            this.Ce.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.Ce.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.Ce.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.Ce.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.Ce.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mItems = this.Ce.mContext.getResources().getTextArray(i);
            this.Ce.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mItems = charSequenceArr;
            this.Ce.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mAdapter = listAdapter;
            this.Ce.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.Ce.mCursor = cursor;
            this.Ce.mLabelColumn = str;
            this.Ce.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ce.mItems = this.Ce.mContext.getResources().getTextArray(i);
            this.Ce.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ce.mCheckedItems = zArr;
            this.Ce.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ce.mItems = charSequenceArr;
            this.Ce.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ce.mCheckedItems = zArr;
            this.Ce.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ce.mCursor = cursor;
            this.Ce.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ce.mIsCheckedColumn = str;
            this.Ce.mLabelColumn = str2;
            this.Ce.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mItems = this.Ce.mContext.getResources().getTextArray(i);
            this.Ce.mOnClickListener = onClickListener;
            this.Ce.mCheckedItem = i2;
            this.Ce.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mCursor = cursor;
            this.Ce.mOnClickListener = onClickListener;
            this.Ce.mCheckedItem = i;
            this.Ce.mLabelColumn = str;
            this.Ce.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mItems = charSequenceArr;
            this.Ce.mOnClickListener = onClickListener;
            this.Ce.mCheckedItem = i;
            this.Ce.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.Ce.mAdapter = listAdapter;
            this.Ce.mOnClickListener = onClickListener;
            this.Ce.mCheckedItem = i;
            this.Ce.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.Ce.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.Ce.mView = null;
            this.Ce.mViewLayoutResId = i;
            this.Ce.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.Ce.mView = view;
            this.Ce.mViewLayoutResId = 0;
            this.Ce.mViewSpacingSpecified = false;
            return this;
        }

        @RestrictTo
        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.Ce.mView = view;
            this.Ce.mViewLayoutResId = 0;
            this.Ce.mViewSpacingSpecified = true;
            this.Ce.mViewSpacingLeft = i;
            this.Ce.mViewSpacingTop = i2;
            this.Ce.mViewSpacingRight = i3;
            this.Ce.mViewSpacingBottom = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.Ce.mForceInverseBackground = z;
            return this;
        }

        @RestrictTo
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.Ce.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.Ce.mContext, this.mTheme);
            this.Ce.apply(alertDialog.Cd);
            alertDialog.setCancelable(this.Ce.mCancelable);
            if (this.Ce.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.Ce.mOnCancelListener);
            alertDialog.setOnDismissListener(this.Ce.mOnDismissListener);
            if (this.Ce.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.Ce.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }
}
