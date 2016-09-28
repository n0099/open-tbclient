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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private View aeW;
    private TextView aeX;
    private ImageView aeY;
    private Context mContext;
    private Toast sk;
    public long aeT = 3000;
    private int aeU = -1;
    private int aeV = -1;
    private Runnable afa = new i(this);
    private Handler aeZ = new Handler();

    public h() {
        this.mContext = null;
        this.aeW = null;
        this.aeX = null;
        this.aeY = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.aeW = LayoutInflater.from(this.mContext).inflate(r.h.image_toast_view, (ViewGroup) null);
        this.aeX = (TextView) this.aeW.findViewById(r.g.tip_text);
        this.aeY = (ImageView) this.aeW.findViewById(r.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aeX.setText(i2);
        this.aeY.setImageResource(i);
        E(this.aeW);
    }

    public void E(View view) {
        this.aeZ.removeCallbacks(this.afa);
        if (this.sk == null) {
            this.sk = new Toast(this.mContext);
        }
        this.aeZ.postDelayed(this.afa, this.aeT);
        this.sk.setView(view);
        this.sk.setDuration(1);
        this.sk.setGravity(17, 0, 0);
        this.sk.show();
    }

    public void c(CharSequence charSequence) {
        this.aeX.setText(charSequence);
        this.aeY.setImageResource(r.f.icon_toast_game_ok);
        E(this.aeW);
    }

    public void d(CharSequence charSequence) {
        this.aeX.setText(charSequence);
        this.aeY.setImageResource(r.f.icon_toast_game_error);
        E(this.aeW);
    }

    public void wl() {
        if (this.sk != null) {
            this.sk.cancel();
        }
    }
}
