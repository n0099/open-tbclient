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
    private AlertDialog aFF;
    private String aFG;
    private DialogInterface.OnCancelListener aFH;
    private boolean aFI;
    private TextView axd;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aFG = null;
        this.axd = null;
        this.aFI = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aFG = null;
        this.axd = null;
        this.aFI = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aFF = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aFF, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axd = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aFG) && this.axd != null) {
                this.axd.setText(this.aFG);
            }
            if (this.aFF != null && this.aFF.getWindow() != null) {
                this.aFF.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aFF.setCancelable(true);
                    this.aFF.setCanceledOnTouchOutside(true);
                    this.aFF.setOnCancelListener(onCancelListener);
                } else {
                    this.aFF.setCanceledOnTouchOutside(false);
                    this.aFF.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aFF = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aFF, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axd = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aFG) && this.axd != null) {
                this.axd.setText(this.aFG);
            }
            if (this.aFF != null && this.aFF.getWindow() != null) {
                this.aFF.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aFF.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bA(boolean z) {
        if (z) {
            if (this.aFI) {
                b(this.aFH);
                return;
            } else {
                c(this.aFH);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aFF, this.mActivity);
    }

    public void ec(int i) {
        if (this.mActivity != null) {
            this.aFG = this.mActivity.getString(i);
        }
    }

    public void gk(String str) {
        this.aFG = str;
        if (this.axd != null) {
            this.axd.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aFH = onCancelListener;
    }

    public boolean isShowing() {
        return this.aFF != null && this.aFF.isShowing();
    }

    public void bB(boolean z) {
        this.aFI = z;
    }

    public void setCancelable(boolean z) {
        if (this.aFF != null) {
            this.aFF.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aFF != null) {
            this.aFF.setCanceledOnTouchOutside(z);
        }
    }
}
