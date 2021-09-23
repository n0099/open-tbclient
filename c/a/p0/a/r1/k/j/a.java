package c.a.p0.a.r1.k.j;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f8429b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f8430c;

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
                return;
            }
        }
        this.f8429b = "boxjs.";
        this.f8430c = Sets.newHashSet("getAppInfoSync", "performpanel", "statisticEvent", "ubcReport", "getSlaveIdSync", "ubcFlowJar");
    }

    @Override // c.a.p0.a.r1.k.j.c
    public List<c.a.p0.a.r1.k.a> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
            c("api-name " + optString);
            if (TextUtils.isEmpty(optString)) {
                return arrayList;
            }
            int optInt = jSONObject.optInt("count");
            c("api-count " + optInt);
            if (optInt <= 0) {
                return arrayList;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
            if (optJSONArray != null && optJSONArray2 != null) {
                int min = Math.min(optJSONArray.length(), optJSONArray2.length());
                if (min <= 0) {
                    return arrayList;
                }
                for (int i2 = 0; i2 < min; i2++) {
                    c.a.p0.a.r1.k.a aVar = new c.a.p0.a.r1.k.a();
                    aVar.f(optString);
                    aVar.g(b(aVar));
                    aVar.i(optJSONArray.optLong(i2));
                    aVar.h(optJSONArray2.optLong(i2));
                    arrayList.add(aVar);
                    if (c.f8431a) {
                        c(aVar.toString());
                    }
                }
                return arrayList;
            }
            c("startTimes or endTimes is empty");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final int b(c.a.p0.a.r1.k.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            String a2 = aVar.a();
            if (TextUtils.isEmpty(a2)) {
                return 0;
            }
            return (a2.startsWith(this.f8429b) || this.f8430c.contains(a2)) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            boolean z = c.f8431a;
        }
    }
}
