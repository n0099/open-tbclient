package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.fsg.base.b.a;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.NetworkUtils;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ApollonBean {
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
        a.a("BeanTaskManager").a("ApollonBeanTask", this.mTskKey);
        RestTemplate restTemplate = this.mRestTemplate;
        if (restTemplate != null) {
            restTemplate.setRequestInterceptor(null);
        }
    }

    public void execBean() {
        execBean(responseClass());
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else if (getHttpMethod() == 1) {
            restResponseEntity = this.mRestTemplate.postForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else {
            restResponseEntity = null;
        }
        handleResponse(cls, cls2, restResponseEntity);
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

    public abstract Class<?> responseClass();

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        this.mRspCallback = iBeanResponseCallback;
    }

    public <T> void execBean(Class<T> cls) {
        execBean(cls, null);
    }

    public <T, E> void execBean(final Class<T> cls, final Class<E> cls2) {
        Runnable runnable = new Runnable() { // from class: com.baidu.fsg.base.restnet.beans.ApollonBean.1
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
        a a2 = a.a("BeanTaskManager");
        this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        a2.getClass();
        a2.a(new a.c(0L, 0L, false, this.mTskKey, runnable), "ApollonBeanTask");
    }
}
