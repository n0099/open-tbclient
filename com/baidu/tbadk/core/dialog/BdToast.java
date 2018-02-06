package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aRW;
    private static HashMap<DefaultIcon, Integer> aRY = new HashMap<>(2);
    private Toast amN;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView rz;
    private int Hy = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int aiE = 0;
    private int aiF = 0;
    private int aRX = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        aRY.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        aRY.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        aRY.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.rz = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast p(CharSequence charSequence) {
        this.mText = charSequence;
        this.rz.setText(this.mText);
        return this;
    }

    public void fl(int i) {
        this.aRX = i;
    }

    public BdToast fm(int i) {
        this.Hy = i;
        return this;
    }

    public BdToast fn(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast fo(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.aiF = i;
    }

    public void aa(float f) {
        this.rz.setLineSpacing(0.0f, f);
    }

    public BdToast Ba() {
        this.amN = new Toast(this.mContext);
        Bb();
        if (this.Hy != -1) {
            aj.c(this.mIconView, this.Hy);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        aj.e(this.rz, d.C0140d.cp_cont_g, 1);
        this.rz.setText(this.mText);
        this.amN.setGravity(this.mGravity, this.aiE, this.aiF);
        this.amN.setDuration(this.mDuration);
        fp(this.aRX);
        this.amN.setView(this.mRootView);
        return this;
    }

    private BdToast t(int i, int i2, int i3) {
        this.mGravity = i;
        this.aiE = i2;
        this.aiF = i3;
        return Ba();
    }

    public static BdToast b(Context context, int i, int i2, int i3) {
        return new BdToast(context).t(i, i2, i3);
    }

    private void Bb() {
        if (aRW != null && aRW.get() != null) {
            aRW.get().cancel();
        }
        aRW = new SoftReference<>(this.amN);
    }

    private void fp(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast Bc() {
        this.rz.setText(this.mText);
        this.amN.setGravity(this.mGravity, this.aiE, this.aiF);
        this.amN.setDuration(this.mDuration);
        this.amN.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).p(charSequence).Ba();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fo(i).Ba();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).p(charSequence).fm(i).Ba();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).p(charSequence).fm(i).fo(i2).Ba();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).p(charSequence).fm(aRY.get(defaultIcon).intValue()).Ba();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).p(charSequence).fm(aRY.get(defaultIcon).intValue()).fo(i).Ba();
    }
}
