package b.i.b.a.b0;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.i0.i;
import b.i.b.a.i0.v;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f31854a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31855b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f31856c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f31857d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31858e;

    /* renamed from: f  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f31859f;

    public a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b.i.b.a.i0.a.e(str);
        this.f31854a = str;
        this.f31858e = str2;
        this.f31859f = codecCapabilities;
        boolean z3 = true;
        this.f31855b = (z || codecCapabilities == null || !e(codecCapabilities)) ? false : true;
        this.f31856c = codecCapabilities != null && l(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !j(codecCapabilities))) {
            z3 = false;
        }
        this.f31857d = z3;
    }

    public static int a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i2)) == null) {
            if (i2 > 1 || ((v.f32661a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
                return i2;
            }
            if ("audio/ac3".equals(str2)) {
                i3 = 6;
            } else {
                i3 = "audio/eac3".equals(str2) ? 16 : 30;
            }
            String str3 = "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + PreferencesUtil.RIGHT_MOUNT;
            return i3;
        }
        return invokeLLI.intValue;
    }

    @TargetApi(21)
    public static boolean c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{videoCapabilities, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            if (d2 != -1.0d && d2 > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
            }
            return videoCapabilities.isSizeSupported(i2, i3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, codecCapabilities)) == null) ? v.f32661a >= 19 && f(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(19)
    public static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("adaptive-playback") : invokeL.booleanValue;
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, codecCapabilities)) == null) ? v.f32661a >= 21 && k(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean k(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("secure-playback") : invokeL.booleanValue;
    }

    public static boolean l(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, codecCapabilities)) == null) ? v.f32661a >= 21 && m(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean m(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("tunneled-playback") : invokeL.booleanValue;
    }

    public static a q(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new a(str, str2, codecCapabilities, z, z2) : (a) invokeCommon.objValue;
    }

    public static a r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? new a(str, null, null, false, false) : (a) invokeL.objValue;
    }

    @TargetApi(21)
    public Point b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31859f;
            if (codecCapabilities == null) {
                p("align.caps");
                return null;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                p("align.vCaps");
                return null;
            }
            int widthAlignment = videoCapabilities.getWidthAlignment();
            int heightAlignment = videoCapabilities.getHeightAlignment();
            return new Point(v.f(i2, widthAlignment) * widthAlignment, v.f(i3, heightAlignment) * heightAlignment);
        }
        return (Point) invokeII.objValue;
    }

    public MediaCodecInfo.CodecProfileLevel[] d() {
        InterceptResult invokeV;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31859f;
            return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
        }
        return (MediaCodecInfo.CodecProfileLevel[]) invokeV.objValue;
    }

    @TargetApi(21)
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31859f;
            if (codecCapabilities == null) {
                p("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                p("channelCount.aCaps");
                return false;
            } else if (a(this.f31854a, this.f31858e, audioCapabilities.getMaxInputChannelCount()) < i2) {
                p("channelCount.support, " + i2);
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @TargetApi(21)
    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31859f;
            if (codecCapabilities == null) {
                p("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                p("sampleRate.aCaps");
                return false;
            } else if (audioCapabilities.isSampleRateSupported(i2)) {
                return true;
            } else {
                p("sampleRate.support, " + i2);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        String b2;
        MediaCodecInfo.CodecProfileLevel[] d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null || this.f31858e == null || (b2 = i.b(str)) == null) {
                return true;
            }
            if (!this.f31858e.equals(b2)) {
                p("codec.mime " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2);
                return false;
            }
            Pair<Integer, Integer> e2 = MediaCodecUtil.e(str);
            if (e2 == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : d()) {
                if (codecProfileLevel.profile == ((Integer) e2.first).intValue() && codecProfileLevel.level >= ((Integer) e2.second).intValue()) {
                    return true;
                }
            }
            p("codec.profileLevel, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2);
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public boolean n(int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31859f;
            if (codecCapabilities == null) {
                p("sizeAndRate.caps");
                return false;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                p("sizeAndRate.vCaps");
                return false;
            } else if (c(videoCapabilities, i2, i3, d2)) {
                return true;
            } else {
                if (i2 < i3 && c(videoCapabilities, i3, i2, d2)) {
                    o("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2);
                    return true;
                }
                p("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            String str2 = "AssumedSupport [" + str + "] [" + this.f31854a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31858e + "] [" + v.f32665e + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String str2 = "NoSupport [" + str + "] [" + this.f31854a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f31858e + "] [" + v.f32665e + PreferencesUtil.RIGHT_MOUNT;
        }
    }
}
