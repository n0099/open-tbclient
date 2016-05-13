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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<?> Do;
    private AlertDialog ZY;
    private DialogInterface.OnCancelListener aaa;
    private Activity mActivity;
    private String ZZ = null;
    private TextView SF = null;

    public b(TbPageContext<?> tbPageContext) {
        this.Do = null;
        this.mActivity = null;
        this.Do = tbPageContext;
        if (this.Do != null && this.Do.getPageActivity() != null) {
            this.mActivity = this.Do.getPageActivity();
        }
    }

    private b b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.ZY = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.h.j.a(this.ZY, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.custom_loading_toast, (ViewGroup) null);
            this.SF = (TextView) inflate.findViewById(t.g.custom_loading_text);
            if (!StringUtils.isNull(this.ZZ) && this.SF != null) {
                this.SF.setText(this.ZZ);
            }
            if (this.ZY != null && this.ZY.getWindow() != null) {
                this.ZY.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.ZY.setCancelable(true);
                    this.ZY.setCanceledOnTouchOutside(true);
                    this.ZY.setOnCancelListener(onCancelListener);
                } else {
                    this.ZY.setCanceledOnTouchOutside(false);
                    this.ZY.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aD(boolean z) {
        if (z) {
            b(this.aaa);
        } else {
            com.baidu.adp.lib.h.j.b(this.ZY, this.mActivity);
        }
    }

    public void cG(int i) {
        if (this.mActivity != null) {
            this.ZZ = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aaa = onCancelListener;
    }
}
