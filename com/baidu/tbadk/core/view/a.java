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
    private AlertDialog atj;
    private DialogInterface.OnCancelListener atl;
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private String atk = null;
    private TextView alu = null;
    private boolean atm = true;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.alu = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atk) && this.alu != null) {
                this.alu.setText(this.atk);
            }
            if (this.atj != null && this.atj.getWindow() != null) {
                this.atj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atj.setCancelable(true);
                    this.atj.setCanceledOnTouchOutside(true);
                    this.atj.setOnCancelListener(onCancelListener);
                } else {
                    this.atj.setCanceledOnTouchOutside(false);
                    this.atj.setCancelable(false);
                }
            }
        }
        return this;
    }

    private a c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.atj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.atj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.i.custom_loading_toast, (ViewGroup) null);
            this.alu = (TextView) inflate.findViewById(d.g.custom_loading_text);
            if (!StringUtils.isNull(this.atk) && this.alu != null) {
                this.alu.setText(this.atk);
            }
            if (this.atj != null && this.atj.getWindow() != null) {
                this.atj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.atj.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void aM(boolean z) {
        if (z) {
            if (this.atm) {
                b(this.atl);
                return;
            } else {
                c(this.atl);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.atj, this.mActivity);
    }

    public void dc(int i) {
        if (this.mActivity != null) {
            this.atk = this.mActivity.getString(i);
        }
    }

    public void fi(String str) {
        this.atk = str;
        if (this.alu != null) {
            this.alu.setText(str);
        }
    }

    public void d(DialogInterface.OnCancelListener onCancelListener) {
        this.atl = onCancelListener;
    }

    public boolean isShowing() {
        return this.atj != null && this.atj.isShowing();
    }

    public void aN(boolean z) {
        this.atm = z;
    }

    public void setCancelable(boolean z) {
        if (this.atj != null) {
            this.atj.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.atj != null) {
            this.atj.setCanceledOnTouchOutside(z);
        }
    }
}
