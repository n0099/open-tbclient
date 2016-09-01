package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> We;
    private static HashMap<DefaultIcon, Integer> Wj = new HashMap<>(2);
    private final ViewGroup Vz;
    private final TextView Wb;
    private final ImageView Wf;
    private CharSequence Wg;
    private final Context mContext;
    private Toast sk;
    private int Wh = -1;
    private int mGravity = 16;
    private int Cs = 0;
    private int nB = 0;
    private int nC = 0;
    private int Wi = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Wk) with 'values()' method */
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
        Wj.put(DefaultIcon.SUCCESS, Integer.valueOf(t.f.icon_unite_pass));
        Wj.put(DefaultIcon.FAILURE, Integer.valueOf(t.f.icon_unite_lose));
        Wj.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.Vz = (ViewGroup) LayoutInflater.from(context).inflate(t.h.dialog_bdtoast, (ViewGroup) null);
        this.Wf = (ImageView) this.Vz.findViewById(t.g.toast_icon);
        this.Wb = (TextView) this.Vz.findViewById(t.g.toast_message);
    }

    public void cancel() {
        if (this.sk != null) {
            this.sk.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.Wg = charSequence;
        this.Wb.setText(this.Wg);
        return this;
    }

    public void cj(int i) {
        this.Wi = i;
    }

    public BdToast ck(int i) {
        this.Wh = i;
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

    public BdToast td() {
        this.sk = new Toast(this.mContext);
        te();
        if (this.Wh != -1) {
            av.c(this.Wf, this.Wh);
            this.Wf.setVisibility(0);
        } else {
            this.Wf.setVisibility(8);
        }
        av.c(this.Wb, t.d.cp_cont_g, 1);
        this.Wb.setText(this.Wg);
        this.sk.setGravity(this.mGravity, this.nB, this.nC);
        this.sk.setDuration(this.Cs);
        co(this.Wi);
        this.sk.setView(this.Vz);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.nB = i2;
        this.nC = i3;
        return td();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void te() {
        if (We != null && We.get() != null) {
            We.get().cancel();
        }
        We = new SoftReference<>(this.sk);
    }

    private void co(int i) {
        if (i > 0) {
            this.Vz.setPadding(i, this.Vz.getTop(), i, this.Vz.getBottom());
        }
    }

    public BdToast tf() {
        this.Wb.setText(this.Wg);
        this.sk.setGravity(this.mGravity, this.nB, this.nC);
        this.sk.setDuration(this.Cs);
        this.sk.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).td();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).td();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ck(i).td();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).ck(i).cm(i2).td();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).ck(Wj.get(defaultIcon).intValue()).td();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).ck(Wj.get(defaultIcon).intValue()).cm(i).td();
    }
}
