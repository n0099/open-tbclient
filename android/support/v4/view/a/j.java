package android.support.v4.view.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class j implements n {
    final /* synthetic */ g a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, g gVar) {
        this.b = iVar;
        this.a = gVar;
    }

    @Override // android.support.v4.view.a.n
    public boolean a(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }

    @Override // android.support.v4.view.a.n
    public List<Object> a(String str, int i) {
        List<a> a = this.a.a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(a.get(i2).a());
        }
        return arrayList;
    }

    @Override // android.support.v4.view.a.n
    public Object a(int i) {
        a a = this.a.a(i);
        if (a == null) {
            return null;
        }
        return a.a();
    }
}
