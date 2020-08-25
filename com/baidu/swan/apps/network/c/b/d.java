package com.baidu.swan.apps.network.c.b;

import com.baidu.swan.apps.runtime.e;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes8.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray avg() {
        e azJ = e.azJ();
        if (azJ != null) {
            String string = azJ.azU().getString("note_data_pay_check_list", "");
            String str = string;
            if (str == null || l.isBlank(str)) {
                return null;
            }
            return new JSONObject(string).optJSONArray("pay_keys");
        }
        return null;
    }

    @h
    /* loaded from: classes8.dex */
    static final class a implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ String cFs;
        final /* synthetic */ kotlin.jvm.a.b cpZ;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cpZ = bVar;
            this.cFs = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void auZ() {
            JSONArray avg = d.avg();
            if (avg == null || avg.length() == 0) {
                kotlin.jvm.a.b bVar = this.cpZ;
                if (bVar != null) {
                    kotlin.l lVar = (kotlin.l) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = avg.length();
            for (int i = 0; i < length; i++) {
                if (q.l(this.cFs, avg.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cpZ;
                    if (bVar2 != null) {
                        kotlin.l lVar2 = (kotlin.l) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cpZ;
            if (bVar3 != null) {
                kotlin.l lVar3 = (kotlin.l) bVar3.invoke(false);
            }
        }
    }

    public static final void b(String str, kotlin.jvm.a.b<? super Boolean, kotlin.l> bVar) {
        com.baidu.swan.apps.network.c.a.auW().a(new a(bVar, str));
    }
}
