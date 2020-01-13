package com.baidu.swan.apps.r.b;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/removeComponentFromFullScreenSync");
    }

    @Override // com.baidu.swan.apps.r.b.b
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final com.baidu.swan.apps.r.d.a aVar, @NonNull final List<String> list) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    aVar.hO(str);
                }
            }
        });
        return true;
    }
}
