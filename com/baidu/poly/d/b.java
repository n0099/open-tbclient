package com.baidu.poly.d;

import android.os.Bundle;
import com.baidu.poly.a;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private static b ait;
    private a ahD;

    private b(a aVar) {
        this.ahD = aVar;
    }

    public static void b(a aVar) {
        ait = new b(aVar);
    }

    public static b uF() {
        return ait;
    }

    public void a(Bundle bundle, final String str, final a.c cVar, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.a.uu().a(bundle, new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: k */
            public void onSuccess(Map<String, String> map) {
                b.this.ahD.a(map, str, new a.C0115a() { // from class: com.baidu.poly.d.b.1.1
                    @Override // com.baidu.poly.d.a.C0115a
                    public void onResult(int i, String str2) {
                        cVar.onResult(i, str2);
                    }

                    @Override // com.baidu.poly.d.a.C0115a
                    public void dk(String str2) {
                        cVar.dk(str2);
                    }
                });
                if (aVar != null) {
                    aVar.onSuccess(map);
                }
            }

            @Override // com.baidu.poly.a.a
            public void b(Throwable th, String str2) {
                a.c cVar2 = cVar;
                if (str2 == null) {
                    str2 = th != null ? th.getMessage() : null;
                }
                cVar2.dk(str2);
            }
        });
    }
}
