package com.baidu.swan.apps.network.c.b;

import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes10.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray ayA() {
        e aDb = e.aDb();
        if (aDb != null) {
            String string = aDb.aDm().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @h
    /* loaded from: classes10.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ kotlin.jvm.a.b cEr;
        final /* synthetic */ String cTz;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cEr = bVar;
            this.cTz = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void ayt() {
            JSONArray ayA = d.ayA();
            if (ayA == null || ayA.length() == 0) {
                kotlin.jvm.a.b bVar = this.cEr;
                if (bVar != null) {
                    kotlin.l lVar = (kotlin.l) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = ayA.length();
            for (int i = 0; i < length; i++) {
                if (q.l(this.cTz, ayA.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cEr;
                    if (bVar2 != null) {
                        kotlin.l lVar2 = (kotlin.l) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cEr;
            if (bVar3 != null) {
                kotlin.l lVar3 = (kotlin.l) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, kotlin.l> bVar) {
        com.baidu.swan.apps.network.c.a.ayq().a(new a(bVar, str));
    }
}
