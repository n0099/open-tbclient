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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> aaI;
    private AlertDialog aik;
    private DialogInterface.OnCancelListener aim;
    private Activity mActivity;
    private String ail = null;
    private TextView aaZ = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aaI = null;
        this.mActivity = null;
        this.aaI = tbPageContext;
        if (this.aaI != null && this.aaI.getPageActivity() != null) {
            this.mActivity = this.aaI.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.aik = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.aik, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.custom_loading_toast, (ViewGroup) null);
            this.aaZ = (TextView) inflate.findViewById(w.h.custom_loading_text);
            if (!StringUtils.isNull(this.ail) && this.aaZ != null) {
                this.aaZ.setText(this.ail);
            }
            if (this.aik != null && this.aik.getWindow() != null) {
                this.aik.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.aik.setCancelable(true);
                    this.aik.setCanceledOnTouchOutside(true);
                    this.aik.setOnCancelListener(onCancelListener);
                } else {
                    this.aik.setCanceledOnTouchOutside(false);
                    this.aik.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aI(boolean z) {
        if (z) {
            b(this.aim);
        } else {
            com.baidu.adp.lib.g.j.b(this.aik, this.mActivity);
        }
    }

    public void cW(int i) {
        if (this.mActivity != null) {
            this.ail = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.aim = onCancelListener;
    }
}
