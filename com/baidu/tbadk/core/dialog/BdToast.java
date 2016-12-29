package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> Wg;
    private static HashMap<DefaultIcon, Integer> Wl = new HashMap<>(2);
    private final ViewGroup VB;
    private final TextView Wd;
    private final ImageView Wh;
    private CharSequence Wi;
    private final Context mContext;
    private Toast sl;
    private int Wj = -1;
    private int mGravity = 16;
    private int Ct = 0;
    private int nC = 0;
    private int nD = 0;
    private int Wk = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Wm) with 'values()' method */
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
        Wl.put(DefaultIcon.SUCCESS, Integer.valueOf(r.f.icon_unite_pass));
        Wl.put(DefaultIcon.FAILURE, Integer.valueOf(r.f.icon_unite_lose));
        Wl.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.VB = (ViewGroup) LayoutInflater.from(context).inflate(r.h.dialog_bdtoast, (ViewGroup) null);
        this.Wh = (ImageView) this.VB.findViewById(r.g.toast_icon);
        this.Wd = (TextView) this.VB.findViewById(r.g.toast_message);
    }

    public void cancel() {
        if (this.sl != null) {
            this.sl.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.Wi = charSequence;
        this.Wd.setText(this.Wi);
        return this;
    }

    public void cm(int i) {
        this.Wk = i;
    }

    public BdToast cn(int i) {
        this.Wj = i;
        return this;
    }

    public BdToast co(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cp(int i) {
        this.Ct = i;
        return this;
    }

    public void cq(int i) {
        this.nD = i;
    }

    public void P(float f) {
        this.Wd.setLineSpacing(0.0f, f);
    }

    public BdToast th() {
        this.sl = new Toast(this.mContext);
        ti();
        if (this.Wj != -1) {
            ar.c(this.Wh, this.Wj);
            this.Wh.setVisibility(0);
        } else {
            this.Wh.setVisibility(8);
        }
        ar.c(this.Wd, r.d.cp_cont_g, 1);
        this.Wd.setText(this.Wi);
        this.sl.setGravity(this.mGravity, this.nC, this.nD);
        this.sl.setDuration(this.Ct);
        cr(this.Wk);
        this.sl.setView(this.VB);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.nC = i2;
        this.nD = i3;
        return th();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void ti() {
        if (Wg != null && Wg.get() != null) {
            Wg.get().cancel();
        }
        Wg = new SoftReference<>(this.sl);
    }

    private void cr(int i) {
        if (i > 0) {
            this.VB.setPadding(i, this.VB.getTop(), i, this.VB.getBottom());
        }
    }

    public BdToast tj() {
        this.Wd.setText(this.Wi);
        this.sl.setGravity(this.mGravity, this.nC, this.nD);
        this.sl.setDuration(this.Ct);
        this.sl.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cp(i).th();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cn(i).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cn(i).cp(i2).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cn(Wl.get(defaultIcon).intValue()).th();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cn(Wl.get(defaultIcon).intValue()).cp(i).th();
    }
}
