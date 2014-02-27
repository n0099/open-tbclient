package com.baidu.adp.lib.asyncTask;

import android.util.SparseIntArray;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {
    SparseIntArray a;
    final /* synthetic */ f b;

    public k(f fVar, LinkedList<j> linkedList) {
        this.b = fVar;
        this.a = null;
        if (linkedList != null) {
            this.a = new SparseIntArray();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                j jVar = linkedList.get(i);
                this.a.put(jVar.h(), this.a.get(jVar.h(), 0) + 1);
            }
        }
    }

    public final boolean a(j jVar) {
        int i;
        if (jVar == null) {
            return false;
        }
        if (this.a != null && (i = this.a.get(jVar.h(), 0)) != 0) {
            return jVar.j() == BdAsyncTaskParallelType.SERIAL ? i <= 0 : jVar.j() == BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : jVar.j() == BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : jVar.j() != BdAsyncTaskParallelType.FOUR_PARALLEL || i < 4;
        }
        return true;
    }
}
