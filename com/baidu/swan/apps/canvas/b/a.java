package com.baidu.swan.apps.canvas.b;

import android.text.TextUtils;
import com.baidu.swan.apps.b.c.c;
import com.baidu.swan.apps.canvas.c.g;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public abstract class a {
    public g a(com.baidu.swan.apps.canvas.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.aXH;
        String str2 = aVar.id;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        c cVar = (c) e.LD().eH(aVar.aXH);
        return cVar != null ? cVar.dO(aVar.id) : null;
    }

    public CanvasView b(com.baidu.swan.apps.canvas.c.a aVar) {
        g a = a(aVar);
        if (a == null) {
            return null;
        }
        return a.aHf;
    }
}
