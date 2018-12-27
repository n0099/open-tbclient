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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class g {
    private Toast Gv;
    private View aHg;
    private TextView aHh;
    private ImageView aHi;
    private Context mContext;
    public long aHd = 3000;
    private int aHe = -1;
    private int aHf = -1;
    private Runnable aHk = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gv != null) {
                g.this.Gv.cancel();
            }
        }
    };
    private Handler aHj = new Handler();

    public g() {
        this.mContext = null;
        this.aHg = null;
        this.aHh = null;
        this.aHi = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aHg = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aHh = (TextView) this.aHg.findViewById(e.g.tip_text);
        this.aHi = (ImageView) this.aHg.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aHh.setText(i2);
        this.aHi.setImageResource(i);
        M(this.aHg);
    }

    public void M(View view) {
        this.aHj.removeCallbacks(this.aHk);
        if (this.Gv == null) {
            this.Gv = new Toast(this.mContext);
        }
        this.aHj.postDelayed(this.aHk, this.aHd);
        this.Gv.setView(view);
        this.Gv.setDuration(1);
        this.Gv.setGravity(17, 0, 0);
        this.Gv.show();
    }

    public void e(CharSequence charSequence) {
        this.aHh.setText(charSequence);
        this.aHi.setImageResource(e.f.icon_toast_game_ok);
        M(this.aHg);
    }

    public void f(CharSequence charSequence) {
        this.aHh.setText(charSequence);
        this.aHi.setImageResource(e.f.icon_toast_game_error);
        M(this.aHg);
    }
}
