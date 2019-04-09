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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private Toast Gu;
    private View bPU;
    private TextView bPV;
    private ImageView bPW;
    private Context mContext;
    public long bPR = 3000;
    private int bPS = -1;
    private int bPT = -1;
    private Runnable bPY = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Gu != null) {
                e.this.Gu.cancel();
            }
        }
    };
    private Handler bPX = new Handler();

    public e() {
        this.mContext = null;
        this.bPU = null;
        this.bPV = null;
        this.bPW = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bPU = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bPV = (TextView) this.bPU.findViewById(d.g.tip_text);
        this.bPW = (ImageView) this.bPU.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bPV.setText(i2);
        this.bPW.setImageResource(i);
        aG(this.bPU);
    }

    public void aG(View view) {
        this.bPX.removeCallbacks(this.bPY);
        if (this.Gu == null) {
            this.Gu = new Toast(this.mContext);
        }
        this.bPX.postDelayed(this.bPY, this.bPR);
        this.Gu.setView(view);
        this.Gu.setDuration(1);
        this.Gu.setGravity(17, 0, 0);
        this.Gu.show();
    }

    public void i(CharSequence charSequence) {
        this.bPV.setText(charSequence);
        this.bPW.setImageResource(d.f.icon_toast_game_ok);
        aG(this.bPU);
    }

    public void j(CharSequence charSequence) {
        this.bPV.setText(charSequence);
        this.bPW.setImageResource(d.f.icon_toast_game_error);
        aG(this.bPU);
    }
}
