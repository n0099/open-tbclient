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
    private View bPT;
    private TextView bPU;
    private ImageView bPV;
    private Context mContext;
    public long bPQ = 3000;
    private int bPR = -1;
    private int bPS = -1;
    private Runnable bPX = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Gu != null) {
                e.this.Gu.cancel();
            }
        }
    };
    private Handler bPW = new Handler();

    public e() {
        this.mContext = null;
        this.bPT = null;
        this.bPU = null;
        this.bPV = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bPT = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bPU = (TextView) this.bPT.findViewById(d.g.tip_text);
        this.bPV = (ImageView) this.bPT.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bPU.setText(i2);
        this.bPV.setImageResource(i);
        aG(this.bPT);
    }

    public void aG(View view) {
        this.bPW.removeCallbacks(this.bPX);
        if (this.Gu == null) {
            this.Gu = new Toast(this.mContext);
        }
        this.bPW.postDelayed(this.bPX, this.bPQ);
        this.Gu.setView(view);
        this.Gu.setDuration(1);
        this.Gu.setGravity(17, 0, 0);
        this.Gu.show();
    }

    public void i(CharSequence charSequence) {
        this.bPU.setText(charSequence);
        this.bPV.setImageResource(d.f.icon_toast_game_ok);
        aG(this.bPT);
    }

    public void j(CharSequence charSequence) {
        this.bPU.setText(charSequence);
        this.bPV.setImageResource(d.f.icon_toast_game_error);
        aG(this.bPT);
    }
}
