package c.a.p.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.statistics.ICommandStatistics;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements ICommandStatistics<ActionData> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4630h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f4631b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f4632c;

    /* renamed from: d  reason: collision with root package name */
    public int f4633d;

    /* renamed from: e  reason: collision with root package name */
    public int f4634e;

    /* renamed from: f  reason: collision with root package name */
    public int f4635f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Pair<String, String>> f4636g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185552790, "Lc/a/p/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185552790, "Lc/a/p/c/b;");
                return;
            }
        }
        f4630h = AppConfig.isDebug();
    }

    public b(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4632c = new JSONArray();
        this.f4636g = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    /* renamed from: a */
    public void collectInfo(String str, ActionData actionData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, actionData, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("product", str);
            jSONObject.put("version", actionData == null ? "-1" : actionData.version);
            jSONObject.put("valid", z ? "1" : "0");
            if (z) {
                this.f4634e++;
            }
            this.f4632c.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final long b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            long j2 = 0;
            if (TextUtils.isEmpty(str2)) {
                return 0L;
            }
            try {
                j2 = Long.parseLong(str2);
                if (f4630h) {
                    String str3 = "action = " + str + " support imsdk long connect,new data version is  " + str2;
                }
            } catch (NumberFormatException unused) {
                if (f4630h) {
                    String str4 = "action = " + str + " support imsdk long connect,version is not right--> " + str2;
                }
            }
            return j2;
        }
        return invokeLL.longValue;
    }

    public final boolean c(Context context, String str, String str2, ActionData actionData, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, actionData, jSONObject)) == null) ? !e(jSONObject) || b(str2, actionData.version) > b(str2, c.a.p.c.d.a.e(context, str, str2)) : invokeLLLLL.booleanValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UpdateConstants.RECEIVE_TS_KEY, this.a);
                jSONObject.put("detail", this.f4632c);
                jSONObject.put("totalCount", this.f4633d);
                jSONObject.put("successCount", this.f4634e);
                jSONObject.put("versionFilterCount", this.f4635f);
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void doStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            UpdateRuntime.getUpdateContext().doStatistics(this.f4631b, d());
        }
    }

    public final boolean e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("version_asc"), "1") : invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [T, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:? -> B:46:0x00f5). Please submit an issue!!! */
    public final Map f(JsonReader jsonReader, JSONObject jSONObject) throws IOException {
        InterceptResult invokeLL;
        ActionData actionData;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, jsonReader, jSONObject)) == null) {
            jsonReader.beginObject();
            Gson gson = new Gson();
            HashMap hashMap = new HashMap();
            loop0: while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    this.f4633d++;
                    if (f4630h) {
                        r0 = "read action " + nextName + " " + nextName2;
                    }
                    Pair pair = new Pair(nextName, nextName2);
                    List<Pair<String, String>> list = this.f4636g;
                    boolean z3 = list != null && list.contains(pair);
                    try {
                        Object read = gson.getAdapter(TypeToken.get(JsonElement.class)).read(jsonReader);
                        hashMap.put(nextName + "/" + nextName2, read.toString());
                        ActionData actionData2 = new ActionData();
                        try {
                            JSONObject jSONObject2 = new JSONObject(read.toString());
                            actionData2.version = jSONObject2.getString("version");
                            actionData2.data = jSONObject2.getString("data");
                            c.a.p.c.d.a.c(AppRuntime.getAppContext(), nextName, nextName2, actionData2);
                            try {
                                synchronized (b.class) {
                                    try {
                                        actionData = actionData2;
                                        try {
                                            if (c(AppRuntime.getAppContext(), nextName, nextName2, actionData2, jSONObject)) {
                                                z = true;
                                            } else {
                                                boolean z4 = f4630h;
                                                collectInfo(nextName + "/" + nextName2, actionData, false);
                                                z = true;
                                                try {
                                                    this.f4635f++;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    try {
                                                        throw th;
                                                        break loop0;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        z2 = true;
                                                        e.printStackTrace();
                                                        String str = nextName + "/" + nextName2;
                                                        if (z3) {
                                                        }
                                                        z = false;
                                                        collectInfo(str, actionData, z);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = true;
                                            throw th;
                                            break loop0;
                                            break loop0;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        actionData = actionData2;
                                    }
                                }
                                z2 = true;
                            } catch (Exception e3) {
                                e = e3;
                                actionData = actionData2;
                                z = true;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            actionData = actionData2;
                            z = true;
                            z2 = false;
                        }
                        String str2 = nextName + "/" + nextName2;
                        if (z3 || !z2) {
                            z = false;
                        }
                        collectInfo(str2, actionData, z);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        collectInfo(nextName + "/" + nextName2, null, false);
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endObject();
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public Map g(Reader reader, int i2, JSONObject jSONObject) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, reader, i2, jSONObject)) == null) {
            this.a = String.valueOf(System.currentTimeMillis());
            this.f4631b = i2;
            Map f2 = f(new JsonReader(reader), jSONObject);
            doStatistics();
            return f2;
        }
        return (Map) invokeLIL.objValue;
    }
}
