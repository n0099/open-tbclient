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
    private TbPageContext<?> aaX;
    private DialogInterface.OnCancelListener aiA;
    private AlertDialog aiy;
    private Activity mActivity;
    private String aiz = null;
    private TextView abo = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aaX = null;
        this.mActivity = null;
        this.aaX = tbPageContext;
        if (this.aaX != null && this.aaX.getPageActivity() != null) {
            this.mActivity = this.aaX.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aiy = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.aiy, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.custom_loading_toast, (ViewGroup) null);
            this.abo = (TextView) inflate.findViewById(w.h.custom_loading_text);
            if (!StringUtils.isNull(this.aiz) && this.abo != null) {
                this.abo.setText(this.aiz);
            }
            if (this.aiy != null && this.aiy.getWindow() != null) {
                this.aiy.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aiy.setCancelable(true);
                    this.aiy.setCanceledOnTouchOutside(true);
                    this.aiy.setOnCancelListener(onCancelListener);
                } else {
                    this.aiy.setCanceledOnTouchOutside(false);
                    this.aiy.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aK(boolean z) {
        if (z) {
            b(this.aiA);
        } else {
            com.baidu.adp.lib.g.j.b(this.aiy, this.mActivity);
        }
    }

    public void cZ(int i) {
        if (this.mActivity != null) {
            this.aiz = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aiA = onCancelListener;
    }
}
