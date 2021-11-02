package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
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
/* loaded from: classes7.dex */
public class m extends UploadBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38147a;

    /* renamed from: b  reason: collision with root package name */
    public String f38148b;

    /* renamed from: c  reason: collision with root package name */
    public String f38149c;

    /* renamed from: d  reason: collision with root package name */
    public String f38150d;

    /* renamed from: e  reason: collision with root package name */
    public String f38151e;

    /* renamed from: f  reason: collision with root package name */
    public String f38152f;

    /* renamed from: g  reason: collision with root package name */
    public LivenessRecogDTO f38153g;

    /* renamed from: h  reason: collision with root package name */
    public String f38154h;

    /* renamed from: i  reason: collision with root package name */
    public String f38155i;
    public String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context) {
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
        String zid2 = RimGlobalUtils.getZid2();
        this.f38151e = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f38150d = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f38154h = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38155i = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.j = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f38152f = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f38148b = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            execBean(UploadVideoModel.class);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f38149c = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f38147a = str;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        List<UploadBean.UploadFileModel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
            this.f38153g = livenessRecogDTO;
            if (livenessRecogDTO != null && (list = this.files) != null && list.get(0) != null && this.files.get(0).filedata != null) {
                setSpParameter(this.f38153g.spParams);
                if (!TextUtils.isEmpty(this.f38153g.processid)) {
                    arrayList.add(new RestNameValuePair("processid", this.f38153g.processid));
                }
                if (!TextUtils.isEmpty(a())) {
                    arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
                }
                if (!TextUtils.isEmpty(this.f38147a)) {
                    arrayList.add(new RestNameValuePair("video_type", this.f38147a));
                }
                if (!TextUtils.isEmpty(this.f38148b)) {
                    arrayList.add(new RestNameValuePair("callbackkey", this.f38148b));
                }
                if (!TextUtils.isEmpty(this.f38149c)) {
                    arrayList.add(new RestNameValuePair("image_callbackkey", this.f38149c));
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
                arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(this.f38153g.serviceType)) {
                    arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f38153g.serviceType));
                }
                arrayList.add(new RestNameValuePair("type", "video"));
                arrayList.add(new RestNameValuePair("app", "android"));
                arrayList.add(new RestNameValuePair("skey", this.f38154h));
                arrayList.add(new RestNameValuePair("data", this.f38155i));
                arrayList.add(new RestNameValuePair("deviceId", this.j));
            }
            arrayList.add(new RestNameValuePair("client", "android"));
            if (!TextUtils.isEmpty(this.f38151e)) {
                arrayList.add(new RestNameValuePair("zid2", this.f38151e));
            } else if (!TextUtils.isEmpty(this.f38150d)) {
                arrayList.add(new RestNameValuePair("zid", this.f38150d));
            }
            if (!TextUtils.isEmpty(this.f38152f)) {
                arrayList.add(new RestNameValuePair("need_confirm", this.f38152f));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? UploadVideoModel.class : (Class) invokeV.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f38153g != null) {
                sb.append("bduss=" + this.f38153g.bduss);
                sb.append(";stoken=" + this.f38153g.stoken);
            }
            return PayUtils.encrypt("phone_number", sb.toString());
        }
        return (String) invokeV.objValue;
    }
}
