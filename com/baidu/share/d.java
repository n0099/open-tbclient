package com.baidu.share;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.a = null;
        this.a = context;
    }

    private static boolean a(Context context, String str, String str2, String str3, long j, HashMap hashMap) {
        try {
            Intent intent = new Intent(e.a());
            intent.putExtra(e.c(), Crypto.a(context, str));
            intent.putExtra(e.d(), Crypto.a(context, str2));
            intent.putExtra(e.f(), Crypto.a(context, new StringBuilder(String.valueOf(j)).toString()));
            intent.putExtra(e.g(), Crypto.a(context, str3));
            String str4 = null;
            if (hashMap != null && hashMap.size() > 0) {
                str4 = new JSONObject(hashMap).toString();
            }
            intent.putExtra(e.e(), Crypto.a(context, str4));
            intent.addFlags(32);
            context.sendBroadcast(intent, e.b());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean b(c cVar) {
        if (cVar == null || cVar.a == null || cVar.a.equals("")) {
            return false;
        }
        return cVar.d == null || cVar.d.get(e.c()) == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(c cVar) {
        return a(cVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(c cVar, ArrayList arrayList) {
        if (b(cVar)) {
            String str = cVar.a;
            String packageName = this.a.getPackageName();
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = null;
            if (arrayList != null) {
                str2 = new String();
                for (int i = 0; i < arrayList.size(); i++) {
                    str2 = String.valueOf(str2) + ((String) arrayList.get(i)).replace(e.h(), "") + e.h();
                }
                if (str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            }
            return a(this.a, str, packageName, str2, currentTimeMillis, cVar.d);
        }
        return false;
    }
}
