package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type gB;
    private final com.airbnb.lottie.model.a.b iF;
    private final com.airbnb.lottie.model.a.b iN;
    private final com.airbnb.lottie.model.a.b iO;
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
        this.gB = type;
        this.iN = bVar;
        this.iO = bVar2;
        this.iF = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type bN() {
        return this.gB;
    }

    public com.airbnb.lottie.model.a.b db() {
        return this.iO;
    }

    public com.airbnb.lottie.model.a.b dc() {
        return this.iN;
    }

    public com.airbnb.lottie.model.a.b cV() {
        return this.iF;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.iN + ", end: " + this.iO + ", offset: " + this.iF + "}";
    }
}
