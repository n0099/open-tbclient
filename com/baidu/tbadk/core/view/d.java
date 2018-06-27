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
    private Toast Ds;
    private View avp;
    private TextView avq;
    private ImageView avr;
    private Context mContext;
    public long avm = 3000;
    private int avn = -1;
    private int avo = -1;
    private Runnable avt = new Runnable() { // from class: com.baidu.tbadk.core.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.Ds != null) {
                d.this.Ds.cancel();
            }
        }
    };
    private Handler avs = new Handler();

    public d() {
        this.mContext = null;
        this.avp = null;
        this.avq = null;
        this.avr = null;
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.avp = LayoutInflater.from(this.mContext).inflate(d.i.image_toast_view, (ViewGroup) null);
        this.avq = (TextView) this.avp.findViewById(d.g.tip_text);
        this.avr = (ImageView) this.avp.findViewById(d.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.avq.setText(i2);
        this.avr.setImageResource(i);
        B(this.avp);
    }

    public void B(View view) {
        this.avs.removeCallbacks(this.avt);
        if (this.Ds == null) {
            this.Ds = new Toast(this.mContext);
        }
        this.avs.postDelayed(this.avt, this.avm);
        this.Ds.setView(view);
        this.Ds.setDuration(1);
        this.Ds.setGravity(17, 0, 0);
        this.Ds.show();
    }

    public void i(CharSequence charSequence) {
        this.avq.setText(charSequence);
        this.avr.setImageResource(d.f.icon_toast_game_ok);
        B(this.avp);
    }

    public void j(CharSequence charSequence) {
        this.avq.setText(charSequence);
        this.avr.setImageResource(d.f.icon_toast_game_error);
        B(this.avp);
    }
}
