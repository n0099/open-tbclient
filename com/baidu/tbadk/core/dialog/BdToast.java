package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> awW;
    private static HashMap<DefaultIcon, Integer> awX = new HashMap<>(2);
    private Toast Gv;
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
        awX.put(DefaultIcon.SUCCESS, Integer.valueOf(e.f.icon_unite_pass));
        awX.put(DefaultIcon.FAILURE, Integer.valueOf(e.f.icon_unite_lose));
        awX.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(e.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(e.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(e.g.toast_message);
    }

    public BdToast d(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void dl(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast dm(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast dn(int i) {
        this.mGravity = i;
        return this;
    }

    /* renamed from: do  reason: not valid java name */
    public BdToast m16do(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.Ce = i;
    }

    public void Z(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast BL() {
        this.Gv = new Toast(this.mContext);
        BM();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, e.d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Gv.setGravity(this.mGravity, this.Cd, this.Ce);
        this.Gv.setDuration(this.mDuration);
        dp(this.paddingHorizontal);
        this.Gv.setView(this.mRootView);
        return this;
    }

    private void BM() {
        if (awW != null && awW.get() != null) {
            awW.get().cancel();
        }
        awW = new SoftReference<>(this.Gv);
    }

    private void dp(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast BN() {
        this.mTextView.setText(this.mText);
        this.Gv.setGravity(this.mGravity, this.Cd, this.Ce);
        this.Gv.setDuration(this.mDuration);
        this.Gv.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).d(charSequence).BL();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).m16do(i).BL();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).dm(i).BL();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).d(charSequence).dm(i).m16do(i2).BL();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).d(charSequence).dm(awX.get(defaultIcon).intValue()).BL();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).d(charSequence).dm(awX.get(defaultIcon).intValue()).m16do(i).BL();
    }
}
