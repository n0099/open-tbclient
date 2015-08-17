package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> WX;
    private static HashMap<DefaultIcon, Integer> Xc = new HashMap<>(2);
    private final ImageView WY;
    private CharSequence WZ;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private Toast yE;
    private int Xa = -1;
    private int mGravity = 16;
    private int Ih = 0;
    private int uq = 0;
    private int ur = 0;
    private int Xb = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Xd) with 'values()' method */
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
        Xc.put(DefaultIcon.SUCCESS, Integer.valueOf(i.e.icon_unite_pass));
        Xc.put(DefaultIcon.FAILURE, Integer.valueOf(i.e.icon_unite_lose));
        Xc.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(i.g.dialog_bdtoast, (ViewGroup) null);
        this.WY = (ImageView) this.mRootView.findViewById(i.f.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(i.f.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.WZ = charSequence;
        return this;
    }

    public void bM(int i) {
        this.Xb = i;
    }

    public BdToast bN(int i) {
        this.Xa = i;
        return this;
    }

    public BdToast bO(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bP(int i) {
        this.Ih = i;
        return this;
    }

    public void bQ(int i) {
        this.ur = i;
    }

    public BdToast sV() {
        this.yE = new Toast(this.mContext);
        sW();
        if (this.Xa != -1) {
            al.c(this.WY, this.Xa);
            this.WY.setVisibility(0);
        } else {
            this.WY.setVisibility(8);
        }
        al.b(this.mTextView, i.c.toast_text, 1);
        this.mTextView.setText(this.WZ);
        bR(this.Xb);
        this.yE.setView(this.mRootView);
        this.yE.setGravity(this.mGravity, this.uq, this.ur);
        this.yE.setDuration(this.Ih);
        return this;
    }

    private void sW() {
        if (WX != null && WX.get() != null) {
            WX.get().cancel();
        }
        WX = new SoftReference<>(this.yE);
    }

    private void bR(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast sX() {
        this.yE.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).sV();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bP(i).sV();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bN(i).sV();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bN(i).bP(i2).sV();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bN(Xc.get(defaultIcon).intValue()).sV();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bN(Xc.get(defaultIcon).intValue()).bP(i).sV();
    }
}
