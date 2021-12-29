package com.baidu.apollon.beans;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.taskmanager.TaskManager;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class ApollonBean<T> {
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
        this.mContext = DxmApplicationContextImpl.getApplicationContext(context);
    }

    public void destroyBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRspCallback = null;
            TaskManager.getInstance("BeanTaskManager").cancelTask("ApollonBeanTask", this.mTskKey);
            RestTemplate restTemplate = this.mRestTemplate;
            if (restTemplate != null) {
                restTemplate.setRequestInterceptor(null);
            }
        }
    }

    public abstract void execBean();

    public <T> void execBean(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
            execBean(cls, null);
        }
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                restResponseEntity = this.mRestTemplate.b(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else if (getHttpMethod() == 1) {
                restResponseEntity = this.mRestTemplate.d(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else {
                restResponseEntity = null;
            }
            handleResponse(cls, cls2, restResponseEntity);
        }
    }

    public int getAuthLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public abstract int getBeanId();

    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iBeanResponseCallback) == null) {
            this.mRspCallback = iBeanResponseCallback;
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
            Runnable runnable = new Runnable(this, cls, cls2) { // from class: com.baidu.apollon.beans.ApollonBean.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Class a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Class f33451b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ApollonBean f33452c;

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
                    this.f33452c = this;
                    this.a = cls;
                    this.f33451b = cls2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                this.f33452c.prepareRestTemplate();
                                this.f33452c.executeAndHandleResponse(this.a, this.f33451b);
                            } catch (Exception e2) {
                                this.f33452c.handleCommonErrors(e2);
                            }
                        } finally {
                            this.f33452c.mRspCallback = null;
                        }
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
            taskManager.addTask(new TaskManager.Task(taskManager, 0L, 0L, false, this.mTskKey, runnable), "ApollonBeanTask");
        }
    }
}
