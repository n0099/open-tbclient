package c.a.p0.a.i1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.p0.a.z2.n0;
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
public class d implements c.a.p0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f6332e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.i1.c.h.c f6333f;

    /* renamed from: g  reason: collision with root package name */
    public String f6334g;

    /* renamed from: h  reason: collision with root package name */
    public String f6335h;

    /* renamed from: i  reason: collision with root package name */
    public double f6336i;

    /* renamed from: j  reason: collision with root package name */
    public double f6337j;

    /* renamed from: k  reason: collision with root package name */
    public int f6338k;
    public int l;
    public b m;
    public c n;
    public a o;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class a implements c.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f6339e;

        /* renamed from: f  reason: collision with root package name */
        public double f6340f;

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
            this.f6339e = 0.5d;
            this.f6340f = 1.0d;
        }

        @Override // c.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f6339e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f6340f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f6339e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f6339e = d3;
            double d4 = this.f6340f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f6340f = d2;
        }

        @Override // c.a.p0.a.m1.a
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
    public static class b extends C0336d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f6341j;

        /* renamed from: k  reason: collision with root package name */
        public String f6342k;
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
            this.f6341j = 0.0f;
            this.f6342k = "BYCLICK";
            this.l = -1;
        }

        @Override // c.a.p0.a.i1.c.h.d.C0336d, c.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f6341j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.f6342k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = c.a.p0.a.i1.c.d.a(jSONObject.optString("bgColor"), -1);
            c.a.p0.a.i1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class c extends C0336d implements c.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f6343j;

        /* renamed from: k  reason: collision with root package name */
        public float f6344k;
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
            this.f6343j = 0.0f;
            this.f6344k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // c.a.p0.a.i1.c.h.d.C0336d, c.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f6343j = c.a.p0.a.i1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = c.a.p0.a.i1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.f6344k = b2;
            if (this.f6343j == 0.0f && b2 == 0.0f) {
                this.f6343j = c.a.p0.a.i1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.f6344k = c.a.p0.a.i1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = c.a.p0.a.i1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: c.a.p0.a.i1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0336d implements c.a.p0.a.m1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f6345e;

        /* renamed from: f  reason: collision with root package name */
        public int f6346f;

        /* renamed from: g  reason: collision with root package name */
        public float f6347g;

        /* renamed from: h  reason: collision with root package name */
        public int f6348h;

        /* renamed from: i  reason: collision with root package name */
        public float f6349i;

        public C0336d(d dVar) {
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
            this.f6345e = "";
            this.f6346f = -16777216;
            this.f6347g = c.a.p0.a.i1.c.d.b(10.0d);
            this.f6348h = 0;
            this.f6349i = 0.0f;
        }

        @Override // c.a.p0.a.m1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.f6345e = jSONObject.optString("content");
                this.f6346f = c.a.p0.a.i1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(c.a.p0.a.i1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = c.a.p0.a.i1.c.d.b(10.0d);
                }
                this.f6347g = b2;
                this.f6348h = c.a.p0.a.i1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f6349i = c.a.p0.a.i1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // c.a.p0.a.m1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f6345e) : invokeV.booleanValue;
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
        this.f6332e = "";
        this.f6334g = "";
        this.f6335h = "";
        this.f6336i = 0.0d;
        this.f6337j = 1.0d;
        this.f6338k = -1;
        this.l = -1;
    }

    @Override // c.a.p0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c.a.p0.a.i1.c.h.c cVar = new c.a.p0.a.i1.c.h.c();
        this.f6333f = cVar;
        cVar.a(jSONObject);
        if (this.f6333f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f6332e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6332e = jSONObject.optString("id");
            }
            this.f6334g = jSONObject.optString("title");
            this.f6335h = jSONObject.optString("iconPath");
            this.f6336i = jSONObject.optDouble(AnimationProperty.ROTATE, 0.0d);
            this.f6337j = Math.abs(jSONObject.optDouble(AnimationProperty.OPACITY, 1.0d));
            this.f6338k = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
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

    @Override // c.a.p0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.i1.c.h.c cVar = this.f6333f;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
