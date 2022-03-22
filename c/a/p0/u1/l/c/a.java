package c.a.p0.u1.l.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.u1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1417a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f18834b;

        /* renamed from: c  reason: collision with root package name */
        public String f18835c;

        /* renamed from: d  reason: collision with root package name */
        public String f18836d;

        /* renamed from: e  reason: collision with root package name */
        public String f18837e;

        /* renamed from: f  reason: collision with root package name */
        public String f18838f;

        /* renamed from: g  reason: collision with root package name */
        public int f18839g;

        /* renamed from: h  reason: collision with root package name */
        public long f18840h;
        public String i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;

        public C1417a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1157698771, "Lc/a/p0/u1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1157698771, "Lc/a/p0/u1/l/c/a;");
                return;
            }
        }
        a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C1417a> a(String str, String str2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)})) == null) ? b(str, str2, null, 0L, j, j2) : (List) invokeCommon.objValue;
    }

    public static List<C1417a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, userData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i = -1;
            int userType = userData != null ? userData.getUserType() : -1;
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("title");
                    String optString2 = optJSONObject.optString("url");
                    String optString3 = optJSONObject.optString("src");
                    String optString4 = optJSONObject.optString("text");
                    optJSONObject.optLong("picId");
                    String optString5 = optJSONObject.optString("msg_src");
                    C1417a c1417a = new C1417a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = a.matcher(optString2);
                        if (matcher.find()) {
                            c1417a.n = matcher.group(1);
                        }
                    }
                    c1417a.f18836d = optString2;
                    c1417a.a = optString;
                    c1417a.f18834b = optString4;
                    c1417a.f18835c = optString3;
                    c1417a.f18837e = str2;
                    c1417a.k = j2;
                    c1417a.l = j3;
                    c1417a.f18838f = optString5;
                    if (userType > i) {
                        c1417a.f18839g = userType;
                    }
                    if (userData != null) {
                        c1417a.f18840h = j;
                        c1417a.i = userData.getUserId();
                        c1417a.j = userData.getUserType();
                    }
                    linkedList.add(c1417a);
                    i2++;
                    i = -1;
                }
                return linkedList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeCommon.objValue;
    }
}
