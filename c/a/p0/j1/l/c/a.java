package c.a.p0.j1.l.c;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f20577a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.j1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0959a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20578a;

        /* renamed from: b  reason: collision with root package name */
        public String f20579b;

        /* renamed from: c  reason: collision with root package name */
        public String f20580c;

        /* renamed from: d  reason: collision with root package name */
        public String f20581d;

        /* renamed from: e  reason: collision with root package name */
        public String f20582e;

        /* renamed from: f  reason: collision with root package name */
        public String f20583f;

        /* renamed from: g  reason: collision with root package name */
        public int f20584g;

        /* renamed from: h  reason: collision with root package name */
        public long f20585h;

        /* renamed from: i  reason: collision with root package name */
        public String f20586i;

        /* renamed from: j  reason: collision with root package name */
        public int f20587j;
        public long k;
        public long l;
        public long m;
        public String n;

        public C0959a() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-435138616, "Lc/a/p0/j1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-435138616, "Lc/a/p0/j1/l/c/a;");
                return;
            }
        }
        f20577a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C0959a> a(String str, String str2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? b(str, str2, null, 0L, j2, j3) : (List) invokeCommon.objValue;
    }

    public static List<C0959a> b(String str, String str2, UserData userData, long j2, long j3, long j4) {
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
                    C0959a c0959a = new C0959a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = f20577a.matcher(optString2);
                        if (matcher.find()) {
                            c0959a.n = matcher.group(1);
                        }
                    }
                    c0959a.f20581d = optString2;
                    c0959a.f20578a = optString;
                    c0959a.f20579b = optString4;
                    c0959a.f20580c = optString3;
                    c0959a.f20582e = str2;
                    c0959a.k = j3;
                    c0959a.l = j4;
                    c0959a.f20583f = optString5;
                    if (userType > i2) {
                        c0959a.f20584g = userType;
                    }
                    if (userData != null) {
                        c0959a.f20585h = j2;
                        c0959a.f20586i = userData.getUserId();
                        c0959a.f20587j = userData.getUserType();
                    }
                    linkedList.add(c0959a);
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
