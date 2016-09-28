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
    private TbPageContext<?> Gd;
    private AlertDialog adT;
    private DialogInterface.OnCancelListener adV;
    private Activity mActivity;
    private String adU = null;
    private TextView WE = null;

    public a(TbPageContext<?> tbPageContext) {
        this.Gd = null;
        this.mActivity = null;
        this.Gd = tbPageContext;
        if (this.Gd != null && this.Gd.getPageActivity() != null) {
            this.mActivity = this.Gd.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.adT = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.adT, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.custom_loading_toast, (ViewGroup) null);
            this.WE = (TextView) inflate.findViewById(r.g.custom_loading_text);
            if (!StringUtils.isNull(this.adU) && this.WE != null) {
                this.WE.setText(this.adU);
            }
            if (this.adT != null && this.adT.getWindow() != null) {
                this.adT.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.adT.setCancelable(true);
                    this.adT.setCanceledOnTouchOutside(true);
                    this.adT.setOnCancelListener(onCancelListener);
                } else {
                    this.adT.setCanceledOnTouchOutside(false);
                    this.adT.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aF(boolean z) {
        if (z) {
            b(this.adV);
        } else {
            com.baidu.adp.lib.h.j.b(this.adT, this.mActivity);
        }
    }

    public void cW(int i) {
        if (this.mActivity != null) {
            this.adU = this.mActivity.getString(i);
        }
    }

    public void dW(String str) {
        this.adU = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.adV = onCancelListener;
    }
}
