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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private AlertDialog adb;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String adc = null;
    private TextView Xo = null;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.adb = new AlertDialog.Builder(this.mActivity).create();
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.custom_loading_toast, (ViewGroup) null);
            this.Xo = (TextView) inflate.findViewById(i.f.custom_loading_text);
            com.baidu.adp.lib.g.j.a(this.adb, this.mActivity);
            if (this.adb != null && this.adb.getWindow() != null) {
                this.adb.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.adb.setCancelable(true);
                    this.adb.setCanceledOnTouchOutside(true);
                    this.adb.setOnCancelListener(onCancelListener);
                } else {
                    this.adb.setCanceledOnTouchOutside(false);
                    this.adb.setCancelable(false);
                }
            }
        }
        return this;
    }

    public a vs() {
        return b(null);
    }

    public void av(boolean z) {
        if (z) {
            if (this.adb == null) {
                vs();
            }
            if (!StringUtils.isNull(this.adc) && this.Xo != null) {
                this.Xo.setText(this.adc);
            }
            com.baidu.adp.lib.g.j.a(this.adb, this.mActivity);
            return;
        }
        com.baidu.adp.lib.g.j.b(this.adb, this.mActivity);
    }

    public void cB(int i) {
        if (this.mActivity != null) {
            this.adc = this.mActivity.getString(i);
        }
    }
}
