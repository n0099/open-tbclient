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
    private View aeN;
    private TextView aeO;
    private ImageView aeP;
    private Context mContext;
    private Toast sl;
    public long aeK = 3000;
    private int aeL = -1;
    private int aeM = -1;
    private Runnable aeR = new i(this);
    private Handler aeQ = new Handler();

    public h() {
        this.mContext = null;
        this.aeN = null;
        this.aeO = null;
        this.aeP = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.aeN = LayoutInflater.from(this.mContext).inflate(r.h.image_toast_view, (ViewGroup) null);
        this.aeO = (TextView) this.aeN.findViewById(r.g.tip_text);
        this.aeP = (ImageView) this.aeN.findViewById(r.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aeO.setText(i2);
        this.aeP.setImageResource(i);
        E(this.aeN);
    }

    public void E(View view) {
        this.aeQ.removeCallbacks(this.aeR);
        if (this.sl == null) {
            this.sl = new Toast(this.mContext);
        }
        this.aeQ.postDelayed(this.aeR, this.aeK);
        this.sl.setView(view);
        this.sl.setDuration(1);
        this.sl.setGravity(17, 0, 0);
        this.sl.show();
    }

    public void c(CharSequence charSequence) {
        this.aeO.setText(charSequence);
        this.aeP.setImageResource(r.f.icon_toast_game_ok);
        E(this.aeN);
    }

    public void d(CharSequence charSequence) {
        this.aeO.setText(charSequence);
        this.aeP.setImageResource(r.f.icon_toast_game_error);
        E(this.aeN);
    }

    public void vZ() {
        if (this.sl != null) {
            this.sl.cancel();
        }
    }
}
