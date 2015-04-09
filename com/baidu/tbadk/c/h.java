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
    private ImageView alL;
    private TextView alM;
    private TextView alN;
    private TextView alO;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, w.net_refresh_view_layout, null));
        this.alL = (ImageView) this.alF.findViewById(v.net_refresh_image);
        this.alM = (TextView) this.alF.findViewById(v.net_refresh_desc);
        this.alN = (TextView) this.alF.findViewById(v.net_refresh_title);
        this.alO = (TextView) this.alF.findViewById(v.net_refresh_button);
        this.alO.setOnClickListener(onClickListener);
        this.alF.setOnClickListener(null);
        rk();
    }

    public void ez(String str) {
        this.alM.setText(str);
    }

    public void zO() {
        this.alO.setVisibility(0);
        this.alN.setVisibility(0);
        ba.b(this.alM, s.cp_cont_d, 1);
    }

    public void zP() {
        this.alO.setVisibility(8);
        this.alN.setVisibility(8);
        ba.b(this.alM, s.cp_cont_b, 1);
    }

    public void rk() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ba.c(this.alL, u.net_refresh_emotion);
        ba.a(this.alM, s.cp_cont_d, 1, skinType);
        ba.a(this.alN, s.cp_cont_b, 1, skinType);
        ba.a(this.alO, s.cp_cont_g, 1, skinType);
        ba.c(this.alO, u.btn_appdownload, skinType);
        ba.j(this.alF, s.cp_bg_line_d);
    }
}
