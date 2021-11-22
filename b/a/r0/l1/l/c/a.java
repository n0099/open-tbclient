package b.a.r0.l1.l.c;

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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f21778a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.l1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1072a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21779a;

        /* renamed from: b  reason: collision with root package name */
        public String f21780b;

        /* renamed from: c  reason: collision with root package name */
        public String f21781c;

        /* renamed from: d  reason: collision with root package name */
        public String f21782d;

        /* renamed from: e  reason: collision with root package name */
        public String f21783e;

        /* renamed from: f  reason: collision with root package name */
        public String f21784f;

        /* renamed from: g  reason: collision with root package name */
        public int f21785g;

        /* renamed from: h  reason: collision with root package name */
        public long f21786h;

        /* renamed from: i  reason: collision with root package name */
        public String f21787i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;

        public C1072a() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1013619369, "Lb/a/r0/l1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1013619369, "Lb/a/r0/l1/l/c/a;");
                return;
            }
        }
        f21778a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C1072a> a(String str, String str2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)})) == null) ? b(str, str2, null, 0L, j, j2) : (List) invokeCommon.objValue;
    }

    public static List<C1072a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, userData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = -1;
            int userType = userData != null ? userData.getUserType() : -1;
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    String optString = optJSONObject.optString("title");
                    String optString2 = optJSONObject.optString("url");
                    String optString3 = optJSONObject.optString("src");
                    String optString4 = optJSONObject.optString("text");
                    optJSONObject.optLong("picId");
                    String optString5 = optJSONObject.optString("msg_src");
                    C1072a c1072a = new C1072a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = f21778a.matcher(optString2);
                        if (matcher.find()) {
                            c1072a.n = matcher.group(1);
                        }
                    }
                    c1072a.f21782d = optString2;
                    c1072a.f21779a = optString;
                    c1072a.f21780b = optString4;
                    c1072a.f21781c = optString3;
                    c1072a.f21783e = str2;
                    c1072a.k = j2;
                    c1072a.l = j3;
                    c1072a.f21784f = optString5;
                    if (userType > i2) {
                        c1072a.f21785g = userType;
                    }
                    if (userData != null) {
                        c1072a.f21786h = j;
                        c1072a.f21787i = userData.getUserId();
                        c1072a.j = userData.getUserType();
                    }
                    linkedList.add(c1072a);
                    i3++;
                    i2 = -1;
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
