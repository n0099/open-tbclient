package com.baidu.adp.lib.asyncTask;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {
    int a;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    final /* synthetic */ g f;

    public l(g gVar, LinkedList<k> linkedList) {
        int i = 0;
        this.f = gVar;
        this.a = 0;
        if (linkedList != null) {
            this.a = linkedList.size();
            while (true) {
                int i2 = i;
                if (i2 < this.a) {
                    k kVar = linkedList.get(i2);
                    if (kVar.g() == BdAsyncTaskType.SERIAL) {
                        this.b++;
                    } else if (kVar.g() == BdAsyncTaskType.TWO_PARALLEL) {
                        this.c++;
                    } else if (kVar.g() == BdAsyncTaskType.THREE_PARALLEL) {
                        this.d++;
                    } else if (kVar.g() == BdAsyncTaskType.FOUR_PARALLEL) {
                        this.e++;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a(k kVar) {
        if (kVar == null) {
            return false;
        }
        return kVar.g() == BdAsyncTaskType.SERIAL ? this.b < 1 : kVar.g() == BdAsyncTaskType.TWO_PARALLEL ? this.c < 2 : kVar.g() == BdAsyncTaskType.THREE_PARALLEL ? this.d < 3 : kVar.g() != BdAsyncTaskType.FOUR_PARALLEL || this.e < 4;
    }
}
