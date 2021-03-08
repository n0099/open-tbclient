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
    public static final JSONArray aDv() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO != null) {
            String string = aIO.aIZ().getString("note_data_pay_check_list", "");
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
        final /* synthetic */ kotlin.jvm.a.b dbI;
        final /* synthetic */ String dri;

        a(kotlin.jvm.a.b bVar, String str) {
            this.dbI = bVar;
            this.dri = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aDo() {
            JSONArray aDv = d.aDv();
            if (aDv == null || aDv.length() == 0) {
                kotlin.jvm.a.b bVar = this.dbI;
                if (bVar != null) {
                    h hVar = (h) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = aDv.length();
            for (int i = 0; i < length; i++) {
                if (p.l(this.dri, aDv.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.dbI;
                    if (bVar2 != null) {
                        h hVar2 = (h) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.dbI;
            if (bVar3 != null) {
                h hVar3 = (h) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, h> bVar) {
        com.baidu.swan.apps.network.c.a.aDl().a(new a(bVar, str));
    }
}
