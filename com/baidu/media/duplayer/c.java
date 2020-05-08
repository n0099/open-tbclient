package com.baidu.media.duplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class c {
    private static MediaCodecInfo[] bim;
    private static Map<String, Integer> d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private static Map<String, MediaCodecInfo> f = new HashMap();
    public int b = 0;
    public MediaCodecInfo bil;
    public String c;

    static {
        d.put("OMX.Nvidia.h264.decode", 800);
        d.put("OMX.Nvidia.h264.decode.secure", 300);
        d.put("OMX.Intel.hw_vd.h264", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE));
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
        } else if (!lowerCase.startsWith("omx.pv") && !lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("omx.ffmpeg.") && !lowerCase.startsWith("omx.k3.ffmpeg.") && !lowerCase.startsWith("omx.avcodec.")) {
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
                        i = mediaCodecInfo.getCapabilitiesForType(str) != null ? CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING : 600;
                    } catch (Throwable th) {
                        i = 600;
                    }
                }
            }
        }
        c cVar = new c();
        cVar.bil = mediaCodecInfo;
        cVar.b = i;
        cVar.c = str;
        return cVar;
    }

    public static synchronized String a(String str) {
        String a;
        synchronized (c.class) {
            a = a(str, -1, -1, 0.0d);
        }
        return a;
    }

    private static String a(String str, int i, int i2, double d2) {
        a();
        MediaCodecInfo fw = fw(str);
        if (fw != null) {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 21 && i > 0 && i2 > 0) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = fw.getCapabilitiesForType(str);
                z = d2 > 0.0d ? capabilitiesForType.getVideoCapabilities().areSizeAndRateSupported(i, i2, d2) : capabilitiesForType.getVideoCapabilities().isSizeSupported(i, i2);
            }
            if (z) {
                CyberLog.d("CyberMediaCodecInfo", "mineType:" + str + " decoder:" + fw.getName());
                return fw.getName();
            }
            CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + fw.getName() + Constants.ACCEPT_TIME_SEPARATOR_SP + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + d2 + "]");
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                if (bim == null && Build.VERSION.SDK_INT >= 16) {
                    if (Build.VERSION.SDK_INT < 21) {
                        ArrayList arrayList = new ArrayList();
                        int codecCount = MediaCodecList.getCodecCount();
                        for (int i = 0; i < codecCount; i++) {
                            arrayList.add(MediaCodecList.getCodecInfoAt(i));
                        }
                        bim = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
                    } else {
                        bim = new MediaCodecList(0).getCodecInfos();
                    }
                    fw("video/avc");
                    fw("video/hevc");
                }
            } catch (Exception e) {
            }
        }
    }

    private static MediaCodecInfo fw(String str) {
        c cVar;
        String[] supportedTypes;
        c a;
        MediaCodecInfo mediaCodecInfo = f.get(str);
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bim.length; i++) {
            MediaCodecInfo mediaCodecInfo2 = bim[i];
            if (!mediaCodecInfo2.isEncoder() && (supportedTypes = mediaCodecInfo2.getSupportedTypes()) != null) {
                for (String str2 : supportedTypes) {
                    if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str) && (a = a(mediaCodecInfo2, str)) != null) {
                        arrayList.add(a);
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
            if (cVar2.b <= cVar.b) {
                cVar2 = cVar;
            }
        }
        if (cVar.b < 600) {
            return null;
        }
        f.put(str, cVar.bil);
        return cVar.bil;
    }
}
