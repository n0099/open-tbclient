package c.a.p0.a.u.e.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p.d.y;
import c.a.p0.a.z2.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.SwanAppActivity;
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
public class j extends c.a.p0.a.u.e.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f8451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8453g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8454h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8455i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ j f8456j;

        public a(j jVar, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8456j = jVar;
            this.f8451e = arrayMap;
            this.f8452f = jSONArray;
            this.f8453g = jSONArray2;
            this.f8454h = jSONArray3;
            this.f8455i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
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
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.f8451e.put(optString, optString2);
                }
            }
            this.f8456j.G(this.f8451e, this.f8452f, "images");
            this.f8456j.G(this.f8451e, this.f8453g, "urls");
            this.f8456j.G(this.f8451e, this.f8454h, "url");
            try {
                this.f8455i.put("images", this.f8452f);
                this.f8455i.put("urls", this.f8453g);
                this.f8455i.put("url", this.f8454h);
            } catch (JSONException unused2) {
            }
            SwanAppActivity activity = c.a.p0.a.g1.f.U().getActivity();
            if (activity == null) {
                c.a.p0.a.c1.a.C().b(this.f8456j.getContext(), this.f8455i);
            } else {
                c.a.p0.a.c1.a.C().b(activity, this.f8455i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public final String A(JSONArray jSONArray, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, jSONArray, str, i2)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i2).optString("url");
            }
            return jSONArray.optString(i2);
        }
        return (String) invokeLLI.objValue;
    }

    public c.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#handlePreviewImage", false);
            if (n()) {
                c.a.p0.a.e0.d.c("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new c.a.p0.a.u.h.b(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new c.a.p0.a.u.h.b(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(getContext())) {
                        return new c.a.p0.a.u.h.b(403);
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
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i2);
                                jSONObject2.put("url", optString3);
                                String b2 = d0.b();
                                if (d0.c(optString3) && !TextUtils.isEmpty(b2)) {
                                    jSONObject2.put("referer", b2);
                                }
                                String g0 = c.a.p0.a.h0.u.g.U().g0();
                                if (!TextUtils.isEmpty(g0)) {
                                    jSONObject2.put(com.alipay.sdk.cons.b.f31302b, g0);
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
                                Context activity = c.a.p0.a.g1.f.U().getActivity();
                                if (activity != null) {
                                    c.a.p0.a.c1.a.C().b(activity, jSONObject);
                                } else {
                                    c.a.p0.a.c1.a.C().b(getContext(), jSONObject);
                                }
                            }
                            return c.a.p0.a.u.h.b.f();
                        }
                        return new c.a.p0.a.u.h.b(202);
                    }
                    return new c.a.p0.a.u.h.b(202);
                } catch (JSONException unused) {
                    return new c.a.p0.a.u.h.b(202);
                }
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final JSONArray C(JSONArray jSONArray) {
        InterceptResult invokeL;
        c.a.p0.a.d2.e L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (L = c.a.p0.a.d2.e.L()) != null && !TextUtils.isEmpty(L.f4616f) && !TextUtils.isEmpty(L.j0())) {
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        String optString = jSONArray.optString(i2);
                        PathType s = c.a.p0.a.o2.b.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = c.a.p0.a.o2.b.M(optString, L.f4616f);
                        } else if (s == PathType.RELATIVE) {
                            optString = c.a.p0.a.o2.b.L(optString, L, L.j0());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i2, optString);
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
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String A = A(jSONArray, str, i2);
            if (!TextUtils.isEmpty(A) && c.a.p0.a.o2.b.s(A) == PathType.CLOUD) {
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
        y l = c.a.p0.a.c1.a.l();
        if (l == null) {
            return;
        }
        l.c(getContext(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void F(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
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
                        String g0 = c.a.p0.a.h0.u.g.U().g0();
                        if (!TextUtils.isEmpty(g0)) {
                            optJSONObject.put(com.alipay.sdk.cons.b.f31302b, g0);
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
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String str2 = arrayMap.get(A(jSONArray, str, i2));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i2).put("url", str2);
                    } else {
                        jSONArray.put(i2, str2);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Override // c.a.p0.a.u.c.d
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
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
