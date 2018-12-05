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
    private View aHf;
    private TextView aHg;
    private ImageView aHh;
    private Context mContext;
    public long aHc = 3000;
    private int aHd = -1;
    private int aHe = -1;
    private Runnable aHj = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gv != null) {
                g.this.Gv.cancel();
            }
        }
    };
    private Handler aHi = new Handler();

    public g() {
        this.mContext = null;
        this.aHf = null;
        this.aHg = null;
        this.aHh = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aHf = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aHg = (TextView) this.aHf.findViewById(e.g.tip_text);
        this.aHh = (ImageView) this.aHf.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aHg.setText(i2);
        this.aHh.setImageResource(i);
        M(this.aHf);
    }

    public void M(View view) {
        this.aHi.removeCallbacks(this.aHj);
        if (this.Gv == null) {
            this.Gv = new Toast(this.mContext);
        }
        this.aHi.postDelayed(this.aHj, this.aHc);
        this.Gv.setView(view);
        this.Gv.setDuration(1);
        this.Gv.setGravity(17, 0, 0);
        this.Gv.show();
    }

    public void e(CharSequence charSequence) {
        this.aHg.setText(charSequence);
        this.aHh.setImageResource(e.f.icon_toast_game_ok);
        M(this.aHf);
    }

    public void f(CharSequence charSequence) {
        this.aHg.setText(charSequence);
        this.aHh.setImageResource(e.f.icon_toast_game_error);
        M(this.aHf);
    }
}
