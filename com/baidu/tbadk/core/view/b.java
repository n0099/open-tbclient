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
    private TextView bNm;
    private AlertDialog bWj;
    private String bWk;
    private DialogInterface.OnCancelListener bWl;
    private boolean bWm;
    private Activity mActivity;
    private TbPageContext<?> mContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.bWk = null;
        this.bNm = null;
        this.bWm = true;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.bWk = null;
        this.bNm = null;
        this.bWm = true;
        this.mActivity = activity;
    }

    private b c(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bWj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bWj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bNm = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bWk) && this.bNm != null) {
                this.bNm.setText(this.bWk);
            }
            if (this.bWj != null && this.bWj.getWindow() != null) {
                this.bWj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bWj.setCancelable(true);
                    this.bWj.setCanceledOnTouchOutside(true);
                    this.bWj.setOnCancelListener(onCancelListener);
                } else {
                    this.bWj.setCanceledOnTouchOutside(false);
                    this.bWj.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.bWj = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.a(this.bWj, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.bNm = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.bWk) && this.bNm != null) {
                this.bNm.setText(this.bWk);
            }
            if (this.bWj != null && this.bWj.getWindow() != null) {
                this.bWj.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.bWj.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void ef(boolean z) {
        if (z) {
            if (this.bWm) {
                c(this.bWl);
                return;
            } else {
                d(this.bWl);
                return;
            }
        }
        com.baidu.adp.lib.g.g.b(this.bWj, this.mActivity);
    }

    public void it(int i) {
        if (this.mActivity != null) {
            this.bWk = this.mActivity.getString(i);
        }
    }

    public void ov(String str) {
        this.bWk = str;
        if (this.bNm != null) {
            this.bNm.setText(str);
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.bWl = onCancelListener;
    }

    public boolean isShowing() {
        return this.bWj != null && this.bWj.isShowing();
    }

    public void eg(boolean z) {
        this.bWm = z;
    }

    public void setCancelable(boolean z) {
        if (this.bWj != null) {
            this.bWj.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.bWj != null) {
            this.bWj.setCanceledOnTouchOutside(z);
        }
    }
}
