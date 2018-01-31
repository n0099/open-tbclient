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
    private static SoftReference<Toast> aQx;
    private static HashMap<DefaultIcon, Integer> aQz = new HashMap<>(2);
    private Toast amO;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView rz;
    private int Hz = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int aiF = 0;
    private int aiG = 0;
    private int aQy = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        aQz.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        aQz.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        aQz.put(DefaultIcon.NOT, 0);
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

    public void fl(int i) {
        this.aQy = i;
    }

    public BdToast fm(int i) {
        this.Hz = i;
        return this;
    }

    public BdToast fn(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast fo(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.aiG = i;
    }

    public void U(float f) {
        this.rz.setLineSpacing(0.0f, f);
    }

    public BdToast AH() {
        this.amO = new Toast(this.mContext);
        AI();
        if (this.Hz != -1) {
            aj.c(this.mIconView, this.Hz);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        aj.e(this.rz, d.C0108d.cp_cont_g, 1);
        this.rz.setText(this.mText);
        this.amO.setGravity(this.mGravity, this.aiF, this.aiG);
        this.amO.setDuration(this.mDuration);
        fp(this.aQy);
        this.amO.setView(this.mRootView);
        return this;
    }

    private BdToast t(int i, int i2, int i3) {
        this.mGravity = i;
        this.aiF = i2;
        this.aiG = i3;
        return AH();
    }

    public static BdToast b(Context context, int i, int i2, int i3) {
        return new BdToast(context).t(i, i2, i3);
    }

    private void AI() {
        if (aQx != null && aQx.get() != null) {
            aQx.get().cancel();
        }
        aQx = new SoftReference<>(this.amO);
    }

    private void fp(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast AJ() {
        this.rz.setText(this.mText);
        this.amO.setGravity(this.mGravity, this.aiF, this.aiG);
        this.amO.setDuration(this.mDuration);
        this.amO.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).p(charSequence).AH();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fo(i).AH();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fm(i).AH();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).p(charSequence).fm(i).fo(i2).AH();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).p(charSequence).fm(aQz.get(defaultIcon).intValue()).AH();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).p(charSequence).fm(aQz.get(defaultIcon).intValue()).fo(i).AH();
    }
}
