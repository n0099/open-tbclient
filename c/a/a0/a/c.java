package c.a.a0.a;

import android.os.Environment;
import android.text.TextUtils;
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
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f1105b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1106c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1107d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1108e;

    /* renamed from: f  reason: collision with root package name */
    public static Sticker f1109f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1110g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1111h;

    /* renamed from: i  reason: collision with root package name */
    public static String f1112i;

    /* renamed from: j  reason: collision with root package name */
    public static String f1113j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1456963744, "Lc/a/a0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1456963744, "Lc/a/a0/a/c;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1105b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1110g : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) ? z ? f1113j : k : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f1111h : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1109f : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1107d : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.m()) {
                r0 = "setPath: " + str;
            }
            String str2 = str + "/";
            f1105b = str2;
            f1106c = str2;
            String str3 = f1105b + "ext/";
            f1107d = f1106c + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f1110g = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f1107d = "file:///android_asset/arsource/faceModels/";
                String str4 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f1111h = str4 + "/makeup";
                f1112i = str4 + "/beauty";
                f1113j = str4 + "/arFilterInit";
                k = str4 + "/arFilterEditInit";
                String str5 = f1112i + "/liveVideoFace/live_face_knead.json";
                r0 = f1112i + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f1112i + "/liveVideoFace/baby_face_knead.json";
            } else {
                f1110g = f1106c + "filters/yuantu/yuantu.png";
                String str7 = f1106c + "filter/beauty_skin_stream.png";
                String str8 = f1106c + "filter/beauty_skin_small_video.png";
                f1111h = f1105b + "makeup/";
                f1112i = f1105b + "beauty/";
                f1113j = f1105b + "arFilterInit/";
                k = f1105b + "arFilterEditInit/";
                String str9 = f1112i + "liveVideoFace/live_face_knead.json";
                String str10 = f1112i + "liveVideoFace/goddess_face_knead.json";
                String str11 = f1112i + "liveVideoFace/baby_face_knead.json";
                if (f1109f == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f1105b + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f1109f = sticker;
                }
            }
            String str12 = f1106c + NodeJS.GLOBAL;
            String str13 = f1106c + "vip_list.json";
            f1108e = f1106c + "filters";
            String str14 = f1106c + "dlModels/";
            String str15 = f1108e + "/all";
            String str16 = f1106c + "global/res/filter";
        }
    }
}
