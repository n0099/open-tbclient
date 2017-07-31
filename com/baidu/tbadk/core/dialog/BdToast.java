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
    private static SoftReference<Toast> acq;
    private static HashMap<DefaultIcon, Integer> acv = new HashMap<>(2);
    private Toast AE;
    private final ViewGroup abK;
    private final ImageView acr;
    private CharSequence acs;
    private final Context mContext;
    private final TextView mTextView;
    private int act = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int ww = 0;
    private int wx = 0;
    private int acu = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        acv.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        acv.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        acv.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.abK = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.acr = (ImageView) this.abK.findViewById(d.h.toast_icon);
        this.mTextView = (TextView) this.abK.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.acs = charSequence;
        this.mTextView.setText(this.acs);
        return this;
    }

    public void cn(int i) {
        this.acu = i;
    }

    public BdToast co(int i) {
        this.act = i;
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
        this.wx = i;
    }

    public void P(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tx() {
        this.AE = new Toast(this.mContext);
        ty();
        if (this.act != -1) {
            ai.c(this.acr, this.act);
            this.acr.setVisibility(0);
        } else {
            this.acr.setVisibility(8);
        }
        ai.c(this.mTextView, d.e.cp_cont_g, 1);
        this.mTextView.setText(this.acs);
        this.AE.setGravity(this.mGravity, this.ww, this.wx);
        this.AE.setDuration(this.mDuration);
        cs(this.acu);
        this.AE.setView(this.abK);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.ww = i2;
        this.wx = i3;
        return tx();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void ty() {
        if (acq != null && acq.get() != null) {
            acq.get().cancel();
        }
        acq = new SoftReference<>(this.AE);
    }

    private void cs(int i) {
        if (i > 0) {
            this.abK.setPadding(i, this.abK.getTop(), i, this.abK.getBottom());
        }
    }

    public BdToast tz() {
        this.mTextView.setText(this.acs);
        this.AE.setGravity(this.mGravity, this.ww, this.wx);
        this.AE.setDuration(this.mDuration);
        this.AE.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cq(i).tx();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).co(i).cq(i2).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).co(acv.get(defaultIcon).intValue()).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).co(acv.get(defaultIcon).intValue()).cq(i).tx();
    }
}
