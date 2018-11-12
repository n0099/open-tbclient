package com.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class d extends f<com.airbnb.lottie.model.content.c> {
    private final com.airbnb.lottie.model.content.c pG;

    public d(List<? extends com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.c>> list) {
        super(list);
        com.airbnb.lottie.model.content.c cVar = list.get(0).on;
        int size = cVar == null ? 0 : cVar.getSize();
        this.pG = new com.airbnb.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: d */
    public com.airbnb.lottie.model.content.c a(com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.c> aVar, float f) {
        this.pG.a(aVar.on, aVar.oo, f);
        return this.pG;
    }
}
