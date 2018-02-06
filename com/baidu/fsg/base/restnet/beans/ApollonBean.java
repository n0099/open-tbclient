package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.fsg.base.a.a;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.NetworkUtils;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ApollonBean {
    private static final String BEAN_TASK_MGR_KEY = "BeanTaskManager";
    private static final String BEAN_TASK_MGR_TASK_KEY = "ApollonBeanTask";
    protected Context mContext;
    protected RestTemplate mRestTemplate;
    protected IBeanResponseCallback mRspCallback;
    private String mTskKey = "";

    public abstract int getBeanId();

    protected abstract List<RestNameValuePair> getRequestParams();

    public abstract String getUrl();

    protected abstract <T, E> void handleCommonErrors(Exception exc);

    protected abstract void handleNetworkFailureError();

    public abstract <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity);

    protected abstract <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity);

    protected abstract void prepareRestTemplate();

    public abstract Class<?> responseClass();

    public ApollonBean(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        this.mRspCallback = iBeanResponseCallback;
    }

    public void execBean() {
        execBean(responseClass());
    }

    public String getEncode() {
        return "UTF-8";
    }

    public int getHttpMethod() {
        return 1;
    }

    public void destroyBean() {
        this.mRspCallback = null;
        a.a(BEAN_TASK_MGR_KEY).a(BEAN_TASK_MGR_TASK_KEY, this.mTskKey);
        if (this.mRestTemplate != null) {
            this.mRestTemplate.setRequestInterceptor(null);
        }
    }

    public <T> void execBean(Class<T> cls) {
        execBean(cls, null);
    }

    public <T, E> void execBean(final Class<T> cls, final Class<E> cls2) {
        Runnable runnable = new Runnable() { // from class: com.baidu.fsg.base.restnet.beans.ApollonBean.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ApollonBean.this.prepareRestTemplate();
                    ApollonBean.this.executeAndHandleResponse(cls, cls2);
                } catch (Exception e) {
                    ApollonBean.this.handleCommonErrors(e);
                } finally {
                    ApollonBean.this.mRspCallback = null;
                }
            }
        };
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            handleNetworkFailureError();
            return;
        }
        a a = a.a(BEAN_TASK_MGR_KEY);
        this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
        a.getClass();
        a.a(new a.c(0L, 0L, false, this.mTskKey, runnable), BEAN_TASK_MGR_TASK_KEY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.fsg.base.restnet.RestTemplate */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.fsg.base.restnet.RestTemplate */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<? extends BeanResponseBase> restResponseEntity = null;
        if (getHttpMethod() == 0) {
            restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        } else if (getHttpMethod() == 1) {
            restResponseEntity = this.mRestTemplate.postForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
        }
        handleResponse(cls, cls2, restResponseEntity);
    }
}
