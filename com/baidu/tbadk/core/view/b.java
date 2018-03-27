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
public class b {
    private TbPageContext<?> aRI;
    private DialogInterface.OnCancelListener aZA;
    private AlertDialog aZy;
    private Activity mActivity;
    private String aZz = null;
    private TextView aSa = null;
    private boolean aZB = true;

    public b(TbPageContext<?> tbPageContext) {
        this.aRI = null;
        this.mActivity = null;
        this.aRI = tbPageContext;
        if (this.aRI != null && this.aRI.getPageActivity() != null) {
            this.mActivity = this.aRI.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZy = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZy, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aSa = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZz) && this.aSa != null) {
                this.aSa.setText(this.aZz);
            }
            if (this.aZy != null && this.aZy.getWindow() != null) {
                this.aZy.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZy.setCancelable(true);
                    this.aZy.setCanceledOnTouchOutside(true);
                    this.aZy.setOnCancelListener(onCancelListener);
                } else {
                    this.aZy.setCanceledOnTouchOutside(false);
                    this.aZy.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZy = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZy, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aSa = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZz) && this.aSa != null) {
                this.aSa.setText(this.aZz);
            }
            if (this.aZy != null && this.aZy.getWindow() != null) {
                this.aZy.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZy.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bq(boolean z) {
        if (z) {
            if (this.aZB) {
                b(this.aZA);
                return;
            } else {
                c(this.aZA);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aZy, this.mActivity);
    }

    public void ga(int i) {
        if (this.mActivity != null) {
            this.aZz = this.mActivity.getString(i);
        }
    }

    public void eR(String str) {
        this.aZz = str;
        if (this.aSa != null) {
            this.aSa.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aZA = onCancelListener;
    }

    public boolean isShowing() {
        return this.aZy != null && this.aZy.isShowing();
    }

    public void br(boolean z) {
        this.aZB = z;
    }

    public void setCancelable(boolean z) {
        if (this.aZy != null) {
            this.aZy.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aZy != null) {
            this.aZy.setCanceledOnTouchOutside(z);
        }
    }
}
