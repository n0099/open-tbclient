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
    private TextView bOs;
    private AlertDialog bXr;
    private String bXs;
    private DialogInterface.OnCancelListener bXt;
    private boolean bXu;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bXs = null;
        this.bOs = null;
        this.bXu = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bXs = null;
        this.bOs = null;
        this.bXu = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bXr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bXr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOs = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bXs) && this.bOs != null) {
                this.bOs.setText(this.bXs);
            }
            if (this.bXr != null && this.bXr.getWindow() != null) {
                this.bXr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bXr.setCancelable(true);
                    this.bXr.setCanceledOnTouchOutside(true);
                    this.bXr.setOnCancelListener(onCancelListener);
                } else {
                    this.bXr.setCanceledOnTouchOutside(false);
                    this.bXr.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bXr = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bXr, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOs = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bXs) && this.bOs != null) {
                this.bOs.setText(this.bXs);
            }
            if (this.bXr != null && this.bXr.getWindow() != null) {
                this.bXr.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bXr.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void ej(boolean z) {
        if (z) {
            if (this.bXu) {
                c(this.bXt);
                return;
            } else {
                d(this.bXt);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bXr, this.mActivity);
    }

    public void iz(int i) {
        if (this.mActivity != null) {
            this.bXs = this.mActivity.getString(i);
        }
    }

    public void oM(String str) {
        this.bXs = str;
        if (this.bOs != null) {
            this.bOs.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bXt = onCancelListener;
    }

    public boolean isShowing() {
        return this.bXr != null && this.bXr.isShowing();
    }

    public void ek(boolean z) {
        this.bXu = z;
    }

    public void setCancelable(boolean z) {
        if (this.bXr != null) {
            this.bXr.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bXr != null) {
            this.bXr.setCanceledOnTouchOutside(z);
        }
    }
}
