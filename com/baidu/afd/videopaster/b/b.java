package com.baidu.afd.videopaster.b;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class b {
    public void e(@NonNull a aVar) {
        aVar.acO = 3;
        com.baidu.afd.videopaster.b.a(aVar);
        if (n(aVar)) {
            aVar.acO = 31;
            com.baidu.afd.videopaster.b.c(aVar);
        }
    }

    public void f(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.acO = 32;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void g(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.acO = 33;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void h(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.acO = 34;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void i(@NonNull a aVar) {
        aVar.acO = 5;
        com.baidu.afd.videopaster.b.b(aVar);
    }

    public void j(@NonNull a aVar) {
        aVar.acO = 2;
        com.baidu.afd.videopaster.b.a(aVar, "image");
    }

    public void k(@NonNull a aVar) {
        aVar.acO = 2;
        com.baidu.afd.videopaster.b.a(aVar, "title");
    }

    public void l(@NonNull a aVar) {
        aVar.acO = 2;
        com.baidu.afd.videopaster.b.a(aVar, "button");
    }

    public void d(@NonNull a aVar, int i) {
        aVar.acO = 7;
        com.baidu.afd.videopaster.b.a(aVar, i);
    }

    public void m(@NonNull a aVar) {
    }

    public void e(@NonNull a aVar, int i) {
        com.baidu.afd.videopaster.b.b(aVar, i);
    }

    private boolean n(@NonNull a aVar) {
        return aVar.acV == 1;
    }
}
