package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> Sp;
    private static HashMap<DefaultIcon, Integer> Su = new HashMap<>(2);
    private final ViewGroup RI;
    private final TextView Sm;
    private final ImageView Sq;
    private CharSequence Sr;
    private final Context mContext;
    private Toast pv;
    private int Ss = -1;
    private int mGravity = 16;
    private int zD = 0;
    private int kF = 0;
    private int kG = 0;
    private int St = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Sv) with 'values()' method */
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
        Su.put(DefaultIcon.SUCCESS, Integer.valueOf(t.f.icon_unite_pass));
        Su.put(DefaultIcon.FAILURE, Integer.valueOf(t.f.icon_unite_lose));
        Su.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.RI = (ViewGroup) LayoutInflater.from(context).inflate(t.h.dialog_bdtoast, (ViewGroup) null);
        this.Sq = (ImageView) this.RI.findViewById(t.g.toast_icon);
        this.Sm = (TextView) this.RI.findViewById(t.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.Sr = charSequence;
        this.Sm.setText(this.Sr);
        return this;
    }

    public void bW(int i) {
        this.St = i;
    }

    public BdToast bX(int i) {
        this.Ss = i;
        return this;
    }

    public BdToast bY(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bZ(int i) {
        this.zD = i;
        return this;
    }

    public void ca(int i) {
        this.kG = i;
    }

    public BdToast sa() {
        this.pv = new Toast(this.mContext);
        sb();
        if (this.Ss != -1) {
            at.c(this.Sq, this.Ss);
            this.Sq.setVisibility(0);
        } else {
            this.Sq.setVisibility(8);
        }
        at.c(this.Sm, t.d.toast_text, 1);
        this.Sm.setText(this.Sr);
        this.pv.setGravity(this.mGravity, this.kF, this.kG);
        this.pv.setDuration(this.zD);
        cb(this.St);
        this.pv.setView(this.RI);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.kF = i2;
        this.kG = i3;
        return sa();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void sb() {
        if (Sp != null && Sp.get() != null) {
            Sp.get().cancel();
        }
        Sp = new SoftReference<>(this.pv);
    }

    private void cb(int i) {
        if (i > 0) {
            this.RI.setPadding(i, this.RI.getTop(), i, this.RI.getBottom());
        }
    }

    public BdToast sc() {
        this.Sm.setText(this.Sr);
        this.pv.setGravity(this.mGravity, this.kF, this.kG);
        this.pv.setDuration(this.zD);
        this.pv.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).sa();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bZ(i).sa();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bX(i).sa();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).bX(i).bZ(i2).sa();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).bX(Su.get(defaultIcon).intValue()).sa();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).bX(Su.get(defaultIcon).intValue()).bZ(i).sa();
    }
}
