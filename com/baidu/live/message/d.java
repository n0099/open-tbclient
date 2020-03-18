package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo awJ;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        this.awJ = alaLiveExceptionInfo;
        if (this.awJ != null) {
            addParam("appState", this.awJ.appState);
            addParam("connect", this.awJ.connect ? 1 : 0);
            addParam("dropFrame", this.awJ.dropFrame);
            addParam("live_id", this.awJ.liveID);
            addParam("lostRate", this.awJ.lostRate);
            addParam("ls", this.awJ.liveType);
            addParam("media_status", this.awJ.mediaStatus);
            addParam("net_speed", this.awJ.netSpped);
            addParam("network_type", this.awJ.networkType);
            addParam("node_ip", this.awJ.nodeIP);
            addParam("phone", this.awJ.phone ? 1 : 0);
            addParam("session_line", this.awJ.sessionChannel);
            addParam("status", this.awJ.status);
            addParam("stream_url", this.awJ.streamUrl);
            addParam("video_level", this.awJ.videoLevel);
            addParam("fps_min", this.awJ.fpsMin);
            addParam("fps_max", this.awJ.fpsMax);
            addParam("fps_avg", this.awJ.fpsAvg);
            addParam("failure_audio", this.awJ.failureAudio);
            addParam("failure_video", this.awJ.failureVideo);
            addParam("play_fail", this.awJ.playFail);
            addParam("lag_network_num", this.awJ.lagNetworkNum);
            addParam("lag_sync_num", this.awJ.lagSyncNum);
            addParam("lag_n_min", this.awJ.lagnmin);
            addParam("lag_n_max", this.awJ.lagnmax);
            addParam("lag_n_total", this.awJ.lagntotal);
            addParam("lag_s_min", this.awJ.lagsmin);
            addParam("lag_s_max", this.awJ.lagsmax);
            addParam("lag_s_total", this.awJ.lagstotal);
            addParam("connect_count", this.awJ.connectCount);
            addParam("event_type", this.awJ.eventType);
            addParam("first_open", this.awJ.firstOpenTime);
        }
    }
}
