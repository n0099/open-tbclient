package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.face.liveness.datamodel.ConfirmModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.NetworkBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends BaseBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40142a;

    /* renamed from: b  reason: collision with root package name */
    public int f40143b;

    /* renamed from: c  reason: collision with root package name */
    public LivenessRecogDTO f40144c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
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

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f40142a = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f40143b = i2;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            LivenessRecogDTO livenessRecogDTO = this.f40144c;
            if (livenessRecogDTO != null) {
                setSpParameter(livenessRecogDTO.spParams);
                arrayList.add(new RestNameValuePair("processid", this.f40144c.processid));
                LivenessRecogType livenessRecogType = this.f40144c.livenessType;
                if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                    arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                    arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                    arrayList.add(new RestNameValuePair("type", "certinfo"));
                    arrayList.add(new RestNameValuePair("exuid", this.f40144c.exUid));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", this.f40144c.realName);
                        jSONObject.put("cert", this.f40144c.idCardNum);
                        jSONObject.put("bankmobile", this.f40144c.phoneNum);
                        arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                    arrayList.add(new RestNameValuePair("type", "authtoken"));
                    arrayList.add(new RestNameValuePair("authtoken", this.f40144c.authToken));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                    arrayList.add(new RestNameValuePair("type", "outer"));
                    arrayList.add(new RestNameValuePair("exuid", this.f40144c.exUid));
                }
                arrayList.add(new RestNameValuePair("opt", String.valueOf(this.f40142a)));
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f40144c.serviceType));
                arrayList.add(new RestNameValuePair("living_type", String.valueOf(this.f40143b)));
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
            return 13;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.p;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ConfirmModel.class : (Class) invokeV.objValue;
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessRecogDTO) == null) {
            this.f40144c = livenessRecogDTO;
        }
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f40144c != null) {
                sb.append("bduss=" + this.f40144c.bduss);
                sb.append(";stoken=" + this.f40144c.stoken);
            }
            return PayUtils.encrypt("phone_number", sb.toString());
        }
        return (String) invokeV.objValue;
    }
}
