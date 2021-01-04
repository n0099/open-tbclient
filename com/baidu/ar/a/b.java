package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private JSONObject bJ;
    private JSONObject bK;
    private e bL;
    private String bM;
    private ICallbackWith<String> bN;
    private Context mContext;

    public b(Context context) {
        this.bM = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a2 = d.a(context);
            if (a2 != null) {
                this.bJ = a2.bI;
                this.bM = a2.bH;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null || this.mContext == null) {
            return;
        }
        this.bM = aVar.bH;
        this.bJ = aVar.bI;
        d.a(this.mContext, aVar);
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.bN = iCallbackWith;
    }

    public JSONObject af() {
        if (this.bK == null) {
            com.baidu.ar.h.b.c(TAG, "use inner config: " + this.bJ);
            return this.bJ;
        }
        com.baidu.ar.h.b.c(TAG, "use outter config: " + this.bK);
        return this.bK;
    }

    public int ag() {
        return c.ag();
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        this.bL = new e();
        this.bL.c(new ICallbackWith<String>() { // from class: com.baidu.ar.a.b.1
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
                if (iCallbackWith == null || aVar == null) {
                    return;
                }
                iCallbackWith.run(aVar.bI);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        this.bK = jSONObject;
    }

    public void release() {
        this.bN = null;
        if (this.bL != null) {
            this.bL.cancel();
            this.bL = null;
        }
        this.mContext = null;
    }
}
