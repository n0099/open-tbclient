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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private Toast amH;
    private View baY;
    private TextView baZ;
    private ImageView bba;
    private Context mContext;
    public long baV = 3000;
    private int baW = -1;
    private int baX = -1;
    private Runnable bbc = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.amH != null) {
                e.this.amH.cancel();
            }
        }
    };
    private Handler bbb = new Handler();

    public e() {
        this.mContext = null;
        this.baY = null;
        this.baZ = null;
        this.bba = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.baY = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.baZ = (TextView) this.baY.findViewById(d.g.tip_text);
        this.bba = (ImageView) this.baY.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.baZ.setText(i2);
        this.bba.setImageResource(i);
        aT(this.baY);
    }

    public void aT(View view) {
        this.bbb.removeCallbacks(this.bbc);
        if (this.amH == null) {
            this.amH = new Toast(this.mContext);
        }
        this.bbb.postDelayed(this.bbc, this.baV);
        this.amH.setView(view);
        this.amH.setDuration(1);
        this.amH.setGravity(17, 0, 0);
        this.amH.show();
    }

    public void q(CharSequence charSequence) {
        this.baZ.setText(charSequence);
        this.bba.setImageResource(d.f.icon_toast_game_ok);
        aT(this.baY);
    }

    public void r(CharSequence charSequence) {
        this.baZ.setText(charSequence);
        this.bba.setImageResource(d.f.icon_toast_game_error);
        aT(this.baY);
    }
}
