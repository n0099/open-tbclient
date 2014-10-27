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
    private ImageView VG;
    private TextView VH;
    private TextView VI;
    private TextView VJ;

    public h(Context context, View.OnClickListener onClickListener) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, w.net_refresh_view_layout, null));
        this.VG = (ImageView) this.Vz.findViewById(v.net_refresh_image);
        this.VH = (TextView) this.Vz.findViewById(v.net_refresh_desc);
        this.VI = (TextView) this.Vz.findViewById(v.net_refresh_title);
        this.VJ = (TextView) this.Vz.findViewById(v.net_refresh_button);
        this.VJ.setOnClickListener(onClickListener);
        sB();
    }

    public void dF(String str) {
        this.VH.setText(str);
    }

    public void sB() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        aw.c(this.VG, u.net_refresh_emotion);
        aw.a(this.VH, s.cp_cont_d, 1, skinType);
        aw.a(this.VI, s.cp_cont_b, 1, skinType);
        aw.a(this.VJ, s.cp_cont_g, 1, skinType);
        aw.c(this.VJ, u.btn_appdownload, skinType);
        aw.i(this.Vz, s.cp_bg_line_d);
    }
}
