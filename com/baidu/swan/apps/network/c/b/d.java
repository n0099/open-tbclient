package com.baidu.swan.apps.network.c.b;

import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes11.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray ahw() {
        e akO = e.akO();
        if (akO != null) {
            String string = akO.akX().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @h
    /* loaded from: classes11.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b cfQ;
        final /* synthetic */ String cfR;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cfQ = bVar;
            this.cfR = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void aho() {
            JSONArray ahw = d.ahw();
            if (ahw == null || ahw.length() == 0) {
                kotlin.jvm.a.b bVar = this.cfQ;
                if (bVar != null) {
                    kotlin.l lVar = (kotlin.l) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = ahw.length();
            for (int i = 0; i < length; i++) {
                if (q.k(this.cfR, ahw.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cfQ;
                    if (bVar2 != null) {
                        kotlin.l lVar2 = (kotlin.l) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cfQ;
            if (bVar3 != null) {
                kotlin.l lVar3 = (kotlin.l) bVar3.invoke(false);
            }
        }
    }

    public static final void a(String str, kotlin.jvm.a.b<? super Boolean, kotlin.l> bVar) {
        com.baidu.swan.apps.network.c.a.ahk().a(new a(bVar, str));
    }
}
