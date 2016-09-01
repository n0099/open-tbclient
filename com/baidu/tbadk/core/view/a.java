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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> Gd;
    private AlertDialog adI;
    private DialogInterface.OnCancelListener adK;
    private Activity mActivity;
    private String adJ = null;
    private TextView Wu = null;

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
            this.adI = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.adI, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.custom_loading_toast, (ViewGroup) null);
            this.Wu = (TextView) inflate.findViewById(t.g.custom_loading_text);
            if (!StringUtils.isNull(this.adJ) && this.Wu != null) {
                this.Wu.setText(this.adJ);
            }
            if (this.adI != null && this.adI.getWindow() != null) {
                this.adI.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.adI.setCancelable(true);
                    this.adI.setCanceledOnTouchOutside(true);
                    this.adI.setOnCancelListener(onCancelListener);
                } else {
                    this.adI.setCanceledOnTouchOutside(false);
                    this.adI.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aF(boolean z) {
        if (z) {
            b(this.adK);
        } else {
            com.baidu.adp.lib.h.j.b(this.adI, this.mActivity);
        }
    }

    public void cW(int i) {
        if (this.mActivity != null) {
            this.adJ = this.mActivity.getString(i);
        }
    }

    public void dT(String str) {
        this.adJ = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.adK = onCancelListener;
    }
}
