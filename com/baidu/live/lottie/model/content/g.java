package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.o;
import com.baidu.live.lottie.model.a.l;
/* loaded from: classes10.dex */
public class g implements b {
    private final com.baidu.live.lottie.model.a.b btW;
    private final com.baidu.live.lottie.model.a.b btX;
    private final l btY;
    private final String name;

    public g(String str, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.btW = bVar;
        this.btX = bVar2;
        this.btY = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b NV() {
        return this.btW;
    }

    public com.baidu.live.lottie.model.a.b NW() {
        return this.btX;
    }

    public l NX() {
        return this.btY;
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new o(hVar, aVar, this);
    }
}
