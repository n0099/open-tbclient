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
    private AlertDialog alb;
    private DialogInterface.OnCancelListener ald;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String alc = null;
    private TextView adw = null;
    private boolean ale = true;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.alb = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.alb, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.adw = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.alc) && this.adw != null) {
                this.adw.setText(this.alc);
            }
            if (this.alb != null && this.alb.getWindow() != null) {
                this.alb.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.alb.setCancelable(true);
                    this.alb.setCanceledOnTouchOutside(true);
                    this.alb.setOnCancelListener(onCancelListener);
                } else {
                    this.alb.setCanceledOnTouchOutside(false);
                    this.alb.setCancelable(false);
                }
            }
        }
        return this;
    }

    private a c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.alb = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.alb, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.adw = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.alc) && this.adw != null) {
                this.adw.setText(this.alc);
            }
            if (this.alb != null && this.alb.getWindow() != null) {
                this.alb.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.alb.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aI(boolean z) {
        if (z) {
            if (this.ale) {
                b(this.ald);
                return;
            } else {
                c(this.ald);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.alb, this.mActivity);
    }

    public void da(int i) {
        if (this.mActivity != null) {
            this.alc = this.mActivity.getString(i);
        }
    }

    public void eJ(String str) {
        this.alc = str;
        if (this.adw != null) {
            this.adw.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.ald = onCancelListener;
    }

    public boolean isShowing() {
        return this.alb != null && this.alb.isShowing();
    }

    public void aJ(boolean z) {
        this.ale = z;
    }

    public void setCancelable(boolean z) {
        if (this.alb != null) {
            this.alb.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.alb != null) {
            this.alb.setCanceledOnTouchOutside(z);
        }
    }
}
