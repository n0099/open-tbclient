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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private View aaR;
    private TextView aaS;
    private ImageView aaT;
    private Context mContext;
    private Toast pv;
    public long aaO = 3000;
    private int aaP = -1;
    private int aaQ = -1;
    private Runnable aaV = new i(this);
    private Handler aaU = new Handler();

    public h() {
        this.mContext = null;
        this.aaR = null;
        this.aaS = null;
        this.aaT = null;
        this.mContext = TbadkCoreApplication.m11getInst().getContext();
        this.aaR = LayoutInflater.from(this.mContext).inflate(t.h.image_toast_view, (ViewGroup) null);
        this.aaS = (TextView) this.aaR.findViewById(t.g.tip_text);
        this.aaT = (ImageView) this.aaR.findViewById(t.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aaS.setText(i2);
        this.aaT.setImageResource(i);
        E(this.aaR);
    }

    public void E(View view) {
        this.aaU.removeCallbacks(this.aaV);
        if (this.pv == null) {
            this.pv = new Toast(this.mContext);
        }
        this.aaU.postDelayed(this.aaV, this.aaO);
        this.pv.setView(view);
        this.pv.setDuration(1);
        this.pv.setGravity(17, 0, 0);
        this.pv.show();
    }

    public void c(CharSequence charSequence) {
        this.aaS.setText(charSequence);
        this.aaT.setImageResource(t.f.icon_toast_game_ok);
        E(this.aaR);
    }

    public void d(CharSequence charSequence) {
        this.aaS.setText(charSequence);
        this.aaT.setImageResource(t.f.icon_toast_game_error);
        E(this.aaR);
    }

    public void uT() {
        if (this.pv != null) {
            this.pv.cancel();
        }
    }
}
