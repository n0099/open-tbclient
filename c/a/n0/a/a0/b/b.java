package c.a.n0.a.a0.b;

import androidx.core.app.NotificationCompat;
import c.a.n0.a.a0.a.j.a0;
import c.a.n0.a.a0.a.j.b0;
import c.a.n0.a.a0.a.j.c0;
import c.a.n0.a.a0.a.j.d0;
import c.a.n0.a.a0.a.j.e0;
import c.a.n0.a.a0.a.j.f0;
import c.a.n0.a.a0.a.j.g;
import c.a.n0.a.a0.a.j.g0;
import c.a.n0.a.a0.a.j.h;
import c.a.n0.a.a0.a.j.h0;
import c.a.n0.a.a0.a.j.i0;
import c.a.n0.a.a0.a.j.j0;
import c.a.n0.a.a0.a.j.k;
import c.a.n0.a.a0.a.j.l;
import c.a.n0.a.a0.a.j.l0;
import c.a.n0.a.a0.a.j.m;
import c.a.n0.a.a0.a.j.m0;
import c.a.n0.a.a0.a.j.n;
import c.a.n0.a.a0.a.j.n0;
import c.a.n0.a.a0.a.j.o;
import c.a.n0.a.a0.a.j.o0;
import c.a.n0.a.a0.a.j.p;
import c.a.n0.a.a0.a.j.p0;
import c.a.n0.a.a0.a.j.q;
import c.a.n0.a.a0.a.j.q0;
import c.a.n0.a.a0.a.j.r;
import c.a.n0.a.a0.a.j.s;
import c.a.n0.a.a0.a.j.t;
import c.a.n0.a.a0.a.j.u;
import c.a.n0.a.a0.a.j.v;
import c.a.n0.a.a0.a.j.w;
import c.a.n0.a.a0.a.j.x;
import c.a.n0.a.a0.a.j.y;
import c.a.n0.a.a0.a.j.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends c.a.n0.a.a0.a.j.a>> q;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.n0.a.a0.a.j.a> o;
    public boolean p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1089004175, "Lc/a/n0/a/a0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1089004175, "Lc/a/n0/a/a0/b/b;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        q = hashMap;
        hashMap.put("setFillStyle", x.class);
        q.put("fillRect", m.class);
        q.put("setStrokeStyle", g0.class);
        q.put("strokeStyle", n0.class);
        q.put("setLineCap", a0.class);
        q.put("setLineJoin", c0.class);
        q.put("setLineWidth", d0.class);
        q.put("setLineDash", b0.class);
        q.put("setMiterLimit", e0.class);
        q.put("strokeRect", m0.class);
        q.put("moveTo", q.class);
        q.put("lineTo", p.class);
        q.put("stroke", l0.class);
        q.put("fill", l.class);
        q.put("beginPath", c.a.n0.a.a0.a.j.d.class);
        q.put("rect", s.class);
        q.put("clearRect", c.a.n0.a.a0.a.j.f.class);
        q.put("closePath", h.class);
        q.put("arc", c.a.n0.a.a0.a.j.c.class);
        q.put("bezierCurveTo", c.a.n0.a.a0.a.j.e.class);
        q.put("quadraticCurveTo", r.class);
        q.put("scale", w.class);
        q.put("rotate", u.class);
        q.put("translate", q0.class);
        q.put("transform", p0.class);
        q.put("setTransform", j0.class);
        q.put("font", o.class);
        q.put("setFontSize", y.class);
        q.put("setTextAlign", h0.class);
        q.put("setTextBaseline", i0.class);
        q.put("fillText", n.class);
        q.put("strokeText", o0.class);
        q.put("clip", g.class);
        q.put("drawImage", k.class);
        q.put("save", v.class);
        q.put("restore", t.class);
        q.put("setShadow", f0.class);
        q.put("setGlobalAlpha", z.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.p = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends c.a.n0.a.a0.a.j.a> cls = q.get(optString);
                if (cls != null) {
                    c.a.n0.a.a0.a.j.a newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.o.add(newInstance);
                }
            }
            this.p = jSONObject.optInt("reserve") != 0;
        } catch (Exception e2) {
            if (c.a.n0.a.k.f6803a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.n0.a.a0.b.a, c.a.n0.a.c0.b.b, c.a.n0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }

    public List<c.a.n0.a.a0.a.j.a> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.booleanValue;
    }
}
