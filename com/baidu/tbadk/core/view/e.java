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
    private View bYL;
    private TextView bYM;
    private ImageView bYN;
    private Context mContext;
    public long bYI = 3000;
    private int bYJ = -1;
    private int bYK = -1;
    private Runnable bYP = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.El != null) {
                e.this.El.cancel();
            }
        }
    };
    private Handler bYO = new Handler();

    public e() {
        this.mContext = null;
        this.bYL = null;
        this.bYM = null;
        this.bYN = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bYL = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.bYM = (TextView) this.bYL.findViewById(R.id.tip_text);
        this.bYN = (ImageView) this.bYL.findViewById(R.id.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bYM.setText(i2);
        this.bYN.setImageResource(i);
        aO(this.bYL);
    }

    public void aO(View view) {
        this.bYO.removeCallbacks(this.bYP);
        if (this.El == null) {
            this.El = new Toast(this.mContext);
        }
        this.bYO.postDelayed(this.bYP, this.bYI);
        this.El.setView(view);
        this.El.setDuration(1);
        this.El.setGravity(17, 0, 0);
        this.El.show();
    }

    public void i(CharSequence charSequence) {
        this.bYM.setText(charSequence);
        this.bYN.setImageResource(R.drawable.icon_toast_game_ok);
        aO(this.bYL);
    }

    public void j(CharSequence charSequence) {
        this.bYM.setText(charSequence);
        this.bYN.setImageResource(R.drawable.icon_toast_game_error);
        aO(this.bYL);
    }
}
