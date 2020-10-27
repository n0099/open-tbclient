package com.baidu.afd.videopaster.b;

import android.support.annotation.NonNull;
/* loaded from: classes21.dex */
public class b {
    public void e(@NonNull a aVar) {
        aVar.ZM = 3;
        com.baidu.afd.videopaster.b.a(aVar);
        if (n(aVar)) {
            aVar.ZM = 31;
            com.baidu.afd.videopaster.b.c(aVar);
        }
    }

    public void f(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.ZM = 32;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void g(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.ZM = 33;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void h(@NonNull a aVar) {
        if (n(aVar)) {
            aVar.ZM = 34;
            com.baidu.afd.videopaster.b.d(aVar);
        }
    }

    public void i(@NonNull a aVar) {
        aVar.ZM = 5;
        com.baidu.afd.videopaster.b.b(aVar);
    }

    public void j(@NonNull a aVar) {
        aVar.ZM = 2;
        com.baidu.afd.videopaster.b.a(aVar, "image");
    }

    public void k(@NonNull a aVar) {
        aVar.ZM = 2;
        com.baidu.afd.videopaster.b.a(aVar, "title");
    }

    public void l(@NonNull a aVar) {
        aVar.ZM = 2;
        com.baidu.afd.videopaster.b.a(aVar, "button");
    }

    public void b(@NonNull a aVar, int i) {
        aVar.ZM = 7;
        com.baidu.afd.videopaster.b.a(aVar, i);
    }

    public void m(@NonNull a aVar) {
    }

    public void c(@NonNull a aVar, String str) {
        com.baidu.afd.videopaster.b.b(aVar, str);
    }

    private boolean n(@NonNull a aVar) {
        return aVar.ZU == 1;
    }
}
