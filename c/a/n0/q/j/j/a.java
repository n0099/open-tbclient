package c.a.n0.q.j.j;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9261b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9262c;

    /* renamed from: d  reason: collision with root package name */
    public final String f9263d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9264e;

    /* renamed from: f  reason: collision with root package name */
    public final String f9265f;

    /* renamed from: g  reason: collision with root package name */
    public final String f9266g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<String> f9267h;
    public final String i;
    public final Long j;
    public int k;

    public a(String str, int i, int i2, String str2, String str3, String str4, String str5, Set<String> set, String str6, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, set, str6, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f9262c = i2;
        this.f9261b = i;
        this.f9263d = str2;
        this.f9264e = str3;
        this.f9265f = str4;
        this.f9266g = str5;
        this.f9267h = set;
        this.i = str6;
        this.j = l;
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                String optString = jSONObject.optString("version");
                if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return null;
                }
                String optString2 = optJSONObject.optString("content_type");
                int optInt = optJSONObject.optInt("official_no");
                int optInt2 = optJSONObject.optInt("container_no");
                String optString3 = optJSONObject.optString("host_name");
                String optString4 = optJSONObject.optString("share_callback_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                String optString5 = optJSONObject.optString("scheme_head");
                String optString6 = optJSONObject.optString("failure_url");
                HashSet hashSet = new HashSet();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString7 = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString7)) {
                            hashSet.add(optString7);
                        }
                    }
                }
                a aVar = new a(optString2, optInt, optInt2, optString3, optString4, optString6, optString, hashSet.size() > 0 ? hashSet : null, optString5, null);
                aVar.k = optJSONObject.optInt("use_openbundleid", -1);
                return aVar;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
