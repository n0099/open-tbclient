package com.baidu.swan.apps.network.c.b;

import kotlin.e;
import kotlin.h;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@e
/* loaded from: classes9.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray aDs() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL != null) {
            String string = aIL.aIW().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @e
    /* loaded from: classes9.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b daf;
        final /* synthetic */ String dpH;

        a(kotlin.jvm.a.b bVar, String str) {
            this.daf = bVar;
            this.dpH = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aDl() {
            JSONArray aDs = d.aDs();
            if (aDs == null || aDs.length() == 0) {
                kotlin.jvm.a.b bVar = this.daf;
                if (bVar != null) {
                    h hVar = (h) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = aDs.length();
            for (int i = 0; i < length; i++) {
                if (p.l(this.dpH, aDs.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.daf;
                    if (bVar2 != null) {
                        h hVar2 = (h) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.daf;
            if (bVar3 != null) {
                h hVar3 = (h) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, h> bVar) {
        com.baidu.swan.apps.network.c.a.aDi().a(new a(bVar, str));
    }
}
