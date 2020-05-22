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
    public static final JSONArray akP() {
        e aoG = e.aoG();
        if (aoG != null) {
            String string = aoG.aoR().getString("note_data_pay_check_list", "");
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
        final /* synthetic */ kotlin.jvm.a.b cqG;
        final /* synthetic */ String cqH;

        a(kotlin.jvm.a.b bVar, String str) {
            this.cqG = bVar;
            this.cqH = str;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public final void akH() {
            JSONArray akP = d.akP();
            if (akP == null || akP.length() == 0) {
                kotlin.jvm.a.b bVar = this.cqG;
                if (bVar != null) {
                    kotlin.l lVar = (kotlin.l) bVar.invoke(true);
                    return;
                }
                return;
            }
            int length = akP.length();
            for (int i = 0; i < length; i++) {
                if (q.l(this.cqH, akP.get(i))) {
                    kotlin.jvm.a.b bVar2 = this.cqG;
                    if (bVar2 != null) {
                        kotlin.l lVar2 = (kotlin.l) bVar2.invoke(true);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.a.b bVar3 = this.cqG;
            if (bVar3 != null) {
                kotlin.l lVar3 = (kotlin.l) bVar3.invoke(false);
            }
        }
    }

    public static final void a(String str, kotlin.jvm.a.b<? super Boolean, kotlin.l> bVar) {
        com.baidu.swan.apps.network.c.a.akD().a(new a(bVar, str));
    }
}
