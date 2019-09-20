package com.baidu.swan.apps.view.container.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class b {
    public static SwanAppNAViewContainer a(com.baidu.swan.apps.model.a.a.a aVar, @Nullable com.baidu.swan.apps.view.container.a aVar2) {
        if (aVar == null) {
            return null;
        }
        return a(aVar.aEs, aVar.id, aVar2);
    }

    public static SwanAppNAViewContainer a(String str, String str2, @Nullable com.baidu.swan.apps.view.container.a aVar) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (aVar == null) {
            aVar = c.iF(str);
        }
        if (aVar == null) {
            return null;
        }
        com.baidu.swan.apps.view.container.a.a Ql = aVar.Ql();
        if (Ql == null || Ql.Qo() == null) {
            return null;
        }
        for (View view : Ql.Qo()) {
            if (view instanceof SwanAppNAViewContainer) {
                SwanAppNAViewContainer swanAppNAViewContainer = (SwanAppNAViewContainer) view;
                if (TextUtils.equals(swanAppNAViewContainer.getViewId(), str2)) {
                    return swanAppNAViewContainer;
                }
            }
        }
        return null;
    }
}
