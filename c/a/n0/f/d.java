package c.a.n0.f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import c.a.n0.l.g;
import c.a.n0.l.j;
import c.a.n0.l.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f4241c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4228b = context;
        this.f4241c = e.a(context);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", c.a.n0.l.d.j(this.f4228b));
                jSONObject.put("1", c.a.n0.l.c.h(this.f4228b));
                jSONObject.put("2", c.a.n0.g.b.a(this.f4228b, true, false));
                jSONObject.put("3", c.a.n0.g.a.c(this.f4228b));
                return c("q/1/qr", c.a.n0.l.c.c(this.f4228b, e(f(true, false), jSONObject), "1077101"));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                byte[] f2 = c.a.n0.l.c.f();
                String b2 = this.f4241c.b(str, URLEncoder.encode(Base64.encodeToString(c.a.n0.l.e.h(f2, g.b(c.a.n0.l.d.f(this.f4228b)).getBytes()), 0)));
                if (TextUtils.isEmpty(b2)) {
                    return "";
                }
                String a2 = a(b2, this.f4241c.e(f2, jSONObject.toString()));
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                JSONObject jSONObject2 = new JSONObject(a2);
                jSONObject2.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                String optString = jSONObject2.optString("skey");
                return new String(c.a.n0.l.e.e(Base64.decode(jSONObject2.optString("data").getBytes(), 0), c.a.n0.l.e.g(Base64.decode(optString.getBytes(), 0), g.b(c.a.n0.l.d.f(this.f4228b)).getBytes())));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String d(JSONObject jSONObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, j2)) == null) {
            try {
                return c("q/1/qmini", c.a.n0.l.c.c(this.f4228b, e(f(true, false), jSONObject), "1077102"));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }

    public final JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, jSONObject2)) == null) {
            if (jSONObject == null && jSONObject2 == null) {
                return null;
            }
            if (jSONObject == null) {
                return jSONObject2;
            }
            if (jSONObject2 == null) {
                return jSONObject;
            }
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject f(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                g(jSONObject, "21", c.a.n0.g.b.a(this.f4228b, z, z2));
                g(jSONObject, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE, c.a.n0.l.d.b(this.f4228b, z, z2));
                g(jSONObject, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, c.a.n0.g.b.c(this.f4228b, z, z2));
                g(jSONObject, "24", c.a.n0.g.b.b(this.f4228b, z, z2));
                g(jSONObject, "40", c.a.n0.g.a.d(this.f4228b, z, z2));
                g(jSONObject, "41", c.a.n0.g.a.a(this.f4228b));
                g(jSONObject, RoomMasterTable.DEFAULT_ID, c.a.n0.g.a.b(this.f4228b, z, z2));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void g(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, jSONObject, str, str2) == null) || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put(str, "");
            } else {
                jSONObject.put(str, str2);
            }
        } catch (Throwable th) {
            c.a.n0.l.c.d(th);
        }
    }

    public boolean h(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            try {
                f2 = f(false, true);
                f2.put("27", Build.MANUFACTURER);
                f2.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, Build.MODEL);
                f2.put(BaseUtils.METHOD_SENDMESSAGE, String.valueOf(Build.VERSION.SDK_INT));
                f2.put("56", Build.VERSION.RELEASE);
                f2.put("50", k.a(this.f4228b));
                f2.put("60", k.f(this.f4228b));
                Pair<Integer, String[]> e2 = k.e(this.f4228b);
                if (e2 != null) {
                    f2.put("20", e2.first);
                    String[] strArr = (String[]) e2.second;
                    if (strArr.length == 4) {
                        f2.put("14", strArr[0]);
                        f2.put("18", strArr[1]);
                        f2.put("15", strArr[2]);
                        f2.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, strArr[3]);
                    }
                }
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
            }
            return new JSONObject(c("q/1/qpre", c.a.n0.l.c.c(this.f4228b, e(f2, jSONObject), "1077104"))).optInt("0", 0) == 0;
        }
        return invokeL.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f4228b.getPackageName());
                jSONObject.put("6", c.a.n0.l.c.l(this.f4228b));
                jSONObject.put("7", j.a(this.f4228b));
                return c("q/1/qc", c.a.n0.l.c.c(this.f4228b, jSONObject, ""));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String j(JSONObject jSONObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, j2)) == null) {
            try {
                return c("q/1/qv", c.a.n0.l.c.c(this.f4228b, e(f(true, false), jSONObject), ""));
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }
}
