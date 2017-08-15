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
    private TbPageContext<?> acr;
    private AlertDialog aki;
    private DialogInterface.OnCancelListener akk;
    private Activity mActivity;
    private String akj = null;
    private TextView acI = null;

    public a(TbPageContext<?> tbPageContext) {
        this.acr = null;
        this.mActivity = null;
        this.acr = tbPageContext;
        if (this.acr != null && this.acr.getPageActivity() != null) {
            this.mActivity = this.acr.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aki = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aki, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.acI = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.akj) && this.acI != null) {
                this.acI.setText(this.akj);
            }
            if (this.aki != null && this.aki.getWindow() != null) {
                this.aki.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aki.setCancelable(true);
                    this.aki.setCanceledOnTouchOutside(true);
                    this.aki.setOnCancelListener(onCancelListener);
                } else {
                    this.aki.setCanceledOnTouchOutside(false);
                    this.aki.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.akk);
        } else {
            com.baidu.adp.lib.g.g.b(this.aki, this.mActivity);
        }
    }

    public void dc(int i) {
        if (this.mActivity != null) {
            this.akj = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.akk = onCancelListener;
    }
}
