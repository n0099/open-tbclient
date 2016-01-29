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
    private TbPageContext<?> MR;
    private AlertDialog afe;
    private Activity mActivity;
    private String aff = null;
    private TextView YY = null;

    public b(TbPageContext<?> tbPageContext) {
        this.MR = null;
        this.mActivity = null;
        this.MR = tbPageContext;
        if (this.MR != null && this.MR.getPageActivity() != null) {
            this.mActivity = this.MR.getPageActivity();
        }
    }

    public b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.afe = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.custom_loading_toast, (ViewGroup) null);
            this.YY = (TextView) inflate.findViewById(t.g.custom_loading_text);
            com.baidu.adp.lib.h.j.a(this.afe, this.mActivity);
            if (this.afe != null && this.afe.getWindow() != null) {
                this.afe.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.afe.setCancelable(true);
                    this.afe.setCanceledOnTouchOutside(true);
                    this.afe.setOnCancelListener(onCancelListener);
                } else {
                    this.afe.setCanceledOnTouchOutside(false);
                    this.afe.setCancelable(false);
                }
            }
        }
        return this;
    }

    public b wN() {
        return b(null);
    }

    public void show() {
        aw(true);
    }

    public void aw(boolean z) {
        if (z) {
            if (this.afe == null) {
                wN();
            }
            if (!StringUtils.isNull(this.aff) && this.YY != null) {
                this.YY.setText(this.aff);
            }
            com.baidu.adp.lib.h.j.a(this.afe, this.mActivity);
            return;
        }
        com.baidu.adp.lib.h.j.b(this.afe, this.mActivity);
    }

    public void cV(int i) {
        if (this.mActivity != null) {
            this.aff = this.mActivity.getString(i);
        }
    }
}
