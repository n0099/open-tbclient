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
    private AlertDialog aBq;
    private String aBr;
    private DialogInterface.OnCancelListener aBs;
    private boolean aBt;
    private TextView asQ;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aBr = null;
        this.asQ = null;
        this.aBt = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aBr = null;
        this.asQ = null;
        this.aBt = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aBq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aBq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.asQ = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aBr) && this.asQ != null) {
                this.asQ.setText(this.aBr);
            }
            if (this.aBq != null && this.aBq.getWindow() != null) {
                this.aBq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aBq.setCancelable(true);
                    this.aBq.setCanceledOnTouchOutside(true);
                    this.aBq.setOnCancelListener(onCancelListener);
                } else {
                    this.aBq.setCanceledOnTouchOutside(false);
                    this.aBq.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aBq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aBq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.asQ = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aBr) && this.asQ != null) {
                this.asQ.setText(this.aBr);
            }
            if (this.aBq != null && this.aBq.getWindow() != null) {
                this.aBq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aBq.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bj(boolean z) {
        if (z) {
            if (this.aBt) {
                b(this.aBs);
                return;
            } else {
                c(this.aBs);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aBq, this.mActivity);
    }

    public void dA(int i) {
        if (this.mActivity != null) {
            this.aBr = this.mActivity.getString(i);
        }
    }

    public void fS(String str) {
        this.aBr = str;
        if (this.asQ != null) {
            this.asQ.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aBs = onCancelListener;
    }

    public boolean isShowing() {
        return this.aBq != null && this.aBq.isShowing();
    }

    public void bk(boolean z) {
        this.aBt = z;
    }

    public void setCancelable(boolean z) {
        if (this.aBq != null) {
            this.aBq.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aBq != null) {
            this.aBq.setCanceledOnTouchOutside(z);
        }
    }
}
