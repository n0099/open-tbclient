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
    private static SoftReference<Toast> aaZ;
    private static HashMap<DefaultIcon, Integer> abe = new HashMap<>(2);
    private final ViewGroup aat;
    private final ImageView aba;
    private CharSequence abb;
    private final Context mContext;
    private final TextView mTextView;
    private Toast zc;
    private int abc = -1;
    private int mGravity = 16;
    private int Iv = 0;
    private int uS = 0;
    private int uT = 0;
    private int abd = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (abf) with 'values()' method */
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
        abe.put(DefaultIcon.SUCCESS, Integer.valueOf(w.g.icon_unite_pass));
        abe.put(DefaultIcon.FAILURE, Integer.valueOf(w.g.icon_unite_lose));
        abe.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aat = (ViewGroup) LayoutInflater.from(context).inflate(w.j.dialog_bdtoast, (ViewGroup) null);
        this.aba = (ImageView) this.aat.findViewById(w.h.toast_icon);
        this.mTextView = (TextView) this.aat.findViewById(w.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.abb = charSequence;
        this.mTextView.setText(this.abb);
        return this;
    }

    public void ck(int i) {
        this.abd = i;
    }

    public BdToast cl(int i) {
        this.abc = i;
        return this;
    }

    public BdToast cm(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cn(int i) {
        this.Iv = i;
        return this;
    }

    public void co(int i) {
        this.uT = i;
    }

    public void Q(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tW() {
        this.zc = new Toast(this.mContext);
        tX();
        if (this.abc != -1) {
            aq.c(this.aba, this.abc);
            this.aba.setVisibility(0);
        } else {
            this.aba.setVisibility(8);
        }
        aq.c(this.mTextView, w.e.cp_cont_g, 1);
        this.mTextView.setText(this.abb);
        this.zc.setGravity(this.mGravity, this.uS, this.uT);
        this.zc.setDuration(this.Iv);
        cp(this.abd);
        this.zc.setView(this.aat);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uS = i2;
        this.uT = i3;
        return tW();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tX() {
        if (aaZ != null && aaZ.get() != null) {
            aaZ.get().cancel();
        }
        aaZ = new SoftReference<>(this.zc);
    }

    private void cp(int i) {
        if (i > 0) {
            this.aat.setPadding(i, this.aat.getTop(), i, this.aat.getBottom());
        }
    }

    public BdToast tY() {
        this.mTextView.setText(this.abb);
        this.zc.setGravity(this.mGravity, this.uS, this.uT);
        this.zc.setDuration(this.Iv);
        this.zc.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cn(i).tW();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cl(i).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cl(i).cn(i2).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cl(abe.get(defaultIcon).intValue()).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cl(abe.get(defaultIcon).intValue()).cn(i).tW();
    }
}
