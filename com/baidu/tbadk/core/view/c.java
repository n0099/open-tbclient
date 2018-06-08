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
public class c {
    private Toast Dq;
    private View auD;
    private TextView auE;
    private ImageView auF;
    private Context mContext;
    public long auA = 3000;
    private int auB = -1;
    private int auC = -1;
    private Runnable auH = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.Dq != null) {
                c.this.Dq.cancel();
            }
        }
    };
    private Handler auG = new Handler();

    public c() {
        this.mContext = null;
        this.auD = null;
        this.auE = null;
        this.auF = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.auD = LayoutInflater.from(this.mContext).inflate(d.i.image_toast_view, (ViewGroup) null);
        this.auE = (TextView) this.auD.findViewById(d.g.tip_text);
        this.auF = (ImageView) this.auD.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.auE.setText(i2);
        this.auF.setImageResource(i);
        B(this.auD);
    }

    public void B(View view) {
        this.auG.removeCallbacks(this.auH);
        if (this.Dq == null) {
            this.Dq = new Toast(this.mContext);
        }
        this.auG.postDelayed(this.auH, this.auA);
        this.Dq.setView(view);
        this.Dq.setDuration(1);
        this.Dq.setGravity(17, 0, 0);
        this.Dq.show();
    }

    public void i(CharSequence charSequence) {
        this.auE.setText(charSequence);
        this.auF.setImageResource(d.f.icon_toast_game_ok);
        B(this.auD);
    }

    public void j(CharSequence charSequence) {
        this.auE.setText(charSequence);
        this.auF.setImageResource(d.f.icon_toast_game_error);
        B(this.auD);
    }
}
