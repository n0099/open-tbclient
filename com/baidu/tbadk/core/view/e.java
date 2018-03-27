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
    private View bba;
    private TextView bbb;
    private ImageView bbc;
    private Context mContext;
    public long baX = 3000;
    private int baY = -1;
    private int baZ = -1;
    private Runnable bbe = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.amH != null) {
                e.this.amH.cancel();
            }
        }
    };
    private Handler bbd = new Handler();

    public e() {
        this.mContext = null;
        this.bba = null;
        this.bbb = null;
        this.bbc = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bba = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bbb = (TextView) this.bba.findViewById(d.g.tip_text);
        this.bbc = (ImageView) this.bba.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bbb.setText(i2);
        this.bbc.setImageResource(i);
        aT(this.bba);
    }

    public void aT(View view) {
        this.bbd.removeCallbacks(this.bbe);
        if (this.amH == null) {
            this.amH = new Toast(this.mContext);
        }
        this.bbd.postDelayed(this.bbe, this.baX);
        this.amH.setView(view);
        this.amH.setDuration(1);
        this.amH.setGravity(17, 0, 0);
        this.amH.show();
    }

    public void q(CharSequence charSequence) {
        this.bbb.setText(charSequence);
        this.bbc.setImageResource(d.f.icon_toast_game_ok);
        aT(this.bba);
    }

    public void r(CharSequence charSequence) {
        this.bbb.setText(charSequence);
        this.bbc.setImageResource(d.f.icon_toast_game_error);
        aT(this.bba);
    }
}
