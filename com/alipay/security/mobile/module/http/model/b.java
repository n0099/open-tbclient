package com.alipay.security.mobile.module.http.model;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x006a: INVOKE  (r3v4 char A[REMOVE]) = (r1v23 java.lang.String), (0 int) type: VIRTUAL call: java.lang.String.charAt(int):char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x0084: INVOKE  (r1v25 char A[REMOVE]) = (r1v23 java.lang.String), (2 int) type: VIRTUAL call: java.lang.String.charAt(int):char)] */
    public static c a(DataReportResult dataReportResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataReportResult)) == null) {
            c cVar = new c();
            if (dataReportResult == null) {
                return null;
            }
            cVar.f36240a = dataReportResult.success;
            cVar.f36241b = dataReportResult.resultCode;
            Map<String, String> map = dataReportResult.resultData;
            if (map != null) {
                cVar.f36242c = map.get("apdid");
                cVar.f36243d = map.get("apdidToken");
                cVar.f36246g = map.get("dynamicKey");
                cVar.f36247h = map.get("timeInterval");
                cVar.f36248i = map.get("webrtcUrl");
                cVar.f36249j = "";
                String str = map.get("drmSwitch");
                if (com.alipay.security.mobile.module.a.a.b(str)) {
                    if (str.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str.charAt(0));
                        cVar.f36244e = sb.toString();
                    }
                    if (str.length() >= 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str.charAt(2));
                        cVar.f36245f = sb2.toString();
                    }
                }
                if (map.containsKey("apse_degrade")) {
                    cVar.k = map.get("apse_degrade");
                }
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static DataReportRequest a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            DataReportRequest dataReportRequest = new DataReportRequest();
            if (dVar == null) {
                return null;
            }
            dataReportRequest.os = dVar.f36250a;
            dataReportRequest.rpcVersion = dVar.f36259j;
            dataReportRequest.bizType = "1";
            HashMap hashMap = new HashMap();
            dataReportRequest.bizData = hashMap;
            hashMap.put("apdid", dVar.f36251b);
            dataReportRequest.bizData.put("apdidToken", dVar.f36252c);
            dataReportRequest.bizData.put("umidToken", dVar.f36253d);
            dataReportRequest.bizData.put("dynamicKey", dVar.f36254e);
            dataReportRequest.deviceData = dVar.f36255f;
            return dataReportRequest;
        }
        return (DataReportRequest) invokeL.objValue;
    }
}
