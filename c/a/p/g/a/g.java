package c.a.p.g.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public l f11733b;

    /* renamed from: c  reason: collision with root package name */
    public h f11734c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f11735d;

    /* renamed from: e  reason: collision with root package name */
    public Context f11736e;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new f();
        this.f11733b = new p();
        this.f11734c = new e();
        if (this.f11735d == null) {
            c(context);
        }
    }

    @Override // c.a.p.g.a.c
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f11735d == null) {
                c(this.f11736e);
            }
            return this.f11735d;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("aid", this.a.c(this.f11736e));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("uid", this.f11734c.a(this.f11736e));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("adrid", this.f11733b.b(this.f11736e));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("network", this.f11733b.a(this.f11736e));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                jSONObject.put("pkg", this.f11733b.c(this.f11736e));
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                jSONObject.put("ctime", this.f11733b.a());
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                jSONObject.put("ua", this.f11733b.d(this.f11736e));
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                jSONObject.put("ut", this.f11733b.b());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put("iid", this.a.b(this.f11736e));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("sids", this.a.d(this.f11736e));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("oid", this.a.e(this.f11736e));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                jSONObject.put("gaid", this.a.a(this.f11736e));
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            try {
                jSONObject.put("cver", this.a.a());
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            try {
                jSONObject.put("sappinfos", this.a.f(this.f11736e).toString());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                jSONObject.put("cstoreext", this.a.g(this.f11736e).toString());
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context == null) {
                throw new NullPointerException("ctx should not be null");
            }
            if (this.f11736e == null) {
                this.f11736e = context.getApplicationContext();
            }
            this.f11735d = b();
        }
    }
}
