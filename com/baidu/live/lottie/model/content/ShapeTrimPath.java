package com.baidu.live.lottie.model.content;

import com.baidu.live.lottie.a.a.r;
/* loaded from: classes9.dex */
public class ShapeTrimPath implements b {
    private final Type bpp;
    private final com.baidu.live.lottie.model.a.b bqv;
    private final com.baidu.live.lottie.model.a.b bqy;
    private final com.baidu.live.lottie.model.a.b bqz;
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
        this.bpp = type;
        this.bqy = bVar;
        this.bqz = bVar2;
        this.bqv = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type LK() {
        return this.bpp;
    }

    public com.baidu.live.lottie.model.a.b MC() {
        return this.bqz;
    }

    public com.baidu.live.lottie.model.a.b MD() {
        return this.bqy;
    }

    public com.baidu.live.lottie.model.a.b My() {
        return this.bqv;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.bqy + ", end: " + this.bqz + ", offset: " + this.bqv + "}";
    }
}
