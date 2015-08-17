package com.baidu.tbadk.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends a {
    private TextView auA;
    private TextView auB;
    private TbImageView auy;
    private TextView auz;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(i.g.net_refresh_view_layout, (ViewGroup) null));
        this.auy = (TbImageView) this.aus.findViewById(i.f.net_refresh_image);
        this.auz = (TextView) this.aus.findViewById(i.f.net_refresh_desc);
        this.auA = (TextView) this.aus.findViewById(i.f.net_refresh_title);
        this.auB = (TextView) this.aus.findViewById(i.f.net_refresh_button);
        this.auB.setOnClickListener(onClickListener);
        this.aus.setOnClickListener(null);
        ta();
    }

    public void fi(String str) {
        this.auz.setText(str);
    }

    public void eg(int i) {
        ViewGroup.LayoutParams layoutParams = this.auy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.auy.setLayoutParams(marginLayoutParams);
        }
    }

    public void Cw() {
        this.auB.setVisibility(0);
        this.auA.setVisibility(0);
        al.b(this.auz, i.c.cp_cont_d, 1);
    }

    public void Cx() {
        this.auB.setVisibility(8);
        this.auA.setVisibility(8);
        al.b(this.auz, i.c.cp_cont_b, 1);
    }

    public void ta() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        al.c(this.auy, i.e.net_refresh_emotion);
        al.a(this.auz, i.c.cp_cont_d, 1, skinType);
        al.a(this.auA, i.c.cp_cont_b, 1, skinType);
        al.a(this.auB, i.c.cp_cont_g, 1, skinType);
        al.c(this.auB, i.e.btn_appdownload, skinType);
        al.j(this.aus, i.c.cp_bg_line_d);
    }
}
