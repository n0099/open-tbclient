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
    private static SoftReference<Toast> bFf;
    private static HashMap<DefaultIcon, Integer> bFg = new HashMap<>(2);
    private Toast Gu;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int Cd = 0;
    private int Ce = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        bFg.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        bFg.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        bFg.put(DefaultIcon.NOT, 0);
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

    public void gM(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast gN(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast gO(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast gP(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.Ce = i;
    }

    public void ak(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast abf() {
        this.Gu = new Toast(this.mContext);
        abg();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.d(this.mTextView, d.C0236d.cp_btn_a, 1);
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cd, this.Ce);
        this.Gu.setDuration(this.mDuration);
        gR(this.paddingHorizontal);
        this.Gu.setView(this.mRootView);
        return this;
    }

    public BdToast gQ(int i) {
        this.Gu = new Toast(this.mContext);
        abg();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, d.C0236d.cp_btn_a, 1, i);
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cd, this.Ce);
        this.Gu.setDuration(this.mDuration);
        gR(this.paddingHorizontal);
        this.Gu.setView(this.mRootView);
        return this;
    }

    private void abg() {
        if (bFf != null && bFf.get() != null) {
            bFf.get().cancel();
        }
        bFf = new SoftReference<>(this.Gu);
    }

    private void gR(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast abh() {
        this.mTextView.setText(this.mText);
        this.Gu.setGravity(this.mGravity, this.Cd, this.Ce);
        this.Gu.setDuration(this.mDuration);
        this.Gu.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).abf();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).gP(i).abf();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).gP(i).gQ(i2);
    }

    public static BdToast c(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).gN(i).abf();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).gN(i).gP(i2).abf();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).gN(bFg.get(defaultIcon).intValue()).abf();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).gN(bFg.get(defaultIcon).intValue()).gP(i).abf();
    }
}
