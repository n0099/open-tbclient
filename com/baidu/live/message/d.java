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
    private AlaLiveExceptionInfo aQm;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.aQm = alaLiveExceptionInfo;
        if (this.aQm != null) {
            addParam("appState", this.aQm.appState);
            addParam("connect", this.aQm.connect ? 1 : 0);
            addParam("dropFrame", this.aQm.dropFrame);
            addParam("live_id", this.aQm.liveID);
            addParam("lostRate", this.aQm.lostRate);
            addParam("ls", this.aQm.liveType);
            addParam("media_status", this.aQm.mediaStatus);
            addParam("net_speed", this.aQm.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.aQm.networkType);
            addParam("node_ip", this.aQm.nodeIP);
            addParam("phone", this.aQm.phone ? 1 : 0);
            addParam("session_line", this.aQm.sessionChannel);
            addParam("status", this.aQm.status);
            addParam("stream_url", this.aQm.streamUrl);
            addParam("video_level", this.aQm.videoLevel);
            addParam("fps_min", this.aQm.fpsMin);
            addParam("fps_max", this.aQm.fpsMax);
            addParam("fps_avg", this.aQm.fpsAvg);
            addParam("failure_audio", this.aQm.failureAudio);
            addParam("failure_video", this.aQm.failureVideo);
            addParam("play_fail", this.aQm.playFail);
            addParam("lag_network_num", this.aQm.lagNetworkNum);
            addParam("lag_sync_num", this.aQm.lagSyncNum);
            addParam("lag_n_min", this.aQm.lagnmin);
            addParam("lag_n_max", this.aQm.lagnmax);
            addParam("lag_n_total", this.aQm.lagntotal);
            addParam("lag_s_min", this.aQm.lagsmin);
            addParam("lag_s_max", this.aQm.lagsmax);
            addParam("lag_s_total", this.aQm.lagstotal);
            addParam("connect_count", this.aQm.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.aQm.eventType);
            addParam("first_open", this.aQm.firstOpenTime);
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
