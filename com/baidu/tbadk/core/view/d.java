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
    private AlertDialog aFG;
    private String aFH;
    private DialogInterface.OnCancelListener aFI;
    private boolean aFJ;
    private TextView axe;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.aFH = null;
        this.axe = null;
        this.aFJ = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.aFH = null;
        this.axe = null;
        this.aFJ = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aFG = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aFG, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axe = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aFH) && this.axe != null) {
                this.axe.setText(this.aFH);
            }
            if (this.aFG != null && this.aFG.getWindow() != null) {
                this.aFG.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aFG.setCancelable(true);
                    this.aFG.setCanceledOnTouchOutside(true);
                    this.aFG.setOnCancelListener(onCancelListener);
                } else {
                    this.aFG.setCanceledOnTouchOutside(false);
                    this.aFG.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aFG = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aFG, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.axe = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.aFH) && this.axe != null) {
                this.axe.setText(this.aFH);
            }
            if (this.aFG != null && this.aFG.getWindow() != null) {
                this.aFG.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aFG.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bA(boolean z) {
        if (z) {
            if (this.aFJ) {
                b(this.aFI);
                return;
            } else {
                c(this.aFI);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aFG, this.mActivity);
    }

    public void ec(int i) {
        if (this.mActivity != null) {
            this.aFH = this.mActivity.getString(i);
        }
    }

    public void gl(String str) {
        this.aFH = str;
        if (this.axe != null) {
            this.axe.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aFI = onCancelListener;
    }

    public boolean isShowing() {
        return this.aFG != null && this.aFG.isShowing();
    }

    public void bB(boolean z) {
        this.aFJ = z;
    }

    public void setCancelable(boolean z) {
        if (this.aFG != null) {
            this.aFG.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aFG != null) {
            this.aFG.setCanceledOnTouchOutside(z);
        }
    }
}
