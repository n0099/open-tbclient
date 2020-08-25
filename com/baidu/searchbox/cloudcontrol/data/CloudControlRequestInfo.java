package com.baidu.searchbox.cloudcontrol.data;

import java.util.HashMap;
/* loaded from: classes11.dex */
public class CloudControlRequestInfo {
    private Object mCheckInfo;
    private Object mFilter;
    private boolean mIsForceDispatch;
    private Object mPostData;
    private HashMap<String, String> mQueryData;
    private String mServiceName;

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2) {
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
    }

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2, Object obj3) {
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
        this.mFilter = obj3;
    }

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2, Object obj3, boolean z) {
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
        this.mFilter = obj3;
        this.mIsForceDispatch = z;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public Object getPostData() {
        return this.mPostData;
    }

    public HashMap<String, String> getQueryData() {
        if (this.mQueryData == null) {
            this.mQueryData = new HashMap<>();
        }
        return this.mQueryData;
    }

    public Object getCheckInfo() {
        return this.mCheckInfo;
    }

    public Object getFilter() {
        return this.mFilter;
    }

    public boolean isForceDispatch() {
        return this.mIsForceDispatch;
    }
}
