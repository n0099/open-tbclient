package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class d extends f<com.airbnb.lottie.model.content.c> {
    private final com.airbnb.lottie.model.content.c CN;

    public d(List<com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.c>> list) {
        super(list);
        com.airbnb.lottie.model.content.c cVar = list.get(0).Gp;
        int size = cVar == null ? 0 : cVar.getSize();
        this.CN = new com.airbnb.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: d */
    public com.airbnb.lottie.model.content.c a(com.airbnb.lottie.e.a<com.airbnb.lottie.model.content.c> aVar, float f) {
        this.CN.a(aVar.Gp, aVar.Gq, f);
        return this.CN;
    }
}
