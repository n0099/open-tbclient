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
    private TbPageContext<?> acp;
    private AlertDialog akg;
    private DialogInterface.OnCancelListener aki;
    private Activity mActivity;
    private String akh = null;
    private TextView acG = null;

    public a(TbPageContext<?> tbPageContext) {
        this.acp = null;
        this.mActivity = null;
        this.acp = tbPageContext;
        if (this.acp != null && this.acp.getPageActivity() != null) {
            this.mActivity = this.acp.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.akg = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.akg, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.custom_loading_toast, (ViewGroup) null);
            this.acG = (TextView) inflate.findViewById(d.h.custom_loading_text);
            if (!StringUtils.isNull(this.akh) && this.acG != null) {
                this.acG.setText(this.akh);
            }
            if (this.akg != null && this.akg.getWindow() != null) {
                this.akg.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.akg.setCancelable(true);
                    this.akg.setCanceledOnTouchOutside(true);
                    this.akg.setOnCancelListener(onCancelListener);
                } else {
                    this.akg.setCanceledOnTouchOutside(false);
                    this.akg.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.aki);
        } else {
            com.baidu.adp.lib.g.g.b(this.akg, this.mActivity);
        }
    }

    public void dc(int i) {
        if (this.mActivity != null) {
            this.akh = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aki = onCancelListener;
    }
}
