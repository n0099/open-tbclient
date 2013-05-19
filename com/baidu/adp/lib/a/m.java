package com.baidu.adp.lib.a;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    int a;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    final /* synthetic */ h f;

    public m(h hVar, LinkedList linkedList) {
        int i = 0;
        this.f = hVar;
        this.a = 0;
        if (linkedList != null) {
            this.a = linkedList.size();
            while (true) {
                int i2 = i;
                if (i2 < this.a) {
                    l lVar = (l) linkedList.get(i2);
                    if (lVar.g() == o.SERIAL) {
                        this.b++;
                    } else if (lVar.g() == o.TWO_PARALLEL) {
                        this.c++;
                    } else if (lVar.g() == o.THREE_PARALLEL) {
                        this.d++;
                    } else if (lVar.g() == o.FOUR_PARALLEL) {
                        this.e++;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        return lVar.g() == o.SERIAL ? this.b < 1 : lVar.g() == o.TWO_PARALLEL ? this.c < 2 : lVar.g() == o.THREE_PARALLEL ? this.d < 3 : lVar.g() != o.FOUR_PARALLEL || this.e < 4;
    }
}
