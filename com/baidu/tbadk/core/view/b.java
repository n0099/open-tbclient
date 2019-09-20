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
    private TextView bOT;
    private AlertDialog bYk;
    private String bYl;
    private DialogInterface.OnCancelListener bYm;
    private boolean bYn;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bYl = null;
        this.bOT = null;
        this.bYn = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bYl = null;
        this.bOT = null;
        this.bYn = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bYk = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bYk, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOT = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bYl) && this.bOT != null) {
                this.bOT.setText(this.bYl);
            }
            if (this.bYk != null && this.bYk.getWindow() != null) {
                this.bYk.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bYk.setCancelable(true);
                    this.bYk.setCanceledOnTouchOutside(true);
                    this.bYk.setOnCancelListener(onCancelListener);
                } else {
                    this.bYk.setCanceledOnTouchOutside(false);
                    this.bYk.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bYk = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bYk, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bOT = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bYl) && this.bOT != null) {
                this.bOT.setText(this.bYl);
            }
            if (this.bYk != null && this.bYk.getWindow() != null) {
                this.bYk.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bYk.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void em(boolean z) {
        if (z) {
            if (this.bYn) {
                c(this.bYm);
                return;
            } else {
                d(this.bYm);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bYk, this.mActivity);
    }

    public void iC(int i) {
        if (this.mActivity != null) {
            this.bYl = this.mActivity.getString(i);
        }
    }

    public void oU(String str) {
        this.bYl = str;
        if (this.bOT != null) {
            this.bOT.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bYm = onCancelListener;
    }

    public boolean isShowing() {
        return this.bYk != null && this.bYk.isShowing();
    }

    public void en(boolean z) {
        this.bYn = z;
    }

    public void setCancelable(boolean z) {
        if (this.bYk != null) {
            this.bYk.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bYk != null) {
            this.bYk.setCanceledOnTouchOutside(z);
        }
    }
}
