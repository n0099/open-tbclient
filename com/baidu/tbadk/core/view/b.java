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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b {
    private AlertDialog aeD;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String aeE = null;
    private TextView YB = null;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aeD = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.h.custom_loading_toast, (ViewGroup) null);
            this.YB = (TextView) inflate.findViewById(n.g.custom_loading_text);
            com.baidu.adp.lib.h.j.a(this.aeD, this.mActivity);
            if (this.aeD != null && this.aeD.getWindow() != null) {
                this.aeD.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aeD.setCancelable(true);
                    this.aeD.setCanceledOnTouchOutside(true);
                    this.aeD.setOnCancelListener(onCancelListener);
                } else {
                    this.aeD.setCanceledOnTouchOutside(false);
                    this.aeD.setCancelable(false);
                }
            }
        }
        return this;
    }

    public b vG() {
        return b(null);
    }

    public void show() {
        av(true);
    }

    public void av(boolean z) {
        if (z) {
            if (this.aeD == null) {
                vG();
            }
            if (!StringUtils.isNull(this.aeE) && this.YB != null) {
                this.YB.setText(this.aeE);
            }
            com.baidu.adp.lib.h.j.a(this.aeD, this.mActivity);
            return;
        }
        com.baidu.adp.lib.h.j.b(this.aeD, this.mActivity);
    }

    public void cE(int i) {
        if (this.mActivity != null) {
            this.aeE = this.mActivity.getString(i);
        }
    }
}
