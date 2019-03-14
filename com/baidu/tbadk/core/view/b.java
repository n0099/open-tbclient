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
    private TextView bFI;
    private AlertDialog bOr;
    private String bOs;
    private DialogInterface.OnCancelListener bOt;
    private boolean bOu;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bOs = null;
        this.bFI = null;
        this.bOu = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bOs = null;
        this.bFI = null;
        this.bOu = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFI = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOs) && this.bFI != null) {
                this.bFI.setText(this.bOs);
            }
            if (this.bOr != null && this.bOr.getWindow() != null) {
                this.bOr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOr.setCancelable(true);
                    this.bOr.setCanceledOnTouchOutside(true);
                    this.bOr.setOnCancelListener(onCancelListener);
                } else {
                    this.bOr.setCanceledOnTouchOutside(false);
                    this.bOr.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFI = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOs) && this.bFI != null) {
                this.bFI.setText(this.bOs);
            }
            if (this.bOr != null && this.bOr.getWindow() != null) {
                this.bOr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOr.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void dJ(boolean z) {
        if (z) {
            if (this.bOu) {
                c(this.bOt);
                return;
            } else {
                d(this.bOt);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bOr, this.mActivity);
    }

    public void hG(int i) {
        if (this.mActivity != null) {
            this.bOs = this.mActivity.getString(i);
        }
    }

    public void nl(String str) {
        this.bOs = str;
        if (this.bFI != null) {
            this.bFI.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bOt = onCancelListener;
    }

    public boolean isShowing() {
        return this.bOr != null && this.bOr.isShowing();
    }

    public void dK(boolean z) {
        this.bOu = z;
    }

    public void setCancelable(boolean z) {
        if (this.bOr != null) {
            this.bOr.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bOr != null) {
            this.bOr.setCanceledOnTouchOutside(z);
        }
    }
}
