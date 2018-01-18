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
    private View aZr;
    private TextView aZs;
    private ImageView aZt;
    private Toast amL;
    private Context mContext;
    public long aZo = 3000;
    private int aZp = -1;
    private int aZq = -1;
    private Runnable aZv = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.amL != null) {
                e.this.amL.cancel();
            }
        }
    };
    private Handler aZu = new Handler();

    public e() {
        this.mContext = null;
        this.aZr = null;
        this.aZs = null;
        this.aZt = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aZr = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.aZs = (TextView) this.aZr.findViewById(d.g.tip_text);
        this.aZt = (ImageView) this.aZr.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aZs.setText(i2);
        this.aZt.setImageResource(i);
        aT(this.aZr);
    }

    public void aT(View view) {
        this.aZu.removeCallbacks(this.aZv);
        if (this.amL == null) {
            this.amL = new Toast(this.mContext);
        }
        this.aZu.postDelayed(this.aZv, this.aZo);
        this.amL.setView(view);
        this.amL.setDuration(1);
        this.amL.setGravity(17, 0, 0);
        this.amL.show();
    }

    public void q(CharSequence charSequence) {
        this.aZs.setText(charSequence);
        this.aZt.setImageResource(d.f.icon_toast_game_ok);
        aT(this.aZr);
    }

    public void r(CharSequence charSequence) {
        this.aZs.setText(charSequence);
        this.aZt.setImageResource(d.f.icon_toast_game_error);
        aT(this.aZr);
    }
}
