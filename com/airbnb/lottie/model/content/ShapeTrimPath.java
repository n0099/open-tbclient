package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes7.dex */
public class ShapeTrimPath implements b {
    private final Type EA;
    private final com.airbnb.lottie.model.a.b GC;
    private final com.airbnb.lottie.model.a.b GD;
    private final com.airbnb.lottie.model.a.b Gt;
    private final String name;

    /* loaded from: classes7.dex */
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
        this.EA = type;
        this.GC = bVar;
        this.GD = bVar2;
        this.Gt = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type jd() {
        return this.EA;
    }

    public com.airbnb.lottie.model.a.b kr() {
        return this.GD;
    }

    public com.airbnb.lottie.model.a.b ks() {
        return this.GC;
    }

    public com.airbnb.lottie.model.a.b kl() {
        return this.Gt;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.GC + ", end: " + this.GD + ", offset: " + this.Gt + "}";
    }
}
