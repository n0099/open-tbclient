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
public class d {
    private View alo;
    private TextView alp;
    private ImageView alq;
    private Context mContext;
    private Toast yz;
    public long alk = 3000;
    private int alm = -1;
    private int aln = -1;
    private Runnable als = new Runnable() { // from class: com.baidu.tbadk.core.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.yz != null) {
                d.this.yz.cancel();
            }
        }
    };
    private Handler alr = new Handler();

    public d() {
        this.mContext = null;
        this.alo = null;
        this.alp = null;
        this.alq = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.alo = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.alp = (TextView) this.alo.findViewById(d.g.tip_text);
        this.alq = (ImageView) this.alo.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.alp.setText(i2);
        this.alq.setImageResource(i);
        A(this.alo);
    }

    public void A(View view) {
        this.alr.removeCallbacks(this.als);
        if (this.yz == null) {
            this.yz = new Toast(this.mContext);
        }
        this.alr.postDelayed(this.als, this.alk);
        this.yz.setView(view);
        this.yz.setDuration(1);
        this.yz.setGravity(17, 0, 0);
        this.yz.show();
    }

    public void c(CharSequence charSequence) {
        this.alp.setText(charSequence);
        this.alq.setImageResource(d.f.icon_toast_game_ok);
        A(this.alo);
    }

    public void d(CharSequence charSequence) {
        this.alp.setText(charSequence);
        this.alq.setImageResource(d.f.icon_toast_game_error);
        A(this.alo);
    }
}
