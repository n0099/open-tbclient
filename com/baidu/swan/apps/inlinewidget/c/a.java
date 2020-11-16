package com.baidu.swan.apps.inlinewidget.c;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // com.baidu.swan.apps.inlinewidget.c.b
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final com.baidu.swan.apps.inlinewidget.e.b bVar, @NonNull final List<String> list) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : list) {
                    bVar.oD(str);
                }
            }
        });
        return true;
    }
}
