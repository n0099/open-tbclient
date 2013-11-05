package android.support.v4.view.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class j implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f327a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, g gVar) {
        this.b = iVar;
        this.f327a = gVar;
    }

    @Override // android.support.v4.view.a.n
    public boolean a(int i, int i2, Bundle bundle) {
        return this.f327a.a(i, i2, bundle);
    }

    @Override // android.support.v4.view.a.n
    public List<Object> a(String str, int i) {
        List<a> a2 = this.f327a.a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(a2.get(i2).a());
        }
        return arrayList;
    }

    @Override // android.support.v4.view.a.n
    public Object a(int i) {
        a a2 = this.f327a.a(i);
        if (a2 == null) {
            return null;
        }
        return a2.a();
    }
}
