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
    private static SoftReference<Toast> Xb;
    private static HashMap<DefaultIcon, Integer> Xg = new HashMap<>(2);
    private final TextView WY;
    private final ViewGroup Wy;
    private final ImageView Xc;
    private CharSequence Xd;
    private final Context mContext;
    private Toast zk;
    private int Xe = -1;
    private int mGravity = 16;
    private int Jn = 0;
    private int uO = 0;
    private int uP = 0;
    private int Xf = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Xh) with 'values()' method */
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
        Xg.put(DefaultIcon.SUCCESS, Integer.valueOf(t.f.icon_unite_pass));
        Xg.put(DefaultIcon.FAILURE, Integer.valueOf(t.f.icon_unite_lose));
        Xg.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.Wy = (ViewGroup) LayoutInflater.from(context).inflate(t.h.dialog_bdtoast, (ViewGroup) null);
        this.Xc = (ImageView) this.Wy.findViewById(t.g.toast_icon);
        this.WY = (TextView) this.Wy.findViewById(t.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.Xd = charSequence;
        this.WY.setText(this.Xd);
        return this;
    }

    public void cl(int i) {
        this.Xf = i;
    }

    public BdToast cm(int i) {
        this.Xe = i;
        return this;
    }

    public BdToast cn(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast co(int i) {
        this.Jn = i;
        return this;
    }

    public void cp(int i) {
        this.uP = i;
    }

    public BdToast uv() {
        this.zk = new Toast(this.mContext);
        uw();
        if (this.Xe != -1) {
            at.c(this.Xc, this.Xe);
            this.Xc.setVisibility(0);
        } else {
            this.Xc.setVisibility(8);
        }
        at.b(this.WY, t.d.toast_text, 1);
        this.WY.setText(this.Xd);
        this.zk.setGravity(this.mGravity, this.uO, this.uP);
        this.zk.setDuration(this.Jn);
        cq(this.Xf);
        this.zk.setView(this.Wy);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.uO = i2;
        this.uP = i3;
        return uv();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void uw() {
        if (Xb != null && Xb.get() != null) {
            Xb.get().cancel();
        }
        Xb = new SoftReference<>(this.zk);
    }

    private void cq(int i) {
        if (i > 0) {
            this.Wy.setPadding(i, this.Wy.getTop(), i, this.Wy.getBottom());
        }
    }

    public BdToast ux() {
        this.WY.setText(this.Xd);
        this.zk.setGravity(this.mGravity, this.uO, this.uP);
        this.zk.setDuration(this.Jn);
        this.zk.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).uv();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).uv();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).uv();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cm(i).co(i2).uv();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cm(Xg.get(defaultIcon).intValue()).uv();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cm(Xg.get(defaultIcon).intValue()).co(i).uv();
    }
}
