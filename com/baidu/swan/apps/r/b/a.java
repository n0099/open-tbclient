package com.baidu.swan.apps.r.b;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // com.baidu.swan.apps.r.b.b
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final com.baidu.swan.apps.r.d.a aVar, @NonNull final List<String> list) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.r.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    aVar.ib(str);
                }
            }
        });
        return true;
    }
}
