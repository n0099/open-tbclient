package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.converter.GsonHttpMessageConverter;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes.dex */
public abstract class b<T> extends ApollonBean<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3601a = "CommonBean";

    public b(Context context) {
        super(context);
    }

    private <T> T a(String str, Class<T> cls) {
        try {
            return (T) JsonUtils.fromJson(str, cls);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        if (restResponseEntity != null && this.mRspCallback != null) {
            BeanResponseBase body = restResponseEntity.getBody();
            if (body != null) {
                int serverReturnValue = body.getServerReturnValue(cls);
                if (serverReturnValue != 0) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, body.getRealResponseMsg());
                    return;
                }
                LogUtil.d(f3601a, "execBean. ret       . rsp class = " + cls);
                if (cls != null) {
                    if (JsonUtils.DataType.isString(cls)) {
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent());
                        return;
                    }
                    T a2 = a(body.getRealResponseContent(), cls);
                    LogUtil.d(f3601a, "execBean. ret ok. real response = " + a2);
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

    @Override // com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        this.mRestTemplate = new RestTemplate(this.mContext, ChannelUtils.getHostUA(), "apollon");
        this.mRestTemplate.setRequestInterceptor(new ArrayList());
        this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
    }

    public b(Context context, int i) {
        super(context);
    }
}
