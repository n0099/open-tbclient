package b.a.a0.a;

import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1136a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f1137b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1138c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1139d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1140e;

    /* renamed from: f  reason: collision with root package name */
    public static Sticker f1141f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1142g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1143h;

    /* renamed from: i  reason: collision with root package name */
    public static String f1144i;
    public static String j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1041052193, "Lb/a/a0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1041052193, "Lb/a/a0/a/c;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1137b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1142g : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? j : k : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f1143h : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1141f : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1139d : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.m()) {
                r0 = "setPath: " + str;
            }
            String str2 = str + "/";
            f1137b = str2;
            f1138c = str2;
            String str3 = f1137b + "ext/";
            f1139d = f1138c + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f1142g = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f1139d = "file:///android_asset/arsource/faceModels/";
                String str4 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f1143h = str4 + "/makeup";
                f1144i = str4 + "/beauty";
                j = str4 + "/arFilterInit";
                k = str4 + "/arFilterEditInit";
                String str5 = f1144i + "/liveVideoFace/live_face_knead.json";
                r0 = f1144i + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f1144i + "/liveVideoFace/baby_face_knead.json";
            } else {
                f1142g = f1138c + "filters/yuantu/yuantu.png";
                String str7 = f1138c + "filter/beauty_skin_stream.png";
                String str8 = f1138c + "filter/beauty_skin_small_video.png";
                f1143h = f1137b + "makeup/";
                f1144i = f1137b + "beauty/";
                j = f1137b + "arFilterInit/";
                k = f1137b + "arFilterEditInit/";
                String str9 = f1144i + "liveVideoFace/live_face_knead.json";
                String str10 = f1144i + "liveVideoFace/goddess_face_knead.json";
                String str11 = f1144i + "liveVideoFace/baby_face_knead.json";
                if (f1141f == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f1137b + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f1141f = sticker;
                }
            }
            String str12 = f1138c + "global";
            String str13 = f1138c + "vip_list.json";
            f1140e = f1138c + "filters";
            String str14 = f1138c + "dlModels/";
            String str15 = f1140e + "/all";
            String str16 = f1138c + "global/res/filter";
        }
    }
}
