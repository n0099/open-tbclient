package c.a.s.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.s.a.b.a;
import c.a.s.a.b.d;
import c.a.s.a.e.b;
import c.a.s.a.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f29813e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29814a;

    /* renamed from: b  reason: collision with root package name */
    public String f29815b;

    /* renamed from: c  reason: collision with root package name */
    public Context f29816c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29817d;

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
                return;
            }
        }
        this.f29815b = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f29813e == null) {
                synchronized (a.class) {
                    if (f29813e == null) {
                        f29813e = new a();
                    }
                }
            }
            return f29813e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29815b : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29817d : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29814a : invokeV.intValue;
    }

    public void e(Context context, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f29815b = str;
            if (context != null) {
                this.f29816c = context.getApplicationContext();
            }
            this.f29814a = i2;
            this.f29817d = z;
        }
    }

    public void f(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (TextUtils.isEmpty(this.f29815b) || this.f29816c == null || jSONArray == null || jSONArray.length() == 0) {
                c.a("IMLiteUBC", "cuid is empty or context null or upload json is null");
                return;
            }
            Context context = this.f29816c;
            if (jSONArray == null || jSONArray.length() == 0) {
                c.a("UBCUploader", "upload json is null");
                return;
            }
            c.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
            if (z2) {
                c.a("UBCUploader", "save ubcdata");
                return;
            }
            JSONObject a3 = new c.a.s.a.d.a(z, jSONArray).a();
            if (a3 == null) {
                c.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            String jSONObject = a3.toString();
            if (TextUtils.isEmpty(jSONObject)) {
                a2 = null;
            } else {
                a2 = b.a(jSONObject.getBytes());
                if (a2 != null && a2.length > 2) {
                    a2[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                    a2[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                }
            }
            byte[] bArr = a2;
            if (bArr == null || bArr.length < 3) {
                c.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
                return;
            }
            c.a("UBCUploader", "gzip success, length:" + bArr.length);
            c.a("UBCUploader", "start execute http upload data");
            d dVar = new d(context);
            c.a.s.a.b.a a4 = c.a.s.a.b.a.a(context);
            if (context == null || TextUtils.isEmpty(dVar.a())) {
                dVar.b(c.a.s.a.b.a.f29819d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
            } else if (z3) {
                c.a.s.a.c.a.a().b(new a.RunnableC1390a(a4, dVar, bArr, dVar));
            } else {
                a4.e(dVar.b(), dVar.a(), bArr, dVar.d(), dVar.c(), dVar);
            }
        }
    }
}
