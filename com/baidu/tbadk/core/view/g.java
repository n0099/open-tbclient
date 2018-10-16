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
    private Toast Gr;
    private View aCP;
    private TextView aCQ;
    private ImageView aCR;
    private Context mContext;
    public long aCM = 3000;
    private int aCN = -1;
    private int aCO = -1;
    private Runnable aCT = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.Gr != null) {
                g.this.Gr.cancel();
            }
        }
    };
    private Handler aCS = new Handler();

    public g() {
        this.mContext = null;
        this.aCP = null;
        this.aCQ = null;
        this.aCR = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aCP = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.aCQ = (TextView) this.aCP.findViewById(e.g.tip_text);
        this.aCR = (ImageView) this.aCP.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aCQ.setText(i2);
        this.aCR.setImageResource(i);
        M(this.aCP);
    }

    public void M(View view) {
        this.aCS.removeCallbacks(this.aCT);
        if (this.Gr == null) {
            this.Gr = new Toast(this.mContext);
        }
        this.aCS.postDelayed(this.aCT, this.aCM);
        this.Gr.setView(view);
        this.Gr.setDuration(1);
        this.Gr.setGravity(17, 0, 0);
        this.Gr.show();
    }

    public void e(CharSequence charSequence) {
        this.aCQ.setText(charSequence);
        this.aCR.setImageResource(e.f.icon_toast_game_ok);
        M(this.aCP);
    }

    public void f(CharSequence charSequence) {
        this.aCQ.setText(charSequence);
        this.aCR.setImageResource(e.f.icon_toast_game_error);
        M(this.aCP);
    }
}
