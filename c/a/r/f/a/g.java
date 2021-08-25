package c.a.r.f.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f29526a;

    /* renamed from: b  reason: collision with root package name */
    public l f29527b;

    /* renamed from: c  reason: collision with root package name */
    public h f29528c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f29529d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29530e;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29526a = new f();
        this.f29527b = new p();
        this.f29528c = new e();
        if (this.f29529d == null) {
            c(context);
        }
    }

    @Override // c.a.r.f.a.c
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f29529d == null) {
                c(this.f29530e);
            }
            return this.f29529d;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("aid", this.f29526a.a(this.f29530e));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("uid", this.f29528c.a(this.f29530e));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("adrid", this.f29527b.c(this.f29530e));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("network", this.f29527b.d(this.f29530e));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                jSONObject.put("pkg", this.f29527b.b(this.f29530e));
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                jSONObject.put("ctime", this.f29527b.b());
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                jSONObject.put("ua", this.f29527b.a(this.f29530e));
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                jSONObject.put("ut", this.f29527b.a());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put("iid", this.f29526a.e(this.f29530e));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put(Config.SID, this.f29526a.b(this.f29530e));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("oid", this.f29526a.c(this.f29530e));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                jSONObject.put(Config.GAID, this.f29526a.d(this.f29530e));
            } catch (Exception e14) {
                e14.printStackTrace();
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
            if (this.f29530e == null) {
                this.f29530e = context.getApplicationContext();
            }
            this.f29529d = b();
        }
    }
}
