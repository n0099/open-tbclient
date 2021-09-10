package c.a.r0.m3.f;

import android.app.Application;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RemindRecommendMessage a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                RemindRecommendMessage remindRecommendMessage = new RemindRecommendMessage();
                JSONObject jSONObject = new JSONObject(str);
                remindRecommendMessage.title = jSONObject.optString("title");
                remindRecommendMessage.url = jSONObject.optString("url");
                remindRecommendMessage.picture = jSONObject.optString("picture");
                remindRecommendMessage.name = jSONObject.optString("name");
                remindRecommendMessage.isLocal = false;
                return remindRecommendMessage;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (RemindRecommendMessage) invokeL.objValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c(System.currentTimeMillis()) : invokeV.longValue;
    }

    public static long c(long j2) {
        InterceptResult invokeJ;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            String loadString = TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_dialog_time", "12:05:00");
            String[] split = (TextUtils.isEmpty(loadString) ? "12:05:00" : loadString).split(":");
            int i5 = 5;
            if (split == null || split.length != 3) {
                i2 = 0;
                i3 = 12;
                i4 = 5;
            } else {
                i3 = c.a.e.e.m.b.e(split[0], 12);
                i4 = c.a.e.e.m.b.e(split[1], 5);
                i2 = c.a.e.e.m.b.e(split[2], 0);
            }
            if (i3 < 0 || i3 > 23 || i4 < 0 || i4 > 59 || i2 < 0 || i2 > 59) {
                i2 = 0;
                i3 = 12;
            } else {
                i5 = i4;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            calendar.set(12, i5);
            calendar.set(13, i2);
            Application app = TbadkCoreApplication.getInst().getApp();
            if (app != null && app.getContentResolver() != null && DateFormat.is24HourFormat(app)) {
                calendar.set(11, i3);
            } else {
                if (i3 >= 12) {
                    i3 -= 12;
                    calendar.set(9, 1);
                } else {
                    calendar.set(9, 0);
                }
                calendar.set(10, i3);
            }
            return calendar.getTimeInMillis();
        }
        return invokeJ.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            sb.append("remind_recommend_server_switch");
            return TbadkSettings.getInst().loadInt(sb.toString(), 1) == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.q0.s.d0.b.j().k("sync_local_dialog", 1) == 1 : invokeV.booleanValue;
    }

    public static boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j2)) == null) {
            Time time = new Time();
            time.set(j2);
            int i2 = time.year;
            int i3 = time.month;
            int i4 = time.monthDay;
            time.set(System.currentTimeMillis());
            return i2 == time.year && i3 == time.month && i4 == time.monthDay;
        }
        return invokeJ.booleanValue;
    }

    public static String g(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, dataRes)) == null) {
            if (dataRes != null && dataRes.local_dialog != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", dataRes.local_dialog.title);
                    jSONObject.put("picture", dataRes.local_dialog.picture);
                    jSONObject.put("url", dataRes.local_dialog.url);
                    jSONObject.put("name", dataRes.local_dialog.name);
                    return jSONObject.toString();
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
