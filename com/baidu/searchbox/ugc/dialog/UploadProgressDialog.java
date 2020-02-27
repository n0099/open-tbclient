package com.baidu.searchbox.ugc.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.view.RoundProgressBar;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class UploadProgressDialog extends Dialog {
    private static final int INCREASE_PROGRESS_INTERVAL = 10;
    public static final int MAX_PROGRESS = 100;
    private static final int THREAD_RUN_INTERVAL = 100;
    private Button mCancleBtn;
    private CancalProgressListener mListener;
    private long mProgress;
    private RoundProgressBar mProgressBar;
    private WeakReference<Activity> mWeakRefContext;

    /* loaded from: classes13.dex */
    public interface CancalProgressListener {
        void cancel();
    }

    public void setListener(CancalProgressListener cancalProgressListener) {
        this.mListener = cancalProgressListener;
    }

    public UploadProgressDialog(Activity activity, int i) {
        super(activity, i);
        this.mProgress = 0L;
        this.mWeakRefContext = new WeakReference<>(activity);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null) {
            FrameLayout frameLayout = new FrameLayout(appContext);
            LayoutInflater.from(appContext).inflate(R.layout.ugc_upload_progress_dialog, (ViewGroup) frameLayout, true);
            setContentView(frameLayout);
            this.mCancleBtn = (Button) findViewById(R.id.progress_cancle);
            this.mProgressBar = (RoundProgressBar) findViewById(R.id.ugc_progress);
            this.mProgressBar.setMax(100);
            this.mCancleBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.dialog.UploadProgressDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UploadProgressDialog.this.mListener != null) {
                        UploadProgressDialog.this.mListener.cancel();
                    }
                    UploadProgressDialog.this.dismiss();
                }
            });
            setCanceledOnTouchOutside(false);
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                attributes.width = -2;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
        }
    }

    public void notifyProgress(long j) {
        if (j <= 100) {
            this.mProgressBar.setProgress(j);
            this.mProgress = j;
        }
    }

    public void setCancleEnable(boolean z) {
        this.mCancleBtn.setEnabled(z);
        if (z) {
            this.mCancleBtn.setAlpha(1.0f);
        } else {
            this.mCancleBtn.setAlpha(0.2f);
        }
    }

    public void updateProgressAuto(int i) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.ugc.dialog.UploadProgressDialog.2
            @Override // java.lang.Runnable
            public void run() {
                while (UploadProgressDialog.this.mProgress < 100) {
                    UploadProgressDialog.this.mProgress += 10;
                    Activity activity = (Activity) UploadProgressDialog.this.mWeakRefContext.get();
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ugc.dialog.UploadProgressDialog.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UploadProgressDialog.this.mProgress < 100) {
                                    UploadProgressDialog.this.notifyProgress(UploadProgressDialog.this.mProgress);
                                }
                            }
                        });
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, UploadProgressDialog.class.getSimpleName(), 1);
    }

    public long getProgress() {
        return this.mProgress;
    }
}
