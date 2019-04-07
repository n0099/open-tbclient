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
    private TextView bFK;
    private AlertDialog bOt;
    private String bOu;
    private DialogInterface.OnCancelListener bOv;
    private boolean bOw;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bOu = null;
        this.bFK = null;
        this.bOw = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bOu = null;
        this.bFK = null;
        this.bOw = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOt = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOt, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFK = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOu) && this.bFK != null) {
                this.bFK.setText(this.bOu);
            }
            if (this.bOt != null && this.bOt.getWindow() != null) {
                this.bOt.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOt.setCancelable(true);
                    this.bOt.setCanceledOnTouchOutside(true);
                    this.bOt.setOnCancelListener(onCancelListener);
                } else {
                    this.bOt.setCanceledOnTouchOutside(false);
                    this.bOt.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bOt = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bOt, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.bFK = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.bOu) && this.bFK != null) {
                this.bFK.setText(this.bOu);
            }
            if (this.bOt != null && this.bOt.getWindow() != null) {
                this.bOt.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bOt.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void dJ(boolean z) {
        if (z) {
            if (this.bOw) {
                c(this.bOv);
                return;
            } else {
                d(this.bOv);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bOt, this.mActivity);
    }

    public void hF(int i) {
        if (this.mActivity != null) {
            this.bOu = this.mActivity.getString(i);
        }
    }

    public void nm(String str) {
        this.bOu = str;
        if (this.bFK != null) {
            this.bFK.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bOv = onCancelListener;
    }

    public boolean isShowing() {
        return this.bOt != null && this.bOt.isShowing();
    }

    public void dK(boolean z) {
        this.bOw = z;
    }

    public void setCancelable(boolean z) {
        if (this.bOt != null) {
            this.bOt.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bOt != null) {
            this.bOt.setCanceledOnTouchOutside(z);
        }
    }
}
