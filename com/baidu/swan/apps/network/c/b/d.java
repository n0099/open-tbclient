package com.baidu.swan.apps.network.c.b;

import com.baidu.swan.apps.runtime.e;
import kotlin.g;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray WB() {
        e ZT = e.ZT();
        if (ZT != null) {
            String string = ZT.aac().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    /* loaded from: classes9.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b bCc;
        final /* synthetic */ String bCd;

        a(kotlin.jvm.a.b bVar, String str) {
            this.bCc = bVar;
            this.bCd = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void Ws() {
            JSONArray WB = d.WB();
            if (WB == null || WB.length() == 0) {
                kotlin.jvm.a.b bVar = this.bCc;
                if (bVar != null) {
                    g gVar = (g) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = WB.length();
            for (int i = 0; i < length; i++) {
                if (p.h(this.bCd, WB.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.bCc;
                    if (bVar2 != null) {
                        g gVar2 = (g) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.bCc;
            if (bVar3 != null) {
                g gVar3 = (g) bVar3.invoke(false);
            }
        }
    }

    public static final void a(String str, kotlin.jvm.a.b<? super Boolean, g> bVar) {
        com.baidu.swan.apps.network.c.a.Wo().a(new a(bVar, str));
    }
}
