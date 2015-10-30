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
    private AlertDialog acW;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String acX = null;
    private TextView Xi = null;

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
            this.acW = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.custom_loading_toast, (ViewGroup) null);
            this.Xi = (TextView) inflate.findViewById(i.f.custom_loading_text);
            com.baidu.adp.lib.g.j.a(this.acW, this.mActivity);
            if (this.acW != null && this.acW.getWindow() != null) {
                this.acW.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.acW.setCancelable(true);
                    this.acW.setCanceledOnTouchOutside(true);
                    this.acW.setOnCancelListener(onCancelListener);
                } else {
                    this.acW.setCanceledOnTouchOutside(false);
                    this.acW.setCancelable(false);
                }
            }
        }
        return this;
    }

    public a vm() {
        return b(null);
    }

    public void av(boolean z) {
        if (z) {
            if (this.acW == null) {
                vm();
            }
            if (!StringUtils.isNull(this.acX) && this.Xi != null) {
                this.Xi.setText(this.acX);
            }
            com.baidu.adp.lib.g.j.a(this.acW, this.mActivity);
            return;
        }
        com.baidu.adp.lib.g.j.b(this.acW, this.mActivity);
    }

    public void cD(int i) {
        if (this.mActivity != null) {
            this.acX = this.mActivity.getString(i);
        }
    }
}
