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
    public static final JSONArray aGQ() {
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm != null) {
            String string = aMm.aMx().getString("note_data_pay_check_list", "");
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
        final /* synthetic */ kotlin.jvm.a.b dcK;
        final /* synthetic */ String dsk;

        a(kotlin.jvm.a.b bVar, String str) {
            this.dcK = bVar;
            this.dsk = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aGJ() {
            JSONArray aGQ = d.aGQ();
            if (aGQ == null || aGQ.length() == 0) {
                kotlin.jvm.a.b bVar = this.dcK;
                if (bVar != null) {
                    h hVar = (h) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = aGQ.length();
            for (int i = 0; i < length; i++) {
                if (p.l(this.dsk, aGQ.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.dcK;
                    if (bVar2 != null) {
                        h hVar2 = (h) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.dcK;
            if (bVar3 != null) {
                h hVar3 = (h) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, h> bVar) {
        com.baidu.swan.apps.network.c.a.aGG().a(new a(bVar, str));
    }
}
