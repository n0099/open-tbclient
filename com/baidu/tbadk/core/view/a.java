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
public class a {
    private TextView alU;
    private AlertDialog atM;
    private String atN;
    private DialogInterface.OnCancelListener atO;
    private boolean atP;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.atN = null;
        this.alU = null;
        this.atP = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public a(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.atN = null;
        this.alU = null;
        this.atP = true;
        this.mActivity = activity;
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atM = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atM, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.alU = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atN) && this.alU != null) {
                this.alU.setText(this.atN);
            }
            if (this.atM != null && this.atM.getWindow() != null) {
                this.atM.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atM.setCancelable(true);
                    this.atM.setCanceledOnTouchOutside(true);
                    this.atM.setOnCancelListener(onCancelListener);
                } else {
                    this.atM.setCanceledOnTouchOutside(false);
                    this.atM.setCancelable(false);
                }
            }
        }
        return this;
    }

    private a c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atM = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atM, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.alU = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atN) && this.alU != null) {
                this.alU.setText(this.atN);
            }
            if (this.atM != null && this.atM.getWindow() != null) {
                this.atM.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atM.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aO(boolean z) {
        if (z) {
            if (this.atP) {
                b(this.atO);
                return;
            } else {
                c(this.atO);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.atM, this.mActivity);
    }

    public void dd(int i) {
        if (this.mActivity != null) {
            this.atN = this.mActivity.getString(i);
        }
    }

    public void fm(String str) {
        this.atN = str;
        if (this.alU != null) {
            this.alU.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.atO = onCancelListener;
    }

    public boolean isShowing() {
        return this.atM != null && this.atM.isShowing();
    }

    public void aP(boolean z) {
        this.atP = z;
    }

    public void setCancelable(boolean z) {
        if (this.atM != null) {
            this.atM.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.atM != null) {
            this.atM.setCanceledOnTouchOutside(z);
        }
    }
}
