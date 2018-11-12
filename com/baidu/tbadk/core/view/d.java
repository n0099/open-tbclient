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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private AlertDialog aCf;
    private String aCg;
    private DialogInterface.OnCancelListener aCh;
    private boolean aCi;
    private TextView atD;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aCg = null;
        this.atD = null;
        this.aCi = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aCg = null;
        this.atD = null;
        this.aCi = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aCf = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aCf, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.atD = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aCg) && this.atD != null) {
                this.atD.setText(this.aCg);
            }
            if (this.aCf != null && this.aCf.getWindow() != null) {
                this.aCf.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aCf.setCancelable(true);
                    this.aCf.setCanceledOnTouchOutside(true);
                    this.aCf.setOnCancelListener(onCancelListener);
                } else {
                    this.aCf.setCanceledOnTouchOutside(false);
                    this.aCf.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aCf = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aCf, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.atD = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aCg) && this.atD != null) {
                this.atD.setText(this.aCg);
            }
            if (this.aCf != null && this.aCf.getWindow() != null) {
                this.aCf.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aCf.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bz(boolean z) {
        if (z) {
            if (this.aCi) {
                b(this.aCh);
                return;
            } else {
                c(this.aCh);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aCf, this.mActivity);
    }

    public void dO(int i) {
        if (this.mActivity != null) {
            this.aCg = this.mActivity.getString(i);
        }
    }

    public void fS(String str) {
        this.aCg = str;
        if (this.atD != null) {
            this.atD.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aCh = onCancelListener;
    }

    public boolean isShowing() {
        return this.aCf != null && this.aCf.isShowing();
    }

    public void bA(boolean z) {
        this.aCi = z;
    }

    public void setCancelable(boolean z) {
        if (this.aCf != null) {
            this.aCf.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aCf != null) {
            this.aCf.setCanceledOnTouchOutside(z);
        }
    }
}
