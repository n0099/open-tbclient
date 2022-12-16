package com.baidu.searchbox.retrieve.inter.statistics;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IStatTask {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(StatConstants.VALUE_FROM_RETRIEVE, "stat");

    void recordActiveUploadData(boolean z, String str, String str2, String str3, String str4);

    void recordCheckRetrieveData(boolean z, boolean z2, String str, String str2, String str3, String str4);

    void recordDispatchRetrieveData(boolean z, String str, String str2, String str3, String str4);

    void recordReceiveRetrieveData(boolean z);

    void recordUploadRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject);
}
