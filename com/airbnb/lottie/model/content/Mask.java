package com.airbnb.lottie.model.content;

import d.a.a.u.i.d;
import d.a.a.u.i.h;
/* loaded from: classes.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f1587a;

    /* renamed from: b  reason: collision with root package name */
    public final h f1588b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1589c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1590d;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z) {
        this.f1587a = maskMode;
        this.f1588b = hVar;
        this.f1589c = dVar;
        this.f1590d = z;
    }

    public MaskMode a() {
        return this.f1587a;
    }

    public h b() {
        return this.f1588b;
    }

    public d c() {
        return this.f1589c;
    }

    public boolean d() {
        return this.f1590d;
    }
}
