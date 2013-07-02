package com.baidu.adp.lib.asyncTask;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    int a;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    final /* synthetic */ f f;

    public k(f fVar, LinkedList linkedList) {
        int i = 0;
        this.f = fVar;
        this.a = 0;
        if (linkedList != null) {
            this.a = linkedList.size();
            while (true) {
                int i2 = i;
                if (i2 < this.a) {
                    j jVar = (j) linkedList.get(i2);
                    if (jVar.g() == BdAsyncTaskType.SERIAL) {
                        this.b++;
                    } else if (jVar.g() == BdAsyncTaskType.TWO_PARALLEL) {
                        this.c++;
                    } else if (jVar.g() == BdAsyncTaskType.THREE_PARALLEL) {
                        this.d++;
                    } else if (jVar.g() == BdAsyncTaskType.FOUR_PARALLEL) {
                        this.e++;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        return jVar.g() == BdAsyncTaskType.SERIAL ? this.b < 1 : jVar.g() == BdAsyncTaskType.TWO_PARALLEL ? this.c < 2 : jVar.g() == BdAsyncTaskType.THREE_PARALLEL ? this.d < 3 : jVar.g() != BdAsyncTaskType.FOUR_PARALLEL || this.e < 4;
    }
}
