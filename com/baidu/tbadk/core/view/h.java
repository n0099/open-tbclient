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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h {
    private View afg;
    private TextView afh;
    private ImageView afi;
    private TbPageContext<?> mContext;
    private Toast yL;
    private int afe = -1;
    private int aff = -1;
    private Runnable afk = new i(this);
    private Handler afj = new Handler();

    public h(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.afg = null;
        this.afh = null;
        this.afi = null;
        this.mContext = tbPageContext;
        this.afg = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.h.image_toast_view, (ViewGroup) null);
        this.afh = (TextView) this.afg.findViewById(n.g.tip_text);
        this.afi = (ImageView) this.afg.findViewById(n.g.tip_iamge);
    }

    public void e(Context context, View view) {
        this.afj.removeCallbacks(this.afk);
        if (this.yL == null) {
            this.yL = new Toast(context);
            this.afj.postDelayed(this.afk, 3000L);
        }
        this.yL.setView(view);
        this.yL.setGravity(17, 0, 0);
        this.yL.show();
    }

    public void c(CharSequence charSequence) {
        this.afh.setText(charSequence);
        this.afi.setImageResource(n.f.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.afg);
    }

    public void d(CharSequence charSequence) {
        this.afh.setText(charSequence);
        this.afi.setImageResource(n.f.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.afg);
    }
}
