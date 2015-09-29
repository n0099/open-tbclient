package com.baidu.tbadk.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f {
    private View adv;
    private TextView adw;
    private ImageView adx;
    private TbPageContext<?> mContext;
    private Toast yD;
    private int adt = -1;
    private int adu = -1;
    private Runnable adz = new g(this);
    private Handler ady = new Handler();

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.adv = null;
        this.adw = null;
        this.adx = null;
        this.mContext = tbPageContext;
        this.adv = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.image_toast_view, (ViewGroup) null);
        this.adw = (TextView) this.adv.findViewById(i.f.tip_text);
        this.adx = (ImageView) this.adv.findViewById(i.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.ady.removeCallbacks(this.adz);
        if (this.yD == null) {
            this.yD = new Toast(context);
            this.ady.postDelayed(this.adz, 3000L);
        }
        this.yD.setView(view);
        this.yD.setGravity(17, 0, 0);
        this.yD.show();
    }

    public void dA(String str) {
        this.adw.setText(str);
        this.adx.setImageResource(i.e.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.adv);
    }

    public void dB(String str) {
        this.adw.setText(str);
        this.adx.setImageResource(i.e.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.adv);
    }
}
