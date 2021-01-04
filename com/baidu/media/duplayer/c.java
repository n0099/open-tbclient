package com.baidu.media.duplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.fsg.face.liveness.video.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes15.dex */
public class c {
    private static MediaCodecInfo[] ciZ;
    private static Map<String, Integer> d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private static Map<String, MediaCodecInfo> f = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f3239b = 0;
    public String c;
    public MediaCodecInfo ciY;

    static {
        d.put("OMX.Nvidia.h264.decode", 800);
        d.put("OMX.Nvidia.h264.decode.secure", 300);
        d.put("OMX.Intel.hw_vd.h264", 801);
        d.put("OMX.Intel.VideoDecoder.AVC", 800);
        d.put("OMX.qcom.video.decoder.avc", 800);
        d.put("OMX.ittiam.video.decoder.avc", 0);
        d.put("OMX.SEC.avc.dec", 800);
        d.put("OMX.SEC.AVC.Decoder", 799);
        d.put("OMX.SEC.avcdec", 798);
        d.put("OMX.SEC.avc.sw.dec", 200);
        d.put("OMX.Exynos.avc.dec", 800);
        d.put("OMX.Exynos.AVC.Decoder", 799);
        d.put("OMX.k3.video.decoder.avc", 800);
        d.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        d.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        d.put("OMX.rk.video_decoder.avc", 800);
        d.put("OMX.amlogic.avc.decoder.awesome", 800);
        d.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        d.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        d.remove("OMX.Action.Video.Decoder");
        d.remove("OMX.allwinner.video.decoder.avc");
        d.remove("OMX.BRCM.vc4.decoder.avc");
        d.remove("OMX.brcm.video.h264.hw.decoder");
        d.remove("OMX.brcm.video.h264.decoder");
        d.remove("OMX.cosmo.video.decoder.avc");
        d.remove("OMX.duos.h264.decoder");
        d.remove("OMX.hantro.81x0.video.decoder");
        d.remove("OMX.hantro.G1.video.decoder");
        d.remove("OMX.hisi.video.decoder");
        d.remove("OMX.LG.decoder.video.avc");
        d.remove("OMX.MS.AVC.Decoder");
        d.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        d.remove("OMX.RTK.video.decoder");
        d.remove("OMX.sprd.h264.decoder");
        d.remove("OMX.ST.VFM.H264Dec");
        d.remove("OMX.vpu.video_decoder.avc");
        d.remove("OMX.WMT.decoder.avc");
        d.remove("OMX.bluestacks.hw.decoder");
        d.put("OMX.google.h264.decoder", 200);
        d.put("OMX.google.h264.lc.decoder", 200);
        d.put("OMX.k3.ffmpeg.decoder", 200);
        d.put("OMX.ffmpeg.video.decoder", 200);
        d.put("OMX.sprd.soft.h264.decoder", 200);
    }

    @TargetApi(16)
    private static c a(MediaCodecInfo mediaCodecInfo, String str) {
        int i = 200;
        if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("omx.")) {
            i = 100;
        } else if (!lowerCase.startsWith("omx.pv") && ((!lowerCase.startsWith("omx.google.") || lowerCase.equals("omx.google.hevc.decoder")) && !lowerCase.startsWith("omx.ffmpeg.") && !lowerCase.startsWith("omx.k3.ffmpeg.") && !lowerCase.startsWith("omx.avcodec."))) {
            if (lowerCase.startsWith("omx.ittiam.")) {
                i = 0;
            } else if (lowerCase.startsWith("omx.mtk.")) {
                i = Build.VERSION.SDK_INT < 18 ? 0 : 800;
            } else {
                Integer num = d.get(lowerCase);
                if (num != null) {
                    i = num.intValue();
                } else {
                    try {
                        i = mediaCodecInfo.getCapabilitiesForType(str) != null ? 700 : 600;
                    } catch (Throwable th) {
                        i = 600;
                    }
                }
            }
        }
        c cVar = new c();
        cVar.ciY = mediaCodecInfo;
        cVar.f3239b = i;
        cVar.c = str;
        return cVar;
    }

    public static synchronized String a(String str) {
        String a2;
        synchronized (c.class) {
            a2 = a(str, -1, -1, 0.0d);
        }
        return a2;
    }

    private static String a(String str, int i, int i2, double d2) {
        a();
        MediaCodecInfo jE = jE(str);
        if (jE != null) {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 21 && i > 0 && i2 > 0) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = jE.getCapabilitiesForType(str);
                z = d2 > 0.0d ? capabilitiesForType.getVideoCapabilities().areSizeAndRateSupported(i, i2, d2) : capabilitiesForType.getVideoCapabilities().isSizeSupported(i, i2);
            }
            if (z) {
                CyberLog.d("CyberMediaCodecInfo", "mineType:" + str + " decoder:" + jE.getName());
                return jE.getName();
            }
            CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + jE.getName() + "," + i + "," + i2 + "," + d2 + "]");
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                if (ciZ == null && Build.VERSION.SDK_INT >= 16) {
                    if (Build.VERSION.SDK_INT < 21) {
                        ArrayList arrayList = new ArrayList();
                        int codecCount = MediaCodecList.getCodecCount();
                        for (int i = 0; i < codecCount; i++) {
                            arrayList.add(MediaCodecList.getCodecInfoAt(i));
                        }
                        ciZ = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
                    } else {
                        ciZ = new MediaCodecList(0).getCodecInfos();
                    }
                    if (CyberCfgManager.getInstance().getCfgBoolValue("enable_mc_google_hevc_decoder", true)) {
                        d.put("OMX.google.hevc.decoder", 601);
                        CyberLog.i("CyberMediaCodecInfo", "enable_mc_google_hevc_decoder add");
                    } else {
                        d.put("OMX.google.hevc.decoder", 200);
                    }
                    jE(f.f2362b);
                    jE("video/hevc");
                }
            } catch (Exception e) {
            }
        }
    }

    private static MediaCodecInfo jE(String str) {
        c cVar;
        String[] supportedTypes;
        c a2;
        MediaCodecInfo mediaCodecInfo = f.get(str);
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ciZ.length; i++) {
            MediaCodecInfo mediaCodecInfo2 = ciZ[i];
            if (!mediaCodecInfo2.isEncoder() && (supportedTypes = mediaCodecInfo2.getSupportedTypes()) != null) {
                for (String str2 : supportedTypes) {
                    if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str) && (a2 = a(mediaCodecInfo2, str)) != null) {
                        arrayList.add(a2);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        c cVar2 = (c) arrayList.get(0);
        Iterator it = arrayList.iterator();
        while (true) {
            cVar = cVar2;
            if (!it.hasNext()) {
                break;
            }
            cVar2 = (c) it.next();
            if (cVar2.f3239b <= cVar.f3239b) {
                cVar2 = cVar;
            }
        }
        if (cVar.f3239b < 600) {
            return null;
        }
        f.put(str, cVar.ciY);
        return cVar.ciY;
    }
}
