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
    private TbPageContext<?> ceu;
    private boolean isAutoSetCancelable;
    private Activity mActivity;
    private DialogInterface.OnCancelListener mOnCancelListner;
    private TextView mTipView;
    private AlertDialog mWaitingDialog;
    private String tipString;

    public b(TbPageContext<?> tbPageContext) {
        this.ceu = null;
        this.mActivity = null;
        this.tipString = null;
        this.mTipView = null;
        this.isAutoSetCancelable = true;
        this.ceu = tbPageContext;
        if (this.ceu != null && this.ceu.getPageActivity() != null) {
            this.mActivity = this.ceu.getPageActivity();
        }
    }

    public b(Activity activity) {
        this.ceu = null;
        this.mActivity = null;
        this.tipString = null;
        this.mTipView = null;
        this.isAutoSetCancelable = true;
        this.mActivity = activity;
    }

    private b d(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.mWaitingDialog = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.showDialog(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.tipString) && this.mTipView != null) {
                this.mTipView.setText(this.tipString);
            }
            if (this.mWaitingDialog != null && this.mWaitingDialog.getWindow() != null) {
                this.mWaitingDialog.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.mWaitingDialog.setCancelable(true);
                    this.mWaitingDialog.setCanceledOnTouchOutside(true);
                    this.mWaitingDialog.setOnCancelListener(onCancelListener);
                } else {
                    this.mWaitingDialog.setCanceledOnTouchOutside(false);
                    this.mWaitingDialog.setCancelable(false);
                }
            }
        }
        return this;
    }

    private b e(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.mWaitingDialog = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.g.showDialog(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.tipString) && this.mTipView != null) {
                this.mTipView.setText(this.tipString);
            }
            if (this.mWaitingDialog != null && this.mWaitingDialog.getWindow() != null) {
                this.mWaitingDialog.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.mWaitingDialog.setOnCancelListener(onCancelListener);
                }
            }
        }
        return this;
    }

    public void setDialogVisiable(boolean z) {
        if (z) {
            if (this.isAutoSetCancelable) {
                d(this.mOnCancelListner);
                return;
            } else {
                e(this.mOnCancelListner);
                return;
            }
        }
        com.baidu.adp.lib.g.g.dismissDialog(this.mWaitingDialog, this.mActivity);
    }

    public void setTipString(int i) {
        if (this.mActivity != null) {
            this.tipString = this.mActivity.getString(i);
        }
    }

    public void setTipString(String str) {
        this.tipString = str;
        if (this.mTipView != null) {
            this.mTipView.setText(str);
        }
    }

    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListner = onCancelListener;
    }

    public boolean isShowing() {
        return this.mWaitingDialog != null && this.mWaitingDialog.isShowing();
    }

    public void setAutoSetCancelable(boolean z) {
        this.isAutoSetCancelable = z;
    }

    public void setCancelable(boolean z) {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(z);
        }
    }
}
