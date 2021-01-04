package com.baidu.live.lottie.a.b;

import java.util.List;
/* loaded from: classes10.dex */
public class d extends f<com.baidu.live.lottie.model.content.c> {
    private final com.baidu.live.lottie.model.content.c buj;

    public d(List<com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.c>> list) {
        super(list);
        com.baidu.live.lottie.model.content.c cVar = list.get(0).HN;
        int size = cVar == null ? 0 : cVar.getSize();
        this.buj = new com.baidu.live.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: d */
    public com.baidu.live.lottie.model.content.c a(com.baidu.live.lottie.e.a<com.baidu.live.lottie.model.content.c> aVar, float f) {
        this.buj.a(aVar.HN, aVar.HO, f);
        return this.buj;
    }
}
