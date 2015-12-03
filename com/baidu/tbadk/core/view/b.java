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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b {
    private AlertDialog adY;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String adZ = null;
    private TextView XY = null;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.adY = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.g.custom_loading_toast, (ViewGroup) null);
            this.XY = (TextView) inflate.findViewById(n.f.custom_loading_text);
            com.baidu.adp.lib.h.j.a(this.adY, this.mActivity);
            if (this.adY != null && this.adY.getWindow() != null) {
                this.adY.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.adY.setCancelable(true);
                    this.adY.setCanceledOnTouchOutside(true);
                    this.adY.setOnCancelListener(onCancelListener);
                } else {
                    this.adY.setCanceledOnTouchOutside(false);
                    this.adY.setCancelable(false);
                }
            }
        }
        return this;
    }

    public b vW() {
        return b(null);
    }

    public void show() {
        ay(true);
    }

    public void ay(boolean z) {
        if (z) {
            if (this.adY == null) {
                vW();
            }
            if (!StringUtils.isNull(this.adZ) && this.XY != null) {
                this.XY.setText(this.adZ);
            }
            com.baidu.adp.lib.h.j.a(this.adY, this.mActivity);
            return;
        }
        com.baidu.adp.lib.h.j.b(this.adY, this.mActivity);
    }

    public void cL(int i) {
        if (this.mActivity != null) {
            this.adZ = this.mActivity.getString(i);
        }
    }
}
