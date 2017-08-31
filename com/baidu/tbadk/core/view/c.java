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
    private View akK;
    private TextView akL;
    private ImageView akM;
    private Context mContext;
    private Toast yz;
    public long akH = 3000;
    private int akI = -1;
    private int akJ = -1;
    private Runnable akO = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.yz != null) {
                c.this.yz.cancel();
            }
        }
    };
    private Handler akN = new Handler();

    public c() {
        this.mContext = null;
        this.akK = null;
        this.akL = null;
        this.akM = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.akK = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.akL = (TextView) this.akK.findViewById(d.h.tip_text);
        this.akM = (ImageView) this.akK.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.akL.setText(i2);
        this.akM.setImageResource(i);
        A(this.akK);
    }

    public void A(View view) {
        this.akN.removeCallbacks(this.akO);
        if (this.yz == null) {
            this.yz = new Toast(this.mContext);
        }
        this.akN.postDelayed(this.akO, this.akH);
        this.yz.setView(view);
        this.yz.setDuration(1);
        this.yz.setGravity(17, 0, 0);
        this.yz.show();
    }

    public void c(CharSequence charSequence) {
        this.akL.setText(charSequence);
        this.akM.setImageResource(d.g.icon_toast_game_ok);
        A(this.akK);
    }

    public void d(CharSequence charSequence) {
        this.akL.setText(charSequence);
        this.akM.setImageResource(d.g.icon_toast_game_error);
        A(this.akK);
    }

    public void wC() {
        if (this.yz != null) {
            this.yz.cancel();
        }
    }
}
