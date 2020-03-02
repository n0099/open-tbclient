package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo awy;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.awy = alaLiveExceptionInfo;
        if (this.awy != null) {
            addParam("appState", this.awy.appState);
            addParam("connect", this.awy.connect ? 1 : 0);
            addParam("dropFrame", this.awy.dropFrame);
            addParam("live_id", this.awy.liveID);
            addParam("lostRate", this.awy.lostRate);
            addParam("ls", this.awy.liveType);
            addParam("media_status", this.awy.mediaStatus);
            addParam("net_speed", this.awy.netSpped);
            addParam("network_type", this.awy.networkType);
            addParam("node_ip", this.awy.nodeIP);
            addParam("phone", this.awy.phone ? 1 : 0);
            addParam("session_line", this.awy.sessionChannel);
            addParam("status", this.awy.status);
            addParam("stream_url", this.awy.streamUrl);
            addParam("video_level", this.awy.videoLevel);
            addParam("fps_min", this.awy.fpsMin);
            addParam("fps_max", this.awy.fpsMax);
            addParam("fps_avg", this.awy.fpsAvg);
            addParam("failure_audio", this.awy.failureAudio);
            addParam("failure_video", this.awy.failureVideo);
            addParam("play_fail", this.awy.playFail);
            addParam("lag_network_num", this.awy.lagNetworkNum);
            addParam("lag_sync_num", this.awy.lagSyncNum);
            addParam("lag_n_min", this.awy.lagnmin);
            addParam("lag_n_max", this.awy.lagnmax);
            addParam("lag_n_total", this.awy.lagntotal);
            addParam("lag_s_min", this.awy.lagsmin);
            addParam("lag_s_max", this.awy.lagsmax);
            addParam("lag_s_total", this.awy.lagstotal);
            addParam("connect_count", this.awy.connectCount);
            addParam("event_type", this.awy.eventType);
            addParam("first_open", this.awy.firstOpenTime);
        }
    }
}
