package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends UploadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5903a;

    /* renamed from: b  reason: collision with root package name */
    public String f5904b;

    /* renamed from: c  reason: collision with root package name */
    public String f5905c;

    /* renamed from: d  reason: collision with root package name */
    public String f5906d;

    /* renamed from: e  reason: collision with root package name */
    public String f5907e;

    /* renamed from: f  reason: collision with root package name */
    public LivenessRecogDTO f5908f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String zid2 = RimGlobalUtils.getZid2();
        this.f5906d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5905c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f5903a = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f5907e = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            execBean(AudioVideoUploadModel.class);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        List<UploadBean.UploadFileModel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
            this.f5908f = livenessRecogDTO;
            if (livenessRecogDTO != null && (list = this.files) != null && list.get(0) != null && this.files.get(0).filedata != null) {
                setSpParameter(this.f5908f.spParams);
                arrayList.add(new RestNameValuePair("processid", this.f5908f.processid));
                if (!TextUtils.isEmpty(this.f5904b)) {
                    arrayList.add(new RestNameValuePair("image_callbackkey", this.f5904b));
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
                arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5908f.serviceType));
                LivenessRecogType livenessRecogType = this.f5908f.livenessType;
                if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                    arrayList.add(new RestNameValuePair("type", "bduss"));
                    arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                    arrayList.add(new RestNameValuePair("type", "certinfo"));
                    arrayList.add(new RestNameValuePair("exuid", this.f5908f.exUid));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", this.f5908f.realName);
                        jSONObject.put("cert", this.f5908f.idCardNum);
                        jSONObject.put("bankmobile", this.f5908f.phoneNum);
                        arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                    arrayList.add(new RestNameValuePair("type", "authtoken"));
                    arrayList.add(new RestNameValuePair("authtoken", this.f5908f.authToken));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                    arrayList.add(new RestNameValuePair("type", "outer"));
                    arrayList.add(new RestNameValuePair("exuid", this.f5908f.exUid));
                }
            }
            arrayList.add(new RestNameValuePair("client", "android"));
            if (!TextUtils.isEmpty(this.f5906d)) {
                arrayList.add(new RestNameValuePair("zid2", this.f5906d));
            } else if (!TextUtils.isEmpty(this.f5905c)) {
                arrayList.add(new RestNameValuePair("zid", this.f5905c));
            }
            if (!TextUtils.isEmpty(this.f5903a)) {
                arrayList.add(new RestNameValuePair("audioStartTime", "0"));
            }
            if (!TextUtils.isEmpty(this.f5907e)) {
                arrayList.add(new RestNameValuePair("shouldCollectPicture", this.f5907e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 11;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.w;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AudioVideoUploadModel.class : (Class) invokeV.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f5908f != null) {
                sb.append("bduss=" + this.f5908f.bduss);
                sb.append(";stoken=" + this.f5908f.stoken);
            }
            return PayUtils.encrypt("phone_number", sb.toString());
        }
        return (String) invokeV.objValue;
    }
}
