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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    private View afu;
    private TextView afv;
    private ImageView afw;
    private Context mContext;
    private Toast sl;
    public long afr = 3000;
    private int afs = -1;
    private int aft = -1;
    private Runnable afy = new i(this);
    private Handler afx = new Handler();

    public h() {
        this.mContext = null;
        this.afu = null;
        this.afv = null;
        this.afw = null;
        this.mContext = TbadkCoreApplication.m9getInst().getContext();
        this.afu = LayoutInflater.from(this.mContext).inflate(r.h.image_toast_view, (ViewGroup) null);
        this.afv = (TextView) this.afu.findViewById(r.g.tip_text);
        this.afw = (ImageView) this.afu.findViewById(r.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.afv.setText(i2);
        this.afw.setImageResource(i);
        E(this.afu);
    }

    public void E(View view) {
        this.afx.removeCallbacks(this.afy);
        if (this.sl == null) {
            this.sl = new Toast(this.mContext);
        }
        this.afx.postDelayed(this.afy, this.afr);
        this.sl.setView(view);
        this.sl.setDuration(1);
        this.sl.setGravity(17, 0, 0);
        this.sl.show();
    }

    public void c(CharSequence charSequence) {
        this.afv.setText(charSequence);
        this.afw.setImageResource(r.f.icon_toast_game_ok);
        E(this.afu);
    }

    public void d(CharSequence charSequence) {
        this.afv.setText(charSequence);
        this.afw.setImageResource(r.f.icon_toast_game_error);
        E(this.afu);
    }

    public void wp() {
        if (this.sl != null) {
            this.sl.cancel();
        }
    }
}
