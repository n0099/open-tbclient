package com.baidu.ala.helper;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AlaLiveDebugInfo implements Serializable {
    private static final long serialVersionUID = 5698793191517772253L;
    public long bandWidth;
    public int connectCnt;
    public int connectNumber;
    public int connectSuccess;
    public long connectTime;
    public long currentBandWidth;
    public long currentDropA;
    public long currentDropCount;
    public long currentDropI;
    public long currentDropP;
    public long currentPlaySppedCount;
    public long dataFlow;
    public long elapsedMilli;
    public double failureAudio;
    public double failureVideo;
    public int fpsAvg;
    public int fpsMax;
    public int fpsMin;
    public long fpsTimestamp;
    public int monitorInterval;
    public long sendAudioCount;
    public long sendAudioFailure;
    public long sendVideoCount;
    public long sendVideoFailure;
    public int statusCode;
    public long timeStamp;
    public long totalDropA;
    public long totalDropCount;
    public long totalDropI;
    public long totalDropP;
    public long totalPlaySpeedCount;

    public AlaLiveDebugInfo() {
    }

    public AlaLiveDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (alaLiveDebugInfo != null) {
            this.bandWidth = alaLiveDebugInfo.bandWidth;
            this.connectCnt = alaLiveDebugInfo.connectCnt;
            this.connectNumber = alaLiveDebugInfo.connectNumber;
            this.statusCode = alaLiveDebugInfo.statusCode;
            this.connectSuccess = alaLiveDebugInfo.connectSuccess;
            this.connectTime = alaLiveDebugInfo.connectTime;
            this.currentBandWidth = alaLiveDebugInfo.currentBandWidth;
            this.currentDropA = alaLiveDebugInfo.currentDropA;
            this.currentDropCount = alaLiveDebugInfo.currentDropCount;
            this.currentDropI = alaLiveDebugInfo.currentDropI;
            this.currentDropP = alaLiveDebugInfo.currentDropP;
            this.currentPlaySppedCount = alaLiveDebugInfo.currentPlaySppedCount;
            this.dataFlow = alaLiveDebugInfo.dataFlow;
            this.elapsedMilli = alaLiveDebugInfo.elapsedMilli;
            this.monitorInterval = alaLiveDebugInfo.monitorInterval;
            this.timeStamp = alaLiveDebugInfo.timeStamp;
            this.totalDropA = alaLiveDebugInfo.totalDropA;
            this.totalDropCount = alaLiveDebugInfo.totalDropCount;
            this.totalDropI = alaLiveDebugInfo.totalDropI;
            this.totalPlaySpeedCount = alaLiveDebugInfo.totalPlaySpeedCount;
            this.sendAudioCount = alaLiveDebugInfo.sendAudioCount;
            this.sendVideoCount = alaLiveDebugInfo.sendVideoCount;
            this.sendAudioFailure = alaLiveDebugInfo.sendAudioFailure;
            this.sendVideoFailure = alaLiveDebugInfo.sendVideoFailure;
            this.fpsMin = alaLiveDebugInfo.fpsMin;
            this.fpsMax = alaLiveDebugInfo.fpsMax;
            this.fpsAvg = alaLiveDebugInfo.fpsAvg;
            this.fpsTimestamp = alaLiveDebugInfo.fpsTimestamp;
            this.failureAudio = alaLiveDebugInfo.failureAudio;
            this.failureVideo = alaLiveDebugInfo.failureVideo;
        }
    }

    public void fillWithDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (alaLiveDebugInfo != null) {
            this.bandWidth = alaLiveDebugInfo.bandWidth;
            this.connectCnt = alaLiveDebugInfo.connectCnt;
            this.connectNumber = alaLiveDebugInfo.connectNumber;
            this.statusCode = alaLiveDebugInfo.statusCode;
            this.connectSuccess = alaLiveDebugInfo.connectSuccess;
            this.connectTime = alaLiveDebugInfo.connectTime;
            this.currentBandWidth = alaLiveDebugInfo.currentBandWidth;
            this.currentDropA = alaLiveDebugInfo.currentDropA;
            this.currentDropCount = alaLiveDebugInfo.currentDropCount;
            this.currentDropI = alaLiveDebugInfo.currentDropI;
            this.currentDropP = alaLiveDebugInfo.currentDropP;
            this.currentPlaySppedCount = alaLiveDebugInfo.currentPlaySppedCount;
            this.dataFlow = alaLiveDebugInfo.dataFlow;
            this.elapsedMilli = alaLiveDebugInfo.elapsedMilli;
            this.monitorInterval = alaLiveDebugInfo.monitorInterval;
            this.timeStamp = alaLiveDebugInfo.timeStamp;
            this.totalDropA = alaLiveDebugInfo.totalDropA;
            this.totalDropCount = alaLiveDebugInfo.totalDropCount;
            this.totalDropI = alaLiveDebugInfo.totalDropI;
            this.totalPlaySpeedCount = alaLiveDebugInfo.totalPlaySpeedCount;
            this.sendAudioCount = alaLiveDebugInfo.sendAudioCount;
            this.sendVideoCount = alaLiveDebugInfo.sendVideoCount;
            this.sendAudioFailure = alaLiveDebugInfo.sendAudioFailure;
            this.sendVideoFailure = alaLiveDebugInfo.sendVideoFailure;
            this.fpsMin = alaLiveDebugInfo.fpsMin;
            this.fpsMax = alaLiveDebugInfo.fpsMax;
            this.fpsAvg = alaLiveDebugInfo.fpsAvg;
            this.fpsTimestamp = alaLiveDebugInfo.fpsTimestamp;
            this.failureAudio = alaLiveDebugInfo.failureAudio;
            this.failureVideo = alaLiveDebugInfo.failureVideo;
        }
    }
}
