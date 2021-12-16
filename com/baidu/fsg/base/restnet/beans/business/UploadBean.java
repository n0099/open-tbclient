package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.b.d;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.RestTemplate;
import com.baidu.fsg.base.restnet.a.c;
import com.baidu.fsg.base.restnet.beans.BeanResponseBase;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public abstract class UploadBean extends NetworkBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMET_BEAN = 1;
    public static final String TAG = "UploadBean";
    public static final String UPLOAD_BEAN_TASK_MGR_KEY = "UploadBeanTask";
    public static final String UPLOAD_BEAN_TASK_MGR_TASK_KEY = "UploadBean";
    public transient /* synthetic */ FieldHolder $fh;
    public int beanType;
    public List<UploadFileModel> files;
    public RestMultipartEntity.ProgressListener listener;
    public String mTskKey;
    public Class<?> rspClass;

    /* loaded from: classes10.dex */
    public static class UploadFileModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String contentType;
        public String fileName;
        public byte[] filedata;
        public String name;

        public UploadFileModel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1623305784, "Lcom/baidu/fsg/base/restnet/beans/business/UploadBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1623305784, "Lcom/baidu/fsg/base/restnet/beans/business/UploadBean;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTskKey = "";
        this.beanType = -1;
        this.files = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadBean(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTskKey = "";
        this.beanType = -1;
        this.files = new ArrayList();
        this.beanType = i2;
    }

    private void checkSign(BeanResponseBase beanResponseBase) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, beanResponseBase) == null) && needCheckClientSign() && beanResponseBase != null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, cls)) == null) {
            try {
                return (T) JsonUtils.fromJson(str, cls);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    private RestMultipartEntity generateMultipartEntity() throws Exception {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
                if (uploadFileModel != null && (bArr = uploadFileModel.filedata) != null) {
                    restMultipartEntity.addPart(uploadFileModel.name, uploadFileModel.fileName, new ByteArrayInputStream(bArr), uploadFileModel.contentType, z2);
                }
                i2++;
                z = z2;
            }
            restMultipartEntity.setProgressListener(this.listener);
            return restMultipartEntity;
        }
        return (RestMultipartEntity) invokeV.objValue;
    }

    public void addFile(UploadFileModel uploadFileModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, uploadFileModel) == null) || uploadFileModel == null) {
            return;
        }
        this.files.add(uploadFileModel);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void destroyBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mRspCallback = null;
            d.b(UPLOAD_BEAN_TASK_MGR_KEY).a("UploadBean", this.mTskKey);
            RestTemplate restTemplate = this.mRestTemplate;
            if (restTemplate != null) {
                restTemplate.setRequestInterceptor(null);
            }
            this.files.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T> void execBean(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
            this.rspClass = cls;
            super.execBean(cls);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T1, E> void executeAndHandleResponse(Class<T1> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
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
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        IBeanResponseCallback iBeanResponseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, cls, cls2, restResponseEntity) == null) || (iBeanResponseCallback = this.mRspCallback) == null) {
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
                if (cls == null) {
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                    return;
                } else if (JsonUtils.DataType.isString(cls)) {
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, body.getRealResponseContent(), body.sign);
                    return;
                } else {
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
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mRspCallback.onBeanExecFailure(getBeanId(), -1, BeanConstants.ERROR_MSG_CHECKSIGN);
                return;
            }
        }
        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, BeanConstants.rim_resolve_error);
    }

    public boolean needCheckClientSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "upload bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.beanType == 1 ? new CometHttpRequestInterceptor() : new EbpayHttpRequestInterceptor());
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new c());
        }
    }

    public void setProgressListener(RestMultipartEntity.ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, progressListener) == null) {
            this.listener = progressListener;
        }
    }

    public Object uploadUrlConnection(Class<?> cls) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cls)) == null) {
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
        return invokeL.objValue;
    }
}
