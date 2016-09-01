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
    private View aeL;
    private TextView aeM;
    private ImageView aeN;
    private Context mContext;
    private Toast sk;
    public long aeI = 3000;
    private int aeJ = -1;
    private int aeK = -1;
    private Runnable aeP = new i(this);
    private Handler aeO = new Handler();

    public h() {
        this.mContext = null;
        this.aeL = null;
        this.aeM = null;
        this.aeN = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.aeL = LayoutInflater.from(this.mContext).inflate(t.h.image_toast_view, (ViewGroup) null);
        this.aeM = (TextView) this.aeL.findViewById(t.g.tip_text);
        this.aeN = (ImageView) this.aeL.findViewById(t.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aeM.setText(i2);
        this.aeN.setImageResource(i);
        E(this.aeL);
    }

    public void E(View view) {
        this.aeO.removeCallbacks(this.aeP);
        if (this.sk == null) {
            this.sk = new Toast(this.mContext);
        }
        this.aeO.postDelayed(this.aeP, this.aeI);
        this.sk.setView(view);
        this.sk.setDuration(1);
        this.sk.setGravity(17, 0, 0);
        this.sk.show();
    }

    public void c(CharSequence charSequence) {
        this.aeM.setText(charSequence);
        this.aeN.setImageResource(t.f.icon_toast_game_ok);
        E(this.aeL);
    }

    public void d(CharSequence charSequence) {
        this.aeM.setText(charSequence);
        this.aeN.setImageResource(t.f.icon_toast_game_error);
        E(this.aeL);
    }

    public void vX() {
        if (this.sk != null) {
            this.sk.cancel();
        }
    }
}
