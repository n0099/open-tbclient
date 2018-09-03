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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class d {
    private Toast Do;
    private View auU;
    private TextView auV;
    private ImageView auW;
    private Context mContext;
    public long auR = 3000;
    private int auS = -1;
    private int auT = -1;
    private Runnable auY = new Runnable() { // from class: com.baidu.tbadk.core.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.Do != null) {
                d.this.Do.cancel();
            }
        }
    };
    private Handler auX = new Handler();

    public d() {
        this.mContext = null;
        this.auU = null;
        this.auV = null;
        this.auW = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.auU = LayoutInflater.from(this.mContext).inflate(f.h.image_toast_view, (ViewGroup) null);
        this.auV = (TextView) this.auU.findViewById(f.g.tip_text);
        this.auW = (ImageView) this.auU.findViewById(f.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.auV.setText(i2);
        this.auW.setImageResource(i);
        B(this.auU);
    }

    public void B(View view) {
        this.auX.removeCallbacks(this.auY);
        if (this.Do == null) {
            this.Do = new Toast(this.mContext);
        }
        this.auX.postDelayed(this.auY, this.auR);
        this.Do.setView(view);
        this.Do.setDuration(1);
        this.Do.setGravity(17, 0, 0);
        this.Do.show();
    }

    public void e(CharSequence charSequence) {
        this.auV.setText(charSequence);
        this.auW.setImageResource(f.C0146f.icon_toast_game_ok);
        B(this.auU);
    }

    public void f(CharSequence charSequence) {
        this.auV.setText(charSequence);
        this.auW.setImageResource(f.C0146f.icon_toast_game_error);
        B(this.auU);
    }
}
