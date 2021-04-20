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
    public final Context f12886a;

    /* renamed from: b  reason: collision with root package name */
    public Toast f12887b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f12888c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f12889d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12890e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f12891f;

    /* renamed from: g  reason: collision with root package name */
    public int f12892g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12893h = false;
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
        this.f12886a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.f12888c = viewGroup;
        this.f12889d = (ImageView) viewGroup.findViewById(R.id.toast_icon);
        this.f12890e = (TextView) this.f12888c.findViewById(R.id.toast_message);
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
        Toast toast = new Toast(this.f12886a);
        this.f12887b = toast;
        u.a(toast);
        s();
        int i = this.f12892g;
        if (i != -1) {
            if (this.f12893h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12889d, this.f12892g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12889d, i);
            }
            this.f12889d.setVisibility(0);
        } else {
            this.f12889d.setVisibility(8);
        }
        this.f12888c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f12886a, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f12890e, R.color.CAM_X0101, 1);
        this.f12890e.setText(this.f12891f);
        this.f12887b.setGravity(this.i, this.k, this.l);
        this.f12887b.setDuration(this.j);
        r(this.m);
        this.f12887b.setView(this.f12888c);
        return this;
    }

    public BdToast b(int i) {
        this.f12887b = new Toast(this.f12886a);
        s();
        int i2 = this.f12892g;
        if (i2 != -1) {
            if (this.f12893h) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12889d, this.f12892g, R.color.CAM_X0101, null);
            } else {
                SkinManager.setImageResource(this.f12889d, i2);
            }
            this.f12889d.setVisibility(0);
        } else {
            this.f12889d.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.f12890e, R.color.CAM_X0101, 1, i);
        this.f12890e.setText(this.f12891f);
        this.f12887b.setGravity(this.i, this.k, this.l);
        this.f12887b.setDuration(this.j);
        r(this.m);
        this.f12887b.setView(this.f12888c);
        return this;
    }

    public BdToast j(int i) {
        this.j = i;
        return this;
    }

    public void k(float f2) {
        this.f12890e.setLineSpacing(0.0f, f2);
    }

    public BdToast l(int i) {
        this.i = i;
        return this;
    }

    public BdToast m(int i, boolean z) {
        this.f12892g = i;
        this.f12893h = z;
        return this;
    }

    public void n(int i) {
        this.l = i;
    }

    public void o(int i) {
        this.m = i;
    }

    public BdToast p(CharSequence charSequence) {
        this.f12891f = charSequence;
        this.f12890e.setText(charSequence);
        return this;
    }

    public BdToast q() {
        this.f12890e.setText(this.f12891f);
        this.f12887b.setGravity(this.i, this.k, this.l);
        this.f12887b.setDuration(this.j);
        this.f12887b.show();
        return this;
    }

    public final void r(int i) {
        if (i > 0) {
            this.f12888c.setPadding(i, this.f12888c.getTop(), i, this.f12888c.getBottom());
        }
    }

    public final void s() {
        SoftReference<Toast> softReference = n;
        if (softReference != null && softReference.get() != null) {
            n.get().cancel();
        }
        n = new SoftReference<>(this.f12887b);
    }
}
