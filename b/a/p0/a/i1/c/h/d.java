package b.a.p0.a.i1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes.dex */
public class d implements b.a.p0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f6488e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.i1.c.h.c f6489f;

    /* renamed from: g  reason: collision with root package name */
    public String f6490g;

    /* renamed from: h  reason: collision with root package name */
    public String f6491h;

    /* renamed from: i  reason: collision with root package name */
    public double f6492i;
    public double j;
    public int k;
    public int l;
    public b m;
    public c n;
    public a o;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class a implements b.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f6493e;

        /* renamed from: f  reason: collision with root package name */
        public double f6494f;

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
            this.f6493e = 0.5d;
            this.f6494f = 1.0d;
        }

        @Override // b.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f6493e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f6494f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f6493e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f6493e = d3;
            double d4 = this.f6494f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f6494f = d2;
        }

        @Override // b.a.p0.a.m1.a
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
    public static class b extends C0280d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
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
            this.j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // b.a.p0.a.i1.c.h.d.C0280d, b.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = b.a.p0.a.i1.c.d.a(jSONObject.optString("bgColor"), -1);
            b.a.p0.a.i1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class c extends C0280d implements b.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
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
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // b.a.p0.a.i1.c.h.d.C0280d, b.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = b.a.p0.a.i1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = b.a.p0.a.i1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.j == 0.0f && b2 == 0.0f) {
                this.j = b.a.p0.a.i1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = b.a.p0.a.i1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = b.a.p0.a.i1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: b.a.p0.a.i1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0280d implements b.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f6495e;

        /* renamed from: f  reason: collision with root package name */
        public int f6496f;

        /* renamed from: g  reason: collision with root package name */
        public float f6497g;

        /* renamed from: h  reason: collision with root package name */
        public int f6498h;

        /* renamed from: i  reason: collision with root package name */
        public float f6499i;

        public C0280d(d dVar) {
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
            this.f6495e = "";
            this.f6496f = -16777216;
            this.f6497g = b.a.p0.a.i1.c.d.b(10.0d);
            this.f6498h = 0;
            this.f6499i = 0.0f;
        }

        @Override // b.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.f6495e = jSONObject.optString("content");
                this.f6496f = b.a.p0.a.i1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(b.a.p0.a.i1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = b.a.p0.a.i1.c.d.b(10.0d);
                }
                this.f6497g = b2;
                this.f6498h = b.a.p0.a.i1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f6499i = b.a.p0.a.i1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // b.a.p0.a.m1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f6495e) : invokeV.booleanValue;
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
        this.f6488e = "";
        this.f6490g = "";
        this.f6491h = "";
        this.f6492i = 0.0d;
        this.j = 1.0d;
        this.k = -1;
        this.l = -1;
    }

    @Override // b.a.p0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        b.a.p0.a.i1.c.h.c cVar = new b.a.p0.a.i1.c.h.c();
        this.f6489f = cVar;
        cVar.a(jSONObject);
        if (this.f6489f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f6488e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6488e = jSONObject.optString("id");
            }
            this.f6490g = jSONObject.optString("title");
            this.f6491h = jSONObject.optString("iconPath");
            this.f6492i = jSONObject.optDouble("rotate", 0.0d);
            this.j = Math.abs(jSONObject.optDouble("alpha", 1.0d));
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

    @Override // b.a.p0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.i1.c.h.c cVar = this.f6489f;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
