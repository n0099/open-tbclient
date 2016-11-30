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
    private TbPageContext<?> Gf;
    private AlertDialog aer;
    private DialogInterface.OnCancelListener aet;
    private Activity mActivity;
    private String aes = null;
    private TextView Xc = null;

    public a(TbPageContext<?> tbPageContext) {
        this.Gf = null;
        this.mActivity = null;
        this.Gf = tbPageContext;
        if (this.Gf != null && this.Gf.getPageActivity() != null) {
            this.mActivity = this.Gf.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aer = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.aer, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.custom_loading_toast, (ViewGroup) null);
            this.Xc = (TextView) inflate.findViewById(r.g.custom_loading_text);
            if (!StringUtils.isNull(this.aes) && this.Xc != null) {
                this.Xc.setText(this.aes);
            }
            if (this.aer != null && this.aer.getWindow() != null) {
                this.aer.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aer.setCancelable(true);
                    this.aer.setCanceledOnTouchOutside(true);
                    this.aer.setOnCancelListener(onCancelListener);
                } else {
                    this.aer.setCanceledOnTouchOutside(false);
                    this.aer.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aI(boolean z) {
        if (z) {
            b(this.aet);
        } else {
            com.baidu.adp.lib.h.j.b(this.aer, this.mActivity);
        }
    }

    public void cX(int i) {
        if (this.mActivity != null) {
            this.aes = this.mActivity.getString(i);
        }
    }

    public void dY(String str) {
        this.aes = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aet = onCancelListener;
    }
}
