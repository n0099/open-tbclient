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
    private static SoftReference<Toast> acc;
    private static HashMap<DefaultIcon, Integer> ach = new HashMap<>(2);
    private final TextView abT;
    private final ImageView acd;
    private CharSequence ace;
    private final Context mContext;
    private final ViewGroup mRootView;
    private Toast yz;
    private int acf = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int uo = 0;
    private int up = 0;
    private int acg = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        ach.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        ach.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        ach.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.acd = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.abT = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.ace = charSequence;
        this.abT.setText(this.ace);
        return this;
    }

    public void co(int i) {
        this.acg = i;
    }

    public BdToast cp(int i) {
        this.acf = i;
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
        this.up = i;
    }

    public void E(float f) {
        this.abT.setLineSpacing(0.0f, f);
    }

    public BdToast to() {
        this.yz = new Toast(this.mContext);
        tp();
        if (this.acf != -1) {
            aj.c(this.acd, this.acf);
            this.acd.setVisibility(0);
        } else {
            this.acd.setVisibility(8);
        }
        aj.c(this.abT, d.C0096d.cp_cont_g, 1);
        this.abT.setText(this.ace);
        this.yz.setGravity(this.mGravity, this.uo, this.up);
        this.yz.setDuration(this.mDuration);
        cs(this.acg);
        this.yz.setView(this.mRootView);
        return this;
    }

    private BdToast k(int i, int i2, int i3) {
        this.mGravity = i;
        this.uo = i2;
        this.up = i3;
        return to();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).k(i, i2, i3);
    }

    private void tp() {
        if (acc != null && acc.get() != null) {
            acc.get().cancel();
        }
        acc = new SoftReference<>(this.yz);
    }

    private void cs(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tq() {
        this.abT.setText(this.ace);
        this.yz.setGravity(this.mGravity, this.uo, this.up);
        this.yz.setDuration(this.mDuration);
        this.yz.show();
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
        return new BdToast(context).b(charSequence).cp(ach.get(defaultIcon).intValue()).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cp(ach.get(defaultIcon).intValue()).cr(i).to();
    }
}
