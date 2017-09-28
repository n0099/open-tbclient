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
    private static SoftReference<Toast> abA;
    private static HashMap<DefaultIcon, Integer> abF = new HashMap<>(2);
    private final ViewGroup aaQ;
    private final ImageView abB;
    private CharSequence abC;
    private final TextView abv;
    private final Context mContext;
    private Toast yB;
    private int abD = -1;
    private int mGravity = 16;
    private int HU = 0;
    private int uq = 0;
    private int ur = 0;
    private int abE = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        abF.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        abF.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        abF.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aaQ = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.abB = (ImageView) this.aaQ.findViewById(d.h.toast_icon);
        this.abv = (TextView) this.aaQ.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.abC = charSequence;
        this.abv.setText(this.abC);
        return this;
    }

    public void cn(int i) {
        this.abE = i;
    }

    public BdToast co(int i) {
        this.abD = i;
        return this;
    }

    public BdToast cp(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cq(int i) {
        this.HU = i;
        return this;
    }

    public void cr(int i) {
        this.ur = i;
    }

    public void F(float f) {
        this.abv.setLineSpacing(0.0f, f);
    }

    public BdToast to() {
        this.yB = new Toast(this.mContext);
        tp();
        if (this.abD != -1) {
            aj.c(this.abB, this.abD);
            this.abB.setVisibility(0);
        } else {
            this.abB.setVisibility(8);
        }
        aj.c(this.abv, d.e.cp_cont_g, 1);
        this.abv.setText(this.abC);
        this.yB.setGravity(this.mGravity, this.uq, this.ur);
        this.yB.setDuration(this.HU);
        cs(this.abE);
        this.yB.setView(this.aaQ);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uq = i2;
        this.ur = i3;
        return to();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tp() {
        if (abA != null && abA.get() != null) {
            abA.get().cancel();
        }
        abA = new SoftReference<>(this.yB);
    }

    private void cs(int i) {
        if (i > 0) {
            this.aaQ.setPadding(i, this.aaQ.getTop(), i, this.aaQ.getBottom());
        }
    }

    public BdToast tq() {
        this.abv.setText(this.abC);
        this.yB.setGravity(this.mGravity, this.uq, this.ur);
        this.yB.setDuration(this.HU);
        this.yB.show();
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
        return new BdToast(context).b(charSequence).co(abF.get(defaultIcon).intValue()).to();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).co(abF.get(defaultIcon).intValue()).cq(i).to();
    }
}
