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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    private View abV;
    private TextView abW;
    private ImageView abX;
    private Context mContext;
    private Toast pX;
    public long abS = 3000;
    private int abT = -1;
    private int abU = -1;
    private Runnable abZ = new i(this);
    private Handler abY = new Handler();

    public h() {
        this.mContext = null;
        this.abV = null;
        this.abW = null;
        this.abX = null;
        this.mContext = TbadkCoreApplication.m10getInst().getContext();
        this.abV = LayoutInflater.from(this.mContext).inflate(u.h.image_toast_view, (ViewGroup) null);
        this.abW = (TextView) this.abV.findViewById(u.g.tip_text);
        this.abX = (ImageView) this.abV.findViewById(u.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.abW.setText(i2);
        this.abX.setImageResource(i);
        D(this.abV);
    }

    public void D(View view) {
        this.abY.removeCallbacks(this.abZ);
        if (this.pX == null) {
            this.pX = new Toast(this.mContext);
        }
        this.abY.postDelayed(this.abZ, this.abS);
        this.pX.setView(view);
        this.pX.setDuration(1);
        this.pX.setGravity(17, 0, 0);
        this.pX.show();
    }

    public void c(CharSequence charSequence) {
        this.abW.setText(charSequence);
        this.abX.setImageResource(u.f.icon_toast_game_ok);
        D(this.abV);
    }

    public void d(CharSequence charSequence) {
        this.abW.setText(charSequence);
        this.abX.setImageResource(u.f.icon_toast_game_error);
        D(this.abV);
    }

    public void uT() {
        if (this.pX != null) {
            this.pX.cancel();
        }
    }
}
