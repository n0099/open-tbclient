package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {
    private final Type FG;
    private final com.airbnb.lottie.model.a.b HA;
    private final com.airbnb.lottie.model.a.b HI;
    private final com.airbnb.lottie.model.a.b HJ;
    private final String name;

    /* loaded from: classes5.dex */
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
        this.FG = type;
        this.HI = bVar;
        this.HJ = bVar2;
        this.HA = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type iB() {
        return this.FG;
    }

    public com.airbnb.lottie.model.a.b jP() {
        return this.HJ;
    }

    public com.airbnb.lottie.model.a.b jQ() {
        return this.HI;
    }

    public com.airbnb.lottie.model.a.b jJ() {
        return this.HA;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.HI + ", end: " + this.HJ + ", offset: " + this.HA + "}";
    }
}
