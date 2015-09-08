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
public class n {
    private View aej;
    private TextView aek;
    private ImageView ael;
    private TbPageContext<?> mContext;
    private Toast yC;
    private int aeh = -1;
    private int aei = -1;
    private Runnable aen = new o(this);
    private Handler aem = new Handler();

    public n(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.aej = null;
        this.aek = null;
        this.ael = null;
        this.mContext = tbPageContext;
        this.aej = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.image_toast_view, (ViewGroup) null);
        this.aek = (TextView) this.aej.findViewById(i.f.tip_text);
        this.ael = (ImageView) this.aej.findViewById(i.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.aem.removeCallbacks(this.aen);
        if (this.yC == null) {
            this.yC = new Toast(context);
            this.aem.postDelayed(this.aen, 3000L);
        }
        this.yC.setView(view);
        this.yC.setGravity(17, 0, 0);
        this.yC.show();
    }

    public void dw(String str) {
        this.aek.setText(str);
        this.ael.setImageResource(i.e.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.aej);
    }

    public void dx(String str) {
        this.aek.setText(str);
        this.ael.setImageResource(i.e.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.aej);
    }
}
