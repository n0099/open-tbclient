package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo awx;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.awx = alaLiveExceptionInfo;
        if (this.awx != null) {
            addParam("appState", this.awx.appState);
            addParam("connect", this.awx.connect ? 1 : 0);
            addParam("dropFrame", this.awx.dropFrame);
            addParam("live_id", this.awx.liveID);
            addParam("lostRate", this.awx.lostRate);
            addParam("ls", this.awx.liveType);
            addParam("media_status", this.awx.mediaStatus);
            addParam("net_speed", this.awx.netSpped);
            addParam("network_type", this.awx.networkType);
            addParam("node_ip", this.awx.nodeIP);
            addParam("phone", this.awx.phone ? 1 : 0);
            addParam("session_line", this.awx.sessionChannel);
            addParam("status", this.awx.status);
            addParam("stream_url", this.awx.streamUrl);
            addParam("video_level", this.awx.videoLevel);
            addParam("fps_min", this.awx.fpsMin);
            addParam("fps_max", this.awx.fpsMax);
            addParam("fps_avg", this.awx.fpsAvg);
            addParam("failure_audio", this.awx.failureAudio);
            addParam("failure_video", this.awx.failureVideo);
            addParam("play_fail", this.awx.playFail);
            addParam("lag_network_num", this.awx.lagNetworkNum);
            addParam("lag_sync_num", this.awx.lagSyncNum);
            addParam("lag_n_min", this.awx.lagnmin);
            addParam("lag_n_max", this.awx.lagnmax);
            addParam("lag_n_total", this.awx.lagntotal);
            addParam("lag_s_min", this.awx.lagsmin);
            addParam("lag_s_max", this.awx.lagsmax);
            addParam("lag_s_total", this.awx.lagstotal);
            addParam("connect_count", this.awx.connectCount);
            addParam("event_type", this.awx.eventType);
            addParam("first_open", this.awx.firstOpenTime);
        }
    }
}
