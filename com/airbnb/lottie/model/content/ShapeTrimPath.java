package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes16.dex */
public class ShapeTrimPath implements b {
    private final Type DI;
    private final com.airbnb.lottie.model.a.b FB;
    private final com.airbnb.lottie.model.a.b FJ;
    private final com.airbnb.lottie.model.a.b FK;
    private final String name;

    /* loaded from: classes16.dex */
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
        this.DI = type;
        this.FJ = bVar;
        this.FK = bVar2;
        this.FB = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type jd() {
        return this.DI;
    }

    public com.airbnb.lottie.model.a.b kr() {
        return this.FK;
    }

    public com.airbnb.lottie.model.a.b ks() {
        return this.FJ;
    }

    public com.airbnb.lottie.model.a.b kl() {
        return this.FB;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.FJ + ", end: " + this.FK + ", offset: " + this.FB + "}";
    }
}
