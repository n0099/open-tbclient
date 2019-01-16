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
    private AlertDialog aGi;
    private String aGj;
    private DialogInterface.OnCancelListener aGk;
    private boolean aGl;
    private TextView axG;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aGj = null;
        this.axG = null;
        this.aGl = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aGj = null;
        this.axG = null;
        this.aGl = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aGi = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aGi, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axG = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aGj) && this.axG != null) {
                this.axG.setText(this.aGj);
            }
            if (this.aGi != null && this.aGi.getWindow() != null) {
                this.aGi.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aGi.setCancelable(true);
                    this.aGi.setCanceledOnTouchOutside(true);
                    this.aGi.setOnCancelListener(onCancelListener);
                } else {
                    this.aGi.setCanceledOnTouchOutside(false);
                    this.aGi.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aGi = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aGi, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axG = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aGj) && this.axG != null) {
                this.axG.setText(this.aGj);
            }
            if (this.aGi != null && this.aGi.getWindow() != null) {
                this.aGi.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aGi.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bB(boolean z) {
        if (z) {
            if (this.aGl) {
                b(this.aGk);
                return;
            } else {
                c(this.aGk);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aGi, this.mActivity);
    }

    public void ec(int i) {
        if (this.mActivity != null) {
            this.aGj = this.mActivity.getString(i);
        }
    }

    public void gz(String str) {
        this.aGj = str;
        if (this.axG != null) {
            this.axG.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aGk = onCancelListener;
    }

    public boolean isShowing() {
        return this.aGi != null && this.aGi.isShowing();
    }

    public void bC(boolean z) {
        this.aGl = z;
    }

    public void setCancelable(boolean z) {
        if (this.aGi != null) {
            this.aGi.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aGi != null) {
            this.aGi.setCanceledOnTouchOutside(z);
        }
    }
}
