package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes6.dex */
public class c extends HttpMessage {
    private AlaLiveExceptionInfo ajC;

    public c() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.ajC = alaLiveExceptionInfo;
        if (this.ajC != null) {
            addParam("appState", this.ajC.appState);
            addParam("connect", this.ajC.connect ? 1 : 0);
            addParam("dropFrame", this.ajC.dropFrame);
            addParam("live_id", this.ajC.liveID);
            addParam("lostRate", this.ajC.lostRate);
            addParam("ls", this.ajC.liveType);
            addParam("media_status", this.ajC.mediaStatus);
            addParam("net_speed", this.ajC.netSpped);
            addParam("network_type", this.ajC.networkType);
            addParam("node_ip", this.ajC.nodeIP);
            addParam("phone", this.ajC.phone ? 1 : 0);
            addParam("session_line", this.ajC.sessionChannel);
            addParam("status", this.ajC.status);
            addParam("stream_url", this.ajC.streamUrl);
            addParam("video_level", this.ajC.videoLevel);
            addParam("fps_min", this.ajC.fpsMin);
            addParam("fps_max", this.ajC.fpsMax);
            addParam("fps_avg", this.ajC.fpsAvg);
            addParam("failure_audio", this.ajC.failureAudio);
            addParam("failure_video", this.ajC.failureVideo);
            addParam("play_fail", this.ajC.playFail);
            addParam("lag_network_num", this.ajC.lagNetworkNum);
            addParam("lag_sync_num", this.ajC.lagSyncNum);
            addParam("lag_n_min", this.ajC.lagnmin);
            addParam("lag_n_max", this.ajC.lagnmax);
            addParam("lag_n_total", this.ajC.lagntotal);
            addParam("lag_s_min", this.ajC.lagsmin);
            addParam("lag_s_max", this.ajC.lagsmax);
            addParam("lag_s_total", this.ajC.lagstotal);
            addParam("connect_count", this.ajC.connectCount);
            addParam("event_type", this.ajC.eventType);
            addParam("first_open", this.ajC.firstOpenTime);
        }
    }
}
