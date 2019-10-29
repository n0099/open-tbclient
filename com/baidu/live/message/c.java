package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes6.dex */
public class c extends HttpMessage {
    private AlaLiveExceptionInfo ajU;

    public c() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.ajU = alaLiveExceptionInfo;
        if (this.ajU != null) {
            addParam("appState", this.ajU.appState);
            addParam("connect", this.ajU.connect ? 1 : 0);
            addParam("dropFrame", this.ajU.dropFrame);
            addParam("live_id", this.ajU.liveID);
            addParam("lostRate", this.ajU.lostRate);
            addParam("ls", this.ajU.liveType);
            addParam("media_status", this.ajU.mediaStatus);
            addParam("net_speed", this.ajU.netSpped);
            addParam("network_type", this.ajU.networkType);
            addParam("node_ip", this.ajU.nodeIP);
            addParam("phone", this.ajU.phone ? 1 : 0);
            addParam("session_line", this.ajU.sessionChannel);
            addParam("status", this.ajU.status);
            addParam("stream_url", this.ajU.streamUrl);
            addParam("video_level", this.ajU.videoLevel);
            addParam("fps_min", this.ajU.fpsMin);
            addParam("fps_max", this.ajU.fpsMax);
            addParam("fps_avg", this.ajU.fpsAvg);
            addParam("failure_audio", this.ajU.failureAudio);
            addParam("failure_video", this.ajU.failureVideo);
            addParam("play_fail", this.ajU.playFail);
            addParam("lag_network_num", this.ajU.lagNetworkNum);
            addParam("lag_sync_num", this.ajU.lagSyncNum);
            addParam("lag_n_min", this.ajU.lagnmin);
            addParam("lag_n_max", this.ajU.lagnmax);
            addParam("lag_n_total", this.ajU.lagntotal);
            addParam("lag_s_min", this.ajU.lagsmin);
            addParam("lag_s_max", this.ajU.lagsmax);
            addParam("lag_s_total", this.ajU.lagstotal);
            addParam("connect_count", this.ajU.connectCount);
            addParam("event_type", this.ajU.eventType);
            addParam("first_open", this.ajU.firstOpenTime);
        }
    }
}
