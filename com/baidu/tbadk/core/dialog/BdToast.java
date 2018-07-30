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
    private static SoftReference<Toast> alj;
    private static HashMap<DefaultIcon, Integer> alk = new HashMap<>(2);
    private Toast Do;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int yW = 0;
    private int yX = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        alk.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        alk.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        alk.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(d.g.toast_message);
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
        this.yX = i;
    }

    public void Y(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast xl() {
        this.Do = new Toast(this.mContext);
        xm();
        if (this.mIconResId != -1) {
            am.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        am.c(this.mTextView, d.C0140d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Do.setGravity(this.mGravity, this.yW, this.yX);
        this.Do.setDuration(this.mDuration);
        ct(this.paddingHorizontal);
        this.Do.setView(this.mRootView);
        return this;
    }

    private void xm() {
        if (alj != null && alj.get() != null) {
            alj.get().cancel();
        }
        alj = new SoftReference<>(this.Do);
    }

    private void ct(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast xn() {
        this.mTextView.setText(this.mText);
        this.Do.setGravity(this.mGravity, this.yW, this.yX);
        this.Do.setDuration(this.mDuration);
        this.Do.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).d(charSequence).xl();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cs(i).xl();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cq(i).xl();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).d(charSequence).cq(i).cs(i2).xl();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).d(charSequence).cq(alk.get(defaultIcon).intValue()).xl();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).d(charSequence).cq(alk.get(defaultIcon).intValue()).cs(i).xl();
    }
}
