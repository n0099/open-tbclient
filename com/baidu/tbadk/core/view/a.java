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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> aas;
    private AlertDialog ahJ;
    private DialogInterface.OnCancelListener ahL;
    private Activity mActivity;
    private String ahK = null;
    private TextView aaJ = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aas = null;
        this.mActivity = null;
        this.aas = tbPageContext;
        if (this.aas != null && this.aas.getPageActivity() != null) {
            this.mActivity = this.aas.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ahJ = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.ahJ, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.custom_loading_toast, (ViewGroup) null);
            this.aaJ = (TextView) inflate.findViewById(w.h.custom_loading_text);
            if (!StringUtils.isNull(this.ahK) && this.aaJ != null) {
                this.aaJ.setText(this.ahK);
            }
            if (this.ahJ != null && this.ahJ.getWindow() != null) {
                this.ahJ.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ahJ.setCancelable(true);
                    this.ahJ.setCanceledOnTouchOutside(true);
                    this.ahJ.setOnCancelListener(onCancelListener);
                } else {
                    this.ahJ.setCanceledOnTouchOutside(false);
                    this.ahJ.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aH(boolean z) {
        if (z) {
            b(this.ahL);
        } else {
            com.baidu.adp.lib.g.j.b(this.ahJ, this.mActivity);
        }
    }

    public void cW(int i) {
        if (this.mActivity != null) {
            this.ahK = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ahL = onCancelListener;
    }
}
