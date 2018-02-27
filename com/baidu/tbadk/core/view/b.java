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
    private TbPageContext<?> aRG;
    private AlertDialog aZw;
    private DialogInterface.OnCancelListener aZy;
    private Activity mActivity;
    private String aZx = null;
    private TextView aRY = null;
    private boolean aZz = true;

    public b(TbPageContext<?> tbPageContext) {
        this.aRG = null;
        this.mActivity = null;
        this.aRG = tbPageContext;
        if (this.aRG != null && this.aRG.getPageActivity() != null) {
            this.mActivity = this.aRG.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZw = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZw, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aRY = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZx) && this.aRY != null) {
                this.aRY.setText(this.aZx);
            }
            if (this.aZw != null && this.aZw.getWindow() != null) {
                this.aZw.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZw.setCancelable(true);
                    this.aZw.setCanceledOnTouchOutside(true);
                    this.aZw.setOnCancelListener(onCancelListener);
                } else {
                    this.aZw.setCanceledOnTouchOutside(false);
                    this.aZw.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aZw = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.aZw, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.custom_loading_toast, (ViewGroup) null);
            this.aRY = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.aZx) && this.aRY != null) {
                this.aRY.setText(this.aZx);
            }
            if (this.aZw != null && this.aZw.getWindow() != null) {
                this.aZw.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aZw.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void bq(boolean z) {
        if (z) {
            if (this.aZz) {
                b(this.aZy);
                return;
            } else {
                c(this.aZy);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.aZw, this.mActivity);
    }

    public void ga(int i) {
        if (this.mActivity != null) {
            this.aZx = this.mActivity.getString(i);
        }
    }

    public void eR(String str) {
        this.aZx = str;
        if (this.aRY != null) {
            this.aRY.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.aZy = onCancelListener;
    }

    public boolean isShowing() {
        return this.aZw != null && this.aZw.isShowing();
    }

    public void br(boolean z) {
        this.aZz = z;
    }

    public void setCancelable(boolean z) {
        if (this.aZw != null) {
            this.aZw.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.aZw != null) {
            this.aZw.setCanceledOnTouchOutside(z);
        }
    }
}
