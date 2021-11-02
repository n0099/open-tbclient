package b.a.p0.a.u.e.p;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import b.a.p0.a.p.d.y;
import b.a.p0.a.v2.d0;
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
public class e extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f8388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8389f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8390g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8391h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8392i;
        public final /* synthetic */ e j;

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
            this.j = eVar;
            this.f8388e = arrayMap;
            this.f8389f = jSONArray;
            this.f8390g = jSONArray2;
            this.f8391h = jSONArray3;
            this.f8392i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
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
                if (b.a.p0.a.u.c.d.f8000c) {
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
                    this.f8388e.put(optString, optString2);
                }
            }
            this.j.z(this.f8388e, this.f8389f, "images");
            this.j.z(this.f8388e, this.f8390g, "urls");
            this.j.z(this.f8388e, this.f8391h, "url");
            try {
                this.f8392i.put("images", this.f8389f);
                this.f8392i.put("urls", this.f8390g);
                this.f8392i.put("url", this.f8391h);
            } catch (JSONException e3) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e3.printStackTrace();
                }
            }
            b.a.p0.a.c1.a.y().b(this.j.getContext(), this.f8392i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int s(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, jSONArray)) == null) {
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

    public final String t(JSONArray jSONArray, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, i2)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i2).optString("url");
            }
            return jSONArray.optString(i2);
        }
        return (String) invokeLLI.objValue;
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "params = " + str;
            }
            if (k()) {
                b.a.p0.a.e0.d.b("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(getContext())) {
                        return new b.a.p0.a.u.h.b(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            y(optJSONArray2);
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
                                String X = b.a.p0.a.h0.u.g.M().X();
                                if (b.a.p0.a.u.c.d.f8000c) {
                                    String str3 = "userAgent: " + X;
                                }
                                if (!TextUtils.isEmpty(X)) {
                                    jSONObject2.put(com.alipay.sdk.cons.b.f34073b, X);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            v(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int s = s(jSONObject, optJSONArray);
                        if (s >= 0 && s < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(s));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            w(arrayMap, optJSONArray3, "images");
                            w(arrayMap, optJSONArray4, "urls");
                            w(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                x(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                b.a.p0.a.c1.a.y().b(getContext(), jSONObject);
                            }
                            return new b.a.p0.a.u.h.b(0);
                        }
                        return new b.a.p0.a.u.h.b(202);
                    }
                    return new b.a.p0.a.u.h.b(202);
                } catch (JSONException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        e2.printStackTrace();
                    }
                    return new b.a.p0.a.u.h.b(202);
                }
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final JSONArray v(JSONArray jSONArray) {
        InterceptResult invokeL;
        b.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (i2 = b.a.p0.a.a2.e.i()) != null && !TextUtils.isEmpty(i2.f3961f) && !TextUtils.isEmpty(i2.Y())) {
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        String optString = jSONArray.optString(i3);
                        PathType s = b.a.p0.a.k2.b.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = b.a.p0.a.k2.b.M(optString, i2.f3961f);
                        } else if (s == PathType.RELATIVE) {
                            optString = b.a.p0.a.k2.b.L(optString, i2, i2.Y());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i3, optString);
                            if (b.a.p0.a.u.c.d.f8000c) {
                                String str = "convert swan path success：" + optString;
                            }
                        }
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void w(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, arrayMap, jSONArray, str) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String t = t(jSONArray, str, i2);
            if (!TextUtils.isEmpty(t) && b.a.p0.a.k2.b.s(t) == PathType.CLOUD) {
                arrayMap.put(t, t);
            }
        }
    }

    public final void x(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) || jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        y k = b.a.p0.a.c1.a.k();
        if (k == null) {
            return;
        }
        k.c(getContext(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void y(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
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
                        String X = b.a.p0.a.h0.u.g.M().X();
                        if (b.a.p0.a.u.c.d.f8000c) {
                            String str = "userAgent: " + X;
                        }
                        if (!TextUtils.isEmpty(X)) {
                            optJSONObject.put(com.alipay.sdk.cons.b.f34073b, X);
                        }
                    }
                } catch (JSONException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void z(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, arrayMap, jSONArray, str) == null) || arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String str2 = arrayMap.get(t(jSONArray, str, i2));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i2).put("url", str2);
                    } else {
                        jSONArray.put(i2, str2);
                    }
                } catch (JSONException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
