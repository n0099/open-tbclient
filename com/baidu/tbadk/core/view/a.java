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
    private AlertDialog acV;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String acW = null;
    private TextView Xg = null;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.acV = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.custom_loading_toast, (ViewGroup) null);
            this.Xg = (TextView) inflate.findViewById(i.f.custom_loading_text);
            com.baidu.adp.lib.g.j.a(this.acV, this.mActivity);
            if (this.acV != null && this.acV.getWindow() != null) {
                this.acV.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.acV.setCancelable(true);
                    this.acV.setCanceledOnTouchOutside(true);
                    this.acV.setOnCancelListener(onCancelListener);
                } else {
                    this.acV.setCanceledOnTouchOutside(false);
                    this.acV.setCancelable(false);
                }
            }
        }
        return this;
    }

    public a vp() {
        return b(null);
    }

    public void av(boolean z) {
        if (z) {
            if (this.acV == null) {
                vp();
            }
            if (!StringUtils.isNull(this.acW) && this.Xg != null) {
                this.Xg.setText(this.acW);
            }
            com.baidu.adp.lib.g.j.a(this.acV, this.mActivity);
            return;
        }
        com.baidu.adp.lib.g.j.b(this.acV, this.mActivity);
    }

    public void cD(int i) {
        if (this.mActivity != null) {
            this.acW = this.mActivity.getString(i);
        }
    }
}
