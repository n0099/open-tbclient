package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type CE;
    private final com.airbnb.lottie.model.a.b EF;
    private final com.airbnb.lottie.model.a.b EN;
    private final com.airbnb.lottie.model.a.b EO;
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
        this.CE = type;
        this.EN = bVar;
        this.EO = bVar2;
        this.EF = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type hA() {
        return this.CE;
    }

    public com.airbnb.lottie.model.a.b iQ() {
        return this.EO;
    }

    public com.airbnb.lottie.model.a.b iR() {
        return this.EN;
    }

    public com.airbnb.lottie.model.a.b iK() {
        return this.EF;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.EN + ", end: " + this.EO + ", offset: " + this.EF + "}";
    }
}
