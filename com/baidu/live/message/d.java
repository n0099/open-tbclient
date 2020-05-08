package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo aQs;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.aQs = alaLiveExceptionInfo;
        if (this.aQs != null) {
            addParam("appState", this.aQs.appState);
            addParam("connect", this.aQs.connect ? 1 : 0);
            addParam("dropFrame", this.aQs.dropFrame);
            addParam("live_id", this.aQs.liveID);
            addParam("lostRate", this.aQs.lostRate);
            addParam("ls", this.aQs.liveType);
            addParam("media_status", this.aQs.mediaStatus);
            addParam("net_speed", this.aQs.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.aQs.networkType);
            addParam("node_ip", this.aQs.nodeIP);
            addParam("phone", this.aQs.phone ? 1 : 0);
            addParam("session_line", this.aQs.sessionChannel);
            addParam("status", this.aQs.status);
            addParam("stream_url", this.aQs.streamUrl);
            addParam("video_level", this.aQs.videoLevel);
            addParam("fps_min", this.aQs.fpsMin);
            addParam("fps_max", this.aQs.fpsMax);
            addParam("fps_avg", this.aQs.fpsAvg);
            addParam("failure_audio", this.aQs.failureAudio);
            addParam("failure_video", this.aQs.failureVideo);
            addParam("play_fail", this.aQs.playFail);
            addParam("lag_network_num", this.aQs.lagNetworkNum);
            addParam("lag_sync_num", this.aQs.lagSyncNum);
            addParam("lag_n_min", this.aQs.lagnmin);
            addParam("lag_n_max", this.aQs.lagnmax);
            addParam("lag_n_total", this.aQs.lagntotal);
            addParam("lag_s_min", this.aQs.lagsmin);
            addParam("lag_s_max", this.aQs.lagsmax);
            addParam("lag_s_total", this.aQs.lagstotal);
            addParam("connect_count", this.aQs.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.aQs.eventType);
            addParam("first_open", this.aQs.firstOpenTime);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isTieba()) {
                addParam("im_sdk_version", BIMManager.getVersion());
                addParam("im_sdk_connet", LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined() + "");
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID), String.class);
                if (runTask == null || TextUtils.isEmpty((CharSequence) runTask.getData())) {
                    j = 0;
                } else {
                    try {
                        j = Long.parseLong((String) runTask.getData());
                    } catch (NumberFormatException e) {
                        j = 0;
                    }
                }
                addParam("im_join_castid", j + "");
            }
        }
    }
}
