package com.baidu.swan.support.v4.c;

import android.view.LayoutInflater;
import com.baidu.swan.support.v4.c.c;
/* loaded from: classes16.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory2(eVar != null ? new c.a(eVar) : null);
    }
}
