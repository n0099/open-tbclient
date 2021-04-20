package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import d.a.a.d;
import d.a.a.u.i.j;
import d.a.a.u.i.k;
import d.a.a.u.i.l;
import d.a.a.u.j.b;
import d.a.a.y.a;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f1618a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1619b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1620c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1621d;

    /* renamed from: e  reason: collision with root package name */
    public final LayerType f1622e;

    /* renamed from: f  reason: collision with root package name */
    public final long f1623f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f1624g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Mask> f1625h;
    public final l i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;
    @Nullable
    public final j q;
    @Nullable
    public final k r;
    @Nullable
    public final d.a.a.u.i.b s;
    public final List<a<Float>> t;
    public final MatteType u;
    public final boolean v;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<b> list, d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<a<Float>> list3, MatteType matteType, @Nullable d.a.a.u.i.b bVar, boolean z) {
        this.f1618a = list;
        this.f1619b = dVar;
        this.f1620c = str;
        this.f1621d = j;
        this.f1622e = layerType;
        this.f1623f = j2;
        this.f1624g = str2;
        this.f1625h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f2;
        this.n = f3;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
        this.v = z;
    }

    public d a() {
        return this.f1619b;
    }

    public long b() {
        return this.f1621d;
    }

    public List<a<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.f1622e;
    }

    public List<Mask> e() {
        return this.f1625h;
    }

    public MatteType f() {
        return this.u;
    }

    public String g() {
        return this.f1620c;
    }

    public long h() {
        return this.f1623f;
    }

    public int i() {
        return this.p;
    }

    public int j() {
        return this.o;
    }

    @Nullable
    public String k() {
        return this.f1624g;
    }

    public List<b> l() {
        return this.f1618a;
    }

    public int m() {
        return this.l;
    }

    public int n() {
        return this.k;
    }

    public int o() {
        return this.j;
    }

    public float p() {
        return this.n / this.f1619b.e();
    }

    @Nullable
    public j q() {
        return this.q;
    }

    @Nullable
    public k r() {
        return this.r;
    }

    @Nullable
    public d.a.a.u.i.b s() {
        return this.s;
    }

    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    public l u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        Layer s = this.f1619b.s(h());
        if (s != null) {
            sb.append("\t\tParents: ");
            sb.append(s.g());
            Layer s2 = this.f1619b.s(s.h());
            while (s2 != null) {
                sb.append("->");
                sb.append(s2.g());
                s2 = this.f1619b.s(s2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f1618a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (b bVar : this.f1618a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
