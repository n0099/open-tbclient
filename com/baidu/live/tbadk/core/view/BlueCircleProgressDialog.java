package com.baidu.live.tbadk.core.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class BlueCircleProgressDialog {
    private Activity mActivity;
    private TbPageContext<?> mContext;
    private DialogInterface.OnCancelListener mOnCancelListner;
    private AlertDialog mWaitingDialog;
    private String tipString = null;
    private TextView mTipView = null;
    private boolean isAutoSetCancelable = true;

    public BlueCircleProgressDialog(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mActivity = null;
        this.mContext = tbPageContext;
        if (this.mContext != null && this.mContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    private BlueCircleProgressDialog create(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.mWaitingDialog = new AlertDialog.Builder(this.mActivity).create();
            ShowUtil.showDialog(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(a.h.sdk_custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(a.g.custom_loading_text);
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

    private BlueCircleProgressDialog createCanSetCancelableDialog(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.mWaitingDialog = new AlertDialog.Builder(this.mActivity).create();
            ShowUtil.showDialog(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(a.h.sdk_custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(a.g.custom_loading_text);
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
                create(this.mOnCancelListner);
                return;
            } else {
                createCanSetCancelableDialog(this.mOnCancelListner);
                return;
            }
        }
        ShowUtil.dismissDialog(this.mWaitingDialog, this.mActivity);
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
