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
import d.a.c.e.p.l;
import d.a.c.e.p.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class BdToast {
    public static SoftReference<Toast> n;
    public static HashMap<DefaultIcon, Integer> o;

    /* renamed from: a  reason: collision with root package name */
    public final Context f12147a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f12148b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f12149c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f12150d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12151e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f12152f;

    /* renamed from: g  reason: collision with root package name */
    public int f12153g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12154h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f12155i = 16;
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
        this.f12147a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f12149c = viewGroup;
        this.f12150d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f12151e = (TextView) this.f12149c.findViewById(R.id.toast_message);
    }

    public static BdToast c(Context context, CharSequence charSequence) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.a();
        return bdToast;
    }

    public static BdToast d(Context context, CharSequence charSequence, int i2) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.j(i2);
        bdToast.a();
        return bdToast;
    }

    public static BdToast e(Context context, CharSequence charSequence, int i2, int i3) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.j(i2);
        bdToast.b(i3);
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

    public static BdToast g(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i2) {
        int intValue = o.get(defaultIcon).intValue();
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(intValue, true);
        bdToast.j(i2);
        bdToast.a();
        return bdToast;
    }

    public static BdToast h(Context context, CharSequence charSequence, int i2, int i3, boolean z) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(i2, z);
        bdToast.j(i3);
        bdToast.a();
        return bdToast;
    }

    public static BdToast i(Context context, CharSequence charSequence, int i2, boolean z) {
        BdToast bdToast = new BdToast(context);
        bdToast.p(charSequence);
        bdToast.m(i2, z);
        bdToast.a();
        return bdToast;
    }

    public BdToast a() {
        Toast toast = new Toast(this.f12147a);
        this.f12148b = toast;
        u.a(toast);
        s();
        int i2 = this.f12153g;
        if (i2 != -1) {
            if (this.f12154h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12150d, this.f12153g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12150d, i2);
            }
            this.f12150d.setVisibility(0);
        } else {
            this.f12150d.setVisibility(8);
        }
        this.f12149c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f12147a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f12151e, R.color.CAM_X0101, 1);
        this.f12151e.setText(this.f12152f);
        this.f12148b.setGravity(this.f12155i, this.k, this.l);
        this.f12148b.setDuration(this.j);
        r(this.m);
        this.f12148b.setView(this.f12149c);
        return this;
    }

    public BdToast b(int i2) {
        this.f12148b = new Toast(this.f12147a);
        s();
        int i3 = this.f12153g;
        if (i3 != -1) {
            if (this.f12154h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12150d, this.f12153g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12150d, i3);
            }
            this.f12150d.setVisibility(0);
        } else {
            this.f12150d.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.f12151e, R.color.CAM_X0101, 1, i2);
        this.f12151e.setText(this.f12152f);
        this.f12148b.setGravity(this.f12155i, this.k, this.l);
        this.f12148b.setDuration(this.j);
        r(this.m);
        this.f12148b.setView(this.f12149c);
        return this;
    }

    public BdToast j(int i2) {
        this.j = i2;
        return this;
    }

    public void k(float f2) {
        this.f12151e.setLineSpacing(0.0f, f2);
    }

    public BdToast l(int i2) {
        this.f12155i = i2;
        return this;
    }

    public BdToast m(int i2, boolean z) {
        this.f12153g = i2;
        this.f12154h = z;
        return this;
    }

    public void n(int i2) {
        this.l = i2;
    }

    public void o(int i2) {
        this.m = i2;
    }

    public BdToast p(CharSequence charSequence) {
        this.f12152f = charSequence;
        this.f12151e.setText(charSequence);
        return this;
    }

    public BdToast q() {
        this.f12151e.setText(this.f12152f);
        this.f12148b.setGravity(this.f12155i, this.k, this.l);
        this.f12148b.setDuration(this.j);
        this.f12148b.show();
        return this;
    }

    public final void r(int i2) {
        if (i2 > 0) {
            this.f12149c.setPadding(i2, this.f12149c.getTop(), i2, this.f12149c.getBottom());
        }
    }

    public final void s() {
        SoftReference<Toast> softReference = n;
        if (softReference != null && softReference.get() != null) {
            n.get().cancel();
        }
        n = new SoftReference<>(this.f12148b);
    }
}
