package b.a.p0.a.h2.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.l0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f6382a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6383b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6384c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6385d;

    /* renamed from: e  reason: collision with root package name */
    public String f6386e;

    /* renamed from: f  reason: collision with root package name */
    public String f6387f;

    /* renamed from: g  reason: collision with root package name */
    public String f6388g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f6389h;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f6390i;
    public int j;
    public String k;
    public String l;
    public String m;
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<f> s;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6391a;

        /* renamed from: b  reason: collision with root package name */
        public String f6392b;

        /* renamed from: c  reason: collision with root package name */
        public String f6393c;

        /* renamed from: d  reason: collision with root package name */
        public String f6394d;

        /* renamed from: e  reason: collision with root package name */
        public String f6395e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f6396f;

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

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6386e = "";
        this.f6387f = "";
        this.f6388g = "";
        this.f6389h = new ArrayList();
        this.f6390i = new ArrayList();
        this.j = -1;
        this.k = "";
        this.l = "";
        this.m = "";
        this.f6383b = str;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (l0.f("3.320.0")) {
                return str;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1456866260:
                    if (str.equals("scope.phoneContact")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -653473286:
                    if (str.equals("scope.userLocation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -21617665:
                    if (str.equals("scope.camera")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 277279100:
                    if (str.equals("scope.mobile")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 411225387:
                    if (str.equals("scope.record")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 583039347:
                    if (str.equals("scope.userInfo")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 671518104:
                    if (str.equals("scope.calendar")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 986629481:
                    if (str.equals("scope.writePhotosAlbum")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1303164176:
                    if (str.equals("scope.faceVerify")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1326852849:
                    if (str.equals("scope.realNameInfo")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 1555675269:
                    if (str.equals("scope.invoiceTitle")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1927763546:
                    if (str.equals("scope.address")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return "snsapi_userinfo";
                case 1:
                    return "mobile";
                case 2:
                    return "mapp_location";
                case 3:
                    return "mapp_images";
                case 4:
                    return "mapp_choose_address";
                case 5:
                    return "mapp_choose_invoice";
                case 6:
                    return PermissionProxy.SCOPE_ID_CAMERA;
                case 7:
                    return PermissionProxy.SCOPE_ID_RECORD;
                case '\b':
                    return "mapp_i_face_verify";
                case '\t':
                    return "ppcert";
                case '\n':
                    return "scope_calendar";
                case 11:
                    return "mapp_i_read_contacts";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (l0.f("3.320.0")) {
                return str;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1994404663:
                    if (str.equals("scope_calendar")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -1785599184:
                    if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1603097981:
                    if (str.equals("mapp_images")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1352756132:
                    if (str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1074510320:
                    if (str.equals("mapp_choose_invoice")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -982018012:
                    if (str.equals("ppcert")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -977063690:
                    if (str.equals("snsapi_userinfo")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -218238720:
                    if (str.equals("mapp_location")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 112565975:
                    if (str.equals("mapp_choose_address")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 862108635:
                    if (str.equals("mapp_i_read_contacts")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1746078554:
                    if (str.equals("mapp_i_face_verify")) {
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return "scope.userInfo";
                case 1:
                    return "scope.mobile";
                case 2:
                    return "scope.userLocation";
                case 3:
                    return "scope.writePhotosAlbum";
                case 4:
                    return "scope.address";
                case 5:
                    return "scope.invoiceTitle";
                case 6:
                    return "scope.camera";
                case 7:
                    return "scope.record";
                case '\b':
                    return "scope.faceVerify";
                case '\t':
                    return "scope.realNameInfo";
                case '\n':
                    return "scope.calendar";
                case 11:
                    return "scope.phoneContact";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static f f(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, jSONObject)) == null) {
            f fVar = new f(str);
            fVar.f6382a = jSONObject;
            fVar.f6384c = jSONObject.optBoolean("permit", false);
            fVar.f6385d = jSONObject.optBoolean("forbidden", true);
            fVar.f6386e = jSONObject.optString("grade");
            fVar.k = jSONObject.optString("type", "");
            fVar.f6387f = jSONObject.optString("name", "");
            fVar.f6388g = jSONObject.optString("short_name", "");
            jSONObject.optString("description", "");
            fVar.j = jSONObject.optInt("tip_status", -1);
            fVar.l = jSONObject.optString("explain", "");
            fVar.m = jSONObject.optString("sub_explain", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("ext");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    fVar.f6390i.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    fVar.f6389h.add(optJSONArray2.optString(i3));
                }
            }
            fVar.o = jSONObject.optJSONObject("other");
            fVar.p = jSONObject.optString("plugin_app_name");
            fVar.q = jSONObject.optString("plugin_icon_url");
            if (!jSONObject.has("forbidden")) {
                b.a.p0.a.e0.d.k("SwanAppUpdateManager", "scope:" + str + WebGLImageLoader.DATA_URL + jSONObject);
            }
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public static f g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("id", "");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return f(optString, jSONObject);
        }
        return (f) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j > 0 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "1".equals(this.k) : invokeV.booleanValue;
    }

    public void h() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jSONObject = this.o) == null || jSONObject.keys() == null || !this.o.keys().hasNext()) {
            return;
        }
        a aVar = new a();
        this.n = aVar;
        aVar.f6391a = this.o.optString("detail_text");
        this.n.f6393c = this.o.optString("detail_url");
        this.n.f6392b = this.o.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
        this.n.f6394d = this.o.optString("keyword");
        this.n.f6395e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f6396f = optJSONObject.optJSONArray("details");
        }
    }

    public void i(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s = list;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f6383b, Integer.valueOf(this.j)) : (String) invokeV.objValue;
    }
}
