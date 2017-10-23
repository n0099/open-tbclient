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
    private TbPageContext<?> abm;
    private AlertDialog aiR;
    private DialogInterface.OnCancelListener aiT;
    private Activity mActivity;
    private String aiS = null;
    private TextView abE = null;

    public a(TbPageContext<?> tbPageContext) {
        this.abm = null;
        this.mActivity = null;
        this.abm = tbPageContext;
        if (this.abm != null && this.abm.getPageActivity() != null) {
            this.mActivity = this.abm.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aiR = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aiR, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.abE = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.aiS) && this.abE != null) {
                this.abE.setText(this.aiS);
            }
            if (this.aiR != null && this.aiR.getWindow() != null) {
                this.aiR.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aiR.setCancelable(true);
                    this.aiR.setCanceledOnTouchOutside(true);
                    this.aiR.setOnCancelListener(onCancelListener);
                } else {
                    this.aiR.setCanceledOnTouchOutside(false);
                    this.aiR.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aG(boolean z) {
        if (z) {
            b(this.aiT);
        } else {
            com.baidu.adp.lib.g.g.b(this.aiR, this.mActivity);
        }
    }

    public void da(int i) {
        if (this.mActivity != null) {
            this.aiS = this.mActivity.getString(i);
        }
    }

    public void eg(String str) {
        this.aiS = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aiT = onCancelListener;
    }
}
