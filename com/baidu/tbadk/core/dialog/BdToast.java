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
    private static SoftReference<Toast> anO;
    private static HashMap<DefaultIcon, Integer> anP = new HashMap<>(2);
    private Toast FI;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int Bs = 0;
    private int Bt = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        anP.put(DefaultIcon.SUCCESS, Integer.valueOf(e.f.icon_unite_pass));
        anP.put(DefaultIcon.FAILURE, Integer.valueOf(e.f.icon_unite_lose));
        anP.put(DefaultIcon.NOT, 0);
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

    public void cz(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast cA(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast cB(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cC(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.Bt = i;
    }

    public void Y(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast yr() {
        this.FI = new Toast(this.mContext);
        ys();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, e.d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.FI.setGravity(this.mGravity, this.Bs, this.Bt);
        this.FI.setDuration(this.mDuration);
        cD(this.paddingHorizontal);
        this.FI.setView(this.mRootView);
        return this;
    }

    private void ys() {
        if (anO != null && anO.get() != null) {
            anO.get().cancel();
        }
        anO = new SoftReference<>(this.FI);
    }

    private void cD(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast yt() {
        this.mTextView.setText(this.mText);
        this.FI.setGravity(this.mGravity, this.Bs, this.Bt);
        this.FI.setDuration(this.mDuration);
        this.FI.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).d(charSequence).yr();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cC(i).yr();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cA(i).yr();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).d(charSequence).cA(i).cC(i2).yr();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).d(charSequence).cA(anP.get(defaultIcon).intValue()).yr();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).d(charSequence).cA(anP.get(defaultIcon).intValue()).cC(i).yr();
    }
}
