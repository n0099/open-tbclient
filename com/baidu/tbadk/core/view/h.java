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
    private View abk;
    private TextView abl;
    private ImageView abm;
    private Context mContext;
    private Toast pv;
    public long abh = 3000;
    private int abi = -1;
    private int abj = -1;
    private Runnable abo = new i(this);
    private Handler abn = new Handler();

    public h() {
        this.mContext = null;
        this.abk = null;
        this.abl = null;
        this.abm = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.abk = LayoutInflater.from(this.mContext).inflate(u.h.image_toast_view, (ViewGroup) null);
        this.abl = (TextView) this.abk.findViewById(u.g.tip_text);
        this.abm = (ImageView) this.abk.findViewById(u.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.abl.setText(i2);
        this.abm.setImageResource(i);
        D(this.abk);
    }

    public void D(View view) {
        this.abn.removeCallbacks(this.abo);
        if (this.pv == null) {
            this.pv = new Toast(this.mContext);
        }
        this.abn.postDelayed(this.abo, this.abh);
        this.pv.setView(view);
        this.pv.setDuration(1);
        this.pv.setGravity(17, 0, 0);
        this.pv.show();
    }

    public void c(CharSequence charSequence) {
        this.abl.setText(charSequence);
        this.abm.setImageResource(u.f.icon_toast_game_ok);
        D(this.abk);
    }

    public void d(CharSequence charSequence) {
        this.abl.setText(charSequence);
        this.abm.setImageResource(u.f.icon_toast_game_error);
        D(this.abk);
    }

    public void uT() {
        if (this.pv != null) {
            this.pv.cancel();
        }
    }
}
