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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<?> Dp;
    private AlertDialog aap;
    private DialogInterface.OnCancelListener aar;
    private Activity mActivity;
    private String aaq = null;
    private TextView SW = null;

    public b(TbPageContext<?> tbPageContext) {
        this.Dp = null;
        this.mActivity = null;
        this.Dp = tbPageContext;
        if (this.Dp != null && this.Dp.getPageActivity() != null) {
            this.mActivity = this.Dp.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aap = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.aap, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.custom_loading_toast, (ViewGroup) null);
            this.SW = (TextView) inflate.findViewById(u.g.custom_loading_text);
            if (!StringUtils.isNull(this.aaq) && this.SW != null) {
                this.SW.setText(this.aaq);
            }
            if (this.aap != null && this.aap.getWindow() != null) {
                this.aap.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aap.setCancelable(true);
                    this.aap.setCanceledOnTouchOutside(true);
                    this.aap.setOnCancelListener(onCancelListener);
                } else {
                    this.aap.setCanceledOnTouchOutside(false);
                    this.aap.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aB(boolean z) {
        if (z) {
            b(this.aar);
        } else {
            com.baidu.adp.lib.h.j.b(this.aap, this.mActivity);
        }
    }

    public void cI(int i) {
        if (this.mActivity != null) {
            this.aaq = this.mActivity.getString(i);
        }
    }

    public void dS(String str) {
        this.aaq = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aar = onCancelListener;
    }
}
