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
public class a {
    private TextView alu;
    private AlertDialog atq;
    private String atr;
    private DialogInterface.OnCancelListener ats;
    private boolean att;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.atr = null;
        this.alu = null;
        this.att = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public a(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.atr = null;
        this.alu = null;
        this.att = true;
        this.mActivity = activity;
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.alu = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atr) && this.alu != null) {
                this.alu.setText(this.atr);
            }
            if (this.atq != null && this.atq.getWindow() != null) {
                this.atq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atq.setCancelable(true);
                    this.atq.setCanceledOnTouchOutside(true);
                    this.atq.setOnCancelListener(onCancelListener);
                } else {
                    this.atq.setCanceledOnTouchOutside(false);
                    this.atq.setCancelable(false);
                }
            }
        }
        return this;
    }

    private a c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atq = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atq, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.alu = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atr) && this.alu != null) {
                this.alu.setText(this.atr);
            }
            if (this.atq != null && this.atq.getWindow() != null) {
                this.atq.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atq.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aM(boolean z) {
        if (z) {
            if (this.att) {
                b(this.ats);
                return;
            } else {
                c(this.ats);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.atq, this.mActivity);
    }

    public void df(int i) {
        if (this.mActivity != null) {
            this.atr = this.mActivity.getString(i);
        }
    }

    public void fk(String str) {
        this.atr = str;
        if (this.alu != null) {
            this.alu.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.ats = onCancelListener;
    }

    public boolean isShowing() {
        return this.atq != null && this.atq.isShowing();
    }

    public void aN(boolean z) {
        this.att = z;
    }

    public void setCancelable(boolean z) {
        if (this.atq != null) {
            this.atq.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.atq != null) {
            this.atq.setCanceledOnTouchOutside(z);
        }
    }
}
