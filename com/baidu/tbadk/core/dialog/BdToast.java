package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aci;
    private static HashMap<DefaultIcon, Integer> acn = new HashMap<>(2);
    private final TextView abZ;
    private final ImageView acj;
    private CharSequence ack;
    private final Context mContext;
    private final ViewGroup mRootView;
    private Toast yC;
    private int acl = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int ur = 0;
    private int us = 0;
    private int acm = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        acn.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        acn.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        acn.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.acj = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.abZ = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.ack = charSequence;
        this.abZ.setText(this.ack);
        return this;
    }

    public void co(int i) {
        this.acm = i;
    }

    public BdToast cp(int i) {
        this.acl = i;
        return this;
    }

    public BdToast cq(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cr(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.us = i;
    }

    public void E(float f) {
        this.abZ.setLineSpacing(0.0f, f);
    }

    public BdToast tr() {
        this.yC = new Toast(this.mContext);
        ts();
        if (this.acl != -1) {
            aj.c(this.acj, this.acl);
            this.acj.setVisibility(0);
        } else {
            this.acj.setVisibility(8);
        }
        aj.c(this.abZ, d.C0082d.cp_cont_g, 1);
        this.abZ.setText(this.ack);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.mDuration);
        cs(this.acm);
        this.yC.setView(this.mRootView);
        return this;
    }

    private BdToast k(int i, int i2, int i3) {
        this.mGravity = i;
        this.ur = i2;
        this.us = i3;
        return tr();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).k(i, i2, i3);
    }

    private void ts() {
        if (aci != null && aci.get() != null) {
            aci.get().cancel();
        }
        aci = new SoftReference<>(this.yC);
    }

    private void cs(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tt() {
        this.abZ.setText(this.ack);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.mDuration);
        this.yC.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tr();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cr(i).tr();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cp(i).tr();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cp(i).cr(i2).tr();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cp(acn.get(defaultIcon).intValue()).tr();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cp(acn.get(defaultIcon).intValue()).cr(i).tr();
    }
}
