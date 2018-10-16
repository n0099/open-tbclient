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
    private static SoftReference<Toast> asI;
    private static HashMap<DefaultIcon, Integer> asJ = new HashMap<>(2);
    private Toast Gr;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int Ca = 0;
    private int Cb = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        asJ.put(DefaultIcon.SUCCESS, Integer.valueOf(e.f.icon_unite_pass));
        asJ.put(DefaultIcon.FAILURE, Integer.valueOf(e.f.icon_unite_lose));
        asJ.put(DefaultIcon.NOT, 0);
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

    public void cJ(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast cK(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast cL(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cM(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.Cb = i;
    }

    public void Z(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast AA() {
        this.Gr = new Toast(this.mContext);
        AB();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, e.d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Gr.setGravity(this.mGravity, this.Ca, this.Cb);
        this.Gr.setDuration(this.mDuration);
        cN(this.paddingHorizontal);
        this.Gr.setView(this.mRootView);
        return this;
    }

    private void AB() {
        if (asI != null && asI.get() != null) {
            asI.get().cancel();
        }
        asI = new SoftReference<>(this.Gr);
    }

    private void cN(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast AC() {
        this.mTextView.setText(this.mText);
        this.Gr.setGravity(this.mGravity, this.Ca, this.Cb);
        this.Gr.setDuration(this.mDuration);
        this.Gr.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).d(charSequence).AA();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cM(i).AA();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).d(charSequence).cK(i).AA();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).d(charSequence).cK(i).cM(i2).AA();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).d(charSequence).cK(asJ.get(defaultIcon).intValue()).AA();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).d(charSequence).cK(asJ.get(defaultIcon).intValue()).cM(i).AA();
    }
}
