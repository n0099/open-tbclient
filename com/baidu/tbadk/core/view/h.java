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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private TbPageContext<?> MR;
    private View afS;
    private TextView afT;
    private ImageView afU;
    private Toast yT;
    private int afQ = -1;
    private int afR = -1;
    private Runnable afW = new i(this);
    private Handler afV = new Handler();

    public h(TbPageContext<?> tbPageContext) {
        this.MR = null;
        this.afS = null;
        this.afT = null;
        this.afU = null;
        this.MR = tbPageContext;
        this.afS = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.image_toast_view, (ViewGroup) null);
        this.afT = (TextView) this.afS.findViewById(t.g.tip_text);
        this.afU = (ImageView) this.afS.findViewById(t.g.tip_iamge);
    }

    public void e(Context context, View view) {
        this.afV.removeCallbacks(this.afW);
        if (this.yT == null) {
            this.yT = new Toast(context);
            this.afV.postDelayed(this.afW, 3000L);
        }
        this.yT.setView(view);
        this.yT.setGravity(17, 0, 0);
        this.yT.show();
    }

    public void c(CharSequence charSequence) {
        this.afT.setText(charSequence);
        this.afU.setImageResource(t.f.icon_toast_game_ok);
        e(this.MR.getPageActivity(), this.afS);
    }

    public void d(CharSequence charSequence) {
        this.afT.setText(charSequence);
        this.afU.setImageResource(t.f.icon_toast_game_error);
        e(this.MR.getPageActivity(), this.afS);
    }
}
