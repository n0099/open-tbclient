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
    private View bPQ;
    private TextView bPR;
    private ImageView bPS;
    private Context mContext;
    public long bPN = 3000;
    private int bPO = -1;
    private int bPP = -1;
    private Runnable bPU = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Gu != null) {
                e.this.Gu.cancel();
            }
        }
    };
    private Handler bPT = new Handler();

    public e() {
        this.mContext = null;
        this.bPQ = null;
        this.bPR = null;
        this.bPS = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bPQ = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bPR = (TextView) this.bPQ.findViewById(d.g.tip_text);
        this.bPS = (ImageView) this.bPQ.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bPR.setText(i2);
        this.bPS.setImageResource(i);
        aG(this.bPQ);
    }

    public void aG(View view) {
        this.bPT.removeCallbacks(this.bPU);
        if (this.Gu == null) {
            this.Gu = new Toast(this.mContext);
        }
        this.bPT.postDelayed(this.bPU, this.bPN);
        this.Gu.setView(view);
        this.Gu.setDuration(1);
        this.Gu.setGravity(17, 0, 0);
        this.Gu.show();
    }

    public void i(CharSequence charSequence) {
        this.bPR.setText(charSequence);
        this.bPS.setImageResource(d.f.icon_toast_game_ok);
        aG(this.bPQ);
    }

    public void j(CharSequence charSequence) {
        this.bPR.setText(charSequence);
        this.bPS.setImageResource(d.f.icon_toast_game_error);
        aG(this.bPQ);
    }
}
