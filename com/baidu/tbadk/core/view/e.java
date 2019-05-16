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
    private Toast Eg;
    private View bXI;
    private TextView bXJ;
    private ImageView bXK;
    private Context mContext;
    public long bXF = 3000;
    private int bXG = -1;
    private int bXH = -1;
    private Runnable bXM = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Eg != null) {
                e.this.Eg.cancel();
            }
        }
    };
    private Handler bXL = new Handler();

    public e() {
        this.mContext = null;
        this.bXI = null;
        this.bXJ = null;
        this.bXK = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bXI = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.bXJ = (TextView) this.bXI.findViewById(R.id.tip_text);
        this.bXK = (ImageView) this.bXI.findViewById(R.id.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bXJ.setText(i2);
        this.bXK.setImageResource(i);
        aM(this.bXI);
    }

    public void aM(View view) {
        this.bXL.removeCallbacks(this.bXM);
        if (this.Eg == null) {
            this.Eg = new Toast(this.mContext);
        }
        this.bXL.postDelayed(this.bXM, this.bXF);
        this.Eg.setView(view);
        this.Eg.setDuration(1);
        this.Eg.setGravity(17, 0, 0);
        this.Eg.show();
    }

    public void i(CharSequence charSequence) {
        this.bXJ.setText(charSequence);
        this.bXK.setImageResource(R.drawable.icon_toast_game_ok);
        aM(this.bXI);
    }

    public void j(CharSequence charSequence) {
        this.bXJ.setText(charSequence);
        this.bXK.setImageResource(R.drawable.icon_toast_game_error);
        aM(this.bXI);
    }
}
