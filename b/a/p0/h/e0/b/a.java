package b.a.p0.h.e0.b;

import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.r0.n;
import b.a.p0.f.g;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10385b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10386c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.y.b.a f10387a;

    /* renamed from: b.a.p0.h.e0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0562a implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.e0.b.c f10388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10389f;

        public C0562a(a aVar, b.a.p0.h.e0.b.c cVar) {
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
            this.f10389f = aVar;
            this.f10388e = cVar;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    boolean unused = a.f10385b;
                    this.f10389f.j("shareVideo: fail, no login in");
                    return;
                }
                boolean unused2 = a.f10385b;
                this.f10389f.h(this.f10388e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.h.e0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10390a;

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
            this.f10390a = aVar;
        }

        @Override // b.a.p0.h.e0.b.b
        public void a(b.a.p0.h.e0.b.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
                if (a.f10385b) {
                    String.format("onFail params = %s;errMsg = %s", cVar, str);
                }
                this.f10390a.j(str);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (a.f10385b) {
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
                        String unused = a.f10386c = jSONObject.optString("community_id");
                        a.f(jSONObject.optString("url"));
                        return;
                    }
                    a.g();
                } catch (JSONException e2) {
                    if (a.f10385b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-832536516, "Lb/a/p0/h/e0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-832536516, "Lb/a/p0/h/e0/b/a;");
                return;
            }
        }
        f10385b = k.f6397a;
        String str = b.a.p0.a.d0.a.c() + "/webpage";
        f10386c = "";
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
        this.f10387a = b.a.p0.a.y.b.a.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f10386c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            b.a.p0.h.y.b bVar = (b.a.p0.h.y.b) e.i().W();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put("app_key", e.U());
            } catch (JSONException e2) {
                if (f10385b) {
                    e2.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            bVar.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(b.a.p0.h.e0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            b.a.p0.h.t.a.h().a(cVar, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "shareVideo";
            eVar.f6387e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            b.a.p0.a.j2.k.h(eVar);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f10387a == null) {
            return;
        }
        b.a.p0.h.d.c.b bVar = new b.a.p0.h.d.c.b();
        bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        b.a.p0.h.m0.c.call(this.f10387a, false, bVar);
        i();
    }

    public final b.a.p0.h.e0.b.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f10387a == null) {
                i();
                return null;
            } else if (e.i() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.f10387a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String y = n.y(B);
                if (TextUtils.isEmpty(y)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                b.a.p0.h.e0.b.c cVar = new b.a.p0.h.e0.b.c();
                cVar.f10391a = y;
                cVar.f10393c = this.f10387a.B("title");
                cVar.f10392b = this.f10387a.B("query");
                d dVar = new d();
                dVar.f10396a = this.f10387a.y("clipMaxDuration", 30L);
                dVar.f10397b = this.f10387a.y("clipMinDuration", 3L);
                dVar.f10398c = this.f10387a.B("topicSource");
                dVar.f10399d = this.f10387a.C("publishTitle", b.a.p0.a.c1.a.b().getResources().getString(g.swangame_publish_video));
                dVar.f10400e = this.f10387a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                dVar.f10404i = this.f10387a.r("sourceType", 1);
                dVar.j = this.f10387a.C("sourceFrom", "tiny");
                dVar.f10402g = this.f10387a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                dVar.f10401f = this.f10387a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                dVar.f10403h = this.f10387a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                dVar.k = this.f10387a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("app_key", e.U());
                    jSONObject.put("frame_type", b.a.p0.a.a2.d.g().l());
                    jSONObject.put("query", cVar.f10392b);
                    if (e.i() != null && e.i().M() != null) {
                        jSONObject.put("title", e.i().M().J());
                    }
                } catch (JSONException e2) {
                    if (f10385b) {
                        e2.toString();
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(f10386c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", f10386c);
                        if (e.i() != null && e.i().M() != null) {
                            jSONObject2.put("name", e.i().M().J());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e3) {
                        if (f10385b) {
                            e3.toString();
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e4) {
                        if (f10385b) {
                            e4.toString();
                        }
                    }
                    dVar.l = jSONObject3.toString();
                    dVar.m = -1;
                } else {
                    dVar.m = 0;
                }
                cVar.f10395e = dVar;
                return cVar;
            }
        }
        return (b.a.p0.h.e0.b.c) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "shareVideo";
            b.a.p0.a.j2.k.h(eVar);
            b.a.p0.h.e0.b.c k = k();
            if (k == null) {
                return;
            }
            b.a.p0.a.m.b j = e.i().j();
            if (j.e(b.a.p0.a.c1.a.b())) {
                h(k);
                return;
            }
            SwanAppActivity activity = f.T().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                j.f(activity, null, new C0562a(this, k));
            }
        }
    }
}
