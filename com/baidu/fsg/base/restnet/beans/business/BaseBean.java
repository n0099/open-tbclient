package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.c;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public abstract class BaseBean extends NetworkBean {
    public static final int COMET_BEAN = 1;
    private static final String TAG = "BeasBean";
    private int beanType;

    public BaseBean(Context context) {
        super(context);
        this.beanType = -1;
    }

    public BaseBean(Context context, int i) {
        super(context);
        this.beanType = -1;
        this.beanType = i;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    protected void prepareRestTemplate() {
        RestHttpRequestInterceptor ebpayHttpRequestInterceptor;
        this.mRestTemplate = new RestTemplate(this.mContext, BussinessUtils.getUA(this.mContext), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        if (this.beanType == 1) {
            ebpayHttpRequestInterceptor = new CometHttpRequestInterceptor();
        } else {
            ebpayHttpRequestInterceptor = new EbpayHttpRequestInterceptor();
        }
        arrayList.add(ebpayHttpRequestInterceptor);
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new c());
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        if (restResponseEntity != null && this.mRspCallback != null) {
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
                    LogUtil.d(TAG, "execBean. ret       . rsp class = " + cls);
                    if (cls != null) {
                        if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                            return;
                        }
                        Object extractRealResponse = extractRealResponse(body.getRealResponseContent(), cls);
                        LogUtil.d(TAG, "execBean. ret ok. real response = " + extractRealResponse);
                        if (extractRealResponse != null) {
                            if (((IBeanResponse) extractRealResponse).checkResponseValidity()) {
                                ((IBeanResponse) extractRealResponse).storeResponse(this.mContext);
                                this.mRspCallback.onBeanExecSuccess(getBeanId(), extractRealResponse, body.retMsg, body.sign);
                                return;
                            }
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
                        return;
                    }
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                    return;
                }
            }
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
        } else if (this.mRspCallback != null) {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
        }
    }

    private void checkSign(BeanResponseBase beanResponseBase) throws Exception {
        if (needCheckClientSign() && beanResponseBase != null) {
            String str = beanResponseBase.csign;
            JSONObject jSONObject = beanResponseBase.result;
            if (jSONObject != null) {
                String mds = Md5Utils.toMds(jSONObject, this.reqId, ETAG.ITEM_SEPARATOR);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(mds) || !str.equals(mds)) {
                    throw new Exception(BeanConstants.ERROR_MSG_CHECKSIGN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        super.executeAndHandleResponse(cls, cls2);
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        try {
            return (T) JsonUtils.fromJson(str, cls);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public boolean needNonce() {
        return true;
    }

    public boolean needCheckClientSign() {
        return false;
    }
}
