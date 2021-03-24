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
import d.b.b.e.p.l;
import d.b.b.e.p.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class BdToast {
    public static SoftReference<Toast> n;
    public static HashMap<DefaultIcon, Integer> o;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13224a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f13225b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f13226c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f13227d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13228e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f13229f;

    /* renamed from: g  reason: collision with root package name */
    public int f13230g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13231h = false;
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
        this.f13224a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f13226c = viewGroup;
        this.f13227d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f13228e = (TextView) this.f13226c.findViewById(R.id.toast_message);
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
        Toast toast = new Toast(this.f13224a);
        this.f13225b = toast;
        u.a(toast);
        s();
        int i = this.f13230g;
        if (i != -1) {
            if (this.f13231h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13227d, this.f13230g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f13227d, i);
            }
            this.f13227d.setVisibility(0);
        } else {
            this.f13227d.setVisibility(8);
        }
        this.f13226c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f13224a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f13228e, R.color.CAM_X0101, 1);
        this.f13228e.setText(this.f13229f);
        this.f13225b.setGravity(this.i, this.k, this.l);
        this.f13225b.setDuration(this.j);
        r(this.m);
        this.f13225b.setView(this.f13226c);
        return this;
    }

    public BdToast b(int i) {
        this.f13225b = new Toast(this.f13224a);
        s();
        int i2 = this.f13230g;
        if (i2 != -1) {
            if (this.f13231h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13227d, this.f13230g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f13227d, i2);
            }
            this.f13227d.setVisibility(0);
        } else {
            this.f13227d.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.f13228e, R.color.CAM_X0101, 1, i);
        this.f13228e.setText(this.f13229f);
        this.f13225b.setGravity(this.i, this.k, this.l);
        this.f13225b.setDuration(this.j);
        r(this.m);
        this.f13225b.setView(this.f13226c);
        return this;
    }

    public BdToast j(int i) {
        this.j = i;
        return this;
    }

    public void k(float f2) {
        this.f13228e.setLineSpacing(0.0f, f2);
    }

    public BdToast l(int i) {
        this.i = i;
        return this;
    }

    public BdToast m(int i, boolean z) {
        this.f13230g = i;
        this.f13231h = z;
        return this;
    }

    public void n(int i) {
        this.l = i;
    }

    public void o(int i) {
        this.m = i;
    }

    public BdToast p(CharSequence charSequence) {
        this.f13229f = charSequence;
        this.f13228e.setText(charSequence);
        return this;
    }

    public BdToast q() {
        this.f13228e.setText(this.f13229f);
        this.f13225b.setGravity(this.i, this.k, this.l);
        this.f13225b.setDuration(this.j);
        this.f13225b.show();
        return this;
    }

    public final void r(int i) {
        if (i > 0) {
            this.f13226c.setPadding(i, this.f13226c.getTop(), i, this.f13226c.getBottom());
        }
    }

    public final void s() {
        SoftReference<Toast> softReference = n;
        if (softReference != null && softReference.get() != null) {
            n.get().cancel();
        }
        n = new SoftReference<>(this.f13225b);
    }
}
