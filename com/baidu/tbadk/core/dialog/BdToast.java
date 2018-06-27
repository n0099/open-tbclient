package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> alK;
    private static HashMap<DefaultIcon, Integer> alL = new HashMap<>(2);
    private Toast Ds;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int zb = 0;
    private int zc = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        alL.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        alL.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        alL.put(DefaultIcon.NOT, 0);
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

    public void cn(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast co(int i) {
        this.mIconResId = i;
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

    public void setOffsetY(int i) {
        this.zc = i;
    }

    public void Y(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast xt() {
        this.Ds = new Toast(this.mContext);
        xu();
        if (this.mIconResId != -1) {
            am.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        am.c(this.mTextView, d.C0142d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Ds.setGravity(this.mGravity, this.zb, this.zc);
        this.Ds.setDuration(this.mDuration);
        cr(this.paddingHorizontal);
        this.Ds.setView(this.mRootView);
        return this;
    }

    private void xu() {
        if (alK != null && alK.get() != null) {
            alK.get().cancel();
        }
        alK = new SoftReference<>(this.Ds);
    }

    private void cr(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast xv() {
        this.mTextView.setText(this.mText);
        this.Ds.setGravity(this.mGravity, this.zb, this.zc);
        this.Ds.setDuration(this.mDuration);
        this.Ds.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).xt();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).cq(i).xt();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).co(i).xt();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).co(i).cq(i2).xt();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).co(alL.get(defaultIcon).intValue()).xt();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).co(alL.get(defaultIcon).intValue()).cq(i).xt();
    }
}
