package com.baidu.poly.d;

import android.os.Bundle;
import com.baidu.poly.a;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private static b aip;
    private a ahr;

    private b(a aVar) {
        this.ahr = aVar;
    }

    public static void b(a aVar) {
        aip = new b(aVar);
    }

    public static b uV() {
        return aip;
    }

    public void a(Bundle bundle, final PayChannel payChannel, final a.c cVar, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.a.uK().a(bundle, new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: k */
            public void onSuccess(Map<String, String> map) {
                a.C0099a c0099a = new a.C0099a() { // from class: com.baidu.poly.d.b.1.1
                    @Override // com.baidu.poly.d.a.C0099a
                    public void onResult(int i, String str) {
                        cVar.onResult(i, str);
                    }

                    @Override // com.baidu.poly.d.a.C0099a
                    public void onFail(String str) {
                        cVar.onFail(str);
                    }
                };
                if (payChannel.getActionType().equals(PayChannel.ACTION_TYPE_SDK)) {
                    b.this.ahr.a(map, payChannel.getPayChannel(), c0099a);
                }
                if (aVar != null) {
                    aVar.onSuccess(map);
                }
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str) {
                a.c cVar2 = cVar;
                if (str == null) {
                    str = th != null ? th.getMessage() : null;
                }
                cVar2.onFail(str);
            }
        }, payChannel);
    }
}
