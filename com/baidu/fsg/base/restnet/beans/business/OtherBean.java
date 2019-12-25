package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.d;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class OtherBean extends NetworkBean {
    private static final String TAG = "OtherBaseBean";

    public OtherBean(Context context) {
        super(context);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    protected void prepareRestTemplate() {
        this.mRestTemplate = new RestTemplate(this.mContext, BussinessUtils.getUA(this.mContext), "pay bean http request");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EbpayHttpRequestInterceptor());
        this.mRestTemplate.setRequestInterceptor(arrayList);
        this.mRestTemplate.setMessageConverter(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> postForEntity;
        String str;
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
                String mds = Md5Utils.toMds(jSONObject2, this.reqId, ETAG.ITEM_SEPARATOR);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(mds) || !optString.equals(mds)) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                str = new JSONObject(str2).optString("sign");
            } catch (JSONException e2) {
                e2.printStackTrace();
                str = null;
            }
            this.mRspCallback.onBeanExecSuccess(getBeanId(), body, null, str);
        } else if (this.mRspCallback != null) {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
    }
}
