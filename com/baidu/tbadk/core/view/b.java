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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<?> DQ;
    private AlertDialog aaY;
    private DialogInterface.OnCancelListener aba;
    private Activity mActivity;
    private String aaZ = null;
    private TextView TE = null;

    public b(TbPageContext<?> tbPageContext) {
        this.DQ = null;
        this.mActivity = null;
        this.DQ = tbPageContext;
        if (this.DQ != null && this.DQ.getPageActivity() != null) {
            this.mActivity = this.DQ.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aaY = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.aaY, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.custom_loading_toast, (ViewGroup) null);
            this.TE = (TextView) inflate.findViewById(u.g.custom_loading_text);
            if (!StringUtils.isNull(this.aaZ) && this.TE != null) {
                this.TE.setText(this.aaZ);
            }
            if (this.aaY != null && this.aaY.getWindow() != null) {
                this.aaY.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aaY.setCancelable(true);
                    this.aaY.setCanceledOnTouchOutside(true);
                    this.aaY.setOnCancelListener(onCancelListener);
                } else {
                    this.aaY.setCanceledOnTouchOutside(false);
                    this.aaY.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aE(boolean z) {
        if (z) {
            b(this.aba);
        } else {
            com.baidu.adp.lib.h.j.b(this.aaY, this.mActivity);
        }
    }

    public void cI(int i) {
        if (this.mActivity != null) {
            this.aaZ = this.mActivity.getString(i);
        }
    }

    public void dR(String str) {
        this.aaZ = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aba = onCancelListener;
    }
}
