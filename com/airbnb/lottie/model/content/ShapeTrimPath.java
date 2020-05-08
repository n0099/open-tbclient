package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type Cd;
    private final com.airbnb.lottie.model.a.b Ee;
    private final com.airbnb.lottie.model.a.b Em;
    private final com.airbnb.lottie.model.a.b En;
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
        this.Cd = type;
        this.Em = bVar;
        this.En = bVar2;
        this.Ee = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type hk() {
        return this.Cd;
    }

    public com.airbnb.lottie.model.a.b iA() {
        return this.En;
    }

    public com.airbnb.lottie.model.a.b iB() {
        return this.Em;
    }

    public com.airbnb.lottie.model.a.b iu() {
        return this.Ee;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.Em + ", end: " + this.En + ", offset: " + this.Ee + "}";
    }
}
