package c.a.p0.a.s.a.d;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.w;
import c.a.p0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.s.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public JSONObject n;
    public int o;
    public int p;
    public int q;
    public int r;
    public JSONArray s;
    public float t;
    @Nullable
    public JSONObject u;
    public long v;
    public String w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, @NonNull String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.q = 0;
        this.t = -1.0f;
        this.w = "";
    }

    @Override // c.a.p0.a.s.b.b, c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.n = jSONObject.optJSONObject("style");
        this.u = jSONObject.optJSONObject(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        j();
        i();
    }

    @Override // c.a.p0.a.s.b.b
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = (b) super.clone();
            if (this.n != null) {
                try {
                    bVar.n = new JSONObject(this.n.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.s != null) {
                try {
                    bVar.s = new JSONArray(this.s.toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (this.u != null) {
                try {
                    bVar.u = new JSONObject(this.u.toString());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            return bVar;
        }
        return invokeV.objValue;
    }

    @Override // c.a.p0.a.s.b.b
    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            super.h(jSONObject);
            j();
            i();
        }
    }

    public final void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jSONObject = this.u) == null) {
            return;
        }
        try {
            this.v = Long.parseLong(jSONObject.optString("duration"));
        } catch (Exception unused) {
            d.b("Component-Model-View", "duration occurs exception");
            this.v = 0L;
        }
        this.w = this.u.optString("easing");
    }

    public final void j() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        try {
            this.o = Color.parseColor(jSONObject.optString("bgColor"));
        } catch (Exception unused) {
            d.b("Component-Model-View", "backgroundColor occurs exception");
            this.o = 0;
        }
        this.p = this.n.optInt("borderWidth");
        try {
            this.q = Color.parseColor(this.n.optString("borderColor"));
        } catch (Exception unused2) {
            d.b("Component-Model-View", "borderColor occurs exception");
            this.q = 0;
        }
        this.r = n0.g(this.n.optInt("borderRadius"));
        this.t = w.b(this.n, "opacity", -1.0f);
        this.s = this.n.optJSONArray("padding");
    }
}
