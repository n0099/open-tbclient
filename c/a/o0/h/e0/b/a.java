package c.a.o0.h.e0.b;

import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.g1.f;
import c.a.o0.a.k;
import c.a.o0.a.r0.n;
import c.a.o0.f.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11150b;

    /* renamed from: c  reason: collision with root package name */
    public static String f11151c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.y.b.a f11152a;

    /* renamed from: c.a.o0.h.e0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0565a implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.e0.b.c f11153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11154f;

        public C0565a(a aVar, c.a.o0.h.e0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11154f = aVar;
            this.f11153e = cVar;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    boolean unused = a.f11150b;
                    this.f11154f.j("shareVideo: fail, no login in");
                    return;
                }
                boolean unused2 = a.f11150b;
                this.f11154f.h(this.f11153e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.o0.h.e0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11155a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11155a = aVar;
        }

        @Override // c.a.o0.h.e0.b.b
        public void a(c.a.o0.h.e0.b.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                if (a.f11150b) {
                    String.format("onFail params = %s;errMsg = %s", cVar, str);
                }
                this.f11155a.j(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a.f11150b) {
                    iOException.printStackTrace();
                }
                a.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject != null) {
                        String unused = a.f11151c = jSONObject.optString("community_id");
                        a.f(jSONObject.optString("url"));
                        return;
                    }
                    a.g();
                } catch (JSONException e2) {
                    if (a.f11150b) {
                        e2.printStackTrace();
                    }
                    a.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1472153412, "Lc/a/o0/h/e0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1472153412, "Lc/a/o0/h/e0/b/a;");
                return;
            }
        }
        f11150b = k.f7049a;
        String str = c.a.o0.a.d0.a.c() + "/webpage";
        f11151c = "";
    }

    public a(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11152a = c.a.o0.a.y.b.a.G(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f11151c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c.a.o0.h.y.b bVar = (c.a.o0.h.y.b) e.i().X();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put("app_key", e.V());
            } catch (JSONException e2) {
                if (f11150b) {
                    e2.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            bVar.b(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(c.a.o0.h.e0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            c.a.o0.h.t.a.h().a(cVar, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7036b = "shareVideo";
            eVar.f7039e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            c.a.o0.a.j2.k.h(eVar);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11152a == null) {
            return;
        }
        c.a.o0.h.d.c.b bVar = new c.a.o0.h.d.c.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        c.a.o0.h.m0.c.a(this.f11152a, false, bVar);
        i();
    }

    public final c.a.o0.h.e0.b.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f11152a == null) {
                i();
                return null;
            } else if (e.i() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String C = this.f11152a.C(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(C)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String y = n.y(C);
                if (TextUtils.isEmpty(y)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                c.a.o0.h.e0.b.c cVar = new c.a.o0.h.e0.b.c();
                cVar.f11156a = y;
                cVar.f11158c = this.f11152a.C("title");
                cVar.f11157b = this.f11152a.C("query");
                d dVar = new d();
                dVar.f11161a = this.f11152a.z("clipMaxDuration", 30L);
                dVar.f11162b = this.f11152a.z("clipMinDuration", 3L);
                dVar.f11163c = this.f11152a.C("topicSource");
                dVar.f11164d = this.f11152a.D("publishTitle", c.a.o0.a.c1.a.b().getResources().getString(g.swangame_publish_video));
                dVar.f11165e = this.f11152a.D("publishURL", "/searchbox?action=ugc&cmd=177");
                dVar.f11169i = this.f11152a.s("sourceType", 1);
                dVar.f11170j = this.f11152a.D("sourceFrom", "tiny");
                dVar.f11167g = this.f11152a.D("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                dVar.f11166f = this.f11152a.D("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                dVar.f11168h = this.f11152a.D("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                dVar.k = this.f11152a.D("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("app_key", e.V());
                    jSONObject.put("frame_type", c.a.o0.a.a2.d.g().l());
                    jSONObject.put("query", cVar.f11157b);
                    if (e.i() != null && e.i().N() != null) {
                        jSONObject.put("title", e.i().N().K());
                    }
                } catch (JSONException e2) {
                    if (f11150b) {
                        e2.toString();
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(f11151c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", f11151c);
                        if (e.i() != null && e.i().N() != null) {
                            jSONObject2.put("name", e.i().N().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e3) {
                        if (f11150b) {
                            e3.toString();
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e4) {
                        if (f11150b) {
                            e4.toString();
                        }
                    }
                    dVar.l = jSONObject3.toString();
                    dVar.m = -1;
                } else {
                    dVar.m = 0;
                }
                cVar.f11160e = dVar;
                return cVar;
            }
        }
        return (c.a.o0.h.e0.b.c) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7036b = "shareVideo";
            c.a.o0.a.j2.k.h(eVar);
            c.a.o0.h.e0.b.c k = k();
            if (k == null) {
                return;
            }
            c.a.o0.a.m.b j2 = e.i().j();
            if (j2.e(c.a.o0.a.c1.a.b())) {
                h(k);
                return;
            }
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                j2.f(activity, null, new C0565a(this, k));
            }
        }
    }
}
