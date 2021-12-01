package c.a.p0.j.f0.b;

import android.text.TextUtils;
import c.a.p0.a.d2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.n2.n;
import c.a.p0.h.g;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10204b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10205c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.y.b.a a;

    /* renamed from: c.a.p0.j.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0654a implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.f0.b.c f10206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10207f;

        public C0654a(a aVar, c.a.p0.j.f0.b.c cVar) {
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
            this.f10207f = aVar;
            this.f10206e = cVar;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    boolean unused = a.f10204b;
                    this.f10207f.j("shareVideo: fail, no login in");
                    return;
                }
                boolean unused2 = a.f10204b;
                this.f10207f.h(this.f10206e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.j.f0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.p0.j.f0.b.b
        public void a(c.a.p0.j.f0.b.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                if (a.f10204b) {
                    String.format("onFail params = %s;errMsg = %s", cVar, str);
                }
                this.a.j(str);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (a.f10204b) {
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
                        String unused = a.f10205c = jSONObject.optString("community_id");
                        a.f(jSONObject.optString("url"));
                        return;
                    }
                    a.g();
                } catch (JSONException e2) {
                    if (a.f10204b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(224491358, "Lc/a/p0/j/f0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(224491358, "Lc/a/p0/j/f0/b/a;");
                return;
            }
        }
        f10204b = k.a;
        String str = c.a.p0.a.d0.a.c() + "/webpage";
        f10205c = "";
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
        this.a = c.a.p0.a.y.b.a.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f10205c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c.a.p0.j.z.b bVar = (c.a.p0.j.z.b) e.L().h0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put("app_key", e.f0());
            } catch (JSONException e2) {
                if (f10204b) {
                    e2.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            bVar.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(c.a.p0.j.f0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            c.a.p0.j.u.a.i().a(cVar, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.a.n2.s.e eVar = new c.a.p0.a.n2.s.e();
            eVar.f7113b = "shareVideo";
            eVar.f7116e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            n.h(eVar);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null) {
            return;
        }
        c.a.p0.j.d.c.b bVar = new c.a.p0.j.d.c.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        c.a.p0.j.n0.c.call(this.a, false, bVar);
        i();
    }

    public final c.a.p0.j.f0.b.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (e.L() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = c.a.p0.a.r0.n.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                c.a.p0.j.f0.b.c cVar = new c.a.p0.j.f0.b.c();
                cVar.a = B2;
                cVar.f10209c = this.a.B("title");
                cVar.f10208b = this.a.B("query");
                d dVar = new d();
                dVar.a = this.a.y("clipMaxDuration", 30L);
                dVar.f10212b = this.a.y("clipMinDuration", 3L);
                dVar.f10213c = this.a.B("topicSource");
                dVar.f10214d = this.a.C("publishTitle", c.a.p0.a.c1.a.c().getResources().getString(g.swangame_publish_video));
                dVar.f10215e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                dVar.f10219i = this.a.r("sourceType", 1);
                dVar.f10220j = this.a.C("sourceFrom", "tiny");
                dVar.f10217g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                dVar.f10216f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                dVar.f10218h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                dVar.f10221k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("app_key", e.f0());
                    jSONObject.put("frame_type", c.a.p0.a.d2.d.J().l());
                    jSONObject.put("query", cVar.f10208b);
                    if (e.L() != null && e.L().X() != null) {
                        jSONObject.put("title", e.L().X().K());
                    }
                } catch (JSONException e2) {
                    if (f10204b) {
                        e2.toString();
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(f10205c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", f10205c);
                        if (e.L() != null && e.L().X() != null) {
                            jSONObject2.put("name", e.L().X().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e3) {
                        if (f10204b) {
                            e3.toString();
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e4) {
                        if (f10204b) {
                            e4.toString();
                        }
                    }
                    dVar.l = jSONObject3.toString();
                    dVar.m = -1;
                } else {
                    dVar.m = 0;
                }
                cVar.f10211e = dVar;
                return cVar;
            }
        }
        return (c.a.p0.j.f0.b.c) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.a.n2.s.e eVar = new c.a.p0.a.n2.s.e();
            eVar.f7113b = "shareVideo";
            n.h(eVar);
            c.a.p0.j.f0.b.c k2 = k();
            if (k2 == null) {
                return;
            }
            c.a.p0.a.m.b M = e.L().M();
            if (M.e(c.a.p0.a.c1.a.c())) {
                h(k2);
                return;
            }
            SwanAppActivity activity = f.U().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                M.f(activity, null, new C0654a(this, k2));
            }
        }
    }
}
