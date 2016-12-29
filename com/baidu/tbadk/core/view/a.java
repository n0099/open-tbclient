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
    private AlertDialog adK;
    private DialogInterface.OnCancelListener adM;
    private Activity mActivity;
    private String adL = null;
    private TextView Ww = null;

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
            this.adK = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.adK, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.custom_loading_toast, (ViewGroup) null);
            this.Ww = (TextView) inflate.findViewById(r.g.custom_loading_text);
            if (!StringUtils.isNull(this.adL) && this.Ww != null) {
                this.Ww.setText(this.adL);
            }
            if (this.adK != null && this.adK.getWindow() != null) {
                this.adK.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.adK.setCancelable(true);
                    this.adK.setCanceledOnTouchOutside(true);
                    this.adK.setOnCancelListener(onCancelListener);
                } else {
                    this.adK.setCanceledOnTouchOutside(false);
                    this.adK.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aJ(boolean z) {
        if (z) {
            b(this.adM);
        } else {
            com.baidu.adp.lib.h.j.b(this.adK, this.mActivity);
        }
    }

    public void cZ(int i) {
        if (this.mActivity != null) {
            this.adL = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.adM = onCancelListener;
    }
}
