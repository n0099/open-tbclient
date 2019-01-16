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
    private View aHI;
    private TextView aHJ;
    private ImageView aHK;
    private Context mContext;
    public long aHF = 3000;
    private int aHG = -1;
    private int aHH = -1;
    private Runnable aHM = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gv != null) {
                g.this.Gv.cancel();
            }
        }
    };
    private Handler aHL = new Handler();

    public g() {
        this.mContext = null;
        this.aHI = null;
        this.aHJ = null;
        this.aHK = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aHI = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aHJ = (TextView) this.aHI.findViewById(e.g.tip_text);
        this.aHK = (ImageView) this.aHI.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aHJ.setText(i2);
        this.aHK.setImageResource(i);
        M(this.aHI);
    }

    public void M(View view) {
        this.aHL.removeCallbacks(this.aHM);
        if (this.Gv == null) {
            this.Gv = new Toast(this.mContext);
        }
        this.aHL.postDelayed(this.aHM, this.aHF);
        this.Gv.setView(view);
        this.Gv.setDuration(1);
        this.Gv.setGravity(17, 0, 0);
        this.Gv.show();
    }

    public void e(CharSequence charSequence) {
        this.aHJ.setText(charSequence);
        this.aHK.setImageResource(e.f.icon_toast_game_ok);
        M(this.aHI);
    }

    public void f(CharSequence charSequence) {
        this.aHJ.setText(charSequence);
        this.aHK.setImageResource(e.f.icon_toast_game_error);
        M(this.aHI);
    }
}
