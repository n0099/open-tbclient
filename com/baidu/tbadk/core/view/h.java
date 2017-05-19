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
    private View aiZ;
    private TextView aja;
    private ImageView ajb;
    private Context mContext;
    private Toast zd;
    public long aiW = 3000;
    private int aiX = -1;
    private int aiY = -1;
    private Runnable ajd = new i(this);
    private Handler ajc = new Handler();

    public h() {
        this.mContext = null;
        this.aiZ = null;
        this.aja = null;
        this.ajb = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.aiZ = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.aja = (TextView) this.aiZ.findViewById(w.h.tip_text);
        this.ajb = (ImageView) this.aiZ.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aja.setText(i2);
        this.ajb.setImageResource(i);
        A(this.aiZ);
    }

    public void A(View view) {
        this.ajc.removeCallbacks(this.ajd);
        if (this.zd == null) {
            this.zd = new Toast(this.mContext);
        }
        this.ajc.postDelayed(this.ajd, this.aiW);
        this.zd.setView(view);
        this.zd.setDuration(1);
        this.zd.setGravity(17, 0, 0);
        this.zd.show();
    }

    public void c(CharSequence charSequence) {
        this.aja.setText(charSequence);
        this.ajb.setImageResource(w.g.icon_toast_game_ok);
        A(this.aiZ);
    }

    public void d(CharSequence charSequence) {
        this.aja.setText(charSequence);
        this.ajb.setImageResource(w.g.icon_toast_game_error);
        A(this.aiZ);
    }

    public void vZ() {
        if (this.zd != null) {
            this.zd.cancel();
        }
    }
}
