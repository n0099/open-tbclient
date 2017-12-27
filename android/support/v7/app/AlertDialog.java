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
    final AlertController Cj;

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int i) {
        super(context, d(context, i));
        this.Cj = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int d(Context context, int i) {
        if (i < 16777216) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    public Button getButton(int i) {
        return this.Cj.getButton(i);
    }

    public ListView getListView() {
        return this.Cj.getListView();
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Cj.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.Cj.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.Cj.setMessage(charSequence);
    }

    public void setView(View view) {
        this.Cj.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.Cj.setView(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.Cj.a(i, charSequence, (DialogInterface.OnClickListener) null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.Cj.a(i, charSequence, onClickListener, (Message) null);
    }

    public void setIcon(int i) {
        this.Cj.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.Cj.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.Cj.setIcon(typedValue.resourceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Cj.dR();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.Cj.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.Cj.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final AlertController.AlertParams Ck;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.d(context, 0));
        }

        public Builder(Context context, int i) {
            this.Ck = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.d(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.Ck.mContext;
        }

        public Builder setTitle(int i) {
            this.Ck.mTitle = this.Ck.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.Ck.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.Ck.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            this.Ck.mMessage = this.Ck.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.Ck.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.Ck.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.Ck.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.Ck.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.Ck.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mPositiveButtonText = this.Ck.mContext.getText(i);
            this.Ck.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mPositiveButtonText = charSequence;
            this.Ck.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mNegativeButtonText = this.Ck.mContext.getText(i);
            this.Ck.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mNegativeButtonText = charSequence;
            this.Ck.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mNeutralButtonText = this.Ck.mContext.getText(i);
            this.Ck.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mNeutralButtonText = charSequence;
            this.Ck.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.Ck.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.Ck.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.Ck.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.Ck.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mItems = this.Ck.mContext.getResources().getTextArray(i);
            this.Ck.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mItems = charSequenceArr;
            this.Ck.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mAdapter = listAdapter;
            this.Ck.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.Ck.mCursor = cursor;
            this.Ck.mLabelColumn = str;
            this.Ck.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ck.mItems = this.Ck.mContext.getResources().getTextArray(i);
            this.Ck.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ck.mCheckedItems = zArr;
            this.Ck.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ck.mItems = charSequenceArr;
            this.Ck.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ck.mCheckedItems = zArr;
            this.Ck.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.Ck.mCursor = cursor;
            this.Ck.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.Ck.mIsCheckedColumn = str;
            this.Ck.mLabelColumn = str2;
            this.Ck.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mItems = this.Ck.mContext.getResources().getTextArray(i);
            this.Ck.mOnClickListener = onClickListener;
            this.Ck.mCheckedItem = i2;
            this.Ck.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mCursor = cursor;
            this.Ck.mOnClickListener = onClickListener;
            this.Ck.mCheckedItem = i;
            this.Ck.mLabelColumn = str;
            this.Ck.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mItems = charSequenceArr;
            this.Ck.mOnClickListener = onClickListener;
            this.Ck.mCheckedItem = i;
            this.Ck.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.Ck.mAdapter = listAdapter;
            this.Ck.mOnClickListener = onClickListener;
            this.Ck.mCheckedItem = i;
            this.Ck.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.Ck.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.Ck.mView = null;
            this.Ck.mViewLayoutResId = i;
            this.Ck.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.Ck.mView = view;
            this.Ck.mViewLayoutResId = 0;
            this.Ck.mViewSpacingSpecified = false;
            return this;
        }

        @RestrictTo
        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.Ck.mView = view;
            this.Ck.mViewLayoutResId = 0;
            this.Ck.mViewSpacingSpecified = true;
            this.Ck.mViewSpacingLeft = i;
            this.Ck.mViewSpacingTop = i2;
            this.Ck.mViewSpacingRight = i3;
            this.Ck.mViewSpacingBottom = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.Ck.mForceInverseBackground = z;
            return this;
        }

        @RestrictTo
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.Ck.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.Ck.mContext, this.mTheme);
            this.Ck.apply(alertDialog.Cj);
            alertDialog.setCancelable(this.Ck.mCancelable);
            if (this.Ck.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.Ck.mOnCancelListener);
            alertDialog.setOnDismissListener(this.Ck.mOnDismissListener);
            if (this.Ck.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.Ck.mOnKeyListener);
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
