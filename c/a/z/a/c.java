package c.a.z.a;

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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f30893a;

    /* renamed from: b  reason: collision with root package name */
    public static String f30894b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30895c;

    /* renamed from: d  reason: collision with root package name */
    public static String f30896d;

    /* renamed from: e  reason: collision with root package name */
    public static Sticker f30897e;

    /* renamed from: f  reason: collision with root package name */
    public static String f30898f;

    /* renamed from: g  reason: collision with root package name */
    public static String f30899g;

    /* renamed from: h  reason: collision with root package name */
    public static String f30900h;

    /* renamed from: i  reason: collision with root package name */
    public static String f30901i;

    /* renamed from: j  reason: collision with root package name */
    public static String f30902j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f30893a : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f30898f : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? f30901i : f30902j : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f30899g : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f30897e : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f30895c : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.n()) {
                r0 = "setPath: " + str;
            }
            String str2 = str + "/";
            f30893a = str2;
            f30894b = str2;
            String str3 = f30893a + "ext/";
            f30895c = f30894b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f30898f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f30895c = "file:///android_asset/arsource/faceModels/";
                String str4 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f30899g = str4 + "/makeup";
                f30900h = str4 + "/beauty";
                f30901i = str4 + "/arFilterInit";
                f30902j = str4 + "/arFilterEditInit";
                String str5 = f30900h + "/liveVideoFace/live_face_knead.json";
                r0 = f30900h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f30900h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f30898f = f30894b + "filters/yuantu/yuantu.png";
                String str7 = f30894b + "filter/beauty_skin_stream.png";
                String str8 = f30894b + "filter/beauty_skin_small_video.png";
                f30899g = f30893a + "makeup/";
                f30900h = f30893a + "beauty/";
                f30901i = f30893a + "arFilterInit/";
                f30902j = f30893a + "arFilterEditInit/";
                String str9 = f30900h + "liveVideoFace/live_face_knead.json";
                String str10 = f30900h + "liveVideoFace/goddess_face_knead.json";
                String str11 = f30900h + "liveVideoFace/baby_face_knead.json";
                if (f30897e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f30893a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f30897e = sticker;
                }
            }
            String str12 = f30894b + "global";
            String str13 = f30894b + "vip_list.json";
            f30896d = f30894b + "filters";
            String str14 = f30894b + "dlModels/";
            String str15 = f30896d + "/all";
            String str16 = f30894b + "global/res/filter";
        }
    }
}
