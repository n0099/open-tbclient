package com.baidu.android.nebula.b;

import java.io.Serializable;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Serializable, Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f531a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u uVar, u uVar2) {
        return uVar.b().compareToIgnoreCase(uVar2.b());
    }
}
