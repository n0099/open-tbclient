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
/* loaded from: classes7.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo beC;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.beC = alaLiveExceptionInfo;
        if (this.beC != null) {
            addParam("appState", this.beC.appState);
            addParam("connect", this.beC.connect ? 1 : 0);
            addParam("dropFrame", this.beC.dropFrame);
            addParam("live_id", this.beC.liveID);
            addParam("lostRate", this.beC.lostRate);
            addParam("ls", this.beC.liveType);
            addParam("media_status", this.beC.mediaStatus);
            addParam("net_speed", this.beC.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.beC.networkType);
            addParam("node_ip", this.beC.nodeIP);
            addParam("phone", this.beC.phone ? 1 : 0);
            addParam("session_line", this.beC.sessionChannel);
            addParam("status", this.beC.status);
            addParam("stream_url", this.beC.streamUrl);
            addParam("video_level", this.beC.videoLevel);
            addParam("fps_min", this.beC.fpsMin);
            addParam("fps_max", this.beC.fpsMax);
            addParam("fps_avg", this.beC.fpsAvg);
            addParam("failure_audio", this.beC.failureAudio);
            addParam("failure_video", this.beC.failureVideo);
            addParam("play_fail", this.beC.playFail);
            addParam("lag_network_num", this.beC.lagNetworkNum);
            addParam("lag_sync_num", this.beC.lagSyncNum);
            addParam("lag_n_min", this.beC.lagnmin);
            addParam("lag_n_max", this.beC.lagnmax);
            addParam("lag_n_total", this.beC.lagntotal);
            addParam("lag_s_min", this.beC.lagsmin);
            addParam("lag_s_max", this.beC.lagsmax);
            addParam("lag_s_total", this.beC.lagstotal);
            addParam("connect_count", this.beC.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.beC.eventType);
            addParam("first_open", this.beC.firstOpenTime);
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
