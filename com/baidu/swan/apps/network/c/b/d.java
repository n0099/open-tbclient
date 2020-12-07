package com.baidu.swan.apps.network.c.b;

import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@e
/* loaded from: classes25.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray aFv() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV != null) {
            String string = aJV.aKg().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @e
    /* loaded from: classes25.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b cXP;
        final /* synthetic */ String dnk;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cXP = bVar;
            this.dnk = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aFo() {
            JSONArray aFv = d.aFv();
            if (aFv == null || aFv.length() == 0) {
                kotlin.jvm.a.b bVar = this.cXP;
                if (bVar != null) {
                    h hVar = (h) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = aFv.length();
            for (int i = 0; i < length; i++) {
                if (p.l(this.dnk, aFv.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cXP;
                    if (bVar2 != null) {
                        h hVar2 = (h) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cXP;
            if (bVar3 != null) {
                h hVar3 = (h) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, h> bVar) {
        com.baidu.swan.apps.network.c.a.aFl().a(new a(bVar, str));
    }
}
