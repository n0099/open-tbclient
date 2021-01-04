package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.o;
import com.baidu.live.lottie.model.a.l;
/* loaded from: classes10.dex */
public class g implements b {
    private final com.baidu.live.lottie.model.a.b bvi;
    private final com.baidu.live.lottie.model.a.b bvj;
    private final l bvk;
    private final String name;

    public g(String str, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.bvi = bVar;
        this.bvj = bVar2;
        this.bvk = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b Qs() {
        return this.bvi;
    }

    public com.baidu.live.lottie.model.a.b Qt() {
        return this.bvj;
    }

    public l Qu() {
        return this.bvk;
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new o(hVar, aVar, this);
    }
}
