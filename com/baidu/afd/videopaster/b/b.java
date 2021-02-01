package com.baidu.afd.videopaster.b;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class b {
    public void e(@NonNull a aVar) {
        aVar.abr = 3;
        com.baidu.afd.videopaster.b.a(aVar);
        if (n(aVar)) {
            aVar.abr = 31;
            com.baidu.afd.videopaster.b.c(aVar);
        }
    }

    public void f(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.abr = 32;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void g(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.abr = 33;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void h(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.abr = 34;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void i(@NonNull a aVar) {
        aVar.abr = 5;
        com.baidu.afd.videopaster.b.b(aVar);
    }

    public void j(@NonNull a aVar) {
        aVar.abr = 2;
        com.baidu.afd.videopaster.b.a(aVar, "image");
    }

    public void k(@NonNull a aVar) {
        aVar.abr = 2;
        com.baidu.afd.videopaster.b.a(aVar, "title");
    }

    public void l(@NonNull a aVar) {
        aVar.abr = 2;
        com.baidu.afd.videopaster.b.a(aVar, "button");
    }

    public void d(@NonNull a aVar, int i) {
        aVar.abr = 7;
        com.baidu.afd.videopaster.b.a(aVar, i);
    }

    public void m(@NonNull a aVar) {
    }

    public void e(@NonNull a aVar, int i) {
        com.baidu.afd.videopaster.b.b(aVar, i);
    }

    private boolean n(@NonNull a aVar) {
        return aVar.abz == 1;
    }
}
