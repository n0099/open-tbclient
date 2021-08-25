package c.a.q0.j1.l.c;

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
    public static Pattern f20907a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.j1.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0970a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f20908a;

        /* renamed from: b  reason: collision with root package name */
        public String f20909b;

        /* renamed from: c  reason: collision with root package name */
        public String f20910c;

        /* renamed from: d  reason: collision with root package name */
        public String f20911d;

        /* renamed from: e  reason: collision with root package name */
        public String f20912e;

        /* renamed from: f  reason: collision with root package name */
        public String f20913f;

        /* renamed from: g  reason: collision with root package name */
        public int f20914g;

        /* renamed from: h  reason: collision with root package name */
        public long f20915h;

        /* renamed from: i  reason: collision with root package name */
        public String f20916i;

        /* renamed from: j  reason: collision with root package name */
        public int f20917j;
        public long k;
        public long l;
        public long m;
        public String n;

        public C0970a() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-306055897, "Lc/a/q0/j1/l/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-306055897, "Lc/a/q0/j1/l/c/a;");
                return;
            }
        }
        f20907a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
    }

    public static List<C0970a> a(String str, String str2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? b(str, str2, null, 0L, j2, j3) : (List) invokeCommon.objValue;
    }

    public static List<C0970a> b(String str, String str2, UserData userData, long j2, long j3, long j4) {
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
                    C0970a c0970a = new C0970a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = f20907a.matcher(optString2);
                        if (matcher.find()) {
                            c0970a.n = matcher.group(1);
                        }
                    }
                    c0970a.f20911d = optString2;
                    c0970a.f20908a = optString;
                    c0970a.f20909b = optString4;
                    c0970a.f20910c = optString3;
                    c0970a.f20912e = str2;
                    c0970a.k = j3;
                    c0970a.l = j4;
                    c0970a.f20913f = optString5;
                    if (userType > i2) {
                        c0970a.f20914g = userType;
                    }
                    if (userData != null) {
                        c0970a.f20915h = j2;
                        c0970a.f20916i = userData.getUserId();
                        c0970a.f20917j = userData.getUserType();
                    }
                    linkedList.add(c0970a);
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
