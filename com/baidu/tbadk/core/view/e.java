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
    private TextView aZA;
    private ImageView aZB;
    private View aZz;
    private Toast amO;
    private Context mContext;
    public long aZw = 3000;
    private int aZx = -1;
    private int aZy = -1;
    private Runnable aZD = new Runnable() { // from class: com.baidu.tbadk.core.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.amO != null) {
                e.this.amO.cancel();
            }
        }
    };
    private Handler aZC = new Handler();

    public e() {
        this.mContext = null;
        this.aZz = null;
        this.aZA = null;
        this.aZB = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.aZz = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.aZA = (TextView) this.aZz.findViewById(d.g.tip_text);
        this.aZB = (ImageView) this.aZz.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aZA.setText(i2);
        this.aZB.setImageResource(i);
        aT(this.aZz);
    }

    public void aT(View view) {
        this.aZC.removeCallbacks(this.aZD);
        if (this.amO == null) {
            this.amO = new Toast(this.mContext);
        }
        this.aZC.postDelayed(this.aZD, this.aZw);
        this.amO.setView(view);
        this.amO.setDuration(1);
        this.amO.setGravity(17, 0, 0);
        this.amO.show();
    }

    public void q(CharSequence charSequence) {
        this.aZA.setText(charSequence);
        this.aZB.setImageResource(d.f.icon_toast_game_ok);
        aT(this.aZz);
    }

    public void r(CharSequence charSequence) {
        this.aZA.setText(charSequence);
        this.aZB.setImageResource(d.f.icon_toast_game_error);
        aT(this.aZz);
    }
}
