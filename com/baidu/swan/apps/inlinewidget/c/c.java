package com.baidu.swan.apps.inlinewidget.c;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/removeComponentFromFullScreenSync");
    }

    @Override // com.baidu.swan.apps.inlinewidget.c.b
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final com.baidu.swan.apps.inlinewidget.e.b bVar, @NonNull final List<String> list) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    bVar.pe(str);
                }
            }
        });
        return true;
    }
}
