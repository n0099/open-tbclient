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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a {
    private TextView alt;
    private AlertDialog atr;
    private String ats;
    private DialogInterface.OnCancelListener att;
    private boolean atu;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.ats = null;
        this.alt = null;
        this.atu = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public a(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.ats = null;
        this.alt = null;
        this.atu = true;
        this.mActivity = activity;
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(f.h.custom_loading_toast, (ViewGroup) null);
            this.alt = (TextView) inflate.findViewById(f.g.custom_loading_text);
            if (!StringUtils.isNull(this.ats) && this.alt != null) {
                this.alt.setText(this.ats);
            }
            if (this.atr != null && this.atr.getWindow() != null) {
                this.atr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atr.setCancelable(true);
                    this.atr.setCanceledOnTouchOutside(true);
                    this.atr.setOnCancelListener(onCancelListener);
                } else {
                    this.atr.setCanceledOnTouchOutside(false);
                    this.atr.setCancelable(false);
                }
            }
        }
        return this;
    }

    private a c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(f.h.custom_loading_toast, (ViewGroup) null);
            this.alt = (TextView) inflate.findViewById(f.g.custom_loading_text);
            if (!StringUtils.isNull(this.ats) && this.alt != null) {
                this.alt.setText(this.ats);
            }
            if (this.atr != null && this.atr.getWindow() != null) {
                this.atr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atr.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aN(boolean z) {
        if (z) {
            if (this.atu) {
                b(this.att);
                return;
            } else {
                c(this.att);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.atr, this.mActivity);
    }

    public void df(int i) {
        if (this.mActivity != null) {
            this.ats = this.mActivity.getString(i);
        }
    }

    public void fk(String str) {
        this.ats = str;
        if (this.alt != null) {
            this.alt.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.att = onCancelListener;
    }

    public boolean isShowing() {
        return this.atr != null && this.atr.isShowing();
    }

    public void aO(boolean z) {
        this.atu = z;
    }

    public void setCancelable(boolean z) {
        if (this.atr != null) {
            this.atr.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.atr != null) {
            this.atr.setCanceledOnTouchOutside(z);
        }
    }
}
