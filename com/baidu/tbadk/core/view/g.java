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
    private View aDF;
    private TextView aDG;
    private ImageView aDH;
    private Context mContext;
    public long aDC = 3000;
    private int aDD = -1;
    private int aDE = -1;
    private Runnable aDJ = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gv != null) {
                g.this.Gv.cancel();
            }
        }
    };
    private Handler aDI = new Handler();

    public g() {
        this.mContext = null;
        this.aDF = null;
        this.aDG = null;
        this.aDH = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aDF = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aDG = (TextView) this.aDF.findViewById(e.g.tip_text);
        this.aDH = (ImageView) this.aDF.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aDG.setText(i2);
        this.aDH.setImageResource(i);
        M(this.aDF);
    }

    public void M(View view) {
        this.aDI.removeCallbacks(this.aDJ);
        if (this.Gv == null) {
            this.Gv = new Toast(this.mContext);
        }
        this.aDI.postDelayed(this.aDJ, this.aDC);
        this.Gv.setView(view);
        this.Gv.setDuration(1);
        this.Gv.setGravity(17, 0, 0);
        this.Gv.show();
    }

    public void e(CharSequence charSequence) {
        this.aDG.setText(charSequence);
        this.aDH.setImageResource(e.f.icon_toast_game_ok);
        M(this.aDF);
    }

    public void f(CharSequence charSequence) {
        this.aDG.setText(charSequence);
        this.aDH.setImageResource(e.f.icon_toast_game_error);
        M(this.aDF);
    }
}
