package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile IHttpRequest bR;
    public boolean jr;
    public String js;
    public String jt;
    public k.a ju;
    public int jv;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean jx;
        public JSONObject jy;
        public String jz;

        public a() {
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

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jv = 0;
        this.jr = fVar.jI;
        this.js = fVar.jL;
        this.jt = fVar.jM;
    }

    private String S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            String aPIKey = TextUtils.isEmpty(this.js) ? DuMixARConfig.getAPIKey() : this.jt;
            return com.baidu.ar.h.l.aU(str + aPIKey);
        }
        return (String) invokeL.objValue;
    }

    private String T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private void a(IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iAuthCallback) == null) || this.bR == null) {
            return;
        }
        this.bR.enqueue(new com.baidu.ar.ihttp.a(this, iAuthCallback) { // from class: com.baidu.ar.auth.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IAuthCallback jl;
            public final /* synthetic */ b jw;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iAuthCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.jw = this;
                this.jl = iAuthCallback;
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                    this.jw.b(this.jl);
                }
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                    try {
                        a b2 = this.jw.b(iHttpResponse);
                        if (!b2.jx) {
                            if (this.jl != null) {
                                this.jl.onError(b2.jz, 0);
                                return;
                            }
                            return;
                        }
                        this.jw.e(b2.jy);
                        if (this.jl != null) {
                            this.jl.onSuccess();
                        }
                    } catch (Exception unused) {
                        this.jw.b(this.jl);
                    }
                }
            }
        });
    }

    private void a(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str + "=" + T(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a b(IHttpResponse iHttpResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, iHttpResponse)) == null) {
            if (iHttpResponse == null || !iHttpResponse.isSuccess()) {
                throw new HttpException(4, "response fail");
            }
            JSONObject jSONObject = new JSONObject(iHttpResponse.getContent());
            if (jSONObject.has("errorNum")) {
                a aVar = new a();
                boolean z = jSONObject.getInt("errorNum") == 0;
                aVar.jx = z;
                if (z) {
                    aVar.jy = jSONObject.optJSONObject("data");
                } else {
                    aVar.jz = jSONObject.has("errorMsg") ? jSONObject.getString("errorMsg") : "";
                }
                return aVar;
            }
            throw new HttpException(4, "response format is error");
        }
        return (a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, iAuthCallback) == null) {
            int i2 = this.jv + 1;
            this.jv = i2;
            if (i2 > 5) {
                if (iAuthCallback != null) {
                    iAuthCallback.onSuccess();
                    return;
                }
                return;
            }
            com.baidu.ar.h.b.b("ARAuth", "retry " + this.jv + " at " + System.currentTimeMillis());
            try {
                Thread.currentThread();
                Thread.sleep(this.jv * 500);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            a(iAuthCallback);
        }
    }

    private String cw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            String str = Build.CPU_ABI;
            if (Build.VERSION.SDK_INT >= 21) {
                str = Arrays.asList(Build.SUPPORTED_ABIS).toString();
            }
            String uuid = new UUID(("182020" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (str.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)).hashCode(), -335774081).toString();
            String valueOf = !TextUtils.isEmpty(Build.MANUFACTURER) ? String.valueOf(Build.MANUFACTURER.charAt(0)) : "A";
            return valueOf + uuid.replace("-", "").toUpperCase();
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, jSONObject) == null) || this.ju == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        if (jSONObject == null || !jSONObject.has("features")) {
            hashSet.addAll(FeatureCodes.getAll());
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("features");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    hashSet.add(Integer.valueOf(optJSONArray.optInt(i2)));
                }
            }
        }
        this.ju.a(hashSet);
    }

    private String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, context)) == null) {
            UUID gz = new com.baidu.ar.h.g(context).gz();
            String uuid = gz == null ? "" : gz.toString();
            StringBuilder sb = new StringBuilder();
            String gx = com.baidu.ar.h.c.gx();
            a(sb, "app_id", TextUtils.isEmpty(this.js) ? DuMixARConfig.getAipAppId() : this.js);
            a(sb, "brand", Build.BRAND);
            a(sb, "device", Build.DEVICE);
            a(sb, "dumix_type", gx);
            a(sb, "fr", "-1");
            a(sb, HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
            a(sb, "model", Build.MODEL);
            a(sb, "os_type", "android");
            a(sb, "serial_num", j(context));
            a(sb, "timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            a(sb, "user_id", uuid);
            a(sb, "sign", S(sb.toString()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            String cw = i2 > 28 ? cw() : (i2 <= 27 || context.checkSelfPermission(s.f57419c) != 0) ? Build.SERIAL : Build.getSerial();
            return "unknown".equals(cw) ? "" : cw;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.ju = aVar;
        }
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iAuthCallback) == null) {
            this.bR = HttpFactory.newRequest();
            if (this.bR == null) {
                return;
            }
            long[] a2 = m.a(10, 50L);
            if (a2[0] == 1) {
                String gP = com.baidu.ar.h.s.gP();
                this.bR.setMethod("POST").setUrl(gP).addHeader("Content-Type: application/x-www-form-urlencoded").setBody(i(context));
                a(iAuthCallback);
                return;
            }
            com.baidu.ar.h.b.b("ARAuth", "time err. " + a2[1]);
            if (iAuthCallback != null) {
                iAuthCallback.onSuccess();
            }
        }
    }
}
