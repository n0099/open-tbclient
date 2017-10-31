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
    private View akU;
    private TextView akV;
    private ImageView akW;
    private Context mContext;
    private Toast yC;
    public long akR = 3000;
    private int akS = -1;
    private int akT = -1;
    private Runnable akY = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.yC != null) {
                c.this.yC.cancel();
            }
        }
    };
    private Handler akX = new Handler();

    public c() {
        this.mContext = null;
        this.akU = null;
        this.akV = null;
        this.akW = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.akU = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.akV = (TextView) this.akU.findViewById(d.g.tip_text);
        this.akW = (ImageView) this.akU.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.akV.setText(i2);
        this.akW.setImageResource(i);
        A(this.akU);
    }

    public void A(View view) {
        this.akX.removeCallbacks(this.akY);
        if (this.yC == null) {
            this.yC = new Toast(this.mContext);
        }
        this.akX.postDelayed(this.akY, this.akR);
        this.yC.setView(view);
        this.yC.setDuration(1);
        this.yC.setGravity(17, 0, 0);
        this.yC.show();
    }

    public void c(CharSequence charSequence) {
        this.akV.setText(charSequence);
        this.akW.setImageResource(d.f.icon_toast_game_ok);
        A(this.akU);
    }

    public void d(CharSequence charSequence) {
        this.akV.setText(charSequence);
        this.akW.setImageResource(d.f.icon_toast_game_error);
        A(this.akU);
    }
}
