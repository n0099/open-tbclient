package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.searchbox.ui.RoundProgressBar;
/* loaded from: classes3.dex */
public class ProgressBarDialog extends BoxAlertDialog {
    private TextView mContentText;
    private View mContentView;
    private RoundProgressBar mProgressBar;

    protected ProgressBarDialog(Context context) {
        super(context);
    }

    protected ProgressBarDialog(Context context, int i) {
        super(context, i);
    }

    protected ProgressBarDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContentView = createContentView();
        getBuilder().setView(this.mContentView);
    }

    public void setMaxProgress(int i) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setMax(i);
        }
    }

    public void setProgress(int i) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setProgress(i);
        }
    }

    public void showProgressBar(boolean z) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(z ? 0 : 8);
        }
    }

    public void setProgressTextColor(int i) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setTextColor(i);
        }
    }

    public void setCircleColor(int i) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setCircleColor(i);
        }
    }

    public void setCircleProgressColor(int i) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setCircleProgressColor(i);
        }
    }

    public void setProgressTextSize(float f) {
        if (this.mProgressBar != null) {
            this.mProgressBar.setTextSize(f);
        }
    }

    public void setContentText(String str) {
        if (this.mContentText != null) {
            this.mContentText.setText(str);
        }
    }

    public void setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        getBuilder().setPositiveButton(charSequence, onClickListener);
    }

    public void setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        getBuilder().setNegativeButton(charSequence, onClickListener);
    }

    private View createContentView() {
        this.mContentView = LayoutInflater.from(getContext()).inflate(R.layout.progress_bar_dialog_content_layout, (ViewGroup) null);
        this.mContentText = (TextView) this.mContentView.findViewById(R.id.content_text);
        this.mProgressBar = (RoundProgressBar) this.mContentView.findViewById(R.id.content_progress_bar);
        return this.mContentView;
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BoxAlertDialog.Builder {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        protected BoxAlertDialog onCreateDialog(Context context) {
            return new ProgressBarDialog(context, R.style.NoTitleDialog);
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog.Builder setNegativeButton(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            super.setNegativeButton(charSequence, onClickListener);
            this.mDialogElement.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.ProgressBarDialog.Builder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.mDialog.onButtonClick(-2);
                    Builder.this.mDialog.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -2);
                    }
                }
            });
            return this;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog.Builder setPositiveButton(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            super.setPositiveButton(charSequence, onClickListener);
            this.mDialogElement.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.dialog.ProgressBarDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.mDialog.onButtonClick(-1);
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -1);
                    }
                }
            });
            return this;
        }
    }
}
