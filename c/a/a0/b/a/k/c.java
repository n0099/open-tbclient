package c.a.a0.b.a.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "MediaTrackUtils";

    /* renamed from: b  reason: collision with root package name */
    public static String f1281b = "FILTER_MATRIX";

    /* renamed from: c  reason: collision with root package name */
    public static String f1282c = "FILTER_LUT";

    /* renamed from: d  reason: collision with root package name */
    public static String f1283d = "FILTER_SUB_LUT";

    /* renamed from: e  reason: collision with root package name */
    public static String f1284e = "FILTER_SUBTITLE";

    /* renamed from: f  reason: collision with root package name */
    public static String f1285f = "FILTER_STICKER";

    /* renamed from: g  reason: collision with root package name */
    public static String f1286g = "FILTER_GAUSSIAN_BLUR_H";

    /* renamed from: h  reason: collision with root package name */
    public static String f1287h = "FILTER_GAUSSIAN_BLUR_V";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f1288i = false;

    /* renamed from: j  reason: collision with root package name */
    public static int f1289j = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1947864431, "Lc/a/a0/b/a/k/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1947864431, "Lc/a/a0/b/a/k/c;");
        }
    }

    public static void a(MediaTrack mediaTrack, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, mediaTrack, j2) == null) {
            a.b(mediaTrack, j2);
            n(mediaTrack);
        }
    }

    public static void b(MediaTrack mediaTrack, Map<String, ShaderConfig> map, MediaTrack mediaTrack2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, mediaTrack, map, mediaTrack2) == null) {
            a.f(mediaTrack, map, mediaTrack2);
        }
    }

    public static void c(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, mediaTrack, mediaTrackConfig) == null) {
            a.g(mediaTrack, mediaTrackConfig);
        }
    }

    public static void d(MediaTrack mediaTrack, List<MediaSegment> list, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaTrack, list, mediaTrackConfig) == null) {
            a.h(mediaTrack, list, mediaTrackConfig);
        }
    }

    public static List<MediaTrack> e(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, Map<String, ShaderConfig> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, mediaTrack, mediaTrackConfig, map)) == null) {
            List<MediaTrack> j2 = a.j(mediaTrack, mediaTrackConfig, map);
            for (MediaTrack mediaTrack2 : j2) {
                n(mediaTrack2);
            }
            return j2;
        }
        return (List) invokeLLL.objValue;
    }

    public static String f(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, context, str, str2, str3)) == null) ? a.o(context, str, str2, str3) : (String) invokeLLLL.objValue;
    }

    public static Bitmap g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.contains(File.separator)) {
                return BitmapFactory.decodeResource(context.getResources(), h(str, context));
            }
            return BitmapFactory.decodeFile(str);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static int h(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, context)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                int identifier = context.getResources().getIdentifier(str, "drawable", applicationInfo.packageName);
                return identifier == 0 ? context.getResources().getIdentifier(str, "mipmap", applicationInfo.packageName) : identifier;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static MediaAEffect i(MediaTrack mediaTrack, MediaTrackConfig mediaTrackConfig, String str, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{mediaTrack, mediaTrackConfig, str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) ? a.t(mediaTrack, mediaTrackConfig, str, i2, i3, j2) : (MediaAEffect) invokeCommon.objValue;
    }

    public static String j(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) ? a.v(context, str, str2) : (String) invokeLLL.objValue;
    }

    public static boolean k(List<MediaTrack> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, list, str)) == null) ? a.x(list, str) : invokeLL.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f1288i : invokeV.booleanValue;
    }

    public static boolean m(MediaTrack mediaTrack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, mediaTrack, str)) == null) ? a.E(mediaTrack, str) : invokeLL.booleanValue;
    }

    public static void n(MediaTrack mediaTrack) {
        String str;
        ShaderParams next;
        Iterator<ShaderParams> it;
        String str2;
        ShaderParams next2;
        Iterator<ShaderParams> it2;
        MediaSegment mediaSegment;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, mediaTrack) == null) {
            MediaTrack mediaTrack2 = mediaTrack;
            if (f1288i) {
                List<MediaSegment> list = mediaTrack2.mediaSegments;
                String str5 = PreferencesUtil.LEFT_MOUNT;
                String str6 = ": ";
                if (list != null) {
                    int i2 = 0;
                    while (i2 < mediaTrack2.mediaSegments.size()) {
                        MediaSegment mediaSegment2 = mediaTrack2.mediaSegments.get(i2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(" --> segment : ");
                        sb.append(i2);
                        sb.append(str6);
                        sb.append(mediaSegment2.type);
                        sb.append("--->");
                        sb.append(mediaSegment2.start);
                        sb.append("----");
                        sb.append(mediaSegment2.end);
                        sb.append("---> scaleType --->");
                        sb.append(mediaSegment2.scaleType);
                        String str7 = " shaderConfigKey --->";
                        sb.append(" shaderConfigKey --->");
                        sb.append(mediaSegment2.shaderConfigKey);
                        sb.append(" effectConfigKey --->");
                        sb.append(mediaSegment2.effectConfigKey);
                        sb.toString();
                        MediaAEffect mediaAEffect = mediaSegment2.mediaAEffect;
                        if (mediaAEffect != null && mediaAEffect.mediaOneAEffects != null) {
                            int i3 = 0;
                            while (i3 < mediaSegment2.mediaAEffect.mediaOneAEffects.size()) {
                                MediaOneAEffect mediaOneAEffect = mediaSegment2.mediaAEffect.mediaOneAEffects.get(i3);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("effect : ");
                                sb2.append(i2);
                                sb2.append("->");
                                sb2.append(i3);
                                sb2.append(str6);
                                String str8 = str5;
                                String str9 = str6;
                                sb2.append(mediaOneAEffect.start);
                                sb2.append("----");
                                sb2.append(mediaOneAEffect.end);
                                sb2.append(str7);
                                sb2.append(mediaSegment2.mediaAEffect.shaderConfigKey);
                                sb2.toString();
                                List<ShaderParams> list2 = mediaOneAEffect.aParams;
                                if (list2 != null) {
                                    Iterator<ShaderParams> it3 = list2.iterator();
                                    while (it3.hasNext()) {
                                        float[] fArr = it3.next().values;
                                        if (fArr != null) {
                                            int length = fArr.length;
                                            it2 = it3;
                                            str4 = str8;
                                            int i4 = 0;
                                            while (true) {
                                                mediaSegment = mediaSegment2;
                                                if (i4 >= length) {
                                                    break;
                                                }
                                                str4 = str4 + fArr[i4] + "---";
                                                i4++;
                                                mediaSegment2 = mediaSegment;
                                                str7 = str7;
                                            }
                                            str3 = str7;
                                        } else {
                                            it2 = it3;
                                            mediaSegment = mediaSegment2;
                                            str3 = str7;
                                            str4 = str8;
                                        }
                                        String str10 = "ShaderParams ------> type: " + next2.type + " name: " + next2.name + " values: " + (str4 + PreferencesUtil.RIGHT_MOUNT);
                                        it3 = it2;
                                        mediaSegment2 = mediaSegment;
                                        str7 = str3;
                                    }
                                }
                                i3++;
                                str5 = str8;
                                str6 = str9;
                                mediaSegment2 = mediaSegment2;
                                str7 = str7;
                            }
                        }
                        i2++;
                        str5 = str5;
                        str6 = str6;
                    }
                }
                String str11 = str5;
                String str12 = str6;
                if (mediaTrack2.mediaTransitions != null) {
                    for (int i5 = 0; i5 < mediaTrack2.mediaTransitions.size(); i5++) {
                        MediaTransition mediaTransition = mediaTrack2.mediaTransitions.get(i5);
                        String str13 = " --> transition : " + i5 + " ---> " + i5 + str12 + mediaTransition.start + "----" + mediaTransition.end + "---- duration : " + mediaTransition.duration;
                    }
                }
                if (mediaTrack2.superpositionHeader != null) {
                    String str14 = " --> superposition header : " + mediaTrack2.superpositionHeader.start + "----" + mediaTrack2.superpositionHeader.end + "----" + mediaTrack2.superpositionHeader.superpositionType;
                    MediaAEffect mediaAEffect2 = mediaTrack2.superpositionHeader.mediaAEffect;
                    if (mediaAEffect2 != null && mediaAEffect2.mediaOneAEffects != null) {
                        for (int i6 = 0; i6 < mediaTrack2.superpositionHeader.mediaAEffect.mediaOneAEffects.size(); i6++) {
                            MediaOneAEffect mediaOneAEffect2 = mediaTrack2.superpositionHeader.mediaAEffect.mediaOneAEffects.get(i6);
                            String str15 = "superposition header effect : + ->" + i6 + str12 + mediaOneAEffect2.start + "----" + mediaOneAEffect2.end;
                            List<ShaderParams> list3 = mediaOneAEffect2.aParams;
                            if (list3 != null) {
                                Iterator<ShaderParams> it4 = list3.iterator();
                                while (it4.hasNext()) {
                                    float[] fArr2 = it4.next().values;
                                    if (fArr2 != null) {
                                        int length2 = fArr2.length;
                                        str2 = str11;
                                        int i7 = 0;
                                        while (i7 < length2) {
                                            str2 = str2 + fArr2[i7] + "---";
                                            i7++;
                                            it4 = it4;
                                        }
                                        it = it4;
                                    } else {
                                        it = it4;
                                        str2 = str11;
                                    }
                                    String str16 = "superposition header ShaderParams ------> type: " + next.type + " name: " + next.name + " values: " + (str2 + PreferencesUtil.RIGHT_MOUNT);
                                    it4 = it;
                                }
                            }
                        }
                    }
                }
                if (mediaTrack2.superpositionFooter != null) {
                    String str17 = " --> superposition footer : " + mediaTrack2.superpositionFooter.start + "----" + mediaTrack2.superpositionFooter.end + "----" + mediaTrack2.superpositionFooter.superpositionType;
                    MediaAEffect mediaAEffect3 = mediaTrack2.superpositionFooter.mediaAEffect;
                    if (mediaAEffect3 == null || mediaAEffect3.mediaOneAEffects == null) {
                        return;
                    }
                    int i8 = 0;
                    while (i8 < mediaTrack2.superpositionFooter.mediaAEffect.mediaOneAEffects.size()) {
                        MediaOneAEffect mediaOneAEffect3 = mediaTrack2.superpositionFooter.mediaAEffect.mediaOneAEffects.get(i8);
                        String str18 = "superposition footer effect : + ->" + i8 + str12 + mediaOneAEffect3.start + "----" + mediaOneAEffect3.end;
                        List<ShaderParams> list4 = mediaOneAEffect3.aParams;
                        if (list4 != null) {
                            for (ShaderParams shaderParams : list4) {
                                float[] fArr3 = shaderParams.values;
                                if (fArr3 != null) {
                                    str = str11;
                                    for (float f2 : fArr3) {
                                        str = str + f2 + "---";
                                    }
                                } else {
                                    str = str11;
                                }
                                String str19 = "superposition footer ShaderParams ------> type: " + shaderParams.type + " name: " + shaderParams.name + " values: " + (str + PreferencesUtil.RIGHT_MOUNT);
                            }
                        }
                        i8++;
                        mediaTrack2 = mediaTrack;
                    }
                }
            }
        }
    }
}
