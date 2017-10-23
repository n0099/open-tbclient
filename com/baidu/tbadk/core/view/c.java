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
    private ImageView akA;
    private View aky;
    private TextView akz;
    private Context mContext;
    private Toast yC;
    public long akv = 3000;
    private int akw = -1;
    private int akx = -1;
    private Runnable akC = new Runnable() { // from class: com.baidu.tbadk.core.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.yC != null) {
                c.this.yC.cancel();
            }
        }
    };
    private Handler akB = new Handler();

    public c() {
        this.mContext = null;
        this.aky = null;
        this.akz = null;
        this.akA = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aky = LayoutInflater.from(this.mContext).inflate(d.j.image_toast_view, (ViewGroup) null);
        this.akz = (TextView) this.aky.findViewById(d.h.tip_text);
        this.akA = (ImageView) this.aky.findViewById(d.h.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.akz.setText(i2);
        this.akA.setImageResource(i);
        A(this.aky);
    }

    public void A(View view) {
        this.akB.removeCallbacks(this.akC);
        if (this.yC == null) {
            this.yC = new Toast(this.mContext);
        }
        this.akB.postDelayed(this.akC, this.akv);
        this.yC.setView(view);
        this.yC.setDuration(1);
        this.yC.setGravity(17, 0, 0);
        this.yC.show();
    }

    public void c(CharSequence charSequence) {
        this.akz.setText(charSequence);
        this.akA.setImageResource(d.g.icon_toast_game_ok);
        A(this.aky);
    }

    public void d(CharSequence charSequence) {
        this.akz.setText(charSequence);
        this.akA.setImageResource(d.g.icon_toast_game_error);
        A(this.aky);
    }
}
