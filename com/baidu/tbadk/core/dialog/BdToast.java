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
    private static SoftReference<Toast> Xg;
    private static HashMap<DefaultIcon, Integer> Xl = new HashMap<>(2);
    private final ImageView Xh;
    private CharSequence Xi;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private Toast yC;
    private int Xj = -1;
    private int mGravity = 16;
    private int Ih = 0;
    private int uo = 0;
    private int up = 0;
    private int Xk = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Xm) with 'values()' method */
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
        Xl.put(DefaultIcon.SUCCESS, Integer.valueOf(i.e.icon_unite_pass));
        Xl.put(DefaultIcon.FAILURE, Integer.valueOf(i.e.icon_unite_lose));
        Xl.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(i.g.dialog_bdtoast, (ViewGroup) null);
        this.Xh = (ImageView) this.mRootView.findViewById(i.f.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(i.f.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.Xi = charSequence;
        return this;
    }

    public void bP(int i) {
        this.Xk = i;
    }

    public BdToast bQ(int i) {
        this.Xj = i;
        return this;
    }

    public BdToast bR(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bS(int i) {
        this.Ih = i;
        return this;
    }

    public void bT(int i) {
        this.up = i;
    }

    public BdToast ta() {
        this.yC = new Toast(this.mContext);
        tb();
        if (this.Xj != -1) {
            al.c(this.Xh, this.Xj);
            this.Xh.setVisibility(0);
        } else {
            this.Xh.setVisibility(8);
        }
        al.b(this.mTextView, i.c.toast_text, 1);
        this.mTextView.setText(this.Xi);
        bU(this.Xk);
        this.yC.setView(this.mRootView);
        this.yC.setGravity(this.mGravity, this.uo, this.up);
        this.yC.setDuration(this.Ih);
        return this;
    }

    private void tb() {
        if (Xg != null && Xg.get() != null) {
            Xg.get().cancel();
        }
        Xg = new SoftReference<>(this.yC);
    }

    private void bU(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tc() {
        this.yC.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).ta();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bS(i).ta();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bQ(i).ta();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bQ(i).bS(i2).ta();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bQ(Xl.get(defaultIcon).intValue()).ta();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bQ(Xl.get(defaultIcon).intValue()).bS(i).ta();
    }
}
