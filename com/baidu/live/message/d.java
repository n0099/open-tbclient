package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
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
    private AlaLiveExceptionInfo aWB;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.aWB = alaLiveExceptionInfo;
        if (this.aWB != null) {
            addParam("appState", this.aWB.appState);
            addParam("connect", this.aWB.connect ? 1 : 0);
            addParam("dropFrame", this.aWB.dropFrame);
            addParam("live_id", this.aWB.liveID);
            addParam("lostRate", this.aWB.lostRate);
            addParam("ls", this.aWB.liveType);
            addParam("media_status", this.aWB.mediaStatus);
            addParam("net_speed", this.aWB.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.aWB.networkType);
            addParam("node_ip", this.aWB.nodeIP);
            addParam("phone", this.aWB.phone ? 1 : 0);
            addParam("session_line", this.aWB.sessionChannel);
            addParam("status", this.aWB.status);
            addParam("stream_url", this.aWB.streamUrl);
            addParam("video_level", this.aWB.videoLevel);
            addParam("fps_min", this.aWB.fpsMin);
            addParam("fps_max", this.aWB.fpsMax);
            addParam("fps_avg", this.aWB.fpsAvg);
            addParam("failure_audio", this.aWB.failureAudio);
            addParam("failure_video", this.aWB.failureVideo);
            addParam("play_fail", this.aWB.playFail);
            addParam("lag_network_num", this.aWB.lagNetworkNum);
            addParam("lag_sync_num", this.aWB.lagSyncNum);
            addParam("lag_n_min", this.aWB.lagnmin);
            addParam("lag_n_max", this.aWB.lagnmax);
            addParam("lag_n_total", this.aWB.lagntotal);
            addParam("lag_s_min", this.aWB.lagsmin);
            addParam("lag_s_max", this.aWB.lagsmax);
            addParam("lag_s_total", this.aWB.lagstotal);
            addParam("connect_count", this.aWB.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.aWB.eventType);
            addParam("first_open", this.aWB.firstOpenTime);
            addParam("im_sdk_version", BIMManager.getVersion());
            addParam("im_sdk_connet", LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined() + "");
            if (IMConfigInternal.getInstance().getSDKVersionValue(TbadkCoreApplication.getInst().getContext()) >= 5850036) {
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
                addParam("im_latest_gift_msgid", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getMaxReliableMsgId(j) + "");
                addParam("im_gift_msg_num", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getReliableMsgCount(j) + "");
            }
            try {
                addParam("im_join_castid", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getAllCastIdList() + "");
            } catch (Throwable th) {
                addParam("im_join_castid", "0");
            }
        }
    }
}
