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
    private TextView bNl;
    private AlertDialog bWi;
    private String bWj;
    private DialogInterface.OnCancelListener bWk;
    private boolean bWl;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bWj = null;
        this.bNl = null;
        this.bWl = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bWj = null;
        this.bNl = null;
        this.bWl = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bWi = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bWi, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bNl = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bWj) && this.bNl != null) {
                this.bNl.setText(this.bWj);
            }
            if (this.bWi != null && this.bWi.getWindow() != null) {
                this.bWi.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bWi.setCancelable(true);
                    this.bWi.setCanceledOnTouchOutside(true);
                    this.bWi.setOnCancelListener(onCancelListener);
                } else {
                    this.bWi.setCanceledOnTouchOutside(false);
                    this.bWi.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bWi = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bWi, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bNl = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bWj) && this.bNl != null) {
                this.bNl.setText(this.bWj);
            }
            if (this.bWi != null && this.bWi.getWindow() != null) {
                this.bWi.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bWi.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void ef(boolean z) {
        if (z) {
            if (this.bWl) {
                c(this.bWk);
                return;
            } else {
                d(this.bWk);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bWi, this.mActivity);
    }

    public void it(int i) {
        if (this.mActivity != null) {
            this.bWj = this.mActivity.getString(i);
        }
    }

    public void ow(String str) {
        this.bWj = str;
        if (this.bNl != null) {
            this.bNl.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bWk = onCancelListener;
    }

    public boolean isShowing() {
        return this.bWi != null && this.bWi.isShowing();
    }

    public void eg(boolean z) {
        this.bWl = z;
    }

    public void setCancelable(boolean z) {
        if (this.bWi != null) {
            this.bWi.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bWi != null) {
            this.bWi.setCanceledOnTouchOutside(z);
        }
    }
}
