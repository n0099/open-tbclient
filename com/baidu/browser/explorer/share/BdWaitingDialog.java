package com.baidu.browser.explorer.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BdWaitingDialog extends Dialog {
    private static final int MESSAGE_PADDING = 12;
    private static final int TEXT_SIZE = 16;
    private Context mContext;
    private String mMessage;

    public BdWaitingDialog(Context context) {
        super(context, context.getResources().getIdentifier("browser_BdWaitingDialog", "style", context.getPackageName()));
        this.mContext = context;
    }

    public static BdWaitingDialog show(Context context, CharSequence charSequence) {
        return show(context, charSequence, false);
    }

    public static BdWaitingDialog show(Context context, CharSequence charSequence, boolean z) {
        return show(context, charSequence, z, null);
    }

    public static BdWaitingDialog show(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        BdWaitingDialog bdWaitingDialog = new BdWaitingDialog(context);
        bdWaitingDialog.setMessage(charSequence);
        bdWaitingDialog.setCancelable(z);
        bdWaitingDialog.setOnCancelListener(onCancelListener);
        bdWaitingDialog.show();
        return bdWaitingDialog;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new BdWaitingView(this.mContext));
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence.toString();
    }

    public void setMessage(int i) {
        this.mMessage = this.mContext.getResources().getString(i);
    }

    /* loaded from: classes.dex */
    public class BdWaitingView extends LinearLayout {
        private Context mContext;
        private int mMessagePadding;
        private int mScreenWidth;
        private int mTextSize;

        public BdWaitingView(Context context) {
            super(context);
            this.mContext = context;
            loadConfiguration();
            layoutDesign();
        }

        private void loadConfiguration() {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mTextSize = (int) (16.0d * Math.sqrt(f));
            this.mMessagePadding = (int) (f * 12.0f);
        }

        private void layoutDesign() {
            setOrientation(1);
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            setBackgroundColor(0);
            ProgressBar progressBar = new ProgressBar(this.mContext);
            progressBar.setBackgroundColor(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            progressBar.setLayoutParams(layoutParams);
            addView(progressBar);
            TextView textView = new TextView(this.mContext);
            textView.setText(BdWaitingDialog.this.mMessage);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            layoutParams2.width = this.mScreenWidth;
            textView.setGravity(17);
            textView.setLayoutParams(layoutParams2);
            textView.setBackgroundColor(0);
            textView.setPadding(this.mMessagePadding, this.mMessagePadding, this.mMessagePadding, this.mMessagePadding);
            textView.setTextSize(this.mTextSize);
            textView.setTextColor(-1710619);
            addView(textView);
        }
    }
}
