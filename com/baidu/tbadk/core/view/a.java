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
public class a {
    private TbPageContext<?> aby;
    private AlertDialog ajC;
    private DialogInterface.OnCancelListener ajE;
    private Activity mActivity;
    private String ajD = null;
    private TextView abP = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aby = null;
        this.mActivity = null;
        this.aby = tbPageContext;
        if (this.aby != null && this.aby.getPageActivity() != null) {
            this.mActivity = this.aby.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ajC = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajC, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.abP = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.ajD) && this.abP != null) {
                this.abP.setText(this.ajD);
            }
            if (this.ajC != null && this.ajC.getWindow() != null) {
                this.ajC.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajC.setCancelable(true);
                    this.ajC.setCanceledOnTouchOutside(true);
                    this.ajC.setOnCancelListener(onCancelListener);
                } else {
                    this.ajC.setCanceledOnTouchOutside(false);
                    this.ajC.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.ajE);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajC, this.mActivity);
        }
    }

    public void dd(int i) {
        if (this.mActivity != null) {
            this.ajD = this.mActivity.getString(i);
        }
    }

    public void ep(String str) {
        this.ajD = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajE = onCancelListener;
    }
}
