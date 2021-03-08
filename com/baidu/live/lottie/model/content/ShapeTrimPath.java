package com.baidu.live.lottie.model.content;

import com.baidu.live.lottie.a.a.r;
/* loaded from: classes9.dex */
public class ShapeTrimPath implements b {
    private final Type bus;
    private final com.baidu.live.lottie.model.a.b bvB;
    private final com.baidu.live.lottie.model.a.b bvC;
    private final com.baidu.live.lottie.model.a.b bvy;
    private final String name;

    /* loaded from: classes9.dex */
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

    public ShapeTrimPath(String str, Type type, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2, com.baidu.live.lottie.model.a.b bVar3) {
        this.name = str;
        this.bus = type;
        this.bvB = bVar;
        this.bvC = bVar2;
        this.bvy = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type Nl() {
        return this.bus;
    }

    public com.baidu.live.lottie.model.a.b Od() {
        return this.bvC;
    }

    public com.baidu.live.lottie.model.a.b Oe() {
        return this.bvB;
    }

    public com.baidu.live.lottie.model.a.b NZ() {
        return this.bvy;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.bvB + ", end: " + this.bvC + ", offset: " + this.bvy + "}";
    }
}
