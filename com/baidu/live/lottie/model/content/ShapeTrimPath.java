package com.baidu.live.lottie.model.content;

import com.baidu.live.lottie.a.a.r;
/* loaded from: classes10.dex */
public class ShapeTrimPath implements b {
    private final Type buc;
    private final com.baidu.live.lottie.model.a.b bvj;
    private final com.baidu.live.lottie.model.a.b bvm;
    private final com.baidu.live.lottie.model.a.b bvn;
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
        this.buc = type;
        this.bvm = bVar;
        this.bvn = bVar2;
        this.bvj = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type PF() {
        return this.buc;
    }

    public com.baidu.live.lottie.model.a.b Qx() {
        return this.bvn;
    }

    public com.baidu.live.lottie.model.a.b Qy() {
        return this.bvm;
    }

    public com.baidu.live.lottie.model.a.b Qt() {
        return this.bvj;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.bvm + ", end: " + this.bvn + ", offset: " + this.bvj + "}";
    }
}
