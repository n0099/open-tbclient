package c.a.z.a;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f31278c;

    /* renamed from: d  reason: collision with root package name */
    public static MediaCodecInfo[] f31279d;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, MediaCodecInfo> f31280e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodecInfo f31281a;

    /* renamed from: b  reason: collision with root package name */
    public int f31282b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899320800, "Lc/a/z/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899320800, "Lc/a/z/a/d;");
                return;
            }
        }
        f31278c = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        f31280e = new HashMap();
        f31278c.put("OMX.Nvidia.h264.decode", 800);
        f31278c.put("OMX.Nvidia.h264.decode.secure", 300);
        f31278c.put("OMX.Intel.hw_vd.h264", 801);
        f31278c.put("OMX.Intel.VideoDecoder.AVC", 800);
        f31278c.put("OMX.qcom.video.decoder.avc", 800);
        f31278c.put("OMX.ittiam.video.decoder.avc", 0);
        f31278c.put("OMX.SEC.avc.dec", 800);
        f31278c.put("OMX.SEC.AVC.Decoder", 799);
        f31278c.put("OMX.SEC.avcdec", 798);
        f31278c.put("OMX.SEC.avc.sw.dec", 200);
        f31278c.put("OMX.Exynos.avc.dec", 800);
        f31278c.put("OMX.Exynos.AVC.Decoder", 799);
        f31278c.put("OMX.k3.video.decoder.avc", 800);
        f31278c.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        f31278c.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        f31278c.put("OMX.rk.video_decoder.avc", 800);
        f31278c.put("OMX.amlogic.avc.decoder.awesome", 800);
        f31278c.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        f31278c.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        f31278c.put("OMX.allwinner.video.decoder.avc", 0);
        f31278c.put("OMX.qcom.video.decoder.hevcswvdec", 0);
        f31278c.remove("OMX.Action.Video.Decoder");
        f31278c.remove("OMX.BRCM.vc4.decoder.avc");
        f31278c.remove("OMX.brcm.video.h264.hw.decoder");
        f31278c.remove("OMX.brcm.video.h264.decoder");
        f31278c.remove("OMX.cosmo.video.decoder.avc");
        f31278c.remove("OMX.duos.h264.decoder");
        f31278c.remove("OMX.hantro.81x0.video.decoder");
        f31278c.remove("OMX.hantro.G1.video.decoder");
        f31278c.remove("OMX.hisi.video.decoder");
        f31278c.remove("OMX.LG.decoder.video.avc");
        f31278c.remove("OMX.MS.AVC.Decoder");
        f31278c.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        f31278c.remove("OMX.RTK.video.decoder");
        f31278c.remove("OMX.sprd.h264.decoder");
        f31278c.remove("OMX.ST.VFM.H264Dec");
        f31278c.remove("OMX.vpu.video_decoder.avc");
        f31278c.remove("OMX.WMT.decoder.avc");
        f31278c.remove("OMX.bluestacks.hw.decoder");
        f31278c.put("OMX.google.h264.decoder", 200);
        f31278c.put("OMX.google.h264.lc.decoder", 200);
        f31278c.put("OMX.k3.ffmpeg.decoder", 200);
        f31278c.put("OMX.ffmpeg.video.decoder", 200);
        f31278c.put("OMX.sprd.soft.h264.decoder", 200);
        f31278c.put("OMX.google.hevc.decoder", 200);
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31282b = 0;
    }

    @TargetApi(16)
    public static d a(MediaCodecInfo mediaCodecInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaCodecInfo, str)) == null) {
            if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
                return null;
            }
            String name = mediaCodecInfo.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            String lowerCase = name.toLowerCase(Locale.US);
            int i2 = 600;
            if (!lowerCase.startsWith("omx.")) {
                i2 = 100;
            } else if (lowerCase.startsWith("omx.pv") || ((lowerCase.startsWith("omx.google.") && !lowerCase.equals("omx.google.hevc.decoder")) || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec."))) {
                i2 = 200;
            } else {
                if (!lowerCase.startsWith("omx.ittiam.")) {
                    if (!lowerCase.startsWith("omx.mtk.")) {
                        Integer num = f31278c.get(lowerCase);
                        if (num != null) {
                            i2 = num.intValue();
                        } else {
                            try {
                                if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                                    i2 = 700;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        i2 = 800;
                    }
                }
                i2 = 0;
            }
            d dVar = new d();
            dVar.f31281a = mediaCodecInfo;
            dVar.f31282b = i2;
            return dVar;
        }
        return (d) invokeLL.objValue;
    }

    public static synchronized String b(String str) {
        InterceptResult invokeL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (d.class) {
                c2 = c(str, -1, -1, 0.0d);
            }
            return c2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            d();
            MediaCodecInfo e2 = e(str);
            if (e2 != null) {
                boolean z = true;
                if (Build.VERSION.SDK_INT >= 21 && i2 > 0 && i3 > 0) {
                    int i4 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
                    MediaCodecInfo.VideoCapabilities videoCapabilities = e2.getCapabilitiesForType(str).getVideoCapabilities();
                    z = i4 > 0 ? videoCapabilities.areSizeAndRateSupported(i2, i3, d2) : videoCapabilities.isSizeSupported(i2, i3);
                }
                if (z) {
                    CyberLog.d("CyberMediaCodecInfo", "mineType:" + str + " decoder:" + e2.getName());
                    return e2.getName();
                }
                CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + e2.getName() + "," + i2 + "," + i3 + "," + d2 + PreferencesUtil.RIGHT_MOUNT);
                return null;
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (d.class) {
                try {
                } catch (Error e2) {
                    e2.printStackTrace();
                } catch (Exception unused) {
                }
                if (f31279d != null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 16) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 21) {
                    ArrayList arrayList = new ArrayList();
                    int codecCount = MediaCodecList.getCodecCount();
                    for (int i2 = 0; i2 < codecCount; i2++) {
                        arrayList.add(MediaCodecList.getCodecInfoAt(i2));
                    }
                    f31279d = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
                } else {
                    f31279d = new MediaCodecList(0).getCodecInfos();
                }
                e("video/avc");
                e("video/hevc");
            }
        }
    }

    public static MediaCodecInfo e(String str) {
        InterceptResult invokeL;
        String[] supportedTypes;
        d a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            MediaCodecInfo mediaCodecInfo = f31280e.get(str);
            if (mediaCodecInfo != null) {
                return mediaCodecInfo;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                MediaCodecInfo[] mediaCodecInfoArr = f31279d;
                if (i2 >= mediaCodecInfoArr.length) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = mediaCodecInfoArr[i2];
                if (!mediaCodecInfo2.isEncoder() && (supportedTypes = mediaCodecInfo2.getSupportedTypes()) != null) {
                    for (String str2 : supportedTypes) {
                        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str) && (a2 = a(mediaCodecInfo2, str)) != null) {
                            arrayList.add(a2);
                        }
                    }
                }
                i2++;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            d dVar = (d) arrayList.get(0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (dVar2.f31282b > dVar.f31282b) {
                    dVar = dVar2;
                }
            }
            if (dVar.f31282b < 600) {
                return null;
            }
            f31280e.put(str, dVar.f31281a);
            return dVar.f31281a;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }
}
