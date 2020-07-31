package com.baidu.poly.a.b;

import com.baidu.poly.a.a.f;
import com.baidu.poly.util.HttpSigner;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static int byU = 1;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0240a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.b.a bzf;
        final /* synthetic */ JSONObject bzg;

        C0240a(com.baidu.poly.b.a aVar, JSONObject jSONObject) {
            this.bzf = aVar;
            this.bzg = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            com.baidu.poly.b.a aVar = this.bzf;
            if (aVar != null) {
                aVar.onResult(0, "");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.b.a aVar = this.bzf;
            if (aVar != null) {
                aVar.onResult(1, str);
            }
            com.baidu.poly.a.c.a.c(this.bzg);
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.b.a bzf;

        b(com.baidu.poly.b.a aVar) {
            this.bzf = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            com.baidu.poly.b.a aVar = this.bzf;
            if (aVar != null) {
                aVar.onResult(0, "");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.b.a aVar = this.bzf;
            if (aVar != null) {
                aVar.onResult(1, str);
            }
        }
    }

    public static final void b(int i) {
        byU = i;
    }

    public static final int p() {
        return byU;
    }

    public static final void b(JSONObject jSONObject, com.baidu.poly.b.a aVar) {
        if (jSONObject != null) {
            com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
            c.a(cVar);
            com.baidu.poly.a.a.b ab = c.ab(jSONObject);
            c.a(cVar, ab.get("bduss"));
            HttpSigner.a(ab);
            new f(false).a(d.u(), cVar, ab, new C0240a(aVar, jSONObject));
        }
    }

    public static final void a(JSONArray jSONArray, com.baidu.poly.b.a aVar) {
        if (jSONArray != null) {
            com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
            c.a(cVar);
            com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
            String jSONArray2 = jSONArray.toString();
            q.l((Object) jSONArray2, "params.toString()");
            bVar.g("batchData", jSONArray2);
            HttpSigner.a(bVar);
            new f(false).a(d.q(), cVar, bVar, new b(aVar));
        }
    }
}
