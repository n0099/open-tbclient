package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> bMD;
    private static HashMap<DefaultIcon, Integer> bME = new HashMap<>(2);
    private Toast Ef;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int zK = 0;
    private int zL = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        bME.put(DefaultIcon.SUCCESS, Integer.valueOf((int) R.drawable.icon_unite_pass));
        bME.put(DefaultIcon.FAILURE, Integer.valueOf((int) R.drawable.icon_unite_lose));
        bME.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(R.id.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.toast_message);
    }

    public BdToast h(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void hy(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast hz(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast hA(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast hB(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.zL = i;
    }

    public void am(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast afM() {
        this.Ef = new Toast(this.mContext);
        afN();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.f(this.mTextView, R.color.cp_btn_a, 1);
        this.mTextView.setText(this.mText);
        this.Ef.setGravity(this.mGravity, this.zK, this.zL);
        this.Ef.setDuration(this.mDuration);
        hD(this.paddingHorizontal);
        this.Ef.setView(this.mRootView);
        return this;
    }

    public BdToast hC(int i) {
        this.Ef = new Toast(this.mContext);
        afN();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, R.color.cp_btn_a, 1, i);
        this.mTextView.setText(this.mText);
        this.Ef.setGravity(this.mGravity, this.zK, this.zL);
        this.Ef.setDuration(this.mDuration);
        hD(this.paddingHorizontal);
        this.Ef.setView(this.mRootView);
        return this;
    }

    private void afN() {
        if (bMD != null && bMD.get() != null) {
            bMD.get().cancel();
        }
        bMD = new SoftReference<>(this.Ef);
    }

    private void hD(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast afO() {
        this.mTextView.setText(this.mText);
        this.Ef.setGravity(this.mGravity, this.zK, this.zL);
        this.Ef.setDuration(this.mDuration);
        this.Ef.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).afM();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).hB(i).afM();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).hB(i).hC(i2);
    }

    public static BdToast c(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).hz(i).afM();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).hz(i).hB(i2).afM();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).hz(bME.get(defaultIcon).intValue()).afM();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).hz(bME.get(defaultIcon).intValue()).hB(i).afM();
    }
}
