package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> YJ;
    private static HashMap<DefaultIcon, Integer> YO = new HashMap<>(2);
    private final TextView YG;
    private final ImageView YK;
    private CharSequence YL;
    private final ViewGroup Ye;
    private final Context mContext;
    private Toast yT;
    private int YM = -1;
    private int mGravity = 16;
    private int Jh = 0;
    private int uF = 0;
    private int uG = 0;
    private int YN = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (YP) with 'values()' method */
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
        YO.put(DefaultIcon.SUCCESS, Integer.valueOf(t.f.icon_unite_pass));
        YO.put(DefaultIcon.FAILURE, Integer.valueOf(t.f.icon_unite_lose));
        YO.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.Ye = (ViewGroup) LayoutInflater.from(context).inflate(t.h.dialog_bdtoast, (ViewGroup) null);
        this.YK = (ImageView) this.Ye.findViewById(t.g.toast_icon);
        this.YG = (TextView) this.Ye.findViewById(t.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.YL = charSequence;
        this.YG.setText(this.YL);
        return this;
    }

    public void cj(int i) {
        this.YN = i;
    }

    public BdToast ck(int i) {
        this.YM = i;
        return this;
    }

    public BdToast cl(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cm(int i) {
        this.Jh = i;
        return this;
    }

    public void cn(int i) {
        this.uG = i;
    }

    public BdToast uq() {
        this.yT = new Toast(this.mContext);
        ur();
        if (this.YM != -1) {
            ar.c(this.YK, this.YM);
            this.YK.setVisibility(0);
        } else {
            this.YK.setVisibility(8);
        }
        ar.b(this.YG, t.d.toast_text, 1);
        this.YG.setText(this.YL);
        this.yT.setGravity(this.mGravity, this.uF, this.uG);
        this.yT.setDuration(this.Jh);
        co(this.YN);
        this.yT.setView(this.Ye);
        return this;
    }

    private BdToast m(int i, int i2, int i3) {
        this.mGravity = i;
        this.uF = i2;
        this.uG = i3;
        return uq();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).m(i, i2, i3);
    }

    private void ur() {
        if (YJ != null && YJ.get() != null) {
            YJ.get().cancel();
        }
        YJ = new SoftReference<>(this.yT);
    }

    private void co(int i) {
        if (i > 0) {
            this.Ye.setPadding(i, this.Ye.getTop(), i, this.Ye.getBottom());
        }
    }

    public BdToast us() {
        this.YG.setText(this.YL);
        this.yT.setGravity(this.mGravity, this.uF, this.uG);
        this.yT.setDuration(this.Jh);
        this.yT.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).uq();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cm(i).uq();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ck(i).uq();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).ck(i).cm(i2).uq();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).ck(YO.get(defaultIcon).intValue()).uq();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).ck(YO.get(defaultIcon).intValue()).cm(i).uq();
    }
}
