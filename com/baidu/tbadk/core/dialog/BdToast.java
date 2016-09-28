package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> Wo;
    private static HashMap<DefaultIcon, Integer> Wt = new HashMap<>(2);
    private final ViewGroup VJ;
    private final TextView Wl;
    private final ImageView Wp;
    private CharSequence Wq;
    private final Context mContext;
    private Toast sk;
    private int Wr = -1;
    private int mGravity = 16;
    private int Cs = 0;
    private int nB = 0;
    private int nC = 0;
    private int Ws = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Wu) with 'values()' method */
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
        Wt.put(DefaultIcon.SUCCESS, Integer.valueOf(r.f.icon_unite_pass));
        Wt.put(DefaultIcon.FAILURE, Integer.valueOf(r.f.icon_unite_lose));
        Wt.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.VJ = (ViewGroup) LayoutInflater.from(context).inflate(r.h.dialog_bdtoast, (ViewGroup) null);
        this.Wp = (ImageView) this.VJ.findViewById(r.g.toast_icon);
        this.Wl = (TextView) this.VJ.findViewById(r.g.toast_message);
    }

    public void cancel() {
        if (this.sk != null) {
            this.sk.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.Wq = charSequence;
        this.Wl.setText(this.Wq);
        return this;
    }

    public void cj(int i) {
        this.Ws = i;
    }

    public BdToast ck(int i) {
        this.Wr = i;
        return this;
    }

    public BdToast cl(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cm(int i) {
        this.Cs = i;
        return this;
    }

    public void cn(int i) {
        this.nC = i;
    }

    public BdToast ts() {
        this.sk = new Toast(this.mContext);
        tt();
        if (this.Wr != -1) {
            av.c(this.Wp, this.Wr);
            this.Wp.setVisibility(0);
        } else {
            this.Wp.setVisibility(8);
        }
        av.c(this.Wl, r.d.cp_cont_g, 1);
        this.Wl.setText(this.Wq);
        this.sk.setGravity(this.mGravity, this.nB, this.nC);
        this.sk.setDuration(this.Cs);
        co(this.Ws);
        this.sk.setView(this.VJ);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.nB = i2;
        this.nC = i3;
        return ts();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void tt() {
        if (Wo != null && Wo.get() != null) {
            Wo.get().cancel();
        }
        Wo = new SoftReference<>(this.sk);
    }

    private void co(int i) {
        if (i > 0) {
            this.VJ.setPadding(i, this.VJ.getTop(), i, this.VJ.getBottom());
        }
    }

    public BdToast tu() {
        this.Wl.setText(this.Wq);
        this.sk.setGravity(this.mGravity, this.nB, this.nC);
        this.sk.setDuration(this.Cs);
        this.sk.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).ts();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).ts();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ck(i).ts();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).ck(i).cm(i2).ts();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).ck(Wt.get(defaultIcon).intValue()).ts();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).ck(Wt.get(defaultIcon).intValue()).cm(i).ts();
    }
}
