package com.baidu.searchbox.elasticthread;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ElasticDataUploader {
    private static volatile ElasticDataUploader sInstance = null;
    private IUploader mUploaderImpl;

    /* loaded from: classes3.dex */
    public interface IUploader {
        void uploadStatisticData(JSONObject jSONObject);

        void uploadWarningData(JSONObject jSONObject);
    }

    public static ElasticDataUploader getInstance() {
        if (sInstance == null) {
            synchronized (ElasticDataUploader.class) {
                if (sInstance == null) {
                    sInstance = new ElasticDataUploader();
                }
            }
        }
        return sInstance;
    }

    public void setUploader(IUploader iUploader) {
        this.mUploaderImpl = iUploader;
    }

    public void uploadStatisticData(final JSONObject jSONObject) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.elasticthread.ElasticDataUploader.1
            @Override // java.lang.Runnable
            public void run() {
                if (ElasticDataUploader.this.mUploaderImpl != null) {
                    ElasticDataUploader.this.mUploaderImpl.uploadStatisticData(jSONObject);
                }
            }
        }, "upload_statistic_data", 3);
    }

    public void uploadWarningData(final JSONObject jSONObject) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.elasticthread.ElasticDataUploader.2
            @Override // java.lang.Runnable
            public void run() {
                if (ElasticDataUploader.this.mUploaderImpl != null) {
                    ElasticDataUploader.this.mUploaderImpl.uploadWarningData(jSONObject);
                }
            }
        }, "upload_warning_data", 3);
    }
}
