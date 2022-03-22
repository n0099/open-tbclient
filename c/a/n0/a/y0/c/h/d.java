package c.a.n0.a.y0.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes.dex */
public class d implements c.a.n0.a.c1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.y0.c.h.c f7705b;

    /* renamed from: c  reason: collision with root package name */
    public String f7706c;

    /* renamed from: d  reason: collision with root package name */
    public String f7707d;

    /* renamed from: e  reason: collision with root package name */
    public double f7708e;

    /* renamed from: f  reason: collision with root package name */
    public double f7709f;

    /* renamed from: g  reason: collision with root package name */
    public int f7710g;

    /* renamed from: h  reason: collision with root package name */
    public int f7711h;
    public b i;
    public c j;
    public a k;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class a implements c.a.n0.a.c1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public double f7712b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0.5d;
            this.f7712b = 1.0d;
        }

        @Override // c.a.n0.a.c1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f7712b = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.a;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.a = d3;
            double d4 = this.f7712b;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f7712b = d2;
        }

        @Override // c.a.n0.a.c1.a
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
    public static class b extends C0595d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public float f7713f;

        /* renamed from: g  reason: collision with root package name */
        public String f7714g;

        /* renamed from: h  reason: collision with root package name */
        public int f7715h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7713f = 0.0f;
            this.f7714g = "BYCLICK";
            this.f7715h = -1;
        }

        @Override // c.a.n0.a.y0.c.h.d.C0595d, c.a.n0.a.c1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f7713f = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.f7714g = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.f7715h = c.a.n0.a.y0.c.d.a(jSONObject.optString("bgColor"), -1);
            c.a.n0.a.y0.c.d.a(jSONObject.optString("borderColor"), this.f7715h);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes.dex */
    public static class c extends C0595d implements c.a.n0.a.c1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public float f7716f;

        /* renamed from: g  reason: collision with root package name */
        public float f7717g;

        /* renamed from: h  reason: collision with root package name */
        public float f7718h;
        public int i;
        public float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7716f = 0.0f;
            this.f7717g = 0.0f;
            this.f7718h = 0.0f;
            this.i = 0;
            this.j = 0.0f;
        }

        @Override // c.a.n0.a.y0.c.h.d.C0595d, c.a.n0.a.c1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f7716f = c.a.n0.a.y0.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = c.a.n0.a.y0.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.f7717g = b2;
            if (this.f7716f == 0.0f && b2 == 0.0f) {
                this.f7716f = c.a.n0.a.y0.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.f7717g = c.a.n0.a.y0.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.f7718h = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.i = c.a.n0.a.y0.c.d.a(jSONObject.optString("borderColor"), 0);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: c.a.n0.a.y0.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0595d implements c.a.n0.a.c1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f7719b;

        /* renamed from: c  reason: collision with root package name */
        public float f7720c;

        /* renamed from: d  reason: collision with root package name */
        public int f7721d;

        /* renamed from: e  reason: collision with root package name */
        public float f7722e;

        public C0595d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.f7719b = -16777216;
            this.f7720c = c.a.n0.a.y0.c.d.b(10.0d);
            this.f7721d = 0;
            this.f7722e = 0.0f;
        }

        @Override // c.a.n0.a.c1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.a = jSONObject.optString("content");
                this.f7719b = c.a.n0.a.y0.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                    b2 = Math.abs(c.a.n0.a.y0.c.d.b(jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 10.0d)));
                } else {
                    b2 = c.a.n0.a.y0.c.d.b(10.0d);
                }
                this.f7720c = b2;
                this.f7721d = c.a.n0.a.y0.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f7722e = c.a.n0.a.y0.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN);
                }
            }
        }

        @Override // c.a.n0.a.c1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f7706c = "";
        this.f7707d = "";
        this.f7708e = 0.0d;
        this.f7709f = 1.0d;
        this.f7710g = -1;
        this.f7711h = -1;
    }

    @Override // c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c.a.n0.a.y0.c.h.c cVar = new c.a.n0.a.y0.c.h.c();
        this.f7705b = cVar;
        cVar.a(jSONObject);
        if (this.f7705b.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.a = optString;
            if (TextUtils.isEmpty(optString)) {
                this.a = jSONObject.optString("id");
            }
            this.f7706c = jSONObject.optString("title");
            this.f7707d = jSONObject.optString("iconPath");
            this.f7708e = jSONObject.optDouble(AnimationProperty.ROTATE, 0.0d);
            this.f7709f = Math.abs(jSONObject.optDouble(AnimationProperty.OPACITY, 1.0d));
            this.f7710g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f7711h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.i = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar2 = new c(this);
            this.j = cVar2;
            cVar2.a(jSONObject.optJSONObject("label"));
            a aVar = new a();
            this.k = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.y0.c.h.c cVar = this.f7705b;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
