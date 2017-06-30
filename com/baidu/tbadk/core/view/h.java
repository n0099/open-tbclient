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
    private View ajx;
    private TextView ajy;
    private ImageView ajz;
    private Context mContext;
    private Toast zd;
    public long aju = 3000;
    private int ajv = -1;
    private int ajw = -1;
    private Runnable ajB = new i(this);
    private Handler ajA = new Handler();

    public h() {
        this.mContext = null;
        this.ajx = null;
        this.ajy = null;
        this.ajz = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.ajx = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.ajy = (TextView) this.ajx.findViewById(w.h.tip_text);
        this.ajz = (ImageView) this.ajx.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ajy.setText(i2);
        this.ajz.setImageResource(i);
        A(this.ajx);
    }

    public void A(View view) {
        this.ajA.removeCallbacks(this.ajB);
        if (this.zd == null) {
            this.zd = new Toast(this.mContext);
        }
        this.ajA.postDelayed(this.ajB, this.aju);
        this.zd.setView(view);
        this.zd.setDuration(1);
        this.zd.setGravity(17, 0, 0);
        this.zd.show();
    }

    public void c(CharSequence charSequence) {
        this.ajy.setText(charSequence);
        this.ajz.setImageResource(w.g.icon_toast_game_ok);
        A(this.ajx);
    }

    public void d(CharSequence charSequence) {
        this.ajy.setText(charSequence);
        this.ajz.setImageResource(w.g.icon_toast_game_error);
        A(this.ajx);
    }

    public void wn() {
        if (this.zd != null) {
            this.zd.cancel();
        }
    }
}
