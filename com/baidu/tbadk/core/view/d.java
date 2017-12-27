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
public class d {
    private View aZs;
    private TextView aZt;
    private ImageView aZu;
    private Toast amL;
    private Context mContext;
    public long aZp = 3000;
    private int aZq = -1;
    private int aZr = -1;
    private Runnable aZw = new Runnable() { // from class: com.baidu.tbadk.core.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.amL != null) {
                d.this.amL.cancel();
            }
        }
    };
    private Handler aZv = new Handler();

    public d() {
        this.mContext = null;
        this.aZs = null;
        this.aZt = null;
        this.aZu = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aZs = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.aZt = (TextView) this.aZs.findViewById(d.g.tip_text);
        this.aZu = (ImageView) this.aZs.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aZt.setText(i2);
        this.aZu.setImageResource(i);
        aT(this.aZs);
    }

    public void aT(View view) {
        this.aZv.removeCallbacks(this.aZw);
        if (this.amL == null) {
            this.amL = new Toast(this.mContext);
        }
        this.aZv.postDelayed(this.aZw, this.aZp);
        this.amL.setView(view);
        this.amL.setDuration(1);
        this.amL.setGravity(17, 0, 0);
        this.amL.show();
    }

    public void q(CharSequence charSequence) {
        this.aZt.setText(charSequence);
        this.aZu.setImageResource(d.f.icon_toast_game_ok);
        aT(this.aZs);
    }

    public void r(CharSequence charSequence) {
        this.aZt.setText(charSequence);
        this.aZu.setImageResource(d.f.icon_toast_game_error);
        aT(this.aZs);
    }
}
