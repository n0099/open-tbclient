package c.a.n0.h.c;

import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.a.r0.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f10773a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838856305, "Lc/a/n0/h/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1838856305, "Lc/a/n0/h/c/f;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        f10773a = hashMap;
        hashMap.put("494433", EmotionResourceProvider.EMOTION_SOUND_SUFFIX);
        f10773a.put("524946", ".wav");
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
            }
            String sb2 = sb.toString();
            if (k.f6803a) {
                String str = "audio buffer header: " + sb2;
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) ? f2 <= 1.0f && f2 >= 0.0f : invokeF.booleanValue;
    }

    public static d c(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gVar)) == null) {
            d dVar = new d();
            dVar.f10760a = gVar.f10775f;
            dVar.f10764e = gVar.autoplay;
            dVar.f10765f = gVar.loop;
            dVar.f10762c = gVar.src;
            dVar.f10763d = gVar.startTime;
            dVar.f10766g = gVar.obeyMuteSwitch;
            dVar.f10768i = gVar.volume;
            dVar.f10769j = i().toString();
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public static String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
            return "/" + c.a.n0.a.a2.e.V() + "/" + str.hashCode() + substring;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = n.n() + "/usr";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            String str2 = "create targetFile dir error, path is " + file.getAbsolutePath();
            new Throwable();
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            return File.separator + "bdata" + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String e2 = e();
            return (!j() || TextUtils.isEmpty(e2)) ? AppRuntime.getAppContext().getCacheDir().getAbsolutePath() : e2;
        }
        return (String) invokeV.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr == null || 3 > bArr.length) {
                return "";
            }
            byte[] bArr2 = new byte[3];
            for (int i2 = 0; i2 < 3; i2++) {
                bArr2[i2] = bArr[i2];
            }
            return f10773a.get(a(bArr2));
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onCanplay", "canplay");
                jSONObject.put("onPlay", "play");
                jSONObject.put("onEnded", "ended");
                jSONObject.put(MissionEvent.MESSAGE_PAUSE, "pause");
                jSONObject.put("onSeeking", "seeking");
                jSONObject.put("onSeeked", "seeked");
                jSONObject.put(MissionEvent.MESSAGE_STOP, IntentConfig.STOP);
                jSONObject.put("onError", "error");
                jSONObject.put("onTimeUpdate", "timeupdate");
                jSONObject.put("onBufferingUpdate", "buffered");
                jSONObject.put("onWaiting", "waiting");
            } catch (Exception e2) {
                if (k.f6803a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "mounted".equals(Environment.getExternalStorageState()) : invokeV.booleanValue;
    }
}
