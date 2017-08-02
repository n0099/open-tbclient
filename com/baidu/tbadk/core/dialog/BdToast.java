package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aaT;
    private static HashMap<DefaultIcon, Integer> aaY = new HashMap<>(2);
    private final ImageView aaU;
    private CharSequence aaV;
    private final ViewGroup aan;
    private final Context mContext;
    private final TextView mTextView;
    private Toast zd;
    private int aaW = -1;
    private int mGravity = 16;
    private int Ii = 0;
    private int uT = 0;
    private int uU = 0;
    private int aaX = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        aaY.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        aaY.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        aaY.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aan = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.aaU = (ImageView) this.aan.findViewById(d.h.toast_icon);
        this.mTextView = (TextView) this.aan.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.aaV = charSequence;
        this.mTextView.setText(this.aaV);
        return this;
    }

    public void cl(int i) {
        this.aaX = i;
    }

    public BdToast cm(int i) {
        this.aaW = i;
        return this;
    }

    public BdToast cn(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast co(int i) {
        this.Ii = i;
        return this;
    }

    public void cp(int i) {
        this.uU = i;
    }

    public void P(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tn() {
        this.zd = new Toast(this.mContext);
        to();
        if (this.aaW != -1) {
            ai.c(this.aaU, this.aaW);
            this.aaU.setVisibility(0);
        } else {
            this.aaU.setVisibility(8);
        }
        ai.c(this.mTextView, d.e.cp_cont_g, 1);
        this.mTextView.setText(this.aaV);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Ii);
        cq(this.aaX);
        this.zd.setView(this.aan);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uT = i2;
        this.uU = i3;
        return tn();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void to() {
        if (aaT != null && aaT.get() != null) {
            aaT.get().cancel();
        }
        aaT = new SoftReference<>(this.zd);
    }

    private void cq(int i) {
        if (i > 0) {
            this.aan.setPadding(i, this.aan.getTop(), i, this.aan.getBottom());
        }
    }

    public BdToast tp() {
        this.mTextView.setText(this.aaV);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Ii);
        this.zd.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tn();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).tn();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).tn();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cm(i).co(i2).tn();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cm(aaY.get(defaultIcon).intValue()).tn();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cm(aaY.get(defaultIcon).intValue()).co(i).tn();
    }
}
