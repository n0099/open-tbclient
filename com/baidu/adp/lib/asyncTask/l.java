package com.baidu.adp.lib.asyncTask;

import android.util.SparseIntArray;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {
    SparseIntArray a;
    final /* synthetic */ g b;

    public l(g gVar, LinkedList<k> linkedList) {
        this.b = gVar;
        this.a = null;
        if (linkedList != null) {
            this.a = new SparseIntArray();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                k kVar = linkedList.get(i);
                this.a.put(kVar.f(), this.a.get(kVar.f(), 0) + 1);
            }
        }
    }

    public boolean a(k kVar) {
        int i;
        if (kVar == null) {
            return false;
        }
        if (this.a != null && (i = this.a.get(kVar.f(), 0)) != 0) {
            return kVar.h() == BdAsyncTaskParallelType.SERIAL ? i < 1 : kVar.h() == BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : kVar.h() == BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : kVar.h() != BdAsyncTaskParallelType.FOUR_PARALLEL || i < 4;
        }
        return true;
    }
}
