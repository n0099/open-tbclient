package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.c.e.p.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class BdToast {
    public static SoftReference<Toast> n;
    public static HashMap<DefaultIcon, Integer> o;

    /* renamed from: a  reason: collision with root package name */
    public final Context f12894a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f12895b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f12896c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f12897d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12898e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f12899f;

    /* renamed from: g  reason: collision with root package name */
    public int f12900g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12901h = false;
    public int i = 16;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;

    /* loaded from: classes3.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        HashMap<DefaultIcon, Integer> hashMap = new HashMap<>(2);
        o = hashMap;
        hashMap.put(DefaultIcon.SUCCESS, Integer.valueOf(R.drawable.icon_pure_toast_succeed40_svg));
        o.put(DefaultIcon.FAILURE, Integer.valueOf(R.drawable.icon_pure_toast_mistake40_svg));
        o.put(DefaultIcon.NOT, 0);
    }

    public BdToast(Context context) {
        this.f12894a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f12896c = viewGroup;
        this.f12897d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f12898e = (TextView) this.f12896c.findViewById(R.id.toast_message);
    }

    public static BdToast c(Context context, CharSequence charSequence) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.a();
        return bdToast;
    }

    public static BdToast d(Context context, CharSequence charSequence, int i) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.j(i);
        bdToast.a();
        return bdToast;
    }

    public static BdToast e(Context context, CharSequence charSequence, int i, int i2) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.j(i);
        bdToast.b(i2);
        return bdToast;
    }

    public static BdToast f(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        int intValue = o.get(defaultIcon).intValue();
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(intValue, true);
        bdToast.a();
        return bdToast;
    }

    public static BdToast g(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        int intValue = o.get(defaultIcon).intValue();
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(intValue, true);
        bdToast.j(i);
        bdToast.a();
        return bdToast;
    }

    public static BdToast h(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(i, z);
        bdToast.j(i2);
        bdToast.a();
        return bdToast;
    }

    public static BdToast i(Context context, CharSequence charSequence, int i, boolean z) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(i, z);
        bdToast.a();
        return bdToast;
    }

    public BdToast a() {
        Toast toast = new Toast(this.f12894a);
        this.f12895b = toast;
        u.a(toast);
        s();
        int i = this.f12900g;
        if (i != -1) {
            if (this.f12901h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12897d, this.f12900g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12897d, i);
            }
            this.f12897d.setVisibility(0);
        } else {
            this.f12897d.setVisibility(8);
        }
        this.f12896c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f12894a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f12898e, R.color.CAM_X0101, 1);
        this.f12898e.setText(this.f12899f);
        this.f12895b.setGravity(this.i, this.k, this.l);
        this.f12895b.setDuration(this.j);
        r(this.m);
        this.f12895b.setView(this.f12896c);
        return this;
    }

    public BdToast b(int i) {
        this.f12895b = new Toast(this.f12894a);
        s();
        int i2 = this.f12900g;
        if (i2 != -1) {
            if (this.f12901h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12897d, this.f12900g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12897d, i2);
            }
            this.f12897d.setVisibility(0);
        } else {
            this.f12897d.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.f12898e, R.color.CAM_X0101, 1, i);
        this.f12898e.setText(this.f12899f);
        this.f12895b.setGravity(this.i, this.k, this.l);
        this.f12895b.setDuration(this.j);
        r(this.m);
        this.f12895b.setView(this.f12896c);
        return this;
    }

    public BdToast j(int i) {
        this.j = i;
        return this;
    }

    public void k(float f2) {
        this.f12898e.setLineSpacing(0.0f, f2);
    }

    public BdToast l(int i) {
        this.i = i;
        return this;
    }

    public BdToast m(int i, boolean z) {
        this.f12900g = i;
        this.f12901h = z;
        return this;
    }

    public void n(int i) {
        this.l = i;
    }

    public void o(int i) {
        this.m = i;
    }

    public BdToast p(CharSequence charSequence) {
        this.f12899f = charSequence;
        this.f12898e.setText(charSequence);
        return this;
    }

    public BdToast q() {
        this.f12898e.setText(this.f12899f);
        this.f12895b.setGravity(this.i, this.k, this.l);
        this.f12895b.setDuration(this.j);
        this.f12895b.show();
        return this;
    }

    public final void r(int i) {
        if (i > 0) {
            this.f12896c.setPadding(i, this.f12896c.getTop(), i, this.f12896c.getBottom());
        }
    }

    public final void s() {
        SoftReference<Toast> softReference = n;
        if (softReference != null && softReference.get() != null) {
            n.get().cancel();
        }
        n = new SoftReference<>(this.f12895b);
    }
}
