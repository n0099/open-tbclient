package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.b.d;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Objects;
/* loaded from: classes7.dex */
public abstract class ApollonBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TASK_MGR_KEY = "BeanTaskManager";
    public static final String BEAN_TASK_MGR_TASK_KEY = "ApollonBeanTask";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public RestTemplate mRestTemplate;
    public IBeanResponseCallback mRspCallback;
    public String mTskKey;

    public ApollonBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTskKey = "";
        this.mContext = context.getApplicationContext();
    }

    public void destroyBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRspCallback = null;
            d.b("BeanTaskManager").a("ApollonBeanTask", this.mTskKey);
            RestTemplate restTemplate = this.mRestTemplate;
            if (restTemplate != null) {
                restTemplate.setRequestInterceptor(null);
            }
        }
    }

    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            execBean(responseClass());
        }
    }

    public <T> void execBean(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
            execBean(cls, null);
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
            Runnable runnable = new Runnable(this, cls, cls2) { // from class: com.baidu.fsg.base.restnet.beans.ApollonBean.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ApollonBean this$0;
                public final /* synthetic */ Class val$errContentClass;
                public final /* synthetic */ Class val$rspClass;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cls, cls2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$rspClass = cls;
                    this.val$errContentClass = cls2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                this.this$0.prepareRestTemplate();
                                this.this$0.executeAndHandleResponse(this.val$rspClass, this.val$errContentClass);
                            } catch (Exception e2) {
                                this.this$0.handleCommonErrors(e2);
                            }
                        } finally {
                            this.this$0.mRspCallback = null;
                        }
                    }
                }
            };
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                handleNetworkFailureError();
                return;
            }
            d b2 = d.b("BeanTaskManager");
            this.mTskKey = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
            Objects.requireNonNull(b2);
            b2.a(new d.c(b2, 0L, 0L, false, this.mTskKey, runnable), "ApollonBeanTask");
        }
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                restResponseEntity = this.mRestTemplate.getForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else if (getHttpMethod() == 1) {
                restResponseEntity = this.mRestTemplate.postForEntity(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else {
                restResponseEntity = null;
            }
            handleResponse(cls, cls2, restResponseEntity);
        }
    }

    public abstract int getBeanId();

    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iBeanResponseCallback) == null) {
            this.mRspCallback = iBeanResponseCallback;
        }
    }
}
