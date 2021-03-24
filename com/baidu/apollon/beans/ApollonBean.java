package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.taskmanager.TaskManager;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ApollonBean<T> {
    public static final String BEAN_TASK_MGR_KEY = "BeanTaskManager";
    public static final String BEAN_TASK_MGR_TASK_KEY = "ApollonBeanTask";
    public Context mContext;
    public RestTemplate mRestTemplate;
    public IBeanResponseCallback mRspCallback;
    public String mTskKey = "";

    public ApollonBean(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void destroyBean() {
        this.mRspCallback = null;
        TaskManager.getInstance("BeanTaskManager").cancelTask("ApollonBeanTask", this.mTskKey);
        RestTemplate restTemplate = this.mRestTemplate;
        if (restTemplate != null) {
            restTemplate.setRequestInterceptor(null);
        }
    }

    public abstract void execBean();

    public <T> void execBean(Class<T> cls) {
        execBean(cls, null);
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.b(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else if (getHttpMethod() == 1) {
            restResponseEntity = this.mRestTemplate.d(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else {
            restResponseEntity = null;
        }
        handleResponse(cls, cls2, restResponseEntity);
    }

    public int getAuthLevel() {
        return 2;
    }

    public abstract int getBeanId();

    public String getEncode() {
        return "UTF-8";
    }

    public int getHttpMethod() {
        return 1;
    }

    public abstract List<RestNameValuePair> getRequestParams();

    public abstract String getUrl();

    public abstract <T, E> void handleCommonErrors(Exception exc);

    public abstract void handleNetworkFailureError();

    public abstract <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity);

    public abstract <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity);

    public abstract void prepareRestTemplate();

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        this.mRspCallback = iBeanResponseCallback;
    }

    public <T, E> void execBean(final Class<T> cls, final Class<E> cls2) {
        Runnable runnable = new Runnable() { // from class: com.baidu.apollon.beans.ApollonBean.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        ApollonBean.this.prepareRestTemplate();
                        ApollonBean.this.executeAndHandleResponse(cls, cls2);
                    } catch (Exception e2) {
                        ApollonBean.this.handleCommonErrors(e2);
                    }
                } finally {
                    ApollonBean.this.mRspCallback = null;
                }
            }
        };
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            handleNetworkFailureError();
            return;
        }
        TaskManager taskManager = TaskManager.getInstance("BeanTaskManager");
        this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        taskManager.getClass();
        taskManager.a(new TaskManager.c(0L, 0L, false, this.mTskKey, runnable), "ApollonBeanTask");
    }
}
