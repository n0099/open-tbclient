package com.baidu.prologue.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class h extends e {
    private static HashMap<String, String> redirectSchemes = new HashMap<>();
    private static HashMap<String, e> mDynamicDispatchers = new HashMap<>();

    public static h acn() {
        return a.chr;
    }

    /* loaded from: classes14.dex */
    private static class a {
        private static final h chr = new h();
    }

    private h() {
    }

    @Override // com.baidu.prologue.c.e
    public boolean a(Context context, g gVar, com.baidu.prologue.c.a aVar) {
        e eVar;
        String allPath = gVar.getAllPath();
        if (redirectSchemes.get(allPath) != null) {
            gVar.replaceAllPath(allPath, redirectSchemes.get(allPath));
        }
        String path = gVar.getPath(true);
        if (!TextUtils.isEmpty(path) && (eVar = mDynamicDispatchers.get(path)) != null) {
            return eVar.a(context, gVar, aVar);
        }
        return false;
    }

    @Override // com.baidu.prologue.c.e
    public boolean c(Context context, g gVar, com.baidu.prologue.c.a aVar) {
        gVar.result = j.wrapCallbackParams(302);
        return false;
    }

    public void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            mDynamicDispatchers.put(str, eVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null) {
            eVar.addRedirectScheme(redirectSchemes);
        }
    }
}
