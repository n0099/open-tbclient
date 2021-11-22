package b.a.p0.q.k.j;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f11944a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11945b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11946c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11947d;

    /* renamed from: e  reason: collision with root package name */
    public final String f11948e;

    /* renamed from: f  reason: collision with root package name */
    public final String f11949f;

    /* renamed from: g  reason: collision with root package name */
    public final String f11950g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<String> f11951h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11952i;
    public final Long j;
    public int k;

    public a(String str, int i2, int i3, String str2, String str3, String str4, String str5, Set<String> set, String str6, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, set, str6, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11944a = str;
        this.f11946c = i3;
        this.f11945b = i2;
        this.f11947d = str2;
        this.f11948e = str3;
        this.f11949f = str4;
        this.f11950g = str5;
        this.f11951h = set;
        this.f11952i = str6;
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
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString7 = optJSONArray.optString(i2);
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
