package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.o;
import com.baidu.live.lottie.model.a.l;
/* loaded from: classes9.dex */
public class g implements b {
    private final com.baidu.live.lottie.model.a.b bqu;
    private final com.baidu.live.lottie.model.a.b bqv;
    private final l bqw;
    private final String name;

    public g(String str, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.bqu = bVar;
        this.bqv = bVar2;
        this.bqw = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b Mx() {
        return this.bqu;
    }

    public com.baidu.live.lottie.model.a.b My() {
        return this.bqv;
    }

    public l Mz() {
        return this.bqw;
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new o(hVar, aVar, this);
    }
}
