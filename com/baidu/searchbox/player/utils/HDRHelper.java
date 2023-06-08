package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.content.res.Configuration;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.view.Display;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u0006\u0010\b\u001a\u00020\u0005\u001a\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"supportHDRCodec", "", "supportedHdrTypes", "", "matchCodecProfileLevel", "", "codecInfo", "Landroid/media/MediaCodecInfo;", "queryCodecSupport", "queryConfig", "activity", "Landroid/app/Activity;", "queryMaxMinLuminance", "", "querySupportedHdrTypes", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "HDRHelper")
/* loaded from: classes4.dex */
public final class HDRHelper {
    public static int supportHDRCodec = -1;
    public static String supportedHdrTypes = "";

    @RequiresApi(21)
    public static final boolean matchCodecProfileLevel(MediaCodecInfo mediaCodecInfo) {
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        Intrinsics.checkNotNullExpressionValue(supportedTypes, "supportedTypes");
        for (String str : supportedTypes) {
            if (Intrinsics.areEqual(str, MimeTypes.VIDEO_H265) && !mediaCodecInfo.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                    if (capabilitiesForType != null) {
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                        Intrinsics.checkNotNullExpressionValue(codecProfileLevelArr, "capabilities.profileLevels");
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                            if (codecProfileLevel.profile == 4096) {
                                return true;
                            }
                        }
                        continue;
                    }
                } catch (Exception e) {
                    BdVideoLog.e(e.getMessage());
                }
            }
        }
        return false;
    }

    public static final float[] queryMaxMinLuminance(Activity activity) {
        float[] fArr = {-1.0f, -1.0f};
        if (activity == null) {
            return fArr;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "activity.windowManager.defaultDisplay");
        if (Build.VERSION.SDK_INT >= 24) {
            Display.HdrCapabilities hdrCapabilities = defaultDisplay.getHdrCapabilities();
            if (hdrCapabilities == null) {
                return fArr;
            }
            float desiredMaxLuminance = hdrCapabilities.getDesiredMaxLuminance();
            float desiredMinLuminance = hdrCapabilities.getDesiredMinLuminance();
            BdVideoLog.d("MaxLuminance= " + desiredMaxLuminance + "； MinLuminance = " + desiredMinLuminance);
            fArr[0] = desiredMaxLuminance;
            fArr[1] = desiredMinLuminance;
        }
        return fArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x003d */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static final boolean queryCodecSupport() {
        int i = supportHDRCodec;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        if (i != -1) {
            if (i != 1) {
                return false;
            }
            return true;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                Intrinsics.checkNotNullExpressionValue(codecInfos, "codecInfos");
                int length = codecInfos.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    MediaCodecInfo codecInfo = codecInfos[i2];
                    Intrinsics.checkNotNullExpressionValue(codecInfo, "codecInfo");
                    if (matchCodecProfileLevel(codecInfo)) {
                        r1 = 1;
                        break;
                    }
                    i2++;
                }
            } catch (Exception e) {
                BdVideoLog.e(e.getMessage());
            }
        }
        supportHDRCodec = r1;
        return r1;
    }

    public static final boolean queryConfig(Activity activity) {
        Configuration configuration = activity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "activity.resources.configuration");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        boolean isScreenWideColorGamut = configuration.isScreenWideColorGamut();
        boolean isScreenHdr = configuration.isScreenHdr();
        BdVideoLog.d("Configuration color " + isScreenWideColorGamut + " hdr " + isScreenHdr);
        if (!isScreenWideColorGamut || !isScreenHdr) {
            return false;
        }
        return true;
    }

    public static final String querySupportedHdrTypes(Activity activity) {
        boolean z;
        boolean z2;
        if (supportedHdrTypes.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return supportedHdrTypes;
        }
        if (activity == null) {
            return "-1";
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "activity.windowManager.defaultDisplay");
        if (Build.VERSION.SDK_INT >= 24) {
            Display.HdrCapabilities hdrCapabilities = defaultDisplay.getHdrCapabilities();
            if (hdrCapabilities == null) {
                return "-1";
            }
            int[] supportedHdrTypes2 = hdrCapabilities.getSupportedHdrTypes();
            Intrinsics.checkNotNullExpressionValue(supportedHdrTypes2, "hdrCapabilities.supportedHdrTypes");
            int length = supportedHdrTypes2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = supportedHdrTypes2[i];
                supportedHdrTypes += i2;
                if (i != supportedHdrTypes2.length - 1) {
                    supportedHdrTypes += '_';
                }
                if (i2 == -1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    supportedHdrTypes = "-1";
                    break;
                }
                i++;
            }
        }
        return supportedHdrTypes;
    }
}
