package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private JSONObject bD;
    private e bE;
    private String bF;
    private ICallbackWith<String> bG;
    private Context mContext;

    public b(Context context) {
        this.bF = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            a a = d.a(context);
            if (a != null) {
                this.bD = a.bC;
                this.bF = a.bB;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null || this.mContext == null) {
            return;
        }
        this.bF = aVar.bB;
        this.bD = aVar.bC;
        d.a(this.mContext, aVar);
    }

    public JSONObject P() {
        return this.bD;
    }

    public int Q() {
        return c.Q();
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.bG = iCallbackWith;
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        this.bE = new e();
        this.bE.c(new ICallbackWith<String>() { // from class: com.baidu.ar.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: k */
            public void run(String str) {
                if (b.this.bG != null) {
                    b.this.bG.run(str);
                }
            }
        });
        this.bE.a(this.mContext, this.bF, new ICallbackWith<a>() { // from class: com.baidu.ar.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b */
            public void run(a aVar) {
                b.this.bE = null;
                b.this.a(aVar);
                if (iCallbackWith == null || aVar == null) {
                    return;
                }
                iCallbackWith.run(aVar.bC);
            }
        });
    }

    public void release() {
        this.bG = null;
        if (this.bE != null) {
            this.bE.cancel();
            this.bE = null;
        }
        this.mContext = null;
    }
}
