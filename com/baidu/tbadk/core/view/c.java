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
    private View akJ;
    private TextView akK;
    private ImageView akL;
    private Context mContext;
    private Toast yz;
    public long akG = 3000;
    private int akH = -1;
    private int akI = -1;
    private Runnable akN = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.yz != null) {
                c.this.yz.cancel();
            }
        }
    };
    private Handler akM = new Handler();

    public c() {
        this.mContext = null;
        this.akJ = null;
        this.akK = null;
        this.akL = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.akJ = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.akK = (TextView) this.akJ.findViewById(d.h.tip_text);
        this.akL = (ImageView) this.akJ.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.akK.setText(i2);
        this.akL.setImageResource(i);
        A(this.akJ);
    }

    public void A(View view) {
        this.akM.removeCallbacks(this.akN);
        if (this.yz == null) {
            this.yz = new Toast(this.mContext);
        }
        this.akM.postDelayed(this.akN, this.akG);
        this.yz.setView(view);
        this.yz.setDuration(1);
        this.yz.setGravity(17, 0, 0);
        this.yz.show();
    }

    public void c(CharSequence charSequence) {
        this.akK.setText(charSequence);
        this.akL.setImageResource(d.g.icon_toast_game_ok);
        A(this.akJ);
    }

    public void d(CharSequence charSequence) {
        this.akK.setText(charSequence);
        this.akL.setImageResource(d.g.icon_toast_game_error);
        A(this.akJ);
    }

    public void wC() {
        if (this.yz != null) {
            this.yz.cancel();
        }
    }
}
