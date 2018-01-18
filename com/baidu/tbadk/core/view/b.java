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
    private TbPageContext<?> aQp;
    private AlertDialog aXR;
    private DialogInterface.OnCancelListener aXT;
    private Activity mActivity;
    private String aXS = null;
    private TextView aQH = null;

    public b(TbPageContext<?> tbPageContext) {
        this.aQp = null;
        this.mActivity = null;
        this.aQp = tbPageContext;
        if (this.aQp != null && this.aQp.getPageActivity() != null) {
            this.mActivity = this.aQp.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aXR = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aXR, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aQH = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aXS) && this.aQH != null) {
                this.aQH.setText(this.aXS);
            }
            if (this.aXR != null && this.aXR.getWindow() != null) {
                this.aXR.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aXR.setCancelable(true);
                    this.aXR.setCanceledOnTouchOutside(true);
                    this.aXR.setOnCancelListener(onCancelListener);
                } else {
                    this.aXR.setCanceledOnTouchOutside(false);
                    this.aXR.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void bm(boolean z) {
        if (z) {
            b(this.aXT);
        } else {
            com.baidu.adp.lib.g.g.b(this.aXR, this.mActivity);
        }
    }

    public void fY(int i) {
        if (this.mActivity != null) {
            this.aXS = this.mActivity.getString(i);
        }
    }

    public void ey(String str) {
        this.aXS = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aXT = onCancelListener;
    }

    public boolean isShowing() {
        return this.aXR != null && this.aXR.isShowing();
    }
}
