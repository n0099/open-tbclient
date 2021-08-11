package b.a.a.a.w;

import android.text.TextUtils;
import b.a.a.a.r;
import b.a.a.a.u.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1 A[Catch: JSONException -> 0x0117, TryCatch #0 {JSONException -> 0x0117, blocks: (B:15:0x002e, B:18:0x003e, B:20:0x0045, B:35:0x007f, B:37:0x0088, B:39:0x009a, B:45:0x00ac, B:47:0x00b4, B:53:0x00e1, B:55:0x00e9, B:57:0x00f6, B:48:0x00c6, B:50:0x00ce, B:23:0x004f, B:24:0x0056, B:26:0x005c, B:33:0x0077, B:32:0x0074, B:31:0x006f, B:34:0x007a), top: B:66:0x002e }] */
    @Override // b.a.a.a.w.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p d(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        String sb;
        String str;
        String str2;
        String optString;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            Object f2 = r.f("com.bytedance.sdk.openadsdk.core.e.m", obj);
            if (f2 == null) {
                return null;
            }
            try {
                obj2 = f2.getClass().getDeclaredMethod("aO", null).invoke(f2, new Object[0]);
            } catch (Exception e2) {
                b.a.a.a.x.d.c(e2);
                obj2 = null;
            }
            if (obj2 == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(obj2.toString());
                JSONObject optJSONObject3 = jSONObject.optJSONObject("icon");
                String optString2 = optJSONObject3 != null ? optJSONObject3.optString("url") : null;
                JSONArray optJSONArray = jSONObject.optJSONArray("image");
                if (optJSONArray == null) {
                    sb = null;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    boolean z = true;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString3 = optJSONArray.getJSONObject(i2).optString("url");
                        if (!TextUtils.isEmpty(optString3)) {
                            if (z) {
                                z = false;
                            } else {
                                sb2.append(',');
                            }
                            sb2.append(optString3);
                        }
                    }
                    sb = sb2.toString();
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("video");
                if (optJSONObject4 != null) {
                    String optString4 = optJSONObject4.optString("video_url");
                    str = optJSONObject4.optString("cover_url");
                    str2 = optString4;
                } else {
                    str = null;
                    str2 = null;
                }
                int optInt = jSONObject.optInt("interaction_type", -1);
                if (optInt != 3) {
                    if (optInt == 4 && (optJSONObject2 = jSONObject.optJSONObject("app")) != null) {
                        str3 = optJSONObject2.optString("app_name");
                        str4 = optJSONObject2.optString("package_name");
                        str5 = optJSONObject2.optString("download_url");
                        optString = null;
                        if (str3 == null || (optJSONObject = jSONObject.optJSONObject("app_manage")) == null) {
                            str6 = str3;
                            str7 = str4;
                        } else {
                            String optString5 = optJSONObject.optString("app_name");
                            str7 = optJSONObject.optString("package_name");
                            str6 = optString5;
                        }
                        return new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null);
                    }
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    optString = null;
                    if (str3 == null) {
                    }
                    str6 = str3;
                    str7 = str4;
                    return new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("deep_link");
                if (optJSONObject5 != null) {
                    optString = optJSONObject5.optString("deeplink_url");
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    if (str3 == null) {
                    }
                    str6 = str3;
                    str7 = str4;
                    return new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null);
                }
                str3 = null;
                str4 = null;
                str5 = null;
                optString = null;
                if (str3 == null) {
                }
                str6 = str3;
                str7 = str4;
                return new p(jSONObject.optString("source"), jSONObject.optString("title"), jSONObject.optString("description"), optString2, str6, str7, str5, sb, str, str2, jSONObject.optString("target_url"), optString, null);
            } catch (JSONException e3) {
                b.a.a.a.x.d.c(e3);
                return null;
            }
        }
        return (p) invokeL.objValue;
    }
}
