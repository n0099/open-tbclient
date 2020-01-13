package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes2.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo asn;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.asn = alaLiveExceptionInfo;
        if (this.asn != null) {
            addParam("appState", this.asn.appState);
            addParam("connect", this.asn.connect ? 1 : 0);
            addParam("dropFrame", this.asn.dropFrame);
            addParam("live_id", this.asn.liveID);
            addParam("lostRate", this.asn.lostRate);
            addParam("ls", this.asn.liveType);
            addParam("media_status", this.asn.mediaStatus);
            addParam("net_speed", this.asn.netSpped);
            addParam("network_type", this.asn.networkType);
            addParam("node_ip", this.asn.nodeIP);
            addParam("phone", this.asn.phone ? 1 : 0);
            addParam("session_line", this.asn.sessionChannel);
            addParam("status", this.asn.status);
            addParam("stream_url", this.asn.streamUrl);
            addParam("video_level", this.asn.videoLevel);
            addParam("fps_min", this.asn.fpsMin);
            addParam("fps_max", this.asn.fpsMax);
            addParam("fps_avg", this.asn.fpsAvg);
            addParam("failure_audio", this.asn.failureAudio);
            addParam("failure_video", this.asn.failureVideo);
            addParam("play_fail", this.asn.playFail);
            addParam("lag_network_num", this.asn.lagNetworkNum);
            addParam("lag_sync_num", this.asn.lagSyncNum);
            addParam("lag_n_min", this.asn.lagnmin);
            addParam("lag_n_max", this.asn.lagnmax);
            addParam("lag_n_total", this.asn.lagntotal);
            addParam("lag_s_min", this.asn.lagsmin);
            addParam("lag_s_max", this.asn.lagsmax);
            addParam("lag_s_total", this.asn.lagstotal);
            addParam("connect_count", this.asn.connectCount);
            addParam("event_type", this.asn.eventType);
            addParam("first_open", this.asn.firstOpenTime);
        }
    }
}
