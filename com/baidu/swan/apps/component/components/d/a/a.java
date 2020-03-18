package com.baidu.swan.apps.component.components.d.a;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    @Nullable
    public static CanvasView a(com.baidu.swan.apps.canvas.b.a aVar) {
        com.baidu.swan.apps.component.components.d.a aVar2 = (com.baidu.swan.apps.component.components.d.a) com.baidu.swan.apps.component.container.a.d(aVar);
        if (aVar2 == null) {
            c.e("Component-Canvas-Utils", "get canvas view fail: find a null component");
            return null;
        }
        return aVar2.biJ;
    }
}
