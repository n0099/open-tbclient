package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.d;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class OtherBean extends NetworkBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OtherBaseBean";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherBean(Context context) {
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

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> postForEntity;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                postForEntity = this.mRestTemplate.getForEntity(getUrl(), getRequestParams(), getEncode(), cls);
            } else {
                postForEntity = getHttpMethod() == 1 ? this.mRestTemplate.postForEntity(getUrl(), getRequestParams(), getEncode(), cls) : null;
            }
            if (postForEntity != null && this.mRspCallback != null) {
                T body = postForEntity.getBody();
                if (body == null) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
                    return;
                }
                String str2 = (String) body;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("csign");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    new ArrayList();
                    String mds = Md5Utils.toMds(jSONObject2, this.reqId, "&");
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(mds) || !optString.equals(mds)) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                        return;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                try {
                    str = new JSONObject(str2).optString("sign");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    str = null;
                }
                this.mRspCallback.onBeanExecSuccess(getBeanId(), body, null, str);
                return;
            }
            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
            }
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2, restResponseEntity) == null) {
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EbpayHttpRequestInterceptor());
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new d());
        }
    }
}
