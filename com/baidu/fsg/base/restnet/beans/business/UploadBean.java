package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.b.a;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.c;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class UploadBean extends NetworkBean {
    public static final int COMET_BEAN = 1;
    public static final String TAG = "UploadBean";
    public static final String UPLOAD_BEAN_TASK_MGR_KEY = "UploadBeanTask";
    public static final String UPLOAD_BEAN_TASK_MGR_TASK_KEY = "UploadBean";
    public int beanType;
    public List<UploadFileModel> files;
    public RestMultipartEntity.ProgressListener listener;
    public String mTskKey;
    public Class<?> rspClass;

    /* loaded from: classes2.dex */
    public static class UploadFileModel {
        public String contentType;
        public String fileName;
        public byte[] filedata;
        public String name;
    }

    public UploadBean(Context context) {
        super(context);
        this.mTskKey = "";
        this.beanType = -1;
        this.files = new ArrayList();
    }

    private void checkSign(BeanResponseBase beanResponseBase) throws Exception {
        if (!needCheckClientSign() || beanResponseBase == null) {
            return;
        }
        String str = beanResponseBase.csign;
        JSONObject jSONObject = beanResponseBase.result;
        if (jSONObject != null) {
            String mds = Md5Utils.toMds(jSONObject, this.reqId, "&");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(mds) || !str.equals(mds)) {
                throw new Exception(BeanConstants.ERROR_MSG_CHECKSIGN);
            }
        }
    }

    private <T> T extractRealResponse(String str, Class<T> cls) {
        try {
            return (T) JsonUtils.fromJson(str, cls);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private RestMultipartEntity generateMultipartEntity() throws Exception {
        RestMultipartEntity restMultipartEntity = new RestMultipartEntity();
        List<RestNameValuePair> requestParams = getRequestParams();
        if (requestParams != null) {
            for (RestNameValuePair restNameValuePair : requestParams) {
                restMultipartEntity.addPart(restNameValuePair.getName(), restNameValuePair.getValue());
            }
        }
        boolean z = false;
        int i2 = 0;
        while (i2 < this.files.size()) {
            boolean z2 = i2 == this.files.size() - 1 ? true : z;
            UploadFileModel uploadFileModel = this.files.get(i2);
            if (uploadFileModel != null && uploadFileModel.filedata != null) {
                restMultipartEntity.addPart(uploadFileModel.name, uploadFileModel.fileName, new ByteArrayInputStream(uploadFileModel.filedata), uploadFileModel.contentType, z2);
            }
            i2++;
            z = z2;
        }
        restMultipartEntity.setProgressListener(this.listener);
        return restMultipartEntity;
    }

    public void addFile(UploadFileModel uploadFileModel) {
        if (uploadFileModel != null) {
            this.files.add(uploadFileModel);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void destroyBean() {
        this.mRspCallback = null;
        a.a(UPLOAD_BEAN_TASK_MGR_KEY).a("UploadBean", this.mTskKey);
        RestTemplate restTemplate = this.mRestTemplate;
        if (restTemplate != null) {
            restTemplate.setRequestInterceptor(null);
        }
        this.files.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T> void execBean(Class<T> cls) {
        this.rspClass = cls;
        super.execBean(cls);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T1, E> void executeAndHandleResponse(Class<T1> cls, Class<E> cls2) {
        try {
            RestMultipartEntity generateMultipartEntity = generateMultipartEntity();
            RestResponseEntity<? extends BeanResponseBase> postMultipartForEntity = this.mRestTemplate.postMultipartForEntity(getUrl(), generateMultipartEntity, getEncode(), BeanResponseBase.class);
            generateMultipartEntity.closeOutStream();
            handleResponse(cls, null, postMultipartForEntity);
        } catch (Exception e2) {
            if ((e2 instanceof RestRuntimeException) && ((RestRuntimeException) e2).contains(SocketTimeoutException.class)) {
                IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                if (iBeanResponseCallback != null) {
                    iBeanResponseCallback.onBeanExecFailure(getBeanId(), -5, BeanConstants.rim_timeout_error);
                }
            } else {
                handleResponse(cls, null, null);
            }
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback == null) {
            return;
        }
        if (restResponseEntity == null) {
            if (iBeanResponseCallback != null) {
                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
                return;
            }
            return;
        }
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
                String str = TAG;
                LogUtil.d(str, "execBean. ret       . rsp class = " + cls);
                if (cls != null) {
                    if (JsonUtils.DataType.isString(cls)) {
                        this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                        return;
                    }
                    Object extractRealResponse = extractRealResponse(body.getRealResponseContent(), cls);
                    String str2 = TAG;
                    LogUtil.d(str2, "execBean. ret ok. real response = " + extractRealResponse);
                    if (extractRealResponse != null) {
                        IBeanResponse iBeanResponse = (IBeanResponse) extractRealResponse;
                        if (iBeanResponse.checkResponseValidity()) {
                            iBeanResponse.storeResponse(this.mContext);
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
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                return;
            }
        }
        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
    }

    public boolean needCheckClientSign() {
        return false;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public boolean needNonce() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void prepareRestTemplate() {
        RestHttpRequestInterceptor ebpayHttpRequestInterceptor;
        Context context = this.mContext;
        this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "upload bean http request");
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

    public void setProgressListener(RestMultipartEntity.ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public Object uploadUrlConnection(Class<?> cls) throws Exception {
        RestMultipartEntity generateMultipartEntity = generateMultipartEntity();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(getUrl()).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + generateMultipartEntity.getBoundary());
        generateMultipartEntity.writeTo(httpURLConnection.getOutputStream());
        generateMultipartEntity.getOutputStream().close();
        httpURLConnection.getOutputStream().flush();
        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        try {
            Object fromJson = JsonUtils.fromJson(FileCopyUtils.copyToString(inputStreamReader), cls);
            inputStreamReader.close();
            generateMultipartEntity.closeOutStream();
            return fromJson;
        } catch (JSONException unused) {
            return null;
        }
    }

    public UploadBean(Context context, int i2) {
        super(context);
        this.mTskKey = "";
        this.beanType = -1;
        this.files = new ArrayList();
        this.beanType = i2;
    }
}
