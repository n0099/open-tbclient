package c.a.p0.s2;

import androidx.core.app.NotificationCompat;
import c.a.o0.s.q.b1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f24010a;

    /* renamed from: b  reason: collision with root package name */
    public b1 f24011b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f24012a;

        /* renamed from: b  reason: collision with root package name */
        public String f24013b;

        /* renamed from: c  reason: collision with root package name */
        public long f24014c;

        /* renamed from: d  reason: collision with root package name */
        public String f24015d;

        /* renamed from: e  reason: collision with root package name */
        public String f24016e;

        /* renamed from: f  reason: collision with root package name */
        public long f24017f;

        /* renamed from: g  reason: collision with root package name */
        public int f24018g;

        /* renamed from: h  reason: collision with root package name */
        public int f24019h;

        /* renamed from: i  reason: collision with root package name */
        public String f24020i;

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
                return;
            }
        }
        this.f24010a = new ArrayList();
        this.f24011b = new b1();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<a> list = this.f24010a;
            return (list == null || list.size() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b1 b1Var = this.f24011b;
            return b1Var != null && b1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String str2 = "";
            if (jSONObject == null) {
                return;
            }
            try {
                this.f24011b.i(jSONObject.getJSONObject("page"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    return;
                }
                this.f24010a.clear();
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (jSONObject2 == null) {
                        jSONArray = optJSONArray;
                        str = str2;
                        i2 = i3;
                    } else {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                        String optString = jSONObject3.optString("name_show", str2);
                        jSONObject3.optString("name", str2);
                        long optLong = jSONObject2.optLong("pid", 0L);
                        String optString2 = jSONObject2.optString("title", str2);
                        long optLong2 = jSONObject2.optLong("time", 0L) * 1000;
                        String optString3 = jSONObject2.optString("content", str2);
                        String optString4 = jSONObject2.optString("fname", str2);
                        long optLong3 = jSONObject2.optLong("tid", 0L);
                        jSONArray = optJSONArray;
                        int optInt = jSONObject2.optInt("is_floor", 0);
                        str = str2;
                        int optInt2 = jSONObject2.optInt("is_replay", 0);
                        i2 = i3;
                        if (jSONObject2.optInt("thread_type", 0) != 33) {
                            a aVar = new a();
                            aVar.f24012a = optLong;
                            aVar.f24013b = optString2;
                            aVar.f24014c = optLong2;
                            aVar.f24015d = optString3;
                            aVar.f24016e = optString4;
                            aVar.f24017f = optLong3;
                            aVar.f24018g = optInt;
                            aVar.f24019h = optInt2;
                            aVar.f24020i = optString;
                            this.f24010a.add(aVar);
                        }
                    }
                    i3 = i2 + 1;
                    optJSONArray = jSONArray;
                    str2 = str;
                }
            } catch (Exception e2) {
                BdLog.d(e2.getMessage());
            }
        }
    }
}
