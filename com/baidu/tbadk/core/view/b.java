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
    private TbPageContext<?> aQq;
    private AlertDialog aXS;
    private DialogInterface.OnCancelListener aXU;
    private Activity mActivity;
    private String aXT = null;
    private TextView aQI = null;

    public b(TbPageContext<?> tbPageContext) {
        this.aQq = null;
        this.mActivity = null;
        this.aQq = tbPageContext;
        if (this.aQq != null && this.aQq.getPageActivity() != null) {
            this.mActivity = this.aQq.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aXS = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aXS, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aQI = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aXT) && this.aQI != null) {
                this.aQI.setText(this.aXT);
            }
            if (this.aXS != null && this.aXS.getWindow() != null) {
                this.aXS.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aXS.setCancelable(true);
                    this.aXS.setCanceledOnTouchOutside(true);
                    this.aXS.setOnCancelListener(onCancelListener);
                } else {
                    this.aXS.setCanceledOnTouchOutside(false);
                    this.aXS.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void bm(boolean z) {
        if (z) {
            b(this.aXU);
        } else {
            com.baidu.adp.lib.g.g.b(this.aXS, this.mActivity);
        }
    }

    public void ga(int i) {
        if (this.mActivity != null) {
            this.aXT = this.mActivity.getString(i);
        }
    }

    public void ey(String str) {
        this.aXT = str;
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aXU = onCancelListener;
    }

    public boolean isShowing() {
        return this.aXS != null && this.aXS.isShowing();
    }
}
