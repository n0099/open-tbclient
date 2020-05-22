package com.baidu.swan.apps.p.b;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // com.baidu.swan.apps.p.b.b
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final com.baidu.swan.apps.p.d.a aVar, @NonNull final List<String> list) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.p.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    aVar.kx(str);
                }
            }
        });
        return true;
    }
}
