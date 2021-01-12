package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes3.dex */
public class ShapeTrimPath implements b {
    private final Type En;
    private final com.airbnb.lottie.model.a.b Ge;
    private final com.airbnb.lottie.model.a.b Gm;
    private final com.airbnb.lottie.model.a.b Gn;
    private final String name;

    /* loaded from: classes3.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    public ShapeTrimPath(String str, Type type, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, com.airbnb.lottie.model.a.b bVar3) {
        this.name = str;
        this.En = type;
        this.Gm = bVar;
        this.Gn = bVar2;
        this.Ge = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type iC() {
        return this.En;
    }

    public com.airbnb.lottie.model.a.b jQ() {
        return this.Gn;
    }

    public com.airbnb.lottie.model.a.b jR() {
        return this.Gm;
    }

    public com.airbnb.lottie.model.a.b jK() {
        return this.Ge;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.Gm + ", end: " + this.Gn + ", offset: " + this.Ge + "}";
    }
}
