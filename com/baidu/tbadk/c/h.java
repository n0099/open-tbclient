package com.baidu.tbadk.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends a {
    private ImageView alD;
    private TextView alE;
    private TextView alF;
    private TextView alG;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, w.net_refresh_view_layout, null));
        this.alD = (ImageView) this.alx.findViewById(v.net_refresh_image);
        this.alE = (TextView) this.alx.findViewById(v.net_refresh_desc);
        this.alF = (TextView) this.alx.findViewById(v.net_refresh_title);
        this.alG = (TextView) this.alx.findViewById(v.net_refresh_button);
        this.alG.setOnClickListener(onClickListener);
        this.alx.setOnClickListener(null);
        rk();
    }

    public void ew(String str) {
        this.alE.setText(str);
    }

    public void zI() {
        this.alG.setVisibility(0);
        this.alF.setVisibility(0);
        ba.b(this.alE, s.cp_cont_d, 1);
    }

    public void zJ() {
        this.alG.setVisibility(8);
        this.alF.setVisibility(8);
        ba.b(this.alE, s.cp_cont_b, 1);
    }

    public void rk() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ba.c(this.alD, u.net_refresh_emotion);
        ba.a(this.alE, s.cp_cont_d, 1, skinType);
        ba.a(this.alF, s.cp_cont_b, 1, skinType);
        ba.a(this.alG, s.cp_cont_g, 1, skinType);
        ba.c(this.alG, u.btn_appdownload, skinType);
        ba.j(this.alx, s.cp_bg_line_d);
    }
}
