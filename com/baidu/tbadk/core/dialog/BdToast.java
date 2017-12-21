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
    private static SoftReference<Toast> acf;
    private static HashMap<DefaultIcon, Integer> ack = new HashMap<>(2);
    private final TextView abW;
    private final ImageView acg;
    private CharSequence ach;
    private final Context mContext;
    private final ViewGroup mRootView;
    private Toast yA;
    private int aci = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int up = 0;
    private int uq = 0;
    private int acj = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        ack.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        ack.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        ack.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.acg = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.abW = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.ach = charSequence;
        this.abW.setText(this.ach);
        return this;
    }

    public void co(int i) {
        this.acj = i;
    }

    public BdToast cp(int i) {
        this.aci = i;
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
        this.uq = i;
    }

    public void E(float f) {
        this.abW.setLineSpacing(0.0f, f);
    }

    public BdToast to() {
        this.yA = new Toast(this.mContext);
        tp();
        if (this.aci != -1) {
            aj.c(this.acg, this.aci);
            this.acg.setVisibility(0);
        } else {
            this.acg.setVisibility(8);
        }
        aj.c(this.abW, d.C0095d.cp_cont_g, 1);
        this.abW.setText(this.ach);
        this.yA.setGravity(this.mGravity, this.up, this.uq);
        this.yA.setDuration(this.mDuration);
        cs(this.acj);
        this.yA.setView(this.mRootView);
        return this;
    }

    private BdToast k(int i, int i2, int i3) {
        this.mGravity = i;
        this.up = i2;
        this.uq = i3;
        return to();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).k(i, i2, i3);
    }

    private void tp() {
        if (acf != null && acf.get() != null) {
            acf.get().cancel();
        }
        acf = new SoftReference<>(this.yA);
    }

    private void cs(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tq() {
        this.abW.setText(this.ach);
        this.yA.setGravity(this.mGravity, this.up, this.uq);
        this.yA.setDuration(this.mDuration);
        this.yA.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cr(i).to();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cp(i).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cp(i).cr(i2).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cp(ack.get(defaultIcon).intValue()).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cp(ack.get(defaultIcon).intValue()).cr(i).to();
    }
}
