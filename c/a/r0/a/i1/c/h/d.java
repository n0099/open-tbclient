package c.a.r0.a.i1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes.dex */
public class d implements c.a.r0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f7358e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.i1.c.h.c f7359f;

    /* renamed from: g  reason: collision with root package name */
    public String f7360g;

    /* renamed from: h  reason: collision with root package name */
    public String f7361h;

    /* renamed from: i  reason: collision with root package name */
    public double f7362i;

    /* renamed from: j  reason: collision with root package name */
    public double f7363j;
    public int k;
    public int l;
    public b m;
    public c n;
    public a o;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class a implements c.a.r0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f7364e;

        /* renamed from: f  reason: collision with root package name */
        public double f7365f;

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
            this.f7364e = 0.5d;
            this.f7365f = 1.0d;
        }

        @Override // c.a.r0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f7364e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f7365f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f7364e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f7364e = d3;
            double d4 = this.f7365f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f7365f = d2;
        }

        @Override // c.a.r0.a.m1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class b extends C0438d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f7366j;
        public String k;
        public int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7366j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // c.a.r0.a.i1.c.h.d.C0438d, c.a.r0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f7366j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = c.a.r0.a.i1.c.d.a(jSONObject.optString("bgColor"), -1);
            c.a.r0.a.i1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class c extends C0438d implements c.a.r0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f7367j;
        public float k;
        public float l;
        public int m;
        public float n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7367j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // c.a.r0.a.i1.c.h.d.C0438d, c.a.r0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f7367j = c.a.r0.a.i1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = c.a.r0.a.i1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.f7367j == 0.0f && b2 == 0.0f) {
                this.f7367j = c.a.r0.a.i1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = c.a.r0.a.i1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = c.a.r0.a.i1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: c.a.r0.a.i1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0438d implements c.a.r0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f7368e;

        /* renamed from: f  reason: collision with root package name */
        public int f7369f;

        /* renamed from: g  reason: collision with root package name */
        public float f7370g;

        /* renamed from: h  reason: collision with root package name */
        public int f7371h;

        /* renamed from: i  reason: collision with root package name */
        public float f7372i;

        public C0438d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7368e = "";
            this.f7369f = -16777216;
            this.f7370g = c.a.r0.a.i1.c.d.b(10.0d);
            this.f7371h = 0;
            this.f7372i = 0.0f;
        }

        @Override // c.a.r0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.f7368e = jSONObject.optString("content");
                this.f7369f = c.a.r0.a.i1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(c.a.r0.a.i1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = c.a.r0.a.i1.c.d.b(10.0d);
                }
                this.f7370g = b2;
                this.f7371h = c.a.r0.a.i1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f7372i = c.a.r0.a.i1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // c.a.r0.a.m1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f7368e) : invokeV.booleanValue;
        }
    }

    public d() {
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
        this.f7358e = "";
        this.f7360g = "";
        this.f7361h = "";
        this.f7362i = 0.0d;
        this.f7363j = 1.0d;
        this.k = -1;
        this.l = -1;
    }

    @Override // c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c.a.r0.a.i1.c.h.c cVar = new c.a.r0.a.i1.c.h.c();
        this.f7359f = cVar;
        cVar.a(jSONObject);
        if (this.f7359f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f7358e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f7358e = jSONObject.optString("id");
            }
            this.f7360g = jSONObject.optString("title");
            this.f7361h = jSONObject.optString("iconPath");
            this.f7362i = jSONObject.optDouble(AnimationProperty.ROTATE, 0.0d);
            this.f7363j = Math.abs(jSONObject.optDouble(AnimationProperty.OPACITY, 1.0d));
            this.k = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.l = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.m = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar2 = new c(this);
            this.n = cVar2;
            cVar2.a(jSONObject.optJSONObject("label"));
            a aVar = new a();
            this.o = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.a.i1.c.h.c cVar = this.f7359f;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
