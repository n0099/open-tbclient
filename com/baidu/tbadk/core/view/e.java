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
    private Toast amN;
    private View bbk;
    private TextView bbl;
    private ImageView bbm;
    private Context mContext;
    public long bbh = 3000;
    private int bbi = -1;
    private int bbj = -1;
    private Runnable bbo = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.amN != null) {
                e.this.amN.cancel();
            }
        }
    };
    private Handler bbn = new Handler();

    public e() {
        this.mContext = null;
        this.bbk = null;
        this.bbl = null;
        this.bbm = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.bbk = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.bbl = (TextView) this.bbk.findViewById(d.g.tip_text);
        this.bbm = (ImageView) this.bbk.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.bbl.setText(i2);
        this.bbm.setImageResource(i);
        aT(this.bbk);
    }

    public void aT(View view) {
        this.bbn.removeCallbacks(this.bbo);
        if (this.amN == null) {
            this.amN = new Toast(this.mContext);
        }
        this.bbn.postDelayed(this.bbo, this.bbh);
        this.amN.setView(view);
        this.amN.setDuration(1);
        this.amN.setGravity(17, 0, 0);
        this.amN.show();
    }

    public void q(CharSequence charSequence) {
        this.bbl.setText(charSequence);
        this.bbm.setImageResource(d.f.icon_toast_game_ok);
        aT(this.bbk);
    }

    public void r(CharSequence charSequence) {
        this.bbl.setText(charSequence);
        this.bbm.setImageResource(d.f.icon_toast_game_error);
        aT(this.bbk);
    }
}
