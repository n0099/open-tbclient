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
    private Toast AG;
    private View alr;
    private TextView als;
    private ImageView alt;
    private Context mContext;
    public long alo = 3000;
    private int alp = -1;
    private int alq = -1;
    private Runnable alv = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.AG != null) {
                c.this.AG.cancel();
            }
        }
    };
    private Handler alu = new Handler();

    public c() {
        this.mContext = null;
        this.alr = null;
        this.als = null;
        this.alt = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.alr = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.als = (TextView) this.alr.findViewById(d.h.tip_text);
        this.alt = (ImageView) this.alr.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.als.setText(i2);
        this.alt.setImageResource(i);
        A(this.alr);
    }

    public void A(View view) {
        this.alu.removeCallbacks(this.alv);
        if (this.AG == null) {
            this.AG = new Toast(this.mContext);
        }
        this.alu.postDelayed(this.alv, this.alo);
        this.AG.setView(view);
        this.AG.setDuration(1);
        this.AG.setGravity(17, 0, 0);
        this.AG.show();
    }

    public void c(CharSequence charSequence) {
        this.als.setText(charSequence);
        this.alt.setImageResource(d.g.icon_toast_game_ok);
        A(this.alr);
    }

    public void d(CharSequence charSequence) {
        this.als.setText(charSequence);
        this.alt.setImageResource(d.g.icon_toast_game_error);
        A(this.alr);
    }

    public void wE() {
        if (this.AG != null) {
            this.AG.cancel();
        }
    }
}
