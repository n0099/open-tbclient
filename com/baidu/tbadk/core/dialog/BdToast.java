package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> adk;
    private static HashMap<DefaultIcon, Integer> adm = new HashMap<>(2);
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private Toast xk;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int sU = 0;
    private int sV = 0;
    private int adl = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        adm.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        adm.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        adm.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.i.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast h(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void ck(int i) {
        this.adl = i;
    }

    public BdToast cl(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast cm(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cn(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.sV = i;
    }

    public void O(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tJ() {
        this.xk = new Toast(this.mContext);
        tK();
        if (this.mIconResId != -1) {
            ak.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        ak.c(this.mTextView, d.C0126d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.xk.setGravity(this.mGravity, this.sU, this.sV);
        this.xk.setDuration(this.mDuration);
        co(this.adl);
        this.xk.setView(this.mRootView);
        return this;
    }

    private void tK() {
        if (adk != null && adk.get() != null) {
            adk.get().cancel();
        }
        adk = new SoftReference<>(this.xk);
    }

    private void co(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tL() {
        this.mTextView.setText(this.mText);
        this.xk.setGravity(this.mGravity, this.sU, this.sV);
        this.xk.setDuration(this.mDuration);
        this.xk.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).tJ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).cn(i).tJ();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).cl(i).tJ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).cl(i).cn(i2).tJ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).cl(adm.get(defaultIcon).intValue()).tJ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).cl(adm.get(defaultIcon).intValue()).cn(i).tJ();
    }
}
