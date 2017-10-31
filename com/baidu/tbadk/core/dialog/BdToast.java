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
    private static SoftReference<Toast> abN;
    private static HashMap<DefaultIcon, Integer> abS = new HashMap<>(2);
    private final TextView abE;
    private final ImageView abO;
    private CharSequence abP;
    private final Context mContext;
    private final ViewGroup mRootView;
    private Toast yC;
    private int abQ = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int ur = 0;
    private int us = 0;
    private int abR = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        abS.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        abS.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        abS.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.abO = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.abE = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.abP = charSequence;
        this.abE.setText(this.abP);
        return this;
    }

    public void cn(int i) {
        this.abR = i;
    }

    public BdToast co(int i) {
        this.abQ = i;
        return this;
    }

    public BdToast cp(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cq(int i) {
        this.mDuration = i;
        return this;
    }

    public void cr(int i) {
        this.us = i;
    }

    public void E(float f) {
        this.abE.setLineSpacing(0.0f, f);
    }

    public BdToast to() {
        this.yC = new Toast(this.mContext);
        tp();
        if (this.abQ != -1) {
            aj.c(this.abO, this.abQ);
            this.abO.setVisibility(0);
        } else {
            this.abO.setVisibility(8);
        }
        aj.c(this.abE, d.C0080d.cp_cont_g, 1);
        this.abE.setText(this.abP);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.mDuration);
        cs(this.abR);
        this.yC.setView(this.mRootView);
        return this;
    }

    private BdToast k(int i, int i2, int i3) {
        this.mGravity = i;
        this.ur = i2;
        this.us = i3;
        return to();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).k(i, i2, i3);
    }

    private void tp() {
        if (abN != null && abN.get() != null) {
            abN.get().cancel();
        }
        abN = new SoftReference<>(this.yC);
    }

    private void cs(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tq() {
        this.abE.setText(this.abP);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.mDuration);
        this.yC.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cq(i).to();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).co(i).cq(i2).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).co(abS.get(defaultIcon).intValue()).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).co(abS.get(defaultIcon).intValue()).cq(i).to();
    }
}
