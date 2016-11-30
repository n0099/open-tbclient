package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> WM;
    private static HashMap<DefaultIcon, Integer> WR = new HashMap<>(2);
    private final TextView WJ;
    private final ImageView WN;
    private CharSequence WO;
    private final ViewGroup Wh;
    private final Context mContext;
    private Toast sl;
    private int WP = -1;
    private int mGravity = 16;
    private int Cs = 0;
    private int nC = 0;
    private int nD = 0;
    private int WQ = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (WS) with 'values()' method */
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
        WR.put(DefaultIcon.SUCCESS, Integer.valueOf(r.f.icon_unite_pass));
        WR.put(DefaultIcon.FAILURE, Integer.valueOf(r.f.icon_unite_lose));
        WR.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.Wh = (ViewGroup) LayoutInflater.from(context).inflate(r.h.dialog_bdtoast, (ViewGroup) null);
        this.WN = (ImageView) this.Wh.findViewById(r.g.toast_icon);
        this.WJ = (TextView) this.Wh.findViewById(r.g.toast_message);
    }

    public void cancel() {
        if (this.sl != null) {
            this.sl.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.WO = charSequence;
        this.WJ.setText(this.WO);
        return this;
    }

    public void ck(int i) {
        this.WQ = i;
    }

    public BdToast cl(int i) {
        this.WP = i;
        return this;
    }

    public BdToast cm(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cn(int i) {
        this.Cs = i;
        return this;
    }

    public void co(int i) {
        this.nD = i;
    }

    public BdToast tw() {
        this.sl = new Toast(this.mContext);
        tx();
        if (this.WP != -1) {
            at.c(this.WN, this.WP);
            this.WN.setVisibility(0);
        } else {
            this.WN.setVisibility(8);
        }
        at.c(this.WJ, r.d.cp_cont_g, 1);
        this.WJ.setText(this.WO);
        this.sl.setGravity(this.mGravity, this.nC, this.nD);
        this.sl.setDuration(this.Cs);
        cp(this.WQ);
        this.sl.setView(this.Wh);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.nC = i2;
        this.nD = i3;
        return tw();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void tx() {
        if (WM != null && WM.get() != null) {
            WM.get().cancel();
        }
        WM = new SoftReference<>(this.sl);
    }

    private void cp(int i) {
        if (i > 0) {
            this.Wh.setPadding(i, this.Wh.getTop(), i, this.Wh.getBottom());
        }
    }

    public BdToast ty() {
        this.WJ.setText(this.WO);
        this.sl.setGravity(this.mGravity, this.nC, this.nD);
        this.sl.setDuration(this.Cs);
        this.sl.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tw();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cn(i).tw();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cl(i).tw();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cl(i).cn(i2).tw();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cl(WR.get(defaultIcon).intValue()).tw();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cl(WR.get(defaultIcon).intValue()).cn(i).tw();
    }
}
