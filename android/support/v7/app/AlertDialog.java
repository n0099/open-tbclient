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
    final AlertController Ci;

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int i) {
        super(context, e(context, i));
        this.Ci = new AlertController(getContext(), this, getWindow());
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
        return this.Ci.getButton(i);
    }

    public ListView getListView() {
        return this.Ci.getListView();
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Ci.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.Ci.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.Ci.setMessage(charSequence);
    }

    public void setView(View view) {
        this.Ci.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.Ci.setView(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.Ci.a(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.Ci.a(i, charSequence, onClickListener, (Message) null);
    }

    public void setIcon(int i) {
        this.Ci.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.Ci.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.Ci.setIcon(typedValue.resourceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Ci.dR();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.Ci.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.Ci.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final AlertController.AlertParams Cj;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.e(context, 0));
        }

        public Builder(Context context, int i) {
            this.Cj = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.e(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.Cj.mContext;
        }

        public Builder setTitle(int i) {
            this.Cj.mTitle = this.Cj.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.Cj.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.Cj.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            this.Cj.mMessage = this.Cj.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.Cj.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.Cj.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.Cj.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.Cj.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.Cj.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mPositiveButtonText = this.Cj.mContext.getText(i);
            this.Cj.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mPositiveButtonText = charSequence;
            this.Cj.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mNegativeButtonText = this.Cj.mContext.getText(i);
            this.Cj.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mNegativeButtonText = charSequence;
            this.Cj.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mNeutralButtonText = this.Cj.mContext.getText(i);
            this.Cj.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mNeutralButtonText = charSequence;
            this.Cj.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.Cj.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.Cj.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.Cj.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.Cj.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mItems = this.Cj.mContext.getResources().getTextArray(i);
            this.Cj.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mItems = charSequenceArr;
            this.Cj.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mAdapter = listAdapter;
            this.Cj.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.Cj.mCursor = cursor;
            this.Cj.mLabelColumn = str;
            this.Cj.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Cj.mItems = this.Cj.mContext.getResources().getTextArray(i);
            this.Cj.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Cj.mCheckedItems = zArr;
            this.Cj.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Cj.mItems = charSequenceArr;
            this.Cj.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Cj.mCheckedItems = zArr;
            this.Cj.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Cj.mCursor = cursor;
            this.Cj.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Cj.mIsCheckedColumn = str;
            this.Cj.mLabelColumn = str2;
            this.Cj.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mItems = this.Cj.mContext.getResources().getTextArray(i);
            this.Cj.mOnClickListener = onClickListener;
            this.Cj.mCheckedItem = i2;
            this.Cj.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mCursor = cursor;
            this.Cj.mOnClickListener = onClickListener;
            this.Cj.mCheckedItem = i;
            this.Cj.mLabelColumn = str;
            this.Cj.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mItems = charSequenceArr;
            this.Cj.mOnClickListener = onClickListener;
            this.Cj.mCheckedItem = i;
            this.Cj.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.Cj.mAdapter = listAdapter;
            this.Cj.mOnClickListener = onClickListener;
            this.Cj.mCheckedItem = i;
            this.Cj.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.Cj.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.Cj.mView = null;
            this.Cj.mViewLayoutResId = i;
            this.Cj.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.Cj.mView = view;
            this.Cj.mViewLayoutResId = 0;
            this.Cj.mViewSpacingSpecified = false;
            return this;
        }

        @RestrictTo
        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.Cj.mView = view;
            this.Cj.mViewLayoutResId = 0;
            this.Cj.mViewSpacingSpecified = true;
            this.Cj.mViewSpacingLeft = i;
            this.Cj.mViewSpacingTop = i2;
            this.Cj.mViewSpacingRight = i3;
            this.Cj.mViewSpacingBottom = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.Cj.mForceInverseBackground = z;
            return this;
        }

        @RestrictTo
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.Cj.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.Cj.mContext, this.mTheme);
            this.Cj.apply(alertDialog.Ci);
            alertDialog.setCancelable(this.Cj.mCancelable);
            if (this.Cj.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.Cj.mOnCancelListener);
            alertDialog.setOnDismissListener(this.Cj.mOnDismissListener);
            if (this.Cj.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.Cj.mOnKeyListener);
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
