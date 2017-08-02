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
    private View ajV;
    private TextView ajW;
    private ImageView ajX;
    private Context mContext;
    private Toast zd;
    public long ajS = 3000;
    private int ajT = -1;
    private int ajU = -1;
    private Runnable ajZ = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.zd != null) {
                c.this.zd.cancel();
            }
        }
    };
    private Handler ajY = new Handler();

    public c() {
        this.mContext = null;
        this.ajV = null;
        this.ajW = null;
        this.ajX = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.ajV = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.ajW = (TextView) this.ajV.findViewById(d.h.tip_text);
        this.ajX = (ImageView) this.ajV.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ajW.setText(i2);
        this.ajX.setImageResource(i);
        A(this.ajV);
    }

    public void A(View view) {
        this.ajY.removeCallbacks(this.ajZ);
        if (this.zd == null) {
            this.zd = new Toast(this.mContext);
        }
        this.ajY.postDelayed(this.ajZ, this.ajS);
        this.zd.setView(view);
        this.zd.setDuration(1);
        this.zd.setGravity(17, 0, 0);
        this.zd.show();
    }

    public void c(CharSequence charSequence) {
        this.ajW.setText(charSequence);
        this.ajX.setImageResource(d.g.icon_toast_game_ok);
        A(this.ajV);
    }

    public void d(CharSequence charSequence) {
        this.ajW.setText(charSequence);
        this.ajX.setImageResource(d.g.icon_toast_game_error);
        A(this.ajV);
    }

    public void wu() {
        if (this.zd != null) {
            this.zd.cancel();
        }
    }
}
