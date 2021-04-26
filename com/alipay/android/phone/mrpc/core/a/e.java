package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public int f1604c;

    /* renamed from: d  reason: collision with root package name */
    public Object f1605d;

    public e(int i2, String str, Object obj) {
        super(str, obj);
        this.f1604c = i2;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f1605d = obj;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002e: IGET  (r4v3 int A[REMOVE]) = (r5v0 'this' com.alipay.android.phone.mrpc.core.a.e A[IMMUTABLE_TYPE, THIS]) com.alipay.android.phone.mrpc.core.a.e.c int)] */
    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f1605d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.a.a.f.a(this.f1605d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f1602a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1604c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            new StringBuilder("mParams is:").append(this.f1603b);
            arrayList.add(new BasicNameValuePair("requestData", this.f1603b == null ? "[]" : com.alipay.a.a.f.a(this.f1603b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.f1603b);
            sb2.append(":");
            sb2.append(e2);
            throw new RpcException(9, sb2.toString() == null ? "" : e2.getMessage(), e2);
        }
    }
}
