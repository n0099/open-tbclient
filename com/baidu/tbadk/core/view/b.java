package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<?> LH;
    private AlertDialog XU;
    private Activity mActivity;
    private String XV = null;
    private TextView Sl = null;

    public b(TbPageContext<?> tbPageContext) {
        this.LH = null;
        this.mActivity = null;
        this.LH = tbPageContext;
        if (this.LH != null || this.LH.getPageActivity() != null) {
            this.mActivity = this.LH.getPageActivity();
        }
    }

    public b uj() {
        if (this.mActivity != null) {
            this.XU = new AlertDialog.Builder(this.mActivity).create();
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mActivity, com.baidu.tieba.r.custom_loading_toast, null);
            this.Sl = (TextView) inflate.findViewById(com.baidu.tieba.q.custom_loading_text);
            com.baidu.adp.lib.g.k.a(this.XU, this.mActivity);
            if (this.XU != null && this.XU.getWindow() != null) {
                this.XU.getWindow().setContentView(inflate);
                this.XU.setCanceledOnTouchOutside(false);
            }
        }
        return this;
    }

    public void ar(boolean z) {
        if (z) {
            if (this.XU == null) {
                uj();
            }
            if (!StringUtils.isNull(this.XV) && this.Sl != null) {
                this.Sl.setText(this.XV);
            }
            com.baidu.adp.lib.g.k.a(this.XU, this.mActivity);
            return;
        }
        com.baidu.adp.lib.g.k.b(this.XU, this.mActivity);
    }
}
