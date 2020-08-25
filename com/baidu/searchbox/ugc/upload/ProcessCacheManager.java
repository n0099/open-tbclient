package com.baidu.searchbox.ugc.upload;

import com.baidu.searchbox.ugc.model.UploadCacheBean;
/* loaded from: classes8.dex */
public class ProcessCacheManager {
    private static volatile ProcessCacheManager instance;
    public String mediaIdResponseStr;
    public UploadCacheBean uploadCacheBean = new UploadCacheBean();

    private ProcessCacheManager() {
        this.uploadCacheBean.initBean();
    }

    public static ProcessCacheManager getInstance() {
        if (instance == null) {
            synchronized (ProcessCacheManager.class) {
                if (instance == null) {
                    instance = new ProcessCacheManager();
                }
            }
        }
        return instance;
    }
}
