package com.baidu.swan.apps.network.c.b;

import com.baidu.swan.apps.runtime.e;
import kotlin.jvm.internal.q;
import kotlin.k;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray WY() {
        e aaq = e.aaq();
        if (aaq != null) {
            String string = aaq.aaz().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    /* loaded from: classes10.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b bCO;
        final /* synthetic */ String bCP;

        a(kotlin.jvm.a.b bVar, String str) {
            this.bCO = bVar;
            this.bCP = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void WP() {
            JSONArray WY = d.WY();
            if (WY == null || WY.length() == 0) {
                kotlin.jvm.a.b bVar = this.bCO;
                if (bVar != null) {
                    k kVar = (k) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = WY.length();
            for (int i = 0; i < length; i++) {
                if (q.h(this.bCP, WY.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.bCO;
                    if (bVar2 != null) {
                        k kVar2 = (k) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.bCO;
            if (bVar3 != null) {
                k kVar3 = (k) bVar3.invoke(false);
            }
        }
    }

    public static final void a(String str, kotlin.jvm.a.b<? super Boolean, k> bVar) {
        com.baidu.swan.apps.network.c.a.WL().a(new a(bVar, str));
    }
}
