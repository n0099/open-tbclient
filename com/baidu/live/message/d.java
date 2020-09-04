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
    private AlaLiveExceptionInfo beE;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.beE = alaLiveExceptionInfo;
        if (this.beE != null) {
            addParam("appState", this.beE.appState);
            addParam("connect", this.beE.connect ? 1 : 0);
            addParam("dropFrame", this.beE.dropFrame);
            addParam("live_id", this.beE.liveID);
            addParam("lostRate", this.beE.lostRate);
            addParam("ls", this.beE.liveType);
            addParam("media_status", this.beE.mediaStatus);
            addParam("net_speed", this.beE.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.beE.networkType);
            addParam("node_ip", this.beE.nodeIP);
            addParam("phone", this.beE.phone ? 1 : 0);
            addParam("session_line", this.beE.sessionChannel);
            addParam("status", this.beE.status);
            addParam("stream_url", this.beE.streamUrl);
            addParam("video_level", this.beE.videoLevel);
            addParam("fps_min", this.beE.fpsMin);
            addParam("fps_max", this.beE.fpsMax);
            addParam("fps_avg", this.beE.fpsAvg);
            addParam("failure_audio", this.beE.failureAudio);
            addParam("failure_video", this.beE.failureVideo);
            addParam("play_fail", this.beE.playFail);
            addParam("lag_network_num", this.beE.lagNetworkNum);
            addParam("lag_sync_num", this.beE.lagSyncNum);
            addParam("lag_n_min", this.beE.lagnmin);
            addParam("lag_n_max", this.beE.lagnmax);
            addParam("lag_n_total", this.beE.lagntotal);
            addParam("lag_s_min", this.beE.lagsmin);
            addParam("lag_s_max", this.beE.lagsmax);
            addParam("lag_s_total", this.beE.lagstotal);
            addParam("connect_count", this.beE.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.beE.eventType);
            addParam("first_open", this.beE.firstOpenTime);
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
