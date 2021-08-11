package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes4.dex */
public abstract class b<T> extends ApollonBean<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37605a = "CommonBean";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private <T> T a(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, cls)) == null) {
            try {
                return (T) JsonUtils.fromJson(str, cls);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != null && this.mRspCallback != null) {
                BeanResponseBase body = restResponseEntity.getBody();
                if (body != null) {
                    int serverReturnValue = body.getServerReturnValue(cls);
                    if (serverReturnValue != 0) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, body.getRealResponseMsg());
                        return;
                    }
                    LogUtil.d(f37605a, "execBean. ret       . rsp class = " + cls);
                    if (cls != null) {
                        if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent());
                            return;
                        }
                        T a2 = a(body.getRealResponseContent(), cls);
                        LogUtil.d(f37605a, "execBean. ret ok. real response = " + a2);
                        if (a2 != null) {
                            IBeanResponse iBeanResponse = (IBeanResponse) a2;
                            if (iBeanResponse.checkResponseValidity()) {
                                iBeanResponse.storeResponse(this.mContext);
                                this.mRspCallback.onBeanExecSuccess(getBeanId(), a2, body.getRealResponseMsg());
                                return;
                            }
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                        return;
                    }
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseMsg());
                    return;
                }
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                return;
            }
            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
            }
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mRestTemplate = new RestTemplate(this.mContext, ChannelUtils.getHostUA(), "apollon");
            this.mRestTemplate.setRequestInterceptor(new ArrayList());
            this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
