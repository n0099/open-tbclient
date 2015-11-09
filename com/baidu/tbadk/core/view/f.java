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
    private View adB;
    private TextView adC;
    private ImageView adD;
    private TbPageContext<?> mContext;
    private Toast yD;
    private int adz = -1;
    private int adA = -1;
    private Runnable adF = new g(this);
    private Handler adE = new Handler();

    public f(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.adB = null;
        this.adC = null;
        this.adD = null;
        this.mContext = tbPageContext;
        this.adB = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.image_toast_view, (ViewGroup) null);
        this.adC = (TextView) this.adB.findViewById(i.f.tip_text);
        this.adD = (ImageView) this.adB.findViewById(i.f.tip_iamge);
    }

    public void e(Context context, View view) {
        this.adE.removeCallbacks(this.adF);
        if (this.yD == null) {
            this.yD = new Toast(context);
            this.adE.postDelayed(this.adF, 3000L);
        }
        this.yD.setView(view);
        this.yD.setGravity(17, 0, 0);
        this.yD.show();
    }

    public void dA(String str) {
        this.adC.setText(str);
        this.adD.setImageResource(i.e.icon_toast_game_ok);
        e(this.mContext.getPageActivity(), this.adB);
    }

    public void dB(String str) {
        this.adC.setText(str);
        this.adD.setImageResource(i.e.icon_toast_game_error);
        e(this.mContext.getPageActivity(), this.adB);
    }
}
