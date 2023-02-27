package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static final String TAG = "b";
    public JSONObject bJ;
    public JSONObject bK;
    public e bL;
    public String bM;
    public ICallbackWith<String> bN;
    public Context mContext;

    public b(Context context) {
        this.bM = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a = d.a(context);
            if (a != null) {
                this.bJ = a.bI;
                this.bM = a.bH;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Context context;
        if (aVar == null || (context = this.mContext) == null) {
            return;
        }
        this.bM = aVar.bH;
        this.bJ = aVar.bI;
        d.a(context, aVar);
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.bN = iCallbackWith;
    }

    public JSONObject af() {
        if (this.bK == null) {
            String str = TAG;
            com.baidu.ar.h.b.c(str, "use inner config: " + this.bJ);
            return this.bJ;
        }
        String str2 = TAG;
        com.baidu.ar.h.b.c(str2, "use outter config: " + this.bK);
        return this.bK;
    }

    public int ag() {
        return c.ag();
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        e eVar = new e();
        this.bL = eVar;
        eVar.c(new ICallbackWith<String>() { // from class: com.baidu.ar.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: n */
            public void run(String str) {
                if (b.this.bN != null) {
                    b.this.bN.run(str);
                }
            }
        });
        this.bL.a(this.mContext, this.bM, new ICallbackWith<a>() { // from class: com.baidu.ar.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b */
            public void run(a aVar) {
                b.this.bL = null;
                b.this.a(aVar);
                ICallbackWith iCallbackWith2 = iCallbackWith;
                if (iCallbackWith2 == null || aVar == null) {
                    return;
                }
                iCallbackWith2.run(aVar.bI);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        this.bK = jSONObject;
    }

    public void release() {
        this.bN = null;
        e eVar = this.bL;
        if (eVar != null) {
            eVar.cancel();
            this.bL = null;
        }
        this.mContext = null;
    }
}
