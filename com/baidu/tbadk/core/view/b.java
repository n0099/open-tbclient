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
    private TbPageContext<?> abX;
    private AlertDialog ajG;
    private DialogInterface.OnCancelListener ajI;
    private Activity mActivity;
    private String ajH = null;
    private TextView acs = null;

    public b(TbPageContext<?> tbPageContext) {
        this.abX = null;
        this.mActivity = null;
        this.abX = tbPageContext;
        if (this.abX != null && this.abX.getPageActivity() != null) {
            this.mActivity = this.abX.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ajG = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.ajG, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.acs = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.ajH) && this.acs != null) {
                this.acs.setText(this.ajH);
            }
            if (this.ajG != null && this.ajG.getWindow() != null) {
                this.ajG.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ajG.setCancelable(true);
                    this.ajG.setCanceledOnTouchOutside(true);
                    this.ajG.setOnCancelListener(onCancelListener);
                } else {
                    this.ajG.setCanceledOnTouchOutside(false);
                    this.ajG.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aE(boolean z) {
        if (z) {
            b(this.ajI);
        } else {
            com.baidu.adp.lib.g.g.b(this.ajG, this.mActivity);
        }
    }

    public void db(int i) {
        if (this.mActivity != null) {
            this.ajH = this.mActivity.getString(i);
        }
    }

    public void er(String str) {
        this.ajH = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ajI = onCancelListener;
    }
}
