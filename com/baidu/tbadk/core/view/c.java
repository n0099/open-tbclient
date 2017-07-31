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
    private Toast AE;
    private View alp;
    private TextView alq;
    private ImageView alr;
    private Context mContext;
    public long alm = 3000;
    private int aln = -1;
    private int alo = -1;
    private Runnable alt = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.AE != null) {
                c.this.AE.cancel();
            }
        }
    };
    private Handler als = new Handler();

    public c() {
        this.mContext = null;
        this.alp = null;
        this.alq = null;
        this.alr = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.alp = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.alq = (TextView) this.alp.findViewById(d.h.tip_text);
        this.alr = (ImageView) this.alp.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.alq.setText(i2);
        this.alr.setImageResource(i);
        A(this.alp);
    }

    public void A(View view) {
        this.als.removeCallbacks(this.alt);
        if (this.AE == null) {
            this.AE = new Toast(this.mContext);
        }
        this.als.postDelayed(this.alt, this.alm);
        this.AE.setView(view);
        this.AE.setDuration(1);
        this.AE.setGravity(17, 0, 0);
        this.AE.show();
    }

    public void c(CharSequence charSequence) {
        this.alq.setText(charSequence);
        this.alr.setImageResource(d.g.icon_toast_game_ok);
        A(this.alp);
    }

    public void d(CharSequence charSequence) {
        this.alq.setText(charSequence);
        this.alr.setImageResource(d.g.icon_toast_game_error);
        A(this.alp);
    }

    public void wE() {
        if (this.AE != null) {
            this.AE.cancel();
        }
    }
}
