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
    private Toast Do;
    private View auV;
    private TextView auW;
    private ImageView auX;
    private Context mContext;
    public long auS = 3000;
    private int auT = -1;
    private int auU = -1;
    private Runnable auZ = new Runnable() { // from class: com.baidu.tbadk.core.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.Do != null) {
                d.this.Do.cancel();
            }
        }
    };
    private Handler auY = new Handler();

    public d() {
        this.mContext = null;
        this.auV = null;
        this.auW = null;
        this.auX = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.auV = LayoutInflater.from(this.mContext).inflate(d.h.image_toast_view, (ViewGroup) null);
        this.auW = (TextView) this.auV.findViewById(d.g.tip_text);
        this.auX = (ImageView) this.auV.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.auW.setText(i2);
        this.auX.setImageResource(i);
        B(this.auV);
    }

    public void B(View view) {
        this.auY.removeCallbacks(this.auZ);
        if (this.Do == null) {
            this.Do = new Toast(this.mContext);
        }
        this.auY.postDelayed(this.auZ, this.auS);
        this.Do.setView(view);
        this.Do.setDuration(1);
        this.Do.setGravity(17, 0, 0);
        this.Do.show();
    }

    public void e(CharSequence charSequence) {
        this.auW.setText(charSequence);
        this.auX.setImageResource(d.f.icon_toast_game_ok);
        B(this.auV);
    }

    public void f(CharSequence charSequence) {
        this.auW.setText(charSequence);
        this.auX.setImageResource(d.f.icon_toast_game_error);
        B(this.auV);
    }
}
