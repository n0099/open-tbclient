package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.util.l;
import java.lang.reflect.Type;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.f1614b);
            StringBuilder sb = new StringBuilder("threadid = ");
            sb.append(Thread.currentThread().getId());
            sb.append("; rpc response:  ");
            sb.append(str);
            JSONObject jSONObject = new JSONObject(str);
            int i2 = jSONObject.getInt(l.f1987a);
            if (i2 == 1000) {
                return this.f1613a == String.class ? jSONObject.optString("result") : com.alipay.a.a.e.a(jSONObject.optString("result"), this.f1613a);
            }
            throw new RpcException(Integer.valueOf(i2), jSONObject.optString("tips"));
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.f1614b));
            sb2.append(":");
            sb2.append(e2);
            throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e2.getMessage());
        }
    }
}
