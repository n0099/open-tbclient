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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    private View ajB;
    private TextView ajC;
    private ImageView ajD;
    private Context mContext;
    private Toast yZ;
    public long ajy = 3000;
    private int ajz = -1;
    private int ajA = -1;
    private Runnable ajF = new i(this);
    private Handler ajE = new Handler();

    public h() {
        this.mContext = null;
        this.ajB = null;
        this.ajC = null;
        this.ajD = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.ajB = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.ajC = (TextView) this.ajB.findViewById(w.h.tip_text);
        this.ajD = (ImageView) this.ajB.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ajC.setText(i2);
        this.ajD.setImageResource(i);
        A(this.ajB);
    }

    public void A(View view) {
        this.ajE.removeCallbacks(this.ajF);
        if (this.yZ == null) {
            this.yZ = new Toast(this.mContext);
        }
        this.ajE.postDelayed(this.ajF, this.ajy);
        this.yZ.setView(view);
        this.yZ.setDuration(1);
        this.yZ.setGravity(17, 0, 0);
        this.yZ.show();
    }

    public void c(CharSequence charSequence) {
        this.ajC.setText(charSequence);
        this.ajD.setImageResource(w.g.icon_toast_game_ok);
        A(this.ajB);
    }

    public void d(CharSequence charSequence) {
        this.ajC.setText(charSequence);
        this.ajD.setImageResource(w.g.icon_toast_game_error);
        A(this.ajB);
    }

    public void wM() {
        if (this.yZ != null) {
            this.yZ.cancel();
        }
    }
}
