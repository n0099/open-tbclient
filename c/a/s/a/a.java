package c.a.s.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.s.a.b.a;
import c.a.s.a.b.d;
import c.a.s.a.e.b;
import c.a.s.a.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f12315e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f12316b;

    /* renamed from: c  reason: collision with root package name */
    public Context f12317c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12318d;

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
        this.f12316b = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12315e == null) {
                synchronized (a.class) {
                    if (f12315e == null) {
                        f12315e = new a();
                    }
                }
            }
            return f12315e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12316b : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12318d : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public void e(Context context, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f12316b = str;
            if (context != null) {
                this.f12317c = context.getApplicationContext();
            }
            this.a = i2;
            this.f12318d = z;
        }
    }

    public void f(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (TextUtils.isEmpty(this.f12316b) || this.f12317c == null || jSONArray == null || jSONArray.length() == 0) {
                c.a("IMLiteUBC", "cuid is empty or context null or upload json is null");
                return;
            }
            Context context = this.f12317c;
            if (jSONArray == null || jSONArray.length() == 0) {
                c.a("UBCUploader", "upload json is null");
                return;
            }
            c.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
            if (z2) {
                c.a("UBCUploader", "save ubcdata");
                return;
            }
            JSONObject a2 = new c.a.s.a.d.a(z, jSONArray).a();
            if (a2 == null) {
                c.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            String jSONObject = a2.toString();
            if (TextUtils.isEmpty(jSONObject)) {
                a = null;
            } else {
                a = b.a(jSONObject.getBytes());
                if (a != null && a.length > 2) {
                    a[0] = ContentUtil.GZIP_HEAD_1;
                    a[1] = ContentUtil.GZIP_HEAD_2;
                }
            }
            byte[] bArr = a;
            if (bArr == null || bArr.length < 3) {
                c.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
                return;
            }
            c.a("UBCUploader", "gzip success, length:" + bArr.length);
            c.a("UBCUploader", "start execute http upload data");
            d dVar = new d(context);
            c.a.s.a.b.a a3 = c.a.s.a.b.a.a(context);
            if (context == null || TextUtils.isEmpty(dVar.a())) {
                dVar.b(c.a.s.a.b.a.f12320d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
            } else if (z3) {
                c.a.s.a.c.a.a().b(new a.RunnableC0808a(a3, dVar, bArr, dVar));
            } else {
                a3.e(dVar.b(), dVar.a(), bArr, dVar.d(), dVar.c(), dVar);
            }
        }
    }
}
