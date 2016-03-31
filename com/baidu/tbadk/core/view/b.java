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
public class b {
    private TbPageContext<?> MX;
    private DialogInterface.OnCancelListener aeB;
    private AlertDialog aez;
    private Activity mActivity;
    private String aeA = null;
    private TextView Xr = null;

    public b(TbPageContext<?> tbPageContext) {
        this.MX = null;
        this.mActivity = null;
        this.MX = tbPageContext;
        if (this.MX != null && this.MX.getPageActivity() != null) {
            this.mActivity = this.MX.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aez = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.aez, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.custom_loading_toast, (ViewGroup) null);
            this.Xr = (TextView) inflate.findViewById(t.g.custom_loading_text);
            if (!StringUtils.isNull(this.aeA) && this.Xr != null) {
                this.Xr.setText(this.aeA);
            }
            if (this.aez != null && this.aez.getWindow() != null) {
                this.aez.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aez.setCancelable(true);
                    this.aez.setCanceledOnTouchOutside(true);
                    this.aez.setOnCancelListener(onCancelListener);
                } else {
                    this.aez.setCanceledOnTouchOutside(false);
                    this.aez.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void ay(boolean z) {
        if (z) {
            b(this.aeB);
        } else {
            com.baidu.adp.lib.h.j.b(this.aez, this.mActivity);
        }
    }

    public void cY(int i) {
        if (this.mActivity != null) {
            this.aeA = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aeB = onCancelListener;
    }
}
