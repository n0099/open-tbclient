package com.baidu.poly.a.b;

import com.baidu.poly.a.a.f;
import com.baidu.poly.util.HttpSigner;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class a {
    private static int cgm = 1;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C0309a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.b.a cgx;
        final /* synthetic */ JSONObject cgy;

        C0309a(com.baidu.poly.b.a aVar, JSONObject jSONObject) {
            this.cgx = aVar;
            this.cgy = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            com.baidu.poly.b.a aVar = this.cgx;
            if (aVar != null) {
                aVar.onResult(0, "");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.b.a aVar = this.cgx;
            if (aVar != null) {
                aVar.onResult(1, str);
            }
            com.baidu.poly.a.c.a.c(this.cgy);
        }
    }

    /* loaded from: classes19.dex */
    public static final class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.b.a cgx;

        b(com.baidu.poly.b.a aVar) {
            this.cgx = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            com.baidu.poly.b.a aVar = this.cgx;
            if (aVar != null) {
                aVar.onResult(0, "");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.b.a aVar = this.cgx;
            if (aVar != null) {
                aVar.onResult(1, str);
            }
        }
    }

    public static final void b(int i) {
        cgm = i;
    }

    public static final int q() {
        return cgm;
    }

    public static final void b(JSONObject jSONObject, com.baidu.poly.b.a aVar) {
        if (jSONObject != null) {
            com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
            c.a(cVar);
            com.baidu.poly.a.a.b ao = c.ao(jSONObject);
            c.a(cVar, ao.get("bduss"));
            HttpSigner.a(ao);
            new f(false).a(d.w(), cVar, ao, new C0309a(aVar, jSONObject));
        }
    }

    public static final void a(JSONArray jSONArray, com.baidu.poly.b.a aVar) {
        if (jSONArray != null) {
            com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
            c.a(cVar);
            com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
            String jSONArray2 = jSONArray.toString();
            p.n(jSONArray2, "params.toString()");
            bVar.g("batchData", jSONArray2);
            HttpSigner.a(bVar);
            new f(false).a(d.r(), cVar, bVar, new b(aVar));
        }
    }
}
