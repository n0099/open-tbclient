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
    private View aHJ;
    private TextView aHK;
    private ImageView aHL;
    private Context mContext;
    public long aHG = 3000;
    private int aHH = -1;
    private int aHI = -1;
    private Runnable aHN = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gv != null) {
                g.this.Gv.cancel();
            }
        }
    };
    private Handler aHM = new Handler();

    public g() {
        this.mContext = null;
        this.aHJ = null;
        this.aHK = null;
        this.aHL = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aHJ = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aHK = (TextView) this.aHJ.findViewById(e.g.tip_text);
        this.aHL = (ImageView) this.aHJ.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aHK.setText(i2);
        this.aHL.setImageResource(i);
        M(this.aHJ);
    }

    public void M(View view) {
        this.aHM.removeCallbacks(this.aHN);
        if (this.Gv == null) {
            this.Gv = new Toast(this.mContext);
        }
        this.aHM.postDelayed(this.aHN, this.aHG);
        this.Gv.setView(view);
        this.Gv.setDuration(1);
        this.Gv.setGravity(17, 0, 0);
        this.Gv.show();
    }

    public void e(CharSequence charSequence) {
        this.aHK.setText(charSequence);
        this.aHL.setImageResource(e.f.icon_toast_game_ok);
        M(this.aHJ);
    }

    public void f(CharSequence charSequence) {
        this.aHK.setText(charSequence);
        this.aHL.setImageResource(e.f.icon_toast_game_error);
        M(this.aHJ);
    }
}
