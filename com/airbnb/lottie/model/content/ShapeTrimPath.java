package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type Dp;
    private final com.airbnb.lottie.model.a.b Fk;
    private final com.airbnb.lottie.model.a.b Fs;
    private final com.airbnb.lottie.model.a.b Ft;
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
        this.Dp = type;
        this.Fs = bVar;
        this.Ft = bVar2;
        this.Fk = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type jc() {
        return this.Dp;
    }

    public com.airbnb.lottie.model.a.b kq() {
        return this.Ft;
    }

    public com.airbnb.lottie.model.a.b kr() {
        return this.Fs;
    }

    public com.airbnb.lottie.model.a.b kk() {
        return this.Fk;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.Fs + ", end: " + this.Ft + ", offset: " + this.Fk + "}";
    }
}
