package com.baidu.live.videochat.d;

import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static AlaLiveRtcConfig b(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        AlaLiveRtcConfig alaLiveRtcConfig = new AlaLiveRtcConfig();
        alaLiveRtcConfig.mUId = TbadkCoreApplication.getCurrentAccountId();
        alaLiveRtcConfig.mRoomId = alaAvtsData.roomId;
        alaLiveRtcConfig.mLineIndex = alaAvtsData.lineId;
        alaLiveRtcConfig.mRtcServerHost = alaAvtsData.host;
        alaLiveRtcConfig.mRtcServerPort = alaAvtsData.port;
        if (alaAvtsConfigInfo != null) {
            alaLiveRtcConfig.mHandshakeTimeout = alaAvtsConfigInfo.handshakeTimeout;
            alaLiveRtcConfig.mHeartInterval = alaAvtsConfigInfo.heartInterval;
            alaLiveRtcConfig.mHeartTimeout = alaAvtsConfigInfo.heartTimeout;
            alaLiveRtcConfig.mCloseTimeout = alaAvtsConfigInfo.closeTimeout;
            alaLiveRtcConfig.mReduceDelay = alaAvtsConfigInfo.reduceDelay;
        }
        return alaLiveRtcConfig;
    }

    public static void a(AlaLiveRecorder alaLiveRecorder, AlaLiveRtcConfig alaLiveRtcConfig) {
        if (alaLiveRecorder != null && alaLiveRtcConfig != null) {
            LiveRecorderConfigHelper.GN().GO();
            alaLiveRecorder.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GN().f(true, true);
            AlaLiveVideoConfig videoConfig = alaLiveRecorder.getVideoConfig();
            if (videoConfig != null) {
                LiveRecorderConfigHelper.GN().a(true, videoConfig);
            }
            alaLiveRecorder.switchToRtcMode(f.getWidth(), f.getHeight());
        }
    }

    public static boolean a(AlaLiveRecorder alaLiveRecorder, AlaLiveRtcConfig alaLiveRtcConfig, String str) {
        if (alaLiveRecorder == null || alaLiveRtcConfig == null) {
            return false;
        }
        LiveRecorderConfigHelper.GN().GO();
        alaLiveRtcConfig.mPushUrl = str;
        alaLiveRecorder.setRtcConfig(alaLiveRtcConfig);
        LiveRecorderConfigHelper.GN().a(false, alaLiveRecorder.getVideoConfig());
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GN().f(false, true);
        alaLiveRecorder.getVideoConfig().setOutputWidth(f.getWidth());
        alaLiveRecorder.getVideoConfig().setOutputHeight(f.getHeight());
        if (!alaLiveRecorder.setDefaultRtcMode()) {
            BdLog.e("recorder.setDefaultRtcMode failed");
        }
        return alaLiveRecorder.startPush(str) == 0;
    }
}
