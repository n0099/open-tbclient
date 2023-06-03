package com.baidu.searchbox.player.kernel;

import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.gfb;
import com.baidu.tieba.hfb;
import com.baidu.tieba.jfb;
import com.baidu.tieba.lfb;
import com.baidu.tieba.mfb;
import com.baidu.tieba.pfb;
import com.baidu.tieba.rfb;
import com.baidu.tieba.sfb;
import com.baidu.tieba.tfb;
import com.baidu.tieba.zfb;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u0019\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0002J.\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(H\u0016J\"\u0010)\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0010H\u0016J\u001a\u0010-\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020\u0015H\u0016J\u001c\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u000101H\u0016J\"\u00102\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0016J\"\u00105\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0016J\u001a\u00108\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00109\u001a\u00020\u0010H\u0016J,\u0010:\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010;\u001a\u0004\u0018\u0001012\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0016J*\u0010>\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0010H\u0016J\"\u0010@\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0015H\u0016J\u0012\u0010A\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010B\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010C\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010F\u001a\u00020\u0010H\u0016J\"\u0010G\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010H\u0016J$\u0010J\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00102\b\u0010K\u001a\u0004\u0018\u000101H\u0016J\"\u0010L\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0016J\"\u0010M\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010N\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0010H\u0016J6\u0010O\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00102\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020P\u0018\u00010&j\n\u0012\u0004\u0012\u00020P\u0018\u0001`(H\u0016J.\u0010Q\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`(H\u0016J$\u0010R\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010S2\u0006\u0010K\u001a\u00020\u0010H\u0016J6\u0010T\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00102\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020U\u0018\u00010&j\n\u0012\u0004\u0012\u00020U\u0018\u0001`(H\u0016J6\u0010V\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00102\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020W\u0018\u00010&j\n\u0012\u0004\u0012\u00020W\u0018\u0001`(H\u0016J$\u0010X\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010Y\u001a\u0004\u0018\u00010S2\u0006\u0010,\u001a\u00020\u0010H\u0016R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/baidu/searchbox/player/kernel/YYKernelInfoConverter;", "Lcom/yy/transvod/player/OnPlayerPlayCompletionListener;", "Lcom/yy/transvod/player/OnPlayerInfoListener;", "Lcom/yy/transvod/player/OnPlayerStateUpdateListener;", "Lcom/yy/transvod/player/OnPlayerFirstVideoFrameShowListener;", "Lcom/yy/transvod/player/OnPlayerErrorListener;", "Lcom/yy/transvod/player/OnPlayerStatisticsListener;", "Lcom/yy/transvod/player/OnPlayerAVExtraInfoListener;", "Lcom/yy/transvod/player/OnPlayerQualityMonitorListener;", "Lcom/yy/transvod/player/OnPlayerCachePositionUpdateListener;", "kernel", "Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "kernelCallback", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "(Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;Lcom/baidu/searchbox/player/kernel/IKernelPlayer;)V", "<set-?>", "", "bufferingPosition", "getBufferingPosition", "()I", "downloadSpeed", "", "getKernel", "()Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "setKernel", "(Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;)V", "getKernelCallback", "()Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "setKernelCallback", "(Lcom/baidu/searchbox/player/kernel/IKernelPlayer;)V", "videoDecodeSpeed", "onCarltonInfo", "", "carltonLength", "onDSEMixAudioExtraInfoV1", DI.LIVE_PLAYER, "Lcom/yy/transvod/player/VodPlayer;", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "Ljava/util/ArrayList;", "Lcom/yy/transvod/player/common/MixAudioExtraInfo;", "Lkotlin/collections/ArrayList;", "onPlayerAudioStalls", "audioStalls", "", "type", "onPlayerCachePositionUpdate", CriusAttrConstants.POSITION, "onPlayerCacheWriteToDiskCompleted", "p0", "", "onPlayerDecodeBitrate", "videoBitrate", "audioBitrate", "onPlayerDecodeOuputSize", "width", "height", "onPlayerDecodeType", "decodType", "onPlayerError", "url", "what", "extra", "onPlayerFirstVideoFrameShow", "costMs", "onPlayerInfo", "onPlayerPlayCompletion", "onPlayerPlayCompletionOneLoop", "onPlayerReceiveToRenderDelay", DelayTB.DELAY, "onPlayerRenderFramerate", "framerate", "onPlayerStateUpdate", GameAssistConstKt.KEY_DISK_NEW_STATE, "reason", "onPlayerStatistics", "p2", "onPlayerVideoSizeUpdate", "onPlayerVideoStalls", "videoStalls", "onSEIAlphaChannelInfo", "Lcom/yy/transvod/player/common/AlphaChannelData;", "onSEIAudioExtraInfoV0", "onSEIAudioOriginalData", "", "onSEIMixVideoExtraInfo", "Lcom/yy/transvod/player/common/MixVideoExtraInfo;", "onSEIVideoExtraInfo", "Lcom/yy/transvod/player/common/VideoExtraInfo;", "onSEIVideoOriginalData", "sei", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YYKernelInfoConverter implements pfb, mfb, sfb, lfb, jfb, tfb, gfb, rfb, hfb {
    public int bufferingPosition;
    public long downloadSpeed;
    public AbsVideoKernel kernel;
    public IKernelPlayer kernelCallback;
    public int videoDecodeSpeed;

    @Override // com.baidu.tieba.hfb
    public void onPlayerCacheWriteToDiskCompleted(zfb zfbVar, String str) {
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIAlphaChannelInfo(zfb zfbVar, int i, ArrayList<AlphaChannelData> arrayList) {
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIMixVideoExtraInfo(zfb zfbVar, int i, ArrayList<MixVideoExtraInfo> arrayList) {
    }

    public YYKernelInfoConverter(AbsVideoKernel kernel, IKernelPlayer iKernelPlayer) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        this.kernel = kernel;
        this.kernelCallback = iKernelPlayer;
    }

    @Override // com.baidu.tieba.gfb
    public void onDSEMixAudioExtraInfoV1(zfb zfbVar, ArrayList<MixAudioExtraInfo> arrayList) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onDSEMixAudioExtraInfoV1");
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerDecodeType(zfb zfbVar, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerDecodeType decodeType = " + i);
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerReceiveToRenderDelay(zfb zfbVar, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerReceiveToRenderDelay delay = " + i);
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerRenderFramerate(zfb zfbVar, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerRenderFramerate framerate = " + i);
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIAudioExtraInfoV0(zfb zfbVar, ArrayList<Long> arrayList) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onSEIAudioExtraInfoV0");
    }

    public /* synthetic */ YYKernelInfoConverter(AbsVideoKernel absVideoKernel, IKernelPlayer iKernelPlayer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(absVideoKernel, (i & 2) != 0 ? null : iKernelPlayer);
    }

    @Override // com.baidu.tieba.jfb
    public void onPlayerError(zfb zfbVar, String str, int i, int i2) {
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onError(i, i2, str);
        }
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerError：url = " + str + "; what = " + i + "; extra = " + i2);
    }

    @Override // com.baidu.tieba.lfb
    public void onPlayerFirstVideoFrameShow(zfb zfbVar, int i, int i2, int i3) {
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, 0, 0);
        }
        IKernelPlayer iKernelPlayer2 = this.kernelCallback;
        if (iKernelPlayer2 != null) {
            iKernelPlayer2.onInfo(904, -1, null);
        }
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerFirstVideoFrameShow");
    }

    private final void onCarltonInfo(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("carlton_type", "1");
            jSONObject.put("carltonLength", String.valueOf(j));
            jSONObject.put("decodeSpeed", String.valueOf(this.videoDecodeSpeed));
            jSONObject.put("loadSpeed", this.downloadSpeed);
            IKernelPlayer iKernelPlayer = this.kernelCallback;
            if (iKernelPlayer != null) {
                iKernelPlayer.onInfo(10009, -1, jSONObject.toString());
            }
            BdVideoLog.d(YYKernelInfoConverterKt.TAG, "卡顿率：" + jSONObject);
        } catch (Exception e) {
            BdVideoLog.w(e.getMessage());
        }
    }

    public final int getBufferingPosition() {
        return this.bufferingPosition;
    }

    public final AbsVideoKernel getKernel() {
        return this.kernel;
    }

    public final IKernelPlayer getKernelCallback() {
        return this.kernelCallback;
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerAudioStalls(zfb zfbVar, boolean z, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerAudioStalls audioStalls = " + z + "; type = " + i);
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerDecodeBitrate(zfb zfbVar, int i, int i2) {
        this.videoDecodeSpeed = i;
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerDecodeBitrate videoBitrate =" + i);
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerDecodeOuputSize(zfb zfbVar, int i, int i2) {
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, 0, 0);
        }
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerDecodeOuputSize width = " + i + "; height = " + i2);
    }

    @Override // com.baidu.tieba.tfb
    public void onPlayerStatistics(zfb zfbVar, int i, String str) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStatistics p1 = " + i + "; p2 = " + str);
    }

    @Override // com.baidu.tieba.mfb
    public void onPlayerVideoSizeUpdate(zfb zfbVar, int i, int i2) {
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, 0, 0);
        }
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIAudioOriginalData(zfb zfbVar, byte[] bArr, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onSEIAudioOriginalData");
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIVideoExtraInfo(zfb zfbVar, int i, ArrayList<VideoExtraInfo> arrayList) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onSEIVideoExtraInfo");
    }

    @Override // com.baidu.tieba.gfb
    public void onSEIVideoOriginalData(zfb zfbVar, byte[] bArr, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onSEIVideoOriginalData");
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onInfo(10103, i, bArr);
        }
    }

    @Override // com.baidu.tieba.hfb
    public void onPlayerCachePositionUpdate(zfb zfbVar, long j) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerCachePositionUpdate position = " + j);
        if (zfbVar != null) {
            long e = zfbVar.e();
            if (e <= 0) {
                return;
            }
            this.bufferingPosition = (int) j;
            int i = (int) ((((float) j) * 100.0f) / ((float) e));
            IKernelPlayer iKernelPlayer = this.kernelCallback;
            if (iKernelPlayer != null) {
                iKernelPlayer.onBufferingUpdate(i);
            }
        }
    }

    @Override // com.baidu.tieba.mfb
    public void onPlayerInfo(zfb zfbVar, int i, long j) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            IKernelPlayer iKernelPlayer = this.kernelCallback;
                            if (iKernelPlayer != null) {
                                iKernelPlayer.onInfo(910, (int) j, null);
                            }
                            BdVideoLog.d(YYKernelInfoConverterKt.TAG, "progress = " + j);
                            return;
                        }
                        return;
                    }
                    BdVideoLog.d(YYKernelInfoConverterKt.TAG, "resourceDuration = " + j);
                    return;
                }
                BdVideoLog.d(YYKernelInfoConverterKt.TAG, "resourceTotalSize = " + j);
                return;
            }
            onCarltonInfo(j);
            BdVideoLog.d(YYKernelInfoConverterKt.TAG, "carltonLength = " + j);
            return;
        }
        this.downloadSpeed = j;
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "downloadSpeed = " + j);
    }

    @Override // com.baidu.tieba.sfb
    public void onPlayerStateUpdate(zfb zfbVar, int i, int i2) {
        if (i != 0) {
            if (i != 1) {
                switch (i) {
                    case 4:
                        IKernelPlayer iKernelPlayer = this.kernelCallback;
                        if (iKernelPlayer != null) {
                            iKernelPlayer.onPrepared();
                        }
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = prepared");
                        return;
                    case 5:
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = loading");
                        return;
                    case 6:
                        this.kernel.notifyStatusChange(PlayerStatus.PLAYING);
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = playing");
                        return;
                    case 7:
                        this.kernel.notifyStatusChange(PlayerStatus.PAUSE);
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = paused");
                        return;
                    case 8:
                        IKernelPlayer iKernelPlayer2 = this.kernelCallback;
                        if (iKernelPlayer2 != null) {
                            iKernelPlayer2.onCompletion();
                        }
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = complete");
                        return;
                    case 9:
                        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = invalid");
                        return;
                    case 10:
                        IKernelPlayer iKernelPlayer3 = this.kernelCallback;
                        if (iKernelPlayer3 != null) {
                            iKernelPlayer3.onKernelPreDetach();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.kernel.notifyStatusChange(PlayerStatus.IDLE);
            BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = idel");
            return;
        }
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerStateUpdate state = unknow");
    }

    @Override // com.baidu.tieba.pfb
    public void onPlayerPlayCompletion(zfb zfbVar) {
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onCompletion();
        }
    }

    @Override // com.baidu.tieba.pfb
    public void onPlayerPlayCompletionOneLoop(zfb zfbVar) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerPlayCompletionOneLoop");
        IKernelPlayer iKernelPlayer = this.kernelCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onInfo(955, -1, null);
        }
    }

    public final void setKernel(AbsVideoKernel absVideoKernel) {
        Intrinsics.checkNotNullParameter(absVideoKernel, "<set-?>");
        this.kernel = absVideoKernel;
    }

    public final void setKernelCallback(IKernelPlayer iKernelPlayer) {
        this.kernelCallback = iKernelPlayer;
    }

    @Override // com.baidu.tieba.rfb
    public void onPlayerVideoStalls(zfb zfbVar, boolean z, int i) {
        BdVideoLog.d(YYKernelInfoConverterKt.TAG, "onPlayerVideoStalls videoStalls = " + z + "; type = " + i);
        if (z) {
            IKernelPlayer iKernelPlayer = this.kernelCallback;
            if (iKernelPlayer != null) {
                iKernelPlayer.onInfo(701, -1, null);
                return;
            }
            return;
        }
        IKernelPlayer iKernelPlayer2 = this.kernelCallback;
        if (iKernelPlayer2 != null) {
            iKernelPlayer2.onInfo(702, -1, null);
        }
    }
}
