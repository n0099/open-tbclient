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
    private Toast El;
    private View bYR;
    private TextView bYS;
    private ImageView bYT;
    private Context mContext;
    public long bYO = 3000;
    private int bYP = -1;
    private int bYQ = -1;
    private Runnable bYV = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.El != null) {
                e.this.El.cancel();
            }
        }
    };
    private Handler bYU = new Handler();

    public e() {
        this.mContext = null;
        this.bYR = null;
        this.bYS = null;
        this.bYT = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bYR = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.bYS = (TextView) this.bYR.findViewById(R.id.tip_text);
        this.bYT = (ImageView) this.bYR.findViewById(R.id.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bYS.setText(i2);
        this.bYT.setImageResource(i);
        aO(this.bYR);
    }

    public void aO(View view) {
        this.bYU.removeCallbacks(this.bYV);
        if (this.El == null) {
            this.El = new Toast(this.mContext);
        }
        this.bYU.postDelayed(this.bYV, this.bYO);
        this.El.setView(view);
        this.El.setDuration(1);
        this.El.setGravity(17, 0, 0);
        this.El.show();
    }

    public void i(CharSequence charSequence) {
        this.bYS.setText(charSequence);
        this.bYT.setImageResource(R.drawable.icon_toast_game_ok);
        aO(this.bYR);
    }

    public void j(CharSequence charSequence) {
        this.bYS.setText(charSequence);
        this.bYT.setImageResource(R.drawable.icon_toast_game_error);
        aO(this.bYR);
    }
}
