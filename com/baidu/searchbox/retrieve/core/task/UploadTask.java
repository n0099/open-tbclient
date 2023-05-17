package com.baidu.searchbox.retrieve.core.task;

import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.upload.UploadHelper;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UploadTask implements IUploadTask {
    public static final long ACTIVE_START_TIME_DEFAULT = 0;
    public static final long SIZE_LIMIT_DEFAULT = 20480;
    public static final long TIME_DELAY_DEFAULT = 60000;

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, long j, long j2, long j3, IActiveUploadListener iActiveUploadListener) {
        UploadHelper.getInstance().activeUpload(str, str2, list, j, j2, j3, iActiveUploadListener);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void fetchUpload(String str, String str2, String str3, long j, long j2, long j3, List<String> list) {
        UploadHelper.getInstance().fetchUpload(str, str2, str3, j, j2, j3, list);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, IActiveUploadListener iActiveUploadListener) {
        UploadHelper.getInstance().activeUpload(str, str2, list, SIZE_LIMIT_DEFAULT, 0L, System.currentTimeMillis() + 60000, iActiveUploadListener);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, String str3, long j, long j2, long j3, JSONObject jSONObject) {
        UploadHelper.getInstance().activeUpload(str, str2, list, str3, j, j2, j3, jSONObject);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadSnapShot(String str, String str2, List<String> list, long j, long j2, long j3, boolean z, IActiveUploadListener iActiveUploadListener) {
        UploadHelper.getInstance().activeUploadSnapShot(str, str2, list, j, j2, j3, z, iActiveUploadListener);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, JSONObject jSONObject) {
        activeUpload(str, str2, list, str, SIZE_LIMIT_DEFAULT, 0L, System.currentTimeMillis() + 60000, jSONObject);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadFile(String str, String str2, List<String> list, long j, IActiveUploadListener iActiveUploadListener) {
        UploadHelper.getInstance().activeUploadFile(str, str2, list, j, iActiveUploadListener);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject) {
        UploadHelper.getInstance().activeUploadFile(str, str2, list, str3, j, jSONObject);
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadSnapShot(String str, String str2, List<String> list, String str3, long j, long j2, long j3, boolean z, JSONObject jSONObject) {
        UploadHelper.getInstance().activeUploadSnapShot(str, str2, list, str3, j, j2, j3, z, jSONObject);
    }
}
