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
    private static SoftReference<Toast> abn;
    private static HashMap<DefaultIcon, Integer> abt = new HashMap<>(2);
    private final ViewGroup aaE;
    private final TextView abi;
    private final ImageView abo;
    private CharSequence abp;
    private final Context mContext;
    private Toast yC;
    private int abq = -1;
    private int mGravity = 16;
    private int HV = 0;
    private int ur = 0;
    private int us = 0;
    private int abr = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        abt.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        abt.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        abt.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aaE = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.abo = (ImageView) this.aaE.findViewById(d.h.toast_icon);
        this.abi = (TextView) this.aaE.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.abp = charSequence;
        this.abi.setText(this.abp);
        return this;
    }

    public void cm(int i) {
        this.abr = i;
    }

    public BdToast cn(int i) {
        this.abq = i;
        return this;
    }

    public BdToast co(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cp(int i) {
        this.HV = i;
        return this;
    }

    public void cq(int i) {
        this.us = i;
    }

    public void F(float f) {
        this.abi.setLineSpacing(0.0f, f);
    }

    public BdToast th() {
        this.yC = new Toast(this.mContext);
        ti();
        if (this.abq != -1) {
            aj.c(this.abo, this.abq);
            this.abo.setVisibility(0);
        } else {
            this.abo.setVisibility(8);
        }
        aj.c(this.abi, d.e.cp_cont_g, 1);
        this.abi.setText(this.abp);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.HV);
        cr(this.abr);
        this.yC.setView(this.aaE);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.ur = i2;
        this.us = i3;
        return th();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void ti() {
        if (abn != null && abn.get() != null) {
            abn.get().cancel();
        }
        abn = new SoftReference<>(this.yC);
    }

    private void cr(int i) {
        if (i > 0) {
            this.aaE.setPadding(i, this.aaE.getTop(), i, this.aaE.getBottom());
        }
    }

    public BdToast tj() {
        this.abi.setText(this.abp);
        this.yC.setGravity(this.mGravity, this.ur, this.us);
        this.yC.setDuration(this.HV);
        this.yC.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cp(i).th();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cn(i).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cn(i).cp(i2).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cn(abt.get(defaultIcon).intValue()).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cn(abt.get(defaultIcon).intValue()).cp(i).th();
    }
}
