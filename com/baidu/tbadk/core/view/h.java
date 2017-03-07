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
    private View ajn;
    private TextView ajo;
    private ImageView ajp;
    private Context mContext;
    private Toast zy;
    public long ajk = 3000;
    private int ajl = -1;
    private int ajm = -1;
    private Runnable ajr = new i(this);
    private Handler ajq = new Handler();

    public h() {
        this.mContext = null;
        this.ajn = null;
        this.ajo = null;
        this.ajp = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.ajn = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.ajo = (TextView) this.ajn.findViewById(w.h.tip_text);
        this.ajp = (ImageView) this.ajn.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ajo.setText(i2);
        this.ajp.setImageResource(i);
        A(this.ajn);
    }

    public void A(View view) {
        this.ajq.removeCallbacks(this.ajr);
        if (this.zy == null) {
            this.zy = new Toast(this.mContext);
        }
        this.ajq.postDelayed(this.ajr, this.ajk);
        this.zy.setView(view);
        this.zy.setDuration(1);
        this.zy.setGravity(17, 0, 0);
        this.zy.show();
    }

    public void c(CharSequence charSequence) {
        this.ajo.setText(charSequence);
        this.ajp.setImageResource(w.g.icon_toast_game_ok);
        A(this.ajn);
    }

    public void d(CharSequence charSequence) {
        this.ajo.setText(charSequence);
        this.ajp.setImageResource(w.g.icon_toast_game_error);
        A(this.ajn);
    }

    public void wq() {
        if (this.zy != null) {
            this.zy.cancel();
        }
    }
}
