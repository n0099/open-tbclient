package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> LS;
    private AlertDialog acR;
    private Activity mActivity;
    private String acS = null;
    private TextView Xf = null;

    public a(TbPageContext<?> tbPageContext) {
        this.LS = null;
        this.mActivity = null;
        this.LS = tbPageContext;
        if (this.LS != null && this.LS.getPageActivity() != null) {
            this.mActivity = this.LS.getPageActivity();
        }
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.acR = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.custom_loading_toast, (ViewGroup) null);
            this.Xf = (TextView) inflate.findViewById(i.f.custom_loading_text);
            com.baidu.adp.lib.g.j.a(this.acR, this.mActivity);
            if (this.acR != null && this.acR.getWindow() != null) {
                this.acR.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.acR.setCancelable(true);
                    this.acR.setCanceledOnTouchOutside(true);
                    this.acR.setOnCancelListener(onCancelListener);
                } else {
                    this.acR.setCanceledOnTouchOutside(false);
                    this.acR.setCancelable(false);
                }
            }
        }
        return this;
    }

    public a vn() {
        return b(null);
    }

    public void av(boolean z) {
        if (z) {
            if (this.acR == null) {
                vn();
            }
            if (!StringUtils.isNull(this.acS) && this.Xf != null) {
                this.Xf.setText(this.acS);
            }
            com.baidu.adp.lib.g.j.a(this.acR, this.mActivity);
            return;
        }
        com.baidu.adp.lib.g.j.b(this.acR, this.mActivity);
    }
}
