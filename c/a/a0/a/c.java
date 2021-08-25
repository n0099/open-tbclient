package c.a.a0.a;

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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f1647a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1648b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1649c;

    /* renamed from: d  reason: collision with root package name */
    public static String f1650d;

    /* renamed from: e  reason: collision with root package name */
    public static Sticker f1651e;

    /* renamed from: f  reason: collision with root package name */
    public static String f1652f;

    /* renamed from: g  reason: collision with root package name */
    public static String f1653g;

    /* renamed from: h  reason: collision with root package name */
    public static String f1654h;

    /* renamed from: i  reason: collision with root package name */
    public static String f1655i;

    /* renamed from: j  reason: collision with root package name */
    public static String f1656j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1647a : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1652f : (String) invokeV.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? f1655i : f1656j : (String) invokeZ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f1653g : (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f1651e : (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1649c : (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (b.n()) {
                r0 = "setPath: " + str;
            }
            String str2 = str + "/";
            f1647a = str2;
            f1648b = str2;
            String str3 = f1647a + "ext/";
            f1649c = f1648b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f1652f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                f1649c = "file:///android_asset/arsource/faceModels/";
                String str4 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                f1653g = str4 + "/makeup";
                f1654h = str4 + "/beauty";
                f1655i = str4 + "/arFilterInit";
                f1656j = str4 + "/arFilterEditInit";
                String str5 = f1654h + "/liveVideoFace/live_face_knead.json";
                r0 = f1654h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = f1654h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f1652f = f1648b + "filters/yuantu/yuantu.png";
                String str7 = f1648b + "filter/beauty_skin_stream.png";
                String str8 = f1648b + "filter/beauty_skin_small_video.png";
                f1653g = f1647a + "makeup/";
                f1654h = f1647a + "beauty/";
                f1655i = f1647a + "arFilterInit/";
                f1656j = f1647a + "arFilterEditInit/";
                String str9 = f1654h + "liveVideoFace/live_face_knead.json";
                String str10 = f1654h + "liveVideoFace/goddess_face_knead.json";
                String str11 = f1654h + "liveVideoFace/baby_face_knead.json";
                if (f1651e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(f1647a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    f1651e = sticker;
                }
            }
            String str12 = f1648b + "global";
            String str13 = f1648b + "vip_list.json";
            f1650d = f1648b + "filters";
            String str14 = f1648b + "dlModels/";
            String str15 = f1650d + "/all";
            String str16 = f1648b + "global/res/filter";
        }
    }
}
