package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import d.a.a.f;
import d.a.a.q.a.q;
import d.a.a.s.i.d;
import d.a.a.s.j.b;
import java.util.List;
/* loaded from: classes.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1601a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.s.i.b f1602b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.a.s.i.b> f1603c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.a f1604d;

    /* renamed from: e  reason: collision with root package name */
    public final d f1605e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.i.b f1606f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f1607g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f1608h;
    public final float i;

    /* loaded from: classes.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = a.f1609a[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = a.f1610b[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1609a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1610b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f1610b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1610b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1610b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f1609a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1609a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1609a[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable d.a.a.s.i.b bVar, List<d.a.a.s.i.b> list, d.a.a.s.i.a aVar, d dVar, d.a.a.s.i.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2) {
        this.f1601a = str;
        this.f1602b = bVar;
        this.f1603c = list;
        this.f1604d = aVar;
        this.f1605e = dVar;
        this.f1606f = bVar2;
        this.f1607g = lineCapType;
        this.f1608h = lineJoinType;
        this.i = f2;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(f fVar, d.a.a.s.k.a aVar) {
        return new q(fVar, aVar, this);
    }

    public LineCapType b() {
        return this.f1607g;
    }

    public d.a.a.s.i.a c() {
        return this.f1604d;
    }

    public d.a.a.s.i.b d() {
        return this.f1602b;
    }

    public LineJoinType e() {
        return this.f1608h;
    }

    public List<d.a.a.s.i.b> f() {
        return this.f1603c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.f1601a;
    }

    public d i() {
        return this.f1605e;
    }

    public d.a.a.s.i.b j() {
        return this.f1606f;
    }
}
