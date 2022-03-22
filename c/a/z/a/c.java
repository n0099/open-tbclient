package c.a.z.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f22139b;

    /* renamed from: c  reason: collision with root package name */
    public static String f22140c;

    /* renamed from: d  reason: collision with root package name */
    public static String f22141d;

    /* renamed from: e  reason: collision with root package name */
    public static String f22142e;

    /* renamed from: f  reason: collision with root package name */
    public static Sticker f22143f;

    /* renamed from: g  reason: collision with root package name */
    public static String f22144g;

    /* renamed from: h  reason: collision with root package name */
    public static String f22145h;
    public static String i;
    public static String j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-899320831, "Lc/a/z/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-899320831, "Lc/a/z/a/c;");
        }
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(str);
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f22139b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f22144g : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) ? z ? j : k : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f22145h : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f22143f : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f22141d : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.m()) {
                Log.d("DuAr_DuArResConfig", "setPath: " + str);
            }
            String str2 = str + "/";
            f22139b = str2;
            f22140c = str2;
            r0 = f22139b + "ext/";
            f22141d = f22140c + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f22144g = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f22141d = "file:///android_asset/arsource/faceModels/";
                String str3 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f22145h = str3 + "/makeup";
                i = str3 + "/beauty";
                j = str3 + "/arFilterInit";
                k = str3 + "/arFilterEditInit";
                String str4 = i + "/liveVideoFace/live_face_knead.json";
                String str5 = i + "/liveVideoFace/goddess_face_knead.json";
                String str6 = i + "/liveVideoFace/baby_face_knead.json";
            } else {
                f22144g = f22140c + "filters/yuantu/yuantu.png";
                String str7 = f22140c + "filter/beauty_skin_stream.png";
                String str8 = f22140c + "filter/beauty_skin_small_video.png";
                f22145h = f22139b + "makeup/";
                i = f22139b + "beauty/";
                j = f22139b + "arFilterInit/";
                k = f22139b + "arFilterEditInit/";
                r0 = i + "liveVideoFace/live_face_knead.json";
                String str9 = i + "liveVideoFace/goddess_face_knead.json";
                String str10 = i + "liveVideoFace/baby_face_knead.json";
                if (f22143f == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f22139b + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f22143f = sticker;
                }
            }
            r0 = f22140c + NodeJS.GLOBAL;
            String str11 = f22140c + "vip_list.json";
            f22142e = f22140c + "filters";
            r0 = f22140c + "dlModels/";
            String str12 = f22142e + "/all";
            r0 = f22140c + "global/res/filter";
        }
    }
}
