package c.a.n0.a.q.b;

import androidx.core.app.NotificationCompat;
import c.a.n0.a.q.a.j.a0;
import c.a.n0.a.q.a.j.b0;
import c.a.n0.a.q.a.j.c0;
import c.a.n0.a.q.a.j.d0;
import c.a.n0.a.q.a.j.e0;
import c.a.n0.a.q.a.j.f0;
import c.a.n0.a.q.a.j.g;
import c.a.n0.a.q.a.j.g0;
import c.a.n0.a.q.a.j.h;
import c.a.n0.a.q.a.j.h0;
import c.a.n0.a.q.a.j.i0;
import c.a.n0.a.q.a.j.j0;
import c.a.n0.a.q.a.j.k;
import c.a.n0.a.q.a.j.l;
import c.a.n0.a.q.a.j.l0;
import c.a.n0.a.q.a.j.m;
import c.a.n0.a.q.a.j.m0;
import c.a.n0.a.q.a.j.n;
import c.a.n0.a.q.a.j.n0;
import c.a.n0.a.q.a.j.o;
import c.a.n0.a.q.a.j.o0;
import c.a.n0.a.q.a.j.p;
import c.a.n0.a.q.a.j.p0;
import c.a.n0.a.q.a.j.q;
import c.a.n0.a.q.a.j.q0;
import c.a.n0.a.q.a.j.r;
import c.a.n0.a.q.a.j.s;
import c.a.n0.a.q.a.j.t;
import c.a.n0.a.q.a.j.u;
import c.a.n0.a.q.a.j.v;
import c.a.n0.a.q.a.j.w;
import c.a.n0.a.q.a.j.x;
import c.a.n0.a.q.a.j.y;
import c.a.n0.a.q.a.j.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends c.a.n0.a.q.a.j.a>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.n0.a.q.a.j.a> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-823440391, "Lc/a/n0/a/q/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-823440391, "Lc/a/n0/a/q/b/b;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", x.class);
        m.put("fillRect", m.class);
        m.put("setStrokeStyle", g0.class);
        m.put("strokeStyle", n0.class);
        m.put("setLineCap", a0.class);
        m.put("setLineJoin", c0.class);
        m.put("setLineWidth", d0.class);
        m.put("setLineDash", b0.class);
        m.put("setMiterLimit", e0.class);
        m.put("strokeRect", m0.class);
        m.put("moveTo", q.class);
        m.put("lineTo", p.class);
        m.put("stroke", l0.class);
        m.put("fill", l.class);
        m.put("beginPath", c.a.n0.a.q.a.j.d.class);
        m.put("rect", s.class);
        m.put("clearRect", c.a.n0.a.q.a.j.f.class);
        m.put("closePath", h.class);
        m.put("arc", c.a.n0.a.q.a.j.c.class);
        m.put("bezierCurveTo", c.a.n0.a.q.a.j.e.class);
        m.put("quadraticCurveTo", r.class);
        m.put(AnimationProperty.SCALE, w.class);
        m.put(AnimationProperty.ROTATE, u.class);
        m.put(AnimationProperty.TRANSLATE, q0.class);
        m.put(AnimationProperty.TRANSFORM, p0.class);
        m.put("setTransform", j0.class);
        m.put("font", o.class);
        m.put("setFontSize", y.class);
        m.put("setTextAlign", h0.class);
        m.put("setTextBaseline", i0.class);
        m.put("fillText", n.class);
        m.put("strokeText", o0.class);
        m.put("clip", g.class);
        m.put("drawImage", k.class);
        m.put("save", v.class);
        m.put("restore", t.class);
        m.put("setShadow", f0.class);
        m.put("setGlobalAlpha", z.class);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends c.a.n0.a.q.a.j.a> cls = m.get(optString);
                if (cls != null) {
                    c.a.n0.a.q.a.j.a newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e2) {
            if (c.a.n0.a.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public List<c.a.n0.a.q.a.j.a> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.q.b.a, c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isValid() : invokeV.booleanValue;
    }
}
