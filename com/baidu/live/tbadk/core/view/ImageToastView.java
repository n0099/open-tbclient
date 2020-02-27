package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ImageToastView {
    private Context mContext;
    private Toast mToast;
    private ImageView tipImage;
    private TextView tipText;
    private View tipView;
    public long toastTime = 3000;
    private int imageID = -1;
    private int stringID = -1;
    private Runnable mToastRunnable = new Runnable() { // from class: com.baidu.live.tbadk.core.view.ImageToastView.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageToastView.this.mToast != null) {
                ImageToastView.this.mToast.cancel();
            }
        }
    };
    private Handler mToastHandler = new Handler();

    public ImageToastView() {
        this.mContext = null;
        this.tipView = null;
        this.tipText = null;
        this.tipImage = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.tipView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_image_toast_view, (ViewGroup) null);
        this.tipText = (TextView) this.tipView.findViewById(a.g.tip_text);
        this.tipImage = (ImageView) this.tipView.findViewById(a.g.tip_iamge);
    }

    public void showSuccessToast() {
        this.tipText.setText(a.i.sdk_success);
        this.tipImage.setImageResource(a.f.sdk_icon_toast_game_ok);
        showViewToast(this.tipView);
    }

    public void showFailToast() {
        this.tipText.setText(a.i.sdk_fail);
        this.tipImage.setImageResource(a.f.sdk_icon_toast_game_error);
        showViewToast(this.tipView);
    }

    public void showToast(int i, int i2) {
        this.tipText.setText(i2);
        this.tipImage.setImageResource(i);
        showViewToast(this.tipView);
    }

    public void showViewToast(View view) {
        this.mToastHandler.removeCallbacks(this.mToastRunnable);
        if (this.mToast == null) {
            this.mToast = new Toast(this.mContext);
        }
        this.mToastHandler.postDelayed(this.mToastRunnable, this.toastTime);
        this.mToast.setView(view);
        this.mToast.setDuration(1);
        this.mToast.setGravity(17, 0, 0);
        this.mToast.show();
    }

    public void showSuccessToast(CharSequence charSequence) {
        this.tipText.setText(charSequence);
        this.tipImage.setImageResource(a.f.sdk_icon_toast_game_ok);
        showViewToast(this.tipView);
    }

    public void showFailToast(CharSequence charSequence) {
        this.tipText.setText(charSequence);
        this.tipImage.setImageResource(a.f.sdk_icon_toast_game_error);
        showViewToast(this.tipView);
    }

    public void setImageID(int i) {
        this.imageID = i;
    }

    public void setStringID(int i) {
        this.stringID = i;
    }

    public void cancelToast() {
        if (this.mToast != null) {
            this.mToast.cancel();
        }
    }
}
