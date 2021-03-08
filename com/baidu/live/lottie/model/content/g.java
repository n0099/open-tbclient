package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.o;
import com.baidu.live.lottie.model.a.l;
/* loaded from: classes9.dex */
public class g implements b {
    private final com.baidu.live.lottie.model.a.b bvx;
    private final com.baidu.live.lottie.model.a.b bvy;
    private final l bvz;
    private final String name;

    public g(String str, com.baidu.live.lottie.model.a.b bVar, com.baidu.live.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.bvx = bVar;
        this.bvy = bVar2;
        this.bvz = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b NY() {
        return this.bvx;
    }

    public com.baidu.live.lottie.model.a.b NZ() {
        return this.bvy;
    }

    public l Oa() {
        return this.bvz;
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new o(hVar, aVar, this);
    }
}
