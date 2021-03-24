package com.airbnb.lottie.model.content;

import d.a.a.s.i.d;
import d.a.a.s.i.h;
/* loaded from: classes.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f1588a;

    /* renamed from: b  reason: collision with root package name */
    public final h f1589b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1590c;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, h hVar, d dVar) {
        this.f1588a = maskMode;
        this.f1589b = hVar;
        this.f1590c = dVar;
    }

    public MaskMode a() {
        return this.f1588a;
    }

    public h b() {
        return this.f1589b;
    }

    public d c() {
        return this.f1590c;
    }
}
