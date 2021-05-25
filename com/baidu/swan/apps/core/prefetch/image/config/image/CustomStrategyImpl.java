package com.baidu.swan.apps.core.prefetch.image.config.image;

import androidx.annotation.NonNull;
import d.a.l0.a.h0.o.h.d.b.a;
import d.a.l0.a.h0.o.h.g.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CustomStrategyImpl implements a {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f10738a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.CustomStrategyImpl.1
        {
            add("intercepthttp");
            add("intercepthttps");
        }
    };

    @Override // d.a.l0.a.h0.o.h.d.b.a
    public boolean a(@NonNull g gVar) {
        String d2 = gVar.d();
        for (String str : this.f10738a) {
            if (d2.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "CustomStrategyImpl";
    }
}
