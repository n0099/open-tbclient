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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> Fp;
    private AlertDialog acU;
    private DialogInterface.OnCancelListener acW;
    private Activity mActivity;
    private String acV = null;
    private TextView VM = null;

    public a(TbPageContext<?> tbPageContext) {
        this.Fp = null;
        this.mActivity = null;
        this.Fp = tbPageContext;
        if (this.Fp != null && this.Fp.getPageActivity() != null) {
            this.mActivity = this.Fp.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.acU = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.acU, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.j.custom_loading_toast, (ViewGroup) null);
            this.VM = (TextView) inflate.findViewById(r.h.custom_loading_text);
            if (!StringUtils.isNull(this.acV) && this.VM != null) {
                this.VM.setText(this.acV);
            }
            if (this.acU != null && this.acU.getWindow() != null) {
                this.acU.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.acU.setCancelable(true);
                    this.acU.setCanceledOnTouchOutside(true);
                    this.acU.setOnCancelListener(onCancelListener);
                } else {
                    this.acU.setCanceledOnTouchOutside(false);
                    this.acU.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aJ(boolean z) {
        if (z) {
            b(this.acW);
        } else {
            com.baidu.adp.lib.g.j.b(this.acU, this.mActivity);
        }
    }

    public void da(int i) {
        if (this.mActivity != null) {
            this.acV = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.acW = onCancelListener;
    }
}
