package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> To;
    private static HashMap<DefaultIcon, Integer> Tt = new HashMap<>(2);
    private final ViewGroup SJ;
    private final TextView Tl;
    private final ImageView Tp;
    private CharSequence Tq;
    private final Context mContext;
    private Toast pX;
    private int Tr = -1;
    private int mGravity = 16;
    private int Ae = 0;
    private int lg = 0;
    private int lh = 0;
    private int Ts = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Tu) with 'values()' method */
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
        Tt.put(DefaultIcon.SUCCESS, Integer.valueOf(u.f.icon_unite_pass));
        Tt.put(DefaultIcon.FAILURE, Integer.valueOf(u.f.icon_unite_lose));
        Tt.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.SJ = (ViewGroup) LayoutInflater.from(context).inflate(u.h.dialog_bdtoast, (ViewGroup) null);
        this.Tp = (ImageView) this.SJ.findViewById(u.g.toast_icon);
        this.Tl = (TextView) this.SJ.findViewById(u.g.toast_message);
    }

    public void cancel() {
        if (this.pX != null) {
            this.pX.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.Tq = charSequence;
        this.Tl.setText(this.Tq);
        return this;
    }

    public void bW(int i) {
        this.Ts = i;
    }

    public BdToast bX(int i) {
        this.Tr = i;
        return this;
    }

    public BdToast bY(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bZ(int i) {
        this.Ae = i;
        return this;
    }

    public void ca(int i) {
        this.lh = i;
    }

    public BdToast rY() {
        this.pX = new Toast(this.mContext);
        rZ();
        if (this.Tr != -1) {
            av.c(this.Tp, this.Tr);
            this.Tp.setVisibility(0);
        } else {
            this.Tp.setVisibility(8);
        }
        av.c(this.Tl, u.d.cp_cont_g, 1);
        this.Tl.setText(this.Tq);
        this.pX.setGravity(this.mGravity, this.lg, this.lh);
        this.pX.setDuration(this.Ae);
        cb(this.Ts);
        this.pX.setView(this.SJ);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.lg = i2;
        this.lh = i3;
        return rY();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void rZ() {
        if (To != null && To.get() != null) {
            To.get().cancel();
        }
        To = new SoftReference<>(this.pX);
    }

    private void cb(int i) {
        if (i > 0) {
            this.SJ.setPadding(i, this.SJ.getTop(), i, this.SJ.getBottom());
        }
    }

    public BdToast sa() {
        this.Tl.setText(this.Tq);
        this.pX.setGravity(this.mGravity, this.lg, this.lh);
        this.pX.setDuration(this.Ae);
        this.pX.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).rY();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bZ(i).rY();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bX(i).rY();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).bX(i).bZ(i2).rY();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).bX(Tt.get(defaultIcon).intValue()).rY();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).bX(Tt.get(defaultIcon).intValue()).bZ(i).rY();
    }
}
