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
    private TbPageContext<?> aaS;
    private AlertDialog aiN;
    private DialogInterface.OnCancelListener aiP;
    private Activity mActivity;
    private String aiO = null;
    private TextView abj = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aaS = null;
        this.mActivity = null;
        this.aaS = tbPageContext;
        if (this.aaS != null && this.aaS.getPageActivity() != null) {
            this.mActivity = this.aaS.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aiN = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aiN, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.abj = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.aiO) && this.abj != null) {
                this.abj.setText(this.aiO);
            }
            if (this.aiN != null && this.aiN.getWindow() != null) {
                this.aiN.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aiN.setCancelable(true);
                    this.aiN.setCanceledOnTouchOutside(true);
                    this.aiN.setOnCancelListener(onCancelListener);
                } else {
                    this.aiN.setCanceledOnTouchOutside(false);
                    this.aiN.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.aiP);
        } else {
            com.baidu.adp.lib.g.g.b(this.aiN, this.mActivity);
        }
    }

    public void da(int i) {
        if (this.mActivity != null) {
            this.aiO = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aiP = onCancelListener;
    }
}
