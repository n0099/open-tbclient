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
    private AlertDialog aGj;
    private String aGk;
    private DialogInterface.OnCancelListener aGl;
    private boolean aGm;
    private TextView axH;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aGk = null;
        this.axH = null;
        this.aGm = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aGk = null;
        this.axH = null;
        this.aGm = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aGj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aGj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axH = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aGk) && this.axH != null) {
                this.axH.setText(this.aGk);
            }
            if (this.aGj != null && this.aGj.getWindow() != null) {
                this.aGj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aGj.setCancelable(true);
                    this.aGj.setCanceledOnTouchOutside(true);
                    this.aGj.setOnCancelListener(onCancelListener);
                } else {
                    this.aGj.setCanceledOnTouchOutside(false);
                    this.aGj.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aGj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aGj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axH = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aGk) && this.axH != null) {
                this.axH.setText(this.aGk);
            }
            if (this.aGj != null && this.aGj.getWindow() != null) {
                this.aGj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aGj.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bB(boolean z) {
        if (z) {
            if (this.aGm) {
                b(this.aGl);
                return;
            } else {
                c(this.aGl);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aGj, this.mActivity);
    }

    public void ec(int i) {
        if (this.mActivity != null) {
            this.aGk = this.mActivity.getString(i);
        }
    }

    public void gz(String str) {
        this.aGk = str;
        if (this.axH != null) {
            this.axH.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aGl = onCancelListener;
    }

    public boolean isShowing() {
        return this.aGj != null && this.aGj.isShowing();
    }

    public void bC(boolean z) {
        this.aGm = z;
    }

    public void setCancelable(boolean z) {
        if (this.aGj != null) {
            this.aGj.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aGj != null) {
            this.aGj.setCanceledOnTouchOutside(z);
        }
    }
}
