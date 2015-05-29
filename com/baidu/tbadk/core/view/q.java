package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class q {
    private TbPageContext<?> LH;
    private int YZ = -1;
    private int Za = -1;
    private View Zb;
    private TextView Zc;
    private ImageView Zd;

    public q(TbPageContext<?> tbPageContext) {
        this.LH = null;
        this.Zb = null;
        this.Zc = null;
        this.Zd = null;
        this.LH = tbPageContext;
        this.Zb = com.baidu.adp.lib.g.b.hr().inflate(tbPageContext.getPageActivity(), com.baidu.tieba.r.image_toast_view, null);
        this.Zc = (TextView) this.Zb.findViewById(com.baidu.tieba.q.tip_text);
        this.Zd = (ImageView) this.Zb.findViewById(com.baidu.tieba.q.tip_iamge);
    }

    public void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        toast.show();
    }

    public void dn(String str) {
        this.Zc.setText(str);
        this.Zd.setImageResource(com.baidu.tieba.p.icon_toast_game_ok);
        e(this.LH.getPageActivity(), this.Zb);
    }

    public void dp(String str) {
        this.Zc.setText(str);
        this.Zd.setImageResource(com.baidu.tieba.p.icon_toast_game_error);
        e(this.LH.getPageActivity(), this.Zb);
    }
}
