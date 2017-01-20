package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> VB = new HashMap<>(2);
    private static SoftReference<Toast> Vw;
    private final ViewGroup UR;
    private final TextView Vt;
    private final ImageView Vx;
    private CharSequence Vy;
    private final Context mContext;
    private Toast sd;
    private int Vz = -1;
    private int mGravity = 16;
    private int BF = 0;
    private int nv = 0;
    private int nw = 0;
    private int VA = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (VC) with 'values()' method */
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
        VB.put(DefaultIcon.SUCCESS, Integer.valueOf(r.g.icon_unite_pass));
        VB.put(DefaultIcon.FAILURE, Integer.valueOf(r.g.icon_unite_lose));
        VB.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.UR = (ViewGroup) LayoutInflater.from(context).inflate(r.j.dialog_bdtoast, (ViewGroup) null);
        this.Vx = (ImageView) this.UR.findViewById(r.h.toast_icon);
        this.Vt = (TextView) this.UR.findViewById(r.h.toast_message);
    }

    public void cancel() {
        if (this.sd != null) {
            this.sd.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.Vy = charSequence;
        this.Vt.setText(this.Vy);
        return this;
    }

    public void cl(int i) {
        this.VA = i;
    }

    public BdToast cm(int i) {
        this.Vz = i;
        return this;
    }

    public BdToast cn(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast co(int i) {
        this.BF = i;
        return this;
    }

    public void cp(int i) {
        this.nw = i;
    }

    public void Q(float f) {
        this.Vt.setLineSpacing(0.0f, f);
    }

    public BdToast tb() {
        this.sd = new Toast(this.mContext);
        tc();
        if (this.Vz != -1) {
            ap.c(this.Vx, this.Vz);
            this.Vx.setVisibility(0);
        } else {
            this.Vx.setVisibility(8);
        }
        ap.c(this.Vt, r.e.cp_cont_g, 1);
        this.Vt.setText(this.Vy);
        this.sd.setGravity(this.mGravity, this.nv, this.nw);
        this.sd.setDuration(this.BF);
        cq(this.VA);
        this.sd.setView(this.UR);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.nv = i2;
        this.nw = i3;
        return tb();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tc() {
        if (Vw != null && Vw.get() != null) {
            Vw.get().cancel();
        }
        Vw = new SoftReference<>(this.sd);
    }

    private void cq(int i) {
        if (i > 0) {
            this.UR.setPadding(i, this.UR.getTop(), i, this.UR.getBottom());
        }
    }

    public BdToast td() {
        this.Vt.setText(this.Vy);
        this.sd.setGravity(this.mGravity, this.nv, this.nw);
        this.sd.setDuration(this.BF);
        this.sd.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tb();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).tb();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).tb();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cm(i).co(i2).tb();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cm(VB.get(defaultIcon).intValue()).tb();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cm(VB.get(defaultIcon).intValue()).co(i).tb();
    }
}
