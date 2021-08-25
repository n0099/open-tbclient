package c.a.o0.a.h1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import c.a.o0.a.v2.n0;
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
public class d implements c.a.o0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f6507e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.a.h1.c.h.c f6508f;

    /* renamed from: g  reason: collision with root package name */
    public String f6509g;

    /* renamed from: h  reason: collision with root package name */
    public String f6510h;

    /* renamed from: i  reason: collision with root package name */
    public double f6511i;

    /* renamed from: j  reason: collision with root package name */
    public double f6512j;
    public int k;
    public int l;
    public b m;
    public c n;
    public a o;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class a implements c.a.o0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f6513e;

        /* renamed from: f  reason: collision with root package name */
        public double f6514f;

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
            this.f6513e = 0.5d;
            this.f6514f = 1.0d;
        }

        @Override // c.a.o0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f6513e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f6514f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f6513e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f6513e = d3;
            double d4 = this.f6514f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f6514f = d2;
        }

        @Override // c.a.o0.a.l1.a
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
    public static class b extends C0252d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f6515j;
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
            this.f6515j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // c.a.o0.a.h1.c.h.d.C0252d, c.a.o0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f6515j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = c.a.o0.a.h1.c.d.a(jSONObject.optString("bgColor"), -1);
            c.a.o0.a.h1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class c extends C0252d implements c.a.o0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public float f6516j;
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
            this.f6516j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // c.a.o0.a.h1.c.h.d.C0252d, c.a.o0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f6516j = c.a.o0.a.h1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = c.a.o0.a.h1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.f6516j == 0.0f && b2 == 0.0f) {
                this.f6516j = c.a.o0.a.h1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = c.a.o0.a.h1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = c.a.o0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: c.a.o0.a.h1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0252d implements c.a.o0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f6517e;

        /* renamed from: f  reason: collision with root package name */
        public int f6518f;

        /* renamed from: g  reason: collision with root package name */
        public float f6519g;

        /* renamed from: h  reason: collision with root package name */
        public int f6520h;

        /* renamed from: i  reason: collision with root package name */
        public float f6521i;

        public C0252d(d dVar) {
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
            this.f6517e = "";
            this.f6518f = -16777216;
            this.f6519g = c.a.o0.a.h1.c.d.b(10.0d);
            this.f6520h = 0;
            this.f6521i = 0.0f;
        }

        @Override // c.a.o0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.f6517e = jSONObject.optString("content");
                this.f6518f = c.a.o0.a.h1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(c.a.o0.a.h1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = c.a.o0.a.h1.c.d.b(10.0d);
                }
                this.f6519g = b2;
                this.f6520h = c.a.o0.a.h1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f6521i = c.a.o0.a.h1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // c.a.o0.a.l1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f6517e) : invokeV.booleanValue;
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
        this.f6507e = "";
        this.f6509g = "";
        this.f6510h = "";
        this.f6511i = 0.0d;
        this.f6512j = 1.0d;
        this.k = -1;
        this.l = -1;
    }

    @Override // c.a.o0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c.a.o0.a.h1.c.h.c cVar = new c.a.o0.a.h1.c.h.c();
        this.f6508f = cVar;
        cVar.a(jSONObject);
        if (this.f6508f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f6507e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6507e = jSONObject.optString("id");
            }
            this.f6509g = jSONObject.optString("title");
            this.f6510h = jSONObject.optString("iconPath");
            this.f6511i = jSONObject.optDouble("rotate", 0.0d);
            this.f6512j = Math.abs(jSONObject.optDouble("alpha", 1.0d));
            this.k = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.l = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.m = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar2 = new c(this);
            this.n = cVar2;
            cVar2.a(jSONObject.optJSONObject(NotificationCompatJellybean.KEY_LABEL));
            a aVar = new a();
            this.o = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // c.a.o0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.a.h1.c.h.c cVar = this.f6508f;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
