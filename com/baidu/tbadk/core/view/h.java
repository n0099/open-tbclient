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
    private View ajC;
    private TextView ajD;
    private ImageView ajE;
    private Context mContext;
    private Toast zc;
    public long ajz = 3000;
    private int ajA = -1;
    private int ajB = -1;
    private Runnable ajG = new i(this);
    private Handler ajF = new Handler();

    public h() {
        this.mContext = null;
        this.ajC = null;
        this.ajD = null;
        this.ajE = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.ajC = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.ajD = (TextView) this.ajC.findViewById(w.h.tip_text);
        this.ajE = (ImageView) this.ajC.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ajD.setText(i2);
        this.ajE.setImageResource(i);
        A(this.ajC);
    }

    public void A(View view) {
        this.ajF.removeCallbacks(this.ajG);
        if (this.zc == null) {
            this.zc = new Toast(this.mContext);
        }
        this.ajF.postDelayed(this.ajG, this.ajz);
        this.zc.setView(view);
        this.zc.setDuration(1);
        this.zc.setGravity(17, 0, 0);
        this.zc.show();
    }

    public void c(CharSequence charSequence) {
        this.ajD.setText(charSequence);
        this.ajE.setImageResource(w.g.icon_toast_game_ok);
        A(this.ajC);
    }

    public void d(CharSequence charSequence) {
        this.ajD.setText(charSequence);
        this.ajE.setImageResource(w.g.icon_toast_game_error);
        A(this.ajC);
    }

    public void wM() {
        if (this.zc != null) {
            this.zc.cancel();
        }
    }
}
