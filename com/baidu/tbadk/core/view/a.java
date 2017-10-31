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
    private TbPageContext<?> abI;
    private AlertDialog ajn;
    private DialogInterface.OnCancelListener ajp;
    private Activity mActivity;
    private String ajo = null;
    private TextView acd = null;

    public a(TbPageContext<?> tbPageContext) {
        this.abI = null;
        this.mActivity = null;
        this.abI = tbPageContext;
        if (this.abI != null && this.abI.getPageActivity() != null) {
            this.mActivity = this.abI.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ajn = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajn, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.acd = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.ajo) && this.acd != null) {
                this.acd.setText(this.ajo);
            }
            if (this.ajn != null && this.ajn.getWindow() != null) {
                this.ajn.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajn.setCancelable(true);
                    this.ajn.setCanceledOnTouchOutside(true);
                    this.ajn.setOnCancelListener(onCancelListener);
                } else {
                    this.ajn.setCanceledOnTouchOutside(false);
                    this.ajn.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aE(boolean z) {
        if (z) {
            b(this.ajp);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajn, this.mActivity);
        }
    }

    public void db(int i) {
        if (this.mActivity != null) {
            this.ajo = this.mActivity.getString(i);
        }
    }

    public void em(String str) {
        this.ajo = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajp = onCancelListener;
    }
}
