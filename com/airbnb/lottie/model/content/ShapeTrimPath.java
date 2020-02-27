package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type gC;
    private final com.airbnb.lottie.model.a.b iG;
    private final com.airbnb.lottie.model.a.b iO;
    private final com.airbnb.lottie.model.a.b iP;
    private final String name;

    /* loaded from: classes6.dex */
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
        this.gC = type;
        this.iO = bVar;
        this.iP = bVar2;
        this.iG = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type bN() {
        return this.gC;
    }

    public com.airbnb.lottie.model.a.b db() {
        return this.iP;
    }

    public com.airbnb.lottie.model.a.b dc() {
        return this.iO;
    }

    public com.airbnb.lottie.model.a.b cV() {
        return this.iG;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.iO + ", end: " + this.iP + ", offset: " + this.iG + "}";
    }
}
