package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> Xa;
    private static HashMap<DefaultIcon, Integer> Xf = new HashMap<>(2);
    private final ImageView Xb;
    private CharSequence Xc;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private Toast yD;
    private int Xd = -1;
    private int mGravity = 16;
    private int Ii = 0;
    private int uo = 0;
    private int up = 0;
    private int Xe = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Xg) with 'values()' method */
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
        Xf.put(DefaultIcon.SUCCESS, Integer.valueOf(i.e.icon_unite_pass));
        Xf.put(DefaultIcon.FAILURE, Integer.valueOf(i.e.icon_unite_lose));
        Xf.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(i.g.dialog_bdtoast, (ViewGroup) null);
        this.Xb = (ImageView) this.mRootView.findViewById(i.f.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(i.f.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.Xc = charSequence;
        this.mTextView.setText(this.Xc);
        return this;
    }

    public void bP(int i) {
        this.Xe = i;
    }

    public BdToast bQ(int i) {
        this.Xd = i;
        return this;
    }

    public BdToast bR(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bS(int i) {
        this.Ii = i;
        return this;
    }

    public void bT(int i) {
        this.up = i;
    }

    public BdToast sU() {
        this.yD = new Toast(this.mContext);
        sV();
        if (this.Xd != -1) {
            an.c(this.Xb, this.Xd);
            this.Xb.setVisibility(0);
        } else {
            this.Xb.setVisibility(8);
        }
        an.b(this.mTextView, i.c.toast_text, 1);
        this.mTextView.setText(this.Xc);
        this.yD.setGravity(this.mGravity, this.uo, this.up);
        this.yD.setDuration(this.Ii);
        bU(this.Xe);
        this.yD.setView(this.mRootView);
        return this;
    }

    private BdToast n(int i, int i2, int i3) {
        this.mGravity = i;
        this.uo = i2;
        this.up = i3;
        return sU();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).n(i, i2, i3);
    }

    private void sV() {
        if (Xa != null && Xa.get() != null) {
            Xa.get().cancel();
        }
        Xa = new SoftReference<>(this.yD);
    }

    private void bU(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast sW() {
        this.mTextView.setText(this.Xc);
        this.yD.setGravity(this.mGravity, this.uo, this.up);
        this.yD.setDuration(this.Ii);
        this.yD.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).sU();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bS(i).sU();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bQ(i).sU();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bQ(i).bS(i2).sU();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bQ(Xf.get(defaultIcon).intValue()).sU();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bQ(Xf.get(defaultIcon).intValue()).bS(i).sU();
    }
}
