package com.baidu.live.lottie.model.content;

import com.baidu.live.lottie.a.a.r;
/* loaded from: classes10.dex */
public class ShapeTrimPath implements b {
    private final Type bsQ;
    private final com.baidu.live.lottie.model.a.b btX;
    private final com.baidu.live.lottie.model.a.b bua;
    private final com.baidu.live.lottie.model.a.b bub;
    private final String name;

    /* loaded from: classes10.dex */
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
        this.bsQ = type;
        this.bua = bVar;
        this.bub = bVar2;
        this.btX = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type Ni() {
        return this.bsQ;
    }

    public com.baidu.live.lottie.model.a.b Oa() {
        return this.bub;
    }

    public com.baidu.live.lottie.model.a.b Ob() {
        return this.bua;
    }

    public com.baidu.live.lottie.model.a.b NW() {
        return this.btX;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.bua + ", end: " + this.bub + ", offset: " + this.btX + "}";
    }
}
