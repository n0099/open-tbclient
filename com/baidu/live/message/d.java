package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo awz;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.awz = alaLiveExceptionInfo;
        if (this.awz != null) {
            addParam("appState", this.awz.appState);
            addParam("connect", this.awz.connect ? 1 : 0);
            addParam("dropFrame", this.awz.dropFrame);
            addParam("live_id", this.awz.liveID);
            addParam("lostRate", this.awz.lostRate);
            addParam("ls", this.awz.liveType);
            addParam("media_status", this.awz.mediaStatus);
            addParam("net_speed", this.awz.netSpped);
            addParam("network_type", this.awz.networkType);
            addParam("node_ip", this.awz.nodeIP);
            addParam("phone", this.awz.phone ? 1 : 0);
            addParam("session_line", this.awz.sessionChannel);
            addParam("status", this.awz.status);
            addParam("stream_url", this.awz.streamUrl);
            addParam("video_level", this.awz.videoLevel);
            addParam("fps_min", this.awz.fpsMin);
            addParam("fps_max", this.awz.fpsMax);
            addParam("fps_avg", this.awz.fpsAvg);
            addParam("failure_audio", this.awz.failureAudio);
            addParam("failure_video", this.awz.failureVideo);
            addParam("play_fail", this.awz.playFail);
            addParam("lag_network_num", this.awz.lagNetworkNum);
            addParam("lag_sync_num", this.awz.lagSyncNum);
            addParam("lag_n_min", this.awz.lagnmin);
            addParam("lag_n_max", this.awz.lagnmax);
            addParam("lag_n_total", this.awz.lagntotal);
            addParam("lag_s_min", this.awz.lagsmin);
            addParam("lag_s_max", this.awz.lagsmax);
            addParam("lag_s_total", this.awz.lagstotal);
            addParam("connect_count", this.awz.connectCount);
            addParam("event_type", this.awz.eventType);
            addParam("first_open", this.awz.firstOpenTime);
        }
    }
}
