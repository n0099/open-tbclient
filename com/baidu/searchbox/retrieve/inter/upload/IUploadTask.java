package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IUploadTask {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD);

    void activeUpload(String str, String str2, List<String> list, long j, long j2, long j3, IActiveUploadListener iActiveUploadListener);

    void activeUpload(String str, String str2, List<String> list, IActiveUploadListener iActiveUploadListener);

    void activeUpload(String str, String str2, List<String> list, String str3, long j, long j2, long j3, JSONObject jSONObject);

    void activeUpload(String str, String str2, List<String> list, JSONObject jSONObject);

    void activeUploadFile(String str, String str2, List<String> list, long j, IActiveUploadListener iActiveUploadListener);

    void activeUploadFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject);

    void activeUploadSnapShot(String str, String str2, List<String> list, long j, long j2, long j3, boolean z, IActiveUploadListener iActiveUploadListener);

    void activeUploadSnapShot(String str, String str2, List<String> list, String str3, long j, long j2, long j3, boolean z, JSONObject jSONObject);

    void fetchUpload(String str, String str2, String str3, long j, long j2, long j3, List<String> list);
}
