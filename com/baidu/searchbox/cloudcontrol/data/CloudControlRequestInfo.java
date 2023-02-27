package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CloudControlRequestInfo {
    public Object mCheckInfo;
    public IProcessorDataInterceptor mDataInterceptor;
    public Object mFilter;
    public boolean mIsForceDispatch;
    public Object mPostData;
    public HashMap<String, String> mQueryData;
    public String mServiceName;

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

    public Object getCheckInfo() {
        return this.mCheckInfo;
    }

    public IProcessorDataInterceptor getDataInterceptor() {
        return this.mDataInterceptor;
    }

    public Object getFilter() {
        return this.mFilter;
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

    public String getServiceName() {
        return this.mServiceName;
    }

    public boolean isForceDispatch() {
        return this.mIsForceDispatch;
    }

    public void setDataInterceptor(IProcessorDataInterceptor iProcessorDataInterceptor) {
        this.mDataInterceptor = iProcessorDataInterceptor;
    }

    public void setPostData(Object obj) {
        this.mPostData = obj;
    }
}
