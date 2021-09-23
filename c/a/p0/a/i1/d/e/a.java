package c.a.p0.a.i1.d.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.c1.d.i;
import c.a.p0.a.g1.f;
import c.a.p0.a.h;
import c.a.p0.a.k;
import c.a.p0.a.v2.w;
import c.a.p0.a.z1.b.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6760a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.w2.j.a f6761b;

    /* renamed from: c.a.p0.a.i1.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0265a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6762a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6763b;

        public C0265a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6763b = aVar;
            this.f6762a = str;
        }

        @Override // c.a.p0.a.z1.b.e.b.a
        public void a(c.a.p0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                a.d(bVar.c(), this.f6763b.f6760a, this.f6762a);
                this.f6763b.f6761b.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // c.a.p0.a.c1.d.i.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.a.c1.d.i.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    public a(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6760a = activity;
    }

    public static void d(int i2, Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i2, activity, str) == null) {
            if (i2 == 5) {
                i(activity, str);
            } else if (i2 == 6) {
                g(activity, str);
            } else if (i2 == 7) {
                f(activity, str);
            } else if (i2 != 8) {
            } else {
                h(activity, str);
            }
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("content://") || str.startsWith("file://");
        }
        return invokeL.booleanValue;
    }

    public static void f(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, activity, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("urls", new JSONArray(new String[]{str}));
                jSONObject.put("type", "0");
                jSONObject.put("index", "0");
            } catch (JSONException e2) {
                if (k.f7085a) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.a.c1.a.y().b(activity, jSONObject);
        }
    }

    public static void g(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            c.a.p0.a.c1.a.y().f(activity, new JSONObject(hashMap));
        }
    }

    public static void h(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            c.a.p0.a.c1.a.y().a(activity, new JSONObject(hashMap));
        }
    }

    public static void i(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, str) == null) {
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "type", "3");
            w.f(jSONObject, "imageUrl", str);
            w.f(jSONObject, "iconUrl", str);
            w.f(jSONObject, "source", "swan");
            w.f(jSONObject, "path", f.V().U());
            e Q = e.Q();
            if (Q != null) {
                w.f(jSONObject, "title", Q.L().K());
                PMSAppInfo f0 = Q.L().f0();
                if (f0 != null) {
                    w.f(jSONObject, "linkUrl", f0.webUrl);
                } else {
                    w.f(jSONObject, "linkUrl", str);
                }
            }
            c.a.p0.a.c1.a.Y().a(activity, jSONObject, new b());
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!e(str)) {
                this.f6761b.e(6, h.swan_app_img_menu_save_image);
            }
            this.f6761b.e(5, h.swan_app_img_menu_share_image);
        }
    }

    public void j(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str) == null) {
            c.a.p0.a.w2.j.a aVar = this.f6761b;
            if (aVar != null && aVar.n()) {
                this.f6761b.j();
            }
            c.a.p0.a.w2.j.a aVar2 = new c.a.p0.a.w2.j.a(view);
            this.f6761b = aVar2;
            aVar2.r(new C0265a(this, str));
            c(str);
            this.f6761b.t();
        }
    }
}
