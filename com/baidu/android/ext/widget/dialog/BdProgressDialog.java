package com.baidu.android.ext.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.SmoothProgressBar;
/* loaded from: classes11.dex */
public class BdProgressDialog extends ProgressDialog {
    private static final int CANCELABLE_TIME = 5000;
    private boolean mDetached;
    private TextView mMsg;
    private String mMsgText;
    private SmoothProgressBar mProgressBar;
    private View mRootView;

    public BdProgressDialog(Context context) {
        super(context);
        this.mMsgText = "";
        this.mDetached = false;
        this.mMsgText = context.getString(R.string.progress_deleting);
    }

    public BdProgressDialog(Context context, String str) {
        super(context);
        this.mMsgText = "";
        this.mDetached = false;
        this.mMsgText = str;
    }

    public BdProgressDialog(Context context, int i) {
        super(context, i);
        this.mMsgText = "";
        this.mDetached = false;
        this.mMsgText = context.getString(R.string.progress_deleting);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.progress_dialog);
        this.mRootView = findViewById(R.id.root_container);
        this.mProgressBar = (SmoothProgressBar) findViewById(R.id.loading_bar);
        this.mMsg = (TextView) findViewById(R.id.message);
        setMessage(this.mMsgText);
        setPageResources();
    }

    public void setPageResources() {
        if (this.mRootView != null) {
            this.mRootView.setBackground(this.mRootView.getResources().getDrawable(R.drawable.novel_loading_bg));
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setIndeterminateDrawable(this.mProgressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
        }
        if (this.mMsg != null) {
            this.mMsg.setTextColor(this.mMsg.getResources().getColor(R.color.loading_text_color));
        }
    }

    public void setMessage(String str) {
        this.mMsgText = str;
        if (this.mMsg != null) {
            this.mMsg.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (!this.mDetached) {
            super.show();
            this.mDetached = false;
            this.mRootView.postDelayed(new Runnable() { // from class: com.baidu.android.ext.widget.dialog.BdProgressDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!BdProgressDialog.this.mDetached && BdProgressDialog.this.isShowing()) {
                        BdProgressDialog.this.setCancelable(true);
                        BdProgressDialog.this.setCanceledOnTouchOutside(true);
                    }
                }
            }, 5000L);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (!this.mDetached) {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.android.ext.widget.dialog.BdProgressDialog.2
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BdProgressDialog.this.setPageResources();
            }
        });
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        this.mDetached = true;
    }
}
