package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IUploadTask {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD);

    void activeUpload(String str, String str2, List<String> list, long j2, long j3, long j4, IActiveUploadListener iActiveUploadListener);

    void activeUpload(String str, String str2, List<String> list, IActiveUploadListener iActiveUploadListener);

    void activeUpload(String str, String str2, List<String> list, String str3, long j2, long j3, long j4, JSONObject jSONObject);

    void activeUpload(String str, String str2, List<String> list, JSONObject jSONObject);

    void activeUploadFile(String str, String str2, List<String> list, long j2, IActiveUploadListener iActiveUploadListener);

    void activeUploadFile(String str, String str2, List<String> list, String str3, long j2, JSONObject jSONObject);

    void activeUploadSnapShot(String str, String str2, List<String> list, long j2, long j3, long j4, boolean z, IActiveUploadListener iActiveUploadListener);

    void activeUploadSnapShot(String str, String str2, List<String> list, String str3, long j2, long j3, long j4, boolean z, JSONObject jSONObject);

    void fetchUpload(String str, String str2, String str3, long j2, long j3, long j4, List<String> list);
}
