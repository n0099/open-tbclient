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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class g {
    private Toast FI;
    private View ayg;
    private TextView ayh;
    private ImageView ayi;
    private Context mContext;
    public long ayd = 3000;
    private int aye = -1;
    private int ayf = -1;
    private Runnable ayk = new Runnable() { // from class: com.baidu.tbadk.core.view.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.FI != null) {
                g.this.FI.cancel();
            }
        }
    };
    private Handler ayj = new Handler();

    public g() {
        this.mContext = null;
        this.ayg = null;
        this.ayh = null;
        this.ayi = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.ayg = LayoutInflater.from(this.mContext).inflate(e.h.image_toast_view, (ViewGroup) null);
        this.ayh = (TextView) this.ayg.findViewById(e.g.tip_text);
        this.ayi = (ImageView) this.ayg.findViewById(e.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.ayh.setText(i2);
        this.ayi.setImageResource(i);
        M(this.ayg);
    }

    public void M(View view) {
        this.ayj.removeCallbacks(this.ayk);
        if (this.FI == null) {
            this.FI = new Toast(this.mContext);
        }
        this.ayj.postDelayed(this.ayk, this.ayd);
        this.FI.setView(view);
        this.FI.setDuration(1);
        this.FI.setGravity(17, 0, 0);
        this.FI.show();
    }

    public void e(CharSequence charSequence) {
        this.ayh.setText(charSequence);
        this.ayi.setImageResource(e.f.icon_toast_game_ok);
        M(this.ayg);
    }

    public void f(CharSequence charSequence) {
        this.ayh.setText(charSequence);
        this.ayi.setImageResource(e.f.icon_toast_game_error);
        M(this.ayg);
    }
}
