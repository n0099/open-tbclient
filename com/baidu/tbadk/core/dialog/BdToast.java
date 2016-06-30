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
    private static SoftReference<Toast> SG;
    private static HashMap<DefaultIcon, Integer> SL = new HashMap<>(2);
    private final TextView SD;
    private final ImageView SH;
    private CharSequence SI;
    private final ViewGroup Sb;
    private final Context mContext;
    private Toast pv;
    private int SJ = -1;
    private int mGravity = 16;
    private int zC = 0;
    private int kD = 0;
    private int kE = 0;
    private int SK = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (SM) with 'values()' method */
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
        SL.put(DefaultIcon.SUCCESS, Integer.valueOf(u.f.icon_unite_pass));
        SL.put(DefaultIcon.FAILURE, Integer.valueOf(u.f.icon_unite_lose));
        SL.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.Sb = (ViewGroup) LayoutInflater.from(context).inflate(u.h.dialog_bdtoast, (ViewGroup) null);
        this.SH = (ImageView) this.Sb.findViewById(u.g.toast_icon);
        this.SD = (TextView) this.Sb.findViewById(u.g.toast_message);
    }

    public void cancel() {
        if (this.pv != null) {
            this.pv.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.SI = charSequence;
        this.SD.setText(this.SI);
        return this;
    }

    public void bW(int i) {
        this.SK = i;
    }

    public BdToast bX(int i) {
        this.SJ = i;
        return this;
    }

    public BdToast bY(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bZ(int i) {
        this.zC = i;
        return this;
    }

    public void ca(int i) {
        this.kE = i;
    }

    public BdToast rZ() {
        this.pv = new Toast(this.mContext);
        sa();
        if (this.SJ != -1) {
            av.c(this.SH, this.SJ);
            this.SH.setVisibility(0);
        } else {
            this.SH.setVisibility(8);
        }
        av.c(this.SD, u.d.cp_cont_g, 1);
        this.SD.setText(this.SI);
        this.pv.setGravity(this.mGravity, this.kD, this.kE);
        this.pv.setDuration(this.zC);
        cb(this.SK);
        this.pv.setView(this.Sb);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.kD = i2;
        this.kE = i3;
        return rZ();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void sa() {
        if (SG != null && SG.get() != null) {
            SG.get().cancel();
        }
        SG = new SoftReference<>(this.pv);
    }

    private void cb(int i) {
        if (i > 0) {
            this.Sb.setPadding(i, this.Sb.getTop(), i, this.Sb.getBottom());
        }
    }

    public BdToast sb() {
        this.SD.setText(this.SI);
        this.pv.setGravity(this.mGravity, this.kD, this.kE);
        this.pv.setDuration(this.zC);
        this.pv.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).rZ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bZ(i).rZ();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bX(i).rZ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).bX(i).bZ(i2).rZ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).bX(SL.get(defaultIcon).intValue()).rZ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).bX(SL.get(defaultIcon).intValue()).bZ(i).rZ();
    }
}
