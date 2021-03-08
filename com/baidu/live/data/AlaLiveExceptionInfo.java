package com.baidu.live.data;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class AlaLiveExceptionInfo implements Serializable {
    public static final int EVENT_TYPE_DELAY = 5;
    public static final int EVENT_TYPE_FAST_OPEN = 2;
    public static final int EVENT_TYPE_NORMAL = 0;
    public static final int EVENT_TYPE_PLAY_FAILED = 3;
    public static final int EVENT_TYPE_SESSION_SWITCH = 1;
    public static final int EVENT_TYPE_STUCKS = 4;
    public static final int FAIL_TYPE_DECODER_ERROR = 1;
    public static final int FAIL_TYPE_STREAM_CONNECT_ERROR = 2;
    public static final int FAIL_TYPE_STREAM_NO_VIDEO = 3;
    public static final int FAST_OPEN_TIME_INVALID_VALUE = 3000;
    private static final long serialVersionUID = -1687025304827964341L;
    public int appState;
    public boolean connect;
    public int connectCount;
    public int dropFrame;
    public int eventType;
    public double failureAudio;
    public double failureVideo;
    public int firstOpenTime;
    public int fpsAvg;
    public int fpsMax;
    public int fpsMin;
    public int lagDuration;
    public int lagNetworkNum;
    public int lagSyncNum;
    public int lagnmax;
    public int lagnmin;
    public int lagntotal;
    public int lagsmax;
    public int lagsmin;
    public int lagstotal;
    public long liveID;
    public int liveType;
    public float lostRate;
    public int mediaStatus;
    public String netSpped;
    public String networkType;
    public String nodeIP;
    public boolean phone;
    public int playFail;
    public int sessionChannel = 1;
    public int status;
    public String streamUrl;
    public int videoLevel;

    public void reset() {
        this.playFail = 0;
        this.lagNetworkNum = 0;
        this.lagSyncNum = 0;
        this.lagDuration = 0;
        this.lagnmin = 0;
        this.lagnmax = 0;
        this.lagntotal = 0;
        this.lagsmin = 0;
        this.lagsmax = 0;
        this.lagstotal = 0;
        this.eventType = 0;
        this.firstOpenTime = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nliveID:").append(this.liveID);
        sb.append("\nnetworkType:").append(this.networkType);
        sb.append("\nappState:").append(this.appState);
        sb.append("\nstatus:").append(this.status);
        sb.append("\nnodeIP:").append(this.nodeIP);
        sb.append("\nsessionChannel:").append(this.sessionChannel);
        sb.append("\nvideoLevel:").append(this.videoLevel);
        sb.append("\nconnect:").append(this.connect);
        sb.append("\nphone:").append(this.phone);
        sb.append("\nlostRate:").append(this.lostRate);
        sb.append("\nmediaStatus:").append(this.mediaStatus);
        sb.append("\nnetSpped:").append(this.netSpped);
        sb.append("\ndropFrame:").append(this.dropFrame);
        sb.append("\nliveType:").append(this.liveType);
        sb.append("\nstreamUrl:").append(this.streamUrl);
        sb.append("\nfpsMin:").append(this.fpsMin);
        sb.append("\nfpsMax:").append(this.fpsMax);
        sb.append("\nfpsAvg:").append(this.fpsAvg);
        sb.append("\nfailureAudio:").append(this.failureAudio);
        sb.append("\nfailureVideo:").append(this.failureVideo);
        sb.append("\nconnectCount:").append(this.connectCount);
        sb.append("\nplayFail:").append(this.playFail);
        sb.append("\nlagNetworkNum:").append(this.lagNetworkNum);
        return sb.toString();
    }
}
