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
public class g {
    private ImageView aeA;
    private View aey;
    private TextView aez;
    private TbPageContext<?> mContext;
    private Toast yJ;
    private int aew = -1;
    private int aex = -1;
    private Runnable aeC = new h(this);
    private Handler aeB = new Handler();

    public g(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.aey = null;
        this.aez = null;
        this.aeA = null;
        this.mContext = tbPageContext;
        this.aey = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.g.image_toast_view, (ViewGroup) null);
        this.aez = (TextView) this.aey.findViewById(n.f.tip_text);
        this.aeA = (ImageView) this.aey.findViewById(n.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.aeB.removeCallbacks(this.aeC);
        if (this.yJ == null) {
            this.yJ = new Toast(context);
            this.aeB.postDelayed(this.aeC, 3000L);
        }
        this.yJ.setView(view);
        this.yJ.setGravity(17, 0, 0);
        this.yJ.show();
    }

    public void d(CharSequence charSequence) {
        this.aez.setText(charSequence);
        this.aeA.setImageResource(n.e.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.aey);
    }

    public void e(CharSequence charSequence) {
        this.aez.setText(charSequence);
        this.aeA.setImageResource(n.e.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.aey);
    }
}
