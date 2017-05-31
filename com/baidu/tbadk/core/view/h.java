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
    private View aiP;
    private TextView aiQ;
    private ImageView aiR;
    private Context mContext;
    private Toast zd;
    public long aiM = 3000;
    private int aiN = -1;
    private int aiO = -1;
    private Runnable aiT = new i(this);
    private Handler aiS = new Handler();

    public h() {
        this.mContext = null;
        this.aiP = null;
        this.aiQ = null;
        this.aiR = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.aiP = LayoutInflater.from(this.mContext).inflate(w.j.image_toast_view, (ViewGroup) null);
        this.aiQ = (TextView) this.aiP.findViewById(w.h.tip_text);
        this.aiR = (ImageView) this.aiP.findViewById(w.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aiQ.setText(i2);
        this.aiR.setImageResource(i);
        A(this.aiP);
    }

    public void A(View view) {
        this.aiS.removeCallbacks(this.aiT);
        if (this.zd == null) {
            this.zd = new Toast(this.mContext);
        }
        this.aiS.postDelayed(this.aiT, this.aiM);
        this.zd.setView(view);
        this.zd.setDuration(1);
        this.zd.setGravity(17, 0, 0);
        this.zd.show();
    }

    public void c(CharSequence charSequence) {
        this.aiQ.setText(charSequence);
        this.aiR.setImageResource(w.g.icon_toast_game_ok);
        A(this.aiP);
    }

    public void d(CharSequence charSequence) {
        this.aiQ.setText(charSequence);
        this.aiR.setImageResource(w.g.icon_toast_game_error);
        A(this.aiP);
    }

    public void vW() {
        if (this.zd != null) {
            this.zd.cancel();
        }
    }
}
