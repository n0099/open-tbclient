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
    private View adw;
    private TextView adx;
    private ImageView ady;
    private TbPageContext<?> mContext;
    private Toast yD;
    private int adu = -1;
    private int adv = -1;
    private Runnable adA = new g(this);
    private Handler adz = new Handler();

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.adw = null;
        this.adx = null;
        this.ady = null;
        this.mContext = tbPageContext;
        this.adw = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.image_toast_view, (ViewGroup) null);
        this.adx = (TextView) this.adw.findViewById(i.f.tip_text);
        this.ady = (ImageView) this.adw.findViewById(i.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.adz.removeCallbacks(this.adA);
        if (this.yD == null) {
            this.yD = new Toast(context);
            this.adz.postDelayed(this.adA, 3000L);
        }
        this.yD.setView(view);
        this.yD.setGravity(17, 0, 0);
        this.yD.show();
    }

    public void dA(String str) {
        this.adx.setText(str);
        this.ady.setImageResource(i.e.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.adw);
    }

    public void dB(String str) {
        this.adx.setText(str);
        this.ady.setImageResource(i.e.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.adw);
    }
}
