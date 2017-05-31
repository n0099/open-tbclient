package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aat;
    private static HashMap<DefaultIcon, Integer> aay = new HashMap<>(2);
    private final ViewGroup ZN;
    private final ImageView aau;
    private CharSequence aav;
    private final Context mContext;
    private final TextView mTextView;
    private Toast zd;
    private int aaw = -1;
    private int mGravity = 16;
    private int Ij = 0;
    private int uT = 0;
    private int uU = 0;
    private int aax = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (aaz) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DefaultIcon[] valuesCustom() {
            DefaultIcon[] valuesCustom = values();
            int length = valuesCustom.length;
            DefaultIcon[] defaultIconArr = new DefaultIcon[length];
            System.arraycopy(valuesCustom, 0, defaultIconArr, 0, length);
            return defaultIconArr;
        }
    }

    static {
        aay.put(DefaultIcon.SUCCESS, Integer.valueOf(w.g.icon_unite_pass));
        aay.put(DefaultIcon.FAILURE, Integer.valueOf(w.g.icon_unite_lose));
        aay.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.ZN = (ViewGroup) LayoutInflater.from(context).inflate(w.j.dialog_bdtoast, (ViewGroup) null);
        this.aau = (ImageView) this.ZN.findViewById(w.h.toast_icon);
        this.mTextView = (TextView) this.ZN.findViewById(w.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.aav = charSequence;
        this.mTextView.setText(this.aav);
        return this;
    }

    public void cj(int i) {
        this.aax = i;
    }

    public BdToast ck(int i) {
        this.aaw = i;
        return this;
    }

    public BdToast cl(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cm(int i) {
        this.Ij = i;
        return this;
    }

    public void cn(int i) {
        this.uU = i;
    }

    public void P(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast ti() {
        this.zd = new Toast(this.mContext);
        tj();
        if (this.aaw != -1) {
            aq.c(this.aau, this.aaw);
            this.aau.setVisibility(0);
        } else {
            this.aau.setVisibility(8);
        }
        aq.c(this.mTextView, w.e.cp_cont_g, 1);
        this.mTextView.setText(this.aav);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Ij);
        co(this.aax);
        this.zd.setView(this.ZN);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uT = i2;
        this.uU = i3;
        return ti();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tj() {
        if (aat != null && aat.get() != null) {
            aat.get().cancel();
        }
        aat = new SoftReference<>(this.zd);
    }

    private void co(int i) {
        if (i > 0) {
            this.ZN.setPadding(i, this.ZN.getTop(), i, this.ZN.getBottom());
        }
    }

    public BdToast tk() {
        this.mTextView.setText(this.aav);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Ij);
        this.zd.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).ti();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).ti();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ck(i).ti();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).ck(i).cm(i2).ti();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).ck(aay.get(defaultIcon).intValue()).ti();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).ck(aay.get(defaultIcon).intValue()).cm(i).ti();
    }
}
