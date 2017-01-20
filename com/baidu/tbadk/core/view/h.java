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
    private View adY;
    private TextView adZ;
    private ImageView aea;
    private Context mContext;
    private Toast sd;
    public long adV = 3000;
    private int adW = -1;
    private int adX = -1;
    private Runnable aec = new i(this);
    private Handler aeb = new Handler();

    public h() {
        this.mContext = null;
        this.adY = null;
        this.adZ = null;
        this.aea = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.adY = LayoutInflater.from(this.mContext).inflate(r.j.image_toast_view, (ViewGroup) null);
        this.adZ = (TextView) this.adY.findViewById(r.h.tip_text);
        this.aea = (ImageView) this.adY.findViewById(r.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.adZ.setText(i2);
        this.aea.setImageResource(i);
        C(this.adY);
    }

    public void C(View view) {
        this.aeb.removeCallbacks(this.aec);
        if (this.sd == null) {
            this.sd = new Toast(this.mContext);
        }
        this.aeb.postDelayed(this.aec, this.adV);
        this.sd.setView(view);
        this.sd.setDuration(1);
        this.sd.setGravity(17, 0, 0);
        this.sd.show();
    }

    public void c(CharSequence charSequence) {
        this.adZ.setText(charSequence);
        this.aea.setImageResource(r.g.icon_toast_game_ok);
        C(this.adY);
    }

    public void d(CharSequence charSequence) {
        this.adZ.setText(charSequence);
        this.aea.setImageResource(r.g.icon_toast_game_error);
        C(this.adY);
    }

    public void vT() {
        if (this.sd != null) {
            this.sd.cancel();
        }
    }
}
