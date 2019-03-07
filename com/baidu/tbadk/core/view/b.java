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
    private TextView bFG;
    private AlertDialog bOq;
    private String bOr;
    private DialogInterface.OnCancelListener bOs;
    private boolean bOt;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bOr = null;
        this.bFG = null;
        this.bOt = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bOr = null;
        this.bFG = null;
        this.bOt = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFG = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOr) && this.bFG != null) {
                this.bFG.setText(this.bOr);
            }
            if (this.bOq != null && this.bOq.getWindow() != null) {
                this.bOq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOq.setCancelable(true);
                    this.bOq.setCanceledOnTouchOutside(true);
                    this.bOq.setOnCancelListener(onCancelListener);
                } else {
                    this.bOq.setCanceledOnTouchOutside(false);
                    this.bOq.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFG = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOr) && this.bFG != null) {
                this.bFG.setText(this.bOr);
            }
            if (this.bOq != null && this.bOq.getWindow() != null) {
                this.bOq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOq.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void dJ(boolean z) {
        if (z) {
            if (this.bOt) {
                c(this.bOs);
                return;
            } else {
                d(this.bOs);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bOq, this.mActivity);
    }

    public void hG(int i) {
        if (this.mActivity != null) {
            this.bOr = this.mActivity.getString(i);
        }
    }

    public void nl(String str) {
        this.bOr = str;
        if (this.bFG != null) {
            this.bFG.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bOs = onCancelListener;
    }

    public boolean isShowing() {
        return this.bOq != null && this.bOq.isShowing();
    }

    public void dK(boolean z) {
        this.bOt = z;
    }

    public void setCancelable(boolean z) {
        if (this.bOq != null) {
            this.bOq.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bOq != null) {
            this.bOq.setCanceledOnTouchOutside(z);
        }
    }
}
