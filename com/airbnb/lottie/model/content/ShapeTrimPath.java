package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes4.dex */
public class ShapeTrimPath implements b {
    private final Type gy;
    private final com.airbnb.lottie.model.a.b iD;
    private final com.airbnb.lottie.model.a.b iL;
    private final com.airbnb.lottie.model.a.b iM;
    private final String name;

    /* loaded from: classes4.dex */
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
        this.gy = type;
        this.iL = bVar;
        this.iM = bVar2;
        this.iD = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type bM() {
        return this.gy;
    }

    public com.airbnb.lottie.model.a.b da() {
        return this.iM;
    }

    public com.airbnb.lottie.model.a.b db() {
        return this.iL;
    }

    public com.airbnb.lottie.model.a.b cU() {
        return this.iD;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.iL + ", end: " + this.iM + ", offset: " + this.iD + "}";
    }
}
