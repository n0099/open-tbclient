package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.c;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class BaseBean extends NetworkBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMET_BEAN = 1;
    public static final String TAG = "BeasBean";
    public transient /* synthetic */ FieldHolder $fh;
    public int beanType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context) {
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
        this.beanType = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context, int i2) {
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
        this.beanType = -1;
        this.beanType = i2;
    }

    private void checkSign(BeanResponseBase beanResponseBase) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, beanResponseBase) == null) && needCheckClientSign() && beanResponseBase != null) {
            String str = beanResponseBase.csign;
            JSONObject jSONObject = beanResponseBase.result;
            if (jSONObject != null) {
                String mds = Md5Utils.toMds(jSONObject, this.reqId, "&");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(mds) || !str.equals(mds)) {
                    throw new Exception(BeanConstants.ERROR_MSG_CHECKSIGN);
                }
            }
        }
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, cls)) == null) {
            try {
                return (T) JsonUtils.fromJson(str, cls);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
            super.executeAndHandleResponse(cls, cls2);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        IBeanResponseCallback iBeanResponseCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity == null || this.mRspCallback == null) {
                iBeanResponseCallback = this.mRspCallback;
                if (iBeanResponseCallback == null) {
                    return;
                }
            } else {
                handleResponseHeaders(restResponseEntity);
                BeanResponseBase body = restResponseEntity.getBody();
                if (body != null) {
                    try {
                        checkSign(body);
                        int serverReturnValue = body.getServerReturnValue(cls);
                        if (serverReturnValue != 0) {
                            this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, body.retMsg);
                            return;
                        }
                        LogUtil.d("BeasBean", "execBean. ret       . rsp class = " + cls);
                        if (cls == null) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                            return;
                        } else if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                            return;
                        } else {
                            Object extractRealResponse = extractRealResponse(body.getRealResponseContent(), cls);
                            LogUtil.d("BeasBean", "execBean. ret ok. real response = " + extractRealResponse);
                            if (extractRealResponse != null) {
                                IBeanResponse iBeanResponse = (IBeanResponse) extractRealResponse;
                                if (iBeanResponse.checkResponseValidity()) {
                                    iBeanResponse.storeResponse(this.mContext);
                                    this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, body.retMsg, body.sign);
                                    return;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                        return;
                    }
                }
                iBeanResponseCallback = this.mRspCallback;
            }
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
        }
    }

    public boolean needCheckClientSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.beanType == 1 ? new CometHttpRequestInterceptor() : new EbpayHttpRequestInterceptor());
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new c());
        }
    }
}
