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
public class b {
    private TbPageContext<?> aQs;
    private AlertDialog aXZ;
    private DialogInterface.OnCancelListener aYb;
    private Activity mActivity;
    private String aYa = null;
    private TextView aQK = null;

    public b(TbPageContext<?> tbPageContext) {
        this.aQs = null;
        this.mActivity = null;
        this.aQs = tbPageContext;
        if (this.aQs != null && this.aQs.getPageActivity() != null) {
            this.mActivity = this.aQs.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aXZ = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aXZ, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aQK = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aYa) && this.aQK != null) {
                this.aQK.setText(this.aYa);
            }
            if (this.aXZ != null && this.aXZ.getWindow() != null) {
                this.aXZ.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aXZ.setCancelable(true);
                    this.aXZ.setCanceledOnTouchOutside(true);
                    this.aXZ.setOnCancelListener(onCancelListener);
                } else {
                    this.aXZ.setCanceledOnTouchOutside(false);
                    this.aXZ.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void bn(boolean z) {
        if (z) {
            b(this.aYb);
        } else {
            com.baidu.adp.lib.g.g.b(this.aXZ, this.mActivity);
        }
    }

    public void fY(int i) {
        if (this.mActivity != null) {
            this.aYa = this.mActivity.getString(i);
        }
    }

    public void eF(String str) {
        this.aYa = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aYb = onCancelListener;
    }

    public boolean isShowing() {
        return this.aXZ != null && this.aXZ.isShowing();
    }
}
