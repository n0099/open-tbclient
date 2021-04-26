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
    public final Context f12811a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f12812b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f12813c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f12814d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12815e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f12816f;

    /* renamed from: g  reason: collision with root package name */
    public int f12817g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12818h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f12819i = 16;
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
        this.f12811a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f12813c = viewGroup;
        this.f12814d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f12815e = (TextView) this.f12813c.findViewById(R.id.toast_message);
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
        Toast toast = new Toast(this.f12811a);
        this.f12812b = toast;
        u.a(toast);
        s();
        int i2 = this.f12817g;
        if (i2 != -1) {
            if (this.f12818h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12814d, this.f12817g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12814d, i2);
            }
            this.f12814d.setVisibility(0);
        } else {
            this.f12814d.setVisibility(8);
        }
        this.f12813c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f12811a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f12815e, R.color.CAM_X0101, 1);
        this.f12815e.setText(this.f12816f);
        this.f12812b.setGravity(this.f12819i, this.k, this.l);
        this.f12812b.setDuration(this.j);
        r(this.m);
        this.f12812b.setView(this.f12813c);
        return this;
    }

    public BdToast b(int i2) {
        this.f12812b = new Toast(this.f12811a);
        s();
        int i3 = this.f12817g;
        if (i3 != -1) {
            if (this.f12818h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12814d, this.f12817g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12814d, i3);
            }
            this.f12814d.setVisibility(0);
        } else {
            this.f12814d.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.f12815e, R.color.CAM_X0101, 1, i2);
        this.f12815e.setText(this.f12816f);
        this.f12812b.setGravity(this.f12819i, this.k, this.l);
        this.f12812b.setDuration(this.j);
        r(this.m);
        this.f12812b.setView(this.f12813c);
        return this;
    }

    public BdToast j(int i2) {
        this.j = i2;
        return this;
    }

    public void k(float f2) {
        this.f12815e.setLineSpacing(0.0f, f2);
    }

    public BdToast l(int i2) {
        this.f12819i = i2;
        return this;
    }

    public BdToast m(int i2, boolean z) {
        this.f12817g = i2;
        this.f12818h = z;
        return this;
    }

    public void n(int i2) {
        this.l = i2;
    }

    public void o(int i2) {
        this.m = i2;
    }

    public BdToast p(CharSequence charSequence) {
        this.f12816f = charSequence;
        this.f12815e.setText(charSequence);
        return this;
    }

    public BdToast q() {
        this.f12815e.setText(this.f12816f);
        this.f12812b.setGravity(this.f12819i, this.k, this.l);
        this.f12812b.setDuration(this.j);
        this.f12812b.show();
        return this;
    }

    public final void r(int i2) {
        if (i2 > 0) {
            this.f12813c.setPadding(i2, this.f12813c.getTop(), i2, this.f12813c.getBottom());
        }
    }

    public final void s() {
        SoftReference<Toast> softReference = n;
        if (softReference != null && softReference.get() != null) {
            n.get().cancel();
        }
        n = new SoftReference<>(this.f12812b);
    }
}
