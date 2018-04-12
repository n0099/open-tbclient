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
public class b {
    private View amv;
    private TextView amw;
    private ImageView amx;
    private Context mContext;
    private Toast xk;
    public long ams = 3000;
    private int amt = -1;
    private int amu = -1;
    private Runnable amz = new Runnable() { // from class: com.baidu.tbadk.core.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.xk != null) {
                b.this.xk.cancel();
            }
        }
    };
    private Handler amy = new Handler();

    public b() {
        this.mContext = null;
        this.amv = null;
        this.amw = null;
        this.amx = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.amv = LayoutInflater.from(this.mContext).inflate(d.i.image_toast_view, (ViewGroup) null);
        this.amw = (TextView) this.amv.findViewById(d.g.tip_text);
        this.amx = (ImageView) this.amv.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.amw.setText(i2);
        this.amx.setImageResource(i);
        B(this.amv);
    }

    public void B(View view2) {
        this.amy.removeCallbacks(this.amz);
        if (this.xk == null) {
            this.xk = new Toast(this.mContext);
        }
        this.amy.postDelayed(this.amz, this.ams);
        this.xk.setView(view2);
        this.xk.setDuration(1);
        this.xk.setGravity(17, 0, 0);
        this.xk.show();
    }

    public void i(CharSequence charSequence) {
        this.amw.setText(charSequence);
        this.amx.setImageResource(d.f.icon_toast_game_ok);
        B(this.amv);
    }

    public void j(CharSequence charSequence) {
        this.amw.setText(charSequence);
        this.amx.setImageResource(d.f.icon_toast_game_error);
        B(this.amv);
    }
}
