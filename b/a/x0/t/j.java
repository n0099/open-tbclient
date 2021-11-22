package b.a.x0.t;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, HashMap> f30794a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);

        void b();

        void c(String str);

        void d();

        void e(boolean z);

        void f(boolean z);

        void g(int i2);

        void h();

        void i();

        void j(String str);

        void k(int i2);

        void onRecordEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2102737764, "Lb/a/x0/t/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2102737764, "Lb/a/x0/t/j;");
                return;
            }
        }
        f30794a = new HashMap<>();
    }

    public static HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "capture_timer_clear");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "capture_timer_start");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sex_type", Integer.valueOf(i2));
            hashMap.put("event_name", "sex_event");
            hashMap.put("event_data", hashMap2);
            return hashMap;
        }
        return (HashMap) invokeI.objValue;
    }

    public static HashMap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (f30794a.get(str) != null) {
                return f30794a.get(str);
            }
            HashMap hashMap = null;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1909077165:
                    if (str.equals("startRecord")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1848594969:
                    if (str.equals("pauseRecord")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -815530368:
                    if (str.equals("resetRecord")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -793791417:
                    if (str.equals("startOverRecord")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 473974106:
                    if (str.equals("capture_timer_clear")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 488985455:
                    if (str.equals("capture_timer_start")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                hashMap = h();
            } else if (c2 == 1) {
                hashMap = f();
            } else if (c2 == 2) {
                hashMap = g();
            } else if (c2 == 3) {
                hashMap = a();
            } else if (c2 == 4) {
                hashMap = b();
            } else if (c2 == 5) {
                hashMap = i();
            }
            if (hashMap != null) {
                f30794a.put(str, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap e(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Double.valueOf(d2)})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "audio_volume");
            hashMap.put("event_data", String.valueOf(Math.ceil(d2)));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public static HashMap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_pause");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_reset");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_start");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_start_over");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static void j(HashMap<String, Object> hashMap, a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, hashMap, aVar) == null) || h.f(hashMap) || aVar == null || (obj = hashMap.get("event_name")) == null || !(obj instanceof String)) {
            return;
        }
        String str = (String) obj;
        char c2 = 65535;
        int i2 = 0;
        switch (str.hashCode()) {
            case -1903331025:
                if (str.equals("show_text")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1768834290:
                if (str.equals("game_end")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1584838740:
                if (str.equals("filter_adjust_enable")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1272940549:
                if (str.equals("game_is_ready")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -708270859:
                if (str.equals("phone_shake")) {
                    c2 = 1;
                    break;
                }
                break;
            case -672934016:
                if (str.equals("case_reset")) {
                    c2 = 5;
                    break;
                }
                break;
            case -548493597:
                if (str.equals("need_volume")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 902635637:
                if (str.equals("child_status")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 967087977:
                if (str.equals("game_pause")) {
                    c2 = 2;
                    break;
                }
                break;
            case 969912325:
                if (str.equals("game_score")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1000807605:
                if (str.equals("game_http")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1001154298:
                if (str.equals("game_time")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1076032614:
                if (str.equals("need_face")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (hashMap.get("text_content") instanceof String) {
                    aVar.c((String) hashMap.get("text_content"));
                    return;
                }
                return;
            case 1:
                aVar.d();
                return;
            case 2:
            case 3:
                if (hashMap.get("game_score") != null) {
                    aVar.a(hashMap.get("game_score").toString());
                    return;
                }
                return;
            case 4:
                if (hashMap.get("game_score") != null) {
                    aVar.a(hashMap.get("game_score").toString());
                }
                aVar.onRecordEnd();
                return;
            case 5:
                aVar.h();
                return;
            case 6:
                aVar.b();
                return;
            case 7:
                if (hashMap.get("text_content") instanceof Float) {
                    try {
                        i2 = ((Float) hashMap.get("text_content")).intValue();
                    } catch (Exception e2) {
                        c.g(e2);
                    }
                    aVar.g(i2);
                    return;
                }
                return;
            case '\b':
                if (hashMap.get("isDefaultChild") != null) {
                    String obj2 = hashMap.get("isDefaultChild").toString();
                    if (!TextUtils.equals(obj2, "1.0") && !TextUtils.equals(obj2, "1")) {
                        r3 = false;
                    }
                    aVar.f(r3);
                    return;
                }
                return;
            case '\t':
                if (hashMap.get("volume_ability") != null) {
                    aVar.e(g.a(hashMap.get("volume_ability").toString(), 0.0f) == 1.0f);
                    return;
                }
                return;
            case '\n':
                aVar.i();
                return;
            case 11:
                if (hashMap.get("globalBeautyMakeupFilter") == null || !(hashMap.get("globalBeautyMakeupFilter") instanceof Float)) {
                    return;
                }
                aVar.k(((Float) hashMap.get("globalBeautyMakeupFilter")).intValue());
                return;
            case '\f':
                if (hashMap.get("set_content") != null) {
                    aVar.j(hashMap.get("set_content").toString());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
