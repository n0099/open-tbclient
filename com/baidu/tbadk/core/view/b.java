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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private TextView bOn;
    private AlertDialog bXl;
    private String bXm;
    private DialogInterface.OnCancelListener bXn;
    private boolean bXo;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bXm = null;
        this.bOn = null;
        this.bXo = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bXm = null;
        this.bOn = null;
        this.bXo = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bXl = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bXl, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOn = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bXm) && this.bOn != null) {
                this.bOn.setText(this.bXm);
            }
            if (this.bXl != null && this.bXl.getWindow() != null) {
                this.bXl.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bXl.setCancelable(true);
                    this.bXl.setCanceledOnTouchOutside(true);
                    this.bXl.setOnCancelListener(onCancelListener);
                } else {
                    this.bXl.setCanceledOnTouchOutside(false);
                    this.bXl.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bXl = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bXl, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOn = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bXm) && this.bOn != null) {
                this.bOn.setText(this.bXm);
            }
            if (this.bXl != null && this.bXl.getWindow() != null) {
                this.bXl.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bXl.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void ej(boolean z) {
        if (z) {
            if (this.bXo) {
                c(this.bXn);
                return;
            } else {
                d(this.bXn);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bXl, this.mActivity);
    }

    public void iz(int i) {
        if (this.mActivity != null) {
            this.bXm = this.mActivity.getString(i);
        }
    }

    public void oM(String str) {
        this.bXm = str;
        if (this.bOn != null) {
            this.bOn.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bXn = onCancelListener;
    }

    public boolean isShowing() {
        return this.bXl != null && this.bXl.isShowing();
    }

    public void ek(boolean z) {
        this.bXo = z;
    }

    public void setCancelable(boolean z) {
        if (this.bXl != null) {
            this.bXl.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bXl != null) {
            this.bXl.setCanceledOnTouchOutside(z);
        }
    }
}
