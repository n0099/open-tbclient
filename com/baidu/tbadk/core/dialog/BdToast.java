package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aaJ;
    private static HashMap<DefaultIcon, Integer> aaO = new HashMap<>(2);
    private final TextView aaE;
    private final ImageView aaK;
    private CharSequence aaL;
    private final ViewGroup aac;
    private final Context mContext;
    private Toast zy;
    private int aaM = -1;
    private int mGravity = 16;
    private int IT = 0;
    private int vk = 0;
    private int vl = 0;
    private int aaN = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (aaP) with 'values()' method */
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
        aaO.put(DefaultIcon.SUCCESS, Integer.valueOf(w.g.icon_unite_pass));
        aaO.put(DefaultIcon.FAILURE, Integer.valueOf(w.g.icon_unite_lose));
        aaO.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aac = (ViewGroup) LayoutInflater.from(context).inflate(w.j.dialog_bdtoast, (ViewGroup) null);
        this.aaK = (ImageView) this.aac.findViewById(w.h.toast_icon);
        this.aaE = (TextView) this.aac.findViewById(w.h.toast_message);
    }

    public void cancel() {
        if (this.zy != null) {
            this.zy.cancel();
        }
    }

    public BdToast b(CharSequence charSequence) {
        this.aaL = charSequence;
        this.aaE.setText(this.aaL);
        return this;
    }

    public void ch(int i) {
        this.aaN = i;
    }

    public BdToast ci(int i) {
        this.aaM = i;
        return this;
    }

    public BdToast cj(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast ck(int i) {
        this.IT = i;
        return this;
    }

    public void cl(int i) {
        this.vl = i;
    }

    public void Q(float f) {
        this.aaE.setLineSpacing(0.0f, f);
    }

    public BdToast ty() {
        this.zy = new Toast(this.mContext);
        tz();
        if (this.aaM != -1) {
            aq.c(this.aaK, this.aaM);
            this.aaK.setVisibility(0);
        } else {
            this.aaK.setVisibility(8);
        }
        aq.c(this.aaE, w.e.cp_cont_g, 1);
        this.aaE.setText(this.aaL);
        this.zy.setGravity(this.mGravity, this.vk, this.vl);
        this.zy.setDuration(this.IT);
        cm(this.aaN);
        this.zy.setView(this.aac);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.vk = i2;
        this.vl = i3;
        return ty();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tz() {
        if (aaJ != null && aaJ.get() != null) {
            aaJ.get().cancel();
        }
        aaJ = new SoftReference<>(this.zy);
    }

    private void cm(int i) {
        if (i > 0) {
            this.aac.setPadding(i, this.aac.getTop(), i, this.aac.getBottom());
        }
    }

    public BdToast tA() {
        this.aaE.setText(this.aaL);
        this.zy.setGravity(this.mGravity, this.vk, this.vl);
        this.zy.setDuration(this.IT);
        this.zy.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).ty();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ck(i).ty();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).ci(i).ty();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).ci(i).ck(i2).ty();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).ci(aaO.get(defaultIcon).intValue()).ty();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).ci(aaO.get(defaultIcon).intValue()).ck(i).ty();
    }
}
