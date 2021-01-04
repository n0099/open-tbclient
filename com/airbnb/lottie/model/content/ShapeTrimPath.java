package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes3.dex */
public class ShapeTrimPath implements b {
    private final Type Ep;
    private final com.airbnb.lottie.model.a.b Gg;
    private final com.airbnb.lottie.model.a.b Go;
    private final com.airbnb.lottie.model.a.b Gp;
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
        this.Ep = type;
        this.Go = bVar;
        this.Gp = bVar2;
        this.Gg = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type iC() {
        return this.Ep;
    }

    public com.airbnb.lottie.model.a.b jQ() {
        return this.Gp;
    }

    public com.airbnb.lottie.model.a.b jR() {
        return this.Go;
    }

    public com.airbnb.lottie.model.a.b jK() {
        return this.Gg;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.Go + ", end: " + this.Gp + ", offset: " + this.Gg + "}";
    }
}
