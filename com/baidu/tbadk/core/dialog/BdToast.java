package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> ali;
    private static HashMap<DefaultIcon, Integer> alj = new HashMap<>(2);
    private Toast Do;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int yX = 0;
    private int yY = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        alj.put(DefaultIcon.SUCCESS, Integer.valueOf(f.C0146f.icon_unite_pass));
        alj.put(DefaultIcon.FAILURE, Integer.valueOf(f.C0146f.icon_unite_lose));
        alj.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(f.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(f.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(f.g.toast_message);
    }

    public BdToast d(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void cp(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast cq(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast cr(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cs(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.yY = i;
    }

    public void Y(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast xk() {
        this.Do = new Toast(this.mContext);
        xl();
        if (this.mIconResId != -1) {
            am.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        am.c(this.mTextView, f.d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Do.setGravity(this.mGravity, this.yX, this.yY);
        this.Do.setDuration(this.mDuration);
        ct(this.paddingHorizontal);
        this.Do.setView(this.mRootView);
        return this;
    }

    private void xl() {
        if (ali != null && ali.get() != null) {
            ali.get().cancel();
        }
        ali = new SoftReference<>(this.Do);
    }

    private void ct(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast xm() {
        this.mTextView.setText(this.mText);
        this.Do.setGravity(this.mGravity, this.yX, this.yY);
        this.Do.setDuration(this.mDuration);
        this.Do.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).d(charSequence).xk();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cs(i).xk();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cq(i).xk();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).d(charSequence).cq(i).cs(i2).xk();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).d(charSequence).cq(alj.get(defaultIcon).intValue()).xk();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).d(charSequence).cq(alj.get(defaultIcon).intValue()).cs(i).xk();
    }
}
