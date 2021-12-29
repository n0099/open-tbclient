package c.a.t0.s1.l.c;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.s1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1354a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22779b;

        /* renamed from: c  reason: collision with root package name */
        public String f22780c;

        /* renamed from: d  reason: collision with root package name */
        public String f22781d;

        /* renamed from: e  reason: collision with root package name */
        public String f22782e;

        /* renamed from: f  reason: collision with root package name */
        public String f22783f;

        /* renamed from: g  reason: collision with root package name */
        public int f22784g;

        /* renamed from: h  reason: collision with root package name */
        public long f22785h;

        /* renamed from: i  reason: collision with root package name */
        public String f22786i;

        /* renamed from: j  reason: collision with root package name */
        public int f22787j;

        /* renamed from: k  reason: collision with root package name */
        public long f22788k;
        public long l;
        public long m;
        public String n;

        public C1354a() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(993971277, "Lc/a/t0/s1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(993971277, "Lc/a/t0/s1/l/c/a;");
                return;
            }
        }
        a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C1354a> a(String str, String str2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? b(str, str2, null, 0L, j2, j3) : (List) invokeCommon.objValue;
    }

    public static List<C1354a> b(String str, String str2, UserData userData, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, userData, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
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
                    C1354a c1354a = new C1354a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = a.matcher(optString2);
                        if (matcher.find()) {
                            c1354a.n = matcher.group(1);
                        }
                    }
                    c1354a.f22781d = optString2;
                    c1354a.a = optString;
                    c1354a.f22779b = optString4;
                    c1354a.f22780c = optString3;
                    c1354a.f22782e = str2;
                    c1354a.f22788k = j3;
                    c1354a.l = j4;
                    c1354a.f22783f = optString5;
                    if (userType > i2) {
                        c1354a.f22784g = userType;
                    }
                    if (userData != null) {
                        c1354a.f22785h = j2;
                        c1354a.f22786i = userData.getUserId();
                        c1354a.f22787j = userData.getUserType();
                    }
                    linkedList.add(c1354a);
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
