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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private Toast El;
    private View bZK;
    private TextView bZL;
    private ImageView bZM;
    private Handler bZN;
    private Context mContext;
    public long bZH = 3000;
    private int bZI = -1;
    private int bZJ = -1;
    private Runnable bZO = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.El != null) {
                e.this.El.cancel();
            }
        }
    };

    public e() {
        this.mContext = null;
        this.bZK = null;
        this.bZL = null;
        this.bZM = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bZK = LayoutInflater.from(this.mContext).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.bZL = (TextView) this.bZK.findViewById(R.id.tip_text);
        this.bZM = (ImageView) this.bZK.findViewById(R.id.tip_iamge);
        this.bZK.setBackgroundDrawable(am.X(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds32), am.getColor(R.color.cp_hud_a)));
        am.j(this.bZL, R.color.cp_cont_a);
        this.bZN = new Handler();
    }

    public void showToast(int i, int i2) {
        this.bZL.setText(i2);
        this.bZM.setImageResource(i);
        aO(this.bZK);
    }

    public void aO(View view) {
        this.bZN.removeCallbacks(this.bZO);
        if (this.El == null) {
            this.El = new Toast(this.mContext);
        }
        this.bZN.postDelayed(this.bZO, this.bZH);
        this.El.setView(view);
        this.El.setDuration(1);
        this.El.setGravity(17, 0, 0);
        this.El.show();
    }

    public void i(CharSequence charSequence) {
        this.bZL.setText(charSequence);
        this.bZM.setImageResource(R.drawable.icon_toast_game_ok);
        aO(this.bZK);
    }

    public void j(CharSequence charSequence) {
        this.bZL.setText(charSequence);
        this.bZM.setImageResource(R.drawable.icon_toast_game_error);
        aO(this.bZK);
    }
}
