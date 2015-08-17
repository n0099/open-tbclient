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
    private TbPageContext<?> LS;
    private View adZ;
    private TextView aea;
    private ImageView aeb;
    private Toast yE;
    private int adX = -1;
    private int adY = -1;
    private Runnable aed = new o(this);
    private Handler aec = new Handler();

    public n(TbPageContext<?> tbPageContext) {
        this.LS = null;
        this.adZ = null;
        this.aea = null;
        this.aeb = null;
        this.LS = tbPageContext;
        this.adZ = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.image_toast_view, (ViewGroup) null);
        this.aea = (TextView) this.adZ.findViewById(i.f.tip_text);
        this.aeb = (ImageView) this.adZ.findViewById(i.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.aec.removeCallbacks(this.aed);
        if (this.yE == null) {
            this.yE = new Toast(context);
            this.aec.postDelayed(this.aed, 3000L);
        }
        this.yE.setView(view);
        this.yE.setGravity(17, 0, 0);
        this.yE.show();
    }

    public void dp(String str) {
        this.aea.setText(str);
        this.aeb.setImageResource(i.e.icon_toast_game_ok);
        e(this.LS.getPageActivity(), this.adZ);
    }

    public void dq(String str) {
        this.aea.setText(str);
        this.aeb.setImageResource(i.e.icon_toast_game_error);
        e(this.LS.getPageActivity(), this.adZ);
    }
}
