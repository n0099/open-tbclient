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
    private static SoftReference<Toast> aRL;
    private static HashMap<DefaultIcon, Integer> aRN = new HashMap<>(2);
    private Toast amH;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView ry;
    private int Ht = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int aiy = 0;
    private int aiz = 0;
    private int aRM = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        aRN.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        aRN.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        aRN.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.h.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.ry = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast p(CharSequence charSequence) {
        this.mText = charSequence;
        this.ry.setText(this.mText);
        return this;
    }

    public void fl(int i) {
        this.aRM = i;
    }

    public BdToast fm(int i) {
        this.Ht = i;
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
        this.aiz = i;
    }

    public void aa(float f) {
        this.ry.setLineSpacing(0.0f, f);
    }

    public BdToast Ba() {
        this.amH = new Toast(this.mContext);
        Bb();
        if (this.Ht != -1) {
            aj.c(this.mIconView, this.Ht);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        aj.e(this.ry, d.C0141d.cp_cont_g, 1);
        this.ry.setText(this.mText);
        this.amH.setGravity(this.mGravity, this.aiy, this.aiz);
        this.amH.setDuration(this.mDuration);
        fp(this.aRM);
        this.amH.setView(this.mRootView);
        return this;
    }

    private BdToast t(int i, int i2, int i3) {
        this.mGravity = i;
        this.aiy = i2;
        this.aiz = i3;
        return Ba();
    }

    public static BdToast b(Context context, int i, int i2, int i3) {
        return new BdToast(context).t(i, i2, i3);
    }

    private void Bb() {
        if (aRL != null && aRL.get() != null) {
            aRL.get().cancel();
        }
        aRL = new SoftReference<>(this.amH);
    }

    private void fp(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast Bc() {
        this.ry.setText(this.mText);
        this.amH.setGravity(this.mGravity, this.aiy, this.aiz);
        this.amH.setDuration(this.mDuration);
        this.amH.show();
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
        return new BdToast(context).p(charSequence).fm(aRN.get(defaultIcon).intValue()).Ba();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).p(charSequence).fm(aRN.get(defaultIcon).intValue()).fo(i).Ba();
    }
}
