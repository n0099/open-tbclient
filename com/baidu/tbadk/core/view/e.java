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
    private View bPR;
    private TextView bPS;
    private ImageView bPT;
    private Context mContext;
    public long bPO = 3000;
    private int bPP = -1;
    private int bPQ = -1;
    private Runnable bPV = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Gu != null) {
                e.this.Gu.cancel();
            }
        }
    };
    private Handler bPU = new Handler();

    public e() {
        this.mContext = null;
        this.bPR = null;
        this.bPS = null;
        this.bPT = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bPR = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bPS = (TextView) this.bPR.findViewById(d.g.tip_text);
        this.bPT = (ImageView) this.bPR.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bPS.setText(i2);
        this.bPT.setImageResource(i);
        aG(this.bPR);
    }

    public void aG(View view) {
        this.bPU.removeCallbacks(this.bPV);
        if (this.Gu == null) {
            this.Gu = new Toast(this.mContext);
        }
        this.bPU.postDelayed(this.bPV, this.bPO);
        this.Gu.setView(view);
        this.Gu.setDuration(1);
        this.Gu.setGravity(17, 0, 0);
        this.Gu.show();
    }

    public void i(CharSequence charSequence) {
        this.bPS.setText(charSequence);
        this.bPT.setImageResource(d.f.icon_toast_game_ok);
        aG(this.bPR);
    }

    public void j(CharSequence charSequence) {
        this.bPS.setText(charSequence);
        this.bPT.setImageResource(d.f.icon_toast_game_error);
        aG(this.bPR);
    }
}
