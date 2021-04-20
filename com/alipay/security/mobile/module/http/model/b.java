package com.alipay.security.mobile.module.http.model;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x0065: INVOKE  (r3v3 char A[REMOVE]) = (r1v20 java.lang.String), (0 int) type: VIRTUAL call: java.lang.String.charAt(int):char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x007f: INVOKE  (r1v22 char A[REMOVE]) = (r1v20 java.lang.String), (2 int) type: VIRTUAL call: java.lang.String.charAt(int):char)] */
    public static c a(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f2119a = dataReportResult.success;
        cVar.f2120b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f2126h = map.get("apdid");
            cVar.i = map.get("apdidToken");
            cVar.l = map.get("dynamicKey");
            cVar.m = map.get("timeInterval");
            cVar.n = map.get("webrtcUrl");
            cVar.o = "";
            String str = map.get("drmSwitch");
            if (com.alipay.security.mobile.module.a.a.b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.j = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.k = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.p = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f2127a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.f2128b);
        dataReportRequest.bizData.put("apdidToken", dVar.f2129c);
        dataReportRequest.bizData.put("umidToken", dVar.f2130d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f2131e);
        dataReportRequest.deviceData = dVar.f2132f;
        return dataReportRequest;
    }
}
