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
    private TbPageContext<?> abz;
    private AlertDialog ajd;
    private DialogInterface.OnCancelListener ajf;
    private Activity mActivity;
    private String aje = null;
    private TextView abQ = null;

    public a(TbPageContext<?> tbPageContext) {
        this.abz = null;
        this.mActivity = null;
        this.abz = tbPageContext;
        if (this.abz != null && this.abz.getPageActivity() != null) {
            this.mActivity = this.abz.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ajd = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajd, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.abQ = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.aje) && this.abQ != null) {
                this.abQ.setText(this.aje);
            }
            if (this.ajd != null && this.ajd.getWindow() != null) {
                this.ajd.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajd.setCancelable(true);
                    this.ajd.setCanceledOnTouchOutside(true);
                    this.ajd.setOnCancelListener(onCancelListener);
                } else {
                    this.ajd.setCanceledOnTouchOutside(false);
                    this.ajd.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.ajf);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajd, this.mActivity);
        }
    }

    public void db(int i) {
        if (this.mActivity != null) {
            this.aje = this.mActivity.getString(i);
        }
    }

    public void eh(String str) {
        this.aje = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajf = onCancelListener;
    }
}
