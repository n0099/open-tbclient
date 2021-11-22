package b.a.p0.q.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.q.i.i;
import b.a.p0.q.j.l.b;
import b.a.p0.q.k.i.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PMSAppInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appKey = jSONObject.optString("app_key");
            pMSAppInfo.appName = jSONObject.optString("app_name");
            pMSAppInfo.description = jSONObject.optString("app_desc");
            pMSAppInfo.appStatus = jSONObject.optInt("app_status");
            pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
            pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
            pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
            pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
            pMSAppInfo.maxAge = jSONObject.optLong("max_age");
            pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
            pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
            pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
            pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
            pMSAppInfo.domainConfig = jSONObject.optString("domain_config");
            pMSAppInfo.webAction = jSONObject.optString("web_action");
            pMSAppInfo.domains = jSONObject.optString("domains");
            pMSAppInfo.serverExt = jSONObject.optString("ext");
            pMSAppInfo.appSign = jSONObject.optLong("app_sign");
            pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
            pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
            pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.paNumber = jSONObject.optString("pa_number");
            String optString = p(pMSAppInfo.serverExt).optString("quick_app_key");
            if (!TextUtils.isEmpty(optString)) {
                pMSAppInfo.quickAppKey = optString;
            }
            JSONObject optJSONObject = p(pMSAppInfo.serverExt).optJSONObject(SwanAppBearInfo.BEAR_INFO);
            if (optJSONObject != null) {
                pMSAppInfo.bearInfo = optJSONObject.toString();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
            if (optJSONArray != null) {
                pMSAppInfo.pluginInfo = optJSONArray.toString();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("brand");
            if (optJSONObject2 != null) {
                pMSAppInfo.brandsInfo = optJSONObject2.toString();
            }
            b.a.p0.q.c.b().k(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
            b.a.p0.q.c.b().s(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
            pMSAppInfo.webUrl = jSONObject.optString("web_url");
            pMSAppInfo.rank = jSONObject.optInt("rank");
            pMSAppInfo.webPermit = jSONObject.optInt("web_permit");
            pMSAppInfo.csProtocolVersion = PMSConstants.a.a();
            pMSAppInfo.userActionApis = jSONObject.optString("user_action_apis");
            return pMSAppInfo;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public static boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && 1 == jSONObject.optInt("reset_env", 0) : invokeL.booleanValue;
    }

    public static b.a.p0.q.i.c c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (b.a.p0.q.i.c) j(jSONObject, new b.a.p0.q.i.c());
        }
        return (b.a.p0.q.i.c) invokeL.objValue;
    }

    public static b.a.p0.q.i.e d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (b.a.p0.q.i.e) j(jSONObject, new b.a.p0.q.i.e());
        }
        return (b.a.p0.q.i.e) invokeL.objValue;
    }

    public static b.a.p0.q.j.l.a e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.a aVar = new b.a.p0.q.j.l.a();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            List<i> l = l(optJSONArray);
            aVar.f11845c = l;
            if (l != null && l.contains(null)) {
                k(aVar, optJSONArray);
            } else {
                aVar.f11843a = 0;
            }
            return aVar;
        }
        return (b.a.p0.q.j.l.a) invokeL.objValue;
    }

    public static b.a.p0.q.j.l.b f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.b bVar = new b.a.p0.q.j.l.b();
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    b.a aVar = new b.a();
                    aVar.f11847a = optJSONObject.optInt("errno");
                    aVar.f11848b = optJSONObject.optString("bundle_id");
                    aVar.f11849c = optJSONObject.optInt("category");
                    aVar.f11850d = m(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                    aVar.f11851e = n(optJSONObject.optJSONArray("sub"));
                    aVar.f11852f = l(optJSONObject.optJSONArray("dep"));
                    aVar.f11853g = a(optJSONObject.optJSONObject("app_info"));
                    b.a.p0.q.c.b().p(aVar.f11848b, optJSONObject, aVar.f11850d, aVar.f11851e);
                    arrayList.add(aVar);
                }
            }
            bVar.f11846a = arrayList;
            return bVar;
        }
        return (b.a.p0.q.j.l.b) invokeL.objValue;
    }

    public static b.a.p0.q.j.l.c g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.c cVar = new b.a.p0.q.j.l.c();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                cVar.f11855a = m(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                cVar.f11856b = n(optJSONObject.optJSONArray("sub"));
                cVar.f11857c = l(optJSONObject.optJSONArray("dep"));
                b.a.p0.q.c.b().p(str, optJSONObject, cVar.f11855a, cVar.f11856b);
            }
            cVar.f11858d = d(jSONObject.optJSONObject("framework"));
            cVar.f11860f = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            cVar.f11859e = a(jSONObject.optJSONObject("app_info"));
            return cVar;
        }
        return (b.a.p0.q.j.l.c) invokeLL.objValue;
    }

    public static b.a.p0.q.j.l.d h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.d dVar = new b.a.p0.q.j.l.d();
            dVar.f11861a = o(jSONObject);
            return dVar;
        }
        return (b.a.p0.q.j.l.d) invokeL.objValue;
    }

    public static b.a.p0.q.j.l.e i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.e eVar = new b.a.p0.q.j.l.e();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                eVar.f11862a = n(optJSONObject.optJSONArray("sub"));
                b.a.p0.q.c.b().p(str, optJSONObject, null, eVar.f11862a);
            }
            return eVar;
        }
        return (b.a.p0.q.j.l.e) invokeLL.objValue;
    }

    public static <T extends b.a.p0.q.i.f> T j(JSONObject jSONObject, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, t)) == null) {
            if (jSONObject == null || t == null) {
                return null;
            }
            t.f11774g = jSONObject.optString("bundle_id");
            t.f11775h = jSONObject.optInt("category");
            t.j = jSONObject.optString("version_name");
            t.f11776i = jSONObject.optLong("version_code");
            t.k = jSONObject.optLong("size");
            t.l = jSONObject.optString(PackageTable.MD5);
            t.m = jSONObject.optString("sign");
            t.n = jSONObject.optString("download_url");
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static void k(b.a.p0.q.j.l.a aVar, JSONArray jSONArray) {
        int optInt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, aVar, jSONArray) == null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("errno", 0)) != 0) {
                String optString = optJSONObject.optString("bundle_id");
                aVar.f11843a = optInt;
                aVar.f11844b = String.format("%s : Not Exist.", optString);
                return;
            }
        }
    }

    public static List<i> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("app_info");
                        i o = o(optJSONObject2);
                        if (o != null && optJSONObject3 != null) {
                            o.r = optJSONObject3.optString("app_key");
                            o.s = optJSONObject3.optString("app_name");
                            o.q = optJSONObject3.optString("domains");
                        }
                        arrayList.add(o);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static b.a.p0.q.i.g m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.i.g gVar = (b.a.p0.q.i.g) j(jSONObject, new b.a.p0.q.i.g());
            gVar.o = jSONObject.optInt("pkg_type");
            gVar.p = jSONObject.optString("ext");
            return gVar;
        }
        return (b.a.p0.q.i.g) invokeL.objValue;
    }

    public static List<b.a.p0.q.i.h> n(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    b.a.p0.q.i.h hVar = (b.a.p0.q.i.h) j(optJSONObject, new b.a.p0.q.i.h());
                    hVar.q = optJSONObject.optInt("pkg_type");
                    hVar.p = optJSONObject.optString("sub_path");
                    hVar.r = optJSONObject.optBoolean("independent");
                    hVar.s = optJSONObject.optString("ext");
                    arrayList.add(hVar);
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static i o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            i iVar = new i();
            j(jSONObject, iVar);
            long optLong = jSONObject.optLong("max_age");
            if (optLong < 0) {
                optLong = 0;
            }
            iVar.o = optLong;
            return iVar;
        }
        return (i) invokeL.objValue;
    }

    public static JSONObject p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static b.a.p0.q.j.l.f q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b.a.p0.q.j.l.f fVar = new b.a.p0.q.j.l.f();
            fVar.f11863a = jSONObject.optLong("max_age");
            long optLong = jSONObject.optLong("lastsynctime");
            if (optLong > 0) {
                n.f11933c = optLong;
            }
            fVar.f11864b = jSONObject;
            return fVar;
        }
        return (b.a.p0.q.j.l.f) invokeL.objValue;
    }
}
