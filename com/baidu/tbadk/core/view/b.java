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
    private TbPageContext<?> aRR;
    private AlertDialog aZI;
    private DialogInterface.OnCancelListener aZK;
    private Activity mActivity;
    private String aZJ = null;
    private TextView aSj = null;
    private boolean aZL = true;

    public b(TbPageContext<?> tbPageContext) {
        this.aRR = null;
        this.mActivity = null;
        this.aRR = tbPageContext;
        if (this.aRR != null && this.aRR.getPageActivity() != null) {
            this.mActivity = this.aRR.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZI = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZI, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aSj = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZJ) && this.aSj != null) {
                this.aSj.setText(this.aZJ);
            }
            if (this.aZI != null && this.aZI.getWindow() != null) {
                this.aZI.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZI.setCancelable(true);
                    this.aZI.setCanceledOnTouchOutside(true);
                    this.aZI.setOnCancelListener(onCancelListener);
                } else {
                    this.aZI.setCanceledOnTouchOutside(false);
                    this.aZI.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZI = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZI, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aSj = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZJ) && this.aSj != null) {
                this.aSj.setText(this.aZJ);
            }
            if (this.aZI != null && this.aZI.getWindow() != null) {
                this.aZI.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZI.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bq(boolean z) {
        if (z) {
            if (this.aZL) {
                b(this.aZK);
                return;
            } else {
                c(this.aZK);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aZI, this.mActivity);
    }

    public void ga(int i) {
        if (this.mActivity != null) {
            this.aZJ = this.mActivity.getString(i);
        }
    }

    public void eR(String str) {
        this.aZJ = str;
        if (this.aSj != null) {
            this.aSj.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aZK = onCancelListener;
    }

    public boolean isShowing() {
        return this.aZI != null && this.aZI.isShowing();
    }

    public void br(boolean z) {
        this.aZL = z;
    }

    public void setCancelable(boolean z) {
        if (this.aZI != null) {
            this.aZI.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aZI != null) {
            this.aZI.setCanceledOnTouchOutside(z);
        }
    }
}
