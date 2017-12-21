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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<?> aca;
    private AlertDialog ajJ;
    private DialogInterface.OnCancelListener ajL;
    private Activity mActivity;
    private String ajK = null;
    private TextView acv = null;

    public b(TbPageContext<?> tbPageContext) {
        this.aca = null;
        this.mActivity = null;
        this.aca = tbPageContext;
        if (this.aca != null && this.aca.getPageActivity() != null) {
            this.mActivity = this.aca.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ajJ = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajJ, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.acv = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.ajK) && this.acv != null) {
                this.acv.setText(this.ajK);
            }
            if (this.ajJ != null && this.ajJ.getWindow() != null) {
                this.ajJ.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajJ.setCancelable(true);
                    this.ajJ.setCanceledOnTouchOutside(true);
                    this.ajJ.setOnCancelListener(onCancelListener);
                } else {
                    this.ajJ.setCanceledOnTouchOutside(false);
                    this.ajJ.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aE(boolean z) {
        if (z) {
            b(this.ajL);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajJ, this.mActivity);
        }
    }

    public void db(int i) {
        if (this.mActivity != null) {
            this.ajK = this.mActivity.getString(i);
        }
    }

    public void er(String str) {
        this.ajK = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajL = onCancelListener;
    }
}
