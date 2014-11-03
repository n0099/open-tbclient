package com.baidu.tbadk.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends a {
    private ImageView VK;
    private TextView VL;
    private TextView VM;
    private TextView VN;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, w.net_refresh_view_layout, null));
        this.VK = (ImageView) this.VD.findViewById(v.net_refresh_image);
        this.VL = (TextView) this.VD.findViewById(v.net_refresh_desc);
        this.VM = (TextView) this.VD.findViewById(v.net_refresh_title);
        this.VN = (TextView) this.VD.findViewById(v.net_refresh_button);
        this.VN.setOnClickListener(onClickListener);
        sD();
    }

    public void dF(String str) {
        this.VL.setText(str);
    }

    public void sD() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.c(this.VK, u.net_refresh_emotion);
        aw.a(this.VL, s.cp_cont_d, 1, skinType);
        aw.a(this.VM, s.cp_cont_b, 1, skinType);
        aw.a(this.VN, s.cp_cont_g, 1, skinType);
        aw.c(this.VN, u.btn_appdownload, skinType);
        aw.i(this.VD, s.cp_bg_line_d);
    }
}
