package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.RandomUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.utils.SafeUtils;
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f34762b;

    /* renamed from: c  reason: collision with root package name */
    public String f34763c;

    /* renamed from: d  reason: collision with root package name */
    public String f34764d;

    /* renamed from: e  reason: collision with root package name */
    public String f34765e;

    /* renamed from: f  reason: collision with root package name */
    public String f34766f;

    /* renamed from: g  reason: collision with root package name */
    public String f34767g;

    /* renamed from: h  reason: collision with root package name */
    public String f34768h;

    /* renamed from: i  reason: collision with root package name */
    public String f34769i;

    /* renamed from: j  reason: collision with root package name */
    public String f34770j;

    /* renamed from: k  reason: collision with root package name */
    public LivenessRecogDTO f34771k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
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
        this.f34765e = "1";
        String zid2 = RimGlobalUtils.getZid2();
        this.f34764d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f34763c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f34768h = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f34769i = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f34770j = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f34767g = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f34762b = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            execBean(UploadContrastPortraitModel.class);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f34766f = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            LivenessRecogDTO livenessRecogDTO = this.f34771k;
            if (livenessRecogDTO != null) {
                setSpParameter(livenessRecogDTO.spParams);
                arrayList.add(new RestNameValuePair("processid", this.f34771k.processid));
                LivenessRecogType livenessRecogType = this.f34771k.livenessType;
                if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                    arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                    arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                    arrayList.add(new RestNameValuePair("type", "certinfo"));
                    arrayList.add(new RestNameValuePair("exuid", this.f34771k.exUid));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", this.f34771k.realName);
                        jSONObject.put("cert", this.f34771k.idCardNum);
                        jSONObject.put("bankmobile", this.f34771k.phoneNum);
                        arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                    arrayList.add(new RestNameValuePair("type", "authtoken"));
                    arrayList.add(new RestNameValuePair("authtoken", this.f34771k.authToken));
                } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                    arrayList.add(new RestNameValuePair("type", "outer"));
                    arrayList.add(new RestNameValuePair("exuid", this.f34771k.exUid));
                }
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f34771k.serviceType));
                arrayList.add(new RestNameValuePair("app", "android"));
                arrayList.add(new RestNameValuePair("skey", this.f34768h));
                arrayList.add(new RestNameValuePair("data", this.f34769i));
                arrayList.add(new RestNameValuePair("deviceId", this.f34770j));
            }
            String randomString = RandomUtils.getRandomString(4096);
            arrayList.add(new RestNameValuePair("imgdigests", this.f34762b));
            try {
                arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.a, randomString).getBytes("UTF-8"))));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
            if (!TextUtils.isEmpty(this.f34764d)) {
                arrayList.add(new RestNameValuePair("zid2", this.f34764d));
            } else if (!TextUtils.isEmpty(this.f34763c)) {
                arrayList.add(new RestNameValuePair("zid", this.f34763c));
            }
            arrayList.add(new RestNameValuePair("last", this.f34765e));
            if (!TextUtils.isEmpty(this.f34766f)) {
                arrayList.add(new RestNameValuePair("callbackkey", this.f34766f));
            }
            if (!TextUtils.isEmpty(this.f34767g)) {
                arrayList.add(new RestNameValuePair("need_confirm", this.f34767g));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.m;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? UploadContrastPortraitModel.class : (Class) invokeV.objValue;
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, livenessRecogDTO) == null) {
            this.f34771k = livenessRecogDTO;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f34765e = z ? "1" : "0";
        }
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f34771k != null) {
                sb.append("bduss=" + this.f34771k.bduss);
                sb.append(";stoken=" + this.f34771k.stoken);
            }
            return PayUtils.encrypt("phone_number", sb.toString());
        }
        return (String) invokeV.objValue;
    }
}
