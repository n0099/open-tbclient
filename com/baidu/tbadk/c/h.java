package com.baidu.tbadk.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends a {
    private ImageView amM;
    private TextView amN;
    private TextView amO;
    private TextView amP;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, r.net_refresh_view_layout, null));
        this.amM = (ImageView) this.amG.findViewById(q.net_refresh_image);
        this.amN = (TextView) this.amG.findViewById(q.net_refresh_desc);
        this.amO = (TextView) this.amG.findViewById(q.net_refresh_title);
        this.amP = (TextView) this.amG.findViewById(q.net_refresh_button);
        this.amP.setOnClickListener(onClickListener);
        this.amG.setOnClickListener(null);
        rU();
    }

    public void eQ(String str) {
        this.amN.setText(str);
    }

    public void dQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.amM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.amM.setLayoutParams(marginLayoutParams);
        }
    }

    public void AA() {
        this.amP.setVisibility(0);
        this.amO.setVisibility(0);
        ay.b(this.amN, n.cp_cont_d, 1);
    }

    public void AB() {
        this.amP.setVisibility(8);
        this.amO.setVisibility(8);
        ay.b(this.amN, n.cp_cont_b, 1);
    }

    public void rU() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ay.c(this.amM, p.net_refresh_emotion);
        ay.a(this.amN, n.cp_cont_d, 1, skinType);
        ay.a(this.amO, n.cp_cont_b, 1, skinType);
        ay.a(this.amP, n.cp_cont_g, 1, skinType);
        ay.c(this.amP, p.btn_appdownload, skinType);
        ay.j(this.amG, n.cp_bg_line_d);
    }
}
