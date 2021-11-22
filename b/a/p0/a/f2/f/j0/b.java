package b.a.p0.a.f2.f.j0;

import android.util.Log;
import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean q;
    public static String r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f5047a;

    /* renamed from: b  reason: collision with root package name */
    public final double f5048b;

    /* renamed from: c  reason: collision with root package name */
    public final double f5049c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5050d;

    /* renamed from: e  reason: collision with root package name */
    public final double f5051e;

    /* renamed from: f  reason: collision with root package name */
    public final double f5052f;

    /* renamed from: g  reason: collision with root package name */
    public final double f5053g;

    /* renamed from: h  reason: collision with root package name */
    public final double f5054h;

    /* renamed from: i  reason: collision with root package name */
    public final String f5055i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183831756, "Lb/a/p0/a/f2/f/j0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(183831756, "Lb/a/p0/a/f2/f/j0/b;");
                return;
            }
        }
        q = k.f6863a;
        r = "LocationResult";
    }

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Double.valueOf(d2), Double.valueOf(d3), Float.valueOf(f2), Double.valueOf(d4), Double.valueOf(d5), str2, str3, str4, str5, str6, str7, str8, str9};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5047a = str;
        this.f5048b = d2;
        this.f5049c = d3;
        this.f5050d = f2;
        this.f5051e = d4;
        this.f5052f = d5;
        this.f5053g = 0.0d;
        this.f5054h = d4;
        this.f5055i = str2;
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.n = str7;
        this.o = str8;
        this.p = str9;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("longitude", this.f5048b);
                jSONObject.put("latitude", this.f5049c);
                jSONObject.put("speed", this.f5050d);
                jSONObject.put("accuracy", this.f5051e);
                jSONObject.put("altitude", this.f5052f);
                jSONObject.put("verticalAccuracy", this.f5053g);
                jSONObject.put("horizontalAccuracy", this.f5054h);
                jSONObject.put("country", this.f5055i);
                jSONObject.put("countryCode", this.j);
                jSONObject.put("city", this.k);
                jSONObject.put("cityCode", this.l);
                jSONObject.put("province", this.m);
                jSONObject.put("district", this.n);
                jSONObject.put("street", this.o);
                jSONObject.put("streetNumber", this.p);
                jSONObject.put("isFullAccuracy", true);
            } catch (JSONException e2) {
                if (q) {
                    String str = "toJSON error: " + Log.getStackTraceString(e2);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
