package com.baidu.tbadk.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private Context mContext;
    private Toast mToast;
    public long toastTime = IMConnection.RETRY_DELAY_TIMES;
    private int imageID = -1;
    private int stringID = -1;
    private View tipView = null;
    private TextView tipText = null;
    private ImageView tipImage = null;
    private Runnable mToastRunnable = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mToast != null) {
                c.this.mToast.cancel();
            }
        }
    };
    private Handler mToastHandler = new Handler();

    public c() {
        this.mContext = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
    }

    public void showToast(int i, int i2) {
        this.tipView = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.tipText = (TextView) this.tipView.findViewById(R.id.tip_text);
        this.tipImage = (ImageView) this.tipView.findViewById(R.id.tip_iamge);
        this.tipView.setBackgroundDrawable(ao.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32), ao.getColor(R.color.CAM_X0701)));
        ao.setViewTextColor(this.tipText, R.color.CAM_X0101);
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
        this.tipView = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.tipText = (TextView) this.tipView.findViewById(R.id.tip_text);
        this.tipImage = (ImageView) this.tipView.findViewById(R.id.tip_iamge);
        this.tipView.setBackgroundDrawable(ao.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32), ao.getColor(R.color.CAM_X0701)));
        ao.setViewTextColor(this.tipText, R.color.CAM_X0101);
        this.tipText.setText(charSequence);
        this.tipImage.setImageResource(R.drawable.icon_toast_game_ok);
        showViewToast(this.tipView);
    }

    public void showFailToast(CharSequence charSequence) {
        this.tipView = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.tipText = (TextView) this.tipView.findViewById(R.id.tip_text);
        this.tipImage = (ImageView) this.tipView.findViewById(R.id.tip_iamge);
        this.tipView.setBackgroundDrawable(ao.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32), ao.getColor(R.color.CAM_X0701)));
        ao.setViewTextColor(this.tipText, R.color.CAM_X0101);
        this.tipText.setText(charSequence);
        this.tipImage.setImageResource(R.drawable.icon_toast_game_error);
        showViewToast(this.tipView);
    }
}
