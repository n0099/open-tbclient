package b.a.p0.v.j.b.a;

import android.text.TextUtils;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.v2.n0;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11629a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.v.j.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0630a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f11630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f11631f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11632g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11633h;

        public RunnableC0630a(SwanAppComponentContainerView swanAppComponentContainerView, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppComponentContainerView, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11630e = swanAppComponentContainerView;
            this.f11631f = z;
            this.f11632g = str;
            this.f11633h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    int L = n0.L(this.f11630e.getWidth());
                    int L2 = n0.L(this.f11630e.getHeight());
                    jSONObject.putOpt("fullscreen", this.f11631f ? "1" : "0");
                    jSONObject.putOpt("width", String.valueOf(L));
                    jSONObject.putOpt("height", String.valueOf(L2));
                } catch (JSONException e2) {
                    if (a.f11629a) {
                        e2.printStackTrace();
                    }
                }
                a.b(this.f11632g, this.f11633h, "fullscreenchange", jSONObject);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138974021, "Lb/a/p0/v/j/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2138974021, "Lb/a/p0/v/j/b/a/a;");
                return;
            }
        }
        f11629a = k.f6397a;
    }

    public static void b(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, str2, str3, jSONObject) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                    jSONObject2.put("vtype", str3);
                    jSONObject.putOpt("videoId", str);
                    jSONObject2.put("data", jSONObject.toString());
                } catch (JSONException e2) {
                    if (f11629a) {
                        e2.printStackTrace();
                    }
                }
                d.a("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
                b.a.p0.a.w2.g.c.a.d(str2, str, "video", str3, jSONObject2);
            } else if (f11629a) {
                String str4 = "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str;
            }
        }
    }

    public static void c(String str, String str2, boolean z, VideoContainerManager videoContainerManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, Boolean.valueOf(z), videoContainerManager}) == null) {
            SwanAppComponentContainerView G = videoContainerManager.G();
            G.post(new RunnableC0630a(G, z, str, str2));
        }
    }
}
