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
    private static SoftReference<Toast> aau;
    private static HashMap<DefaultIcon, Integer> aaz = new HashMap<>(2);
    private final ViewGroup ZO;
    private final ImageView aav;
    private CharSequence aaw;
    private final Context mContext;
    private final TextView mTextView;
    private Toast zd;
    private int aax = -1;
    private int mGravity = 16;
    private int Iv = 0;
    private int uT = 0;
    private int uU = 0;
    private int aay = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (aaA) with 'values()' method */
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
        aaz.put(DefaultIcon.SUCCESS, Integer.valueOf(w.g.icon_unite_pass));
        aaz.put(DefaultIcon.FAILURE, Integer.valueOf(w.g.icon_unite_lose));
        aaz.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.ZO = (ViewGroup) LayoutInflater.from(context).inflate(w.j.dialog_bdtoast, (ViewGroup) null);
        this.aav = (ImageView) this.ZO.findViewById(w.h.toast_icon);
        this.mTextView = (TextView) this.ZO.findViewById(w.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.aaw = charSequence;
        this.mTextView.setText(this.aaw);
        return this;
    }

    public void ci(int i) {
        this.aay = i;
    }

    public BdToast cj(int i) {
        this.aax = i;
        return this;
    }

    public BdToast ck(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cl(int i) {
        this.Iv = i;
        return this;
    }

    public void cm(int i) {
        this.uU = i;
    }

    public void Q(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tj() {
        this.zd = new Toast(this.mContext);
        tk();
        if (this.aax != -1) {
            aq.c(this.aav, this.aax);
            this.aav.setVisibility(0);
        } else {
            this.aav.setVisibility(8);
        }
        aq.c(this.mTextView, w.e.cp_cont_g, 1);
        this.mTextView.setText(this.aaw);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Iv);
        cn(this.aay);
        this.zd.setView(this.ZO);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uT = i2;
        this.uU = i3;
        return tj();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tk() {
        if (aau != null && aau.get() != null) {
            aau.get().cancel();
        }
        aau = new SoftReference<>(this.zd);
    }

    private void cn(int i) {
        if (i > 0) {
            this.ZO.setPadding(i, this.ZO.getTop(), i, this.ZO.getBottom());
        }
    }

    public BdToast tl() {
        this.mTextView.setText(this.aaw);
        this.zd.setGravity(this.mGravity, this.uT, this.uU);
        this.zd.setDuration(this.Iv);
        this.zd.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tj();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cl(i).tj();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cj(i).tj();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cj(i).cl(i2).tj();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cj(aaz.get(defaultIcon).intValue()).tj();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cj(aaz.get(defaultIcon).intValue()).cl(i).tj();
    }
}
