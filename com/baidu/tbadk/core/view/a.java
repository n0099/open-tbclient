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
    private AlertDialog ajB;
    private DialogInterface.OnCancelListener ajD;
    private Activity mActivity;
    private String ajC = null;
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
            this.ajB = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajB, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.abP = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.ajC) && this.abP != null) {
                this.abP.setText(this.ajC);
            }
            if (this.ajB != null && this.ajB.getWindow() != null) {
                this.ajB.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajB.setCancelable(true);
                    this.ajB.setCanceledOnTouchOutside(true);
                    this.ajB.setOnCancelListener(onCancelListener);
                } else {
                    this.ajB.setCanceledOnTouchOutside(false);
                    this.ajB.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.ajD);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajB, this.mActivity);
        }
    }

    public void dd(int i) {
        if (this.mActivity != null) {
            this.ajC = this.mActivity.getString(i);
        }
    }

    public void ep(String str) {
        this.ajC = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajD = onCancelListener;
    }
}
