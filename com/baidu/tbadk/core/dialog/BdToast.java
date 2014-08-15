package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static Toast b;
    private static HashMap<DefaultIcon, Integer> j = new HashMap<>(2);
    private final Context a;
    private final ViewGroup c;
    private final ImageView d;
    private final TextView e;
    private CharSequence f;
    private int g = -1;
    private int h = 16;
    private int i = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        j.put(DefaultIcon.SUCCESS, Integer.valueOf(t.icon_unite_pass));
        j.put(DefaultIcon.FAILURE, Integer.valueOf(t.icon_unite_lose));
    }

    private BdToast(Context context) {
        this.a = context;
        this.c = (ViewGroup) ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(v.dialog_bdtoast, (ViewGroup) null);
        this.d = (ImageView) this.c.findViewById(u.toast_icon);
        this.e = (TextView) this.c.findViewById(u.toast_message);
    }

    public BdToast a(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public BdToast a(int i) {
        this.g = i;
        return this;
    }

    public BdToast b(int i) {
        this.i = i;
        return this;
    }

    public BdToast a() {
        if (b != null) {
            b.cancel();
        }
        b = new Toast(this.a);
        if (this.g != -1) {
            ay.c(this.d, this.g);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        ay.a(this.e, r.toast_text, 1);
        this.e.setText(this.f);
        b.setView(this.c);
        b.setGravity(this.h, 0, 0);
        b.setDuration(this.i);
        return this;
    }

    public BdToast b() {
        b.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).a(charSequence).a();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).a(charSequence).a(i).a();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).a(charSequence).a(i).b(i2).a();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).a(charSequence).a(j.get(defaultIcon).intValue()).a();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).a(charSequence).a(j.get(defaultIcon).intValue()).b(i).a();
    }
}
