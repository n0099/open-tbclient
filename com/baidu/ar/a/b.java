package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private JSONObject bG;
    private JSONObject bH;
    private e bI;
    private String bJ;
    private ICallbackWith<String> bK;
    private Context mContext;

    public b(Context context) {
        this.bJ = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a2 = d.a(context);
            if (a2 != null) {
                this.bG = a2.bF;
                this.bJ = a2.bE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null || this.mContext == null) {
            return;
        }
        this.bJ = aVar.bE;
        this.bG = aVar.bF;
        d.a(this.mContext, aVar);
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.bK = iCallbackWith;
    }

    public JSONObject ad() {
        if (this.bH == null) {
            com.baidu.ar.g.b.c(TAG, "use inner config: " + this.bG);
            return this.bG;
        }
        com.baidu.ar.g.b.c(TAG, "use outter config: " + this.bH);
        return this.bH;
    }

    public int ae() {
        return c.ae();
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        this.bI = new e();
        this.bI.c(new ICallbackWith<String>() { // from class: com.baidu.ar.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: l */
            public void run(String str) {
                if (b.this.bK != null) {
                    b.this.bK.run(str);
                }
            }
        });
        this.bI.a(this.mContext, this.bJ, new ICallbackWith<a>() { // from class: com.baidu.ar.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b */
            public void run(a aVar) {
                b.this.bI = null;
                b.this.a(aVar);
                if (iCallbackWith == null || aVar == null) {
                    return;
                }
                iCallbackWith.run(aVar.bF);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        this.bH = jSONObject;
    }

    public void release() {
        this.bK = null;
        if (this.bI != null) {
            this.bI.cancel();
            this.bI = null;
        }
        this.mContext = null;
    }
}
