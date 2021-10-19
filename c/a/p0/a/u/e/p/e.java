package c.a.p0.a.u.e.p;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import c.a.p0.a.p.d.y;
import c.a.p0.a.v2.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f9137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f9138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f9139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f9140h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9141i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f9142j;

        public a(e eVar, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9142j = eVar;
            this.f9137e = arrayMap;
            this.f9138f = jSONArray;
            this.f9139g = jSONArray2;
            this.f9140h = jSONArray3;
            this.f9141i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    e2.printStackTrace();
                }
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.f9137e.put(optString, optString2);
                }
            }
            this.f9142j.A(this.f9137e, this.f9138f, "images");
            this.f9142j.A(this.f9137e, this.f9139g, "urls");
            this.f9142j.A(this.f9137e, this.f9140h, "url");
            try {
                this.f9141i.put("images", this.f9138f);
                this.f9141i.put("urls", this.f9139g);
                this.f9141i.put("url", this.f9140h);
            } catch (JSONException e3) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    e3.printStackTrace();
                }
            }
            c.a.p0.a.c1.a.y().b(this.f9142j.i(), this.f9141i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayMap, jSONArray, str) == null) || arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String str2 = arrayMap.get(u(jSONArray, str, i2));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i2).put("url", str2);
                    } else {
                        jSONArray.put(i2, str2);
                    }
                } catch (JSONException e2) {
                    if (c.a.p0.a.u.c.d.f8735c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final int t(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final String u(JSONArray jSONArray, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, jSONArray, str, i2)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i2).optString("url");
            }
            return jSONArray.optString(i2);
        }
        return (String) invokeLLI.objValue;
    }

    public c.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8735c) {
                String str2 = "params = " + str;
            }
            if (l()) {
                c.a.p0.a.e0.d.b("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new c.a.p0.a.u.h.b(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new c.a.p0.a.u.h.b(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(i())) {
                        return new c.a.p0.a.u.h.b(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            z(optJSONArray2);
                            jSONObject.put("images", optJSONArray2);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i2);
                                jSONObject2.put("url", optString3);
                                String b2 = d0.b();
                                if (d0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                    jSONObject2.put("referer", b2);
                                }
                                String Y = c.a.p0.a.h0.u.g.N().Y();
                                if (c.a.p0.a.u.c.d.f8735c) {
                                    String str3 = "userAgent: " + Y;
                                }
                                if (!TextUtils.isEmpty(Y)) {
                                    jSONObject2.put(com.alipay.sdk.cons.b.f35972b, Y);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            w(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int t = t(jSONObject, optJSONArray);
                        if (t >= 0 && t < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(t));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            x(arrayMap, optJSONArray3, "images");
                            x(arrayMap, optJSONArray4, "urls");
                            x(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                y(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                c.a.p0.a.c1.a.y().b(i(), jSONObject);
                            }
                            return new c.a.p0.a.u.h.b(0);
                        }
                        return new c.a.p0.a.u.h.b(202);
                    }
                    return new c.a.p0.a.u.h.b(202);
                } catch (JSONException e2) {
                    if (c.a.p0.a.u.c.d.f8735c) {
                        e2.printStackTrace();
                    }
                    return new c.a.p0.a.u.h.b(202);
                }
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final JSONArray w(JSONArray jSONArray) {
        InterceptResult invokeL;
        c.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (i2 = c.a.p0.a.a2.e.i()) != null && !TextUtils.isEmpty(i2.f4566f) && !TextUtils.isEmpty(i2.Z())) {
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        String optString = jSONArray.optString(i3);
                        PathType s = c.a.p0.a.k2.b.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = c.a.p0.a.k2.b.M(optString, i2.f4566f);
                        } else if (s == PathType.RELATIVE) {
                            optString = c.a.p0.a.k2.b.L(optString, i2, i2.Z());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i3, optString);
                            if (c.a.p0.a.u.c.d.f8735c) {
                                String str = "convert swan path success：" + optString;
                            }
                        }
                    } catch (JSONException e2) {
                        if (c.a.p0.a.u.c.d.f8735c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void x(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, arrayMap, jSONArray, str) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String u = u(jSONArray, str, i2);
            if (!TextUtils.isEmpty(u) && c.a.p0.a.k2.b.s(u) == PathType.CLOUD) {
                arrayMap.put(u, u);
            }
        }
    }

    public final void y(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048582, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) || jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        y k = c.a.p0.a.c1.a.k();
        if (k == null) {
            return;
        }
        k.c(i(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void z(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONArray) == null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String b2 = d0.b();
                        if (d0.c(optString) && !TextUtils.isEmpty(b2)) {
                            optJSONObject.put("referer", b2);
                        }
                        String Y = c.a.p0.a.h0.u.g.N().Y();
                        if (c.a.p0.a.u.c.d.f8735c) {
                            String str = "userAgent: " + Y;
                        }
                        if (!TextUtils.isEmpty(Y)) {
                            optJSONObject.put(com.alipay.sdk.cons.b.f35972b, Y);
                        }
                    }
                } catch (JSONException e2) {
                    if (c.a.p0.a.u.c.d.f8735c) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        }
    }
}
