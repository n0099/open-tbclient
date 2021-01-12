package com.baidu.swan.apps.network.c.b;

import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@e
/* loaded from: classes8.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray aCW() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs != null) {
            String string = aIs.aID().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @e
    /* loaded from: classes8.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b cXV;
        final /* synthetic */ String dnu;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cXV = bVar;
            this.dnu = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aCP() {
            JSONArray aCW = d.aCW();
            if (aCW == null || aCW.length() == 0) {
                kotlin.jvm.a.b bVar = this.cXV;
                if (bVar != null) {
                    h hVar = (h) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = aCW.length();
            for (int i = 0; i < length; i++) {
                if (p.l(this.dnu, aCW.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cXV;
                    if (bVar2 != null) {
                        h hVar2 = (h) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cXV;
            if (bVar3 != null) {
                h hVar3 = (h) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, h> bVar) {
        com.baidu.swan.apps.network.c.a.aCM().a(new a(bVar, str));
    }
}
