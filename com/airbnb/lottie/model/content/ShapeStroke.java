package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import d.a.a.f;
import d.a.a.s.b.c;
import d.a.a.s.b.r;
import d.a.a.u.i.d;
import d.a.a.u.j.b;
import java.util.List;
/* loaded from: classes.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1602a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.u.i.b f1603b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.a.u.i.b> f1604c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.a f1605d;

    /* renamed from: e  reason: collision with root package name */
    public final d f1606e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.u.i.b f1607f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f1608g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f1609h;
    public final float i;
    public final boolean j;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.f1610a[ordinal()];
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
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.f1611b[ordinal()];
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
        public static final /* synthetic */ int[] f1610a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1611b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f1611b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1611b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1611b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f1610a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1610a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1610a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable d.a.a.u.i.b bVar, List<d.a.a.u.i.b> list, d.a.a.u.i.a aVar, d dVar, d.a.a.u.i.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.f1602a = str;
        this.f1603b = bVar;
        this.f1604c = list;
        this.f1605d = aVar;
        this.f1606e = dVar;
        this.f1607f = bVar2;
        this.f1608g = lineCapType;
        this.f1609h = lineJoinType;
        this.i = f2;
        this.j = z;
    }

    @Override // d.a.a.u.j.b
    public c a(f fVar, d.a.a.u.k.a aVar) {
        return new r(fVar, aVar, this);
    }

    public LineCapType b() {
        return this.f1608g;
    }

    public d.a.a.u.i.a c() {
        return this.f1605d;
    }

    public d.a.a.u.i.b d() {
        return this.f1603b;
    }

    public LineJoinType e() {
        return this.f1609h;
    }

    public List<d.a.a.u.i.b> f() {
        return this.f1604c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.f1602a;
    }

    public d i() {
        return this.f1606e;
    }

    public d.a.a.u.i.b j() {
        return this.f1607f;
    }

    public boolean k() {
        return this.j;
    }
}
