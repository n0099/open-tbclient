package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> bFk;
    private static HashMap<DefaultIcon, Integer> bFl = new HashMap<>(2);
    private Toast Gu;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int Cc = 0;
    private int Cd = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        bFl.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        bFl.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        bFl.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast h(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void gL(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast gM(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast gN(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast gO(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.Cd = i;
    }

    public void ak(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast abc() {
        this.Gu = new Toast(this.mContext);
        abd();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.d(this.mTextView, d.C0277d.cp_btn_a, 1);
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cc, this.Cd);
        this.Gu.setDuration(this.mDuration);
        gQ(this.paddingHorizontal);
        this.Gu.setView(this.mRootView);
        return this;
    }

    public BdToast gP(int i) {
        this.Gu = new Toast(this.mContext);
        abd();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, d.C0277d.cp_btn_a, 1, i);
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cc, this.Cd);
        this.Gu.setDuration(this.mDuration);
        gQ(this.paddingHorizontal);
        this.Gu.setView(this.mRootView);
        return this;
    }

    private void abd() {
        if (bFk != null && bFk.get() != null) {
            bFk.get().cancel();
        }
        bFk = new SoftReference<>(this.Gu);
    }

    private void gQ(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast abe() {
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cc, this.Cd);
        this.Gu.setDuration(this.mDuration);
        this.Gu.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).abc();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).gO(i).abc();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).gO(i).gP(i2);
    }

    public static BdToast c(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).gM(i).abc();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).gM(i).gO(i2).abc();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).gM(bFl.get(defaultIcon).intValue()).abc();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).gM(bFl.get(defaultIcon).intValue()).gO(i).abc();
    }
}
