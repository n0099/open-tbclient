package c.a.o0.a.e2.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f5510a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5511b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5512c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5513d;

    /* renamed from: e  reason: collision with root package name */
    public String f5514e;

    /* renamed from: f  reason: collision with root package name */
    public String f5515f;

    /* renamed from: g  reason: collision with root package name */
    public String f5516g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f5517h;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f5518i;

    /* renamed from: j  reason: collision with root package name */
    public int f5519j;
    public String k;
    public String l;
    public String m;
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<f> s;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5520a;

        /* renamed from: b  reason: collision with root package name */
        public String f5521b;

        /* renamed from: c  reason: collision with root package name */
        public String f5522c;

        /* renamed from: d  reason: collision with root package name */
        public String f5523d;

        /* renamed from: e  reason: collision with root package name */
        public String f5524e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f5525f;

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
                }
            }
        }
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5514e = "";
        this.f5515f = "";
        this.f5516g = "";
        this.f5517h = new ArrayList();
        this.f5518i = new ArrayList();
        this.f5519j = -1;
        this.k = "";
        this.l = "";
        this.m = "";
        this.f5511b = str;
    }

    public static f d(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
            f fVar = new f(str);
            fVar.f5510a = jSONObject;
            fVar.f5512c = jSONObject.optBoolean("permit", false);
            fVar.f5513d = jSONObject.optBoolean("forbidden", true);
            fVar.f5514e = jSONObject.optString("grade");
            fVar.k = jSONObject.optString("type", "");
            fVar.f5515f = jSONObject.optString("name", "");
            fVar.f5516g = jSONObject.optString("short_name", "");
            jSONObject.optString("description", "");
            fVar.f5519j = jSONObject.optInt("tip_status", -1);
            fVar.l = jSONObject.optString("explain", "");
            fVar.m = jSONObject.optString("sub_explain", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("ext");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    fVar.f5518i.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    fVar.f5517h.add(optJSONArray2.optString(i3));
                }
            }
            fVar.o = jSONObject.optJSONObject("other");
            fVar.p = jSONObject.optString("plugin_app_name");
            fVar.q = jSONObject.optString("plugin_icon_url");
            if (!jSONObject.has("forbidden")) {
                c.a.o0.a.e0.d.h("SwanAppUpdateManager", "scope:" + str + WebGLImageLoader.DATA_URL + jSONObject);
            }
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public static f e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("id", "");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return d(optString, jSONObject);
        }
        return (f) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5519j > 0 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5519j != 0 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "1".equals(this.k) : invokeV.booleanValue;
    }

    public void f() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jSONObject = this.o) == null || jSONObject.keys() == null || !this.o.keys().hasNext()) {
            return;
        }
        a aVar = new a();
        this.n = aVar;
        aVar.f5520a = this.o.optString("detail_text");
        this.n.f5522c = this.o.optString("detail_url");
        this.n.f5521b = this.o.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
        this.n.f5523d = this.o.optString("keyword");
        this.n.f5524e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f5525f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s = list;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f5511b, Integer.valueOf(this.f5519j)) : (String) invokeV.objValue;
    }
}
