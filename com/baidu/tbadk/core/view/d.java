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
    private TextView anY;
    private AlertDialog awF;
    private String awG;
    private DialogInterface.OnCancelListener awH;
    private boolean awI;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.awG = null;
        this.anY = null;
        this.awI = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public d(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.awG = null;
        this.anY = null;
        this.awI = true;
        this.mActivity = activity;
    }

    private d b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.awF = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.awF, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.anY = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.awG) && this.anY != null) {
                this.anY.setText(this.awG);
            }
            if (this.awF != null && this.awF.getWindow() != null) {
                this.awF.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.awF.setCancelable(true);
                    this.awF.setCanceledOnTouchOutside(true);
                    this.awF.setOnCancelListener(onCancelListener);
                } else {
                    this.awF.setCanceledOnTouchOutside(false);
                    this.awF.setCancelable(false);
                }
            }
        }
        return this;
    }

    private d c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.awF = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.awF, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.custom_loading_toast, (ViewGroup) null);
            this.anY = (TextView) inflate.findViewById(e.g.custom_loading_text);
            if (!StringUtils.isNull(this.awG) && this.anY != null) {
                this.anY.setText(this.awG);
            }
            if (this.awF != null && this.awF.getWindow() != null) {
                this.awF.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.awF.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aZ(boolean z) {
        if (z) {
            if (this.awI) {
                b(this.awH);
                return;
            } else {
                c(this.awH);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.awF, this.mActivity);
    }

    public void dq(int i) {
        if (this.mActivity != null) {
            this.awG = this.mActivity.getString(i);
        }
    }

    public void fE(String str) {
        this.awG = str;
        if (this.anY != null) {
            this.anY.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.awH = onCancelListener;
    }

    public boolean isShowing() {
        return this.awF != null && this.awF.isShowing();
    }

    public void ba(boolean z) {
        this.awI = z;
    }

    public void setCancelable(boolean z) {
        if (this.awF != null) {
            this.awF.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.awF != null) {
            this.awF.setCanceledOnTouchOutside(z);
        }
    }
}
