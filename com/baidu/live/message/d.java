package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes2.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo arB;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.arB = alaLiveExceptionInfo;
        if (this.arB != null) {
            addParam("appState", this.arB.appState);
            addParam("connect", this.arB.connect ? 1 : 0);
            addParam("dropFrame", this.arB.dropFrame);
            addParam("live_id", this.arB.liveID);
            addParam("lostRate", this.arB.lostRate);
            addParam("ls", this.arB.liveType);
            addParam("media_status", this.arB.mediaStatus);
            addParam("net_speed", this.arB.netSpped);
            addParam("network_type", this.arB.networkType);
            addParam("node_ip", this.arB.nodeIP);
            addParam("phone", this.arB.phone ? 1 : 0);
            addParam("session_line", this.arB.sessionChannel);
            addParam("status", this.arB.status);
            addParam("stream_url", this.arB.streamUrl);
            addParam("video_level", this.arB.videoLevel);
            addParam("fps_min", this.arB.fpsMin);
            addParam("fps_max", this.arB.fpsMax);
            addParam("fps_avg", this.arB.fpsAvg);
            addParam("failure_audio", this.arB.failureAudio);
            addParam("failure_video", this.arB.failureVideo);
            addParam("play_fail", this.arB.playFail);
            addParam("lag_network_num", this.arB.lagNetworkNum);
            addParam("lag_sync_num", this.arB.lagSyncNum);
            addParam("lag_n_min", this.arB.lagnmin);
            addParam("lag_n_max", this.arB.lagnmax);
            addParam("lag_n_total", this.arB.lagntotal);
            addParam("lag_s_min", this.arB.lagsmin);
            addParam("lag_s_max", this.arB.lagsmax);
            addParam("lag_s_total", this.arB.lagstotal);
            addParam("connect_count", this.arB.connectCount);
            addParam("event_type", this.arB.eventType);
            addParam("first_open", this.arB.firstOpenTime);
        }
    }
}
