package com.baidu.android.nebula.a;

import java.io.Serializable;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Serializable, Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f555a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(a aVar, a aVar2) {
        return aVar.b().compareToIgnoreCase(aVar2.b());
    }
}
