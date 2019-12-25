package com.baidu.searchbox.ugc.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class UploadPhotosDialog extends Dialog {
    private CancalProgressListener mListener;
    private ProgressBar mProgressBar;
    private TextView mProgressTv;
    private TextView mUploadingWordTv;
    private WeakReference<Activity> mWeakRefContext;

    /* loaded from: classes11.dex */
    public interface CancalProgressListener {
        void cancel();
    }

    public void setListener(CancalProgressListener cancalProgressListener) {
        this.mListener = cancalProgressListener;
    }

    public UploadPhotosDialog(Activity activity) {
        super(activity, R.style.ugc_upload_photo_dialog);
        this.mWeakRefContext = new WeakReference<>(activity);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ugc_upload_photos_dialog);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        initView();
    }

    private void initView() {
        this.mProgressTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_upload_numbers"));
        this.mProgressBar = (ProgressBar) findViewById(ResourceUtils.getResIdByName("ugc_upload_progressbar"));
        this.mUploadingWordTv = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_upload_uploading_word"));
        updateUi();
    }

    private void updateUi() {
        UgcUiUtils.setViewDrawable(findViewById(ResourceUtils.getResIdByName("ugc_upload_root")), R.drawable.ugc_upload_photos_dialog_bg);
        UgcUiUtils.setTextResource(this.mProgressTv, R.color.ugc_upload_images_numbers_text_color);
        Activity activity = this.mWeakRefContext.get();
        if (activity != null && this.mProgressBar != null) {
            this.mProgressBar.setIndeterminateDrawable(activity.getResources().getDrawable(R.drawable.ugc_upload_images_round_progress));
        }
        UgcUiUtils.setTextResource(this.mUploadingWordTv, R.color.ugc_upload_images_numbers_text_color);
    }

    public void notifyProgress(int i, int i2) {
        UiBaseUtils.setTextString(this.mProgressTv, String.valueOf((int) ((i / i2) * 100.0f)) + "%");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            if (this.mListener != null) {
                this.mListener.cancel();
            }
            return true;
        }
        return false;
    }
}
