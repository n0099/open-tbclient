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
    private TbPageContext<?> aaY;
    private DialogInterface.OnCancelListener aiB;
    private AlertDialog aiz;
    private Activity mActivity;
    private String aiA = null;
    private TextView abp = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aaY = null;
        this.mActivity = null;
        this.aaY = tbPageContext;
        if (this.aaY != null && this.aaY.getPageActivity() != null) {
            this.mActivity = this.aaY.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aiz = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.aiz, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.custom_loading_toast, (ViewGroup) null);
            this.abp = (TextView) inflate.findViewById(w.h.custom_loading_text);
            if (!StringUtils.isNull(this.aiA) && this.abp != null) {
                this.abp.setText(this.aiA);
            }
            if (this.aiz != null && this.aiz.getWindow() != null) {
                this.aiz.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aiz.setCancelable(true);
                    this.aiz.setCanceledOnTouchOutside(true);
                    this.aiz.setOnCancelListener(onCancelListener);
                } else {
                    this.aiz.setCanceledOnTouchOutside(false);
                    this.aiz.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aK(boolean z) {
        if (z) {
            b(this.aiB);
        } else {
            com.baidu.adp.lib.g.j.b(this.aiz, this.mActivity);
        }
    }

    public void cZ(int i) {
        if (this.mActivity != null) {
            this.aiA = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aiB = onCancelListener;
    }
}
