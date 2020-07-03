package com.baidu.tbadk.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private Context mContext;
    private Toast mToast;
    private Handler mToastHandler;
    private ImageView tipImage;
    private TextView tipText;
    private View tipView;
    public long toastTime = 3000;
    private int imageID = -1;
    private int stringID = -1;
    private Runnable mToastRunnable = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mToast != null) {
                c.this.mToast.cancel();
            }
        }
    };

    public c() {
        this.mContext = null;
        this.tipView = null;
        this.tipText = null;
        this.tipImage = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.tipView = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.tipText = (TextView) this.tipView.findViewById(R.id.tip_text);
        this.tipImage = (ImageView) this.tipView.findViewById(R.id.tip_iamge);
        this.tipView.setBackgroundDrawable(an.aG(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32), an.getColor(R.color.cp_hud_a)));
        an.setViewTextColor(this.tipText, (int) R.color.cp_cont_a);
        this.mToastHandler = new Handler();
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
        this.tipImage.setImageResource(R.drawable.icon_toast_game_ok);
        showViewToast(this.tipView);
    }

    public void showFailToast(CharSequence charSequence) {
        this.tipText.setText(charSequence);
        this.tipImage.setImageResource(R.drawable.icon_toast_game_error);
        showViewToast(this.tipView);
    }
}
