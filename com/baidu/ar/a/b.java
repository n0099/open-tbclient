package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private JSONObject bP;
    private JSONObject bQ;
    private e bR;
    private String bS;
    private ICallbackWith<String> bT;
    private Context mContext;

    public b(Context context) {
        this.bS = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a = d.a(context);
            if (a != null) {
                this.bP = a.bO;
                this.bS = a.bN;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null || this.mContext == null) {
            return;
        }
        this.bS = aVar.bN;
        this.bP = aVar.bO;
        d.a(this.mContext, aVar);
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.bT = iCallbackWith;
    }

    public JSONObject ad() {
        if (this.bQ == null) {
            com.baidu.ar.f.b.c(TAG, "use inner config: " + this.bP);
            return this.bP;
        }
        com.baidu.ar.f.b.c(TAG, "use outter config: " + this.bQ);
        return this.bQ;
    }

    public int ae() {
        return c.ae();
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        this.bR = new e();
        this.bR.c(new ICallbackWith<String>() { // from class: com.baidu.ar.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: k */
            public void run(String str) {
                if (b.this.bT != null) {
                    b.this.bT.run(str);
                }
            }
        });
        this.bR.a(this.mContext, this.bS, new ICallbackWith<a>() { // from class: com.baidu.ar.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b */
            public void run(a aVar) {
                b.this.bR = null;
                b.this.a(aVar);
                if (iCallbackWith == null || aVar == null) {
                    return;
                }
                iCallbackWith.run(aVar.bO);
            }
        });
    }

    public void c(JSONObject jSONObject) {
        this.bQ = jSONObject;
    }

    public void release() {
        this.bT = null;
        if (this.bR != null) {
            this.bR.cancel();
            this.bR = null;
        }
        this.mContext = null;
    }
}
