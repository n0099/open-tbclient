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
    private TextView bFL;
    private AlertDialog bOu;
    private String bOv;
    private DialogInterface.OnCancelListener bOw;
    private boolean bOx;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bOv = null;
        this.bFL = null;
        this.bOx = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bOv = null;
        this.bFL = null;
        this.bOx = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOu = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOu, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFL = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOv) && this.bFL != null) {
                this.bFL.setText(this.bOv);
            }
            if (this.bOu != null && this.bOu.getWindow() != null) {
                this.bOu.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOu.setCancelable(true);
                    this.bOu.setCanceledOnTouchOutside(true);
                    this.bOu.setOnCancelListener(onCancelListener);
                } else {
                    this.bOu.setCanceledOnTouchOutside(false);
                    this.bOu.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOu = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOu, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFL = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOv) && this.bFL != null) {
                this.bFL.setText(this.bOv);
            }
            if (this.bOu != null && this.bOu.getWindow() != null) {
                this.bOu.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOu.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void dJ(boolean z) {
        if (z) {
            if (this.bOx) {
                c(this.bOw);
                return;
            } else {
                d(this.bOw);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bOu, this.mActivity);
    }

    public void hF(int i) {
        if (this.mActivity != null) {
            this.bOv = this.mActivity.getString(i);
        }
    }

    public void nm(String str) {
        this.bOv = str;
        if (this.bFL != null) {
            this.bFL.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bOw = onCancelListener;
    }

    public boolean isShowing() {
        return this.bOu != null && this.bOu.isShowing();
    }

    public void dK(boolean z) {
        this.bOx = z;
    }

    public void setCancelable(boolean z) {
        if (this.bOu != null) {
            this.bOu.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bOu != null) {
            this.bOu.setCanceledOnTouchOutside(z);
        }
    }
}
