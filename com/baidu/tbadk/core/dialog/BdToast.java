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
    private static SoftReference<Toast> aQv;
    private static HashMap<DefaultIcon, Integer> aQx = new HashMap<>(2);
    private Toast amL;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView rz;
    private int Hz = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int aiC = 0;
    private int aiD = 0;
    private int aQw = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        aQx.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        aQx.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        aQx.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.rz = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast p(CharSequence charSequence) {
        this.mText = charSequence;
        this.rz.setText(this.mText);
        return this;
    }

    public void fn(int i) {
        this.aQw = i;
    }

    public BdToast fo(int i) {
        this.Hz = i;
        return this;
    }

    public BdToast fp(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast fq(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.aiD = i;
    }

    public void U(float f) {
        this.rz.setLineSpacing(0.0f, f);
    }

    public BdToast AO() {
        this.amL = new Toast(this.mContext);
        AP();
        if (this.Hz != -1) {
            aj.c(this.mIconView, this.Hz);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        aj.e(this.rz, d.C0108d.cp_cont_g, 1);
        this.rz.setText(this.mText);
        this.amL.setGravity(this.mGravity, this.aiC, this.aiD);
        this.amL.setDuration(this.mDuration);
        fr(this.aQw);
        this.amL.setView(this.mRootView);
        return this;
    }

    private BdToast t(int i, int i2, int i3) {
        this.mGravity = i;
        this.aiC = i2;
        this.aiD = i3;
        return AO();
    }

    public static BdToast b(Context context, int i, int i2, int i3) {
        return new BdToast(context).t(i, i2, i3);
    }

    private void AP() {
        if (aQv != null && aQv.get() != null) {
            aQv.get().cancel();
        }
        aQv = new SoftReference<>(this.amL);
    }

    private void fr(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast AQ() {
        this.rz.setText(this.mText);
        this.amL.setGravity(this.mGravity, this.aiC, this.aiD);
        this.amL.setDuration(this.mDuration);
        this.amL.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).p(charSequence).AO();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fq(i).AO();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fo(i).AO();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).p(charSequence).fo(i).fq(i2).AO();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).p(charSequence).fo(aQx.get(defaultIcon).intValue()).AO();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).p(charSequence).fo(aQx.get(defaultIcon).intValue()).fq(i).AO();
    }
}
