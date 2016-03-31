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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private View afs;
    private TextView aft;
    private ImageView afu;
    private Context mContext;
    private Toast zk;
    public long afp = 3000;
    private int afq = -1;
    private int afr = -1;
    private Runnable afw = new i(this);
    private Handler afv = new Handler();

    public h() {
        this.mContext = null;
        this.afs = null;
        this.aft = null;
        this.afu = null;
        this.mContext = TbadkCoreApplication.m411getInst().getContext();
        this.afs = LayoutInflater.from(this.mContext).inflate(t.h.image_toast_view, (ViewGroup) null);
        this.aft = (TextView) this.afs.findViewById(t.g.tip_text);
        this.afu = (ImageView) this.afs.findViewById(t.g.tip_iamge);
    }

    public void showToast(int i, int i2) {
        this.aft.setText(i2);
        this.afu.setImageResource(i);
        E(this.afs);
    }

    public void E(View view) {
        this.afv.removeCallbacks(this.afw);
        if (this.zk == null) {
            this.zk = new Toast(this.mContext);
        }
        this.afv.postDelayed(this.afw, this.afp);
        this.zk.setView(view);
        this.zk.setDuration(1);
        this.zk.setGravity(17, 0, 0);
        this.zk.show();
    }

    public void c(CharSequence charSequence) {
        this.aft.setText(charSequence);
        this.afu.setImageResource(t.f.icon_toast_game_ok);
        E(this.afs);
    }

    public void d(CharSequence charSequence) {
        this.aft.setText(charSequence);
        this.afu.setImageResource(t.f.icon_toast_game_error);
        E(this.afs);
    }

    public void xj() {
        if (this.zk != null) {
            this.zk.cancel();
        }
    }
}
