package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import d.a.a.d;
import d.a.a.s.i.j;
import d.a.a.s.i.k;
import d.a.a.s.i.l;
import d.a.a.s.j.b;
import d.a.a.w.a;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f1616a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1617b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1618c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1619d;

    /* renamed from: e  reason: collision with root package name */
    public final LayerType f1620e;

    /* renamed from: f  reason: collision with root package name */
    public final long f1621f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f1622g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Mask> f1623h;
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
    public final d.a.a.s.i.b s;
    public final List<a<Float>> t;
    public final MatteType u;

    /* loaded from: classes.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<b> list, d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<a<Float>> list3, MatteType matteType, @Nullable d.a.a.s.i.b bVar) {
        this.f1616a = list;
        this.f1617b = dVar;
        this.f1618c = str;
        this.f1619d = j;
        this.f1620e = layerType;
        this.f1621f = j2;
        this.f1622g = str2;
        this.f1623h = list2;
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
    }

    public d a() {
        return this.f1617b;
    }

    public long b() {
        return this.f1619d;
    }

    public List<a<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.f1620e;
    }

    public List<Mask> e() {
        return this.f1623h;
    }

    public MatteType f() {
        return this.u;
    }

    public String g() {
        return this.f1618c;
    }

    public long h() {
        return this.f1621f;
    }

    public int i() {
        return this.p;
    }

    public int j() {
        return this.o;
    }

    @Nullable
    public String k() {
        return this.f1622g;
    }

    public List<b> l() {
        return this.f1616a;
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
        return this.n / this.f1617b.e();
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
    public d.a.a.s.i.b s() {
        return this.s;
    }

    public float t() {
        return this.m;
    }

    public String toString() {
        return v("");
    }

    public l u() {
        return this.i;
    }

    public String v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        Layer o = this.f1617b.o(h());
        if (o != null) {
            sb.append("\t\tParents: ");
            sb.append(o.g());
            Layer o2 = this.f1617b.o(o.h());
            while (o2 != null) {
                sb.append("->");
                sb.append(o2.g());
                o2 = this.f1617b.o(o2.h());
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
        if (!this.f1616a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (b bVar : this.f1616a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
