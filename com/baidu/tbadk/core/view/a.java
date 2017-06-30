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
    private TbPageContext<?> aat;
    private AlertDialog air;
    private DialogInterface.OnCancelListener ait;
    private Activity mActivity;
    private String ais = null;
    private TextView aaK = null;

    public a(TbPageContext<?> tbPageContext) {
        this.aat = null;
        this.mActivity = null;
        this.aat = tbPageContext;
        if (this.aat != null && this.aat.getPageActivity() != null) {
            this.mActivity = this.aat.getPageActivity();
        }
    }

    private a b(DialogInterface.OnCancelListener onCancelListener) {
        if (this.mActivity != null) {
            this.air = new AlertDialog.Builder(this.mActivity).create();
            com.baidu.adp.lib.g.j.a(this.air, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.custom_loading_toast, (ViewGroup) null);
            this.aaK = (TextView) inflate.findViewById(w.h.custom_loading_text);
            if (!StringUtils.isNull(this.ais) && this.aaK != null) {
                this.aaK.setText(this.ais);
            }
            if (this.air != null && this.air.getWindow() != null) {
                this.air.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.air.setCancelable(true);
                    this.air.setCanceledOnTouchOutside(true);
                    this.air.setOnCancelListener(onCancelListener);
                } else {
                    this.air.setCanceledOnTouchOutside(false);
                    this.air.setCancelable(false);
                }
            }
        }
        return this;
    }

    public void aI(boolean z) {
        if (z) {
            b(this.ait);
        } else {
            com.baidu.adp.lib.g.j.b(this.air, this.mActivity);
        }
    }

    public void cY(int i) {
        if (this.mActivity != null) {
            this.ais = this.mActivity.getString(i);
        }
    }

    public void c(DialogInterface.OnCancelListener onCancelListener) {
        this.ait = onCancelListener;
    }
}
