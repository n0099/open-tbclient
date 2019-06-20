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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private Toast Ef;
    private View bXJ;
    private TextView bXK;
    private ImageView bXL;
    private Context mContext;
    public long bXG = 3000;
    private int bXH = -1;
    private int bXI = -1;
    private Runnable bXN = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Ef != null) {
                e.this.Ef.cancel();
            }
        }
    };
    private Handler bXM = new Handler();

    public e() {
        this.mContext = null;
        this.bXJ = null;
        this.bXK = null;
        this.bXL = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bXJ = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.bXK = (TextView) this.bXJ.findViewById(R.id.tip_text);
        this.bXL = (ImageView) this.bXJ.findViewById(R.id.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bXK.setText(i2);
        this.bXL.setImageResource(i);
        aM(this.bXJ);
    }

    public void aM(View view) {
        this.bXM.removeCallbacks(this.bXN);
        if (this.Ef == null) {
            this.Ef = new Toast(this.mContext);
        }
        this.bXM.postDelayed(this.bXN, this.bXG);
        this.Ef.setView(view);
        this.Ef.setDuration(1);
        this.Ef.setGravity(17, 0, 0);
        this.Ef.show();
    }

    public void i(CharSequence charSequence) {
        this.bXK.setText(charSequence);
        this.bXL.setImageResource(R.drawable.icon_toast_game_ok);
        aM(this.bXJ);
    }

    public void j(CharSequence charSequence) {
        this.bXK.setText(charSequence);
        this.bXL.setImageResource(R.drawable.icon_toast_game_error);
        aM(this.bXJ);
    }
}
