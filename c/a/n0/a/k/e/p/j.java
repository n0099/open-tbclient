package c.a.n0.a.k.e.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.y;
import c.a.n0.a.p2.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends c.a.n0.a.k.e.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayMap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5262b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5263c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONArray f5264d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5265e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f5266f;

        public a(j jVar, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5266f = jVar;
            this.a = arrayMap;
            this.f5262b = jSONArray;
            this.f5263c = jSONArray2;
            this.f5264d = jSONArray3;
            this.f5265e = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.a.put(optString, optString2);
                }
            }
            this.f5266f.G(this.a, this.f5262b, "images");
            this.f5266f.G(this.a, this.f5263c, "urls");
            this.f5266f.G(this.a, this.f5264d, "url");
            try {
                this.f5265e.put("images", this.f5262b);
                this.f5265e.put("urls", this.f5263c);
                this.f5265e.put("url", this.f5264d);
            } catch (JSONException unused2) {
            }
            SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
            if (activity == null) {
                c.a.n0.a.s0.a.C().b(this.f5266f.getContext(), this.f5265e);
            } else {
                c.a.n0.a.s0.a.C().b(activity, this.f5265e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String A(JSONArray jSONArray, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, jSONArray, str, i)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i).optString("url");
            }
            return jSONArray.optString(i);
        }
        return (String) invokeLLI.objValue;
    }

    public c.a.n0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#handlePreviewImage", false);
            if (n()) {
                c.a.n0.a.u.d.c("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new c.a.n0.a.k.h.b(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new c.a.n0.a.k.h.b(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(getContext())) {
                        return new c.a.n0.a.k.h.b(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            F(optJSONArray2);
                            jSONObject.put("images", optJSONArray2);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i);
                                jSONObject2.put("url", optString3);
                                String b2 = d0.b();
                                if (d0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                    jSONObject2.put(Config.LAUNCH_REFERER, b2);
                                }
                                String g0 = c.a.n0.a.x.u.g.U().g0();
                                if (!TextUtils.isEmpty(g0)) {
                                    jSONObject2.put(HttpRequest.USER_AGENT, g0);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            C(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int z = z(jSONObject, optJSONArray);
                        if (z >= 0 && z < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(z));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            D(arrayMap, optJSONArray3, "images");
                            D(arrayMap, optJSONArray4, "urls");
                            D(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                E(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                Context activity = c.a.n0.a.w0.f.U().getActivity();
                                if (activity != null) {
                                    c.a.n0.a.s0.a.C().b(activity, jSONObject);
                                } else {
                                    c.a.n0.a.s0.a.C().b(getContext(), jSONObject);
                                }
                            }
                            return c.a.n0.a.k.h.b.f();
                        }
                        return new c.a.n0.a.k.h.b(202);
                    }
                    return new c.a.n0.a.k.h.b(202);
                } catch (JSONException unused) {
                    return new c.a.n0.a.k.h.b(202);
                }
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final JSONArray C(JSONArray jSONArray) {
        InterceptResult invokeL;
        c.a.n0.a.t1.e L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (L = c.a.n0.a.t1.e.L()) != null && !TextUtils.isEmpty(L.f6344b) && !TextUtils.isEmpty(L.j0())) {
                for (int i = 0; i < length; i++) {
                    try {
                        String optString = jSONArray.optString(i);
                        PathType s = c.a.n0.a.e2.b.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = c.a.n0.a.e2.b.M(optString, L.f6344b);
                        } else if (s == PathType.RELATIVE) {
                            optString = c.a.n0.a.e2.b.L(optString, L, L.j0());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i, optString);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void D(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, arrayMap, jSONArray, str) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String A = A(jSONArray, str, i);
            if (!TextUtils.isEmpty(A) && c.a.n0.a.e2.b.s(A) == PathType.CLOUD) {
                arrayMap.put(A, A);
            }
        }
    }

    public final void E(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048580, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) || jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        y l = c.a.n0.a.s0.a.l();
        if (l == null) {
            return;
        }
        l.c(getContext(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void F(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String b2 = d0.b();
                        if (d0.c(optString) && !TextUtils.isEmpty(b2)) {
                            optJSONObject.put(Config.LAUNCH_REFERER, b2);
                        }
                        String g0 = c.a.n0.a.x.u.g.U().g0();
                        if (!TextUtils.isEmpty(g0)) {
                            optJSONObject.put(HttpRequest.USER_AGENT, g0);
                        }
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        }
    }

    public final void G(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, arrayMap, jSONArray, str) == null) || arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String str2 = arrayMap.get(A(jSONArray, str, i));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i).put("url", str2);
                    } else {
                        jSONArray.put(i, str2);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "PreviewImageApi" : (String) invokeV.objValue;
    }

    public final int z(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(optString, jSONArray.getString(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
