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
    public static String f1107b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1108c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1109d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1110e;

    /* renamed from: f  reason: collision with root package name */
    public static Sticker f1111f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1112g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1113h;

    /* renamed from: i  reason: collision with root package name */
    public static String f1114i;

    /* renamed from: j  reason: collision with root package name */
    public static String f1115j;

    /* renamed from: k  reason: collision with root package name */
    public static String f1116k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1107b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1112g : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) ? z ? f1115j : f1116k : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f1113h : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1111f : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1109d : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.m()) {
                r0 = "setPath: " + str;
            }
            String str2 = str + "/";
            f1107b = str2;
            f1108c = str2;
            String str3 = f1107b + "ext/";
            f1109d = f1108c + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f1112g = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f1109d = "file:///android_asset/arsource/faceModels/";
                String str4 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f1113h = str4 + "/makeup";
                f1114i = str4 + "/beauty";
                f1115j = str4 + "/arFilterInit";
                f1116k = str4 + "/arFilterEditInit";
                String str5 = f1114i + "/liveVideoFace/live_face_knead.json";
                r0 = f1114i + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f1114i + "/liveVideoFace/baby_face_knead.json";
            } else {
                f1112g = f1108c + "filters/yuantu/yuantu.png";
                String str7 = f1108c + "filter/beauty_skin_stream.png";
                String str8 = f1108c + "filter/beauty_skin_small_video.png";
                f1113h = f1107b + "makeup/";
                f1114i = f1107b + "beauty/";
                f1115j = f1107b + "arFilterInit/";
                f1116k = f1107b + "arFilterEditInit/";
                String str9 = f1114i + "liveVideoFace/live_face_knead.json";
                String str10 = f1114i + "liveVideoFace/goddess_face_knead.json";
                String str11 = f1114i + "liveVideoFace/baby_face_knead.json";
                if (f1111f == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f1107b + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f1111f = sticker;
                }
            }
            String str12 = f1108c + NodeJS.GLOBAL;
            String str13 = f1108c + "vip_list.json";
            f1110e = f1108c + "filters";
            String str14 = f1108c + "dlModels/";
            String str15 = f1110e + "/all";
            String str16 = f1108c + "global/res/filter";
        }
    }
}
