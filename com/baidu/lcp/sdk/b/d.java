package com.baidu.lcp.sdk.b;

import android.content.Context;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.lcp.sdk.connect.a;
import com.baidu.lcp.sdk.connect.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a {
    private a.d axf = null;

    public d(Context context) {
        this.context = context;
    }

    @Override // com.baidu.lcp.sdk.b.c.InterfaceC0156c
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        com.baidu.lcp.sdk.d.d.d("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.aD(this.context).awM + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.aD(this.context).awM);
            JSONArray optJSONArray = jSONObject.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
            int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
            int length2 = optJSONArray != null ? optJSONArray.length() : 0;
            if (length2 + length > 0) {
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && length2 > 0) {
                    arrayList.add(optJSONArray.getString(0));
                }
                if (optJSONArray2 != null && length > 0) {
                    arrayList.add(optJSONArray2.getString(0));
                }
                com.baidu.lcp.sdk.connect.a.s(arrayList);
                if (this.axf != null && com.baidu.lcp.sdk.connect.a.avY.size() > 0) {
                    this.axf.c(0, "ok", com.baidu.lcp.sdk.connect.a.avY.get(0));
                    if (com.baidu.lcp.sdk.connect.a.avY.size() > 1) {
                        com.baidu.lcp.sdk.connect.a.avZ++;
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.lcp.sdk.d.d.e("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            com.baidu.lcp.sdk.connect.a.aS(true);
            com.baidu.lcp.sdk.connect.a.aA(this.context).a(f.aD(this.context).awM, this.axf);
        } catch (Exception e) {
            com.baidu.lcp.sdk.d.d.e("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e.getMessage());
            com.baidu.lcp.sdk.connect.a.aS(true);
            com.baidu.lcp.sdk.connect.a.aA(this.context).a(f.aD(this.context).awM, this.axf);
        }
    }

    @Override // com.baidu.lcp.sdk.b.c.InterfaceC0156c
    public void onFailure(int i, String str) {
        com.baidu.lcp.sdk.d.d.e("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
        com.baidu.lcp.sdk.connect.a.aS(true);
        com.baidu.lcp.sdk.connect.a.aA(this.context).a(f.aD(this.context).awM, this.axf);
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public String getHost() {
        return "https://180.76.76.112/v6/0025";
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + f.aD(this.context).awM).getBytes();
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
        return hashMap;
    }

    @Override // com.baidu.lcp.sdk.b.a, com.baidu.lcp.sdk.b.c.a
    public String getMediaType() {
        return "application/x-www-form-urlencoded";
    }

    public void a(a.d dVar) {
        this.axf = dVar;
    }

    @Override // com.baidu.lcp.sdk.b.a, com.baidu.lcp.sdk.b.c.a
    public String getMethod() {
        return "GET";
    }
}
