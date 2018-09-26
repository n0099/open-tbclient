package cn.jiguang.d.d;

import java.util.Comparator;
/* loaded from: classes3.dex */
final class x implements Comparator<q> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(q qVar, q qVar2) {
        return (int) (qVar.c().lastModified() - qVar2.c().lastModified());
    }
}
